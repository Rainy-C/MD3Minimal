package com.example.md3min;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/**
 * 最简单的 MD3 应用：零控件，只做状态栏 + 小白条（手势导航栏）沉浸。
 * 不调用 setContentView()，整个窗口就是 MD3 主题的背景色。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1) edge-to-edge：让内容延伸到状态栏和小白条后面
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        // 2) 两个系统栏全透明
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);

        // 3) Android 10+ 关掉系统栏上的半透明"对比度遮罩"，真·全透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            getWindow().setStatusBarContrastEnforced(false);
            getWindow().setNavigationBarContrastEnforced(false);
        }

        // 4) 按深/浅色模式切换系统栏图标颜色：浅色背景配深色图标，反之亦然
        boolean night = (getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
        WindowInsetsControllerCompat c =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        c.setAppearanceLightStatusBars(!night);
        c.setAppearanceLightNavigationBars(!night);
    }
}
