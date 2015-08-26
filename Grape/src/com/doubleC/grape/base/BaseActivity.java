package com.doubleC.grape.base;

import android.app.Activity;
import android.util.Log;

import com.doubleC.grape.common.oberver.NetworkStatusOberver;

/**
 * 
 * Activity基类
 * 
 * @author doubleC
 * 2015/08/06
 */
public abstract class BaseActivity extends Activity implements NetworkStatusOberver{
    protected boolean isFront; 
    
    protected abstract void initView();
    protected abstract void addListener();
    protected abstract void initData();
    
    @Override
    public void update(int ststus) {
        if(isFront){
            Log.d("fcc", "网络变化了");
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        isFront = false;
    }
}
