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