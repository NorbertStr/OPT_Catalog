package com.optcatalog.ui.screens.product_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DropdownMenu(
    onUpdateDatabase: () -> Unit
){
    var expanded by remember {mutableStateOf(false)}

    Box(
        modifier = Modifier
            .background(Color(0xFF37474F)),


    ){
        IconButton(onClick = {expanded = !expanded}) {
            Icon(Icons.Default.Menu, contentDescription = "More options")
        }
        androidx.compose.material3.DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false}
        ){
            DropdownMenuItem(
                text = { Text("Synchronize") },
                leadingIcon = { Icon(Icons.Default.Refresh, contentDescription = "refresch detabase") },
                onClick = {
                    onUpdateDatabase()
                    expanded = false
                }

            )
        }

    }
}

@Preview
@Composable
private fun DropdownMenuPreview() {
    DropdownMenu(
        onUpdateDatabase = {}
    )
}