package com.example.mvvmpractice.repository;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmpractice.model.Product;
import com.example.mvvmpractice.network.APIClient;
import com.example.mvvmpractice.network.APIService;
import com.example.mvvmpractice.utils.Constants;

import java.util.AbstractList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageRepository {

    public static ImageRepository instance;
    private MutableLiveData<List<Product>> productList;

    public ImageRepository() {
        productList = new MutableLiveData<>();
    }

    public static ImageRepository getInstance() {
        if (instance == null) {
            instance = new ImageRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Product>> getImages(Context context) {

        productList = new MutableLiveData<>();

        APIService apiService = APIClient.getClient(context, Constants.BASE_URL).create(APIService.class);

        Call<List<Product>> call = apiService.getData();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                productList.postValue(response.body());
                Log.e("TAG", "onResponse: productlist size: " + productList);
            }

            @Override
            public void onFailure(@NonNull Call<List<Product>> call, @NonNull Throwable t) {
                productList.postValue(null);
                Log.e("onfailure", "onFailure: Api error");
            }
        });
        return productList;
    }
}
