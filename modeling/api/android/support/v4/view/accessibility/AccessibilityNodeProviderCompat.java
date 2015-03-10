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


package android.support.v4.view.accessibility;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper for accessing {@link android.view.accessibility.AccessibilityNodeProvider}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class AccessibilityNodeProviderCompat {

    interface AccessibilityNodeProviderImpl {
        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat compat);
    }

    static class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat compat) {
            return null;
        }
    }

    static class AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderStubImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object newAccessibilityNodeProviderBridge(
                final AccessibilityNodeProviderCompat compat) {
            return AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(
                    new AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge() {
                        @DSSafe(DSCat.SAFE_LIST)
            @Override
                        public boolean performAction(int virtualViewId, int action,
                                Bundle arguments) {
                            return compat.performAction(virtualViewId, action, arguments);
                        }

                        @DSSafe(DSCat.SAFE_LIST)
            @Override
                        public List<Object> findAccessibilityNodeInfosByText(
                                            String text, int virtualViewId) {
                            List<AccessibilityNodeInfoCompat> compatInfos =
                                compat.findAccessibilityNodeInfosByText(text, virtualViewId);
                            List<Object> infos = new ArrayList<Object>();
                            final int infoCount = compatInfos.size();
                            for (int i = 0; i < infoCount; i++) {
                                AccessibilityNodeInfoCompat infoCompat = compatInfos.get(i);
                                infos.add(infoCompat.getInfo());
                            }
                            return infos;
                        }

                        @DSSafe(DSCat.SAFE_LIST)
            @Override
                        public Object createAccessibilityNodeInfo(
                                int virtualViewId) {
                            final AccessibilityNodeInfoCompat compatInfo = compat
                                    .createAccessibilityNodeInfo(virtualViewId);
                            if (compatInfo == null) {
                                return null;
                            } else {
                                return compatInfo.getInfo();
                            }
                        }
                    });
        }
    }

    static class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderStubImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object newAccessibilityNodeProviderBridge(
                final AccessibilityNodeProviderCompat compat) {
            return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(
                    new AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge() {
                        @DSSafe(DSCat.SAFE_LIST)
            @Override
                        public boolean performAction(
                                int virtualViewId, int action, Bundle arguments) {
                            return compat.performAction(virtualViewId, action, arguments);
                        }

                        @DSSafe(DSCat.SAFE_LIST)
            @Override
                        public List<Object> findAccessibilityNodeInfosByText(
                                String text, int virtualViewId) {
                            List<AccessibilityNodeInfoCompat> compatInfos =
                                    compat.findAccessibilityNodeInfosByText(text, virtualViewId);
                            List<Object> infos = new ArrayList<Object>();
                            final int infoCount = compatInfos.size();
                            for (int i = 0; i < infoCount; i++) {
                                AccessibilityNodeInfoCompat infoCompat = compatInfos.get(i);
                                infos.add(infoCompat.getInfo());
                            }
                            return infos;
                        }

                        @DSSafe(DSCat.SAFE_LIST)
            @Override
                        public Object createAccessibilityNodeInfo(int virtualViewId) {
                            final AccessibilityNodeInfoCompat compatInfo =
                                    compat.createAccessibilityNodeInfo(virtualViewId);
                            if (compatInfo == null) {
                                return null;
                            } else {
                                return compatInfo.getInfo();
                            }
                        }

                        @DSSafe(DSCat.SAFE_LIST)
            @Override
                        public Object findFocus(int focus) {
                            final AccessibilityNodeInfoCompat compatInfo = compat.findFocus(focus);
                            if (compatInfo == null) {
                                return null;
                            } else {
                                return compatInfo.getInfo();
                            }
                        }
                    });
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.618 -0400", hash_original_field = "48629E1EF59C7AC3C27FEDA4F322ABF0", hash_generated_field = "CE1E18E5EA07069A732C13416453E5C0")

    private static  AccessibilityNodeProviderImpl IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.620 -0400", hash_original_field = "CE4A25A5FCA68A13DF0B738C2E4F0931", hash_generated_field = "97E0C8F5D54B0146976916141F3ABC8E")

    private  Object mProvider;

    static {
        if (Build.VERSION.SDK_INT >= 19) { // KitKat
            IMPL = new AccessibilityNodeProviderKitKatImpl();
        } else if (Build.VERSION.SDK_INT >= 16) { // JellyBean
            IMPL = new AccessibilityNodeProviderJellyBeanImpl();
        } else {
            IMPL = new AccessibilityNodeProviderStubImpl();
        }
    }

    /**
     * Creates a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.624 -0400", hash_original_method = "91BF216ED8536154020FF4A2846E1987", hash_generated_method = "AA9708B2E188F2186761F4411A283FC5")
        
public AccessibilityNodeProviderCompat() {
        mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }

    /**
     * Creates a new instance wrapping an
     * {@link android.view.accessibility.AccessibilityNodeProvider}.
     *
     * @param provider The provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.627 -0400", hash_original_method = "F12C0D637A0C2267486A3DB09B5FD1DD", hash_generated_method = "D28D317FCBAD330B88B7F6A42C312AA9")
        
public AccessibilityNodeProviderCompat(Object provider) {
        mProvider = provider;
    }

    /**
     * @return The wrapped {@link android.view.accessibility.AccessibilityNodeProvider}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.629 -0400", hash_original_method = "1A780E2925A8445EDC44EDD31624C667", hash_generated_method = "19AF098890749E7BDD93C8A964CD775E")
        
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.632 -0400", hash_original_method = "DB5C1904AB5A686019BFA23425D0697D", hash_generated_method = "693BE92A77E07C3BB3E8D7299DD58291")
        
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.635 -0400", hash_original_method = "7E74F335A2D5DD213B9A800F16F5C8B8", hash_generated_method = "923DF7BCA2BC291182E703183FAAB2BD")
        
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.639 -0400", hash_original_method = "CEBBD190AE53E7A0E938AB0B13044DF6", hash_generated_method = "352A8A56066C5A16BCB2AF4DD3D9A95F")
        
public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text,
            int virtualViewId) {
        return null;
    }

    /**
     * Find the virtual view, i.e. a descendant of the host View, that has the
     * specified focus type.
     *
     * @param focus The focus to find. One of
     *            {@link AccessibilityNodeInfoCompat#FOCUS_INPUT} or
     *            {@link AccessibilityNodeInfoCompat#FOCUS_ACCESSIBILITY}.
     * @return The node info of the focused view or null.
     * @see AccessibilityNodeInfoCompat#FOCUS_INPUT
     * @see AccessibilityNodeInfoCompat#FOCUS_ACCESSIBILITY
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.642 -0400", hash_original_method = "F4E72E3F713928304060FBB2F64396EC", hash_generated_method = "714B6A4D92ECF188588E3752E8CE82E3")
        
public AccessibilityNodeInfoCompat findFocus(int focus) {
        return null;
    }
}
