package com.doubleC.grape.business;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doubleC.grape.AppManger;
import com.doubleC.grape.R;
import com.doubleC.grape.base.BaseFragmentActivity;
import com.doubleC.grape.business.classify.ClassifyFragment;
import com.doubleC.grape.business.find.FindFragment;
import com.doubleC.grape.business.home.HomeFragment;
import com.doubleC.grape.business.mine.MineFragment;

public class MainActivity extends BaseFragmentActivity implements OnClickListener {

    private ViewGroup home, classify, find, mine;
    private TextView home_text,classify_text,find_text,mine_text;
    private Fragment homeFragment,classfyFragment,findFragment,mineFragment;
    
    private List<TextView> tabList = new ArrayList<TextView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManger.instance().addSctivity(this);
        setContentView(R.layout.main);
        initView();
        addListener();
        initData(savedInstanceState);
    }

    @Override
    protected void initView() {
        home = (ViewGroup) findViewById(R.id.home);
        classify = (ViewGroup) findViewById(R.id.classify);
        find = (ViewGroup) findViewById(R.id.find);
        mine = (ViewGroup) findViewById(R.id.mine);
        
        home_text = (TextView) findViewById(R.id.home_text);
        classify_text = (TextView) findViewById(R.id.classify_text);
        find_text = (TextView) findViewById(R.id.find_text);
        mine_text = (TextView) findViewById(R.id.mine_text);
        tabList.add(home_text);
        tabList.add(classify_text);
        tabList.add(find_text);
        tabList.add(mine_text);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        
        //TODO 可以在这里设计一个fm工厂
        fm = getSupportFragmentManager();
        
        
        if (savedInstanceState == null) {
            homeFragment = new HomeFragment();
            classfyFragment = new ClassifyFragment();
            findFragment = new FindFragment();
            mineFragment = new MineFragment();
            
            fromFragment = homeFragment;
            
            ft = fm.beginTransaction();
            ft.add(R.id.contain, homeFragment,"homeFragment");
            ft.add(R.id.contain, classfyFragment,"classfyFragment");
            ft.add(R.id.contain, findFragment,"findFragment");
            ft.add(R.id.contain, mineFragment,"mineFragment");
            
            ft.show(homeFragment)
            .hide(classfyFragment)
            .hide(findFragment)
            .hide(mineFragment)
            .commit();
            switchTabTextCloor(home_text);
            
        }else{
            homeFragment = fm.findFragmentByTag("homeFragment");
            classfyFragment = fm.findFragmentByTag("classfyFragment");
            findFragment = fm.findFragmentByTag("findFragment");
            mineFragment = fm.findFragmentByTag("mineFragment");
            
            ft = fm.beginTransaction();
            ft.hide(homeFragment)
            .hide(classfyFragment)
            .hide(findFragment)
            .hide(mineFragment);
            
            if(null==fromFragmentStr){
                fromFragment = homeFragment;
                ft.show(homeFragment);
            }else{
                if(fromFragmentStr.equals("homeFragment")){
                    fromFragment = homeFragment;
                    ft.show(homeFragment);
                    switchTabTextCloor(home_text);
                }else if(fromFragmentStr.equals("classfyFragment")){
                    fromFragment = classfyFragment;
                    ft.show(classfyFragment);
                    switchTabTextCloor(classify_text);
                }else if(fromFragmentStr.equals("findFragment")){
                    fromFragment = findFragment;
                    ft.show(findFragment);
                    switchTabTextCloor(find_text);
                }else if(fromFragmentStr.equals("mineFragment")){
                    fromFragment = mineFragment;
                    ft.show(mineFragment);
                    switchTabTextCloor(mine_text);
                }
            }
            ft.commit();
        }
    }

    @Override
    protected void addListener() {
        home.setOnClickListener(this);
        classify.setOnClickListener(this);
        find.setOnClickListener(this);
        mine.setOnClickListener(this);
    }

    private void switchTabTextCloor(TextView view){
        int id = view.getId();
        if(null==tabList){
            return;
        }
        int num = tabList.size();
        for(int i=0;i<num;i++){
            if(id==tabList.get(i).getId()){
                tabList.get(i).setTextColor(Color.parseColor("#E34F1B"));
            }else{
                tabList.get(i).setTextColor(Color.parseColor("#000000"));
            }
        }
    }
    
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.home:
            switchFragment(R.id.contain, fromFragment, homeFragment,"homeFragment");
            switchTabTextCloor(home_text);
            break;
        case R.id.classify:
            switchFragment(R.id.contain, fromFragment, classfyFragment,"classfyFragment");
            switchTabTextCloor(classify_text);
            break;
        case R.id.find:
            switchFragment(R.id.contain, fromFragment, findFragment,"findFragment");
            switchTabTextCloor(find_text);
            break;
        case R.id.mine:
            switchFragment(R.id.contain, fromFragment, mineFragment,"mineFragment");
            switchTabTextCloor(mine_text);
            break;
        default:
            break;
        }
    }
    
    
}
