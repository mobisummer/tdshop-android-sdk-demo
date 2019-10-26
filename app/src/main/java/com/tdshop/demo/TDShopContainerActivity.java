package com.tdshop.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tdshop.android.ActionCallback;
import com.tdshop.android.TDShopContainer;
import com.tdshop.android.TDShopContainer.HybridActionListener;

public class TDShopContainerActivity extends AppCompatActivity {

  private EditText mPidEt;
  private Button mLoadBt;
  private TDShopContainer mTDShopContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tdshop_container);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("TDShopContainer");
    }

    mTDShopContainer = new TDShopContainer();
    Fragment containerFragment = mTDShopContainer.init(new HybridActionListener() {
      @Override
      public boolean onHybridRequestClose() {
        finish();
        return true;
      }
    });
    getSupportFragmentManager().beginTransaction().replace(R.id.content, containerFragment)
        .commit();
    mPidEt = findViewById(R.id.et_pid);
    mLoadBt = findViewById(R.id.bt_load);
    mLoadBt.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            mTDShopContainer.load(mPidEt.getText().toString().trim(), new ActionCallback() {
              @Override
              public void onSucceed() {
                Toast.makeText(TDShopContainerActivity.this, "load success", Toast.LENGTH_SHORT)
                    .show();
              }

              @Override
              public void onFailed(Exception e) {
                Toast.makeText(TDShopContainerActivity.this, "load failed", Toast.LENGTH_SHORT)
                    .show();
                e.printStackTrace();
              }
            });
          }
        });
  }
}
