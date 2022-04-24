package com.tygris.lush.ui.screens.mainScreen

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import com.tygris.lush.R
import com.tygris.lush.domain.model.Track
import com.tygris.lush.ui.screens.mainScreen.elements.TrackCard
import com.tygris.lush.ui.screens.shared.LushTopbar
import com.tygris.lush.ui.state.TrackListViewModel

@Composable
fun MainScreenScaffold(viewModel: TrackListViewModel){
    val context = LocalContext.current
    val composableScope = rememberCoroutineScope()
    Scaffold(topBar = { LushTopbar(context = context)}) {
        MainScreen(viewModel.musicList)
    }
}

@Composable
fun MainScreen(musiclist: List<Track>){
                LazyColumn(modifier = Modifier.fillMaxHeight(0.90f)){
                item {
                    musiclist.forEach {
                    track ->
                        TrackCard(
                            title = track.track_title,
                            Artist = track.track_artist,
                            album = track.track_album,
                            length = track.track_length,
                            isSelected = false,
                            )
                    }
                    Card(modifier = Modifier.fillMaxHeight(0.10f)) {

                    }
            }
    } }
//TrackListProvide().forEach {
//    TrackCard(isSelected = false, title = it.track_title,
//        album = it.track_album, Artist = it.track_artist,
//        length = it.track_length)
//}
