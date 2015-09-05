package com.doubleC.grape.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;

import com.doubleC.grape.R;

/**
 * 
 * Activity基类
 * 
 * @author doubleC
 * 2015/08/06
 */
public abstract class BaseActivity extends Activity{
    protected boolean isFront; 
    
    protected abstract void initView();
    protected abstract void addListener();
    protected abstract void initData();
    
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
    
    /**加载进度条*/
	@SuppressWarnings("unused")
	public void showProgressDialog() {
		ProgressDialog progressDialog = null;
		
		if(progressDialog!=null){
			progressDialog.cancel();
		}
		progressDialog=new ProgressDialog(this);
		Drawable drawable=getResources().getDrawable(R.drawable.loading_animation);
		progressDialog.setIndeterminateDrawable(drawable);
		progressDialog.setIndeterminate(true);
		progressDialog.setCancelable(true);
		progressDialog.setMessage("请稍候，正在努力加载。。");
		progressDialog.show();
	}
}
