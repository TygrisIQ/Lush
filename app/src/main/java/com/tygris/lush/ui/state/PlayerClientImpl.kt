package com.tygris.lush.ui.state

import android.content.ComponentName
import android.content.Context
import android.graphics.BitmapFactory
import android.media.MediaMetadata
import android.media.MediaMetadataRetriever
import android.media.browse.MediaBrowser
import android.media.session.MediaController
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.net.toUri
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.tygris.lush.domain.model.TrackMinimal
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PlayerClientImpl @Inject constructor(
    @ApplicationContext applicationContext: Context): PlayerClient,
        DefaultLifecycleObserver{
    @Volatile private var deferredController = CompletableDeferred<MediaController>()
    private val _nowPlaying = MutableStateFlow<MediaMetadata?>(null)
    private val connectionCallBack = MediaBrowser.ConnectionCallback()
    private val mediaBrowser = MediaBrowser(
        applicationContext,
        ComponentName(applicationContext, ""),
        connectionCallBack,
        null
    )

    override suspend fun returnTrack(route: String): TrackMinimal {
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(route)
        val length = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION) ?: ""
        val album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)
        val artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)
        val title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE) ?: ""
        val image = mmr.embeddedPicture
        val arttoImageBitmap = BitmapFactory
            .decodeByteArray(image,0, image?.size ?: 2)
            .asImageBitmap()
        return TrackMinimal(
            track_title = title,
            track_length =  length,
            track_album = album,
            track_artist = artist,
            track_image = arttoImageBitmap,
            track_uri = route.toUri()
            )
    }

    override val nowPlaying: StateFlow<MediaMetadata?> = _nowPlaying


    override suspend fun getItem(itemId: Long): MediaBrowser.MediaItem? {
        TODO("Not yet implemented")
    }

    override suspend fun search(query: String): List<MediaBrowser.MediaItem> {
        TODO("Not yet implemented")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        mediaBrowser.connect()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        mediaBrowser.disconnect()
    }
}

