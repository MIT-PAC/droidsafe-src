/*
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

package android.support.v4.view.accessibility;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.List;

import android.os.Bundle;
import android.view.View;

/**
 * Helper for accessing {@link android.view.accessibility.AccessibilityNodeProvider}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class AccessibilityNodeProviderCompat {

    interface AccessibilityNodeProviderImpl {
        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat compat);
    }

    static class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.756 -0500", hash_original_method = "CBBBD2C21CAF1A046E49597CB8D9B3E3", hash_generated_method = "1E91848D6231480003DD02A8A2E3D59B")
        
@Override
        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat compat) {
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.761 -0500", hash_original_field = "48629E1EF59C7AC3C27FEDA4F322ABF0", hash_generated_field = "CE1E18E5EA07069A732C13416453E5C0")


    private static  AccessibilityNodeProviderImpl IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.764 -0500", hash_original_field = "CE4A25A5FCA68A13DF0B738C2E4F0931", hash_generated_field = "97E0C8F5D54B0146976916141F3ABC8E")


    private  Object mProvider;

    static {
    	IMPL = new AccessibilityNodeProviderStubImpl();
    }

    /**
     * Creates a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.769 -0500", hash_original_method = "91BF216ED8536154020FF4A2846E1987", hash_generated_method = "AA9708B2E188F2186761F4411A283FC5")
    
public AccessibilityNodeProviderCompat() {
        mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }

    /**
     * Creates a new instance wrapping an
     * {@link android.view.accessibility.AccessibilityNodeProvider}.
     *
     * @param provider The provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.772 -0500", hash_original_method = "F12C0D637A0C2267486A3DB09B5FD1DD", hash_generated_method = "D28D317FCBAD330B88B7F6A42C312AA9")
    
public AccessibilityNodeProviderCompat(Object provider) {
        mProvider = provider;
    }

    /**
     * @return The wrapped {@link android.view.accessibility.AccessibilityNodeProvider}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.774 -0500", hash_original_method = "1A780E2925A8445EDC44EDD31624C667", hash_generated_method = "19AF098890749E7BDD93C8A964CD775E")
    
public Object getProvider() {
        return mProvider;
    }

    /**
     * Returns an {@link AccessibilityNodeInfoCompat} representing a virtual view,
     * i.e. a descendant of the host View, with the given <code>virtualViewId</code>
     * or the host View itself if <code>virtualViewId</code> equals to {@link View#NO_ID}.
     * <p>
     * A virtual descendant is an imaginary View that is reported as a part of the view
     * hierarchy for accessibility purposes. This enables custom views that draw complex
     * content to report them selves as a tree of virtual views, thus conveying their
     * logical structure.
     * </p>
     * <p>
     * The implementer is responsible for obtaining an accessibility node info from the
     * pool of reusable instances and setting the desired properties of the node info
     * before returning it.
     * </p>
     *
     * @param virtualViewId A client defined virtual view id.
     * @return A populated {@link AccessibilityNodeInfoCompat} for a virtual descendant
     *     or the host View.
     *
     * @see AccessibilityNodeInfoCompat
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.776 -0500", hash_original_method = "DB5C1904AB5A686019BFA23425D0697D", hash_generated_method = "693BE92A77E07C3BB3E8D7299DD58291")
    
public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
        return null;
    }

    /**
     * Performs an accessibility action on a virtual view, i.e. a descendant of the
     * host View, with the given <code>virtualViewId</code> or the host View itself
     * if <code>virtualViewId</code> equals to {@link View#NO_ID}.
     *
     * @param virtualViewId A client defined virtual view id.
     * @param action The action to perform.
     * @param arguments Optional arguments.
     * @return True if the action was performed.
     *
     * @see #createAccessibilityNodeInfo(int)
     * @see AccessibilityNodeInfoCompat
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.780 -0500", hash_original_method = "7E74F335A2D5DD213B9A800F16F5C8B8", hash_generated_method = "923DF7BCA2BC291182E703183FAAB2BD")
    
public boolean performAction(int virtualViewId, int action, Bundle arguments) {
        return false;
    }

    /**
     * Finds {@link AccessibilityNodeInfoCompat}s by text. The match is case insensitive
     * containment. The search is relative to the virtual view, i.e. a descendant of the
     * host View, with the given <code>virtualViewId</code> or the host View itself
     * <code>virtualViewId</code> equals to {@link View#NO_ID}.
     *
     * @param virtualViewId A client defined virtual view id which defined
     *     the root of the tree in which to perform the search.
     * @param text The searched text.
     * @return A list of node info.
     *
     * @see #createAccessibilityNodeInfo(int)
     * @see AccessibilityNodeInfoCompat
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.782 -0500", hash_original_method = "CEBBD190AE53E7A0E938AB0B13044DF6", hash_generated_method = "352A8A56066C5A16BCB2AF4DD3D9A95F")
    
public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text,
            int virtualViewId) {
        return null;
    }
}
