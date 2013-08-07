package android.support.v4.view.accessibility;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.List;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;




class AccessibilityNodeInfoCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.967 -0400", hash_original_method = "90D82575443FCC4920A59159F197ECDC", hash_generated_method = "90D82575443FCC4920A59159F197ECDC")
    public AccessibilityNodeInfoCompatIcs ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static Object obtain() {
        return AccessibilityNodeInfo.obtain();
    }

    
    @DSModeled(DSC.SPEC)
    public static Object obtain(View source) {
        return AccessibilityNodeInfo.obtain(source);
    }

    
    @DSModeled(DSC.SPEC)
    public static Object obtain(Object info) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) info);
    }

    
    @DSModeled(DSC.SPEC)
    public static void addAction(Object info, int action) {
        ((AccessibilityNodeInfo) info).addAction(action);
    }

    
    @DSModeled(DSC.SPEC)
    public static void addChild(Object info, View child) {
        ((AccessibilityNodeInfo) info).addChild(child);
    }

    
    @SuppressWarnings("unchecked")
    public static List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
        Object result = ((AccessibilityNodeInfo) info).findAccessibilityNodeInfosByText(text);
        return (List<Object>) result;
    }

    
    @DSModeled(DSC.SPEC)
    public static int getActions(Object info) {
        return ((AccessibilityNodeInfo) info).getActions();
    }

    
    @DSModeled(DSC.SPEC)
    public static void getBoundsInParent(Object info, Rect outBounds) {
        ((AccessibilityNodeInfo) info).getBoundsInParent(outBounds);
    }

    
    @DSModeled(DSC.SPEC)
    public static void getBoundsInScreen(Object info, Rect outBounds) {
        ((AccessibilityNodeInfo) info).getBoundsInScreen(outBounds);
    }

    
    @DSModeled(DSC.SPEC)
    public static Object getChild(Object info, int index) {
        return ((AccessibilityNodeInfo) info).getChild(index);
    }

    
    @DSModeled(DSC.SPEC)
    public static int getChildCount(Object info) {
        return ((AccessibilityNodeInfo) info).getChildCount();
    }

    
    @DSModeled(DSC.SPEC)
    public static CharSequence getClassName(Object info) {
        return ((AccessibilityNodeInfo) info).getClassName();
    }

    
    @DSModeled(DSC.SPEC)
    public static CharSequence getContentDescription(Object info) {
        return ((AccessibilityNodeInfo) info).getContentDescription();
    }

    
    @DSModeled(DSC.SPEC)
    public static CharSequence getPackageName(Object info) {
        return ((AccessibilityNodeInfo) info).getPackageName();
    }

    
    @DSModeled(DSC.SPEC)
    public static Object getParent(Object info) {
        return ((AccessibilityNodeInfo) info).getParent();
    }

    
    @DSModeled(DSC.SPEC)
    public static CharSequence getText(Object info) {
        return ((AccessibilityNodeInfo) info).getText();
    }

    
    @DSModeled(DSC.SPEC)
    public static int getWindowId(Object info) {
        return ((AccessibilityNodeInfo) info).getWindowId();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isCheckable(Object info) {
        return ((AccessibilityNodeInfo) info).isCheckable();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isChecked(Object info) {
        return ((AccessibilityNodeInfo) info).isChecked();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isClickable(Object info) {
        return ((AccessibilityNodeInfo) info).isClickable();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isEnabled(Object info) {
        return ((AccessibilityNodeInfo) info).isEnabled();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isFocusable(Object info) {
        return ((AccessibilityNodeInfo) info).isFocusable();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isFocused(Object info) {
        return ((AccessibilityNodeInfo) info).isFocused();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isLongClickable(Object info) {
        return ((AccessibilityNodeInfo) info).isLongClickable();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isPassword(Object info) {
        return ((AccessibilityNodeInfo) info).isPassword();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isScrollable(Object info) {
        return ((AccessibilityNodeInfo) info).isScrollable();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isSelected(Object info) {
        return ((AccessibilityNodeInfo) info).isSelected();
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean performAction(Object info, int action) {
        return ((AccessibilityNodeInfo) info).performAction(action);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setBoundsInParent(Object info, Rect bounds) {
        ((AccessibilityNodeInfo) info).setBoundsInParent(bounds);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setBoundsInScreen(Object info, Rect bounds) {
        ((AccessibilityNodeInfo) info).setBoundsInScreen(bounds);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setCheckable(Object info, boolean checkable) {
        ((AccessibilityNodeInfo) info).setCheckable(checkable);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setChecked(Object info, boolean checked) {
        ((AccessibilityNodeInfo) info).setChecked(checked);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setClassName(Object info, CharSequence className) {
        ((AccessibilityNodeInfo) info).setClassName(className);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setClickable(Object info, boolean clickable) {
        ((AccessibilityNodeInfo) info).setClickable(clickable);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setContentDescription(Object info, CharSequence contentDescription) {
        ((AccessibilityNodeInfo) info).setContentDescription(contentDescription);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setEnabled(Object info, boolean enabled) {
        ((AccessibilityNodeInfo) info).setEnabled(enabled);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setFocusable(Object info, boolean focusable) {
        ((AccessibilityNodeInfo) info).setFocusable(focusable);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setFocused(Object info, boolean focused) {
        ((AccessibilityNodeInfo) info).setFocused(focused);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setLongClickable(Object info, boolean longClickable) {
        ((AccessibilityNodeInfo) info).setLongClickable(longClickable);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setPackageName(Object info, CharSequence packageName) {
        ((AccessibilityNodeInfo) info).setPackageName(packageName);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setParent(Object info, View parent) {
        ((AccessibilityNodeInfo) info).setParent(parent);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setPassword(Object info, boolean password) {
        ((AccessibilityNodeInfo) info).setPassword(password);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setScrollable(Object info, boolean scrollable) {
        ((AccessibilityNodeInfo) info).setScrollable(scrollable);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setSelected(Object info, boolean selected) {
        ((AccessibilityNodeInfo) info).setSelected(selected);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setSource(Object info, View source) {
        ((AccessibilityNodeInfo) info).setSource(source);
    }

    
    @DSModeled(DSC.SPEC)
    public static void setText(Object info, CharSequence text) {
        ((AccessibilityNodeInfo) info).setText(text);
    }

    
    @DSModeled(DSC.SPEC)
    public static void recycle(Object info) {
        ((AccessibilityNodeInfo) info).recycle();
    }

    
}

