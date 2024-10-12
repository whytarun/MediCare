package com.tv.medicare.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.medicare.auth.authNavGraph
import com.medicare.auth.authRoute

@Composable
fun  MedicareNavHost(navHostController : NavHostController) {
      NavHost(navController = navHostController,
          startDestination = authRoute
      ){
         authNavGraph(
             navController = navHostController,
         )
      }
}