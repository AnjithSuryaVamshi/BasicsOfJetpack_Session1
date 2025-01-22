package com.example.session1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.session1.ui.theme.Session1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Session1Theme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    //explain about state
    var count by remember {
        mutableStateOf(0)
    }

    //Explain about row  and column
    Column(
        //Explain about modifier
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {



        //Text
        Text(
            text = "Counter App",
            modifier = modifier

        )




        Text(
            text = count.toString(),
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { if (count > 0) count-- }) {
            Text(text = "Decrement")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count = 0 }) {
            Text(text = "Reset")
        }

        Spacer(modifier = Modifier.height(16.dp))



        //Button
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
            )
        ) {
            Text(
                text = "Navigate",
                color = Color.Cyan,
                fontSize = 20.sp,

                )
        }



        //Image
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(280.dp)
                .clip(RoundedCornerShape(10.dp))
        )




        //Text field
        var text by remember {
            mutableStateOf("")
        }
        OutlinedTextField(text, onValueChange = { text =it },label = {Text("Enter your name")})
        if (count == 5) {
            Toast.makeText(context, "Reached 5", Toast.LENGTH_SHORT).show()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Session1Theme {
        Greeting()
    }
}