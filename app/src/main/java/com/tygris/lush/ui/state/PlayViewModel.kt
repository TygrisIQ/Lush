package com.tygris.lush.ui.state

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tygris.lush.domain.model.TrackMinimal
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


@HiltViewModel
class PlayViewModel @Inject constructor(private val playerClient: PlayerClient)
    : ViewModel(){
        private var trackSelected : TrackMinimal? = null
        val currentTrack = playerClient.nowPlaying.value
        val state : LiveData<PlayerState> = liveData {


            fun updateSelectedSong(route: Uri) {
            viewModelScope.launch{
              trackSelected = playerClient.returnTrack(route = route.toString())
           }
            }
            val currentState = playerClient.nowPlaying.filter {
                it == null
            }.map {
                playing ->
                playing.let {
                   it?.containsKey("id")
                }
            }
        }

}


data class PlayerState(
    val isPlaying: Boolean,
    val loadedTrack : Track?,
    val availableActions: Set<LushActions>
){
    data class Track(
        val id: String,
        val title: String,
        val artist: String,
        val duration: Long,
        val artworkUri: Uri?
    )

    enum class LushActions{
        Pause,
        Play
    }

}