package com.ph30891.asm_ph30891.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ph30891.asm_ph30891.ui.theme.Asm_ph30891Theme
import com.ph30891.asm_ph30891.view.navigator.BottomNav

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           MainScreen()
        }
    }
}
@Composable
@Preview
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { Welcome(navController = navController) }
        composable("login") { LoginScreen(navController = navController)}
        composable("signup"){ SignUpScreen(navController = navController)}
        composable("tabNav"){ BottomNav(navController = navController)}
//        composable("home"){ Home()}
        composable("details/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType }),
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            val product = fake_products.find { it.id == productId }
            product?.let { DetailsScreen(product = it,navController = navController) }
        }
        composable("cart"){ CartScreen(navController = navController)}
        composable("checkout"){ CheckoutScreen(navController = navController) }
        composable("success"){ SuccessScreen(navController = navController) }
    }
}

//@Composable
//fun DetailNav( navController:NavHostController) {
////    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "details/{productId}") {
//        composable("details/{productId}",
//            arguments = listOf(navArgument("productId") { type = NavType.IntType })
//        ) { backStackEntry ->
//            val productId = backStackEntry.arguments?.getInt("productId")
//            val product = fake_products.find { it.id == productId }
//            product?.let { DetailsScreen(product = it) }
//        }
//    }
//}

