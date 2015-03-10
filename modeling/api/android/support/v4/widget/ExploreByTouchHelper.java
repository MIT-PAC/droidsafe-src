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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

import java.util.LinkedList;
import java.util.List;

/**
 * ExploreByTouchHelper is a utility class for implementing accessibility
 * support in custom {@link View}s that represent a collection of View-like
 * logical items. It extends {@link AccessibilityNodeProviderCompat} and
 * simplifies many aspects of providing information to accessibility services
 * and managing accessibility focus. This class does not currently support
 * hierarchies of logical items.
 * <p>
 * This should be applied to the parent view using
 * {@link ViewCompat#setAccessibilityDelegate}:
 *
 * <pre>
 * mAccessHelper = ExploreByTouchHelper.create(someView, mAccessHelperCallback);
 * ViewCompat.setAccessibilityDelegate(someView, mAccessHelper);
 * </pre>
 */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.340 -0400", hash_original_field = "54057F033B7A576C01E71E48BE605799", hash_generated_field = "8AA8DEB8BAABB608350ADF82E17AE347")

    public static final int INVALID_ID = Integer.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.344 -0400", hash_original_field = "EF48CF00CA89D70A7C3E747517972EFA", hash_generated_field = "3A855ED039B0347F4085762AF5DBC9EA")

    private static final String DEFAULT_CLASS_NAME = View.class.getName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.349 -0400", hash_original_field = "7FA76B71EACE8545029340404F4CC131", hash_generated_field = "943051E43F5EA27EF3D5D21EEC285C88")

    private final Rect mTempScreenRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.353 -0400", hash_original_field = "02C86148652D7B5D00CD14864BA31A9D", hash_generated_field = "52EB5D54D137642C2006FC7AA6140EA7")

    private final Rect mTempParentRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.357 -0400", hash_original_field = "32422B89F3A5AC4D7D247B41299C2023", hash_generated_field = "05A3F47D3886C2131D5607359C3D02EB")

    private final Rect mTempVisibleRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.361 -0400", hash_original_field = "104C3FE9E38940A52505AD3B074C6F48", hash_generated_field = "FEC16F8CF49A6292884B822C865E6BB1")

    private final int[] mTempGlobalRect = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.364 -0400", hash_original_field = "E4C36FF4DECEE64D8DCAF37E82982D7D", hash_generated_field = "C013ECED7CA524EB41E7ACD46DE26D71")

    private  AccessibilityManager mManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.368 -0400", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private  View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.372 -0400", hash_original_field = "C1933835EBF7BF928DB4B35AD9A24E47", hash_generated_field = "E64C69A5C63856677F9DF6F5B7B1CB8E")

    private ExploreByTouchNodeProvider mNodeProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.376 -0400", hash_original_field = "6A496DACD051CF5C8AD7A059ACB3841D", hash_generated_field = "D15DBDE25680C2D125B2C430FEAB8451")

    private int mFocusedVirtualViewId = INVALID_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.379 -0400", hash_original_field = "FDFA54882EC2EBF901F5419136AA0882", hash_generated_field = "F602442B12174AD4617B21CAA85503BF")

    private int mHoveredVirtualViewId = INVALID_ID;

    /**
     * Factory method to create a new {@link ExploreByTouchHelper}.
     *
     * @param forView View whose logical children are exposed by this helper.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.384 -0400", hash_original_method = "57B2771ABBD66DEA0E874E0F9FBB3AC7", hash_generated_method = "AC68BF2745A64914790A8BC03F15229C")
    
public ExploreByTouchHelper(View forView) {
        if (forView == null) {
            throw new IllegalArgumentException("View may not be null");
        }

        mView = forView;
        final Context context = forView.getContext();
        mManager = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
    }

    /**
     * Returns the {@link AccessibilityNodeProviderCompat} for this helper.
     *
     * @param host View whose logical children are exposed by this helper.
     * @return The accessibility node provider for this helper.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.388 -0400", hash_original_method = "3A7154DD0098C6940A4C85A82BE34446", hash_generated_method = "457F2F722DDA8C643FAA750BC4CA08A2")
    
@Override
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        if (mNodeProvider == null) {
            mNodeProvider = new ExploreByTouchNodeProvider();
        }
        return mNodeProvider;
    }

    /**
     * Dispatches hover {@link MotionEvent}s to the virtual view hierarchy when
     * the Explore by Touch feature is enabled.
     * <p>
     * This method should be called by overriding
     * {@link View#dispatchHoverEvent}:
     *
     * <pre>&#64;Override
     * public boolean dispatchHoverEvent(MotionEvent event) {
     *   if (mHelper.dispatchHoverEvent(this, event) {
     *     return true;
     *   }
     *   return super.dispatchHoverEvent(event);
     * }
     * </pre>
     *
     * @param event The hover event to dispatch to the virtual view hierarchy.
     * @return Whether the hover event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.394 -0400", hash_original_method = "A8DD5310ECE049158C0E504920F91633", hash_generated_method = "DA4721836BAEB03A3FE8C06BF15624F6")
    
public boolean dispatchHoverEvent(MotionEvent event) {
        if (!mManager.isEnabled()
                || !AccessibilityManagerCompat.isTouchExplorationEnabled(mManager)) {
            return false;
        }

        switch (event.getAction()) {
            case MotionEventCompat.ACTION_HOVER_MOVE:
            case MotionEventCompat.ACTION_HOVER_ENTER:
                final int virtualViewId = getVirtualViewAt(event.getX(), event.getY());
                updateHoveredVirtualView(virtualViewId);
                return (virtualViewId != INVALID_ID);
            case MotionEventCompat.ACTION_HOVER_EXIT:
                if (mFocusedVirtualViewId != INVALID_ID) {
                    updateHoveredVirtualView(INVALID_ID);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /**
     * Populates an event of the specified type with information about an item
     * and attempts to send it up through the view hierarchy.
     * <p>
     * You should call this method after performing a user action that normally
     * fires an accessibility event, such as clicking on an item.
     *
     * <pre>public void performItemClick(T item) {
     *   ...
     *   sendEventForVirtualViewId(item.id, AccessibilityEvent.TYPE_VIEW_CLICKED);
     * }
     * </pre>
     *
     * @param virtualViewId The virtual view id for which to send an event.
     * @param eventType The type of event to send.
     * @return true if the event was sent successfully.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.398 -0400", hash_original_method = "96D110182B0704010077DB7FDA2616F5", hash_generated_method = "048D3F10F127EFEF8ECD6CCAFBC22F0E")
    
public boolean sendEventForVirtualView(int virtualViewId, int eventType) {
        if ((virtualViewId == INVALID_ID) || !mManager.isEnabled()) {
            return false;
        }

        final ViewParent parent = mView.getParent();
        if (parent == null) {
            return false;
        }

        final AccessibilityEvent event = createEvent(virtualViewId, eventType);
        return ViewParentCompat.requestSendAccessibilityEvent(parent, mView, event);
    }

    /**
     * Notifies the accessibility framework that the properties of the parent
     * view have changed.
     * <p>
     * You <b>must</b> call this method after adding or removing items from the
     * parent view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.402 -0400", hash_original_method = "99D9FCDA3D467DE95B67931AE8471B3E", hash_generated_method = "706ED86502A88CA5CC321BAC703D1D73")
    
public void invalidateRoot() {
        invalidateVirtualView(View.NO_ID);
    }

    /**
     * Notifies the accessibility framework that the properties of a particular
     * item have changed.
     * <p>
     * You <b>must</b> call this method after changing any of the properties set
     * in {@link #onPopulateNodeForVirtualView}.
     *
     * @param virtualViewId The virtual view id to invalidate.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.406 -0400", hash_original_method = "17EE4F93EE5401D70D975BE6F352A6D7", hash_generated_method = "1710C544718E4FD6EB9DD97F09EF4279")
    
public void invalidateVirtualView(int virtualViewId) {
        sendEventForVirtualView(
                virtualViewId, AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED);
    }

    /**
     * Returns the virtual view id for the currently focused item,
     *
     * @return A virtual view id, or {@link #INVALID_ID} if no item is
     *         currently focused.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.409 -0400", hash_original_method = "281E86F843DA7D39923585B3C9F3F8E6", hash_generated_method = "5D0E247CF1D209C9AE08E580B1FF609D")
    
public int getFocusedVirtualView() {
        return mFocusedVirtualViewId;
    }

    /**
     * Sets the currently hovered item, sending hover accessibility events as
     * necessary to maintain the correct state.
     *
     * @param virtualViewId The virtual view id for the item currently being
     *            hovered, or {@link #INVALID_ID} if no item is hovered within
     *            the parent view.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.413 -0400", hash_original_method = "438FC3EE468C2481A68882B250CBAFD4", hash_generated_method = "66B477549E6D91D8114EF828949EFD7E")
    
private void updateHoveredVirtualView(int virtualViewId) {
        if (mHoveredVirtualViewId == virtualViewId) {
            return;
        }

        final int previousVirtualViewId = mHoveredVirtualViewId;
        mHoveredVirtualViewId = virtualViewId;

        // Stay consistent with framework behavior by sending ENTER/EXIT pairs
        // in reverse order. This is accurate as of API 18.
        sendEventForVirtualView(virtualViewId, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
        sendEventForVirtualView(
                previousVirtualViewId, AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT);
    }

    /**
     * Constructs and returns an {@link AccessibilityEvent} for the specified
     * virtual view id, which includes the host view ({@link View#NO_ID}).
     *
     * @param virtualViewId The virtual view id for the item for which to
     *            construct an event.
     * @param eventType The type of event to construct.
     * @return An {@link AccessibilityEvent} populated with information about
     *         the specified item.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.417 -0400", hash_original_method = "DC2F06AD2459123BE3EE0DB6360F5DDB", hash_generated_method = "528A921E95A3249C0290CE2A637A949C")
    
private AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        switch (virtualViewId) {
            case View.NO_ID:
                return createEventForHost(eventType);
            default:
                return createEventForChild(virtualViewId, eventType);
        }
    }

    /**
     * Constructs and returns an {@link AccessibilityEvent} for the host node.
     *
     * @param eventType The type of event to construct.
     * @return An {@link AccessibilityEvent} populated with information about
     *         the specified item.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.422 -0400", hash_original_method = "F6176DE05E5EEDE2729CEDA2461C82B8", hash_generated_method = "428B5BEDA468B40E0EA20311F46185FB")
    
private AccessibilityEvent createEventForHost(int eventType) {
        final AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        ViewCompat.onInitializeAccessibilityEvent(mView, event);
        return event;
    }

    /**
     * Constructs and returns an {@link AccessibilityEvent} populated with
     * information about the specified item.
     *
     * @param virtualViewId The virtual view id for the item for which to
     *            construct an event.
     * @param eventType The type of event to construct.
     * @return An {@link AccessibilityEvent} populated with information about
     *         the specified item.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.427 -0400", hash_original_method = "B5387EAE5ECDAA2232667A6155115C6F", hash_generated_method = "DD8A336121EE1260E0EE0E054BBA42A1")
    
private AccessibilityEvent createEventForChild(int virtualViewId, int eventType) {
        final AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        event.setEnabled(true);
        event.setClassName(DEFAULT_CLASS_NAME);

        // Allow the client to populate the event.
        onPopulateEventForVirtualView(virtualViewId, event);

        // Make sure the developer is following the rules.
        if (event.getText().isEmpty() && (event.getContentDescription() == null)) {
            throw new RuntimeException("Callbacks must add text or a content description in "
                    + "populateEventForVirtualViewId()");
        }

        // Don't allow the client to override these properties.
        event.setPackageName(mView.getContext().getPackageName());

        final AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(event);
        record.setSource(mView, virtualViewId);

        return event;
    }

    /**
     * Constructs and returns an {@link AccessibilityNodeInfoCompat} for the
     * specified virtual view id, which includes the host view
     * ({@link View#NO_ID}).
     *
     * @param virtualViewId The virtual view id for the item for which to
     *            construct a node.
     * @return An {@link AccessibilityNodeInfoCompat} populated with information
     *         about the specified item.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.430 -0400", hash_original_method = "EBE0710EEEB344DA7EE2AED22575E2DA", hash_generated_method = "9FF00C64D55869543A3B73F758C3DBB0")
    
private AccessibilityNodeInfoCompat createNode(int virtualViewId) {
        switch (virtualViewId) {
            case View.NO_ID:
                return createNodeForHost();
            default:
                return createNodeForChild(virtualViewId);
        }
    }

    /**
     * Constructs and returns an {@link AccessibilityNodeInfoCompat} for the
     * host view populated with its virtual descendants.
     *
     * @return An {@link AccessibilityNodeInfoCompat} for the parent node.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.435 -0400", hash_original_method = "1F4D425D0B761A2CF9DAF84D210E8C06", hash_generated_method = "611A11E020E72A907B0EF493D5FD56E6")
    
private AccessibilityNodeInfoCompat createNodeForHost() {
        final AccessibilityNodeInfoCompat node = AccessibilityNodeInfoCompat.obtain(mView);
        ViewCompat.onInitializeAccessibilityNodeInfo(mView, node);

        // Add the virtual descendants.
        final LinkedList<Integer> virtualViewIds = new LinkedList<Integer>();
        getVisibleVirtualViews(virtualViewIds);

        for (Integer childVirtualViewId : virtualViewIds) {
            node.addChild(mView, childVirtualViewId);
        }

        return node;
    }

    /**
     * Constructs and returns an {@link AccessibilityNodeInfoCompat} for the
     * specified item. Automatically manages accessibility focus actions.
     * <p>
     * Allows the implementing class to specify most node properties, but
     * overrides the following:
     * <ul>
     * <li>{@link AccessibilityNodeInfoCompat#setPackageName}
     * <li>{@link AccessibilityNodeInfoCompat#setClassName}
     * <li>{@link AccessibilityNodeInfoCompat#setParent(View)}
     * <li>{@link AccessibilityNodeInfoCompat#setSource(View, int)}
     * <li>{@link AccessibilityNodeInfoCompat#setVisibleToUser}
     * <li>{@link AccessibilityNodeInfoCompat#setBoundsInScreen(Rect)}
     * </ul>
     * <p>
     * Uses the bounds of the parent view and the parent-relative bounding
     * rectangle specified by
     * {@link AccessibilityNodeInfoCompat#getBoundsInParent} to automatically
     * update the following properties:
     * <ul>
     * <li>{@link AccessibilityNodeInfoCompat#setVisibleToUser}
     * <li>{@link AccessibilityNodeInfoCompat#setBoundsInParent}
     * </ul>
     *
     * @param virtualViewId The virtual view id for item for which to construct
     *            a node.
     * @return An {@link AccessibilityNodeInfoCompat} for the specified item.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.442 -0400", hash_original_method = "06BB9C41C92493E56EB052472C0E6CAD", hash_generated_method = "F8D3790A88D9C725AD2EFB67F0A00102")
    
private AccessibilityNodeInfoCompat createNodeForChild(int virtualViewId) {
        final AccessibilityNodeInfoCompat node = AccessibilityNodeInfoCompat.obtain();

        // Ensure the client has good defaults.
        node.setEnabled(true);
        node.setClassName(DEFAULT_CLASS_NAME);

        // Allow the client to populate the node.
        onPopulateNodeForVirtualView(virtualViewId, node);

        // Make sure the developer is following the rules.
        if ((node.getText() == null) && (node.getContentDescription() == null)) {
            throw new RuntimeException("Callbacks must add text or a content description in "
                    + "populateNodeForVirtualViewId()");
        }

        node.getBoundsInParent(mTempParentRect);
        if (mTempParentRect.isEmpty()) {
            throw new RuntimeException("Callbacks must set parent bounds in "
                    + "populateNodeForVirtualViewId()");
        }

        final int actions = node.getActions();
        if ((actions & AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in "
                    + "populateNodeForVirtualViewId()");
        }
        if ((actions & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in "
                    + "populateNodeForVirtualViewId()");
        }

        // Don't allow the client to override these properties.
        node.setPackageName(mView.getContext().getPackageName());
        node.setSource(mView, virtualViewId);
        node.setParent(mView);

        // Manage internal accessibility focus state.
        if (mFocusedVirtualViewId == virtualViewId) {
            node.setAccessibilityFocused(true);
            node.addAction(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            node.setAccessibilityFocused(false);
            node.addAction(AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS);
        }

        // Set the visibility based on the parent bound.
        if (intersectVisibleToUser(mTempParentRect)) {
            node.setVisibleToUser(true);
            node.setBoundsInParent(mTempParentRect);
        }

        // Calculate screen-relative bound.
        mView.getLocationOnScreen(mTempGlobalRect);
        final int offsetX = mTempGlobalRect[0];
        final int offsetY = mTempGlobalRect[1];
        mTempScreenRect.set(mTempParentRect);
        mTempScreenRect.offset(offsetX, offsetY);
        node.setBoundsInScreen(mTempScreenRect);

        return node;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.447 -0400", hash_original_method = "4865729248C15A3BDB4AF7F4CD3C0582", hash_generated_method = "4781350769968312C99D68A9236452AF")
    
private boolean performAction(int virtualViewId, int action, Bundle arguments) {
        switch (virtualViewId) {
            case View.NO_ID:
                return performActionForHost(action, arguments);
            default:
                return performActionForChild(virtualViewId, action, arguments);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.451 -0400", hash_original_method = "7AB3307663C8B9E8A60C43E776F0F48C", hash_generated_method = "9D4863B543BF26E95B595B4F889DCFB1")
    
private boolean performActionForHost(int action, Bundle arguments) {
        return ViewCompat.performAccessibilityAction(mView, action, arguments);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.455 -0400", hash_original_method = "C4B4581ABB41EAD20E436B3D07A04F79", hash_generated_method = "FF5AAB479AB785F505A5BB3D4A5BD156")
    
private boolean performActionForChild(int virtualViewId, int action, Bundle arguments) {
        switch (action) {
            case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS:
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS:
                return manageFocusForChild(virtualViewId, action, arguments);
            default:
                return onPerformActionForVirtualView(virtualViewId, action, arguments);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.460 -0400", hash_original_method = "EB3B7851E0A9AE9507BD94312ED2E0A5", hash_generated_method = "BBDC04FF7D10F1EA7138EE472553FC9C")
    
private boolean manageFocusForChild(int virtualViewId, int action, Bundle arguments) {
        switch (action) {
            case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS:
                return requestAccessibilityFocus(virtualViewId);
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS:
                return clearAccessibilityFocus(virtualViewId);
            default:
                return false;
        }
    }

    /**
     * Computes whether the specified {@link Rect} intersects with the visible
     * portion of its parent {@link View}. Modifies {@code localRect} to contain
     * only the visible portion.
     *
     * @param localRect A rectangle in local (parent) coordinates.
     * @return Whether the specified {@link Rect} is visible on the screen.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.465 -0400", hash_original_method = "C741EA9E01AD56ACA1CAE75445D93E59", hash_generated_method = "59E5BFEE256BAB0048C4EF36203D9474")
    
private boolean intersectVisibleToUser(Rect localRect) {
        // Missing or empty bounds mean this view is not visible.
        if ((localRect == null) || localRect.isEmpty()) {
            return false;
        }

        // Attached to invisible window means this view is not visible.
        if (mView.getWindowVisibility() != View.VISIBLE) {
            return false;
        }

        // An invisible predecessor means that this view is not visible.
        ViewParent viewParent = mView.getParent();
        while (viewParent instanceof View) {
            final View view = (View) viewParent;
            if ((ViewCompat.getAlpha(view) <= 0) || (view.getVisibility() != View.VISIBLE)) {
                return false;
            }
            viewParent = view.getParent();
        }

        // A null parent implies the view is not visible.
        if (viewParent == null) {
            return false;
        }

        // If no portion of the parent is visible, this view is not visible.
        if (!mView.getLocalVisibleRect(mTempVisibleRect)) {
            return false;
        }

        // Check if the view intersects the visible portion of the parent.
        return localRect.intersect(mTempVisibleRect);
    }

    /**
     * Returns whether this virtual view is accessibility focused.
     *
     * @return True if the view is accessibility focused.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.468 -0400", hash_original_method = "E8BD9512DA48718E84726C044C56025C", hash_generated_method = "33A3A8D7C9BDBC3ED100CA30AAD87945")
    
private boolean isAccessibilityFocused(int virtualViewId) {
        return (mFocusedVirtualViewId == virtualViewId);
    }

    /**
     * Attempts to give accessibility focus to a virtual view.
     * <p>
     * A virtual view will not actually take focus if
     * {@link AccessibilityManager#isEnabled()} returns false,
     * {@link AccessibilityManager#isTouchExplorationEnabled()} returns false,
     * or the view already has accessibility focus.
     *
     * @param virtualViewId The id of the virtual view on which to place
     *            accessibility focus.
     * @return Whether this virtual view actually took accessibility focus.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.472 -0400", hash_original_method = "9221D7E230633C01EE0D4401DD9EDF4F", hash_generated_method = "8D289384FC46C15507C4061828706FD1")
    
private boolean requestAccessibilityFocus(int virtualViewId) {
        if (!mManager.isEnabled()
                || !AccessibilityManagerCompat.isTouchExplorationEnabled(mManager)) {
            return false;
        }
        // TODO: Check virtual view visibility.
        if (!isAccessibilityFocused(virtualViewId)) {
            mFocusedVirtualViewId = virtualViewId;
            // TODO: Only invalidate virtual view bounds.
            mView.invalidate();
            sendEventForVirtualView(virtualViewId,
                    AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED);
            return true;
        }
        return false;
    }

    /**
     * Attempts to clear accessibility focus from a virtual view.
     *
     * @param virtualViewId The id of the virtual view from which to clear
     *            accessibility focus.
     * @return Whether this virtual view actually cleared accessibility focus.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.476 -0400", hash_original_method = "7A51DC02724A98B596F2ECF37D3805B1", hash_generated_method = "C93B43EE7E6C75FFF0A0A18E99CB8B59")
    
private boolean clearAccessibilityFocus(int virtualViewId) {
        if (isAccessibilityFocused(virtualViewId)) {
            mFocusedVirtualViewId = INVALID_ID;
            mView.invalidate();
            sendEventForVirtualView(virtualViewId,
                    AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED);
            return true;
        }
        return false;
    }

    /**
     * Provides a mapping between view-relative coordinates and logical
     * items.
     *
     * @param x The view-relative x coordinate
     * @param y The view-relative y coordinate
     * @return virtual view identifier for the logical item under
     *         coordinates (x,y)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.480 -0400", hash_original_method = "60BB1E84FCA474B200ED13202641C1BB", hash_generated_method = "2B85F8D44FB370EF937C50C06E08E3DE")
    
protected abstract int getVirtualViewAt(float x, float y);

    /**
     * Populates a list with the view's visible items. The ordering of items
     * within {@code virtualViewIds} specifies order of accessibility focus
     * traversal.
     *
     * @param virtualViewIds The list to populate with visible items
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.483 -0400", hash_original_method = "F1691EE0366624B0B3D2D77A90A8E893", hash_generated_method = "CD88857B817695162064E7831E8A1EB9")
    
protected abstract void getVisibleVirtualViews(List<Integer> virtualViewIds);

    /**
     * Populates an {@link AccessibilityEvent} with information about the
     * specified item.
     * <p>
     * Implementations <b>must</b> populate the following required fields:
     * <ul>
     * <li>event text, see {@link AccessibilityEvent#getText} or
     * {@link AccessibilityEvent#setContentDescription}
     * </ul>
     * <p>
     * The helper class automatically populates the following fields with
     * default values, but implementations may optionally override them:
     * <ul>
     * <li>item class name, set to android.view.View, see
     * {@link AccessibilityEvent#setClassName}
     * </ul>
     * <p>
     * The following required fields are automatically populated by the
     * helper class and may not be overridden:
     * <ul>
     * <li>package name, set to the package of the host view's
     * {@link Context}, see {@link AccessibilityEvent#setPackageName}
     * <li>event source, set to the host view and virtual view identifier,
     * see {@link AccessibilityRecordCompat#setSource(View, int)}
     * </ul>
     *
     * @param virtualViewId The virtual view id for the item for which to
     *            populate the event
     * @param event The event to populate
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.488 -0400", hash_original_method = "B2E49BDDBC18C066A863F629479B0A8F", hash_generated_method = "C0DA5337D12B5C0F4B396E0B884CD4A4")
    
protected abstract void onPopulateEventForVirtualView(
            int virtualViewId, AccessibilityEvent event);

    /**
     * Populates an {@link AccessibilityNodeInfoCompat} with information
     * about the specified item.
     * <p>
     * Implementations <b>must</b> populate the following required fields:
     * <ul>
     * <li>event text, see {@link AccessibilityNodeInfoCompat#setText} or
     * {@link AccessibilityNodeInfoCompat#setContentDescription}
     * <li>bounds in parent coordinates, see
     * {@link AccessibilityNodeInfoCompat#setBoundsInParent}
     * </ul>
     * <p>
     * The helper class automatically populates the following fields with
     * default values, but implementations may optionally override them:
     * <ul>
     * <li>enabled state, set to true, see
     * {@link AccessibilityNodeInfoCompat#setEnabled}
     * <li>item class name, identical to the class name set by
     * {@link #onPopulateEventForVirtualView}, see
     * {@link AccessibilityNodeInfoCompat#setClassName}
     * </ul>
     * <p>
     * The following required fields are automatically populated by the
     * helper class and may not be overridden:
     * <ul>
     * <li>package name, identical to the package name set by
     * {@link #onPopulateEventForVirtualView}, see
     * {@link AccessibilityNodeInfoCompat#setPackageName}
     * <li>node source, identical to the event source set in
     * {@link #onPopulateEventForVirtualView}, see
     * {@link AccessibilityNodeInfoCompat#setSource(View, int)}
     * <li>parent view, set to the host view, see
     * {@link AccessibilityNodeInfoCompat#setParent(View)}
     * <li>visibility, computed based on parent-relative bounds, see
     * {@link AccessibilityNodeInfoCompat#setVisibleToUser}
     * <li>accessibility focus, computed based on internal helper state, see
     * {@link AccessibilityNodeInfoCompat#setAccessibilityFocused}
     * <li>bounds in screen coordinates, computed based on host view bounds,
     * see {@link AccessibilityNodeInfoCompat#setBoundsInScreen}
     * </ul>
     * <p>
     * Additionally, the helper class automatically handles accessibility
     * focus management by adding the appropriate
     * {@link AccessibilityNodeInfoCompat#ACTION_ACCESSIBILITY_FOCUS} or
     * {@link AccessibilityNodeInfoCompat#ACTION_CLEAR_ACCESSIBILITY_FOCUS}
     * action. Implementations must <b>never</b> manually add these actions.
     * <p>
     * The helper class also automatically modifies parent- and
     * screen-relative bounds to reflect the portion of the item visible
     * within its parent.
     *
     * @param virtualViewId The virtual view identifier of the item for
     *            which to populate the node
     * @param node The node to populate
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.492 -0400", hash_original_method = "2BFD04B45BC24BA9601ECB515166B93C", hash_generated_method = "618F7E23D8A4D7EF822614D4DDAE516A")
    
protected abstract void onPopulateNodeForVirtualView(
            int virtualViewId, AccessibilityNodeInfoCompat node);

    /**
     * Performs the specified accessibility action on the item associated
     * with the virtual view identifier. See
     * {@link AccessibilityNodeInfoCompat#performAction(int, Bundle)} for
     * more information.
     * <p>
     * Implementations <b>must</b> handle any actions added manually in
     * {@link #onPopulateNodeForVirtualView}.
     * <p>
     * The helper class automatically handles focus management resulting
     * from {@link AccessibilityNodeInfoCompat#ACTION_ACCESSIBILITY_FOCUS}
     * and
     * {@link AccessibilityNodeInfoCompat#ACTION_CLEAR_ACCESSIBILITY_FOCUS}
     * actions.
     *
     * @param virtualViewId The virtual view identifier of the item on which
     *            to perform the action
     * @param action The accessibility action to perform
     * @param arguments (Optional) A bundle with additional arguments, or
     *            null
     * @return true if the action was performed
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.497 -0400", hash_original_method = "0C33342135985E48955C28913B6F3F0B", hash_generated_method = "F16A4C17D2B8E69D8B5B1580B9A5F94F")
    
protected abstract boolean onPerformActionForVirtualView(
            int virtualViewId, int action, Bundle arguments);

    /**
     * Exposes a virtual view hierarchy to the accessibility framework. Only
     * used in API 16+.
     */
    private class ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
            return ExploreByTouchHelper.this.createNode(virtualViewId);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return ExploreByTouchHelper.this.performAction(virtualViewId, action, arguments);
        }
    }
}
