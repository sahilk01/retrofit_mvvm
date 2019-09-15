package com.elgigs.recyclermvvm.viewmodel;

import com.elgigs.recyclermvvm.Model.Hero;
import com.elgigs.recyclermvvm.Remote.Repository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HeroesViewModel extends ViewModel {

       private MutableLiveData<List<Hero>> mutableLiveData;
       private Repository repository;

       public void init() {
          if (mutableLiveData!=null) {
              return;
          }
          repository = Repository.getInstance();
          mutableLiveData = repository.getHeroesBro();
       }

       public LiveData<List<Hero>> getRepository() {
           return mutableLiveData;
       }
}
