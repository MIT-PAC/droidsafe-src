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
    private View mView;
    private long mDuration;
    private boolean mDurationSet = false;
    private long mStartDelay = 0;
    private boolean mStartDelaySet = false;
    private TimeInterpolator mInterpolator;
    private boolean mInterpolatorSet = false;
    private Animator.AnimatorListener mListener = null;
    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<NameValuesHolder>();
    private Runnable mAnimationStarter = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.647 -0400", hash_original_method = "FBB53873B37744AA497F2F82BA93513F", hash_generated_method = "B49121F60C78DA005BF63A708AB544D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            startAnimation();
            // ---------- Original Method ----------
            //startAnimation();
        }

        
}; //Transformed anonymous class
    private HashMap<Animator, PropertyBundle> mAnimatorMap =
            new HashMap<Animator, PropertyBundle>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.648 -0400", hash_original_method = "684AC817B57804E91C0EF57CA21B86F4", hash_generated_method = "06991414B5688D27473ABF8362BBE64F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ViewPropertyAnimator(View view) {
        dsTaint.addTaint(view.dsTaint);
        view.ensureTransformationInfo();
        // ---------- Original Method ----------
        //mView = view;
        //view.ensureTransformationInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.648 -0400", hash_original_method = "AB53F93DCFA553673F10278B2219DEEA", hash_generated_method = "2D68A4CEE33F335B2190551AA697642D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator setDuration(long duration) {
        dsTaint.addTaint(duration);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
        } //End block
        mDurationSet = true;
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDurationSet = true;
        //mDuration = duration;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.648 -0400", hash_original_method = "BFD4BDEC4492EF4D0AE1BFA285B3702C", hash_generated_method = "C368CE23308D6A6F48CED184896D15C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getDuration() {
        {
            long varBEC4786C7A2B0EC94964323CF6069F5F_436640300 = (new ValueAnimator().getDuration());
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (mDurationSet) {
            //return mDuration;
        //} else {
            //return new ValueAnimator().getDuration();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.649 -0400", hash_original_method = "137A1F44FEDEF7DBAEA1EE8251F82E1F", hash_generated_method = "B31A70AF3AA807BDA6EAB444D7E54625")
    @DSModeled(DSC.SAFE)
    public long getStartDelay() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (mStartDelaySet) {
            //return mStartDelay;
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.649 -0400", hash_original_method = "55E567100D84151F5304C84C830F2C1B", hash_generated_method = "10F44A4848D34EAC6774A6E360C24CA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator setStartDelay(long startDelay) {
        dsTaint.addTaint(startDelay);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    startDelay);
        } //End block
        mStartDelaySet = true;
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (startDelay < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //startDelay);
        //}
        //mStartDelaySet = true;
        //mStartDelay = startDelay;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.649 -0400", hash_original_method = "995017692E981832E150BE79F0CB8507", hash_generated_method = "AEF9512C8141BCBC35E934D2063906E1")
    @DSModeled(DSC.SAFE)
    public ViewPropertyAnimator setInterpolator(TimeInterpolator interpolator) {
        dsTaint.addTaint(interpolator.dsTaint);
        mInterpolatorSet = true;
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mInterpolatorSet = true;
        //mInterpolator = interpolator;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.649 -0400", hash_original_method = "D3B983C6B8AF317CF4B7893570C39145", hash_generated_method = "30C826197ACE9BB4A9353310484B735C")
    @DSModeled(DSC.SAFE)
    public ViewPropertyAnimator setListener(Animator.AnimatorListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mListener = listener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.649 -0400", hash_original_method = "8C3C0DB6E3E572D598F887EBD1169042", hash_generated_method = "A5710AE0D85F06F649F4EF64FCC54E4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        startAnimation();
        // ---------- Original Method ----------
        //startAnimation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.654 -0400", hash_original_method = "504B77AB05B1FC68628CE89848555449", hash_generated_method = "B443F3D704798D6F24DA2A018E8776B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        {
            boolean varC7EDB04DFF778343313FFD6886633261_29565127 = (mAnimatorMap.size() > 0);
            {
                HashMap<Animator, PropertyBundle> mAnimatorMapCopy;
                mAnimatorMapCopy = (HashMap<Animator, PropertyBundle>)mAnimatorMap.clone();
                Set<Animator> animatorSet;
                animatorSet = mAnimatorMapCopy.keySet();
                {
                    Iterator<Animator> var411C23257FA32C3C32619F08CC5859B3_716224081 = (animatorSet).iterator();
                    var411C23257FA32C3C32619F08CC5859B3_716224081.hasNext();
                    Animator runningAnim = var411C23257FA32C3C32619F08CC5859B3_716224081.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.654 -0400", hash_original_method = "8D670697E365032294CEEA6593A27CE4", hash_generated_method = "CBC80A46A14CCE7DC5CAEF55E2ABA7F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator x(float value) {
        dsTaint.addTaint(value);
        animateProperty(X, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.654 -0400", hash_original_method = "2E3B808D4A6B84F6D09D6182416A5594", hash_generated_method = "7CD8B8A656AD27F20DF19FB584A3E75E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator xBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(X, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.654 -0400", hash_original_method = "6AC23ECE2D15FE0B2F16B84D01FE289F", hash_generated_method = "3DFCFBF04853E1F5F699AB2757182985")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator y(float value) {
        dsTaint.addTaint(value);
        animateProperty(Y, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.655 -0400", hash_original_method = "00E84702996DAE91A9CE0634285E6E21", hash_generated_method = "5A38D5038A4C17244BA9C1D477EA0DB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator yBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(Y, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.655 -0400", hash_original_method = "F233DBDEC9778D70C84673F609341CB5", hash_generated_method = "B8ABBADAB1695A4B28A0F8C23982440C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator rotation(float value) {
        dsTaint.addTaint(value);
        animateProperty(ROTATION, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(ROTATION, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.655 -0400", hash_original_method = "64AA9FBA8001BF9E52DBF885273C96E3", hash_generated_method = "B4CCBEAC44C8065EB141A276296054C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator rotationBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(ROTATION, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.655 -0400", hash_original_method = "6C5ABF33E117D9BB891BADA4C861CBC2", hash_generated_method = "BAC157B123018CE5CA882EBF5F42D76D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator rotationX(float value) {
        dsTaint.addTaint(value);
        animateProperty(ROTATION_X, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(ROTATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.655 -0400", hash_original_method = "107BE4D9D2AC7B45B56F8331D6FF6E98", hash_generated_method = "A575DF71E2D2A804CD46A50CE4FD9130")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator rotationXBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(ROTATION_X, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.655 -0400", hash_original_method = "C4C456A89DC44934AFAAB7646D99F320", hash_generated_method = "850F4077EA61D167EC59C3B1D5A85C8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator rotationY(float value) {
        dsTaint.addTaint(value);
        animateProperty(ROTATION_Y, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(ROTATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.656 -0400", hash_original_method = "50D1D865E8418E3E5575CE85EA5530DD", hash_generated_method = "EA2AEBC402EB4338D6288528F9883217")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator rotationYBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(ROTATION_Y, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(ROTATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.656 -0400", hash_original_method = "6A79DB871F5C4E97C4452F0A1C04756A", hash_generated_method = "BCCE716B94A27B2C4A80BD5D5E0D3C09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator translationX(float value) {
        dsTaint.addTaint(value);
        animateProperty(TRANSLATION_X, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(TRANSLATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.656 -0400", hash_original_method = "92BE44E9F6280B7AE0D2A8904499350A", hash_generated_method = "E1DE8B3C96DF884F4C4718BFF4AF3088")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator translationXBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(TRANSLATION_X, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(TRANSLATION_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.656 -0400", hash_original_method = "B250150142DA03B7AD8AE045EB4F7730", hash_generated_method = "6F65C9F83B64466BF8EFE08C9BBA4E67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator translationY(float value) {
        dsTaint.addTaint(value);
        animateProperty(TRANSLATION_Y, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(TRANSLATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.656 -0400", hash_original_method = "5605726C555918AA2A627C8B848E7FA1", hash_generated_method = "8A7026771B05D132B2BD4DA7E1E8C67C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator translationYBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(TRANSLATION_Y, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(TRANSLATION_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.656 -0400", hash_original_method = "D5A33D637AF4590F069926DA61E58388", hash_generated_method = "FBCE0C405A6B9010040238197EC908C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator scaleX(float value) {
        dsTaint.addTaint(value);
        animateProperty(SCALE_X, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(SCALE_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.657 -0400", hash_original_method = "631FDEF7985B082E37297CEE1F6072F7", hash_generated_method = "985F0D59624EC1922AD17D8B2BFDAD8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator scaleXBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(SCALE_X, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(SCALE_X, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.657 -0400", hash_original_method = "4F8C4B940AF7AE45F87D198B1B467EBE", hash_generated_method = "40FB66DE9B9E1DA4CB693EE4433338C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator scaleY(float value) {
        dsTaint.addTaint(value);
        animateProperty(SCALE_Y, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(SCALE_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.657 -0400", hash_original_method = "966CE83C4778D118E9F221736109C3B2", hash_generated_method = "74DFE807099BE35791C92575FEF65368")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator scaleYBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(SCALE_Y, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(SCALE_Y, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.657 -0400", hash_original_method = "0CB6E06CAEEE818FC3721A3BD57FF4EB", hash_generated_method = "ABD2F2BE9AA66C38CA69CC213880232E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator alpha(float value) {
        dsTaint.addTaint(value);
        animateProperty(ALPHA, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animateProperty(ALPHA, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.657 -0400", hash_original_method = "ECBF15CE25304962FC64383EBA52129F", hash_generated_method = "142B7A51353058EC317AA3C3E55BE477")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewPropertyAnimator alphaBy(float value) {
        dsTaint.addTaint(value);
        animatePropertyBy(ALPHA, value);
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //animatePropertyBy(ALPHA, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.658 -0400", hash_original_method = "10886573EB8B45FC976B918620A506A6", hash_generated_method = "611F4C66FC3873B12CF89B6476B1082C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.658 -0400", hash_original_method = "DC6A356EFD140318ADF1C94BF09D3544", hash_generated_method = "CEB7E740E3998712501BDA9CC5DE080B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void animateProperty(int constantName, float toValue) {
        dsTaint.addTaint(toValue);
        dsTaint.addTaint(constantName);
        float fromValue;
        fromValue = getValue(constantName);
        float deltaValue;
        deltaValue = toValue - fromValue;
        animatePropertyBy(constantName, fromValue, deltaValue);
        // ---------- Original Method ----------
        //float fromValue = getValue(constantName);
        //float deltaValue = toValue - fromValue;
        //animatePropertyBy(constantName, fromValue, deltaValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.658 -0400", hash_original_method = "B9FE8E2780DEC5F83DA892CAE9192499", hash_generated_method = "0D99B86AA5C5C956573C2AFBA3EBE397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void animatePropertyBy(int constantName, float byValue) {
        dsTaint.addTaint(byValue);
        dsTaint.addTaint(constantName);
        float fromValue;
        fromValue = getValue(constantName);
        animatePropertyBy(constantName, fromValue, byValue);
        // ---------- Original Method ----------
        //float fromValue = getValue(constantName);
        //animatePropertyBy(constantName, fromValue, byValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.676 -0400", hash_original_method = "1BDECA037A3A41B230975E15C12C5086", hash_generated_method = "01EB49C0659F3F4C6AA2EBAF9E9DA4DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void animatePropertyBy(int constantName, float startValue, float byValue) {
        dsTaint.addTaint(startValue);
        dsTaint.addTaint(byValue);
        dsTaint.addTaint(constantName);
        {
            boolean varC7EDB04DFF778343313FFD6886633261_1621837871 = (mAnimatorMap.size() > 0);
            {
                Animator animatorToCancel;
                animatorToCancel = null;
                Set<Animator> animatorSet;
                animatorSet = mAnimatorMap.keySet();
                {
                    Iterator<Animator> var411C23257FA32C3C32619F08CC5859B3_335691889 = (animatorSet).iterator();
                    var411C23257FA32C3C32619F08CC5859B3_335691889.hasNext();
                    Animator runningAnim = var411C23257FA32C3C32619F08CC5859B3_335691889.next();
                    {
                        PropertyBundle bundle;
                        bundle = mAnimatorMap.get(runningAnim);
                        {
                            boolean varA44819BE67A66D6D9299A3D560AE9DE8_1350568949 = (bundle.cancel(constantName));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.677 -0400", hash_original_method = "543199367D6B4536DD4796BA994C91F7", hash_generated_method = "A5DD3CD52F7F3E9E8BBA562C1AB16DAD")
    @DSModeled(DSC.SAFE)
    private void setValue(int propertyConstant, float value) {
        dsTaint.addTaint(propertyConstant);
        dsTaint.addTaint(value);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.677 -0400", hash_original_method = "7CFF5C0EAB5A873E8FB7B3F0396E6B5F", hash_generated_method = "29FCE2E08B91CFA5800F5936FEAEBEF9")
    @DSModeled(DSC.SAFE)
    private float getValue(int propertyConstant) {
        dsTaint.addTaint(propertyConstant);
        View.TransformationInfo info;
        info = mView.mTransformationInfo;
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class PropertyBundle {
        int mPropertyMask;
        ArrayList<NameValuesHolder> mNameValuesHolder;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.677 -0400", hash_original_method = "6483519B8187FEE4E1EA6883A6980FC2", hash_generated_method = "1E69E2EB5E57C15F7474C6395C372237")
        @DSModeled(DSC.SAFE)
         PropertyBundle(int propertyMask, ArrayList<NameValuesHolder> nameValuesHolder) {
            dsTaint.addTaint(propertyMask);
            dsTaint.addTaint(nameValuesHolder.dsTaint);
            // ---------- Original Method ----------
            //mPropertyMask = propertyMask;
            //mNameValuesHolder = nameValuesHolder;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.678 -0400", hash_original_method = "4E1EA61EF3802406B1375FE91CF7D26A", hash_generated_method = "BE86E4BD580409162AB111C16932502D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean cancel(int propertyConstant) {
            dsTaint.addTaint(propertyConstant);
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
            return dsTaint.getTaintBoolean();
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
        int mNameConstant;
        float mFromValue;
        float mDeltaValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.678 -0400", hash_original_method = "96CB986053199F9A9E461CA697D4B879", hash_generated_method = "A9A1577EE06F3487214771F0A2E43D9E")
        @DSModeled(DSC.SAFE)
         NameValuesHolder(int nameConstant, float fromValue, float deltaValue) {
            dsTaint.addTaint(deltaValue);
            dsTaint.addTaint(nameConstant);
            dsTaint.addTaint(fromValue);
            // ---------- Original Method ----------
            //mNameConstant = nameConstant;
            //mFromValue = fromValue;
            //mDeltaValue = deltaValue;
        }

        
    }


    
    private class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.678 -0400", hash_original_method = "BF81323765EC72797521F7C4C7700F6F", hash_generated_method = "BF81323765EC72797521F7C4C7700F6F")
                public AnimatorEventListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.678 -0400", hash_original_method = "F9860C292F584577E1CB80EC7999B7B9", hash_generated_method = "B95BAF032135C004564F39A622A3CFBA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            {
                mListener.onAnimationStart(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationStart(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.678 -0400", hash_original_method = "F7FF3E25F5EB45E2838B85C55C1E6F41", hash_generated_method = "2CB8168D8C760FBD382023697D806D33")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            {
                mListener.onAnimationCancel(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationCancel(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.678 -0400", hash_original_method = "B115085E9A5CEF09E5F889C8A8B6D805", hash_generated_method = "9A2F6C2AC378E0C67FACC0096D8269F4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            {
                mListener.onAnimationRepeat(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mListener.onAnimationRepeat(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.679 -0400", hash_original_method = "A70C7A230A722F778ADFA14D1A0F2C8C", hash_generated_method = "5856372F010510070B44F2E3573A9DB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.679 -0400", hash_original_method = "DF41E3115CE6BC840253482EC4390D2C", hash_generated_method = "84873BEBBBE3BD8DF4B2716357839733")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final int NONE           = 0x0000;
    private static final int TRANSLATION_X  = 0x0001;
    private static final int TRANSLATION_Y  = 0x0002;
    private static final int SCALE_X        = 0x0004;
    private static final int SCALE_Y        = 0x0008;
    private static final int ROTATION       = 0x0010;
    private static final int ROTATION_X     = 0x0020;
    private static final int ROTATION_Y     = 0x0040;
    private static final int X              = 0x0080;
    private static final int Y              = 0x0100;
    private static final int ALPHA          = 0x0200;
    private static final int TRANSFORM_MASK = TRANSLATION_X | TRANSLATION_Y | SCALE_X | SCALE_Y |
            ROTATION | ROTATION_X | ROTATION_Y | X | Y;
}

