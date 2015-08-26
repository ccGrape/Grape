package com.doubleC.grape;

import java.util.Stack;

import android.app.Activity;
import android.content.Context;

public class AppManger {
    private static Stack<Activity> mActivityStack;
    private static AppManger mAppManger;
    
    //TODO 确定一下要不要这样写
    private AppManger(){
        mActivityStack = new Stack<Activity>();
    }
    /**
     * 单一实例
     * @return
     */
    public static AppManger instance(){
        if(null==mAppManger){
            mAppManger = new AppManger();
        }
        return mAppManger;
    }
    
    /**
     * 添加activity到栈里
     * @param activity
     */
    public void addSctivity(Activity activity){
        if(null==mActivityStack){
            mActivityStack = new Stack<Activity>();
        }
        mActivityStack.add(activity);
    }
    
    /**
     * 获得栈顶元素
     * @return
     */
    public Activity getTopActivity(){
        Activity activity = mActivityStack.lastElement();
        return activity;
    }
    
    /**
     * 杀死栈顶activity
     */
    public void killTopActivity(){
       Activity activity = mActivityStack.lastElement();
       killActivity(activity);
    }
    
    /**
     * 杀死指定activity,同时从栈中弹出该activity
     * @param activity
     */
    public void killActivity(Activity activity){
        if(null!=activity){
            mActivityStack.remove(activity);
            activity.finish();
            activity=null;
        }
    }
    
    /**
     * 杀死指定类名的activity(可能会出现同一个类的实例对象)
     * @param clazz
     */
    public void killActivity(Class<?> clazz){
        for(Activity activity : mActivityStack){
            if(activity.getClass().equals(clazz)){
                killActivity(activity);
            }
        }
    }
    
    /**
     * 杀死栈中所有的activity
     */
    public void killAllActivity(){
        for(int i=0,size=mActivityStack.size();i<size;i++){
            if(null!=mActivityStack.get(i)){
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }
    
    /**
     * 退出应用程序
     * @param context
     */
    public void appExit(Context context){
        try {
            killAllActivity();
            /*ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.restartPackage(context.getPackageName());
            System.exit(0);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
