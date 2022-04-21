package com.tygris.lush.ui.screens.mainScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.tygris.lush.domain.model.Track
import com.tygris.lush.ui.screens.mainScreen.elements.TrackCard
import com.tygris.lush.ui.screens.shared.LushTopbar
import com.tygris.lush.ui.util.ReturnAudioFileList
import com.tygris.lush.ui.util.TrackListProvide

@Composable
fun MainScreenScaffold(){
    val context = LocalContext.current
    Scaffold(topBar = { LushTopbar(context = context)}) {
        MainScreen()
    }
}

@Composable
fun MainScreen(){
    val context = LocalContext.current
    LazyColumn{
        item {
            ReturnAudioFileList(context).forEach {
                TrackCard(title = it.track_title,
                    Artist = "Tygris"
                    , album = "The Chronic", length = 30f, isSelected = false)
            }

        }
    }
    }
//TrackListProvide().forEach {
//    TrackCard(isSelected = false, title = it.track_title,
//        album = it.track_album, Artist = it.track_artist,
//        length = it.track_length)
//}
