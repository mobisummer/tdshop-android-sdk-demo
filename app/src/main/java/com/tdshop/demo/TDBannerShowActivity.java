package com.tdshop.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.tdshop.android.TDBannerView;
import com.tdshop.android.TDShop;
import java.util.Objects;

public class TDBannerShowActivity extends AppCompatActivity {

  private TDBannerView mBannerView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_td_banner_show);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDBannerView");
    }
    mBannerView = findViewById(R.id.v_banner);
    if (TDShop.sdkInitialized()) {
      mBannerView.load();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    getActionBar();
  }
}
