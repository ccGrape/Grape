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
    ProgressDialog progressDialog = null;
    
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
    
	public void showProgressDialog() {
		if(progressDialog==null){
		    progressDialog=new ProgressDialog(this);
		}
		if(progressDialog.isShowing()){
		    return;
		    
		}
		//progressDialog.setIndeterminate(true);//不确定的状态
		//progressDialog.setMessage("");
		progressDialog.setCancelable(true);
		progressDialog.setCanceledOnTouchOutside(false);
		progressDialog.show();
	}
	
	public void cancelProgressDialog(){
	    if(progressDialog==null){
	        return;
	    }
	    if(!progressDialog.isShowing()){
	        return;
	    }
	    progressDialog.cancel();
	}
}
