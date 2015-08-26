package com.doubleC.grape.business.find;

import com.doubleC.grape.R;
import com.doubleC.grape.base.BaseFragment;
import com.doubleC.grape.business.find.database.DataBaseActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FindFragment extends BaseFragment implements OnClickListener{
    
    private Button find_db;
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentName = "FindFragment";
        Log.e("fragment", fragmentName+"        onAttach");
    }
    
    //TODO 去了解这一可以做些什么事情
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment,null);
        initView(view);
        addListener();
        initData();
        return view;
    }

    @Override
    protected void initView(View view) {
        find_db = (Button) view.findViewById(R.id.find_db);
    }

    @Override
    protected void addListener() {
        find_db.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.find_db:
            Intent intent = new Intent(getActivity(),DataBaseActivity.class);
            startActivity(intent);
            break;

        default:
            break;
        }
    }
}
