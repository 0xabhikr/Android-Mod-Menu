# Step 3: Creating New Features

To add a feature to the mod menu:

1. Go to your `IMenuData` implementation.
2. Override `GetFeatureList()` and return your features like:

```java
@Override
public String[] GetFeatureList() {
    return new String[]{
        "0_Toggle_GodMode_True",
        "1_SeekBar_Speed_1_10",
        "2_ButtonOnOff_AutoAim_True",
        "3_InputText_PlayerName",
        "Category_Game Settings",
        "4_CollapseAdd_MoreSettings",
        "5_CheckBox_ActivateShield_True"
    };
}
```

### Format

- `0_Toggle_GodMode_True`
- `1_SeekBar_Speed_Min_Max`
- `2_ButtonOnOff_FeatureName`
- `3_InputText_CustomInput`

These are automatically parsed by `DZMenuComponents` or `LGLMenuComponents`.

