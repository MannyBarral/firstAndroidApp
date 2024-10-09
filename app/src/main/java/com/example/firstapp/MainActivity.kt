package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstapp.ui.theme.FirstAppTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Manuel",
                        modifier = Modifier.padding(innerPadding)
                    )
//                    showText(
//                        text = "This is my first Android App",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
    }
}

@Composable
fun UserInputExample() {
    // Declare a state for managing the input text
    var text by remember { mutableStateOf("") }

    // Column to arrange elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // TextField for user input
        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Display the entered text
        Spacer(modifier = Modifier.height(16.dp)) // Space between input and text

        Text(
            text = "Hello, $text!",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun showText (text : String, modifier : Modifier = Modifier){
    Text(
        text = text,
        modifier = modifier
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Cyan) {
        Text(
            text = "Hello $name!",
            modifier = modifier.padding(24 .dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAppTheme {
        //Greeting("Matilde")
        UserInputExample()
    }
}