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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.069 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

    long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.069 -0400", hash_original_field = "21F0A5E67D578B871CE4890BB4301938", hash_generated_field = "4E1645CE3651AE4D866A4E97769672FC")

    long mSeekTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.069 -0400", hash_original_field = "C36D028293D9AEB21CE372B528F12B7D", hash_generated_field = "25D0DF5A7C1B0B40E8B3204C90423678")

    private boolean mPlayingBackwards = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.070 -0400", hash_original_field = "24FDF63EDEAC7BEE43B5C4C5591E8865", hash_generated_field = "4C9D53155FF73BA27011D6E7DB3AD10B")

    private int mCurrentIteration = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.070 -0400", hash_original_field = "C2F7E02BDA00B17A8F988AB57AA22BF9", hash_generated_field = "8A50A9EB094A19AFEFAE9DD764A21B61")

    private float mCurrentFraction = 0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.070 -0400", hash_original_field = "CC68149CDA21F68465AA90F07F5D95CC", hash_generated_field = "E6BC29DFE32B95A7746A3240D4908F49")

    private boolean mStartedDelay = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.070 -0400", hash_original_field = "4990509A1CCCA8D89E912983C67DFF20", hash_generated_field = "99C0D1839DB2E0976F6365DA96527AB3")

    private long mDelayStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.071 -0400", hash_original_field = "9950F1CC6304A23A1DF3E99C55CB4013", hash_generated_field = "8F8CC3CA50EF97884C628BBEA63AE150")

    int mPlayingState = STOPPED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.071 -0400", hash_original_field = "62A2DC3D8C5F735AB3A7DFD6D4A40243", hash_generated_field = "BF66F685C8DAD91C6D305A2AD45B0022")

    private boolean mRunning = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.071 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.071 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "D7228C282593CDC77734D668B23541D3")

    boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.071 -0400", hash_original_field = "278AF3A57BE580604E764F8A9A2B780D", hash_generated_field = "7C681C473ED41389A77BB70A2C4D72CE")

    private long mDuration = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.072 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.072 -0400", hash_original_field = "7400544E99BDB4AB399DABF03F346DE6", hash_generated_field = "86BE2F843C53DE337B277203FC4ABA75")

    private int mRepeatCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.072 -0400", hash_original_field = "31336EA85735F5B517DD430F87691118", hash_generated_field = "D8AE514964A82408D2EBFBBF132AAE13")

    private int mRepeatMode = RESTART;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.072 -0400", hash_original_field = "ED64FCC69138AB0D151E83CCFCFE975A", hash_generated_field = "42D7E84F8F4EF4F62C2A90763184E4DB")

    private TimeInterpolator mInterpolator = sDefaultInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.072 -0400", hash_original_field = "6141FE189AA3625489E2AE5CC67F512B", hash_generated_field = "413346BD5600531FF965862127DA0D01")

    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.073 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "E200C2BDFC70B9C579B8C490F170F688")

    PropertyValuesHolder[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.073 -0400", hash_original_field = "DEA90B16C4F0F78E79C71A2F9BB8975C", hash_generated_field = "AF5FC8A22004016791392366FC7AA458")

    HashMap<String, PropertyValuesHolder> mValuesMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.074 -0400", hash_original_method = "17A6701FB198CD0BD584AB7A0EFE3839", hash_generated_method = "1E0F7AE0C295B96E8122202378305CF8")
    public  ValueAnimator() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.076 -0400", hash_original_method = "67525E8968A6999074D725B8947CD2FE", hash_generated_method = "B1B6DF7B7D00135B9408B80E674B1144")
    public void setIntValues(int... values) {
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("", values)});
        } //End block
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            valuesHolder.setIntValues(values);
        } //End block
        mInitialized = false;
        addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.077 -0400", hash_original_method = "D733778AA31410A94B9571EEAAECBB30", hash_generated_method = "8D44CA4A08D3805F77CD3A6A33DCD298")
    public void setFloatValues(float... values) {
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("", values)});
        } //End block
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            valuesHolder.setFloatValues(values);
        } //End block
        mInitialized = false;
        addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.079 -0400", hash_original_method = "AAE460ECCCBF6E694CF45A2F7BA85BA5", hash_generated_method = "0F9C12E3657B2B9AB57CABFA48321137")
    public void setObjectValues(Object... values) {
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofObject("",
                    (TypeEvaluator)null, values)});
        } //End block
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            valuesHolder.setObjectValues(values);
        } //End block
        mInitialized = false;
        addTaint(values[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.080 -0400", hash_original_method = "D9E3FD9EEAA02CD647DC7AEFD5007E3A", hash_generated_method = "A4A872F1FCDDC8DBC806CFF3FC9F7F77")
    public void setValues(PropertyValuesHolder... values) {
        int numValues = values.length;
        mValues = values;
        mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
        {
            int i = 0;
            {
                PropertyValuesHolder valuesHolder = (PropertyValuesHolder) values[i];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.081 -0400", hash_original_method = "78A6AA7AD01513781B120BCE5DC9E156", hash_generated_method = "383DA4E88D3FB9E1B08D85A5B5E108DA")
    public PropertyValuesHolder[] getValues() {
        PropertyValuesHolder[] varB4EAC82CA7396A68D541C85D26508E83_828221140 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_828221140 = mValues;
        varB4EAC82CA7396A68D541C85D26508E83_828221140.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_828221140;
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.082 -0400", hash_original_method = "1534ECD6905850E5B269582384A75673", hash_generated_method = "3CBAE170C7C3BAA194F73C93FAF9D2D5")
     void initAnimation() {
        {
            int numValues = mValues.length;
            {
                int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.084 -0400", hash_original_method = "622DE942E3334D786E7FE8DBF49B30DE", hash_generated_method = "7E965EC964C8FA1A6C667AD1DB80E38A")
    public ValueAnimator setDuration(long duration) {
        ValueAnimator varB4EAC82CA7396A68D541C85D26508E83_1853454242 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
        } //End block
        mDuration = duration;
        varB4EAC82CA7396A68D541C85D26508E83_1853454242 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1853454242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1853454242;
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDuration = duration;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.085 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "8B5AC97D3630595D0AE8FC15689DBFFD")
    public long getDuration() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_475523095 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_475523095;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.086 -0400", hash_original_method = "9366966ECC70650E5B5651EBD3539ED0", hash_generated_method = "71E4BADDE8832D39E130F37E82056016")
    public void setCurrentPlayTime(long playTime) {
        initAnimation();
        long currentTime = AnimationUtils.currentAnimationTimeMillis();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.089 -0400", hash_original_method = "68655250B160F78BB8C6212DC5765131", hash_generated_method = "8D161A228D33D1E369D2B47327C2B956")
    public long getCurrentPlayTime() {
        long var6F61F9B0364A4D245BC9CF0ACBEF5BEE_87152238 = (AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1613346920 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1613346920;
        // ---------- Original Method ----------
        //if (!mInitialized || mPlayingState == STOPPED) {
            //return 0;
        //}
        //return AnimationUtils.currentAnimationTimeMillis() - mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.090 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "C14CE2CF306DCD050B27A2BC433F0AA8")
    public long getStartDelay() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1361706133 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1361706133;
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.091 -0400", hash_original_method = "84D20D1DEBEAE9C7FDE98EA5D287F4D2", hash_generated_method = "FAC2ECF430C77C663A5F61FD6D4BD7CA")
    public void setStartDelay(long startDelay) {
        this.mStartDelay = startDelay;
        // ---------- Original Method ----------
        //this.mStartDelay = startDelay;
    }

    
    public static long getFrameDelay() {
        return sFrameDelay;
    }

    
    public static void setFrameDelay(long frameDelay) {
        sFrameDelay = frameDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.095 -0400", hash_original_method = "3CBE561BBB42AB3DB3CAF9B67D05776D", hash_generated_method = "1CC8C17757594A035F80DC78C52E4FC5")
    public Object getAnimatedValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1706758822 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_847853944 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1706758822 = mValues[0].getAnimatedValue();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_847853944 = null;
        Object varA7E53CE21691AB073D9660D615818899_1838780141; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1838780141 = varB4EAC82CA7396A68D541C85D26508E83_1706758822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1838780141 = varB4EAC82CA7396A68D541C85D26508E83_847853944;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1838780141.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1838780141;
        // ---------- Original Method ----------
        //if (mValues != null && mValues.length > 0) {
            //return mValues[0].getAnimatedValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.099 -0400", hash_original_method = "2B530B2B81FC1FAD77C53EC8863AE50E", hash_generated_method = "92DF30D662D17E37F80F8C99D6DD8C4B")
    public Object getAnimatedValue(String propertyName) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1590139728 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1563787472 = null; //Variable for return #2
        PropertyValuesHolder valuesHolder = mValuesMap.get(propertyName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1590139728 = valuesHolder.getAnimatedValue();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1563787472 = null;
        } //End block
        addTaint(propertyName.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_902170570; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_902170570 = varB4EAC82CA7396A68D541C85D26508E83_1590139728;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_902170570 = varB4EAC82CA7396A68D541C85D26508E83_1563787472;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_902170570.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_902170570;
        // ---------- Original Method ----------
        //PropertyValuesHolder valuesHolder = mValuesMap.get(propertyName);
        //if (valuesHolder != null) {
            //return valuesHolder.getAnimatedValue();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.101 -0400", hash_original_method = "4F2FB0A315DAA7A8B07A49F4FCE27399", hash_generated_method = "7098540AE96AF889E34ED53706CB0331")
    public void setRepeatCount(int value) {
        mRepeatCount = value;
        // ---------- Original Method ----------
        //mRepeatCount = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.102 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "55EEFD10FF6456409F1D1F8DC66E44DA")
    public int getRepeatCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159349195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159349195;
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.104 -0400", hash_original_method = "C33D7F87842C98944308EC1438B3A8A7", hash_generated_method = "57CCF83DF3B3AF7C69315FCAF2E9D050")
    public void setRepeatMode(int value) {
        mRepeatMode = value;
        // ---------- Original Method ----------
        //mRepeatMode = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.105 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "9DDE16180D7ADB5A666DC202AA824476")
    public int getRepeatMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679855463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679855463;
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.106 -0400", hash_original_method = "D2A8BFD752ECF80FCD3BD03F5B9AF68A", hash_generated_method = "5E7135EF2BA4C3F11D8555A731C33374")
    public void addUpdateListener(AnimatorUpdateListener listener) {
        {
            mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
        } //End block
        mUpdateListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mUpdateListeners == null) {
            //mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
        //}
        //mUpdateListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.108 -0400", hash_original_method = "ABC42C9D08D6EB9E3E04E4FD12636CA0", hash_generated_method = "C442C719649EE8FF274F608780F8CCA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.110 -0400", hash_original_method = "E6D135867EE130F9CB4EA2C9507FABF5", hash_generated_method = "B6DD6B14DA882E54224EB623D6A9843A")
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        mUpdateListeners.remove(listener);
        {
            boolean varA4B084E767DE55BA6AFD2DEBEB0A7784_1607144640 = (mUpdateListeners.size() == 0);
            {
                mUpdateListeners = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mUpdateListeners == null) {
            //return;
        //}
        //mUpdateListeners.remove(listener);
        //if (mUpdateListeners.size() == 0) {
            //mUpdateListeners = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.112 -0400", hash_original_method = "AF77FCDF6C80D02141639AFD7587863F", hash_generated_method = "4AD5CA0900FB4ADF922CC1530AE31746")
    @Override
    public void setInterpolator(TimeInterpolator value) {
        {
            mInterpolator = value;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.113 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "8CCB516995DB3FC108FA9643E6A0A4C6")
    public TimeInterpolator getInterpolator() {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_654057754 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_654057754 = mInterpolator;
        varB4EAC82CA7396A68D541C85D26508E83_654057754.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_654057754;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.114 -0400", hash_original_method = "BC30F1B6BC4F20E2E98ADFB4EC800F88", hash_generated_method = "D174E2891B05C4CB9C1E9C2CA05E9860")
    public void setEvaluator(TypeEvaluator value) {
        {
            mValues[0].setEvaluator(value);
        } //End block
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (value != null && mValues != null && mValues.length > 0) {
            //mValues[0].setEvaluator(value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.118 -0400", hash_original_method = "4B39A931455D340382CCAC7898FAB8D3", hash_generated_method = "F387211E2B2FC5276671D9915F6A4F26")
    private void start(boolean playBackwards) {
        {
            boolean var607F99F94A9C3E729CF05A4C4A58ABDF_1721742518 = (Looper.myLooper() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new AndroidRuntimeException("Animators may only be run on Looper threads");
            } //End block
        } //End collapsed parenthetic
        mPlayingBackwards = playBackwards;
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
                ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                int numListeners = tmpListeners.size();
                {
                    int i = 0;
                    {
                        tmpListeners.get(i).onAnimationStart(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        AnimationHandler animationHandler = sAnimationHandler.get();
        {
            animationHandler = new AnimationHandler();
            sAnimationHandler.set(animationHandler);
        } //End block
        animationHandler.sendEmptyMessage(ANIMATION_START);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.119 -0400", hash_original_method = "0E699EAEE0E759B00B92DBAE6A0AB7E1", hash_generated_method = "CF8459FD9743EB11F57C1D75490D5091")
    @Override
    public void start() {
        start(false);
        // ---------- Original Method ----------
        //start(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.133 -0400", hash_original_method = "5EC046ABFAD295E5D2C88DB1426702CD", hash_generated_method = "D2C6B7D7E3102BDE0069D8C2E68494C3")
    @Override
    public void cancel() {
        {
            boolean var58486F75E12966B52474E15F32795998_210529420 = (mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                sDelayedAnims.get().contains(this));
            {
                {
                    ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_1939780170 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_1939780170.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_1939780170.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.135 -0400", hash_original_method = "55C31F194BE33B60E19FAC66D36F0F3B", hash_generated_method = "F70AC8BEDFC8F4EE3CE24747BE32B16A")
    @Override
    public void end() {
        {
            boolean var421E56E1FD921FD2A83C6EC630885000_840766710 = (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.135 -0400", hash_original_method = "80FBC5A625B4BAB80C578CF39CB5DA5B", hash_generated_method = "3D9F78705CB2FBEB3B1123F061EFFFAE")
    @Override
    public boolean isRunning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86487358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_86487358;
        // ---------- Original Method ----------
        //return (mPlayingState == RUNNING || mRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.136 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "5A70E88C0A890EA8421888DCA3CC5EE6")
    @Override
    public boolean isStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647795131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647795131;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.137 -0400", hash_original_method = "45B2842BAB0EB46941DD63C0EA48CBA2", hash_generated_method = "DC3D2BFD0B7D4074D185BF018F9E839E")
    public void reverse() {
        mPlayingBackwards = !mPlayingBackwards;
        {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            long currentPlayTime = currentTime - mStartTime;
            long timeLeft = mDuration - currentPlayTime;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.139 -0400", hash_original_method = "634DE70818167FA9FFDD8CDDE693BD3B", hash_generated_method = "A6AD3C65AEE0E0F29F3080AB534B938E")
    private void endAnimation() {
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        mPlayingState = STOPPED;
        {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners = tmpListeners.size();
            {
                int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.141 -0400", hash_original_method = "45B9B57EC5A2CFD523C0E84592BD9EAC", hash_generated_method = "9EAACD46099D7699A6221675AC5121EE")
    private void startAnimation() {
        initAnimation();
        sAnimations.get().add(this);
        {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners = tmpListeners.size();
            {
                int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.142 -0400", hash_original_method = "33DF90BAA846BB88E01B9C85165D068C", hash_generated_method = "5A16433024F0F37F461CCF8B869BEEBF")
    private boolean delayedAnimationFrame(long currentTime) {
        {
            mStartedDelay = true;
            mDelayStartTime = currentTime;
        } //End block
        {
            long deltaTime = currentTime - mDelayStartTime;
            {
                mStartTime = currentTime - (deltaTime - mStartDelay);
                mPlayingState = RUNNING;
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411311493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411311493;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.144 -0400", hash_original_method = "101420F61878798EE86197F974BCAB89", hash_generated_method = "05687D9781CEA6A74C646A7BAE7B4956")
     boolean animationFrame(long currentTime) {
        boolean done = false;
        {
            mPlayingState = RUNNING;
            {
                mStartTime = currentTime;
            } //End block
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
                    int numListeners = mListeners.size();
                    {
                        int i = 0;
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107229553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107229553;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.144 -0400", hash_original_method = "7C3735DD08F0E37DA76BAA97A1C3802E", hash_generated_method = "20DCDADBDCEC2ABF868B1B6A2AAD0B08")
    public float getAnimatedFraction() {
        float var546ADE640B6EDFBC8A086EF31347E768_612922690 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_612922690;
        // ---------- Original Method ----------
        //return mCurrentFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.145 -0400", hash_original_method = "64FBD5BD2598ED0D273DFF76320B41E6", hash_generated_method = "23B5323686D3ED8B28970748951EA5FC")
     void animateValue(float fraction) {
        fraction = mInterpolator.getInterpolation(fraction);
        mCurrentFraction = fraction;
        int numValues = mValues.length;
        {
            int i = 0;
            {
                mValues[i].calculateValue(fraction);
            } //End block
        } //End collapsed parenthetic
        {
            int numListeners = mUpdateListeners.size();
            {
                int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.148 -0400", hash_original_method = "E24942BE7DE3A089D4AA1F8054FFC13E", hash_generated_method = "40DEE2D411A0FD1E8208EC22699D93C1")
    @Override
    public ValueAnimator clone() {
        ValueAnimator varB4EAC82CA7396A68D541C85D26508E83_1526572578 = null; //Variable for return #1
        final ValueAnimator anim = (ValueAnimator) super.clone();
        {
            ArrayList<AnimatorUpdateListener> oldListeners = mUpdateListeners;
            anim.mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
            int numListeners = oldListeners.size();
            {
                int i = 0;
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
        PropertyValuesHolder[] oldValues = mValues;
        {
            int numValues = oldValues.length;
            anim.mValues = new PropertyValuesHolder[numValues];
            anim.mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
            {
                int i = 0;
                {
                    PropertyValuesHolder newValuesHolder = oldValues[i].clone();
                    anim.mValues[i] = newValuesHolder;
                    anim.mValuesMap.put(newValuesHolder.getPropertyName(), newValuesHolder);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1526572578 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_1526572578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1526572578;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.153 -0400", hash_original_method = "533F41B1624628F4A2CEF95F44B8AA6B", hash_generated_method = "C24A08C451778C515291F8308EB0B101")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1267525378 = null; //Variable for return #1
        String returnVal = "ValueAnimator@" + Integer.toHexString(hashCode());
        {
            {
                int i = 0;
                {
                    returnVal += "\n    " + mValues[i].toString();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1267525378 = returnVal;
        varB4EAC82CA7396A68D541C85D26508E83_1267525378.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1267525378;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.153 -0400", hash_original_method = "2DEE4CFD7471B34E056063BEAD8FACC4", hash_generated_method = "2DEE4CFD7471B34E056063BEAD8FACC4")
        public AnimationHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.156 -0400", hash_original_method = "52F201F0F7E1BD7680ACD711BB668600", hash_generated_method = "623ACE57415E51657C31250EB20DC56D")
        @Override
        public void handleMessage(Message msg) {
            boolean callAgain = true;
            ArrayList<ValueAnimator> animations = sAnimations.get();
            ArrayList<ValueAnimator> delayedAnims = sDelayedAnims.get();
            //Begin case ANIMATION_START 
            ArrayList<ValueAnimator> pendingAnimations = sPendingAnimations.get();
            //End case ANIMATION_START 
            //Begin case ANIMATION_START 
            {
                boolean varA1F5D09ABD5BA1EAA9064BD2C7F540A0_1235885646 = (animations.size() > 0 || delayedAnims.size() > 0);
                {
                    callAgain = false;
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_START 
            //Begin case ANIMATION_START 
            {
                boolean var310842A70C8547E073B963714355E2EF_730322598 = (pendingAnimations.size() > 0);
                {
                    ArrayList<ValueAnimator> pendingCopy = (ArrayList<ValueAnimator>) pendingAnimations.clone();
                    pendingAnimations.clear();
                    int count = pendingCopy.size();
                    {
                        int i = 0;
                        {
                            ValueAnimator anim = pendingCopy.get(i);
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
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            ArrayList<ValueAnimator> readyAnims = sReadyAnims.get();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            ArrayList<ValueAnimator> endingAnims = sEndingAnims.get();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            int numDelayedAnims = delayedAnims.size();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                int i = 0;
                {
                    ValueAnimator anim = delayedAnims.get(i);
                    {
                        boolean var5A6A4AC41707EA57AE87A5C33A49358D_1524024160 = (anim.delayedAnimationFrame(currentTime));
                        {
                            readyAnims.add(anim);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            int numReadyAnims = readyAnims.size();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                {
                    int i = 0;
                    {
                        ValueAnimator anim = readyAnims.get(i);
                        anim.startAnimation();
                        anim.mRunning = true;
                        delayedAnims.remove(anim);
                    } //End block
                } //End collapsed parenthetic
                readyAnims.clear();
            } //End block
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            int numAnims = animations.size();
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            int i = 0;
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                ValueAnimator anim = animations.get(i);
                {
                    boolean varB2157FB20628670967962D499113FAB2_1337275107 = (anim.animationFrame(currentTime));
                    {
                        endingAnims.add(anim);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varB2E9B25FC12B68A819E499BFA350E9C9_696483977 = (animations.size() == numAnims);
                    {
                        endingAnims.remove(anim);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                boolean var24F884196EA732DACEFF40751A202210_1203037629 = (endingAnims.size() > 0);
                {
                    {
                        i = 0;
                        boolean var680A26EFE24B5CA3CBE89BBC9415413A_382871546 = (i < endingAnims.size());
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
                boolean var8A9BF7DDA394FFB721509F4D19C0EAE3_1684062966 = (callAgain && (!animations.isEmpty() || !delayedAnims.isEmpty()));
                {
                    sendEmptyMessageDelayed(ANIMATION_FRAME, Math.max(0, sFrameDelay -
                            (AnimationUtils.currentAnimationTimeMillis() - currentTime)));
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_FRAME 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static interface AnimatorUpdateListener {
        
        void onAnimationUpdate(ValueAnimator animation);

    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.157 -0400", hash_original_field = "19C300A967EA25F9D559F955E00792C9", hash_generated_field = "7F6E8414A42B0168ECE0452ABB40B4B9")

    private static final long DEFAULT_FRAME_DELAY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.157 -0400", hash_original_field = "0D7E68A8285D57CCE4D86E51B69846C6", hash_generated_field = "B6DA4DB1E039ECF48740CF743117C6A2")

    static final int ANIMATION_START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.157 -0400", hash_original_field = "E6CA3E401C4A7A7E6AF52E70B57FDFB1", hash_generated_field = "0D77E46A646010DDC0F6082111BE5EAF")

    static final int ANIMATION_FRAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.157 -0400", hash_original_field = "94992C68B07F926E36FA460B8902EACC", hash_generated_field = "689C0CFD849BED6433C2577D385AF415")

    static final int STOPPED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.158 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "8330C184A03CB39DDF37800BA8B3C69E")

    static final int RUNNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.158 -0400", hash_original_field = "0F6D75AE6BB844EFE3A8E4551071CD49", hash_generated_field = "FA3F6B2AADC08540A334E2962EC190BC")

    static final int SEEKED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.158 -0400", hash_original_field = "B4A7D055BAB8301E2C8667A28C9D013B", hash_generated_field = "298BE37EE0C7369286A3ABAA61580A61")

    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<AnimationHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.159 -0400", hash_original_field = "3C37B16155D9D4A0309FE675F3A94C61", hash_generated_field = "F04351AD4592C7F63B7E9F5094FD300A")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.159 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "30984E86954B4487FB1FB1FDC9319F03")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_248712503 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_248712503 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_248712503.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_248712503;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.161 -0400", hash_original_field = "3CAB4DC1D9F9A2C4E0E643C552FB8B5A", hash_generated_field = "1698E605B6DA07A41E58FD2F922706B0")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.161 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "4FF2FD37465665796C1B58FB56AB965F")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1102750751 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1102750751 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1102750751.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1102750751;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.165 -0400", hash_original_field = "1ACEA9A643A2CAF5FE528C380BB8CF14", hash_generated_field = "EB1F31AE16C005A08187EF8034F10324")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.165 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "02005CDE0FB40562043DE6CBF2865DD9")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_750130945 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_750130945 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_750130945.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_750130945;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.167 -0400", hash_original_field = "DE94AD3F45FD0B9D4CDA700DC5CD404B", hash_generated_field = "53E069A69435EAC1CC36D6839EADCA67")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.167 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "7346F25FDFB97A2663CECFE8F4D83A73")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1291337822 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1291337822 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1291337822.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1291337822;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.169 -0400", hash_original_field = "255441D2B8970E34EB230C059292860D", hash_generated_field = "D2EEA5B8BD4B8D7168D2B5C9CE01B11F")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.168 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "1D39BB2D8E01B1E6514960600C7DFC2B")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1528695003 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1528695003 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1528695003.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1528695003;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.169 -0400", hash_original_field = "CAB4CFDA656A41124CB58DC84DFC5E60", hash_generated_field = "C580F5E9382C56D07696899D4103886B")

    private static final TimeInterpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.169 -0400", hash_original_field = "524C52C0A1E88CDA180A0F7AA6118606", hash_generated_field = "7E9EFDBC560251144B1ABA6A3E58FAA3")

    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.169 -0400", hash_original_field = "15DEFED28FFB599464BB68C200695E4F", hash_generated_field = "81564E463CF700876869857891E00106")

    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.170 -0400", hash_original_field = "645DD1C3FAB37420AA3AF59AEC271373", hash_generated_field = "B136BC014A7EC92E31D514350E48B057")

    private static long sFrameDelay = DEFAULT_FRAME_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.170 -0400", hash_original_field = "5F06E0F5187ED0CBFC4EF9E7B4D64EDE", hash_generated_field = "9FE7B7E5ED52768DD1C53DC895EC1A0D")

    public static final int RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.170 -0400", hash_original_field = "6BAA62FAC35E1F188A65C74FED662C34", hash_generated_field = "6790E6439C0E7615743240DF9A7C010E")

    public static final int REVERSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.170 -0400", hash_original_field = "5E2F9BDAA8CE14DD954BF40FD55E2AF3", hash_generated_field = "285D35A4B336A34C53955AE44424AC64")

    public static final int INFINITE = -1;
}

