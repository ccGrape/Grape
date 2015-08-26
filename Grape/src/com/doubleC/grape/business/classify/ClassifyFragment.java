package com.doubleC.grape.business.classify;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doubleC.grape.R;
import com.doubleC.grape.base.BaseFragment;

public class ClassifyFragment extends BaseFragment{
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentName = "ClassifyFragment";
        Log.e("fragment", fragmentName+"        onAttach");
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.classify_fragment,null);
        return fragment;
    }

    @Override
    protected void initView(View view) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void addListener() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void initData() {
        // TODO Auto-generated method stub
        
    }
}
