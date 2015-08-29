package com.doubleC.grape.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

/**
 * Fragment基类
 * 
 * @author boubleC
 * 2015/08/06
 */
public abstract class BaseFragment extends Fragment{
    protected boolean isFront;
    protected String fragmentName;
    
    /**
     * 这个方法实现了fragment和activity的绑定
     * 
     * 在其子类中可以定义一个借口进行fragment的操作在activity中的回调
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    
    protected abstract void initView(View view);
    
    protected abstract void addListener();
    
    protected abstract void initData();
    
    @Override
    public void onResume() {
        super.onResume();
        isFront = true;
    }
    
    @Override
    public void onStop() {
        super.onStop();
        isFront = false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*@Override
    public void onResume() {
        super.onResume();
        Log.e("fragment", fragmentName+"        onResume");
    }
    
    @Override
    public void onPause() {
        super.onPause();
        Log.e("fragment", fragmentName+"         onPause");
    }
    
    @Override
    public void onStop() {
        super.onStop();
        Log.e("fragment", fragmentName+"         onStop");
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("fragment", fragmentName+"         onDestroy");
    }*/
}
