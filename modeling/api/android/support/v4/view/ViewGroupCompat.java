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


package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/**
 * Helper for accessing features in {@link ViewGroup}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class ViewGroupCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.186 -0400", hash_original_field = "026952D358F010FF3FE12B8CEFBDF571", hash_generated_field = "F6F47B97D3553EE6604958527590C013")

    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.190 -0400", hash_original_field = "75AAB763422DD0FBF8947B023BEAD7A0", hash_generated_field = "BA3C9DCE557976C60024CDD5E2604EE6")

    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    interface ViewGroupCompatImpl {
        public boolean onRequestSendAccessibilityEvent(ViewGroup group, View child,
                AccessibilityEvent event);

        public void setMotionEventSplittingEnabled(ViewGroup group, boolean split);
        public int getLayoutMode(ViewGroup group);
        public void setLayoutMode(ViewGroup group, int mode);
    }

    static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        public boolean onRequestSendAccessibilityEvent(
                ViewGroup group, View child, AccessibilityEvent event) {
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
            // no-op, didn't exist.
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getLayoutMode(ViewGroup group) {
            return LAYOUT_MODE_CLIP_BOUNDS;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setLayoutMode(ViewGroup group, int mode) {
            // no-op, didn't exist. Views only support clip bounds.
        }
    }

    static class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
            ViewGroupCompatHC.setMotionEventSplittingEnabled(group, split);
        }
    }

    static class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onRequestSendAccessibilityEvent(
                ViewGroup group, View child, AccessibilityEvent event) {
            return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(group, child, event);
        }
    }

    static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getLayoutMode(ViewGroup group) {
            return ViewGroupCompatJellybeanMR2.getLayoutMode(group);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setLayoutMode(ViewGroup group, int mode) {
            ViewGroupCompatJellybeanMR2.setLayoutMode(group, mode);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.243 -0400", hash_original_field = "B1B66CC23CA7DFB890A608C54A7234A0", hash_generated_field = "E257834CBFA3D612BE0D9147AAF7AA2F")

    static  ViewGroupCompatImpl IMPL;
    static {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 18) {
            IMPL = new ViewGroupCompatJellybeanMR2Impl();
        } else if (version >= 14) {
            IMPL = new ViewGroupCompatIcsImpl();
        } else if (version >= 11) {
            IMPL = new ViewGroupCompatHCImpl();
        } else {
            IMPL = new ViewGroupCompatStubImpl();
        }
    }

    /**
     * Called when a child has requested sending an {@link AccessibilityEvent} and
     * gives an opportunity to its parent to augment the event.
     * <p>
     * If an {@link AccessibilityDelegateCompat} has been specified via calling
     * {@link ViewCompat#setAccessibilityDelegate(View, AccessibilityDelegateCompat)} its
     * {@link AccessibilityDelegateCompat#onRequestSendAccessibilityEvent(ViewGroup, View,
     * AccessibilityEvent)} is responsible for handling this call.
     * </p>
     *
     * @param group The group whose method to invoke.
     * @param child The child which requests sending the event.
     * @param event The event to be sent.
     * @return True if the event should be sent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.253 -0400", hash_original_method = "1978CC92E32CD8348C5DF7FC73DFB333", hash_generated_method = "F38CF5C9CC229C8624781E234CDEA610")
        
public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child,
            AccessibilityEvent event) {
        return IMPL.onRequestSendAccessibilityEvent(group, child, event);
    }

    /**
     * Enable or disable the splitting of MotionEvents to multiple children during touch event
     * dispatch. This behavior is enabled by default for applications that target an
     * SDK version of 11 (Honeycomb) or newer. On earlier platform versions this feature
     * was not supported and this method is a no-op.
     *
     * <p>When this option is enabled MotionEvents may be split and dispatched to different child
     * views depending on where each pointer initially went down. This allows for user interactions
     * such as scrolling two panes of content independently, chording of buttons, and performing
     * independent gestures on different pieces of content.
     *
     * @param group ViewGroup to modify
     * @param split <code>true</code> to allow MotionEvents to be split and dispatched to multiple
     *              child views. <code>false</code> to only allow one child view to be the target of
     *              any MotionEvent received by this ViewGroup.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.257 -0400", hash_original_method = "0805EF6A3EE41BF4322D94C8366C27F3", hash_generated_method = "F8B3E58662F54595DB87E5E8F42E8A2F")
        
public static void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        IMPL.setMotionEventSplittingEnabled(group, split);
    }

    /**
     * Returns the basis of alignment during layout operations on this ViewGroup:
     * either {@link #LAYOUT_MODE_CLIP_BOUNDS} or {@link #LAYOUT_MODE_OPTICAL_BOUNDS}.
     * <p>
     * If no layoutMode was explicitly set, either programmatically or in an XML resource,
     * the method returns the layoutMode of the view's parent ViewGroup if such a parent exists,
     * otherwise the method returns a default value of {@link #LAYOUT_MODE_CLIP_BOUNDS}.
     *
     * @return the layout mode to use during layout operations
     *
     * @see #setLayoutMode(ViewGroup, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.261 -0400", hash_original_method = "6502A1D0C2960DEA9D1111BB6F2B8B1A", hash_generated_method = "6BED9CFC735159626EF83D92DBA4CBB1")
        
public static int getLayoutMode(ViewGroup group) {
        return IMPL.getLayoutMode(group);
    }

    /**
     * Sets the basis of alignment during the layout of this ViewGroup.
     * Valid values are either {@link #LAYOUT_MODE_CLIP_BOUNDS} or
     * {@link #LAYOUT_MODE_OPTICAL_BOUNDS}.
     *
     * @param mode the layout mode to use during layout operations
     *
     * @see #getLayoutMode(ViewGroup)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.265 -0400", hash_original_method = "CFA2D375D615B8A6666CDB724BFD3493", hash_generated_method = "79D1CAAC7605B813C53D18DC91E2F48F")
        
public static void setLayoutMode(ViewGroup group, int mode) {
        IMPL.setLayoutMode(group, mode);
    }

    /*
     * Hide the constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.249 -0400", hash_original_method = "C9E473FFFB3F968718996597E8C1665E", hash_generated_method = "4204166126FD256F38E2FC1681739B07")
        
private ViewGroupCompat() {

    }
}
