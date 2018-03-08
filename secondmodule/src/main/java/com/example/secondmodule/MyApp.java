package com.example.secondmodule;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by 艾德米 on 2018/3/7.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
