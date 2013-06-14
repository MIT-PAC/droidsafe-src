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
    int mNumKeyframes;
    Keyframe mFirstKeyframe;
    Keyframe mLastKeyframe;
    TimeInterpolator mInterpolator;
    ArrayList<Keyframe> mKeyframes;
    TypeEvaluator mEvaluator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:06:32.227 -0400", hash_original_method = "AC41B3CB583B4F8C00E3AFE9CCF7C554", hash_generated_method = "5CC90FA4E70C763E5DCF8D8C3518322C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyframeSet(Keyframe... keyframes) {
        dsTaint.addTaint(keyframes[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:06:32.286 -0400", hash_original_method = "EEDF4BFC49E3BB0A5C905B0E8446FBFF", hash_generated_method = "2FE29BAABADD9136A62547F216909CCE")
    @DSModeled(DSC.SAFE)
    public void setEvaluator(TypeEvaluator evaluator) {
        dsTaint.addTaint(evaluator.dsTaint);
        // ---------- Original Method ----------
        //mEvaluator = evaluator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:06:32.302 -0400", hash_original_method = "852EEF0AADF480969C7D66EC6180E295", hash_generated_method = "82AB356622992315215FB28EC6E19EE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public KeyframeSet clone() {
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
        return (KeyframeSet)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:06:32.371 -0400", hash_original_method = "80AFA2A1CA8ECB40318B145A78C4EE8C", hash_generated_method = "9100D763722EF643DAF4B8B6FE2500A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getValue(float fraction) {
        dsTaint.addTaint(fraction);
        {
            {
                fraction = mInterpolator.getInterpolation(fraction);
            } //End block
            Object var69ACDFA834654FC20F5D3B1062115C7F_41554110 = (mEvaluator.evaluate(fraction, mFirstKeyframe.getValue(),
                    mLastKeyframe.getValue()));
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
            Object var89F63B2184F1DEFCE34D1A70AEB99F88_1905366609 = (mEvaluator.evaluate(intervalFraction, mFirstKeyframe.getValue(),
                    nextKeyframe.getValue()));
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
            Object var2252536E0CAFCF276CF4AB0205367539_329744410 = (mEvaluator.evaluate(intervalFraction, prevKeyframe.getValue(),
                    mLastKeyframe.getValue()));
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
                    boolean var6EBE8138E05C6E6707EE379D88735F94_277150210 = (fraction < nextKeyframe.getFraction());
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
                        Object varE5E1F5C0FE611ED7E36647EA62ADA384_56218911 = (mEvaluator.evaluate(intervalFraction, prevKeyframe.getValue(),
                        nextKeyframe.getValue()));
                    } //End block
                } //End collapsed parenthetic
                prevKeyframe = nextKeyframe;
            } //End block
        } //End collapsed parenthetic
        Object var34D284DD3E00DDF7953116AFE9726B09_1249725832 = (mLastKeyframe.getValue());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:06:32.401 -0400", hash_original_method = "5AFB3B0DBEF799B422062A71D978DCE0", hash_generated_method = "B9FB3DD181B847E91C9068C3F8953A80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String returnVal;
        returnVal = " ";
        {
            int i;
            i = 0;
            {
                returnVal += mKeyframes.get(i).getValue() + "  ";
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String returnVal = " ";
        //for (int i = 0; i < mNumKeyframes; ++i) {
            //returnVal += mKeyframes.get(i).getValue() + "  ";
        //}
        //return returnVal;
    }

    
}

