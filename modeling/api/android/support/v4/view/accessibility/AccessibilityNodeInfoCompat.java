/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.view.accessibility;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper for accessing {@link android.view.accessibility.AccessibilityNodeInfo}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class AccessibilityNodeInfoCompat {

    static interface AccessibilityNodeInfoImpl {
        public Object obtain();
        public Object obtain(View source);
        public Object obtain(Object info);
        public Object obtain(View root, int virtualDescendantId);
        public void setSource(Object info, View source);
        public void setSource(Object info, View root, int virtualDescendantId);
        public Object findFocus(Object info, int focus);
        public Object focusSearch(Object info, int direction);
        public int getWindowId(Object info);
        public int getChildCount(Object info);
        public Object getChild(Object info, int index);
        public void addChild(Object info, View child);
        public void addChild(Object info, View child, int virtualDescendantId);
        public int getActions(Object info);
        public void addAction(Object info, int action);
        public boolean performAction(Object info, int action);
        public boolean performAction(Object info, int action, Bundle arguments);
        public void setMovementGranularities(Object info, int granularities);
        public int getMovementGranularities(Object info);
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text);
        public Object getParent(Object info);
        public void setParent(Object info, View root, int virtualDescendantId);
        public void setParent(Object info, View parent);
        public void getBoundsInParent(Object info, Rect outBounds);
        public void setBoundsInParent(Object info, Rect bounds);
        public void getBoundsInScreen(Object info, Rect outBounds);
        public void setBoundsInScreen(Object info, Rect bounds);
        public boolean isCheckable(Object info);
        public void setCheckable(Object info, boolean checkable);
        public boolean isChecked(Object info);
        public void setChecked(Object info, boolean checked);
        public boolean isFocusable(Object info);
        public void setFocusable(Object info, boolean focusable);
        public boolean isFocused(Object info);
        public void setFocused(Object info, boolean focused);
        public boolean isVisibleToUser(Object info);
        public void setVisibleToUser(Object info, boolean visibleToUser);
        public boolean isAccessibilityFocused(Object info);
        public void setAccessibilityFocused(Object info, boolean focused);
        public boolean isSelected(Object info);
        public void setSelected(Object info, boolean selected);
        public boolean isClickable(Object info);
        public void setClickable(Object info, boolean clickable);
        public boolean isLongClickable(Object info);
        public void setLongClickable(Object info, boolean longClickable);
        public boolean isEnabled(Object info);
        public void setEnabled(Object info, boolean enabled);
        public boolean isPassword(Object info);
        public void setPassword(Object info, boolean password);
        public boolean isScrollable(Object info);
        public void setScrollable(Object info, boolean scrollable);
        public CharSequence getPackageName(Object info);
        public void setPackageName(Object info, CharSequence packageName);
        public CharSequence getClassName(Object info);
        public void setClassName(Object info, CharSequence className);
        public CharSequence getText(Object info);
        public void setText(Object info, CharSequence text);
        public CharSequence getContentDescription(Object info);
        public void setContentDescription(Object info, CharSequence contentDescription);
        public void recycle(Object info);
        public String getViewIdResourceName(Object info);
        public void setViewIdResourceName(Object info, String viewId);
        public int getLiveRegion(Object info);
        public void setLiveRegion(Object info, int mode);
    }

    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain() {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain(View source) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain(View root, int virtualDescendantId) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain(Object info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void addAction(Object info, int action) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void addChild(Object info, View child) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void addChild(Object info, View child, int virtualDescendantId) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            return Collections.emptyList();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getActions(Object info) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void getBoundsInParent(Object info, Rect outBounds) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void getBoundsInScreen(Object info, Rect outBounds) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object getChild(Object info, int index) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getChildCount(Object info) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getClassName(Object info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getContentDescription(Object info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getPackageName(Object info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object getParent(Object info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getText(Object info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getWindowId(Object info) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isCheckable(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isChecked(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isClickable(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isEnabled(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isFocusable(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isFocused(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isVisibleToUser(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isAccessibilityFocused(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isLongClickable(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isPassword(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isScrollable(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isSelected(Object info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean performAction(Object info, int action) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean performAction(Object info, int action, Bundle arguments) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMovementGranularities(Object info, int granularities) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getMovementGranularities(Object info) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setBoundsInParent(Object info, Rect bounds) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setBoundsInScreen(Object info, Rect bounds) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setCheckable(Object info, boolean checkable) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setChecked(Object info, boolean checked) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setClassName(Object info, CharSequence className) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setClickable(Object info, boolean clickable) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setContentDescription(Object info, CharSequence contentDescription) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setEnabled(Object info, boolean enabled) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setFocusable(Object info, boolean focusable) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setFocused(Object info, boolean focused) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setVisibleToUser(Object info, boolean visibleToUser) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setAccessibilityFocused(Object info, boolean focused) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setLongClickable(Object info, boolean longClickable) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setPackageName(Object info, CharSequence packageName) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setParent(Object info, View parent) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setPassword(Object info, boolean password) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setScrollable(Object info, boolean scrollable) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSelected(Object info, boolean selected) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSource(Object info, View source) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSource(Object info, View root, int virtualDescendantId) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object findFocus(Object info, int focus) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object focusSearch(Object info, int direction) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setText(Object info, CharSequence text) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void recycle(Object info) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setParent(Object info, View root, int virtualDescendantId) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String getViewIdResourceName(Object info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setViewIdResourceName(Object info, String viewId) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getLiveRegion(Object info) {
            //return ViewCompat.ACCESSIBILITY_LIVE_REGION_NONE;
        	return DSUtils.FAKE_INT;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setLiveRegion(Object info, int mode) {
            // No-op
        }
    }

    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain() {
            return AccessibilityNodeInfoCompatIcs.obtain();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain(View source) {
            return AccessibilityNodeInfoCompatIcs.obtain(source);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain(Object info) {
            return AccessibilityNodeInfoCompatIcs.obtain(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void addAction(Object info, int action) {
            AccessibilityNodeInfoCompatIcs.addAction(info, action);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void addChild(Object info, View child) {
            AccessibilityNodeInfoCompatIcs.addChild(info, child);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(info, text);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getActions(Object info) {
            return AccessibilityNodeInfoCompatIcs.getActions(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void getBoundsInParent(Object info, Rect outBounds) {
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(info, outBounds);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void getBoundsInScreen(Object info, Rect outBounds) {
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(info, outBounds);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object getChild(Object info, int index) {
            return AccessibilityNodeInfoCompatIcs.getChild(info, index);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getChildCount(Object info) {
            return AccessibilityNodeInfoCompatIcs.getChildCount(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getClassName(Object info) {
            return AccessibilityNodeInfoCompatIcs.getClassName(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getContentDescription(Object info) {
            return AccessibilityNodeInfoCompatIcs.getContentDescription(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getPackageName(Object info) {
            return AccessibilityNodeInfoCompatIcs.getPackageName(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object getParent(Object info) {
            return AccessibilityNodeInfoCompatIcs.getParent(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getText(Object info) {
            return AccessibilityNodeInfoCompatIcs.getText(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getWindowId(Object info) {
            return AccessibilityNodeInfoCompatIcs.getWindowId(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isCheckable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isCheckable(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isChecked(Object info) {
            return AccessibilityNodeInfoCompatIcs.isChecked(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isClickable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isClickable(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isEnabled(Object info) {
            return AccessibilityNodeInfoCompatIcs.isEnabled(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isFocusable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isFocusable(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isFocused(Object info) {
            return AccessibilityNodeInfoCompatIcs.isFocused(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isLongClickable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isLongClickable(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isPassword(Object info) {
            return AccessibilityNodeInfoCompatIcs.isPassword(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isScrollable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isScrollable(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isSelected(Object info) {
            return AccessibilityNodeInfoCompatIcs.isSelected(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean performAction(Object info, int action) {
            return AccessibilityNodeInfoCompatIcs.performAction(info, action);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setBoundsInParent(Object info, Rect bounds) {
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(info, bounds);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setBoundsInScreen(Object info, Rect bounds) {
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(info, bounds);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setCheckable(Object info, boolean checkable) {
            AccessibilityNodeInfoCompatIcs.setCheckable(info, checkable);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setChecked(Object info, boolean checked) {
            AccessibilityNodeInfoCompatIcs.setChecked(info, checked);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setClassName(Object info, CharSequence className) {
            AccessibilityNodeInfoCompatIcs.setClassName(info, className);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setClickable(Object info, boolean clickable) {
            AccessibilityNodeInfoCompatIcs.setClickable(info, clickable);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setContentDescription(Object info, CharSequence contentDescription) {
            AccessibilityNodeInfoCompatIcs.setContentDescription(info, contentDescription);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setEnabled(Object info, boolean enabled) {
            AccessibilityNodeInfoCompatIcs.setEnabled(info, enabled);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setFocusable(Object info, boolean focusable) {
            AccessibilityNodeInfoCompatIcs.setFocusable(info, focusable);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setFocused(Object info, boolean focused) {
            AccessibilityNodeInfoCompatIcs.setFocused(info, focused);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setLongClickable(Object info, boolean longClickable) {
            AccessibilityNodeInfoCompatIcs.setLongClickable(info, longClickable);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setPackageName(Object info, CharSequence packageName) {
            AccessibilityNodeInfoCompatIcs.setPackageName(info, packageName);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setParent(Object info, View parent) {
            AccessibilityNodeInfoCompatIcs.setParent(info, parent);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setPassword(Object info, boolean password) {
            AccessibilityNodeInfoCompatIcs.setPassword(info, password);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setScrollable(Object info, boolean scrollable) {
            AccessibilityNodeInfoCompatIcs.setScrollable(info, scrollable);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSelected(Object info, boolean selected) {
            AccessibilityNodeInfoCompatIcs.setSelected(info, selected);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSource(Object info, View source) {
            AccessibilityNodeInfoCompatIcs.setSource(info, source);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setText(Object info, CharSequence text) {
            AccessibilityNodeInfoCompatIcs.setText(info, text);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void recycle(Object info) {
            AccessibilityNodeInfoCompatIcs.recycle(info);
        }
    }

    static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain(View root, int virtualDescendantId) {
            return AccessibilityNodeInfoCompatJellyBean.obtain(root, virtualDescendantId);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object findFocus(Object info, int focus) {
            return AccessibilityNodeInfoCompatJellyBean.findFocus(info, focus);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object focusSearch(Object info, int direction) {
            return AccessibilityNodeInfoCompatJellyBean.focusSearch(info, direction);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void addChild(Object info, View child, int virtualDescendantId) {
            AccessibilityNodeInfoCompatJellyBean.addChild(info, child, virtualDescendantId);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSource(Object info, View root, int virtualDescendantId) {
            AccessibilityNodeInfoCompatJellyBean.setSource(info, root, virtualDescendantId);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isVisibleToUser(Object info) {
            return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setVisibleToUser(Object info, boolean visibleToUser) {
            AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(info, visibleToUser);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isAccessibilityFocused(Object info) {
            return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setAccessibilityFocused(Object info, boolean focused) {
            AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(info, focused);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean performAction(Object info, int action, Bundle arguments) {
            return AccessibilityNodeInfoCompatJellyBean.performAction(info, action, arguments);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMovementGranularities(Object info, int granularities) {
            AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(info, granularities);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getMovementGranularities(Object info) {
            return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setParent(Object info, View root, int virtualDescendantId) {
            AccessibilityNodeInfoCompatJellyBean.setParent(info, root, virtualDescendantId);
        }
    }

    static class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String getViewIdResourceName(Object info) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setViewIdResourceName(Object info, String viewId) {
            AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(info, viewId);
        }
    }

    static class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getLiveRegion(Object info) {
            return AccessibilityNodeInfoCompatKitKat.getLiveRegion(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setLiveRegion(Object info, int mode) {
            AccessibilityNodeInfoCompatKitKat.setLiveRegion(info, mode);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) { // KitKat
            IMPL = new AccessibilityNodeInfoKitKatImpl();
        } else if (Build.VERSION.SDK_INT >= 18) { // JellyBean MR2
            IMPL = new AccessibilityNodeInfoJellybeanMr2Impl();
        } else if (Build.VERSION.SDK_INT >= 16) { // JellyBean
            IMPL = new AccessibilityNodeInfoJellybeanImpl();
        } else if (Build.VERSION.SDK_INT >= 14) { // ICS
            IMPL = new AccessibilityNodeInfoIcsImpl();
        } else {
            IMPL = new AccessibilityNodeInfoStubImpl();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.622 -0400", hash_original_field = "B1D8AB103F046CFEA3FC9CDC8BCBC3C0", hash_generated_field = "97BD12C859C1DA2B5849DD1AFA547C72")

    private static  AccessibilityNodeInfoImpl IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.626 -0400", hash_original_field = "617EB5A49831D4E42CC1FEF3965E4033", hash_generated_field = "F78F9523CB351E82CADC0E3370F65663")

    /**
     * Action that focuses the node.
     */
    public static final int ACTION_FOCUS = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.629 -0400", hash_original_field = "9F650D1FD27771928876D8E4DD202D99", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.632 -0400", hash_original_field = "0DF782BD9DC3375190032A37A32E539E", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.635 -0400", hash_original_field = "8ECD989E8F1471431728127462E951C5", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.638 -0400", hash_original_field = "C7267D751F256BC9670AE9E31C6ECE67", hash_generated_field = "369109CF974797303A77D882977240E7")

    public static final int ACTION_CLICK = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.641 -0400", hash_original_field = "4DFD570C0FD2FA7C7801E85CA8B5E6D3", hash_generated_field = "C0F426E2F32474A6404CFE767AD73CE4")

    public static final int ACTION_LONG_CLICK = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.644 -0400", hash_original_field = "6F7D403C052B22D61A58C6093F6E7418", hash_generated_field = "23E39B8AD98E524986F046CC64E6F646")

    /**
     * Action that gives accessibility focus to the node.
     */
    public static final int ACTION_ACCESSIBILITY_FOCUS = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.646 -0400", hash_original_field = "3720035E18CACEBB3EB7F94AFF5EFDFE", hash_generated_field = "66EB817E0227733617E14FD5735CD068")

    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.649 -0400", hash_original_field = "DF4BE758CADBA14CFF85FB211B96D86A", hash_generated_field = "0B265A63A772A3ABC6EFFD89FEE57B5B")

    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.652 -0400", hash_original_field = "4EF885AA6EE7B5C59E79575105718938", hash_generated_field = "5173488E01C32C0DC0C86F4F28097DB1")

    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.654 -0400", hash_original_field = "8657B834F1901FE8F9D991180E263548", hash_generated_field = "86C315CC9AED4E0A29B9F0A50B0F67EA")

    public static final int ACTION_NEXT_HTML_ELEMENT = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.657 -0400", hash_original_field = "5C13ECD6A218D64401913A21ED823003", hash_generated_field = "48FD65F25C66E993E665D75F4684A620")

    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 0x00000800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.660 -0400", hash_original_field = "F4FC94FA11326AC65E5ECF56F54009B5", hash_generated_field = "F3E317F3F3A122DEB215B24F3D0D41D3")

    public static final int ACTION_SCROLL_FORWARD = 0x00001000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.663 -0400", hash_original_field = "799E58A1FB5524D09D0CB3DC1A4D1E75", hash_generated_field = "9DAE87EDFA9A64406AA303BCE4781DEA")

    public static final int ACTION_SCROLL_BACKWARD = 0x00002000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.666 -0400", hash_original_field = "852405331E4F6E978DA8D196B7C4BEC7", hash_generated_field = "3352BD4C1629D5BCCA8E2D089F467DCA")

    /**
     * Action to copy the current selection to the clipboard.
     */
    public static final int ACTION_COPY = 0x00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.669 -0400", hash_original_field = "EBD56648509ADFCCE37A4885C1C6F619", hash_generated_field = "874DC47A1FF587630BAE5527B52F2F7C")

    public static final int ACTION_PASTE = 0x00008000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.671 -0400", hash_original_field = "EE25F239389881284A3B0C04A9AA5400", hash_generated_field = "38A9E0B496DC978484E7C3873AD44541")

    public static final int ACTION_CUT = 0x00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.674 -0400", hash_original_field = "6E535E2113658F49774806DBA9509ADA", hash_generated_field = "B34E272B9031F1D03A14B687B8B2388A")

    public static final int ACTION_SET_SELECTION = 0x00020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.676 -0400", hash_original_field = "560D05D7E01CA3D98CB8BB322CB5C932", hash_generated_field = "A258FCB8910863B6D6343AE915B4E37B")

    /**
     * Argument for which movement granularity to be used when traversing the node text.
     * <p>
     * <strong>Type:</strong> int<br>
     * <strong>Actions:</strong> {@link #ACTION_NEXT_AT_MOVEMENT_GRANULARITY},
     * {@link #ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY}
     * </p>
     */
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT =
        "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.680 -0400", hash_original_field = "A0E0355E41BF96A58E08DA078F33E7BB", hash_generated_field = "E8E9F3F2E6B1351B29467170AE6D8C98")

    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING =
        "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.683 -0400", hash_original_field = "6BE9EC4049777F94C2E33C0D7C6C5248", hash_generated_field = "D83A5F9EF030AB31FC140D8F9F685343")

    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN =
            "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.686 -0400", hash_original_field = "0800B2F721F8D99A013A455EAB303110", hash_generated_field = "1C425615B46794900B4B25AF432C984B")

    public static final String ACTION_ARGUMENT_SELECTION_START_INT =
            "ACTION_ARGUMENT_SELECTION_START_INT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.688 -0400", hash_original_field = "651A5D6F1937FDBEE80CEF417694937A", hash_generated_field = "DBC39AB10C7F9F70A4DE82DDAAF9E828")

    public static final String ACTION_ARGUMENT_SELECTION_END_INT =
            "ACTION_ARGUMENT_SELECTION_END_INT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.691 -0400", hash_original_field = "B063FBC735A168CBAF679026C6C13BA7", hash_generated_field = "28A4BA2020997AB8AC9457E4ACC3A64A")

    /**
     * The input focus.
     */
    public static final int FOCUS_INPUT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.693 -0400", hash_original_field = "D5C2CA1630BA9F671A9BDCAF160AD838", hash_generated_field = "5780C58BCB0EBC1BAF40418729B1EC11")

    public static final int FOCUS_ACCESSIBILITY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.696 -0400", hash_original_field = "C0D9A00404EAC3BF54407E09B497D1DA", hash_generated_field = "E007B47EC43205E02B73C370346A4E45")

    /**
     * Movement granularity bit for traversing the text of a node by character.
     */
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.699 -0400", hash_original_field = "DB7BA362F439FAED5D81550932D93392", hash_generated_field = "64C41D52DECEEE03766FCC71B2A1A7EB")

    public static final int MOVEMENT_GRANULARITY_WORD = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.701 -0400", hash_original_field = "DD69345DA74233121E961FEB39AC53DC", hash_generated_field = "9DED1C2D70A0DF71C5CDF5F4AA2043A5")

    public static final int MOVEMENT_GRANULARITY_LINE = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.705 -0400", hash_original_field = "E98EA0A516176B9BCC202ECCC344AE53", hash_generated_field = "552269D376C3888E8D12D8A8281BD6F3")

    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.708 -0400", hash_original_field = "A438DA85EAA83318A4054308BDC2CC11", hash_generated_field = "DDA56A4533F97BBE00EBAE70D3555634")

    public static final int MOVEMENT_GRANULARITY_PAGE = 0x00000010;

    /**
     * Creates a wrapper for info implementation.
     *
     * @param object The info to wrap.
     * @return A wrapper for if the object is not null, null otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.712 -0400", hash_original_method = "2DFE928CC0A7C8B2845A0A9C19748EC7", hash_generated_method = "FD1A1E5EAF915CFBA0FDBCD5053E48C9")
        
static AccessibilityNodeInfoCompat wrapNonNullInstance(Object object) {
        if (object != null) {
            return new AccessibilityNodeInfoCompat(object);
        }
        return null;
    }

    /**
     * Returns a cached instance if such is available otherwise a new one and
     * sets the source.
     *
     * @return An instance.
     * @see #setSource(View)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.720 -0400", hash_original_method = "F9AA2D570A3175E85EA88CC7CBE5041C", hash_generated_method = "49AC34C441BC55CC4E6DED083F40E68C")
        
public static AccessibilityNodeInfoCompat obtain(View source) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.obtain(source));
    }

    /**
     * Returns a cached instance if such is available otherwise a new one
     * and sets the source.
     *
     * @param root The root of the virtual subtree.
     * @param virtualDescendantId The id of the virtual descendant.
     * @return An instance.
     *
     * @see #setSource(View, int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.724 -0400", hash_original_method = "7BFD5802F760348263B626FB8A12835C", hash_generated_method = "C5ACC94206ECD69C2F9D20F9AA2861D6")
        
public static AccessibilityNodeInfoCompat obtain(View root, int virtualDescendantId) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(
                IMPL.obtain(root, virtualDescendantId));
    }

    /**
     * Returns a cached instance if such is available otherwise a new one.
     *
     * @return An instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.726 -0400", hash_original_method = "272D52BEF9820381418060E4EE596F9C", hash_generated_method = "AF3B3E12D0337DB41978A195C832F209")
        
public static AccessibilityNodeInfoCompat obtain() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.obtain());
    }

    /**
     * Returns a cached instance if such is available or a new one is create.
     * The returned instance is initialized from the given <code>info</code>.
     *
     * @param info The other info.
     * @return An instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.729 -0400", hash_original_method = "78780BBC3BE59608C62FADBC53E0363A", hash_generated_method = "50982A2D65173EA810560A83102FC8B6")
        
public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat info) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.obtain(info.mInfo));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.899 -0400", hash_original_method = "DBC6612AC976A9F762D088C047C7CF9C", hash_generated_method = "A51EAB80893C5E25C7B9BA4D588B0C0F")
        
private static String getActionSymbolicName(int action) {
        switch (action) {
            case ACTION_FOCUS:
                return "ACTION_FOCUS";
            case ACTION_CLEAR_FOCUS:
                return "ACTION_CLEAR_FOCUS";
            case ACTION_SELECT:
                return "ACTION_SELECT";
            case ACTION_CLEAR_SELECTION:
                return "ACTION_CLEAR_SELECTION";
            case ACTION_CLICK:
                return "ACTION_CLICK";
            case ACTION_LONG_CLICK:
                return "ACTION_LONG_CLICK";
            case ACTION_ACCESSIBILITY_FOCUS:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case ACTION_CLEAR_ACCESSIBILITY_FOCUS:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case ACTION_NEXT_AT_MOVEMENT_GRANULARITY:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case ACTION_NEXT_HTML_ELEMENT:
                return "ACTION_NEXT_HTML_ELEMENT";
            case ACTION_PREVIOUS_HTML_ELEMENT:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case ACTION_SCROLL_FORWARD:
                return "ACTION_SCROLL_FORWARD";
            case ACTION_SCROLL_BACKWARD:
                return "ACTION_SCROLL_BACKWARD";
            case ACTION_CUT:
                return "ACTION_CUT";
            case ACTION_COPY:
                return "ACTION_COPY";
            case ACTION_PASTE:
                return "ACTION_PASTE";
            case ACTION_SET_SELECTION:
                return "ACTION_SET_SELECTION";
            default:
                return"ACTION_UNKNOWN";
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.624 -0400", hash_original_field = "6DDA95A03CB574AE472C66BB1085F01C", hash_generated_field = "EA545B797CAE6A5B712CE13E995894C9")

    private  Object mInfo;

    /**
     * Creates a new instance wrapping an
     * {@link android.view.accessibility.AccessibilityNodeInfo}.
     *
     * @param info The info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.715 -0400", hash_original_method = "27EEB78B664A0859CE9D2482B14EDA44", hash_generated_method = "1537DEEDF291D03E1EC9A2D44728DFE0")
        
public AccessibilityNodeInfoCompat(Object info) {
        mInfo = info;
    }

    /**
     * @return The wrapped {@link android.view.accessibility.AccessibilityNodeInfo}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.717 -0400", hash_original_method = "A54689839F6FFAA9158E320BE92D3988", hash_generated_method = "DCCD49288D99218A38C96EC4094E8F79")
        
public Object getInfo() {
        return mInfo;
    }

    /**
     * Sets the source.
     *
     * @param source The info source.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.731 -0400", hash_original_method = "DBD6C4E567C7947922529BA45E2088C3", hash_generated_method = "90B66C2995A5D6DDFBBCBCFC7050DA5D")
        
public void setSource(View source) {
        IMPL.setSource(mInfo, source);
    }

    /**
     * Sets the source to be a virtual descendant of the given <code>root</code>.
     * If <code>virtualDescendantId</code> is {@link View#NO_ID} the root
     * is set as the source.
     * <p>
     * A virtual descendant is an imaginary View that is reported as a part of the view
     * hierarchy for accessibility purposes. This enables custom views that draw complex
     * content to report themselves as a tree of virtual views, thus conveying their
     * logical structure.
     * </p>
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param root The root of the virtual subtree.
     * @param virtualDescendantId The id of the virtual descendant.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.735 -0400", hash_original_method = "7954D3A09383A096032D62B125ADE25C", hash_generated_method = "CF5787C77447F4E59A64736D5DFC78AE")
        
public void setSource(View root, int virtualDescendantId) {
        IMPL.setSource(mInfo, root, virtualDescendantId);
    }

    /**
     * Find the view that has the specified focus type. The search starts from
     * the view represented by this node info.
     *
     * @param focus The focus to find. One of {@link #FOCUS_INPUT} or
     *         {@link #FOCUS_ACCESSIBILITY}.
     * @return The node info of the focused view or null.
     *
     * @see #FOCUS_INPUT
     * @see #FOCUS_ACCESSIBILITY
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.737 -0400", hash_original_method = "4C686674D95265051C82554481B0829A", hash_generated_method = "83E9A731F3B65367BC899A3B69D6091C")
        
public AccessibilityNodeInfoCompat findFocus(int focus) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.findFocus(mInfo, focus));
    }

    /**
     * Searches for the nearest view in the specified direction that can take
     * input focus.
     *
     * @param direction The direction. Can be one of:
     *     {@link View#FOCUS_DOWN},
     *     {@link View#FOCUS_UP},
     *     {@link View#FOCUS_LEFT},
     *     {@link View#FOCUS_RIGHT},
     *     {@link View#FOCUS_FORWARD},
     *     {@link View#FOCUS_BACKWARD}.
     *
     * @return The node info for the view that can take accessibility focus.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.740 -0400", hash_original_method = "4D0E79DD2865CDF4E8D5564C91FF887A", hash_generated_method = "52BD4D39C8E14A2E803380AF7A00312D")
        
public AccessibilityNodeInfoCompat focusSearch(int direction) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.focusSearch(mInfo, direction));
    }

    /**
     * Gets the id of the window from which the info comes from.
     *
     * @return The window id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.742 -0400", hash_original_method = "2FCD3C5691FCBE6EB393188032460842", hash_generated_method = "532CDC7BE655D6CCA090E084464B70A9")
        
public int getWindowId() {
        return IMPL.getWindowId(mInfo);
    }

    /**
     * Gets the number of children.
     *
     * @return The child count.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.744 -0400", hash_original_method = "2AD4C51D718899601C93A5649AD946AD", hash_generated_method = "A8C4B49542793C1ECB3A1A24BEC4FBB9")
        
public int getChildCount() {
        return IMPL.getChildCount(mInfo);
    }

    /**
     * Get the child at given index.
     * <p>
     * <strong>Note:</strong> It is a client responsibility to recycle the
     * received info by calling {@link AccessibilityNodeInfoCompat#recycle()} to
     * avoid creating of multiple instances.
     * </p>
     *
     * @param index The child index.
     * @return The child node.
     * @throws IllegalStateException If called outside of an
     *             AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.747 -0400", hash_original_method = "5EB6D299E8201A572C3108A03EA668ED", hash_generated_method = "EF18259A1F1227E6AA82A2D0EFA585C2")
        
public AccessibilityNodeInfoCompat getChild(int index) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getChild(mInfo, index));
    }

    /**
     * Adds a child.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param child The child.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.751 -0400", hash_original_method = "96991CF3D104F82AE28D15A837764722", hash_generated_method = "16E809D8BA444B09A15AA1DB6234B0DB")
        
public void addChild(View child) {
        IMPL.addChild(mInfo, child);
    }

    /**
     * Adds a virtual child which is a descendant of the given <code>root</code>.
     * If <code>virtualDescendantId</code> is {@link View#NO_ID} the root
     * is added as a child.
     * <p>
     * A virtual descendant is an imaginary View that is reported as a part of the view
     * hierarchy for accessibility purposes. This enables custom views that draw complex
     * content to report them selves as a tree of virtual views, thus conveying their
     * logical structure.
     * </p>
     *
     * @param root The root of the virtual subtree.
     * @param virtualDescendantId The id of the virtual child.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.755 -0400", hash_original_method = "27ACF91E2BB26DB3FB9A03AE42473C80", hash_generated_method = "E8F23D4BB6F80C1381F656208C6E0876")
        
public void addChild(View root, int virtualDescendantId) {
        IMPL.addChild(mInfo, root, virtualDescendantId);
    }

    /**
     * Gets the actions that can be performed on the node.
     *
     * @return The bit mask of with actions.
     * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_FOCUS
     * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_CLEAR_FOCUS
     * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_SELECT
     * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_CLEAR_SELECTION
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.758 -0400", hash_original_method = "933CE3223B5CD7F54D5F21B403DB8A7E", hash_generated_method = "537D5CB0A559CBBF67228F479B60ED73")
        
public int getActions() {
        return IMPL.getActions(mInfo);
    }

    /**
     * Adds an action that can be performed on the node.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param action The action.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.760 -0400", hash_original_method = "F620D8EC3817B6EC64D02A805E40B2B4", hash_generated_method = "1F3F2FFA9362EAD00B99DB76616D4CD3")
        
public void addAction(int action) {
        IMPL.addAction(mInfo, action);
    }

    /**
     * Performs an action on the node.
     * <p>
     * <strong>Note:</strong> An action can be performed only if the request is
     * made from an {@link android.accessibilityservice.AccessibilityService}.
     * </p>
     *
     * @param action The action to perform.
     * @return True if the action was performed.
     * @throws IllegalStateException If called outside of an
     *             AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.763 -0400", hash_original_method = "76F70B64C56F7E2DCA168B652A090370", hash_generated_method = "93DD76A34CE5DF8253F6A81AF8E167E4")
        
public boolean performAction(int action) {
        return IMPL.performAction(mInfo, action);
    }

    /**
     * Performs an action on the node.
     * <p>
     *   <strong>Note:</strong> An action can be performed only if the request is made
     *   from an {@link android.accessibilityservice.AccessibilityService}.
     * </p>
     *
     * @param action The action to perform.
     * @param arguments A bundle with additional arguments.
     * @return True if the action was performed.
     *
     * @throws IllegalStateException If called outside of an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.766 -0400", hash_original_method = "D1A422A8904A39B2ED551FD6FBF9D15C", hash_generated_method = "121B89AA6CBEEA10ADA81CEE42269F6F")
        
public boolean performAction(int action, Bundle arguments) {
        return IMPL.performAction(mInfo, action, arguments);
    }

    /**
     * Sets the movement granularities for traversing the text of this node.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param granularities The bit mask with granularities.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.768 -0400", hash_original_method = "EF36E97AF685EFB246C7E0DB4903F5E7", hash_generated_method = "CC1B038B95474C9F08EAD3A83F2E072A")
        
public void setMovementGranularities(int granularities) {
        IMPL.setMovementGranularities(mInfo, granularities);
    }

    /**
     * Gets the movement granularities for traversing the text of this node.
     *
     * @return The bit mask with granularities.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.771 -0400", hash_original_method = "165530901FAD09423D54567E2ACB4A57", hash_generated_method = "D138F1B8AE8CF20BE2B460986621EB91")
        
public int getMovementGranularities() {
        return IMPL.getMovementGranularities(mInfo);
    }

    /**
     * Finds {@link android.view.accessibility.AccessibilityNodeInfo}s by text. The match
     * is case insensitive containment. The search is relative to this info i.e. this
     * info is the root of the traversed tree.
     * <p>
     * <strong>Note:</strong> It is a client responsibility to recycle the
     * received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle()}
     * to avoid creating of multiple instances.
     * </p>
     *
     * @param text The searched text.
     * @return A list of node info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.775 -0400", hash_original_method = "D972868A6ABA9BEE83DE29ABCCDE4A4C", hash_generated_method = "D4FCE95BF9B8E9E49357701DFD27F6B5")
        
public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text) {
        List<AccessibilityNodeInfoCompat> result = new ArrayList<AccessibilityNodeInfoCompat>();
        List<Object> infos = IMPL.findAccessibilityNodeInfosByText(mInfo, text);
        final int infoCount = infos.size();
        for (int i = 0; i < infoCount; i++) {
            Object info = infos.get(i);
            result.add(new AccessibilityNodeInfoCompat(info));
        }
        return result;
    }

    /**
     * Gets the parent.
     * <p>
     * <strong>Note:</strong> It is a client responsibility to recycle the
     * received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle()}
     * to avoid creating of multiple instances.
     * </p>
     *
     * @return The parent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.778 -0400", hash_original_method = "BE2C9EF1F5455D9ACA6B035382A423BB", hash_generated_method = "FBC1F035CD7BFA23A4B03152D9896BBF")
        
public AccessibilityNodeInfoCompat getParent() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getParent(mInfo));
    }

    /**
     * Sets the parent.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param parent The parent.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.780 -0400", hash_original_method = "86518FC5D5AE3E2BA199BEEAA088933F", hash_generated_method = "A9CC7F035545F94FB6F4921F709546B9")
        
public void setParent(View parent) {
        IMPL.setParent(mInfo, parent);
    }

    /**
     * Sets the parent to be a virtual descendant of the given <code>root</code>.
     * If <code>virtualDescendantId</code> equals to {@link View#NO_ID} the root
     * is set as the parent.
     * <p>
     * A virtual descendant is an imaginary View that is reported as a part of the view
     * hierarchy for accessibility purposes. This enables custom views that draw complex
     * content to report them selves as a tree of virtual views, thus conveying their
     * logical structure.
     * </p>
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param root The root of the virtual subtree.
     * @param virtualDescendantId The id of the virtual descendant.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.783 -0400", hash_original_method = "7AB699AAF54FCCF23DA69F8C685E3524", hash_generated_method = "B498B5BF869F09FF4D688384ACE2DDD3")
        
public void setParent(View root, int virtualDescendantId) {
        IMPL.setParent(mInfo, root, virtualDescendantId);
    }

    /**
     * Gets the node bounds in parent coordinates.
     *
     * @param outBounds The output node bounds.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.785 -0400", hash_original_method = "E0ACD239D05CD134F4788FDE11AB973D", hash_generated_method = "DF442BEA6EFF145BFDDC74F1596920B2")
        
public void getBoundsInParent(Rect outBounds) {
        IMPL.getBoundsInParent(mInfo, outBounds);
    }

    /**
     * Sets the node bounds in parent coordinates.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param bounds The node bounds.
     *@throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.787 -0400", hash_original_method = "3D18F1D3A722CB931F3C0EA8FCAAFCB7", hash_generated_method = "4800FFEAA8FE374D7F76DD508373AD10")
        
public void setBoundsInParent(Rect bounds) {
        IMPL.setBoundsInParent(mInfo, bounds);
    }

    /**
     * Gets the node bounds in screen coordinates.
     *
     * @param outBounds The output node bounds.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.790 -0400", hash_original_method = "603EEE18F9883128AEF640A26C131D4C", hash_generated_method = "DD24380EE95AB6750BC5D493BDB21D91")
        
public void getBoundsInScreen(Rect outBounds) {
        IMPL.getBoundsInScreen(mInfo, outBounds);
    }

    /**
     * Sets the node bounds in screen coordinates.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param bounds The node bounds.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.792 -0400", hash_original_method = "430D1838A28087C23844BEEDDC51F0AD", hash_generated_method = "09AEB8EF4B01EEEB391FC10D88383349")
        
public void setBoundsInScreen(Rect bounds) {
        IMPL.setBoundsInScreen(mInfo, bounds);
    }

    /**
     * Gets whether this node is checkable.
     *
     * @return True if the node is checkable.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.795 -0400", hash_original_method = "AC8D43F54DC3BA7E7C149D4503D525F3", hash_generated_method = "F2938EAA3048AB629FE1EE997D43827D")
        
public boolean isCheckable() {
        return IMPL.isCheckable(mInfo);
    }

    /**
     * Sets whether this node is checkable.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param checkable True if the node is checkable.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.797 -0400", hash_original_method = "02532B45DC391F52A2535027893C38AD", hash_generated_method = "DB9149D5D970D65DD9A6A80E6072ABDF")
        
public void setCheckable(boolean checkable) {
        IMPL.setCheckable(mInfo, checkable);
    }

    /**
     * Gets whether this node is checked.
     *
     * @return True if the node is checked.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.800 -0400", hash_original_method = "519FEB307C383A2CCF5C74B89068518B", hash_generated_method = "43860E8682617411EB0F8D925489E905")
        
public boolean isChecked() {
        return IMPL.isChecked(mInfo);
    }

    /**
     * Sets whether this node is checked.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param checked True if the node is checked.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.802 -0400", hash_original_method = "FAB30364812370D4A3BF52C70FA75BB2", hash_generated_method = "A59C6BCE2CD8DB866372B92FC3B179DB")
        
public void setChecked(boolean checked) {
        IMPL.setChecked(mInfo, checked);
    }

    /**
     * Gets whether this node is focusable.
     *
     * @return True if the node is focusable.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.804 -0400", hash_original_method = "C9FC8F868000F9B33292AD780E66DCA0", hash_generated_method = "1B0C7C9ED4E3061FC117CF300391E932")
        
public boolean isFocusable() {
        return IMPL.isFocusable(mInfo);
    }

    /**
     * Sets whether this node is focusable.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param focusable True if the node is focusable.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.807 -0400", hash_original_method = "FBAE0F38121F1E86CBC8B993867A4A27", hash_generated_method = "9EE3B225F0BB900FFF66FF8CFE4D2755")
        
public void setFocusable(boolean focusable) {
        IMPL.setFocusable(mInfo, focusable);
    }

    /**
     * Gets whether this node is focused.
     *
     * @return True if the node is focused.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.810 -0400", hash_original_method = "4F186107AF4B40F30B1A87108529D484", hash_generated_method = "1CE5FAA6469CB8E3576D4A61733A2FB1")
        
public boolean isFocused() {
        return IMPL.isFocused(mInfo);
    }

    /**
     * Sets whether this node is focused.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param focused True if the node is focused.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.812 -0400", hash_original_method = "9869A69DD9422BD72F2EA6EC374F4934", hash_generated_method = "20F520430D8D21E4D7B31FF626E2060D")
        
public void setFocused(boolean focused) {
        IMPL.setFocused(mInfo, focused);
    }

    /**
     * Sets whether this node is visible to the user.
     *
     * @return Whether the node is visible to the user.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.815 -0400", hash_original_method = "A8DEEB549F9B553F594403F7D5242DB9", hash_generated_method = "C58903448AC17A6A2D63D59A7CDF8D37")
        
public boolean isVisibleToUser() {
        return IMPL.isVisibleToUser(mInfo);
    }

    /**
     * Sets whether this node is visible to the user.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param visibleToUser Whether the node is visible to the user.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.818 -0400", hash_original_method = "510D47E0125ACE2A9F163ED65DBE5145", hash_generated_method = "C7AFC8E49A87CCAB09E6D03A81D90359")
        
public void setVisibleToUser(boolean visibleToUser) {
        IMPL.setVisibleToUser(mInfo, visibleToUser);
    }

    /**
     * Gets whether this node is accessibility focused.
     *
     * @return True if the node is accessibility focused.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.820 -0400", hash_original_method = "1DDBF526F2F38229BD98FC5AEA0C0D4E", hash_generated_method = "B730E645006C06397B6CFC17CA80349D")
        
public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(mInfo);
    }

    /**
     * Sets whether this node is accessibility focused.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param focused True if the node is accessibility focused.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.822 -0400", hash_original_method = "BB0DBAB86C9C8CBDDFF7BA1405B1C600", hash_generated_method = "9930BFA5429A7BBCD53A985D256B6434")
        
public void setAccessibilityFocused(boolean focused) {
        IMPL.setAccessibilityFocused(mInfo, focused);
    }

    /**
     * Gets whether this node is selected.
     *
     * @return True if the node is selected.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.825 -0400", hash_original_method = "DDA60D7434111992259669E63D890C29", hash_generated_method = "F851DFD3AB4682AEC9781FD2E8716529")
        
public boolean isSelected() {
        return IMPL.isSelected(mInfo);
    }

    /**
     * Sets whether this node is selected.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param selected True if the node is selected.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.827 -0400", hash_original_method = "CCBAF3645335D86B821DEAC9BDDB4ED2", hash_generated_method = "00F8596CE99ACE290DD1B676F34D71C6")
        
public void setSelected(boolean selected) {
        IMPL.setSelected(mInfo, selected);
    }

    /**
     * Gets whether this node is clickable.
     *
     * @return True if the node is clickable.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.830 -0400", hash_original_method = "6F39B6C0009288DFEA1A8807AE028922", hash_generated_method = "A3D847D73DF1E2DD92FCBC32FE6B781B")
        
public boolean isClickable() {
        return IMPL.isClickable(mInfo);
    }

    /**
     * Sets whether this node is clickable.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param clickable True if the node is clickable.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.832 -0400", hash_original_method = "CBF9AA1E7F6DA4EEE21EFD519E970C6E", hash_generated_method = "43B26BD6D513B5F41067E1E4D4FAF666")
        
public void setClickable(boolean clickable) {
        IMPL.setClickable(mInfo, clickable);
    }

    /**
     * Gets whether this node is long clickable.
     *
     * @return True if the node is long clickable.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.834 -0400", hash_original_method = "2A0651AA24697C87D5B10A2F592D15AE", hash_generated_method = "4D2C2FC18945A9E163C831680B184A24")
        
public boolean isLongClickable() {
        return IMPL.isLongClickable(mInfo);
    }

    /**
     * Sets whether this node is long clickable.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param longClickable True if the node is long clickable.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.837 -0400", hash_original_method = "C41DB90B24D967665ADB7BE195D933F7", hash_generated_method = "450B17F683658666E99C7B3076539982")
        
public void setLongClickable(boolean longClickable) {
        IMPL.setLongClickable(mInfo, longClickable);
    }

    /**
     * Gets whether this node is enabled.
     *
     * @return True if the node is enabled.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.839 -0400", hash_original_method = "652E5B5F063CB50BC77186FF37F33BDF", hash_generated_method = "6BA66641655E00C9ED155D7F2DCE0E9C")
        
public boolean isEnabled() {
        return IMPL.isEnabled(mInfo);
    }

    /**
     * Sets whether this node is enabled.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param enabled True if the node is enabled.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.841 -0400", hash_original_method = "38B56F1A12BFB4B4EFFD2BC2116AF996", hash_generated_method = "6CE97DBF8734F261892A971A7D8BDF52")
        
public void setEnabled(boolean enabled) {
        IMPL.setEnabled(mInfo, enabled);
    }

    /**
     * Gets whether this node is a password.
     *
     * @return True if the node is a password.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.844 -0400", hash_original_method = "65A99E085FF9E307AFC93D67B83055DB", hash_generated_method = "C464D20B5B06D4A8BB2AAB921D019802")
        
public boolean isPassword() {
        return IMPL.isPassword(mInfo);
    }

    /**
     * Sets whether this node is a password.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param password True if the node is a password.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.847 -0400", hash_original_method = "B97A25B40B977908B12069641BAB55A8", hash_generated_method = "F607BC9F283964AD117DE9BEB44E99B1")
        
public void setPassword(boolean password) {
        IMPL.setPassword(mInfo, password);
    }

    /**
     * Gets if the node is scrollable.
     *
     * @return True if the node is scrollable, false otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.850 -0400", hash_original_method = "C7AAD2830522B8BD5949276001A4D042", hash_generated_method = "930838EDEF0DD5A1791DF4F002E34E4C")
        
public boolean isScrollable() {
        return IMPL.isScrollable(mInfo);
    }

    /**
     * Sets if the node is scrollable.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param scrollable True if the node is scrollable, false otherwise.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.852 -0400", hash_original_method = "EF0CC581E7F7F261AFF7A1550C16EBCA", hash_generated_method = "FF10968521D7D7EE6AA386EF051FC800")
        
public void setScrollable(boolean scrollable) {
        IMPL.setScrollable(mInfo, scrollable);
    }

    /**
     * Gets the package this node comes from.
     *
     * @return The package name.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.854 -0400", hash_original_method = "11DA2F2F6D35A0A5BD4D3AD5855546F2", hash_generated_method = "E376132D49C22EECF8940FC095DC9C7A")
        
public CharSequence getPackageName() {
        return IMPL.getPackageName(mInfo);
    }

    /**
     * Sets the package this node comes from.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param packageName The package name.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.857 -0400", hash_original_method = "51BDE657C455C3947A276CD4621D88BF", hash_generated_method = "B10217DFFD45DFE59CD0708B3A3739E6")
        
public void setPackageName(CharSequence packageName) {
        IMPL.setPackageName(mInfo, packageName);
    }

    /**
     * Gets the class this node comes from.
     *
     * @return The class name.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.860 -0400", hash_original_method = "80725931141339E528C95BCDFA69AC67", hash_generated_method = "AD5985DA033FE7AA31D10BC4686F4408")
        
public CharSequence getClassName() {
        return IMPL.getClassName(mInfo);
    }

    /**
     * Sets the class this node comes from.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param className The class name.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.863 -0400", hash_original_method = "95DBB6C9D00CCAE01AE6EC9F7D77613E", hash_generated_method = "8F56A94F6ACCE2223C09F279D7B8EC3A")
        
public void setClassName(CharSequence className) {
        IMPL.setClassName(mInfo, className);
    }

    /**
     * Gets the text of this node.
     *
     * @return The text.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.865 -0400", hash_original_method = "384621808EBD921F20A6EB28B91ADAD5", hash_generated_method = "5E5A150E827CB2DE5FA31B44CEBACCE2")
        
public CharSequence getText() {
        return IMPL.getText(mInfo);
    }

    /**
     * Sets the text of this node.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param text The text.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.868 -0400", hash_original_method = "CCE84BD471DC2DB3AF81C568CF944475", hash_generated_method = "21AF717A075F3D5014CAD534ABD735C0")
        
public void setText(CharSequence text) {
        IMPL.setText(mInfo, text);
    }

    /**
     * Gets the content description of this node.
     *
     * @return The content description.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.870 -0400", hash_original_method = "17A5AE651613EAEE40274E28D0DBF3CB", hash_generated_method = "7BA20ABCE576512166E9EC2E2C4CCBB0")
        
public CharSequence getContentDescription() {
        return IMPL.getContentDescription(mInfo);
    }

    /**
     * Sets the content description of this node.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param contentDescription The content description.
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.873 -0400", hash_original_method = "0581568FD089D03E78C8C673EC290A8E", hash_generated_method = "68AF30028603DEE6092DD3B53086E5AA")
        
public void setContentDescription(CharSequence contentDescription) {
        IMPL.setContentDescription(mInfo, contentDescription);
    }

    /**
     * Return an instance back to be reused.
     * <p>
     * <strong>Note:</strong> You must not touch the object after calling this function.
     *
     * @throws IllegalStateException If the info is already recycled.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.875 -0400", hash_original_method = "4012C2A77CF6E1C54F1B4372AFDF8962", hash_generated_method = "371816176A0FE984D43E7A281211A3A7")
        
public void recycle() {
        IMPL.recycle(mInfo);
    }

    /**
     * Sets the fully qualified resource name of the source view's id.
     *
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param viewId The id resource name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.878 -0400", hash_original_method = "29B3BE5DB60EB69D9B361D6A3D92230E", hash_generated_method = "A9ADB5483C8272E94FAAEE3D17C2374E")
        
public void setViewIdResourceName(String viewId) {
        IMPL.setViewIdResourceName(mInfo, viewId);
    }

    /**
     * Gets the fully qualified resource name of the source view's id.
     *
     * <p>
     *   <strong>Note:</strong> The primary usage of this API is for UI test automation
     *   and in order to report the source view id of an {@link AccessibilityNodeInfoCompat}
     *   the client has to set the {@link AccessibilityServiceInfoCompat#FLAG_REPORT_VIEW_IDS}
     *   flag when configuring his {@link android.accessibilityservice.AccessibilityService}.
     * </p>
     *
     * @return The id resource name.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.880 -0400", hash_original_method = "CCDB5C412314CB74E4323C8B128154AE", hash_generated_method = "886FA95681D42CD22F99D956BC28AFD1")
        
public String getViewIdResourceName() {
        return IMPL.getViewIdResourceName(mInfo);
    }

    /**
     * Gets the node's live region mode.
     * <p>
     * A live region is a node that contains information that is important for
     * the user and when it changes the user should be notified. For example,
     * in a login screen with a TextView that displays an "incorrect password"
     * notification, that view should be marked as a live region with mode
     * {@link ViewCompat#ACCESSIBILITY_LIVE_REGION_POLITE}.
     * <p>
     * It is the responsibility of the accessibility service to monitor
     * {@link AccessibilityEventCompat#TYPE_WINDOW_CONTENT_CHANGED} events
     * indicating changes to live region nodes and their children.
     *
     * @return The live region mode, or
     *         {@link ViewCompat#ACCESSIBILITY_LIVE_REGION_NONE} if the view is
     *         not a live region.
     * @see ViewCompat#getAccessibilityLiveRegion(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.882 -0400", hash_original_method = "37E25FE6F4100F4E71C4E4F59681FB50", hash_generated_method = "5CA2F75DABA5BE4DC8BE596CD05630CF")
        
public int getLiveRegion() {
        return IMPL.getLiveRegion(mInfo);
    }

    /**
     * Sets the node's live region mode.
     * <p>
     * <strong>Note:</strong> Cannot be called from an
     * {@link android.accessibilityservice.AccessibilityService}. This class is
     * made immutable before being delivered to an AccessibilityService.
     *
     * @param mode The live region mode, or
     *        {@link ViewCompat#ACCESSIBILITY_LIVE_REGION_NONE} if the view is
     *        not a live region.
     * @see ViewCompat#setAccessibilityLiveRegion(View, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.884 -0400", hash_original_method = "51661971092A1A85900673C1A87B6E82", hash_generated_method = "F346542AB10EEE95978FFE5A38FFC090")
        
public void setLiveRegion(int mode) {
        IMPL.setLiveRegion(mInfo, mode);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.887 -0400", hash_original_method = "3D44C3AC54A391BB7EEFE6DCE99834D5", hash_generated_method = "1820D3808537E877B4E310BAB0EC6052")
        
@Override
    public int hashCode() {
        return (mInfo == null) ? 0 : mInfo.hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.891 -0400", hash_original_method = "9F360410AD288A74DD17C77A13BAB054", hash_generated_method = "C5D6ED61C819BF3A883EE2D10FA827A0")
        
@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityNodeInfoCompat other = (AccessibilityNodeInfoCompat) obj;
        if (mInfo == null) {
            if (other.mInfo != null) {
                return false;
            }
        } else if (!mInfo.equals(other.mInfo)) {
            return false;
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:08.895 -0400", hash_original_method = "512238791ADF615E9D587E6727E9DA69", hash_generated_method = "D20583F4A042D1ED83B486AE0FA0DD19")
        
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());

        Rect bounds = new Rect();

        getBoundsInParent(bounds);
        builder.append("; boundsInParent: " + bounds);

        getBoundsInScreen(bounds);
        builder.append("; boundsInScreen: " + bounds);

        builder.append("; packageName: ").append(getPackageName());
        builder.append("; className: ").append(getClassName());
        builder.append("; text: ").append(getText());
        builder.append("; contentDescription: ").append(getContentDescription());
        builder.append("; viewId: ").append(getViewIdResourceName());

        builder.append("; checkable: ").append(isCheckable());
        builder.append("; checked: ").append(isChecked());
        builder.append("; focusable: ").append(isFocusable());
        builder.append("; focused: ").append(isFocused());
        builder.append("; selected: ").append(isSelected());
        builder.append("; clickable: ").append(isClickable());
        builder.append("; longClickable: ").append(isLongClickable());
        builder.append("; enabled: ").append(isEnabled());
        builder.append("; password: ").append(isPassword());
        builder.append("; scrollable: " + isScrollable());

        builder.append("; [");
        for (int actionBits = getActions(); actionBits != 0;) {
            final int action = 1 << Integer.numberOfTrailingZeros(actionBits);
            actionBits &= ~action;
            builder.append(getActionSymbolicName(action));
            if (actionBits != 0) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }
}
