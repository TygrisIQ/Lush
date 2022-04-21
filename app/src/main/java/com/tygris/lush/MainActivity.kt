package com.tygris.lush

import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.tygris.lush.ui.navigation.AppNavigation
import com.tygris.lush.ui.screens.util_screens.PermissionNotGranted
import com.tygris.lush.ui.theme.LushTheme


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            LushTheme {
                //A surface container using the 'background' color from the theme
                val storagePermissionState = rememberPermissionState(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)
                when(storagePermissionState.status){
                  PermissionStatus.Granted->{
                        Log.d("TAGGY","READ EXTERNAL STORAGE IS GRANTED!")
                      Surface(
                          modifier = Modifier.fillMaxSize(),
                          color = MaterialTheme.colors.background
                      ) {
                          AppNavigation()
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

