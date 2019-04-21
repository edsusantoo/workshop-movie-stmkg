package com.edsusantoo.bismillah.moviestmkg.network;

import retrofit2.Retrofit;

public class RetrofitConfig {

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .build();
    }

    public static ApiServices getApiServices() {

        return getRetrofit().create(ApiServices.class);
    }


}
