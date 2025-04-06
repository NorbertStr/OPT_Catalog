package com.optcatalog

import AppTheme
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.optcatalog.data.model.Product
import com.optcatalog.ui.screens.product_details.ProductDetailScreen
import com.optcatalog.ui.screens.product_list.FirebaseUpdateToast
import com.optcatalog.ui.screens.product_list.ProductListScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))

        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()

            AppTheme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()
                lateinit var product: Product
                var isPressed by remember{ mutableStateOf(false) }


                NavHost(navController = navController, startDestination = "ProductList") {

                    composable("ProductList") {
                        ProductListScreen(
                            searchProduct = { query -> viewModel.searchProduct(query) },
                            searchResults = viewModel.products.collectAsState(),
                            onNavigate = { item ->
                                product = item
                                navController.navigate("ProductDetailScreen")
                            },
                            onUpdateDatabase = {
                                viewModel.updateLocalDatabaseFromFirebase()
                                isPressed = !isPressed
                            }
                        )
                    }

                    composable("ProductDetailScreen") {
                        ProductDetailScreen(
                            product = product,
                            onBackProductList = {
                                navController.navigate("ProductList") {
                                    popUpTo(0)
                                }
                            }
                        )

                    }
                }
                FirebaseUpdateToast(
                    context = this,
                    isPressed = isPressed,
                )
                viewModel.initializeDatabase(this)
            }
        }
    }
}


