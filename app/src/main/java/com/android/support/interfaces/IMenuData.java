package com.android.support.interfaces;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public abstract class IMenuData {
    public abstract String Icon();
    public abstract String IconWebViewData();
    public abstract String[] GetFeatureList();
    public abstract String[] SettingsList();
    public abstract boolean IsGameLibLoaded();
    public abstract View.OnTouchListener onTouchListener();
    public abstract void Init(Context context, TextView title, TextView subTitle);
}
