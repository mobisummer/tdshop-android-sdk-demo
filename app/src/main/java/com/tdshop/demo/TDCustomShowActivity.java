package com.tdshop.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.tdshop.android.TDShop;
import com.tdshop.android.TDShopException;
import com.tdshop.android.creative.CreativeViewListener;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class TDCustomShowActivity extends AppCompatActivity {

  private RectangularView mCustomCreativeView;
  private EditText mPidEt;
  private Button mLoadBt;
  private Badge mBadge;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tdcustom_show);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDCustomView");
    }
    mPidEt = findViewById(R.id.et_pid);
    mCustomCreativeView = findViewById(R.id.v_custom_creative);
    mCustomCreativeView.setCreateListener(
        new CreativeViewListener() {
          @Override
          public void onCreativeError(TDShopException exception) {
            Log.e("CustomCreativeView", exception.getMessage());
            Toast.makeText(TDCustomShowActivity.this, exception.getMessage(), Toast.LENGTH_SHORT)
                .show();
          }

          @Override
          public void onCreativeLoaded(View view) {
            Log.d("CustomCreativeView", "onCreativeLoaded");
            Toast.makeText(
                TDCustomShowActivity.this, "CustomCreativeView Loaded", Toast.LENGTH_SHORT)
                .show();
            if (mCustomCreativeView.getCreativeMaterial() == null) {
              return;
            }
            Glide.with(view.getContext())
                .load(mCustomCreativeView.getCreativeMaterial().getImageUrl())
                .into(mCustomCreativeView);
            mBadge.setBadgeText(mCustomCreativeView.getCreativeMaterial().getContent());
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
    mLoadBt = findViewById(R.id.bt_load);
    mLoadBt.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            if (!TDShop.isSdkInitialized()) {
              Toast.makeText(TDCustomShowActivity.this, "init sdk first", Toast.LENGTH_SHORT)
                  .show();
              return;
            }
            mCustomCreativeView.load(mPidEt.getText().toString().trim());
          }
        });
    mBadge = setBadge(mCustomCreativeView);
  }

  public static Badge setBadge(View menuActionView) {
    Badge badge = new QBadgeView(menuActionView.getContext());
    badge.bindTarget(menuActionView);
    badge.setBadgeGravity(Gravity.TOP | Gravity.END);
    badge.setGravityOffset(4f, 6f, true);
    badge.setBadgePadding(1f, true);
    return badge;
  }
}
