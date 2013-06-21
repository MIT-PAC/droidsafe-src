package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Random;

public class LayoutAnimationController {
    protected Animation mAnimation;
    protected Random mRandomizer;
    protected Interpolator mInterpolator;
    private float mDelay;
    private int mOrder;
    private long mDuration;
    private long mMaxDelay;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.148 -0400", hash_original_method = "E3D4984E609CD7A8F1E539254F42C7CB", hash_generated_method = "0425A1EAE767A319E66CEB0A2A2FFE08")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.148 -0400", hash_original_method = "F5882907CA59BB2AE2BDFE73A922FA4E", hash_generated_method = "8F963B94EED5625FB18E2A47FF35B44A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutAnimationController(Animation animation) {
        this(animation, 0.5f);
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.149 -0400", hash_original_method = "2D34A90DB159467DA6803B576AE47B5C", hash_generated_method = "3DFE8DCA919FDF7E482DBB10ADE43B54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutAnimationController(Animation animation, float delay) {
        dsTaint.addTaint(animation.dsTaint);
        dsTaint.addTaint(delay);
        setAnimation(animation);
        // ---------- Original Method ----------
        //mDelay = delay;
        //setAnimation(animation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.149 -0400", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "76479DEE3C3B466A0078F5144E9D0D88")
    @DSModeled(DSC.SAFE)
    public int getOrder() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.149 -0400", hash_original_method = "648C96BEF511A58A69E168C40D059B54", hash_generated_method = "8E00A8899254F07D866542E0CDF2971C")
    @DSModeled(DSC.SAFE)
    public void setOrder(int order) {
        dsTaint.addTaint(order);
        // ---------- Original Method ----------
        //mOrder = order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.149 -0400", hash_original_method = "DA137DCBF1E5E58EF4425067063E3D6F", hash_generated_method = "D61EAED565BC15ECE5D1B5BD5C97F906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAnimation(Context context, int resourceID) {
        dsTaint.addTaint(resourceID);
        dsTaint.addTaint(context.dsTaint);
        setAnimation(AnimationUtils.loadAnimation(context, resourceID));
        // ---------- Original Method ----------
        //setAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.149 -0400", hash_original_method = "B4A74FA6048B5852F1E265E64E11FC0D", hash_generated_method = "5D4695134ED5BD42F42ECFC5E79688C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAnimation(Animation animation) {
        dsTaint.addTaint(animation.dsTaint);
        mAnimation.setFillBefore(true);
        // ---------- Original Method ----------
        //mAnimation = animation;
        //mAnimation.setFillBefore(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.150 -0400", hash_original_method = "DAC4606AD5070B4B7D220BEE34A17978", hash_generated_method = "22C8F8E6DA61D692547264E4A6463F29")
    @DSModeled(DSC.SAFE)
    public Animation getAnimation() {
        return (Animation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.150 -0400", hash_original_method = "66DF0F8C4443D43AC8C0B59FD3C0EE80", hash_generated_method = "5A342C081CD22B78CCF851B2B8ABC1DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInterpolator(Context context, int resourceID) {
        dsTaint.addTaint(resourceID);
        dsTaint.addTaint(context.dsTaint);
        setInterpolator(AnimationUtils.loadInterpolator(context, resourceID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.150 -0400", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "A14ED552F9DB6BE8496AFC6BEA170232")
    @DSModeled(DSC.SAFE)
    public void setInterpolator(Interpolator interpolator) {
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.150 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "76053164EB61152210D7C18D58A6F349")
    @DSModeled(DSC.SAFE)
    public Interpolator getInterpolator() {
        return (Interpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.150 -0400", hash_original_method = "55CD68136127075BB4939DEA602DB451", hash_generated_method = "F82277A3D8EFDE77F6F7BE24D2D47063")
    @DSModeled(DSC.SAFE)
    public float getDelay() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.150 -0400", hash_original_method = "66A46BCEB9C76B70A4A3D1129198A613", hash_generated_method = "B1BC018E6D7A058C4A1072F4CC2F10B0")
    @DSModeled(DSC.SAFE)
    public void setDelay(float delay) {
        dsTaint.addTaint(delay);
        // ---------- Original Method ----------
        //mDelay = delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.151 -0400", hash_original_method = "C391ED719773BAF357B5BB149771DE74", hash_generated_method = "AAA9D21F90DE68DF987FDBE226B2E91F")
    @DSModeled(DSC.SAFE)
    public boolean willOverlap() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDelay < 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.151 -0400", hash_original_method = "78D31C459A561793AE549A78D34651C2", hash_generated_method = "28ED2DD3D8DE8D02B2A83588A15C5A4B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.151 -0400", hash_original_method = "96F3EFCD32C49E23FCBCF1FC0105A7B0", hash_generated_method = "4553FF5C21431519FBF2C724BA3321FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Animation getAnimationForView(View view) {
        dsTaint.addTaint(view.dsTaint);
        long delay;
        delay = getDelayForView(view) + mAnimation.getStartOffset();
        mMaxDelay = Math.max(mMaxDelay, delay);
        try 
        {
            Animation animation;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.151 -0400", hash_original_method = "F6685E165800CF46F16D582CC6341EDA", hash_generated_method = "4D61563594ECBE481E39C87046D700F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDone() {
        boolean varAA996CFF263FCCB06A70FF5712A8C20D_1386104327 = (AnimationUtils.currentAnimationTimeMillis() >
                mAnimation.getStartTime() + mMaxDelay + mDuration);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return AnimationUtils.currentAnimationTimeMillis() >
                //mAnimation.getStartTime() + mMaxDelay + mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.152 -0400", hash_original_method = "C5014C66E1BA1577E6F39C7457247B02", hash_generated_method = "217C84329A264664380170A75998B79C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected long getDelayForView(View view) {
        dsTaint.addTaint(view.dsTaint);
        ViewGroup.LayoutParams lp;
        lp = view.getLayoutParams();
        AnimationParameters params;
        params = lp.layoutAnimationParameters;
        float delay;
        delay = mDelay * mAnimation.getDuration();
        long viewDelay;
        viewDelay = (long) (getTransformedIndex(params) * delay);
        float totalDelay;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.152 -0400", hash_original_method = "305795D5C2AE9556CA8D226C9088184E", hash_generated_method = "AB6C606858954EC2050040E90616BC65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getTransformedIndex(AnimationParameters params) {
        dsTaint.addTaint(params.dsTaint);
        {
            Object var998A9FCD617ED3F225652B49EC9B64C8_1268569568 = (getOrder());
            //Begin case ORDER_RANDOM 
            {
                mRandomizer = new Random();
            } //End block
            //End case ORDER_RANDOM 
            //Begin case ORDER_RANDOM 
            int var35A3E0E3BF8465C06EAD60D9C202EAD6_412877123 = ((int) (params.count * mRandomizer.nextFloat()));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.152 -0400", hash_original_method = "306FDDA070662CC16985D7D7D54EA29B", hash_generated_method = "306FDDA070662CC16985D7D7D54EA29B")
                public AnimationParameters ()
        {
        }


    }


    
    public static final int ORDER_NORMAL  = 0;
    public static final int ORDER_REVERSE = 1;
    public static final int ORDER_RANDOM  = 2;
}

