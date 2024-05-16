package com.fydhfzh.etsppb

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.fydhfzh.etsppb.ui.theme.ETSPPBTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navigateToHomePage: () -> Unit
){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(
                text = "TIX",
                color = Color.Red,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge)
            })
        },
        bottomBar = {
            CenterAlignedTopAppBar(title = { Text(
                text = buildAnnotatedString {
                    append("Butuh bantuan? Hubungi kami di ")
                    withStyle(
                        SpanStyle(
                            color = Color.Blue
                        )
                    ){
                        append("Layanan Pelanggan")
                    }
                },
                fontSize = 10.sp
            ) })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .height(150.dp)
            )
            Text(
                text = "Log In",
                fontSize = 30.sp,
                letterSpacing = 3.sp
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )
            LoginField(
                navigateToHomePage = navigateToHomePage
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginField(
    modifier: Modifier = Modifier,
    navigateToHomePage: () -> Unit
){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = "Email",
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier
                .height(40.dp)
        )
        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
            ),
            placeholder = {
                Text(
                    text = "Masukkan email",
                    color = Color.LightGray,
                    fontSize = 20.sp
                )
            },
            singleLine = true
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Text(
            text = "Password ",
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier
                .height(40.dp)
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.White,
            ),
            placeholder = {
                Text(
                    text = "Masukkan password",
                    color = Color.LightGray,
                    fontSize = 20.sp
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true
        )
        Spacer(
            modifier = Modifier
                .height(25.dp)
        )
        Text(text = buildAnnotatedString {
            append("Lupa password? ")
            withStyle(style = SpanStyle(
                fontWeight = FontWeight.SemiBold
            )){
                append("Reset Password")
            }
        },
            fontSize = 15.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        LogInButton(
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            navigateToHomePage
        )
    }
}

@Composable
fun LogInButton(
    modifier: Modifier = Modifier,
    navigateToHomePage: () -> Unit
){
    Button(
        onClick = { navigateToHomePage() },
        modifier = modifier
            .width(200.dp),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5A5A))
    ) {
        Text(
            text = "Log In",
            fontSize = 20.sp
            )
    }
}