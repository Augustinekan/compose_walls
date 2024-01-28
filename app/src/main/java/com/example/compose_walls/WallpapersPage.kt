package com.example.compose_walls

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.TypedArrayUtils.getResourceId
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.compose_walls.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpapersPage(navController: NavController, category: String?){
    Scaffold (
        topBar = { if(category!=null){WallpapersPageTopAppBar(categoryTitle = category)} },
        content = {innerPadding ->  Surface (modifier = Modifier.padding(innerPadding)){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                WallpapersGrid()
            }
        }
        }
    )
}

@Composable
fun WallpapersGrid(){
    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp)){
        LazyVerticalGrid(

            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
                columns = GridCells.Fixed(2), content ={
            items(wallpaperList.size){index ->
                
                    WallpaperGridItem(wallpaper = wallpaperList[index])

            }
        })
    }
}

@SuppressLint("RestrictedApi")
@Composable
    fun WallpaperGridItem(wallpaper: String){
    val imagePainter: Painter = painterResource(id = getResourceId(wallpaper))

    Box (modifier = Modifier.clip(shape = RoundedCornerShape(4.dp)).aspectRatio(0.9F)){

        Image(
//            model = "file:///android_asset/images_folder/image.png",

            painter = imagePainter, contentDescription = wallpaper,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize().clip(shape = RoundedCornerShape(4.dp),

        ))
    }
    }

@Composable
private fun getResourceId(imageName: String): Int {
    val context = LocalContext.current
    val resources = context.resources
    return resources.getIdentifier(imageName, "drawable", context.packageName)
}

val wallpaperList = listOf("cat","mountain","night","scene","sub","volcano");

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

    )
}

@Preview
@Composable
fun WallpapersPagePreview(){
    val navController = rememberNavController()

    WallpapersPage(navController = navController,category = null)
}