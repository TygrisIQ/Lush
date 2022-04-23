package com.tygris.lush.ui.screens.mainScreen.elements

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.tygris.lush.ui.theme.LushTheme
import com.tygris.lush.ui.theme.rubik


@Composable
fun TrackCard(title: String?,
              Artist: String?,
              album : String?,
              length : Float,
              isSelected: Boolean,
              albumArt : Bitmap){

        Card(backgroundColor = Color.Transparent,
            border = BorderStroke(2.dp,Color.Transparent),
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),

        ) {
            //Album Art Row
            Row(modifier = Modifier.fillMaxWidth(0.20f)) {
                AsyncImage(albumArt, contentDescription =null,
                )
            }
            Row() {
                Column(modifier =Modifier.padding(start = 3.dp,
                    top = 2.dp, bottom = 2.dp)){
                    Row(horizontalArrangement = Arrangement.Start) {
                        title?.let {
                            Text(
                                text = it, fontSize = 19.sp,
                                maxLines = 1, overflow = TextOverflow.Ellipsis,
                                fontFamily = rubik, fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Row(horizontalArrangement = Arrangement.Start) {
                        Artist?.let {
                            Text(
                                text = it, fontSize = 9.sp, fontWeight = FontWeight.SemiBold,
                                fontFamily = rubik, maxLines = 1, overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.fillMaxWidth(0.25f)
                            )
                        }
                    }

                }
            }
        }

}

//@Preview(showBackground = true)
//@Composable
//fun TrackCardPreview(){
//    TrackCard(false)
//}
//@Preview(showBackground = true)
//@Composable
//fun TrackCardPreviewDark(){
//    LushTheme(darkTheme = false) {
//        TrackCard(false)
//    }
//}
////////////////////////////////////
//Cleaning out my closet/////////://
//Eminem - The Eminem Show///////://
///////////////////////////////////