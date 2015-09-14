package com.doubleC.grape.business.find.progressdialog;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.TextView;

import com.doubleC.grape.R;
import com.doubleC.grape.base.BaseActivity;
import com.doubleC.grape.common.view.CustomProgressDialog;

public class ProgressDialogTest extends BaseActivity implements OnClickListener{

    private TextView progressdialog_show,progressdialog_cancle,progressdialog_coustomer;
    private CustomProgressDialog costumerProgressDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressdialog);
        initView();
        initData();
        addListener();
    }
    
    @Override
    protected void initView() {
        progressdialog_show = (TextView) findViewById(R.id.progressdialog_show);
        progressdialog_cancle = (TextView) findViewById(R.id.progressdialog_cancle);
        progressdialog_coustomer = (TextView) findViewById(R.id.progressdialog_coustomer);
    }

    @Override
    protected void addListener() {
        progressdialog_show.setOnClickListener(this);
        progressdialog_cancle.setOnClickListener(this);
        progressdialog_coustomer.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.progressdialog_show:
            showProgressDialog();
            break;
        case R.id.progressdialog_cancle:
            cancelProgressDialog();
            break;
        case R.id.progressdialog_coustomer:
            
            break;
        default:
            break;
        }
    }

}
