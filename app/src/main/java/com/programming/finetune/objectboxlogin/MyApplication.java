package com.programming.finetune.objectboxlogin;

import android.app.Application;

import io.objectbox.BoxStore;

/**
 * Created by cedex on 9/8/2017.
 */

public class MyApplication extends Application {

    private static MyApplication mApplication;
    private BoxStore mBoxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        // Building the boxstore using object box build
        // before adding this line make sure you have build your project
        mBoxStore = MyObjectBox.builder().androidContext(MyApplication.this).build();
    }

    public static MyApplication getApplication(){
        return mApplication;
    }

    public BoxStore getBoxStore(){
        return mBoxStore;
    }
}
