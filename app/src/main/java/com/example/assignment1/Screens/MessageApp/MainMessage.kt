package com.example.assignment1.Screens.MessageApp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.airbnb.lottie.utils.MeanCalculator


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Message(navController:NavController) {

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

        ){
  val context = LocalContext.current
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
        val text = "hello From Rohit Jain from Message App"
        Text(text = text)
        Button(onClick = {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            context.startActivity(shareIntent)

        }) {
            Text("hello")
        }
    }

}}}