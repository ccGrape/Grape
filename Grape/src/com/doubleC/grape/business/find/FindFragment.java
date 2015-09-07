package com.doubleC.grape.business.find;

import com.doubleC.grape.R;
import com.doubleC.grape.base.BaseFragment;
import com.doubleC.grape.business.find.database.DataBaseActivity;
import com.doubleC.grape.business.find.dialog.DialogActivity;
import com.doubleC.grape.business.find.progressdialog.ProgressDialogTest;
import com.doubleC.grape.business.find.urlregex.UrlRegexActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FindFragment extends BaseFragment implements OnClickListener{
    
    private Button find_db,find_dialog,find_progressDialog,find_url_regex;
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
        View view = inflater.inflate(R.layout.find_fragment1,null);
        initView(view);
        addListener();
        initData();
        return view;
    }

    @Override
    protected void initView(View view) {
        find_db = (Button) view.findViewById(R.id.find_db);
        find_dialog = (Button) view.findViewById(R.id.find_dialog);
        find_progressDialog = (Button) view.findViewById(R.id.find_progressDialog);
        find_url_regex  = (Button) view.findViewById(R.id.find_url_regex);
    }

    @Override
    protected void addListener() {
        find_db.setOnClickListener(this);
        find_dialog.setOnClickListener(this);
        find_progressDialog.setOnClickListener(this);
        find_url_regex.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        //TODO 在此做处理
        /*String urlRegEx = "^(http|www|ftp|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";
        int flags = Pattern.CASE_INSENSITIVE;
        Pattern pattern = Pattern.compile(urlRegEx, flags);
        Linkify.addLinks(hodler.content, pattern,"");*/
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.find_db://数据库
            Intent dbIntent = new Intent(getActivity(),DataBaseActivity.class);
            startActivity(dbIntent);
            break;
        case R.id.find_dialog:
            Intent dialogIntent = new Intent(getActivity(),DialogActivity.class);
            startActivity(dialogIntent);
            break;
        case R.id.find_progressDialog:
            Intent progressDialogIntent = new Intent(getActivity(),ProgressDialogTest.class);
            startActivity(progressDialogIntent);
            break;
        case R.id.find_url_regex:
            Intent urlRegexDialogIntent = new Intent(getActivity(),UrlRegexActivity.class);
            startActivity(urlRegexDialogIntent);
            break;
        default:
            break;
        }
    }
}
