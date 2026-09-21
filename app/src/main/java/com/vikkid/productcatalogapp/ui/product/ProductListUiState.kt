package com.vikkid.productcatalogapp.ui.product

import com.vikkid.productcatalogapp.data.model.Product

data class ProductListUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val errorMessage: String? = null
)