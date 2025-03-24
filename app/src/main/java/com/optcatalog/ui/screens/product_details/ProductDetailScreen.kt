package com.optcatalog.ui.screens.product_details

import AppTheme
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.optcatalog.data.model.Product


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    product: Product
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = product.number,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = topAppBarColors(
                    containerColor = Color(0xFF37474F)
                )
            )
        }
    )
    { innerPadding ->
        Surface(
            modifier = modifier.padding(innerPadding),
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {


                Text(text = product.name)
                Spacer(
                    modifier = Modifier
                        .height(3.dp)
                        .background(Color.Gray)
                        .fillMaxSize()
                )
                Text(
                    modifier = Modifier.padding(top = 15.dp, bottom = 7.dp),
                    text = "Decryption:",
                    fontStyle = FontStyle.Italic
                )
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column (modifier = Modifier.fillMaxWidth()){
                        Text(
                            text = product.description,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text(text = "Lot: ${product.lot}" )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text =" Serial: ${product.serial}")
                        }
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun ProductDetailsScreenPreview() {
    val product = Product(
        id = 1,
        number = "999-123",
        name = "Filter",
        serial = "yes",
        lot = "no",
        description = "Do not Open Master Container Take Box"
    )
    AppTheme {
        ProductDetailScreen(product = product)
    }

}

@Preview(showBackground = true, showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun ProductDetailsScreenPreviewDark() {
    val product = Product(
        id = 1,
        number = "999-123",
        name = "Filter",
        serial = "yes",
        lot = "no",
        description = "Do not Open Master Container Take Box"
    )
    AppTheme {
        ProductDetailScreen(product = product)
    }

}