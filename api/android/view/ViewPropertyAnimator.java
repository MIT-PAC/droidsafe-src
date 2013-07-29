package android.view;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ViewPropertyAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "8BF5222528387AE04CED3C727F9F8865")

    private long mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "2173D0EAB9C999840AC85B43401734BC", hash_generated_field = "03D5FC9AEBB7D8B90777FF73C31E1A48")

    private boolean mDurationSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "DF48E3731958141B55A4C7E73DDFC592", hash_generated_field = "4F4328485D02696A823721721A3E8657")

    private boolean mStartDelaySet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "EACBADF91032ABF3D011EE1B3057F84D")

    private TimeInterpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "4E6DBADDA65ADE077AE86FF3C107D674", hash_generated_field = "82B2216AD41FE3E781D6035774E250B3")

    private boolean mInterpolatorSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "6F7F10CDECDD60587A676132819FC95C", hash_generated_field = "69256070A6B51CD84194DBDA7B561216")

    private Animator.AnimatorListener mListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "08EB2BB862E5FE0721A17E700067CCEB", hash_generated_field = "2F88CB8CE002DBE4EE3C525DE38A44D1")

    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "DCD9F986A2DB3ACDD6D71B582052B6E9", hash_generated_field = "245199B04CE5933EE61BB14613CB2F2D")

    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<NameValuesHolder>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "E77137B6BB2AC6EED35F93F563E9A9A8", hash_generated_field = "DDAE17988E2F7FE309FFBA8222A2CC64")

    private Runnable mAnimationStarter = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_method = "FBB53873B37744AA497F2F82BA93513F", hash_generated_method = "B49121F60C78DA005BF63A708AB544D3")
        @Override
        public void run() {
            startAnimation();
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.896 -0400", hash_original_field = "2BB891F43500DBB293AEBA7F524B468D", hash_generated_field = "8AE0B8099C4E7901C63106A6D931EB1C")

    private HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap<Animator, PropertyBundle>();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.897 -0400", hash_original_method = "684AC817B57804E91C0EF57CA21B86F4", hash_generated_method = "81503CFEBD19EABDC587B9564B95B657")
      ViewPropertyAnimator(View view) {
        mView = view;
        view.ensureTransformationInfo();
        // ---------- Original Method ----------
        //mView = view;
        //view.ensureTransformationInfo();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.897 -0400", hash_original_method = "AB53F93DCFA553673F10278B2219DEEA", hash_generated_method = "B4366D810486F1B2F2EBD2D20CC14738")
    public ViewPropertyAnimator setDuration(long duration) {
        if(duration < 0)        
        {
            IllegalArgumentException varBE9004E8E8C014F966F457353E164ECE_1911036212 = new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
            varBE9004E8E8C014F966F457353E164ECE_1911036212.addTaint(taint);
            throw varBE9004E8E8C014F966F457353E164ECE_1911036212;
        } //End block
        mDurationSet = true;
        mDuration = duration;
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_2019534639 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2019534639.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2019534639;
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDurationSet = true;
        //mDuration = duration;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.898 -0400", hash_original_method = "BFD4BDEC4492EF4D0AE1BFA285B3702C", hash_generated_method = "C02BB8B1ADFDAD6D4C72222ED422F2E5")
    public long getDuration() {
        if(mDurationSet)        
        {
            long var25395741BFE51A7D136A5C7109AAD2D8_1498232942 = (mDuration);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1882182070 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1882182070;
        } //End block
        else
        {
            long varE9BF4C9C84488436E1D1F2E5F9AADB49_563328233 = (new ValueAnimator().getDuration());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_74998481 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_74998481;
        } //End block
        // ---------- Original Method ----------
        //if (mDurationSet) {
            //return mDuration;
        //} else {
            //return new ValueAnimator().getDuration();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.899 -0400", hash_original_method = "137A1F44FEDEF7DBAEA1EE8251F82E1F", hash_generated_method = "5D72DDD5DA304B16D6696F656FF3B789")
    public long getStartDelay() {
        if(mStartDelaySet)        
        {
            long varD6348B0CF9AA194EA8CCE71E8A2B9F80_158496442 = (mStartDelay);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1152658359 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1152658359;
        } //End block
        else
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_463205527 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_329996807 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_329996807;
        } //End block
        // ---------- Original Method ----------
        //if (mStartDelaySet) {
            //return mStartDelay;
        //} else {
            //return 0;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.899 -0400", hash_original_method = "55E567100D84151F5304C84C830F2C1B", hash_generated_method = "9D2FB3A6CA2F7AA3C2B4088D616CA016")
    public ViewPropertyAnimator setStartDelay(long startDelay) {
        if(startDelay < 0)        
        {
            IllegalArgumentException varFCA553B88D1C3C33CE9EEFDD31E7822C_1670917343 = new IllegalArgumentException("Animators cannot have negative duration: " +
                    startDelay);
            varFCA553B88D1C3C33CE9EEFDD31E7822C_1670917343.addTaint(taint);
            throw varFCA553B88D1C3C33CE9EEFDD31E7822C_1670917343;
        } //End block
        mStartDelaySet = true;
        mStartDelay = startDelay;
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_649818028 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_649818028.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_649818028;
        // ---------- Original Method ----------
        //if (startDelay < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //startDelay);
        //}
        //mStartDelaySet = true;
        //mStartDelay = startDelay;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.900 -0400", hash_original_method = "995017692E981832E150BE79F0CB8507", hash_generated_method = "291EDB0B433BA17A089D8C619D92D4C4")
    public ViewPropertyAnimator setInterpolator(TimeInterpolator interpolator) {
        mInterpolatorSet = true;
        mInterpolator = interpolator;
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_691536802 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_691536802.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_691536802;
        // ---------- Original Method ----------
        //mInterpolatorSet = true;
        //mInterpolator = interpolator;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.900 -0400", hash_original_method = "D3B983C6B8AF317CF4B7893570C39145", hash_generated_method = "FCCFAA164C55325442FC1A447F0FCC26")
    public ViewPropertyAnimator setListener(Animator.AnimatorListener listener) {
        mListener = listener;
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1507552994 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1507552994.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1507552994;
        // ---------- Original Method ----------
        //mListener = listener;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.901 -0400", hash_original_method = "8C3C0DB6E3E572D598F887EBD1169042", hash_generated_method = "A5710AE0D85F06F649F4EF64FCC54E4A")
    public void start() {
        startAnimation();
        // ---------- Original Method ----------
        //startAnimation();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.901 -0400", hash_original_method = "504B77AB05B1FC68628CE89848555449", hash_generated_method = "19BC79E1E8A09A787338888B8F75DA6A")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.902 -0400", hash_original_method = "8D670697E365032294CEEA6593A27CE4", hash_generated_method = "791077AD107F57CE89958B7383BCECCF")
    public ViewPropertyAnimator x(float value) {
        addTaint(value);
        animateProperty(X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_466082604 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_466082604.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_466082604;
        // ---------- Original Method ----------
        //animateProperty(X, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.902 -0400", hash_original_method = "2E3B808D4A6B84F6D09D6182416A5594", hash_generated_method = "8716DA742F7960E1E82633BBB7AEAE36")
    public ViewPropertyAnimator xBy(float value) {
        addTaint(value);
        animatePropertyBy(X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_458794581 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_458794581.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_458794581;
        // ---------- Original Method ----------
        //animatePropertyBy(X, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.902 -0400", hash_original_method = "6AC23ECE2D15FE0B2F16B84D01FE289F", hash_generated_method = "23E0902A3EC48C376B5FB2551D522FA0")
    public ViewPropertyAnimator y(float value) {
        addTaint(value);
        animateProperty(Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_2141592309 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2141592309.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2141592309;
        // ---------- Original Method ----------
        //animateProperty(Y, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.902 -0400", hash_original_method = "00E84702996DAE91A9CE0634285E6E21", hash_generated_method = "81A1A512AA0AAEDA9B6925CC9015B12B")
    public ViewPropertyAnimator yBy(float value) {
        addTaint(value);
        animatePropertyBy(Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1807345996 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1807345996.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1807345996;
        // ---------- Original Method ----------
        //animatePropertyBy(Y, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.903 -0400", hash_original_method = "F233DBDEC9778D70C84673F609341CB5", hash_generated_method = "FFF27C89E1B92A8836BC50DE3D193287")
    public ViewPropertyAnimator rotation(float value) {
        addTaint(value);
        animateProperty(ROTATION, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_165722902 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_165722902.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_165722902;
        // ---------- Original Method ----------
        //animateProperty(ROTATION, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.903 -0400", hash_original_method = "64AA9FBA8001BF9E52DBF885273C96E3", hash_generated_method = "5FDF3658CDFE85312CF03FF86BEF742F")
    public ViewPropertyAnimator rotationBy(float value) {
        addTaint(value);
        animatePropertyBy(ROTATION, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_600822780 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_600822780.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_600822780;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.903 -0400", hash_original_method = "6C5ABF33E117D9BB891BADA4C861CBC2", hash_generated_method = "D38DC53B7BFC5D9673D3AF71BCB0FFB7")
    public ViewPropertyAnimator rotationX(float value) {
        addTaint(value);
        animateProperty(ROTATION_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1406654573 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1406654573.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1406654573;
        // ---------- Original Method ----------
        //animateProperty(ROTATION_X, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.903 -0400", hash_original_method = "107BE4D9D2AC7B45B56F8331D6FF6E98", hash_generated_method = "08C9FEAC7D7A2C1642DFAF2BBA46AE98")
    public ViewPropertyAnimator rotationXBy(float value) {
        addTaint(value);
        animatePropertyBy(ROTATION_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_275667207 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_275667207.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_275667207;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION_X, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.903 -0400", hash_original_method = "C4C456A89DC44934AFAAB7646D99F320", hash_generated_method = "DA411E4EFEBC6FD9E4EDD80BA39286D5")
    public ViewPropertyAnimator rotationY(float value) {
        addTaint(value);
        animateProperty(ROTATION_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1509488906 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1509488906.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1509488906;
        // ---------- Original Method ----------
        //animateProperty(ROTATION_Y, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "50D1D865E8418E3E5575CE85EA5530DD", hash_generated_method = "0C0CB1AA7967290F75D54CCD67E5228C")
    public ViewPropertyAnimator rotationYBy(float value) {
        addTaint(value);
        animatePropertyBy(ROTATION_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_390293823 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_390293823.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_390293823;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION_Y, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "6A79DB871F5C4E97C4452F0A1C04756A", hash_generated_method = "EE1C5705E016FE93C93E8EB8AD03003A")
    public ViewPropertyAnimator translationX(float value) {
        addTaint(value);
        animateProperty(TRANSLATION_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1048848649 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1048848649.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1048848649;
        // ---------- Original Method ----------
        //animateProperty(TRANSLATION_X, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "92BE44E9F6280B7AE0D2A8904499350A", hash_generated_method = "E04144DBE3C718576E7BAB56DF1C9371")
    public ViewPropertyAnimator translationXBy(float value) {
        addTaint(value);
        animatePropertyBy(TRANSLATION_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_727292684 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_727292684.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_727292684;
        // ---------- Original Method ----------
        //animatePropertyBy(TRANSLATION_X, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "B250150142DA03B7AD8AE045EB4F7730", hash_generated_method = "F9561D75EED2DE6BFE407D6D08CF83AC")
    public ViewPropertyAnimator translationY(float value) {
        addTaint(value);
        animateProperty(TRANSLATION_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1989858845 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1989858845.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1989858845;
        // ---------- Original Method ----------
        //animateProperty(TRANSLATION_Y, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "5605726C555918AA2A627C8B848E7FA1", hash_generated_method = "EDB67665DC318BC556F0109B61A89C2D")
    public ViewPropertyAnimator translationYBy(float value) {
        addTaint(value);
        animatePropertyBy(TRANSLATION_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_156378007 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_156378007.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_156378007;
        // ---------- Original Method ----------
        //animatePropertyBy(TRANSLATION_Y, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "D5A33D637AF4590F069926DA61E58388", hash_generated_method = "52C99CD97B4B6109DF9D9AF57D8BBE1C")
    public ViewPropertyAnimator scaleX(float value) {
        addTaint(value);
        animateProperty(SCALE_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1375584852 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1375584852.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1375584852;
        // ---------- Original Method ----------
        //animateProperty(SCALE_X, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "631FDEF7985B082E37297CEE1F6072F7", hash_generated_method = "DDDECDC9673DFDA296314EBFB6B8BC93")
    public ViewPropertyAnimator scaleXBy(float value) {
        addTaint(value);
        animatePropertyBy(SCALE_X, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1629745685 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1629745685.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1629745685;
        // ---------- Original Method ----------
        //animatePropertyBy(SCALE_X, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "4F8C4B940AF7AE45F87D198B1B467EBE", hash_generated_method = "6B039A5F732C00FC27BBA2B2E6FC1425")
    public ViewPropertyAnimator scaleY(float value) {
        addTaint(value);
        animateProperty(SCALE_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1858546414 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1858546414.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1858546414;
        // ---------- Original Method ----------
        //animateProperty(SCALE_Y, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.904 -0400", hash_original_method = "966CE83C4778D118E9F221736109C3B2", hash_generated_method = "F0580BEF7D8613916BD59F86164F4746")
    public ViewPropertyAnimator scaleYBy(float value) {
        addTaint(value);
        animatePropertyBy(SCALE_Y, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1419283218 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1419283218.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1419283218;
        // ---------- Original Method ----------
        //animatePropertyBy(SCALE_Y, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.905 -0400", hash_original_method = "0CB6E06CAEEE818FC3721A3BD57FF4EB", hash_generated_method = "CE52611559E93C0D577CCCB159C7BE34")
    public ViewPropertyAnimator alpha(float value) {
        addTaint(value);
        animateProperty(ALPHA, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_1108727745 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1108727745.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1108727745;
        // ---------- Original Method ----------
        //animateProperty(ALPHA, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.905 -0400", hash_original_method = "ECBF15CE25304962FC64383EBA52129F", hash_generated_method = "8964940F9DC4EE9E5CE4F18BE780ADB5")
    public ViewPropertyAnimator alphaBy(float value) {
        addTaint(value);
        animatePropertyBy(ALPHA, value);
ViewPropertyAnimator var72A74007B2BE62B849F475C7BDA4658B_812601378 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_812601378.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_812601378;
        // ---------- Original Method ----------
        //animatePropertyBy(ALPHA, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.905 -0400", hash_original_method = "10886573EB8B45FC976B918620A506A6", hash_generated_method = "D84E91E3898D4791773481D75296A024")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.906 -0400", hash_original_method = "DC6A356EFD140318ADF1C94BF09D3544", hash_generated_method = "747AF21211DEF47919A0F14EB53253B7")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.906 -0400", hash_original_method = "B9FE8E2780DEC5F83DA892CAE9192499", hash_generated_method = "A5B8DBE795D13265E1A5F32F24943CBE")
    private void animatePropertyBy(int constantName, float byValue) {
        addTaint(byValue);
        addTaint(constantName);
        float fromValue = getValue(constantName);
        animatePropertyBy(constantName, fromValue, byValue);
        // ---------- Original Method ----------
        //float fromValue = getValue(constantName);
        //animatePropertyBy(constantName, fromValue, byValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.907 -0400", hash_original_method = "1BDECA037A3A41B230975E15C12C5086", hash_generated_method = "DF9B9C8AF5D48B4BF600D02CBB7DC588")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.908 -0400", hash_original_method = "543199367D6B4536DD4796BA994C91F7", hash_generated_method = "691352C82D26CDF5047A47150F705E2D")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.908 -0400", hash_original_method = "7CFF5C0EAB5A873E8FB7B3F0396E6B5F", hash_generated_method = "5B29A59E2967C5249A52407EFFB3FEF5")
    private float getValue(int propertyConstant) {
        addTaint(propertyConstant);
        final View.TransformationInfo info = mView.mTransformationInfo;
switch(propertyConstant){
        case TRANSLATION_X:
        float var5154BD5FD1E363E437CD2D1EDA75CCC5_1811142746 = (info.mTranslationX);
                float var546ADE640B6EDFBC8A086EF31347E768_338943623 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_338943623;
        case TRANSLATION_Y:
        float var0446E9497E6C0D936013640AADF48EFD_2140893944 = (info.mTranslationY);
                float var546ADE640B6EDFBC8A086EF31347E768_953446718 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_953446718;
        case ROTATION:
        float varB359A89402B2A3EEE24FA75F562D5AD1_729192536 = (info.mRotation);
                float var546ADE640B6EDFBC8A086EF31347E768_341262027 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_341262027;
        case ROTATION_X:
        float var603AED3CADF0BF4C401E10DEAEC1AEAA_597963097 = (info.mRotationX);
                float var546ADE640B6EDFBC8A086EF31347E768_1909114013 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1909114013;
        case ROTATION_Y:
        float var27B648AAD89CAB2B767C3C37DD0D719C_77055291 = (info.mRotationY);
                float var546ADE640B6EDFBC8A086EF31347E768_605508996 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_605508996;
        case SCALE_X:
        float var639F208C1CF89B157615AF9BDC3A5C62_1254539810 = (info.mScaleX);
                float var546ADE640B6EDFBC8A086EF31347E768_314761364 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_314761364;
        case SCALE_Y:
        float varAFA163F38ACD3DBEA0CD7C290089546F_1140989344 = (info.mScaleY);
                float var546ADE640B6EDFBC8A086EF31347E768_943425260 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_943425260;
        case X:
        float var5E840649BCB284040BE877913CDE445B_1390496261 = (mView.mLeft + info.mTranslationX);
                float var546ADE640B6EDFBC8A086EF31347E768_1585795558 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1585795558;
        case Y:
        float varB7335E346CC48D404C6613A51DC94754_45121112 = (mView.mTop + info.mTranslationY);
                float var546ADE640B6EDFBC8A086EF31347E768_1896937644 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1896937644;
        case ALPHA:
        float var09315B5BB71724FF4B9B2E1E59808C8A_9411987 = (info.mAlpha);
                float var546ADE640B6EDFBC8A086EF31347E768_602278885 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_602278885;
}        float varCFCD208495D565EF66E7DFF9F98764DA_2078953566 = (0);
                float var546ADE640B6EDFBC8A086EF31347E768_1898153327 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1898153327;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class PropertyBundle {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.909 -0400", hash_original_field = "EA82D747FDF82EEF7E2D5AF15C87B00D", hash_generated_field = "DD49B26A61D9970E0B1D820803D8F62F")

        int mPropertyMask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.909 -0400", hash_original_field = "62545405009A575225238A37B954143A", hash_generated_field = "F20E3CD953F396C43CDD27D3775574C7")

        ArrayList<NameValuesHolder> mNameValuesHolder;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.909 -0400", hash_original_method = "6483519B8187FEE4E1EA6883A6980FC2", hash_generated_method = "0CE8E5F353B93E51DDD0F1A900D1B63F")
          PropertyBundle(int propertyMask, ArrayList<NameValuesHolder> nameValuesHolder) {
            mPropertyMask = propertyMask;
            mNameValuesHolder = nameValuesHolder;
            // ---------- Original Method ----------
            //mPropertyMask = propertyMask;
            //mNameValuesHolder = nameValuesHolder;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.909 -0400", hash_original_method = "4E1EA61EF3802406B1375FE91CF7D26A", hash_generated_method = "BA7FEBAB964F1A105F577B223B059C6E")
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
                        boolean varB326B5062B2F0E69046810717534CB09_1142749035 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968661780 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_968661780;
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_949300443 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304093487 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_304093487;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.909 -0400", hash_original_field = "062773B58F942AD47DB973EC0F474614", hash_generated_field = "1D2069986089C122C058DF69AE8585A8")

        int mNameConstant;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.909 -0400", hash_original_field = "58166AED0E3EA530251BD54D5936049B", hash_generated_field = "E0FB3AD0E73F80DF22AE6663ABA13808")

        float mFromValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.909 -0400", hash_original_field = "32CA45314BBE60A9C754152D801F36B7", hash_generated_field = "6689A5DB2A8581AB15B0CD1E639E3108")

        float mDeltaValue;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.910 -0400", hash_original_method = "96CB986053199F9A9E461CA697D4B879", hash_generated_method = "FDEACC85A045B9ABDF7AE5453B59801C")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.910 -0400", hash_original_method = "583F783AF22881FEE7C79B0EC23630FE", hash_generated_method = "583F783AF22881FEE7C79B0EC23630FE")
        public AnimatorEventListener ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.910 -0400", hash_original_method = "F9860C292F584577E1CB80EC7999B7B9", hash_generated_method = "B43379B21AD61A37C99B1B5256FCA553")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.910 -0400", hash_original_method = "F7FF3E25F5EB45E2838B85C55C1E6F41", hash_generated_method = "BBD6DA3EF6F22D20003390C199319635")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.910 -0400", hash_original_method = "B115085E9A5CEF09E5F889C8A8B6D805", hash_generated_method = "B2B2B47B2236FAD23981728E5EFAACF7")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.910 -0400", hash_original_method = "A70C7A230A722F778ADFA14D1A0F2C8C", hash_generated_method = "D16D3C80558837551264F53DB56BF515")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_method = "DF41E3115CE6BC840253482EC4390D2C", hash_generated_method = "8D5F6BC207128194608D29371BEE4934")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "6E3EBA86A35D2BDF0C219EC56301B9FD", hash_generated_field = "53FCA486F4B3E72DD422D1A05E64E7D7")

    private static final int NONE = 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "7EF24AB0415E857330A0B400367FB35C", hash_generated_field = "1EA0ED90123067FBA25A12B73C3B24A4")

    private static final int TRANSLATION_X = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "1693EAC704341CCB25545B840106B0CF", hash_generated_field = "74C6ACDB0AB6198B341013D44626807D")

    private static final int TRANSLATION_Y = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "FC034E19AA4FD3583834AC3AE12C69BE", hash_generated_field = "E676EA8846B5357A39E8D3182B5EE15E")

    private static final int SCALE_X = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "396F4A8B38BEB256E7696C27913A8337", hash_generated_field = "08F4E43074CCDA53ECDCF5DD24262BBA")

    private static final int SCALE_Y = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "EA906C9DB1083889CC51D2B071788A60", hash_generated_field = "A0750AAA69331EB7E9646558AD0A02F9")

    private static final int ROTATION = 0x0010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "E91E7704034A7800A0FACA1679BF154C", hash_generated_field = "159F22271A102CB6FE5DEF638B8BC6A5")

    private static final int ROTATION_X = 0x0020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "D5ABA69BD26D7D526F8ACF4FE902FA77", hash_generated_field = "97534AB067F7E259F67702CF1E739334")

    private static final int ROTATION_Y = 0x0040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "E034313BC3E778F9D17592C78EE7806A", hash_generated_field = "581B8B6FF307BDC6C94C6FBF3BC24EAE")

    private static final int X = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "313A540AD3FEDC5648CEC2A19CB8CB9F", hash_generated_field = "55573BD988F03CE9C928861DECD58BE3")

    private static final int Y = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "5A78DFE318375AD927D4480D8645725D", hash_generated_field = "04050B0DAE51D1C9573296CE00EE96EE")

    private static final int ALPHA = 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.911 -0400", hash_original_field = "D0A601CA267A5480FF50581D2A8EE745", hash_generated_field = "6B12798A8293494A9A5448AEA6533D12")

    private static final int TRANSFORM_MASK = TRANSLATION_X | TRANSLATION_Y | SCALE_X | SCALE_Y |
            ROTATION | ROTATION_X | ROTATION_Y | X | Y;
}

