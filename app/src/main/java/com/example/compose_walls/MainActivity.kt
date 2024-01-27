package com.example.compose_walls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.compose_walls.ui.theme.Compose_wallsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            //MyApp(name = "Compose Walls", navController = rememberNavController())
            //Navigation()
            Compose_wallsTheme {
                // Remember the NavController for navigation
                val navController = rememberNavController()
                // Define the navigation hierarchy and content
                MyApp(navController = navController, name = "MY APP")
            }
        }
    }
}



