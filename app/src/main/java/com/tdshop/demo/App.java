package com.tdshop.demo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.util.Log;
import android.webkit.WebView;

public class App extends Application {

  private static final String TAG = "App";

  @Override
  public void onCreate() {
    super.onCreate();
    //Avoid WebView directory conflicts, which will causing crashes on 9.0
    if ((getPackageName() + ":tdWeb").equals(getProcessName(this))) {
      if (VERSION.SDK_INT >= VERSION_CODES.P) {
        WebView.setDataDirectorySuffix("tdweb");
      }
    }
    Log.i(TAG, "onCreate: " + getProcessName(this));
  }

  public static String getProcessName(Context context) {
    ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
      if (processInfo.pid == android.os.Process.myPid()) {
        return processInfo.processName;
      }
    }

    return null;
  }
}
