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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.116 -0400", hash_original_field = "B921E44548BA55022C2E5E2542E4E6A6", hash_generated_field = "F8991A4D76FA7127497F697B241FE789")

    private int mFlags = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.116 -0400", hash_original_field = "76D7D73778AD0C3E9D57E6A56AEDF738", hash_generated_field = "8EC03BE3CD289D6F418E2CF7DC6F95E4")

    private boolean mDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.116 -0400", hash_original_field = "888EF7A5D7544FB5951B99C74B40D228", hash_generated_field = "5E007DCC0C9F570E21A91D79E9C13C9C")

    private boolean mHasAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.116 -0400", hash_original_field = "4335C63647F4C9C587C209D1307D6600", hash_generated_field = "73E0F51E2ECCC5C0D56C337BEBD9E384")

    private ArrayList<Animation> mAnimations = new ArrayList<Animation>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.116 -0400", hash_original_field = "6BE9D6A097D689D6BDC5549D28D482AD", hash_generated_field = "7C9616BD413863FD9A0B9027C75DAE9A")

    private Transformation mTempTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.116 -0400", hash_original_field = "BA958BD29B7212ACE2528C4CBEE64AE8", hash_generated_field = "AF3B01ACE4EBE7EDEF6A14863051F362")

    private long mLastEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.116 -0400", hash_original_field = "441A36BE7709FD352A5D7E4E42DE8658", hash_generated_field = "4D3BA52AA4D41C4D38A585BCDB7160A1")

    private long[] mStoredOffsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.118 -0400", hash_original_method = "E48F61BFB7E750EB9CE1872A6E59F583", hash_generated_method = "A58464424B52BF2B588BF7CA9EE4C1AE")
    public  AnimationSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AnimationSet);
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK,
                a.getBoolean(com.android.internal.R.styleable.AnimationSet_shareInterpolator, true));
        init();
        {
            boolean var2026BAD09B30E00531380AA0AD5347B0_16060409 = (context.getApplicationInfo().targetSdkVersion >=
                Build.VERSION_CODES.ICE_CREAM_SANDWICH);
            {
                {
                    boolean varAB9E1DA2B763B3C2704210D390F5B692_590872498 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_duration));
                    {
                        mFlags |= PROPERTY_DURATION_MASK;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var7BF613E6FCAED02536A8D4C74FF9C55D_580244942 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_fillBefore));
                    {
                        mFlags |= PROPERTY_FILL_BEFORE_MASK;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varD72A102A08FCBE04AFEA1289372E1DDD_2039863402 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_fillAfter));
                    {
                        mFlags |= PROPERTY_FILL_AFTER_MASK;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2957C54AD2EA755A7DF1B0292AD3945E_1843806175 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_repeatMode));
                    {
                        mFlags |= PROPERTY_REPEAT_MODE_MASK;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2A787A7DA9E50B2DF1528034DA0EA71F_992001626 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_startOffset));
                    {
                        mFlags |= PROPERTY_START_OFFSET_MASK;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.120 -0400", hash_original_method = "40E1DAC9F5FF86741AE2A2FFD7F09052", hash_generated_method = "535ABCCFFDA33430AE3A8EDF119CFA90")
    public  AnimationSet(boolean shareInterpolator) {
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK, shareInterpolator);
        init();
        addTaint(shareInterpolator);
        // ---------- Original Method ----------
        //setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK, shareInterpolator);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.128 -0400", hash_original_method = "17885947D34B4C6D63222266DEE6E0A5", hash_generated_method = "A6439559DB4FE88CA010E809F9C7EF1A")
    @Override
    protected AnimationSet clone() throws CloneNotSupportedException {
        AnimationSet varB4EAC82CA7396A68D541C85D26508E83_724139089 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_724139089 = animation;
        varB4EAC82CA7396A68D541C85D26508E83_724139089.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_724139089;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.128 -0400", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "5931F6904132B4A25B60E9C33D9C37BA")
    private void setFlag(int mask, boolean value) {
        {
            mFlags |= mask;
        } //End block
        {
            mFlags &= ~mask;
        } //End block
        addTaint(value);
        // ---------- Original Method ----------
        //if (value) {
            //mFlags |= mask;
        //} else {
            //mFlags &= ~mask;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.132 -0400", hash_original_method = "96CA9C56EEADA219CA715399206CF9BC", hash_generated_method = "C0944DDBBB8FF4378AF642CA83ECA72A")
    private void init() {
        mStartTime = 0;
        // ---------- Original Method ----------
        //mStartTime = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.132 -0400", hash_original_method = "346D63116043912E4EE20FDCAED3D0BD", hash_generated_method = "D774C7CE898B1835FB75E215DDE23AB1")
    @Override
    public void setFillAfter(boolean fillAfter) {
        mFlags |= PROPERTY_FILL_AFTER_MASK;
        super.setFillAfter(fillAfter);
        addTaint(fillAfter);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_FILL_AFTER_MASK;
        //super.setFillAfter(fillAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.132 -0400", hash_original_method = "08C3166F3D09017C7ECB4F829DA334D1", hash_generated_method = "F455DB42EC12A016BD93423B093C4EF2")
    @Override
    public void setFillBefore(boolean fillBefore) {
        mFlags |= PROPERTY_FILL_BEFORE_MASK;
        super.setFillBefore(fillBefore);
        addTaint(fillBefore);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_FILL_BEFORE_MASK;
        //super.setFillBefore(fillBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.145 -0400", hash_original_method = "777D14C93CE8BFF50BC39E2E3CDE2663", hash_generated_method = "D8D85C3F9BAED8A15F72614D00ECE642")
    @Override
    public void setRepeatMode(int repeatMode) {
        mFlags |= PROPERTY_REPEAT_MODE_MASK;
        super.setRepeatMode(repeatMode);
        addTaint(repeatMode);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_REPEAT_MODE_MASK;
        //super.setRepeatMode(repeatMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.145 -0400", hash_original_method = "3C61E6DAB3DDF346757DEBEA1DAB7005", hash_generated_method = "F5D906F1B773C51F47E204ED6CBBD1A6")
    @Override
    public void setStartOffset(long startOffset) {
        mFlags |= PROPERTY_START_OFFSET_MASK;
        super.setStartOffset(startOffset);
        addTaint(startOffset);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_START_OFFSET_MASK;
        //super.setStartOffset(startOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.150 -0400", hash_original_method = "32142259597E010D1F73DE9F53078982", hash_generated_method = "22B15F6B59586176B97FDCF9F14BCF1C")
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
                        boolean var318ECFBA18F61FF993BA76974A857338_1072405642 = (animations.get(i).hasAlpha());
                        {
                            mHasAlpha = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886746921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886746921;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.151 -0400", hash_original_method = "638E0400F0B782F58F566825CD0FEEA0", hash_generated_method = "7C956B9BDCA422BA10EF6C2F8EA55212")
    @Override
    public void setDuration(long durationMillis) {
        mFlags |= PROPERTY_DURATION_MASK;
        super.setDuration(durationMillis);
        mLastEnd = mStartOffset + mDuration;
        addTaint(durationMillis);
        // ---------- Original Method ----------
        //mFlags |= PROPERTY_DURATION_MASK;
        //super.setDuration(durationMillis);
        //mLastEnd = mStartOffset + mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.152 -0400", hash_original_method = "F96436C1C98CEDEFC582978CFED41496", hash_generated_method = "4AADAF7A43199F406BCEDEB3AF1D464D")
    public void addAnimation(Animation a) {
        mAnimations.add(a);
        boolean noMatrix;
        noMatrix = (mFlags & PROPERTY_MORPH_MATRIX_MASK) == 0;
        {
            boolean var3AFC8C1F9BD79C2924F0D44D1D866132_1784206429 = (noMatrix && a.willChangeTransformationMatrix());
            {
                mFlags |= PROPERTY_MORPH_MATRIX_MASK;
            } //End block
        } //End collapsed parenthetic
        boolean changeBounds;
        changeBounds = (mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == 0;
        {
            boolean var8CD50B8AD5A50CFC0010E75A020FCCF0_802256145 = (changeBounds && a.willChangeTransformationMatrix());
            {
                mFlags |= PROPERTY_CHANGE_BOUNDS_MASK;
            } //End block
        } //End collapsed parenthetic
        {
            mLastEnd = mStartOffset + mDuration;
        } //End block
        {
            {
                boolean var6D0AA57EF2650F3165F6492B79B1F2BD_836243764 = (mAnimations.size() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.152 -0400", hash_original_method = "ED7478CCB671993C959207E062C9FA4F", hash_generated_method = "5F0AA123E1B36BA0F296AC7822A50E20")
    @Override
    public void setStartTime(long startTimeMillis) {
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
        addTaint(startTimeMillis);
        // ---------- Original Method ----------
        //super.setStartTime(startTimeMillis);
        //final int count = mAnimations.size();
        //final ArrayList<Animation> animations = mAnimations;
        //for (int i = 0; i < count; i++) {
            //Animation a = animations.get(i);
            //a.setStartTime(startTimeMillis);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.171 -0400", hash_original_method = "1DB17F128BC07A7BFF2B0ED14844511C", hash_generated_method = "706C5A08200A10315CB9CC1AD16AEC62")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_107585557 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_107585557;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.172 -0400", hash_original_method = "8BDDB0E57A894DBD22BE4F412303E6AB", hash_generated_method = "57178574F38D7677D5BE2C08B9F1B2A9")
    @Override
    public void restrictDuration(long durationMillis) {
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
        addTaint(durationMillis);
        // ---------- Original Method ----------
        //super.restrictDuration(durationMillis);
        //final ArrayList<Animation> animations = mAnimations;
        //int count = animations.size();
        //for (int i = 0; i < count; i++) {
            //animations.get(i).restrictDuration(durationMillis);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.173 -0400", hash_original_method = "0C51A5B794999BCAB9F83D60602DBD5A", hash_generated_method = "8C621563A31DBEC14F9B7981368BCBC5")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1197420653 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1197420653;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.173 -0400", hash_original_method = "979F8D0FD623C4002C8BD37290EA10AA", hash_generated_method = "FA242E1E535AEE4DB55506C511241579")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1259908652 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1259908652;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.174 -0400", hash_original_method = "357CAB1AB4D965ADF6EAF9B7256F84EE", hash_generated_method = "B98CDCA56FC6BFF11FA26F8429AE5246")
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
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
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.176 -0400", hash_original_method = "3F803CA56592D1A8F5A2DABD815E935C", hash_generated_method = "00333071792CD78577FBEAF0985631CC")
    @Override
    public boolean getTransformation(long currentTime, Transformation t) {
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
        addTaint(currentTime);
        addTaint(t.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881628398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881628398;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.176 -0400", hash_original_method = "2134BF7993F0D641B52B56C7C0A9A6E5", hash_generated_method = "A092112153A1670E9B3A6CF11A438696")
    @Override
    public void scaleCurrentDuration(float scale) {
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
        addTaint(scale);
        // ---------- Original Method ----------
        //final ArrayList<Animation> animations = mAnimations;
        //int count = animations.size();
        //for (int i = 0; i < count; i++) {
            //animations.get(i).scaleCurrentDuration(scale);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.193 -0400", hash_original_method = "CAD543A8149EEDE67DD6611F7E4BF120", hash_generated_method = "4AF115C82FD3C309855ABCAB46CD8E6C")
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
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
        addTaint(width);
        addTaint(height);
        addTaint(parentWidth);
        addTaint(parentHeight);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.193 -0400", hash_original_method = "2E3A361BE20A8D002834672DDB7CD636", hash_generated_method = "F50B3D17E3EAD3AC5C651A4E6CE1B416")
    @Override
    public void reset() {
        super.reset();
        restoreChildrenStartOffset();
        // ---------- Original Method ----------
        //super.reset();
        //restoreChildrenStartOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.194 -0400", hash_original_method = "1FA58C163A7DB9A5169EF699805FA3C9", hash_generated_method = "9D2BDB09AAD4A9793EC3838EBE23F6D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.194 -0400", hash_original_method = "EC73055689DC3CDB2DE15C42C77CE8EF", hash_generated_method = "2A728D75AD13C0FC015B175F58197A6C")
    public List<Animation> getAnimations() {
        List<Animation> varB4EAC82CA7396A68D541C85D26508E83_1446123170 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1446123170 = mAnimations;
        varB4EAC82CA7396A68D541C85D26508E83_1446123170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1446123170;
        // ---------- Original Method ----------
        //return mAnimations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.194 -0400", hash_original_method = "007230E9C632DD7C25BB9E67DB11C3C3", hash_generated_method = "6AE39E0213D19A2452BE0C5A05BB2407")
    @Override
    public boolean willChangeTransformationMatrix() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1699715276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1699715276;
        // ---------- Original Method ----------
        //return (mFlags & PROPERTY_MORPH_MATRIX_MASK) == PROPERTY_MORPH_MATRIX_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.194 -0400", hash_original_method = "A538326162AE4CED46022318A3520B17", hash_generated_method = "A075CCE03B388E668067164DCE67AA67")
    @Override
    public boolean willChangeBounds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_594153828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_594153828;
        // ---------- Original Method ----------
        //return (mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == PROPERTY_CHANGE_BOUNDS_MASK;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.195 -0400", hash_original_field = "05C61D34F2D6FA49720C368787295F7C", hash_generated_field = "27C0C40052344E2A47B2FD0541B4A331")

    private static int PROPERTY_FILL_AFTER_MASK = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.195 -0400", hash_original_field = "777BB302827C2D122E450457A10D3BA7", hash_generated_field = "FECE67DD456347504C783898C48E1CB3")

    private static int PROPERTY_FILL_BEFORE_MASK = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.195 -0400", hash_original_field = "B81B9161EB151AE3DEAEE42B58F544B9", hash_generated_field = "BB1A1F02568FA6AB70F87EC75D116B19")

    private static int PROPERTY_REPEAT_MODE_MASK = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.195 -0400", hash_original_field = "441E05DBA26742E52C72A452E9B86340", hash_generated_field = "6DA7786D78FBC79E8E1DAFC79DD4C75D")

    private static int PROPERTY_START_OFFSET_MASK = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.195 -0400", hash_original_field = "A72EEEC20A966DB75D61B5074375CCA1", hash_generated_field = "AB7E75008C635F5E5D1DB1A6644036DC")

    private static int PROPERTY_SHARE_INTERPOLATOR_MASK = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.195 -0400", hash_original_field = "B44854A667D88A05C8430A29896B5F4F", hash_generated_field = "13501FFEA87067BAFC7EC89290FCBE70")

    private static int PROPERTY_DURATION_MASK = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.195 -0400", hash_original_field = "F76845D17AEC36F4A6EB6848D6A60DCB", hash_generated_field = "6316D07F8363AE1394C0D94872B84193")

    private static int PROPERTY_MORPH_MATRIX_MASK = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.195 -0400", hash_original_field = "3FAD3D66D5C579A786F540732A33C45E", hash_generated_field = "9A73656B2CC67728B25D69CE4E209573")

    private static int PROPERTY_CHANGE_BOUNDS_MASK = 0x80;
}

