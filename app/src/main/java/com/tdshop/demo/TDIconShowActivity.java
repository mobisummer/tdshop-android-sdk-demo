package com.tdshop.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.tdshop.android.TDIconView;
import com.tdshop.android.TDShop;
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
    if (TDShop.sdkInitialized()) {
      mIconView.load();
    }
  }
}
