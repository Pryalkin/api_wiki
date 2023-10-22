package com.bsuir.wikipedia.app.screen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsuir.wikipedia.app.model.item.WikiPage

@Composable
fun DetailScreen(
    num: WikiPage
){
    Surface(
        color = MaterialTheme.colors.onSecondary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ){
        Column(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(6.dp),
                ) {
                    Text(text = "Pageid: ${num.pageid}",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Title: ${num.title}",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Content model: ${num.contentmodel}",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)

                }
            }
        }
    }
}