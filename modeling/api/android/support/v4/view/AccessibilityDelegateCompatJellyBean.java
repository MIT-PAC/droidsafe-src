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
 * Copyright (C) 2012 The Android Open Source Project
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
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/**
 * JellyBean specific AccessibilityDelegate API implementation.
 */
class AccessibilityDelegateCompatJellyBean {

    public interface AccessibilityDelegateBridgeJellyBean {
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event);
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event);
        public void onInitializeAccessibilityNodeInfo(View host, Object info);
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event);
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
            AccessibilityEvent event);
        public void sendAccessibilityEvent(View host, int eventType);
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event);
        public Object getAccessibilityNodeProvider(View host);
        public boolean performAccessibilityAction(View host, int action, Bundle args);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.627 -0400", hash_original_method = "7E58444EB0B3B83173AB9B039DCD6C05", hash_generated_method = "284FA2ACE51242B2A38C08A3EE810C1D")
        
public static Object newAccessibilityDelegateBridge(
            final AccessibilityDelegateBridgeJellyBean bridge) {
        return new AccessibilityDelegate() {

            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                return bridge.dispatchPopulateAccessibilityEvent(host, event);
            }

            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                bridge.onInitializeAccessibilityEvent(host, event);
            }

            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                bridge.onInitializeAccessibilityNodeInfo(host, info);
            }

            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                bridge.onPopulateAccessibilityEvent(host, event);
            }

            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                    AccessibilityEvent event) {
                return bridge.onRequestSendAccessibilityEvent(host, child, event);
            }

            @DSSpec(DSCat.IO_ACTION_METHOD)
        @Override
            public void sendAccessibilityEvent(View host, int eventType) {
                bridge.sendAccessibilityEvent(host, eventType);
            }

            @DSSpec(DSCat.IO_ACTION_METHOD)
        @Override
            public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                bridge.sendAccessibilityEventUnchecked(host, event);
            }

            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
                return (AccessibilityNodeProvider) bridge.getAccessibilityNodeProvider(host);
            }

            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public boolean performAccessibilityAction(View host, int action, Bundle args) {
                return bridge.performAccessibilityAction(host, action, args);
            }
        };
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.632 -0400", hash_original_method = "2DA3C5628107A4D95EC42F8370E703ED", hash_generated_method = "FE5C09C02C8E2CC4AB17B858E96EAA15")
        
public static Object getAccessibilityNodeProvider(Object delegate,
            View host) {
        return ((AccessibilityDelegate) delegate).getAccessibilityNodeProvider(host);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.637 -0400", hash_original_method = "4C6EDD3B252E4B69548D3413F51E993F", hash_generated_method = "C5BA9072A4704CB57A4958BB5729FA40")
        
public static boolean performAccessibilityAction(Object delegate, View host, int action,
            Bundle args) {
        return ((AccessibilityDelegate) delegate).performAccessibilityAction(host, action, args);
    }
}
