package com.tygris.lush.ui.state

import android.content.ContentUris
import android.content.Context
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tygris.lush.R
import com.tygris.lush.domain.model.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import java.util.*

class TrackListViewModel : ViewModel() {
    val musicList = mutableListOf<Track>()
    private var initialized = false
    private val backgroundScope = viewModelScope.plus(Dispatchers.Default)
    private var albumArt : ImageBitmap? = null

    fun getTrack(track_id: Long,context: Context){
        backgroundScope.launch {

        }
    }
    fun getMusicList(context: Context){
        if(initialized) return
        backgroundScope.launch {
               val collection =
                   if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                       MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
                   }
                   else{
                       MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                   }
               val projection = arrayOf(
                   MediaStore.Audio.Media._ID,
                   MediaStore.Audio.Media.DISPLAY_NAME,
                   MediaStore.Audio.Media.DURATION,
                   MediaStore.Audio.Media.TITLE,
                   MediaStore.Audio.Media.ALBUM_ID,
                   MediaStore.Audio.Media.ARTIST,
                   MediaStore.Audio.Media.MIME_TYPE)
               val selection = MediaStore.Audio.Media.IS_MUSIC +" !=0"
               val sortOrder = MediaStore.Audio.Media.DISPLAY_NAME
               val query = context.contentResolver.query(
                   collection,
                   projection,
                   selection,
                   null,
                   sortOrder

               )
               query?.use { cursor ->
                   val idColumn =
                       cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
                   val nameColumn =
                       cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)
                   val durationColumn =
                       cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
                   val mimeColumn =
                       cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE)
                   val albumColumn =
                       cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)
                   val artistColumn =
                       cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
                   while (cursor.moveToNext()){
                       val id = cursor.getLong(idColumn)
                       val name = cursor.getString(nameColumn)
                       val duration = cursor.getInt(durationColumn)
                       val format = cursor.getString(mimeColumn)
                       val album_id = cursor.getString(albumColumn)
                       val artist = cursor.getString(artistColumn)
                       val contentUri: Uri = ContentUris.withAppendedId(
                           MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                           id
                       )
                       musicList += Track(
                           uuid= UUID.randomUUID(),
                           track_id = id,
                           track_artist = artist,
                           track_title = name,
                           track_length = duration.toString(),
                           track_album = album_id,
                           track_uri = contentUri,
                           track_image = null)
                   } }
               initialized = true } }


    private fun initializeDefaultAlbumArt(context: Context){
       backgroundScope.launch {
           albumArt = BitmapFactory.decodeResource(context.resources,
               R.drawable.musical_note).asImageBitmap()
       }
    }
    private fun getAlbumArt(context: Context, uri: Uri) {
        if(albumArt == null) initializeDefaultAlbumArt(context)
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(context, uri)
        val data = mmr.embeddedPicture
        if(data != null){
        albumArt =  BitmapFactory.decodeByteArray(data, 0, data.size)
            .asImageBitmap()
        }else{
            albumArt
        }
    }
    }

