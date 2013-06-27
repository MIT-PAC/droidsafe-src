package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.TimeInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ViewPropertyAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.469 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "8BF5222528387AE04CED3C727F9F8865")

    private long mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "2173D0EAB9C999840AC85B43401734BC", hash_generated_field = "03D5FC9AEBB7D8B90777FF73C31E1A48")

    private boolean mDurationSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "DF48E3731958141B55A4C7E73DDFC592", hash_generated_field = "4F4328485D02696A823721721A3E8657")

    private boolean mStartDelaySet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "EACBADF91032ABF3D011EE1B3057F84D")

    private TimeInterpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "4E6DBADDA65ADE077AE86FF3C107D674", hash_generated_field = "82B2216AD41FE3E781D6035774E250B3")

    private boolean mInterpolatorSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "6F7F10CDECDD60587A676132819FC95C", hash_generated_field = "69256070A6B51CD84194DBDA7B561216")

    private Animator.AnimatorListener mListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "08EB2BB862E5FE0721A17E700067CCEB", hash_generated_field = "2F88CB8CE002DBE4EE3C525DE38A44D1")

    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.486 -0400", hash_original_field = "DCD9F986A2DB3ACDD6D71B582052B6E9", hash_generated_field = "245199B04CE5933EE61BB14613CB2F2D")

    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<NameValuesHolder>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.488 -0400", hash_original_field = "E77137B6BB2AC6EED35F93F563E9A9A8", hash_generated_field = "2402B8D07D0FF2BFB1DD6CD21A7F563D")

    private Runnable mAnimationStarter = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.488 -0400", hash_original_method = "FBB53873B37744AA497F2F82BA93513F", hash_generated_method = "B49121F60C78DA005BF63A708AB544D3")
        @Override
        public void run() {
            startAnimation();
            // ---------- Original Method ----------
            //startAnimation();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.488 -0400", hash_original_field = "2BB891F43500DBB293AEBA7F524B468D", hash_generated_field = "8AE0B8099C4E7901C63106A6D931EB1C")

    private HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap<Animator, PropertyBundle>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.489 -0400", hash_original_method = "684AC817B57804E91C0EF57CA21B86F4", hash_generated_method = "81503CFEBD19EABDC587B9564B95B657")
      ViewPropertyAnimator(View view) {
        mView = view;
        view.ensureTransformationInfo();
        // ---------- Original Method ----------
        //mView = view;
        //view.ensureTransformationInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.489 -0400", hash_original_method = "AB53F93DCFA553673F10278B2219DEEA", hash_generated_method = "90BD5F1311748A2F43B655C7C7D425D6")
    public ViewPropertyAnimator setDuration(long duration) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1821249919 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
        } //End block
        mDurationSet = true;
        mDuration = duration;
        varB4EAC82CA7396A68D541C85D26508E83_1821249919 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1821249919.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1821249919;
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDurationSet = true;
        //mDuration = duration;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.506 -0400", hash_original_method = "BFD4BDEC4492EF4D0AE1BFA285B3702C", hash_generated_method = "0689F34E3C66CBAA62F503AC1E8697D3")
    public long getDuration() {
        {
            long varBEC4786C7A2B0EC94964323CF6069F5F_1318312144 = (new ValueAnimator().getDuration());
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_831232820 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_831232820;
        // ---------- Original Method ----------
        //if (mDurationSet) {
            //return mDuration;
        //} else {
            //return new ValueAnimator().getDuration();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.506 -0400", hash_original_method = "137A1F44FEDEF7DBAEA1EE8251F82E1F", hash_generated_method = "D2135FFF254ADFBD6EFC67CD3E093DDF")
    public long getStartDelay() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_850797963 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_850797963;
        // ---------- Original Method ----------
        //if (mStartDelaySet) {
            //return mStartDelay;
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.510 -0400", hash_original_method = "55E567100D84151F5304C84C830F2C1B", hash_generated_method = "D5FF41D6F68B8DB6811B0160B5ECD1D3")
    public ViewPropertyAnimator setStartDelay(long startDelay) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_882775408 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    startDelay);
        } //End block
        mStartDelaySet = true;
        mStartDelay = startDelay;
        varB4EAC82CA7396A68D541C85D26508E83_882775408 = this;
        varB4EAC82CA7396A68D541C85D26508E83_882775408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_882775408;
        // ---------- Original Method ----------
        //if (startDelay < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //startDelay);
        //}
        //mStartDelaySet = true;
        //mStartDelay = startDelay;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.532 -0400", hash_original_method = "995017692E981832E150BE79F0CB8507", hash_generated_method = "977A81B69562111378FE526F489A5E0C")
    public ViewPropertyAnimator setInterpolator(TimeInterpolator interpolator) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_757456708 = null; //Variable for return #1
        mInterpolatorSet = true;
        mInterpolator = interpolator;
        varB4EAC82CA7396A68D541C85D26508E83_757456708 = this;
        varB4EAC82CA7396A68D541C85D26508E83_757456708.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_757456708;
        // ---------- Original Method ----------
        //mInterpolatorSet = true;
        //mInterpolator = interpolator;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.532 -0400", hash_original_method = "D3B983C6B8AF317CF4B7893570C39145", hash_generated_method = "568C15B661B0FEC34A1795F81FC93171")
    public ViewPropertyAnimator setListener(Animator.AnimatorListener listener) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1356450568 = null; //Variable for return #1
        mListener = listener;
        varB4EAC82CA7396A68D541C85D26508E83_1356450568 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1356450568.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1356450568;
        // ---------- Original Method ----------
        //mListener = listener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.533 -0400", hash_original_method = "8C3C0DB6E3E572D598F887EBD1169042", hash_generated_method = "A5710AE0D85F06F649F4EF64FCC54E4A")
    public void start() {
        startAnimation();
        // ---------- Original Method ----------
        //startAnimation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.586 -0400", hash_original_method = "504B77AB05B1FC68628CE89848555449", hash_generated_method = "42A4EA2207CD79B8836C4C3505D52EF8")
    public void cancel() {
        {
            boolean varC7EDB04DFF778343313FFD6886633261_1482096806 = (mAnimatorMap.size() > 0);
            {
                HashMap<Animator, PropertyBundle> mAnimatorMapCopy;
                mAnimatorMapCopy = (HashMap<Animator, PropertyBundle>)mAnimatorMap.clone();
                Set<Animator> animatorSet;
                animatorSet = mAnimatorMapCopy.keySet();
                {
                    Iterator<Animator> var411C23257FA32C3C32619F08CC5859B3_883275335 = (animatorSet).iterator();
                    var411C23257FA32C3C32619F08CC5859B3_883275335.hasNext();
                    Animator runningAnim = var411C23257FA32C3C32619F08CC5859B3_883275335.next();
                    {
                        runningAnim.cancel();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.608 -0400", hash_original_method = "8D670697E365032294CEEA6593A27CE4", hash_generated_method = "6BA8785FFB3EEA7543177B836A6B2702")
    public ViewPropertyAnimator x(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_50843496 = null; //Variable for return #1
        animateProperty(X, value);
        varB4EAC82CA7396A68D541C85D26508E83_50843496 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_50843496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_50843496;
        // ---------- Original Method ----------
        //animateProperty(X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.608 -0400", hash_original_method = "2E3B808D4A6B84F6D09D6182416A5594", hash_generated_method = "0ED17598CF0B9545C57D514B86F3A687")
    public ViewPropertyAnimator xBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_905820135 = null; //Variable for return #1
        animatePropertyBy(X, value);
        varB4EAC82CA7396A68D541C85D26508E83_905820135 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_905820135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_905820135;
        // ---------- Original Method ----------
        //animatePropertyBy(X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.609 -0400", hash_original_method = "6AC23ECE2D15FE0B2F16B84D01FE289F", hash_generated_method = "8FBFFE4F38BFE643B8F9FCC6A04678EA")
    public ViewPropertyAnimator y(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_234349558 = null; //Variable for return #1
        animateProperty(Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_234349558 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_234349558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_234349558;
        // ---------- Original Method ----------
        //animateProperty(Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.609 -0400", hash_original_method = "00E84702996DAE91A9CE0634285E6E21", hash_generated_method = "0F2071762DFB0D5D6C9EBF618E769293")
    public ViewPropertyAnimator yBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_127342831 = null; //Variable for return #1
        animatePropertyBy(Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_127342831 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_127342831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_127342831;
        // ---------- Original Method ----------
        //animatePropertyBy(Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.610 -0400", hash_original_method = "F233DBDEC9778D70C84673F609341CB5", hash_generated_method = "4BD13E92597903D59C7EE9A205F8D693")
    public ViewPropertyAnimator rotation(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_670590680 = null; //Variable for return #1
        animateProperty(ROTATION, value);
        varB4EAC82CA7396A68D541C85D26508E83_670590680 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_670590680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_670590680;
        // ---------- Original Method ----------
        //animateProperty(ROTATION, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.611 -0400", hash_original_method = "64AA9FBA8001BF9E52DBF885273C96E3", hash_generated_method = "9EE6C2E64E451797F9EEA2BACDF69DE6")
    public ViewPropertyAnimator rotationBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1506311284 = null; //Variable for return #1
        animatePropertyBy(ROTATION, value);
        varB4EAC82CA7396A68D541C85D26508E83_1506311284 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1506311284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1506311284;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.637 -0400", hash_original_method = "6C5ABF33E117D9BB891BADA4C861CBC2", hash_generated_method = "A64B2488F0166A1364B2A2A338CA8D56")
    public ViewPropertyAnimator rotationX(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1156621412 = null; //Variable for return #1
        animateProperty(ROTATION_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_1156621412 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1156621412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1156621412;
        // ---------- Original Method ----------
        //animateProperty(ROTATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.638 -0400", hash_original_method = "107BE4D9D2AC7B45B56F8331D6FF6E98", hash_generated_method = "2ECDABB0F775AC73BA69F4C954E02F8D")
    public ViewPropertyAnimator rotationXBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_273196082 = null; //Variable for return #1
        animatePropertyBy(ROTATION_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_273196082 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_273196082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_273196082;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.639 -0400", hash_original_method = "C4C456A89DC44934AFAAB7646D99F320", hash_generated_method = "A0B4AE0383A1468D13240501EFCEAD44")
    public ViewPropertyAnimator rotationY(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_972531099 = null; //Variable for return #1
        animateProperty(ROTATION_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_972531099 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_972531099.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_972531099;
        // ---------- Original Method ----------
        //animateProperty(ROTATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.654 -0400", hash_original_method = "50D1D865E8418E3E5575CE85EA5530DD", hash_generated_method = "524613916111FC5291F0C849CF33F7E7")
    public ViewPropertyAnimator rotationYBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1236341201 = null; //Variable for return #1
        animatePropertyBy(ROTATION_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1236341201 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1236341201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1236341201;
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.655 -0400", hash_original_method = "6A79DB871F5C4E97C4452F0A1C04756A", hash_generated_method = "23A5BD6C09F7BE80A1A8BEB88B1A1E19")
    public ViewPropertyAnimator translationX(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1800566117 = null; //Variable for return #1
        animateProperty(TRANSLATION_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_1800566117 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1800566117.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1800566117;
        // ---------- Original Method ----------
        //animateProperty(TRANSLATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.655 -0400", hash_original_method = "92BE44E9F6280B7AE0D2A8904499350A", hash_generated_method = "E1D351FB559E526B0E4B79811961A889")
    public ViewPropertyAnimator translationXBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_12645395 = null; //Variable for return #1
        animatePropertyBy(TRANSLATION_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_12645395 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_12645395.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12645395;
        // ---------- Original Method ----------
        //animatePropertyBy(TRANSLATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.656 -0400", hash_original_method = "B250150142DA03B7AD8AE045EB4F7730", hash_generated_method = "C357DA691CEF8DB39AC1717CED4DD89B")
    public ViewPropertyAnimator translationY(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_864239716 = null; //Variable for return #1
        animateProperty(TRANSLATION_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_864239716 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_864239716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_864239716;
        // ---------- Original Method ----------
        //animateProperty(TRANSLATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.656 -0400", hash_original_method = "5605726C555918AA2A627C8B848E7FA1", hash_generated_method = "87820C83B5D811D5E7F15E186A95F1DA")
    public ViewPropertyAnimator translationYBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1886600402 = null; //Variable for return #1
        animatePropertyBy(TRANSLATION_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1886600402 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1886600402.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1886600402;
        // ---------- Original Method ----------
        //animatePropertyBy(TRANSLATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.673 -0400", hash_original_method = "D5A33D637AF4590F069926DA61E58388", hash_generated_method = "7FE83E5040F9E3A0F7B59CF8D9C299E8")
    public ViewPropertyAnimator scaleX(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1496866544 = null; //Variable for return #1
        animateProperty(SCALE_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_1496866544 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1496866544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1496866544;
        // ---------- Original Method ----------
        //animateProperty(SCALE_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.674 -0400", hash_original_method = "631FDEF7985B082E37297CEE1F6072F7", hash_generated_method = "9058AD43C9B22EC5697C6EBD1ABA162F")
    public ViewPropertyAnimator scaleXBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_2009676199 = null; //Variable for return #1
        animatePropertyBy(SCALE_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_2009676199 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2009676199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2009676199;
        // ---------- Original Method ----------
        //animatePropertyBy(SCALE_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.677 -0400", hash_original_method = "4F8C4B940AF7AE45F87D198B1B467EBE", hash_generated_method = "9F00400878CBC58615AB3097A7D90A10")
    public ViewPropertyAnimator scaleY(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1497549272 = null; //Variable for return #1
        animateProperty(SCALE_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1497549272 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1497549272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1497549272;
        // ---------- Original Method ----------
        //animateProperty(SCALE_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.678 -0400", hash_original_method = "966CE83C4778D118E9F221736109C3B2", hash_generated_method = "507C404A51BB04A48AC470886C1196FB")
    public ViewPropertyAnimator scaleYBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1862094629 = null; //Variable for return #1
        animatePropertyBy(SCALE_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1862094629 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1862094629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1862094629;
        // ---------- Original Method ----------
        //animatePropertyBy(SCALE_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.678 -0400", hash_original_method = "0CB6E06CAEEE818FC3721A3BD57FF4EB", hash_generated_method = "8C62A8E3BC0E2E1919A8839E9C1EBD32")
    public ViewPropertyAnimator alpha(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1452606929 = null; //Variable for return #1
        animateProperty(ALPHA, value);
        varB4EAC82CA7396A68D541C85D26508E83_1452606929 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1452606929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452606929;
        // ---------- Original Method ----------
        //animateProperty(ALPHA, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.699 -0400", hash_original_method = "ECBF15CE25304962FC64383EBA52129F", hash_generated_method = "B8F63C917AD0ECA1DAAADFB66F2A5E55")
    public ViewPropertyAnimator alphaBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1437096717 = null; //Variable for return #1
        animatePropertyBy(ALPHA, value);
        varB4EAC82CA7396A68D541C85D26508E83_1437096717 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1437096717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1437096717;
        // ---------- Original Method ----------
        //animatePropertyBy(ALPHA, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.700 -0400", hash_original_method = "10886573EB8B45FC976B918620A506A6", hash_generated_method = "611F4C66FC3873B12CF89B6476B1082C")
    private void startAnimation() {
        ValueAnimator animator;
        animator = ValueAnimator.ofFloat(1.0f);
        ArrayList<NameValuesHolder> nameValueList;
        nameValueList = (ArrayList<NameValuesHolder>) mPendingAnimations.clone();
        mPendingAnimations.clear();
        int propertyMask;
        propertyMask = 0;
        int propertyCount;
        propertyCount = nameValueList.size();
        {
            int i;
            i = 0;
            {
                NameValuesHolder nameValuesHolder;
                nameValuesHolder = nameValueList.get(i);
                propertyMask |= nameValuesHolder.mNameConstant;
            } //End block
        } //End collapsed parenthetic
        mAnimatorMap.put(animator, new PropertyBundle(propertyMask, nameValueList));
        animator.addUpdateListener(mAnimatorEventListener);
        animator.addListener(mAnimatorEventListener);
        {
            animator.setStartDelay(mStartDelay);
        } //End block
        {
            animator.setDuration(mDuration);
        } //End block
        {
            animator.setInterpolator(mInterpolator);
        } //End block
        animator.start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.700 -0400", hash_original_method = "DC6A356EFD140318ADF1C94BF09D3544", hash_generated_method = "9E0393B49DFB00F8298EF15620F53AB7")
    private void animateProperty(int constantName, float toValue) {
        float fromValue;
        fromValue = getValue(constantName);
        float deltaValue;
        deltaValue = toValue - fromValue;
        animatePropertyBy(constantName, fromValue, deltaValue);
        addTaint(constantName);
        addTaint(toValue);
        // ---------- Original Method ----------
        //float fromValue = getValue(constantName);
        //float deltaValue = toValue - fromValue;
        //animatePropertyBy(constantName, fromValue, deltaValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.701 -0400", hash_original_method = "B9FE8E2780DEC5F83DA892CAE9192499", hash_generated_method = "0829423AC382385C1B004B90E3B1CAFC")
    private void animatePropertyBy(int constantName, float byValue) {
        float fromValue;
        fromValue = getValue(constantName);
        animatePropertyBy(constantName, fromValue, byValue);
        addTaint(constantName);
        addTaint(byValue);
        // ---------- Original Method ----------
        //float fromValue = getValue(constantName);
        //animatePropertyBy(constantName, fromValue, byValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.802 -0400", hash_original_method = "1BDECA037A3A41B230975E15C12C5086", hash_generated_method = "A3AB0DB973C9660194665A2AC134397B")
    private void animatePropertyBy(int constantName, float startValue, float byValue) {
        {
            boolean varC7EDB04DFF778343313FFD6886633261_1555088244 = (mAnimatorMap.size() > 0);
            {
                Animator animatorToCancel;
                animatorToCancel = null;
                Set<Animator> animatorSet;
                animatorSet = mAnimatorMap.keySet();
                {
                    Iterator<Animator> var411C23257FA32C3C32619F08CC5859B3_1821548033 = (animatorSet).iterator();
                    var411C23257FA32C3C32619F08CC5859B3_1821548033.hasNext();
                    Animator runningAnim = var411C23257FA32C3C32619F08CC5859B3_1821548033.next();
                    {
                        PropertyBundle bundle;
                        bundle = mAnimatorMap.get(runningAnim);
                        {
                            boolean varA44819BE67A66D6D9299A3D560AE9DE8_1427759730 = (bundle.cancel(constantName));
                            {
                                {
                                    animatorToCancel = runningAnim;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    animatorToCancel.cancel();
                } //End block
            } //End block
        } //End collapsed parenthetic
        NameValuesHolder nameValuePair;
        nameValuePair = new NameValuesHolder(constantName, startValue, byValue);
        mPendingAnimations.add(nameValuePair);
        mView.removeCallbacks(mAnimationStarter);
        mView.post(mAnimationStarter);
        addTaint(constantName);
        addTaint(startValue);
        addTaint(byValue);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.814 -0400", hash_original_method = "543199367D6B4536DD4796BA994C91F7", hash_generated_method = "4838A5DCBFFDF16C8DAF41D857BFA3F7")
    private void setValue(int propertyConstant, float value) {
        View.TransformationInfo info;
        info = mView.mTransformationInfo;
        //Begin case TRANSLATION_X 
        info.mTranslationX = value;
        //End case TRANSLATION_X 
        //Begin case TRANSLATION_Y 
        info.mTranslationY = value;
        //End case TRANSLATION_Y 
        //Begin case ROTATION 
        info.mRotation = value;
        //End case ROTATION 
        //Begin case ROTATION_X 
        info.mRotationX = value;
        //End case ROTATION_X 
        //Begin case ROTATION_Y 
        info.mRotationY = value;
        //End case ROTATION_Y 
        //Begin case SCALE_X 
        info.mScaleX = value;
        //End case SCALE_X 
        //Begin case SCALE_Y 
        info.mScaleY = value;
        //End case SCALE_Y 
        //Begin case X 
        info.mTranslationX = value - mView.mLeft;
        //End case X 
        //Begin case Y 
        info.mTranslationY = value - mView.mTop;
        //End case Y 
        //Begin case ALPHA 
        info.mAlpha = value;
        //End case ALPHA 
        addTaint(propertyConstant);
        addTaint(value);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.815 -0400", hash_original_method = "7CFF5C0EAB5A873E8FB7B3F0396E6B5F", hash_generated_method = "B67C6B2E10114A1717B8EC9C834BADC4")
    private float getValue(int propertyConstant) {
        View.TransformationInfo info;
        info = mView.mTransformationInfo;
        addTaint(propertyConstant);
        float var546ADE640B6EDFBC8A086EF31347E768_714753172 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_714753172;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class PropertyBundle {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.815 -0400", hash_original_field = "EA82D747FDF82EEF7E2D5AF15C87B00D", hash_generated_field = "DD49B26A61D9970E0B1D820803D8F62F")

        int mPropertyMask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.815 -0400", hash_original_field = "62545405009A575225238A37B954143A", hash_generated_field = "F20E3CD953F396C43CDD27D3775574C7")

        ArrayList<NameValuesHolder> mNameValuesHolder;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.816 -0400", hash_original_method = "6483519B8187FEE4E1EA6883A6980FC2", hash_generated_method = "0CE8E5F353B93E51DDD0F1A900D1B63F")
          PropertyBundle(int propertyMask, ArrayList<NameValuesHolder> nameValuesHolder) {
            mPropertyMask = propertyMask;
            mNameValuesHolder = nameValuesHolder;
            // ---------- Original Method ----------
            //mPropertyMask = propertyMask;
            //mNameValuesHolder = nameValuesHolder;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.817 -0400", hash_original_method = "4E1EA61EF3802406B1375FE91CF7D26A", hash_generated_method = "33197FB38D3A1831D9E153CE222E17AF")
         boolean cancel(int propertyConstant) {
            {
                int count;
                count = mNameValuesHolder.size();
                {
                    int i;
                    i = 0;
                    {
                        NameValuesHolder nameValuesHolder;
                        nameValuesHolder = mNameValuesHolder.get(i);
                        {
                            mNameValuesHolder.remove(i);
                            mPropertyMask &= ~propertyConstant;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735434956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735434956;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.817 -0400", hash_original_field = "062773B58F942AD47DB973EC0F474614", hash_generated_field = "1D2069986089C122C058DF69AE8585A8")

        int mNameConstant;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.817 -0400", hash_original_field = "58166AED0E3EA530251BD54D5936049B", hash_generated_field = "E0FB3AD0E73F80DF22AE6663ABA13808")

        float mFromValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.817 -0400", hash_original_field = "32CA45314BBE60A9C754152D801F36B7", hash_generated_field = "6689A5DB2A8581AB15B0CD1E639E3108")

        float mDeltaValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.818 -0400", hash_original_method = "96CB986053199F9A9E461CA697D4B879", hash_generated_method = "FDEACC85A045B9ABDF7AE5453B59801C")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.818 -0400", hash_original_method = "583F783AF22881FEE7C79B0EC23630FE", hash_generated_method = "583F783AF22881FEE7C79B0EC23630FE")
        public AnimatorEventListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.826 -0400", hash_original_method = "F9860C292F584577E1CB80EC7999B7B9", hash_generated_method = "3E1477D59BEC11873EA6D0B9A6B63CFA")
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mListener.onAnimationStart(animation);
            } //End block
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationStart(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.838 -0400", hash_original_method = "F7FF3E25F5EB45E2838B85C55C1E6F41", hash_generated_method = "6019076678A7A5975EBE4B68B28D8BF0")
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mListener.onAnimationCancel(animation);
            } //End block
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationCancel(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.839 -0400", hash_original_method = "B115085E9A5CEF09E5F889C8A8B6D805", hash_generated_method = "BA8C3D8ABAD0AFAB24C7264A3BA022A7")
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mListener.onAnimationRepeat(animation);
            } //End block
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationRepeat(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.851 -0400", hash_original_method = "A70C7A230A722F778ADFA14D1A0F2C8C", hash_generated_method = "CE32AB72C6E4513FB3D73055CC821268")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mListener.onAnimationEnd(animation);
            } //End block
            mAnimatorMap.remove(animation);
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationEnd(animation);
            //}
            //mAnimatorMap.remove(animation);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_method = "DF41E3115CE6BC840253482EC4390D2C", hash_generated_method = "F498DB05A29C58A7500B80DCF630C189")
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean alphaHandled;
            alphaHandled = false;
            mView.invalidateParentCaches();
            float fraction;
            fraction = animation.getAnimatedFraction();
            PropertyBundle propertyBundle;
            propertyBundle = mAnimatorMap.get(animation);
            int propertyMask;
            propertyMask = propertyBundle.mPropertyMask;
            {
                mView.invalidate(false);
            } //End block
            ArrayList<NameValuesHolder> valueList;
            valueList = propertyBundle.mNameValuesHolder;
            {
                int count;
                count = valueList.size();
                {
                    int i;
                    i = 0;
                    {
                        NameValuesHolder values;
                        values = valueList.get(i);
                        float value;
                        value = values.mFromValue + fraction * values.mDeltaValue;
                        {
                            alphaHandled = mView.setAlphaNoInvalidation(value);
                        } //End block
                        {
                            setValue(values.mNameConstant, value);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mView.mTransformationInfo.mMatrixDirty = true;
                mView.mPrivateFlags |= View.DRAWN;
            } //End block
            mView.invalidate(alphaHandled);
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "6E3EBA86A35D2BDF0C219EC56301B9FD", hash_generated_field = "162249DF7B7614C0C2172E845A983F9C")

    private static int NONE = 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "7EF24AB0415E857330A0B400367FB35C", hash_generated_field = "BEB03421719669188624A909E1DF778E")

    private static int TRANSLATION_X = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "1693EAC704341CCB25545B840106B0CF", hash_generated_field = "64DC81A165C8AD02494B4DA1EF08AC2D")

    private static int TRANSLATION_Y = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "FC034E19AA4FD3583834AC3AE12C69BE", hash_generated_field = "1342C5C182408D5FA4B36D93492B01E6")

    private static int SCALE_X = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "396F4A8B38BEB256E7696C27913A8337", hash_generated_field = "87BB3C996DEDA157829621EF03DE06A1")

    private static int SCALE_Y = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "EA906C9DB1083889CC51D2B071788A60", hash_generated_field = "A30CDAF1EB2E4284B322A26FD8860265")

    private static int ROTATION = 0x0010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "E91E7704034A7800A0FACA1679BF154C", hash_generated_field = "1127BFF4A0506214771F167DF84E6E5A")

    private static int ROTATION_X = 0x0020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "D5ABA69BD26D7D526F8ACF4FE902FA77", hash_generated_field = "188F314AB516BD96DE15412F74C96B3F")

    private static int ROTATION_Y = 0x0040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "E034313BC3E778F9D17592C78EE7806A", hash_generated_field = "954EE78F3CE36C42BC017010FBDBDB51")

    private static int X = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "313A540AD3FEDC5648CEC2A19CB8CB9F", hash_generated_field = "F6C2AC7F2BE88BB2492DB368CDA05D4A")

    private static int Y = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.853 -0400", hash_original_field = "5A78DFE318375AD927D4480D8645725D", hash_generated_field = "02590A87213415423CBE6AC084B90574")

    private static int ALPHA = 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:53.854 -0400", hash_original_field = "D0A601CA267A5480FF50581D2A8EE745", hash_generated_field = "E1050BFAE421F819DDA3B4806DA3F2F5")

    private static int TRANSFORM_MASK = TRANSLATION_X | TRANSLATION_Y | SCALE_X | SCALE_Y |
            ROTATION | ROTATION_X | ROTATION_Y | X | Y;
}

