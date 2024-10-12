package com.medicare.auth

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.medicare.auth.detailscreen.DetailScreen
import com.medicare.auth.home.HomeScreen
import com.medicare.auth.login.LoginScreen

const val authRoute ="auth"

sealed class AuthScreen( val route :String) {
    data object Login :AuthScreen("$authRoute/login")
    data object HomeScreen :AuthScreen("$authRoute/home")
    data object DetailScreen : AuthScreen( "$authRoute/detail")
}

fun NavGraphBuilder.authNavGraph(
    navController: NavController
){
    navigation(startDestination = AuthScreen.Login.route, route= authRoute){
        composable(AuthScreen.Login.route){
            LoginScreen(viewModel = hiltViewModel(),
                onNavigateToHome = {
                    navController.navigate(AuthScreen.HomeScreen.route)
                },

            )
        }

        composable(AuthScreen.HomeScreen.route){
            HomeScreen( viewModel = hiltViewModel(),
                onNavigateToHomeDetail ={ medicine ->
                    navController.navigate("${AuthScreen.DetailScreen.route}/${medicine.id}")
                }
            )
        }
        composable(
            route = "${AuthScreen.DetailScreen.route}/{medicineId}",
            arguments = listOf(navArgument("medicineId") { type= NavType.IntType })
        ){ backStackEntry ->
             val medicineId= backStackEntry.arguments?.getInt("medicineId")
            DetailScreen(
                viewModel = hiltViewModel(),
                medicineId = medicineId ?: 1,
                navController = navController
            )
        }
    }

}