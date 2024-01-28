package com.example.compose_walls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.compose_walls.navigation.Navigation
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


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyAppPreview(){
    val navController = rememberNavController()

    Navigation(navController)
}



