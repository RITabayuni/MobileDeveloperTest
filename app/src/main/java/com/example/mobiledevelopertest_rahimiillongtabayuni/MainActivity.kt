package com.example.mobiledevelopertest_rahimiillongtabayuni

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobiledevelopertest_rahimiillongtabayuni.ui.theme.MobileDeveloperTest_RahimiIllongTabayuniTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileDeveloperTest_RahimiIllongTabayuniTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController){
    var selectedUserName by remember { mutableStateOf("") }
    NavHost(navController = navController, startDestination = "first_screen" ){
        composable("first_screen") {FirstScreen(navController)}
        composable("second_screen/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            SecondScreen(navController, name, selectedUserName)
        }
        composable("third_screen") {ThirdScreen(navController) {selectedUser ->
            selectedUserName = selectedUser
            navController.navigate("second_screen/$selectedUser"){
                popUpTo("third_screen") {inclusive = true}
            }
        } }
    }
}
