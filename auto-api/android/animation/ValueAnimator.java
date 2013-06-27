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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.145 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

    long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.151 -0400", hash_original_field = "21F0A5E67D578B871CE4890BB4301938", hash_generated_field = "4E1645CE3651AE4D866A4E97769672FC")

    long mSeekTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.152 -0400", hash_original_field = "C36D028293D9AEB21CE372B528F12B7D", hash_generated_field = "25D0DF5A7C1B0B40E8B3204C90423678")

    private boolean mPlayingBackwards = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.154 -0400", hash_original_field = "24FDF63EDEAC7BEE43B5C4C5591E8865", hash_generated_field = "4C9D53155FF73BA27011D6E7DB3AD10B")

    private int mCurrentIteration = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.155 -0400", hash_original_field = "C2F7E02BDA00B17A8F988AB57AA22BF9", hash_generated_field = "8A50A9EB094A19AFEFAE9DD764A21B61")

    private float mCurrentFraction = 0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.157 -0400", hash_original_field = "CC68149CDA21F68465AA90F07F5D95CC", hash_generated_field = "E6BC29DFE32B95A7746A3240D4908F49")

    private boolean mStartedDelay = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.165 -0400", hash_original_field = "4990509A1CCCA8D89E912983C67DFF20", hash_generated_field = "99C0D1839DB2E0976F6365DA96527AB3")

    private long mDelayStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.167 -0400", hash_original_field = "9950F1CC6304A23A1DF3E99C55CB4013", hash_generated_field = "8F8CC3CA50EF97884C628BBEA63AE150")

    int mPlayingState = STOPPED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.169 -0400", hash_original_field = "62A2DC3D8C5F735AB3A7DFD6D4A40243", hash_generated_field = "BF66F685C8DAD91C6D305A2AD45B0022")

    private boolean mRunning = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.172 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.173 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "D7228C282593CDC77734D668B23541D3")

    boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.175 -0400", hash_original_field = "278AF3A57BE580604E764F8A9A2B780D", hash_generated_field = "7C681C473ED41389A77BB70A2C4D72CE")

    private long mDuration = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.176 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.178 -0400", hash_original_field = "7400544E99BDB4AB399DABF03F346DE6", hash_generated_field = "86BE2F843C53DE337B277203FC4ABA75")

    private int mRepeatCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.185 -0400", hash_original_field = "31336EA85735F5B517DD430F87691118", hash_generated_field = "D8AE514964A82408D2EBFBBF132AAE13")

    private int mRepeatMode = RESTART;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.187 -0400", hash_original_field = "ED64FCC69138AB0D151E83CCFCFE975A", hash_generated_field = "42D7E84F8F4EF4F62C2A90763184E4DB")

    private TimeInterpolator mInterpolator = sDefaultInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.190 -0400", hash_original_field = "6141FE189AA3625489E2AE5CC67F512B", hash_generated_field = "413346BD5600531FF965862127DA0D01")

    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.193 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "E200C2BDFC70B9C579B8C490F170F688")

    PropertyValuesHolder[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.195 -0400", hash_original_field = "DEA90B16C4F0F78E79C71A2F9BB8975C", hash_generated_field = "AF5FC8A22004016791392366FC7AA458")

    HashMap<String, PropertyValuesHolder> mValuesMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.201 -0400", hash_original_method = "17A6701FB198CD0BD584AB7A0EFE3839", hash_generated_method = "1E0F7AE0C295B96E8122202378305CF8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.230 -0400", hash_original_method = "67525E8968A6999074D725B8947CD2FE", hash_generated_method = "785D0EE3A4ECBCA5AE2754E06572ABE6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.242 -0400", hash_original_method = "D733778AA31410A94B9571EEAAECBB30", hash_generated_method = "F79304EA4A6737FAC7478A9AEA3EDE98")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.255 -0400", hash_original_method = "AAE460ECCCBF6E694CF45A2F7BA85BA5", hash_generated_method = "90DDBEA99C76CC43224E495EBCA2E2BA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.276 -0400", hash_original_method = "D9E3FD9EEAA02CD647DC7AEFD5007E3A", hash_generated_method = "6FC38FE964567B5044063E6BCF26CF8D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.289 -0400", hash_original_method = "78A6AA7AD01513781B120BCE5DC9E156", hash_generated_method = "E2F19A876561428C8E97DBD4D0D90754")
    public PropertyValuesHolder[] getValues() {
        PropertyValuesHolder[] varB4EAC82CA7396A68D541C85D26508E83_768074776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_768074776 = mValues;
        varB4EAC82CA7396A68D541C85D26508E83_768074776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_768074776;
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.300 -0400", hash_original_method = "1534ECD6905850E5B269582384A75673", hash_generated_method = "6BBF6129DA30B7815375213690CEA17F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.316 -0400", hash_original_method = "622DE942E3334D786E7FE8DBF49B30DE", hash_generated_method = "B0B5C3A430F8E2F8B75286D446B79497")
    public ValueAnimator setDuration(long duration) {
        ValueAnimator varB4EAC82CA7396A68D541C85D26508E83_380540447 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
        } //End block
        mDuration = duration;
        varB4EAC82CA7396A68D541C85D26508E83_380540447 = this;
        varB4EAC82CA7396A68D541C85D26508E83_380540447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_380540447;
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("Animators cannot have negative duration: " +
                    //duration);
        //}
        //mDuration = duration;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.326 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "5C27F06C7D1E472796975FE4ACE8BC34")
    public long getDuration() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_733770035 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_733770035;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.340 -0400", hash_original_method = "9366966ECC70650E5B5651EBD3539ED0", hash_generated_method = "C26F6E435DF60DD647F1AD2EF60B2CB2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.351 -0400", hash_original_method = "68655250B160F78BB8C6212DC5765131", hash_generated_method = "C94FE7A9E916E67B879F427CBBB9FBFD")
    public long getCurrentPlayTime() {
        long var6F61F9B0364A4D245BC9CF0ACBEF5BEE_1010439125 = (AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_451935424 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_451935424;
        // ---------- Original Method ----------
        //if (!mInitialized || mPlayingState == STOPPED) {
            //return 0;
        //}
        //return AnimationUtils.currentAnimationTimeMillis() - mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.359 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "5993267D6788142B11FD8DFD250554EF")
    public long getStartDelay() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2099099188 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2099099188;
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.371 -0400", hash_original_method = "84D20D1DEBEAE9C7FDE98EA5D287F4D2", hash_generated_method = "FAC2ECF430C77C663A5F61FD6D4BD7CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.390 -0400", hash_original_method = "3CBE561BBB42AB3DB3CAF9B67D05776D", hash_generated_method = "C9B9FAE117BF775D9543166D116417B9")
    public Object getAnimatedValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1994771056 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1579130137 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1994771056 = mValues[0].getAnimatedValue();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1579130137 = null;
        Object varA7E53CE21691AB073D9660D615818899_1229600646; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1229600646 = varB4EAC82CA7396A68D541C85D26508E83_1994771056;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1229600646 = varB4EAC82CA7396A68D541C85D26508E83_1579130137;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1229600646.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1229600646;
        // ---------- Original Method ----------
        //if (mValues != null && mValues.length > 0) {
            //return mValues[0].getAnimatedValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.410 -0400", hash_original_method = "2B530B2B81FC1FAD77C53EC8863AE50E", hash_generated_method = "87D74E10667F9FFD490D224042775ED0")
    public Object getAnimatedValue(String propertyName) {
        Object varB4EAC82CA7396A68D541C85D26508E83_924474700 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1967859513 = null; //Variable for return #2
        PropertyValuesHolder valuesHolder;
        valuesHolder = mValuesMap.get(propertyName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_924474700 = valuesHolder.getAnimatedValue();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1967859513 = null;
        } //End block
        addTaint(propertyName.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1700740543; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1700740543 = varB4EAC82CA7396A68D541C85D26508E83_924474700;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1700740543 = varB4EAC82CA7396A68D541C85D26508E83_1967859513;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1700740543.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1700740543;
        // ---------- Original Method ----------
        //PropertyValuesHolder valuesHolder = mValuesMap.get(propertyName);
        //if (valuesHolder != null) {
            //return valuesHolder.getAnimatedValue();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.420 -0400", hash_original_method = "4F2FB0A315DAA7A8B07A49F4FCE27399", hash_generated_method = "7098540AE96AF889E34ED53706CB0331")
    public void setRepeatCount(int value) {
        mRepeatCount = value;
        // ---------- Original Method ----------
        //mRepeatCount = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.429 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "3BC4FA9580061BDE1DB29D290AFDB80D")
    public int getRepeatCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321516809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321516809;
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.437 -0400", hash_original_method = "C33D7F87842C98944308EC1438B3A8A7", hash_generated_method = "57CCF83DF3B3AF7C69315FCAF2E9D050")
    public void setRepeatMode(int value) {
        mRepeatMode = value;
        // ---------- Original Method ----------
        //mRepeatMode = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.444 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "8977F20296C1ABCA5215DF26DC1C5024")
    public int getRepeatMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402767380 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402767380;
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.455 -0400", hash_original_method = "D2A8BFD752ECF80FCD3BD03F5B9AF68A", hash_generated_method = "5E7135EF2BA4C3F11D8555A731C33374")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.463 -0400", hash_original_method = "ABC42C9D08D6EB9E3E04E4FD12636CA0", hash_generated_method = "C442C719649EE8FF274F608780F8CCA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.477 -0400", hash_original_method = "E6D135867EE130F9CB4EA2C9507FABF5", hash_generated_method = "4DFE958DDB587D17685CA9CB85D7C68A")
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        mUpdateListeners.remove(listener);
        {
            boolean varA4B084E767DE55BA6AFD2DEBEB0A7784_1907039668 = (mUpdateListeners.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.488 -0400", hash_original_method = "AF77FCDF6C80D02141639AFD7587863F", hash_generated_method = "4AD5CA0900FB4ADF922CC1530AE31746")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.497 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "68C41C789D82729FB52EF7E92A308C2D")
    public TimeInterpolator getInterpolator() {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_688850456 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_688850456 = mInterpolator;
        varB4EAC82CA7396A68D541C85D26508E83_688850456.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_688850456;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.507 -0400", hash_original_method = "BC30F1B6BC4F20E2E98ADFB4EC800F88", hash_generated_method = "D174E2891B05C4CB9C1E9C2CA05E9860")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.558 -0400", hash_original_method = "4B39A931455D340382CCAC7898FAB8D3", hash_generated_method = "0CC8FAA4D9A53160AFC4F1CED7537737")
    private void start(boolean playBackwards) {
        {
            boolean var607F99F94A9C3E729CF05A4C4A58ABDF_299254614 = (Looper.myLooper() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:53.569 -0400", hash_original_method = "0E699EAEE0E759B00B92DBAE6A0AB7E1", hash_generated_method = "CF8459FD9743EB11F57C1D75490D5091")
    @Override
    public void start() {
        start(false);
        // ---------- Original Method ----------
        //start(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.127 -0400", hash_original_method = "5EC046ABFAD295E5D2C88DB1426702CD", hash_generated_method = "12CC3F68ED533E269630AFD52278F3E4")
    @Override
    public void cancel() {
        {
            boolean var58486F75E12966B52474E15F32795998_1224821263 = (mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                sDelayedAnims.get().contains(this));
            {
                {
                    ArrayList<AnimatorListener> tmpListeners;
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_1861355235 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_1861355235.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_1861355235.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.144 -0400", hash_original_method = "55C31F194BE33B60E19FAC66D36F0F3B", hash_generated_method = "E8A3676F1934FDC0A92DC32D2B4B04B8")
    @Override
    public void end() {
        {
            boolean var421E56E1FD921FD2A83C6EC630885000_57598411 = (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.157 -0400", hash_original_method = "80FBC5A625B4BAB80C578CF39CB5DA5B", hash_generated_method = "E8F34AC77D5AF39A5F93AD57D502034B")
    @Override
    public boolean isRunning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754316751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754316751;
        // ---------- Original Method ----------
        //return (mPlayingState == RUNNING || mRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.176 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "BA288CF94E65B94CE98B25BF23E76D18")
    @Override
    public boolean isStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299503533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_299503533;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.179 -0400", hash_original_method = "45B2842BAB0EB46941DD63C0EA48CBA2", hash_generated_method = "8464325B96E1EFED68EC2B8D5E769DF0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.231 -0400", hash_original_method = "634DE70818167FA9FFDD8CDDE693BD3B", hash_generated_method = "2EB139BF48A4C75A3B726709B4DB7799")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.263 -0400", hash_original_method = "45B9B57EC5A2CFD523C0E84592BD9EAC", hash_generated_method = "F8618324A6C1947DE7C36EAA7950B157")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.299 -0400", hash_original_method = "33DF90BAA846BB88E01B9C85165D068C", hash_generated_method = "18B466860AAAC88C10FB84395F77C60A")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71328876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_71328876;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.348 -0400", hash_original_method = "101420F61878798EE86197F974BCAB89", hash_generated_method = "787668FDC8413FCB19570A4D243B5986")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614418646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614418646;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.359 -0400", hash_original_method = "7C3735DD08F0E37DA76BAA97A1C3802E", hash_generated_method = "5ED85244CC1F340BFCDF891509C245C8")
    public float getAnimatedFraction() {
        float var546ADE640B6EDFBC8A086EF31347E768_113104066 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_113104066;
        // ---------- Original Method ----------
        //return mCurrentFraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.378 -0400", hash_original_method = "64FBD5BD2598ED0D273DFF76320B41E6", hash_generated_method = "B174E9DEE8013A1612E125B9AA6C5E92")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.428 -0400", hash_original_method = "E24942BE7DE3A089D4AA1F8054FFC13E", hash_generated_method = "F3600B1A27BB65CC872A4EFA46332535")
    @Override
    public ValueAnimator clone() {
        ValueAnimator varB4EAC82CA7396A68D541C85D26508E83_210566999 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_210566999 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_210566999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_210566999;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.456 -0400", hash_original_method = "533F41B1624628F4A2CEF95F44B8AA6B", hash_generated_method = "4ADEB3AF38C2D309C025F0D7A839D0A3")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_559547171 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_559547171 = returnVal;
        varB4EAC82CA7396A68D541C85D26508E83_559547171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_559547171;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.457 -0400", hash_original_method = "2DEE4CFD7471B34E056063BEAD8FACC4", hash_generated_method = "2DEE4CFD7471B34E056063BEAD8FACC4")
        public AnimationHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.519 -0400", hash_original_method = "52F201F0F7E1BD7680ACD711BB668600", hash_generated_method = "469C0A6135CFDBFAB6085FA259AA70C3")
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
                boolean varA1F5D09ABD5BA1EAA9064BD2C7F540A0_2139089329 = (animations.size() > 0 || delayedAnims.size() > 0);
                {
                    callAgain = false;
                } //End block
            } //End collapsed parenthetic
            //End case ANIMATION_START 
            //Begin case ANIMATION_START 
            {
                boolean var310842A70C8547E073B963714355E2EF_112607741 = (pendingAnimations.size() > 0);
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
                        boolean var5A6A4AC41707EA57AE87A5C33A49358D_2119569385 = (anim.delayedAnimationFrame(currentTime));
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
                    boolean varB2157FB20628670967962D499113FAB2_114993872 = (anim.animationFrame(currentTime));
                    {
                        endingAnims.add(anim);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varB2E9B25FC12B68A819E499BFA350E9C9_377321479 = (animations.size() == numAnims);
                    {
                        endingAnims.remove(anim);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case ANIMATION_FRAME 
            //Begin case ANIMATION_FRAME 
            {
                boolean var24F884196EA732DACEFF40751A202210_596015661 = (endingAnims.size() > 0);
                {
                    {
                        i = 0;
                        boolean var680A26EFE24B5CA3CBE89BBC9415413A_1093471743 = (i < endingAnims.size());
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
                boolean var8A9BF7DDA394FFB721509F4D19C0EAE3_1796068755 = (callAgain && (!animations.isEmpty() || !delayedAnims.isEmpty()));
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.532 -0400", hash_original_field = "19C300A967EA25F9D559F955E00792C9", hash_generated_field = "CB37D4BBAF0C3007EE89D606EC40D46E")

    private static long DEFAULT_FRAME_DELAY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.533 -0400", hash_original_field = "0D7E68A8285D57CCE4D86E51B69846C6", hash_generated_field = "8DB85D57A755DFF1B2BD312B26AE84AC")

    static int ANIMATION_START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.534 -0400", hash_original_field = "E6CA3E401C4A7A7E6AF52E70B57FDFB1", hash_generated_field = "2107DA520BA95F9C06114AA6337E6C39")

    static int ANIMATION_FRAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.544 -0400", hash_original_field = "94992C68B07F926E36FA460B8902EACC", hash_generated_field = "601060F93103F60EBABAE3676228D730")

    static int STOPPED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.545 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "88602DC17E0B71B007B3E69EDD897660")

    static int RUNNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.546 -0400", hash_original_field = "0F6D75AE6BB844EFE3A8E4551071CD49", hash_generated_field = "E86721B01A734AACDF9D45143C1492D8")

    static int SEEKED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.560 -0400", hash_original_field = "B4A7D055BAB8301E2C8667A28C9D013B", hash_generated_field = "298BE37EE0C7369286A3ABAA61580A61")

    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<AnimationHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.564 -0400", hash_original_field = "3C37B16155D9D4A0309FE675F3A94C61", hash_generated_field = "60CB3ACDD05354944116449C2E09ACD5")

    private static ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.563 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "063D6A7595604E9AC3460702A5492E02")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1668353731 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1668353731 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1668353731.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1668353731;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.581 -0400", hash_original_field = "3CAB4DC1D9F9A2C4E0E643C552FB8B5A", hash_generated_field = "FCD78A91AFC020CFC08AA2705BF98C64")

    private static ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.580 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "9554A043CC3E7EC5AC2F571E808C396A")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1265417533 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1265417533 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1265417533.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1265417533;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.596 -0400", hash_original_field = "1ACEA9A643A2CAF5FE528C380BB8CF14", hash_generated_field = "4B1799FADE8F499D6D09E624712C7B54")

    private static ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.594 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "B65C7D7F681BDF2C0E6492ECC83AD7AF")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_874491379 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_874491379 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_874491379.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_874491379;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.631 -0400", hash_original_field = "DE94AD3F45FD0B9D4CDA700DC5CD404B", hash_generated_field = "BE891002227C539DD68E900BDF35765A")

    private static ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.630 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "DD7AAD1F48DBF996266A1378EF1495D8")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_379383564 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_379383564 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_379383564.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_379383564;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.653 -0400", hash_original_field = "255441D2B8970E34EB230C059292860D", hash_generated_field = "2115AFD7F067E16861767091263F80D7")

    private static ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.652 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "039DDDD82DE2E28B2193F95036DB1E99")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1525812342 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1525812342 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1525812342.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1525812342;
            // ---------- Original Method ----------
            //return new ArrayList<ValueAnimator>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.654 -0400", hash_original_field = "CAB4CFDA656A41124CB58DC84DFC5E60", hash_generated_field = "A22DC92EFAB5D0B7B98C34F66C7523A2")

    private static TimeInterpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.660 -0400", hash_original_field = "524C52C0A1E88CDA180A0F7AA6118606", hash_generated_field = "30E5C223A9B6F778F4F421C7D3106909")

    private static TypeEvaluator sIntEvaluator = new IntEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.660 -0400", hash_original_field = "15DEFED28FFB599464BB68C200695E4F", hash_generated_field = "7AEBE35D2A556DA8460D794234916F05")

    private static TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.661 -0400", hash_original_field = "645DD1C3FAB37420AA3AF59AEC271373", hash_generated_field = "B136BC014A7EC92E31D514350E48B057")

    private static long sFrameDelay = DEFAULT_FRAME_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.678 -0400", hash_original_field = "5F06E0F5187ED0CBFC4EF9E7B4D64EDE", hash_generated_field = "9FE7B7E5ED52768DD1C53DC895EC1A0D")

    public static final int RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.679 -0400", hash_original_field = "6BAA62FAC35E1F188A65C74FED662C34", hash_generated_field = "6790E6439C0E7615743240DF9A7C010E")

    public static final int REVERSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.690 -0400", hash_original_field = "5E2F9BDAA8CE14DD954BF40FD55E2AF3", hash_generated_field = "285D35A4B336A34C53955AE44424AC64")

    public static final int INFINITE = -1;
}

