package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class AnimationSet extends Animation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.364 -0400", hash_original_field = "B921E44548BA55022C2E5E2542E4E6A6", hash_generated_field = "F8991A4D76FA7127497F697B241FE789")

    private int mFlags = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.365 -0400", hash_original_field = "76D7D73778AD0C3E9D57E6A56AEDF738", hash_generated_field = "8EC03BE3CD289D6F418E2CF7DC6F95E4")

    private boolean mDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.365 -0400", hash_original_field = "888EF7A5D7544FB5951B99C74B40D228", hash_generated_field = "5E007DCC0C9F570E21A91D79E9C13C9C")

    private boolean mHasAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.365 -0400", hash_original_field = "4335C63647F4C9C587C209D1307D6600", hash_generated_field = "73E0F51E2ECCC5C0D56C337BEBD9E384")

    private ArrayList<Animation> mAnimations = new ArrayList<Animation>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.365 -0400", hash_original_field = "6BE9D6A097D689D6BDC5549D28D482AD", hash_generated_field = "7C9616BD413863FD9A0B9027C75DAE9A")

    private Transformation mTempTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.365 -0400", hash_original_field = "BA958BD29B7212ACE2528C4CBEE64AE8", hash_generated_field = "AF3B01ACE4EBE7EDEF6A14863051F362")

    private long mLastEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.365 -0400", hash_original_field = "441A36BE7709FD352A5D7E4E42DE8658", hash_generated_field = "4D3BA52AA4D41C4D38A585BCDB7160A1")

    private long[] mStoredOffsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.365 -0400", hash_original_method = "E48F61BFB7E750EB9CE1872A6E59F583", hash_generated_method = "A8DD7551B9CBE50A2C5A4868DDA3A875")
    public  AnimationSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AnimationSet);
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK,
                a.getBoolean(com.android.internal.R.styleable.AnimationSet_shareInterpolator, true));
        init();
        {
            boolean var2026BAD09B30E00531380AA0AD5347B0_605455086 = (context.getApplicationInfo().targetSdkVersion >=
                Build.VERSION_CODES.ICE_CREAM_SANDWICH);
            {
                {
                    boolean varAB9E1DA2B763B3C2704210D390F5B692_1685461476 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_duration));
                    {
                        mFlags |= PROPERTY_DURATION_MASK;
                    } 
                } 
                {
                    boolean var7BF613E6FCAED02536A8D4C74FF9C55D_317844697 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_fillBefore));
                    {
                        mFlags |= PROPERTY_FILL_BEFORE_MASK;
                    } 
                } 
                {
                    boolean varD72A102A08FCBE04AFEA1289372E1DDD_1897983390 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_fillAfter));
                    {
                        mFlags |= PROPERTY_FILL_AFTER_MASK;
                    } 
                } 
                {
                    boolean var2957C54AD2EA755A7DF1B0292AD3945E_2061382280 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_repeatMode));
                    {
                        mFlags |= PROPERTY_REPEAT_MODE_MASK;
                    } 
                } 
                {
                    boolean var2A787A7DA9E50B2DF1528034DA0EA71F_794709446 = (a.hasValue(com.android.internal.R.styleable.AnimationSet_startOffset));
                    {
                        mFlags |= PROPERTY_START_OFFSET_MASK;
                    } 
                } 
            } 
        } 
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.366 -0400", hash_original_method = "40E1DAC9F5FF86741AE2A2FFD7F09052", hash_generated_method = "535ABCCFFDA33430AE3A8EDF119CFA90")
    public  AnimationSet(boolean shareInterpolator) {
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK, shareInterpolator);
        init();
        addTaint(shareInterpolator);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.367 -0400", hash_original_method = "17885947D34B4C6D63222266DEE6E0A5", hash_generated_method = "109657E7D7DD50146D12B04A191B2A2D")
    @Override
    protected AnimationSet clone() throws CloneNotSupportedException {
        AnimationSet varB4EAC82CA7396A68D541C85D26508E83_1961780847 = null; 
        final AnimationSet animation = (AnimationSet) super.clone();
        animation.mTempTransformation = new Transformation();
        animation.mAnimations = new ArrayList<Animation>();
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
        {
            int i = 0;
            {
                animation.mAnimations.add(animations.get(i).clone());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1961780847 = animation;
        varB4EAC82CA7396A68D541C85D26508E83_1961780847.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1961780847;
        
        
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.367 -0400", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "5931F6904132B4A25B60E9C33D9C37BA")
    private void setFlag(int mask, boolean value) {
        {
            mFlags |= mask;
        } 
        {
            mFlags &= ~mask;
        } 
        addTaint(value);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.368 -0400", hash_original_method = "96CA9C56EEADA219CA715399206CF9BC", hash_generated_method = "C0944DDBBB8FF4378AF642CA83ECA72A")
    private void init() {
        mStartTime = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.369 -0400", hash_original_method = "346D63116043912E4EE20FDCAED3D0BD", hash_generated_method = "D774C7CE898B1835FB75E215DDE23AB1")
    @Override
    public void setFillAfter(boolean fillAfter) {
        mFlags |= PROPERTY_FILL_AFTER_MASK;
        super.setFillAfter(fillAfter);
        addTaint(fillAfter);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.369 -0400", hash_original_method = "08C3166F3D09017C7ECB4F829DA334D1", hash_generated_method = "F455DB42EC12A016BD93423B093C4EF2")
    @Override
    public void setFillBefore(boolean fillBefore) {
        mFlags |= PROPERTY_FILL_BEFORE_MASK;
        super.setFillBefore(fillBefore);
        addTaint(fillBefore);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.369 -0400", hash_original_method = "777D14C93CE8BFF50BC39E2E3CDE2663", hash_generated_method = "D8D85C3F9BAED8A15F72614D00ECE642")
    @Override
    public void setRepeatMode(int repeatMode) {
        mFlags |= PROPERTY_REPEAT_MODE_MASK;
        super.setRepeatMode(repeatMode);
        addTaint(repeatMode);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.370 -0400", hash_original_method = "3C61E6DAB3DDF346757DEBEA1DAB7005", hash_generated_method = "F5D906F1B773C51F47E204ED6CBBD1A6")
    @Override
    public void setStartOffset(long startOffset) {
        mFlags |= PROPERTY_START_OFFSET_MASK;
        super.setStartOffset(startOffset);
        addTaint(startOffset);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.371 -0400", hash_original_method = "32142259597E010D1F73DE9F53078982", hash_generated_method = "458B0859D1AA88CCA23E2D8BCCF548B1")
    @Override
    public boolean hasAlpha() {
        {
            mDirty = mHasAlpha = false;
            final int count = mAnimations.size();
            final ArrayList<Animation> animations = mAnimations;
            {
                int i = 0;
                {
                    {
                        boolean var318ECFBA18F61FF993BA76974A857338_1829014778 = (animations.get(i).hasAlpha());
                        {
                            mHasAlpha = true;
                        } 
                    } 
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110040435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110040435;
        
        
            
            
            
            
                
                    
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.371 -0400", hash_original_method = "638E0400F0B782F58F566825CD0FEEA0", hash_generated_method = "7C956B9BDCA422BA10EF6C2F8EA55212")
    @Override
    public void setDuration(long durationMillis) {
        mFlags |= PROPERTY_DURATION_MASK;
        super.setDuration(durationMillis);
        mLastEnd = mStartOffset + mDuration;
        addTaint(durationMillis);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.372 -0400", hash_original_method = "F96436C1C98CEDEFC582978CFED41496", hash_generated_method = "C3BA093446983FF1F6159A3BAECBF6D7")
    public void addAnimation(Animation a) {
        mAnimations.add(a);
        boolean noMatrix = (mFlags & PROPERTY_MORPH_MATRIX_MASK) == 0;
        {
            boolean var3AFC8C1F9BD79C2924F0D44D1D866132_1863304549 = (noMatrix && a.willChangeTransformationMatrix());
            {
                mFlags |= PROPERTY_MORPH_MATRIX_MASK;
            } 
        } 
        boolean changeBounds = (mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == 0;
        {
            boolean var8CD50B8AD5A50CFC0010E75A020FCCF0_657135499 = (changeBounds && a.willChangeTransformationMatrix());
            {
                mFlags |= PROPERTY_CHANGE_BOUNDS_MASK;
            } 
        } 
        {
            mLastEnd = mStartOffset + mDuration;
        } 
        {
            {
                boolean var6D0AA57EF2650F3165F6492B79B1F2BD_2131474533 = (mAnimations.size() == 1);
                {
                    mDuration = a.getStartOffset() + a.getDuration();
                    mLastEnd = mStartOffset + mDuration;
                } 
                {
                    mLastEnd = Math.max(mLastEnd, a.getStartOffset() + a.getDuration());
                    mDuration = mLastEnd - mStartOffset;
                } 
            } 
        } 
        mDirty = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.372 -0400", hash_original_method = "ED7478CCB671993C959207E062C9FA4F", hash_generated_method = "3BC931A7011E7E3663A099E3C8AA1C2B")
    @Override
    public void setStartTime(long startTimeMillis) {
        super.setStartTime(startTimeMillis);
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
        {
            int i = 0;
            {
                Animation a = animations.get(i);
                a.setStartTime(startTimeMillis);
            } 
        } 
        addTaint(startTimeMillis);
        
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.373 -0400", hash_original_method = "1DB17F128BC07A7BFF2B0ED14844511C", hash_generated_method = "8455C35F68B47CC136302EDEF5CA024E")
    @Override
    public long getStartTime() {
        long startTime = Long.MAX_VALUE;
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
        {
            int i = 0;
            {
                Animation a = animations.get(i);
                startTime = Math.min(startTime, a.getStartTime());
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_989801379 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_989801379;
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.373 -0400", hash_original_method = "8BDDB0E57A894DBD22BE4F412303E6AB", hash_generated_method = "8659C6A3369FC11F1BD7F4CA842781EE")
    @Override
    public void restrictDuration(long durationMillis) {
        super.restrictDuration(durationMillis);
        final ArrayList<Animation> animations = mAnimations;
        int count = animations.size();
        {
            int i = 0;
            {
                animations.get(i).restrictDuration(durationMillis);
            } 
        } 
        addTaint(durationMillis);
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.374 -0400", hash_original_method = "0C51A5B794999BCAB9F83D60602DBD5A", hash_generated_method = "CFEB9F884904523099C41E8C45860573")
    @Override
    public long getDuration() {
        final ArrayList<Animation> animations = mAnimations;
        final int count = animations.size();
        long duration = 0;
        boolean durationSet = (mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK;
        {
            duration = mDuration;
        } 
        {
            {
                int i = 0;
                {
                    duration = Math.max(duration, animations.get(i).getDuration());
                } 
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2025053701 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2025053701;
        
        
        
        
        
        
            
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.374 -0400", hash_original_method = "979F8D0FD623C4002C8BD37290EA10AA", hash_generated_method = "49D080A1DD7EDD799CC090E84622851D")
    public long computeDurationHint() {
        long duration = 0;
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
        {
            int i = count - 1;
            {
                final long d = animations.get(i).computeDurationHint();
                duration = d;
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_554438785 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_554438785;
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.375 -0400", hash_original_method = "357CAB1AB4D965ADF6EAF9B7256F84EE", hash_generated_method = "A31FD5F47540A33F4BFE49D3F2C6F0EA")
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        final RectF region = mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);
        {
            final int count = mAnimations.size();
            final ArrayList<Animation> animations = mAnimations;
            final Transformation temp = mTempTransformation;
            final Transformation previousTransformation = mPreviousTransformation;
            {
                int i = count - 1;
                {
                    final Animation a = animations.get(i);
                    temp.clear();
                    final Interpolator interpolator = a.mInterpolator;
                    a.applyTransformation(interpolator != null ? interpolator.getInterpolation(0.0f)
                        : 0.0f, temp);
                    previousTransformation.compose(temp);
                } 
            } 
        } 
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.375 -0400", hash_original_method = "3F803CA56592D1A8F5A2DABD815E935C", hash_generated_method = "6E7F53346DF39FCD8BF7BB6C8C7A6BB0")
    @Override
    public boolean getTransformation(long currentTime, Transformation t) {
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
        final Transformation temp = mTempTransformation;
        boolean more = false;
        boolean started = false;
        boolean ended = true;
        t.clear();
        {
            int i = count - 1;
            {
                final Animation a = animations.get(i);
                temp.clear();
                more = a.getTransformation(currentTime, temp, getScaleFactor()) || more;
                t.compose(temp);
                started = started || a.hasStarted();
                ended = a.hasEnded() && ended;
            } 
        } 
        {
            {
                mListener.onAnimationStart(this);
            } 
            mStarted = true;
        } 
        {
            {
                mListener.onAnimationEnd(this);
            } 
            mEnded = ended;
        } 
        addTaint(currentTime);
        addTaint(t.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666771507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666771507;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.376 -0400", hash_original_method = "2134BF7993F0D641B52B56C7C0A9A6E5", hash_generated_method = "957F6625FCF64C32826C05A28022CA1C")
    @Override
    public void scaleCurrentDuration(float scale) {
        final ArrayList<Animation> animations = mAnimations;
        int count = animations.size();
        {
            int i = 0;
            {
                animations.get(i).scaleCurrentDuration(scale);
            } 
        } 
        addTaint(scale);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.377 -0400", hash_original_method = "CAD543A8149EEDE67DD6611F7E4BF120", hash_generated_method = "42472DB26E40B3740A7FF93E06D27AB5")
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
        {
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
        {
            {
                storedOffsets = mStoredOffsets = new long[count];
            } 
        } 
        {
            storedOffsets = mStoredOffsets = null;
        } 
        {
            int i = 0;
            {
                Animation a = children.get(i);
                {
                    a.setDuration(duration);
                } 
                {
                    a.setFillAfter(fillAfter);
                } 
                {
                    a.setFillBefore(fillBefore);
                } 
                {
                    a.setRepeatMode(repeatMode);
                } 
                {
                    a.setInterpolator(interpolator);
                } 
                {
                    long offset = a.getStartOffset();
                    a.setStartOffset(offset + startOffset);
                    storedOffsets[i] = offset;
                } 
                a.initialize(width, height, parentWidth, parentHeight);
            } 
        } 
        addTaint(width);
        addTaint(height);
        addTaint(parentWidth);
        addTaint(parentHeight);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.377 -0400", hash_original_method = "2E3A361BE20A8D002834672DDB7CD636", hash_generated_method = "F50B3D17E3EAD3AC5C651A4E6CE1B416")
    @Override
    public void reset() {
        super.reset();
        restoreChildrenStartOffset();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.378 -0400", hash_original_method = "1FA58C163A7DB9A5169EF699805FA3C9", hash_generated_method = "E76A4630C188DB0B484D7C17F4FB0E05")
     void restoreChildrenStartOffset() {
        final long[] offsets = mStoredOffsets;
        final ArrayList<Animation> children = mAnimations;
        final int count = children.size();
        {
            int i = 0;
            {
                children.get(i).setStartOffset(offsets[i]);
            } 
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.378 -0400", hash_original_method = "EC73055689DC3CDB2DE15C42C77CE8EF", hash_generated_method = "F3C87E71F35D2A828DCFDB10398B26C0")
    public List<Animation> getAnimations() {
        List<Animation> varB4EAC82CA7396A68D541C85D26508E83_967679873 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_967679873 = mAnimations;
        varB4EAC82CA7396A68D541C85D26508E83_967679873.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_967679873;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.379 -0400", hash_original_method = "007230E9C632DD7C25BB9E67DB11C3C3", hash_generated_method = "6F0A30D9364D1D47031497420C8C07BE")
    @Override
    public boolean willChangeTransformationMatrix() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696991394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_696991394;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.379 -0400", hash_original_method = "A538326162AE4CED46022318A3520B17", hash_generated_method = "75AADF83FDCC002BFEAAFABFFDCD62F1")
    @Override
    public boolean willChangeBounds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579886858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579886858;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.380 -0400", hash_original_field = "05C61D34F2D6FA49720C368787295F7C", hash_generated_field = "4E6A2393E3A41FF00CBD8150E755D9D3")

    private static final int PROPERTY_FILL_AFTER_MASK = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.380 -0400", hash_original_field = "777BB302827C2D122E450457A10D3BA7", hash_generated_field = "AF3B072AF41D6260060EBDA66CF66385")

    private static final int PROPERTY_FILL_BEFORE_MASK = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.380 -0400", hash_original_field = "B81B9161EB151AE3DEAEE42B58F544B9", hash_generated_field = "1FD86F067E7DF1209C97B9951E5A2D68")

    private static final int PROPERTY_REPEAT_MODE_MASK = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.380 -0400", hash_original_field = "441E05DBA26742E52C72A452E9B86340", hash_generated_field = "D59291534504149726C15D5B8C4B78EF")

    private static final int PROPERTY_START_OFFSET_MASK = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.380 -0400", hash_original_field = "A72EEEC20A966DB75D61B5074375CCA1", hash_generated_field = "16B7CB13D692AA5D34D2FE4D9F825737")

    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.380 -0400", hash_original_field = "B44854A667D88A05C8430A29896B5F4F", hash_generated_field = "4649CE1597E4F6226E08DA4CD678394F")

    private static final int PROPERTY_DURATION_MASK = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.380 -0400", hash_original_field = "F76845D17AEC36F4A6EB6848D6A60DCB", hash_generated_field = "58E407F6C09F775B2C3112E974909A4B")

    private static final int PROPERTY_MORPH_MATRIX_MASK = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.380 -0400", hash_original_field = "3FAD3D66D5C579A786F540732A33C45E", hash_generated_field = "DD8036C86532BF82965105099123C6F4")

    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 0x80;
}

