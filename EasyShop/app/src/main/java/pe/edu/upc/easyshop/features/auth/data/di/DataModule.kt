package pe.edu.upc.easyshop.features.auth.data.di

import pe.edu.upc.easyshop.core.networking.ApiConstants
import pe.edu.upc.easyshop.features.auth.data.remote.AuthService
import pe.edu.upc.easyshop.features.auth.data.repositories.AuthRepositoryImpl
import pe.edu.upc.easyshop.features.auth.domain.repositories.AuthRepository
import pe.edu.upc.easyshop.features.home.data.remote.services.ProductService
import pe.edu.upc.easyshop.features.home.data.repositories.ProductRepositoryImpl
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(getAuthService())
    }

    fun getAuthService(): AuthService {
        return getRetrofit().create(AuthService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}