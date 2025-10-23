package com.example.augustmidmorningnavigationapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.augustmidmorningnavigationapp.ui.theme.pages.about.AboutScreen
import com.example.augustmidmorningnavigationapp.ui.theme.pages.home.HomeScreen
import com.example.augustmidmorningnavigationapp.ui.theme.pages.login.LoginScreen
import com.example.augustmidmorningnavigationapp.ui.theme.pages.products.AddProductsScreen
import com.example.augustmidmorningnavigationapp.ui.theme.pages.signup.SignupScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = ROUTE_LOGIN) {
    NavHost(navController = navController,
        modifier = modifier,startDestination = startDestination){

        composable(ROUTE_LOGIN){
           LoginScreen(navController)
        }

        composable(ROUTE_SIGNUP){
            SignupScreen(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }

        composable(ROUTE_ABOUT){
            AboutScreen(navController)
        }

        composable(ROUTE_ADD_PRODUCTS){
            AddProductsScreen(navController)
        }

        composable(ROUTE_VIEW_PRODUCTS){

        }
    }
}