package com.myfirst.unit_iisprint_4coding;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("v1/us/daily.json")
    Call<List<ResponseCovid>> getPosts();

}
