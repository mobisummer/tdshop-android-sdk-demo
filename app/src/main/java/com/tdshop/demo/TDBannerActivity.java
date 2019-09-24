package com.tdshop.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.tdshop.android.TDBannerView;
import com.tdshop.android.TDShopException;
import com.tdshop.android.creative.CreativeViewListener;

public class TDBannerActivity extends AppCompatActivity {
  private static final String TAG = TDBannerActivity.class.getName();
  private TDBannerView mBannerView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_td_banner_show);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDBannerView");
    }
    mBannerView = findViewById(R.id.v_banner);
    mBannerView.setBannerType(TDBannerView.TYPE_SMALL_BANNER);
    mBannerView.setCreativeViewListener(
        new CreativeViewListener() {
          @Override
          public void onCreativeError(TDShopException exception) {
            Log.d(TAG, "onCreativeError" + exception.toString());
          }

          @Override
          public void onCreativeLoaded(View view) {
            Log.d(TAG, "onAdLoaded");
            mBannerView.show();
          }

          @Override
          public void onCreativeShowed(View view) {
            Log.d(TAG, "onCreativeShowed");
          }

          @Override
          public void onCreativeClosed(View view) {}

          @Override
          public void onCreativeClicked(View view) {}
        });
    mBannerView.setPlacementId("myshop_banner_002");
    mBannerView.load();
  }

  @Override
  protected void onResume() {
    super.onResume();
    getActionBar();
  }
}
