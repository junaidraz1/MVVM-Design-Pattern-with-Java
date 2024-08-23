package com.example.mvvmpractice.network;

import com.example.mvvmpractice.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/photos")
    Call<List<Product>> getData();

}
