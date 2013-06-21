package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    long mStartTime;
    long mSeekTime = -1;
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
    private int mRepeatCount = 0;
    private int mRepeatMode = RESTART;
    private TimeInterpolator mInterpolator = sDefaultInterpolator;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.618 -0400", hash_original_method = "17A6701FB198CD0BD584AB7A0EFE3839", hash_generated_method = "1E0F7AE0C295B96E8122202378305CF8")
    @DSModeled(DSC.SAFE)
    public ValueAnimator() {
        // ---------- Original Method ----------
    }

    
        public static ValueAnimator ofInt(int... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setIntValues(values);
        return anim;
    }

    
        public static ValueAnimator ofFloat(float... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setFloatValues(values);
        return anim;
    }

    
        public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setValues(values);
        return anim;
    }

    
        public static ValueAnimator ofObject(TypeEvaluator evaluator, Object... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.620 -0400", hash_original_method = "67525E8968A6999074D725B8947CD2FE", hash_generated_method = "AD2A5EEE91826E2946FABEB057A696E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIntValues(int... values) {
        dsTaint.addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.630 -0400", hash_original_method = "D733778AA31410A94B9571EEAAECBB30", hash_generated_method = "3F4EF6FD606A9AB49B87FAB29995F115")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFloatValues(float... values) {
        dsTaint.addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.633 -0400", hash_original_method = "AAE460ECCCBF6E694CF45A2F7BA85BA5", hash_generated_method = "38C6E1FB9B536205EF0765A645D386FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.636 -0400", hash_original_method = "D9E3FD9EEAA02CD647DC7AEFD5007E3A", hash_generated_method = "644DB2FAA9865750E2339E0B7AC00F7F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.637 -0400", hash_original_method = "78A6AA7AD01513781B120BCE5DC9E156", hash_generated_method = "D4BC7893ACAE7D01FF34950446E67D40")
    @DSModeled(DSC.SAFE)
    public PropertyValuesHolder[] getValues() {
        return (PropertyValuesHolder[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.638 -0400", hash_original_method = "1534ECD6905850E5B269582384A75673", hash_generated_method = "6BBF6129DA30B7815375213690CEA17F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.639 -0400", hash_original_method = "622DE942E3334D786E7FE8DBF49B30DE", hash_generated_method = "122E222B82B68419D2B8061160EA19ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.654 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "7393246166219F841D7208D2C30FC7B2")
    @DSModeled(DSC.SAFE)
    public long getDuration() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.656 -0400", hash_original_method = "9366966ECC70650E5B5651EBD3539ED0", hash_generated_method = "809C8587526104BFE2A293A706868A12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.657 -0400", hash_original_method = "68655250B160F78BB8C6212DC5765131", hash_generated_method = "8E7AC5BCF53C5F3823A05D10D7EBBF07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getCurrentPlayTime() {
        long var6F61F9B0364A4D245BC9CF0ACBEF5BEE_2057880036 = (AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (!mInitialized || mPlayingState == STOPPED) {
            //return 0;
        //}
        //return AnimationUtils.currentAnimationTimeMillis() - mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.657 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "DCC8A41DC39050FC76AE059D731C084A")
    @DSModeled(DSC.SAFE)
    public long getStartDelay() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.658 -0400", hash_original_method = "84D20D1DEBEAE9C7FDE98EA5D287F4D2", hash_generated_method = "1670B41AB59B29578C0BDC8F06276F0C")
    @DSModeled(DSC.SAFE)
    public void setStartDelay(long startDelay) {
        dsTaint.addTaint(startDelay);
        // ---------- Original Method ----------
        //this.mStartDelay = startDelay;
    }

    
        public static long getFrameDelay() {
        return sFrameDelay;
    }

    
        public static void setFrameDelay(long frameDelay) {
        sFrameDelay = frameDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.663 -0400", hash_original_method = "3CBE561BBB42AB3DB3CAF9B67D05776D", hash_generated_method = "FBBD21A3600A687829CAD5B2AB047CA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getAnimatedValue() {
        {
            Object varD564D71966A41E36D69B9EB440DB6736_1737181234 = (mValues[0].getAnimatedValue());
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mValues != null && mValues.length > 0) {
            //return mValues[0].getAnimatedValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.665 -0400", hash_original_method = "2B530B2B81FC1FAD77C53EC8863AE50E", hash_generated_method = "E60BA3FF74591ACF25975120C456E882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getAnimatedValue(String propertyName) {
        dsTaint.addTaint(propertyName);
        PropertyValuesHolder valuesHolder;
        valuesHolder = mValuesMap.get(propertyName);
        {
            Object varF8F10DEBDDDCBED9F85C6570BFF4FCFC_1831216905 = (valuesHolder.getAnimatedValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.666 -0400", hash_original_method = "4F2FB0A315DAA7A8B07A49F4FCE27399", hash_generated_method = "01AB51CB23146039A67945D47AB2EC2B")
    @DSModeled(DSC.SAFE)
    public void setRepeatCount(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //mRepeatCount = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.668 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "85EC6C9DB83FC4FA5B74CCFA57CA19CC")
    @DSModeled(DSC.SAFE)
    public int getRepeatCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.669 -0400", hash_original_method = "C33D7F87842C98944308EC1438B3A8A7", hash_generated_method = "148DB7D9C321EDD011CE67ACC667FE82")
    @DSModeled(DSC.SAFE)
    public void setRepeatMode(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //mRepeatMode = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.670 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "6624FE6A716E0D15AACB0C3B82E99B42")
    @DSModeled(DSC.SAFE)
    public int getRepeatMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.670 -0400", hash_original_method = "D2A8BFD752ECF80FCD3BD03F5B9AF68A", hash_generated_method = "9EE5E9C3811CF86254B903F90F71A81E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.671 -0400", hash_original_method = "ABC42C9D08D6EB9E3E04E4FD12636CA0", hash_generated_method = "C442C719649EE8FF274F608780F8CCA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.672 -0400", hash_original_method = "E6D135867EE130F9CB4EA2C9507FABF5", hash_generated_method = "F72B4B62F641A364EF5E44F03D87BAD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mUpdateListeners.remove(listener);
        {
            boolean varA4B084E767DE55BA6AFD2DEBEB0A7784_480947544 = (mUpdateListeners.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.673 -0400", hash_original_method = "AF77FCDF6C80D02141639AFD7587863F", hash_generated_method = "874167BCE423F067C07C71347EC2AC22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.674 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "3D7C5E61728E00CFB484A2D5B90535DE")
    @DSModeled(DSC.SAFE)
    public TimeInterpolator getInterpolator() {
        return (TimeInterpolator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.675 -0400", hash_original_method = "BC30F1B6BC4F20E2E98ADFB4EC800F88", hash_generated_method = "0967CD1C7F83FDF59EF7A8F2F4EE2596")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.692 -0400", hash_original_method = "4B39A931455D340382CCAC7898FAB8D3", hash_generated_method = "DE6E50F38D793DB9A26513D7318DEC85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void start(boolean playBackwards) {
        dsTaint.addTaint(playBackwards);
        {
            boolean var607F99F94A9C3E729CF05A4C4A58ABDF_1175244353 = (Looper.myLooper() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.694 -0400", hash_original_method = "0E699EAEE0E759B00B92DBAE6A0AB7E1", hash_generated_method = "CF8459FD9743EB11F57C1D75490D5091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void start() {
        start(false);
        // ---------- Original Method ----------
        //start(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.726 -0400", hash_original_method = "5EC046ABFAD295E5D2C88DB1426702CD", hash_generated_method = "2346E334C3EA4EC279EF249F28CA9DF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void cancel() {
        {
            boolean var58486F75E12966B52474E15F32795998_1526836896 = (mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                sDelayedAnims.get().contains(this));
            {
                {
                    ArrayList<AnimatorListener> tmpListeners;
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_903173234 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_903173234.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_903173234.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.728 -0400", hash_original_method = "55C31F194BE33B60E19FAC66D36F0F3B", hash_generated_method = "ED6721C260A64EEFE455C00D7D5CE8DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void end() {
        {
            boolean var421E56E1FD921FD2A83C6EC630885000_1887369697 = (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.729 -0400", hash_original_method = "80FBC5A625B4BAB80C578CF39CB5DA5B", hash_generated_method = "89D95CCB6EAB0EDACAC61B97152CD3A4")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isRunning() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPlayingState == RUNNING || mRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.730 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "18F903773E382D89BF9EEA19FD1903C0")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.731 -0400", hash_original_method = "45B2842BAB0EB46941DD63C0EA48CBA2", hash_generated_method = "8464325B96E1EFED68EC2B8D5E769DF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.732 -0400", hash_original_method = "634DE70818167FA9FFDD8CDDE693BD3B", hash_generated_method = "2EB139BF48A4C75A3B726709B4DB7799")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.734 -0400", hash_original_method = "45B9B57EC5A2CFD523C0E84592BD9EAC", hash_generated_method = "F8618324A6C1947DE7C36EAA7950B157")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.735 -0400", hash_original_method = "33DF90BAA846BB88E01B9C85165D068C", hash_generated_method = "FEAC614A6D48693C44205D3A2F983AD6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.747 -0400", hash_original_method = "101420F61878798EE86197F974BCAB89", hash_generated_method = "352C1D5B370701106C5AEEFC532D8B3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean animationFrame(long currentTime) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.749 -0400", hash_original_method = "7C3735DD08F0E37DA76BAA97A1C3802E", hash_generated_method = "B8CD76F446A539F10EBAE4C8E121921A")
    @DSModeled(DSC.SAFE)
    public float getAnimatedFraction() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCurrentFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.754 -0400", hash_original_method = "64FBD5BD2598ED0D273DFF76320B41E6", hash_generated_method = "B010909EA21BF05A400178E9D0EC9567")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.760 -0400", hash_original_method = "E24942BE7DE3A089D4AA1F8054FFC13E", hash_generated_method = "5D5D045AF96239AE249F12471F76C92D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ValueAnimator clone() {
        ValueAnimator anim;
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

    
        public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

    
        public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.763 -0400", hash_original_method = "533F41B1624628F4A2CEF95F44B8AA6B", hash_generated_method = "9A76AB63A0F49EE0E1CEB15816DA3C97")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.764 -0400", hash_original_method = "938F92B24F6334DD78B5F967FF420102", hash_generated_method = "938F92B24F6334DD78B5F967FF420102")
                public AnimationHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.781 -0400", hash_original_method = "52F201F0F7E1BD7680ACD711BB668600", hash_generated_method = "153702AE50CA894AFEF745211D520227")
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
                boolean varA1F5D09ABD5BA1EAA9064BD2C7F540A0_221051982 = (animations.size() > 0 || delayedAnims.size() > 0);
                {
                    callAgain = false;
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_START 
            //Begin case ANIMATION_START 
            {
                boolean var310842A70C8547E073B963714355E2EF_712397327 = (pendingAnimations.size() > 0);
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
                        boolean var5A6A4AC41707EA57AE87A5C33A49358D_1819455049 = (anim.delayedAnimationFrame(currentTime));
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
                    boolean varB2157FB20628670967962D499113FAB2_105134667 = (anim.animationFrame(currentTime));
                    {
                        endingAnims.add(anim);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varB2E9B25FC12B68A819E499BFA350E9C9_1299185844 = (animations.size() == numAnims);
                    {
                        endingAnims.remove(anim);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                boolean var24F884196EA732DACEFF40751A202210_1622922273 = (endingAnims.size() > 0);
                {
                    {
                        i = 0;
                        boolean var680A26EFE24B5CA3CBE89BBC9415413A_495254246 = (i < endingAnims.size());
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
                boolean var8A9BF7DDA394FFB721509F4D19C0EAE3_2052759176 = (callAgain && (!animations.isEmpty() || !delayedAnims.isEmpty()));
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
    
    private static final long DEFAULT_FRAME_DELAY = 10;
    static final int ANIMATION_START = 0;
    static final int ANIMATION_FRAME = 1;
    static final int STOPPED    = 0;
    static final int RUNNING    = 1;
    static final int SEEKED     = 2;
    private static ThreadLocal<AnimationHandler> sAnimationHandler =
            new ThreadLocal<AnimationHandler>();
    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.784 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "ABF19C9B350F0C0FFA9D7ECC0570AAC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> var334ACA1B8CF9CFC30CEC06F4F91C2874_1872913510 = (new ArrayList<ValueAnimator>());
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.786 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "3FB7DF1BB5BA87E0A3CC99A1546A7DA6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> var334ACA1B8CF9CFC30CEC06F4F91C2874_1810293093 = (new ArrayList<ValueAnimator>());
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.787 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "E9AB09C4B4C7ADDA62B01EC9D5E1A39B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> var334ACA1B8CF9CFC30CEC06F4F91C2874_1466589325 = (new ArrayList<ValueAnimator>());
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.789 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "61880F66936CC4AE173FC6925CD173EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> var334ACA1B8CF9CFC30CEC06F4F91C2874_1213384985 = (new ArrayList<ValueAnimator>());
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:33.791 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "C9D41CB28677FAA9108E65A48B62D424")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> var334ACA1B8CF9CFC30CEC06F4F91C2874_516946626 = (new ArrayList<ValueAnimator>());
            return (ArrayList<ValueAnimator>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
}; //Transformed anonymous class
    private static final TimeInterpolator sDefaultInterpolator =
            new AccelerateDecelerateInterpolator();
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static long sFrameDelay = DEFAULT_FRAME_DELAY;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int INFINITE = -1;
}

