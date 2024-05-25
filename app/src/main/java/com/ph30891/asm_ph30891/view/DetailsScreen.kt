package com.ph30891.asm_ph30891.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.ph30891.asm_ph30891.ui.theme.Gelasio
import com.ph30891.asm_ph30891.ui.theme.Nunito_Sans

@Composable
fun DetailsScreen(product: Product, navController: NavController) {
    val scrollState = rememberScrollState()
    val selectedClassifyIndex = remember { mutableStateOf(0) }
    val lazyListState = rememberLazyListState()
    val quantity = remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
             .fillMaxWidth()
             .fillMaxHeight()
             .background(Color("#f5f5f5".toColorInt())),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                 .fillMaxWidth()
                 .fillMaxHeight(0.5f)
                 .background(Color("#f5f5f5".toColorInt()))
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
//               horizontalAlignment = Alignment.CenterHorizontally,
//               verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    // button back và column button select màu
                    Box(
                        modifier = Modifier
                             .weight(1f)
                             .padding(start = 15.dp)
                    ) {
                        LazyRow(
                            modifier = Modifier
                                 .fillMaxWidth()
                                 .fillMaxHeight(0.5f)
                                 .padding(start = 30.dp)
                                 .clip(RoundedCornerShape(bottomStart = 35.dp)),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            itemsIndexed(product.productClassify) { index, classify ->
                                Box(
                                    modifier = Modifier
                                         .clickable { selectedClassifyIndex.value = index }
                                         .padding(horizontal = 5.dp)
                                ) {
                                    ImageItem(imageUrl = classify.photo)
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                 .height(350.dp)
                                 .statusBarsPadding(),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            BackButton(navController)
                            ColorSelectionButtons(
                                product = product,
                                selectedClassifyIndex = selectedClassifyIndex
                            )
                        }

                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                 .fillMaxSize()
                 .fillMaxHeight(0.5f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                     .fillMaxWidth()
                     .fillMaxHeight()
                     .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                         .fillMaxWidth()
                         .fillMaxHeight()
                         .weight(7.5f)
                         .verticalScroll(scrollState)
                ) {
                    Text(
                        modifier = Modifier,
                        text = product.name,
                        fontSize = 24.sp,
                        fontFamily = Gelasio,
                        fontWeight = FontWeight.Medium,
                        color = Color("#303030".toColorInt())
                    )
                     Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier,
                            text = product.price,
                            fontSize = 30.sp,
                            fontFamily = Nunito_Sans,
                            fontWeight = FontWeight.Bold,
                            color = Color("#303030".toColorInt())
                        )
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
                     Spacer(modifier = Modifier.height(10.dp))
                     Row(
                          modifier = Modifier
                               .wrapContentWidth(),
                          horizontalArrangement = Arrangement.Center,
                          verticalAlignment = Alignment.CenterVertically
                     ) {
                          Icon(
                               Icons.Default.Star,
                               contentDescription = null,
                               modifier = Modifier.size(30.dp),
                               tint = Color("#f2c94c".toColorInt())
                          )

                          Text(
                               text = "4.5",
                               fontSize = 18.sp,
                               modifier = Modifier.padding(start = 4.dp),
                               fontFamily = Nunito_Sans,
                               fontWeight = FontWeight.Bold,
                               color = Color("#303030".toColorInt()),
                          )
                          Spacer(modifier = Modifier.width(30.dp))
                          Text(
                               text = "(100 reviews)",
                               fontSize = 16.sp,
                               modifier = Modifier.padding(start = 8.dp),
                               fontFamily = Nunito_Sans,
                               fontWeight = FontWeight.SemiBold,
                               color = Color("#808080".toColorInt())
                          )

                     }
                     Spacer(modifier = Modifier.height(10.dp))
                     Text(
                          text = product.description,
                          fontFamily = Nunito_Sans,
                          fontWeight = FontWeight.Light,
                          color = Color("#606060".toColorInt()),
                          fontSize = 16.sp,
                          textAlign = TextAlign.Justify
                     )
                }
                Row(
                    modifier = Modifier
                         .fillMaxWidth()
                         .fillMaxHeight()
                         .weight(2.5f)
                         .padding(top = 10.dp),
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                             .shadow(1.dp, shape = RoundedCornerShape(8.dp))
                             .background(Color(0xFFF0F0F0))
                             .width(60.dp)
                             .height(60.dp),
                    ) {
                        Image(
                            Icons.Default.BookmarkBorder,
                            contentDescription = null,
                            modifier = Modifier
                                 .width(24.dp)
                                 .height(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = {navController.navigate("cart")},
                        modifier = Modifier
                             .fillMaxWidth()
                             .height(60.dp)
                             .shadow(4.dp, shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(10.dp),
                            text = "Add to cart",
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

}

@Composable
fun BackButton(navController: NavController) {
    IconButton(
        onClick = { navController.popBackStack() },
        modifier = Modifier
             .clip(RoundedCornerShape(10.dp))
             .background(Color("#ffffff".toColorInt()))

    ) {
        Icon(Icons.Default.ArrowBackIosNew, contentDescription = null)
    }
}

@Composable
fun ColorSelectionButtons(product: Product, selectedClassifyIndex: MutableState<Int>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
             .clip(RoundedCornerShape(20.dp))
             .background(Color("#ffffff".toColorInt()))
    ) {
        product.productClassify.forEachIndexed { index, classify ->
            ColorButton(
                color = classify.color,
                isSelected = selectedClassifyIndex.value == index,
                onClick = { selectedClassifyIndex.value = index }
            )
        }
    }
}

@Composable
fun ColorButton(color: String, isSelected: Boolean, onClick: () -> Unit) {
    val borderColor =
        if (isSelected) Color("#999999".toColorInt()) else Color("#efefef".toColorInt())
    Box(
        modifier = Modifier
             .padding(10.dp)
             .size(30.dp)
             .clip(RoundedCornerShape(20.dp))
             .background(Color(color.toColorInt()))
             .border(3.dp, borderColor, RoundedCornerShape(20.dp))
             .clickable { onClick() }

    )
}

@Composable
fun ImageItem(imageUrl: String) {
    Image(
        painter = rememberImagePainter(data = imageUrl),
        contentDescription = null,
        modifier = Modifier
             .width(400.dp)
             .height(470.dp)
             .clip(RoundedCornerShape(bottomStart = 15.dp))
             .background(Color.LightGray),
        contentScale = ContentScale.Crop
    )
}
//                         Row(
//                              modifier = Modifier
//                                   .fillMaxWidth()
//                                   .height(450.dp)
//                                   .horizontalScroll(rememberScrollState())
//                                   .padding(horizontal = 30.dp),
//                              horizontalArrangement = Arrangement.Center,
//                              verticalAlignment = Alignment.Bottom,
//                         ) {
//                              product.productClassify.forEachIndexed { index, _ ->
//                                   Box(
//
//                                        modifier = Modifier
//                                             .width(
//                                                  if (selectedClassifyIndex.value == index) 35.dp
//                                                  else 20.dp
//                                             )
//                                             .height(7.dp)
//                                             .clip(RoundedCornerShape(10.dp))
//                                             .background(
//                                                  if (selectedClassifyIndex.value == index) Color.Black
//                                                  else Color.White
//                                             )
//
//                                   )
//                              }
//                         }

//@Preview(showBackground = true)
//@Composable
//fun PreviewDetails(){
//    DetailsScreen()
//}