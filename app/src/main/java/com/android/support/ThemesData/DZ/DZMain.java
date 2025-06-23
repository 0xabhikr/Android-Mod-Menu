package com.android.support.ThemesData.DZ;

import android.content.Context;

import com.android.support.interfaces.IMenuData;

public class DZMain {
    DZShared shared;

    public DZMain(Context context, DZShared shared) {
        this.shared = shared;
        this.shared.MenuStyle = new DZStyle();
        this.shared.getContext = context;
        this.shared.components = new DZMenuComponents(shared);
        this.shared.menu = new DZMenu(shared);
    }

    public void setData(IMenuData data) {
        this.shared.MenuData = data;
    }
}
