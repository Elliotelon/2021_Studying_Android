package com.elliot.step03box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elliot.step03box.ui.theme.StudyingTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BoxContainer()
                }
            }
        }
    }
}

// arrangement 요소를 어떤식 배열할지
// arrangement 는 Row, Column 같은 요소들이 들어가는
// 컨테이너성격의 콤포저블에서 요소들의 아이템을 정렬할 때 사용 됩니다.
// 웹 개발 css 에서 flex 와 비슷하다고 보시면 됩니다.

// horizontal Arranement 이니까 Start, End, Center 만 존재
//Arrangement.SpaceBetween : 공간 모두 차지
//Arrangement.Start : 왼쪽으로
//Arrangement.End : 오른쪽으로
//Arrangement.SpaceAround : 빈 공간을 남겨두기
//Arrangement.Center : 요소들에 넣기
//Arrangement.SpaceBetween : 사이에 공간을 밀어넣기
//Arrangement.SpaceEvenly : 요소들 사이에 공간을 똑같이 하기

// alignment 는 말그대로 해당 컨테이너 안에 들어있는 요소들의 위치를 어떠한 방향으로 정렬할지를 정합니다.
// linearLayout 에서 gravity 와 동일 하다고 보시면 됩니다.
// Alignment.Bottom : 컨테이너의 아래에 두기
// Alignment.Top : 컨테이너의 위에 두기
// 현재는 Row 콤포저블 안에서 align이 들어가기 때문에 Center Vertically
// Alignment.CenterVertically : 컨테이너의 수직방향으로 중앙에 두기


@Composable
fun BoxContainer(){
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        DummyBox(modifier = Modifier.size(200.dp), color = Color.Green)
        DummyBox(modifier = Modifier.size(150.dp), color = Color.Yellow)
        DummyBox(color = Color.Blue)
    }
}

@Composable
fun DummyBox(modifier : Modifier = Modifier, color : Color? = null){

    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)

    val randomColor = color?.let{ it } ?: Color(red, green, blue)
    Box(modifier = modifier
        .size(100.dp)
        .background(randomColor))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudyingTheme {
        BoxContainer()
    }
}