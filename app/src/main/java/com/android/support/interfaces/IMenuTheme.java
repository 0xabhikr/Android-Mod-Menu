package com.android.support.interfaces;

import android.content.Context;

public interface IMenuTheme {
    void Init(Context context, IMenuData menuData);
    void ShowMenu();
    void setVisibility(int view);
    void onDestroy();
    void SetWindowManagerWindowService();
    void SetWindowManagerActivity();
}
