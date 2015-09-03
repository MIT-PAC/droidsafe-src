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
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/**
 * Helper for accessing {@link View.AccessibilityDelegate} introduced after
 * API level 4 in a backwards compatible fashion.
 */
public class AccessibilityDelegateCompat {

    static interface AccessibilityDelegateImpl {
        public Object newAccessiblityDelegateDefaultImpl();
        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat listener);
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info);
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event);
        public void sendAccessibilityEvent(Object delegate, View host, int eventType);
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event);
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object delegate,
                View host);
        public boolean performAccessibilityAction(Object delegate, View host, int action,
                Bundle args);
    }

    static class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        @DSSafe(DSCat.SAFE_LIST)
        public Object newAccessiblityDelegateDefaultImpl() {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat listener) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event) {
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void sendAccessibilityEvent(Object delegate, View host, int eventType) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event) {

        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object delegate,
                View host) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean performAccessibilityAction(Object delegate, View host, int action,
                Bundle args) {
            return false;
        }
    }

    static class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object newAccessiblityDelegateDefaultImpl() {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat compat) {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(
                    new AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() {
                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public boolean dispatchPopulateAccessibilityEvent(View host,
                        AccessibilityEvent event) {
                    return compat.dispatchPopulateAccessibilityEvent(host, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                    compat.onInitializeAccessibilityEvent(host, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onInitializeAccessibilityNodeInfo(View host, Object info) {
                    compat.onInitializeAccessibilityNodeInfo(host,
                            new AccessibilityNodeInfoCompat(info));
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                    compat.onPopulateAccessibilityEvent(host, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                        AccessibilityEvent event) {
                    return compat.onRequestSendAccessibilityEvent(host, child, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void sendAccessibilityEvent(View host, int eventType) {
                    compat.sendAccessibilityEvent(host, eventType);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                    compat.sendAccessibilityEventUnchecked(host, event);
                }
            });
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(delegate,
                    host, event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(delegate, host, event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(delegate, host,
                    info.getInfo());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(delegate, host, event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event) {
            return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(delegate, host,
                    child, event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void sendAccessibilityEvent(Object delegate, View host, int eventType) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEvent(delegate, host, eventType);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(delegate, host, event);
        }
    }

    static class AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateIcsImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat compat) {
            return AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(
                    new AccessibilityDelegateCompatJellyBean
                            .AccessibilityDelegateBridgeJellyBean() {
                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public boolean dispatchPopulateAccessibilityEvent(View host,
                        AccessibilityEvent event) {
                    return compat.dispatchPopulateAccessibilityEvent(host, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                    compat.onInitializeAccessibilityEvent(host, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onInitializeAccessibilityNodeInfo(View host, Object info) {
                    compat.onInitializeAccessibilityNodeInfo(host,
                            new AccessibilityNodeInfoCompat(info));
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                    compat.onPopulateAccessibilityEvent(host, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                        AccessibilityEvent event) {
                    return compat.onRequestSendAccessibilityEvent(host, child, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void sendAccessibilityEvent(View host, int eventType) {
                    compat.sendAccessibilityEvent(host, eventType);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                    compat.sendAccessibilityEventUnchecked(host, event);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public Object getAccessibilityNodeProvider(View host) {
                    AccessibilityNodeProviderCompat provider =
                        compat.getAccessibilityNodeProvider(host);
                    return (provider != null) ? provider.getProvider() : null;
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public boolean performAccessibilityAction(View host, int action, Bundle args) {
                    return compat.performAccessibilityAction(host, action, args);
                }
            });
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object delegate,
                View host) {
            Object provider = AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(
                    delegate, host);
            if (provider != null) {
                return new AccessibilityNodeProviderCompat(provider);
            }
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean performAccessibilityAction(Object delegate, View host, int action,
                Bundle args) {
            return AccessibilityDelegateCompatJellyBean.performAccessibilityAction(delegate,
                    host, action, args);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:57.986 -0400", hash_original_field = "13943D57EDEED9A173F5F68E5210D679", hash_generated_field = "69637AEE9A0A7BCD1114720A430081E5")

    private static  AccessibilityDelegateImpl IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:57.992 -0400", hash_original_field = "40AEF38903E1CAF710B76F2110800697", hash_generated_field = "2FAA9D9F17162833D2EDFD9409B491F8")

    private static  Object DEFAULT_DELEGATE;

    static {
        if (Build.VERSION.SDK_INT >= 16) { // JellyBean
            IMPL = new AccessibilityDelegateJellyBeanImpl();
        } else if (Build.VERSION.SDK_INT >= 14) { // ICS
            IMPL = new AccessibilityDelegateIcsImpl();
        } else {
            IMPL = new AccessibilityDelegateStubImpl();
        }
        DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.002 -0400", hash_original_field = "FB4910AEBDA35C6A7EDDEEAAF16AFC5E", hash_generated_field = "FB4910AEBDA35C6A7EDDEEAAF16AFC5E")

     Object mBridge;

    /**
     * Creates a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.008 -0400", hash_original_method = "97DB5C1E35BD81C1D800183C23794857", hash_generated_method = "5F972D2D6251E8B0920DE31F0A14B3B7")
        
public AccessibilityDelegateCompat() {
        mBridge = IMPL.newAccessiblityDelegateBridge(this);
    }

    /**
     * @return The wrapped bridge implementation.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.013 -0400", hash_original_method = "29194344028099349300BA7E9C8229CD", hash_generated_method = "29194344028099349300BA7E9C8229CD")
        
Object getBridge() {
        return mBridge;
    }

    /**
     * Sends an accessibility event of the given type. If accessibility is not
     * enabled this method has no effect.
     * <p>
     * The default implementation behaves as {@link View#sendAccessibilityEvent(int)
     * View#sendAccessibilityEvent(int)} for the case of no accessibility delegate
     * been set.
     * </p>
     *
     * @param host The View hosting the delegate.
     * @param eventType The type of the event to send.
     *
     * @see View#sendAccessibilityEvent(int) View#sendAccessibilityEvent(int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.019 -0400", hash_original_method = "AF292CC2C422FC35BC5B564D13D2EFD0", hash_generated_method = "F4DE4730815B36F8B2C48D1F87C14F30")
        
public void sendAccessibilityEvent(View host, int eventType) {
        IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, host, eventType);
    }

    /**
     * Sends an accessibility event. This method behaves exactly as
     * {@link #sendAccessibilityEvent(View, int)} but takes as an argument an
     * empty {@link AccessibilityEvent} and does not perform a check whether
     * accessibility is enabled.
     * <p>
     * The default implementation behaves as
     * {@link View#sendAccessibilityEventUnchecked(AccessibilityEvent)
     * View#sendAccessibilityEventUnchecked(AccessibilityEvent)} for
     * the case of no accessibility delegate been set.
     * </p>
     *
     * @param host The View hosting the delegate.
     * @param event The event to send.
     *
     * @see View#sendAccessibilityEventUnchecked(AccessibilityEvent)
     *      View#sendAccessibilityEventUnchecked(AccessibilityEvent)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.025 -0400", hash_original_method = "B8A02114F1FBE7409787CB3469B3FB8D", hash_generated_method = "80CA7DA1CBEE9E99E743A4DFFB64F5AC")
        
public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, host, event);
    }

    /**
     * Dispatches an {@link AccessibilityEvent} to the host {@link View} first and then
     * to its children for adding their text content to the event.
     * <p>
     * The default implementation behaves as
     * {@link View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
     * View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)} for
     * the case of no accessibility delegate been set.
     * </p>
     *
     * @param host The View hosting the delegate.
     * @param event The event.
     * @return True if the event population was completed.
     *
     * @see View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
     *      View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.031 -0400", hash_original_method = "1C87274B198DB8C027DD7E3DED431EEE", hash_generated_method = "DC6576B317F1DAD9FA11B73B76E6AA25")
        
public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    /**
     * Gives a chance to the host View to populate the accessibility event with its
     * text content.
     * <p>
     * The default implementation behaves as
     * {@link ViewCompat#onPopulateAccessibilityEvent(View, AccessibilityEvent)
     * ViewCompat#onPopulateAccessibilityEvent(AccessibilityEvent)} for
     * the case of no accessibility delegate been set.
     * </p>
     *
     * @param host The View hosting the delegate.
     * @param event The accessibility event which to populate.
     *
     * @see ViewCompat#onPopulateAccessibilityEvent(View ,AccessibilityEvent)
     *      ViewCompat#onPopulateAccessibilityEvent(View, AccessibilityEvent)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.037 -0400", hash_original_method = "DE3AA9FE26B29E02F70EE9289C022DB2", hash_generated_method = "7B20261B2577FFD44A0969E1F105163A")
        
public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    /**
     * Initializes an {@link AccessibilityEvent} with information about the
     * the host View which is the event source.
     * <p>
     * The default implementation behaves as
     * {@link ViewCompat#onInitializeAccessibilityEvent(View v, AccessibilityEvent event)
     * ViewCompat#onInitalizeAccessibilityEvent(View v, AccessibilityEvent event)} for
     * the case of no accessibility delegate been set.
     * </p>
     *
     * @param host The View hosting the delegate.
     * @param event The event to initialize.
     *
     * @see ViewCompat#onInitializeAccessibilityEvent(View, AccessibilityEvent)
     *      ViewCompat#onInitializeAccessibilityEvent(View, AccessibilityEvent)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.042 -0400", hash_original_method = "6FCF19A166005C43B6A9E9FED7E7775A", hash_generated_method = "29477B5D539E075056775EB8413ED6E0")
        
public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    /**
     * Initializes an {@link AccessibilityNodeInfoCompat} with information about the host view.
     * <p>
     * The default implementation behaves as
     * {@link ViewCompat#onInitializeAccessibilityNodeInfo(View, AccessibilityNodeInfoCompat)
     * ViewCompat#onInitializeAccessibilityNodeInfo(View, AccessibilityNodeInfoCompat)} for
     * the case of no accessibility delegate been set.
     * </p>
     *
     * @param host The View hosting the delegate.
     * @param info The instance to initialize.
     *
     * @see ViewCompat#onInitializeAccessibilityNodeInfo(View, AccessibilityNodeInfoCompat)
     *      ViewCompat#onInitializeAccessibilityNodeInfo(View, AccessibilityNodeInfoCompat)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.049 -0400", hash_original_method = "702CF486436EF7CB7E261126510CB2C4", hash_generated_method = "8A751126F33F4AB41626A74C610FF20D")
        
public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, host, info);
    }

    /**
     * Called when a child of the host View has requested sending an
     * {@link AccessibilityEvent} and gives an opportunity to the parent (the host)
     * to augment the event.
     * <p>
     * The default implementation behaves as
     * {@link ViewGroupCompat#onRequestSendAccessibilityEvent(ViewGroup, View, AccessibilityEvent)
     * ViewGroupCompat#onRequestSendAccessibilityEvent(ViewGroup, View, AccessibilityEvent)} for
     * the case of no accessibility delegate been set.
     * </p>
     *
     * @param host The View hosting the delegate.
     * @param child The child which requests sending the event.
     * @param event The event to be sent.
     * @return True if the event should be sent
     *
     * @see ViewGroupCompat#onRequestSendAccessibilityEvent(ViewGroup, View, AccessibilityEvent)
     *      ViewGroupCompat#onRequestSendAccessibilityEvent(ViewGroup, View, AccessibilityEvent)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.056 -0400", hash_original_method = "73CE2F858DC24998E108FD42EF6CF922", hash_generated_method = "4B55B951CD3EA25FD617AE927A09E82E")
        
public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
            AccessibilityEvent event) {
        return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, host, child, event);
    }

    /**
     * Gets the provider for managing a virtual view hierarchy rooted at this View
     * and reported to {@link android.accessibilityservice.AccessibilityService}s
     * that explore the window content.
     * <p>
     * The default implementation behaves as
     * {@link ViewCompat#getAccessibilityNodeProvider(View) ViewCompat#getAccessibilityNodeProvider(View)}
     * for the case of no accessibility delegate been set.
     * </p>
     *
     * @return The provider.
     *
     * @see AccessibilityNodeProviderCompat
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.061 -0400", hash_original_method = "0B1F1AAFD51E2E935DE00B12D3D28739", hash_generated_method = "53A99BBD6F8F8586E2C002EB261711D9")
        
public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        return IMPL.getAccessibilityNodeProvider(DEFAULT_DELEGATE, host);
    }

    /**
     * Performs the specified accessibility action on the view. For
     * possible accessibility actions look at {@link AccessibilityNodeInfoCompat}.
     * <p>
     * The default implementation behaves as
     * {@link View#performAccessibilityAction(int, Bundle)
     *  View#performAccessibilityAction(int, Bundle)} for the case of
     *  no accessibility delegate been set.
     * </p>
     *
     * @param action The action to perform.
     * @return Whether the action was performed.
     *
     * @see View#performAccessibilityAction(int, Bundle)
     *      View#performAccessibilityAction(int, Bundle)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.067 -0400", hash_original_method = "3966E0F943BB84ABC0EC28FC4C31B47B", hash_generated_method = "6D8BAAF556CFDDFEC98D87AAD9CD29A5")
        
public boolean performAccessibilityAction(View host, int action, Bundle args) {
        return IMPL.performAccessibilityAction(DEFAULT_DELEGATE, host, action, args);
    }
}
