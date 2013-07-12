package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.TimeInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ViewPropertyAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.620 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.620 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "8BF5222528387AE04CED3C727F9F8865")

    private long mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.620 -0400", hash_original_field = "2173D0EAB9C999840AC85B43401734BC", hash_generated_field = "03D5FC9AEBB7D8B90777FF73C31E1A48")

    private boolean mDurationSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.620 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.620 -0400", hash_original_field = "DF48E3731958141B55A4C7E73DDFC592", hash_generated_field = "4F4328485D02696A823721721A3E8657")

    private boolean mStartDelaySet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.620 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "EACBADF91032ABF3D011EE1B3057F84D")

    private TimeInterpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.620 -0400", hash_original_field = "4E6DBADDA65ADE077AE86FF3C107D674", hash_generated_field = "82B2216AD41FE3E781D6035774E250B3")

    private boolean mInterpolatorSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.621 -0400", hash_original_field = "6F7F10CDECDD60587A676132819FC95C", hash_generated_field = "69256070A6B51CD84194DBDA7B561216")

    private Animator.AnimatorListener mListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.621 -0400", hash_original_field = "08EB2BB862E5FE0721A17E700067CCEB", hash_generated_field = "2F88CB8CE002DBE4EE3C525DE38A44D1")

    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.621 -0400", hash_original_field = "DCD9F986A2DB3ACDD6D71B582052B6E9", hash_generated_field = "245199B04CE5933EE61BB14613CB2F2D")

    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<NameValuesHolder>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "E77137B6BB2AC6EED35F93F563E9A9A8", hash_generated_field = "DDAE17988E2F7FE309FFBA8222A2CC64")

    private Runnable mAnimationStarter = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_method = "FBB53873B37744AA497F2F82BA93513F", hash_generated_method = "B49121F60C78DA005BF63A708AB544D3")
        @Override
        public void run() {
            startAnimation();
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.621 -0400", hash_original_field = "2BB891F43500DBB293AEBA7F524B468D", hash_generated_field = "8AE0B8099C4E7901C63106A6D931EB1C")

    private HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap<Animator, PropertyBundle>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.621 -0400", hash_original_method = "684AC817B57804E91C0EF57CA21B86F4", hash_generated_method = "81503CFEBD19EABDC587B9564B95B657")
      ViewPropertyAnimator(View view) {
        mView = view;
        view.ensureTransformationInfo();
        // ---------- Original Method ----------
        //mView = view;
        //view.ensureTransformationInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.622 -0400", hash_original_method = "AB53F93DCFA553673F10278B2219DEEA", hash_generated_method = "082FF5811C2AD6C44914522C9F6E038F")
    public ViewPropertyAnimator setDuration(long duration) {
    if(duration < 0)        
        {
            IllegalArgumentException varBE9004E8E8C014F966F457353E164ECE_1842761425 = new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
            varBE9004E8E8C014F966F457353E164ECE_1842761425.addTaint(taint);
            throw varBE9004E8E8C014F966F457353E164ECE_1842761425;
        } //End block
        mDurationSet = true;
        mDuration = duration;
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1809856062 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1809856062.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1809856062;
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDurationSet = true;
        //mDuration = duration;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.623 -0400", hash_original_method = "BFD4BDEC4492EF4D0AE1BFA285B3702C", hash_generated_method = "B5C0E3E99CC5D81950369CCBC2228FDE")
    public long getDuration() {
    if(mDurationSet)        
        {
            long var25395741BFE51A7D136A5C7109AAD2D8_858478131 = (mDuration);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_622619126 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_622619126;
        } //End block
        else
        {
            long varE9BF4C9C84488436E1D1F2E5F9AADB49_1469001552 = (new ValueAnimator().getDuration());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_773048794 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_773048794;
        } //End block
        // ---------- Original Method ----------
        //if (mDurationSet) {
            //return mDuration;
        //} else {
            //return new ValueAnimator().getDuration();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.624 -0400", hash_original_method = "137A1F44FEDEF7DBAEA1EE8251F82E1F", hash_generated_method = "75A392599894A1D86E29D1F95101AA8C")
    public long getStartDelay() {
    if(mStartDelaySet)        
        {
            long varD6348B0CF9AA194EA8CCE71E8A2B9F80_1690411603 = (mStartDelay);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1318857108 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1318857108;
        } //End block
        else
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_2012860087 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_192324216 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_192324216;
        } //End block
        // ---------- Original Method ----------
        //if (mStartDelaySet) {
            //return mStartDelay;
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.625 -0400", hash_original_method = "55E567100D84151F5304C84C830F2C1B", hash_generated_method = "A9526DC77B31722C05156A33E37B576A")
    public ViewPropertyAnimator setStartDelay(long startDelay) {
    if(startDelay < 0)        
        {
            IllegalArgumentException varFCA553B88D1C3C33CE9EEFDD31E7822C_1481315794 = new IllegalArgumentException("Animators cannot have negative duration: " +
                    startDelay);
            varFCA553B88D1C3C33CE9EEFDD31E7822C_1481315794.addTaint(taint);
            throw varFCA553B88D1C3C33CE9EEFDD31E7822C_1481315794;
        } //End block
        mStartDelaySet = true;
        mStartDelay = startDelay;
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_630557976 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_630557976.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_630557976;
        // ---------- Original Method ----------
        //if (startDelay < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //startDelay);
        //}
        //mStartDelaySet = true;
        //mStartDelay = startDelay;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.626 -0400", hash_original_method = "995017692E981832E150BE79F0CB8507", hash_generated_method = "A8453D832A912FF9E2D89C9AB5C589AA")
    public ViewPropertyAnimator setInterpolator(TimeInterpolator interpolator) {
        mInterpolatorSet = true;
        mInterpolator = interpolator;
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1269282868 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1269282868.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1269282868;
        // ---------- Original Method ----------
        //mInterpolatorSet = true;
        //mInterpolator = interpolator;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.626 -0400", hash_original_method = "D3B983C6B8AF317CF4B7893570C39145", hash_generated_method = "049B26913B300E81924379BFC3180F46")
    public ViewPropertyAnimator setListener(Animator.AnimatorListener listener) {
        mListener = listener;
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1265489122 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1265489122.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1265489122;
        // ---------- Original Method ----------
        //mListener = listener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.626 -0400", hash_original_method = "8C3C0DB6E3E572D598F887EBD1169042", hash_generated_method = "A5710AE0D85F06F649F4EF64FCC54E4A")
    public void start() {
        startAnimation();
        // ---------- Original Method ----------
        //startAnimation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.627 -0400", hash_original_method = "504B77AB05B1FC68628CE89848555449", hash_generated_method = "19BC79E1E8A09A787338888B8F75DA6A")
    public void cancel() {
    if(mAnimatorMap.size() > 0)        
        {
            HashMap<Animator, PropertyBundle> mAnimatorMapCopy = (HashMap<Animator, PropertyBundle>)mAnimatorMap.clone();
            Set<Animator> animatorSet = mAnimatorMapCopy.keySet();
for(Animator runningAnim : animatorSet)
            {
                runningAnim.cancel();
            } //End block
        } //End block
        mPendingAnimations.clear();
        mView.removeCallbacks(mAnimationStarter);
        // ---------- Original Method ----------
        //if (mAnimatorMap.size() > 0) {
            //HashMap<Animator, PropertyBundle> mAnimatorMapCopy =
                    //(HashMap<Animator, PropertyBundle>)mAnimatorMap.clone();
            //Set<Animator> animatorSet = mAnimatorMapCopy.keySet();
            //for (Animator runningAnim : animatorSet) {
                //runningAnim.cancel();
            //}
        //}
        //mPendingAnimations.clear();
        //mView.removeCallbacks(mAnimationStarter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.627 -0400", hash_original_method = "8D670697E365032294CEEA6593A27CE4", hash_generated_method = "6447F4C6DB882F637BAADB24F47269C7")
    public ViewPropertyAnimator x(float value) {
        addTaint(value);
        animateProperty(X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_139436040 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_139436040.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_139436040;
        // ---------- Original Method ----------
        //animateProperty(X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.627 -0400", hash_original_method = "2E3B808D4A6B84F6D09D6182416A5594", hash_generated_method = "08BD0C027A727C54B6B9E93B55539BEC")
    public ViewPropertyAnimator xBy(float value) {
        addTaint(value);
        animatePropertyBy(X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_603986944 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_603986944.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_603986944;
        // ---------- Original Method ----------
        //animatePropertyBy(X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.627 -0400", hash_original_method = "6AC23ECE2D15FE0B2F16B84D01FE289F", hash_generated_method = "23CF890FF0A8437D72726BA93E862FF2")
    public ViewPropertyAnimator y(float value) {
        addTaint(value);
        animateProperty(Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_940259750 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_940259750.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_940259750;
        // ---------- Original Method ----------
        //animateProperty(Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.628 -0400", hash_original_method = "00E84702996DAE91A9CE0634285E6E21", hash_generated_method = "6FC77B4C63995AD3B37078EB07B629E3")
    public ViewPropertyAnimator yBy(float value) {
        addTaint(value);
        animatePropertyBy(Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_34277252 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_34277252.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_34277252;
        // ---------- Original Method ----------
        //animatePropertyBy(Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.628 -0400", hash_original_method = "F233DBDEC9778D70C84673F609341CB5", hash_generated_method = "FA51A9E9EB9E235E6CAEDBBF2A8EFBF1")
    public ViewPropertyAnimator rotation(float value) {
        addTaint(value);
        animateProperty(ROTATION, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1549929644 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1549929644.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1549929644;
        // ---------- Original Method ----------
        //animateProperty(ROTATION, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.628 -0400", hash_original_method = "64AA9FBA8001BF9E52DBF885273C96E3", hash_generated_method = "3C01DC2D2CEEDB1BC744095EB70138DB")
    public ViewPropertyAnimator rotationBy(float value) {
        addTaint(value);
        animatePropertyBy(ROTATION, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_291238297 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_291238297.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_291238297;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.628 -0400", hash_original_method = "6C5ABF33E117D9BB891BADA4C861CBC2", hash_generated_method = "2334768B7C6AB65ECF5EEBDCCB14A112")
    public ViewPropertyAnimator rotationX(float value) {
        addTaint(value);
        animateProperty(ROTATION_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_330998608 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_330998608.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_330998608;
        // ---------- Original Method ----------
        //animateProperty(ROTATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.629 -0400", hash_original_method = "107BE4D9D2AC7B45B56F8331D6FF6E98", hash_generated_method = "5815BE2319DF881B0A867623FC3D610E")
    public ViewPropertyAnimator rotationXBy(float value) {
        addTaint(value);
        animatePropertyBy(ROTATION_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_691952140 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_691952140.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_691952140;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.629 -0400", hash_original_method = "C4C456A89DC44934AFAAB7646D99F320", hash_generated_method = "AD1DCAF20E3DA4481A14A4342545D6FA")
    public ViewPropertyAnimator rotationY(float value) {
        addTaint(value);
        animateProperty(ROTATION_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_901393013 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_901393013.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_901393013;
        // ---------- Original Method ----------
        //animateProperty(ROTATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.629 -0400", hash_original_method = "50D1D865E8418E3E5575CE85EA5530DD", hash_generated_method = "3C890BE58AE98DB5DA1E8386A42BB539")
    public ViewPropertyAnimator rotationYBy(float value) {
        addTaint(value);
        animatePropertyBy(ROTATION_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_98186797 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_98186797.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_98186797;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.629 -0400", hash_original_method = "6A79DB871F5C4E97C4452F0A1C04756A", hash_generated_method = "D5BCC30BBBAC57DBCA8AB0E5B88FCC4E")
    public ViewPropertyAnimator translationX(float value) {
        addTaint(value);
        animateProperty(TRANSLATION_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1378767744 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1378767744.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1378767744;
        // ---------- Original Method ----------
        //animateProperty(TRANSLATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.630 -0400", hash_original_method = "92BE44E9F6280B7AE0D2A8904499350A", hash_generated_method = "3A4962B5E541EAA68B90D581AA45FE5F")
    public ViewPropertyAnimator translationXBy(float value) {
        addTaint(value);
        animatePropertyBy(TRANSLATION_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_882589979 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_882589979.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_882589979;
        // ---------- Original Method ----------
        //animatePropertyBy(TRANSLATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.630 -0400", hash_original_method = "B250150142DA03B7AD8AE045EB4F7730", hash_generated_method = "EDD5ED2C790B972785835C0FDF3FFBB7")
    public ViewPropertyAnimator translationY(float value) {
        addTaint(value);
        animateProperty(TRANSLATION_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_424953992 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_424953992.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_424953992;
        // ---------- Original Method ----------
        //animateProperty(TRANSLATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.630 -0400", hash_original_method = "5605726C555918AA2A627C8B848E7FA1", hash_generated_method = "84BBA37CAC72A356BD2476683F43D1F4")
    public ViewPropertyAnimator translationYBy(float value) {
        addTaint(value);
        animatePropertyBy(TRANSLATION_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_77648592 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_77648592.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_77648592;
        // ---------- Original Method ----------
        //animatePropertyBy(TRANSLATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.630 -0400", hash_original_method = "D5A33D637AF4590F069926DA61E58388", hash_generated_method = "D9D0A3B2A9AE38E5B6326740B47D567B")
    public ViewPropertyAnimator scaleX(float value) {
        addTaint(value);
        animateProperty(SCALE_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1158242404 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1158242404.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1158242404;
        // ---------- Original Method ----------
        //animateProperty(SCALE_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.631 -0400", hash_original_method = "631FDEF7985B082E37297CEE1F6072F7", hash_generated_method = "FEA9F798A84302397220DE2CAAA1B71A")
    public ViewPropertyAnimator scaleXBy(float value) {
        addTaint(value);
        animatePropertyBy(SCALE_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1523642537 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1523642537.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1523642537;
        // ---------- Original Method ----------
        //animatePropertyBy(SCALE_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.631 -0400", hash_original_method = "4F8C4B940AF7AE45F87D198B1B467EBE", hash_generated_method = "93F80CB4AD955407C7ECC80E7E3A74E7")
    public ViewPropertyAnimator scaleY(float value) {
        addTaint(value);
        animateProperty(SCALE_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_513294736 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_513294736.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_513294736;
        // ---------- Original Method ----------
        //animateProperty(SCALE_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.631 -0400", hash_original_method = "966CE83C4778D118E9F221736109C3B2", hash_generated_method = "AF8F5B19222B6C618B71E2853C01C6E2")
    public ViewPropertyAnimator scaleYBy(float value) {
        addTaint(value);
        animatePropertyBy(SCALE_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_880877931 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_880877931.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_880877931;
        // ---------- Original Method ----------
        //animatePropertyBy(SCALE_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.631 -0400", hash_original_method = "0CB6E06CAEEE818FC3721A3BD57FF4EB", hash_generated_method = "98771E421A186A439BFDB0DDEEAB1D62")
    public ViewPropertyAnimator alpha(float value) {
        addTaint(value);
        animateProperty(ALPHA, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1541752079 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1541752079.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1541752079;
        // ---------- Original Method ----------
        //animateProperty(ALPHA, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.632 -0400", hash_original_method = "ECBF15CE25304962FC64383EBA52129F", hash_generated_method = "0ED69D2EEFEBFB954D80104FE35B4550")
    public ViewPropertyAnimator alphaBy(float value) {
        addTaint(value);
        animatePropertyBy(ALPHA, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_208761936 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_208761936.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_208761936;
        // ---------- Original Method ----------
        //animatePropertyBy(ALPHA, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.632 -0400", hash_original_method = "10886573EB8B45FC976B918620A506A6", hash_generated_method = "D84E91E3898D4791773481D75296A024")
    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(1.0f);
        ArrayList<NameValuesHolder> nameValueList = (ArrayList<NameValuesHolder>) mPendingAnimations.clone();
        mPendingAnimations.clear();
        int propertyMask = 0;
        int propertyCount = nameValueList.size();
for(int i = 0;i < propertyCount;++i)
        {
            NameValuesHolder nameValuesHolder = nameValueList.get(i);
            propertyMask |= nameValuesHolder.mNameConstant;
        } //End block
        mAnimatorMap.put(animator, new PropertyBundle(propertyMask, nameValueList));
        animator.addUpdateListener(mAnimatorEventListener);
        animator.addListener(mAnimatorEventListener);
    if(mStartDelaySet)        
        {
            animator.setStartDelay(mStartDelay);
        } //End block
    if(mDurationSet)        
        {
            animator.setDuration(mDuration);
        } //End block
    if(mInterpolatorSet)        
        {
            animator.setInterpolator(mInterpolator);
        } //End block
        animator.start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.632 -0400", hash_original_method = "DC6A356EFD140318ADF1C94BF09D3544", hash_generated_method = "747AF21211DEF47919A0F14EB53253B7")
    private void animateProperty(int constantName, float toValue) {
        addTaint(toValue);
        addTaint(constantName);
        float fromValue = getValue(constantName);
        float deltaValue = toValue - fromValue;
        animatePropertyBy(constantName, fromValue, deltaValue);
        // ---------- Original Method ----------
        //float fromValue = getValue(constantName);
        //float deltaValue = toValue - fromValue;
        //animatePropertyBy(constantName, fromValue, deltaValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.633 -0400", hash_original_method = "B9FE8E2780DEC5F83DA892CAE9192499", hash_generated_method = "A5B8DBE795D13265E1A5F32F24943CBE")
    private void animatePropertyBy(int constantName, float byValue) {
        addTaint(byValue);
        addTaint(constantName);
        float fromValue = getValue(constantName);
        animatePropertyBy(constantName, fromValue, byValue);
        // ---------- Original Method ----------
        //float fromValue = getValue(constantName);
        //animatePropertyBy(constantName, fromValue, byValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.633 -0400", hash_original_method = "1BDECA037A3A41B230975E15C12C5086", hash_generated_method = "DF9B9C8AF5D48B4BF600D02CBB7DC588")
    private void animatePropertyBy(int constantName, float startValue, float byValue) {
        addTaint(byValue);
        addTaint(startValue);
        addTaint(constantName);
    if(mAnimatorMap.size() > 0)        
        {
            Animator animatorToCancel = null;
            Set<Animator> animatorSet = mAnimatorMap.keySet();
for(Animator runningAnim : animatorSet)
            {
                PropertyBundle bundle = mAnimatorMap.get(runningAnim);
    if(bundle.cancel(constantName))                
                {
    if(bundle.mPropertyMask == NONE)                    
                    {
                        animatorToCancel = runningAnim;
                        break;
                    } //End block
                } //End block
            } //End block
    if(animatorToCancel != null)            
            {
                animatorToCancel.cancel();
            } //End block
        } //End block
        NameValuesHolder nameValuePair = new NameValuesHolder(constantName, startValue, byValue);
        mPendingAnimations.add(nameValuePair);
        mView.removeCallbacks(mAnimationStarter);
        mView.post(mAnimationStarter);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.635 -0400", hash_original_method = "543199367D6B4536DD4796BA994C91F7", hash_generated_method = "691352C82D26CDF5047A47150F705E2D")
    private void setValue(int propertyConstant, float value) {
        addTaint(value);
        addTaint(propertyConstant);
        final View.TransformationInfo info = mView.mTransformationInfo;
switch(propertyConstant){
        case TRANSLATION_X:
        info.mTranslationX = value;
        break;
        case TRANSLATION_Y:
        info.mTranslationY = value;
        break;
        case ROTATION:
        info.mRotation = value;
        break;
        case ROTATION_X:
        info.mRotationX = value;
        break;
        case ROTATION_Y:
        info.mRotationY = value;
        break;
        case SCALE_X:
        info.mScaleX = value;
        break;
        case SCALE_Y:
        info.mScaleY = value;
        break;
        case X:
        info.mTranslationX = value - mView.mLeft;
        break;
        case Y:
        info.mTranslationY = value - mView.mTop;
        break;
        case ALPHA:
        info.mAlpha = value;
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.636 -0400", hash_original_method = "7CFF5C0EAB5A873E8FB7B3F0396E6B5F", hash_generated_method = "4D1EE82F437469F20FF6F4C75A95CB72")
    private float getValue(int propertyConstant) {
        addTaint(propertyConstant);
        final View.TransformationInfo info = mView.mTransformationInfo;
switch(propertyConstant){
        case TRANSLATION_X:
        float var5154BD5FD1E363E437CD2D1EDA75CCC5_986955155 = (info.mTranslationX);
                float var546ADE640B6EDFBC8A086EF31347E768_191118998 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_191118998;
        case TRANSLATION_Y:
        float var0446E9497E6C0D936013640AADF48EFD_473715259 = (info.mTranslationY);
                float var546ADE640B6EDFBC8A086EF31347E768_1893692141 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1893692141;
        case ROTATION:
        float varB359A89402B2A3EEE24FA75F562D5AD1_1689483581 = (info.mRotation);
                float var546ADE640B6EDFBC8A086EF31347E768_597146187 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_597146187;
        case ROTATION_X:
        float var603AED3CADF0BF4C401E10DEAEC1AEAA_187826956 = (info.mRotationX);
                float var546ADE640B6EDFBC8A086EF31347E768_1630018928 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1630018928;
        case ROTATION_Y:
        float var27B648AAD89CAB2B767C3C37DD0D719C_1194016618 = (info.mRotationY);
                float var546ADE640B6EDFBC8A086EF31347E768_726399747 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_726399747;
        case SCALE_X:
        float var639F208C1CF89B157615AF9BDC3A5C62_875635363 = (info.mScaleX);
                float var546ADE640B6EDFBC8A086EF31347E768_783584851 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_783584851;
        case SCALE_Y:
        float varAFA163F38ACD3DBEA0CD7C290089546F_1337997832 = (info.mScaleY);
                float var546ADE640B6EDFBC8A086EF31347E768_1355203955 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1355203955;
        case X:
        float var5E840649BCB284040BE877913CDE445B_1741999181 = (mView.mLeft + info.mTranslationX);
                float var546ADE640B6EDFBC8A086EF31347E768_2080741670 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2080741670;
        case Y:
        float varB7335E346CC48D404C6613A51DC94754_1331739045 = (mView.mTop + info.mTranslationY);
                float var546ADE640B6EDFBC8A086EF31347E768_486615638 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_486615638;
        case ALPHA:
        float var09315B5BB71724FF4B9B2E1E59808C8A_167119428 = (info.mAlpha);
                float var546ADE640B6EDFBC8A086EF31347E768_1390900949 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1390900949;
}        float varCFCD208495D565EF66E7DFF9F98764DA_285314195 = (0);
                float var546ADE640B6EDFBC8A086EF31347E768_1267318563 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1267318563;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class PropertyBundle {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.636 -0400", hash_original_field = "EA82D747FDF82EEF7E2D5AF15C87B00D", hash_generated_field = "DD49B26A61D9970E0B1D820803D8F62F")

        int mPropertyMask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.636 -0400", hash_original_field = "62545405009A575225238A37B954143A", hash_generated_field = "F20E3CD953F396C43CDD27D3775574C7")

        ArrayList<NameValuesHolder> mNameValuesHolder;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.637 -0400", hash_original_method = "6483519B8187FEE4E1EA6883A6980FC2", hash_generated_method = "0CE8E5F353B93E51DDD0F1A900D1B63F")
          PropertyBundle(int propertyMask, ArrayList<NameValuesHolder> nameValuesHolder) {
            mPropertyMask = propertyMask;
            mNameValuesHolder = nameValuesHolder;
            // ---------- Original Method ----------
            //mPropertyMask = propertyMask;
            //mNameValuesHolder = nameValuesHolder;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.637 -0400", hash_original_method = "4E1EA61EF3802406B1375FE91CF7D26A", hash_generated_method = "30F886A09BC9545E7C58F48FD51380AD")
         boolean cancel(int propertyConstant) {
    if((mPropertyMask & propertyConstant) != 0 && mNameValuesHolder != null)            
            {
                int count = mNameValuesHolder.size();
for(int i = 0;i < count;++i)
                {
                    NameValuesHolder nameValuesHolder = mNameValuesHolder.get(i);
    if(nameValuesHolder.mNameConstant == propertyConstant)                    
                    {
                        mNameValuesHolder.remove(i);
                        mPropertyMask &= ~propertyConstant;
                        boolean varB326B5062B2F0E69046810717534CB09_1093415438 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975278263 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975278263;
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_336096389 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387631143 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_387631143;
            // ---------- Original Method ----------
            //if ((mPropertyMask & propertyConstant) != 0 && mNameValuesHolder != null) {
                //int count = mNameValuesHolder.size();
                //for (int i = 0; i < count; ++i) {
                    //NameValuesHolder nameValuesHolder = mNameValuesHolder.get(i);
                    //if (nameValuesHolder.mNameConstant == propertyConstant) {
                        //mNameValuesHolder.remove(i);
                        //mPropertyMask &= ~propertyConstant;
                        //return true;
                    //}
                //}
            //}
            //return false;
        }

        
    }


    
    private static class NameValuesHolder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.638 -0400", hash_original_field = "062773B58F942AD47DB973EC0F474614", hash_generated_field = "1D2069986089C122C058DF69AE8585A8")

        int mNameConstant;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.638 -0400", hash_original_field = "58166AED0E3EA530251BD54D5936049B", hash_generated_field = "E0FB3AD0E73F80DF22AE6663ABA13808")

        float mFromValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.638 -0400", hash_original_field = "32CA45314BBE60A9C754152D801F36B7", hash_generated_field = "6689A5DB2A8581AB15B0CD1E639E3108")

        float mDeltaValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.638 -0400", hash_original_method = "96CB986053199F9A9E461CA697D4B879", hash_generated_method = "FDEACC85A045B9ABDF7AE5453B59801C")
          NameValuesHolder(int nameConstant, float fromValue, float deltaValue) {
            mNameConstant = nameConstant;
            mFromValue = fromValue;
            mDeltaValue = deltaValue;
            // ---------- Original Method ----------
            //mNameConstant = nameConstant;
            //mFromValue = fromValue;
            //mDeltaValue = deltaValue;
        }

        
    }


    
    private class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.638 -0400", hash_original_method = "583F783AF22881FEE7C79B0EC23630FE", hash_generated_method = "583F783AF22881FEE7C79B0EC23630FE")
        public AnimatorEventListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.639 -0400", hash_original_method = "F9860C292F584577E1CB80EC7999B7B9", hash_generated_method = "B43379B21AD61A37C99B1B5256FCA553")
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(mListener != null)            
            {
                mListener.onAnimationStart(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationStart(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.639 -0400", hash_original_method = "F7FF3E25F5EB45E2838B85C55C1E6F41", hash_generated_method = "BBD6DA3EF6F22D20003390C199319635")
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(mListener != null)            
            {
                mListener.onAnimationCancel(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationCancel(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.639 -0400", hash_original_method = "B115085E9A5CEF09E5F889C8A8B6D805", hash_generated_method = "B2B2B47B2236FAD23981728E5EFAACF7")
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(mListener != null)            
            {
                mListener.onAnimationRepeat(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationRepeat(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.639 -0400", hash_original_method = "A70C7A230A722F778ADFA14D1A0F2C8C", hash_generated_method = "D16D3C80558837551264F53DB56BF515")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(mListener != null)            
            {
                mListener.onAnimationEnd(animation);
            } //End block
            mAnimatorMap.remove(animation);
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationEnd(animation);
            //}
            //mAnimatorMap.remove(animation);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.640 -0400", hash_original_method = "DF41E3115CE6BC840253482EC4390D2C", hash_generated_method = "8D5F6BC207128194608D29371BEE4934")
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            boolean alphaHandled = false;
            mView.invalidateParentCaches();
            float fraction = animation.getAnimatedFraction();
            PropertyBundle propertyBundle = mAnimatorMap.get(animation);
            int propertyMask = propertyBundle.mPropertyMask;
    if((propertyMask & TRANSFORM_MASK) != 0)            
            {
                mView.invalidate(false);
            } //End block
            ArrayList<NameValuesHolder> valueList = propertyBundle.mNameValuesHolder;
    if(valueList != null)            
            {
                int count = valueList.size();
for(int i = 0;i < count;++i)
                {
                    NameValuesHolder values = valueList.get(i);
                    float value = values.mFromValue + fraction * values.mDeltaValue;
    if(values.mNameConstant == ALPHA)                    
                    {
                        alphaHandled = mView.setAlphaNoInvalidation(value);
                    } //End block
                    else
                    {
                        setValue(values.mNameConstant, value);
                    } //End block
                } //End block
            } //End block
    if((propertyMask & TRANSFORM_MASK) != 0)            
            {
                mView.mTransformationInfo.mMatrixDirty = true;
                mView.mPrivateFlags |= View.DRAWN;
            } //End block
            mView.invalidate(alphaHandled);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "6E3EBA86A35D2BDF0C219EC56301B9FD", hash_generated_field = "53FCA486F4B3E72DD422D1A05E64E7D7")

    private static final int NONE = 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "7EF24AB0415E857330A0B400367FB35C", hash_generated_field = "1EA0ED90123067FBA25A12B73C3B24A4")

    private static final int TRANSLATION_X = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "1693EAC704341CCB25545B840106B0CF", hash_generated_field = "74C6ACDB0AB6198B341013D44626807D")

    private static final int TRANSLATION_Y = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "FC034E19AA4FD3583834AC3AE12C69BE", hash_generated_field = "E676EA8846B5357A39E8D3182B5EE15E")

    private static final int SCALE_X = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "396F4A8B38BEB256E7696C27913A8337", hash_generated_field = "08F4E43074CCDA53ECDCF5DD24262BBA")

    private static final int SCALE_Y = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "EA906C9DB1083889CC51D2B071788A60", hash_generated_field = "A0750AAA69331EB7E9646558AD0A02F9")

    private static final int ROTATION = 0x0010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "E91E7704034A7800A0FACA1679BF154C", hash_generated_field = "159F22271A102CB6FE5DEF638B8BC6A5")

    private static final int ROTATION_X = 0x0020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "D5ABA69BD26D7D526F8ACF4FE902FA77", hash_generated_field = "97534AB067F7E259F67702CF1E739334")

    private static final int ROTATION_Y = 0x0040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "E034313BC3E778F9D17592C78EE7806A", hash_generated_field = "581B8B6FF307BDC6C94C6FBF3BC24EAE")

    private static final int X = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "313A540AD3FEDC5648CEC2A19CB8CB9F", hash_generated_field = "55573BD988F03CE9C928861DECD58BE3")

    private static final int Y = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "5A78DFE318375AD927D4480D8645725D", hash_generated_field = "04050B0DAE51D1C9573296CE00EE96EE")

    private static final int ALPHA = 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.641 -0400", hash_original_field = "D0A601CA267A5480FF50581D2A8EE745", hash_generated_field = "6B12798A8293494A9A5448AEA6533D12")

    private static final int TRANSFORM_MASK = TRANSLATION_X | TRANSLATION_Y | SCALE_X | SCALE_Y |
            ROTATION | ROTATION_X | ROTATION_Y | X | Y;
}

