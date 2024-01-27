package com.example.compose_walls

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController,name: String, modifier: Modifier = Modifier) {
    val navigationItems = listOf<BottomNavigationBarItem>(
        BottomNavigationBarItem(
            title = "Categories",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationBarItem(
            title = "Wallpapers",
            selectedIcon = Icons.Filled.ThumbUp,
            unselectedIcon = Icons.Outlined.ThumbUp,
            hasNews = false,
            badgeCount = null
        )
    );
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    };

    //val pages = listOf(WallpaperCategoriesList(), WallpapersPage(category = null))
    //            Compose_wallsTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    MyApp("Compose Body")
//                }
//            }
    Scaffold(
        topBar = {
            CustomTopAppBar()
        },
        content = { innerPadding ->
            Surface (modifier = Modifier.padding(innerPadding)){
                if(selectedItemIndex==0){WallpaperCategoriesList(navController = navController)}else{WallpapersPage(category = null, navController = navController)}
            }
        },

        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, bottomNavigationBarItem ->  NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                    },
                    label = {
                        Text(text = bottomNavigationBarItem.title)
                    },
                    icon = {
                        BadgedBox(badge = {
                            if(bottomNavigationBarItem.badgeCount!=null){
                                Text(text = bottomNavigationBarItem.badgeCount.toString())
                            }
                            else if(bottomNavigationBarItem.hasNews){
                                Badge ()
                            }
                        }) {
                            Icon(imageVector = if(index == selectedItemIndex){bottomNavigationBarItem.selectedIcon}else {bottomNavigationBarItem.unselectedIcon}, contentDescription = bottomNavigationBarItem.title)
                        }
                    },
                )}

            }
        }

    )
}
