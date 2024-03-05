package com.raywenderlich.android.lab3.app

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.raywenderlich.android.lab3.router.FundamentalsRouter
import com.raywenderlich.android.lab3.router.Screen
import com.raywenderlich.android.lab3.screens.AlertDialogScreen
import com.raywenderlich.android.lab3.screens.BoxScreen
import com.raywenderlich.android.lab3.screens.ColumnScreen
import com.raywenderlich.android.lab3.screens.ExploreButtonsScreen
import com.raywenderlich.android.lab3.screens.GridScreen
import com.raywenderlich.android.lab3.screens.ListScreen
import com.raywenderlich.android.lab3.screens.NavigationScreen
import com.raywenderlich.android.lab3.screens.ProgressIndicatorScreen
import com.raywenderlich.android.lab3.screens.RowScreen
import com.raywenderlich.android.lab3.screens.ScaffoldScreen
import com.raywenderlich.android.lab3.screens.ScrollingScreen
import com.raywenderlich.android.lab3.screens.SurfaceScreen
import com.raywenderlich.android.lab3.screens.TextFieldScreen
import com.raywenderlich.android.lab3.screens.TextScreen

@Composable
fun FundamentalsApp() {
    Surface(color = MaterialTheme.colors.background) {
        Crossfade(targetState = FundamentalsRouter.currentScreen) { screenState ->
            when (screenState.value) {
                is Screen.Navigation -> NavigationScreen()
                is Screen.Text -> TextScreen()
                is Screen.TextField -> TextFieldScreen()
                is Screen.Buttons -> ExploreButtonsScreen()
                is Screen.ProgressIndicator -> ProgressIndicatorScreen()
                is Screen.AlertDialog -> AlertDialogScreen()
                is Screen.Row -> RowScreen()
                is Screen.Column -> ColumnScreen()
                is Screen.Box -> BoxScreen()
                is Screen.Surface -> SurfaceScreen()
                is Screen.Scaffold -> ScaffoldScreen()
                is Screen.Scrolling -> ScrollingScreen()
                is Screen.List -> ListScreen()
                is Screen.Grid -> GridScreen()
            }
        }
    }
}