package com.hardik.jetpackapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hardik.jetpackapplication.module.forgot_password.ForgotPasswordScreen
import com.hardik.jetpackapplication.module.login.LoginScreen
import com.hardik.jetpackapplication.module.register.RegisterScreen
import com.hardik.jetpackapplication.module.reset_password.ResetPasswordScreen
import com.hardik.jetpackapplication.ui.theme.JetpackApplicationTheme

const val LOGIN_ROUTE = "/login"
const val REGISTER_ROUTE = "/register"
const val FORGOT_PASSWORD_ROUTE = "/forgot-password"
const val RESET_PASSWORD_ROUTE = "/reset-password"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            JetpackApplicationTheme {
                NavHost(navController = navController, startDestination = LOGIN_ROUTE){
                    composable(LOGIN_ROUTE) {
                        LoginScreen(navController = navController)
                    }
                    composable(REGISTER_ROUTE) {
                        RegisterScreen(navController = navController)
                    }
                    composable(FORGOT_PASSWORD_ROUTE) {
                        ForgotPasswordScreen(navController = navController)
                    }
                    composable(RESET_PASSWORD_ROUTE) {
                        ResetPasswordScreen(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
}