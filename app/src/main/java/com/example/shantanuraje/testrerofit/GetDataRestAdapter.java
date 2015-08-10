package com.example.shantanuraje.testrerofit;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by Shantanuraje on 10-08-2015.
 */
public class GetDataRestAdapter {
    protected RestAdapter dataRestAdapter;
    protected IGetData getData;
    static final String SERVER_URL="http://192.168.1.8:8080";

    public GetDataRestAdapter(){
        dataRestAdapter=new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(SERVER_URL)
                .build();

        getData=dataRestAdapter.create(IGetData.class);


    }
    public void testServerConnection(Callback<String> callback){
        getData.testConnection(callback);
    }
}
