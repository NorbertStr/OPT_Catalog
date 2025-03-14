package com.optcatalog.ui.screens.product_list

import AppTheme
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.optcatalog.data.model.Product

import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ProductListScreen(
    searchProduct: (String) -> Unit,
    searchResults: State<List<Product>>,
    onNavigate: (item: Product) -> Unit,
    modifier: Modifier = Modifier
) {

    var query by rememberSaveable { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .padding(10.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(16.dp),
                        ambientColor = Color.Gray
                    )
                    .border(
                        border = BorderStroke(width = 1.dp, color = Color.DarkGray),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    textStyle = TextStyle(
                        fontSize = 17.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    placeholder = {
                        Row {
                            Icon(
                                imageVector = Icons.Filled.Search, contentDescription = "",
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            Text(
                                text = "Search", color = Color.Gray
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color(0xFF475D92)),
                )
            }

            searchProduct(query)

            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.clickable {

                }) {
                items(searchResults.value) {
                    ItemRow(product = it, modifier = Modifier.clickable {
                        it.let(onNavigate)
                    })
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:Galaxy Nexus"
)
@Composable
private fun ProductListPreview() {
    val product1 = Product(
        id = 1,
        number = "90909",
        name = "fasdf",
        serial = "tak",
        lot = "nie",
        description = "fasdfgasgh"
    )
    val product2 = Product(
        id = 1,
        number = "90909",
        name = "fasdf",
        serial = "nie",
        lot = "yes",
        description = "fasdfgasgh"
    )
    val product3 = Product(
        id = 1,
        number = "90909",
        name = "fasdf",
        serial = "no",
        lot = "yes",
        description = "fsadfsdafg"
    )

    val productList1 = listOf(
        product1,
        product2,
        product3,
        product2,
        product3,
        product3,
        product2,
        product1,
        product2,
        product1
    )
    val productList2 = MutableStateFlow<List<Product>>(productList1)
    val productList3: State<List<Product>> = productList2.collectAsState()

    AppTheme {
        ProductListScreen(searchProduct = {}, searchResults = productList3, onNavigate = {})
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:Galaxy Nexus"
)
@Composable
private fun ProductListPreviewDark() {
    val product1 = Product(
        id = 1,
        number = "90909",
        name = "fasdf",
        serial = "tak",
        lot = "nie",
        description = "fasdfgasgh"
    )
    val product2 = Product(
        id = 1,
        number = "90909",
        name = "fasdf",
        serial = "nie",
        lot = "yes",
        description = "fasdfgasgh"
    )
    val product3 = Product(
        id = 1,
        number = "90909",
        name = "fasdf",
        serial = "no",
        lot = "yes",
        description = "fsadfsdafg"
    )

    val productList1 = listOf(
        product1,
        product2,
        product3,
        product2,
        product3,
        product3,
        product2,
        product1,
        product2,
        product1
    )
    val productList2 = MutableStateFlow<List<Product>>(productList1)
    val productList3: State<List<Product>> = productList2.collectAsState()

    AppTheme {
        ProductListScreen(searchProduct = {}, searchResults = productList3, onNavigate = {})
    }
}