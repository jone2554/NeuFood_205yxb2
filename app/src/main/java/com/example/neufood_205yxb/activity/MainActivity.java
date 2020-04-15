package com.example.neufood_205yxb.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.neufood_205yxb.R;
public class MainActivity extends FragmentActivity implements View.OnClickListener
{
    private LinearLayout Lshouye;
    private LinearLayout Lcollect;
    private LinearLayout Lsearch;
    private LinearLayout Lmy;

    private ImageButton mImgshouye;
    private ImageButton mImgcollect;
    private ImageButton mImgsearch;
    private ImageButton mImgmy;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    private TextView tshouye;
    private TextView tcollect;
    private TextView tsearch;
    private TextView tmy;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();//初始化控件
        initEvent();//初始化事件
        setSelect(0);
    }

    private void initEvent()
    {
        Lshouye.setOnClickListener(this);
        Lcollect.setOnClickListener(this);
        Lsearch.setOnClickListener(this);
        Lmy.setOnClickListener(this);
    }

    private void initView()
    {
        Lshouye = (LinearLayout) findViewById(R.id.shouye);
        Lcollect = (LinearLayout) findViewById(R.id.collect);
        Lsearch = (LinearLayout) findViewById(R.id.search);
        Lmy = (LinearLayout) findViewById(R.id.my);

        mImgshouye = (ImageButton) findViewById(R.id.picshouye);
        mImgcollect = (ImageButton) findViewById(R.id.piccollect);
        mImgsearch = (ImageButton) findViewById(R.id.picshearch);
        mImgmy = (ImageButton) findViewById(R.id.picmy);

        tshouye= (TextView) findViewById(R.id.tshouye);
        tcollect= (TextView) findViewById(R.id.tcollect);
        tsearch= (TextView) findViewById(R.id.tsearch);
        tmy= (TextView) findViewById(R.id.tmy);
    }

    private void setSelect(int i)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
//       switch (i)
//       {
//            case 0:
//                if (mTab01 == null)
//                {
//                    mTab01 = new ShouyeFragment();
//                    transaction.add(R.id.id_content, mTab01);
//                } else
//                {
//                    transaction.show(mTab01);
//                }
//                mImgshouye.setImageResource(R.drawable.tab_shouye_pressed);
//                shouye.setTextColor(Color.parseColor("#1296db"));
//                break;
//            case 1:
//                if (mTab02 == null)
//                {
//                    mTab02 = new CollectFragmrnt();
//                    transaction.add(R.id.id_content, mTab02);
//                } else
//                {
//                    transaction.show(mTab02);
//
//                }
//                mImgcollect.setImageResource(R.drawable.tab_find_collect_pressed);
//                collect.setTextColor(Color.parseColor("#1296db"));
//                break;
//            case 2:
//                if (mTab03 == null)
//                {
//                    mTab03 = new SearchFragment();
//                    transaction.add(R.id.id_content, mTab03);
//                } else
//                {
//                    transaction.show(mTab03);
//                }
//                mImgsearch.setImageResource(R.drawable.tab_search_pressed);
//                search.setTextColor(Color.parseColor("#1296db"));
//                break;
//            case 3:
//                if (mTab04 == null)
//                {
//                    mTab04 = new MyFragment4();
//                    transaction.add(R.id.id_content, mTab04);
//                } else
//                {
//                    transaction.show(mTab04);
//                }
//                mImgmy.setImageResource(R.drawable.tab_my_pressed);
//                my.setTextColor(Color.parseColor("#1296db"));
//                break;
//
//            default:
//                break;
//        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction)
    {
        if (mTab01 != null)
        {
            transaction.hide(mTab01);
            tshouye.setTextColor(Color.parseColor("#8a8a8a"));
        }
        if (mTab02 != null)
        {
            transaction.hide(mTab02);
            tcollect.setTextColor(Color.parseColor("#8a8a8a"));
        }
        if (mTab03 != null)
        {
            transaction.hide(mTab03);
            tsearch.setTextColor(Color.parseColor("#8a8a8a"));
        }
        if (mTab04 != null)
        {
            transaction.hide(mTab04);
            tmy.setTextColor(Color.parseColor("#8a8a8a"));
        }
    }

    @Override
    public void onClick(View v)
    {
        resetImgs();
        switch (v.getId())
        {
            case R.id.tshouye:
                setSelect(0);
                break;
            case R.id.tcollect:
                setSelect(1);
                break;
            case R.id.tsearch:
                setSelect(2);
                break;
            case R.id.tmy:
                setSelect(3);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void resetImgs()
    {
        mImgshouye.setImageResource(R.drawable.tab_shouye_normal);
        mImgcollect.setImageResource(R.drawable.tab_find_collect_normal);
        mImgsearch.setImageResource(R.drawable.tab_search_normal);
        mImgmy.setImageResource(R.drawable.tab_my_normal);
    }

}

