package com.android.support.base;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.android.support.interfaces.IFloatingBuilder;
import com.android.support.interfaces.IShared;

public class FloatingWindowManager implements IFloatingBuilder {

    IShared sharedData;


    int POS_X;
    int POS_Y;

    public FloatingWindowManager(Context context, IShared shared) {
        sharedData = shared;
        sharedData.getContext = context;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void SetWindowManagerWindowService() {
        int iparams = Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O ? 2038 : 2002;
        sharedData.vmParams = new WindowManager.LayoutParams(
                WRAP_CONTENT,
                WRAP_CONTENT,
                iparams,
                8 | FLAG_TRANSLUCENT_STATUS,
                -3);
        //params = new WindowManager.LayoutParams(WindowManager.LayoutParams.LAST_APPLICATION_WINDOW, 8, -3);
        sharedData.vmParams.gravity = 51;
        sharedData.vmParams.x = POS_X;
        sharedData.vmParams.y = POS_Y;

        sharedData.mWindowManager = (WindowManager) sharedData.getContext.getSystemService(sharedData.getContext.WINDOW_SERVICE);
        sharedData.mWindowManager.addView(sharedData.rootFrame, sharedData.vmParams);

        sharedData.overlayRequired = true;
    }


    @SuppressLint("WrongConstant")
    @Override
    public void SetWindowManagerActivity() {
        sharedData.vmParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                POS_X,//initialX
                POS_Y,//initialy
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                        WindowManager.LayoutParams.FLAG_SPLIT_TOUCH,
                PixelFormat.TRANSPARENT
        );
        sharedData.vmParams.gravity = 51;
        sharedData.vmParams.x = POS_X;
        sharedData.vmParams.y = POS_Y;

        sharedData.mWindowManager = ((Activity) sharedData.getContext).getWindowManager();
        sharedData.mWindowManager.addView(sharedData.rootFrame, sharedData.vmParams);
    }


    @Override
    public View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            final View collapsedView = sharedData.mCollapsed;
            final View expandedView = sharedData.mExpanded;
            private float initialTouchX, initialTouchY;
            private int initialX, initialY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = sharedData.vmParams.x;
                        initialY = sharedData.vmParams.y;
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int rawX = (int) (motionEvent.getRawX() - initialTouchX);
                        int rawY = (int) (motionEvent.getRawY() - initialTouchY);
                        sharedData.mExpanded.setAlpha(1f);
                        sharedData.mCollapsed.setAlpha(1f);
                        //The check for Xdiff <10 && YDiff< 10 because sometime elements moves a little while clicking.
                        //So that is click event.
                        if (rawX < 10 && rawY < 10 && sharedData.isViewCollapsed()) {
                            //When user clicks on the image view of the collapsed layout,
                            //visibility of the collapsed layout will be changed to "View.GONE"
                            //and expanded view will become visible.
                            try {
                                collapsedView.setVisibility(View.GONE);
                                expandedView.setVisibility(View.VISIBLE);
                            } catch (NullPointerException e) {

                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        sharedData.mExpanded.setAlpha(0.5f);
                        sharedData.mCollapsed.setAlpha(0.5f);
                        //Calculate the X and Y coordinates of the view.
                        sharedData.vmParams.x = initialX + ((int) (motionEvent.getRawX() - initialTouchX));
                        sharedData.vmParams.y = initialY + ((int) (motionEvent.getRawY() - initialTouchY));
                        //Update the layout with new X & Y coordinate
                        sharedData.mWindowManager.updateViewLayout(sharedData.rootFrame, sharedData.vmParams);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }



}
