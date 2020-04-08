package com.example.neufood_205yxb.service;

import com.example.neufood_205yxb.bean.LoginBean;
import com.example.neufood_205yxb.bean.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
        @GET("userLogin.do")
        Call<LoginBean> login(
                @Query("username") String username,
                @Query("userpass") String userpass
        );
    @GET("userRegister.do")
    Call<Result> register(
            @Query("username") String username,
            @Query("userpass") String userpass,
            @Query("mobilenum") String mobilenum,
            @Query("address") String address,
            @Query("comment") String comment
    );
}
