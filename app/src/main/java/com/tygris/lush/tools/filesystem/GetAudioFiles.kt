package com.tygris.lush.tools.filesystem

import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import com.tygris.lush.domain.model.Track
import java.io.File
import java.util.*


class GetAudioFiles {

    fun getMusicList(context: Context): MutableList<Track>{
        val trackList = mutableListOf<Track>()
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
        val selection = MediaStore.Audio.Media.IS_MUSIC +"!= 0"
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
            while (cursor.moveToNext()){
                val id = cursor.getLong(idColumn)
                val name = cursor.getString(nameColumn)
                val duration = cursor.getInt(durationColumn)
                val format = cursor.getString(mimeColumn)

                val contentUri: Uri = ContentUris.withAppendedId(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    id
                )

                trackList += Track(
                    UUID.randomUUID(),
                    id,
                    name,
                    duration.toFloat(),
                    null,
                    null,
                     format)
            }
        }

    return trackList
    }
}