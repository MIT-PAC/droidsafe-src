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

package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import java.util.Arrays;

/**
 * ViewDragHelper is a utility class for writing custom ViewGroups. It offers a number
 * of useful operations and state tracking for allowing a user to drag and reposition
 * views within their parent ViewGroup.
 */
public class ViewDragHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.533 -0400", hash_original_field = "C22459DE911D9CCA804FDC2EA256F7AC", hash_generated_field = "549BA946E51CD9BB5484846B8D64B226")

    private static final String TAG = "ViewDragHelper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.535 -0400", hash_original_field = "394D213079DFA0C7024EC13F5673BC94", hash_generated_field = "FCD3FB87F68F757490BA4E90CBF18F9F")

    public static final int INVALID_POINTER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.539 -0400", hash_original_field = "E39B828D2E7A099E9F830BC3FBD507AA", hash_generated_field = "2B07E9251878DD44EDD52AD484FEFBA5")

    public static final int STATE_IDLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.544 -0400", hash_original_field = "5B150207F485E1202FEDFD7A0CE84320", hash_generated_field = "7C4D36560B9E98F158B85C8B667FB807")

    public static final int STATE_DRAGGING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.549 -0400", hash_original_field = "CC4F5243EEB899234841E75594C21697", hash_generated_field = "F35C6606C89E820B508B49614DCD1D82")

    public static final int STATE_SETTLING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.554 -0400", hash_original_field = "0EFEA3C90A5B1469F199BA1BBC6E9715", hash_generated_field = "4B4A3873599EF4402BB200B495248FF3")

    public static final int EDGE_LEFT = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.560 -0400", hash_original_field = "6DF2BAF89E89ED121C8ACF8DB350A55E", hash_generated_field = "3D734C03FA5021D63221C8A557FDD8C3")

    public static final int EDGE_RIGHT = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.565 -0400", hash_original_field = "30C9F42759023FA829A83F641D2DECF1", hash_generated_field = "AAB79CAA9D26386391935D2EA6A5F738")

    public static final int EDGE_TOP = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.570 -0400", hash_original_field = "7CAECFEE68FB41D2B7483D76207C1BB7", hash_generated_field = "3AB40A31A66189BEB47E3E82AB2B26E0")

    public static final int EDGE_BOTTOM = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.574 -0400", hash_original_field = "8DDD171B524F4F7FAB84202E97E24E30", hash_generated_field = "EEC98F8307AC96DB8F5D26BB35AA8F51")

    public static final int EDGE_ALL = EDGE_LEFT | EDGE_TOP | EDGE_RIGHT | EDGE_BOTTOM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.578 -0400", hash_original_field = "631200ADEF49532BD06222F044752516", hash_generated_field = "A366E8464371353EF2CC0818AE5FF7A3")

    public static final int DIRECTION_HORIZONTAL = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.581 -0400", hash_original_field = "54CA641402A75D5C2FE16C2C633D8519", hash_generated_field = "E346CEED25752F2460989EA99FF34B35")

    public static final int DIRECTION_VERTICAL = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.585 -0400", hash_original_field = "B3B8E4F6AE0C27B408DC8ABB7E923C70", hash_generated_field = "72F52FC1E7EA48C7F80DFF642D1DEE1C")

    public static final int DIRECTION_ALL = DIRECTION_HORIZONTAL | DIRECTION_VERTICAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.589 -0400", hash_original_field = "A1646E8E74FB749E3F4D7EE39B142FB8", hash_generated_field = "2D9DEE84C09FF944FAAECA53476690E1")

    private static final int EDGE_SIZE = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.595 -0400", hash_original_field = "1F9B40FA4EA9600D0712B19615D6A305", hash_generated_field = "76BFA39BE634AE9441EF5C834D53B1F4")

    private static final int BASE_SETTLE_DURATION = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.598 -0400", hash_original_field = "FD9103375029EF0DC7A8FDCD1D959B5C", hash_generated_field = "17654B746B84D905348C1100B6FE7760")

    private static final int MAX_SETTLE_DURATION = 600;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.721 -0400", hash_original_field = "75923CE1D8B122884D075B6E2A0FEA78", hash_generated_field = "75F5B478F7E09B4BFDBE89CA1735B7D8")

    private static final Interpolator sInterpolator = new Interpolator() {
        @DSSafe(DSCat.SAFE_LIST)
        public float getInterpolation(float t) {
            t -= 1.0f;
            return t * t * t * t * t + 1.0f;
        }
    };

    /**
     * Factory method to create a new ViewDragHelper.
     *
     * @param forParent Parent view to monitor
     * @param cb Callback to provide information and receive events
     * @return a new ViewDragHelper instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.730 -0400", hash_original_method = "8C7D01833A54C3D61A2AE4A552879F4D", hash_generated_method = "4D03443D8D6F19C4CE342E5BF8839DA2")
    
public static ViewDragHelper create(ViewGroup forParent, Callback cb) {
        return new ViewDragHelper(forParent.getContext(), forParent, cb);
    }

    /**
     * Factory method to create a new ViewDragHelper.
     *
     * @param forParent Parent view to monitor
     * @param sensitivity Multiplier for how sensitive the helper should be about detecting
     *                    the start of a drag. Larger values are more sensitive. 1.0f is normal.
     * @param cb Callback to provide information and receive events
     * @return a new ViewDragHelper instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.734 -0400", hash_original_method = "67650F818F5BA67B783B0F7C4A9FB82C", hash_generated_method = "3FC5B65BDD394EDDB14A3945C4CE4160")
    
public static ViewDragHelper create(ViewGroup forParent, float sensitivity, Callback cb) {
        final ViewDragHelper helper = create(forParent, cb);
        helper.mTouchSlop = (int) (helper.mTouchSlop * (1 / sensitivity));
        return helper;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.601 -0400", hash_original_field = "C7E9E13FC4C98E8DEB45723DE23CAB31", hash_generated_field = "351A9828D8BB52D6437C5F92C76C3ADF")

    // Current drag state; idle, dragging or settling
    private int mDragState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.604 -0400", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.606 -0400", hash_original_field = "D0914C40920996908439839B104BE272", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.609 -0400", hash_original_field = "057A49952EC0F61A5442BA9977D0C3DA", hash_generated_field = "8B5E399E5D6C8B35253E47E79B641D33")

    private float[] mInitialMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.611 -0400", hash_original_field = "92E3F233108803F411CC0D396B0566E7", hash_generated_field = "87DD4324B9180EBE4638F141014CC973")

    private float[] mInitialMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.614 -0400", hash_original_field = "E70F0DD19CEEBAAC65E6D64B716B7E04", hash_generated_field = "810A51F684A233CE1C19E18C021EFC23")

    private float[] mLastMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.617 -0400", hash_original_field = "2D6CC58E2F538567EA1F7BD2A95F1D09", hash_generated_field = "9F51CA19EDD2E304E8215E7E52049521")

    private float[] mLastMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.622 -0400", hash_original_field = "C24FA22EB9A5872960783841CE41F96D", hash_generated_field = "C6F7D6014999DB61A98650AFC830C55C")

    private int[] mInitialEdgesTouched;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.626 -0400", hash_original_field = "EDAF57568D641BB948B92B9E1E845B5D", hash_generated_field = "F287EB6C2DA7A8BE7F1C03EB119475A9")

    private int[] mEdgeDragsInProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.630 -0400", hash_original_field = "CE9D4A1CA302B09E9F13D4313C0D2099", hash_generated_field = "5F3B28AFE055E5D4F8D1FBA135B2712C")

    private int[] mEdgeDragsLocked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.633 -0400", hash_original_field = "CA744232B91F9282376F80DCE48F7D51", hash_generated_field = "3173402BCB7870233D7DC1BAA258E005")

    private int mPointersDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.639 -0400", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.642 -0400", hash_original_field = "1F8FD58859AB263E0B6AE7DCB61C2EDE", hash_generated_field = "29DF0C40E6B66ADC0FCAC047F858C487")

    private float mMaxVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.644 -0400", hash_original_field = "5C7EED378A691E89284A0173638247AB", hash_generated_field = "97037075C7E6AC2C772CCAD8D2CDCBB5")

    private float mMinVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.647 -0400", hash_original_field = "336EAA0E1083A9BD8C09C68B85CD2EFE", hash_generated_field = "E3C4CB718F661C66117C49A470FC6C65")

    private int mEdgeSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.649 -0400", hash_original_field = "2E7B9F8D441B71D4C324C41367B358B2", hash_generated_field = "45CD457B1A84220D829A3F34E8419A05")

    private int mTrackingEdges;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.651 -0400", hash_original_field = "5D0F952B201283814D28AC3DE964F3CB", hash_generated_field = "DC7CF8B2E3C8F05523227D0ADA7B02CD")

    private ScrollerCompat mScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.654 -0400", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private  Callback mCallback;

    /**
     * A Callback is used as a communication channel with the ViewDragHelper back to the
     * parent view using it. <code>on*</code>methods are invoked on siginficant events and several
     * accessor methods are expected to provide the ViewDragHelper with more information
     * about the state of the parent view upon request. The callback also makes decisions
     * governing the range and draggability of child views.
     */
    public static abstract class Callback {
        /**
         * Called when the drag state changes. See the <code>STATE_*</code> constants
         * for more information.
         *
         * @param state The new drag state
         *
         * @see #STATE_IDLE
         * @see #STATE_DRAGGING
         * @see #STATE_SETTLING
         */
        public void onViewDragStateChanged(int state) {}

        /**
         * Called when the captured view's position changes as the result of a drag or settle.
         *
         * @param changedView View whose position changed
         * @param left New X coordinate of the left edge of the view
         * @param top New Y coordinate of the top edge of the view
         * @param dx Change in X position from the last call
         * @param dy Change in Y position from the last call
         */
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {}

        /**
         * Called when a child view is captured for dragging or settling. The ID of the pointer
         * currently dragging the captured view is supplied. If activePointerId is
         * identified as {@link #INVALID_POINTER} the capture is programmatic instead of
         * pointer-initiated.
         *
         * @param capturedChild Child view that was captured
         * @param activePointerId Pointer id tracking the child capture
         */
        public void onViewCaptured(View capturedChild, int activePointerId) {}

        /**
         * Called when the child view is no longer being actively dragged.
         * The fling velocity is also supplied, if relevant. The velocity values may
         * be clamped to system minimums or maximums.
         *
         * <p>Calling code may decide to fling or otherwise release the view to let it
         * settle into place. It should do so using {@link #settleCapturedViewAt(int, int)}
         * or {@link #flingCapturedView(int, int, int, int)}. If the Callback invokes
         * one of these methods, the ViewDragHelper will enter {@link #STATE_SETTLING}
         * and the view capture will not fully end until it comes to a complete stop.
         * If neither of these methods is invoked before <code>onViewReleased</code> returns,
         * the view will stop in place and the ViewDragHelper will return to
         * {@link #STATE_IDLE}.</p>
         *
         * @param releasedChild The captured child view now being released
         * @param xvel X velocity of the pointer as it left the screen in pixels per second.
         * @param yvel Y velocity of the pointer as it left the screen in pixels per second.
         */
        public void onViewReleased(View releasedChild, float xvel, float yvel) {}

        /**
         * Called when one of the subscribed edges in the parent view has been touched
         * by the user while no child view is currently captured.
         *
         * @param edgeFlags A combination of edge flags describing the edge(s) currently touched
         * @param pointerId ID of the pointer touching the described edge(s)
         * @see #EDGE_LEFT
         * @see #EDGE_TOP
         * @see #EDGE_RIGHT
         * @see #EDGE_BOTTOM
         */
        public void onEdgeTouched(int edgeFlags, int pointerId) {}

        /**
         * Called when the given edge may become locked. This can happen if an edge drag
         * was preliminarily rejected before beginning, but after {@link #onEdgeTouched(int, int)}
         * was called. This method should return true to lock this edge or false to leave it
         * unlocked. The default behavior is to leave edges unlocked.
         *
         * @param edgeFlags A combination of edge flags describing the edge(s) locked
         * @return true to lock the edge, false to leave it unlocked
         */
        public boolean onEdgeLock(int edgeFlags) {
            return false;
        }

        /**
         * Called when the user has started a deliberate drag away from one
         * of the subscribed edges in the parent view while no child view is currently captured.
         *
         * @param edgeFlags A combination of edge flags describing the edge(s) dragged
         * @param pointerId ID of the pointer touching the described edge(s)
         * @see #EDGE_LEFT
         * @see #EDGE_TOP
         * @see #EDGE_RIGHT
         * @see #EDGE_BOTTOM
         */
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {}

        /**
         * Called to determine the Z-order of child views.
         *
         * @param index the ordered position to query for
         * @return index of the view that should be ordered at position <code>index</code>
         */
        public int getOrderedChildIndex(int index) {
            return index;
        }

        /**
         * Return the magnitude of a draggable child view's horizontal range of motion in pixels.
         * This method should return 0 for views that cannot move horizontally.
         *
         * @param child Child view to check
         * @return range of horizontal motion in pixels
         */
        public int getViewHorizontalDragRange(View child) {
            return 0;
        }

        /**
         * Return the magnitude of a draggable child view's vertical range of motion in pixels.
         * This method should return 0 for views that cannot move vertically.
         *
         * @param child Child view to check
         * @return range of vertical motion in pixels
         */
        public int getViewVerticalDragRange(View child) {
            return 0;
        }

        /**
         * Called when the user's input indicates that they want to capture the given child view
         * with the pointer indicated by pointerId. The callback should return true if the user
         * is permitted to drag the given view with the indicated pointer.
         *
         * <p>ViewDragHelper may call this method multiple times for the same view even if
         * the view is already captured; this indicates that a new pointer is trying to take
         * control of the view.</p>
         *
         * <p>If this method returns true, a call to {@link #onViewCaptured(android.view.View, int)}
         * will follow if the capture is successful.</p>
         *
         * @param child Child the user is attempting to capture
         * @param pointerId ID of the pointer attempting the capture
         * @return true if capture should be allowed, false otherwise
         */
        public abstract boolean tryCaptureView(View child, int pointerId);

        /**
         * Restrict the motion of the dragged child view along the horizontal axis.
         * The default implementation does not allow horizontal motion; the extending
         * class must override this method and provide the desired clamping.
         *
         *
         * @param child Child view being dragged
         * @param left Attempted motion along the X axis
         * @param dx Proposed change in position for left
         * @return The new clamped position for left
         */
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return 0;
        }

        /**
         * Restrict the motion of the dragged child view along the vertical axis.
         * The default implementation does not allow vertical motion; the extending
         * class must override this method and provide the desired clamping.
         *
         *
         * @param child Child view being dragged
         * @param top Attempted motion along the Y axis
         * @param dy Proposed change in position for top
         * @return The new clamped position for top
         */
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.656 -0400", hash_original_field = "7DB94206E75E9A3FA5CA8D0A9F68B628", hash_generated_field = "4E306D4DACF3751737C4323163D313C7")

    private View mCapturedView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.659 -0400", hash_original_field = "DDEFB0459D9834FF2602B6F70C45A12C", hash_generated_field = "A3DC9EB6E1D41E850BB5557FCF568BED")

    private boolean mReleaseInProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.661 -0400", hash_original_field = "618A7D91F61CEDE70750F5B4524346D4", hash_generated_field = "356254C396806FFBAD2D203D7E235D36")

    private  ViewGroup mParentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.727 -0400", hash_original_field = "030DA41242414ED2CC13FF9EDB4386BA", hash_generated_field = "3F223B98A6B0FA32E393D739C4557FEC")

    private final Runnable mSetIdleRunnable = new Runnable() {
        @DSSafe(DSCat.SAFE_LIST)
        public void run() {
            setDragState(STATE_IDLE);
        }
    };

    /**
     * Apps should use ViewDragHelper.create() to get a new instance.
     * This will allow VDH to use internal compatibility implementations for different
     * platform versions.
     *
     * @param context Context to initialize config-dependent params from
     * @param forParent Parent view to monitor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.739 -0400", hash_original_method = "DBC42E01D144B8AE77AFDBBC6424BC10", hash_generated_method = "DBC4D936BF7DBF36716726BC364F6C82")
    
private ViewDragHelper(Context context, ViewGroup forParent, Callback cb) {
        if (forParent == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cb == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }

        mParentView = forParent;
        mCallback = cb;

        final ViewConfiguration vc = ViewConfiguration.get(context);
        final float density = context.getResources().getDisplayMetrics().density;
        mEdgeSize = (int) (EDGE_SIZE * density + 0.5f);

        mTouchSlop = vc.getScaledTouchSlop();
        mMaxVelocity = vc.getScaledMaximumFlingVelocity();
        mMinVelocity = vc.getScaledMinimumFlingVelocity();
        mScroller = ScrollerCompat.create(context, sInterpolator);
    }

    /**
     * Set the minimum velocity that will be detected as having a magnitude greater than zero
     * in pixels per second. Callback methods accepting a velocity will be clamped appropriately.
     *
     * @param minVel Minimum velocity to detect
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.741 -0400", hash_original_method = "E8C4C797E43D83501D2BDBC317F1285A", hash_generated_method = "B7FB6912999C5D2DFC953D3F9B57396A")
    
public void setMinVelocity(float minVel) {
        mMinVelocity = minVel;
    }

    /**
     * Return the currently configured minimum velocity. Any flings with a magnitude less
     * than this value in pixels per second. Callback methods accepting a velocity will receive
     * zero as a velocity value if the real detected velocity was below this threshold.
     *
     * @return the minimum velocity that will be detected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.743 -0400", hash_original_method = "1ADE600E5D347B7062C43308AF7785C9", hash_generated_method = "3F91935DC15A8316C4020B60A0EBAFF6")
    
public float getMinVelocity() {
        return mMinVelocity;
    }

    /**
     * Retrieve the current drag state of this helper. This will return one of
     * {@link #STATE_IDLE}, {@link #STATE_DRAGGING} or {@link #STATE_SETTLING}.
     * @return The current drag state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.746 -0400", hash_original_method = "E4EF7246572B936797136AEE1F048FD1", hash_generated_method = "0C1C0C7EC1239D8F49FFEDD7C0159ED1")
    
public int getViewDragState() {
        return mDragState;
    }

    /**
     * Enable edge tracking for the selected edges of the parent view.
     * The callback's {@link Callback#onEdgeTouched(int, int)} and
     * {@link Callback#onEdgeDragStarted(int, int)} methods will only be invoked
     * for edges for which edge tracking has been enabled.
     *
     * @param edgeFlags Combination of edge flags describing the edges to watch
     * @see #EDGE_LEFT
     * @see #EDGE_TOP
     * @see #EDGE_RIGHT
     * @see #EDGE_BOTTOM
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.749 -0400", hash_original_method = "76566CAD9CCD9760002FEFEB902E0C15", hash_generated_method = "F331BB89CD785132BD7B30C4CBC00899")
    
public void setEdgeTrackingEnabled(int edgeFlags) {
        mTrackingEdges = edgeFlags;
    }

    /**
     * Return the size of an edge. This is the range in pixels along the edges of this view
     * that will actively detect edge touches or drags if edge tracking is enabled.
     *
     * @return The size of an edge in pixels
     * @see #setEdgeTrackingEnabled(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.751 -0400", hash_original_method = "46DC0068B02226A73B5E98178BD7F6A7", hash_generated_method = "31CE2EFD6ECF8B84C99C4A72D88B8D20")
    
public int getEdgeSize() {
        return mEdgeSize;
    }

    /**
     * Capture a specific child view for dragging within the parent. The callback will be notified
     * but {@link Callback#tryCaptureView(android.view.View, int)} will not be asked permission to
     * capture this view.
     *
     * @param childView Child view to capture
     * @param activePointerId ID of the pointer that is dragging the captured child view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.755 -0400", hash_original_method = "27DE1720FBB9077D7C36537FA42151E9", hash_generated_method = "45D2465276E89439717B11D542C86153")
    
public void captureChildView(View childView, int activePointerId) {
        if (childView.getParent() != mParentView) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant " +
                    "of the ViewDragHelper's tracked parent view (" + mParentView + ")");
        }

        mCapturedView = childView;
        mActivePointerId = activePointerId;
        mCallback.onViewCaptured(childView, activePointerId);
        setDragState(STATE_DRAGGING);
    }

    /**
     * @return The currently captured view, or null if no view has been captured.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.758 -0400", hash_original_method = "526E805457C8186076C6E2687C93A6C9", hash_generated_method = "2F6379AD91D39A7967EE56D5A0CFAB2D")
    
public View getCapturedView() {
        return mCapturedView;
    }

    /**
     * @return The ID of the pointer currently dragging the captured view,
     *         or {@link #INVALID_POINTER}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.760 -0400", hash_original_method = "9A023C5205134013948062EBCEDDC8D7", hash_generated_method = "FA0D840358F191032380087F79BC98D2")
    
public int getActivePointerId() {
        return mActivePointerId;
    }

    /**
     * @return The minimum distance in pixels that the user must travel to initiate a drag
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.763 -0400", hash_original_method = "67F0F180E3003B6190889A1BC2F20399", hash_generated_method = "34B4AA9E73036073A5C48AA13354B59F")
    
public int getTouchSlop() {
        return mTouchSlop;
    }

    /**
     * The result of a call to this method is equivalent to
     * {@link #processTouchEvent(android.view.MotionEvent)} receiving an ACTION_CANCEL event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.767 -0400", hash_original_method = "90B19D2E471FDC8DB0C0249BB8FDFF3A", hash_generated_method = "8939C01F1E74AEFD73557939BC4DEE84")
    
public void cancel() {
        mActivePointerId = INVALID_POINTER;
        clearMotionHistory();

        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    /**
     * {@link #cancel()}, but also abort all motion in progress and snap to the end of any
     * animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.770 -0400", hash_original_method = "5385E4239F3271644C59EADEBA07CF81", hash_generated_method = "89E5125952CF29342E63AA0FFB63A490")
    
public void abort() {
        cancel();
        if (mDragState == STATE_SETTLING) {
            final int oldX = mScroller.getCurrX();
            final int oldY = mScroller.getCurrY();
            mScroller.abortAnimation();
            final int newX = mScroller.getCurrX();
            final int newY = mScroller.getCurrY();
            mCallback.onViewPositionChanged(mCapturedView, newX, newY, newX - oldX, newY - oldY);
        }
        setDragState(STATE_IDLE);
    }

    /**
     * Animate the view <code>child</code> to the given (left, top) position.
     * If this method returns true, the caller should invoke {@link #continueSettling(boolean)}
     * on each subsequent frame to continue the motion until it returns false. If this method
     * returns false there is no further work to do to complete the movement.
     *
     * <p>This operation does not count as a capture event, though {@link #getCapturedView()}
     * will still report the sliding view while the slide is in progress.</p>
     *
     * @param child Child view to capture and animate
     * @param finalLeft Final left position of child
     * @param finalTop Final top position of child
     * @return true if animation should continue through {@link #continueSettling(boolean)} calls
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.773 -0400", hash_original_method = "6E3E98490637FF01A45DBA85DD1FA457", hash_generated_method = "A6C0484D003B2D88B802909C76F338DC")
    
public boolean smoothSlideViewTo(View child, int finalLeft, int finalTop) {
        mCapturedView = child;
        mActivePointerId = INVALID_POINTER;

        return forceSettleCapturedViewAt(finalLeft, finalTop, 0, 0);
    }

    /**
     * Settle the captured view at the given (left, top) position.
     * The appropriate velocity from prior motion will be taken into account.
     * If this method returns true, the caller should invoke {@link #continueSettling(boolean)}
     * on each subsequent frame to continue the motion until it returns false. If this method
     * returns false there is no further work to do to complete the movement.
     *
     * @param finalLeft Settled left edge position for the captured view
     * @param finalTop Settled top edge position for the captured view
     * @return true if animation should continue through {@link #continueSettling(boolean)} calls
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.777 -0400", hash_original_method = "DC5DD3FA625D12E26CD7D9E8DE8C2BEF", hash_generated_method = "4AE4ABE0AB906C6AFBC9ED2ADB64D53C")
    
public boolean settleCapturedViewAt(int finalLeft, int finalTop) {
        if (!mReleaseInProgress) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to " +
                    "Callback#onViewReleased");
        }

        return forceSettleCapturedViewAt(finalLeft, finalTop,
                (int) VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId),
                (int) VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId));
    }

    /**
     * Settle the captured view at the given (left, top) position.
     *
     * @param finalLeft Target left position for the captured view
     * @param finalTop Target top position for the captured view
     * @param xvel Horizontal velocity
     * @param yvel Vertical velocity
     * @return true if animation should continue through {@link #continueSettling(boolean)} calls
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.780 -0400", hash_original_method = "D8DF325A92DA35A7699993005814FDB6", hash_generated_method = "485718728B6DB63FF299DA842E059316")
    
private boolean forceSettleCapturedViewAt(int finalLeft, int finalTop, int xvel, int yvel) {
        final int startLeft = mCapturedView.getLeft();
        final int startTop = mCapturedView.getTop();
        final int dx = finalLeft - startLeft;
        final int dy = finalTop - startTop;

        if (dx == 0 && dy == 0) {
            // Nothing to do. Send callbacks, be done.
            mScroller.abortAnimation();
            setDragState(STATE_IDLE);
            return false;
        }

        final int duration = computeSettleDuration(mCapturedView, dx, dy, xvel, yvel);
        mScroller.startScroll(startLeft, startTop, dx, dy, duration);

        setDragState(STATE_SETTLING);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.784 -0400", hash_original_method = "E1C48CF133A2F88038AA69B8C20BB348", hash_generated_method = "15464160EC8CB48E7305CEDD20862160")
    
private int computeSettleDuration(View child, int dx, int dy, int xvel, int yvel) {
        xvel = clampMag(xvel, (int) mMinVelocity, (int) mMaxVelocity);
        yvel = clampMag(yvel, (int) mMinVelocity, (int) mMaxVelocity);
        final int absDx = Math.abs(dx);
        final int absDy = Math.abs(dy);
        final int absXVel = Math.abs(xvel);
        final int absYVel = Math.abs(yvel);
        final int addedVel = absXVel + absYVel;
        final int addedDistance = absDx + absDy;

        final float xweight = xvel != 0 ? (float) absXVel / addedVel :
                (float) absDx / addedDistance;
        final float yweight = yvel != 0 ? (float) absYVel / addedVel :
                (float) absDy / addedDistance;

        int xduration = computeAxisDuration(dx, xvel, mCallback.getViewHorizontalDragRange(child));
        int yduration = computeAxisDuration(dy, yvel, mCallback.getViewVerticalDragRange(child));

        return (int) (xduration * xweight + yduration * yweight);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.788 -0400", hash_original_method = "B3DBC9C7848D341739D04FAC1432D3EF", hash_generated_method = "C4B224E9FCC7A87B87AFE34586EE9911")
    
private int computeAxisDuration(int delta, int velocity, int motionRange) {
        if (delta == 0) {
            return 0;
        }

        final int width = mParentView.getWidth();
        final int halfWidth = width / 2;
        final float distanceRatio = Math.min(1f, (float) Math.abs(delta) / width);
        final float distance = halfWidth + halfWidth *
                distanceInfluenceForSnapDuration(distanceRatio);

        int duration;
        velocity = Math.abs(velocity);
        if (velocity > 0) {
            duration = 4 * Math.round(1000 * Math.abs(distance / velocity));
        } else {
            final float range = (float) Math.abs(delta) / motionRange;
            duration = (int) ((range + 1) * BASE_SETTLE_DURATION);
        }
        return Math.min(duration, MAX_SETTLE_DURATION);
    }

    /**
     * Clamp the magnitude of value for absMin and absMax.
     * If the value is below the minimum, it will be clamped to zero.
     * If the value is above the maximum, it will be clamped to the maximum.
     *
     * @param value Value to clamp
     * @param absMin Absolute value of the minimum significant value to return
     * @param absMax Absolute value of the maximum value to return
     * @return The clamped value with the same sign as <code>value</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.792 -0400", hash_original_method = "1397CD8195531E66C8C5DBEC807C1BCF", hash_generated_method = "49298495639897DB11EED566786901E6")
    
private int clampMag(int value, int absMin, int absMax) {
        final int absValue = Math.abs(value);
        if (absValue < absMin) return 0;
        if (absValue > absMax) return value > 0 ? absMax : -absMax;
        return value;
    }

    /**
     * Clamp the magnitude of value for absMin and absMax.
     * If the value is below the minimum, it will be clamped to zero.
     * If the value is above the maximum, it will be clamped to the maximum.
     *
     * @param value Value to clamp
     * @param absMin Absolute value of the minimum significant value to return
     * @param absMax Absolute value of the maximum value to return
     * @return The clamped value with the same sign as <code>value</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.795 -0400", hash_original_method = "B561BAA277FA985E39026CCF285D3600", hash_generated_method = "4E6A4845482AB54617F6F0CD193F252D")
    
private float clampMag(float value, float absMin, float absMax) {
        final float absValue = Math.abs(value);
        if (absValue < absMin) return 0;
        if (absValue > absMax) return value > 0 ? absMax : -absMax;
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.798 -0400", hash_original_method = "3937E06E79A8643FB4C5C1D74E3AE99C", hash_generated_method = "433BDABF6A3BE98DDED842628BE09CD1")
    
private float distanceInfluenceForSnapDuration(float f) {
        f -= 0.5f; // center the values about 0.
        f *= 0.3f * Math.PI / 2.0f;
        return (float) Math.sin(f);
    }

    /**
     * Settle the captured view based on standard free-moving fling behavior.
     * The caller should invoke {@link #continueSettling(boolean)} on each subsequent frame
     * to continue the motion until it returns false.
     *
     * @param minLeft Minimum X position for the view's left edge
     * @param minTop Minimum Y position for the view's top edge
     * @param maxLeft Maximum X position for the view's left edge
     * @param maxTop Maximum Y position for the view's top edge
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.802 -0400", hash_original_method = "72607D3085D987A476884A0F5063B6FF", hash_generated_method = "E7191BB04E521607E953182846249BD3")
    
public void flingCapturedView(int minLeft, int minTop, int maxLeft, int maxTop) {
        if (!mReleaseInProgress) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to " +
                    "Callback#onViewReleased");
        }

        mScroller.fling(mCapturedView.getLeft(), mCapturedView.getTop(),
                (int) VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId),
                (int) VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId),
                minLeft, maxLeft, minTop, maxTop);

        setDragState(STATE_SETTLING);
    }

    /**
     * Move the captured settling view by the appropriate amount for the current time.
     * If <code>continueSettling</code> returns true, the caller should call it again
     * on the next frame to continue.
     *
     * @param deferCallbacks true if state callbacks should be deferred via posted message.
     *                       Set this to true if you are calling this method from
     *                       {@link android.view.View#computeScroll()} or similar methods
     *                       invoked as part of layout or drawing.
     * @return true if settle is still in progress
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.806 -0400", hash_original_method = "A155A691C0FBE2504B6AFAA0D213FAF0", hash_generated_method = "F2F2BA42690A123B32FF48A312D4D6CE")
    
public boolean continueSettling(boolean deferCallbacks) {
        if (mDragState == STATE_SETTLING) {
            boolean keepGoing = mScroller.computeScrollOffset();
            final int x = mScroller.getCurrX();
            final int y = mScroller.getCurrY();
            final int dx = x - mCapturedView.getLeft();
            final int dy = y - mCapturedView.getTop();

            if (dx != 0) {
                mCapturedView.offsetLeftAndRight(dx);
            }
            if (dy != 0) {
                mCapturedView.offsetTopAndBottom(dy);
            }

            if (dx != 0 || dy != 0) {
                mCallback.onViewPositionChanged(mCapturedView, x, y, dx, dy);
            }

            if (keepGoing && x == mScroller.getFinalX() && y == mScroller.getFinalY()) {
                // Close enough. The interpolator/scroller might think we're still moving
                // but the user sure doesn't.
                mScroller.abortAnimation();
                keepGoing = mScroller.isFinished();
            }

            if (!keepGoing) {
                if (deferCallbacks) {
                    mParentView.post(mSetIdleRunnable);
                } else {
                    setDragState(STATE_IDLE);
                }
            }
        }

        return mDragState == STATE_SETTLING;
    }

    /**
     * Like all callback events this must happen on the UI thread, but release
     * involves some extra semantics. During a release (mReleaseInProgress)
     * is the only time it is valid to call {@link #settleCapturedViewAt(int, int)}
     * or {@link #flingCapturedView(int, int, int, int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.811 -0400", hash_original_method = "D237D6A9644B9C4EF87601649DFEF242", hash_generated_method = "88CC909B844D5C22ED8CA3B5680B5B18")
    
private void dispatchViewReleased(float xvel, float yvel) {
        mReleaseInProgress = true;
        mCallback.onViewReleased(mCapturedView, xvel, yvel);
        mReleaseInProgress = false;

        if (mDragState == STATE_DRAGGING) {
            // onViewReleased didn't call a method that would have changed this. Go idle.
            setDragState(STATE_IDLE);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.816 -0400", hash_original_method = "E101CD32243E068D9BF1749492F39FEB", hash_generated_method = "C23BA8FB6AFF17E6CD491CFA1D3F1241")
    
private void clearMotionHistory() {
        if (mInitialMotionX == null) {
            return;
        }
        Arrays.fill(mInitialMotionX, 0);
        Arrays.fill(mInitialMotionY, 0);
        Arrays.fill(mLastMotionX, 0);
        Arrays.fill(mLastMotionY, 0);
        Arrays.fill(mInitialEdgesTouched, 0);
        Arrays.fill(mEdgeDragsInProgress, 0);
        Arrays.fill(mEdgeDragsLocked, 0);
        mPointersDown = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.820 -0400", hash_original_method = "1E99DE22CCE0D4C624DDCF93B2B3B59F", hash_generated_method = "19E939297262BD66EC0C71892FEB86F1")
    
private void clearMotionHistory(int pointerId) {
        if (mInitialMotionX == null) {
            return;
        }
        mInitialMotionX[pointerId] = 0;
        mInitialMotionY[pointerId] = 0;
        mLastMotionX[pointerId] = 0;
        mLastMotionY[pointerId] = 0;
        mInitialEdgesTouched[pointerId] = 0;
        mEdgeDragsInProgress[pointerId] = 0;
        mEdgeDragsLocked[pointerId] = 0;
        mPointersDown &= ~(1 << pointerId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.827 -0400", hash_original_method = "17F61FBA30C4A3DA0F91DE2758313E0B", hash_generated_method = "2FFA5F423492401BDF43E690510C6727")
    
private void ensureMotionHistorySizeForId(int pointerId) {
        if (mInitialMotionX == null || mInitialMotionX.length <= pointerId) {
            float[] imx = new float[pointerId + 1];
            float[] imy = new float[pointerId + 1];
            float[] lmx = new float[pointerId + 1];
            float[] lmy = new float[pointerId + 1];
            int[] iit = new int[pointerId + 1];
            int[] edip = new int[pointerId + 1];
            int[] edl = new int[pointerId + 1];

            if (mInitialMotionX != null) {
                System.arraycopy(mInitialMotionX, 0, imx, 0, mInitialMotionX.length);
                System.arraycopy(mInitialMotionY, 0, imy, 0, mInitialMotionY.length);
                System.arraycopy(mLastMotionX, 0, lmx, 0, mLastMotionX.length);
                System.arraycopy(mLastMotionY, 0, lmy, 0, mLastMotionY.length);
                System.arraycopy(mInitialEdgesTouched, 0, iit, 0, mInitialEdgesTouched.length);
                System.arraycopy(mEdgeDragsInProgress, 0, edip, 0, mEdgeDragsInProgress.length);
                System.arraycopy(mEdgeDragsLocked, 0, edl, 0, mEdgeDragsLocked.length);
            }

            mInitialMotionX = imx;
            mInitialMotionY = imy;
            mLastMotionX = lmx;
            mLastMotionY = lmy;
            mInitialEdgesTouched = iit;
            mEdgeDragsInProgress = edip;
            mEdgeDragsLocked = edl;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.830 -0400", hash_original_method = "0C8C63071FDCAD579BDD2D27FD00EF4A", hash_generated_method = "47F7FEC63CB86AF7A483F97480FD34AB")
    
private void saveInitialMotion(float x, float y, int pointerId) {
        ensureMotionHistorySizeForId(pointerId);
        mInitialMotionX[pointerId] = mLastMotionX[pointerId] = x;
        mInitialMotionY[pointerId] = mLastMotionY[pointerId] = y;
        mInitialEdgesTouched[pointerId] = getEdgesTouched((int) x, (int) y);
        mPointersDown |= 1 << pointerId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.833 -0400", hash_original_method = "B6E8823632287C974BAA792F08A356F1", hash_generated_method = "49068F2C03A3F0DDD919E55FBCF3BAC9")
    
private void saveLastMotion(MotionEvent ev) {
        final int pointerCount = MotionEventCompat.getPointerCount(ev);
        for (int i = 0; i < pointerCount; i++) {
            final int pointerId = MotionEventCompat.getPointerId(ev, i);
            final float x = MotionEventCompat.getX(ev, i);
            final float y = MotionEventCompat.getY(ev, i);
            mLastMotionX[pointerId] = x;
            mLastMotionY[pointerId] = y;
        }
    }

    /**
     * Check if the given pointer ID represents a pointer that is currently down (to the best
     * of the ViewDragHelper's knowledge).
     *
     * <p>The state used to report this information is populated by the methods
     * {@link #shouldInterceptTouchEvent(android.view.MotionEvent)} or
     * {@link #processTouchEvent(android.view.MotionEvent)}. If one of these methods has not
     * been called for all relevant MotionEvents to track, the information reported
     * by this method may be stale or incorrect.</p>
     *
     * @param pointerId pointer ID to check; corresponds to IDs provided by MotionEvent
     * @return true if the pointer with the given ID is still down
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.835 -0400", hash_original_method = "4D7B8BABE5479CBD45B0C5C3F099583B", hash_generated_method = "525834005EB3034EB5FD56D005C21B5B")
    
public boolean isPointerDown(int pointerId) {
        return (mPointersDown & 1 << pointerId) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.839 -0400", hash_original_method = "42B26F76D064E1CB49EBEF91D2806964", hash_generated_method = "42B26F76D064E1CB49EBEF91D2806964")
    
void setDragState(int state) {
        if (mDragState != state) {
            mDragState = state;
            mCallback.onViewDragStateChanged(state);
            if (state == STATE_IDLE) {
                mCapturedView = null;
            }
        }
    }

    /**
     * Attempt to capture the view with the given pointer ID. The callback will be involved.
     * This will put us into the "dragging" state. If we've already captured this view with
     * this pointer this method will immediately return true without consulting the callback.
     *
     * @param toCapture View to capture
     * @param pointerId Pointer to capture with
     * @return true if capture was successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.842 -0400", hash_original_method = "6FCBAD4CB98AAC5D3DB8D101EBD98142", hash_generated_method = "20C534E2969807B2274A5948932431FC")
    
boolean tryCaptureViewForDrag(View toCapture, int pointerId) {
        if (toCapture == mCapturedView && mActivePointerId == pointerId) {
            // Already done!
            return true;
        }
        if (toCapture != null && mCallback.tryCaptureView(toCapture, pointerId)) {
            mActivePointerId = pointerId;
            captureChildView(toCapture, pointerId);
            return true;
        }
        return false;
    }

    /**
     * Tests scrollability within child views of v given a delta of dx.
     *
     * @param v View to test for horizontal scrollability
     * @param checkV Whether the view v passed should itself be checked for scrollability (true),
     *               or just its children (false).
     * @param dx Delta scrolled in pixels along the X axis
     * @param dy Delta scrolled in pixels along the Y axis
     * @param x X coordinate of the active touch point
     * @param y Y coordinate of the active touch point
     * @return true if child views of v can be scrolled by delta of dx.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.846 -0400", hash_original_method = "360FA36BEDAE47804B142680C4E8EBC0", hash_generated_method = "1E38F031FBFE4E1AD1583DFD60082ADA")
    
protected boolean canScroll(View v, boolean checkV, int dx, int dy, int x, int y) {
        if (v instanceof ViewGroup) {
            final ViewGroup group = (ViewGroup) v;
            final int scrollX = v.getScrollX();
            final int scrollY = v.getScrollY();
            final int count = group.getChildCount();
            // Count backwards - let topmost views consume scroll distance first.
            for (int i = count - 1; i >= 0; i--) {
                // TODO: Add versioned support here for transformed views.
                // This will not work for transformed views in Honeycomb+
                final View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() &&
                        y + scrollY >= child.getTop() && y + scrollY < child.getBottom() &&
                        canScroll(child, true, dx, dy, x + scrollX - child.getLeft(),
                                y + scrollY - child.getTop())) {
                    return true;
                }
            }
        }

        return checkV && (ViewCompat.canScrollHorizontally(v, -dx) ||
                ViewCompat.canScrollVertically(v, -dy));
    }

    /**
     * Check if this event as provided to the parent view's onInterceptTouchEvent should
     * cause the parent to intercept the touch event stream.
     *
     * @param ev MotionEvent provided to onInterceptTouchEvent
     * @return true if the parent view should return true from onInterceptTouchEvent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.852 -0400", hash_original_method = "479C5198C8AAB5B715FD1473007840B3", hash_generated_method = "5FCBD86E9DBE3F8D43E4FE112DF01D20")
    
public boolean shouldInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        final int actionIndex = MotionEventCompat.getActionIndex(ev);

        if (action == MotionEvent.ACTION_DOWN) {
            // Reset things for a new event stream, just in case we didn't get
            // the whole previous stream.
            cancel();
        }

        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                final float y = ev.getY();
                final int pointerId = MotionEventCompat.getPointerId(ev, 0);
                saveInitialMotion(x, y, pointerId);

                final View toCapture = findTopChildUnder((int) x, (int) y);

                // Catch a settling view if possible.
                if (toCapture == mCapturedView && mDragState == STATE_SETTLING) {
                    tryCaptureViewForDrag(toCapture, pointerId);
                }

                final int edgesTouched = mInitialEdgesTouched[pointerId];
                if ((edgesTouched & mTrackingEdges) != 0) {
                    mCallback.onEdgeTouched(edgesTouched & mTrackingEdges, pointerId);
                }
                break;
            }

            case MotionEventCompat.ACTION_POINTER_DOWN: {
                final int pointerId = MotionEventCompat.getPointerId(ev, actionIndex);
                final float x = MotionEventCompat.getX(ev, actionIndex);
                final float y = MotionEventCompat.getY(ev, actionIndex);

                saveInitialMotion(x, y, pointerId);

                // A ViewDragHelper can only manipulate one view at a time.
                if (mDragState == STATE_IDLE) {
                    final int edgesTouched = mInitialEdgesTouched[pointerId];
                    if ((edgesTouched & mTrackingEdges) != 0) {
                        mCallback.onEdgeTouched(edgesTouched & mTrackingEdges, pointerId);
                    }
                } else if (mDragState == STATE_SETTLING) {
                    // Catch a settling view if possible.
                    final View toCapture = findTopChildUnder((int) x, (int) y);
                    if (toCapture == mCapturedView) {
                        tryCaptureViewForDrag(toCapture, pointerId);
                    }
                }
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                // First to cross a touch slop over a draggable view wins. Also report edge drags.
                final int pointerCount = MotionEventCompat.getPointerCount(ev);
                for (int i = 0; i < pointerCount; i++) {
                    final int pointerId = MotionEventCompat.getPointerId(ev, i);
                    final float x = MotionEventCompat.getX(ev, i);
                    final float y = MotionEventCompat.getY(ev, i);
                    final float dx = x - mInitialMotionX[pointerId];
                    final float dy = y - mInitialMotionY[pointerId];

                    reportNewEdgeDrags(dx, dy, pointerId);
                    if (mDragState == STATE_DRAGGING) {
                        // Callback might have started an edge drag
                        break;
                    }

                    final View toCapture = findTopChildUnder((int) x, (int) y);
                    if (toCapture != null && checkTouchSlop(toCapture, dx, dy) &&
                            tryCaptureViewForDrag(toCapture, pointerId)) {
                        break;
                    }
                }
                saveLastMotion(ev);
                break;
            }

            case MotionEventCompat.ACTION_POINTER_UP: {
                final int pointerId = MotionEventCompat.getPointerId(ev, actionIndex);
                clearMotionHistory(pointerId);
                break;
            }

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                cancel();
                break;
            }
        }

        return mDragState == STATE_DRAGGING;
    }

    /**
     * Process a touch event received by the parent view. This method will dispatch callback events
     * as needed before returning. The parent view's onTouchEvent implementation should call this.
     *
     * @param ev The touch event received by the parent view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.859 -0400", hash_original_method = "1E1CFA810F5EB34DDE6D0C49CB713F3E", hash_generated_method = "4867C30B5DE9852E28FECAE0F1219194")
    
public void processTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        final int actionIndex = MotionEventCompat.getActionIndex(ev);

        if (action == MotionEvent.ACTION_DOWN) {
            // Reset things for a new event stream, just in case we didn't get
            // the whole previous stream.
            cancel();
        }

        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                final float y = ev.getY();
                final int pointerId = MotionEventCompat.getPointerId(ev, 0);
                final View toCapture = findTopChildUnder((int) x, (int) y);

                saveInitialMotion(x, y, pointerId);

                // Since the parent is already directly processing this touch event,
                // there is no reason to delay for a slop before dragging.
                // Start immediately if possible.
                tryCaptureViewForDrag(toCapture, pointerId);

                final int edgesTouched = mInitialEdgesTouched[pointerId];
                if ((edgesTouched & mTrackingEdges) != 0) {
                    mCallback.onEdgeTouched(edgesTouched & mTrackingEdges, pointerId);
                }
                break;
            }

            case MotionEventCompat.ACTION_POINTER_DOWN: {
                final int pointerId = MotionEventCompat.getPointerId(ev, actionIndex);
                final float x = MotionEventCompat.getX(ev, actionIndex);
                final float y = MotionEventCompat.getY(ev, actionIndex);

                saveInitialMotion(x, y, pointerId);

                // A ViewDragHelper can only manipulate one view at a time.
                if (mDragState == STATE_IDLE) {
                    // If we're idle we can do anything! Treat it like a normal down event.

                    final View toCapture = findTopChildUnder((int) x, (int) y);
                    tryCaptureViewForDrag(toCapture, pointerId);

                    final int edgesTouched = mInitialEdgesTouched[pointerId];
                    if ((edgesTouched & mTrackingEdges) != 0) {
                        mCallback.onEdgeTouched(edgesTouched & mTrackingEdges, pointerId);
                    }
                } else if (isCapturedViewUnder((int) x, (int) y)) {
                    // We're still tracking a captured view. If the same view is under this
                    // point, we'll swap to controlling it with this pointer instead.
                    // (This will still work if we're "catching" a settling view.)

                    tryCaptureViewForDrag(mCapturedView, pointerId);
                }
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                if (mDragState == STATE_DRAGGING) {
                    final int index = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
                    final float x = MotionEventCompat.getX(ev, index);
                    final float y = MotionEventCompat.getY(ev, index);
                    final int idx = (int) (x - mLastMotionX[mActivePointerId]);
                    final int idy = (int) (y - mLastMotionY[mActivePointerId]);

                    dragTo(mCapturedView.getLeft() + idx, mCapturedView.getTop() + idy, idx, idy);

                    saveLastMotion(ev);
                } else {
                    // Check to see if any pointer is now over a draggable view.
                    final int pointerCount = MotionEventCompat.getPointerCount(ev);
                    for (int i = 0; i < pointerCount; i++) {
                        final int pointerId = MotionEventCompat.getPointerId(ev, i);
                        final float x = MotionEventCompat.getX(ev, i);
                        final float y = MotionEventCompat.getY(ev, i);
                        final float dx = x - mInitialMotionX[pointerId];
                        final float dy = y - mInitialMotionY[pointerId];

                        reportNewEdgeDrags(dx, dy, pointerId);
                        if (mDragState == STATE_DRAGGING) {
                            // Callback might have started an edge drag.
                            break;
                        }

                        final View toCapture = findTopChildUnder((int) x, (int) y);
                        if (checkTouchSlop(toCapture, dx, dy) &&
                                tryCaptureViewForDrag(toCapture, pointerId)) {
                            break;
                        }
                    }
                    saveLastMotion(ev);
                }
                break;
            }

            case MotionEventCompat.ACTION_POINTER_UP: {
                final int pointerId = MotionEventCompat.getPointerId(ev, actionIndex);
                if (mDragState == STATE_DRAGGING && pointerId == mActivePointerId) {
                    // Try to find another pointer that's still holding on to the captured view.
                    int newActivePointer = INVALID_POINTER;
                    final int pointerCount = MotionEventCompat.getPointerCount(ev);
                    for (int i = 0; i < pointerCount; i++) {
                        final int id = MotionEventCompat.getPointerId(ev, i);
                        if (id == mActivePointerId) {
                            // This one's going away, skip.
                            continue;
                        }

                        final float x = MotionEventCompat.getX(ev, i);
                        final float y = MotionEventCompat.getY(ev, i);
                        if (findTopChildUnder((int) x, (int) y) == mCapturedView &&
                                tryCaptureViewForDrag(mCapturedView, id)) {
                            newActivePointer = mActivePointerId;
                            break;
                        }
                    }

                    if (newActivePointer == INVALID_POINTER) {
                        // We didn't find another pointer still touching the view, release it.
                        releaseViewForPointerUp();
                    }
                }
                clearMotionHistory(pointerId);
                break;
            }

            case MotionEvent.ACTION_UP: {
                if (mDragState == STATE_DRAGGING) {
                    releaseViewForPointerUp();
                }
                cancel();
                break;
            }

            case MotionEvent.ACTION_CANCEL: {
                if (mDragState == STATE_DRAGGING) {
                    dispatchViewReleased(0, 0);
                }
                cancel();
                break;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.863 -0400", hash_original_method = "A47BEB2EEFCF9A9B3EF96D98DEBD5E9F", hash_generated_method = "949469AC419266E82EF0F4467FB91950")
    
private void reportNewEdgeDrags(float dx, float dy, int pointerId) {
        int dragsStarted = 0;
        if (checkNewEdgeDrag(dx, dy, pointerId, EDGE_LEFT)) {
            dragsStarted |= EDGE_LEFT;
        }
        if (checkNewEdgeDrag(dy, dx, pointerId, EDGE_TOP)) {
            dragsStarted |= EDGE_TOP;
        }
        if (checkNewEdgeDrag(dx, dy, pointerId, EDGE_RIGHT)) {
            dragsStarted |= EDGE_RIGHT;
        }
        if (checkNewEdgeDrag(dy, dx, pointerId, EDGE_BOTTOM)) {
            dragsStarted |= EDGE_BOTTOM;
        }

        if (dragsStarted != 0) {
            mEdgeDragsInProgress[pointerId] |= dragsStarted;
            mCallback.onEdgeDragStarted(dragsStarted, pointerId);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.868 -0400", hash_original_method = "DA719FAD2308D1AA2EB906A6123DFBDF", hash_generated_method = "088B0B0E6523FCC6A5AAC4D5930F3715")
    
private boolean checkNewEdgeDrag(float delta, float odelta, int pointerId, int edge) {
        final float absDelta = Math.abs(delta);
        final float absODelta = Math.abs(odelta);

        if ((mInitialEdgesTouched[pointerId] & edge) != edge  || (mTrackingEdges & edge) == 0 ||
                (mEdgeDragsLocked[pointerId] & edge) == edge ||
                (mEdgeDragsInProgress[pointerId] & edge) == edge ||
                (absDelta <= mTouchSlop && absODelta <= mTouchSlop)) {
            return false;
        }
        if (absDelta < absODelta * 0.5f && mCallback.onEdgeLock(edge)) {
            mEdgeDragsLocked[pointerId] |= edge;
            return false;
        }
        return (mEdgeDragsInProgress[pointerId] & edge) == 0 && absDelta > mTouchSlop;
    }

    /**
     * Check if we've crossed a reasonable touch slop for the given child view.
     * If the child cannot be dragged along the horizontal or vertical axis, motion
     * along that axis will not count toward the slop check.
     *
     * @param child Child to check
     * @param dx Motion since initial position along X axis
     * @param dy Motion since initial position along Y axis
     * @return true if the touch slop has been crossed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.872 -0400", hash_original_method = "301FE2FB85D24B4A76E319E2DD66021A", hash_generated_method = "884192727B86385C25E0FCE2C8651E64")
    
private boolean checkTouchSlop(View child, float dx, float dy) {
        if (child == null) {
            return false;
        }
        final boolean checkHorizontal = mCallback.getViewHorizontalDragRange(child) > 0;
        final boolean checkVertical = mCallback.getViewVerticalDragRange(child) > 0;

        if (checkHorizontal && checkVertical) {
            return dx * dx + dy * dy > mTouchSlop * mTouchSlop;
        } else if (checkHorizontal) {
            return Math.abs(dx) > mTouchSlop;
        } else if (checkVertical) {
            return Math.abs(dy) > mTouchSlop;
        }
        return false;
    }

    /**
     * Check if any pointer tracked in the current gesture has crossed
     * the required slop threshold.
     *
     * <p>This depends on internal state populated by
     * {@link #shouldInterceptTouchEvent(android.view.MotionEvent)} or
     * {@link #processTouchEvent(android.view.MotionEvent)}. You should only rely on
     * the results of this method after all currently available touch data
     * has been provided to one of these two methods.</p>
     *
     * @param directions Combination of direction flags, see {@link #DIRECTION_HORIZONTAL},
     *                   {@link #DIRECTION_VERTICAL}, {@link #DIRECTION_ALL}
     * @return true if the slop threshold has been crossed, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.877 -0400", hash_original_method = "FF38D43683E269D97B49F81E25478615", hash_generated_method = "0E4F8F02DA6723E5DF7BC478D47A8659")
    
public boolean checkTouchSlop(int directions) {
        final int count = mInitialMotionX.length;
        for (int i = 0; i < count; i++) {
            if (checkTouchSlop(directions, i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the specified pointer tracked in the current gesture has crossed
     * the required slop threshold.
     *
     * <p>This depends on internal state populated by
     * {@link #shouldInterceptTouchEvent(android.view.MotionEvent)} or
     * {@link #processTouchEvent(android.view.MotionEvent)}. You should only rely on
     * the results of this method after all currently available touch data
     * has been provided to one of these two methods.</p>
     *
     * @param directions Combination of direction flags, see {@link #DIRECTION_HORIZONTAL},
     *                   {@link #DIRECTION_VERTICAL}, {@link #DIRECTION_ALL}
     * @param pointerId ID of the pointer to slop check as specified by MotionEvent
     * @return true if the slop threshold has been crossed, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.881 -0400", hash_original_method = "98BE65B4E963E177593CBA4ADBA9257B", hash_generated_method = "C08ED5492D2D8BBE1DBC8A5EF358F554")
    
public boolean checkTouchSlop(int directions, int pointerId) {
        if (!isPointerDown(pointerId)) {
            return false;
        }

        final boolean checkHorizontal = (directions & DIRECTION_HORIZONTAL) == DIRECTION_HORIZONTAL;
        final boolean checkVertical = (directions & DIRECTION_VERTICAL) == DIRECTION_VERTICAL;

        final float dx = mLastMotionX[pointerId] - mInitialMotionX[pointerId];
        final float dy = mLastMotionY[pointerId] - mInitialMotionY[pointerId];

        if (checkHorizontal && checkVertical) {
            return dx * dx + dy * dy > mTouchSlop * mTouchSlop;
        } else if (checkHorizontal) {
            return Math.abs(dx) > mTouchSlop;
        } else if (checkVertical) {
            return Math.abs(dy) > mTouchSlop;
        }
        return false;
    }

    /**
     * Check if any of the edges specified were initially touched in the currently active gesture.
     * If there is no currently active gesture this method will return false.
     *
     * @param edges Edges to check for an initial edge touch. See {@link #EDGE_LEFT},
     *              {@link #EDGE_TOP}, {@link #EDGE_RIGHT}, {@link #EDGE_BOTTOM} and
     *              {@link #EDGE_ALL}
     * @return true if any of the edges specified were initially touched in the current gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.885 -0400", hash_original_method = "549B6BDD6202FEA398797B7763B1FDB7", hash_generated_method = "6F4D7CF685692B0B470DC96DC4F784A7")
    
public boolean isEdgeTouched(int edges) {
        final int count = mInitialEdgesTouched.length;
        for (int i = 0; i < count; i++) {
            if (isEdgeTouched(edges, i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if any of the edges specified were initially touched by the pointer with
     * the specified ID. If there is no currently active gesture or if there is no pointer with
     * the given ID currently down this method will return false.
     *
     * @param edges Edges to check for an initial edge touch. See {@link #EDGE_LEFT},
     *              {@link #EDGE_TOP}, {@link #EDGE_RIGHT}, {@link #EDGE_BOTTOM} and
     *              {@link #EDGE_ALL}
     * @return true if any of the edges specified were initially touched in the current gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.892 -0400", hash_original_method = "D27303B051D074658CE8DE54AD81806E", hash_generated_method = "3CD06AF5688C74D0075E929784B97AA5")
    
public boolean isEdgeTouched(int edges, int pointerId) {
        return isPointerDown(pointerId) && (mInitialEdgesTouched[pointerId] & edges) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.895 -0400", hash_original_method = "90DCE72FF1124FDC831DA1E2993C306B", hash_generated_method = "7CA0F038F94646F27759519A50CFCB4B")
    
private void releaseViewForPointerUp() {
        mVelocityTracker.computeCurrentVelocity(1000, mMaxVelocity);
        final float xvel = clampMag(
                VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId),
                mMinVelocity, mMaxVelocity);
        final float yvel = clampMag(
                VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId),
                mMinVelocity, mMaxVelocity);
        dispatchViewReleased(xvel, yvel);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.899 -0400", hash_original_method = "8CB1596AC7A5C9041A288E08B64ABEE9", hash_generated_method = "EDC3AA45A16F55FB627CED765306623A")
    
private void dragTo(int left, int top, int dx, int dy) {
        int clampedX = left;
        int clampedY = top;
        final int oldLeft = mCapturedView.getLeft();
        final int oldTop = mCapturedView.getTop();
        if (dx != 0) {
            clampedX = mCallback.clampViewPositionHorizontal(mCapturedView, left, dx);
            mCapturedView.offsetLeftAndRight(clampedX - oldLeft);
        }
        if (dy != 0) {
            clampedY = mCallback.clampViewPositionVertical(mCapturedView, top, dy);
            mCapturedView.offsetTopAndBottom(clampedY - oldTop);
        }

        if (dx != 0 || dy != 0) {
            final int clampedDx = clampedX - oldLeft;
            final int clampedDy = clampedY - oldTop;
            mCallback.onViewPositionChanged(mCapturedView, clampedX, clampedY,
                    clampedDx, clampedDy);
        }
    }

    /**
     * Determine if the currently captured view is under the given point in the
     * parent view's coordinate system. If there is no captured view this method
     * will return false.
     *
     * @param x X position to test in the parent's coordinate system
     * @param y Y position to test in the parent's coordinate system
     * @return true if the captured view is under the given point, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.902 -0400", hash_original_method = "1BE0595FF316A638DD7528D569263577", hash_generated_method = "90451322DE97BF807585B54EFAB69579")
    
public boolean isCapturedViewUnder(int x, int y) {
        return isViewUnder(mCapturedView, x, y);
    }

    /**
     * Determine if the supplied view is under the given point in the
     * parent view's coordinate system.
     *
     * @param view Child view of the parent to hit test
     * @param x X position to test in the parent's coordinate system
     * @param y Y position to test in the parent's coordinate system
     * @return true if the supplied view is under the given point, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.904 -0400", hash_original_method = "4A017A17A3F49AB2F6A7C3BC3B0FFD50", hash_generated_method = "86DD917E20F5DDC9C557F0A1D2C22537")
    
public boolean isViewUnder(View view, int x, int y) {
        if (view == null) {
            return false;
        }
        return x >= view.getLeft() &&
                x < view.getRight() &&
                y >= view.getTop() &&
                y < view.getBottom();
    }

    /**
     * Find the topmost child under the given point within the parent view's coordinate system.
     * The child order is determined using {@link Callback#getOrderedChildIndex(int)}.
     *
     * @param x X position to test in the parent's coordinate system
     * @param y Y position to test in the parent's coordinate system
     * @return The topmost child view under (x, y) or null if none found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.907 -0400", hash_original_method = "7A005296135FAB76F72C26AC55C0F80B", hash_generated_method = "9CF8EB8D86BEC15069331161CEA67A08")
    
public View findTopChildUnder(int x, int y) {
        final int childCount = mParentView.getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            final View child = mParentView.getChildAt(mCallback.getOrderedChildIndex(i));
            if (x >= child.getLeft() && x < child.getRight() &&
                    y >= child.getTop() && y < child.getBottom()) {
                return child;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:44.910 -0400", hash_original_method = "8F1B1AE00453E5F8FA89A3869E1A4329", hash_generated_method = "87F2A31DEF0A27905C85164CB73EEE32")
    
private int getEdgesTouched(int x, int y) {
        int result = 0;

        if (x < mParentView.getLeft() + mEdgeSize) result |= EDGE_LEFT;
        if (y < mParentView.getTop() + mEdgeSize) result |= EDGE_TOP;
        if (x > mParentView.getRight() - mEdgeSize) result |= EDGE_RIGHT;
        if (y > mParentView.getBottom() - mEdgeSize) result |= EDGE_BOTTOM;

        return result;
    }
}
