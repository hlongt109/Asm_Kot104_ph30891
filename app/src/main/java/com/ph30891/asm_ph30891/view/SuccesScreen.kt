package com.ph30891.asm_ph30891.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.ph30891.asm_ph30891.R
import com.ph30891.asm_ph30891.ui.theme.Merriweather
import com.ph30891.asm_ph30891.ui.theme.Nunito_Sans

@Composable
fun SuccessScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "SUCCESS !",
            fontSize = 40.sp,
            fontFamily = Merriweather,
            fontWeight = FontWeight.Bold,
            color = Color("#303030".toColorInt()),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.khung1),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.lg2),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.checkmark),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "Your order will be delivered soon.\n" +
                    "Thank you for choosing our app!",
            fontSize = 22.sp,
            fontFamily = Nunito_Sans,
            fontWeight = FontWeight.Medium,
            color = Color("#606060".toColorInt()),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {navController.navigate("tabNav")},
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .shadow(4.dp, shape = RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "Track your orders",
                fontSize = 22.sp,
                fontFamily = Nunito_Sans,
                fontWeight = FontWeight.SemiBold,
                color = Color("#ffffff".toColorInt()),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {navController.navigate("tabNav") },
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "BACK TO HOME",
                fontSize = 22.sp,
                fontFamily = Nunito_Sans,
                fontWeight = FontWeight.SemiBold,
                color = Color("#303030".toColorInt()),
                textAlign = TextAlign.Center
            )
        }
    }
}