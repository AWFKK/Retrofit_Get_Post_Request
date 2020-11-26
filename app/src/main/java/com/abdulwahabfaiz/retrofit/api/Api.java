package com.abdulwahabfaiz.retrofit.api;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {



    //For Get Data
    @GET("users/2")
    Call<ResponseBody> getUser();

    //For Post Data
    @FormUrlEncoded
    @POST("users")
    Call<ResponseBody>postUser
        (
                @Field("name") String name,
                @Field("job")  String job
        );

}
