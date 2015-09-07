package com.doubleC.grape.common.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.doubleC.grape.R;

public class CustomProgressDialog extends Dialog{

    private static CustomProgressDialog customProgressDialog = null;
    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }
    
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(customProgressDialog==null){
            return;
        }
        ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.loading_image);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }
    
    public static CustomProgressDialog createDialog(Context context){
        customProgressDialog  = new CustomProgressDialog(context, R.style.CustomProgressDialog);
        customProgressDialog.setContentView(R.layout.custom_progress_dialog);
        customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return customProgressDialog;
    }
    
    public CustomProgressDialog setMessage(String message){
        TextView textView = (TextView) customProgressDialog.findViewById(R.id.loading_title);
        if(textView!=null){
            textView.setText(message);
        }
        return customProgressDialog;
    }
}
