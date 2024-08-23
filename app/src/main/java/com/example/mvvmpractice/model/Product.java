package com.example.mvvmpractice.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {


    @SerializedName("title")
    public String title;

    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;
}
