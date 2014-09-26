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
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

/**
 * The SwipeRefreshLayout should be used whenever the user can refresh the
 * contents of a view via a vertical swipe gesture. The activity that
 * instantiates this view should add an OnRefreshListener to be notified
 * whenever the swipe to refresh gesture is completed. The SwipeRefreshLayout
 * will notify the listener each and every time the gesture is completed again;
 * the listener is responsible for correctly determining when to actually
 * initiate a refresh of its content. If the listener determines there should
 * not be a refresh, it must call setRefreshing(false) to cancel any visual
 * indication of a refresh. If an activity wishes to show just the progress
 * animation, it should call setRefreshing(true). To disable the gesture and progress
 * animation, call setEnabled(false) on the view.
 *
 * <p> This layout should be made the parent of the view that will be refreshed as a
 * result of the gesture and can only support one direct child. This view will
 * also be made the target of the gesture and will be forced to match both the
 * width and the height supplied in this layout. The SwipeRefreshLayout does not
 * provide accessibility events; instead, a menu item must be provided to allow
 * refresh of the content wherever this gesture is used.</p>
 */
public class SwipeRefreshLayout extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.765 -0400", hash_original_field = "50A18E47612219169316AE37A756C38B", hash_generated_field = "C5FF78A0C27740DE50CD9DABCCE182C3")

    private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.768 -0400", hash_original_field = "A016E9E38F81665D20E41BF5778925F3", hash_generated_field = "245A91EFE3774DECD5C39030EACE9593")

    private static final long RETURN_TO_ORIGINAL_POSITION_TIMEOUT = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.771 -0400", hash_original_field = "B6D869065A167142D6D4F665566DCA57", hash_generated_field = "8DFFCAA4DAACE30D95D08733D5D74A8A")

    private static final float ACCELERATE_INTERPOLATION_FACTOR = 1.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.774 -0400", hash_original_field = "002F103CA7972D6C69EE8AC2744B1323", hash_generated_field = "53487C5673C294D762848A6369B73806")

    private static final float DECELERATE_INTERPOLATION_FACTOR = 2f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.778 -0400", hash_original_field = "04C779C5870F89C7B97D8FBD9CFE5190", hash_generated_field = "6E9BDC892C0823D51B7C3C2948AB4FE8")

    private static final float PROGRESS_BAR_HEIGHT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.781 -0400", hash_original_field = "BC7781EDE640404546FF0AC167E674FF", hash_generated_field = "032F426F5B8AA6DD64D1824F40ECFB33")

    private static final float MAX_SWIPE_DISTANCE_FACTOR = .6f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.784 -0400", hash_original_field = "C8DC822CAAEEEE23120E460C8F8FC485", hash_generated_field = "AEA1B6947A377E2785F5F0419744CA3D")

    private static final int REFRESH_TRIGGER_DISTANCE = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.787 -0400", hash_original_field = "394D213079DFA0C7024EC13F5673BC94", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.848 -0400", hash_original_field = "C843752033702DC292B8CFC6AAC88F42", hash_generated_field = "E19FC1F58C15705FE751E8DA8477184A")

    private static final int[] LAYOUT_ATTRS = new int[] {
        android.R.attr.enabled
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.790 -0400", hash_original_field = "4B313302002420EBD4325A6E7AB440FA", hash_generated_field = "7772C98829B73BEA50250B98BD908BA1")

    private SwipeProgressBar mProgressBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.793 -0400", hash_original_field = "852A5F36228F419DA7A4F36BB5C9B7E4", hash_generated_field = "C895A302A5EAB442D8936D160230E131")

    private View mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.796 -0400", hash_original_field = "9DB9F22A16B018BD51EAF343499032F2", hash_generated_field = "3508C51EA2896E8CC25947DA22753A26")

    private int mOriginalOffsetTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.798 -0400", hash_original_field = "B0FE1C13BC3592777092398864A9DB5D", hash_generated_field = "281BF5B366247198C52DE7D52456F84E")

    private OnRefreshListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.801 -0400", hash_original_field = "90BBA3355E6267427C684DA37D63DEF0", hash_generated_field = "24B6498B57A4DDD67F7E9CE57E59205C")

    private int mFrom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.804 -0400", hash_original_field = "DC5FE9BC2F31B63B0BB7C7634F95D344", hash_generated_field = "F0EFD1A963C5A2DA985DAC45BE6CA53D")

    private boolean mRefreshing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.807 -0400", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.810 -0400", hash_original_field = "0F8F7AFF0D85528D1563F08142501E13", hash_generated_field = "11EAD8B0FB9940F1A92244C888035114")

    private float mDistanceToTriggerSync = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.813 -0400", hash_original_field = "B60BAD9578DD9959ECA868CC706D12BE", hash_generated_field = "B33F56E3FB57F3719E543C6B7AEBED20")

    private int mMediumAnimationDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.816 -0400", hash_original_field = "893C7ABC2B2C714365FDA5EBFADA45E4", hash_generated_field = "D32E25DB4002039E8339D32F25C26783")

    private float mFromPercentage = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.819 -0400", hash_original_field = "D5B34A7E983C64B5EF0DE9D248C271FF", hash_generated_field = "BE887935FAD4098A752B488BA2F4D35E")

    private float mCurrPercentage = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.821 -0400", hash_original_field = "CE71D8E261D1959DDC52AB37F43011F5", hash_generated_field = "E94A9D38733881973BA081B02F62F48A")

    private int mProgressBarHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.824 -0400", hash_original_field = "B11BB5ABDCF267F2E928E00000458423", hash_generated_field = "2CE3A503C24465E48D5874AA5CEE56C0")

    private int mCurrentTargetOffsetTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.827 -0400", hash_original_field = "8405CC958EF7FF178B766BCBE27E1F2F", hash_generated_field = "123A2D63D23BC6C888D43FC39BEED8A4")

    private float mInitialMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.830 -0400", hash_original_field = "3611C70C88BA02D959402D97DECB16F3", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.833 -0400", hash_original_field = "73B01D10CAB8E5404C455A1ADEF4EF2A", hash_generated_field = "B59FB434376CFD18468CB8F7DF43173C")

    private boolean mIsBeingDragged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.836 -0400", hash_original_field = "D0914C40920996908439839B104BE272", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.838 -0400", hash_original_field = "4C5FE89C5DA4F0B380D53F8AA5775C48", hash_generated_field = "2E0B64A3E6FDD10B38E6053BD52032D8")

    // refresh was triggered.
    private boolean mReturningToStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.842 -0400", hash_original_field = "D76ECF94FC601CE651E7BE010431EA1F", hash_generated_field = "C334F7943F783D99D1E36FD5D491C172")

    private  DecelerateInterpolator mDecelerateInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.845 -0400", hash_original_field = "C7E03331DF22344E2575609AF27F5DFF", hash_generated_field = "3F93B8E718DC53012CAAFB4B54F9AC1F")

    private  AccelerateInterpolator mAccelerateInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.856 -0400", hash_original_field = "8DA0CA6BED5C38779291D6365E97FE1D", hash_generated_field = "D1A174982F879D58831F731F413547EB")

    private final Animation mAnimateToStartPosition = new Animation() {
        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            int targetTop = 0;
            if (mFrom != mOriginalOffsetTop) {
                targetTop = (mFrom + (int)((mOriginalOffsetTop - mFrom) * interpolatedTime));
            }
            int offset = targetTop - mTarget.getTop();
            final int currentTop = mTarget.getTop();
            if (offset + currentTop < 0) {
                offset = 0 - currentTop;
            }
            setTargetOffsetTopAndBottom(offset);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.864 -0400", hash_original_field = "2857EEBDC53EDD94FFBFF727CE58D2F7", hash_generated_field = "46EAA0EB51F9D3F354E30186AE5366B0")

    private Animation mShrinkTrigger = new Animation() {
        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            float percent = mFromPercentage + ((0 - mFromPercentage) * interpolatedTime);
            mProgressBar.setTriggerPercentage(percent);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.872 -0400", hash_original_field = "C3944EDDA133817864D74534602864F4", hash_generated_field = "84A5699F2AE3E3B4AF7D0C5B8C460903")

    private final AnimationListener mReturnToStartPositionListener = new BaseAnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            // Once the target content has returned to its start position, reset
            // the target offset to 0
            mCurrentTargetOffsetTop = 0;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.879 -0400", hash_original_field = "184F107040865BD0A3C5CFCDDF203CE7", hash_generated_field = "6E83D3C8264E3A51E1BAD580B7A925FF")

    private final AnimationListener mShrinkAnimationListener = new BaseAnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            mCurrPercentage = 0;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.886 -0400", hash_original_field = "CA35472D8A7E7BDE7A7E40DC67D291F9", hash_generated_field = "CF8A92EE20C6EC0C186707AA6AB2F6AF")

    private final Runnable mReturnToStartPosition = new Runnable() {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void run() {
            mReturningToStart = true;
            animateOffsetToStartPosition(mCurrentTargetOffsetTop + getPaddingTop(),
                    mReturnToStartPositionListener);
        }

    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.895 -0400", hash_original_field = "54EAC5BFB61A76A86F7DD54D86E88099", hash_generated_field = "EE796E1B94EB6A80771EE959D629A3C4")

    private final Runnable mCancel = new Runnable() {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void run() {
            mReturningToStart = true;
            // Timeout fired since the user last moved their finger; animate the
            // trigger to 0 and put the target back at its original position
            if (mProgressBar != null) {
                mFromPercentage = mCurrPercentage;
                mShrinkTrigger.setDuration(mMediumAnimationDuration);
                mShrinkTrigger.setAnimationListener(mShrinkAnimationListener);
                mShrinkTrigger.reset();
                mShrinkTrigger.setInterpolator(mDecelerateInterpolator);
                startAnimation(mShrinkTrigger);
            }
            animateOffsetToStartPosition(mCurrentTargetOffsetTop + getPaddingTop(),
                    mReturnToStartPositionListener);
        }

    };

    /**
     * Simple constructor to use when creating a SwipeRefreshLayout from code.
     * @param context
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.898 -0400", hash_original_method = "40450DEB549FCCD1104814EE8BA0CD5F", hash_generated_method = "A986C2DF5FBFCD0FACF93EFEA05DBAB1")
    
public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    /**
     * Constructor that is called when inflating SwipeRefreshLayout from XML.
     * @param context
     * @param attrs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.903 -0400", hash_original_method = "21E998C8029EB9485DDD4409A6040166", hash_generated_method = "40C94F3299C979282331D3B2C0790669")
    
public SwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        mMediumAnimationDuration = getResources().getInteger(
                android.R.integer.config_mediumAnimTime);

        setWillNotDraw(false);
        mProgressBar = new SwipeProgressBar(this);
        final DisplayMetrics metrics = getResources().getDisplayMetrics();
        mProgressBarHeight = (int) (metrics.density * PROGRESS_BAR_HEIGHT);
        mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        mAccelerateInterpolator = new AccelerateInterpolator(ACCELERATE_INTERPOLATION_FACTOR);

        final TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
        setEnabled(a.getBoolean(0, true));
        a.recycle();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.906 -0400", hash_original_method = "3D165BFECE779D7D42F1138DD9BB10A1", hash_generated_method = "ECC326EFC7D2D1C435D30A0D15E6EEAC")
    
@Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(mCancel);
        removeCallbacks(mReturnToStartPosition);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.909 -0400", hash_original_method = "6525E8CB9656F080FA503EFF86B8D2E1", hash_generated_method = "6189EA735F44EB4899A9C579FE66A12D")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mReturnToStartPosition);
        removeCallbacks(mCancel);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.913 -0400", hash_original_method = "35CDC380E2A2A758436FBF1265AE98A4", hash_generated_method = "9515BAFB2BD372F002B6B8805BBB4CCE")
    
private void animateOffsetToStartPosition(int from, AnimationListener listener) {
        mFrom = from;
        mAnimateToStartPosition.reset();
        mAnimateToStartPosition.setDuration(mMediumAnimationDuration);
        mAnimateToStartPosition.setAnimationListener(listener);
        mAnimateToStartPosition.setInterpolator(mDecelerateInterpolator);
        mTarget.startAnimation(mAnimateToStartPosition);
    }

    /**
     * Set the listener to be notified when a refresh is triggered via the swipe
     * gesture.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.916 -0400", hash_original_method = "56F9C4FF3EC5C306E13730D4A9123F54", hash_generated_method = "57C434E02B0E7E2C8F6F5DBD98A233D1")
    
public void setOnRefreshListener(OnRefreshListener listener) {
        mListener = listener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.919 -0400", hash_original_method = "9BD4C85542B0E9E6237E7481D15CA6CB", hash_generated_method = "CA7958F515FEA54CE97DF0DE21C7C1C4")
    
private void setTriggerPercentage(float percent) {
        if (percent == 0f) {
            // No-op. A null trigger means it's uninitialized, and setting it to zero-percent
            // means we're trying to reset state, so there's nothing to reset in this case.
            mCurrPercentage = 0;
            return;
        }
        mCurrPercentage = percent;
        mProgressBar.setTriggerPercentage(percent);
    }

    /**
     * Notify the widget that refresh state has changed. Do not call this when
     * refresh is triggered by a swipe gesture.
     *
     * @param refreshing Whether or not the view should show refresh progress.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.922 -0400", hash_original_method = "38B05F87B627D6B2265B3ED7E489E7E3", hash_generated_method = "FCE6402494ADFAA5D1F62DD65E96C00A")
    
public void setRefreshing(boolean refreshing) {
        if (mRefreshing != refreshing) {
            ensureTarget();
            mCurrPercentage = 0;
            mRefreshing = refreshing;
            if (mRefreshing) {
                mProgressBar.start();
            } else {
                mProgressBar.stop();
            }
        }
    }

    /**
     * @deprecated Use {@link #setColorSchemeResources(int, int, int, int)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.927 -0400", hash_original_method = "6997696139732018B79B2D511EC9ED62", hash_generated_method = "B0E618D50AD01DD69CECD0F0C8AA7987")
    
@Deprecated
    public void setColorScheme(int colorRes1, int colorRes2, int colorRes3, int colorRes4) {
        setColorSchemeResources(colorRes1, colorRes2, colorRes3, colorRes4);
    }

    /**
     * Set the four colors used in the progress animation from color resources.
     * The first color will also be the color of the bar that grows in response
     * to a user swipe gesture.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.930 -0400", hash_original_method = "0E7A28D063B01B12BE60C40B12A03B10", hash_generated_method = "CCE5CB89223B763F4A8600220BBCE8CC")
    
public void setColorSchemeResources(int colorRes1, int colorRes2, int colorRes3,
            int colorRes4) {
        final Resources res = getResources();
        setColorSchemeColors(res.getColor(colorRes1), res.getColor(colorRes2),
                res.getColor(colorRes3), res.getColor(colorRes4));
    }

    /**
     * Set the four colors used in the progress animation. The first color will
     * also be the color of the bar that grows in response to a user swipe
     * gesture.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.934 -0400", hash_original_method = "9EAA9454083F13D1B9044B9DBDC17E54", hash_generated_method = "242A63C2EDAB80F374868AD578754C01")
    
public void setColorSchemeColors(int color1, int color2, int color3, int color4) {
        ensureTarget();
        mProgressBar.setColorScheme(color1, color2, color3, color4);
    }

    /**
     * @return Whether the SwipeRefreshWidget is actively showing refresh
     *         progress.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.936 -0400", hash_original_method = "94CF2628AA97C6B705551177596B7B0C", hash_generated_method = "35B782EB9F3B0CF030529C0DAD4C2ECE")
    
public boolean isRefreshing() {
        return mRefreshing;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.940 -0400", hash_original_method = "4CCB40E4AF1A19D516D9C6F00CE1B10A", hash_generated_method = "53FFFD90557921AD389543FC055E8270")
    
private void ensureTarget() {
        // Don't bother getting the parent height if the parent hasn't been laid out yet.
        if (mTarget == null) {
            if (getChildCount() > 1 && !isInEditMode()) {
                throw new IllegalStateException(
                        "SwipeRefreshLayout can host only one direct child");
            }
            mTarget = getChildAt(0);
            mOriginalOffsetTop = mTarget.getTop() + getPaddingTop();
        }
        if (mDistanceToTriggerSync == -1) {
            if (getParent() != null && ((View)getParent()).getHeight() > 0) {
                final DisplayMetrics metrics = getResources().getDisplayMetrics();
                mDistanceToTriggerSync = (int) Math.min(
                        ((View) getParent()) .getHeight() * MAX_SWIPE_DISTANCE_FACTOR,
                                REFRESH_TRIGGER_DISTANCE * metrics.density);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.943 -0400", hash_original_method = "608544966ADBCB919CBD1D90B1E5B743", hash_generated_method = "3C351ABB343FC6FB4C2CBEF225BC5B75")
    
@Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mProgressBar.draw(canvas);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.947 -0400", hash_original_method = "93969D600E5FE7D865446722FEF0BD17", hash_generated_method = "35202DF949D61EA5EEB60D60429D5377")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int width =  getMeasuredWidth();
        final int height = getMeasuredHeight();
        mProgressBar.setBounds(0, 0, width, mProgressBarHeight);
        if (getChildCount() == 0) {
            return;
        }
        final View child = getChildAt(0);
        final int childLeft = getPaddingLeft();
        final int childTop = mCurrentTargetOffsetTop + getPaddingTop();
        final int childWidth = width - getPaddingLeft() - getPaddingRight();
        final int childHeight = height - getPaddingTop() - getPaddingBottom();
        child.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.951 -0400", hash_original_method = "234F5C6C02FB48DC53A76582F231DA29", hash_generated_method = "955DB59FE3B555BDFAB1A69CAE173402")
    
@Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 1 && !isInEditMode()) {
            throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
        }
        if (getChildCount() > 0) {
            getChildAt(0).measure(
                    MeasureSpec.makeMeasureSpec(
                            getMeasuredWidth() - getPaddingLeft() - getPaddingRight(),
                            MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(
                            getMeasuredHeight() - getPaddingTop() - getPaddingBottom(),
                            MeasureSpec.EXACTLY));
        }
    }

    /**
     * @return Whether it is possible for the child view of this layout to
     *         scroll up. Override this if the child view is a custom view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.955 -0400", hash_original_method = "B601FF077A2397A8086214412F14617F", hash_generated_method = "3B6020F55923E98E93C1130E772D5D85")
    
public boolean canChildScrollUp() {
        if (android.os.Build.VERSION.SDK_INT < 14) {
            if (mTarget instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) mTarget;
                return absListView.getChildCount() > 0
                        && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0)
                                .getTop() < absListView.getPaddingTop());
            } else {
                return mTarget.getScrollY() > 0;
            }
        } else {
            return ViewCompat.canScrollVertically(mTarget, -1);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.962 -0400", hash_original_method = "544531D5715382C4CABFA2FF4301668C", hash_generated_method = "01568DA76E26064AE3DDC954930D2F94")
    
@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ensureTarget();

        final int action = MotionEventCompat.getActionMasked(ev);

        if (mReturningToStart && action == MotionEvent.ACTION_DOWN) {
            mReturningToStart = false;
        }

        if (!isEnabled() || mReturningToStart || canChildScrollUp()) {
            // Fail fast if we're not in a state where a swipe is possible
            return false;
        }

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastMotionY = mInitialMotionY = ev.getY();
                mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                mIsBeingDragged = false;
                mCurrPercentage = 0;
                break;

            case MotionEvent.ACTION_MOVE:
                if (mActivePointerId == INVALID_POINTER) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }

                final int pointerIndex = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
                if (pointerIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }

                final float y = MotionEventCompat.getY(ev, pointerIndex);
                final float yDiff = y - mInitialMotionY;
                if (yDiff > mTouchSlop) {
                    mLastMotionY = y;
                    mIsBeingDragged = true;
                }
                break;

            case MotionEventCompat.ACTION_POINTER_UP:
                onSecondaryPointerUp(ev);
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mIsBeingDragged = false;
                mCurrPercentage = 0;
                mActivePointerId = INVALID_POINTER;
                break;
        }

        return mIsBeingDragged;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.966 -0400", hash_original_method = "004563EBE063034C310708E57B03CED4", hash_generated_method = "219A1730F25E577FA6FDC5714683C14E")
    
@Override
    public void requestDisallowInterceptTouchEvent(boolean b) {
        // Nope.
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.971 -0400", hash_original_method = "15832DCC41E32B0FED35CAB187051833", hash_generated_method = "9CA32240278485B1F0FF75718116B68A")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);

        if (mReturningToStart && action == MotionEvent.ACTION_DOWN) {
            mReturningToStart = false;
        }

        if (!isEnabled() || mReturningToStart || canChildScrollUp()) {
            // Fail fast if we're not in a state where a swipe is possible
            return false;
        }

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastMotionY = mInitialMotionY = ev.getY();
                mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                mIsBeingDragged = false;
                mCurrPercentage = 0;
                break;

            case MotionEvent.ACTION_MOVE:
                final int pointerIndex = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
                if (pointerIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }

                final float y = MotionEventCompat.getY(ev, pointerIndex);
                final float yDiff = y - mInitialMotionY;

                if (!mIsBeingDragged && yDiff > mTouchSlop) {
                    mIsBeingDragged = true;
                }

                if (mIsBeingDragged) {
                    // User velocity passed min velocity; trigger a refresh
                    if (yDiff > mDistanceToTriggerSync) {
                        // User movement passed distance; trigger a refresh
                        startRefresh();
                    } else {
                        // Just track the user's movement
                        setTriggerPercentage(
                                mAccelerateInterpolator.getInterpolation(
                                        yDiff / mDistanceToTriggerSync));
                        updateContentOffsetTop((int) (yDiff));
                        if (mLastMotionY > y && mTarget.getTop() == getPaddingTop()) {
                            // If the user puts the view back at the top, we
                            // don't need to. This shouldn't be considered
                            // cancelling the gesture as the user can restart from the top.
                            removeCallbacks(mCancel);
                        } else {
                            updatePositionTimeout();
                        }
                    }
                    mLastMotionY = y;
                }
                break;

            case MotionEventCompat.ACTION_POINTER_DOWN: {
                final int index = MotionEventCompat.getActionIndex(ev);
                mLastMotionY = MotionEventCompat.getY(ev, index);
                mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                break;
            }

            case MotionEventCompat.ACTION_POINTER_UP:
                onSecondaryPointerUp(ev);
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mIsBeingDragged = false;
                mCurrPercentage = 0;
                mActivePointerId = INVALID_POINTER;
                return false;
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.974 -0400", hash_original_method = "58BB2098DCFC98AA6B90735D08DFA1BF", hash_generated_method = "E9FB6E335729BB43583DC8694A9841F9")
    
private void startRefresh() {
        removeCallbacks(mCancel);
        mReturnToStartPosition.run();
        setRefreshing(true);
        mListener.onRefresh();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.979 -0400", hash_original_method = "FFF9C12FAA7545F4A9EA8E78D88D6D8C", hash_generated_method = "658AEC053134EBF11B26B2AA2E289B96")
    
private void updateContentOffsetTop(int targetTop) {
        final int currentTop = mTarget.getTop();
        if (targetTop > mDistanceToTriggerSync) {
            targetTop = (int) mDistanceToTriggerSync;
        } else if (targetTop < 0) {
            targetTop = 0;
        }
        setTargetOffsetTopAndBottom(targetTop - currentTop);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.983 -0400", hash_original_method = "41C491EF516AF0CD32DFE18410BCE502", hash_generated_method = "FC4417FDA5E7D5D0D143FB1FE214A951")
    
private void setTargetOffsetTopAndBottom(int offset) {
        mTarget.offsetTopAndBottom(offset);
        mCurrentTargetOffsetTop = mTarget.getTop();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.988 -0400", hash_original_method = "D9A272DE451AB1025BB1CFD31664AEB3", hash_generated_method = "252219E3564F9930BFE4F016AD23E64F")
    
private void updatePositionTimeout() {
        removeCallbacks(mCancel);
        postDelayed(mCancel, RETURN_TO_ORIGINAL_POSITION_TIMEOUT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:11.994 -0400", hash_original_method = "97862B3FFA37C2623BB875BD793331D3", hash_generated_method = "609BFA1E4065C06539D8D1B5782D144C")
    
private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = MotionEventCompat.getActionIndex(ev);
        final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
        if (pointerId == mActivePointerId) {
            // This was our active pointer going up. Choose a new
            // active pointer and adjust accordingly.
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mLastMotionY = MotionEventCompat.getY(ev, newPointerIndex);
            mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
        }
    }

    /**
     * Classes that wish to be notified when the swipe gesture correctly
     * triggers a refresh should implement this interface.
     */
    public interface OnRefreshListener {
        public void onRefresh();
    }

    /**
     * Simple AnimationListener to avoid having to implement unneeded methods in
     * AnimationListeners.
     */
    private class BaseAnimationListener implements AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
