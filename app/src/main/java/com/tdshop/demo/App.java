package com.tdshop.demo;

import android.app.Application;
import android.util.Log;
import com.tdshop.android.ActionCallback;
import com.tdshop.android.TDShop;

public class App extends Application {

  private static final String TAG = "App";

  @Override
  public void onCreate() {
    super.onCreate();
//     Manual initialization
     TDShop.setIsDebugEnabled(true);
     TDShop.sdkInitialize(this, "myshop", new ActionCallback() {
      @Override
      public void onSucceed() {
        Log.d(TAG, "SDK init onSucceed");
      }

      @Override
      public void onFailed(Exception e) {
        Log.d(TAG, "SDK init onFailed: " + e.toString());
      }
    });
  }
}
