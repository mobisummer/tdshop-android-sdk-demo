package com.tdshop.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tdshop.android.TDShop;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.btn_banner).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        navigateTo(TDBannerShowActivity.class);
      }
    });

    findViewById(R.id.btn_icon).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        navigateTo(TDIconShowActivity.class);
      }
    });

    findViewById(R.id.btn_show_interstitial).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (TDShop.isSdkInitialized()) {
          TDShop.showInterstitialView(MainActivity.this);
        }
      }
    });
  }

  public void navigateTo(Class<?> clazz) {
    Intent intent = new Intent(this, clazz);
    startActivity(intent);
  }
}
