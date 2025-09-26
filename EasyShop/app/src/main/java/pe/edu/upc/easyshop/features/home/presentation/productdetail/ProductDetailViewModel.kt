package pe.edu.upc.easyshop.features.home.presentation.productdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import pe.edu.upc.easyshop.shared.models.Product

class ProductDetailViewModel(private val repository: ProductRepository) : ViewModel() {
    private var _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    fun getProductById(id: Int) {
        viewModelScope.launch {
            Log.d("ProductDetailViewModel", id.toString())
            _product.value = repository.getProductById(id)
        }
    }
}