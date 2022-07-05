package com.tygris.lush.ui.state


import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.tygris.lush.domain.model.TrackMinimal
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PlayViewModel @Inject constructor(

) : ViewModel(){
        private val player : ExoPlayer? = null

        fun setPlayer(){
            player =
        }

        fun updateSelectedSong(uri: Uri, context: Context){
            player?.stop()
            player?.clearMediaItems()
            val mediaItem = MediaItem.fromUri(uri)
            val player = ExoPlayer.Builder(context).build()
            player.setMediaItem(mediaItem)
            playAudio()
        }
        private fun playAudio(){
            player?.stop()
            player?.prepare()
            player?.play()

        }

}
data class PlayerState(
    var playingTrack : Uri,
    val isPlaying: Boolean,
    val loadedTrack : TrackMinimal?,
    val availableActions: LushActions
){

    enum class LushActions{
        Pause,
        Play
    }

}