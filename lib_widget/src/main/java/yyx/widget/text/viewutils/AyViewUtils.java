package yyx.widget.text.viewutils;

import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * Desc: view 操作的工具类
 *
 * @author: Yang Yuanxiong
 * @date: 2022/6/28
 */
public class AyViewUtils {

    /**
     * @param view   view
     * @param params 父布局的LayoutParams
     * @param width  宽度
     */
    public static void setWidth(View view, ViewGroup.LayoutParams params, int width) {
        params.width = width;
        view.setLayoutParams(params);
    }

    /**
     * @param view   view
     * @param params 父布局的LayoutParams
     */
    public static void setMargin(View view, ViewGroup.MarginLayoutParams params, int left, int top, int right, int bottom) {
        params.setMargins(left, top, right, bottom);
        view.setLayoutParams(params);
    }


} 