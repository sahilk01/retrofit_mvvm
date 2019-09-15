package com.elgigs.recyclermvvm.Remote;

import com.elgigs.recyclermvvm.Model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    public static final String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroesList();
}
