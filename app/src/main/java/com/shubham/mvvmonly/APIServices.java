package com.shubham.mvvmonly;

import com.shubham.mvvmonly.Model.Actor;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {

    @GET("fact")
    Call<Actor> getActor();

}
