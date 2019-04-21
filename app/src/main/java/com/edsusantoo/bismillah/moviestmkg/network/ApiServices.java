package com.edsusantoo.bismillah.moviestmkg.network;

import com.edsusantoo.bismillah.moviestmkg.model.PopularResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("3/movie/popular?api_key=50ec555cc1d67559ec5eb1bff307acce&language=en-US&page=1")
    Call<PopularResponse> getPopularMovie();
}
