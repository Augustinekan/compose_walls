package com.example.compose_walls.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.compose_walls.HomePage
import com.example.compose_walls.WallpaperCategoriesList
import com.example.compose_walls.WallpapersPage

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.HomePage.route ){
        composable(route = Screen.HomePage.route){
          HomePage(navController, name = "home")
        }
        composable(route = Screen.WallpaperCategoriesList.route){
            WallpaperCategoriesList(navController)
        }
        composable(route = Screen.WallpapersPage.route + "/{category}",
            arguments = listOf(
                navArgument("category"){
                    nullable = true
                    type = NavType.StringType
                }
            )
            ){entry ->
          WallpapersPage(navController,category = entry.arguments?.getString("category"))
        }
    }
}

