package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class AnimationSet extends Animation {
    private int mFlags = 0;
    private boolean mDirty;
    private boolean mHasAlpha;
    private ArrayList<Animation> mAnimations = new ArrayList<Animation>();
    private Transformation mTempTransformation = new Transformation();
    private long mLastEnd;
    private long[] mStoredOffsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.026 -0400", hash_original_method = "E48F61BFB7E750EB9CE1872A6E59F583", hash_generated_method = "53A9BEA5088FBD86A90DBD8EDD8956B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AnimationSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AnimationSet);
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK,
                a.getBoolean(com.android.internal.R.styleable.AnimationSet_shareInterpolator, true));
        init();
        {
            boolean var2026BAD09B30E00531380AA0AD5347B0_363149609 = (context.getApplicationInfo().targetSdkVersion >=
                Build.VERSION_CODES.ICE_CREAM_SANDWICH);
            {
                {
                    boolean varAB9E1DA2B763B3C2704210D390F5B692_994461479 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_duration));
                    {
                        mFlags |= PROPERTY_DURATION_MASK;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var7BF613E6FCAED02536A8D4C74FF9C55D_1221873252 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_fillBefore));
                    {
                        mFlags |= PROPERTY_FILL_BEFORE_MASK;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varD72A102A08FCBE04AFEA1289372E1DDD_1060732912 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_fillAfter));
                    {
                        mFlags |= PROPERTY_FILL_AFTER_MASK;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2957C54AD2EA755A7DF1B0292AD3945E_707025041 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_repeatMode));
                    {
                        mFlags |= PROPERTY_REPEAT_MODE_MASK;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2A787A7DA9E50B2DF1528034DA0EA71F_1422015021 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_startOffset));
                    {
                        mFlags |= PROPERTY_START_OFFSET_MASK;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.026 -0400", hash_original_method = "40E1DAC9F5FF86741AE2A2FFD7F09052", hash_generated_method = "EBDD4B4A0C0B9651FE96538BEC9CD72F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AnimationSet(boolean shareInterpolator) {
        dsTaint.addTaint(shareInterpolator);
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK, shareInterpolator);
        init();
        // ---------- Original Method ----------
        //setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK, shareInterpolator);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.026 -0400", hash_original_method = "17885947D34B4C6D63222266DEE6E0A5", hash_generated_method = "85A8B2E6BCB1F502689C3CDDAC79B9A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected AnimationSet clone() throws CloneNotSupportedException {
        AnimationSet animation;
        animation = (AnimationSet) super.clone();
        animation.mTempTransformation = new Transformation();
        animation.mAnimations = new ArrayList<Animation>();
        int count;
        count = mAnimations.size();
        ArrayList<Animation> animations;
        animations = mAnimations;
        {
            int i;
            i = 0;
            {
                animation.mAnimations.add(animations.get(i).clone());
            } //End block
        } //End collapsed parenthetic
        return (AnimationSet)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final AnimationSet animation = (AnimationSet) super.clone();
        //animation.mTempTransformation = new Transformation();
        //animation.mAnimations = new ArrayList<Animation>();
        //final int count = mAnimations.size();
        //final ArrayList<Animation> animations = mAnimations;
        //for (int i = 0; i < count; i++) {
            //animation.mAnimations.add(animations.get(i).clone());
        //}
        //return animation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.027 -0400", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "1FA354DD6E17D1276EC7489F3422DE55")
    @DSModeled(DSC.SAFE)
    private void setFlag(int mask, boolean value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(mask);
        {
            mFlags &= ~mask;
        } //End block
        // ---------- Original Method ----------
        //if (value) {
            //mFlags |= mask;
        //} else {
            //mFlags &= ~mask;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.027 -0400", hash_original_method = "96CA9C56EEADA219CA715399206CF9BC", hash_generated_method = "C0944DDBBB8FF4378AF642CA83ECA72A")
    @DSModeled(DSC.SAFE)
    private void init() {
        mStartTime = 0;
        // ---------- Original Method ----------
        //mStartTime = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.027 -0400", hash_original_method = "346D63116043912E4EE20FDCAED3D0BD", hash_generated_method = "B6665B5BF4581F5A20D8B5A4F1B5AFE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFillAfter(boolean fillAfter) {
        dsTaint.addTaint(fillAfter);
        mFlags |= PROPERTY_FILL_AFTER_MASK;
        super.setFillAfter(fillAfter);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_FILL_AFTER_MASK;
        //super.setFillAfter(fillAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.027 -0400", hash_original_method = "08C3166F3D09017C7ECB4F829DA334D1", hash_generated_method = "9F4ED8F94CD0E53440EF5C67033ADD8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFillBefore(boolean fillBefore) {
        dsTaint.addTaint(fillBefore);
        mFlags |= PROPERTY_FILL_BEFORE_MASK;
        super.setFillBefore(fillBefore);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_FILL_BEFORE_MASK;
        //super.setFillBefore(fillBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.027 -0400", hash_original_method = "777D14C93CE8BFF50BC39E2E3CDE2663", hash_generated_method = "727B7685AA08E502D5472AA0AD4BBA6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setRepeatMode(int repeatMode) {
        dsTaint.addTaint(repeatMode);
        mFlags |= PROPERTY_REPEAT_MODE_MASK;
        super.setRepeatMode(repeatMode);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_REPEAT_MODE_MASK;
        //super.setRepeatMode(repeatMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.027 -0400", hash_original_method = "3C61E6DAB3DDF346757DEBEA1DAB7005", hash_generated_method = "2729E895616649F468E19DCF28B98A75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setStartOffset(long startOffset) {
        dsTaint.addTaint(startOffset);
        mFlags |= PROPERTY_START_OFFSET_MASK;
        super.setStartOffset(startOffset);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_START_OFFSET_MASK;
        //super.setStartOffset(startOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.028 -0400", hash_original_method = "32142259597E010D1F73DE9F53078982", hash_generated_method = "1D80D55992A237313111DF0BF0547623")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasAlpha() {
        {
            mDirty = mHasAlpha = false;
            int count;
            count = mAnimations.size();
            ArrayList<Animation> animations;
            animations = mAnimations;
            {
                int i;
                i = 0;
                {
                    {
                        boolean var318ECFBA18F61FF993BA76974A857338_1121254818 = (animations.get(i).hasAlpha());
                        {
                            mHasAlpha = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mDirty) {
            //mDirty = mHasAlpha = false;
            //final int count = mAnimations.size();
            //final ArrayList<Animation> animations = mAnimations;
            //for (int i = 0; i < count; i++) {
                //if (animations.get(i).hasAlpha()) {
                    //mHasAlpha = true;
                    //break;
                //}
            //}
        //}
        //return mHasAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.028 -0400", hash_original_method = "638E0400F0B782F58F566825CD0FEEA0", hash_generated_method = "CEFEC2211B43872569BF98EAF16B93F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDuration(long durationMillis) {
        dsTaint.addTaint(durationMillis);
        mFlags |= PROPERTY_DURATION_MASK;
        super.setDuration(durationMillis);
        mLastEnd = mStartOffset + mDuration;
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_DURATION_MASK;
        //super.setDuration(durationMillis);
        //mLastEnd = mStartOffset + mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.028 -0400", hash_original_method = "F96436C1C98CEDEFC582978CFED41496", hash_generated_method = "6CADE3665655B7D243DFCE1FB21F6106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAnimation(Animation a) {
        dsTaint.addTaint(a.dsTaint);
        mAnimations.add(a);
        boolean noMatrix;
        noMatrix = (mFlags & PROPERTY_MORPH_MATRIX_MASK) == 0;
        {
            boolean var3AFC8C1F9BD79C2924F0D44D1D866132_708645341 = (noMatrix && a.willChangeTransformationMatrix());
            {
                mFlags |= PROPERTY_MORPH_MATRIX_MASK;
            } //End block
        } //End collapsed parenthetic
        boolean changeBounds;
        changeBounds = (mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == 0;
        {
            boolean var8CD50B8AD5A50CFC0010E75A020FCCF0_210386067 = (changeBounds && a.willChangeTransformationMatrix());
            {
                mFlags |= PROPERTY_CHANGE_BOUNDS_MASK;
            } //End block
        } //End collapsed parenthetic
        {
            mLastEnd = mStartOffset + mDuration;
        } //End block
        {
            {
                boolean var6D0AA57EF2650F3165F6492B79B1F2BD_1400713559 = (mAnimations.size() == 1);
                {
                    mDuration = a.getStartOffset() + a.getDuration();
                    mLastEnd = mStartOffset + mDuration;
                } //End block
                {
                    mLastEnd = Math.max(mLastEnd, a.getStartOffset() + a.getDuration());
                    mDuration = mLastEnd - mStartOffset;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mDirty = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.029 -0400", hash_original_method = "ED7478CCB671993C959207E062C9FA4F", hash_generated_method = "D5B0A9FB66966C8932DAAE9DACFDF422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setStartTime(long startTimeMillis) {
        dsTaint.addTaint(startTimeMillis);
        super.setStartTime(startTimeMillis);
        int count;
        count = mAnimations.size();
        ArrayList<Animation> animations;
        animations = mAnimations;
        {
            int i;
            i = 0;
            {
                Animation a;
                a = animations.get(i);
                a.setStartTime(startTimeMillis);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.setStartTime(startTimeMillis);
        //final int count = mAnimations.size();
        //final ArrayList<Animation> animations = mAnimations;
        //for (int i = 0; i < count; i++) {
            //Animation a = animations.get(i);
            //a.setStartTime(startTimeMillis);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.029 -0400", hash_original_method = "1DB17F128BC07A7BFF2B0ED14844511C", hash_generated_method = "E606F22A2794FD04B1BBDD57A5BEBC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getStartTime() {
        long startTime;
        startTime = Long.MAX_VALUE;
        int count;
        count = mAnimations.size();
        ArrayList<Animation> animations;
        animations = mAnimations;
        {
            int i;
            i = 0;
            {
                Animation a;
                a = animations.get(i);
                startTime = Math.min(startTime, a.getStartTime());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long startTime = Long.MAX_VALUE;
        //final int count = mAnimations.size();
        //final ArrayList<Animation> animations = mAnimations;
        //for (int i = 0; i < count; i++) {
            //Animation a = animations.get(i);
            //startTime = Math.min(startTime, a.getStartTime());
        //}
        //return startTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.029 -0400", hash_original_method = "8BDDB0E57A894DBD22BE4F412303E6AB", hash_generated_method = "4AA757AF089DC47AB1A03794D7FC11A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void restrictDuration(long durationMillis) {
        dsTaint.addTaint(durationMillis);
        super.restrictDuration(durationMillis);
        ArrayList<Animation> animations;
        animations = mAnimations;
        int count;
        count = animations.size();
        {
            int i;
            i = 0;
            {
                animations.get(i).restrictDuration(durationMillis);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.restrictDuration(durationMillis);
        //final ArrayList<Animation> animations = mAnimations;
        //int count = animations.size();
        //for (int i = 0; i < count; i++) {
            //animations.get(i).restrictDuration(durationMillis);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.029 -0400", hash_original_method = "0C51A5B794999BCAB9F83D60602DBD5A", hash_generated_method = "795B73B4782A0DC47BBD0BB017710A0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getDuration() {
        ArrayList<Animation> animations;
        animations = mAnimations;
        int count;
        count = animations.size();
        long duration;
        duration = 0;
        boolean durationSet;
        durationSet = (mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK;
        {
            duration = mDuration;
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    duration = Math.max(duration, animations.get(i).getDuration());
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //final ArrayList<Animation> animations = mAnimations;
        //final int count = animations.size();
        //long duration = 0;
        //boolean durationSet = (mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK;
        //if (durationSet) {
            //duration = mDuration;
        //} else {
            //for (int i = 0; i < count; i++) {
                //duration = Math.max(duration, animations.get(i).getDuration());
            //}
        //}
        //return duration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.030 -0400", hash_original_method = "979F8D0FD623C4002C8BD37290EA10AA", hash_generated_method = "B59A897929D97592A44A855C66563A29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long computeDurationHint() {
        long duration;
        duration = 0;
        int count;
        count = mAnimations.size();
        ArrayList<Animation> animations;
        animations = mAnimations;
        {
            int i;
            i = count - 1;
            {
                long d;
                d = animations.get(i).computeDurationHint();
                duration = d;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long duration = 0;
        //final int count = mAnimations.size();
        //final ArrayList<Animation> animations = mAnimations;
        //for (int i = count - 1; i >= 0; --i) {
            //final long d = animations.get(i).computeDurationHint();
            //if (d > duration) duration = d;
        //}
        //return duration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.030 -0400", hash_original_method = "357CAB1AB4D965ADF6EAF9B7256F84EE", hash_generated_method = "DB6974C0EC19F79A4B8F9D46F44BB0F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        RectF region;
        region = mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);
        {
            int count;
            count = mAnimations.size();
            ArrayList<Animation> animations;
            animations = mAnimations;
            Transformation temp;
            temp = mTempTransformation;
            Transformation previousTransformation;
            previousTransformation = mPreviousTransformation;
            {
                int i;
                i = count - 1;
                {
                    Animation a;
                    a = animations.get(i);
                    temp.clear();
                    Interpolator interpolator;
                    interpolator = a.mInterpolator;
                    a.applyTransformation(interpolator != null ? interpolator.getInterpolation(0.0f)
                        : 0.0f, temp);
                    previousTransformation.compose(temp);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.030 -0400", hash_original_method = "3F803CA56592D1A8F5A2DABD815E935C", hash_generated_method = "35E66418CB1261F941ABA200FE729B0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getTransformation(long currentTime, Transformation t) {
        dsTaint.addTaint(currentTime);
        dsTaint.addTaint(t.dsTaint);
        int count;
        count = mAnimations.size();
        ArrayList<Animation> animations;
        animations = mAnimations;
        Transformation temp;
        temp = mTempTransformation;
        boolean more;
        more = false;
        boolean started;
        started = false;
        boolean ended;
        ended = true;
        t.clear();
        {
            int i;
            i = count - 1;
            {
                Animation a;
                a = animations.get(i);
                temp.clear();
                more = a.getTransformation(currentTime, temp, getScaleFactor()) || more;
                t.compose(temp);
                started = started || a.hasStarted();
                ended = a.hasEnded() && ended;
            } //End block
        } //End collapsed parenthetic
        {
            {
                mListener.onAnimationStart(this);
            } //End block
            mStarted = true;
        } //End block
        {
            {
                mListener.onAnimationEnd(this);
            } //End block
            mEnded = ended;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.031 -0400", hash_original_method = "2134BF7993F0D641B52B56C7C0A9A6E5", hash_generated_method = "DA4C0CBA8732991E67D87C3337DD9071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void scaleCurrentDuration(float scale) {
        dsTaint.addTaint(scale);
        ArrayList<Animation> animations;
        animations = mAnimations;
        int count;
        count = animations.size();
        {
            int i;
            i = 0;
            {
                animations.get(i).scaleCurrentDuration(scale);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final ArrayList<Animation> animations = mAnimations;
        //int count = animations.size();
        //for (int i = 0; i < count; i++) {
            //animations.get(i).scaleCurrentDuration(scale);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.031 -0400", hash_original_method = "CAD543A8149EEDE67DD6611F7E4BF120", hash_generated_method = "EC869C7B74631AE08B9495D03307ACA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(parentWidth);
        dsTaint.addTaint(width);
        dsTaint.addTaint(parentHeight);
        super.initialize(width, height, parentWidth, parentHeight);
        boolean durationSet;
        durationSet = (mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK;
        boolean fillAfterSet;
        fillAfterSet = (mFlags & PROPERTY_FILL_AFTER_MASK) == PROPERTY_FILL_AFTER_MASK;
        boolean fillBeforeSet;
        fillBeforeSet = (mFlags & PROPERTY_FILL_BEFORE_MASK) == PROPERTY_FILL_BEFORE_MASK;
        boolean repeatModeSet;
        repeatModeSet = (mFlags & PROPERTY_REPEAT_MODE_MASK) == PROPERTY_REPEAT_MODE_MASK;
        boolean shareInterpolator;
        shareInterpolator = (mFlags & PROPERTY_SHARE_INTERPOLATOR_MASK)
                == PROPERTY_SHARE_INTERPOLATOR_MASK;
        boolean startOffsetSet;
        startOffsetSet = (mFlags & PROPERTY_START_OFFSET_MASK)
                == PROPERTY_START_OFFSET_MASK;
        {
            ensureInterpolator();
        } //End block
        ArrayList<Animation> children;
        children = mAnimations;
        int count;
        count = children.size();
        long duration;
        duration = mDuration;
        boolean fillAfter;
        fillAfter = mFillAfter;
        boolean fillBefore;
        fillBefore = mFillBefore;
        int repeatMode;
        repeatMode = mRepeatMode;
        Interpolator interpolator;
        interpolator = mInterpolator;
        long startOffset;
        startOffset = mStartOffset;
        long[] storedOffsets;
        storedOffsets = mStoredOffsets;
        {
            {
                storedOffsets = mStoredOffsets = new long[count];
            } //End block
        } //End block
        {
            storedOffsets = mStoredOffsets = null;
        } //End block
        {
            int i;
            i = 0;
            {
                Animation a;
                a = children.get(i);
                {
                    a.setDuration(duration);
                } //End block
                {
                    a.setFillAfter(fillAfter);
                } //End block
                {
                    a.setFillBefore(fillBefore);
                } //End block
                {
                    a.setRepeatMode(repeatMode);
                } //End block
                {
                    a.setInterpolator(interpolator);
                } //End block
                {
                    long offset;
                    offset = a.getStartOffset();
                    a.setStartOffset(offset + startOffset);
                    storedOffsets[i] = offset;
                } //End block
                a.initialize(width, height, parentWidth, parentHeight);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.032 -0400", hash_original_method = "2E3A361BE20A8D002834672DDB7CD636", hash_generated_method = "F50B3D17E3EAD3AC5C651A4E6CE1B416")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void reset() {
        super.reset();
        restoreChildrenStartOffset();
        // ---------- Original Method ----------
        //super.reset();
        //restoreChildrenStartOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.032 -0400", hash_original_method = "1FA58C163A7DB9A5169EF699805FA3C9", hash_generated_method = "9D2BDB09AAD4A9793EC3838EBE23F6D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void restoreChildrenStartOffset() {
        long[] offsets;
        offsets = mStoredOffsets;
        ArrayList<Animation> children;
        children = mAnimations;
        int count;
        count = children.size();
        {
            int i;
            i = 0;
            {
                children.get(i).setStartOffset(offsets[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final long[] offsets = mStoredOffsets;
        //if (offsets == null) return;
        //final ArrayList<Animation> children = mAnimations;
        //final int count = children.size();
        //for (int i = 0; i < count; i++) {
            //children.get(i).setStartOffset(offsets[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.032 -0400", hash_original_method = "EC73055689DC3CDB2DE15C42C77CE8EF", hash_generated_method = "57DD7F7C94AB28ED036260E682EE8A89")
    @DSModeled(DSC.SAFE)
    public List<Animation> getAnimations() {
        return (List<Animation>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAnimations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.033 -0400", hash_original_method = "007230E9C632DD7C25BB9E67DB11C3C3", hash_generated_method = "12E32BA016536F99A7D248C572399E12")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean willChangeTransformationMatrix() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & PROPERTY_MORPH_MATRIX_MASK) == PROPERTY_MORPH_MATRIX_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.033 -0400", hash_original_method = "A538326162AE4CED46022318A3520B17", hash_generated_method = "65B83F6DBD52137B751B7C3378E0FD49")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean willChangeBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == PROPERTY_CHANGE_BOUNDS_MASK;
    }

    
    private static final int PROPERTY_FILL_AFTER_MASK         = 0x1;
    private static final int PROPERTY_FILL_BEFORE_MASK        = 0x2;
    private static final int PROPERTY_REPEAT_MODE_MASK        = 0x4;
    private static final int PROPERTY_START_OFFSET_MASK       = 0x8;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 0x10;
    private static final int PROPERTY_DURATION_MASK           = 0x20;
    private static final int PROPERTY_MORPH_MATRIX_MASK       = 0x40;
    private static final int PROPERTY_CHANGE_BOUNDS_MASK      = 0x80;
}

