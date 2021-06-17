package com.sd.lib.loading;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FLoadingView extends FrameLayout {
    private View view_content;
    private View view_progress;
    private TextView tv_text;
    private boolean mConsumeTouchEvent = true;

    public FLoadingView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.lib_loading_view_loading, this, true);
        view_content = findViewById(R.id.lib_loading_view_content);
        view_progress = findViewById(R.id.lib_loading_view_progress);
        tv_text = findViewById(R.id.lib_loading_tv_text);
    }

    /**
     * 设置是否拦截触摸事件，默认true
     */
    public void setConsumeTouchEvent(boolean consume) {
        mConsumeTouchEvent = consume;
    }

    /**
     * 设置文字
     */
    public void setText(String text) {
        tv_text.setText(text);
        tv_text.setVisibility(TextUtils.isEmpty(text) ? GONE : VISIBLE);
    }

    /**
     * 设置进度圈的大小
     */
    public void setProgressSize(int size) {
        final ViewGroup.LayoutParams params = view_progress.getLayoutParams();
        if (params.width != size || params.height != size) {
            params.width = size;
            params.height = size;
            view_progress.setLayoutParams(params);
        }
    }

    /**
     * 设置内容区域背景资源id
     *
     * @param resId 景资源id
     */
    public void setContentBackgroundResource(int resId) {
        view_content.setBackgroundResource(resId);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mConsumeTouchEvent) {
            super.onTouchEvent(event);
            return true;
        }
        return super.onTouchEvent(event);
    }
}
