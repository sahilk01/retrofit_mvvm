package com.elgigs.recyclermvvm.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.elgigs.recyclermvvm.Remote.Api.BASE_URL;

public class RetroServices {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S CreateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
