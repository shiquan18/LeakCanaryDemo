package com.ailian.leakcanary.leakcanarydemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by ailian on 2018/9/4/004.
 */

public class SecondActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DemoApp.getRefWatcher().watch(this);
        setContentView(R.layout.activity_second);
        Singleton singleton = Singleton.newInstance(this);
    }
}
