package com.example.neufood_205yxb.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.neufood_205yxb.R;
import com.example.neufood_205yxb.bean.Result;
import com.example.neufood_205yxb.listener.RetrofitListener;
import com.example.neufood_205yxb.model.UserModel;

public class RegisterActivity extends BaseActivity implements RetrofitListener<Result> {
    private Intent intent;
    private ImageView reg_return;
    private Button register;
    private EditText et_reg_user, et_reg_password, et_reg_repassword,
         et_reg_telephone, et_reg_adress, et_reg_comment;
    private UserModel userModel;

    protected void initViews() {
        setLayout(R.layout.activity_register);
        register = (Button) findViewById(R.id.register);
        et_reg_user = (EditText) findViewById(R.id.et_reg_user);
        et_reg_password = (EditText) findViewById(R.id.et_reg_password);
        et_reg_repassword = (EditText) findViewById(R.id.et_reg_repassword);
        et_reg_telephone = (EditText) findViewById(R.id.et_reg_telephone);
        et_reg_adress = (EditText) findViewById(R.id.et_reg_adress);
//        et_reg_comment = (EditText) findViewById(R.id.et_reg_comment);
        reg_return = (ImageView) findViewById(R.id.reg_return);
    }

    void initEvents() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_reg_password.getText().toString().equals(et_reg_repassword.getText().toString())) {
                    register();
                } else {
                    showToast("请确认两次密码相同");
                }
            }
        });
        reg_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.putExtra("user", et_reg_user.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    void initData() {

    }

    private void register() {
        userModel = new UserModel();
        userModel.register(et_reg_user.getText().toString(),
                et_reg_password.getText().toString(),
                et_reg_telephone.getText().toString(),
                et_reg_adress.getText().toString(),
                et_reg_comment.getText().toString(),
                this);
    }

    @Override
    public void onSuccess(Result result,int flag) {
        if (result.getSuccess().equals("1")) {
            intent = new Intent();
            intent.putExtra("user", et_reg_user.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
            showToast("注册成功");
        } else {
            showToast("注册失败");
        }
    }

    @Override
    public void onFail() {
        showToast("网络发生错误");
    }
}
