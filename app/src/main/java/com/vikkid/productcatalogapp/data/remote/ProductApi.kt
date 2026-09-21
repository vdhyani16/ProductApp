package com.vikkid.productcatalogapp.data.remote

import com.vikkid.productcatalogapp.data.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
}