package com.example.applifilm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun SeriesScreen(search:String){
    val viewModel: MainViewModel = viewModel()
    val series by viewModel.series.collectAsState()

    if (search.isNotEmpty()) {
        if (series.isEmpty()) viewModel.searchSeries(search)
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(series) { serie ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    val imageUrl = "https://image.tmdb.org/t/p/w780" + serie.backdrop_path
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = serie.name,
                        modifier = Modifier

                            .padding(end = 16.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = serie.original_name,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline,
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(6.dp)
                        ) {
                            Text(
                                text = "Détails",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }


                }
            }
        }
    } else {
        viewModel.lastSeries()
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(series) { serie ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    val imageUrl = "https://image.tmdb.org/t/p/w780" + serie.backdrop_path
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = serie.name,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = serie.original_name,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline,
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(6.dp)
                        ) {
                            Text(
                                text = "Détails",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}