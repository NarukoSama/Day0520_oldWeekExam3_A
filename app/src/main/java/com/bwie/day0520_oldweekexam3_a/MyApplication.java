package com.bwie.day0520_oldweekexam3_a;

import android.app.Application;

import org.xutils.x;

/**
 * Created by
 * Chenxin
 * on 2017/5/20.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);

    }
}
