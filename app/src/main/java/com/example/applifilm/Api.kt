package com.example.applifilm

import retrofit2.http.GET
import retrofit2.http.Query


interface Api {
    @GET("trending/movie/week")
    suspend fun lastMovies(@Query("api_key") apikey: String): TmdbMoviesResult

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apikey: String,
        @Query("query") motcle: String
    ): TmdbMoviesResult

    @GET("movie")
    suspend fun detailMovie(
        @Query("") id: Int,
        @Query("api_key") apikey: String,
        @Query("append_to_response") credits: String): DetailMovie

    @GET("trending/tv/week")
    suspend fun lastSeries(@Query("api_key") apikey: String): TmdbSeriesResult

    @GET("search/tv")
    suspend fun searchSeries(
        @Query("api_key") apikey: String,
        @Query("query") motcle: String
    ): TmdbSeriesResult

    @GET("trending/person/week")
    suspend fun lastActors(@Query("api_key") apikey: String): TmdbActorsResult

    @GET("search/person")
    suspend fun searchActors(
        @Query("api_key") apikey: String,
        @Query("query") motcle: String
    ): TmdbActorsResult
}

