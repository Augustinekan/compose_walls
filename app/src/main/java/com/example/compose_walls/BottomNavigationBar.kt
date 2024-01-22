package com.example.compose_walls

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationBarItem (
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
    )