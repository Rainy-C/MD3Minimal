# MD3 Minimal

最简单的 Java + Material Design 3 应用：**零控件**，只做状态栏 + 小白条（手势导航栏）沉浸。

## 它做了什么

- `Theme.Material3.DayNight.NoActionBar`：MD3 主题、Material You 动态取色、自动深浅色
- `WindowCompat.setDecorFitsSystemWindows(false)`：内容延伸到系统栏后面
- 状态栏 / 导航栏 `TRANSPARENT` + 关闭对比度遮罩（Android 10+）
- 按 UI 模式自动切换系统栏图标深浅

## Git 工作流编译（GitHub Actions 云端出包，本地不需要装任何东西）

```bash
git init
git add .
git commit -m "init: md3 minimal"
git branch -M main
git remote add origin https://github.com/<你的用户名>/<仓库名>.git
git push -u origin main
```

推送后打开仓库的 **Actions** 页 → 等 "Build APK" 跑绿 → 在该次运行底部下载
**md3-minimal-debug-apk** 工件，里面就是 `app-debug.apk`，直接安装即可。

之后每次 `git push` 都会自动重新编译。
