package com.example.neufood_205yxb.model;
import com.example.neufood_205yxb.common.Constants;
import com.example.neufood_205yxb.listener.RetrofitListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitBaseModel {
    public Retrofit retrofit;

    public RetrofitBaseModel()
    {
        retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> void bindCallback(Call<T> call, final RetrofitListener<T> listener, final int flag) {
        Callback<T> callback=new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                listener.onSuccess(response.body(),flag);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                listener.onFail();
            }
        };
       call.enqueue(callback);
    }
}
