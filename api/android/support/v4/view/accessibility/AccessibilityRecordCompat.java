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
import android.os.Build;
import android.os.Parcelable;
import android.view.View;

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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.232 -0500", hash_original_method = "817FD8D623FDA4524F619AFC293F09EC", hash_generated_method = "E63F20960B6D02B12716A3819EFD1DB3")
        
public Object obtain() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.238 -0500", hash_original_method = "C833934C702CCEDDDC40965CF6BB153A", hash_generated_method = "5C290EC9EBEB4BFBE387609E0D9669C1")
        
public Object obtain(Object record) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.248 -0500", hash_original_method = "F90CB281D321FEE4A4F0AF83B7ABB25F", hash_generated_method = "8395F33713C137678C91CC8DCC1C85F8")
        
public int getAddedCount(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.256 -0500", hash_original_method = "D88DAB510B8A28B158E9FAE2985AFAAE", hash_generated_method = "D4A50B608802297F15B5F5C580726B1A")
        
public CharSequence getBeforeText(Object record) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.263 -0500", hash_original_method = "FD914D1EFD1979B37ED7245D7B7F7059", hash_generated_method = "8B755CC61A41277EBFC4E498C42DB9E5")
        
public CharSequence getClassName(Object record) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.269 -0500", hash_original_method = "D84898F53B55733105C243C31FF4D92A", hash_generated_method = "CAF063AD9B1E9221FAFACAFE4E1D99CD")
        
public CharSequence getContentDescription(Object record) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.286 -0500", hash_original_method = "ED755EB9CD2FCB213F8D0958182918B1", hash_generated_method = "81B6CE7870AFD751EB2F5A2BC2FE172A")
        
public int getCurrentItemIndex(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.297 -0500", hash_original_method = "EA55EE1496DF735826E7042DBF59DA21", hash_generated_method = "3987405B39094158B1325BF29DCAF612")
        
public int getFromIndex(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.308 -0500", hash_original_method = "B2CEF64A9C6DC39EFF7F59F41B235ACE", hash_generated_method = "2D59078E29748B24183D1BC190865651")
        
public int getItemCount(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.317 -0500", hash_original_method = "43109DE447EFD28C11432306FD2A6430", hash_generated_method = "728C23FBBE8EC2BEFCC98CFC036226AE")
        
public int getMaxScrollX(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.325 -0500", hash_original_method = "79A4CD5BA9EBA207867CFDF16F8DCECF", hash_generated_method = "D9043E637887C85D53891BFE742CBF27")
        
public int getMaxScrollY(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.333 -0500", hash_original_method = "A496485FDBB3D7A6E6A1E20087CB0236", hash_generated_method = "B8A28EBB9FAECE6F7F3DB3B3E07BD8CF")
        
public Parcelable getParcelableData(Object record) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.343 -0500", hash_original_method = "83058A7D703FFDCDBF9FB80F6F624B91", hash_generated_method = "8B4781F3628FEA57C09DFC610F13D5B3")
        
public int getRemovedCount(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.353 -0500", hash_original_method = "A98DC13E63DB6EDF6312E82E1369DC81", hash_generated_method = "F2DF0141ECBB93FCCA5035F3C3394BE7")
        
public int getScrollX(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.361 -0500", hash_original_method = "D402DAA3C0FEF0B1A87C51CCB5A458A6", hash_generated_method = "D4FA330661026690598E9B6A9C019908")
        
public int getScrollY(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.367 -0500", hash_original_method = "AD04ECEBE51E642ED17BCF964DDAE084", hash_generated_method = "BD440C69F1A066C56C2936EF0F491DD2")
        
public AccessibilityNodeInfoCompat getSource(Object record) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.373 -0500", hash_original_method = "557E1B686C578B3F4C5D623A55790D8F", hash_generated_method = "F20A82248C2E6862C50F967608241FE0")
        
public List<CharSequence> getText(Object record) {
            return Collections.emptyList();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.380 -0500", hash_original_method = "53BD445A2E4F458172E7D521BE2BA282", hash_generated_method = "4AA7ABB57EF166792DB1DC0390568A36")
        
public int getToIndex(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.391 -0500", hash_original_method = "E7E274C535518FCBAF4AC98EFC681CC0", hash_generated_method = "D28F657F6FDCF2D8CA43D90DCD3CB70B")
        
public int getWindowId(Object record) {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.399 -0500", hash_original_method = "B009BFD7507989B7F184DE698965678F", hash_generated_method = "3B84D3297CD8369739E5F8299C8BA93B")
        
public boolean isChecked(Object record) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.405 -0500", hash_original_method = "387492772BF087B392CED940E81C610C", hash_generated_method = "C30B55CA3F11F083FCC5B1E7D208BE67")
        
public boolean isEnabled(Object record) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.412 -0500", hash_original_method = "C9E2268D6783DD1689D249ED1947D214", hash_generated_method = "8EF54A75CCB2C83A8709A0A394B0FA8E")
        
public boolean isFullScreen(Object record) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.417 -0500", hash_original_method = "B0A101CD42EE708C94CC714B34E79483", hash_generated_method = "BF7CA31B78B4E7E17402CEABEF929BB2")
        
public boolean isPassword(Object record) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.426 -0500", hash_original_method = "EFE1A97D41CCD0AC1CAE8AE734022222", hash_generated_method = "47A62A91B5CB1AB5E4440859773F1048")
        
public boolean isScrollable(Object record) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.432 -0500", hash_original_method = "0822C51B444C5D0A3B1814CCF76346D8", hash_generated_method = "5AA7C409542DFF72369B4E48A55E4DB5")
        
public void recycle(Object record) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.440 -0500", hash_original_method = "AB58CF4EF2D36470A4509FD8C486C38C", hash_generated_method = "941097B7AFDD8FCCF2A4C82D1085FAA0")
        
public void setAddedCount(Object record, int addedCount) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.448 -0500", hash_original_method = "0C616FCF3D2F73E411A730590E3D5D32", hash_generated_method = "E7DEA07AF501665B7DD721CF8ADD80DB")
        
public void setBeforeText(Object record, CharSequence beforeText) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.454 -0500", hash_original_method = "7C27BC3788733125D507437335EC353D", hash_generated_method = "476B900AC5644288487F1CDCEA207BFF")
        
public void setChecked(Object record, boolean isChecked) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.460 -0500", hash_original_method = "FD317401C826C1223A64867C6EC5B291", hash_generated_method = "E2B14488B82F5DB19A301FFAF494CB63")
        
public void setClassName(Object record, CharSequence className) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.464 -0500", hash_original_method = "94F0136A29282DAA3DE997090A6A286A", hash_generated_method = "FACFD60DD653BD5D107CCB5E4BF347A8")
        
public void setContentDescription(Object record, CharSequence contentDescription) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.470 -0500", hash_original_method = "A2C7EF51987839BAAD4F90BA90C23B24", hash_generated_method = "948976A8566D841C648B6107B0B7C214")
        
public void setCurrentItemIndex(Object record, int currentItemIndex) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.477 -0500", hash_original_method = "1CB087CD34A2A1CF4BACE46FF2A73CB2", hash_generated_method = "7C6EE16288390C16DB94E392B5E2DA7A")
        
public void setEnabled(Object record, boolean isEnabled) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.486 -0500", hash_original_method = "A1530126D49151037E6BE9D65E5EF0F5", hash_generated_method = "2942AB91A34655B458246DED0F9BB5D1")
        
public void setFromIndex(Object record, int fromIndex) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.492 -0500", hash_original_method = "636733158A16FF28777C708D236383E9", hash_generated_method = "CA1EFA8F587C5657D31C9B55872E9B10")
        
public void setFullScreen(Object record, boolean isFullScreen) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.498 -0500", hash_original_method = "7CF260AA168E10865865C5096E83F546", hash_generated_method = "759683BF292A98FE2ACA0C41DFB98E03")
        
public void setItemCount(Object record, int itemCount) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.507 -0500", hash_original_method = "B0E228EC678D60AF999CBBCF90005DC4", hash_generated_method = "45899F5346F1C379101404F8EF46E9BC")
        
public void setMaxScrollX(Object record, int maxScrollX) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.515 -0500", hash_original_method = "6BFFE4DDD0D4E15E25FCE31267BE93D4", hash_generated_method = "E4EE3E4A70650775AE4A5C121ABD2B04")
        
public void setMaxScrollY(Object record, int maxScrollY) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.523 -0500", hash_original_method = "451273F7B55B772F2ACF5DAE588A6DDB", hash_generated_method = "FBA49DA2304854A662C0F13D6182BA49")
        
public void setParcelableData(Object record, Parcelable parcelableData) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.532 -0500", hash_original_method = "F35ACC96BB4285B03C9C78E114EF8F8B", hash_generated_method = "ACE492433993A800BA84D88907F3EBBF")
        
public void setPassword(Object record, boolean isPassword) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.539 -0500", hash_original_method = "A89AC7628D40B20639C8511B06AD2E79", hash_generated_method = "384D2A0942C7013FC5E3C24F8F402853")
        
public void setRemovedCount(Object record, int removedCount) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.544 -0500", hash_original_method = "DA3CC9AB973CA8FF4F8225CF31D19FEC", hash_generated_method = "0330C76F9B4EDA68355F778FF7617721")
        
public void setScrollX(Object record, int scrollX) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.551 -0500", hash_original_method = "867F931D8D0C10A48663B9ECBFA8AA42", hash_generated_method = "47A9BEEEA7C9A268E7ADAF301EC6179A")
        
public void setScrollY(Object record, int scrollY) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.560 -0500", hash_original_method = "D396DC479E27254826BDBDB3890ABCBE", hash_generated_method = "A969D654A05E1635656B40DCFB501BAD")
        
public void setScrollable(Object record, boolean scrollable) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.568 -0500", hash_original_method = "D302B78A3606FA23A1E14A2A82F4DEFF", hash_generated_method = "7D069B941396427ADC81A55B32314A58")
        
public void setSource(Object record, View source) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.579 -0500", hash_original_method = "D826993569B19883E7E5AC70428C6BE2", hash_generated_method = "9251F539122F28683C02FC60453FE6A0")
        
public void setSource(Object record, View root, int virtualDescendantId) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.589 -0500", hash_original_method = "D8359FB6845E0B840F7081D0CBF68C27", hash_generated_method = "E507E29C0E6573BDE8306EA4555EFD65")
        
public void setToIndex(Object record, int toIndex) {

        }
    }

    static class AccessibilityRecordIcsImpl extends AccessibilityRecordStubImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.632 -0500", hash_original_method = "7EB73FBAB263789F210F7788D51468F4", hash_generated_method = "68957D54EC0E0F9EC0B86415A4E17983")
        
@Override
        public Object obtain() {
            return AccessibilityRecordCompatIcs.obtain();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.639 -0500", hash_original_method = "BC9FDD776008A9B0D82C05498D1EECA9", hash_generated_method = "970EFDEB8F0B3D18EE15B4DBAC0890B0")
        
@Override
        public Object obtain(Object record) {
            return AccessibilityRecordCompatIcs.obtain(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.644 -0500", hash_original_method = "1A3B37CCDB12C867E6A2288A86DB25D6", hash_generated_method = "A39173A2D817F615175C7FD3CB0C03A7")
        
@Override
        public int getAddedCount(Object record) {
            return AccessibilityRecordCompatIcs.getAddedCount(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.651 -0500", hash_original_method = "3233A2F1E3D7B7C0F821BB74C3572D3B", hash_generated_method = "584AC428A0171FBE05435F6286476D4E")
        
@Override
        public CharSequence getBeforeText(Object record) {
            return AccessibilityRecordCompatIcs.getBeforeText(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.656 -0500", hash_original_method = "CE0472CF4E9A5E340A202A18673487AD", hash_generated_method = "0B89D6235EE0976AFC09B53E975BDB06")
        
@Override
        public CharSequence getClassName(Object record) {
            return AccessibilityRecordCompatIcs.getClassName(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.665 -0500", hash_original_method = "90265E40F7249321A4F41F94F40B90B4", hash_generated_method = "304F3E5C34FABAF34DAB63789DF68F18")
        
@Override
        public CharSequence getContentDescription(Object record) {
            return AccessibilityRecordCompatIcs.getContentDescription(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.675 -0500", hash_original_method = "6C105B97A5CC45B944ED2061420896E4", hash_generated_method = "2AFF71E1D415075EECC3C64371FEB7D2")
        
@Override
        public int getCurrentItemIndex(Object record) {
            return AccessibilityRecordCompatIcs.getCurrentItemIndex(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.683 -0500", hash_original_method = "E73C10ABA610508FD459620AD9ECEF63", hash_generated_method = "668F13B36E16E80767FF8032CDFD71A6")
        
@Override
        public int getFromIndex(Object record) {
            return AccessibilityRecordCompatIcs.getFromIndex(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.691 -0500", hash_original_method = "C0064662D0DCC3222F592593F36EEC2E", hash_generated_method = "4AD09A63B1DB94E6B2F3FC2DAC7B3E0B")
        
@Override
        public int getItemCount(Object record) {
            return AccessibilityRecordCompatIcs.getItemCount(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.699 -0500", hash_original_method = "CC62F112D356933D47B1FFB5ECF96325", hash_generated_method = "7E54684ECE2785210134282C3FD280D3")
        
@Override
        public Parcelable getParcelableData(Object record) {
            return AccessibilityRecordCompatIcs.getParcelableData(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.706 -0500", hash_original_method = "74EE57882BE0AC5227D4B1A7BE4DF3EB", hash_generated_method = "FABF5E9406292686BAA41C08E08715E5")
        
@Override
        public int getRemovedCount(Object record) {
            return AccessibilityRecordCompatIcs.getRemovedCount(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.714 -0500", hash_original_method = "3CDC55E12CC43F0F7062D946B2C371BA", hash_generated_method = "30DF24AAF9EDC5BD8860CCFF39319410")
        
@Override
        public int getScrollX(Object record) {
            return AccessibilityRecordCompatIcs.getScrollX(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.723 -0500", hash_original_method = "A53F9B18279808A39A557368A4537B73", hash_generated_method = "8A465C02DDC1A031481DA4C876DCD58D")
        
@Override
        public int getScrollY(Object record) {
            return AccessibilityRecordCompatIcs.getScrollY(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.730 -0500", hash_original_method = "1C233517AC94E0C908D3501B04301887", hash_generated_method = "42C1ADD212AF139B99322F6B97DB3175")
        
@Override
        public AccessibilityNodeInfoCompat getSource(Object record) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(
                    AccessibilityRecordCompatIcs.getSource(record));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.737 -0500", hash_original_method = "7D5A4E2FBB71350423F36CEA34258542", hash_generated_method = "77142A2AFB6D297D7847E2C5FD59D52A")
        
@Override
        public List<CharSequence> getText(Object record) {
            return AccessibilityRecordCompatIcs.getText(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.741 -0500", hash_original_method = "DBFAF70FD24A0E3BD9DECD31C804261E", hash_generated_method = "51FF114EB7F00DC0257ED57E2D30E1EE")
        
@Override
        public int getToIndex(Object record) {
            return AccessibilityRecordCompatIcs.getToIndex(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.748 -0500", hash_original_method = "82570EB5ECC68E1592DDC7271BAA513A", hash_generated_method = "AD521B767012F32A046C2EE29FB0D45A")
        
@Override
        public int getWindowId(Object record) {
            return AccessibilityRecordCompatIcs.getWindowId(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.753 -0500", hash_original_method = "D84F419FB6F45F1DC525312FAE07E15A", hash_generated_method = "06591A9FD261367E417BAD4EDBD25044")
        
@Override
        public boolean isChecked(Object record) {
            return AccessibilityRecordCompatIcs.isChecked(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.761 -0500", hash_original_method = "C4D9B7F97B0BCAF922F0D36278F5ECC6", hash_generated_method = "9A724A66D6A8406C3B41CE52528A0008")
        
@Override
        public boolean isEnabled(Object record) {
            return AccessibilityRecordCompatIcs.isEnabled(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.772 -0500", hash_original_method = "2C61F22D5E7C67D35B4F5A356D7C4989", hash_generated_method = "DD94DD3D8AE7BA9853B1B592BFD79DF5")
        
@Override
        public boolean isFullScreen(Object record) {
            return AccessibilityRecordCompatIcs.isFullScreen(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.778 -0500", hash_original_method = "A44538CA98CE6E195EC08845FDC2FD6F", hash_generated_method = "0F241AA3F01EC7062A69F19CAD21106D")
        
@Override
        public boolean isPassword(Object record) {
            return AccessibilityRecordCompatIcs.isPassword(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.784 -0500", hash_original_method = "E306720FA5100494F8B3A29CFC4AB9F1", hash_generated_method = "854CD3C5B3546CB5FE84449416482D10")
        
@Override
        public boolean isScrollable(Object record) {
            return AccessibilityRecordCompatIcs.isScrollable(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.788 -0500", hash_original_method = "2DCE6B495EBDB32321C0D4BA972CB3B3", hash_generated_method = "7E4753D64683C215D676C0B0F47E0459")
        
@Override
        public void recycle(Object record) {
            AccessibilityRecordCompatIcs.recycle(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.794 -0500", hash_original_method = "DDC17112B95239E4ABC47C1E1767BE34", hash_generated_method = "6942375CE6FABEA5068C5A64505C2A1E")
        
@Override
        public void setAddedCount(Object record, int addedCount) {
            AccessibilityRecordCompatIcs.setAddedCount(record, addedCount);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.800 -0500", hash_original_method = "109C8040B092501378954582255B3673", hash_generated_method = "056C3629F00B7AD5E34FC27CE67D4798")
        
@Override
        public void setBeforeText(Object record, CharSequence beforeText) {
            AccessibilityRecordCompatIcs.setBeforeText(record, beforeText);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.808 -0500", hash_original_method = "BD52DFCDB1D18E3D81A71744F8272351", hash_generated_method = "1FB1C14A5F211C21E2DAFCBDF32ABB85")
        
@Override
        public void setChecked(Object record, boolean isChecked) {
            AccessibilityRecordCompatIcs.setChecked(record, isChecked);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.816 -0500", hash_original_method = "7BA9A0C3B031A8D2A4A136C329BCA964", hash_generated_method = "1F639069ACBFCED7FCAB572F558D0DCA")
        
@Override
        public void setClassName(Object record, CharSequence className) {
            AccessibilityRecordCompatIcs.setClassName(record, className);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.821 -0500", hash_original_method = "F1EE16D13E1090ACD14D9B11E9F3D349", hash_generated_method = "4CABFBAE65707DBE9F24685E6BD577F7")
        
@Override
        public void setContentDescription(Object record, CharSequence contentDescription) {
            AccessibilityRecordCompatIcs.setContentDescription(record, contentDescription);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.825 -0500", hash_original_method = "8C69B4B73D3FC51261DEED6BC23C4A94", hash_generated_method = "D32328155426E91AF972FAE589409810")
        
@Override
        public void setCurrentItemIndex(Object record, int currentItemIndex) {
            AccessibilityRecordCompatIcs.setCurrentItemIndex(record, currentItemIndex);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.831 -0500", hash_original_method = "C6018A1F789E522815162DE2BFD2E76A", hash_generated_method = "28FDF4BAC87A45D035D4D14F9C2D08ED")
        
@Override
        public void setEnabled(Object record, boolean isEnabled) {
            AccessibilityRecordCompatIcs.setEnabled(record, isEnabled);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.837 -0500", hash_original_method = "731C43A20B4248157CFF4E6A90BA6ACB", hash_generated_method = "AB7995C55629BFDE98134C3B37CF02E9")
        
@Override
        public void setFromIndex(Object record, int fromIndex) {
            AccessibilityRecordCompatIcs.setFromIndex(record, fromIndex);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.842 -0500", hash_original_method = "CD49CF55168D5300B72410A3B8ED32C0", hash_generated_method = "A3D04FF8D7D8EE2042034F792406F2DE")
        
@Override
        public void setFullScreen(Object record, boolean isFullScreen) {
            AccessibilityRecordCompatIcs.setFullScreen(record, isFullScreen);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.847 -0500", hash_original_method = "F2CD26C5C838EDD025B4D40D354837BF", hash_generated_method = "97C21FEB71B6994F7CEDE833A365A370")
        
@Override
        public void setItemCount(Object record, int itemCount) {
            AccessibilityRecordCompatIcs.setItemCount(record, itemCount);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.854 -0500", hash_original_method = "2EB1B6160F5E20FA1D639E3D4F5851B2", hash_generated_method = "B0D15E3D81EAFC8634698B21D8AE7A12")
        
@Override
        public void setParcelableData(Object record, Parcelable parcelableData) {
            AccessibilityRecordCompatIcs.setParcelableData(record, parcelableData);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.862 -0500", hash_original_method = "680F59D9F36DDD7043F00930FAC1DB30", hash_generated_method = "F485FB9DEA7C13C6EC7A0CE74490D8F4")
        
@Override
        public void setPassword(Object record, boolean isPassword) {
            AccessibilityRecordCompatIcs.setPassword(record, isPassword);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.868 -0500", hash_original_method = "3A809745C2F04B43B84545BC92A48B5D", hash_generated_method = "E53B5BCC6323510EF19B350597C3E90A")
        
@Override
        public void setRemovedCount(Object record, int removedCount) {
            AccessibilityRecordCompatIcs.setRemovedCount(record, removedCount);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.872 -0500", hash_original_method = "924F87FF58D3CC5A5EF35035A475CFDB", hash_generated_method = "BE5BF62BF045420937A708128C102BB0")
        
@Override
        public void setScrollX(Object record, int scrollX) {
            AccessibilityRecordCompatIcs.setScrollX(record, scrollX);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.878 -0500", hash_original_method = "AF8507ABF0BB78F3B8C05F5D96A45B58", hash_generated_method = "E1C2BBE99B015045B4093EBD500039CE")
        
@Override
        public void setScrollY(Object record, int scrollY) {
            AccessibilityRecordCompatIcs.setScrollY(record, scrollY);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.884 -0500", hash_original_method = "7720BB37EC0AC80BE51120598A64968E", hash_generated_method = "4E3247BF69E672483174DB099AA4153A")
        
@Override
        public void setScrollable(Object record, boolean scrollable) {
            AccessibilityRecordCompatIcs.setScrollable(record, scrollable);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.889 -0500", hash_original_method = "DD116DB6DF621B64C90116C909A19B22", hash_generated_method = "03790FF371882DC4DD866DFA71816BB9")
        
@Override
        public void setSource(Object record, View source) {
            AccessibilityRecordCompatIcs.setSource(record, source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.893 -0500", hash_original_method = "4B2B7301B207AC517FB6F6EE2CE16262", hash_generated_method = "3DBDEF278B6779B5A2EA914DE1127E88")
        
@Override
        public void setToIndex(Object record, int toIndex) {
            AccessibilityRecordCompatIcs.setToIndex(record, toIndex);
        }
    }

    static class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordIcsImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.918 -0500", hash_original_method = "F6447CE2880D1C5D7603A51E52113D39", hash_generated_method = "7843B579EA662CE9AB42D66192F4185C")
        
@Override
        public int getMaxScrollX(Object record) {
            return AccessibilityRecordCompatIcsMr1.getMaxScrollX(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.922 -0500", hash_original_method = "7E1E81E703796E4D0991FF571B3F5F99", hash_generated_method = "8D203E50BC4F9B8EACF2298B88C8BD10")
        
@Override
        public int getMaxScrollY(Object record) {
            return AccessibilityRecordCompatIcsMr1.getMaxScrollY(record);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.928 -0500", hash_original_method = "461131C66E704B7AA2D563B2323854EF", hash_generated_method = "18DDB5C3C994248A2785CE1AA41F8438")
        
@Override
        public void setMaxScrollX(Object record, int maxScrollX) {
            AccessibilityRecordCompatIcsMr1.setMaxScrollX(record, maxScrollX);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.934 -0500", hash_original_method = "EF568A2D21619E53346FDC39FD4BFA18", hash_generated_method = "1635583FD16AFFFBB9CF894793382538")
        
@Override
        public void setMaxScrollY(Object record, int maxScrollY) {
            AccessibilityRecordCompatIcsMr1.setMaxScrollY(record, maxScrollY);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 15) {  // ICS MR1
            IMPL = new AccessibilityRecordIcsMr1Impl();
        } else if (Build.VERSION.SDK_INT >= 14) { // ICS
            IMPL = new AccessibilityRecordIcsImpl();
        } else {
            IMPL = new AccessibilityRecordStubImpl();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.959 -0500", hash_original_field = "D9929383C763B2C21DE54D8C7FC3D20D", hash_generated_field = "D1D1E99F4AC4499526A983B23845B236")


    private static  AccessibilityRecordImpl IMPL;

    /**
     * Returns a cached instance if such is available or a new one is
     * instantiated. The instance is initialized with data from the
     * given record.
     *
     * @return An instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.984 -0500", hash_original_method = "AD231933D620BBEEAB028A6E7CC47026", hash_generated_method = "3B1C2B4E56F9EE4429B529F3AEDA0526")
    
public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat record) {
       return new AccessibilityRecordCompat(IMPL.obtain(record.mRecord));
    }

    /**
     * Returns a cached instance if such is available or a new one is
     * instantiated.
     *
     * @return An instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.989 -0500", hash_original_method = "0FCB2F59F0F384BC44DD564E08C514E7", hash_generated_method = "6B295EAB7EFDF3365A836C58611B0E1E")
    
public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(IMPL.obtain());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.967 -0500", hash_original_field = "F224D45AFF2A604E7CE25719AC85C9AA", hash_generated_field = "A784208C03B426DBD21A9F3B1C9C44D6")


    private  Object mRecord;

    /*
     * Hide constructor from clients.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.972 -0500", hash_original_method = "31BFD4200028F68ABA6334AACE842508", hash_generated_method = "EE74AA53D88EE74E2E644EC2ADD28AAD")
    
public AccessibilityRecordCompat(Object record) {
        mRecord = record;
    }

    /**
     * @return The wrapped implementation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.977 -0500", hash_original_method = "2C39E0AE7A2BCE05DB00110D59202E17", hash_generated_method = "6FB7AB3FA39E9C58440C247EE414A4E3")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.993 -0500", hash_original_method = "3AFA3A6DDA2E637FC419ECEFA9F818B5", hash_generated_method = "C2F7AC4D176FE4F3E311D525F1A37051")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:21.998 -0500", hash_original_method = "C5C1E2089E805FAB545775E080EFBCA2", hash_generated_method = "60D4801F64D31D3994EABE2DDBCA0D56")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.002 -0500", hash_original_method = "BD5DBDA19101B7C5C2B8F78A727C7511", hash_generated_method = "B421BDB2AFB97093D74BE45A9A047374")
    
public AccessibilityNodeInfoCompat getSource() {
        return IMPL.getSource(mRecord);
    }

    /**
     * Gets the id of the window from which the event comes from.
     *
     * @return The window id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.008 -0500", hash_original_method = "62E05317A091F9EB5C63A61E1C16E080", hash_generated_method = "DB9F9D0769B58B69B898AF83D9D84AC1")
    
public int getWindowId() {
        return IMPL.getWindowId(mRecord);
    }

    /**
     * Gets if the source is checked.
     *
     * @return True if the view is checked, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.015 -0500", hash_original_method = "1AFF5AE3B94F0056D4EF443770ADC274", hash_generated_method = "8F14572186ECB63335D19347F5075F1A")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.022 -0500", hash_original_method = "82939BC131B10C62FAE215420492E0DB", hash_generated_method = "29AD90AB93BE04379E91CDCA87A97F33")
    
public void setChecked(boolean isChecked) {
        IMPL.setChecked(mRecord, isChecked);
    }

    /**
     * Gets if the source is enabled.
     *
     * @return True if the view is enabled, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.026 -0500", hash_original_method = "A6196744A9E0DE4677E4EDCD9CDB5544", hash_generated_method = "F96AA7B710DB5A0324D101D9992A7285")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.030 -0500", hash_original_method = "FAC75D5FEE9E951D20E8B74F1F30D63A", hash_generated_method = "1DE502D470F275A1126D9196BB3BDF24")
    
public void setEnabled(boolean isEnabled) {
        IMPL.setEnabled(mRecord, isEnabled);
    }

    /**
     * Gets if the source is a password field.
     *
     * @return True if the view is a password field, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.034 -0500", hash_original_method = "70A4DC0C3F7EE431E19CD0DBB313CFE5", hash_generated_method = "4467F6BF641A71BCB073848E1E91AC1E")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.040 -0500", hash_original_method = "8EE6552623D75449CC3632F110D6A6DC", hash_generated_method = "6EF5F8AD71364A8FF28B096D87C1EB8F")
    
public void setPassword(boolean isPassword) {
        IMPL.setPassword(mRecord, isPassword);
    }

    /**
     * Gets if the source is taking the entire screen.
     *
     * @return True if the source is full screen, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.046 -0500", hash_original_method = "AAC0DA1883ED67EF0CCE360E1CEF75EE", hash_generated_method = "E546E71E7B0EFAA879EE424C5B99771E")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.050 -0500", hash_original_method = "758F03C13D5E2913F3F825071429E4D3", hash_generated_method = "83D26E9BBE9F4B1A9D08E02213AD165C")
    
public void setFullScreen(boolean isFullScreen) {
        IMPL.setFullScreen(mRecord, isFullScreen);
    }

    /**
     * Gets if the source is scrollable.
     *
     * @return True if the source is scrollable, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.056 -0500", hash_original_method = "DA5C61B1238A943CEEDDF7DEA078A144", hash_generated_method = "C3C14FE5201C0F5189B618EB7961DF27")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.064 -0500", hash_original_method = "601A06B4D95E981EE14DE3F104930987", hash_generated_method = "FE58510EFC010BC3E1EF2B2E91283604")
    
public void setScrollable(boolean scrollable) {
        IMPL.setScrollable(mRecord, scrollable);
    }

    /**
     * Gets the number of items that can be visited.
     *
     * @return The number of items.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.073 -0500", hash_original_method = "FF998EEBCE262ECE980198329C7BF044", hash_generated_method = "13D7DE7EE93A94596534CF0D0B0D9256")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.082 -0500", hash_original_method = "D724658F0D124C2BBF450D2DF56F4A64", hash_generated_method = "DC0B9D970B77908F5AA0835A4300F644")
    
public void setItemCount(int itemCount) {
        IMPL.setItemCount(mRecord, itemCount);
    }

    /**
     * Gets the index of the source in the list of items the can be visited.
     *
     * @return The current item index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.089 -0500", hash_original_method = "134A1A5E9720C6CF389819EA20DC75ED", hash_generated_method = "E06E5489790247CF6C3B6AA3458A905B")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.094 -0500", hash_original_method = "DD215C23DF27951318344094153429B5", hash_generated_method = "AEB4447B4C2B8427CF69168020719145")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.100 -0500", hash_original_method = "3159741BF497F4B87AC236AE0D7CED6E", hash_generated_method = "48DD16E606C1B7E0F115678AB6E1C554")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.108 -0500", hash_original_method = "4D25992BD728B158A01F4E5FA9D902DE", hash_generated_method = "6D410BE1E81F30946232744A170837F7")
    
public void setFromIndex(int fromIndex) {
        IMPL.setFromIndex(mRecord, fromIndex);
    }

    /**
     * Gets the index of text selection end or the index of the last
     * visible item when scrolling.
     *
     * @return The index of selection end or last item index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.115 -0500", hash_original_method = "B98FE77EA903D04BD246D29EFA547DB8", hash_generated_method = "E8B72E1569E8C9C41012C5C2E8CBE654")
    
public int getToIndex() {
        return IMPL.getToIndex(mRecord);
    }

    /**
     * Sets the index of text selection end or the index of the last
     * visible item when scrolling.
     *
     * @param toIndex The index of selection end or last item index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.124 -0500", hash_original_method = "414EFB55B509BEB1998DEF9660ADB5DF", hash_generated_method = "BF8311346E90404B78F318471D7817A3")
    
public void setToIndex(int toIndex) {
        IMPL.setToIndex(mRecord, toIndex);
    }

    /**
     * Gets the scroll offset of the source left edge in pixels.
     *
     * @return The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.129 -0500", hash_original_method = "2D992416899C0D6D302552E083379ADA", hash_generated_method = "5F87F66AE3629FC5F3FFC6992F4A44AC")
    
public int getScrollX() {
        return IMPL.getScrollX(mRecord);
    }

    /**
     * Sets the scroll offset of the source left edge in pixels.
     *
     * @param scrollX The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.133 -0500", hash_original_method = "3CE80F2924A14D2238AE5FB516124BCB", hash_generated_method = "4C5D453458A47A9A9EE824EE35B494C3")
    
public void setScrollX(int scrollX) {
        IMPL.setScrollX(mRecord, scrollX);
    }

    /**
     * Gets the scroll offset of the source top edge in pixels.
     *
     * @return The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.138 -0500", hash_original_method = "4B111184EA88BFF1C758C71BC3F20771", hash_generated_method = "BA9CE1E71BBD0C673921BB6AE2086A04")
    
public int getScrollY() {
        return IMPL.getScrollY(mRecord);
    }

    /**
     * Sets the scroll offset of the source top edge in pixels.
     *
     * @param scrollY The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.143 -0500", hash_original_method = "701F7B58DDEAE878FA149CFF436CC09C", hash_generated_method = "21D9096F3D98C751569157262BEDC36C")
    
public void setScrollY(int scrollY) {
        IMPL.setScrollY(mRecord, scrollY);
    }

    /**
     * Gets the max scroll offset of the source left edge in pixels.
     *
     * @return The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.148 -0500", hash_original_method = "026EEDFFE581A1F32092C727C4BE4904", hash_generated_method = "25D3128B034A99EC6BBE384F617C206C")
    
public int getMaxScrollX() {
        return IMPL.getMaxScrollX(mRecord);
    }
    /**
     * Sets the max scroll offset of the source left edge in pixels.
     *
     * @param maxScrollX The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.156 -0500", hash_original_method = "7C3D025978A957DA302012C823643FFA", hash_generated_method = "96CBE775B878CFE561BBED4222319704")
    
public void setMaxScrollX(int maxScrollX) {
        IMPL.setMaxScrollX(mRecord, maxScrollX);
    }

    /**
     * Gets the max scroll offset of the source top edge in pixels.
     *
     * @return The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.163 -0500", hash_original_method = "53D3A6102CD53DB5C0BF2E7FB939B80F", hash_generated_method = "CFA5408A4BBC0708C4FC731FB6786874")
    
public int getMaxScrollY() {
        return IMPL.getMaxScrollY(mRecord);
    }

    /**
     * Sets the max scroll offset of the source top edge in pixels.
     *
     * @param maxScrollY The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.172 -0500", hash_original_method = "AE0FD849F58F60734C931CC634460D70", hash_generated_method = "630381C79B5B8C9DFD70CED16AF80EC2")
    
public void setMaxScrollY(int maxScrollY) {
        IMPL.setMaxScrollY(mRecord, maxScrollY);
    }

    /**
     * Gets the number of added characters.
     *
     * @return The number of added characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.179 -0500", hash_original_method = "AE14117EBCD35B74E7A6C851CE8210F8", hash_generated_method = "67D2FDB88DC473F8DDB3A8CA82F31E2E")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.185 -0500", hash_original_method = "575511048E9683D5570A7B1D589F2F9C", hash_generated_method = "52B34116335892C28907E139C3CE79A0")
    
public void setAddedCount(int addedCount) {
        IMPL.setAddedCount(mRecord, addedCount);
    }

    /**
     * Gets the number of removed characters.
     *
     * @return The number of removed characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.190 -0500", hash_original_method = "270EBCBE6CCF53B396B18FE08804E168", hash_generated_method = "B1EFC511FDAF286D6C552013390BD745")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.197 -0500", hash_original_method = "99F088C5A877A6D1CA743EAA6EB22155", hash_generated_method = "488A2900677E7786B47227CAC8080E1B")
    
public void setRemovedCount(int removedCount) {
        IMPL.setRemovedCount(mRecord, removedCount);
    }

    /**
     * Gets the class name of the source.
     *
     * @return The class name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.202 -0500", hash_original_method = "67AA0D33040F2AF335EF030F65429A0D", hash_generated_method = "9B7C3748E4F61B02E9A39D23342238B4")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.221 -0500", hash_original_method = "2A00F8117EF5BF1532A324D95A4DA5A5", hash_generated_method = "4B61217C762EA5383AB992AA9975F610")
    
public void setClassName(CharSequence className) {
        IMPL.setClassName(mRecord, className);
    }

    /**
     * Gets the text of the event. The index in the list represents the priority
     * of the text. Specifically, the lower the index the higher the priority.
     *
     * @return The text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.229 -0500", hash_original_method = "6C334D32F26DB2948FA7A060F2770263", hash_generated_method = "4B2BBF567AC92BB671999A7DEA33D260")
    
public List<CharSequence> getText() {
        return IMPL.getText(mRecord);
    }

    /**
     * Sets the text before a change.
     *
     * @return The text before the change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.237 -0500", hash_original_method = "4C454BCB63118A3CFA6774F8547F2900", hash_generated_method = "F129A173B8CD3A687758BE066B18FEAF")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.247 -0500", hash_original_method = "17C47A47264827FA91F78B1F5C19C158", hash_generated_method = "81E7272751B18F3222C669105CD9932A")
    
public void setBeforeText(CharSequence beforeText) {
        IMPL.setBeforeText(mRecord, beforeText);
    }

    /**
     * Gets the description of the source.
     *
     * @return The description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.255 -0500", hash_original_method = "0E1DDDE186BEA175AC4E63AF1F7EF300", hash_generated_method = "6EF945A4AAA82CFEB63EE038C4B93B35")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.263 -0500", hash_original_method = "24B5932BDE3800F2FCAC61218978EDA1", hash_generated_method = "31054DF5B79A95CC6887B4D0FDCDF4B8")
    
public void setContentDescription(CharSequence contentDescription) {
        IMPL.setContentDescription(mRecord, contentDescription);
    }

    /**
     * Gets the {@link Parcelable} data.
     *
     * @return The parcelable data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.270 -0500", hash_original_method = "6CF5581B59D6C7B0E77B7A5EDAAA13F8", hash_generated_method = "24DF5B1E8C2B9979765823E28D41E91B")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.277 -0500", hash_original_method = "991957DCCCA90403EB058761C8C6E328", hash_generated_method = "1CAD8EBED539B89887BA354E45C47A8D")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.286 -0500", hash_original_method = "CC34369D324679ED344B1A114F44B50C", hash_generated_method = "A2E5D4E4CFCEDE6ACFD8D09E72AE0EA0")
    
public void recycle() {
        IMPL.recycle(mRecord);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.293 -0500", hash_original_method = "25EC1341BA7AB69E33A1507EBB2B1096", hash_generated_method = "A1C5551C739B3736B4A6A18BA02FCE0E")
    
@Override
    public int hashCode() {
        return (mRecord == null) ? 0 : mRecord.hashCode();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 11:34:22.303 -0500", hash_original_method = "23C3AD1F1A4F2DE3EE1527927DE9E6EE", hash_generated_method = "0EB6254746C0D84971139AFEEA52BAE8")
    
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
