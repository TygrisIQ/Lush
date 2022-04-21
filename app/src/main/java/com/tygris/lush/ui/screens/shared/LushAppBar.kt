package com.tygris.lush.ui.screens.shared

import android.content.Context
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.tygris.lush.R
import com.tygris.lush.ui.theme.rubik

@Composable
fun LushTopbar(
    context: Context
){
    TopAppBar(
        title = { Text(text = context.getString(R.string.app_name),
        style = MaterialTheme.typography.body1,
        fontFamily = rubik,
        fontWeight = FontWeight.Bold) },
    )
}

@Composable
@Preview(showBackground = true)
fun LushTopBarPreview(){

}