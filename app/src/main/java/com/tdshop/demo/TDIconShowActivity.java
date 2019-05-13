package com.tdshop.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tdshop.android.TDIconView;
import com.tdshop.android.TDShop;
import com.tdshop.android.TDShopException;
import com.tdshop.android.creative.CreativeViewListener;
import java.util.Objects;

public class TDIconShowActivity extends AppCompatActivity {

  private TDIconView mIconView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_td_icon_show);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDIconView");
    }
    mIconView = findViewById(R.id.v_icon);
    mIconView.setCreativeViewListener(new CreativeViewListener() {
      @Override
      public void onCreativeError(TDShopException exception) {

      }

      @Override
      public void onCreativeLoaded(View view) {
        mIconView.show();
      }

      @Override
      public void onCreativeShowed(View view) {

      }

      @Override
      public void onCreativeClicked(View view) {

      }

      @Override
      public void onCreativeClosed(View view) {

      }
    });
    mIconView.load();
  }
}
