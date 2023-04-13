package com.example.homework4.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homework4.presentation.composables.ArticleView
import com.example.homework4.presentation.theme.Homework4Theme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<DataLoaderViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(viewModel = viewModel)
        }
    }
}

@Composable
fun HomeScreen(viewModel: DataLoaderViewModel) {
    val articles = viewModel.articles.observeAsState(emptyList())
    var search by remember { mutableStateOf("") }
    LaunchedEffect(key1 = Unit) {
        viewModel.loadNews()
    }
    Homework4Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            Column {
                Text(
                    "News",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(37, 49, 91))
                        .padding(8.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(37, 49, 91))
                        .padding(8.dp),
                ) {
                    TextField(
                        value = search,
                        onValueChange = { search = it },
                        modifier = Modifier.weight(1f),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                            )
                        },
                        placeholder = { Text(text = "Search") },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                    )
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Preferences",
                            tint = Color.White,
                        )
                    }
                }
                LazyColumn {
                    items(articles.value) {
                        ArticleView(article = it)
                    }
                }
            }
        }
    }
}
