package com.example.introtocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // This function contains all the code.
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    val moneyCounter = remember {
        mutableStateOf(0)
    }
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF546E7A)
    ) {
        // Using a Column to order the components.
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // This Text shows the current value of the money counter.
            Text(text = "$${moneyCounter.value}", style = TextStyle(color = Color.White, fontSize = 35.sp, fontWeight = FontWeight.ExtraBold))
            // Spacer to add space between components.
            Spacer(modifier = Modifier.height(130.dp))
            // Calling the CreateCircle function and updating the value of money counter.
            CreateCircle(moneyCounter = moneyCounter.value) { newValue ->
                moneyCounter.value = newValue
            }
            // Spacer to add space between components.
            Spacer(modifier = Modifier.height(25.dp))
            // If the value of moneyCounter is greater than 25 we are going to display the following Text.
            if (moneyCounter.value>25){
                Text(text = "Lots of Money!", style = TextStyle(color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold))
            }
        }

    }
}

@Composable
fun CreateCircle(moneyCounter:Int = 0, updateMoneyCounter: (Int) -> Unit){

    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                // We are saying that we want the Card to be clickable.
                //moneyCounter += 1
                updateMoneyCounter(moneyCounter + 1)
            },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        // Using a box to center the Text vertically and horizontally.
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap", modifier = Modifier, style = TextStyle(color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroToComposeTheme {
        MyApp()
    }
}