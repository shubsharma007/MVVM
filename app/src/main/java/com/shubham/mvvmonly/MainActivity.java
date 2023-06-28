package com.shubham.mvvmonly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.shubham.mvvmonly.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    //    APIServices apiServices;
    ViewModelS viewModelS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //apiServices = RetrofitInstance.getRetrofitClient().create(APIServices.class);

        binding.GO.setOnClickListener(v -> {
            viewModelS = new ViewModelProvider(this).get(ViewModelS.class);
            viewModelS.getCatFact().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    binding.rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    binding.rv.setAdapter(new AAdapter(MainActivity.this, s));
                }
            });

//            Call<Actor> call = apiServices.getActor();
//
//            call.enqueue(new Callback<Actor>() {
//
//                @Override
//                public void onResponse(@NonNull Call<Actor> call, @NonNull Response<Actor> response) {
//
//                    if (response.isSuccessful()) {
//
//                        assert response.body() != null;
//                        String fact = response.body().getFact();
//                        binding.rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                        binding.rv.setAdapter(new AAdapter(MainActivity.this, fact));
//
//                    } else {
//
//                        Toast.makeText(MainActivity.this, "oh Sorry!", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                }
//
//                @Override
//                public void onFailure(@NonNull Call<Actor> call, @NonNull Throwable t) {
//
//                    Toast.makeText(MainActivity.this, "Sorry!!!", Toast.LENGTH_SHORT).show();
//
//                }
//
//            });

        });

    }
}