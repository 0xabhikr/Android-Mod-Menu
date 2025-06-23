package com.android.support.interfaces;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public interface IFloatingBuilder
{
    void SetWindowManagerWindowService();
    void SetWindowManagerActivity();
    View.OnTouchListener onTouchListener();

}
