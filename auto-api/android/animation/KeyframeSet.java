package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import android.animation.Keyframe.IntKeyframe;
import android.animation.Keyframe.FloatKeyframe;
import android.animation.Keyframe.ObjectKeyframe;

class KeyframeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.071 -0400", hash_original_field = "8ABE62D0F4315FED9AFE09DF6C0B1969", hash_generated_field = "546EF363B5340CFFE8BC4CB61B7D7CDB")

    int mNumKeyframes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.072 -0400", hash_original_field = "E48CE21BD60568B86C76E1FEB178AD19", hash_generated_field = "F25CCAD87898D140299C8AD61CC00E6F")

    Keyframe mFirstKeyframe;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.072 -0400", hash_original_field = "065059589B03CCB77854AA308BE2FD37", hash_generated_field = "FAFDAB3E74D0E176CA60E56E1C9BCFAE")

    Keyframe mLastKeyframe;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.084 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "E4914FA8D762AE766FD60D6E9561C2E8")

    TimeInterpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.085 -0400", hash_original_field = "2E64EE21B3126F8C2918F39C513A3742", hash_generated_field = "D35BC99293A28124030816692F50EE53")

    ArrayList<Keyframe> mKeyframes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.085 -0400", hash_original_field = "A5A16062C8CFDCD2D78B97324D59FBBD", hash_generated_field = "FEF5736B09891D2FD2D8C1BD6C28F3AE")

    TypeEvaluator mEvaluator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.112 -0400", hash_original_method = "AC41B3CB583B4F8C00E3AFE9CCF7C554", hash_generated_method = "0033E58342FA6F951E2956BE1152FEB3")
    public  KeyframeSet(Keyframe... keyframes) {
        mNumKeyframes = keyframes.length;
        mKeyframes = new ArrayList<Keyframe>();
        mKeyframes.addAll(Arrays.asList(keyframes));
        mFirstKeyframe = mKeyframes.get(0);
        mLastKeyframe = mKeyframes.get(mNumKeyframes - 1);
        mInterpolator = mLastKeyframe.getInterpolator();
        // ---------- Original Method ----------
        //mNumKeyframes = keyframes.length;
        //mKeyframes = new ArrayList<Keyframe>();
        //mKeyframes.addAll(Arrays.asList(keyframes));
        //mFirstKeyframe = mKeyframes.get(0);
        //mLastKeyframe = mKeyframes.get(mNumKeyframes - 1);
        //mInterpolator = mLastKeyframe.getInterpolator();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.157 -0400", hash_original_method = "EEDF4BFC49E3BB0A5C905B0E8446FBFF", hash_generated_method = "B27A43CC2EED297119DEAFB17EFEE8BB")
    public void setEvaluator(TypeEvaluator evaluator) {
        mEvaluator = evaluator;
        // ---------- Original Method ----------
        //mEvaluator = evaluator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.183 -0400", hash_original_method = "852EEF0AADF480969C7D66EC6180E295", hash_generated_method = "1D1DFFF3D30B4449E521A450E2924C01")
    @Override
    public KeyframeSet clone() {
        KeyframeSet varB4EAC82CA7396A68D541C85D26508E83_359502205 = null; //Variable for return #1
        ArrayList<Keyframe> keyframes;
        keyframes = mKeyframes;
        int numKeyframes;
        numKeyframes = mKeyframes.size();
        Keyframe[] newKeyframes;
        newKeyframes = new Keyframe[numKeyframes];
        {
            int i;
            i = 0;
            {
                newKeyframes[i] = keyframes.get(i).clone();
            } //End block
        } //End collapsed parenthetic
        KeyframeSet newSet;
        newSet = new KeyframeSet(newKeyframes);
        varB4EAC82CA7396A68D541C85D26508E83_359502205 = newSet;
        varB4EAC82CA7396A68D541C85D26508E83_359502205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_359502205;
        // ---------- Original Method ----------
        //ArrayList<Keyframe> keyframes = mKeyframes;
        //int numKeyframes = mKeyframes.size();
        //Keyframe[] newKeyframes = new Keyframe[numKeyframes];
        //for (int i = 0; i < numKeyframes; ++i) {
            //newKeyframes[i] = keyframes.get(i).clone();
        //}
        //KeyframeSet newSet = new KeyframeSet(newKeyframes);
        //return newSet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.284 -0400", hash_original_method = "80AFA2A1CA8ECB40318B145A78C4EE8C", hash_generated_method = "712616D7F3C55150488CBAAF0BF5DA10")
    public Object getValue(float fraction) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1887661907 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1665070997 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_343753663 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_1918648757 = null; //Variable for return #4
        Object varB4EAC82CA7396A68D541C85D26508E83_313078456 = null; //Variable for return #5
        {
            {
                fraction = mInterpolator.getInterpolation(fraction);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1887661907 = mEvaluator.evaluate(fraction, mFirstKeyframe.getValue(),
                    mLastKeyframe.getValue());
        } //End block
        {
            Keyframe nextKeyframe;
            nextKeyframe = mKeyframes.get(1);
            TimeInterpolator interpolator;
            interpolator = nextKeyframe.getInterpolator();
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            float prevFraction;
            prevFraction = mFirstKeyframe.getFraction();
            float intervalFraction;
            intervalFraction = (fraction - prevFraction) /
                (nextKeyframe.getFraction() - prevFraction);
            varB4EAC82CA7396A68D541C85D26508E83_1665070997 = mEvaluator.evaluate(intervalFraction, mFirstKeyframe.getValue(),
                    nextKeyframe.getValue());
        } //End block
        {
            Keyframe prevKeyframe;
            prevKeyframe = mKeyframes.get(mNumKeyframes - 2);
            TimeInterpolator interpolator;
            interpolator = mLastKeyframe.getInterpolator();
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            float prevFraction;
            prevFraction = prevKeyframe.getFraction();
            float intervalFraction;
            intervalFraction = (fraction - prevFraction) /
                (mLastKeyframe.getFraction() - prevFraction);
            varB4EAC82CA7396A68D541C85D26508E83_343753663 = mEvaluator.evaluate(intervalFraction, prevKeyframe.getValue(),
                    mLastKeyframe.getValue());
        } //End block
        Keyframe prevKeyframe;
        prevKeyframe = mFirstKeyframe;
        {
            int i;
            i = 1;
            {
                Keyframe nextKeyframe;
                nextKeyframe = mKeyframes.get(i);
                {
                    boolean var6EBE8138E05C6E6707EE379D88735F94_1010672329 = (fraction < nextKeyframe.getFraction());
                    {
                        TimeInterpolator interpolator;
                        interpolator = nextKeyframe.getInterpolator();
                        {
                            fraction = interpolator.getInterpolation(fraction);
                        } //End block
                        float prevFraction;
                        prevFraction = prevKeyframe.getFraction();
                        float intervalFraction;
                        intervalFraction = (fraction - prevFraction) /
                    (nextKeyframe.getFraction() - prevFraction);
                        varB4EAC82CA7396A68D541C85D26508E83_1918648757 = mEvaluator.evaluate(intervalFraction, prevKeyframe.getValue(),
                        nextKeyframe.getValue());
                    } //End block
                } //End collapsed parenthetic
                prevKeyframe = nextKeyframe;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_313078456 = mLastKeyframe.getValue();
        addTaint(fraction);
        Object varA7E53CE21691AB073D9660D615818899_100150578; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_100150578 = varB4EAC82CA7396A68D541C85D26508E83_1887661907;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_100150578 = varB4EAC82CA7396A68D541C85D26508E83_1665070997;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_100150578 = varB4EAC82CA7396A68D541C85D26508E83_343753663;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_100150578 = varB4EAC82CA7396A68D541C85D26508E83_1918648757;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_100150578 = varB4EAC82CA7396A68D541C85D26508E83_313078456;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_100150578.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_100150578;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.306 -0400", hash_original_method = "5AFB3B0DBEF799B422062A71D978DCE0", hash_generated_method = "2AFD59F46FEE37EB6C6EE9F5F09D6F61")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2108104411 = null; //Variable for return #1
        String returnVal;
        returnVal = " ";
        {
            int i;
            i = 0;
            {
                returnVal += mKeyframes.get(i).getValue() + "  ";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2108104411 = returnVal;
        varB4EAC82CA7396A68D541C85D26508E83_2108104411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2108104411;
        // ---------- Original Method ----------
        //String returnVal = " ";
        //for (int i = 0; i < mNumKeyframes; ++i) {
            //returnVal += mKeyframes.get(i).getValue() + "  ";
        //}
        //return returnVal;
    }

    
}

