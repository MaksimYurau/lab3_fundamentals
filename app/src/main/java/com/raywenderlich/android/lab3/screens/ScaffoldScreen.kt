package com.raywenderlich.android.lab3.screens

import android.annotation.SuppressLint
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.raywenderlich.android.lab3.R
import com.raywenderlich.android.lab3.router.BackButtonHandler
import com.raywenderlich.android.lab3.router.FundamentalsRouter
import com.raywenderlich.android.lab3.router.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen() {
    MyScaffold()

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = {
            MyRow()
        },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        bottomBar = { MyBottomAppBar() },
        drawerContent = { MyColumn() }
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val drawerState = scaffoldState.drawerState
    
    TopAppBar(
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        Icons.Default.Menu,
                        tint = Color.White,
                        contentDescription = stringResource(id = R.string.iconContentDescription)
                    )
                },
           onClick = {
               scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close()}
           }
            )
        },
        title = { Text(text = stringResource(id = R.string.topAppBarTitle), color = Color.White) },
        backgroundColor = colorResource(id = R.color.colorPrimary)
    )
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar(
        content = {},
        backgroundColor = colorResource(id = R.color.colorPrimary)
    )
}
