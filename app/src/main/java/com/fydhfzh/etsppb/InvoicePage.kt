package com.fydhfzh.etsppb

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
fun InvoicePage(
    backToHomePage: () -> Unit,
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
        ){
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
            ){
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colorStops = arrayOf(
                                0.5f to Color.White,
                                0.2f to Color(0xFFFF5F5F),
                                0.1f to Color.Red
                            ),
                            start = Offset(Float.POSITIVE_INFINITY, 0f),
                            end = Offset(0f, Float.POSITIVE_INFINITY)
                        )
                    )){
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                        ) {
                            Spacer(modifier = Modifier.width(200.dp))
                            Column(
                                modifier = Modifier
                                    .padding(top =20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Scan Here!", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.height(10.dp))
                                Image(painter = painterResource(id = R.drawable.barcode), contentDescription = null)
                            }
                        }
                        Row {
                            Column(
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Text(text = "Star Wars: Rouge One", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                                Row(
                                    modifier = Modifier
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(10.dp)
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
                                        Text(text = "Total", fontSize = 13.sp)
                                    }
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 20.dp)
                                            .fillMaxHeight(),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(text = "17 Mei 2024", fontSize = 13.sp)
                                        Text(text = "12", fontSize = 13.sp)
                                        Text(text = "Rp50.000", fontSize = 13.sp)
                                        Text(text = "Rp2.000", fontSize = 13.sp)
                                        Text(text = "Rp52.000", fontSize = 13.sp)
                                    }
                                }
                            }
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { backToHomePage() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5F5F)),
                    shape = RoundedCornerShape(10.dp),
//                contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Kembali",
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

//@Preview
//@Composable
//fun InvoicePagePreview(){
//    ETSPPBTheme {
//        InvoicePage()
//    }
//}