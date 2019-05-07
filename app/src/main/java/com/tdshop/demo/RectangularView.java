package com.tdshop.demo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tdshop.android.creative.CreativeRequest;
import com.tdshop.android.creative.CreativeViewDelegate;
import com.tdshop.android.creative.CreativeViewListener;

/**
 * RectangularView class.
 *
 * @author Lucas Cheung.
 * @date 2019-05-05.
 */
public class RectangularView extends AppCompatImageView {

  private CreativeViewDelegate mCreativeViewDelegate;

  public RectangularView(Context context) {
    this(context, null);
  }

  public RectangularView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RectangularView(Context context,
      @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mCreativeViewDelegate = new CreativeViewDelegate(this);
  }

  public void load(String id) {
    mCreativeViewDelegate.loadCreative(
        CreativeRequest.builder().placementId(id).build());
  }

  public void setCreateListener(CreativeViewListener listener) {
    mCreativeViewDelegate.setCreateListener(listener);
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    mCreativeViewDelegate.performShow();
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    mCreativeViewDelegate.performClosed();
  }

  @Override
  public boolean performClick() {
    return mCreativeViewDelegate.performClick();
  }
}
