package com.fydhfzh.etsppb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fydhfzh.etsppb.ui.theme.ETSPPBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ETSPPBTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login_page") {
                    composable(
                        route = "login_page"
                    ) {
                        LoginPage(
                            navigateToHomePage = {
                                navController.navigate("home_page")
                            }
                        )
                    }
                    composable(
                        route = "home_page"
                    ){
                        HomePage(
                            navigateToDatePick = {
                                navController.navigate("date_pick_page")
                            }
                        )
                    }
                    composable(
                        route = "date_pick_page"
                    ){
                        DatePickPage(
                            navigateToOrderDetail = {
                                navController.navigate("order_detail_page")
                            },
                            backToHomePage = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(
                        route = "order_detail_page"
                    ){
                        OrderDetailPage(
                            navigateToOrderDetail = {
                                navController.navigate("invoice_page")
                            },
                            backToDatePick = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(
                        route = "invoice_page"
                    ){
                        InvoicePage(
                            backToHomePage = {
                                navController.navigate("home_page")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ETSPPBTheme {
        Greeting("Android")
    }
}