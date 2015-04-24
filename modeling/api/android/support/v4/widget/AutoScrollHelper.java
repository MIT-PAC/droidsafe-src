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
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/**
 * AutoScrollHelper is a utility class for adding automatic edge-triggered
 * scrolling to Views.
 * <p>
 * <b>Note:</b> Implementing classes are responsible for overriding the
 * {@link #scrollTargetBy}, {@link #canTargetScrollHorizontally}, and
 * {@link #canTargetScrollVertically} methods. See
 * {@link ListViewAutoScrollHelper} for a {@link android.widget.ListView}
 * -specific implementation.
 * <p>
 * <h1>Activation</h1> Automatic scrolling starts when the user touches within
 * an activation area. By default, activation areas are defined as the top,
 * left, right, and bottom 20% of the host view's total area. Touching within
 * the top activation area scrolls up, left scrolls to the left, and so on.
 * <p>
 * As the user touches closer to the extreme edge of the activation area,
 * scrolling accelerates up to a maximum velocity. When using the default edge
 * type, {@link #EDGE_TYPE_INSIDE_EXTEND}, moving outside of the view bounds
 * will scroll at the maximum velocity.
 * <p>
 * The following activation properties may be configured:
 * <ul>
 * <li>Delay after entering activation area before auto-scrolling begins, see
 * {@link #setActivationDelay}. Default value is
 * {@link ViewConfiguration#getTapTimeout()} to avoid conflicting with taps.
 * <li>Location of activation areas, see {@link #setEdgeType}. Default value is
 * {@link #EDGE_TYPE_INSIDE_EXTEND}.
 * <li>Size of activation areas relative to view size, see
 * {@link #setRelativeEdges}. Default value is 20% for both vertical and
 * horizontal edges.
 * <li>Maximum size used to constrain relative size, see
 * {@link #setMaximumEdges}. Default value is {@link #NO_MAX}.
 * </ul>
 * <h1>Scrolling</h1> When automatic scrolling is active, the helper will
 * repeatedly call {@link #scrollTargetBy} to apply new scrolling offsets.
 * <p>
 * The following scrolling properties may be configured:
 * <ul>
 * <li>Acceleration ramp-up duration, see {@link #setRampUpDuration}. Default
 * value is 500 milliseconds.
 * <li>Acceleration ramp-down duration, see {@link #setRampDownDuration}.
 * Default value is 500 milliseconds.
 * <li>Target velocity relative to view size, see {@link #setRelativeVelocity}.
 * Default value is 100% per second for both vertical and horizontal.
 * <li>Minimum velocity used to constrain relative velocity, see
 * {@link #setMinimumVelocity}. When set, scrolling will accelerate to the
 * larger of either this value or the relative target value. Default value is
 * approximately 5 centimeters or 315 dips per second.
 * <li>Maximum velocity used to constrain relative velocity, see
 * {@link #setMaximumVelocity}. Default value is approximately 25 centimeters or
 * 1575 dips per second.
 * </ul>
 */
public abstract class AutoScrollHelper implements View.OnTouchListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.478 -0400", hash_original_field = "D842A337BF566D67B15BF0702FF77B33", hash_generated_field = "E1F434DA79FBE8D6D9EE9281AF81B416")

    public static final float RELATIVE_UNSPECIFIED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.489 -0400", hash_original_field = "843BEA56FA1BB49D5D29FE2C20E93036", hash_generated_field = "DBE9D3990EDA04C63B07998F30370765")

    public static final float NO_MAX = Float.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.498 -0400", hash_original_field = "DE3FAB5CC12C6BB081B6CAD6BAB2E5E3", hash_generated_field = "BC07C6926B4DCA5C5B2C76349409FD74")

    public static final float NO_MIN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.507 -0400", hash_original_field = "47867F7EE2E91C3288A0928ADF23E080", hash_generated_field = "C2528E1E156A9C6EC98C9B01485C4B45")

    public static final int EDGE_TYPE_INSIDE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.516 -0400", hash_original_field = "D66957F240777355B0B286D301B1F58C", hash_generated_field = "89131E7605C6CF2DB7A9247BF909FE12")

    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.535 -0400", hash_original_field = "BABD5786E0C4D228734B5C2233A7B322", hash_generated_field = "027BA98A2B0CCE12C9D73DDEB4AB4823")

    public static final int EDGE_TYPE_OUTSIDE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.543 -0400", hash_original_field = "FBA6C9C5213832E18F5A01E0F1543E85", hash_generated_field = "FB2AF03A0D0E19237A68DC6CAC3EDFEF")

    private static final int HORIZONTAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.552 -0400", hash_original_field = "E82176956A4DF716613C200537EEC301", hash_generated_field = "FE13C9507EB3E0B2777A8026EAF21CFC")

    private static final int VERTICAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.699 -0400", hash_original_field = "DF01098DF3A0717A756B86DA04EE71A2", hash_generated_field = "B5879D4FC1990E1D8C484E0D906B746D")

    private static final int DEFAULT_EDGE_TYPE = EDGE_TYPE_INSIDE_EXTEND;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.707 -0400", hash_original_field = "C6DB71EB026F625884A8DC723EA249D7", hash_generated_field = "5A77C32C343B179ECF2E3F227C1DD7E3")

    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.715 -0400", hash_original_field = "2112EB2FF55615436F7CD39667A96AA3", hash_generated_field = "B1D9D4C0B79695C3EA377F6DB17CB82B")

    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.722 -0400", hash_original_field = "C38BE0B26C891EF2E8D017A90DBD3276", hash_generated_field = "1FDED03DCA376DB1C6ED4138C81AF20E")

    private static final float DEFAULT_MAXIMUM_EDGE = NO_MAX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.731 -0400", hash_original_field = "4728A279254FF6C89DC2B87318A1B694", hash_generated_field = "16A427238A817A2AF6CB9323ABAF510A")

    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.738 -0400", hash_original_field = "DDA1396B3BCF3313968575C7BA7461EB", hash_generated_field = "4E8325234BBB14415320D616A62EC40C")

    private static final float DEFAULT_RELATIVE_VELOCITY = 1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.745 -0400", hash_original_field = "FB90544A5A0B8CDAE38174F3900B1665", hash_generated_field = "478431E63C0A7CC2B077776263BE333B")

    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.755 -0400", hash_original_field = "59D78FE9FD54A2D0E288005C16A613A6", hash_generated_field = "C6BF040C811E8DCD89B513AD026CC47B")

    private static final int DEFAULT_RAMP_UP_DURATION = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.763 -0400", hash_original_field = "F5823A826B73ECC142C31A6F2A656E81", hash_generated_field = "999EE98D118889633CA9011E8D35D525")

    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.953 -0400", hash_original_method = "263E4A0D32648DA26FDBBAACB6117645", hash_generated_method = "4CAD43C25667B715B2E10F9061A28618")
    
private static int constrain(int value, int min, int max) {
        if (value > max) {
            return max;
        } else if (value < min) {
            return min;
        } else {
            return value;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.960 -0400", hash_original_method = "B44B2D3A0D1B4D106AF63A1A59BB5B42", hash_generated_method = "998C3D6B252A59F6CEE63EB21BA01803")
    
private static float constrain(float value, float min, float max) {
        if (value > max) {
            return max;
        } else if (value < min) {
            return min;
        } else {
            return value;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.561 -0400", hash_original_field = "402EBC02797792560979A497BE30886E", hash_generated_field = "CBC6A792B7981D0AE82537E50121B724")

    private final ClampedScroller mScroller = new ClampedScroller();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.570 -0400", hash_original_field = "87CCC237FFE72536778F093F084D0B17", hash_generated_field = "2BEFE480E073A67A95A0F7BCD82617B8")

    private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.578 -0400", hash_original_field = "852A5F36228F419DA7A4F36BB5C9B7E4", hash_generated_field = "C895A302A5EAB442D8936D160230E131")

    private  View mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.585 -0400", hash_original_field = "2E6952E4DC80E74370CB451967A09FCB", hash_generated_field = "C6C45D25683FAA63BA96ECE0AD910E8B")

    private Runnable mRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.595 -0400", hash_original_field = "CC75C470E0120CED50780F6B63ABE788", hash_generated_field = "CE625B767324353EA01FE1A79FB96464")

    private float[] mRelativeEdges = new float[] { RELATIVE_UNSPECIFIED, RELATIVE_UNSPECIFIED };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.603 -0400", hash_original_field = "CD0DE94B0F62AD12C29DB6D970FB31AF", hash_generated_field = "277F68AE0E8214BEBDB9B082215E3522")

    private float[] mMaximumEdges = new float[] { NO_MAX, NO_MAX };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.611 -0400", hash_original_field = "4CE270E5F48864E07C99F586EC615AE4", hash_generated_field = "BC17DEB1229726DC739910E7FD41CD2B")

    private int mEdgeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.619 -0400", hash_original_field = "24AEC5B2AD61B448D1527FDCD93C917C", hash_generated_field = "0DA2E0742E46A34222D3B0918F5869EA")

    private int mActivationDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.628 -0400", hash_original_field = "6573B5FD183D66E99EB5149BC5E55C26", hash_generated_field = "C6AFDE26CF31CB7D680320C8A691BE52")

    private float[] mRelativeVelocity = new float[] { RELATIVE_UNSPECIFIED, RELATIVE_UNSPECIFIED };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.636 -0400", hash_original_field = "490B49B21597D7CA168FB872ED3FD72D", hash_generated_field = "BE0F0AABA7B8D3382ABBF4246A1596DD")

    private float[] mMinimumVelocity = new float[] { NO_MIN, NO_MIN };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.645 -0400", hash_original_field = "1269A07C293099CB3E5CC9316A1F7BA7", hash_generated_field = "D0B19FD3C3061B3CB5FF748A3F2F0998")

    private float[] mMaximumVelocity = new float[] { NO_MAX, NO_MAX };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.652 -0400", hash_original_field = "8E0C13698468DFC73D8869BE31B12E4E", hash_generated_field = "F929CD06852016CE9C41A7C87985EE1E")

    private boolean mAlreadyDelayed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.659 -0400", hash_original_field = "8BB8C3129674A12495103D1FCAFA8B13", hash_generated_field = "1AF1362EB83401036E9DCC139D0A62CE")

    private boolean mNeedsReset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.667 -0400", hash_original_field = "D2E0FF484AC90CD4B154682B490A4B6C", hash_generated_field = "499312C5C0C1D3564A940CE9F3D88BB1")

    private boolean mNeedsCancel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.673 -0400", hash_original_field = "1EF11B2E74F652844136498FA058D6D8", hash_generated_field = "854092FC87CCBE5E499FE3FB8F6394C7")

    private boolean mAnimating;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.682 -0400", hash_original_field = "B372655E189CA31F1D74E7441882FA0E", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.690 -0400", hash_original_field = "C5CAA5D749395EAF95219B8218C828AD", hash_generated_field = "85D4557CAB3F39581FCC0DF1EDF5E92F")

    private boolean mExclusive;

    /**
     * Creates a new helper for scrolling the specified target view.
     * <p>
     * The resulting helper may be configured by chaining setter calls and
     * should be set as a touch listener on the target view.
     * <p>
     * By default, the helper is disabled and will not respond to touch events
     * until it is enabled using {@link #setEnabled}.
     *
     * @param target The view to automatically scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.776 -0400", hash_original_method = "FB8D835FEE5F2100CAF0A73F2F6D85C4", hash_generated_method = "4739C1CA88D25E753C9FC36B07A32AA8")
    
public AutoScrollHelper(View target) {
        mTarget = target;

        final DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        final int maxVelocity = (int) (DEFAULT_MAXIMUM_VELOCITY_DIPS * metrics.density + 0.5f);
        final int minVelocity = (int) (DEFAULT_MINIMUM_VELOCITY_DIPS * metrics.density + 0.5f);
        setMaximumVelocity(maxVelocity, maxVelocity);
        setMinimumVelocity(minVelocity, minVelocity);

        setEdgeType(DEFAULT_EDGE_TYPE);
        setMaximumEdges(DEFAULT_MAXIMUM_EDGE, DEFAULT_MAXIMUM_EDGE);
        setRelativeEdges(DEFAULT_RELATIVE_EDGE, DEFAULT_RELATIVE_EDGE);
        setRelativeVelocity(DEFAULT_RELATIVE_VELOCITY, DEFAULT_RELATIVE_VELOCITY);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(DEFAULT_RAMP_UP_DURATION);
        setRampDownDuration(DEFAULT_RAMP_DOWN_DURATION);
    }

    /**
     * Sets whether the scroll helper is enabled and should respond to touch
     * events.
     *
     * @param enabled Whether the scroll helper is enabled.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.784 -0400", hash_original_method = "B2A73AAAC96C296401AD8E0108266C27", hash_generated_method = "666DA0042B03D46E17A6B5F7AF71E430")
    
public AutoScrollHelper setEnabled(boolean enabled) {
        if (mEnabled && !enabled) {
            requestStop();
        }

        mEnabled = enabled;
        return this;
    }

    /**
     * @return True if this helper is enabled and responding to touch events.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.790 -0400", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "FCD384DBC29E5B725DC0C96A27CA1EC9")
    
public boolean isEnabled() {
        return mEnabled;
    }

    /**
     * Enables or disables exclusive handling of touch events during scrolling.
     * By default, exclusive handling is disabled and the target view receives
     * all touch events.
     * <p>
     * When enabled, {@link #onTouch} will return true if the helper is
     * currently scrolling and false otherwise.
     *
     * @param exclusive True to exclusively handle touch events during scrolling,
     *            false to allow the target view to receive all touch events.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.797 -0400", hash_original_method = "2985CC7554638E96DE27BCEEC0932D9E", hash_generated_method = "7C790A9CDD243ADC102ACCC0E6169D4A")
    
public AutoScrollHelper setExclusive(boolean exclusive) {
        mExclusive = exclusive;
        return this;
    }

    /**
     * Indicates whether the scroll helper handles touch events exclusively
     * during scrolling.
     *
     * @return True if exclusive handling of touch events during scrolling is
     *         enabled, false otherwise.
     * @see #setExclusive(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.803 -0400", hash_original_method = "E1BE5204C5AEA483B8FFE965D0D3BB12", hash_generated_method = "4E8A85A91BB9A3257EFC6F26FF4DCE52")
    
public boolean isExclusive() {
        return mExclusive;
    }

    /**
     * Sets the absolute maximum scrolling velocity.
     * <p>
     * If relative velocity is not specified, scrolling will always reach the
     * same maximum velocity. If both relative and maximum velocities are
     * specified, the maximum velocity will be used to clamp the calculated
     * relative velocity.
     *
     * @param horizontalMax The maximum horizontal scrolling velocity, or
     *            {@link #NO_MAX} to leave the relative value unconstrained.
     * @param verticalMax The maximum vertical scrolling velocity, or
     *            {@link #NO_MAX} to leave the relative value unconstrained.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.810 -0400", hash_original_method = "1A8F05B9F126B225CD502D23316E7608", hash_generated_method = "8CBDE253D1D8C84E8DE28ABD03B8ADC2")
    
public AutoScrollHelper setMaximumVelocity(float horizontalMax, float verticalMax) {
        mMaximumVelocity[HORIZONTAL] = horizontalMax / 1000f;
        mMaximumVelocity[VERTICAL] = verticalMax / 1000f;
        return this;
    }

    /**
     * Sets the absolute minimum scrolling velocity.
     * <p>
     * If both relative and minimum velocities are specified, the minimum
     * velocity will be used to clamp the calculated relative velocity.
     *
     * @param horizontalMin The minimum horizontal scrolling velocity, or
     *            {@link #NO_MIN} to leave the relative value unconstrained.
     * @param verticalMin The minimum vertical scrolling velocity, or
     *            {@link #NO_MIN} to leave the relative value unconstrained.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.818 -0400", hash_original_method = "26EEF6185167D01A06D30EE82F2D2401", hash_generated_method = "CFD66EB22CC96F1E6F5EAB1768D255E2")
    
public AutoScrollHelper setMinimumVelocity(float horizontalMin, float verticalMin) {
        mMinimumVelocity[HORIZONTAL] = horizontalMin / 1000f;
        mMinimumVelocity[VERTICAL] = verticalMin / 1000f;
        return this;
    }

    /**
     * Sets the target scrolling velocity relative to the host view's
     * dimensions.
     * <p>
     * If both relative and maximum velocities are specified, the maximum
     * velocity will be used to clamp the calculated relative velocity.
     *
     * @param horizontal The target horizontal velocity as a fraction of the
     *            host view width per second, or {@link #RELATIVE_UNSPECIFIED}
     *            to ignore.
     * @param vertical The target vertical velocity as a fraction of the host
     *            view height per second, or {@link #RELATIVE_UNSPECIFIED} to
     *            ignore.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.825 -0400", hash_original_method = "0463A69A26778FD1217A604619B7A7DC", hash_generated_method = "64A67A2FC2BCB74AD7E1960D91415643")
    
public AutoScrollHelper setRelativeVelocity(float horizontal, float vertical) {
        mRelativeVelocity[HORIZONTAL] = horizontal / 1000f;
        mRelativeVelocity[VERTICAL] = vertical / 1000f;
        return this;
    }

    /**
     * Sets the activation edge type, one of:
     * <ul>
     * <li>{@link #EDGE_TYPE_INSIDE} for edges that respond to touches inside
     * the bounds of the host view. If touch moves outside the bounds, scrolling
     * will stop.
     * <li>{@link #EDGE_TYPE_INSIDE_EXTEND} for inside edges that continued to
     * scroll when touch moves outside the bounds of the host view.
     * <li>{@link #EDGE_TYPE_OUTSIDE} for edges that only respond to touches
     * that move outside the bounds of the host view.
     * </ul>
     *
     * @param type The type of edge to use.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.831 -0400", hash_original_method = "7F8AAF66020E10F65BC6E0682EC10E1E", hash_generated_method = "A533AA0EBC06A90E1B68F70B0A6F5F34")
    
public AutoScrollHelper setEdgeType(int type) {
        mEdgeType = type;
        return this;
    }

    /**
     * Sets the activation edge size relative to the host view's dimensions.
     * <p>
     * If both relative and maximum edges are specified, the maximum edge will
     * be used to constrain the calculated relative edge size.
     *
     * @param horizontal The horizontal edge size as a fraction of the host view
     *            width, or {@link #RELATIVE_UNSPECIFIED} to always use the
     *            maximum value.
     * @param vertical The vertical edge size as a fraction of the host view
     *            height, or {@link #RELATIVE_UNSPECIFIED} to always use the
     *            maximum value.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.838 -0400", hash_original_method = "3B151E9D0A68EE4ABC433836E13673BF", hash_generated_method = "5FD4A00138B2E6AC9915DE545132367F")
    
public AutoScrollHelper setRelativeEdges(float horizontal, float vertical) {
        mRelativeEdges[HORIZONTAL] = horizontal;
        mRelativeEdges[VERTICAL] = vertical;
        return this;
    }

    /**
     * Sets the absolute maximum edge size.
     * <p>
     * If relative edge size is not specified, activation edges will always be
     * the maximum edge size. If both relative and maximum edges are specified,
     * the maximum edge will be used to constrain the calculated relative edge
     * size.
     *
     * @param horizontalMax The maximum horizontal edge size in pixels, or
     *            {@link #NO_MAX} to use the unconstrained calculated relative
     *            value.
     * @param verticalMax The maximum vertical edge size in pixels, or
     *            {@link #NO_MAX} to use the unconstrained calculated relative
     *            value.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.845 -0400", hash_original_method = "97CCC02C015F548A6AD741142197C3CD", hash_generated_method = "B94C7491E20238B692C47D9457921D6E")
    
public AutoScrollHelper setMaximumEdges(float horizontalMax, float verticalMax) {
        mMaximumEdges[HORIZONTAL] = horizontalMax;
        mMaximumEdges[VERTICAL] = verticalMax;
        return this;
    }

    /**
     * Sets the delay after entering an activation edge before activation of
     * auto-scrolling. By default, the activation delay is set to
     * {@link ViewConfiguration#getTapTimeout()}.
     * <p>
     * Specifying a delay of zero will start auto-scrolling immediately after
     * the touch position enters an activation edge.
     *
     * @param delayMillis The activation delay in milliseconds.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.851 -0400", hash_original_method = "53C1E9165159486B60483FDF06754875", hash_generated_method = "86B42EA982960F78BAEB67A0687DAD78")
    
public AutoScrollHelper setActivationDelay(int delayMillis) {
        mActivationDelay = delayMillis;
        return this;
    }

    /**
     * Sets the amount of time after activation of auto-scrolling that is takes
     * to reach target velocity for the current touch position.
     * <p>
     * Specifying a duration greater than zero prevents sudden jumps in
     * velocity.
     *
     * @param durationMillis The ramp-up duration in milliseconds.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.858 -0400", hash_original_method = "94F526D2B82367F23351B670038C3C29", hash_generated_method = "FCDE9D9AF61417E1EBC3C575D40451F1")
    
public AutoScrollHelper setRampUpDuration(int durationMillis) {
        mScroller.setRampUpDuration(durationMillis);
        return this;
    }

    /**
     * Sets the amount of time after de-activation of auto-scrolling that is
     * takes to slow to a stop.
     * <p>
     * Specifying a duration greater than zero prevents sudden jumps in
     * velocity.
     *
     * @param durationMillis The ramp-down duration in milliseconds.
     * @return The scroll helper, which may used to chain setter calls.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.865 -0400", hash_original_method = "1D78BF04625477BA0136ABE81CEFF9FC", hash_generated_method = "3E3F4BCEEABE406810C7B6FF7650987E")
    
public AutoScrollHelper setRampDownDuration(int durationMillis) {
        mScroller.setRampDownDuration(durationMillis);
        return this;
    }

    /**
     * Handles touch events by activating automatic scrolling, adjusting scroll
     * velocity, or stopping.
     * <p>
     * If {@link #isExclusive()} is false, always returns false so that
     * the host view may handle touch events. Otherwise, returns true when
     * automatic scrolling is active and false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.876 -0400", hash_original_method = "69316525521EDD921ED01254917319D7", hash_generated_method = "5845706179F4E9C02271E2356B7BDA7A")
    
@Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!mEnabled) {
            return false;
        }

        final int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mNeedsCancel = true;
                mAlreadyDelayed = false;
                // $FALL-THROUGH$
            case MotionEvent.ACTION_MOVE:
                final float xTargetVelocity = computeTargetVelocity(
                        HORIZONTAL, event.getX(), v.getWidth(), mTarget.getWidth());
                final float yTargetVelocity = computeTargetVelocity(
                        VERTICAL, event.getY(), v.getHeight(), mTarget.getHeight());
                mScroller.setTargetVelocity(xTargetVelocity, yTargetVelocity);

                // If the auto scroller was not previously active, but it should
                // be, then update the state and start animations.
                if (!mAnimating && shouldAnimate()) {
                    startAnimating();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                requestStop();
                break;
        }

        return mExclusive && mAnimating;
    }

    /**
     * @return whether the target is able to scroll in the requested direction
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.884 -0400", hash_original_method = "B26BA7C061EADCB2BB6D73BE44B07002", hash_generated_method = "733A0C8D057F565CFA38CE5A94E46729")
    
private boolean shouldAnimate() {
        final ClampedScroller scroller = mScroller;
        final int verticalDirection = scroller.getVerticalDirection();
        final int horizontalDirection = scroller.getHorizontalDirection();

        return verticalDirection != 0 && canTargetScrollVertically(verticalDirection)
                || horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection);
    }

    /**
     * Starts the scroll animation.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.893 -0400", hash_original_method = "1D5C1CAD470C382319CB84CDAF0CED74", hash_generated_method = "FB47F8FFE188A17B6D7F9F0ECE864AD5")
    
private void startAnimating() {
        if (mRunnable == null) {
            mRunnable = new ScrollAnimationRunnable();
        }

        mAnimating = true;
        mNeedsReset = true;

        if (!mAlreadyDelayed && mActivationDelay > 0) {
            ViewCompat.postOnAnimationDelayed(mTarget, mRunnable, mActivationDelay);
        } else {
            mRunnable.run();
        }

        // If we start animating again before the user lifts their finger, we
        // already know it's not a tap and don't need an activation delay.
        mAlreadyDelayed = true;
    }

    /**
     * Requests that the scroll animation slow to a stop. If there is an
     * activation delay, this may occur between posting the animation and
     * actually running it.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.899 -0400", hash_original_method = "32219D50AD51418C26556F1ADF039C62", hash_generated_method = "8E6A8709F3121B51F7BADC93125AC0E3")
    
private void requestStop() {
        if (mNeedsReset) {
            // The animation has been posted, but hasn't run yet. Manually
            // stopping animation will prevent it from running.
            mAnimating = false;
        } else {
            mScroller.requestStop();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.911 -0400", hash_original_method = "21B2ACA116C244D6D0246AA1099DB2D2", hash_generated_method = "1F36F3B0EAE2A2DDD1006FF16A16E492")
    
private float computeTargetVelocity(
            int direction, float coordinate, float srcSize, float dstSize) {
        final float relativeEdge = mRelativeEdges[direction];
        final float maximumEdge = mMaximumEdges[direction];
        final float value = getEdgeValue(relativeEdge, srcSize, maximumEdge, coordinate);
        if (value == 0) {
            // The edge in this direction is not activated.
            return 0;
        }

        final float relativeVelocity = mRelativeVelocity[direction];
        final float minimumVelocity = mMinimumVelocity[direction];
        final float maximumVelocity = mMaximumVelocity[direction];
        final float targetVelocity = relativeVelocity * dstSize;

        // Target velocity is adjusted for interpolated edge position, then
        // clamped to the minimum and maximum values. Later, this value will be
        // adjusted for time-based acceleration.
        if (value > 0) {
            return constrain(value * targetVelocity, minimumVelocity, maximumVelocity);
        } else {
            return -constrain(-value * targetVelocity, minimumVelocity, maximumVelocity);
        }
    }

    /**
     * Override this method to scroll the target view by the specified number of
     * pixels.
     *
     * @param deltaX The number of pixels to scroll by horizontally.
     * @param deltaY The number of pixels to scroll by vertically.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.918 -0400", hash_original_method = "6FAB8B17B383926E4B3CB6169D2EF56A", hash_generated_method = "10316ED7B1B991CA66D86A845B473C0F")
    
public abstract void scrollTargetBy(int deltaX, int deltaY);

    /**
     * Override this method to return whether the target view can be scrolled
     * horizontally in a certain direction.
     *
     * @param direction Negative to check scrolling left, positive to check
     *            scrolling right.
     * @return true if the target view is able to horizontally scroll in the
     *         specified direction.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.923 -0400", hash_original_method = "5AE6F97030A2B2872ADB03A39C656588", hash_generated_method = "2A560E07FC4F4562BB30B13EB3CA3F23")
    
public abstract boolean canTargetScrollHorizontally(int direction);

    /**
     * Override this method to return whether the target view can be scrolled
     * vertically in a certain direction.
     *
     * @param direction Negative to check scrolling up, positive to check
     *            scrolling down.
     * @return true if the target view is able to vertically scroll in the
     *         specified direction.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.930 -0400", hash_original_method = "7CCD3473E7C9441C52232BE49B124D54", hash_generated_method = "6C8DAB5C4ADC2BA8D2DD4AF7A7F523A8")
    
public abstract boolean canTargetScrollVertically(int direction);

    /**
     * Returns the interpolated position of a touch point relative to an edge
     * defined by its relative inset, its maximum absolute inset, and the edge
     * interpolator.
     *
     * @param relativeValue The size of the inset relative to the total size.
     * @param size Total size.
     * @param maxValue The maximum size of the inset, used to clamp (relative *
     *            total).
     * @param current Touch position within within the total size.
     * @return Interpolated value of the touch position within the edge.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.939 -0400", hash_original_method = "BA83F8BF39A6AE721B21CF37BA4DF633", hash_generated_method = "E8B0F1FA5CCFA12D045D340EE13DB219")
    
private float getEdgeValue(float relativeValue, float size, float maxValue, float current) {
        // For now, leading and trailing edges are always the same size.
        final float edgeSize = constrain(relativeValue * size, NO_MIN, maxValue);
        final float valueLeading = constrainEdgeValue(current, edgeSize);
        final float valueTrailing = constrainEdgeValue(size - current, edgeSize);
        final float value = (valueTrailing - valueLeading);
        final float interpolated;
        if (value < 0) {
            interpolated = -mEdgeInterpolator.getInterpolation(-value);
        } else if (value > 0) {
            interpolated = mEdgeInterpolator.getInterpolation(value);
        } else {
            return 0;
        }

        return constrain(interpolated, -1, 1);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.945 -0400", hash_original_method = "5116BD62E83073320DAB98090F1C225F", hash_generated_method = "7251BA6549CEB5C52C388E97D53E8956")
    
private float constrainEdgeValue(float current, float leading) {
        if (leading == 0) {
            return 0;
        }

        switch (mEdgeType) {
            case EDGE_TYPE_INSIDE:
            case EDGE_TYPE_INSIDE_EXTEND:
                if (current < leading) {
                    if (current >= 0) {
                        // Movement up to the edge is scaled.
                        return 1f - current / leading;
                    } else if (mAnimating && (mEdgeType == EDGE_TYPE_INSIDE_EXTEND)) {
                        // Movement beyond the edge is always maximum.
                        return 1f;
                    }
                }
                break;
            case EDGE_TYPE_OUTSIDE:
                if (current < 0) {
                    // Movement beyond the edge is scaled.
                    return current / -leading;
                }
                break;
        }

        return 0;
    }

    /**
     * Sends a {@link MotionEvent#ACTION_CANCEL} event to the target view,
     * canceling any ongoing touch events.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:04.966 -0400", hash_original_method = "84B2CF4E7502DF9E54D7F292238924DB", hash_generated_method = "750483E8F4E0E593319844415ACC1A3A")
    
private void cancelTargetTouch() {
        final long eventTime = SystemClock.uptimeMillis();
        final MotionEvent cancel = MotionEvent.obtain(
                eventTime, eventTime, MotionEvent.ACTION_CANCEL, 0, 0, 0);
        mTarget.onTouchEvent(cancel);
        cancel.recycle();
    }

    private class ScrollAnimationRunnable implements Runnable {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void run() {
            if (!mAnimating) {
                return;
            }

            if (mNeedsReset) {
                mNeedsReset = false;
                mScroller.start();
            }

            final ClampedScroller scroller = mScroller;
            if (scroller.isFinished() || !shouldAnimate()) {
                mAnimating = false;
                return;
            }

            if (mNeedsCancel) {
                mNeedsCancel = false;
                cancelTargetTouch();
            }

            scroller.computeScrollDelta();

            final int deltaX = scroller.getDeltaX();
            final int deltaY = scroller.getDeltaY();
            scrollTargetBy(deltaX,  deltaY);

            // Keep going until the scroller has permanently stopped.
            ViewCompat.postOnAnimation(mTarget, this);
        }
    }

    /**
     * Scroller whose velocity follows the curve of an {@link Interpolator} and
     * is clamped to the interpolated 0f value before starting and the
     * interpolated 1f value after a specified duration.
     */
    private static class ClampedScroller {
        private int mRampUpDuration;
        private int mRampDownDuration;
        private float mTargetVelocityX;
        private float mTargetVelocityY;

        private long mStartTime;

        private long mDeltaTime;
        private int mDeltaX;
        private int mDeltaY;

        private long mStopTime;
        private float mStopValue;
        private int mEffectiveRampDown;

        /**
         * Creates a new ramp-up scroller that reaches full velocity after a
         * specified duration.
         */
        public ClampedScroller() {
            mStartTime = Long.MIN_VALUE;
            mStopTime = -1;
            mDeltaTime = 0;
            mDeltaX = 0;
            mDeltaY = 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setRampUpDuration(int durationMillis) {
            mRampUpDuration = durationMillis;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setRampDownDuration(int durationMillis) {
            mRampDownDuration = durationMillis;
        }

        /**
         * Starts the scroller at the current animation time.
         */
        @DSSafe(DSCat.SAFE_LIST)
        public void start() {
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mStopTime = -1;
            mDeltaTime = mStartTime;
            mStopValue = 0.5f;
            mDeltaX = 0;
            mDeltaY = 0;
        }

        /**
         * Stops the scroller at the current animation time.
         */
        @DSSafe(DSCat.SAFE_LIST)
        public void requestStop() {
            final long currentTime = AnimationUtils.currentAnimationTimeMillis();
            mEffectiveRampDown = constrain((int) (currentTime - mStartTime), 0, mRampDownDuration);
            mStopValue = getValueAt(currentTime);
            mStopTime = currentTime;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean isFinished() {
            return mStopTime > 0
                    && AnimationUtils.currentAnimationTimeMillis() > mStopTime + mEffectiveRampDown;
        }

        @DSSafe(DSCat.SAFE_LIST)
        private float getValueAt(long currentTime) {
            if (currentTime < mStartTime) {
                return 0f;
            } else if (mStopTime < 0 || currentTime < mStopTime) {
                final long elapsedSinceStart = currentTime - mStartTime;
                return 0.5f * constrain(elapsedSinceStart / (float) mRampUpDuration, 0, 1);
            } else {
                final long elapsedSinceEnd = currentTime - mStopTime;
                return (1 - mStopValue) + mStopValue
                        * constrain(elapsedSinceEnd / (float) mEffectiveRampDown, 0, 1);
            }
        }

        /**
         * Interpolates the value along a parabolic curve corresponding to the equation
         * <code>y = -4x * (x-1)</code>.
         *
         * @param value The value to interpolate, between 0 and 1.
         * @return the interpolated value, between 0 and 1.
         */
        @DSSafe(DSCat.SAFE_LIST)
        private float interpolateValue(float value) {
            return -4 * value * value + 4 * value;
        }

        /**
         * Computes the current scroll deltas. This usually only be called after
         * starting the scroller with {@link #start()}.
         *
         * @see #getDeltaX()
         * @see #getDeltaY()
         */
        @DSSafe(DSCat.SAFE_LIST)
        public void computeScrollDelta() {
            if (mDeltaTime == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }

            final long currentTime = AnimationUtils.currentAnimationTimeMillis();
            final float value = getValueAt(currentTime);
            final float scale = interpolateValue(value);
            final long elapsedSinceDelta = currentTime - mDeltaTime;

            mDeltaTime = currentTime;
            mDeltaX = (int) (elapsedSinceDelta * scale * mTargetVelocityX);
            mDeltaY = (int) (elapsedSinceDelta * scale * mTargetVelocityY);
        }

        /**
         * Sets the target velocity for this scroller.
         *
         * @param x The target X velocity in pixels per millisecond.
         * @param y The target Y velocity in pixels per millisecond.
         */
        @DSSafe(DSCat.SAFE_LIST)
        public void setTargetVelocity(float x, float y) {
            mTargetVelocityX = x;
            mTargetVelocityY = y;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getHorizontalDirection() {
            return (int) (mTargetVelocityX / Math.abs(mTargetVelocityX));
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getVerticalDirection() {
            return (int) (mTargetVelocityY / Math.abs(mTargetVelocityY));
        }

        /**
         * The distance traveled in the X-coordinate computed by the last call
         * to {@link #computeScrollDelta()}.
         */
        @DSSafe(DSCat.SAFE_LIST)
        public int getDeltaX() {
            return mDeltaX;
        }

        /**
         * The distance traveled in the Y-coordinate computed by the last call
         * to {@link #computeScrollDelta()}.
         */
        @DSSafe(DSCat.SAFE_LIST)
        public int getDeltaY() {
            return mDeltaY;
        }
    }
}
