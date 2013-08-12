package android.animation;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;





public class ValueAnimator extends Animator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.958 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

    long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.959 -0400", hash_original_field = "21F0A5E67D578B871CE4890BB4301938", hash_generated_field = "4E1645CE3651AE4D866A4E97769672FC")

    long mSeekTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.960 -0400", hash_original_field = "C36D028293D9AEB21CE372B528F12B7D", hash_generated_field = "25D0DF5A7C1B0B40E8B3204C90423678")

    private boolean mPlayingBackwards = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.960 -0400", hash_original_field = "24FDF63EDEAC7BEE43B5C4C5591E8865", hash_generated_field = "4C9D53155FF73BA27011D6E7DB3AD10B")

    private int mCurrentIteration = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.961 -0400", hash_original_field = "C2F7E02BDA00B17A8F988AB57AA22BF9", hash_generated_field = "8A50A9EB094A19AFEFAE9DD764A21B61")

    private float mCurrentFraction = 0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.961 -0400", hash_original_field = "CC68149CDA21F68465AA90F07F5D95CC", hash_generated_field = "E6BC29DFE32B95A7746A3240D4908F49")

    private boolean mStartedDelay = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.962 -0400", hash_original_field = "4990509A1CCCA8D89E912983C67DFF20", hash_generated_field = "99C0D1839DB2E0976F6365DA96527AB3")

    private long mDelayStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.962 -0400", hash_original_field = "9950F1CC6304A23A1DF3E99C55CB4013", hash_generated_field = "8F8CC3CA50EF97884C628BBEA63AE150")

    int mPlayingState = STOPPED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.962 -0400", hash_original_field = "62A2DC3D8C5F735AB3A7DFD6D4A40243", hash_generated_field = "BF66F685C8DAD91C6D305A2AD45B0022")

    private boolean mRunning = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.963 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.963 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "D7228C282593CDC77734D668B23541D3")

    boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.963 -0400", hash_original_field = "278AF3A57BE580604E764F8A9A2B780D", hash_generated_field = "7C681C473ED41389A77BB70A2C4D72CE")

    private long mDuration = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.964 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.964 -0400", hash_original_field = "7400544E99BDB4AB399DABF03F346DE6", hash_generated_field = "86BE2F843C53DE337B277203FC4ABA75")

    private int mRepeatCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.965 -0400", hash_original_field = "31336EA85735F5B517DD430F87691118", hash_generated_field = "D8AE514964A82408D2EBFBBF132AAE13")

    private int mRepeatMode = RESTART;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.965 -0400", hash_original_field = "ED64FCC69138AB0D151E83CCFCFE975A", hash_generated_field = "42D7E84F8F4EF4F62C2A90763184E4DB")

    private TimeInterpolator mInterpolator = sDefaultInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.966 -0400", hash_original_field = "6141FE189AA3625489E2AE5CC67F512B", hash_generated_field = "413346BD5600531FF965862127DA0D01")

    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.966 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "E200C2BDFC70B9C579B8C490F170F688")

    PropertyValuesHolder[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.967 -0400", hash_original_field = "DEA90B16C4F0F78E79C71A2F9BB8975C", hash_generated_field = "AF5FC8A22004016791392366FC7AA458")

    HashMap<String, PropertyValuesHolder> mValuesMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.967 -0400", hash_original_method = "17A6701FB198CD0BD584AB7A0EFE3839", hash_generated_method = "1E0F7AE0C295B96E8122202378305CF8")
    @DSModeled(DSC.SAFE)
    public  ValueAnimator() {
        // ---------- Original Method ----------
    }

    
    public static ValueAnimator ofInt(int... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setIntValues(values);
        return anim;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.974 -0400", hash_original_method = "67525E8968A6999074D725B8947CD2FE", hash_generated_method = "840C50568D669C49D42DBBC4BD0B87A6")
    @DSModeled(DSC.SAFE)
    public void setIntValues(int... values) {
        addTaint(values[0]);
        if(values == null || values.length == 0)        
        {
            return;
        } //End block
        if(mValues == null || mValues.length == 0)        
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("", values)});
        } //End block
        else
        {
            PropertyValuesHolder valuesHolder = mValues[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.977 -0400", hash_original_method = "D733778AA31410A94B9571EEAAECBB30", hash_generated_method = "EC1BE9E5174C66E7E3C126FE709D39BD")
    @DSModeled(DSC.SAFE)
    public void setFloatValues(float... values) {
        addTaint(values[0]);
        if(values == null || values.length == 0)        
        {
            return;
        } //End block
        if(mValues == null || mValues.length == 0)        
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("", values)});
        } //End block
        else
        {
            PropertyValuesHolder valuesHolder = mValues[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.980 -0400", hash_original_method = "AAE460ECCCBF6E694CF45A2F7BA85BA5", hash_generated_method = "E6D9D19A4A8B4660D7A3CC2A8886183F")
    public void setObjectValues(Object... values) {
        addTaint(values[0].getTaint());
        if(values == null || values.length == 0)        
        {
            return;
        } //End block
        if(mValues == null || mValues.length == 0)        
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofObject("",
                    (TypeEvaluator)null, values)});
        } //End block
        else
        {
            PropertyValuesHolder valuesHolder = mValues[0];
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.985 -0400", hash_original_method = "D9E3FD9EEAA02CD647DC7AEFD5007E3A", hash_generated_method = "1A154C130D5833B4D25F9C35C150A8A3")
    public void setValues(PropertyValuesHolder... values) {
        int numValues = values.length;
        mValues = values;
        mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
for(int i = 0;i < numValues;++i)
        {
            PropertyValuesHolder valuesHolder = (PropertyValuesHolder) values[i];
            mValuesMap.put(valuesHolder.getPropertyName(), valuesHolder);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.987 -0400", hash_original_method = "78A6AA7AD01513781B120BCE5DC9E156", hash_generated_method = "E4F161275CD2C7EC91592AF6D37E6E67")
    public PropertyValuesHolder[] getValues() {
PropertyValuesHolder[] varC2D5F196132EC24FFA86AC8D1AA44E77_1832261650 =         mValues;
        varC2D5F196132EC24FFA86AC8D1AA44E77_1832261650.addTaint(taint);
        return varC2D5F196132EC24FFA86AC8D1AA44E77_1832261650;
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.989 -0400", hash_original_method = "1534ECD6905850E5B269582384A75673", hash_generated_method = "3E463660AB5DD139F7F83CC8C8CC70BA")
    @DSModeled(DSC.SAFE)
     void initAnimation() {
        if(!mInitialized)        
        {
            int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
            {
                mValues[i].init();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.991 -0400", hash_original_method = "622DE942E3334D786E7FE8DBF49B30DE", hash_generated_method = "C710527D5FB021451FD8DA8A52D83517")
    @DSModeled(DSC.SAFE)
    public ValueAnimator setDuration(long duration) {
        if(duration < 0)        
        {
            IllegalArgumentException varBE9004E8E8C014F966F457353E164ECE_161373675 = new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
            varBE9004E8E8C014F966F457353E164ECE_161373675.addTaint(taint);
            throw varBE9004E8E8C014F966F457353E164ECE_161373675;
        } //End block
        mDuration = duration;
ValueAnimator var72A74007B2BE62B849F475C7BDA4658B_970997194 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_970997194.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_970997194;
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDuration = duration;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.992 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "BD64967C46525D2715DC898C2AB16C28")
    public long getDuration() {
        long var25395741BFE51A7D136A5C7109AAD2D8_2137862021 = (mDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1976147335 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1976147335;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.995 -0400", hash_original_method = "9366966ECC70650E5B5651EBD3539ED0", hash_generated_method = "4AF7C071D2C46B74489D753479B8B317")
    @DSModeled(DSC.SAFE)
    public void setCurrentPlayTime(long playTime) {
        initAnimation();
        long currentTime = AnimationUtils.currentAnimationTimeMillis();
        if(mPlayingState != RUNNING)        
        {
            mSeekTime = playTime;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.000 -0400", hash_original_method = "68655250B160F78BB8C6212DC5765131", hash_generated_method = "F48E131B196AD79E24F7F0CA0A9E83D5")
    @DSModeled(DSC.SAFE)
    public long getCurrentPlayTime() {
        if(!mInitialized || mPlayingState == STOPPED)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_480041329 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1485733962 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1485733962;
        } //End block
        long var1C9200772E158560032A9CF9D62296E6_872729322 = (AnimationUtils.currentAnimationTimeMillis() - mStartTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1069038795 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1069038795;
        // ---------- Original Method ----------
        //if (!mInitialized || mPlayingState == STOPPED) {
            //return 0;
        //}
        //return AnimationUtils.currentAnimationTimeMillis() - mStartTime;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.003 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "96F7BE921EE7AA487F437F01AFAA932D")
    public long getStartDelay() {
        long varD6348B0CF9AA194EA8CCE71E8A2B9F80_1059781133 = (mStartDelay);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1669391582 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1669391582;
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.007 -0400", hash_original_method = "84D20D1DEBEAE9C7FDE98EA5D287F4D2", hash_generated_method = "FAC2ECF430C77C663A5F61FD6D4BD7CA")
    public void setStartDelay(long startDelay) {
        this.mStartDelay = startDelay;
        // ---------- Original Method ----------
        //this.mStartDelay = startDelay;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getFrameDelay() {
        return sFrameDelay;
    }

    
    @DSModeled(DSC.SAFE)
    public static void setFrameDelay(long frameDelay) {
        sFrameDelay = frameDelay;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.013 -0400", hash_original_method = "3CBE561BBB42AB3DB3CAF9B67D05776D", hash_generated_method = "DE9D4EA429A9CA794FAF91972F613CCE")
    public Object getAnimatedValue() {
        if(mValues != null && mValues.length > 0)        
        {
Object var96E4E04F2DBCC1050469FEE260A62C55_1523554031 =             mValues[0].getAnimatedValue();
            var96E4E04F2DBCC1050469FEE260A62C55_1523554031.addTaint(taint);
            return var96E4E04F2DBCC1050469FEE260A62C55_1523554031;
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1042387730 =         null;
        var540C13E9E156B687226421B24F2DF178_1042387730.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1042387730;
        // ---------- Original Method ----------
        //if (mValues != null && mValues.length > 0) {
            //return mValues[0].getAnimatedValue();
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.016 -0400", hash_original_method = "2B530B2B81FC1FAD77C53EC8863AE50E", hash_generated_method = "6F65B5F32C4A6B289D158CBDA4C3E84A")
    public Object getAnimatedValue(String propertyName) {
        addTaint(propertyName.getTaint());
        PropertyValuesHolder valuesHolder = mValuesMap.get(propertyName);
        if(valuesHolder != null)        
        {
Object varAFFF70B2CAFA3E6D7FA10FCE336E53FD_3951793 =             valuesHolder.getAnimatedValue();
            varAFFF70B2CAFA3E6D7FA10FCE336E53FD_3951793.addTaint(taint);
            return varAFFF70B2CAFA3E6D7FA10FCE336E53FD_3951793;
        } //End block
        else
        {
Object var540C13E9E156B687226421B24F2DF178_231079821 =             null;
            var540C13E9E156B687226421B24F2DF178_231079821.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_231079821;
        } //End block
        // ---------- Original Method ----------
        //PropertyValuesHolder valuesHolder = mValuesMap.get(propertyName);
        //if (valuesHolder != null) {
            //return valuesHolder.getAnimatedValue();
        //} else {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.018 -0400", hash_original_method = "4F2FB0A315DAA7A8B07A49F4FCE27399", hash_generated_method = "7098540AE96AF889E34ED53706CB0331")
    public void setRepeatCount(int value) {
        mRepeatCount = value;
        // ---------- Original Method ----------
        //mRepeatCount = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.020 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "5A5DF1A1C73397EF1250FDCD4A8895FB")
    public int getRepeatCount() {
        int varF545692334BC1E20E53D9FB0B2CFFF33_1045369052 = (mRepeatCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1550744639 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1550744639;
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.021 -0400", hash_original_method = "C33D7F87842C98944308EC1438B3A8A7", hash_generated_method = "57CCF83DF3B3AF7C69315FCAF2E9D050")
    public void setRepeatMode(int value) {
        mRepeatMode = value;
        // ---------- Original Method ----------
        //mRepeatMode = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.026 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "C9B1F5E8B45F36DE1FD68B1858936E49")
    public int getRepeatMode() {
        int var0F7262183FEB856E4BA3C1C837CA6BEF_126214678 = (mRepeatMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_550603819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_550603819;
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.030 -0400", hash_original_method = "D2A8BFD752ECF80FCD3BD03F5B9AF68A", hash_generated_method = "F5DF283E858755CDAEB721BA0CC692BD")
    public void addUpdateListener(AnimatorUpdateListener listener) {
        addTaint(listener.getTaint());
        if(mUpdateListeners == null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.033 -0400", hash_original_method = "ABC42C9D08D6EB9E3E04E4FD12636CA0", hash_generated_method = "727A59C99A773D4DBFCFB8B89B4F5FDD")
    public void removeAllUpdateListeners() {
        if(mUpdateListeners == null)        
        {
            return;
        } //End block
        mUpdateListeners.clear();
        mUpdateListeners = null;
        // ---------- Original Method ----------
        //if (mUpdateListeners == null) {
            //return;
        //}
        //mUpdateListeners.clear();
        //mUpdateListeners = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.036 -0400", hash_original_method = "E6D135867EE130F9CB4EA2C9507FABF5", hash_generated_method = "460F58AC30DF7CC9753B21D1A676C90F")
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        addTaint(listener.getTaint());
        if(mUpdateListeners == null)        
        {
            return;
        } //End block
        mUpdateListeners.remove(listener);
        if(mUpdateListeners.size() == 0)        
        {
            mUpdateListeners = null;
        } //End block
        // ---------- Original Method ----------
        //if (mUpdateListeners == null) {
            //return;
        //}
        //mUpdateListeners.remove(listener);
        //if (mUpdateListeners.size() == 0) {
            //mUpdateListeners = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.039 -0400", hash_original_method = "AF77FCDF6C80D02141639AFD7587863F", hash_generated_method = "86B19D29986EF8F2B261A5E66138DDBA")
    @Override
    @DSModeled(DSC.SAFE)
    public void setInterpolator(TimeInterpolator value) {
        if(value != null)        
        {
            mInterpolator = value;
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.041 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "9EA72FF1E956F1C80A42ADF29CAAA123")
    public TimeInterpolator getInterpolator() {
TimeInterpolator var9FA301F6AF154FEBBB2C7439D021F894_780078706 =         mInterpolator;
        var9FA301F6AF154FEBBB2C7439D021F894_780078706.addTaint(taint);
        return var9FA301F6AF154FEBBB2C7439D021F894_780078706;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.043 -0400", hash_original_method = "BC30F1B6BC4F20E2E98ADFB4EC800F88", hash_generated_method = "94AF827F9943E9B9457C1AE5564931ED")
    @DSModeled(DSC.SAFE)
    public void setEvaluator(TypeEvaluator value) {
        addTaint(value.getTaint());
        if(value != null && mValues != null && mValues.length > 0)        
        {
            mValues[0].setEvaluator(value);
        } //End block
        // ---------- Original Method ----------
        //if (value != null && mValues != null && mValues.length > 0) {
            //mValues[0].setEvaluator(value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.049 -0400", hash_original_method = "4B39A931455D340382CCAC7898FAB8D3", hash_generated_method = "4F5881271E026A969D96D0163697FF89")
    @DSModeled(DSC.SAFE)
    private void start(boolean playBackwards) {
        if(Looper.myLooper() == null)        
        {
            AndroidRuntimeException var3B9A5F7965EADDC4E032B0DEF8CC9EF0_695873230 = new AndroidRuntimeException("Animators may only be run on Looper threads");
            var3B9A5F7965EADDC4E032B0DEF8CC9EF0_695873230.addTaint(taint);
            throw var3B9A5F7965EADDC4E032B0DEF8CC9EF0_695873230;
        } //End block
        mPlayingBackwards = playBackwards;
        mCurrentIteration = 0;
        mPlayingState = STOPPED;
        mStarted = true;
        mStartedDelay = false;
        sPendingAnimations.get().add(this);
        if(mStartDelay == 0)        
        {
            setCurrentPlayTime(getCurrentPlayTime());
            mPlayingState = STOPPED;
            mRunning = true;
            if(mListeners != null)            
            {
                ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
                {
                    tmpListeners.get(i).onAnimationStart(this);
                } //End block
            } //End block
        } //End block
        AnimationHandler animationHandler = sAnimationHandler.get();
        if(animationHandler == null)        
        {
            animationHandler = new AnimationHandler();
            sAnimationHandler.set(animationHandler);
        } //End block
        animationHandler.sendEmptyMessage(ANIMATION_START);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.051 -0400", hash_original_method = "0E699EAEE0E759B00B92DBAE6A0AB7E1", hash_generated_method = "CF8459FD9743EB11F57C1D75490D5091")
    @Override
    @DSModeled(DSC.SAFE)
    public void start() {
        start(false);
        // ---------- Original Method ----------
        //start(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.053 -0400", hash_original_method = "5EC046ABFAD295E5D2C88DB1426702CD", hash_generated_method = "14832CD21DEAFA14199F64C586BF729E")
    @Override
    public void cancel() {
        if(mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                sDelayedAnims.get().contains(this))        
        {
            if(mRunning && mListeners != null)            
            {
                ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
for(AnimatorListener listener : tmpListeners)
                {
                    listener.onAnimationCancel(this);
                } //End block
            } //End block
            endAnimation();
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.056 -0400", hash_original_method = "55C31F194BE33B60E19FAC66D36F0F3B", hash_generated_method = "3CEA854E15F475C7E2DA87F0F63E851A")
    @Override
    public void end() {
        if(!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this))        
        {
            mStartedDelay = false;
            startAnimation();
        } //End block
        else
        if(!mInitialized)        
        {
            initAnimation();
        } //End block
        if(mRepeatCount > 0 && (mRepeatCount & 0x01) == 1)        
        {
            animateValue(0f);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.058 -0400", hash_original_method = "80FBC5A625B4BAB80C578CF39CB5DA5B", hash_generated_method = "B911A8569BE5DEB5083AC6704F8FE9A2")
    @Override
    public boolean isRunning() {
        boolean varE27E27F5F002F0FDCE1EB5428F097D74_1913559848 = ((mPlayingState == RUNNING || mRunning));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758874566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758874566;
        // ---------- Original Method ----------
        //return (mPlayingState == RUNNING || mRunning);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.060 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "1A2EF867369B78DE40203E383F5D5ECA")
    @Override
    public boolean isStarted() {
        boolean var7103AE9E2C0D3B676C4EDC763D39DFCF_727852811 = (mStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1958596108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1958596108;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.063 -0400", hash_original_method = "45B2842BAB0EB46941DD63C0EA48CBA2", hash_generated_method = "B3BFE4AA1FB6781B8FB37B94ACB7BFCD")
    public void reverse() {
        mPlayingBackwards = !mPlayingBackwards;
        if(mPlayingState == RUNNING)        
        {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            long currentPlayTime = currentTime - mStartTime;
            long timeLeft = mDuration - currentPlayTime;
            mStartTime = currentTime - timeLeft;
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.066 -0400", hash_original_method = "634DE70818167FA9FFDD8CDDE693BD3B", hash_generated_method = "4D46B15480B7C7634D8BC9E980BB3039")
    private void endAnimation() {
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        mPlayingState = STOPPED;
        if(mRunning && mListeners != null)        
        {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                tmpListeners.get(i).onAnimationEnd(this);
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.067 -0400", hash_original_method = "45B9B57EC5A2CFD523C0E84592BD9EAC", hash_generated_method = "4F59FA0AFF03E77C61AD689FEB69C3B8")
    private void startAnimation() {
        initAnimation();
        sAnimations.get().add(this);
        if(mStartDelay > 0 && mListeners != null)        
        {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                tmpListeners.get(i).onAnimationStart(this);
            } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.071 -0400", hash_original_method = "33DF90BAA846BB88E01B9C85165D068C", hash_generated_method = "6555D1700CBEFFEF13C38C47E94ED8B4")
    private boolean delayedAnimationFrame(long currentTime) {
        if(!mStartedDelay)        
        {
            mStartedDelay = true;
            mDelayStartTime = currentTime;
        } //End block
        else
        {
            long deltaTime = currentTime - mDelayStartTime;
            if(deltaTime > mStartDelay)            
            {
                mStartTime = currentTime - (deltaTime - mStartDelay);
                mPlayingState = RUNNING;
                boolean varB326B5062B2F0E69046810717534CB09_1368780376 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151198724 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151198724;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_562629374 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389871956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389871956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.083 -0400", hash_original_method = "101420F61878798EE86197F974BCAB89", hash_generated_method = "31745E3900A04A895404B6F51EDF4478")
    @DSModeled(DSC.SAFE)
     boolean animationFrame(long currentTime) {
        boolean done = false;
        if(mPlayingState == STOPPED)        
        {
            mPlayingState = RUNNING;
            if(mSeekTime < 0)            
            {
                mStartTime = currentTime;
            } //End block
            else
            {
                mStartTime = currentTime - mSeekTime;
                mSeekTime = -1;
            } //End block
        } //End block
switch(mPlayingState){
        case RUNNING:
        case SEEKED:
        float fraction = mDuration > 0 ? (float)(currentTime - mStartTime) / mDuration : 1f;
        if(fraction >= 1f)        
        {
            if(mCurrentIteration < mRepeatCount || mRepeatCount == INFINITE)            
            {
                if(mListeners != null)                
                {
                    int numListeners = mListeners.size();
for(int i = 0;i < numListeners;++i)
                    {
                        mListeners.get(i).onAnimationRepeat(this);
                    } //End block
                } //End block
                if(mRepeatMode == REVERSE)                
                {
                    mPlayingBackwards = mPlayingBackwards ? false : true;
                } //End block
                mCurrentIteration += (int)fraction;
                fraction = fraction % 1f;
                mStartTime += mDuration;
            } //End block
            else
            {
                done = true;
                fraction = Math.min(fraction, 1.0f);
            } //End block
        } //End block
        if(mPlayingBackwards)        
        {
            fraction = 1f - fraction;
        } //End block
        animateValue(fraction);
        break;
}        boolean var6B2DED51D81A4403D8A4BD25FA1E57EE_937113920 = (done);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211734888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211734888;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.091 -0400", hash_original_method = "7C3735DD08F0E37DA76BAA97A1C3802E", hash_generated_method = "B797367C866B201709543555DD620D42")
    public float getAnimatedFraction() {
        float var5F20A1465612BD819887B170448FB3F7_1448252088 = (mCurrentFraction);
                float var546ADE640B6EDFBC8A086EF31347E768_95296761 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_95296761;
        // ---------- Original Method ----------
        //return mCurrentFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.094 -0400", hash_original_method = "64FBD5BD2598ED0D273DFF76320B41E6", hash_generated_method = "FB36DCFD773AFE8A9379BFE836403D00")
    @DSModeled(DSC.SAFE)
     void animateValue(float fraction) {
        fraction = mInterpolator.getInterpolation(fraction);
        mCurrentFraction = fraction;
        int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
        {
            mValues[i].calculateValue(fraction);
        } //End block
        if(mUpdateListeners != null)        
        {
            int numListeners = mUpdateListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                mUpdateListeners.get(i).onAnimationUpdate(this);
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.101 -0400", hash_original_method = "E24942BE7DE3A089D4AA1F8054FFC13E", hash_generated_method = "59FAECEB0070C3281A7C5A889CF30717")
    @Override
    public ValueAnimator clone() {
        final ValueAnimator anim = (ValueAnimator) super.clone();
        if(mUpdateListeners != null)        
        {
            ArrayList<AnimatorUpdateListener> oldListeners = mUpdateListeners;
            anim.mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
            int numListeners = oldListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                anim.mUpdateListeners.add(oldListeners.get(i));
            } //End block
        } //End block
        anim.mSeekTime = -1;
        anim.mPlayingBackwards = false;
        anim.mCurrentIteration = 0;
        anim.mInitialized = false;
        anim.mPlayingState = STOPPED;
        anim.mStartedDelay = false;
        PropertyValuesHolder[] oldValues = mValues;
        if(oldValues != null)        
        {
            int numValues = oldValues.length;
            anim.mValues = new PropertyValuesHolder[numValues];
            anim.mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
for(int i = 0;i < numValues;++i)
            {
                PropertyValuesHolder newValuesHolder = oldValues[i].clone();
                anim.mValues[i] = newValuesHolder;
                anim.mValuesMap.put(newValuesHolder.getPropertyName(), newValuesHolder);
            } //End block
        } //End block
ValueAnimator var6E2178F33F884BED37C5DEBCD18F9A96_1340890812 =         anim;
        var6E2178F33F884BED37C5DEBCD18F9A96_1340890812.addTaint(taint);
        return var6E2178F33F884BED37C5DEBCD18F9A96_1340890812;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSModeled(DSC.SAFE)
    public static int getCurrentAnimationsCount() {
    	return sAnimations.get().getTaintInt();
        //return sAnimations.get().size();
    }

    
    @DSModeled(DSC.SAFE)
    public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.109 -0400", hash_original_method = "533F41B1624628F4A2CEF95F44B8AA6B", hash_generated_method = "F7FCEDC8B48700AF369CA86456566F17")
    @Override
    public String toString() {
        String returnVal = "ValueAnimator@" + Integer.toHexString(hashCode());
        if(mValues != null)        
        {
for(int i = 0;i < mValues.length;++i)
            {
                returnVal += "\n    " + mValues[i].toString();
            } //End block
        } //End block
String var74D8482D05AF02514EABC315066E6806_2116745028 =         returnVal;
        var74D8482D05AF02514EABC315066E6806_2116745028.addTaint(taint);
        return var74D8482D05AF02514EABC315066E6806_2116745028;
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
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.111 -0400", hash_original_method = "2DEE4CFD7471B34E056063BEAD8FACC4", hash_generated_method = "2DEE4CFD7471B34E056063BEAD8FACC4")
        public AnimationHandler ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.116 -0400", hash_original_method = "52F201F0F7E1BD7680ACD711BB668600", hash_generated_method = "3B1FDE5ACEB670FE3D2CAAF47833AF64")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            boolean callAgain = true;
            ArrayList<ValueAnimator> animations = sAnimations.get();
            ArrayList<ValueAnimator> delayedAnims = sDelayedAnims.get();
switch(msg.what){
            case ANIMATION_START:
            ArrayList<ValueAnimator> pendingAnimations = sPendingAnimations.get();
            if(animations.size() > 0 || delayedAnims.size() > 0)            
            {
                callAgain = false;
            } //End block
            while
(pendingAnimations.size() > 0)            
            {
                ArrayList<ValueAnimator> pendingCopy = (ArrayList<ValueAnimator>) pendingAnimations.clone();
                pendingAnimations.clear();
                int count = pendingCopy.size();
for(int i = 0;i < count;++i)
                {
                    ValueAnimator anim = pendingCopy.get(i);
                    if(anim.mStartDelay == 0)                    
                    {
                        anim.startAnimation();
                    } //End block
                    else
                    {
                        delayedAnims.add(anim);
                    } //End block
                } //End block
            } //End block
            case ANIMATION_FRAME:
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            ArrayList<ValueAnimator> readyAnims = sReadyAnims.get();
            ArrayList<ValueAnimator> endingAnims = sEndingAnims.get();
            int numDelayedAnims = delayedAnims.size();
for(int i = 0;i < numDelayedAnims;++i)
            {
                ValueAnimator anim = delayedAnims.get(i);
                if(anim.delayedAnimationFrame(currentTime))                
                {
                    readyAnims.add(anim);
                } //End block
            } //End block
            int numReadyAnims = readyAnims.size();
            if(numReadyAnims > 0)            
            {
for(int i = 0;i < numReadyAnims;++i)
                {
                    ValueAnimator anim = readyAnims.get(i);
                    anim.startAnimation();
                    anim.mRunning = true;
                    delayedAnims.remove(anim);
                } //End block
                readyAnims.clear();
            } //End block
            int numAnims = animations.size();
            int i = 0;
            while
(i < numAnims)            
            {
                ValueAnimator anim = animations.get(i);
                if(anim.animationFrame(currentTime))                
                {
                    endingAnims.add(anim);
                } //End block
                if(animations.size() == numAnims)                
                {
                    ++i;
                } //End block
                else
                {
                    --numAnims;
                    endingAnims.remove(anim);
                } //End block
            } //End block
            if(endingAnims.size() > 0)            
            {
for(i = 0;i < endingAnims.size();++i)
                {
                    endingAnims.get(i).endAnimation();
                } //End block
                endingAnims.clear();
            } //End block
            if(callAgain && (!animations.isEmpty() || !delayedAnims.isEmpty()))            
            {
                sendEmptyMessageDelayed(ANIMATION_FRAME, Math.max(0, sFrameDelay -
                            (AnimationUtils.currentAnimationTimeMillis() - currentTime)));
            } //End block
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static interface AnimatorUpdateListener {
        
        void onAnimationUpdate(ValueAnimator animation);

    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.119 -0400", hash_original_field = "19C300A967EA25F9D559F955E00792C9", hash_generated_field = "7F6E8414A42B0168ECE0452ABB40B4B9")

    private static final long DEFAULT_FRAME_DELAY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.119 -0400", hash_original_field = "0D7E68A8285D57CCE4D86E51B69846C6", hash_generated_field = "B6DA4DB1E039ECF48740CF743117C6A2")

    static final int ANIMATION_START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.120 -0400", hash_original_field = "E6CA3E401C4A7A7E6AF52E70B57FDFB1", hash_generated_field = "0D77E46A646010DDC0F6082111BE5EAF")

    static final int ANIMATION_FRAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.121 -0400", hash_original_field = "94992C68B07F926E36FA460B8902EACC", hash_generated_field = "689C0CFD849BED6433C2577D385AF415")

    static final int STOPPED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.122 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "8330C184A03CB39DDF37800BA8B3C69E")

    static final int RUNNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.122 -0400", hash_original_field = "0F6D75AE6BB844EFE3A8E4551071CD49", hash_generated_field = "FA3F6B2AADC08540A334E2962EC190BC")

    static final int SEEKED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.123 -0400", hash_original_field = "B4A7D055BAB8301E2C8667A28C9D013B", hash_generated_field = "298BE37EE0C7369286A3ABAA61580A61")

    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<AnimationHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.159 -0400", hash_original_field = "3C37B16155D9D4A0309FE675F3A94C61", hash_generated_field = "F04351AD4592C7F63B7E9F5094FD300A")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
    	@DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.159 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "30984E86954B4487FB1FB1FDC9319F03")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_248712503 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_248712503 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_248712503.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_248712503;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.161 -0400", hash_original_field = "3CAB4DC1D9F9A2C4E0E643C552FB8B5A", hash_generated_field = "1698E605B6DA07A41E58FD2F922706B0")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
    	@DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.161 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "4FF2FD37465665796C1B58FB56AB965F")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1102750751 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1102750751 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1102750751.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1102750751;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.165 -0400", hash_original_field = "1ACEA9A643A2CAF5FE528C380BB8CF14", hash_generated_field = "EB1F31AE16C005A08187EF8034F10324")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
    	@DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.165 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "02005CDE0FB40562043DE6CBF2865DD9")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_750130945 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_750130945 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_750130945.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_750130945;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.167 -0400", hash_original_field = "DE94AD3F45FD0B9D4CDA700DC5CD404B", hash_generated_field = "53E069A69435EAC1CC36D6839EADCA67")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.167 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "7346F25FDFB97A2663CECFE8F4D83A73")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1291337822 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1291337822 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1291337822.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1291337822;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.169 -0400", hash_original_field = "255441D2B8970E34EB230C059292860D", hash_generated_field = "D2EEA5B8BD4B8D7168D2B5C9CE01B11F")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.168 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "1D39BB2D8E01B1E6514960600C7DFC2B")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1528695003 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1528695003 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1528695003.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1528695003;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.127 -0400", hash_original_field = "CAB4CFDA656A41124CB58DC84DFC5E60", hash_generated_field = "C580F5E9382C56D07696899D4103886B")

    private static final TimeInterpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.127 -0400", hash_original_field = "524C52C0A1E88CDA180A0F7AA6118606", hash_generated_field = "7E9EFDBC560251144B1ABA6A3E58FAA3")

    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.128 -0400", hash_original_field = "15DEFED28FFB599464BB68C200695E4F", hash_generated_field = "81564E463CF700876869857891E00106")

    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.128 -0400", hash_original_field = "645DD1C3FAB37420AA3AF59AEC271373", hash_generated_field = "B136BC014A7EC92E31D514350E48B057")

    private static long sFrameDelay = DEFAULT_FRAME_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.129 -0400", hash_original_field = "5F06E0F5187ED0CBFC4EF9E7B4D64EDE", hash_generated_field = "9FE7B7E5ED52768DD1C53DC895EC1A0D")

    public static final int RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.130 -0400", hash_original_field = "6BAA62FAC35E1F188A65C74FED662C34", hash_generated_field = "6790E6439C0E7615743240DF9A7C010E")

    public static final int REVERSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:16.131 -0400", hash_original_field = "5E2F9BDAA8CE14DD954BF40FD55E2AF3", hash_generated_field = "285D35A4B336A34C53955AE44424AC64")

    public static final int INFINITE = -1;
}

