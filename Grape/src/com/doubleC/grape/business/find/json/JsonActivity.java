package com.doubleC.grape.business.find.json;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.doubleC.grape.R;
import com.doubleC.grape.base.BaseActivity;

public class JsonActivity extends BaseActivity implements OnClickListener{

    //界面元素
    private TextView json_button;
    
    //变量
    private String jsonStr;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_test);
        initView();
        initData();
        addListener();
    }
    
    @Override
    protected void initView() {
        json_button = (TextView) findViewById(R.id.json_button);
    }

    @Override
    protected void addListener() {
        json_button.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.json_button:
            jsonStr = test.obj2Json();
            break;
        default:
            break;
        }
    }
}
