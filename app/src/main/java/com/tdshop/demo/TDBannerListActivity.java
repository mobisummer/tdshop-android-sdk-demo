package com.tdshop.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tdshop.android.TDBannerView;
import com.tdshop.android.TDShopException;
import com.tdshop.android.creative.CreativeViewListener;

public class TDBannerListActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_td_banner_list);

    RecyclerView recyclerView = findViewById(R.id.rv_banner);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new Adapter<BannerViewHolder>() {
      private String[] args = {"", "", "", "", "", "", "", "", "", "", ""};

      @NonNull
      @Override
      public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_banner, null, false);
        return new BannerViewHolder(view);
      }

      @Override
      public void onBindViewHolder(@NonNull final BannerViewHolder viewHolder, int i) {
        viewHolder.bannerView.setCreativeViewListener(new CreativeViewListener() {
          @Override
          public void onCreativeError(TDShopException e) {

          }

          @Override
          public void onCreativeLoaded(View view) {
            viewHolder.bannerView.show();
          }

          @Override
          public void onCreativeShowed(View view) {

          }

          @Override
          public void onCreativeClosed(View view) {

          }

          @Override
          public void onCreativeClicked(View view) {

          }
        });
        viewHolder.bannerView.load();
      }

      @Override
      public int getItemCount() {
        return args.length;
      }
    });


  }

  class BannerViewHolder extends ViewHolder {

    public TDBannerView bannerView;

    public BannerViewHolder(@NonNull View itemView) {
      super(itemView);
      this.bannerView = itemView.findViewById(R.id.td_banner);
    }
  }
}
