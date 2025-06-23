package com.android.support.interfaces;

import android.widget.LinearLayout;

public interface IMenuComponentFactory {
    void Switch(LinearLayout linLayout, final int featNum, final String featName, boolean swiOn);
    void SeekBar(LinearLayout linLayout, final int featNum, final String featName, final int min, int max);
    void Button(LinearLayout linLayout, final int featNum, final String featName);
    void ButtonLink(LinearLayout linLayout, final String featName, final String url);
    void ButtonOnOff(LinearLayout linLayout, final int featNum, String featName, boolean switchedOn);
    void Spinner(LinearLayout linLayout, final int featNum, final String featName, final String list);
    void InputNum(LinearLayout linLayout, final int featNum, final String featName, final int maxValue);
    void InputLNum(LinearLayout linLayout, final int featNum, final String featName, final long maxValue);
    void InputText(LinearLayout linLayout, final int featNum, final String featName);
    void CheckBox(LinearLayout linLayout, final int featNum, final String featName, boolean switchedOn);
    void RadioButton(LinearLayout linLayout, final int featNum, String featName, final String list);
    void Collapse(LinearLayout linLayout, final String text, final boolean expanded);
    void Category(LinearLayout linLayout, String text);
    void TextView(LinearLayout linLayout, String text);
    void WebTextView(LinearLayout linLayout, String text);
}
