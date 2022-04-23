package com.tygris.lush

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory

class LushApp : Application(), ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .crossfade(true)
            .build()
    }
}