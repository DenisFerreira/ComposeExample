package com.example.denisferreira.composeexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.denisferreira.composeexample.ui.theme.ComposeExampleTheme
import com.example.denisferreira.composeexample.ui.theme.Purple200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn(){
                        items(5) {
                            FeedItem()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomText(@StringRes textResID: Int) {
    Text(
        text = stringResource(id = textResID),
        color = Purple200,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                Log.d("Welcome", "click")
            }

    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme {
        FeedItem()
    }
}

@Composable
fun FeedItem() {
    Column(
        modifier = Modifier.border(border = BorderStroke(width = 1.dp, Color.Black))
    ) {
        Card(elevation = 8.dp) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.thumbnail),
                    contentDescription = stringResource(id = R.string.thumbnail),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)

                )
                Text(
                    text = "26:15",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp, 8.dp)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.selfie),
                contentDescription = stringResource(
                    R.string.profile_description
                ),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp),


                )
            Column {
                Text(
                    text = "Nome do vídeo",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.size(8.dp))
                Row {
                    Text(
                        text = "Nome do canal",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = " | #### views",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = " | tempo de publicação",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )

                }

            }

        }
    }
}