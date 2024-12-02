package com.example.applifilm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

public class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<Movie>>(listOf())
    val series = MutableStateFlow<List<Serie>>(listOf())
    val actors = MutableStateFlow<List<Actor>>(listOf())
    val detailMovie = MutableStateFlow<DetailMovie?>(null)
    val apikey = "be1ca8af0da3936dcdb2aeaad464d374"
    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(Api::class.java)

    fun searchMovies(motcle: String) {
        viewModelScope.launch {
            try {
                val response = service.searchMovies(apikey, motcle)
                movies.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun lastMovies() {
        viewModelScope.launch {
            movies.value = service.lastMovies(apikey).results
        }
    }

    fun detailMovies(id:Int){
        viewModelScope.launch{
            detailMovie.value = service.detailMovie(id,apikey,"credits")
        }
    }

    fun searchSeries(motcle: String) {
        viewModelScope.launch {
            try {
                val response = service.searchSeries(apikey, motcle)
                series.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun lastSeries() {
        viewModelScope.launch {
            series.value = service.lastSeries(apikey).results
        }
    }

    fun searchActors(motcle: String) {
        viewModelScope.launch {
            try {
                val response = service.searchActors(apikey, motcle)
                actors.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun lastActors() {
        viewModelScope.launch {
            actors.value = service.lastActors(apikey).results
        }
    }
}