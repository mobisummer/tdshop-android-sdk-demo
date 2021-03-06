# V2.3.5
- 【修复】Thread starting during runtime shutdown
- 【修复】修复某些手机因为没有read phone state权限导致的崩溃问题
- 【修复】修复Google play后台提醒的安全漏洞问题

# V2.3.3
- 【修复】修复内置浏览器Scheme兼容性问题
- 【修复】修复线上已知的问题

# V2.3.2
- 【修复】修复内嵌型商城Fragment被添加到ChildFragmentManager中出现的ClassCastException
- 【修复】修复内嵌型商城入口初始化时可能出现的NPE问题

# V2.3.1
- 【修复】修复内嵌型商城入口加载错误的时候出现的NPE问题
- 【修复】Catch deadSystemException
- 【修复】解决在子线程中开启子线程可能造成的Thread start runtime shutdown 问题
- 【修复】修复获取进程名的时候出现的NPE问题
- 【修复】更新了TDBannerView、TDIconView的接入文档

# V2.3.0
- 【增强】相比2.2版本SDK包体积减少300KB，功能不减
- 【变更】自动初始化逻辑变更，使用自动初始化需要在AndroidManifest添加TDInitProvider
- 【增强】新增内嵌型商城入口

# V2.2.10
- 【修复】java.lang.ArithmeticException: divide by zero
- 【修复】java.lang.IllegalStateException closed
- 【修复】修复了在特定情况下网络输出流没有关闭的bug
- 【修复】接口请求优化

# V2.2.9
- 【增强】入口图片展示已支持 GIF，无需依赖第三方库
- 【修复】修复了因2.2.8版本Glide版兼容性问题，导致加载入口时ANR或崩溃
- 【变更】该版本依赖了Google play services 16.0.0

# V2.2.8
- 【变更】入口加载GIF方式进行了变更，由原本使用pl.droidsonroids.gif加载gif变更为Glide
- 【修复】修复设备id高版本重复的问题，导致DAU数据有偏差
- 【修复】修复CreativeViewListener onCreativeShowed 不回调的问题
- 【增强】更新demo

# V2.2.7
- 【修复】Bug fix
     - java.lang.ClassCastException: LinkedTreeMap cannot be cast to HostInfo
     - NPE: Offer empty
     - Thread starting during runtime shutdown
     - 图片加载 ConcurrentModificationException

# V2.2.6
- 【修复】Bug fix
    - 修复Gson解析等已知线上崩溃问题
- 【增强】增强SDK稳定性和拓展性

# V2.2.5
- 【修复】Bug fix
    - `MultiCreativeViewDelegate`执行`performClick`无效的问题

# V2.2.4
- 【增强】TDBannerView 增加320*50的尺寸

# V2.2.3
- 【修复】Bug fix
    - 修复已知线上崩溃问题
- 【增强】增强SDK稳定性和拓展性

# V2.2.2
- 【修复】Bug fix
    - 修复了由于单例引起的NullPointerException

# V2.2.1
- 【修复】Bug fix
    - 修复OK3造成的崩溃BUG
    - 修复守护进程休眠超时造成的崩溃BUG
    - 修复图片加载问题
    - ...
- 【增强】提升网络接口稳定性
- 【增强】提升SDK稳定性
- 【新增】可控制使用外部浏览器打开广告链接

# V2.1.1
- 【修复】拦截三星 5.0 系统，Gson 异常问题

# V2.1.0
- 【新增】商城底部新增工具栏
- 【修复】WebView目录冲突无需主应用做处理
- 【新增】新的错误页UI
- 【修复】Bugfix
    - DeadSystemException
    - InternalError
    - `<input>` 失效问题
    - NPE
    - 非 http、https 链接加载问题

# V2.0.6
- 【提升】仓库迁移至 JCenter ，提升加载速度
- 【新增】`CreativeViewDelegate` 新增 `CreativeViewDelegate(@NonNull Context context)` 构造函数，以方便拆分数据与视图
- 【修复】修复商城回退失效问题
- 【修复】`MultiCreativeViewDelegate`数据第一次回调时为空的问题

# V2.0.2
- 【修复】修复序列化时，classloader 错误导致崩溃

# V2.0.1
- 【修复】修复转盘页无法显示问题

# V2.0.0
- 【修复】修复8.0以上Service不能运行在Background，影响用户无法进入商城
- 【提升】提升首屏加载速度
- 【修复】修复了商城内new tabs白屏，影响用户支付

# V1.3.0
- 【修复】修复加入购物车时，部分机型无法挑选数量或挑选数量后崩溃问题

# V1.2.7
- 【修复】部分机型无法加购问题
- 【修复】部分机型 select 标签导致的崩溃问题
- 【修复】部分机型重新进入商城崩溃问题

# V1.2.3
- GIF 依赖增加支持 `armeabi` 架构

# V1.2.2
- 【新增】[TDBanner](../README.md/#tdbanner)、[TDIcon](../README.md/#tdicon)、[插屏广告](../README.md/#interstitialview) 支持 `GIF`。
- 【提升】提升首屏加载速度

# V1.2.1
- 【新增】[MultiCreativeViewDelegate](../README.md/#multiCreativeViewDelegate)支持传入特定标签数组，返回多个素材，每个素材都有自己的跳转逻辑。
- 【新增】[CreativeViewDelegate](../README.md/#creativeViewDelegate)新增获取当前素材的方法

# V1.1.0
- [TDBanner](../README.md/#tdbanner)、[TDIcon](../README.md/#tdicon)、[插屏广告](../README.md/#interstitialview) 新增 `placementId` 设置,用于支持多入口方案。**旧版中，使用 [TDCreativeViewDelegate](../README.md/#tdcreativeviewdelegate) 的不受影响，[TDBanner](../README.md/#tdbanner)、[TDIcon](../README.md/#tdicon)、[插屏广告](../README.md/#interstitialview)，则会使用下发配置中第一个匹配类型的资源用于显示与跳转**
- 修复部分兼容性导致的崩溃