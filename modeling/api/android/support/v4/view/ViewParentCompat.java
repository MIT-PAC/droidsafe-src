/*
 * Copyright (C) 2013 The Android Open Source Project
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
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/**
 * Helper for accessing features in {@link ViewParent}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class ViewParentCompat {

    interface ViewParentCompatImpl {
        public boolean requestSendAccessibilityEvent(
                ViewParent parent, View child, AccessibilityEvent event);
    }

    static class ViewParentCompatStubImpl implements ViewParentCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean requestSendAccessibilityEvent(
                ViewParent parent, View child, AccessibilityEvent event) {
            // Emulate what ViewRootImpl does in ICS and above.
            if (child == null) {
                return false;
            }
            final AccessibilityManager manager = (AccessibilityManager) child.getContext()
                    .getSystemService(Context.ACCESSIBILITY_SERVICE);
            manager.sendAccessibilityEvent(event);
            return true;
        }
    }

    static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean requestSendAccessibilityEvent(
                ViewParent parent, View child, AccessibilityEvent event) {
            return ViewParentCompatICS.requestSendAccessibilityEvent(parent, child, event);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:06.601 -0400", hash_original_field = "977F0D711577C27228F7492B6718B336", hash_generated_field = "2518E0F083689C72F6BB8E1A5B8911B3")

    static  ViewParentCompatImpl IMPL;
    static {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 14) {
            IMPL = new ViewParentCompatICSImpl();
        } else {
            IMPL = new ViewParentCompatStubImpl();
        }
    }

    /**
     * Called by a child to request from its parent to send an {@link AccessibilityEvent}.
     * The child has already populated a record for itself in the event and is delegating
     * to its parent to send the event. The parent can optionally add a record for itself.
     * <p>
     * Note: An accessibility event is fired by an individual view which populates the
     *       event with a record for its state and requests from its parent to perform
     *       the sending. The parent can optionally add a record for itself before
     *       dispatching the request to its parent. A parent can also choose not to
     *       respect the request for sending the event. The accessibility event is sent
     *       by the topmost view in the view tree.</p>
     *
     * @param parent The parent whose method to invoke.
     * @param child The child which requests sending the event.
     * @param event The event to be sent.
     * @return True if the event was sent.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:06.608 -0400", hash_original_method = "239BB39E98A074D2A5CAC5B24787D859", hash_generated_method = "AD0B1010FD72F56243CED893916A7910")
        
public static boolean requestSendAccessibilityEvent(
            ViewParent parent, View child, AccessibilityEvent event) {
        return IMPL.requestSendAccessibilityEvent(parent, child, event);
    }

    /*
     * Hide the constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:06.604 -0400", hash_original_method = "35B33668A583A8EC56B0E754D7AF3D26", hash_generated_method = "8093664392F34EA9575F640DD17081EB")
        
private ViewParentCompat() {

    }
}
