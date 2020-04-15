package com.example.neufood_205yxb.model;


import android.provider.SyncStateContract;

import com.example.neufood_205yxb.bean.UserInfo;
import com.example.neufood_205yxb.common.Constants;
import com.example.neufood_205yxb.listener.RetrofitListener;
import com.example.neufood_205yxb.service.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserModel extends RetrofitBaseModel {
    private UserService userService;
    private Retrofit retrofit;
    public UserModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.userService = retrofit.create(UserService.class);
    }

    public void userLogin(String username, String password, final RetrofitListener listener) {
        Call call = userService.login(username, password);
        Callback<UserInfo> callback = new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                listener.onSuccess(response.body(),1);
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                listener.onFail();
            }
        };
        call.enqueue(callback);
    }
    public void register(String username, String userpass, String mobilenum,
                         String address, String comment, final RetrofitListener listener) {
        Call call = userService.register(username, userpass, mobilenum, address, comment);
        bindCallback(call,listener, Constants.USEREGISTER);
    }

//    public void getUserById(String user_id, final RetrofitListener<UserInfo> listener) {
//        Call call = userService.getUserById(user_id);
//        bindCallback(call,listener, SyncStateContract.Constants.GETUSERBYID);
//    }
//    public void userCollectFood(String user_id, String food_id, final RetrofitListener listener) {
//        Call call = userService.userCollectFood(user_id,food_id);
//        bindCallback(call,listener, SyncStateContract.Constants.USERCOLLECTFOOD);
//    }
//    public void userCollectShop(String user_id, String shop_id, final RetrofitListener listener) {
//        Call call = userService.userCollectShop(user_id,shop_id);
//        bindCallback(call,listener, SyncStateContract.Constants.USERCOLLECTSHOP);
//    }
//
//
//    public void updateUserById(String user_id, String username, String userpass, String mobilenum, String address, final RetrofitListener listener)  {
//        Call  call = userService.updateUserById(user_id,username,userpass,mobilenum,address);
//        bindCallback(call,listener, SyncStateContract.Constants.UPDATEUSERBYID);
//    }

//    public void insertOrder(String user_id, String food_id, String num, String sum, String suggesttime, String address,final RetrofitListener listener) {
//        Call call = userService.insertOrder(user_id,food_id,num,sum,suggesttime,address);
//        bindCallback(call,listener, SyncStateContract.Constants.INSERTORDER);
//    }
//    public void insertOrder2(String user_id, String sum, String suggesttime, String address,String items,final RetrofitListener listener) {
//        Call call = userService.insertOrder2(user_id,sum,suggesttime,address,items);
//        bindCallback(call,listener, SyncStateContract.Constants.INSERTORDER2);
//    }


//    public void getAllUserCollection(String user_id, String flag, final RetrofitListener listener) {
//        Call call = userService.getAllUserCollection(user_id,flag);
//        bindCallback(call,listener, SyncStateContract.Constants.GETALLUSERCOLLECTION);
//    }

//    public void changeUserImg(String user_id, String filename, final RetrofitListener listener)
//    {
//        File file=new File(filename);
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part body =
//                MultipartBody.Part.createFormData("img", file.getName(), requestFile);
//        Call call = userService.changeUserImg(user_id, body);
//        bindCallback(call,listener, SyncStateContract.Constants.INSERTORDER);
//    }
}
