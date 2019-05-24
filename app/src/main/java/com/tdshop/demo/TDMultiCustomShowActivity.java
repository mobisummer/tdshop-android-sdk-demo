package com.tdshop.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tdshop.android.TDShop;
import com.tdshop.android.TDShopException;
import com.tdshop.android.creative.CreativeViewListener;

public class TDMultiCustomShowActivity extends AppCompatActivity {

  CustomBannerView banner;
  private EditText mPidEt;
  private EditText mTagsEt;
  private Button mLoadBt;

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
    mPidEt = findViewById(R.id.et_pid);
    mTagsEt = findViewById(R.id.et_tags);
    mLoadBt = findViewById(R.id.bt_load);
    mLoadBt.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            if (!TDShop.isSdkInitialized()) {
              Toast.makeText(TDMultiCustomShowActivity.this, "init sdk first", Toast.LENGTH_SHORT)
                  .show();
              return;
            }
            String[] tags;
            String tagStr = mTagsEt.getText().toString();
            if (TextUtils.isEmpty(tagStr)){
              tags = null;
            } else {
              tags = tagStr.split(" ");
            }
            banner.load(mPidEt.getText().toString().trim(), tags);
          }
        });
  }
}
