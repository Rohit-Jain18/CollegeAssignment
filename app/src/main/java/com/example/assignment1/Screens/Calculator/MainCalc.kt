package com.example.assignment1.Screens.Calculator

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.airbnb.lottie.utils.MeanCalculator


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainCalculator(navController: NavController) {

    Surface {
        Scaffold(modifier = Modifier.fillMaxSize(),

            topBar = {
                TopAppBar(
                    title = { Text(text = "Calculator") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        Color(0xff17bebb),
                        titleContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("Home")},
                           ) {

                            Icon(Icons.Outlined.ArrowBack, contentDescription = "back")
                        }
                    }


                )
            }

            )
        {
            val calculatorViewModel: CalculatorViewModel = viewModel()
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Calculator(modifier = Modifier.padding(innerPadding), calculatorViewModel)
            }
        }
    }}