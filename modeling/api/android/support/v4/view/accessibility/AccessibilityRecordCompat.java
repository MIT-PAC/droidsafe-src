/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.view.accessibility;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

import java.util.Collections;
import java.util.List;

/**
 * Helper for accessing {@link android.view.accessibility.AccessibilityRecord}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class AccessibilityRecordCompat {

    static interface AccessibilityRecordImpl {
        public Object obtain();
        public Object obtain(Object record);
        public void setSource(Object record, View source);
        public void setSource(Object record, View root, int virtualDescendantId);
        public AccessibilityNodeInfoCompat getSource(Object record);
        public int getWindowId(Object record);
        public boolean isChecked(Object record);
        public void setChecked(Object record, boolean isChecked);
        public boolean isEnabled(Object record);
        public void setEnabled(Object record, boolean isEnabled);
        public boolean isPassword(Object record);
        public void setPassword(Object record, boolean isPassword);
        public boolean isFullScreen(Object record);
        public void setFullScreen(Object record, boolean isFullScreen);
        public boolean isScrollable(Object record);
        public void setScrollable(Object record, boolean scrollable);
        public int getItemCount(Object record);
        public void setItemCount(Object record, int itemCount);
        public int getCurrentItemIndex(Object record);
        public void setCurrentItemIndex(Object record, int currentItemIndex);
        public int getFromIndex(Object record);
        public void setFromIndex(Object record, int fromIndex);
        public int getToIndex(Object record);
        public void setToIndex(Object record, int toIndex);
        public int getScrollX(Object record);
        public void setScrollX(Object record, int scrollX);
        public int getScrollY(Object record);
        public void setScrollY(Object record, int scrollY);
        public int getMaxScrollX(Object record);
        public void setMaxScrollX(Object record, int maxScrollX);
        public int getMaxScrollY(Object record);
        public void setMaxScrollY(Object record, int maxScrollY);
        public int getAddedCount(Object record);
        public void setAddedCount(Object record, int addedCount);
        public int getRemovedCount(Object record);
        public void setRemovedCount(Object record, int removedCount);
        public CharSequence getClassName(Object record);
        public void setClassName(Object record, CharSequence className);
        public List<CharSequence> getText(Object record);
        public CharSequence getBeforeText(Object record);
        public void setBeforeText(Object record, CharSequence beforeText);
        public CharSequence getContentDescription(Object record);
        public void setContentDescription(Object record, CharSequence contentDescription);
        public Parcelable getParcelableData(Object record);
        public void setParcelableData(Object record, Parcelable parcelableData);
        public void recycle(Object record);
    }

    static class AccessibilityRecordStubImpl implements AccessibilityRecordImpl {
        @DSSafe(DSCat.SAFE_LIST)
        public Object obtain() {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public Object obtain(Object record) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getAddedCount(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public CharSequence getBeforeText(Object record) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public CharSequence getClassName(Object record) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public CharSequence getContentDescription(Object record) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getCurrentItemIndex(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getFromIndex(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getItemCount(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getMaxScrollX(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getMaxScrollY(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public Parcelable getParcelableData(Object record) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getRemovedCount(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getScrollX(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getScrollY(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public AccessibilityNodeInfoCompat getSource(Object record) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public List<CharSequence> getText(Object record) {
            return Collections.emptyList();
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getToIndex(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getWindowId(Object record) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean isChecked(Object record) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean isEnabled(Object record) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean isFullScreen(Object record) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean isPassword(Object record) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean isScrollable(Object record) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void recycle(Object record) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setAddedCount(Object record, int addedCount) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setBeforeText(Object record, CharSequence beforeText) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setChecked(Object record, boolean isChecked) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setClassName(Object record, CharSequence className) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setContentDescription(Object record, CharSequence contentDescription) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setCurrentItemIndex(Object record, int currentItemIndex) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setEnabled(Object record, boolean isEnabled) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setFromIndex(Object record, int fromIndex) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setFullScreen(Object record, boolean isFullScreen) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setItemCount(Object record, int itemCount) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setMaxScrollX(Object record, int maxScrollX) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setMaxScrollY(Object record, int maxScrollY) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setParcelableData(Object record, Parcelable parcelableData) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setPassword(Object record, boolean isPassword) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setRemovedCount(Object record, int removedCount) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setScrollX(Object record, int scrollX) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setScrollY(Object record, int scrollY) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setScrollable(Object record, boolean scrollable) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setSource(Object record, View source) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setSource(Object record, View root, int virtualDescendantId) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setToIndex(Object record, int toIndex) {

        }
    }

    static class AccessibilityRecordIcsImpl extends AccessibilityRecordStubImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain() {
            return AccessibilityRecordCompatIcs.obtain();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object obtain(Object record) {
            return AccessibilityRecordCompatIcs.obtain(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getAddedCount(Object record) {
            return AccessibilityRecordCompatIcs.getAddedCount(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getBeforeText(Object record) {
            return AccessibilityRecordCompatIcs.getBeforeText(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getClassName(Object record) {
            return AccessibilityRecordCompatIcs.getClassName(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getContentDescription(Object record) {
            return AccessibilityRecordCompatIcs.getContentDescription(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getCurrentItemIndex(Object record) {
            return AccessibilityRecordCompatIcs.getCurrentItemIndex(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getFromIndex(Object record) {
            return AccessibilityRecordCompatIcs.getFromIndex(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getItemCount(Object record) {
            return AccessibilityRecordCompatIcs.getItemCount(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Parcelable getParcelableData(Object record) {
            return AccessibilityRecordCompatIcs.getParcelableData(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getRemovedCount(Object record) {
            return AccessibilityRecordCompatIcs.getRemovedCount(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getScrollX(Object record) {
            return AccessibilityRecordCompatIcs.getScrollX(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getScrollY(Object record) {
            return AccessibilityRecordCompatIcs.getScrollY(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public AccessibilityNodeInfoCompat getSource(Object record) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(
                    AccessibilityRecordCompatIcs.getSource(record));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public List<CharSequence> getText(Object record) {
            return AccessibilityRecordCompatIcs.getText(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getToIndex(Object record) {
            return AccessibilityRecordCompatIcs.getToIndex(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getWindowId(Object record) {
            return AccessibilityRecordCompatIcs.getWindowId(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isChecked(Object record) {
            return AccessibilityRecordCompatIcs.isChecked(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isEnabled(Object record) {
            return AccessibilityRecordCompatIcs.isEnabled(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isFullScreen(Object record) {
            return AccessibilityRecordCompatIcs.isFullScreen(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isPassword(Object record) {
            return AccessibilityRecordCompatIcs.isPassword(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isScrollable(Object record) {
            return AccessibilityRecordCompatIcs.isScrollable(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void recycle(Object record) {
            AccessibilityRecordCompatIcs.recycle(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setAddedCount(Object record, int addedCount) {
            AccessibilityRecordCompatIcs.setAddedCount(record, addedCount);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setBeforeText(Object record, CharSequence beforeText) {
            AccessibilityRecordCompatIcs.setBeforeText(record, beforeText);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setChecked(Object record, boolean isChecked) {
            AccessibilityRecordCompatIcs.setChecked(record, isChecked);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setClassName(Object record, CharSequence className) {
            AccessibilityRecordCompatIcs.setClassName(record, className);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setContentDescription(Object record, CharSequence contentDescription) {
            AccessibilityRecordCompatIcs.setContentDescription(record, contentDescription);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setCurrentItemIndex(Object record, int currentItemIndex) {
            AccessibilityRecordCompatIcs.setCurrentItemIndex(record, currentItemIndex);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setEnabled(Object record, boolean isEnabled) {
            AccessibilityRecordCompatIcs.setEnabled(record, isEnabled);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setFromIndex(Object record, int fromIndex) {
            AccessibilityRecordCompatIcs.setFromIndex(record, fromIndex);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setFullScreen(Object record, boolean isFullScreen) {
            AccessibilityRecordCompatIcs.setFullScreen(record, isFullScreen);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setItemCount(Object record, int itemCount) {
            AccessibilityRecordCompatIcs.setItemCount(record, itemCount);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setParcelableData(Object record, Parcelable parcelableData) {
            AccessibilityRecordCompatIcs.setParcelableData(record, parcelableData);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setPassword(Object record, boolean isPassword) {
            AccessibilityRecordCompatIcs.setPassword(record, isPassword);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setRemovedCount(Object record, int removedCount) {
            AccessibilityRecordCompatIcs.setRemovedCount(record, removedCount);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setScrollX(Object record, int scrollX) {
            AccessibilityRecordCompatIcs.setScrollX(record, scrollX);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setScrollY(Object record, int scrollY) {
            AccessibilityRecordCompatIcs.setScrollY(record, scrollY);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setScrollable(Object record, boolean scrollable) {
            AccessibilityRecordCompatIcs.setScrollable(record, scrollable);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSource(Object record, View source) {
            AccessibilityRecordCompatIcs.setSource(record, source);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setToIndex(Object record, int toIndex) {
            AccessibilityRecordCompatIcs.setToIndex(record, toIndex);
        }
    }

    static class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordIcsImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getMaxScrollX(Object record) {
            return AccessibilityRecordCompatIcsMr1.getMaxScrollX(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getMaxScrollY(Object record) {
            return AccessibilityRecordCompatIcsMr1.getMaxScrollY(record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMaxScrollX(Object record, int maxScrollX) {
            AccessibilityRecordCompatIcsMr1.setMaxScrollX(record, maxScrollX);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMaxScrollY(Object record, int maxScrollY) {
            AccessibilityRecordCompatIcsMr1.setMaxScrollY(record, maxScrollY);
        }
    }

    static class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordIcsMr1Impl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSource(Object record, View root, int virtualDescendantId) {
            AccessibilityRecordCompatJellyBean.setSource(record, root, virtualDescendantId);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) { // JellyBean
            IMPL = new AccessibilityRecordJellyBeanImpl();
        } else if (Build.VERSION.SDK_INT >= 15) {  // ICS MR1
            IMPL = new AccessibilityRecordIcsMr1Impl();
        } else if (Build.VERSION.SDK_INT >= 14) { // ICS
            IMPL = new AccessibilityRecordIcsImpl();
        } else {
            IMPL = new AccessibilityRecordStubImpl();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.187 -0400", hash_original_field = "D9929383C763B2C21DE54D8C7FC3D20D", hash_generated_field = "D1D1E99F4AC4499526A983B23845B236")

    private static  AccessibilityRecordImpl IMPL;

    /**
     * Returns a cached instance if such is available or a new one is
     * instantiated. The instance is initialized with data from the
     * given record.
     *
     * @return An instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.200 -0400", hash_original_method = "AD231933D620BBEEAB028A6E7CC47026", hash_generated_method = "3B1C2B4E56F9EE4429B529F3AEDA0526")
        
public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat record) {
       return new AccessibilityRecordCompat(IMPL.obtain(record.mRecord));
    }

    /**
     * Returns a cached instance if such is available or a new one is
     * instantiated.
     *
     * @return An instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.205 -0400", hash_original_method = "0FCB2F59F0F384BC44DD564E08C514E7", hash_generated_method = "6B295EAB7EFDF3365A836C58611B0E1E")
        
public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(IMPL.obtain());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.190 -0400", hash_original_field = "F224D45AFF2A604E7CE25719AC85C9AA", hash_generated_field = "A784208C03B426DBD21A9F3B1C9C44D6")

    private  Object mRecord;

    /**
     * @deprecated This is not type safe. If you want to modify an
     * {@link AccessibilityEvent}'s properties defined in
     * {@link android.view.accessibility.AccessibilityRecord} use
     * {@link AccessibilityEventCompat#asRecord(AccessibilityEvent)}. This method will be removed
     * in a subsequent release of the support library.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.193 -0400", hash_original_method = "31BFD4200028F68ABA6334AACE842508", hash_generated_method = "EE74AA53D88EE74E2E644EC2ADD28AAD")
        
public AccessibilityRecordCompat(Object record) {
        mRecord = record;
    }

    /**
     * @return The wrapped implementation.
     *
     * @deprecated This method will be removed in a subsequent release of
     * the support library.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.195 -0400", hash_original_method = "2C39E0AE7A2BCE05DB00110D59202E17", hash_generated_method = "6FB7AB3FA39E9C58440C247EE414A4E3")
        
public Object getImpl() {
        return mRecord;
    }

    /**
     * Sets the event source.
     *
     * @param source The source.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.208 -0400", hash_original_method = "3AFA3A6DDA2E637FC419ECEFA9F818B5", hash_generated_method = "C2F7AC4D176FE4F3E311D525F1A37051")
        
public void setSource(View source) {
        IMPL.setSource(mRecord, source);
    }

    /**
     * Sets the source to be a virtual descendant of the given <code>root</code>.
     * If <code>virtualDescendantId</code> equals to {@link View#NO_ID} the root
     * is set as the source.
     * <p>
     * A virtual descendant is an imaginary View that is reported as a part of the view
     * hierarchy for accessibility purposes. This enables custom views that draw complex
     * content to report them selves as a tree of virtual views, thus conveying their
     * logical structure.
     * </p>
     *
     * @param root The root of the virtual subtree.
     * @param virtualDescendantId The id of the virtual descendant.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.211 -0400", hash_original_method = "C5C1E2089E805FAB545775E080EFBCA2", hash_generated_method = "60D4801F64D31D3994EABE2DDBCA0D56")
        
public void setSource(View root, int virtualDescendantId) {
        IMPL.setSource(mRecord, root, virtualDescendantId);
    }

    /**
     * Gets the {@link android.view.accessibility.AccessibilityNodeInfo} of
     * the event source.
     * <p>
     * <strong>Note:</strong> It is a client responsibility to recycle the
     * received info by calling
     * {@link android.view.accessibility.AccessibilityNodeInfo#recycle()
     * AccessibilityNodeInfo#recycle()} to avoid creating of multiple instances.
     *</p>
     *
     * @return The info of the source.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.214 -0400", hash_original_method = "BD5DBDA19101B7C5C2B8F78A727C7511", hash_generated_method = "B421BDB2AFB97093D74BE45A9A047374")
        
public AccessibilityNodeInfoCompat getSource() {
        return IMPL.getSource(mRecord);
    }

    /**
     * Gets the id of the window from which the event comes from.
     *
     * @return The window id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.216 -0400", hash_original_method = "62E05317A091F9EB5C63A61E1C16E080", hash_generated_method = "DB9F9D0769B58B69B898AF83D9D84AC1")
        
public int getWindowId() {
        return IMPL.getWindowId(mRecord);
    }

    /**
     * Gets if the source is checked.
     *
     * @return True if the view is checked, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.219 -0400", hash_original_method = "1AFF5AE3B94F0056D4EF443770ADC274", hash_generated_method = "8F14572186ECB63335D19347F5075F1A")
        
public boolean isChecked() {
        return IMPL.isChecked(mRecord);
    }

    /**
     * Sets if the source is checked.
     *
     * @param isChecked True if the view is checked, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.222 -0400", hash_original_method = "82939BC131B10C62FAE215420492E0DB", hash_generated_method = "29AD90AB93BE04379E91CDCA87A97F33")
        
public void setChecked(boolean isChecked) {
        IMPL.setChecked(mRecord, isChecked);
    }

    /**
     * Gets if the source is enabled.
     *
     * @return True if the view is enabled, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.224 -0400", hash_original_method = "A6196744A9E0DE4677E4EDCD9CDB5544", hash_generated_method = "F96AA7B710DB5A0324D101D9992A7285")
        
public boolean isEnabled() {
        return IMPL.isEnabled(mRecord);
    }

    /**
     * Sets if the source is enabled.
     *
     * @param isEnabled True if the view is enabled, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.227 -0400", hash_original_method = "FAC75D5FEE9E951D20E8B74F1F30D63A", hash_generated_method = "1DE502D470F275A1126D9196BB3BDF24")
        
public void setEnabled(boolean isEnabled) {
        IMPL.setEnabled(mRecord, isEnabled);
    }

    /**
     * Gets if the source is a password field.
     *
     * @return True if the view is a password field, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.230 -0400", hash_original_method = "70A4DC0C3F7EE431E19CD0DBB313CFE5", hash_generated_method = "4467F6BF641A71BCB073848E1E91AC1E")
        
public boolean isPassword() {
        return IMPL.isPassword(mRecord);
    }

    /**
     * Sets if the source is a password field.
     *
     * @param isPassword True if the view is a password field, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.232 -0400", hash_original_method = "8EE6552623D75449CC3632F110D6A6DC", hash_generated_method = "6EF5F8AD71364A8FF28B096D87C1EB8F")
        
public void setPassword(boolean isPassword) {
        IMPL.setPassword(mRecord, isPassword);
    }

    /**
     * Gets if the source is taking the entire screen.
     *
     * @return True if the source is full screen, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.235 -0400", hash_original_method = "AAC0DA1883ED67EF0CCE360E1CEF75EE", hash_generated_method = "E546E71E7B0EFAA879EE424C5B99771E")
        
public boolean isFullScreen() {
        return IMPL.isFullScreen(mRecord);
    }

    /**
     * Sets if the source is taking the entire screen.
     *
     * @param isFullScreen True if the source is full screen, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.237 -0400", hash_original_method = "758F03C13D5E2913F3F825071429E4D3", hash_generated_method = "83D26E9BBE9F4B1A9D08E02213AD165C")
        
public void setFullScreen(boolean isFullScreen) {
        IMPL.setFullScreen(mRecord, isFullScreen);
    }

    /**
     * Gets if the source is scrollable.
     *
     * @return True if the source is scrollable, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.240 -0400", hash_original_method = "DA5C61B1238A943CEEDDF7DEA078A144", hash_generated_method = "C3C14FE5201C0F5189B618EB7961DF27")
        
public boolean isScrollable() {
        return IMPL.isScrollable(mRecord);
    }

    /**
     * Sets if the source is scrollable.
     *
     * @param scrollable True if the source is scrollable, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.242 -0400", hash_original_method = "601A06B4D95E981EE14DE3F104930987", hash_generated_method = "FE58510EFC010BC3E1EF2B2E91283604")
        
public void setScrollable(boolean scrollable) {
        IMPL.setScrollable(mRecord, scrollable);
    }

    /**
     * Gets the number of items that can be visited.
     *
     * @return The number of items.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.245 -0400", hash_original_method = "FF998EEBCE262ECE980198329C7BF044", hash_generated_method = "13D7DE7EE93A94596534CF0D0B0D9256")
        
public int getItemCount() {
        return IMPL.getItemCount(mRecord);
    }

    /**
     * Sets the number of items that can be visited.
     *
     * @param itemCount The number of items.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.248 -0400", hash_original_method = "D724658F0D124C2BBF450D2DF56F4A64", hash_generated_method = "DC0B9D970B77908F5AA0835A4300F644")
        
public void setItemCount(int itemCount) {
        IMPL.setItemCount(mRecord, itemCount);
    }

    /**
     * Gets the index of the source in the list of items the can be visited.
     *
     * @return The current item index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.251 -0400", hash_original_method = "134A1A5E9720C6CF389819EA20DC75ED", hash_generated_method = "E06E5489790247CF6C3B6AA3458A905B")
        
public int getCurrentItemIndex() {
        return IMPL.getCurrentItemIndex(mRecord);
    }

    /**
     * Sets the index of the source in the list of items that can be visited.
     *
     * @param currentItemIndex The current item index.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.254 -0400", hash_original_method = "DD215C23DF27951318344094153429B5", hash_generated_method = "AEB4447B4C2B8427CF69168020719145")
        
public void setCurrentItemIndex(int currentItemIndex) {
        IMPL.setCurrentItemIndex(mRecord, currentItemIndex);
    }

    /**
     * Gets the index of the first character of the changed sequence,
     * or the beginning of a text selection or the index of the first
     * visible item when scrolling.
     *
     * @return The index of the first character or selection
     *        start or the first visible item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.257 -0400", hash_original_method = "3159741BF497F4B87AC236AE0D7CED6E", hash_generated_method = "48DD16E606C1B7E0F115678AB6E1C554")
        
public int getFromIndex() {
        return IMPL.getFromIndex(mRecord);
    }

    /**
     * Sets the index of the first character of the changed sequence
     * or the beginning of a text selection or the index of the first
     * visible item when scrolling.
     *
     * @param fromIndex The index of the first character or selection
     *        start or the first visible item.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.259 -0400", hash_original_method = "4D25992BD728B158A01F4E5FA9D902DE", hash_generated_method = "6D410BE1E81F30946232744A170837F7")
        
public void setFromIndex(int fromIndex) {
        IMPL.setFromIndex(mRecord, fromIndex);
    }

    /**
     * Gets the index of text selection end or the index of the last
     * visible item when scrolling.
     *
     * @return The index of selection end or last item index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.262 -0400", hash_original_method = "B98FE77EA903D04BD246D29EFA547DB8", hash_generated_method = "E8B72E1569E8C9C41012C5C2E8CBE654")
        
public int getToIndex() {
        return IMPL.getToIndex(mRecord);
    }

    /**
     * Sets the index of text selection end or the index of the last
     * visible item when scrolling.
     *
     * @param toIndex The index of selection end or last item index.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.264 -0400", hash_original_method = "414EFB55B509BEB1998DEF9660ADB5DF", hash_generated_method = "BF8311346E90404B78F318471D7817A3")
        
public void setToIndex(int toIndex) {
        IMPL.setToIndex(mRecord, toIndex);
    }

    /**
     * Gets the scroll offset of the source left edge in pixels.
     *
     * @return The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.267 -0400", hash_original_method = "2D992416899C0D6D302552E083379ADA", hash_generated_method = "5F87F66AE3629FC5F3FFC6992F4A44AC")
        
public int getScrollX() {
        return IMPL.getScrollX(mRecord);
    }

    /**
     * Sets the scroll offset of the source left edge in pixels.
     *
     * @param scrollX The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.270 -0400", hash_original_method = "3CE80F2924A14D2238AE5FB516124BCB", hash_generated_method = "4C5D453458A47A9A9EE824EE35B494C3")
        
public void setScrollX(int scrollX) {
        IMPL.setScrollX(mRecord, scrollX);
    }

    /**
     * Gets the scroll offset of the source top edge in pixels.
     *
     * @return The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.272 -0400", hash_original_method = "4B111184EA88BFF1C758C71BC3F20771", hash_generated_method = "BA9CE1E71BBD0C673921BB6AE2086A04")
        
public int getScrollY() {
        return IMPL.getScrollY(mRecord);
    }

    /**
     * Sets the scroll offset of the source top edge in pixels.
     *
     * @param scrollY The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.275 -0400", hash_original_method = "701F7B58DDEAE878FA149CFF436CC09C", hash_generated_method = "21D9096F3D98C751569157262BEDC36C")
        
public void setScrollY(int scrollY) {
        IMPL.setScrollY(mRecord, scrollY);
    }

    /**
     * Gets the max scroll offset of the source left edge in pixels.
     *
     * @return The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.278 -0400", hash_original_method = "026EEDFFE581A1F32092C727C4BE4904", hash_generated_method = "25D3128B034A99EC6BBE384F617C206C")
        
public int getMaxScrollX() {
        return IMPL.getMaxScrollX(mRecord);
    }
    /**
     * Sets the max scroll offset of the source left edge in pixels.
     *
     * @param maxScrollX The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.280 -0400", hash_original_method = "7C3D025978A957DA302012C823643FFA", hash_generated_method = "96CBE775B878CFE561BBED4222319704")
        
public void setMaxScrollX(int maxScrollX) {
        IMPL.setMaxScrollX(mRecord, maxScrollX);
    }

    /**
     * Gets the max scroll offset of the source top edge in pixels.
     *
     * @return The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.283 -0400", hash_original_method = "53D3A6102CD53DB5C0BF2E7FB939B80F", hash_generated_method = "CFA5408A4BBC0708C4FC731FB6786874")
        
public int getMaxScrollY() {
        return IMPL.getMaxScrollY(mRecord);
    }

    /**
     * Sets the max scroll offset of the source top edge in pixels.
     *
     * @param maxScrollY The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.285 -0400", hash_original_method = "AE0FD849F58F60734C931CC634460D70", hash_generated_method = "630381C79B5B8C9DFD70CED16AF80EC2")
        
public void setMaxScrollY(int maxScrollY) {
        IMPL.setMaxScrollY(mRecord, maxScrollY);
    }

    /**
     * Gets the number of added characters.
     *
     * @return The number of added characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.288 -0400", hash_original_method = "AE14117EBCD35B74E7A6C851CE8210F8", hash_generated_method = "67D2FDB88DC473F8DDB3A8CA82F31E2E")
        
public int getAddedCount() {
        return IMPL.getAddedCount(mRecord);
    }

    /**
     * Sets the number of added characters.
     *
     * @param addedCount The number of added characters.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.291 -0400", hash_original_method = "575511048E9683D5570A7B1D589F2F9C", hash_generated_method = "52B34116335892C28907E139C3CE79A0")
        
public void setAddedCount(int addedCount) {
        IMPL.setAddedCount(mRecord, addedCount);
    }

    /**
     * Gets the number of removed characters.
     *
     * @return The number of removed characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.293 -0400", hash_original_method = "270EBCBE6CCF53B396B18FE08804E168", hash_generated_method = "B1EFC511FDAF286D6C552013390BD745")
        
public int getRemovedCount() {
        return IMPL.getRemovedCount(mRecord);
    }

    /**
     * Sets the number of removed characters.
     *
     * @param removedCount The number of removed characters.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.296 -0400", hash_original_method = "99F088C5A877A6D1CA743EAA6EB22155", hash_generated_method = "488A2900677E7786B47227CAC8080E1B")
        
public void setRemovedCount(int removedCount) {
        IMPL.setRemovedCount(mRecord, removedCount);
    }

    /**
     * Gets the class name of the source.
     *
     * @return The class name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.298 -0400", hash_original_method = "67AA0D33040F2AF335EF030F65429A0D", hash_generated_method = "9B7C3748E4F61B02E9A39D23342238B4")
        
public CharSequence getClassName() {
        return IMPL.getClassName(mRecord);
    }

    /**
     * Sets the class name of the source.
     *
     * @param className The lass name.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.301 -0400", hash_original_method = "2A00F8117EF5BF1532A324D95A4DA5A5", hash_generated_method = "4B61217C762EA5383AB992AA9975F610")
        
public void setClassName(CharSequence className) {
        IMPL.setClassName(mRecord, className);
    }

    /**
     * Gets the text of the event. The index in the list represents the priority
     * of the text. Specifically, the lower the index the higher the priority.
     *
     * @return The text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.303 -0400", hash_original_method = "6C334D32F26DB2948FA7A060F2770263", hash_generated_method = "4B2BBF567AC92BB671999A7DEA33D260")
        
public List<CharSequence> getText() {
        return IMPL.getText(mRecord);
    }

    /**
     * Sets the text before a change.
     *
     * @return The text before the change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.306 -0400", hash_original_method = "4C454BCB63118A3CFA6774F8547F2900", hash_generated_method = "F129A173B8CD3A687758BE066B18FEAF")
        
public CharSequence getBeforeText() {
        return IMPL.getBeforeText(mRecord);
    }

    /**
     * Sets the text before a change.
     *
     * @param beforeText The text before the change.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.308 -0400", hash_original_method = "17C47A47264827FA91F78B1F5C19C158", hash_generated_method = "81E7272751B18F3222C669105CD9932A")
        
public void setBeforeText(CharSequence beforeText) {
        IMPL.setBeforeText(mRecord, beforeText);
    }

    /**
     * Gets the description of the source.
     *
     * @return The description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.311 -0400", hash_original_method = "0E1DDDE186BEA175AC4E63AF1F7EF300", hash_generated_method = "6EF945A4AAA82CFEB63EE038C4B93B35")
        
public CharSequence getContentDescription() {
        return IMPL.getContentDescription(mRecord);
    }

    /**
     * Sets the description of the source.
     *
     * @param contentDescription The description.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.313 -0400", hash_original_method = "24B5932BDE3800F2FCAC61218978EDA1", hash_generated_method = "31054DF5B79A95CC6887B4D0FDCDF4B8")
        
public void setContentDescription(CharSequence contentDescription) {
        IMPL.setContentDescription(mRecord, contentDescription);
    }

    /**
     * Gets the {@link Parcelable} data.
     *
     * @return The parcelable data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.316 -0400", hash_original_method = "6CF5581B59D6C7B0E77B7A5EDAAA13F8", hash_generated_method = "24DF5B1E8C2B9979765823E28D41E91B")
        
public Parcelable getParcelableData() {
        return IMPL.getParcelableData(mRecord);
    }

    /**
     * Sets the {@link Parcelable} data of the event.
     *
     * @param parcelableData The parcelable data.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.319 -0400", hash_original_method = "991957DCCCA90403EB058761C8C6E328", hash_generated_method = "1CAD8EBED539B89887BA354E45C47A8D")
        
public void setParcelableData(Parcelable parcelableData) {
        IMPL.setParcelableData(mRecord, parcelableData);
    }

    /**
     * Return an instance back to be reused.
     * <p>
     * <strong>Note:</strong> You must not touch the object after calling this
     * function.
     * </p>
     *
     * @throws IllegalStateException If the record is already recycled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.322 -0400", hash_original_method = "CC34369D324679ED344B1A114F44B50C", hash_generated_method = "A2E5D4E4CFCEDE6ACFD8D09E72AE0EA0")
        
public void recycle() {
        IMPL.recycle(mRecord);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.324 -0400", hash_original_method = "25EC1341BA7AB69E33A1507EBB2B1096", hash_generated_method = "A1C5551C739B3736B4A6A18BA02FCE0E")
        
@Override
    public int hashCode() {
        return (mRecord == null) ? 0 : mRecord.hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:10.327 -0400", hash_original_method = "23C3AD1F1A4F2DE3EE1527927DE9E6EE", hash_generated_method = "0EB6254746C0D84971139AFEEA52BAE8")
        
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
        AccessibilityRecordCompat other = (AccessibilityRecordCompat) obj;
        if (mRecord == null) {
            if (other.mRecord != null) {
                return false;
            }
        } else if (!mRecord.equals(other.mRecord)) {
            return false;
        }
        return true;
    }
}
