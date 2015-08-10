package com.example.shantanuraje.testrerofit;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    TextView tvText;
    Button btGetData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText=(TextView)findViewById(R.id.tvText);
        btGetData=(Button)findViewById(R.id.btGetData);
        btGetData.setOnClickListener(this);


    }
    void updateUXWithWeatherData (String data) {
        tvText.setText(data);
    }
    @Override
    public void onClick(View view) {
//        final String data="";
        GetDataRestAdapter getDataRestAdapter;
//        IGetData getData;
        Callback<String> dataCallback=new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d("TAG", "success" + s);
//                data=s;
                updateUXWithWeatherData(s);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("TAG","failure" +error.getUrl());
            }
        };
        getDataRestAdapter=new GetDataRestAdapter();
        getDataRestAdapter.testServerConnection(dataCallback);

    }
}


