package com.tygris.lush.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlayingTrackCard(
    isplaying:(Boolean) -> Unit,

){

}

@Preview(showBackground = true)
@Composable
fun TrackPlayingPreview(){
    PlayingTrackCard({})
}