package com.ph30891.asm_ph30891.view.navigator

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ph30891.asm_ph30891.ui.theme.White01
import com.ph30891.asm_ph30891.view.DetailsScreen
import com.ph30891.asm_ph30891.view.Favourite
import com.ph30891.asm_ph30891.view.Home
import com.ph30891.asm_ph30891.view.Notification
import com.ph30891.asm_ph30891.view.Personal
import com.ph30891.asm_ph30891.view.fake_products

@Composable
fun BottomNav(navController: NavController){
    val navigationController = rememberNavController()
    val contex = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = White01
            ){
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(BottomBarScreen.Home.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                   Icon(
                       Icons.Default.Home, contentDescription = null,
                       modifier = Modifier.size(26.dp),
                       tint = if(selected.value == Icons.Default.Home) Color.DarkGray else Color("#939393".toColorInt())
                   )
                }
                //
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.BookmarkBorder
                        navigationController.navigate(BottomBarScreen.Favourite.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.BookmarkBorder, contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.BookmarkBorder) Color.DarkGray else Color("#939393".toColorInt())
                    )
                }
                //
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.NotificationsNone
                        navigationController.navigate(BottomBarScreen.Notification.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.NotificationsNone, contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.NotificationsNone) Color.DarkGray else Color("#939393".toColorInt())
                    )
                }
                // FloatingActionButton
//                Box(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(16.dp),
//                    contentAlignment = Alignment.Center
//                ) {
//                   FloatingActionButton(
//                       onClick = { Toast.makeText(contex,"Open bottom sheet",Toast.LENGTH_SHORT).show() }
//                   ) {
//                      Icon(Icons.Default.Add, contentDescription = null, tint = Color.LightGray )
//                   }
//                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.PersonOutline
                        navigationController.navigate(BottomBarScreen.Personal.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.PersonOutline, contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.PersonOutline) Color.DarkGray else Color("#939393".toColorInt())
                    )
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = BottomBarScreen.Home.screen,
            modifier =  Modifier.padding(paddingValues)
        ){
            composable(BottomBarScreen.Home.screen){ Home(navController = navController)}
            composable(BottomBarScreen.Favourite.screen){ Favourite() }
            composable(BottomBarScreen.Notification.screen){ Notification() }
            composable(BottomBarScreen.Personal.screen){ Personal() }

        }
    }
}

//@Preview
//@Composable
//fun PreviewNav(){
//    BottomNav()
//}