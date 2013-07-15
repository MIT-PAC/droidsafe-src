package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Arrays;
import android.animation.Keyframe.IntKeyframe;
import android.animation.Keyframe.FloatKeyframe;
import android.animation.Keyframe.ObjectKeyframe;

class KeyframeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.520 -0400", hash_original_field = "8ABE62D0F4315FED9AFE09DF6C0B1969", hash_generated_field = "546EF363B5340CFFE8BC4CB61B7D7CDB")

    int mNumKeyframes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.521 -0400", hash_original_field = "E48CE21BD60568B86C76E1FEB178AD19", hash_generated_field = "F25CCAD87898D140299C8AD61CC00E6F")

    Keyframe mFirstKeyframe;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.521 -0400", hash_original_field = "065059589B03CCB77854AA308BE2FD37", hash_generated_field = "FAFDAB3E74D0E176CA60E56E1C9BCFAE")

    Keyframe mLastKeyframe;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.522 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "E4914FA8D762AE766FD60D6E9561C2E8")

    TimeInterpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.522 -0400", hash_original_field = "2E64EE21B3126F8C2918F39C513A3742", hash_generated_field = "D35BC99293A28124030816692F50EE53")

    ArrayList<Keyframe> mKeyframes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.523 -0400", hash_original_field = "A5A16062C8CFDCD2D78B97324D59FBBD", hash_generated_field = "FEF5736B09891D2FD2D8C1BD6C28F3AE")

    TypeEvaluator mEvaluator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.528 -0400", hash_original_method = "AC41B3CB583B4F8C00E3AFE9CCF7C554", hash_generated_method = "0033E58342FA6F951E2956BE1152FEB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.539 -0400", hash_original_method = "EEDF4BFC49E3BB0A5C905B0E8446FBFF", hash_generated_method = "B27A43CC2EED297119DEAFB17EFEE8BB")
    public void setEvaluator(TypeEvaluator evaluator) {
        mEvaluator = evaluator;
        // ---------- Original Method ----------
        //mEvaluator = evaluator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.542 -0400", hash_original_method = "852EEF0AADF480969C7D66EC6180E295", hash_generated_method = "D10290FC6A72B51DD15475A1E8C01AFE")
    @Override
    public KeyframeSet clone() {
        ArrayList<Keyframe> keyframes = mKeyframes;
        int numKeyframes = mKeyframes.size();
        Keyframe[] newKeyframes = new Keyframe[numKeyframes];
for(int i = 0;i < numKeyframes;++i)
        {
            newKeyframes[i] = keyframes.get(i).clone();
        } //End block
        KeyframeSet newSet = new KeyframeSet(newKeyframes);
KeyframeSet var887F3F78AE0C9FB0CC98EDF99F492138_1983271124 =         newSet;
        var887F3F78AE0C9FB0CC98EDF99F492138_1983271124.addTaint(taint);
        return var887F3F78AE0C9FB0CC98EDF99F492138_1983271124;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.550 -0400", hash_original_method = "80AFA2A1CA8ECB40318B145A78C4EE8C", hash_generated_method = "871BFFA72E4A61ABADE21B075DBF22DA")
    public Object getValue(float fraction) {
        addTaint(fraction);
    if(mNumKeyframes == 2)        
        {
    if(mInterpolator != null)            
            {
                fraction = mInterpolator.getInterpolation(fraction);
            } //End block
Object var34E4E058AF9CE8B969DF6DEF2537A537_1145486492 =             mEvaluator.evaluate(fraction, mFirstKeyframe.getValue(),
                    mLastKeyframe.getValue());
            var34E4E058AF9CE8B969DF6DEF2537A537_1145486492.addTaint(taint);
            return var34E4E058AF9CE8B969DF6DEF2537A537_1145486492;
        } //End block
    if(fraction <= 0f)        
        {
            final Keyframe nextKeyframe = mKeyframes.get(1);
            final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
    if(interpolator != null)            
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            final float prevFraction = mFirstKeyframe.getFraction();
            float intervalFraction = (fraction - prevFraction) /
                (nextKeyframe.getFraction() - prevFraction);
Object varF00583FB3258D795DDC10D4FDA15B588_222020060 =             mEvaluator.evaluate(intervalFraction, mFirstKeyframe.getValue(),
                    nextKeyframe.getValue());
            varF00583FB3258D795DDC10D4FDA15B588_222020060.addTaint(taint);
            return varF00583FB3258D795DDC10D4FDA15B588_222020060;
        } //End block
        else
    if(fraction >= 1f)        
        {
            final Keyframe prevKeyframe = mKeyframes.get(mNumKeyframes - 2);
            final TimeInterpolator interpolator = mLastKeyframe.getInterpolator();
    if(interpolator != null)            
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            final float prevFraction = prevKeyframe.getFraction();
            float intervalFraction = (fraction - prevFraction) /
                (mLastKeyframe.getFraction() - prevFraction);
Object var740E31ABF97BAA5271118DBF805FBE8F_1379733917 =             mEvaluator.evaluate(intervalFraction, prevKeyframe.getValue(),
                    mLastKeyframe.getValue());
            var740E31ABF97BAA5271118DBF805FBE8F_1379733917.addTaint(taint);
            return var740E31ABF97BAA5271118DBF805FBE8F_1379733917;
        } //End block
        Keyframe prevKeyframe = mFirstKeyframe;
for(int i = 1;i < mNumKeyframes;++i)
        {
            Keyframe nextKeyframe = mKeyframes.get(i);
    if(fraction < nextKeyframe.getFraction())            
            {
                final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
    if(interpolator != null)                
                {
                    fraction = interpolator.getInterpolation(fraction);
                } //End block
                final float prevFraction = prevKeyframe.getFraction();
                float intervalFraction = (fraction - prevFraction) /
                    (nextKeyframe.getFraction() - prevFraction);
Object varDD3A0D22802CF8E227E3E1110E0A0DC1_1974256520 =                 mEvaluator.evaluate(intervalFraction, prevKeyframe.getValue(),
                        nextKeyframe.getValue());
                varDD3A0D22802CF8E227E3E1110E0A0DC1_1974256520.addTaint(taint);
                return varDD3A0D22802CF8E227E3E1110E0A0DC1_1974256520;
            } //End block
            prevKeyframe = nextKeyframe;
        } //End block
Object var91FB1B83987C58943E8A4DED27A29F6D_1437539521 =         mLastKeyframe.getValue();
        var91FB1B83987C58943E8A4DED27A29F6D_1437539521.addTaint(taint);
        return var91FB1B83987C58943E8A4DED27A29F6D_1437539521;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.554 -0400", hash_original_method = "5AFB3B0DBEF799B422062A71D978DCE0", hash_generated_method = "F46A4FF6B8CC17BEC8974E544200B509")
    @Override
    public String toString() {
        String returnVal = " ";
for(int i = 0;i < mNumKeyframes;++i)
        {
            returnVal += mKeyframes.get(i).getValue() + "  ";
        } //End block
String var74D8482D05AF02514EABC315066E6806_1821908998 =         returnVal;
        var74D8482D05AF02514EABC315066E6806_1821908998.addTaint(taint);
        return var74D8482D05AF02514EABC315066E6806_1821908998;
        // ---------- Original Method ----------
        //String returnVal = " ";
        //for (int i = 0; i < mNumKeyframes; ++i) {
            //returnVal += mKeyframes.get(i).getValue() + "  ";
        //}
        //return returnVal;
    }

    
}

