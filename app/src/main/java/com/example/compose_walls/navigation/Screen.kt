package com.example.compose_walls.navigation

sealed class Screen (val route: String){
    object HomePage : Screen("home")
    object WallpapersPage : Screen("wallpaperspage")


    object WallpaperCategoriesList : Screen("categories")

    object FullWallpaperPage : Screen("fullwallpaperpage")

    fun withArgs (vararg  args:String):String{
        return  buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}