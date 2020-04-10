package com.example.neufood_205yxb.activity;
//private String AppId="1106189944";
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neufood_205yxb.R;
import com.example.neufood_205yxb.bean.UserInfo;
import com.example.neufood_205yxb.listener.RetrofitListener;
import com.example.neufood_205yxb.model.UserModel;


public class LoginActivity extends BaseActivity implements View.OnClickListener,RetrofitListener<UserInfo>{

    private Button btnlogin;
    private TextView tvreg;
    private EditText username, userpass;
    private CheckBox cbremember;


    void login() {
        UserModel userModel = new UserModel();
        userModel.userLogin(username.getText().toString().trim(), userpass.getText().toString().trim(),this);
    }
    @Override
    public void onSuccess(UserInfo userid,int flag) {
        if (userid.getUser_id().equals("0")) {
            showToast("用户名或密码错误");
        } else {
            saveUser(userid.getUser_id());
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            showToast("登录成功");
        }
    }
    @Override
    public void onFail() {
        showToast("网络发生错误");
    }


    protected void initViews() {
        setLayout(R.layout.activity_login);
        username = (EditText) findViewById(R.id.user);
        userpass = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.login);
        tvreg = (TextView) findViewById(R.id.reg);
        cbremember=(CheckBox)findViewById(R.id.cb_remember);
    }

    void initEvents() {
        btnlogin.setOnClickListener(this);
        tvreg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.login:
                if (username.getText().toString().trim().equals("") || userpass.getText().toString().trim().equals("")) {
                    Toast.makeText(LoginActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    login();
                }
                break;
            case R.id.reg:
                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent1, 1);
                break;
        }
    }

    void initData()
    {
        SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        if(sp.getBoolean("isRemember",false))
        {
            username.setText(sp.getString("username",""));
            userpass.setText(sp.getString("userpass",""));
            cbremember.setChecked(true);
        }else
        {
            username.setText("");
            userpass.setText("");
            cbremember.setChecked(false);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK)
        {
            String et_user = data.getStringExtra("user");
            username.setText(et_user);
        }
    }

    public void saveUser(String user_id) {
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
        if(cbremember.isChecked())
            editor.putBoolean("isRemember",true);
        else
            editor.putBoolean("isRemember",false);
        editor.putString("username", username.getText().toString());
        editor.putString("user_id", user_id);
        editor.putString("userpass", userpass.getText().toString());
        editor.commit();//提交修改
    }

}

