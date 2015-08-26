package com.doubleC.grape.business.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doubleC.grape.R;
import com.doubleC.grape.base.BaseFragment;
import com.doubleC.grape.common.ToastUtil;

public class HomeFragment extends BaseFragment implements OnClickListener{

    private View view;
    private TextView home_text;
    private Activity mActivity;
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        /*fragmentName = "HomeFragment";
        Log.e("fragment", fragmentName+"        onAttach");*/
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, null);
        initView(view);
        addListener();
        initData();
        return view;
    }

    @Override
    protected void initView(View view) {
        home_text = (TextView) view.findViewById(R.id.home_text);
    }

    @Override
    protected void addListener() {
        home_text.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        
    }
    
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.home_text:
            ToastUtil.showToastShort(mActivity,"再按一次退出Grape");
            break;
        default:
            break;
        }
    }
    
    
}
