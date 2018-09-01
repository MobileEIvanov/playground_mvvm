package com.playground;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by emil.ivanov on 9/1/18.
 */
public class NoteApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
