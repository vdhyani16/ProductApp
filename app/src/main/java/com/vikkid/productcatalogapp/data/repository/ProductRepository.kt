package com.vikkid.productcatalogapp.data.repository

import com.vikkid.productcatalogapp.data.model.Product
import com.vikkid.productcatalogapp.data.remote.ProductApi
import com.vikkid.productcatalogapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

interface ProductRepository {
    suspend fun getProducts(): NetworkResult<List<Product>>
}

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): NetworkResult<List<Product>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getProducts()
                NetworkResult.Success(response)
            } catch (e: HttpException) {
                NetworkResult.Error("Server error: ${e.code()} - ${e.message()}")
            } catch (e: IOException) {
                NetworkResult.Error("Network error: Please check your internet connection")
            } catch (e: Exception) {
                NetworkResult.Error("Unknown error: ${e.localizedMessage ?: "Something went wrong"}")
            }
        }
    }
}