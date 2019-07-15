# V1.1.0
- [TDBanner](../README.md/#tdbanner)、[TDIcon](../README.md/#tdicon)、[插屏广告](../README.md/#interstitialview) 新增 `placementId` 设置,用于支持多入口方案。**旧版中，使用 [TDCreativeViewDelegate](../README.md/#tdcreativeviewdelegate) 的不受影响，[TDBanner](../README.md/#tdbanner)、[TDIcon](../README.md/#tdicon)、[插屏广告](../README.md/#interstitialview)，则会使用下发配置中第一个匹配类型的资源用于显示与跳转**
- 修复部分兼容性导致的崩溃

# V1.2.1
- 【新增】[MultiCreativeViewDelegate](../README.md/#multiCreativeViewDelegate)支持传入特定标签数组，返回多个素材，每个素材都有自己的跳转逻辑。
- 【新增】[CreativeViewDelegate](../README.md/#creativeViewDelegate)新增获取当
前素材的方法

# V1.2.2

- 【新增】[TDBanner](../README.md/#tdbanner)、[TDIcon](../README.md/#tdicon)、[插屏广告](../README.md/#interstitialview) 支持 `GIF`。
- 【提升】提升首屏加载速度

# V1.2.3

- GIF 依赖增加支持 `armeabi` 架构

# V1.2.7

- 【修复】部分机型无法加购问题
- 【修复】部分机型 select 标签导致的崩溃问题
- 【修复】部分机型重新进入商城崩溃问题

# V1.3.0

- 【修复】修复加入购物车时，部分机型无法挑选数量或挑选数量后崩溃问题

# V2.0.0

- 【修复】修复8.0以上Service不能运行在Background，影响用户无法进入商城
- 【提升】提升首屏加载速度
- 【修复】修复了商城内new tabs白屏，影响用户支付

# V2.0.1

- 【修复】修复转盘页无法显示问题

# V2.0.2

- 【修复】修复序列化时，classloader 错误导致崩溃

# V2.0.6

- 【提升】仓库迁移至 JCenter ，提升加载速度
- 【新增】`CreativeViewDelegate` 新增 `CreativeViewDelegate(@NonNull Context context)` 构造函数，以方便拆分数据与视图
- 【修复】修复商城回退失效问题
- 【修复】`MultiCreativeViewDelegate`数据第一次回调时为空的问题 

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
