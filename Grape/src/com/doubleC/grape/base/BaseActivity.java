package com.doubleC.grape.base;

import android.app.Activity;

/**
 * 
 * Activity基类
 * 
 * @author doubleC
 * 2015/08/06
 */
public abstract class BaseActivity extends Activity {

    protected abstract void initView();
    protected abstract void addListener();
    protected abstract void initData();
}
