package com.bsuir.wikipedia.app.screen.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bsuir.wikipedia.Singletons
import com.bsuir.wikipedia.app.screen.item.DataItem

@Composable
fun HomeContext(
    navController: NavController
) {
    val viewModel = Singletons.appViewModel
    val obj = viewModel.obj.observeAsState()
    val message = remember{mutableStateOf("")}
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextField(
                value = message.value,
                textStyle = TextStyle(fontSize=25.sp),
                onValueChange = {newText -> message.value = newText}
            )
            Button(onClick = {
                viewModel.getAll(message.value)
            }){
                Text("Find", fontSize = 25.sp)
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            obj.value?.query?.let {
                items(items = it.search) { s ->
                    DataItem(data = s, navController = navController)
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun HomeContextPreview() {
    HomeContext(navController = rememberNavController())
}