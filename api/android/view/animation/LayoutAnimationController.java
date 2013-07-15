package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Random;

public class LayoutAnimationController {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.876 -0400", hash_original_field = "9A46FC3BA66487AE56C5DCE37D0AA79A", hash_generated_field = "24E67EC6656CB0E8440535D7029988FE")

    protected Animation mAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.876 -0400", hash_original_field = "970C389A690CAE654EE6336AA068E17C", hash_generated_field = "2D35EFF44D7BEB70FAD342EC80A5CE7E")

    protected Random mRandomizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.876 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "9557EEC9CBF12937FA6D035BD738A81B")

    protected Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.876 -0400", hash_original_field = "4A07FB752767B90A168D4F2A331D5C36", hash_generated_field = "40E31E41BFDF10FA2549A57D1E0B2464")

    private float mDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.876 -0400", hash_original_field = "6D112D2229BB97D14E6F55D683775A63", hash_generated_field = "5491D551C576BD6880788C5897A5BA8A")

    private int mOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.876 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "8BF5222528387AE04CED3C727F9F8865")

    private long mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.876 -0400", hash_original_field = "6A66DFEF19618C77DCA9D07E8E24369A", hash_generated_field = "6858B6909E393C6400B9A7BBD2C111B0")

    private long mMaxDelay;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.877 -0400", hash_original_method = "E3D4984E609CD7A8F1E539254F42C7CB", hash_generated_method = "6599FBA1793D0D999F80A5DF15D5270C")
    public  LayoutAnimationController(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.LayoutAnimation);
        Animation.Description d = Animation.Description.parseValue(
                a.peekValue(com.android.internal.R.styleable.LayoutAnimation_delay));
        mDelay = d.value;
        mOrder = a.getInt(com.android.internal.R.styleable.LayoutAnimation_animationOrder, ORDER_NORMAL);
        int resource = a.getResourceId(com.android.internal.R.styleable.LayoutAnimation_animation, 0);
    if(resource > 0)        
        {
            setAnimation(context, resource);
        } //End block
        resource = a.getResourceId(com.android.internal.R.styleable.LayoutAnimation_interpolator, 0);
    if(resource > 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.878 -0400", hash_original_method = "F5882907CA59BB2AE2BDFE73A922FA4E", hash_generated_method = "2EAF47A6EA8A6AEDDCA1D592BA1B3308")
    public  LayoutAnimationController(Animation animation) {
        this(animation, 0.5f);
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.878 -0400", hash_original_method = "2D34A90DB159467DA6803B576AE47B5C", hash_generated_method = "57A02ECF74DFF799389B5B731A434AE3")
    public  LayoutAnimationController(Animation animation, float delay) {
        addTaint(animation.getTaint());
        mDelay = delay;
        setAnimation(animation);
        // ---------- Original Method ----------
        //mDelay = delay;
        //setAnimation(animation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.878 -0400", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "60E59B06B163141A53B4BB73EE00D08E")
    public int getOrder() {
        int var6D112D2229BB97D14E6F55D683775A63_369650835 = (mOrder);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193311010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193311010;
        // ---------- Original Method ----------
        //return mOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.879 -0400", hash_original_method = "648C96BEF511A58A69E168C40D059B54", hash_generated_method = "23B5E85A7019C72C38679E0BA3B78B0E")
    public void setOrder(int order) {
        mOrder = order;
        // ---------- Original Method ----------
        //mOrder = order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.879 -0400", hash_original_method = "DA137DCBF1E5E58EF4425067063E3D6F", hash_generated_method = "2B206605AF532EE5314F1209E68A2FA4")
    public void setAnimation(Context context, int resourceID) {
        addTaint(resourceID);
        addTaint(context.getTaint());
        setAnimation(AnimationUtils.loadAnimation(context, resourceID));
        // ---------- Original Method ----------
        //setAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.880 -0400", hash_original_method = "B4A74FA6048B5852F1E265E64E11FC0D", hash_generated_method = "650036FF6A01BD934E9A839927003C94")
    public void setAnimation(Animation animation) {
        mAnimation = animation;
        mAnimation.setFillBefore(true);
        // ---------- Original Method ----------
        //mAnimation = animation;
        //mAnimation.setFillBefore(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.880 -0400", hash_original_method = "DAC4606AD5070B4B7D220BEE34A17978", hash_generated_method = "0FB888DAA280209450A5A10A27E0E0D7")
    public Animation getAnimation() {
Animation var267087685D2F38DE7EECB639921105B0_400424183 =         mAnimation;
        var267087685D2F38DE7EECB639921105B0_400424183.addTaint(taint);
        return var267087685D2F38DE7EECB639921105B0_400424183;
        // ---------- Original Method ----------
        //return mAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.880 -0400", hash_original_method = "66DF0F8C4443D43AC8C0B59FD3C0EE80", hash_generated_method = "8A3E40D82369492DCD0C118058CAE68A")
    public void setInterpolator(Context context, int resourceID) {
        addTaint(resourceID);
        addTaint(context.getTaint());
        setInterpolator(AnimationUtils.loadInterpolator(context, resourceID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.881 -0400", hash_original_method = "7D5A9A852D608ADF508B994526BF9EAC", hash_generated_method = "305B3174980281AD6A6C4213980CE615")
    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.881 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "1FC139C56071CFB6B0409DAB5F28ADE2")
    public Interpolator getInterpolator() {
Interpolator var9FA301F6AF154FEBBB2C7439D021F894_1917899020 =         mInterpolator;
        var9FA301F6AF154FEBBB2C7439D021F894_1917899020.addTaint(taint);
        return var9FA301F6AF154FEBBB2C7439D021F894_1917899020;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.881 -0400", hash_original_method = "55CD68136127075BB4939DEA602DB451", hash_generated_method = "24937C0691A5AA7DA191F9CD3C50F113")
    public float getDelay() {
        float var4A07FB752767B90A168D4F2A331D5C36_113157544 = (mDelay);
                float var546ADE640B6EDFBC8A086EF31347E768_1398009532 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1398009532;
        // ---------- Original Method ----------
        //return mDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.887 -0400", hash_original_method = "66A46BCEB9C76B70A4A3D1129198A613", hash_generated_method = "68B321DC0C555672B92725ED9120FBBD")
    public void setDelay(float delay) {
        mDelay = delay;
        // ---------- Original Method ----------
        //mDelay = delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.887 -0400", hash_original_method = "C391ED719773BAF357B5BB149771DE74", hash_generated_method = "360C0D0F22B14C3E6BB0796ADCED730F")
    public boolean willOverlap() {
        boolean var02C5090F3AD9B37500835DCA56FD4C36_163660839 = (mDelay < 1.0f);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_14378241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_14378241;
        // ---------- Original Method ----------
        //return mDelay < 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.887 -0400", hash_original_method = "78D31C459A561793AE549A78D34651C2", hash_generated_method = "28ED2DD3D8DE8D02B2A83588A15C5A4B")
    public void start() {
        mDuration = mAnimation.getDuration();
        mMaxDelay = Long.MIN_VALUE;
        mAnimation.setStartTime(-1);
        // ---------- Original Method ----------
        //mDuration = mAnimation.getDuration();
        //mMaxDelay = Long.MIN_VALUE;
        //mAnimation.setStartTime(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.888 -0400", hash_original_method = "96F3EFCD32C49E23FCBCF1FC0105A7B0", hash_generated_method = "351F6AA7F9668EB2C9C64334763E85A6")
    public final Animation getAnimationForView(View view) {
        addTaint(view.getTaint());
        final long delay = getDelayForView(view) + mAnimation.getStartOffset();
        mMaxDelay = Math.max(mMaxDelay, delay);
        try 
        {
            final Animation animation = mAnimation.clone();
            animation.setStartOffset(delay);
Animation var1D3E9F798E82851E6201AD690FEA4543_2134671378 =             animation;
            var1D3E9F798E82851E6201AD690FEA4543_2134671378.addTaint(taint);
            return var1D3E9F798E82851E6201AD690FEA4543_2134671378;
        } //End block
        catch (CloneNotSupportedException e)
        {
Animation var540C13E9E156B687226421B24F2DF178_1235608902 =             null;
            var540C13E9E156B687226421B24F2DF178_1235608902.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1235608902;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.888 -0400", hash_original_method = "F6685E165800CF46F16D582CC6341EDA", hash_generated_method = "116FDA041937B4CC283BDEAB52DD8EF7")
    public boolean isDone() {
        boolean var8CADBAA2AEA174A3CC501FAC0D1F9F89_329054835 = (AnimationUtils.currentAnimationTimeMillis() >
                mAnimation.getStartTime() + mMaxDelay + mDuration);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127875273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127875273;
        // ---------- Original Method ----------
        //return AnimationUtils.currentAnimationTimeMillis() >
                //mAnimation.getStartTime() + mMaxDelay + mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.889 -0400", hash_original_method = "C5014C66E1BA1577E6F39C7457247B02", hash_generated_method = "86ABAFD9A0D026E2A9678552628B1579")
    protected long getDelayForView(View view) {
        addTaint(view.getTaint());
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        AnimationParameters params = lp.layoutAnimationParameters;
    if(params == null)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1937719135 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_425148132 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_425148132;
        } //End block
        final float delay = mDelay * mAnimation.getDuration();
        final long viewDelay = (long) (getTransformedIndex(params) * delay);
        final float totalDelay = delay * params.count;
    if(mInterpolator == null)        
        {
            mInterpolator = new LinearInterpolator();
        } //End block
        float normalizedDelay = viewDelay / totalDelay;
        normalizedDelay = mInterpolator.getInterpolation(normalizedDelay);
        long varE65571F221469C7C9AAECA50B46EA242_2108098203 = ((long) (normalizedDelay * totalDelay));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_370192991 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_370192991;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.890 -0400", hash_original_method = "305795D5C2AE9556CA8D226C9088184E", hash_generated_method = "DA5A740B79A7FA3FC61BD49D6EDDB221")
    protected int getTransformedIndex(AnimationParameters params) {
        addTaint(params.getTaint());
switch(getOrder()){
        case ORDER_REVERSE:
        int var33AAD88FD73110B36FD1D2069C70C701_1893597835 = (params.count - 1 - params.index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53830045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53830045;
        case ORDER_RANDOM:
    if(mRandomizer == null)        
        {
            mRandomizer = new Random();
        } //End block
        int var44B54535E1AB5BF3A610EAF6468B6A2A_1010593800 = ((int) (params.count * mRandomizer.nextFloat()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651383237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651383237;
        case ORDER_NORMAL:
        default:
        int var11E1C9E2A00B4E00D44EE70247924CB8_1449396819 = (params.index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744513836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744513836;
}
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.890 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.890 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "AE1343475DB0F2C28979E182E3B11BCC")

        public int index;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.891 -0400", hash_original_method = "838D907A76D7295751639A8A84C023C1", hash_generated_method = "838D907A76D7295751639A8A84C023C1")
        public AnimationParameters ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.891 -0400", hash_original_field = "E45438A8F9A60BA7AC2587957426E9FE", hash_generated_field = "E859EC909F26DCFC9E7628E48052485C")

    public static final int ORDER_NORMAL  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.891 -0400", hash_original_field = "7E153306CF50C4C37B7189EB0B1B4A93", hash_generated_field = "8AF0E7C910184642E51646CAC9E86C19")

    public static final int ORDER_REVERSE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.891 -0400", hash_original_field = "DADA65EAD5CF7CD10F7A4D963D47457D", hash_generated_field = "96FD66E505BF01EB19B03EE5BB059919")

    public static final int ORDER_RANDOM  = 2;
}

