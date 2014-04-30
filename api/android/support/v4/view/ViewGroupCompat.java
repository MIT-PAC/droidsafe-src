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

    interface ViewGroupCompatImpl {
        public boolean onRequestSendAccessibilityEvent(ViewGroup group, View child,
                AccessibilityEvent event);
    }

    static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:28.488 -0500", hash_original_method = "63663A61AE72F4EA1BE6069DE9E21D17", hash_generated_method = "84ECA309248A95C3D32158837B86E714")
        
public boolean onRequestSendAccessibilityEvent(
                ViewGroup group, View child, AccessibilityEvent event) {
            return true;
        }
    }

    static class ViewGroupCompatIcsImpl extends ViewGroupCompatStubImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:28.490 -0500", hash_original_method = "4FD501F6AEC18CEA66F6672447D649B5", hash_generated_method = "DC8FBEAA768F826D905ADE2B0D726760")
        
@Override
        public boolean onRequestSendAccessibilityEvent(
                ViewGroup group, View child, AccessibilityEvent event) {
            return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(group, child, event);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:28.492 -0500", hash_original_field = "B1B66CC23CA7DFB890A608C54A7234A0", hash_generated_field = "E257834CBFA3D612BE0D9147AAF7AA2F")

    static  ViewGroupCompatImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ViewGroupCompatIcsImpl();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:28.494 -0500", hash_original_method = "1978CC92E32CD8348C5DF7FC73DFB333", hash_generated_method = "F38CF5C9CC229C8624781E234CDEA610")
    
public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child,
            AccessibilityEvent event) {
        return IMPL.onRequestSendAccessibilityEvent(group, child, event);
    }

    /*
     * Hide the constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:28.493 -0500", hash_original_method = "C9E473FFFB3F968718996597E8C1665E", hash_generated_method = "4204166126FD256F38E2FC1681739B07")
    
private ViewGroupCompat() {

    }
}
