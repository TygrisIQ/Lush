package com.tygris.lush.ui.screens.shared

import android.content.Context
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.tygris.lush.R
import com.tygris.lush.ui.screens.shared.components.SearchTextField
import com.tygris.lush.ui.theme.rubik

@Composable
fun LushTopBar(
    context: Context,
    ){

    TopAppBar(
        title = { Text(text = context.getString(R.string.app_name),
            style = MaterialTheme.typography.body1,
            fontFamily = rubik,
            fontWeight = FontWeight.Bold)},
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Search, context.getString(R.string.Search))
            }
        }
    )
}



@Composable
@Preview(showBackground = true)
fun LushTopBarPreview(){

}