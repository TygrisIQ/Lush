package com.tygris.lush.domain.model

import java.util.*

data class Track(
    val uuid : UUID = UUID.randomUUID(),
    val track_id : Long = 233223,
    val track_title : String?,
    val track_length : Float,
    val track_album : String?,
    val track_artist : String?,
    val info_format : String
)