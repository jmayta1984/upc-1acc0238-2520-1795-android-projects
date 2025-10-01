package pe.edu.upc.easyshop.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.easyshop.core.root.Main
import pe.edu.upc.easyshop.features.auth.presentation.login.Login
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.auth.presentation.di.PresentationModule.getLoginViewModel
import pe.edu.upc.easyshop.features.auth.presentation.login.LoginViewModel
import pe.edu.upc.easyshop.features.home.presentation.di.PresentationModule.getProductDetailViewModel
import pe.edu.upc.easyshop.features.home.presentation.productdetail.ProductDetail

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val loginViewModel = getLoginViewModel()
    val productDetailViewModel = getProductDetailViewModel()


    NavHost(navController, startDestination = Route.Login.route) {
        composable(Route.Login.route){
            Log.d("AppNavigation", "Login")
            Login(loginViewModel) {
                navController.navigate(Route.Main.route)
            }


        }


        composable (Route.Main.route){
            Log.d("AppNavigation", "Main")

            Main { productId ->
                navController.navigate("${Route.ProductDetail.route}/$productId")

            }
        }
/*
        composable (
            route = Route.ProductDetail.routeWithArgument,
            arguments = listOf(navArgument(Route.ProductDetail.argument) {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.let { arguments ->

                val productId = arguments.getInt(Route.ProductDetail.argument)
                Log.d("AppNavigation", productId.toString())

                //productDetailViewModel.getProductById(productId)
                //ProductDetail(productDetailViewModel)


            }

        }

 */
    }
}



@Preview(showBackground = true)
@Composable
fun AppNavigationPreview(){
    EasyShopTheme {
        AppNavigation()
    }
}