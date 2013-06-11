package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Random;

public class LayoutAnimationController {
    public static final int ORDER_NORMAL  = 0;
    public static final int ORDER_REVERSE = 1;
    public static final int ORDER_RANDOM  = 2;
    protected Animation mAnimation;
    protected Random mRandomizer;
    protected Interpolator mInterpolator;
    private float mDelay;
    private int mOrder;
    private long mDuration;
    private long mMaxDelay;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "E3D4984E609CD7A8F1E539254F42C7CB", hash_generated_method = "25D8D5FABB438E0770457DFD08DB4D58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutAnimationController(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LayoutAnimation);
        Animation.Description d;
        d = Animation.Description.parseValue(
                a.peekValue(com.android.internal.R.styleable.LayoutAnimation_delay));
        mDelay = d.value;
        mOrder = a.getInt(com.android.internal.R.styleable.LayoutAnimation_animationOrder, ORDER_NORMAL);
        int resource;
        resource = a.getResourceId(com.android.internal.R.styleable.LayoutAnimation_animation, 0);
        {
            setAnimation(context, resource);
        } //End block
        resource = a.getResourceId(com.android.internal.R.styleable.LayoutAnimation_interpolator, 0);
        {
            setInterpolator(context, resource);
        } //End block
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LayoutAnimation);
        //Animation.Description d = Animation.Description.parseValue(
                //a.peekValue(com.android.internal.R.styleable.LayoutAnimation_delay));
        //mDelay = d.value;
        //mOrder = a.getInt(com.android.internal.R.styleable.LayoutAnimation_animationOrder, ORDER_NORMAL);
        //int resource = a.getResourceId(com.android.internal.R.styleable.LayoutAnimation_animation, 0);
        //if (resource > 0) {
            //setAnimation(context, resource);
        //}
        //resource = a.getResourceId(com.android.internal.R.styleable.LayoutAnimation_interpolator, 0);
        //if (resource > 0) {
            //setInterpolator(context, resource);
        //}
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "F5882907CA59BB2AE2BDFE73A922FA4E", hash_generated_method = "872F1D4CB37C93B64C0F994478E128B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutAnimationController(Animation animation) {
        this(animation, 0.5f);
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "2D34A90DB159467DA6803B576AE47B5C", hash_generated_method = "031C7AFA184A5C923596CEAF73D4346B")
    @DSModeled(DSC.SAFE)
    public LayoutAnimationController(Animation animation, float delay) {
        dsTaint.addTaint(animation.dsTaint);
        dsTaint.addTaint(delay);
        setAnimation(animation);
        // ---------- Original Method ----------
        //mDelay = delay;
        //setAnimation(animation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "56ADEEF631B73EB26BADF974E5E6A6FA")
    @DSModeled(DSC.SAFE)
    public int getOrder() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "648C96BEF511A58A69E168C40D059B54", hash_generated_method = "4817434D7C01CD924BFCD1F1A9089EC7")
    @DSModeled(DSC.SAFE)
    public void setOrder(int order) {
        dsTaint.addTaint(order);
        // ---------- Original Method ----------
        //mOrder = order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "DA137DCBF1E5E58EF4425067063E3D6F", hash_generated_method = "B66510D8B5D66E71AC17A41D1B6D0C27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAnimation(Context context, int resourceID) {
        dsTaint.addTaint(resourceID);
        dsTaint.addTaint(context.dsTaint);
        setAnimation(AnimationUtils.loadAnimation(context, resourceID));
        // ---------- Original Method ----------
        //setAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "B4A74FA6048B5852F1E265E64E11FC0D", hash_generated_method = "C9083256EDFAB9B632C0956EA83CF945")
    @DSModeled(DSC.SAFE)
    public void setAnimation(Animation animation) {
        dsTaint.addTaint(animation.dsTaint);
        mAnimation.setFillBefore(true);
        // ---------- Original Method ----------
        //mAnimation = animation;
        //mAnimation.setFillBefore(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "DAC4606AD5070B4B7D220BEE34A17978", hash_generated_method = "28BDA5448F04805BF35D1C64C00A31CB")
    @DSModeled(DSC.SAFE)
    public Animation getAnimation() {
        return (Animation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.871 -0400", hash_original_method = "66DF0F8C4443D43AC8C0B59FD3C0EE80", hash_generated_method = "2DA4A13611127658C41EC831D58571DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInterpolator(Context context, int resourceID) {
        dsTaint.addTaint(resourceID);
        dsTaint.addTaint(context.dsTaint);
        setInterpolator(AnimationUtils.loadInterpolator(context, resourceID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "8BFFA42E2F11EC2F4AA064053DB323E7")
    @DSModeled(DSC.SAFE)
    public void setInterpolator(Interpolator interpolator) {
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "68BD8EAF0EBFDD77CF24F1750A8A54DC")
    @DSModeled(DSC.SAFE)
    public Interpolator getInterpolator() {
        return (Interpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "55CD68136127075BB4939DEA602DB451", hash_generated_method = "C5E02520F4771BDF5DA27E7490E707C1")
    @DSModeled(DSC.SAFE)
    public float getDelay() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "66A46BCEB9C76B70A4A3D1129198A613", hash_generated_method = "DE7DCFC13165836EC2E9A676351A6C46")
    @DSModeled(DSC.SAFE)
    public void setDelay(float delay) {
        dsTaint.addTaint(delay);
        // ---------- Original Method ----------
        //mDelay = delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "C391ED719773BAF357B5BB149771DE74", hash_generated_method = "DDE684ED88FC49FDCFA94299AE731BFB")
    @DSModeled(DSC.SAFE)
    public boolean willOverlap() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDelay < 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "78D31C459A561793AE549A78D34651C2", hash_generated_method = "CA06C5F4066D669AD2FCEAE71C847CEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        mDuration = mAnimation.getDuration();
        mMaxDelay = Long.MIN_VALUE;
        mAnimation.setStartTime(-1);
        // ---------- Original Method ----------
        //mDuration = mAnimation.getDuration();
        //mMaxDelay = Long.MIN_VALUE;
        //mAnimation.setStartTime(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "96F3EFCD32C49E23FCBCF1FC0105A7B0", hash_generated_method = "C5A870FB3AFC11CC2A4202AE6C5D686D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Animation getAnimationForView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        final long delay;
        delay = getDelayForView(view) + mAnimation.getStartOffset();
        mMaxDelay = Math.max(mMaxDelay, delay);
        try 
        {
            final Animation animation;
            animation = mAnimation.clone();
            animation.setStartOffset(delay);
        } //End block
        catch (CloneNotSupportedException e)
        { }
        return (Animation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final long delay = getDelayForView(view) + mAnimation.getStartOffset();
        //mMaxDelay = Math.max(mMaxDelay, delay);
        //try {
            //final Animation animation = mAnimation.clone();
            //animation.setStartOffset(delay);
            //return animation;
        //} catch (CloneNotSupportedException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "F6685E165800CF46F16D582CC6341EDA", hash_generated_method = "9688A578B5CCAFC617AC2FF25AE04B23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDone() {
        boolean varAA996CFF263FCCB06A70FF5712A8C20D_656448959 = (AnimationUtils.currentAnimationTimeMillis() >
                mAnimation.getStartTime() + mMaxDelay + mDuration);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return AnimationUtils.currentAnimationTimeMillis() >
                //mAnimation.getStartTime() + mMaxDelay + mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "C5014C66E1BA1577E6F39C7457247B02", hash_generated_method = "D6AA3A26369488CC2D7506E1AE7D7AEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected long getDelayForView(View view) {
        dsTaint.addTaint(view.dsTaint);
        ViewGroup.LayoutParams lp;
        lp = view.getLayoutParams();
        AnimationParameters params;
        params = lp.layoutAnimationParameters;
        final float delay;
        delay = mDelay * mAnimation.getDuration();
        final long viewDelay;
        viewDelay = (long) (getTransformedIndex(params) * delay);
        final float totalDelay;
        totalDelay = delay * params.count;
        {
            mInterpolator = new LinearInterpolator();
        } //End block
        float normalizedDelay;
        normalizedDelay = viewDelay / totalDelay;
        normalizedDelay = mInterpolator.getInterpolation(normalizedDelay);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //ViewGroup.LayoutParams lp = view.getLayoutParams();
        //AnimationParameters params = lp.layoutAnimationParameters;
        //if (params == null) {
            //return 0;
        //}
        //final float delay = mDelay * mAnimation.getDuration();
        //final long viewDelay = (long) (getTransformedIndex(params) * delay);
        //final float totalDelay = delay * params.count;
        //if (mInterpolator == null) {
            //mInterpolator = new LinearInterpolator();
        //}
        //float normalizedDelay = viewDelay / totalDelay;
        //normalizedDelay = mInterpolator.getInterpolation(normalizedDelay);
        //return (long) (normalizedDelay * totalDelay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.872 -0400", hash_original_method = "305795D5C2AE9556CA8D226C9088184E", hash_generated_method = "1C13EA00944D5C51D1C379F02C77B3D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getTransformedIndex(AnimationParameters params) {
        dsTaint.addTaint(params.dsTaint);
        {
            Object var998A9FCD617ED3F225652B49EC9B64C8_1946578778 = (getOrder());
            //Begin case ORDER_RANDOM 
            {
                mRandomizer = new Random();
            } //End block
            //End case ORDER_RANDOM 
            //Begin case ORDER_RANDOM 
            int var35A3E0E3BF8465C06EAD60D9C202EAD6_1809803614 = ((int) (params.count * mRandomizer.nextFloat()));
            //End case ORDER_RANDOM 
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (getOrder()) {
            //case ORDER_REVERSE:
                //return params.count - 1 - params.index;
            //case ORDER_RANDOM:
                //if (mRandomizer == null) {
                    //mRandomizer = new Random();
                //}
                //return (int) (params.count * mRandomizer.nextFloat());
            //case ORDER_NORMAL:
            //default:
                //return params.index;
        //}
    }

    
    public static class AnimationParameters {
        public int count;
        public int index;
        
    }


    
}


