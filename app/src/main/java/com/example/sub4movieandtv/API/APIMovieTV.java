package com.example.sub4movieandtv.API;

import com.example.sub4movieandtv.Model.MovieRespon;
import com.example.sub4movieandtv.Model.TVRespon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIMovieTV {

    @GET("discover/movie")
    Call<MovieRespon> getMovieList(
            @Query("api_key") String apikey,
            @Query("language") String language);

    @GET("discover/tv")
    Call<TVRespon> getTVList(
            @Query("api_key") String apikey,
            @Query("language") String language);

}