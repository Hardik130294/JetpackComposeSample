package com.hardik.jetpackapplication

import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hardik.jetpackapplication.ui.pages.minesweeper.MinesweeperScreen
import com.hardik.jetpackapplication.ui.pages.minesweeper.MinesweeperViewModel
import com.hardik.jetpackapplication.ui.theme.JetpackApplicationTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    JetpackApplicationTheme {
        val gameViewModel: MinesweeperViewModel = viewModel()
        val gameState by gameViewModel.gameState.collectAsState()

        MinesweeperScreen(
            gameState = gameState,
            onClick = { cell ->
                gameViewModel.onClickCell(cell)
            },
            onLongClick = { cell ->
                gameViewModel.onLongClickCell(cell)
            },
            onResetClicked = {
                gameViewModel.resetGame()
            }
        )
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Box(modifier = Modifier.padding(15.dp),contentAlignment = Alignment.Center) {
//                contentColorFor(backgroundColor = Color.Yellow)
//                Greeting()
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting() {
    Button(onClick = {}, modifier = Modifier.padding(15.dp)) {
        Text(
            text = "Hello!",
            modifier = Modifier
        )
    }
}
