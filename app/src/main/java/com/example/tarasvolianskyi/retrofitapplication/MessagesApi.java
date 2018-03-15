package com.example.tarasvolianskyi.retrofitapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by tarasvolianskyi on 15.03.18.
 */

public interface MessagesApi {

    @GET("messages1.json")
    Call<List<Message>> messages();
}
