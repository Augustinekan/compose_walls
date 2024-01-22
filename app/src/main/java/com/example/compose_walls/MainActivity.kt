package com.example.compose_walls

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.compose_walls.ui.theme.Compose_wallsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_wallsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeBody("Compose Body")
                }
            }
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun ComposeBody(name: String, modifier: Modifier = Modifier) {
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

    Scaffold(
        topBar = {
            CustomTopAppBar()
        },
        content = { innerPadding ->
            Surface (modifier = Modifier.padding(innerPadding)){
                WallpaperCategoriesList()

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


