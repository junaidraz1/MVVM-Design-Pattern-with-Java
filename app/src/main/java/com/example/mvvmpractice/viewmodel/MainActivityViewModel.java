package com.example.mvvmpractice.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmpractice.model.Product;
import com.example.mvvmpractice.repository.ImageRepository;

import java.util.List;


public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Product>> listMutableLiveData;

    public void init(Context context) {
        if (listMutableLiveData != null) {
            return;
        }
        ImageRepository imageRepository = ImageRepository.getInstance();
        listMutableLiveData = imageRepository.getImages(context);
    }

    public LiveData<List<Product>> getdata() {
        return listMutableLiveData;
    }
}
