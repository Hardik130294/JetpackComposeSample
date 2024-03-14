package com.hardik.jetpackapplication.module.reset_password

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.hardik.jetpackapplication.R
import com.hardik.jetpackapplication.ui.component.AppTextField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current

    var password by remember { mutableStateOf("") }
    var passwordObscure by remember { mutableStateOf(true) }
    var passwordConfirm by remember { mutableStateOf("") }
    var passwordConfirmObscure by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button")
                }
//                Text(
//                    text = "Forgot Password",
//                    style = MaterialTheme.typography.titleLarge,
//                    color = MaterialTheme.colorScheme.onBackground,
//                    modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ){
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.ill_reset_password),
                contentDescription = "Reset Password Illumination",
                modifier = Modifier
                    .weight(4.5f)
                    .padding(
                        horizontal = 32.dp
                    ),
                contentScale = ContentScale.Fit
            )
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(5.5f)
            ) {
                Text(
                    text = "Reset\nPassword ?",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
                Box(modifier = Modifier.height(16.dp))
                AppTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    hint = "New Password",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "New Password Field",
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = if (passwordObscure) painterResource(id = R.drawable.ic_outline_visibility) else painterResource(
                                id = R.drawable.ic_outline_visibility_off
                            ), contentDescription = "Show New password",
                            modifier = Modifier.clickable {
                                passwordObscure = !passwordObscure
                            }
                        )
                    },
                    obscure = passwordObscure,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                        FocusDirection.Next) }
                    ),
                )
                Box(modifier = Modifier.height(16.dp))
                AppTextField(
                    value = passwordConfirm,
                    onValueChange = {
                        passwordConfirm = it
                    },
                    hint = "Re-enter New Password",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Re-enter New Password Field",
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = if (passwordConfirmObscure) painterResource(id = R.drawable.ic_outline_visibility) else painterResource(
                                id = R.drawable.ic_outline_visibility_off
                            ), contentDescription = "Show Re-entered New password",
                            modifier = Modifier.clickable {
                                passwordConfirmObscure = !passwordConfirmObscure
                            }
                        )
                    },
                    obscure = passwordConfirmObscure,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }
                    ),
                )
                Box(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Submit", style = MaterialTheme.typography.bodyMedium)
                }
                Box(modifier = Modifier.height(16.dp))
            }
        }
    }
}