# Android 端 SDK 接入指引

## 1. SDK 引入

1.1 在**项目**的 `buidl.gradle` 加入

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://raw.githubusercontent.com/mobisummer/tdshop-android-sdk/master" }
    }
}
```

1.2 在**模块**的 `build.gradle` 文件中加入

```
implementation 'com.tdshop.android:sdk:0.6'
```

> **最低支持 Android Sdk 19**

## 2. 初始化

在 `Application` 中进行初始化

```java
    //开启 Debug 模式
    TDShop.setIsDebugEnabled(true);
    TDShop.sdkInitialize(context, APP_ID, new ActionCallback() {
      @Override
      public void onSuccess() {
      }

      @Override
      public void onFailed(Exception e) {
      }
    });
```
> **`APP_ID` 请联系商务获取。**


## 3. 加载商城入口

目前提供的商城入口有
- Banner 图片入口 （[TDBannerView]()）
- 图标图标入口 （[TDIconView]()）
- 插屏广告入口 （[showInterstitialView]()）

### 3.1 TDBannerView

触发 `load()` 操作后加载图片，点击 Banner 会跳转至商城首页。

- MidasBanner宽高比例为720:372
- 如果宽为精准尺寸高为最大尺寸，则会以宽为基准测量高。
- 如果高为精准尺寸宽为最大尺寸，则会以高为基准测量宽。
- 如果宽高都为精准尺寸，则不会按照比例测量
- 如果宽高都为未指定尺寸，则会按照原本图片大小测量

1. 在布局文件中添加 `TDBannerView`

```xml
  <com.tdshop.android.TDBannerView
    android:id="@+id/v_banner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

2. 在 Java 代码中加载图片

```java
public class MainActivity extends AppCompatActivity {
    private CreativeView mBannerView;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          ...
          mBannerView = findViewById(R.id.v_banner);
          mBannerView.load();
          ...
      }
}
```
> **注意，初始化失败会导致图片加载不出来**

### 3.2 TDIConView

触发 `load()` 操作后加载图片，点击 Icon 会跳转商城。

- TDIConView宽高比例为1:1
- 如果宽为精准尺寸高为最大尺寸，则会以宽为基准测量高。
- 如果高为精准尺寸宽为最大尺寸，则会以高为基准测量宽。
- 如果宽高都为精准尺寸，则不会按照比例测量
- 如果宽高都为未指定尺寸，则会按照原本图片大小测量

1. 在布局文件中添加 `TDIConView`

```xml
  <com.tdshop.android.TDIConView
    android:id="@+id/v_icon"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

2. 在 Java 代码中加载图片

```java
public class MainActivity extends AppCompatActivity {
    private CreativeView mIconView;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          ...
          mIconView = findViewById(R.id.v_icon);
          mIconView.load();
          ...
      }

}
```

> **注意，初始化失败会导致图片加载不出来**

### 3.3 显示插屏广告

显示插屏广告，只需在代码中调用即可。点击广告就会跳转商城。

```java
TDShop.showInterstitialView(activity);
```
