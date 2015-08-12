package com.example.shantanuraje.testrerofit;

import retrofit.Callback;
import retrofit.http.GET;

public interface IGetData {
    @GET("/players")
    void testConnection(Callback<String> dataCallback);

//    @POST()
}