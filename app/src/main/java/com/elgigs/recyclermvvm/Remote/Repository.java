package com.elgigs.recyclermvvm.Remote;

import com.elgigs.recyclermvvm.Model.Hero;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static Repository repository;

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    private Api api;

    public Repository() {
        api = RetroServices.CreateService(Api.class);
    }

    public MutableLiveData<List<Hero>> getHeroesBro() {
        final MutableLiveData<List<Hero>> heroesData = new MutableLiveData<>();

        api.getHeroesList().enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if (response.isSuccessful()) {
                    heroesData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                heroesData.setValue(null);
            }
        });

        return heroesData;

    }

}
