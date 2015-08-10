package com.example.shantanuraje.testrerofit;

import retrofit.Callback;
import retrofit.http.GET;

public interface IGetData {
    @GET("/")
    void testConnection(Callback<String> dataCallback);
}