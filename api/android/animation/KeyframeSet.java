package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import android.animation.Keyframe.IntKeyframe;
import android.animation.Keyframe.FloatKeyframe;
import android.animation.Keyframe.ObjectKeyframe;

class KeyframeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.099 -0400", hash_original_field = "8ABE62D0F4315FED9AFE09DF6C0B1969", hash_generated_field = "546EF363B5340CFFE8BC4CB61B7D7CDB")

    int mNumKeyframes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.100 -0400", hash_original_field = "E48CE21BD60568B86C76E1FEB178AD19", hash_generated_field = "F25CCAD87898D140299C8AD61CC00E6F")

    Keyframe mFirstKeyframe;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.100 -0400", hash_original_field = "065059589B03CCB77854AA308BE2FD37", hash_generated_field = "FAFDAB3E74D0E176CA60E56E1C9BCFAE")

    Keyframe mLastKeyframe;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.100 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "E4914FA8D762AE766FD60D6E9561C2E8")

    TimeInterpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.100 -0400", hash_original_field = "2E64EE21B3126F8C2918F39C513A3742", hash_generated_field = "D35BC99293A28124030816692F50EE53")

    ArrayList<Keyframe> mKeyframes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.101 -0400", hash_original_field = "A5A16062C8CFDCD2D78B97324D59FBBD", hash_generated_field = "FEF5736B09891D2FD2D8C1BD6C28F3AE")

    TypeEvaluator mEvaluator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.103 -0400", hash_original_method = "AC41B3CB583B4F8C00E3AFE9CCF7C554", hash_generated_method = "0033E58342FA6F951E2956BE1152FEB3")
    public  KeyframeSet(Keyframe... keyframes) {
        mNumKeyframes = keyframes.length;
        mKeyframes = new ArrayList<Keyframe>();
        mKeyframes.addAll(Arrays.asList(keyframes));
        mFirstKeyframe = mKeyframes.get(0);
        mLastKeyframe = mKeyframes.get(mNumKeyframes - 1);
        mInterpolator = mLastKeyframe.getInterpolator();
        
        
        
        
        
        
        
    }

    
    public static KeyframeSet ofInt(int... values) {
        int numKeyframes = values.length;
        IntKeyframe keyframes[] = new IntKeyframe[Math.max(numKeyframes,2)];
        if (numKeyframes == 1) {
            keyframes[0] = (IntKeyframe) Keyframe.ofInt(0f);
            keyframes[1] = (IntKeyframe) Keyframe.ofInt(1f, values[0]);
        } else {
            keyframes[0] = (IntKeyframe) Keyframe.ofInt(0f, values[0]);
            for (int i = 1; i < numKeyframes; ++i) {
                keyframes[i] = (IntKeyframe) Keyframe.ofInt((float) i / (numKeyframes - 1), values[i]);
            }
        }
        return new IntKeyframeSet(keyframes);
    }

    
    public static KeyframeSet ofFloat(float... values) {
        int numKeyframes = values.length;
        FloatKeyframe keyframes[] = new FloatKeyframe[Math.max(numKeyframes,2)];
        if (numKeyframes == 1) {
            keyframes[0] = (FloatKeyframe) Keyframe.ofFloat(0f);
            keyframes[1] = (FloatKeyframe) Keyframe.ofFloat(1f, values[0]);
        } else {
            keyframes[0] = (FloatKeyframe) Keyframe.ofFloat(0f, values[0]);
            for (int i = 1; i < numKeyframes; ++i) {
                keyframes[i] = (FloatKeyframe) Keyframe.ofFloat((float) i / (numKeyframes - 1), values[i]);
            }
        }
        return new FloatKeyframeSet(keyframes);
    }

    
    public static KeyframeSet ofKeyframe(Keyframe... keyframes) {
        int numKeyframes = keyframes.length;
        boolean hasFloat = false;
        boolean hasInt = false;
        boolean hasOther = false;
        for (int i = 0; i < numKeyframes; ++i) {
            if (keyframes[i] instanceof FloatKeyframe) {
                hasFloat = true;
            } else if (keyframes[i] instanceof IntKeyframe) {
                hasInt = true;
            } else {
                hasOther = true;
            }
        }
        if (hasFloat && !hasInt && !hasOther) {
            FloatKeyframe floatKeyframes[] = new FloatKeyframe[numKeyframes];
            for (int i = 0; i < numKeyframes; ++i) {
                floatKeyframes[i] = (FloatKeyframe) keyframes[i];
            }
            return new FloatKeyframeSet(floatKeyframes);
        } else if (hasInt && !hasFloat && !hasOther) {
            IntKeyframe intKeyframes[] = new IntKeyframe[numKeyframes];
            for (int i = 0; i < numKeyframes; ++i) {
                intKeyframes[i] = (IntKeyframe) keyframes[i];
            }
            return new IntKeyframeSet(intKeyframes);
        } else {
            return new KeyframeSet(keyframes);
        }
    }

    
    public static KeyframeSet ofObject(Object... values) {
        int numKeyframes = values.length;
        ObjectKeyframe keyframes[] = new ObjectKeyframe[Math.max(numKeyframes,2)];
        if (numKeyframes == 1) {
            keyframes[0] = (ObjectKeyframe) Keyframe.ofObject(0f);
            keyframes[1] = (ObjectKeyframe) Keyframe.ofObject(1f, values[0]);
        } else {
            keyframes[0] = (ObjectKeyframe) Keyframe.ofObject(0f, values[0]);
            for (int i = 1; i < numKeyframes; ++i) {
                keyframes[i] = (ObjectKeyframe) Keyframe.ofObject((float) i / (numKeyframes - 1), values[i]);
            }
        }
        return new KeyframeSet(keyframes);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.109 -0400", hash_original_method = "EEDF4BFC49E3BB0A5C905B0E8446FBFF", hash_generated_method = "B27A43CC2EED297119DEAFB17EFEE8BB")
    public void setEvaluator(TypeEvaluator evaluator) {
        mEvaluator = evaluator;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.114 -0400", hash_original_method = "852EEF0AADF480969C7D66EC6180E295", hash_generated_method = "8D747ED419FCBCE3C5C4EBA582665734")
    @Override
    public KeyframeSet clone() {
        KeyframeSet varB4EAC82CA7396A68D541C85D26508E83_50263845 = null; 
        ArrayList<Keyframe> keyframes = mKeyframes;
        int numKeyframes = mKeyframes.size();
        Keyframe[] newKeyframes = new Keyframe[numKeyframes];
        {
            int i = 0;
            {
                newKeyframes[i] = keyframes.get(i).clone();
            } 
        } 
        KeyframeSet newSet = new KeyframeSet(newKeyframes);
        varB4EAC82CA7396A68D541C85D26508E83_50263845 = newSet;
        varB4EAC82CA7396A68D541C85D26508E83_50263845.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_50263845;
        
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.131 -0400", hash_original_method = "80AFA2A1CA8ECB40318B145A78C4EE8C", hash_generated_method = "66C47B28622429BA1AA19F75BF02FEA9")
    public Object getValue(float fraction) {
        Object varB4EAC82CA7396A68D541C85D26508E83_446268573 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_667974857 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_2011659491 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1964158152 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1489095159 = null; 
        {
            {
                fraction = mInterpolator.getInterpolation(fraction);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_446268573 = mEvaluator.evaluate(fraction, mFirstKeyframe.getValue(),
                    mLastKeyframe.getValue());
        } 
        {
            final Keyframe nextKeyframe = mKeyframes.get(1);
            final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
            {
                fraction = interpolator.getInterpolation(fraction);
            } 
            final float prevFraction = mFirstKeyframe.getFraction();
            float intervalFraction = (fraction - prevFraction) /
                (nextKeyframe.getFraction() - prevFraction);
            varB4EAC82CA7396A68D541C85D26508E83_667974857 = mEvaluator.evaluate(intervalFraction, mFirstKeyframe.getValue(),
                    nextKeyframe.getValue());
        } 
        {
            final Keyframe prevKeyframe = mKeyframes.get(mNumKeyframes - 2);
            final TimeInterpolator interpolator = mLastKeyframe.getInterpolator();
            {
                fraction = interpolator.getInterpolation(fraction);
            } 
            final float prevFraction = prevKeyframe.getFraction();
            float intervalFraction = (fraction - prevFraction) /
                (mLastKeyframe.getFraction() - prevFraction);
            varB4EAC82CA7396A68D541C85D26508E83_2011659491 = mEvaluator.evaluate(intervalFraction, prevKeyframe.getValue(),
                    mLastKeyframe.getValue());
        } 
        Keyframe prevKeyframe = mFirstKeyframe;
        {
            int i = 1;
            {
                Keyframe nextKeyframe = mKeyframes.get(i);
                {
                    boolean var6EBE8138E05C6E6707EE379D88735F94_1382036768 = (fraction < nextKeyframe.getFraction());
                    {
                        final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
                        {
                            fraction = interpolator.getInterpolation(fraction);
                        } 
                        final float prevFraction = prevKeyframe.getFraction();
                        float intervalFraction = (fraction - prevFraction) /
                    (nextKeyframe.getFraction() - prevFraction);
                        varB4EAC82CA7396A68D541C85D26508E83_1964158152 = mEvaluator.evaluate(intervalFraction, prevKeyframe.getValue(),
                        nextKeyframe.getValue());
                    } 
                } 
                prevKeyframe = nextKeyframe;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1489095159 = mLastKeyframe.getValue();
        addTaint(fraction);
        Object varA7E53CE21691AB073D9660D615818899_1517767645; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1517767645 = varB4EAC82CA7396A68D541C85D26508E83_446268573;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1517767645 = varB4EAC82CA7396A68D541C85D26508E83_667974857;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1517767645 = varB4EAC82CA7396A68D541C85D26508E83_2011659491;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1517767645 = varB4EAC82CA7396A68D541C85D26508E83_1964158152;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1517767645 = varB4EAC82CA7396A68D541C85D26508E83_1489095159;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1517767645.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1517767645;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.139 -0400", hash_original_method = "5AFB3B0DBEF799B422062A71D978DCE0", hash_generated_method = "B99EE04504F4DDEFB1BEF67ADF49B848")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1102566748 = null; 
        String returnVal = " ";
        {
            int i = 0;
            {
                returnVal += mKeyframes.get(i).getValue() + "  ";
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1102566748 = returnVal;
        varB4EAC82CA7396A68D541C85D26508E83_1102566748.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1102566748;
        
        
        
            
        
        
    }

    
}

