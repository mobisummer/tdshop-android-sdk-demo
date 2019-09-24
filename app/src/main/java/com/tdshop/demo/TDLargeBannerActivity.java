package com.tdshop.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tdshop.android.TDBannerView;
import com.tdshop.android.TDShopException;
import com.tdshop.android.creative.CreativeViewListener;

public class TDLargeBannerActivity extends AppCompatActivity {

  private TDBannerView mBannerView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_td_banner_show);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDBannerView");
    }
    mBannerView = findViewById(R.id.v_banner);
    mBannerView.setBannerType(TDBannerView.TYPE_LARGE_BANNER);
    mBannerView.setCreativeViewListener(
        new CreativeViewListener() {
          @Override
          public void onCreativeError(TDShopException exception) {}

          @Override
          public void onCreativeLoaded(View view) {
            mBannerView.show();
          }

          @Override
          public void onCreativeShowed(View view) {}

          @Override
          public void onCreativeClicked(View view) {}

          @Override
          public void onCreativeClosed(View view) {}
        });
    mBannerView.setPlacementId("myshop_banner_001");
    mBannerView.load();
  }

  @Override
  protected void onResume() {
    super.onResume();
    getActionBar();
  }
}
