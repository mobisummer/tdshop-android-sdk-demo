package com.tdshop.demo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.tdshop.android.creative.CreativeRequest;
import com.tdshop.android.creative.CreativeViewListener;
import com.tdshop.android.creative.MultiCreativeViewDelegate;
import com.tdshop.android.creative.model.CreativeMaterial;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomBannerView class.
 *
 * @author Lucas Cheung.
 * @date 2019-05-22.
 */
public class CustomBannerView extends Banner {

  private MultiCreativeViewDelegate mMultiCreativeViewDelegate;

  public CustomBannerView(Context context) {
    this(context, null);
  }

  public CustomBannerView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public CustomBannerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mMultiCreativeViewDelegate = new MultiCreativeViewDelegate(this);
    setOnBannerListener(
        new OnBannerListener() {
          @Override
          public void OnBannerClick(int position) {
            if (mMultiCreativeViewDelegate.getCreativeMaterialData().isEmpty()){
              return;
            }
            mMultiCreativeViewDelegate.performClick(
                mMultiCreativeViewDelegate.getCreativeMaterialData().get(position).getCreativeId());
          }
        });
    setImageLoader(new GlideImageLoader());
  }

  public void load(String id, String... tags) {
    mMultiCreativeViewDelegate.loadCreative(
        CreativeRequest.builder().placementId(id).tags(tags).build());
  }

  public void show(){
    List<String> imgs = new ArrayList<>();
    for (CreativeMaterial creativeMaterialData : mMultiCreativeViewDelegate.getCreativeMaterialData()) {
      imgs.add(creativeMaterialData.getImageUrl());
    }
    setImages(imgs).start();
  }

  public void setCreateListener(CreativeViewListener listener) {
    mMultiCreativeViewDelegate.setCreateListener(listener);
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    mMultiCreativeViewDelegate.performShow();
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    mMultiCreativeViewDelegate.performClosed();
  }

  public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

      // Glide 加载图片简单用法
      Glide.with(context).load(path).into(imageView);
    }

    // 提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
    @Override
    public ImageView createImageView(Context context) {
      return new ImageView(context);
    }
  }
}
