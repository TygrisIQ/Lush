package com.tygris.lush.ui.util

import android.content.Context
import android.util.Log
import com.tygris.lush.domain.model.Track
import com.tygris.lush.tools.filesystem.GetAudioFiles
import java.io.File
//
//fun TrackListProvide() : List<Track>{
//    val listy = mutableListOf<Track>()
//    var tracky = Track(info_format = "mp3"
//        , track_length = 3.23f
//        , track_artist = "TYGRIS",
//        track_album = "FAKE SMILE", track_title = "1",
//        album_art = )
//    for (i in 1..50){
//        val t = tracky.copy(track_title = i.toString())
//        listy.add(tracky)
//    }
//    return listy
//}
//
//fun ReturnAudioFileList(context: Context) : MutableList<Track>{
//    val getAudioFiles = GetAudioFiles()
//    val listy : MutableList<Track> = getAudioFiles.getMusicList(context)
//    Log.d("TAGGY", "${listy.forEach {it.track_title}}}")
//    return listy
//}