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


package android.view.accessibility;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is the contract a client should implement to enable support of a
 * virtual view hierarchy rooted at a given view for accessibility purposes. A virtual
 * view hierarchy is a tree of imaginary Views that is reported as a part of the view
 * hierarchy when an {@link AccessibilityService} explores the window content.
 * Since the virtual View tree does not exist this class is responsible for
 * managing the {@link AccessibilityNodeInfo}s describing that tree to accessibility
 * services.
 * </p>
 * <p>
 * The main use case of these APIs is to enable a custom view that draws complex content,
 * for example a monthly calendar grid, to be presented as a tree of logical nodes,
 * for example month days each containing events, thus conveying its logical structure.
 * <p>
 * <p>
 * A typical use case is to override {@link View#getAccessibilityNodeProvider()} of the
 * View that is a root of a virtual View hierarchy to return an instance of this class.
 * In such a case this instance is responsible for managing {@link AccessibilityNodeInfo}s
 * describing the virtual sub-tree rooted at the View including the one representing the
 * View itself. Similarly the returned instance is responsible for performing accessibility
 * actions on any virtual view or the root view itself. For example:
 * </p>
 * <pre>
 *     getAccessibilityNodeProvider(
 *         if (mAccessibilityNodeProvider == null) {
 *             mAccessibilityNodeProvider = new AccessibilityNodeProvider() {
 *                 public boolean performAction(int action, int virtualDescendantId) {
 *                     // Implementation.
 *                     return false;
 *                 }
 *
 *                 public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text,
 *                         int virtualDescendantId) {
 *                     // Implementation.
 *                     return null;
 *                 }
 *
 *                 public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualDescendantId) {
 *                     // Implementation.
 *                     return null;
 *                 }
 *             });
 *     return mAccessibilityNodeProvider;
 * </pre>
 */
public abstract class AccessibilityNodeProvider {

    /** Synthetic Constructor */
    @DSSafe(DSCat.SAFE_OTHERS)
    public AccessibilityNodeProvider() {
        
    }
    
    /**
     * Returns an {@link AccessibilityNodeInfo} representing a virtual view,
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
     * @return A populated {@link AccessibilityNodeInfo} for a virtual descendant or the
     *     host View.
     *
     * @see View#createAccessibilityNodeInfo()
     * @see AccessibilityNodeInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-27 14:26:54.358 -0500", hash_original_method = "2D22D7D27171E4BBD3FBB0816658181C", hash_generated_method = "8207C0B9C8EA8A9F91147C603FEEDB42")
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
        AccessibilityNodeInfo  node = new AccessibilityNodeInfo(DSOnlyType.DONTCARE);
        node.addTaint(virtualViewId);
        node.addTaint(getTaint());
        return node;
    }

    /**
     * Performs an accessibility action on a virtual view, i.e. a descendant of the
     * host View, with the given <code>virtualViewId</code> or the host View itself
     * if <code>virtualViewId</code> equals to {@link View#NO_ID}.
     *
     * @param virtualViewId A client defined virtual view id.
     * @param action The action to perform.
     * @param arguments Optional action arguments.
     * @return True if the action was performed.
     *
     * @see View#performAccessibilityAction(int, Bundle)
     * @see #createAccessibilityNodeInfo(int)
     * @see AccessibilityNodeInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-27 14:26:54.363 -0500", hash_original_method = "7E74F335A2D5DD213B9A800F16F5C8B8", hash_generated_method = "923DF7BCA2BC291182E703183FAAB2BD")
    
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean performAction(int virtualViewId, int action, Bundle arguments) {
        return false;
    }

    /**
     * Finds {@link AccessibilityNodeInfo}s by text. The match is case insensitive
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
     * @see AccessibilityNodeInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-27 14:26:54.366 -0500", hash_original_method = "16A32CD569D5A9B35C8E9A129A1ED251", hash_generated_method = "E66EB97DE56E2EB2D4557560CF1D4901")
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSSafe(DSCat.SAFE_OTHERS)
public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text,
            int virtualViewId) {
        AccessibilityNodeInfo  node = new AccessibilityNodeInfo(DSOnlyType.DONTCARE);
        node.addTaint(virtualViewId);
        node.addTaint(getTaint());
        List<AccessibilityNodeInfo> list = new LinkedList<AccessibilityNodeInfo>();
        list.add(node);
        return list;
    }

    /**
     * Finds the accessibility focused {@link AccessibilityNodeInfo}. The search is
     * relative to the virtual view, i.e. a descendant of the host View, with the
     * given <code>virtualViewId</code> or the host View itself
     * <code>virtualViewId</code> equals to {@link View#NO_ID}.
     *
     * <strong>Note:</strong> Normally the system is responsible to transparently find
     *     accessibility focused view starting from a given root but for virtual view
     *     hierarchies it is a responsibility of this provider's implementor to find
     *     the accessibility focused virtual view.
     *
     * @param virtualViewId A client defined virtual view id which defined
     *     the root of the tree in which to perform the search.
     * @return A list of node info.
     *
     * @see #createAccessibilityNodeInfo(int)
     * @see AccessibilityNodeInfo
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-27 14:26:54.369 -0500", hash_original_method = "8D5F5CB0DD81FDFD26C50EECCCDCFCE9", hash_generated_method = "53D90B84868CA28D4FA14FEF2BB4981F")
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
public AccessibilityNodeInfo findAccessibilityFocus(int virtualViewId) {
        AccessibilityNodeInfo  node = new AccessibilityNodeInfo(DSOnlyType.DONTCARE);
        node.addTaint(virtualViewId);
        node.addTaint(getTaint());
        return node;
    }

    /**
     * Finds {@link AccessibilityNodeInfo} to take accessibility focus in the given
     * <code>direction</code>. The search is relative to the virtual view, i.e. a
     * descendant of the host View, with the given <code>virtualViewId</code> or
     * the host View itself <code>virtualViewId</code> equals to {@link View#NO_ID}.
     *
     * <strong>Note:</strong> Normally the system is responsible to transparently find
     *     the next view to take accessibility focus but for virtual view hierarchies
     *     it is a responsibility of this provider's implementor to compute the next
     *     focusable.
     *
     * @param direction The direction in which to search for a focus candidate.
     *     Values are
     *     {@link View#ACCESSIBILITY_FOCUS_FORWARD},
     *     {@link View#ACCESSIBILITY_FOCUS_BACKWARD},
     *     {@link View#ACCESSIBILITY_FOCUS_UP},
     *     {@link View#ACCESSIBILITY_FOCUS_DOWN},
     *     {@link View#ACCESSIBILITY_FOCUS_LEFT},
     *     {@link View#ACCESSIBILITY_FOCUS_RIGHT}.
     * @param virtualViewId A client defined virtual view id which defined
     *     the root of the tree in which to perform the search.
     * @return A list of node info.
     *
     * @see #createAccessibilityNodeInfo(int)
     * @see AccessibilityNodeInfo
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-27 14:26:54.372 -0500", hash_original_method = "9EDAA1AB33E095A491DB90E17C8C458E", hash_generated_method = "F1979A21E992F4B750B5BA23FDCC06B7")
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
public AccessibilityNodeInfo accessibilityFocusSearch(int direction, int virtualViewId) {
        AccessibilityNodeInfo  node = new AccessibilityNodeInfo(DSOnlyType.DONTCARE);
        node.addTaint(virtualViewId);
        node.addTaint(direction);
        node.addTaint(getTaint());
        return node;
    }
}
