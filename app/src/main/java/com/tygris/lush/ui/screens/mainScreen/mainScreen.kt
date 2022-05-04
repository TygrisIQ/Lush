package com.tygris.lush.ui.screens.mainScreen

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tygris.lush.domain.model.Track
import com.tygris.lush.ui.screens.mainScreen.elements.TrackCard
import com.tygris.lush.ui.screens.shared.LushTopBar
import com.tygris.lush.ui.state.TrackListViewModel
import com.tygris.lush.R
import com.tygris.lush.ui.state.PlayViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreenScaffold(trackListViewModel: TrackListViewModel,
                       playViewModel: PlayViewModel){
    val context = LocalContext.current
    val sheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState =
    BottomSheetState(BottomSheetValue.Collapsed))
    BottomSheetScaffold(topBar = { LushTopBar(context = context) },
    sheetContent = {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Text(text = "HELLO")
        }
        Column() {
            AsyncImage(R.drawable.ic_launcher_background,null)
        }
    }, scaffoldState = sheetScaffoldState, sheetPeekHeight = 115.dp,
        sheetGesturesEnabled = true
    ){
        MainScreenMusicList(trackListViewModel.musicList){
            playViewModel.currentTrack
        }

    }
}

@Composable
fun MainScreenMusicList(musicList: List<Track>, giveRoute: (Uri)-> Unit){
                LazyColumn(modifier = Modifier.fillMaxHeight()){
                item {
                    musicList.forEach {
                    track ->
                            TrackCard(
                                title = track.track_title,
                                Artist = track.track_artist,
                                route = track.track_uri,
                                album = track.track_album,
                                isSelected = false,
                                giveRoute = giveRoute
                            )
                        } }


    } }
