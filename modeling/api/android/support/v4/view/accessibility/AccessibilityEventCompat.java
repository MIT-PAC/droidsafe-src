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
import android.view.accessibility.AccessibilityEvent;

/**
 * Helper for accessing features in {@link AccessibilityEvent}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class AccessibilityEventCompat {

    static interface AccessibilityEventVersionImpl {
        public int getRecordCount(AccessibilityEvent event);
        public void appendRecord(AccessibilityEvent event, Object record);
        public Object getRecord(AccessibilityEvent event, int index);
    }

    static class AccessibilityEventStubImpl implements AccessibilityEventVersionImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void appendRecord(AccessibilityEvent event, Object record) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object getRecord(AccessibilityEvent event, int index) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getRecordCount(AccessibilityEvent event) {
            return 0;
        }
    }

    static class AccessibilityEventIcsImpl extends AccessibilityEventStubImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void appendRecord(AccessibilityEvent event, Object record) {
            AccessibilityEventCompatIcs.appendRecord(event, record);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object getRecord(AccessibilityEvent event, int index) {
            return AccessibilityEventCompatIcs.getRecord(event, index);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getRecordCount(AccessibilityEvent event) {
            return AccessibilityEventCompatIcs.getRecordCount(event);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.779 -0400", hash_original_field = "7B8855635B22B57E8F1D8B59D0220DA9", hash_generated_field = "4324F97AEF46831155DDBB54D409FF66")

    private  static AccessibilityEventVersionImpl IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 14) { // ICS
            IMPL = new AccessibilityEventIcsImpl();
        } else {
            IMPL = new AccessibilityEventStubImpl();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.783 -0400", hash_original_field = "31FCC99F3B99C6497BF7D1A2B75DA224", hash_generated_field = "FE950ACD1EB76F522B84E4AF57C8EB4E")

    public static final int TYPE_VIEW_HOVER_ENTER = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.787 -0400", hash_original_field = "CF3E5481B9FA8CE5B340F2D0CC6D61CA", hash_generated_field = "18FE8FEEC4DFCC299D1871533484029C")

    public static final int TYPE_VIEW_HOVER_EXIT = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.790 -0400", hash_original_field = "56B5D701F452B1B8A0D56F5A7C4B733D", hash_generated_field = "241CE14D36798EBC2A23586E200A67F4")

    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.793 -0400", hash_original_field = "C00F69FFB6F4A7790B31945CE3530040", hash_generated_field = "BA83447C09FF159FA67B3574E6C27B8C")

    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.796 -0400", hash_original_field = "C232F9CCDAC306AE1B74987DE402183E", hash_generated_field = "78AE73D6DF96970386315118ADB13502")

    public static final int TYPE_WINDOW_CONTENT_CHANGED = 0x00000800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.799 -0400", hash_original_field = "8A142E4662D2340E134C2E8E3D4F939A", hash_generated_field = "4CA347468789B2191C2D5030F3F1C887")

    public static final int TYPE_VIEW_SCROLLED = 0x00001000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.801 -0400", hash_original_field = "7F48D63C013E10014BB3BF5669F90B70", hash_generated_field = "FD261FCAF58AFDA7AA95FBDB48245FF4")

    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 0x00002000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.804 -0400", hash_original_field = "7654F5E41C84E8F3D54AF01FDC744A80", hash_generated_field = "C0EA68A2D37FD542C5D861087BFB7CE8")

    public static final int TYPE_ANNOUNCEMENT = 0x00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.807 -0400", hash_original_field = "76E0622E007B050FB867C70AFDDDE080", hash_generated_field = "70410615CF305FFFBE69D3A87E794625")

    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 0x00008000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.812 -0400", hash_original_field = "6D8844C732A431BF72444F06D4AC37DF", hash_generated_field = "BF57397E4E5C2EE32C2358B506B54B1C")

    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 0x00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.815 -0400", hash_original_field = "FD32C3BDFCA595543E5EFBA0F04A3FFE", hash_generated_field = "E64CE1CFA8A5E8A0F5354490DD9502EC")

    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 0x00020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.819 -0400", hash_original_field = "2873E45B7222F994ED05D77ED2D37C0D", hash_generated_field = "217E21322551E7FCE0FCA6B64A315101")

    public static final int TYPE_GESTURE_DETECTION_START = 0x00040000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.822 -0400", hash_original_field = "EBCC70DBE8DF29E0A2CF9DA3A23778D9", hash_generated_field = "6B4E2DAB210EC6B88F7CA1E4F0990088")

    public static final int TYPE_GESTURE_DETECTION_END = 0x00080000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.827 -0400", hash_original_field = "827DD0931BB15BCD6065519093178F60", hash_generated_field = "B8995E3C3AD32E2FCD524B07F928B050")

    public static final int TYPE_TOUCH_INTERACTION_START = 0x00100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.831 -0400", hash_original_field = "BD554C4FA16C4C505F5CFAB9931EE96E", hash_generated_field = "6EEC19352074E437B59D57C411EE9CFF")

    public static final int TYPE_TOUCH_INTERACTION_END = 0x00200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.835 -0400", hash_original_field = "0D3369ECD5A8889BF049FB6C016F57F9", hash_generated_field = "5BAD57F63E5D649A21D00BA11B6FBBFC")

    public static final int TYPES_ALL_MASK = 0xFFFFFFFF;

    /**
     * Gets the number of records contained in the event.
     *
     * @return The number of records.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.842 -0400", hash_original_method = "D05B4A07580E207DDCC5C46C2EA908E3", hash_generated_method = "BCA634CB1370E716586E10F478F4E71D")
        
public static int getRecordCount(AccessibilityEvent event) {
        return IMPL.getRecordCount(event);
    }

    /**
     * Appends an {@link android.view.accessibility.AccessibilityRecord} to the end of
     * event records.
     *
     * @param record The record to append.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.846 -0400", hash_original_method = "C5D7AE0EE722797FA1A24CDDBCC18F6C", hash_generated_method = "D7BBC991581A27A57ACAF0A00A5C81A0")
        
public static void appendRecord(AccessibilityEvent event, AccessibilityRecordCompat record) {
        IMPL.appendRecord(event, record.getImpl());
    }

    /**
     * Gets the record at a given index.
     *
     * @param index The index.
     * @return The record at the specified index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.849 -0400", hash_original_method = "1ECD3B6EB310983E35FF433D064412E2", hash_generated_method = "1FCF83A07C6C069FB90341276136FC0F")
        
public static AccessibilityRecordCompat getRecord(AccessibilityEvent event, int index) {
        return new AccessibilityRecordCompat(IMPL.getRecord(event, index));
    }

    /**
     * Creates an {@link AccessibilityRecordCompat} from an {@link AccessibilityEvent}
     * that can be used to manipulate the event properties defined in
     * {@link android.view.accessibility.AccessibilityRecord}.
     * <p>
     * <strong>Note:</strong> Do not call {@link AccessibilityRecordCompat#recycle()} on the
     * returned {@link AccessibilityRecordCompat}. Call {@link AccessibilityEvent#recycle()}
     * in case you want to recycle the event.
     * </p>
     *
     * @param event The from which to create a record.
     * @return An {@link AccessibilityRecordCompat}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.853 -0400", hash_original_method = "CA554E17FEF2C13A5B2F3A307678C1EA", hash_generated_method = "623EF300810C2F5EB474A798262EBFD6")
        
public static AccessibilityRecordCompat asRecord(AccessibilityEvent event) {
        return new AccessibilityRecordCompat(event);
    }

    /*
     * Hide constructor from clients.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.838 -0400", hash_original_method = "7235302697174B91ED05919A9677679C", hash_generated_method = "4AFDAD85305AB637CA1E101B4A51862E")
        
private AccessibilityEventCompat() {

    }
}
