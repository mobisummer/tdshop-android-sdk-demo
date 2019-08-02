package com.tdshop.demo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.util.Log;
import android.webkit.WebView;
import com.tdshop.android.ActionCallback;
import com.tdshop.android.TDShop;

public class App extends Application {

  private static final String TAG = "App";

  @Override
  public void onCreate() {
    super.onCreate();
    // Manual initialization
    // TDShop.setIsDebugEnabled(true);
    // TDShop.sdkInitialize(this, "myshop", new ActionCallback() {
    //  @Override
    //  public void onSucceed() {
    //    Log.d(TAG, "SDK init onSucceed");
    //  }

    //  @Override
    //  public void onFailed(Exception e) {
    //    Log.d(TAG, "SDK init onFailed: " + e.toString());
    //  }
    //});
  }
}
