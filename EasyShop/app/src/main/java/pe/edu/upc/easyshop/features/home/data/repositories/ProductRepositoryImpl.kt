package pe.edu.upc.easyshop.features.home.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easyshop.features.home.data.remote.services.ProductService
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import pe.edu.upc.easyshop.shared.models.Product

class ProductRepositoryImpl(private val service: ProductService) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> = withContext(Dispatchers.IO) {
        val response = service.getAllProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsWrapperDto ->
                val products = productsWrapperDto.products.map { productDto ->
                    Product(
                        id = productDto.id,
                        name = productDto.title,
                        price = productDto.price,
                        image = productDto.thumbnail
                    )
                }
                return@withContext products

            }
        }


        return@withContext emptyList()
    }

    override suspend fun getProductById(id: Int): Product? = withContext(Dispatchers.IO) {
        val response = service.getProductById(id)

        if (response.isSuccessful) {
            response.body()?.let { productDto ->
                return@withContext Product(
                    id = productDto.id,
                    name = productDto.title,
                    price = productDto.price,
                    image = productDto.thumbnail
                )
            }
        }

        return@withContext null
    }
}