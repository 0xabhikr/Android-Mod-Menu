package com.android.support.ThemesData.DZ;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.support.Menu;
import com.android.support.base.FloatingWindowManager;
import com.android.support.interfaces.IMenuData;
import com.android.support.interfaces.IMenuTheme;

public class DZTheme implements IMenuTheme {
    FloatingWindowManager windowManager;
    DZShared shared;
    /**
     *
     */
    @Override
    public void Init(Context context, final IMenuData menuData) {
        shared = new DZShared();
        windowManager = new FloatingWindowManager(context, shared);
        DZMain main = new DZMain(context, shared);
        main.setData(new IMenuData() {
            @Override
            public String Icon() {
                return menuData.Icon();
            }

            @Override
            public String IconWebViewData() {
                return menuData.IconWebViewData();
            }

            @Override
            public String[] GetFeatureList() {
                return menuData.GetFeatureList();
            }

            @Override
            public String[] SettingsList() {
                return menuData.SettingsList();
            }

            @Override
            public boolean IsGameLibLoaded() {
                return menuData.IsGameLibLoaded();
            }

            @Override
            public View.OnTouchListener onTouchListener() {
                return windowManager.onTouchListener();
            }

            @Override
            public void Init(Context context, TextView title, TextView subTitle) {
                menuData.Init(context, title, subTitle);
            }
        });
        shared.menu.build();
    }

    /**
     *
     */
    @Override
    public void ShowMenu() {
        shared.menu.show();
    }

    /**
     * @param view
     */
    @Override
    public void setVisibility(int view) {
        shared.menu.setVisibility(view);
    }

    /**
     *
     */
    @Override
    public void onDestroy() {
        shared.menu.destroy();
    }

    /**
     *
     */
    @Override
    public void SetWindowManagerWindowService() {
        windowManager.SetWindowManagerWindowService();
    }

    /**
     *
     */
    @Override
    public void SetWindowManagerActivity() {

        windowManager.SetWindowManagerActivity();
    }
}
