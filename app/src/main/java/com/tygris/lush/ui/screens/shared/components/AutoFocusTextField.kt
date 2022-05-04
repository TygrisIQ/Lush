package com.tygris.lush.ui.screens.shared.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalTextInputService
import kotlinx.coroutines.delay

@Composable
fun SearchTextField(rValue: (String) ->Unit){
    val s = remember { mutableStateOf("")}
    val focusRequester = remember { FocusRequester() }
    val inputService = LocalTextInputService.current
    val focus = remember { mutableStateOf(false) }
    OutlinedTextField(
        value = s.value,
        onValueChange = {s.value = it},
        trailingIcon = { IconButton(onClick = { rValue(s.value)}) {
            Icon(Icons.Filled.Search, contentDescription = null)
        }},
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (focus.value != it.isFocused) {
                    focus.value = it.isFocused
                    if (!it.isFocused) {
                        inputService?.hideSoftwareKeyboard()
                    }
                }
            }
    )

    LaunchedEffect("") {
        delay(300)
        inputService?.showSoftwareKeyboard()
        focusRequester.requestFocus()
    }
}