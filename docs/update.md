# V1.1.0
- 新增入口 [TDCreativeLayout](../README.md/#tdcreativelayout)
- [TDBanner](../README.md/#tdbanner)、[TDIcon](../README.md/#tdicon)、[插屏广告](../README.md/#interstitialview) 新增 `placementId` 设置,用于支持多入口方案。**旧版中，使用 [TDCreativeViewDelegate](../README.md/#tdcreativeviewdelegate) 的不受影响，[TDBanner](../README.md/#tdbanner)、[TDIcon](../README.md/#tdicon)、[插屏广告](../README.md/#interstitialview)，则会使用下发配置中第一个匹配类型的资源用于显示与跳转**
- 修复部分兼容性导致的崩溃
