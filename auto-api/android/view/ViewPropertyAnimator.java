package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.TimeInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ViewPropertyAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "8BF5222528387AE04CED3C727F9F8865")

    private long mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "2173D0EAB9C999840AC85B43401734BC", hash_generated_field = "03D5FC9AEBB7D8B90777FF73C31E1A48")

    private boolean mDurationSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "DF48E3731958141B55A4C7E73DDFC592", hash_generated_field = "4F4328485D02696A823721721A3E8657")

    private boolean mStartDelaySet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "EACBADF91032ABF3D011EE1B3057F84D")

    private TimeInterpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "4E6DBADDA65ADE077AE86FF3C107D674", hash_generated_field = "82B2216AD41FE3E781D6035774E250B3")

    private boolean mInterpolatorSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "6F7F10CDECDD60587A676132819FC95C", hash_generated_field = "69256070A6B51CD84194DBDA7B561216")

    private Animator.AnimatorListener mListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "08EB2BB862E5FE0721A17E700067CCEB", hash_generated_field = "2F88CB8CE002DBE4EE3C525DE38A44D1")

    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "DCD9F986A2DB3ACDD6D71B582052B6E9", hash_generated_field = "245199B04CE5933EE61BB14613CB2F2D")

    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<NameValuesHolder>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "E77137B6BB2AC6EED35F93F563E9A9A8", hash_generated_field = "DDAE17988E2F7FE309FFBA8222A2CC64")

    private Runnable mAnimationStarter = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_method = "FBB53873B37744AA497F2F82BA93513F", hash_generated_method = "B49121F60C78DA005BF63A708AB544D3")
        @Override
        public void run() {
            startAnimation();
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.253 -0400", hash_original_field = "2BB891F43500DBB293AEBA7F524B468D", hash_generated_field = "8AE0B8099C4E7901C63106A6D931EB1C")

    private HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap<Animator, PropertyBundle>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.254 -0400", hash_original_method = "684AC817B57804E91C0EF57CA21B86F4", hash_generated_method = "81503CFEBD19EABDC587B9564B95B657")
      ViewPropertyAnimator(View view) {
        mView = view;
        view.ensureTransformationInfo();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.255 -0400", hash_original_method = "AB53F93DCFA553673F10278B2219DEEA", hash_generated_method = "B7B0E0139496E62928BC7D82370E40A0")
    public ViewPropertyAnimator setDuration(long duration) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_628884978 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
        } 
        mDurationSet = true;
        mDuration = duration;
        varB4EAC82CA7396A68D541C85D26508E83_628884978 = this;
        varB4EAC82CA7396A68D541C85D26508E83_628884978.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_628884978;
        
        
            
                    
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.255 -0400", hash_original_method = "BFD4BDEC4492EF4D0AE1BFA285B3702C", hash_generated_method = "397FCD8E6B08E084FA19029A5EBF7FAB")
    public long getDuration() {
        {
            long varBEC4786C7A2B0EC94964323CF6069F5F_732161740 = (new ValueAnimator().getDuration());
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_894788374 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_894788374;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.255 -0400", hash_original_method = "137A1F44FEDEF7DBAEA1EE8251F82E1F", hash_generated_method = "BDDBC26F0223F3F02A7556E3F594A158")
    public long getStartDelay() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_522337225 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_522337225;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.256 -0400", hash_original_method = "55E567100D84151F5304C84C830F2C1B", hash_generated_method = "3ADC3E4E6DA8805A5469C9F4331992DC")
    public ViewPropertyAnimator setStartDelay(long startDelay) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1299795430 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    startDelay);
        } 
        mStartDelaySet = true;
        mStartDelay = startDelay;
        varB4EAC82CA7396A68D541C85D26508E83_1299795430 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1299795430.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1299795430;
        
        
            
                    
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.257 -0400", hash_original_method = "995017692E981832E150BE79F0CB8507", hash_generated_method = "B68484D0EA54B7EE3B1A21836DAE3075")
    public ViewPropertyAnimator setInterpolator(TimeInterpolator interpolator) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_189114921 = null; 
        mInterpolatorSet = true;
        mInterpolator = interpolator;
        varB4EAC82CA7396A68D541C85D26508E83_189114921 = this;
        varB4EAC82CA7396A68D541C85D26508E83_189114921.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_189114921;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.258 -0400", hash_original_method = "D3B983C6B8AF317CF4B7893570C39145", hash_generated_method = "0D0892058770E6EE12A8978AA6BAEEC1")
    public ViewPropertyAnimator setListener(Animator.AnimatorListener listener) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1695566237 = null; 
        mListener = listener;
        varB4EAC82CA7396A68D541C85D26508E83_1695566237 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1695566237.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1695566237;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.258 -0400", hash_original_method = "8C3C0DB6E3E572D598F887EBD1169042", hash_generated_method = "A5710AE0D85F06F649F4EF64FCC54E4A")
    public void start() {
        startAnimation();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.262 -0400", hash_original_method = "504B77AB05B1FC68628CE89848555449", hash_generated_method = "FD2E7D5772767C4F9C68AA25209026D7")
    public void cancel() {
        {
            boolean varC7EDB04DFF778343313FFD6886633261_254012980 = (mAnimatorMap.size() > 0);
            {
                HashMap<Animator, PropertyBundle> mAnimatorMapCopy = (HashMap<Animator, PropertyBundle>)mAnimatorMap.clone();
                Set<Animator> animatorSet = mAnimatorMapCopy.keySet();
                {
                    Iterator<Animator> var411C23257FA32C3C32619F08CC5859B3_263118861 = (animatorSet).iterator();
                    var411C23257FA32C3C32619F08CC5859B3_263118861.hasNext();
                    Animator runningAnim = var411C23257FA32C3C32619F08CC5859B3_263118861.next();
                    {
                        runningAnim.cancel();
                    } 
                } 
            } 
        } 
        mPendingAnimations.clear();
        mView.removeCallbacks(mAnimationStarter);
        
        
            
                    
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.263 -0400", hash_original_method = "8D670697E365032294CEEA6593A27CE4", hash_generated_method = "EF92D9546AFDEF3D973587EF1B1F07CF")
    public ViewPropertyAnimator x(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_2139066829 = null; 
        animateProperty(X, value);
        varB4EAC82CA7396A68D541C85D26508E83_2139066829 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2139066829.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2139066829;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.263 -0400", hash_original_method = "2E3B808D4A6B84F6D09D6182416A5594", hash_generated_method = "C77A96891E258A0E0A9EAAA59BD7844A")
    public ViewPropertyAnimator xBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1003616532 = null; 
        animatePropertyBy(X, value);
        varB4EAC82CA7396A68D541C85D26508E83_1003616532 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1003616532.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1003616532;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.264 -0400", hash_original_method = "6AC23ECE2D15FE0B2F16B84D01FE289F", hash_generated_method = "4BC7986C063314C20F799B408F740722")
    public ViewPropertyAnimator y(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_371297939 = null; 
        animateProperty(Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_371297939 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_371297939.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_371297939;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.264 -0400", hash_original_method = "00E84702996DAE91A9CE0634285E6E21", hash_generated_method = "3D12B685AFC7CCD3D5E9CC9B878845A8")
    public ViewPropertyAnimator yBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1896954233 = null; 
        animatePropertyBy(Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1896954233 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1896954233.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1896954233;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.265 -0400", hash_original_method = "F233DBDEC9778D70C84673F609341CB5", hash_generated_method = "9F00A65738F29F780E68209D7A29D310")
    public ViewPropertyAnimator rotation(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_522460057 = null; 
        animateProperty(ROTATION, value);
        varB4EAC82CA7396A68D541C85D26508E83_522460057 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_522460057.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_522460057;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.266 -0400", hash_original_method = "64AA9FBA8001BF9E52DBF885273C96E3", hash_generated_method = "2DACCAB3E59453900D967313FBC57554")
    public ViewPropertyAnimator rotationBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1274128891 = null; 
        animatePropertyBy(ROTATION, value);
        varB4EAC82CA7396A68D541C85D26508E83_1274128891 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1274128891.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1274128891;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.267 -0400", hash_original_method = "6C5ABF33E117D9BB891BADA4C861CBC2", hash_generated_method = "7C864F0D6AEEE6DCF0C3C123A1B45BAE")
    public ViewPropertyAnimator rotationX(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1258641158 = null; 
        animateProperty(ROTATION_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_1258641158 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1258641158.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1258641158;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.267 -0400", hash_original_method = "107BE4D9D2AC7B45B56F8331D6FF6E98", hash_generated_method = "2B8D116AE8EC3FF246C8808A931B1FAC")
    public ViewPropertyAnimator rotationXBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1454291350 = null; 
        animatePropertyBy(ROTATION_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_1454291350 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1454291350.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1454291350;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.268 -0400", hash_original_method = "C4C456A89DC44934AFAAB7646D99F320", hash_generated_method = "AACD98B36AF85C37D58379DD60AA1C95")
    public ViewPropertyAnimator rotationY(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1872983918 = null; 
        animateProperty(ROTATION_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1872983918 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1872983918.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1872983918;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.269 -0400", hash_original_method = "50D1D865E8418E3E5575CE85EA5530DD", hash_generated_method = "AE89E06690E2775B1F2A3FB183D7A1AB")
    public ViewPropertyAnimator rotationYBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1372721995 = null; 
        animatePropertyBy(ROTATION_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1372721995 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1372721995.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1372721995;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.270 -0400", hash_original_method = "6A79DB871F5C4E97C4452F0A1C04756A", hash_generated_method = "9239F5F535C3B5B6FA37111EEFC20476")
    public ViewPropertyAnimator translationX(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_690337745 = null; 
        animateProperty(TRANSLATION_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_690337745 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_690337745.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_690337745;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.270 -0400", hash_original_method = "92BE44E9F6280B7AE0D2A8904499350A", hash_generated_method = "47CEAD9C8D3F6DEAA12E3C38EFF655C6")
    public ViewPropertyAnimator translationXBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_131690807 = null; 
        animatePropertyBy(TRANSLATION_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_131690807 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_131690807.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_131690807;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.271 -0400", hash_original_method = "B250150142DA03B7AD8AE045EB4F7730", hash_generated_method = "7BE28DC7202F9784B6A06B4792815327")
    public ViewPropertyAnimator translationY(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1874955348 = null; 
        animateProperty(TRANSLATION_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1874955348 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1874955348.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1874955348;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.272 -0400", hash_original_method = "5605726C555918AA2A627C8B848E7FA1", hash_generated_method = "246C9E5DCF94899A71B221E8B3006221")
    public ViewPropertyAnimator translationYBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1082877632 = null; 
        animatePropertyBy(TRANSLATION_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1082877632 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1082877632.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1082877632;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.272 -0400", hash_original_method = "D5A33D637AF4590F069926DA61E58388", hash_generated_method = "12DB49B3F9013113916E54C3A2AB84EE")
    public ViewPropertyAnimator scaleX(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1293083413 = null; 
        animateProperty(SCALE_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_1293083413 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1293083413.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1293083413;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.273 -0400", hash_original_method = "631FDEF7985B082E37297CEE1F6072F7", hash_generated_method = "4B42431FE20F82D644B0F34B8A331E85")
    public ViewPropertyAnimator scaleXBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1071370277 = null; 
        animatePropertyBy(SCALE_X, value);
        varB4EAC82CA7396A68D541C85D26508E83_1071370277 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1071370277.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1071370277;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.274 -0400", hash_original_method = "4F8C4B940AF7AE45F87D198B1B467EBE", hash_generated_method = "B1C683CE4D7CBB67AD61E23DC4B666F4")
    public ViewPropertyAnimator scaleY(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1024733957 = null; 
        animateProperty(SCALE_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1024733957 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1024733957.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1024733957;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.274 -0400", hash_original_method = "966CE83C4778D118E9F221736109C3B2", hash_generated_method = "16BB271A5684384AB984D9BCC27A6D06")
    public ViewPropertyAnimator scaleYBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1335968998 = null; 
        animatePropertyBy(SCALE_Y, value);
        varB4EAC82CA7396A68D541C85D26508E83_1335968998 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1335968998.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1335968998;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.275 -0400", hash_original_method = "0CB6E06CAEEE818FC3721A3BD57FF4EB", hash_generated_method = "A1439E80AD96EBAEA06252A228D3D310")
    public ViewPropertyAnimator alpha(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1351343315 = null; 
        animateProperty(ALPHA, value);
        varB4EAC82CA7396A68D541C85D26508E83_1351343315 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1351343315.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1351343315;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.275 -0400", hash_original_method = "ECBF15CE25304962FC64383EBA52129F", hash_generated_method = "97622827A6D5FB2BBBAFBE7DF9D261BE")
    public ViewPropertyAnimator alphaBy(float value) {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_560286645 = null; 
        animatePropertyBy(ALPHA, value);
        varB4EAC82CA7396A68D541C85D26508E83_560286645 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_560286645.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_560286645;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.276 -0400", hash_original_method = "10886573EB8B45FC976B918620A506A6", hash_generated_method = "922D7C1341FBB170488376819C9F2E0F")
    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(1.0f);
        ArrayList<NameValuesHolder> nameValueList = (ArrayList<NameValuesHolder>) mPendingAnimations.clone();
        mPendingAnimations.clear();
        int propertyMask = 0;
        int propertyCount = nameValueList.size();
        {
            int i = 0;
            {
                NameValuesHolder nameValuesHolder = nameValueList.get(i);
                propertyMask |= nameValuesHolder.mNameConstant;
            } 
        } 
        mAnimatorMap.put(animator, new PropertyBundle(propertyMask, nameValueList));
        animator.addUpdateListener(mAnimatorEventListener);
        animator.addListener(mAnimatorEventListener);
        {
            animator.setStartDelay(mStartDelay);
        } 
        {
            animator.setDuration(mDuration);
        } 
        {
            animator.setInterpolator(mInterpolator);
        } 
        animator.start();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.277 -0400", hash_original_method = "DC6A356EFD140318ADF1C94BF09D3544", hash_generated_method = "08D2091C2BF82DF6C586494329DACC99")
    private void animateProperty(int constantName, float toValue) {
        float fromValue = getValue(constantName);
        float deltaValue = toValue - fromValue;
        animatePropertyBy(constantName, fromValue, deltaValue);
        addTaint(constantName);
        addTaint(toValue);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.277 -0400", hash_original_method = "B9FE8E2780DEC5F83DA892CAE9192499", hash_generated_method = "E2B0357EEF4554E8723CFC01728BD120")
    private void animatePropertyBy(int constantName, float byValue) {
        float fromValue = getValue(constantName);
        animatePropertyBy(constantName, fromValue, byValue);
        addTaint(constantName);
        addTaint(byValue);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.285 -0400", hash_original_method = "1BDECA037A3A41B230975E15C12C5086", hash_generated_method = "75EC0737BA3098E6387D3890610778DB")
    private void animatePropertyBy(int constantName, float startValue, float byValue) {
        {
            boolean varC7EDB04DFF778343313FFD6886633261_1273568103 = (mAnimatorMap.size() > 0);
            {
                Animator animatorToCancel = null;
                Set<Animator> animatorSet = mAnimatorMap.keySet();
                {
                    Iterator<Animator> var411C23257FA32C3C32619F08CC5859B3_1455218322 = (animatorSet).iterator();
                    var411C23257FA32C3C32619F08CC5859B3_1455218322.hasNext();
                    Animator runningAnim = var411C23257FA32C3C32619F08CC5859B3_1455218322.next();
                    {
                        PropertyBundle bundle = mAnimatorMap.get(runningAnim);
                        {
                            boolean varA44819BE67A66D6D9299A3D560AE9DE8_623492588 = (bundle.cancel(constantName));
                            {
                                {
                                    animatorToCancel = runningAnim;
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    animatorToCancel.cancel();
                } 
            } 
        } 
        NameValuesHolder nameValuePair = new NameValuesHolder(constantName, startValue, byValue);
        mPendingAnimations.add(nameValuePair);
        mView.removeCallbacks(mAnimationStarter);
        mView.post(mAnimationStarter);
        addTaint(constantName);
        addTaint(startValue);
        addTaint(byValue);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.285 -0400", hash_original_method = "543199367D6B4536DD4796BA994C91F7", hash_generated_method = "6DD304FEEAA04E06C3EEF0C48F5B8BBB")
    private void setValue(int propertyConstant, float value) {
        final View.TransformationInfo info = mView.mTransformationInfo;
        
        info.mTranslationX = value;
        
        
        info.mTranslationY = value;
        
        
        info.mRotation = value;
        
        
        info.mRotationX = value;
        
        
        info.mRotationY = value;
        
        
        info.mScaleX = value;
        
        
        info.mScaleY = value;
        
        
        info.mTranslationX = value - mView.mLeft;
        
        
        info.mTranslationY = value - mView.mTop;
        
        
        info.mAlpha = value;
        
        addTaint(propertyConstant);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.286 -0400", hash_original_method = "7CFF5C0EAB5A873E8FB7B3F0396E6B5F", hash_generated_method = "6A07F659F56364E7C156A86BB65AEDFE")
    private float getValue(int propertyConstant) {
        final View.TransformationInfo info = mView.mTransformationInfo;
        addTaint(propertyConstant);
        float var546ADE640B6EDFBC8A086EF31347E768_1702850717 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1702850717;
        
        
    }

    
    private static class PropertyBundle {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.286 -0400", hash_original_field = "EA82D747FDF82EEF7E2D5AF15C87B00D", hash_generated_field = "DD49B26A61D9970E0B1D820803D8F62F")

        int mPropertyMask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.286 -0400", hash_original_field = "62545405009A575225238A37B954143A", hash_generated_field = "F20E3CD953F396C43CDD27D3775574C7")

        ArrayList<NameValuesHolder> mNameValuesHolder;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.286 -0400", hash_original_method = "6483519B8187FEE4E1EA6883A6980FC2", hash_generated_method = "0CE8E5F353B93E51DDD0F1A900D1B63F")
          PropertyBundle(int propertyMask, ArrayList<NameValuesHolder> nameValuesHolder) {
            mPropertyMask = propertyMask;
            mNameValuesHolder = nameValuesHolder;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.287 -0400", hash_original_method = "4E1EA61EF3802406B1375FE91CF7D26A", hash_generated_method = "F22F5F3125F6B004E11137CDDAD02C1A")
         boolean cancel(int propertyConstant) {
            {
                int count = mNameValuesHolder.size();
                {
                    int i = 0;
                    {
                        NameValuesHolder nameValuesHolder = mNameValuesHolder.get(i);
                        {
                            mNameValuesHolder.remove(i);
                            mPropertyMask &= ~propertyConstant;
                        } 
                    } 
                } 
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742992053 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_742992053;
            
            
                
                
                    
                    
                        
                        
                        
                    
                
            
            
        }

        
    }


    
    private static class NameValuesHolder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.287 -0400", hash_original_field = "062773B58F942AD47DB973EC0F474614", hash_generated_field = "1D2069986089C122C058DF69AE8585A8")

        int mNameConstant;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.287 -0400", hash_original_field = "58166AED0E3EA530251BD54D5936049B", hash_generated_field = "E0FB3AD0E73F80DF22AE6663ABA13808")

        float mFromValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.287 -0400", hash_original_field = "32CA45314BBE60A9C754152D801F36B7", hash_generated_field = "6689A5DB2A8581AB15B0CD1E639E3108")

        float mDeltaValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.288 -0400", hash_original_method = "96CB986053199F9A9E461CA697D4B879", hash_generated_method = "FDEACC85A045B9ABDF7AE5453B59801C")
          NameValuesHolder(int nameConstant, float fromValue, float deltaValue) {
            mNameConstant = nameConstant;
            mFromValue = fromValue;
            mDeltaValue = deltaValue;
            
            
            
            
        }

        
    }


    
    private class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.288 -0400", hash_original_method = "583F783AF22881FEE7C79B0EC23630FE", hash_generated_method = "583F783AF22881FEE7C79B0EC23630FE")
        public AnimatorEventListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.288 -0400", hash_original_method = "F9860C292F584577E1CB80EC7999B7B9", hash_generated_method = "3E1477D59BEC11873EA6D0B9A6B63CFA")
        @Override
        public void onAnimationStart(Animator animation) {
            
            {
                mListener.onAnimationStart(animation);
            } 
            addTaint(animation.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.289 -0400", hash_original_method = "F7FF3E25F5EB45E2838B85C55C1E6F41", hash_generated_method = "6019076678A7A5975EBE4B68B28D8BF0")
        @Override
        public void onAnimationCancel(Animator animation) {
            
            {
                mListener.onAnimationCancel(animation);
            } 
            addTaint(animation.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.289 -0400", hash_original_method = "B115085E9A5CEF09E5F889C8A8B6D805", hash_generated_method = "BA8C3D8ABAD0AFAB24C7264A3BA022A7")
        @Override
        public void onAnimationRepeat(Animator animation) {
            
            {
                mListener.onAnimationRepeat(animation);
            } 
            addTaint(animation.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.290 -0400", hash_original_method = "A70C7A230A722F778ADFA14D1A0F2C8C", hash_generated_method = "CE32AB72C6E4513FB3D73055CC821268")
        @Override
        public void onAnimationEnd(Animator animation) {
            
            {
                mListener.onAnimationEnd(animation);
            } 
            mAnimatorMap.remove(animation);
            addTaint(animation.getTaint());
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_method = "DF41E3115CE6BC840253482EC4390D2C", hash_generated_method = "CE4658E636BFA78ABDBDF6EC38A3A5FD")
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            
            boolean alphaHandled = false;
            mView.invalidateParentCaches();
            float fraction = animation.getAnimatedFraction();
            PropertyBundle propertyBundle = mAnimatorMap.get(animation);
            int propertyMask = propertyBundle.mPropertyMask;
            {
                mView.invalidate(false);
            } 
            ArrayList<NameValuesHolder> valueList = propertyBundle.mNameValuesHolder;
            {
                int count = valueList.size();
                {
                    int i = 0;
                    {
                        NameValuesHolder values = valueList.get(i);
                        float value = values.mFromValue + fraction * values.mDeltaValue;
                        {
                            alphaHandled = mView.setAlphaNoInvalidation(value);
                        } 
                        {
                            setValue(values.mNameConstant, value);
                        } 
                    } 
                } 
            } 
            {
                mView.mTransformationInfo.mMatrixDirty = true;
                mView.mPrivateFlags |= View.DRAWN;
            } 
            mView.invalidate(alphaHandled);
            addTaint(animation.getTaint());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "6E3EBA86A35D2BDF0C219EC56301B9FD", hash_generated_field = "53FCA486F4B3E72DD422D1A05E64E7D7")

    private static final int NONE = 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "7EF24AB0415E857330A0B400367FB35C", hash_generated_field = "1EA0ED90123067FBA25A12B73C3B24A4")

    private static final int TRANSLATION_X = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "1693EAC704341CCB25545B840106B0CF", hash_generated_field = "74C6ACDB0AB6198B341013D44626807D")

    private static final int TRANSLATION_Y = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "FC034E19AA4FD3583834AC3AE12C69BE", hash_generated_field = "E676EA8846B5357A39E8D3182B5EE15E")

    private static final int SCALE_X = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "396F4A8B38BEB256E7696C27913A8337", hash_generated_field = "08F4E43074CCDA53ECDCF5DD24262BBA")

    private static final int SCALE_Y = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "EA906C9DB1083889CC51D2B071788A60", hash_generated_field = "A0750AAA69331EB7E9646558AD0A02F9")

    private static final int ROTATION = 0x0010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "E91E7704034A7800A0FACA1679BF154C", hash_generated_field = "159F22271A102CB6FE5DEF638B8BC6A5")

    private static final int ROTATION_X = 0x0020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "D5ABA69BD26D7D526F8ACF4FE902FA77", hash_generated_field = "97534AB067F7E259F67702CF1E739334")

    private static final int ROTATION_Y = 0x0040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "E034313BC3E778F9D17592C78EE7806A", hash_generated_field = "581B8B6FF307BDC6C94C6FBF3BC24EAE")

    private static final int X = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "313A540AD3FEDC5648CEC2A19CB8CB9F", hash_generated_field = "55573BD988F03CE9C928861DECD58BE3")

    private static final int Y = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "5A78DFE318375AD927D4480D8645725D", hash_generated_field = "04050B0DAE51D1C9573296CE00EE96EE")

    private static final int ALPHA = 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.291 -0400", hash_original_field = "D0A601CA267A5480FF50581D2A8EE745", hash_generated_field = "6B12798A8293494A9A5448AEA6533D12")

    private static final int TRANSFORM_MASK = TRANSLATION_X | TRANSLATION_Y | SCALE_X | SCALE_Y |
            ROTATION | ROTATION_X | ROTATION_Y | X | Y;
}

