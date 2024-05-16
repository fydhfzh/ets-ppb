package com.fydhfzh.etsppb

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fydhfzh.etsppb.ui.theme.ETSPPBTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickPage(
    navigateToOrderDetail: () -> Unit,
    backToHomePage: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(
                text = "TIX",
                color = Color.Red,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge)
            })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(color = Color(0xFFFF5F5F))
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.movie7),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp))
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                    ) {
                        Text(text = "Star Wars: Rogue One", color = Color.White, fontSize = 15.sp)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Column(
                                verticalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier
                                    .height(120.dp)
                            ) {
                                Text(text = "Genre", color = Color.White, fontSize = 13.sp)
                                Text(text = "Durasi", color = Color.White, fontSize = 13.sp)
                                Text(text = "Sutradara", color = Color.White, fontSize = 13.sp)
                                Text(text = "Rating Usia", color = Color.White, fontSize = 13.sp)
                            }
                            Column(
                                verticalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 20.dp)
                                    .height(120.dp)
                            ) {
                                Text(text = "Action", color = Color.White, fontSize = 13.sp)
                                Text(text = "1 jam 50 menit", color = Color.White, fontSize = 13.sp)
                                Text(text = "Gareth Edwards", color = Color.White, fontSize = 13.sp)
                                Text(text = "13+", color = Color.White, fontSize = 13.sp)
                            }
                        }
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            DateList()
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            SeatGrid()
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(color = Color(0xFF6B6A6A), RoundedCornerShape(20))
                        .width(200.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Layar",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .wrapContentHeight()
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .height(50.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { navigateToOrderDetail() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5F5F)),
                    shape = RoundedCornerShape(
                        25, 25, 25, 25
                    )
                ) {
                    Text(text = "Lanjut ke Pembayaran", fontSize = 20.sp)
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateList(){
    val dateList = listOf(
        "16 Mei",
        "17 Mei",
        "18 Mei",
        "19 Mei",
        "20 Mei",
        "21 Mei",
        "22 Mei"
    )

    Column {
        Text(text = "Jadwal", fontWeight = FontWeight.Bold)
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            items(dateList) {item ->
                var isClick by remember {
                    mutableStateOf(false)
                }

                var cardColor = if(isClick) Color(0xFFFF5F5F) else Color.Transparent
                var textColor = if(isClick) Color.White else Color.Black

                OutlinedCard(
                    onClick = { isClick = !isClick},
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(70.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor)
                ) {
                    Text(
                        text = item,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(),
                        color = textColor
                    )
                }
            }
        }
    }
}

@Composable
fun SeatGrid(){
    val totalSection = 3

    Column {
        LazyRow(
            modifier = Modifier
                .padding(start = 10.dp)
        ) {
            items(totalSection) {section ->
                SeatSection(section)
                Spacer(
                    modifier = Modifier
                        .width(50.dp)
                )
            }
        }
    }
}

@Composable
fun SeatSection(
    section: Int
) {
    Column {
        repeat(4){row ->
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
//                modifier = Modifier
//                    .width(100.dp)
            ){
                repeat(4) { column ->
                    var isClick by remember {
                        mutableStateOf(false)
                    }

                    var buttonColor = if(isClick) Color(0xFFFF5F5F) else Color.Transparent
                    var textColor = if(isClick) Color.White else Color.Black

                    OutlinedButton(
                        onClick = { isClick = !isClick },
                        modifier = Modifier
                            .size(50.dp),
                        shape = RoundedCornerShape(
                            20, 20, 20, 20
                        ),
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                    ) {
                        Text(
                            text = "${section * 16 + 4 * row + column + 1}",
                            fontSize = 20.sp,
                            color = textColor
                        )
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun DatePickPagePreview(){
//    ETSPPBTheme {
//        DatePickPage()
//    }
//}