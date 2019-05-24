package com.tdshop.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.tdshop.android.TDIconView;

public class TDIconShowActivity extends AppCompatActivity {

  private TDIconView mIconView;
  private TDIconView mIconView2;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_td_icon_show);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDIconView");
    }
    mIconView = findViewById(R.id.v_icon);
    mIconView2 = findViewById(R.id.v_icon_2);
    mIconView2.setPlacementId("myshop_icon_001");
    mIconView.show();
    mIconView2.show();
  }
}
