package com.doubleC.grape.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.doubleC.grape.R;

/**
 * 自定义toast
 * @author 155256
 *
 */
public class ToastUtil{

    private static LayoutInflater inflater;
       
    public static void showToastLong(Context context,String info){
        inflater = LayoutInflater.from(context);
        View toastView = inflater.inflate(R.layout.toast,null);
        TextView infoView = (TextView) toastView.findViewById(R.id.toast_info);
        infoView.setText(info);
        Toast toast = new Toast(context);
        toast.setView(toastView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
    public static void showToastShort(Context context,String info){
        inflater = LayoutInflater.from(context);
        View toastView = inflater.inflate(R.layout.toast,null);
        TextView infoView = (TextView) toastView.findViewById(R.id.toast_info);
        infoView.setText(info);
        Toast toast = new Toast(context);
        toast.setView(toastView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
