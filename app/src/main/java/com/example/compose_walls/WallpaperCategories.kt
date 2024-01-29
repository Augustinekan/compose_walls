package com.example.compose_walls

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose_walls.navigation.Screen

@Composable
fun WallpaperCategoriesList(navController: NavController) {
    LazyColumn{
        items(getWallpaperCategories()){
            category ->
            WallpaperCategoryTile(category = category, navController = navController)
        }
    }
      //List<WallpaperCategory> categories = getWallpaperCategories();
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperCategoryTile(navController: NavController,category:WallpaperCategory, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        onClick = {
            Log.d("Click", "CardExample: Card Click")
            navController.navigate(Screen.WallpapersPage.withArgs(category.title))
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = category.title, style = MaterialTheme.typography.titleMedium)
        }
    }
}
//
//@Preview
//@Composable
//fun CenteredTextCardPreview() {
//    WallpaperCategoriesList()
//}

class WallpaperCategory(title: String){
   var title: String = title
    //Category constructor(firstName: String) { /*...*/ }

}
fun getWallpaperCategories() = listOf( Abstract, Nature, Horror, Flowers)

val Abstract = WallpaperCategory(title = "Abstract");
val Nature = WallpaperCategory(title = "Nature");
val Horror = WallpaperCategory(title = "Horror");
val Flowers = WallpaperCategory(title = "Flowers ");