package com.tdshop.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.tdshop.android.TDShopException;
import com.tdshop.android.creative.CreativeViewListener;

public class TDMultiCustomShowActivity extends AppCompatActivity {

  CustomBannerView banner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tdmulti_custom_show);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDMultiCustomView");
    }
    banner = findViewById(R.id.banner);
    banner.setCreateListener(new CreativeViewListener() {
      @Override
      public void onCreativeError(TDShopException exception) {
        Log.e("CustomCreativeView", exception.getMessage());
        Toast.makeText(TDMultiCustomShowActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

      }

      @Override
      public void onCreativeLoaded(View view) {
        Log.d("CustomCreativeView", "onCreativeLoaded");
        Toast.makeText(TDMultiCustomShowActivity.this, "CustomCreativeView Loaded", Toast.LENGTH_SHORT).show();
        banner.show();
      }

      @Override
      public void onCreativeShowed(View view) {
        Log.d("CustomCreativeView", "onCreativeShowed");

      }

      @Override
      public void onCreativeClosed(View view) {
        Log.d("CustomCreativeView", "onCreativeClosed");

      }

      @Override
      public void onCreativeClicked(View view) {
        Log.d("CustomCreativeView", "onCreativeClicked");
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    banner.load("myshop_tag_001", "wig");
  }
}
