package com.doubleC.grape.common.util;

import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;

import com.doubleC.grape.common.oberver.NetworkStatusOberver;

public class NetWorkBroadcastReceiver extends BroadcastReceiver {
    State wifiState = null;
    State mobileState = null;
    private  List<NetworkStatusOberver> list = new ArrayList<NetworkStatusOberver>();
    
    public void attach(NetworkStatusOberver observer){
        list.add(observer);
    }
    
    public void detach(NetworkStatusOberver observer){
        list.remove(observer);
    }
    
    public void nodifyObservers(int newState){
        for(NetworkStatusOberver observer : list){
            observer.update(newState);
        }
    }
    
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        wifiState = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        mobileState = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();

        if (wifiState != null && mobileState != null && State.CONNECTED != wifiState
                        && State.CONNECTED != mobileState) {//手机没有任何网络
            nodifyObservers(0);
        }else if (wifiState != null && mobileState != null && State.CONNECTED == wifiState
                        && State.CONNECTED != mobileState) {//无线网络连接成功
            nodifyObservers(1);
        }else if (wifiState != null && mobileState != null && State.CONNECTED != wifiState && State.CONNECTED == mobileState) { //网络连接出成功
            nodifyObservers(2);
        } 
    }
}
