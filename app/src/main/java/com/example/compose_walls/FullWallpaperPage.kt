package com.example.compose_walls

import android.app.WallpaperManager
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose_walls.utils.ImageUtils
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullWallpaperPage(navController: NavController, wallpaper: String) {
    val imagePainter: Painter = painterResource(id = ImageUtils().getResourceId(wallpaper))
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(0.dp))
            .fillMaxSize()
            .padding(0.dp),
        onClick = {
            showBottomSheet = true
        }
    ) {

        Column {

                    Image(
                        //            model = "file:///android_asset/images_folder/image.png",
                        painter = imagePainter, contentDescription = wallpaper,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(0.dp))

                    )
            if(showBottomSheet) {
                ModalBottomSheet(
                    containerColor = Color.Black.copy(alpha = 0.6f),
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    // Sheet content
                    FullWallpaperBottomSheet(navController, wallpaper)

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullWallpaperBottomSheet(navController: NavController, wallpaper: String) {
    val sheetState = rememberModalBottomSheetState()



    val coroutineScope = rememberCoroutineScope()
    val hideModalBottomSheet: () -> Unit =
        { coroutineScope.launch { sheetState.hide() } }

var local = LocalContext.current;

    var ct = LocalContext.current
    fun setAsWallpaper(wallpaper: String) {

        val resources = ct.resources
        val drawableId = resources.getIdentifier(wallpaper, "drawable", ct.packageName)
        if (drawableId != 0) {
            val drawable = ContextCompat.getDrawable(ct, drawableId)
            val bitmap = (drawable as BitmapDrawable).bitmap

            WallpaperManager.getInstance(ct).setBitmap(bitmap)

            // Display optional preview
            // Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Wallpaper Preview")
        } else {

        }
    }


    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
    Column {
        Row (horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp),){
            Button(onClick = {
               hideModalBottomSheet()
//            scope.launch { sheetState.hide() }.invokeOnCompletion {
//                if (!sheetState.isVisible) {
//                    showBottomSheet = false
//                }
//            }
            }) {
                Text(text = "Download")
            }
            Button(onClick = {
               hideModalBottomSheet()

                setAsWallpaper(wallpaper)
//            scope.launch { sheetState.hide() }.invokeOnCompletion {
//                if (!sheetState.isVisible) {
//                    showBottomSheet = false
//                }
//            }
            }) {
                Text(text = "Set Wallpaper")
            }
        }
        //Text(text = "This is a sheet")

        Box(
            modifier = Modifier.height(62.dp)
        ){}
    }

}
}





@Preview
@Composable
fun FullWallpaperPagePreview() {
    val navController = rememberNavController();
    FullWallpaperPage(navController = navController, wallpaper = "volcano")
}

@Preview(showBackground = true)
@Composable
fun FullWallpaperPageBottomSheetPreview() {
    val navController = rememberNavController();
    FullWallpaperBottomSheet(navController = navController, wallpaper = "volcano")
}


