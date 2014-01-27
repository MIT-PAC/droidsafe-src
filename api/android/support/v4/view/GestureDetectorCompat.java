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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Detects various gestures and events using the supplied {@link MotionEvent}s.
 * The {@link OnGestureListener} callback will notify users when a particular
 * motion event has occurred. This class should only be used with {@link MotionEvent}s
 * reported via touch (don't use for trackball events).
 *
 * <p>This compatibility implementation of the framework's GestureDetector guarantees
 * the newer focal point scrolling behavior from Jellybean MR1 on all platform versions.</p>
 *
 * To use this class:
 * <ul>
 *  <li>Create an instance of the {@code GestureDetectorCompat} for your {@link View}
 *  <li>In the {@link View#onTouchEvent(MotionEvent)} method ensure you call
 *          {@link #onTouchEvent(MotionEvent)}. The methods defined in your callback
 *          will be executed when the events occur.
 * </ul>
 */
public class GestureDetectorCompat {
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();
        boolean onTouchEvent(MotionEvent ev);
        void setIsLongpressEnabled(boolean enabled);
        void setOnDoubleTapListener(OnDoubleTapListener listener);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.711 -0500", hash_original_field = "3292E3C407AFFD1ECB63974A48EF6F26", hash_generated_field = "A0C74D07DE33813B70581123FF749A35")


        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.712 -0500", hash_original_field = "1890900927A925C86536426FAA153831", hash_generated_field = "B2C557FED0C410FD936C94D9C495E66C")

        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.713 -0500", hash_original_field = "B38F23199EDAB3EC9AEB64805D70A86D", hash_generated_field = "AF4DBB13E8C6A9BFDCE110BEA6959177")

        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.715 -0500", hash_original_field = "96AD902CB8CC1F973F8F2F99306FF12F", hash_generated_field = "3EDD79F644F06511146F8C3326C425D3")

        private static final int SHOW_PRESS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.716 -0500", hash_original_field = "DA830484F6578D1FA7E355BF15F8A7E5", hash_generated_field = "4E989C39F54DC49F53402A764DC21A3E")

        private static final int LONG_PRESS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.718 -0500", hash_original_field = "D7271B71AB4CDF9866E775AD37C1D459", hash_generated_field = "5FB95885301BF4A2A2BE1CAC2FC68081")

        private static final int TAP = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.706 -0500", hash_original_field = "22908E064AB773A0D025345BB08C461C", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

        private int mTouchSlopSquare;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.707 -0500", hash_original_field = "D8CB968A9E00512DAFB6AA042D9A5D66", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

        private int mDoubleTapSlopSquare;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.708 -0500", hash_original_field = "5030B66C4E6C852287D391072C8046A5", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

        private int mMinimumFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.709 -0500", hash_original_field = "3B70336BAB0F826E0E6552B2A74F553D", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

        private int mMaximumFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.719 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")


        private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.721 -0500", hash_original_field = "1284A2585E50432ED50A1B728A817AEC", hash_generated_field = "0F48D0A94630E1FBE9C08A845F9730F2")

        private  OnGestureListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.723 -0500", hash_original_field = "34B775570CB5DCC36FC56F21F52D5399", hash_generated_field = "6BFE5EA6164149F540DE4277F8AF3864")

        private OnDoubleTapListener mDoubleTapListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.724 -0500", hash_original_field = "FDFC64EF754B3F40601812552039B1D3", hash_generated_field = "09EA51D062ED44D2275BC8E7A65061C0")


        private boolean mStillDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.726 -0500", hash_original_field = "C647D9FF01927E4F18C3E915DCABE3F0", hash_generated_field = "8FA7640B36D34A443E3A43478682F7F9")

        private boolean mInLongPress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.727 -0500", hash_original_field = "C4DA5EC1C08AB3C4511D5C489877E985", hash_generated_field = "54A847320ACF73ACDAB1D622D38FE146")

        private boolean mAlwaysInTapRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.730 -0500", hash_original_field = "D7FEB6486753F746ABF41DB7A0F48661", hash_generated_field = "05F405D52B0F8BE7180D2A6B8335B30C")

        private boolean mAlwaysInBiggerTapRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.733 -0500", hash_original_field = "7A306BD5FEBB31D162FCC9CE4F00D50B", hash_generated_field = "CAFEE339D8B144D23812ECC71639FEB7")


        private MotionEvent mCurrentDownEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.735 -0500", hash_original_field = "11D60B150A81CDB1C3B9E0F59396F002", hash_generated_field = "2C9915BC9FEEE919EC1B54BA44C7E08E")

        private MotionEvent mPreviousUpEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.736 -0500", hash_original_field = "D6CD53B5B941F0F7D74F7957B18BC84D", hash_generated_field = "36A2227955369181C5427F8675061A2C")

        private boolean mIsDoubleTapping;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.737 -0500", hash_original_field = "92733CA8EF1F4054A2FEF22AFF949D6F", hash_generated_field = "84CD91C09EAD7174CCB4F3B9EA5CBA95")


        private float mLastFocusX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.739 -0500", hash_original_field = "CDD83855FC25812EED5D226C79347734", hash_generated_field = "6298DB9E92040E49B36F3F9306873EF7")

        private float mLastFocusY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.740 -0500", hash_original_field = "9F9B3970E38232E0A0A5BEA411423732", hash_generated_field = "242E37A6A8338FD7A04B05F9B165C2FE")

        private float mDownFocusX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.741 -0500", hash_original_field = "FB7F0A6EB29DF38F446297DB124C1CD9", hash_generated_field = "99DEED00E0728B6FC9DC02081D4D5B0F")

        private float mDownFocusY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.742 -0500", hash_original_field = "D68DA72D16EA5A899A89E6EEBF535A9F", hash_generated_field = "A200AEA4E8786AAB09346E7991B4CE6C")


        private boolean mIsLongpressEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.744 -0500", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

        private VelocityTracker mVelocityTracker;

        private class GestureHandler extends Handler {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.745 -0500", hash_original_method = "9D2431BB2A48CA4B74BDD0A31919D26A", hash_generated_method = "9D2431BB2A48CA4B74BDD0A31919D26A")
            
GestureHandler() {
                super();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.747 -0500", hash_original_method = "EA154705C095D614E912EA5301C442EC", hash_generated_method = "EA154705C095D614E912EA5301C442EC")
            
GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.749 -0500", hash_original_method = "B97857986444DBB6880EA006296E5D03", hash_generated_method = "B97F6FF383B743F8B003FC1DC3D263B5")
            
@Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                case SHOW_PRESS:
                    mListener.onShowPress(mCurrentDownEvent);
                    break;

                case LONG_PRESS:
                    dispatchLongPress();
                    break;

                case TAP:
                    // If the user's finger is still down, do not count it as a tap
                    if (mDoubleTapListener != null && !mStillDown) {
                        mDoubleTapListener.onSingleTapConfirmed(mCurrentDownEvent);
                    }
                    break;

                default:
                    throw new RuntimeException("Unknown message " + msg); //never
                }
            }
        }

        /**
         * Creates a GestureDetector with the supplied listener.
         * You may only use this constructor from a UI thread (this is the usual situation).
         * @see android.os.Handler#Handler()
         *
         * @param context the application's context
         * @param listener the listener invoked for all the callbacks, this must
         * not be null.
         * @param handler the handler to use
         *
         * @throws NullPointerException if {@code listener} is null.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.753 -0500", hash_original_method = "0E44C690339E9DC4060FF288C9A50E58", hash_generated_method = "A3880231B047F3E15A30331E859A2974")
        
public GestureDetectorCompatImplBase(Context context, OnGestureListener listener,
                Handler handler) {
            if (handler != null) {
                mHandler = new GestureHandler(handler);
            } else {
                mHandler = new GestureHandler();
            }
            mListener = listener;
            if (listener instanceof OnDoubleTapListener) {
                setOnDoubleTapListener((OnDoubleTapListener) listener);
            }
            init(context);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.757 -0500", hash_original_method = "74A2F376400AF2C150D1C52FC35C5FC0", hash_generated_method = "D5CFD3C18D123B1ECFA9C6EBF8DF81C1")
        
private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (mListener == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            mIsLongpressEnabled = true;

            final ViewConfiguration configuration = ViewConfiguration.get(context);
            final int touchSlop = configuration.getScaledTouchSlop();
            final int doubleTapSlop = configuration.getScaledDoubleTapSlop();
            mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();

            mTouchSlopSquare = touchSlop * touchSlop;
            mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
        }

        /**
         * Sets the listener which will be called for double-tap and related
         * gestures.
         *
         * @param onDoubleTapListener the listener invoked for all the callbacks, or
         *        null to stop listening for double-tap gestures.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.759 -0500", hash_original_method = "571B39F87736E3994F3A317209D7E1C6", hash_generated_method = "F1C90E5AAFAC7521EB10174A8D449B9F")
        
public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            mDoubleTapListener = onDoubleTapListener;
        }

        /**
         * Set whether longpress is enabled, if this is enabled when a user
         * presses and holds down you get a longpress event and nothing further.
         * If it's disabled the user can press and hold down and then later
         * moved their finger and you will get scroll events. By default
         * longpress is enabled.
         *
         * @param isLongpressEnabled whether longpress should be enabled.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.760 -0500", hash_original_method = "14829325F18703625EF98BC2472601E3", hash_generated_method = "51336A8A06442CD62CB3C2FE846AC26F")
        
public void setIsLongpressEnabled(boolean isLongpressEnabled) {
            mIsLongpressEnabled = isLongpressEnabled;
        }

        /**
         * @return true if longpress is enabled, else false.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.762 -0500", hash_original_method = "880D3BB55D8069819877BA46CC6F055B", hash_generated_method = "66E0EA8C34A58B1875D8A044AC247580")
        
public boolean isLongpressEnabled() {
            return mIsLongpressEnabled;
        }

        /**
         * Analyzes the given motion event and if applicable triggers the
         * appropriate callbacks on the {@link OnGestureListener} supplied.
         *
         * @param ev The current motion event.
         * @return true if the {@link OnGestureListener} consumed the event,
         *              else false.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.971 -0500", hash_original_method = "E5CE0E5B73A1CCAF484886A860A0FDAD", hash_generated_method = "3CD9BAAEC078BA9E00D00605EDCC25E0")
        
public boolean onTouchEvent(MotionEvent ev) {
            final int action = ev.getAction();

            if (mVelocityTracker == null) {
                mVelocityTracker = VelocityTracker.obtain();
            }
            mVelocityTracker.addMovement(ev);

            final boolean pointerUp =
                    (action & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_POINTER_UP;
            final int skipIndex = pointerUp ? MotionEventCompat.getActionIndex(ev) : -1;

            // Determine focal point
            float sumX = 0, sumY = 0;
            final int count = MotionEventCompat.getPointerCount(ev);
            for (int i = 0; i < count; i++) {
                if (skipIndex == i) continue;
                sumX += MotionEventCompat.getX(ev, i);
                sumY += MotionEventCompat.getY(ev, i);
            }
            final int div = pointerUp ? count - 1 : count;
            final float focusX = sumX / div;
            final float focusY = sumY / div;

            boolean handled = false;

            switch (action & MotionEventCompat.ACTION_MASK) {
            case MotionEventCompat.ACTION_POINTER_DOWN:
                mDownFocusX = mLastFocusX = focusX;
                mDownFocusY = mLastFocusY = focusY;
                // Cancel long press and taps
                cancelTaps();
                break;

            case MotionEventCompat.ACTION_POINTER_UP:
                mDownFocusX = mLastFocusX = focusX;
                mDownFocusY = mLastFocusY = focusY;

                // Check the dot product of current velocities.
                // If the pointer that left was opposing another velocity vector, clear.
                mVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
                final int upIndex = MotionEventCompat.getActionIndex(ev);
                final int id1 = MotionEventCompat.getPointerId(ev, upIndex);
                final float x1 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, id1);
                final float y1 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, id1);
                for (int i = 0; i < count; i++) {
                    if (i == upIndex) continue;

                    final int id2 = MotionEventCompat.getPointerId(ev, i);
                    final float x = x1 * VelocityTrackerCompat.getXVelocity(mVelocityTracker, id2);
                    final float y = y1 * VelocityTrackerCompat.getYVelocity(mVelocityTracker, id2);

                    final float dot = x + y;
                    if (dot < 0) {
                        mVelocityTracker.clear();
                        break;
                    }
                }
                break;

            case MotionEvent.ACTION_DOWN:
                if (mDoubleTapListener != null) {
                    boolean hadTapMessage = mHandler.hasMessages(TAP);
                    if (hadTapMessage) mHandler.removeMessages(TAP);
                    if ((mCurrentDownEvent != null) && (mPreviousUpEvent != null) && hadTapMessage &&
                            isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, ev)) {
                        // This is a second tap
                        mIsDoubleTapping = true;
                        // Give a callback with the first tap of the double-tap
                        handled |= mDoubleTapListener.onDoubleTap(mCurrentDownEvent);
                        // Give a callback with down event of the double-tap
                        handled |= mDoubleTapListener.onDoubleTapEvent(ev);
                    } else {
                        // This is a first tap
                        mHandler.sendEmptyMessageDelayed(TAP, DOUBLE_TAP_TIMEOUT);
                    }
                }

                mDownFocusX = mLastFocusX = focusX;
                mDownFocusY = mLastFocusY = focusY;
                if (mCurrentDownEvent != null) {
                    mCurrentDownEvent.recycle();
                }
                mCurrentDownEvent = MotionEvent.obtain(ev);
                mAlwaysInTapRegion = true;
                mAlwaysInBiggerTapRegion = true;
                mStillDown = true;
                mInLongPress = false;

                if (mIsLongpressEnabled) {
                    mHandler.removeMessages(LONG_PRESS);
                    mHandler.sendEmptyMessageAtTime(LONG_PRESS, mCurrentDownEvent.getDownTime()
                            + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
                }
                mHandler.sendEmptyMessageAtTime(SHOW_PRESS, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                handled |= mListener.onDown(ev);
                break;

            case MotionEvent.ACTION_MOVE:
                if (mInLongPress) {
                    break;
                }
                final float scrollX = mLastFocusX - focusX;
                final float scrollY = mLastFocusY - focusY;
                if (mIsDoubleTapping) {
                    // Give the move events of the double-tap
                    handled |= mDoubleTapListener.onDoubleTapEvent(ev);
                } else if (mAlwaysInTapRegion) {
                    final int deltaX = (int) (focusX - mDownFocusX);
                    final int deltaY = (int) (focusY - mDownFocusY);
                    int distance = (deltaX * deltaX) + (deltaY * deltaY);
                    if (distance > mTouchSlopSquare) {
                        handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                        mLastFocusX = focusX;
                        mLastFocusY = focusY;
                        mAlwaysInTapRegion = false;
                        mHandler.removeMessages(TAP);
                        mHandler.removeMessages(SHOW_PRESS);
                        mHandler.removeMessages(LONG_PRESS);
                    }
                    if (distance > mTouchSlopSquare) {
                        mAlwaysInBiggerTapRegion = false;
                    }
                } else if ((Math.abs(scrollX) >= 1) || (Math.abs(scrollY) >= 1)) {
                    handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                    mLastFocusX = focusX;
                    mLastFocusY = focusY;
                }
                break;

            case MotionEvent.ACTION_UP:
                mStillDown = false;
                MotionEvent currentUpEvent = MotionEvent.obtain(ev);
                if (mIsDoubleTapping) {
                    // Finally, give the up event of the double-tap
                    handled |= mDoubleTapListener.onDoubleTapEvent(ev);
                } else if (mInLongPress) {
                    mHandler.removeMessages(TAP);
                    mInLongPress = false;
                } else if (mAlwaysInTapRegion) {
                    handled = mListener.onSingleTapUp(ev);
                } else {

                    // A fling must travel the minimum tap distance
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    final int pointerId = MotionEventCompat.getPointerId(ev, 0);
                    velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
                    final float velocityY = VelocityTrackerCompat.getYVelocity(
                            velocityTracker, pointerId);
                    final float velocityX = VelocityTrackerCompat.getXVelocity(
                            velocityTracker, pointerId);

                    if ((Math.abs(velocityY) > mMinimumFlingVelocity)
                            || (Math.abs(velocityX) > mMinimumFlingVelocity)){
                        handled = mListener.onFling(mCurrentDownEvent, ev, velocityX, velocityY);
                    }
                }
                if (mPreviousUpEvent != null) {
                    mPreviousUpEvent.recycle();
                }
                // Hold the event we obtained above - listeners may have changed the original.
                mPreviousUpEvent = currentUpEvent;
                if (mVelocityTracker != null) {
                    // This may have been cleared when we called out to the
                    // application above.
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                }
                mIsDoubleTapping = false;
                mHandler.removeMessages(SHOW_PRESS);
                mHandler.removeMessages(LONG_PRESS);
                break;

            case MotionEvent.ACTION_CANCEL:
                cancel();
                break;
            }

            return handled;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.974 -0500", hash_original_method = "9B9F1964085C6E9CB79BA6CBFD2B9081", hash_generated_method = "C5A172A598ACA3A87A4925C4C503E659")
        
private void cancel() {
            mHandler.removeMessages(SHOW_PRESS);
            mHandler.removeMessages(LONG_PRESS);
            mHandler.removeMessages(TAP);
            mVelocityTracker.recycle();
            mVelocityTracker = null;
            mIsDoubleTapping = false;
            mStillDown = false;
            mAlwaysInTapRegion = false;
            mAlwaysInBiggerTapRegion = false;
            if (mInLongPress) {
                mInLongPress = false;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.976 -0500", hash_original_method = "9E2FBC03F0AF2C678887C1E5B2B3FD14", hash_generated_method = "03A9312B23B686854F2E536B19BAEE10")
        
private void cancelTaps() {
            mHandler.removeMessages(SHOW_PRESS);
            mHandler.removeMessages(LONG_PRESS);
            mHandler.removeMessages(TAP);
            mIsDoubleTapping = false;
            mAlwaysInTapRegion = false;
            mAlwaysInBiggerTapRegion = false;
            if (mInLongPress) {
                mInLongPress = false;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.979 -0500", hash_original_method = "EA18A75BD47C1C65D8FE280884C192C1", hash_generated_method = "350379EFD91AC9A9AC3665FE74AB5D18")
        
private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp,
                MotionEvent secondDown) {
            if (!mAlwaysInBiggerTapRegion) {
                return false;
            }

            if (secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT) {
                return false;
            }

            int deltaX = (int) firstDown.getX() - (int) secondDown.getX();
            int deltaY = (int) firstDown.getY() - (int) secondDown.getY();
            return (deltaX * deltaX + deltaY * deltaY < mDoubleTapSlopSquare);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.981 -0500", hash_original_method = "1B110E72A2C7F37DAF94A595462A9E07", hash_generated_method = "5605DFE52E2DFD6F15B82DC5FFE09AED")
        
private void dispatchLongPress() {
            mHandler.removeMessages(TAP);
            mInLongPress = true;
            mListener.onLongPress(mCurrentDownEvent);
        }
    }

    static class GestureDetectorCompatImplJellybeanMr1 implements GestureDetectorCompatImpl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.994 -0500", hash_original_field = "6F2C53C310FBC2C3B8D9653E505DACB2", hash_generated_field = "8B30959A4950AA59520C53890F5984A0")

        private  GestureDetector mDetector;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.995 -0500", hash_original_method = "453DBA8B82FD89E1ED6E34F9267E5C80", hash_generated_method = "3301352476B6158BFB23A0852093EA91")
        
public GestureDetectorCompatImplJellybeanMr1(Context context, OnGestureListener listener,
                Handler handler) {
            mDetector = new GestureDetector(context, listener, handler);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.996 -0500", hash_original_method = "C6DA455D1425086DAAE3C8639C3C0151", hash_generated_method = "A7ADEDBAB36E52452A9F0BB343BE5E05")
        
@Override
        public boolean isLongpressEnabled() {
            return mDetector.isLongpressEnabled();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.998 -0500", hash_original_method = "0BFF4D0A3E0D6157B437BC7769F18803", hash_generated_method = "159246650C1493D1F2D270F9A40D70A8")
        
@Override
        public boolean onTouchEvent(MotionEvent ev) {
            return mDetector.onTouchEvent(ev);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.999 -0500", hash_original_method = "92328785FD6CF04FF7703DA61DF843FA", hash_generated_method = "F1F1A34F91D061A176F5761F5BAB3B97")
        
@Override
        public void setIsLongpressEnabled(boolean enabled) {
            mDetector.setIsLongpressEnabled(enabled);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.001 -0500", hash_original_method = "72DDE049C40CEE402301FF3EA4500F5A", hash_generated_method = "D1DEF0CFD9840F7D16A75C835131FBE2")
        
@Override
        public void setOnDoubleTapListener(OnDoubleTapListener listener) {
            mDetector.setOnDoubleTapListener(listener);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.003 -0500", hash_original_field = "11DC96F100E61547958771FC9A6C92A8", hash_generated_field = "036BBE30701EEA23262187CD19803D9D")


    private  GestureDetectorCompatImpl mImpl;

    /**
     * Creates a GestureDetectorCompat with the supplied listener.
     * As usual, you may only use this constructor from a UI thread.
     * @see android.os.Handler#Handler()
     *
     * @param context the application's context
     * @param listener the listener invoked for all the callbacks, this must
     * not be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.006 -0500", hash_original_method = "B489A839D159E7FF17B94DE4C6548B8A", hash_generated_method = "0C3D83BD20EFDC79584E615F2E2E74F7")
    
public GestureDetectorCompat(Context context, OnGestureListener listener) {
        this(context, listener, null);
    }

    /**
     * Creates a GestureDetectorCompat with the supplied listener.
     * As usual, you may only use this constructor from a UI thread.
     * @see android.os.Handler#Handler()
     *
     * @param context the application's context
     * @param listener the listener invoked for all the callbacks, this must
     * not be null.
     * @param handler the handler that will be used for posting deferred messages
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.007 -0500", hash_original_method = "A4BEFD368B129408AD26BDC86C73C812", hash_generated_method = "0E09BBC3ECA95FC8F4787F4836ACBC9B")
    
public GestureDetectorCompat(Context context, OnGestureListener listener, Handler handler) {
        if (Build.VERSION.SDK_INT >= 17) {
            mImpl = new GestureDetectorCompatImplJellybeanMr1(context, listener, handler);
        } else {
            mImpl = new GestureDetectorCompatImplBase(context, listener, handler);
        }
    }

    /**
     * @return true if longpress is enabled, else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.008 -0500", hash_original_method = "A561314D3C1B1E75D0698E5F7C49EB6E", hash_generated_method = "27FA60E42B5D9B04268C74E6E62FCD5A")
    
public boolean isLongpressEnabled() {
        return mImpl.isLongpressEnabled();
    }

    /**
     * Analyzes the given motion event and if applicable triggers the
     * appropriate callbacks on the {@link OnGestureListener} supplied.
     *
     * @param event The current motion event.
     * @return true if the {@link OnGestureListener} consumed the event,
     *              else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.009 -0500", hash_original_method = "8AC0D1224703F0491B06EEE77D787E6B", hash_generated_method = "FD20972263F4C73C7499FEBE12A0C33B")
    
public boolean onTouchEvent(MotionEvent event) {
        return mImpl.onTouchEvent(event);
    }

    /**
     * Set whether longpress is enabled, if this is enabled when a user
     * presses and holds down you get a longpress event and nothing further.
     * If it's disabled the user can press and hold down and then later
     * moved their finger and you will get scroll events. By default
     * longpress is enabled.
     *
     * @param enabled whether longpress should be enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.012 -0500", hash_original_method = "CE9D16700D0FD12C9940AF8D170F6A2B", hash_generated_method = "41DB1555F203BAB6431C3230AF437DF3")
    
public void setIsLongpressEnabled(boolean enabled) {
        mImpl.setIsLongpressEnabled(enabled);
    }

    /**
     * Sets the listener which will be called for double-tap and related
     * gestures.
     *
     * @param listener the listener invoked for all the callbacks, or
     *        null to stop listening for double-tap gestures.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.013 -0500", hash_original_method = "6AF653381945FBFC7EE8133ECEAFFC6B", hash_generated_method = "AC10232BF40EF0E772D9EBEBE552FE9C")
    
public void setOnDoubleTapListener(OnDoubleTapListener listener) {
        mImpl.setOnDoubleTapListener(listener);
    }
}
