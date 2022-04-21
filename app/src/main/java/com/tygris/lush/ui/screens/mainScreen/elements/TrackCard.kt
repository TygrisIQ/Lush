package com.tygris.lush.ui.screens.mainScreen.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tygris.lush.ui.theme.LushTheme


@Composable
fun TrackCard(title: String?, Artist: String?,
              album : String?,
              length : Float,
              isSelected: Boolean){

        Card(backgroundColor = Color.Transparent,
            border = BorderStroke(0.2.dp,Color.Transparent)
        ) {
            Column(modifier = Modifier.fillMaxWidth().
            padding(start = 3.dp)) {
               Row() {
                   title?.let {
                       Text(text = it,
                           Modifier.fillMaxWidth(0.75f),
                           overflow = TextOverflow.Ellipsis,
                           fontSize = 15.sp)
                   }
               }
                Row(Modifier.fillMaxWidth(0.75f)) {
                    Artist?.let {
                        Text(text = it,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 9.sp)
                    }

                    Text(text = "-",
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 9.sp,
                        modifier =
                            Modifier.padding(start= 1.dp, end = 1.dp))

                    album?.let {
                        Text(text = it,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            fontSize = 9.sp)
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