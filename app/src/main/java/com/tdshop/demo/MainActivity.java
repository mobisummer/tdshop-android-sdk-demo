package com.tdshop.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        navigateTo(TDBannerActivity.class);
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
          TDShop.showInterstitialView(MainActivity.this, "myshop_interstitial_001");
        }
      }
    });

    findViewById(R.id.btn_show_custom).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        navigateTo(TDCustomShowActivity.class);
      }
    });

    findViewById(R.id.btn_large_banner).setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            navigateTo(TDLargeBannerActivity.class);
          }
        });

    findViewById(R.id.btn_show_multi_custom).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        navigateTo(TDMultiCustomShowActivity.class);
      }
    });

    findViewById(R.id.btn_show_container)
        .setOnClickListener(
            new OnClickListener() {
              @Override
              public void onClick(View v) {
                navigateTo(TDShopContainerActivity.class);
              }
            });
  }

  public void navigateTo(Class<?> clazz) {
    Intent intent = new Intent(this, clazz);
    startActivity(intent);
  }
}
