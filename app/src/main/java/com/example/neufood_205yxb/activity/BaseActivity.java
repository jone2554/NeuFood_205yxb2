package com.example.neufood_205yxb.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import com.example.neufood_205yxb.R;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by Neusoft on 2017/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected int layout_file= R.layout.activity_main;
    protected abstract void initViews();
    abstract void initEvents();
    abstract void initData();
     void setLayout(int layout_file)
    {
        setContentView(layout_file);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(layout_file);
        initViews();
        initData();
        initEvents();
    }
    public String getUser_id()
    {
        SharedPreferences sp;
        sp =getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("user_id", "");
    }
    public SharedPreferences getSPFile()
    {
        return getSharedPreferences("userInfo", Context.MODE_PRIVATE);
    }
    public String getUser_password()
    {
        SharedPreferences sp;
        sp =getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("userpass", "");
    }

    public void showToast(String content)
    {
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
    }
}
