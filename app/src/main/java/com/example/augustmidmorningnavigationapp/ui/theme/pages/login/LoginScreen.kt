package com.example.augustmidmorningnavigationapp.ui.theme.pages.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.augustmidmorningnavigationapp.data.AuthRepository
import com.example.augustmidmorningnavigationapp.navigation.ROUTE_ABOUT
import com.example.augustmidmorningnavigationapp.navigation.ROUTE_HOME
import com.example.augustmidmorningnavigationapp.navigation.ROUTE_SIGNUP
import com.example.augustmidmorningnavigationapp.ui.theme.AugustMidMorningNavigationAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Login here",
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold)

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            // ---------WRITE LOGIN LOGIC HERE---------//
            var authRepository = AuthRepository(navController,context)
            authRepository.login(email.text.trim(), password.text.trim())

        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_SIGNUP)
        }) {
            Text(text = "No account? Signup")
        }

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    AugustMidMorningNavigationAppTheme {
        LoginScreen(rememberNavController())
    }
}