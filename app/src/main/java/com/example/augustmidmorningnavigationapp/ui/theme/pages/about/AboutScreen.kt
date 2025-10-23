package com.example.augustmidmorningnavigationapp.ui.theme.pages.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.augustmidmorningnavigationapp.ui.theme.AugustMidMorningNavigationAppTheme

@Composable
fun AboutScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to about screen")

    }
}

@Preview
@Composable
fun AboutScreenPreview() {
    AugustMidMorningNavigationAppTheme {
        AboutScreen(rememberNavController())
    }
}