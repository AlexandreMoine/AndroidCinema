package com.epul.androidcinema.service;

import com.epul.androidcinema.domain.Movie;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceMovie {

    @GET("movie")
    Call<List<Movie>> getMovies();

}
