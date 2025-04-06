package com.optcatalog.ui.screens.product_list

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.optcatalog.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun FirebaseUpdateToast(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
    isPressed: Boolean,
    context: Context
) {

    val isDatabaseUpdated by viewModel.downloadProductsFromFirebaseIsSuccess.collectAsState()
    var isFirstTime by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(isPressed) {
        delay(2000)
        when (isFirstTime) {
            true -> isFirstTime = false
            false -> {
                Toast.makeText(
                    context,
                    if (isDatabaseUpdated) {
                        "Database has been updated"
                    } else {
                        "Database update failed. Please try again."
                    },
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}