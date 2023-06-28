package com.shubham.mvvmonly;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shubham.mvvmonly.Model.Actor;
import com.shubham.mvvmonly.Retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelS extends AndroidViewModel {

    APIServices apiServices;
    MutableLiveData<String> fact;

    public ViewModelS(@NonNull Application application) {
        super(application);
        fact = new MutableLiveData<>();
        apiServices = RetrofitInstance.getRetrofitClient().create(APIServices.class);
        Call<Actor> call = apiServices.getActor();
        call.enqueue(new Callback<Actor>() {
            @Override
            public void onResponse(Call<Actor> call, Response<Actor> response) {
                if (response.isSuccessful()) {
                    fact.setValue(response.body().getFact());
                } else {

                    Toast.makeText(application, "oh Sorry!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Actor> call, Throwable t) {
                Toast.makeText(application, "Sorry!!!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public LiveData<String> getCatFact() {
        return fact;
    }
}
