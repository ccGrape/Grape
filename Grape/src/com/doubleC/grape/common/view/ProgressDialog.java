package com.doubleC.grape.common.view;

import android.app.Dialog;
import android.content.Context;

public class ProgressDialog extends  Dialog{

    private Context context;
    
    public ProgressDialog(Context context) {
        super(context);
        this.context = context;
    }
    
    public ProgressDialog(Context context, int theme) {
        super(context, theme);
    }
    
}
