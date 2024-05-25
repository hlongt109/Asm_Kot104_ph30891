package com.ph30891.asm_ph30891.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
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
import com.ph30891.asm_ph30891.ui.theme.Gelasio
import com.ph30891.asm_ph30891.ui.theme.Merriweather
import com.ph30891.asm_ph30891.ui.theme.Nunito_Sans
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavController){
    val codeState = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ){
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
                    text = "My cart",
                    fontSize = 22.sp,
                    fontFamily = Merriweather,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            //  ds product
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(6.5f)
            ) {
                CartItem()
                CartItem()
                CartItem()
            }
            // checkout
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2.6f)
                    .padding(16.dp) // Khoảng cách lề
            ) {
                // Hàng chứa ô nhập mã
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier
                        .weight(7f)
                        .shadow( // Thêm đổ bóng
                            elevation = 1.dp, // Độ nâng của đổ bóng
                            shape = RoundedCornerShape(10.dp) // Hình dạng của đổ bóng
                        )
                    ){
                        OutlinedTextField(
                            label = { Text("Enter your promo code", color = Color("#999999".toColorInt()),modifier = Modifier.padding(bottom = 12.dp)) },
                            value = "",
                            onValueChange = { } ,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.White
                            )
                        )
                    }


                    // Nút mũi tên phải
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .shadow(1.dp, shape = RoundedCornerShape(8.dp))
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color("#242424".toColorInt()))
                            .width(60.dp)
                            .height(60.dp),
                    ) {
                        Icon(
                            Icons.Default.ArrowForwardIos,
                            contentDescription = null,
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp),
                            tint = Color("#FFFFFF".toColorInt())
                        )
                    }
                }
                // Hàng chứa tổng tiền
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Total:",
                        fontSize = 22.sp,
                        fontFamily = Nunito_Sans,
                        fontWeight = FontWeight.Bold,
                        color = Color("#808080".toColorInt()),
                        textAlign = TextAlign.Center)

                    Text(text = "$150",
                        fontSize = 22.sp,
                        fontFamily = Nunito_Sans,
                        fontWeight = FontWeight.Bold,
                        color = Color("#303030".toColorInt()),
                        textAlign = TextAlign.Center)
                }
                Spacer(modifier = Modifier.height(15.dp))
                // Nút Check out
                Button(
                    onClick = {navController.navigate("checkout")},
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
                        text = "Check out",
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


@Composable
fun CartItem() {
    val quantity = remember { mutableStateOf(1) }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),

    ) {
        // Hình ảnh vuông
        Image(
            painter = painterResource(id = R.drawable.hinh1), // Thay thế R.drawable.square_image bằng ID hình ảnh của bạn
            contentDescription = null, // Mô tả nội dung hình ảnh
            modifier = Modifier
                .size(120.dp)
                .aspectRatio(1f) // Đảm bảo hình ảnh là hình vuông
        )

        // Phần thông tin sản phẩm
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            // Tên sản phẩm
            Text(text = "Product Name",
                fontSize = 16.sp,
                fontFamily = Nunito_Sans,
                fontWeight = FontWeight.SemiBold,
                color = Color("#808080".toColorInt()))
            Spacer(modifier = Modifier.height(10.dp))

            // Giá sản phẩm
            Text(text = "$50",
                fontSize = 20.sp,
                fontFamily = Nunito_Sans,
                fontWeight = FontWeight.Bold,
                color = Color("#303030".toColorInt()))
            Spacer(modifier = Modifier.height(20.dp))
            // Số lượng
            Row(
                modifier = Modifier
                    .wrapContentWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        if (quantity.value > 1) quantity.value -= 1
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFE0E0E0))
                        .size(35.dp)
                ) {
                    Icon(Icons.Filled.Remove, contentDescription = "Remove")
                }

                Text(
                    text = quantity.value.toString(),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )


                IconButton(
                    onClick = {
                        quantity.value += 1
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFE0E0E0))
                        .size(35.dp)
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }

            }
        }

        // Icon đóng (icon x)
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            tint = Color.Gray, // Màu của icon
            modifier = Modifier
                .size(28.dp)
                .padding(4.dp)
                .clickable { /* Xử lý khi người dùng nhấn vào icon */ }
        )
    }
}