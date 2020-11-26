package com.abdulwahabfaiz.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abdulwahabfaiz.retrofit.api.RetrofitClient;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtGet, txtPost;
    Button   btnGet, btnPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        //Get Button On Click
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUser();
            }
        });

        //Post Button On Click
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postUser();
            }
        });

    }

    void init(){
        //TextView
        txtGet  = findViewById(R.id.textView);
        txtPost = findViewById(R.id.txtPost);

        //Button
        btnGet   = findViewById(R.id.btnGet);
        btnPost  = findViewById(R.id.btnPost);
    }

    //  Getting
    // User Data
    // From Web Api
    public void getUser()
    {
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getUser();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String Response = response.body().string();
                    Log.e("Get Data Response",Response+"");

                    txtGet.setText("Get Request Response \n"+Response);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    // Posting Request
    // For Creating New User
    public void  postUser()
    {
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .postUser("Abdul Wahab Faiz", "Android Developer");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String postResponse = response.body().string();

                    Log.e("Post Response",postResponse+"");

                    txtPost.setText("Post Request Response \n"+postResponse);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

}