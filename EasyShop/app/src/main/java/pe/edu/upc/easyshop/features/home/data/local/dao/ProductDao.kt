package pe.edu.upc.easyshop.features.home.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import pe.edu.upc.easyshop.features.home.data.local.models.ProductEntity

@Dao
interface ProductDao {
    @Insert
    suspend fun insert(vararg entity: ProductEntity)

    @Delete
    suspend fun delete(vararg entity: ProductEntity)
}