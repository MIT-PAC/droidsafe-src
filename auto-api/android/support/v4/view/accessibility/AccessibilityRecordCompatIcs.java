package android.support.v4.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

class AccessibilityRecordCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.832 -0400", hash_original_method = "678927E14E90D812A19F157CA3C70FCB", hash_generated_method = "678927E14E90D812A19F157CA3C70FCB")
    public AccessibilityRecordCompatIcs ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static Object obtain() {
        return AccessibilityRecord.obtain();
    }

    
    @DSModeled(DSC.SAFE)
    public static Object obtain(Object record) {
        return AccessibilityRecord.obtain((AccessibilityRecord) record);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getAddedCount(Object record) {
        return ((AccessibilityRecord) record).getAddedCount();
    }

    
    @DSModeled(DSC.SAFE)
    public static CharSequence getBeforeText(Object record) {
        return ((AccessibilityRecord) record).getBeforeText();
    }

    
    @DSModeled(DSC.SAFE)
    public static CharSequence getClassName(Object record) {
        return ((AccessibilityRecord) record).getClassName();
    }

    
    @DSModeled(DSC.SAFE)
    public static CharSequence getContentDescription(Object record) {
        return ((AccessibilityRecord) record).getContentDescription();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getCurrentItemIndex(Object record) {
        return ((AccessibilityRecord) record).getCurrentItemIndex();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getFromIndex(Object record) {
        return ((AccessibilityRecord) record).getFromIndex();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getItemCount(Object record) {
        return ((AccessibilityRecord) record).getItemCount();
    }

    
    @DSModeled(DSC.SAFE)
    public static Parcelable getParcelableData(Object record) {
        return ((AccessibilityRecord) record).getParcelableData();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getRemovedCount(Object record) {
        return ((AccessibilityRecord) record).getRemovedCount();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getScrollX(Object record) {
        return ((AccessibilityRecord) record).getScrollX();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getScrollY(Object record) {
        return ((AccessibilityRecord) record).getScrollY();
    }

    
    @DSModeled(DSC.SAFE)
    public static Object getSource(Object record) {
        return ((AccessibilityRecord) record).getSource();
    }

    
    @DSModeled(DSC.SAFE)
    public static List<CharSequence> getText(Object record) {
        return ((AccessibilityRecord) record).getText();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getToIndex(Object record) {
        return ((AccessibilityRecord) record).getToIndex();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getWindowId(Object record) {
        return ((AccessibilityRecord) record).getWindowId();
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isChecked(Object record) {
        return ((AccessibilityRecord) record).isChecked();
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isEnabled(Object record) {
        return ((AccessibilityRecord) record).isEnabled();
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isFullScreen(Object record) {
        return ((AccessibilityRecord) record).isFullScreen();
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isPassword(Object record) {
        return ((AccessibilityRecord) record).isPassword();
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isScrollable(Object record) {
        return ((AccessibilityRecord) record).isScrollable();
    }

    
    @DSModeled(DSC.SAFE)
    public static void recycle(Object record) {
        ((AccessibilityRecord) record).recycle();
    }

    
    @DSModeled(DSC.SAFE)
    public static void setAddedCount(Object record, int addedCount) {
        ((AccessibilityRecord) record).setAddedCount(addedCount);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setBeforeText(Object record, CharSequence beforeText) {
        ((AccessibilityRecord) record).setBeforeText(beforeText);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setChecked(Object record, boolean isChecked) {
        ((AccessibilityRecord) record).setChecked(isChecked);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setClassName(Object record, CharSequence className) {
        ((AccessibilityRecord) record).setClassName(className);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setContentDescription(Object record, CharSequence contentDescription) {
        ((AccessibilityRecord) record).setContentDescription(contentDescription);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setCurrentItemIndex(Object record, int currentItemIndex) {
        ((AccessibilityRecord) record).setCurrentItemIndex(currentItemIndex);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setEnabled(Object record, boolean isEnabled) {
        ((AccessibilityRecord) record).setEnabled(isEnabled);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setFromIndex(Object record, int fromIndex) {
        ((AccessibilityRecord) record).setFromIndex(fromIndex);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setFullScreen(Object record, boolean isFullScreen) {
        ((AccessibilityRecord) record).setFullScreen(isFullScreen);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setItemCount(Object record, int itemCount) {
        ((AccessibilityRecord) record).setItemCount(itemCount);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setParcelableData(Object record, Parcelable parcelableData) {
        ((AccessibilityRecord) record).setParcelableData(parcelableData);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setPassword(Object record, boolean isPassword) {
        ((AccessibilityRecord) record).setPassword(isPassword);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setRemovedCount(Object record, int removedCount) {
        ((AccessibilityRecord) record).setRemovedCount(removedCount);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setScrollX(Object record, int scrollX) {
        ((AccessibilityRecord) record).setScrollX(scrollX);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setScrollY(Object record, int scrollY) {
        ((AccessibilityRecord) record).setScrollY(scrollY);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setScrollable(Object record, boolean scrollable) {
        ((AccessibilityRecord) record).setScrollable(scrollable);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setSource(Object record, View source) {
        ((AccessibilityRecord) record).setSource(source);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setToIndex(Object record, int toIndex) {
        ((AccessibilityRecord) record).setToIndex(toIndex);
    }

    
}

