package com.tygris.lush.domain.model

import android.net.Uri
import androidx.compose.ui.graphics.ImageBitmap
import java.util.*

data class Track(
    val uuid : UUID = UUID.randomUUID(),
    val track_id : Long,
    val track_title : String,
    val track_length : String,
    val track_album : String?,
    val track_artist : String?,
    val track_uri : Uri,
    val track_image : ImageBitmap?
    )

data class TrackMinimal(
    val track_title : String,
    val track_length : String,
    val track_album : String?,
    val track_artist : String?,
    val track_uri : Uri,
    val track_image : ImageBitmap?
)

