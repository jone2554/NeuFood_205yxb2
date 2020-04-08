package com.example.neufood_205yxb.service;

import com.example.neufood_205yxb.bean.Shop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopService {
    @GET("getAllShops.do")
    Call<List<Shop>> getAllShops();

    @GET("getShopById.do")
    Call<Shop> getShopById(
            @Query("shop_id") String shop_id
    );
}
