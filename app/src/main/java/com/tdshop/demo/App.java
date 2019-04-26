package com.tdshop.demo;


import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import com.tdshop.android.ActionCallback;
import com.tdshop.android.TDShop;

public class App extends Application {

  private static final String APP_ID = "myshop";
  private static final String TAG = "App";

  @Override
  public void onCreate() {
    super.onCreate();
    //开启 Debug 模式
    TDShop.setIsDebugEnabled(true);
    TDShop.sdkInitialize(this, APP_ID, new ActionCallback() {
      @Override
      public void onSucceed() {
        Toast.makeText(getApplicationContext(), "Init Success", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onFailed(Exception e) {
        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onFailed: " + e.getMessage());
      }
    });
  }
}
