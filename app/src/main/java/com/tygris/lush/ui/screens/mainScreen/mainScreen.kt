package com.tygris.lush.ui.screens.mainScreen

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import com.tygris.lush.domain.model.Track
import com.tygris.lush.ui.screens.mainScreen.elements.TrackCard
import com.tygris.lush.ui.screens.shared.LushTopbar
import com.tygris.lush.ui.state.TrackListViewModel
import com.tygris.lush.R

@Composable
fun MainScreenScaffold(viewModel: TrackListViewModel){
    val context = LocalContext.current
    val defalbumArt = remember{BitmapFactory.decodeResource(context.resources,
        R.drawable.musical_note).asImageBitmap()}
    Scaffold(topBar = { LushTopbar(context = context)}) {
        MainScreen(viewModel.musicList)
    }
}

@Composable
fun MainScreen(musiclist: List<Track>){
    LazyColumn{
        item {

            musiclist.forEach {
                it
                it.track_bitmap?.let { it1 ->
                    TrackCard(title = it.track_title,
                        Artist = it.track_artist, album = it.track_album,
                        length = it.track_length,
                        isSelected = false,
                        albumArt = it1
                    )
                }
                }
            }

        }
    }

//TrackListProvide().forEach {
//    TrackCard(isSelected = false, title = it.track_title,
//        album = it.track_album, Artist = it.track_artist,
//        length = it.track_length)
//}
