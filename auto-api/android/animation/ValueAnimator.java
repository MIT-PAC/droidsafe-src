package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;

public class ValueAnimator extends Animator {
    private static final long DEFAULT_FRAME_DELAY = 10;
    static final int ANIMATION_START = 0;
    static final int ANIMATION_FRAME = 1;
    static final int STOPPED    = 0;
    static final int RUNNING    = 1;
    static final int SEEKED     = 2;
    long mStartTime;
    long mSeekTime = -1;
    private static ThreadLocal<AnimationHandler> sAnimationHandler =
            new ThreadLocal<AnimationHandler>();
    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.305 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "969F196C59899D1C78758187D0ACAB67")
        @DSModeled(DSC.SAFE)
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.305 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "969F196C59899D1C78758187D0ACAB67")
        @DSModeled(DSC.SAFE)
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.306 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "969F196C59899D1C78758187D0ACAB67")
        @DSModeled(DSC.SAFE)
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.306 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "969F196C59899D1C78758187D0ACAB67")
        @DSModeled(DSC.SAFE)
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.307 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "969F196C59899D1C78758187D0ACAB67")
        @DSModeled(DSC.SAFE)
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final TimeInterpolator sDefaultInterpolator =
            new AccelerateDecelerateInterpolator();
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private boolean mPlayingBackwards = false;
    private int mCurrentIteration = 0;
    private float mCurrentFraction = 0f;
    private boolean mStartedDelay = false;
    private long mDelayStartTime;
    int mPlayingState = STOPPED;
    private boolean mRunning = false;
    private boolean mStarted = false;
    boolean mInitialized = false;
    private long mDuration = 300;
    private long mStartDelay = 0;
    private static long sFrameDelay = DEFAULT_FRAME_DELAY;
    private int mRepeatCount = 0;
    private int mRepeatMode = RESTART;
    private TimeInterpolator mInterpolator = sDefaultInterpolator;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int INFINITE = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.307 -0400", hash_original_method = "17A6701FB198CD0BD584AB7A0EFE3839", hash_generated_method = "E65FDCBA053E4EB12D97A5723D458913")
    @DSModeled(DSC.SAFE)
    public ValueAnimator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.308 -0400", hash_original_method = "0DB2B6138C09D648DCDA3E0EA457B413", hash_generated_method = "4C26E70DF465B1826442D3E3B94156A0")
    public static ValueAnimator ofInt(int... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setIntValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.308 -0400", hash_original_method = "C4FFEB9A73183FF46069B22DD458EE60", hash_generated_method = "54582EF16FD6B94475134F0A1BB24BFC")
    public static ValueAnimator ofFloat(float... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setFloatValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.309 -0400", hash_original_method = "204F86E20904258FB3AF1D137E9288A5", hash_generated_method = "6E8699C82E7F2CDE74F47D459770BABF")
    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.309 -0400", hash_original_method = "60BE2A1025CE989C6F6A7DB4305B45F3", hash_generated_method = "2AABC3A1DAD8ACCAAD04FDBA2B50845E")
    public static ValueAnimator ofObject(TypeEvaluator evaluator, Object... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.310 -0400", hash_original_method = "67525E8968A6999074D725B8947CD2FE", hash_generated_method = "3FD717BB3405138A0C093854BD314438")
    @DSModeled(DSC.SAFE)
    public void setIntValues(int... values) {
        dsTaint.addTaint(values);
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("", values)});
        } //End block
        {
            PropertyValuesHolder valuesHolder;
            valuesHolder = mValues[0];
            valuesHolder.setIntValues(values);
        } //End block
        mInitialized = false;
        // ---------- Original Method ----------
        //if (values == null || values.length == 0) {
            //return;
        //}
        //if (mValues == null || mValues.length == 0) {
            //setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("", values)});
        //} else {
            //PropertyValuesHolder valuesHolder = mValues[0];
            //valuesHolder.setIntValues(values);
        //}
        //mInitialized = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.321 -0400", hash_original_method = "D733778AA31410A94B9571EEAAECBB30", hash_generated_method = "65AF15FC04332C8AB965F4472F6AADC5")
    @DSModeled(DSC.SAFE)
    public void setFloatValues(float... values) {
        dsTaint.addTaint(values);
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("", values)});
        } //End block
        {
            PropertyValuesHolder valuesHolder;
            valuesHolder = mValues[0];
            valuesHolder.setFloatValues(values);
        } //End block
        mInitialized = false;
        // ---------- Original Method ----------
        //if (values == null || values.length == 0) {
            //return;
        //}
        //if (mValues == null || mValues.length == 0) {
            //setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("", values)});
        //} else {
            //PropertyValuesHolder valuesHolder = mValues[0];
            //valuesHolder.setFloatValues(values);
        //}
        //mInitialized = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.322 -0400", hash_original_method = "AAE460ECCCBF6E694CF45A2F7BA85BA5", hash_generated_method = "41C28254B5B186994BC65120CBC02A11")
    @DSModeled(DSC.SAFE)
    public void setObjectValues(Object... values) {
        dsTaint.addTaint(values[0].dsTaint);
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofObject("",
                    (TypeEvaluator)null, values)});
        } //End block
        {
            PropertyValuesHolder valuesHolder;
            valuesHolder = mValues[0];
            valuesHolder.setObjectValues(values);
        } //End block
        mInitialized = false;
        // ---------- Original Method ----------
        //if (values == null || values.length == 0) {
            //return;
        //}
        //if (mValues == null || mValues.length == 0) {
            //setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofObject("",
                    //(TypeEvaluator)null, values)});
        //} else {
            //PropertyValuesHolder valuesHolder = mValues[0];
            //valuesHolder.setObjectValues(values);
        //}
        //mInitialized = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.323 -0400", hash_original_method = "D9E3FD9EEAA02CD647DC7AEFD5007E3A", hash_generated_method = "A6CDE334A43BDD2266EFDA4A982506C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValues(PropertyValuesHolder... values) {
        dsTaint.addTaint(values[0].dsTaint);
        int numValues;
        numValues = values.length;
        mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
        {
            int i;
            i = 0;
            {
                PropertyValuesHolder valuesHolder;
                valuesHolder = (PropertyValuesHolder) values[i];
                mValuesMap.put(valuesHolder.getPropertyName(), valuesHolder);
            } //End block
        } //End collapsed parenthetic
        mInitialized = false;
        // ---------- Original Method ----------
        //int numValues = values.length;
        //mValues = values;
        //mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
        //for (int i = 0; i < numValues; ++i) {
            //PropertyValuesHolder valuesHolder = (PropertyValuesHolder) values[i];
            //mValuesMap.put(valuesHolder.getPropertyName(), valuesHolder);
        //}
        //mInitialized = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.324 -0400", hash_original_method = "78A6AA7AD01513781B120BCE5DC9E156", hash_generated_method = "79161DCFF8C97D334FA13DD40AA55DCB")
    @DSModeled(DSC.SAFE)
    public PropertyValuesHolder[] getValues() {
        return (PropertyValuesHolder[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.324 -0400", hash_original_method = "1534ECD6905850E5B269582384A75673", hash_generated_method = "A5E683069FCEC2340A3BAFF882473387")
    @DSModeled(DSC.SAFE)
     void initAnimation() {
        {
            int numValues;
            numValues = mValues.length;
            {
                int i;
                i = 0;
                {
                    mValues[i].init();
                } //End block
            } //End collapsed parenthetic
            mInitialized = true;
        } //End block
        // ---------- Original Method ----------
        //if (!mInitialized) {
            //int numValues = mValues.length;
            //for (int i = 0; i < numValues; ++i) {
                //mValues[i].init();
            //}
            //mInitialized = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.325 -0400", hash_original_method = "622DE942E3334D786E7FE8DBF49B30DE", hash_generated_method = "B0E40B5709CAD610027D47FE602A074A")
    @DSModeled(DSC.SAFE)
    public ValueAnimator setDuration(long duration) {
        dsTaint.addTaint(duration);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
        } //End block
        return (ValueAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDuration = duration;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.325 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "CC1748C13DCF52AEDCB67D067F246B6A")
    @DSModeled(DSC.SAFE)
    public long getDuration() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.326 -0400", hash_original_method = "9366966ECC70650E5B5651EBD3539ED0", hash_generated_method = "04918AAD3BBA2D2C994A15D3F66E45FA")
    @DSModeled(DSC.SAFE)
    public void setCurrentPlayTime(long playTime) {
        dsTaint.addTaint(playTime);
        initAnimation();
        long currentTime;
        currentTime = AnimationUtils.currentAnimationTimeMillis();
        {
            mPlayingState = SEEKED;
        } //End block
        mStartTime = currentTime - playTime;
        animationFrame(currentTime);
        // ---------- Original Method ----------
        //initAnimation();
        //long currentTime = AnimationUtils.currentAnimationTimeMillis();
        //if (mPlayingState != RUNNING) {
            //mSeekTime = playTime;
            //mPlayingState = SEEKED;
        //}
        //mStartTime = currentTime - playTime;
        //animationFrame(currentTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.327 -0400", hash_original_method = "68655250B160F78BB8C6212DC5765131", hash_generated_method = "B9B8550AC73A2A859AC99CD1E7AF8C62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getCurrentPlayTime() {
        long var6F61F9B0364A4D245BC9CF0ACBEF5BEE_1603371522 = (AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (!mInitialized || mPlayingState == STOPPED) {
            //return 0;
        //}
        //return AnimationUtils.currentAnimationTimeMillis() - mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.327 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "D9BA2F1A7EB03D6F1CF0F91602BE4228")
    @DSModeled(DSC.SAFE)
    public long getStartDelay() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.328 -0400", hash_original_method = "84D20D1DEBEAE9C7FDE98EA5D287F4D2", hash_generated_method = "0AB76B360111B0F0FEC00D48BCAC39C6")
    @DSModeled(DSC.SAFE)
    public void setStartDelay(long startDelay) {
        dsTaint.addTaint(startDelay);
        // ---------- Original Method ----------
        //this.mStartDelay = startDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.328 -0400", hash_original_method = "07F990A9818D41589C4C2DC1FA0032A4", hash_generated_method = "2E8CE722FBAD7FDECF44ADD41AB08358")
    public static long getFrameDelay() {
        return sFrameDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.328 -0400", hash_original_method = "56E659663FF9E21EC6A56D4CA3D996C8", hash_generated_method = "8B1F52E4B1315ECE809AFB72E1A30C96")
    public static void setFrameDelay(long frameDelay) {
        sFrameDelay = frameDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.329 -0400", hash_original_method = "3CBE561BBB42AB3DB3CAF9B67D05776D", hash_generated_method = "82F4055E001221E72EA11FA917E86429")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getAnimatedValue() {
        {
            Object varD564D71966A41E36D69B9EB440DB6736_404393162 = (mValues[0].getAnimatedValue());
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mValues != null && mValues.length > 0) {
            //return mValues[0].getAnimatedValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.330 -0400", hash_original_method = "2B530B2B81FC1FAD77C53EC8863AE50E", hash_generated_method = "374DCE2C24EC90EE668846989B436601")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getAnimatedValue(String propertyName) {
        dsTaint.addTaint(propertyName);
        PropertyValuesHolder valuesHolder;
        valuesHolder = mValuesMap.get(propertyName);
        {
            Object varF8F10DEBDDDCBED9F85C6570BFF4FCFC_165235275 = (valuesHolder.getAnimatedValue());
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PropertyValuesHolder valuesHolder = mValuesMap.get(propertyName);
        //if (valuesHolder != null) {
            //return valuesHolder.getAnimatedValue();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.330 -0400", hash_original_method = "4F2FB0A315DAA7A8B07A49F4FCE27399", hash_generated_method = "AFF1D02FC8F118E1FE581728AC93DE89")
    @DSModeled(DSC.SAFE)
    public void setRepeatCount(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //mRepeatCount = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.331 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "53F7F4F4884825675C175C68ADA5AA45")
    @DSModeled(DSC.SAFE)
    public int getRepeatCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.332 -0400", hash_original_method = "C33D7F87842C98944308EC1438B3A8A7", hash_generated_method = "064B5723283E7305B3B06DD9478CE25F")
    @DSModeled(DSC.SAFE)
    public void setRepeatMode(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //mRepeatMode = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.333 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "CD811FE5C081CE38D3580811FC20E9F1")
    @DSModeled(DSC.SAFE)
    public int getRepeatMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.333 -0400", hash_original_method = "D2A8BFD752ECF80FCD3BD03F5B9AF68A", hash_generated_method = "5CC50148DAB2A0DB4B9E1F0EB8107B7F")
    @DSModeled(DSC.SAFE)
    public void addUpdateListener(AnimatorUpdateListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
        } //End block
        mUpdateListeners.add(listener);
        // ---------- Original Method ----------
        //if (mUpdateListeners == null) {
            //mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
        //}
        //mUpdateListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.334 -0400", hash_original_method = "ABC42C9D08D6EB9E3E04E4FD12636CA0", hash_generated_method = "DEF047951C27C47DC2CB23E07B2CB305")
    @DSModeled(DSC.SAFE)
    public void removeAllUpdateListeners() {
        mUpdateListeners.clear();
        mUpdateListeners = null;
        // ---------- Original Method ----------
        //if (mUpdateListeners == null) {
            //return;
        //}
        //mUpdateListeners.clear();
        //mUpdateListeners = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.334 -0400", hash_original_method = "E6D135867EE130F9CB4EA2C9507FABF5", hash_generated_method = "BBE928AB6F3B3FE0AF0CC6AFD9D10734")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mUpdateListeners.remove(listener);
        {
            boolean varA4B084E767DE55BA6AFD2DEBEB0A7784_880031274 = (mUpdateListeners.size() == 0);
            {
                mUpdateListeners = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mUpdateListeners == null) {
            //return;
        //}
        //mUpdateListeners.remove(listener);
        //if (mUpdateListeners.size() == 0) {
            //mUpdateListeners = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.335 -0400", hash_original_method = "AF77FCDF6C80D02141639AFD7587863F", hash_generated_method = "1FF07448C0C9FB639B9A92CB3907391A")
    @DSModeled(DSC.SAFE)
    @Override
    public void setInterpolator(TimeInterpolator value) {
        dsTaint.addTaint(value.dsTaint);
        {
            mInterpolator = new LinearInterpolator();
        } //End block
        // ---------- Original Method ----------
        //if (value != null) {
            //mInterpolator = value;
        //} else {
            //mInterpolator = new LinearInterpolator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.336 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "037DBFD4D3B9E6B777207F66A57911DC")
    @DSModeled(DSC.SAFE)
    public TimeInterpolator getInterpolator() {
        return (TimeInterpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.336 -0400", hash_original_method = "BC30F1B6BC4F20E2E98ADFB4EC800F88", hash_generated_method = "DFE39CC1252EB9748198BFDC564339FD")
    @DSModeled(DSC.SAFE)
    public void setEvaluator(TypeEvaluator value) {
        dsTaint.addTaint(value.dsTaint);
        {
            mValues[0].setEvaluator(value);
        } //End block
        // ---------- Original Method ----------
        //if (value != null && mValues != null && mValues.length > 0) {
            //mValues[0].setEvaluator(value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.338 -0400", hash_original_method = "4B39A931455D340382CCAC7898FAB8D3", hash_generated_method = "1EC4F8F7CCB55EB9C0E76EA9034B1A50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void start(boolean playBackwards) {
        dsTaint.addTaint(playBackwards);
        {
            boolean var607F99F94A9C3E729CF05A4C4A58ABDF_1261970585 = (Looper.myLooper() == null);
            {
            	if (DroidSafeAndroidRuntime.control) throw new AndroidRuntimeException("Animators may only be run on Looper threads");
            } //End block
        } //End collapsed parenthetic
        mCurrentIteration = 0;
        mPlayingState = STOPPED;
        mStarted = true;
        mStartedDelay = false;
        sPendingAnimations.get().add(this);
        {
            setCurrentPlayTime(getCurrentPlayTime());
            mPlayingState = STOPPED;
            mRunning = true;
            {
                ArrayList<AnimatorListener> tmpListeners;
                tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                int numListeners;
                numListeners = tmpListeners.size();
                {
                    int i;
                    i = 0;
                    {
                        tmpListeners.get(i).onAnimationStart(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        AnimationHandler animationHandler;
        animationHandler = sAnimationHandler.get();
        {
            animationHandler = new AnimationHandler();
            sAnimationHandler.set(animationHandler);
        } //End block
        animationHandler.sendEmptyMessage(ANIMATION_START);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.343 -0400", hash_original_method = "0E699EAEE0E759B00B92DBAE6A0AB7E1", hash_generated_method = "9629BBDE1D1B86C791E220C2AD8BF3D8")
    @DSModeled(DSC.SAFE)
    @Override
    public void start() {
        start(false);
        // ---------- Original Method ----------
        //start(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.346 -0400", hash_original_method = "5EC046ABFAD295E5D2C88DB1426702CD", hash_generated_method = "F74674E4E6A38F65F35A3B3EFB9D219D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void cancel() {
        {
            boolean var58486F75E12966B52474E15F32795998_1186535128 = (mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                sDelayedAnims.get().contains(this));
            {
                {
                    ArrayList<AnimatorListener> tmpListeners;
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> seatecAstronomy42 = tmpListeners.iterator();
                        seatecAstronomy42.hasNext();
                        AnimatorListener listener = seatecAstronomy42.next();
                        {
                            listener.onAnimationCancel(this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                endAnimation();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                //sDelayedAnims.get().contains(this)) {
            //if (mRunning && mListeners != null) {
                //ArrayList<AnimatorListener> tmpListeners =
                        //(ArrayList<AnimatorListener>) mListeners.clone();
                //for (AnimatorListener listener : tmpListeners) {
                    //listener.onAnimationCancel(this);
                //}
            //}
            //endAnimation();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.347 -0400", hash_original_method = "55C31F194BE33B60E19FAC66D36F0F3B", hash_generated_method = "CF199497398A64FAF9A74E316BDB3AA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void end() {
        {
            boolean var421E56E1FD921FD2A83C6EC630885000_1762753181 = (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this));
            {
                mStartedDelay = false;
                startAnimation();
            } //End block
            {
                initAnimation();
            } //End block
        } //End collapsed parenthetic
        {
            animateValue(0f);
        } //End block
        {
            animateValue(1f);
        } //End block
        endAnimation();
        // ---------- Original Method ----------
        //if (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this)) {
            //mStartedDelay = false;
            //startAnimation();
        //} else if (!mInitialized) {
            //initAnimation();
        //}
        //if (mRepeatCount > 0 && (mRepeatCount & 0x01) == 1) {
            //animateValue(0f);
        //} else {
            //animateValue(1f);
        //}
        //endAnimation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.348 -0400", hash_original_method = "80FBC5A625B4BAB80C578CF39CB5DA5B", hash_generated_method = "4B857D17A7980728A93FF57A5276AC15")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isRunning() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPlayingState == RUNNING || mRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.349 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "2F12445662AB59FE001C808F3C1B9BF9")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.350 -0400", hash_original_method = "45B2842BAB0EB46941DD63C0EA48CBA2", hash_generated_method = "021E2CE4995228BBE1097DD25A37461D")
    @DSModeled(DSC.SAFE)
    public void reverse() {
        mPlayingBackwards = !mPlayingBackwards;
        {
            long currentTime;
            currentTime = AnimationUtils.currentAnimationTimeMillis();
            long currentPlayTime;
            currentPlayTime = currentTime - mStartTime;
            long timeLeft;
            timeLeft = mDuration - currentPlayTime;
            mStartTime = currentTime - timeLeft;
        } //End block
        {
            start(true);
        } //End block
        // ---------- Original Method ----------
        //mPlayingBackwards = !mPlayingBackwards;
        //if (mPlayingState == RUNNING) {
            //long currentTime = AnimationUtils.currentAnimationTimeMillis();
            //long currentPlayTime = currentTime - mStartTime;
            //long timeLeft = mDuration - currentPlayTime;
            //mStartTime = currentTime - timeLeft;
        //} else {
            //start(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.351 -0400", hash_original_method = "634DE70818167FA9FFDD8CDDE693BD3B", hash_generated_method = "0E546C01A8F60F7DD1BCD4986B8BC057")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void endAnimation() {
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        mPlayingState = STOPPED;
        {
            ArrayList<AnimatorListener> tmpListeners;
            tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners;
            numListeners = tmpListeners.size();
            {
                int i;
                i = 0;
                {
                    tmpListeners.get(i).onAnimationEnd(this);
                } //End block
            } //End collapsed parenthetic
        } //End block
        mRunning = false;
        mStarted = false;
        // ---------- Original Method ----------
        //sAnimations.get().remove(this);
        //sPendingAnimations.get().remove(this);
        //sDelayedAnims.get().remove(this);
        //mPlayingState = STOPPED;
        //if (mRunning && mListeners != null) {
            //ArrayList<AnimatorListener> tmpListeners =
                    //(ArrayList<AnimatorListener>) mListeners.clone();
            //int numListeners = tmpListeners.size();
            //for (int i = 0; i < numListeners; ++i) {
                //tmpListeners.get(i).onAnimationEnd(this);
            //}
        //}
        //mRunning = false;
        //mStarted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.352 -0400", hash_original_method = "45B9B57EC5A2CFD523C0E84592BD9EAC", hash_generated_method = "D17A43C14AF94F06F15993E0B28BF175")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startAnimation() {
        initAnimation();
        sAnimations.get().add(this);
        {
            ArrayList<AnimatorListener> tmpListeners;
            tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners;
            numListeners = tmpListeners.size();
            {
                int i;
                i = 0;
                {
                    tmpListeners.get(i).onAnimationStart(this);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //initAnimation();
        //sAnimations.get().add(this);
        //if (mStartDelay > 0 && mListeners != null) {
            //ArrayList<AnimatorListener> tmpListeners =
                    //(ArrayList<AnimatorListener>) mListeners.clone();
            //int numListeners = tmpListeners.size();
            //for (int i = 0; i < numListeners; ++i) {
                //tmpListeners.get(i).onAnimationStart(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.353 -0400", hash_original_method = "33DF90BAA846BB88E01B9C85165D068C", hash_generated_method = "761B7B111540AA15EDBCA60C487B5B3D")
    @DSModeled(DSC.SAFE)
    private boolean delayedAnimationFrame(long currentTime) {
        dsTaint.addTaint(currentTime);
        {
            mStartedDelay = true;
        } //End block
        {
            long deltaTime;
            deltaTime = currentTime - mDelayStartTime;
            {
                mStartTime = currentTime - (deltaTime - mStartDelay);
                mPlayingState = RUNNING;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!mStartedDelay) {
            //mStartedDelay = true;
            //mDelayStartTime = currentTime;
        //} else {
            //long deltaTime = currentTime - mDelayStartTime;
            //if (deltaTime > mStartDelay) {
                //mStartTime = currentTime - (deltaTime - mStartDelay);
                //mPlayingState = RUNNING;
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.356 -0400", hash_original_method = "101420F61878798EE86197F974BCAB89", hash_generated_method = "16E4643436AE252A65D6F54426540E03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean animationFrame(long currentTime) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(currentTime);
        boolean done;
        done = false;
        {
            mPlayingState = RUNNING;
            {
                mStartTime = currentTime - mSeekTime;
                mSeekTime = -1;
            } //End block
        } //End block
        //Begin case RUNNING SEEKED 
        float fraction;
        fraction = (float)(currentTime - mStartTime) / mDuration;
        fraction = 1f;
        //End case RUNNING SEEKED 
        //Begin case RUNNING SEEKED 
        {
            {
                {
                    int numListeners;
                    numListeners = mListeners.size();
                    {
                        int i;
                        i = 0;
                        {
                            mListeners.get(i).onAnimationRepeat(this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mPlayingBackwards = mPlayingBackwards ? false : true;
                } //End block
                mCurrentIteration += (int)fraction;
                fraction = fraction % 1f;
                mStartTime += mDuration;
            } //End block
            {
                done = true;
                fraction = Math.min(fraction, 1.0f);
            } //End block
        } //End block
        //End case RUNNING SEEKED 
        //Begin case RUNNING SEEKED 
        {
            fraction = 1f - fraction;
        } //End block
        //End case RUNNING SEEKED 
        //Begin case RUNNING SEEKED 
        animateValue(fraction);
        //End case RUNNING SEEKED 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.357 -0400", hash_original_method = "7C3735DD08F0E37DA76BAA97A1C3802E", hash_generated_method = "6F133668AEEB58E2D01E24D054D8F77E")
    @DSModeled(DSC.SAFE)
    public float getAnimatedFraction() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCurrentFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.358 -0400", hash_original_method = "64FBD5BD2598ED0D273DFF76320B41E6", hash_generated_method = "2CF234DDCF4454FC466EE29D5394FD23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void animateValue(float fraction) {
        dsTaint.addTaint(fraction);
        fraction = mInterpolator.getInterpolation(fraction);
        int numValues;
        numValues = mValues.length;
        {
            int i;
            i = 0;
            {
                mValues[i].calculateValue(fraction);
            } //End block
        } //End collapsed parenthetic
        {
            int numListeners;
            numListeners = mUpdateListeners.size();
            {
                int i;
                i = 0;
                {
                    mUpdateListeners.get(i).onAnimationUpdate(this);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //fraction = mInterpolator.getInterpolation(fraction);
        //mCurrentFraction = fraction;
        //int numValues = mValues.length;
        //for (int i = 0; i < numValues; ++i) {
            //mValues[i].calculateValue(fraction);
        //}
        //if (mUpdateListeners != null) {
            //int numListeners = mUpdateListeners.size();
            //for (int i = 0; i < numListeners; ++i) {
                //mUpdateListeners.get(i).onAnimationUpdate(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.360 -0400", hash_original_method = "E24942BE7DE3A089D4AA1F8054FFC13E", hash_generated_method = "F8AD58F0716A22B11F805F64CFAAA3B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ValueAnimator clone() {
        final ValueAnimator anim;
        anim = (ValueAnimator) super.clone();
        {
            ArrayList<AnimatorUpdateListener> oldListeners;
            oldListeners = mUpdateListeners;
            anim.mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
            int numListeners;
            numListeners = oldListeners.size();
            {
                int i;
                i = 0;
                {
                    anim.mUpdateListeners.add(oldListeners.get(i));
                } //End block
            } //End collapsed parenthetic
        } //End block
        anim.mSeekTime = -1;
        anim.mPlayingBackwards = false;
        anim.mCurrentIteration = 0;
        anim.mInitialized = false;
        anim.mPlayingState = STOPPED;
        anim.mStartedDelay = false;
        PropertyValuesHolder[] oldValues;
        oldValues = mValues;
        {
            int numValues;
            numValues = oldValues.length;
            anim.mValues = new PropertyValuesHolder[numValues];
            anim.mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
            {
                int i;
                i = 0;
                {
                    PropertyValuesHolder newValuesHolder;
                    newValuesHolder = oldValues[i].clone();
                    anim.mValues[i] = newValuesHolder;
                    anim.mValuesMap.put(newValuesHolder.getPropertyName(), newValuesHolder);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ValueAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.361 -0400", hash_original_method = "7292715E4E63D06F016EF86B523F3E45", hash_generated_method = "6CA1D9064E9F73A210D3A416401BE832")
    @DSModeled(DSC.SAFE)
    public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.362 -0400", hash_original_method = "72C0DFB579BB865DD3F3D703467E9444", hash_generated_method = "2E51028D92E8F3A72156331AC158B579")
    public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.363 -0400", hash_original_method = "533F41B1624628F4A2CEF95F44B8AA6B", hash_generated_method = "CB7DA2E39F37DC209ED946FB3A6753E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String returnVal;
        returnVal = "ValueAnimator@" + Integer.toHexString(hashCode());
        {
            {
                int i;
                i = 0;
                {
                    returnVal += "\n    " + mValues[i].toString();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String returnVal = "ValueAnimator@" + Integer.toHexString(hashCode());
        //if (mValues != null) {
            //for (int i = 0; i < mValues.length; ++i) {
                //returnVal += "\n    " + mValues[i].toString();
            //}
        //}
        //return returnVal;
    }

    
    private static class AnimationHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.376 -0400", hash_original_method = "52F201F0F7E1BD7680ACD711BB668600", hash_generated_method = "26EDC5BA1EACBF895D784DBE7ED4AFD1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            boolean callAgain;
            callAgain = true;
            ArrayList<ValueAnimator> animations;
            animations = sAnimations.get();
            ArrayList<ValueAnimator> delayedAnims;
            delayedAnims = sDelayedAnims.get();
            //Begin case ANIMATION_START 
            ArrayList<ValueAnimator> pendingAnimations;
            pendingAnimations = sPendingAnimations.get();
            //End case ANIMATION_START 
            //Begin case ANIMATION_START 
            {
                boolean varA1F5D09ABD5BA1EAA9064BD2C7F540A0_260941181 = (animations.size() > 0 || delayedAnims.size() > 0);
                {
                    callAgain = false;
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_START 
            //Begin case ANIMATION_START 
            {
                boolean var310842A70C8547E073B963714355E2EF_1051229414 = (pendingAnimations.size() > 0);
                {
                    ArrayList<ValueAnimator> pendingCopy;
                    pendingCopy = (ArrayList<ValueAnimator>) pendingAnimations.clone();
                    pendingAnimations.clear();
                    int count;
                    count = pendingCopy.size();
                    {
                        int i;
                        i = 0;
                        {
                            ValueAnimator anim;
                            anim = pendingCopy.get(i);
                            {
                                anim.startAnimation();
                            } //End block
                            {
                                delayedAnims.add(anim);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_START 
            //Begin case ANIMATION_FRAME 
            long currentTime;
            currentTime = AnimationUtils.currentAnimationTimeMillis();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            ArrayList<ValueAnimator> readyAnims;
            readyAnims = sReadyAnims.get();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            ArrayList<ValueAnimator> endingAnims;
            endingAnims = sEndingAnims.get();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            int numDelayedAnims;
            numDelayedAnims = delayedAnims.size();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                int i;
                i = 0;
                {
                    ValueAnimator anim;
                    anim = delayedAnims.get(i);
                    {
                        boolean var5A6A4AC41707EA57AE87A5C33A49358D_1010773333 = (anim.delayedAnimationFrame(currentTime));
                        {
                            readyAnims.add(anim);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            int numReadyAnims;
            numReadyAnims = readyAnims.size();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                {
                    int i;
                    i = 0;
                    {
                        ValueAnimator anim;
                        anim = readyAnims.get(i);
                        anim.startAnimation();
                        anim.mRunning = true;
                        delayedAnims.remove(anim);
                    } //End block
                } //End collapsed parenthetic
                readyAnims.clear();
            } //End block
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            int numAnims;
            numAnims = animations.size();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            int i;
            i = 0;
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                ValueAnimator anim;
                anim = animations.get(i);
                {
                    boolean varB2157FB20628670967962D499113FAB2_1082272108 = (anim.animationFrame(currentTime));
                    {
                        endingAnims.add(anim);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varB2E9B25FC12B68A819E499BFA350E9C9_1093614277 = (animations.size() == numAnims);
                    {
                        ++i;
                    } //End block
                    {
                        --numAnims;
                        endingAnims.remove(anim);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                boolean var24F884196EA732DACEFF40751A202210_319120133 = (endingAnims.size() > 0);
                {
                    {
                        i = 0;
                        boolean var680A26EFE24B5CA3CBE89BBC9415413A_1139736301 = (i < endingAnims.size());
                        {
                            endingAnims.get(i).endAnimation();
                        } //End block
                    } //End collapsed parenthetic
                    endingAnims.clear();
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                boolean var8A9BF7DDA394FFB721509F4D19C0EAE3_1711350443 = (callAgain && (!animations.isEmpty() || !delayedAnims.isEmpty()));
                {
                    sendEmptyMessageDelayed(ANIMATION_FRAME, Math.max(0, sFrameDelay -
                            (AnimationUtils.currentAnimationTimeMillis() - currentTime)));
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_FRAME 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static interface AnimatorUpdateListener {
        
        void onAnimationUpdate(ValueAnimator animation);

    }
    
}


