package com.tygris.lush.ui.screens.util_screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tygris.lush.ui.screens.shared.LushTopBar
import com.tygris.lush.R
import com.tygris.lush.ui.theme.rubik

@Composable
fun PermissionNotGranted(text: String?, giveRequest: ()->Unit){
    val context = LocalContext.current
    Scaffold(topBar = { LushTopBar(context = context)  }) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement =
        Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            text?.let { it1 ->
                Text(
                    text = it1,
                    fontFamily = rubik,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = context.getString(R.string.permission_not_granted),
                fontFamily = rubik,
                fontWeight = FontWeight.Bold
            )
            Divider(modifier =
            Modifier.padding(top = 9.dp,
                bottom = 9.dp).width(80.dp))

            Button(onClick = giveRequest) {
                Text(text = context.getString(R.string.GIVE_PERMISSION),
                    fontFamily = rubik, fontWeight = FontWeight.Light)
            }

    }
}
}