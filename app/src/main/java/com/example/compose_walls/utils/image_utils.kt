package com.example.compose_walls.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class ImageUtils {
    @Composable
    fun getResourceId(imageName: String): Int {
        val context = LocalContext.current
        val resources = context.resources
        return resources.getIdentifier(imageName, "drawable", context.packageName)
    }
}