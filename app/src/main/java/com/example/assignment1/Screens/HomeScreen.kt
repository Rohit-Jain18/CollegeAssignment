@file:Suppress("UNUSED_EXPRESSION")

package com.example.assignment1.Screens


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.assignment1.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController:NavController) {
Surface {
    Scaffold ( modifier = Modifier.fillMaxSize(),
        topBar = {
        TopAppBar(
            title = { Text(text = "Assignment App" )},
            colors = TopAppBarDefaults.topAppBarColors(Color(0xff17bebb),
                titleContentColor = Color.White
                )


        )  }  ){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OptionCard(text = "Calculator", onClick = {  navController.navigate("Calculator")} , id = R.raw.calc)
            OptionCard(text = "Message", onClick = {navController.navigate("Message")}, id = R.raw.mesage)

        }
    }

}
}




@Composable
fun OptionCard(
    modifier: Modifier = Modifier.background(Color(0xffffc43d)),
    text: String,
    id : Int,
    onClick: () -> Unit
) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(id))
    val progress by animateLottieCompositionAsState(composition)


    Card(modifier = Modifier
        .width(300.dp)
        .height(300.dp)
        .padding(25.dp)
        .clip(RoundedCornerShape(5))
        ,
        colors = CardDefaults.cardColors(Color(0xffffc43d)),
        onClick =  onClick
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center
            ) {
            LottieAnimation(composition = composition,
              iterations = Int.MAX_VALUE
                , modifier = Modifier.weight(1f))
            Text(text = text ,modifier =Modifier.padding(5.dp, bottom = 11.dp) , fontSize = 20.sp , fontWeight = FontWeight.Bold)
        }


        }

    }

