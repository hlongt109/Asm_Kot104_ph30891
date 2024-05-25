package com.ph30891.asm_ph30891.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun CheckoutScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // toolbar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                ) {
                    Icon(Icons.Default.ArrowBackIosNew, contentDescription = null)
                }
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, end = 35.dp)
                        .fillMaxWidth(),
                    text = "Check out",
                    fontSize = 22.sp,
                    fontFamily = Merriweather,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            // address
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2.2f)
                    .padding(15.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Shipping Address",
                        fontSize = 21.sp,
                        fontFamily = Nunito_Sans,
                        fontWeight = FontWeight.SemiBold,
                        color = Color("#808080".toColorInt()),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Default.BorderColor,
                        contentDescription = "Close",
                        tint = Color("#303030".toColorInt()),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                            .clickable { /* Xử lý  */ }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    shape = RoundedCornerShape(topStart = 7.dp, topEnd = 7.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(3.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Bruno Fernandes",
                            fontSize = 20.sp,
                            fontFamily = Nunito_Sans,
                            fontWeight = FontWeight.Bold,
                            color = Color("#303030".toColorInt()),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Card(
                    shape = RoundedCornerShape(bottomStart = 7.dp, bottomEnd = 7.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(3.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(105.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                            fontSize = 16.sp,
                            fontFamily = Nunito_Sans,
                            fontWeight = FontWeight.Medium,
                            color = Color("#808080".toColorInt()),
                            textAlign = TextAlign.Justify,
                            modifier = Modifier.padding(horizontal = 15.dp)
                        )
                    }
                }
            }
            // payment
            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.6f)
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Payment",
                        fontSize = 21.sp,
                        fontFamily = Nunito_Sans,
                        fontWeight = FontWeight.SemiBold,
                        color = Color("#808080".toColorInt()),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Default.BorderColor,
                        contentDescription = "Close",
                        tint = Color("#909090".toColorInt()),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                            .clickable { /* Xử lý  */ }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    shape = RoundedCornerShape(7.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(3.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.mastercard),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(modifier = Modifier.width(30.dp))
                            Text(
                                text = "*** *** *** 888",
                                fontSize = 20.sp,
                                fontFamily = Nunito_Sans,
                                fontWeight = FontWeight.SemiBold,
                                color = Color("#303030".toColorInt()),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }
                    }
                }
            }
            // delevery method
            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.4f)
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Delivery method",
                        fontSize = 20.sp,
                        fontFamily = Nunito_Sans,
                        fontWeight = FontWeight.SemiBold,
                        color = Color("#808080".toColorInt()),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Default.BorderColor,
                        contentDescription = "Close",
                        tint = Color("#909090".toColorInt()),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                            .clickable { /* Xử lý  */ }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    shape = RoundedCornerShape(7.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(3.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ghn),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(60.dp)
                            )
                            Spacer(modifier = Modifier.width(30.dp))
                            Text(
                                text = "Fast (2-3days)",
                                fontSize = 20.sp,
                                fontFamily = Nunito_Sans,
                                fontWeight = FontWeight.SemiBold,
                                color = Color("#303030".toColorInt()),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }
                    }
                }
            }
            // info order
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .padding(15.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(7.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(3.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 20.dp,
                                        end = 20.dp,
                                        top = 10.dp,
                                        bottom = 10.dp
                                    )
                            ) {
                                Text(
                                    text = "Order:",
                                    fontSize = 20.sp,
                                    fontFamily = Nunito_Sans,
                                    fontWeight = FontWeight.Medium,
                                    color = Color("#808080".toColorInt()),
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "$150",
                                    fontSize = 20.sp,
                                    fontFamily = Nunito_Sans,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color("#242424".toColorInt()),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 20.dp,
                                        end = 20.dp,
                                        top = 10.dp,
                                        bottom = 10.dp
                                    )
                            ) {
                                Text(
                                    text = "Delivery:",
                                    fontSize = 20.sp,
                                    fontFamily = Nunito_Sans,
                                    fontWeight = FontWeight.Medium,
                                    color = Color("#808080".toColorInt()),
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "$5.0",
                                    fontSize = 20.sp,
                                    fontFamily = Nunito_Sans,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color("#242424".toColorInt()),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 20.dp,
                                        end = 20.dp,
                                        top = 10.dp,
                                        bottom = 10.dp
                                    )
                            ) {
                                Text(
                                    text = "Total:",
                                    fontSize = 20.sp,
                                    fontFamily = Nunito_Sans,
                                    fontWeight = FontWeight.Medium,
                                    color = Color("#808080".toColorInt()),
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "$155",
                                    fontSize = 20.sp,
                                    fontFamily = Nunito_Sans,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color("#242424".toColorInt()),
                                    textAlign = TextAlign.Center
                                )
                            }

                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {navController.navigate("success")},
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
                        text = "SUBMIT ORDER",
                        fontSize = 22.sp,
                        fontFamily = Nunito_Sans,
                        fontWeight = FontWeight.SemiBold,
                        color = Color("#ffffff".toColorInt()),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

    }
}