package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class AnimationSet extends Animation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.624 -0400", hash_original_field = "B921E44548BA55022C2E5E2542E4E6A6", hash_generated_field = "F8991A4D76FA7127497F697B241FE789")

    private int mFlags = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.624 -0400", hash_original_field = "76D7D73778AD0C3E9D57E6A56AEDF738", hash_generated_field = "8EC03BE3CD289D6F418E2CF7DC6F95E4")

    private boolean mDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.624 -0400", hash_original_field = "888EF7A5D7544FB5951B99C74B40D228", hash_generated_field = "5E007DCC0C9F570E21A91D79E9C13C9C")

    private boolean mHasAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.624 -0400", hash_original_field = "4335C63647F4C9C587C209D1307D6600", hash_generated_field = "73E0F51E2ECCC5C0D56C337BEBD9E384")

    private ArrayList<Animation> mAnimations = new ArrayList<Animation>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.624 -0400", hash_original_field = "6BE9D6A097D689D6BDC5549D28D482AD", hash_generated_field = "7C9616BD413863FD9A0B9027C75DAE9A")

    private Transformation mTempTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.625 -0400", hash_original_field = "BA958BD29B7212ACE2528C4CBEE64AE8", hash_generated_field = "AF3B01ACE4EBE7EDEF6A14863051F362")

    private long mLastEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.625 -0400", hash_original_field = "441A36BE7709FD352A5D7E4E42DE8658", hash_generated_field = "4D3BA52AA4D41C4D38A585BCDB7160A1")

    private long[] mStoredOffsets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.626 -0400", hash_original_method = "E48F61BFB7E750EB9CE1872A6E59F583", hash_generated_method = "1C318C413046552418BEA54FE240EF21")
    public  AnimationSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AnimationSet);
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK,
                a.getBoolean(com.android.internal.R.styleable.AnimationSet_shareInterpolator, true));
        init();
    if(context.getApplicationInfo().targetSdkVersion >=
                Build.VERSION_CODES.ICE_CREAM_SANDWICH)        
        {
    if(a.hasValue(com.android.internal.R.styleable.AnimationSet_duration))            
            {
                mFlags |= PROPERTY_DURATION_MASK;
            } 
    if(a.hasValue(com.android.internal.R.styleable.AnimationSet_fillBefore))            
            {
                mFlags |= PROPERTY_FILL_BEFORE_MASK;
            } 
    if(a.hasValue(com.android.internal.R.styleable.AnimationSet_fillAfter))            
            {
                mFlags |= PROPERTY_FILL_AFTER_MASK;
            } 
    if(a.hasValue(com.android.internal.R.styleable.AnimationSet_repeatMode))            
            {
                mFlags |= PROPERTY_REPEAT_MODE_MASK;
            } 
    if(a.hasValue(com.android.internal.R.styleable.AnimationSet_startOffset))            
            {
                mFlags |= PROPERTY_START_OFFSET_MASK;
            } 
        } 
        a.recycle();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.626 -0400", hash_original_method = "40E1DAC9F5FF86741AE2A2FFD7F09052", hash_generated_method = "6EA6C262E48E14759DB7CA1F0D549C3D")
    public  AnimationSet(boolean shareInterpolator) {
        addTaint(shareInterpolator);
        setFlag(PROPERTY_SHARE_INTERPOLATOR_MASK, shareInterpolator);
        init();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.627 -0400", hash_original_method = "17885947D34B4C6D63222266DEE6E0A5", hash_generated_method = "6B4EA2765F4605FA7696F1F1620B8008")
    @Override
    protected AnimationSet clone() throws CloneNotSupportedException {
        final AnimationSet animation = (AnimationSet) super.clone();
        animation.mTempTransformation = new Transformation();
        animation.mAnimations = new ArrayList<Animation>();
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
for(int i = 0;i < count;i++)
        {
            animation.mAnimations.add(animations.get(i).clone());
        } 
AnimationSet var1D3E9F798E82851E6201AD690FEA4543_1826289463 =         animation;
        var1D3E9F798E82851E6201AD690FEA4543_1826289463.addTaint(taint);
        return var1D3E9F798E82851E6201AD690FEA4543_1826289463;
        
        
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.627 -0400", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "8A7BB69AA36E9A4190E2455BA21998A6")
    private void setFlag(int mask, boolean value) {
        addTaint(value);
    if(value)        
        {
            mFlags |= mask;
        } 
        else
        {
            mFlags &= ~mask;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.628 -0400", hash_original_method = "96CA9C56EEADA219CA715399206CF9BC", hash_generated_method = "C0944DDBBB8FF4378AF642CA83ECA72A")
    private void init() {
        mStartTime = 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.628 -0400", hash_original_method = "346D63116043912E4EE20FDCAED3D0BD", hash_generated_method = "E3249F9D5294564079C81CD0680DE3D0")
    @Override
    public void setFillAfter(boolean fillAfter) {
        addTaint(fillAfter);
        mFlags |= PROPERTY_FILL_AFTER_MASK;
        super.setFillAfter(fillAfter);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.629 -0400", hash_original_method = "08C3166F3D09017C7ECB4F829DA334D1", hash_generated_method = "65BA3677028996CF76FEE7C246F92D9B")
    @Override
    public void setFillBefore(boolean fillBefore) {
        addTaint(fillBefore);
        mFlags |= PROPERTY_FILL_BEFORE_MASK;
        super.setFillBefore(fillBefore);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.629 -0400", hash_original_method = "777D14C93CE8BFF50BC39E2E3CDE2663", hash_generated_method = "423E165E8CC3E73633128E7BBBF5B47A")
    @Override
    public void setRepeatMode(int repeatMode) {
        addTaint(repeatMode);
        mFlags |= PROPERTY_REPEAT_MODE_MASK;
        super.setRepeatMode(repeatMode);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.629 -0400", hash_original_method = "3C61E6DAB3DDF346757DEBEA1DAB7005", hash_generated_method = "C52F6B3817A7899A7E95101E60AE9ADB")
    @Override
    public void setStartOffset(long startOffset) {
        addTaint(startOffset);
        mFlags |= PROPERTY_START_OFFSET_MASK;
        super.setStartOffset(startOffset);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.630 -0400", hash_original_method = "32142259597E010D1F73DE9F53078982", hash_generated_method = "99366210A2D5FA84627ECB4985851749")
    @Override
    public boolean hasAlpha() {
    if(mDirty)        
        {
            mDirty = mHasAlpha = false;
            final int count = mAnimations.size();
            final ArrayList<Animation> animations = mAnimations;
for(int i = 0;i < count;i++)
            {
    if(animations.get(i).hasAlpha())                
                {
                    mHasAlpha = true;
                    break;
                } 
            } 
        } 
        boolean var888EF7A5D7544FB5951B99C74B40D228_38926534 = (mHasAlpha);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879787775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_879787775;
        
        
            
            
            
            
                
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.630 -0400", hash_original_method = "638E0400F0B782F58F566825CD0FEEA0", hash_generated_method = "50F99B7CDC5B0EA81467471B39A6A0B1")
    @Override
    public void setDuration(long durationMillis) {
        addTaint(durationMillis);
        mFlags |= PROPERTY_DURATION_MASK;
        super.setDuration(durationMillis);
        mLastEnd = mStartOffset + mDuration;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.633 -0400", hash_original_method = "F96436C1C98CEDEFC582978CFED41496", hash_generated_method = "C240BCEF4FB704B6ADFC49AA1DE9247D")
    public void addAnimation(Animation a) {
        mAnimations.add(a);
        boolean noMatrix = (mFlags & PROPERTY_MORPH_MATRIX_MASK) == 0;
    if(noMatrix && a.willChangeTransformationMatrix())        
        {
            mFlags |= PROPERTY_MORPH_MATRIX_MASK;
        } 
        boolean changeBounds = (mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == 0;
    if(changeBounds && a.willChangeTransformationMatrix())        
        {
            mFlags |= PROPERTY_CHANGE_BOUNDS_MASK;
        } 
    if((mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK)        
        {
            mLastEnd = mStartOffset + mDuration;
        } 
        else
        {
    if(mAnimations.size() == 1)            
            {
                mDuration = a.getStartOffset() + a.getDuration();
                mLastEnd = mStartOffset + mDuration;
            } 
            else
            {
                mLastEnd = Math.max(mLastEnd, a.getStartOffset() + a.getDuration());
                mDuration = mLastEnd - mStartOffset;
            } 
        } 
        mDirty = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.634 -0400", hash_original_method = "ED7478CCB671993C959207E062C9FA4F", hash_generated_method = "E88B8AD0A0489F2B7810D7F8885CE2C4")
    @Override
    public void setStartTime(long startTimeMillis) {
        addTaint(startTimeMillis);
        super.setStartTime(startTimeMillis);
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
for(int i = 0;i < count;i++)
        {
            Animation a = animations.get(i);
            a.setStartTime(startTimeMillis);
        } 
        
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.635 -0400", hash_original_method = "1DB17F128BC07A7BFF2B0ED14844511C", hash_generated_method = "629EBD30E924F1A971ABB19CFCFA1FDC")
    @Override
    public long getStartTime() {
        long startTime = Long.MAX_VALUE;
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
for(int i = 0;i < count;i++)
        {
            Animation a = animations.get(i);
            startTime = Math.min(startTime, a.getStartTime());
        } 
        long var5B2A579F62087D17D79CE59F3DE5F6D1_1989928351 = (startTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_148481034 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_148481034;
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.635 -0400", hash_original_method = "8BDDB0E57A894DBD22BE4F412303E6AB", hash_generated_method = "EDFD7C063FD9971AF0D88A58D2BB6462")
    @Override
    public void restrictDuration(long durationMillis) {
        addTaint(durationMillis);
        super.restrictDuration(durationMillis);
        final ArrayList<Animation> animations = mAnimations;
        int count = animations.size();
for(int i = 0;i < count;i++)
        {
            animations.get(i).restrictDuration(durationMillis);
        } 
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.636 -0400", hash_original_method = "0C51A5B794999BCAB9F83D60602DBD5A", hash_generated_method = "86AA4DF630E32FBAF6D50DEB86F735E6")
    @Override
    public long getDuration() {
        final ArrayList<Animation> animations = mAnimations;
        final int count = animations.size();
        long duration = 0;
        boolean durationSet = (mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK;
    if(durationSet)        
        {
            duration = mDuration;
        } 
        else
        {
for(int i = 0;i < count;i++)
            {
                duration = Math.max(duration, animations.get(i).getDuration());
            } 
        } 
        long varB85EC314BF443B797EF8A66B3B03F8A4_745473894 = (duration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1494210147 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1494210147;
        
        
        
        
        
        
            
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.636 -0400", hash_original_method = "979F8D0FD623C4002C8BD37290EA10AA", hash_generated_method = "4A091A5001E9ADEE10BE1FC7B4078570")
    public long computeDurationHint() {
        long duration = 0;
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
for(int i = count - 1;i >= 0;--i)
        {
            final long d = animations.get(i).computeDurationHint();
    if(d > duration)            
            duration = d;
        } 
        long varB85EC314BF443B797EF8A66B3B03F8A4_628278844 = (duration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_57833316 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_57833316;
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.637 -0400", hash_original_method = "357CAB1AB4D965ADF6EAF9B7256F84EE", hash_generated_method = "BFCF3894293EA6F8898D6D3DBFA953DC")
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        final RectF region = mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);
    if(mFillBefore)        
        {
            final int count = mAnimations.size();
            final ArrayList<Animation> animations = mAnimations;
            final Transformation temp = mTempTransformation;
            final Transformation previousTransformation = mPreviousTransformation;
for(int i = count - 1;i >= 0;--i)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.638 -0400", hash_original_method = "3F803CA56592D1A8F5A2DABD815E935C", hash_generated_method = "1AFED66C389E3D7E20AD3A1D1136283A")
    @Override
    public boolean getTransformation(long currentTime, Transformation t) {
        addTaint(t.getTaint());
        addTaint(currentTime);
        final int count = mAnimations.size();
        final ArrayList<Animation> animations = mAnimations;
        final Transformation temp = mTempTransformation;
        boolean more = false;
        boolean started = false;
        boolean ended = true;
        t.clear();
for(int i = count - 1;i >= 0;--i)
        {
            final Animation a = animations.get(i);
            temp.clear();
            more = a.getTransformation(currentTime, temp, getScaleFactor()) || more;
            t.compose(temp);
            started = started || a.hasStarted();
            ended = a.hasEnded() && ended;
        } 
    if(started && !mStarted)        
        {
    if(mListener != null)            
            {
                mListener.onAnimationStart(this);
            } 
            mStarted = true;
        } 
    if(ended != mEnded)        
        {
    if(mListener != null)            
            {
                mListener.onAnimationEnd(this);
            } 
            mEnded = ended;
        } 
        boolean varADDEC426932E71323700AFA1911F8F1C_959139987 = (more);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168073557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_168073557;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.639 -0400", hash_original_method = "2134BF7993F0D641B52B56C7C0A9A6E5", hash_generated_method = "3FDFE82CE26AC0F89E6A8D6C86882C93")
    @Override
    public void scaleCurrentDuration(float scale) {
        addTaint(scale);
        final ArrayList<Animation> animations = mAnimations;
        int count = animations.size();
for(int i = 0;i < count;i++)
        {
            animations.get(i).scaleCurrentDuration(scale);
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.640 -0400", hash_original_method = "CAD543A8149EEDE67DD6611F7E4BF120", hash_generated_method = "C32CCC656AB7F12C44DDD1241E73EBC1")
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        addTaint(parentHeight);
        addTaint(parentWidth);
        addTaint(height);
        addTaint(width);
        super.initialize(width, height, parentWidth, parentHeight);
        boolean durationSet = (mFlags & PROPERTY_DURATION_MASK) == PROPERTY_DURATION_MASK;
        boolean fillAfterSet = (mFlags & PROPERTY_FILL_AFTER_MASK) == PROPERTY_FILL_AFTER_MASK;
        boolean fillBeforeSet = (mFlags & PROPERTY_FILL_BEFORE_MASK) == PROPERTY_FILL_BEFORE_MASK;
        boolean repeatModeSet = (mFlags & PROPERTY_REPEAT_MODE_MASK) == PROPERTY_REPEAT_MODE_MASK;
        boolean shareInterpolator = (mFlags & PROPERTY_SHARE_INTERPOLATOR_MASK)
                == PROPERTY_SHARE_INTERPOLATOR_MASK;
        boolean startOffsetSet = (mFlags & PROPERTY_START_OFFSET_MASK)
                == PROPERTY_START_OFFSET_MASK;
    if(shareInterpolator)        
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
    if(startOffsetSet)        
        {
    if(storedOffsets == null || storedOffsets.length != count)            
            {
                storedOffsets = mStoredOffsets = new long[count];
            } 
        } 
        else
    if(storedOffsets != null)        
        {
            storedOffsets = mStoredOffsets = null;
        } 
for(int i = 0;i < count;i++)
        {
            Animation a = children.get(i);
    if(durationSet)            
            {
                a.setDuration(duration);
            } 
    if(fillAfterSet)            
            {
                a.setFillAfter(fillAfter);
            } 
    if(fillBeforeSet)            
            {
                a.setFillBefore(fillBefore);
            } 
    if(repeatModeSet)            
            {
                a.setRepeatMode(repeatMode);
            } 
    if(shareInterpolator)            
            {
                a.setInterpolator(interpolator);
            } 
    if(startOffsetSet)            
            {
                long offset = a.getStartOffset();
                a.setStartOffset(offset + startOffset);
                storedOffsets[i] = offset;
            } 
            a.initialize(width, height, parentWidth, parentHeight);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.641 -0400", hash_original_method = "2E3A361BE20A8D002834672DDB7CD636", hash_generated_method = "F50B3D17E3EAD3AC5C651A4E6CE1B416")
    @Override
    public void reset() {
        super.reset();
        restoreChildrenStartOffset();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.641 -0400", hash_original_method = "1FA58C163A7DB9A5169EF699805FA3C9", hash_generated_method = "2279BAA9493EAB586EEB7ABA6BF9E5D7")
     void restoreChildrenStartOffset() {
        final long[] offsets = mStoredOffsets;
    if(offsets == null)        
        return;
        final ArrayList<Animation> children = mAnimations;
        final int count = children.size();
for(int i = 0;i < count;i++)
        {
            children.get(i).setStartOffset(offsets[i]);
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.641 -0400", hash_original_method = "EC73055689DC3CDB2DE15C42C77CE8EF", hash_generated_method = "9D6573802CEB69B74DC404D53F694D17")
    public List<Animation> getAnimations() {
List<Animation> var2FFA33FE67F05C81C7BA6EEA1AA0C608_771909556 =         mAnimations;
        var2FFA33FE67F05C81C7BA6EEA1AA0C608_771909556.addTaint(taint);
        return var2FFA33FE67F05C81C7BA6EEA1AA0C608_771909556;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_method = "007230E9C632DD7C25BB9E67DB11C3C3", hash_generated_method = "B00E61762EF85D0E9342D61036DC52EE")
    @Override
    public boolean willChangeTransformationMatrix() {
        boolean var934B00EF70C12F127FB18ABED6AB2DA8_287449491 = ((mFlags & PROPERTY_MORPH_MATRIX_MASK) == PROPERTY_MORPH_MATRIX_MASK);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_992659086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_992659086;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_method = "A538326162AE4CED46022318A3520B17", hash_generated_method = "1408C24DFA4D9988B8C57BE6DB6ACA4F")
    @Override
    public boolean willChangeBounds() {
        boolean varB94FE9EB32C4BC954D47A7E69FC4F151_35690479 = ((mFlags & PROPERTY_CHANGE_BOUNDS_MASK) == PROPERTY_CHANGE_BOUNDS_MASK);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128688281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128688281;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_field = "05C61D34F2D6FA49720C368787295F7C", hash_generated_field = "4E6A2393E3A41FF00CBD8150E755D9D3")

    private static final int PROPERTY_FILL_AFTER_MASK = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_field = "777BB302827C2D122E450457A10D3BA7", hash_generated_field = "AF3B072AF41D6260060EBDA66CF66385")

    private static final int PROPERTY_FILL_BEFORE_MASK = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_field = "B81B9161EB151AE3DEAEE42B58F544B9", hash_generated_field = "1FD86F067E7DF1209C97B9951E5A2D68")

    private static final int PROPERTY_REPEAT_MODE_MASK = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_field = "441E05DBA26742E52C72A452E9B86340", hash_generated_field = "D59291534504149726C15D5B8C4B78EF")

    private static final int PROPERTY_START_OFFSET_MASK = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_field = "A72EEEC20A966DB75D61B5074375CCA1", hash_generated_field = "16B7CB13D692AA5D34D2FE4D9F825737")

    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_field = "B44854A667D88A05C8430A29896B5F4F", hash_generated_field = "4649CE1597E4F6226E08DA4CD678394F")

    private static final int PROPERTY_DURATION_MASK = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_field = "F76845D17AEC36F4A6EB6848D6A60DCB", hash_generated_field = "58E407F6C09F775B2C3112E974909A4B")

    private static final int PROPERTY_MORPH_MATRIX_MASK = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.642 -0400", hash_original_field = "3FAD3D66D5C579A786F540732A33C45E", hash_generated_field = "DD8036C86532BF82965105099123C6F4")

    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 0x80;
}

