package com.ailian.leakcanary.leakcanarydemo;

import android.content.Context;

/**
 * Created by ailian on 2018/9/5/005.
 */

public class Singleton {
    private static Singleton singleton;
    private Context context;
    private Singleton(Context context) {
        this.context = context;
    }

    public static Singleton newInstance(Context context) {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null){//双重检查锁定
                    singleton = new Singleton(context);
                }
            }
        }
        return singleton;
    }
}
