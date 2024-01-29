package com.example.compose_walls

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose_walls.utils.ImageUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullWallpaperPage(navController: NavController, wallpaper: String) {
    val imagePainter: Painter = painterResource(id = ImageUtils().getResourceId(wallpaper))

    Card(
        modifier = Modifier.clip(RoundedCornerShape(0.dp))
            .fillMaxSize()
            .padding(0.dp),
        onClick = {

        }
    ) {

        Image(
            //            model = "file:///android_asset/images_folder/image.png",
            painter = imagePainter, contentDescription = wallpaper,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize().clip(RoundedCornerShape(0.dp))

        )
    }
}

@Preview
@Composable
fun FullWallpaperPagePreview() {
    val navController = rememberNavController();
    FullWallpaperPage(navController = navController, wallpaper = "volcano")
}