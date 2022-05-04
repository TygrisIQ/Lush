package com.tygris.lush.ui.state

import android.media.MediaMetadata
import android.media.browse.MediaBrowser
import com.tygris.lush.domain.model.Track
import com.tygris.lush.domain.model.TrackMinimal
import kotlinx.coroutines.flow.StateFlow

interface PlayerClient {

    val nowPlaying: StateFlow<MediaMetadata?>

    suspend fun getItem(itemId: Long): MediaBrowser.MediaItem?

    suspend fun search(query: String): List<MediaBrowser.MediaItem>

    suspend fun returnTrack(route: String): TrackMinimal


}