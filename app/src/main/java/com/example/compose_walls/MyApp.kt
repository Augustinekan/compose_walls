package com.example.compose_walls

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.compose_walls.navigation.Navigation
import com.example.compose_walls.ui.theme.Compose_wallsTheme

@Composable
fun MyApp(name: String, modifier: Modifier = Modifier,navController: NavHostController) {
    Compose_wallsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigation(navController)
        }
    }
}

