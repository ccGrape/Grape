package com.doubleC.grape.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;

import com.doubleC.grape.R;
import com.doubleC.grape.common.view.CustomProgressDialog;

/**
 * 
 * Activity基类
 * 
 * @author doubleC
 * 2015/08/06
 */
public abstract class BaseActivity extends Activity{
    protected boolean isFront; 
    CustomProgressDialog costumerProgressDialog = null;
    
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
	    showProgressDialog("");
	}
	
	public void showProgressDialog(String message) {
        if(costumerProgressDialog==null){
            costumerProgressDialog = CustomProgressDialog.createDialog(this);
        }
        
        if(costumerProgressDialog.isShowing()){
            return;
        }
        costumerProgressDialog.setCancelable(true);
        costumerProgressDialog.setCanceledOnTouchOutside(false);
        costumerProgressDialog.setMessage(message);
        costumerProgressDialog.show();
    }
	
	public void cancelProgressDialog(){
	    if(costumerProgressDialog==null){
	        return;
	    }
	    if(!costumerProgressDialog.isShowing()){
	        return;
	    }
	    costumerProgressDialog.cancel();
	}
}
