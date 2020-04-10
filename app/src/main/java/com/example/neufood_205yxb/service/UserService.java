package com.example.neufood_205yxb.service;

import com.example.neufood_205yxb.bean.Result;
import com.example.neufood_205yxb.bean.UserInfo;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface UserService {
        @GET("userLogin.do")
        Call<UserInfo> login(
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
    @GET("getUserById.do")
    Call<UserInfo> getUserById(
            @Query("user_id") String user_id
    );
    @Multipart
    @POST("changeUserImg")
    Call<Boolean> changeUserImg(@Query("user_id") String user_id, @Part MultipartBody.Part file);
}
