package com.playground;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

/**
 * Created by emil.ivanov on 9/1/18.
 */
public class NoteApplication extends Application {

    private static Context mInstance;

    public static Context getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: 9/20/18 1. Implement Dagger
        // TODO: 9/20/18 2. Add UI test for note creation
        // TODO: 9/20/18 3. Add UI test for list view
        mInstance = this;
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
