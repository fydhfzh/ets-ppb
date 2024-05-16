package com.fydhfzh.etsppb

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.fydhfzh.etsppb.ui.theme.ETSPPBTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    navigateToDatePick: () -> Unit,
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
            Text(
                text = "Sedang Tayang",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp

            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            MoviesCarousel(
                navigateToDatePick = navigateToDatePick
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Divider(color = Color.LightGray, thickness = 2.dp)
            MovieNews()

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesCarousel(
    navigateToDatePick: () -> Unit
){
    val movies = listOf(
        painterResource(id = R.drawable.movie1),
        painterResource(id = R.drawable.movie2),
        painterResource(id = R.drawable.movie3),
        painterResource(id = R.drawable.movie4),
        painterResource(id = R.drawable.movie5),
        painterResource(id = R.drawable.movie6),
        painterResource(id = R.drawable.movie7),
        painterResource(id = R.drawable.movie8)
    )

    val moviesDescription = listOf(
        stringResource(id = R.string.movie1),
        stringResource(id = R.string.movie2),
        stringResource(id = R.string.movie3),
        stringResource(id = R.string.movie4),
        stringResource(id = R.string.movie5),
        stringResource(id = R.string.movie6),
        stringResource(id = R.string.movie7),
        stringResource(id = R.string.movie8)
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(movies) {movie ->
            Card(
                onClick = { navigateToDatePick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(180.dp)
            ) {
                Image(
                    painter = movie,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(300.dp)
                )
            }
        }
    }
}

@Composable
fun MovieNews(){
    val newsHeader = "Film A berhasil mendapatkan 10 juta tayangan dalam 2 hari"
    val news = "Menurut sutradara film A, perolehan tayangan tersebut merupakan peran penting dari semua aktor yang berperan didalamnya"

    Column {
        Text(text = "News", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()  //important
                    .width(4.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(text = newsHeader, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = news)
            }
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()  //important
                    .width(4.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(text = newsHeader, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = news)
            }
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()  //important
                    .width(4.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(text = newsHeader, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = news)
            }
        }
    }
}

//@Preview
//@Composable
//fun HomePagePreview(){
//    ETSPPBTheme {
//        HomePage()
//    }
//}