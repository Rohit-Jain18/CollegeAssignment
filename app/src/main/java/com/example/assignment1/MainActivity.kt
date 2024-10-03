package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.assignment1.Screens.Calculator.MainCalculator
import com.example.assignment1.Screens.HomeScreen
import com.example.assignment1.Screens.MessageApp.Message
import com.example.assignment1.ui.theme.Assignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
enableEdgeToEdge()
        setContent {
            Assignment1Theme {
               val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Home", builder ={
                    composable("Home",) {
                        HomeScreen(navController)
                    }
                    composable("Calculator",) {
                        MainCalculator(navController)
                    }
                    composable("Message") {
                        Message(navController)
                    }
                })
            }
        }
    }
}

