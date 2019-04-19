package com.ailian.leakcanary.leakcanarydemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by meitu.wumh on 2018/9/4/004.
 */
//https://blog.csdn.net/huo108/article/details/82428129
public class DemoApp extends Application {

    private static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        sRefWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher() {
        return sRefWatcher;
    }
}
