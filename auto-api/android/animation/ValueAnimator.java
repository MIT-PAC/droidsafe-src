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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.855 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

    long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.855 -0400", hash_original_field = "21F0A5E67D578B871CE4890BB4301938", hash_generated_field = "4E1645CE3651AE4D866A4E97769672FC")

    long mSeekTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.856 -0400", hash_original_field = "C36D028293D9AEB21CE372B528F12B7D", hash_generated_field = "25D0DF5A7C1B0B40E8B3204C90423678")

    private boolean mPlayingBackwards = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.857 -0400", hash_original_field = "24FDF63EDEAC7BEE43B5C4C5591E8865", hash_generated_field = "4C9D53155FF73BA27011D6E7DB3AD10B")

    private int mCurrentIteration = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.865 -0400", hash_original_field = "C2F7E02BDA00B17A8F988AB57AA22BF9", hash_generated_field = "8A50A9EB094A19AFEFAE9DD764A21B61")

    private float mCurrentFraction = 0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.866 -0400", hash_original_field = "CC68149CDA21F68465AA90F07F5D95CC", hash_generated_field = "E6BC29DFE32B95A7746A3240D4908F49")

    private boolean mStartedDelay = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.867 -0400", hash_original_field = "4990509A1CCCA8D89E912983C67DFF20", hash_generated_field = "99C0D1839DB2E0976F6365DA96527AB3")

    private long mDelayStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.868 -0400", hash_original_field = "9950F1CC6304A23A1DF3E99C55CB4013", hash_generated_field = "8F8CC3CA50EF97884C628BBEA63AE150")

    int mPlayingState = STOPPED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.868 -0400", hash_original_field = "62A2DC3D8C5F735AB3A7DFD6D4A40243", hash_generated_field = "BF66F685C8DAD91C6D305A2AD45B0022")

    private boolean mRunning = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.869 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.870 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "D7228C282593CDC77734D668B23541D3")

    boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.877 -0400", hash_original_field = "278AF3A57BE580604E764F8A9A2B780D", hash_generated_field = "7C681C473ED41389A77BB70A2C4D72CE")

    private long mDuration = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.877 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.878 -0400", hash_original_field = "7400544E99BDB4AB399DABF03F346DE6", hash_generated_field = "86BE2F843C53DE337B277203FC4ABA75")

    private int mRepeatCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.879 -0400", hash_original_field = "31336EA85735F5B517DD430F87691118", hash_generated_field = "D8AE514964A82408D2EBFBBF132AAE13")

    private int mRepeatMode = RESTART;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.880 -0400", hash_original_field = "ED64FCC69138AB0D151E83CCFCFE975A", hash_generated_field = "42D7E84F8F4EF4F62C2A90763184E4DB")

    private TimeInterpolator mInterpolator = sDefaultInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.881 -0400", hash_original_field = "6141FE189AA3625489E2AE5CC67F512B", hash_generated_field = "413346BD5600531FF965862127DA0D01")

    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.887 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "E200C2BDFC70B9C579B8C490F170F688")

    PropertyValuesHolder[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.888 -0400", hash_original_field = "DEA90B16C4F0F78E79C71A2F9BB8975C", hash_generated_field = "AF5FC8A22004016791392366FC7AA458")

    HashMap<String, PropertyValuesHolder> mValuesMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.890 -0400", hash_original_method = "17A6701FB198CD0BD584AB7A0EFE3839", hash_generated_method = "1E0F7AE0C295B96E8122202378305CF8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.923 -0400", hash_original_method = "67525E8968A6999074D725B8947CD2FE", hash_generated_method = "785D0EE3A4ECBCA5AE2754E06572ABE6")
    public void setIntValues(int... values) {
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("", values)});
        } //End block
        {
            PropertyValuesHolder valuesHolder;
            valuesHolder = mValues[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.936 -0400", hash_original_method = "D733778AA31410A94B9571EEAAECBB30", hash_generated_method = "F79304EA4A6737FAC7478A9AEA3EDE98")
    public void setFloatValues(float... values) {
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("", values)});
        } //End block
        {
            PropertyValuesHolder valuesHolder;
            valuesHolder = mValues[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.944 -0400", hash_original_method = "AAE460ECCCBF6E694CF45A2F7BA85BA5", hash_generated_method = "90DDBEA99C76CC43224E495EBCA2E2BA")
    public void setObjectValues(Object... values) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.963 -0400", hash_original_method = "D9E3FD9EEAA02CD647DC7AEFD5007E3A", hash_generated_method = "6FC38FE964567B5044063E6BCF26CF8D")
    public void setValues(PropertyValuesHolder... values) {
        int numValues;
        numValues = values.length;
        mValues = values;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.974 -0400", hash_original_method = "78A6AA7AD01513781B120BCE5DC9E156", hash_generated_method = "DBE6A4B6495B94E09BE29A4024A0B8EC")
    public PropertyValuesHolder[] getValues() {
        PropertyValuesHolder[] varB4EAC82CA7396A68D541C85D26508E83_376535962 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_376535962 = mValues;
        varB4EAC82CA7396A68D541C85D26508E83_376535962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_376535962;
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.978 -0400", hash_original_method = "1534ECD6905850E5B269582384A75673", hash_generated_method = "6BBF6129DA30B7815375213690CEA17F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.004 -0400", hash_original_method = "622DE942E3334D786E7FE8DBF49B30DE", hash_generated_method = "BFFC324067A4D647461B2E4B02FA3B9B")
    public ValueAnimator setDuration(long duration) {
        ValueAnimator varB4EAC82CA7396A68D541C85D26508E83_744970868 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
        } //End block
        mDuration = duration;
        varB4EAC82CA7396A68D541C85D26508E83_744970868 = this;
        varB4EAC82CA7396A68D541C85D26508E83_744970868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_744970868;
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDuration = duration;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.007 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "F3013FCE9CBB7AFD498B209FDF9BF9CE")
    public long getDuration() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_122389220 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_122389220;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.021 -0400", hash_original_method = "9366966ECC70650E5B5651EBD3539ED0", hash_generated_method = "C26F6E435DF60DD647F1AD2EF60B2CB2")
    public void setCurrentPlayTime(long playTime) {
        initAnimation();
        long currentTime;
        currentTime = AnimationUtils.currentAnimationTimeMillis();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.035 -0400", hash_original_method = "68655250B160F78BB8C6212DC5765131", hash_generated_method = "25CE4F21BD24F2F8C3044FFB62FC7D2D")
    public long getCurrentPlayTime() {
        long var6F61F9B0364A4D245BC9CF0ACBEF5BEE_368743121 = (AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_661917312 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_661917312;
        // ---------- Original Method ----------
        //if (!mInitialized || mPlayingState == STOPPED) {
            //return 0;
        //}
        //return AnimationUtils.currentAnimationTimeMillis() - mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.037 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "106CAA7E85DC836A22B44AA628981A5D")
    public long getStartDelay() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1625401721 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1625401721;
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.054 -0400", hash_original_method = "84D20D1DEBEAE9C7FDE98EA5D287F4D2", hash_generated_method = "FAC2ECF430C77C663A5F61FD6D4BD7CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.067 -0400", hash_original_method = "3CBE561BBB42AB3DB3CAF9B67D05776D", hash_generated_method = "2CBFB9C4E8852D59C7F398426F981918")
    public Object getAnimatedValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1591888248 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1066200111 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1591888248 = mValues[0].getAnimatedValue();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1066200111 = null;
        Object varA7E53CE21691AB073D9660D615818899_1021225102; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1021225102 = varB4EAC82CA7396A68D541C85D26508E83_1591888248;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1021225102 = varB4EAC82CA7396A68D541C85D26508E83_1066200111;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1021225102.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1021225102;
        // ---------- Original Method ----------
        //if (mValues != null && mValues.length > 0) {
            //return mValues[0].getAnimatedValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.092 -0400", hash_original_method = "2B530B2B81FC1FAD77C53EC8863AE50E", hash_generated_method = "1038B1BD912D12A5C2F9FC28952E1F2F")
    public Object getAnimatedValue(String propertyName) {
        Object varB4EAC82CA7396A68D541C85D26508E83_142317038 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1838867426 = null; //Variable for return #2
        PropertyValuesHolder valuesHolder;
        valuesHolder = mValuesMap.get(propertyName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_142317038 = valuesHolder.getAnimatedValue();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1838867426 = null;
        } //End block
        addTaint(propertyName.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1921736557; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1921736557 = varB4EAC82CA7396A68D541C85D26508E83_142317038;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1921736557 = varB4EAC82CA7396A68D541C85D26508E83_1838867426;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1921736557.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1921736557;
        // ---------- Original Method ----------
        //PropertyValuesHolder valuesHolder = mValuesMap.get(propertyName);
        //if (valuesHolder != null) {
            //return valuesHolder.getAnimatedValue();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.096 -0400", hash_original_method = "4F2FB0A315DAA7A8B07A49F4FCE27399", hash_generated_method = "7098540AE96AF889E34ED53706CB0331")
    public void setRepeatCount(int value) {
        mRepeatCount = value;
        // ---------- Original Method ----------
        //mRepeatCount = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.111 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "C556F2CD8CE18D71BECC83A8DC429EB8")
    public int getRepeatCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290864348 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290864348;
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.122 -0400", hash_original_method = "C33D7F87842C98944308EC1438B3A8A7", hash_generated_method = "57CCF83DF3B3AF7C69315FCAF2E9D050")
    public void setRepeatMode(int value) {
        mRepeatMode = value;
        // ---------- Original Method ----------
        //mRepeatMode = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.124 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "6424AFAB02B28CB35DB2EB3AE5D3AD01")
    public int getRepeatMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917164005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917164005;
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.142 -0400", hash_original_method = "D2A8BFD752ECF80FCD3BD03F5B9AF68A", hash_generated_method = "5E7135EF2BA4C3F11D8555A731C33374")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.156 -0400", hash_original_method = "ABC42C9D08D6EB9E3E04E4FD12636CA0", hash_generated_method = "C442C719649EE8FF274F608780F8CCA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.167 -0400", hash_original_method = "E6D135867EE130F9CB4EA2C9507FABF5", hash_generated_method = "EE33A0F4BCBE2718C1E7AB1B01072D91")
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        mUpdateListeners.remove(listener);
        {
            boolean varA4B084E767DE55BA6AFD2DEBEB0A7784_832841636 = (mUpdateListeners.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.179 -0400", hash_original_method = "AF77FCDF6C80D02141639AFD7587863F", hash_generated_method = "4AD5CA0900FB4ADF922CC1530AE31746")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.197 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "18910143E591797A8C0937F9CE5604D7")
    public TimeInterpolator getInterpolator() {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_2111541557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2111541557 = mInterpolator;
        varB4EAC82CA7396A68D541C85D26508E83_2111541557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2111541557;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.202 -0400", hash_original_method = "BC30F1B6BC4F20E2E98ADFB4EC800F88", hash_generated_method = "D174E2891B05C4CB9C1E9C2CA05E9860")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.215 -0400", hash_original_method = "4B39A931455D340382CCAC7898FAB8D3", hash_generated_method = "00730FAD132C6DB5340531B93908B7C5")
    private void start(boolean playBackwards) {
        {
            boolean var607F99F94A9C3E729CF05A4C4A58ABDF_1803388125 = (Looper.myLooper() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:52.231 -0400", hash_original_method = "0E699EAEE0E759B00B92DBAE6A0AB7E1", hash_generated_method = "CF8459FD9743EB11F57C1D75490D5091")
    @Override
    public void start() {
        start(false);
        // ---------- Original Method ----------
        //start(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.277 -0400", hash_original_method = "5EC046ABFAD295E5D2C88DB1426702CD", hash_generated_method = "A72F8C4901728F89ED37E3BD12F8FF60")
    @Override
    public void cancel() {
        {
            boolean var58486F75E12966B52474E15F32795998_1059371753 = (mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                sDelayedAnims.get().contains(this));
            {
                {
                    ArrayList<AnimatorListener> tmpListeners;
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_393613645 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_393613645.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_393613645.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.297 -0400", hash_original_method = "55C31F194BE33B60E19FAC66D36F0F3B", hash_generated_method = "4A263C34EAD56F10211F5FA4B130AA0F")
    @Override
    public void end() {
        {
            boolean var421E56E1FD921FD2A83C6EC630885000_504804138 = (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.312 -0400", hash_original_method = "80FBC5A625B4BAB80C578CF39CB5DA5B", hash_generated_method = "89F7E34C8AFD567A86645B751CA69053")
    @Override
    public boolean isRunning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997186997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997186997;
        // ---------- Original Method ----------
        //return (mPlayingState == RUNNING || mRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.320 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "33D654F31E1992EED2BE1BAD6430A181")
    @Override
    public boolean isStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_751038979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_751038979;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.335 -0400", hash_original_method = "45B2842BAB0EB46941DD63C0EA48CBA2", hash_generated_method = "8464325B96E1EFED68EC2B8D5E769DF0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.352 -0400", hash_original_method = "634DE70818167FA9FFDD8CDDE693BD3B", hash_generated_method = "2EB139BF48A4C75A3B726709B4DB7799")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.371 -0400", hash_original_method = "45B9B57EC5A2CFD523C0E84592BD9EAC", hash_generated_method = "F8618324A6C1947DE7C36EAA7950B157")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.385 -0400", hash_original_method = "33DF90BAA846BB88E01B9C85165D068C", hash_generated_method = "7C8D0E32EF70FB8CE3A1C140D1970B60")
    private boolean delayedAnimationFrame(long currentTime) {
        {
            mStartedDelay = true;
            mDelayStartTime = currentTime;
        } //End block
        {
            long deltaTime;
            deltaTime = currentTime - mDelayStartTime;
            {
                mStartTime = currentTime - (deltaTime - mStartDelay);
                mPlayingState = RUNNING;
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1025785576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1025785576;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.453 -0400", hash_original_method = "101420F61878798EE86197F974BCAB89", hash_generated_method = "57058BB1D9E35AB25EEB4F7BDDAF416E")
     boolean animationFrame(long currentTime) {
        boolean done;
        done = false;
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1565965501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1565965501;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.462 -0400", hash_original_method = "7C3735DD08F0E37DA76BAA97A1C3802E", hash_generated_method = "6F0B2BAED4F263FFDF7B76B47CB50E7E")
    public float getAnimatedFraction() {
        float var546ADE640B6EDFBC8A086EF31347E768_912122390 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_912122390;
        // ---------- Original Method ----------
        //return mCurrentFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.470 -0400", hash_original_method = "64FBD5BD2598ED0D273DFF76320B41E6", hash_generated_method = "B174E9DEE8013A1612E125B9AA6C5E92")
     void animateValue(float fraction) {
        fraction = mInterpolator.getInterpolation(fraction);
        mCurrentFraction = fraction;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.537 -0400", hash_original_method = "E24942BE7DE3A089D4AA1F8054FFC13E", hash_generated_method = "AA1441A7E079F4F629395F1E5F2F7CA5")
    @Override
    public ValueAnimator clone() {
        ValueAnimator varB4EAC82CA7396A68D541C85D26508E83_157346445 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_157346445 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_157346445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_157346445;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.565 -0400", hash_original_method = "533F41B1624628F4A2CEF95F44B8AA6B", hash_generated_method = "EF2867392B46D21BFD9EA8ADBAE57354")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1690512425 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1690512425 = returnVal;
        varB4EAC82CA7396A68D541C85D26508E83_1690512425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1690512425;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.566 -0400", hash_original_method = "2DEE4CFD7471B34E056063BEAD8FACC4", hash_generated_method = "2DEE4CFD7471B34E056063BEAD8FACC4")
        public AnimationHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.634 -0400", hash_original_method = "52F201F0F7E1BD7680ACD711BB668600", hash_generated_method = "F73F94B79510A05DB8C972BBC1D4C716")
        @Override
        public void handleMessage(Message msg) {
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
                boolean varA1F5D09ABD5BA1EAA9064BD2C7F540A0_2004809838 = (animations.size() > 0 || delayedAnims.size() > 0);
                {
                    callAgain = false;
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_START 
            //Begin case ANIMATION_START 
            {
                boolean var310842A70C8547E073B963714355E2EF_2109725557 = (pendingAnimations.size() > 0);
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
                        boolean var5A6A4AC41707EA57AE87A5C33A49358D_900863128 = (anim.delayedAnimationFrame(currentTime));
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
                    boolean varB2157FB20628670967962D499113FAB2_366455967 = (anim.animationFrame(currentTime));
                    {
                        endingAnims.add(anim);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varB2E9B25FC12B68A819E499BFA350E9C9_298232487 = (animations.size() == numAnims);
                    {
                        endingAnims.remove(anim);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                boolean var24F884196EA732DACEFF40751A202210_201965041 = (endingAnims.size() > 0);
                {
                    {
                        i = 0;
                        boolean var680A26EFE24B5CA3CBE89BBC9415413A_1956284356 = (i < endingAnims.size());
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
                boolean var8A9BF7DDA394FFB721509F4D19C0EAE3_985511274 = (callAgain && (!animations.isEmpty() || !delayedAnims.isEmpty()));
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.647 -0400", hash_original_field = "19C300A967EA25F9D559F955E00792C9", hash_generated_field = "CB37D4BBAF0C3007EE89D606EC40D46E")

    private static long DEFAULT_FRAME_DELAY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.648 -0400", hash_original_field = "0D7E68A8285D57CCE4D86E51B69846C6", hash_generated_field = "8DB85D57A755DFF1B2BD312B26AE84AC")

    static int ANIMATION_START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.648 -0400", hash_original_field = "E6CA3E401C4A7A7E6AF52E70B57FDFB1", hash_generated_field = "2107DA520BA95F9C06114AA6337E6C39")

    static int ANIMATION_FRAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.664 -0400", hash_original_field = "94992C68B07F926E36FA460B8902EACC", hash_generated_field = "601060F93103F60EBABAE3676228D730")

    static int STOPPED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.665 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "88602DC17E0B71B007B3E69EDD897660")

    static int RUNNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.665 -0400", hash_original_field = "0F6D75AE6BB844EFE3A8E4551071CD49", hash_generated_field = "E86721B01A734AACDF9D45143C1492D8")

    static int SEEKED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.666 -0400", hash_original_field = "B4A7D055BAB8301E2C8667A28C9D013B", hash_generated_field = "298BE37EE0C7369286A3ABAA61580A61")

    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<AnimationHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.686 -0400", hash_original_field = "3C37B16155D9D4A0309FE675F3A94C61", hash_generated_field = "7AC747D2E7807FC341876C22A13AFD56")

    private static ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.685 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "914A18DC6DDC57DF3D0B8C2E8E007B06")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_790291129 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_790291129 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_790291129.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_790291129;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.703 -0400", hash_original_field = "3CAB4DC1D9F9A2C4E0E643C552FB8B5A", hash_generated_field = "F52E7DC22FB0E7435072FCF3C96DF361")

    private static ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.702 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "AB916B9500C452E411289093080DE1C3")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1184749940 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1184749940 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1184749940.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1184749940;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.732 -0400", hash_original_field = "1ACEA9A643A2CAF5FE528C380BB8CF14", hash_generated_field = "817063C4AA0903CE3E70A2EFB3D47E63")

    private static ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.722 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "1A388EE42CE49C588884A8303F54E924")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_741090877 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_741090877 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_741090877.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_741090877;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.748 -0400", hash_original_field = "DE94AD3F45FD0B9D4CDA700DC5CD404B", hash_generated_field = "C9C914509D653CA9F924D291D68CCEFA")

    private static ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.747 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "DDCE2D19805E23404CCEE1FE4D6C7A19")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_88497127 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_88497127 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_88497127.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_88497127;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.769 -0400", hash_original_field = "255441D2B8970E34EB230C059292860D", hash_generated_field = "AF0A0B5B6512E1794F206DA8FD788A47")

    private static ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.768 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "2219EA6FBCB1EF4C1ADCADBDA6142759")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_614542265 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_614542265 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_614542265.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_614542265;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.770 -0400", hash_original_field = "CAB4CFDA656A41124CB58DC84DFC5E60", hash_generated_field = "A22DC92EFAB5D0B7B98C34F66C7523A2")

    private static TimeInterpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.770 -0400", hash_original_field = "524C52C0A1E88CDA180A0F7AA6118606", hash_generated_field = "30E5C223A9B6F778F4F421C7D3106909")

    private static TypeEvaluator sIntEvaluator = new IntEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.789 -0400", hash_original_field = "15DEFED28FFB599464BB68C200695E4F", hash_generated_field = "7AEBE35D2A556DA8460D794234916F05")

    private static TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.790 -0400", hash_original_field = "645DD1C3FAB37420AA3AF59AEC271373", hash_generated_field = "B136BC014A7EC92E31D514350E48B057")

    private static long sFrameDelay = DEFAULT_FRAME_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.798 -0400", hash_original_field = "5F06E0F5187ED0CBFC4EF9E7B4D64EDE", hash_generated_field = "9FE7B7E5ED52768DD1C53DC895EC1A0D")

    public static final int RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.799 -0400", hash_original_field = "6BAA62FAC35E1F188A65C74FED662C34", hash_generated_field = "6790E6439C0E7615743240DF9A7C010E")

    public static final int REVERSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.800 -0400", hash_original_field = "5E2F9BDAA8CE14DD954BF40FD55E2AF3", hash_generated_field = "285D35A4B336A34C53955AE44424AC64")

    public static final int INFINITE = -1;
}

