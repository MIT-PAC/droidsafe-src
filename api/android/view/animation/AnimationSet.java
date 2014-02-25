package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;

public class AnimationSet extends Animation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.754 -0500", hash_original_field = "098C09D8EE99C82F678BC0CC99301385", hash_generated_field = "4E6A2393E3A41FF00CBD8150E755D9D3")

    private static final int PROPERTY_FILL_AFTER_MASK         = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.757 -0500", hash_original_field = "64BDDFBC94F24EE0CE217347E7DA15CF", hash_generated_field = "AF3B072AF41D6260060EBDA66CF66385")

    private static final int PROPERTY_FILL_BEFORE_MASK        = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.759 -0500", hash_original_field = "7E9762D11D7219E350419CA494D60FE9", hash_generated_field = "1FD86F067E7DF1209C97B9951E5A2D68")

    private static final int PROPERTY_REPEAT_MODE_MASK        = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.761 -0500", hash_original_field = "9679E5CB0A81986C5BAF9C920E23CBD9", hash_generated_field = "D59291534504149726C15D5B8C4B78EF")

    private static final int PROPERTY_START_OFFSET_MASK       = 0x8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.764 -0500", hash_original_field = "2E44688DBB9709E2033E8022526462A0", hash_generated_field = "16B7CB13D692AA5D34D2FE4D9F825737")

    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.766 -0500", hash_original_field = "3D237CBE2B4AD4F0A37D78B1821F1E6C", hash_generated_field = "4649CE1597E4F6226E08DA4CD678394F")

    private static final int PROPERTY_DURATION_MASK           = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.768 -0500", hash_original_field = "C3D760DB65E31496E055C2A5BB02C02C", hash_generated_field = "58E407F6C09F775B2C3112E974909A4B")

    private static final int PROPERTY_MORPH_MATRIX_MASK       = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.772 -0500", hash_original_field = "99C6F8D957A6BE4ED3BC4B3D46BBE024", hash_generated_field = "DD8036C86532BF82965105099123C6F4")

    private static final int PROPERTY_CHANGE_BOUNDS_MASK      = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.775 -0500", hash_original_field = "8E743C742F89AB1EF43FB68AB7D0544D", hash_generated_field = "F8991A4D76FA7127497F697B241FE789")

    private int mFlags = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.777 -0500", hash_original_field = "937A58EDA819AF8EFC516AEF82EA03FD", hash_generated_field = "8EC03BE3CD289D6F418E2CF7DC6F95E4")

    private boolean mDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.779 -0500", hash_original_field = "1AC2461A1D28BD4A761575600F97FDB9", hash_generated_field = "5E007DCC0C9F570E21A91D79E9C13C9C")

    private boolean mHasAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.781 -0500", hash_original_field = "851F35B8E77E128DAB737AF5E6F8582D", hash_generated_field = "73E0F51E2ECCC5C0D56C337BEBD9E384")

    private ArrayList<Animation> mAnimations = new ArrayList<Animation>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.783 -0500", hash_original_field = "0D034AC9673356F70D8070C2206FFC6D", hash_generated_field = "7C9616BD413863FD9A0B9027C75DAE9A")

    private Transformation mTempTransformation = new Transformation();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.786 -0500", hash_original_field = "35958363EF4ACA127C901937BD0C9DCA", hash_generated_field = "AF3B01ACE4EBE7EDEF6A14863051F362")

    private long mLastEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.788 -0500", hash_original_field = "EE026D6DD4C4CEEC9F3DD90E36088B3A", hash_generated_field = "4D3BA52AA4D41C4D38A585BCDB7160A1")

    private long[] mStoredOffsets;

    /**
     * Constructor used when an AnimationSet is loaded from a resource. 
     * 
     * @param context Application context to use
     * @param attrs Attribute set from which to read values
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.791 -0500", hash_original_method = "E48F61BFB7E750EB9CE1872A6E59F583", hash_generated_method = "EA0FE4A9169C252541507BD027C48061")
    
public AnimationSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        TypedArray a =
            context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AnimationSet);
        
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK,
                a.getBoolean(com.android.internal.R.styleable.AnimationSet_shareInterpolator, true));
        init();

        if (context.getApplicationInfo().targetSdkVersion >=
                Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            if (a.hasValue(com.android.internal.R.styleable.AnimationSet_duration)) {
                mFlags |= PROPERTY_DURATION_MASK;
            }
            if (a.hasValue(com.android.internal.R.styleable.AnimationSet_fillBefore)) {
                mFlags |= PROPERTY_FILL_BEFORE_MASK;
            }
            if (a.hasValue(com.android.internal.R.styleable.AnimationSet_fillAfter)) {
                mFlags |= PROPERTY_FILL_AFTER_MASK;
            }
            if (a.hasValue(com.android.internal.R.styleable.AnimationSet_repeatMode)) {
                mFlags |= PROPERTY_REPEAT_MODE_MASK;
            }
            if (a.hasValue(com.android.internal.R.styleable.AnimationSet_startOffset)) {
                mFlags |= PROPERTY_START_OFFSET_MASK;
            }
        }

        a.recycle();
    }
    
    /**
     * Constructor to use when building an AnimationSet from code
     * 
     * @param shareInterpolator Pass true if all of the animations in this set
     *        should use the interpolator assocciated with this AnimationSet.
     *        Pass false if each animation should use its own interpolator.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.794 -0500", hash_original_method = "40E1DAC9F5FF86741AE2A2FFD7F09052", hash_generated_method = "5F96F8968EED46B49569FF0B4F851825")
    
public AnimationSet(boolean shareInterpolator) {
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK, shareInterpolator);
        init();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.797 -0500", hash_original_method = "17885947D34B4C6D63222266DEE6E0A5", hash_generated_method = "2E96BAC66A376DD357922EA94394DACB")
    
@Override
    protected AnimationSet clone() throws CloneNotSupportedException {
        final AnimationSet animation = (AnimationSet) super.clone();
        animation.mTempTransformation = new Transformation();
        animation.mAnimations = new ArrayList<Animation>();

        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;

        for (int i = 0; i < count; i++) {
            animation.mAnimations.add(animations.get(i).clone());
        }

        return animation;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.800 -0500", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "0BC7EE29E2E86D930BE9DB77ED7692C9")
    
private void setFlag(int mask, boolean value) {
        if (value) {
            mFlags |= mask;
        } else {
            mFlags &= ~mask;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.802 -0500", hash_original_method = "96CA9C56EEADA219CA715399206CF9BC", hash_generated_method = "22467722B61DD6511447346A291AF139")
    
private void init() {
        mStartTime = 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.804 -0500", hash_original_method = "346D63116043912E4EE20FDCAED3D0BD", hash_generated_method = "7436D8398CE17BA81A0ABFB2B79B88C4")
    
@Override
    public void setFillAfter(boolean fillAfter) {
        mFlags |= PROPERTY_FILL_AFTER_MASK;
        super.setFillAfter(fillAfter);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.807 -0500", hash_original_method = "08C3166F3D09017C7ECB4F829DA334D1", hash_generated_method = "8AE67956F5C529B66EBFA44A82107535")
    
@Override
    public void setFillBefore(boolean fillBefore) {
        mFlags |= PROPERTY_FILL_BEFORE_MASK;
        super.setFillBefore(fillBefore);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.809 -0500", hash_original_method = "777D14C93CE8BFF50BC39E2E3CDE2663", hash_generated_method = "3FFCDB5E695C17CE7FEE74623942B0FC")
    
@Override
    public void setRepeatMode(int repeatMode) {
        mFlags |= PROPERTY_REPEAT_MODE_MASK;
        super.setRepeatMode(repeatMode);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.811 -0500", hash_original_method = "3C61E6DAB3DDF346757DEBEA1DAB7005", hash_generated_method = "B003ABC2F33AEA7F00993CB4B0253BD5")
    
@Override
    public void setStartOffset(long startOffset) {
        mFlags |= PROPERTY_START_OFFSET_MASK;
        super.setStartOffset(startOffset);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.815 -0500", hash_original_method = "32142259597E010D1F73DE9F53078982", hash_generated_method = "5785CD951D5B275F4F15CD179EB74C2C")
    
@Override
    public boolean hasAlpha() {
        if (mDirty) {
            mDirty = mHasAlpha = false;

            final int count = mAnimations.size();
            final ArrayList<Animation> animations = mAnimations;

            for (int i = 0; i < count; i++) {
                if (animations.get(i).hasAlpha()) {
                    mHasAlpha = true;
                    break;
                }
            }
        }

        return mHasAlpha;
    }

    /**
     * <p>Sets the duration of every child animation.</p>
     *
     * @param durationMillis the duration of the animation, in milliseconds, for
     *        every child in this set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.817 -0500", hash_original_method = "638E0400F0B782F58F566825CD0FEEA0", hash_generated_method = "B62706F06C31766D5E9CB6CCD160509F")
    
@Override
    public void setDuration(long durationMillis) {
        mFlags |= PROPERTY_DURATION_MASK;
        super.setDuration(durationMillis);
        mLastEnd = mStartOffset + mDuration;
    }

    /**
     * Add a child animation to this animation set.
     * The transforms of the child animations are applied in the order
     * that they were added
     * @param a Animation to add.
     */
    @DSComment("no actions/not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.820 -0500", hash_original_method = "F96436C1C98CEDEFC582978CFED41496", hash_generated_method = "A788A071F6C490FDA49F6AE24DF52612")
    
public void addAnimation(Animation a) {
        mAnimations.add(a);

        boolean noMatrix = (mFlags & PROPERTY_MORPH_MATRIX_MASK) == 0;
        if (noMatrix && a.willChangeTransformationMatrix()) {
            mFlags |= PROPERTY_MORPH_MATRIX_MASK;
        }

        boolean changeBounds = (mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == 0;
        if (changeBounds && a.willChangeTransformationMatrix()) {
            mFlags |= PROPERTY_CHANGE_BOUNDS_MASK;
        }

        if ((mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK) {
            mLastEnd = mStartOffset + mDuration;
        } else {
            if (mAnimations.size() == 1) {
                mDuration = a.getStartOffset() + a.getDuration();
                mLastEnd = mStartOffset + mDuration;
            } else {
                mLastEnd = Math.max(mLastEnd, a.getStartOffset() + a.getDuration());
                mDuration = mLastEnd - mStartOffset;
            }
        }

        mDirty = true;
    }
    
    /**
     * Sets the start time of this animation and all child animations
     * 
     * @see android.view.animation.Animation#setStartTime(long)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.823 -0500", hash_original_method = "ED7478CCB671993C959207E062C9FA4F", hash_generated_method = "C0F7D456301E3CE187BF24BFEC7EE750")
    
@Override
    public void setStartTime(long startTimeMillis) {
        super.setStartTime(startTimeMillis);

        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;

        for (int i = 0; i < count; i++) {
            Animation a = animations.get(i);
            a.setStartTime(startTimeMillis);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.825 -0500", hash_original_method = "1DB17F128BC07A7BFF2B0ED14844511C", hash_generated_method = "11AA6E9972AFB317CC8D09DAA10DD04F")
    
@Override
    public long getStartTime() {
        long startTime = Long.MAX_VALUE;

        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;

        for (int i = 0; i < count; i++) {
            Animation a = animations.get(i);
            startTime = Math.min(startTime, a.getStartTime());
        }

        return startTime;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.828 -0500", hash_original_method = "8BDDB0E57A894DBD22BE4F412303E6AB", hash_generated_method = "EFA93EEDB3370BADB4FAF0555FE465E2")
    
@Override
    public void restrictDuration(long durationMillis) {
        super.restrictDuration(durationMillis);

        final ArrayList<Animation> animations = mAnimations;
        int count = animations.size();

        for (int i = 0; i < count; i++) {
            animations.get(i).restrictDuration(durationMillis);
        }
    }
    
    /**
     * The duration of an AnimationSet is defined to be the 
     * duration of the longest child animation.
     * 
     * @see android.view.animation.Animation#getDuration()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.832 -0500", hash_original_method = "0C51A5B794999BCAB9F83D60602DBD5A", hash_generated_method = "E2BFC944BDADC3FFEC7434699CEC2D18")
    
@Override
    public long getDuration() {
        final ArrayList<Animation> animations = mAnimations;
        final int count = animations.size();
        long duration = 0;

        boolean durationSet = (mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK;
        if (durationSet) {
            duration = mDuration;
        } else {
            for (int i = 0; i < count; i++) {
                duration = Math.max(duration, animations.get(i).getDuration());
            }
        }

        return duration;
    }

    /**
     * The duration hint of an animation set is the maximum of the duration
     * hints of all of its component animations.
     * 
     * @see android.view.animation.Animation#computeDurationHint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.834 -0500", hash_original_method = "979F8D0FD623C4002C8BD37290EA10AA", hash_generated_method = "657D400E7F73A95B7A1DCD95F9ECED7D")
    
public long computeDurationHint() {
        long duration = 0;
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
        for (int i = count - 1; i >= 0; --i) {
            final long d = animations.get(i).computeDurationHint();
            if (d > duration) duration = d;
        }
        return duration;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.837 -0500", hash_original_method = "357CAB1AB4D965ADF6EAF9B7256F84EE", hash_generated_method = "F4E21A1F2F3EE535811830B0DB1B4B18")
    
public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        final RectF region = mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);

        if (mFillBefore) {
            final int count = mAnimations.size();
            final ArrayList<Animation> animations = mAnimations;
            final Transformation temp = mTempTransformation;

            final Transformation previousTransformation = mPreviousTransformation;

            for (int i = count - 1; i >= 0; --i) {
                final Animation a = animations.get(i);

                temp.clear();
                final Interpolator interpolator = a.mInterpolator;
                a.applyTransformation(interpolator != null ? interpolator.getInterpolation(0.0f)
                        : 0.0f, temp);
                previousTransformation.compose(temp);
            }
        }
    }

    /**
     * The transformation of an animation set is the concatenation of all of its
     * component animations.
     * 
     * @see android.view.animation.Animation#getTransformation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.840 -0500", hash_original_method = "3F803CA56592D1A8F5A2DABD815E935C", hash_generated_method = "4FF62ACBF95C2E0547E642E3767F9D58")
    
@Override
    public boolean getTransformation(long currentTime, Transformation t) {
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
        final Transformation temp = mTempTransformation;

        boolean more = false;
        boolean started = false;
        boolean ended = true;

        t.clear();

        for (int i = count - 1; i >= 0; --i) {
            final Animation a = animations.get(i);

            temp.clear();
            more = a.getTransformation(currentTime, temp, getScaleFactor()) || more;
            t.compose(temp);

            started = started || a.hasStarted();
            ended = a.hasEnded() && ended;
        }

        if (started && !mStarted) {
            if (mListener != null) {
                mListener.onAnimationStart(this);
            }
            mStarted = true;
        }

        if (ended != mEnded) {
            if (mListener != null) {
                mListener.onAnimationEnd(this);
            }
            mEnded = ended;
        }

        return more;
    }
    
    /**
     * @see android.view.animation.Animation#scaleCurrentDuration(float)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.842 -0500", hash_original_method = "2134BF7993F0D641B52B56C7C0A9A6E5", hash_generated_method = "34991A2E2326CFF66DD93E82A74BB038")
    
@Override
    public void scaleCurrentDuration(float scale) {
        final ArrayList<Animation> animations = mAnimations;
        int count = animations.size();
        for (int i = 0; i < count; i++) {
            animations.get(i).scaleCurrentDuration(scale);
        }
    }

    /**
     * @see android.view.animation.Animation#initialize(int, int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.846 -0500", hash_original_method = "CAD543A8149EEDE67DD6611F7E4BF120", hash_generated_method = "B058C8FBF66C4429633FCC8855C0FFF9")
    
@Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        boolean durationSet = (mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK;
        boolean fillAfterSet = (mFlags & PROPERTY_FILL_AFTER_MASK) == PROPERTY_FILL_AFTER_MASK;
        boolean fillBeforeSet = (mFlags & PROPERTY_FILL_BEFORE_MASK) == PROPERTY_FILL_BEFORE_MASK;
        boolean repeatModeSet = (mFlags & PROPERTY_REPEAT_MODE_MASK) == PROPERTY_REPEAT_MODE_MASK;
        boolean shareInterpolator = (mFlags & PROPERTY_SHARE_INTERPOLATOR_MASK)
                == PROPERTY_SHARE_INTERPOLATOR_MASK;
        boolean startOffsetSet = (mFlags & PROPERTY_START_OFFSET_MASK)
                == PROPERTY_START_OFFSET_MASK;

        if (shareInterpolator) {
            ensureInterpolator();
        }

        final ArrayList<Animation> children = mAnimations;
        final int count = children.size();

        final long duration = mDuration;
        final boolean fillAfter = mFillAfter;
        final boolean fillBefore = mFillBefore;
        final int repeatMode = mRepeatMode;
        final Interpolator interpolator = mInterpolator;
        final long startOffset = mStartOffset;

        long[] storedOffsets = mStoredOffsets;
        if (startOffsetSet) {
            if (storedOffsets == null || storedOffsets.length != count) {
                storedOffsets = mStoredOffsets = new long[count];
            }
        } else if (storedOffsets != null) {
            storedOffsets = mStoredOffsets = null;
        }

        for (int i = 0; i < count; i++) {
            Animation a = children.get(i);
            if (durationSet) {
                a.setDuration(duration);
            }
            if (fillAfterSet) {
                a.setFillAfter(fillAfter);
            }
            if (fillBeforeSet) {
                a.setFillBefore(fillBefore);
            }
            if (repeatModeSet) {
                a.setRepeatMode(repeatMode);
            }
            if (shareInterpolator) {
                a.setInterpolator(interpolator);
            }
            if (startOffsetSet) {
                long offset = a.getStartOffset();
                a.setStartOffset(offset + startOffset);
                storedOffsets[i] = offset;
            }
            a.initialize(width, height, parentWidth, parentHeight);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.848 -0500", hash_original_method = "2E3A361BE20A8D002834672DDB7CD636", hash_generated_method = "13687E2B179AC932D6BE382305D2673C")
    
@Override
    public void reset() {
        super.reset();
        restoreChildrenStartOffset();
    }

    /**
     * @hide
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.851 -0500", hash_original_method = "1FA58C163A7DB9A5169EF699805FA3C9", hash_generated_method = "1FA58C163A7DB9A5169EF699805FA3C9")
    
void restoreChildrenStartOffset() {
        final long[] offsets = mStoredOffsets;
        if (offsets == null) return;

        final ArrayList<Animation> children = mAnimations;
        final int count = children.size();

        for (int i = 0; i < count; i++) {
            children.get(i).setStartOffset(offsets[i]);
        }
    }

    /**
     * @return All the child animations in this AnimationSet. Note that
     * this may include other AnimationSets, which are not expanded.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.853 -0500", hash_original_method = "EC73055689DC3CDB2DE15C42C77CE8EF", hash_generated_method = "8FF4FC1611CE4FC4FB5098A0E6C00EF7")
    
public List<Animation> getAnimations() {
        return mAnimations;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.855 -0500", hash_original_method = "007230E9C632DD7C25BB9E67DB11C3C3", hash_generated_method = "F85437EA75506FCABF9E7778CA95ED2B")
    
@Override
    public boolean willChangeTransformationMatrix() {
        return (mFlags & PROPERTY_MORPH_MATRIX_MASK) == PROPERTY_MORPH_MATRIX_MASK;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.857 -0500", hash_original_method = "A538326162AE4CED46022318A3520B17", hash_generated_method = "B2A6FB4160B2C2747A8ABC85F8BBD2AC")
    
@Override
    public boolean willChangeBounds() {
        return (mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == PROPERTY_CHANGE_BOUNDS_MASK;
    }
}

