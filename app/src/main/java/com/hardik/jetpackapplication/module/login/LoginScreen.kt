package com.hardik.jetpackapplication.module.login

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hardik.jetpackapplication.FORGOT_PASSWORD_ROUTE
import com.hardik.jetpackapplication.R
import com.hardik.jetpackapplication.REGISTER_ROUTE
import com.hardik.jetpackapplication.ui.component.AppTextField
import com.hardik.jetpackapplication.ui.theme.Blue


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordObscure by remember { mutableStateOf(true) }
    Scaffold() {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.ill_sign_in_amico),
                contentDescription = "Sing in Illumination",
                modifier = Modifier
                    .weight(3f)
                    .padding(
                        horizontal = 32.dp
                    ),
                contentScale = ContentScale.Fit
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(7f)
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
                AppTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    hint = "Email Address",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "Email Field",
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) }),
                )
                AppTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    hint = "Password",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Password Field",
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = if (passwordObscure) painterResource(id = R.drawable.ic_outline_visibility) else painterResource(
                                id = R.drawable.ic_outline_visibility_off
                            ), contentDescription = "Show password",
                            modifier = Modifier.clickable {
                                passwordObscure = !passwordObscure
                            }
                        )
                    },
                    obscure = passwordObscure,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }
                    ),
                )
                TextButton(
                    onClick = {
                        navController.navigate(FORGOT_PASSWORD_ROUTE)
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Forgot Password ?")
                }
                Button(
                    onClick = { }, shape = RoundedCornerShape(16.dp), modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Login", style = MaterialTheme.typography.bodyMedium)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(), verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(modifier = Modifier.weight(1f))
                    Text(
                        text = "OR",
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Divider(modifier = Modifier.weight(1f))
                }
                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "",
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Box(modifier = Modifier.width(32.dp))
                    Text(
                        text = "Login with Google",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Don't have an account", style = MaterialTheme.typography.bodyMedium)
                    Box(modifier = Modifier.width(8.dp))                        
                    Text(text = "Register Here !", style = MaterialTheme.typography.bodyMedium.copy(color = Blue), modifier = Modifier.clickable {
                        navController.navigate(REGISTER_ROUTE)
                    })

                }
            }
        }
    }
}