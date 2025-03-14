package com.optcatalog.ui.screens.product_list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.optcatalog.data.model.Product

@Composable
fun ItemRow(
    product: Product,
    modifier: Modifier = Modifier
) {

    ElevatedCard(
        modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Text(
            text = product.number,
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(text = product.name,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Preview
@Composable
private fun ItemRowPreview() {
    val product = Product(
        id = 1,
        number = "999-101",
        name = "filter",
        serial = "true",
        lot = "false",
        description = " Open master box and take one"
    )

    ItemRow(product = product)
}