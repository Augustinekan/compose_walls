package com.example.compose_walls

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpapersPage(navController: NavController, category: String?){
    Scaffold (
        topBar = {WallpapersPageTopAppBar(categoryTitle = category)},
        content = {innerPadding ->  Surface (modifier = Modifier.padding(innerPadding)){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                BasicText(text = "Wallpapers")
            }
        }
        }
    )
}


@ExperimentalMaterial3Api
@Composable
fun WallpapersPageTopAppBar(categoryTitle: String?){

    TopAppBar(
        title = {
            Text(
                if(categoryTitle!=null){"$categoryTitle Wallpapers"}else{"Wallpapers"},
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        },
//        navigationIcon = {
//            IconButton(onClick = { /* doSomething() */ }) {
//                Icon(
//                    imageVector = Icons.Filled.Menu,
//                    contentDescription = "Localized description"
//                )
//            }
//        },
//        actions = {
//            IconButton(onClick = { /* doSomething() */ }) {
//                Icon(
//                    imageVector = Icons.Filled.Favorite,
//                    contentDescription = "Localized description"
//                )
//            }
//        }
    )
}