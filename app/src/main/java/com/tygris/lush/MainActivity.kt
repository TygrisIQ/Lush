package com.tygris.lush

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.tygris.lush.ui.navigation.AppNavigation
import com.tygris.lush.ui.screens.util_screens.PermissionNotGranted
import com.tygris.lush.ui.state.PlayViewModel
import com.tygris.lush.ui.state.TrackListViewModel
import com.tygris.lush.ui.theme.LushTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val trackListViewModel : TrackListViewModel by viewModels()
    private val playingviewmodel : PlayViewModel by viewModels()


    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LushTheme {
                val storagePermissionState = rememberPermissionState(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)
                when(storagePermissionState.status){
                  PermissionStatus.Granted->{
                      Surface(
                          modifier = Modifier.fillMaxSize(),
                          color = MaterialTheme.colors.background
                      ) {

                          trackListViewModel.getMusicList(this)
                          AppNavigation(trackListViewModel, playingviewmodel)
                      }
                  }else -> {
                      Surface(
                          modifier = Modifier.fillMaxSize(),
                          color = MaterialTheme.colors.background
                      ){
                          PermissionNotGranted(text = getString(R.string.reading_external_storage)
                          ) { storagePermissionState.launchPermissionRequest() }
                      }
                  }
                    

                }

            }
        }
    }
}

