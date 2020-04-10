package com.example.neufood_205yxb.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.neufood_205yxb.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
public abstract class BaseFragment extends Fragment {
    protected int layout_file=0;
    private SharedPreferences sp;
    protected FragmentManager childManager;
    private FragmentTransaction transaction;
    protected Context context;
    protected View view = null;

    abstract void initEvents();
    abstract void initViews();
    abstract void initData();

    void setLayout_file(int layout_file)
    {
        this.layout_file=layout_file;
    }
    int getLayout_file()
    {
        return this.layout_file;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayout_file(), container, false);
        initViews();
        initEvents();
        initData();
        return view;
    }

    public String getUser_id() {
        sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("user_id", "");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        childManager = getChildFragmentManager();
    }

//    protected void addFragment(Fragment fragment) {
//        transaction = childManager.beginTransaction();
//        transaction.add(R.id.fragment_container, fragment);
//        transaction.commit();
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

//    protected void replaceFragment(Fragment fragment) {
//
//        transaction = childManager.beginTransaction();
//        transaction.replace(R.id.fragment_container, fragment);
//        transaction.commit();
//    }

    protected void removeFragment(Fragment fragment) {

        transaction = childManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }
    public void showToast(String content)
    {
        Toast.makeText(getActivity(),content,Toast.LENGTH_LONG).show();
    }
}



