package com.fydhfzh.etsppb

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fydhfzh.etsppb.ui.theme.ETSPPBTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailPage(
    navigateToOrderDetail: () -> Unit,
    backToDatePick: () -> Unit
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
                .fillMaxSize()
                .padding(it)
                .padding(10.dp)
        ) {
            Card(
                border = BorderStroke(1.dp, color = Color.Black),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(5.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.movie7),
                            contentDescription = null,
                            modifier = Modifier
                                .size(400.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ){
                        Text(text = "Star Wars: Rogue One")
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                        Row(
                            modifier = Modifier
                                .height(120.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Tanggal", fontSize = 13.sp)
                                Text(text = "Kursi", fontSize = 13.sp)
                                Text(text = "Harga", fontSize = 13.sp)
                                Text(text = "Biaya Layanan", fontSize = 13.sp)
                                Text(text = "Total Harga", fontSize = 13.sp)
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(start = 10.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "17 Mei",
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .fillMaxWidth())
                                Text(text = "12",
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .fillMaxWidth())
                                Text(text = "Rp50.000",
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .fillMaxWidth())
                                Text(text = "Rp2.000",
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .fillMaxWidth())
                                Text(text = "Rp52.000",
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .fillMaxWidth())
                            }
                        }
                    }
                }
                Row {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.iconqris),
                            contentDescription = null,
                            modifier = Modifier
                                .width(150.dp)
                                .height(50.dp))
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.qr),
                            contentDescription = null,
                            modifier = Modifier
                                .size(150.dp))
                        Spacer(
                            modifier = Modifier
                                .height(20.dp)
                        )
                        Button(
                            onClick = { navigateToOrderDetail() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5F5F)),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "Bayar",
                                color = Color.White,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(30.dp)
                                    .fillMaxHeight())
                        }
                    }
                }
            }
        }

    }
}

//@Preview
//@Composable
//fun OrderDetailPagePreview(){
//    ETSPPBTheme {
//        OrderDetailPage()
//    }
//}