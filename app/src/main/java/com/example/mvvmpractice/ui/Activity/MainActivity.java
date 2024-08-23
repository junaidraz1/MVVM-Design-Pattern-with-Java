package com.example.mvvmpractice.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmpractice.databinding.ActivityMainBinding;
import com.example.mvvmpractice.model.Product;
import com.example.mvvmpractice.ui.Adapter.ImageAdapter;
import com.example.mvvmpractice.R;
import com.example.mvvmpractice.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    MainActivityViewModel viewModel;
    List<Product> productList;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        productList = new ArrayList<>();
        imageAdapter = new ImageAdapter(productList, this);

        mainBinding.rvProductList.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.rvProductList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mainBinding.rvProductList.setAdapter(imageAdapter);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).
                create(MainActivityViewModel.class);

        viewModel.init(this);
        viewModel.getdata().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> productList) {
                if (productList != null) {
                    Log.e("TAG", "onChanged: " + productList.size());
                    imageAdapter.updateAdapter(productList);
                } else {
                    Toast.makeText(MainActivity.this, "List contains no data", Toast.LENGTH_SHORT).show();
                    Log.e("onfailure", "onChanged: Adapter is null");
                }
            }
        });
    }
}