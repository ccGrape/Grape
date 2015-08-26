package com.doubleC.grape.base;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.doubleC.grape.AppManger;
import com.doubleC.grape.common.ToastUtil;

/**
 * FragmentActivity基类
 * @author doublleC
 * 2015/08/06
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    protected FragmentManager fm;
    protected FragmentTransaction ft;
    protected Fragment fromFragment;
    protected static String fromFragmentStr;

    private static Boolean isExit = false;

    protected abstract void initView();

    protected abstract void addListener();

    protected abstract void initData(Bundle savedInstanceState);

    public void switchFragment(int id, Fragment from, Fragment to, String tab) {
        if (null == to) {
            return;
        }
        if (to != fromFragment) {
            fromFragment = to;
            fromFragmentStr = tab;
            if (null == fm) {
                fm = getSupportFragmentManager();
            }
            ft = fm.beginTransaction();
            if (!to.isAdded()) {
                ft.hide(from).add(id, to, tab);
            } else {
                ft.hide(from).show(to);
            }
            ft.commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); //调用双击退出函数
        }
        return false;
    }

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            //Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            ToastUtil.showToastShort(this, "再按一次退出Grape");
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 3000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            //System.exit(0);
            /*Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
            android.os.Process.killProcess(android.os.Process.myPid());*/
            AppManger.instance().appExit(getApplicationContext());
        }
    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        Bundle b = new Bundle();
        b.putCharSequence("fragment", fromFragmentStr);
        outState.putBundle("fromFragment",b);
        super.onSaveInstanceState(outState);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Bundle b = savedInstanceState.getBundle("fromFragment");
        fromFragmentStr = b.getString("fragment");
        super.onRestoreInstanceState(savedInstanceState);
    }*/
}
