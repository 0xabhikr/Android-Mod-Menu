package com.android.support.interfaces;

import android.content.Context;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import android.view.View;

public class IShared {


    public LinearLayout mExpanded, mods, mSettings, mCollapse;
    public LinearLayout.LayoutParams scrlLLExpanded, scrlLL;
    public WindowManager mWindowManager;
    public WindowManager.LayoutParams vmParams;
    public ImageView startimage;
    public FrameLayout rootFrame;
    public ScrollView scrollView;
    public boolean stopChecking, overlayRequired;
    public Context getContext;


    public RelativeLayout mCollapsed, mRootContainer;

    public  boolean isViewCollapsed() {
        return rootFrame == null || mCollapsed.getVisibility() == View.VISIBLE;
    }
}
