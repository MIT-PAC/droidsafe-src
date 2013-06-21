package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.Keyframe.IntKeyframe;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet {
    private int firstValue;
    private int lastValue;
    private int deltaValue;
    private boolean firstTime = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.915 -0400", hash_original_method = "64E77D5D4265D6E8D649F0A18EA66E47", hash_generated_method = "63845E18A706EF588318EFEC4F3FFC77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntKeyframeSet(IntKeyframe... keyframes) {
        super(keyframes);
        dsTaint.addTaint(keyframes[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.915 -0400", hash_original_method = "9A8CA9046BD131DAA0650B91E65A3FB9", hash_generated_method = "079E6D78E69A2395D0BD8C546B6066D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getValue(float fraction) {
        dsTaint.addTaint(fraction);
        Object varC0ABABEE513C1CD582B80B7C40753FCE_1456545742 = (getIntValue(fraction));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getIntValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.917 -0400", hash_original_method = "9997EE114626B9F926D48E4DA6AD12AC", hash_generated_method = "4304F8A07950246D7A272721189B406C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntKeyframeSet clone() {
        ArrayList<Keyframe> keyframes;
        keyframes = mKeyframes;
        int numKeyframes;
        numKeyframes = mKeyframes.size();
        IntKeyframe[] newKeyframes;
        newKeyframes = new IntKeyframe[numKeyframes];
        {
            int i;
            i = 0;
            {
                newKeyframes[i] = (IntKeyframe) keyframes.get(i).clone();
            } //End block
        } //End collapsed parenthetic
        IntKeyframeSet newSet;
        newSet = new IntKeyframeSet(newKeyframes);
        return (IntKeyframeSet)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<Keyframe> keyframes = mKeyframes;
        //int numKeyframes = mKeyframes.size();
        //IntKeyframe[] newKeyframes = new IntKeyframe[numKeyframes];
        //for (int i = 0; i < numKeyframes; ++i) {
            //newKeyframes[i] = (IntKeyframe) keyframes.get(i).clone();
        //}
        //IntKeyframeSet newSet = new IntKeyframeSet(newKeyframes);
        //return newSet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.932 -0400", hash_original_method = "7B6E2369DEAB44F75E4F137274BA59BB", hash_generated_method = "F1FCEEB948C55F8E06E4DDE14C6000C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIntValue(float fraction) {
        dsTaint.addTaint(fraction);
        {
            {
                firstTime = false;
                firstValue = ((IntKeyframe) mKeyframes.get(0)).getIntValue();
                lastValue = ((IntKeyframe) mKeyframes.get(1)).getIntValue();
                deltaValue = lastValue - firstValue;
            } //End block
            {
                fraction = mInterpolator.getInterpolation(fraction);
            } //End block
            {
                int var2944BFD0A204E4BEB642BFD369AEDA47_1197229447 = (((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).intValue());
            } //End block
        } //End block
        {
            IntKeyframe prevKeyframe;
            prevKeyframe = (IntKeyframe) mKeyframes.get(0);
            IntKeyframe nextKeyframe;
            nextKeyframe = (IntKeyframe) mKeyframes.get(1);
            int prevValue;
            prevValue = prevKeyframe.getIntValue();
            int nextValue;
            nextValue = nextKeyframe.getIntValue();
            float prevFraction;
            prevFraction = prevKeyframe.getFraction();
            float nextFraction;
            nextFraction = nextKeyframe.getFraction();
            TimeInterpolator interpolator;
            interpolator = nextKeyframe.getInterpolator();
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            float intervalFraction;
            intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            {
                Object varED6D9B9E9A8D6A7136C5AC2ECADD8344_319135082 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            intValue());
            } //End flattened ternary
        } //End block
        {
            IntKeyframe prevKeyframe;
            prevKeyframe = (IntKeyframe) mKeyframes.get(mNumKeyframes - 2);
            IntKeyframe nextKeyframe;
            nextKeyframe = (IntKeyframe) mKeyframes.get(mNumKeyframes - 1);
            int prevValue;
            prevValue = prevKeyframe.getIntValue();
            int nextValue;
            nextValue = nextKeyframe.getIntValue();
            float prevFraction;
            prevFraction = prevKeyframe.getFraction();
            float nextFraction;
            nextFraction = nextKeyframe.getFraction();
            TimeInterpolator interpolator;
            interpolator = nextKeyframe.getInterpolator();
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            float intervalFraction;
            intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            {
                Object varB80CC1E756BD360DEE94937C3273B9EC_452956560 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).intValue());
            } //End flattened ternary
        } //End block
        IntKeyframe prevKeyframe;
        prevKeyframe = (IntKeyframe) mKeyframes.get(0);
        {
            int i;
            i = 1;
            {
                IntKeyframe nextKeyframe;
                nextKeyframe = (IntKeyframe) mKeyframes.get(i);
                {
                    boolean var6EBE8138E05C6E6707EE379D88735F94_16873668 = (fraction < nextKeyframe.getFraction());
                    {
                        TimeInterpolator interpolator;
                        interpolator = nextKeyframe.getInterpolator();
                        {
                            fraction = interpolator.getInterpolation(fraction);
                        } //End block
                        float intervalFraction;
                        intervalFraction = (fraction - prevKeyframe.getFraction()) /
                    (nextKeyframe.getFraction() - prevKeyframe.getFraction());
                        int prevValue;
                        prevValue = prevKeyframe.getIntValue();
                        int nextValue;
                        nextValue = nextKeyframe.getIntValue();
                        {
                            Object var2F9C0FE5DC56964E4EF4CEA1EE7004B2_812167998 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                                intValue());
                        } //End flattened ternary
                    } //End block
                } //End collapsed parenthetic
                prevKeyframe = nextKeyframe;
            } //End block
        } //End collapsed parenthetic
        int varC99722A1C3E627A72AEE22646D0105C9_1500833084 = (((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

