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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.506 -0400", hash_original_field = "235063B1CBCA83735C62ED6B83B05F45", hash_generated_field = "CCD07B82BF514AF2BA45DC7821C1FB70")

    private int firstValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.507 -0400", hash_original_field = "8EFF7B65464999C8928BEF678BFFA00B", hash_generated_field = "C61F9B7F3773608B569D6EA3B1F7CFAB")

    private int lastValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.520 -0400", hash_original_field = "E007AB501C2996F5F53045C2F8C10AA2", hash_generated_field = "AF830F3ABC6E7D884EA4ED2FCFAB117E")

    private int deltaValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.521 -0400", hash_original_field = "A7893FAED7826B5857859A98202AF417", hash_generated_field = "38B092BB517A9D8CB0718E3125088A8D")

    private boolean firstTime = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.534 -0400", hash_original_method = "64E77D5D4265D6E8D649F0A18EA66E47", hash_generated_method = "6C4421523E75FD4F9637AF40E17C4367")
    public  IntKeyframeSet(IntKeyframe... keyframes) {
        super(keyframes);
        addTaint(keyframes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.569 -0400", hash_original_method = "9A8CA9046BD131DAA0650B91E65A3FB9", hash_generated_method = "282A43C4D810663C2A6C2825036923E6")
    @Override
    public Object getValue(float fraction) {
        Object varB4EAC82CA7396A68D541C85D26508E83_632046621 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_632046621 = getIntValue(fraction);
        addTaint(fraction);
        varB4EAC82CA7396A68D541C85D26508E83_632046621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_632046621;
        // ---------- Original Method ----------
        //return getIntValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.628 -0400", hash_original_method = "9997EE114626B9F926D48E4DA6AD12AC", hash_generated_method = "C7516CAE20050F2136FF7B56D7E9A438")
    @Override
    public IntKeyframeSet clone() {
        IntKeyframeSet varB4EAC82CA7396A68D541C85D26508E83_819131143 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_819131143 = newSet;
        varB4EAC82CA7396A68D541C85D26508E83_819131143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_819131143;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:51.042 -0400", hash_original_method = "7B6E2369DEAB44F75E4F137274BA59BB", hash_generated_method = "5AA17D590C03D1453EE19CC5BDE7470E")
    public int getIntValue(float fraction) {
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
                int var2944BFD0A204E4BEB642BFD369AEDA47_885651040 = (((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).intValue());
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
                Object varED6D9B9E9A8D6A7136C5AC2ECADD8344_1937279650 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
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
                Object varB80CC1E756BD360DEE94937C3273B9EC_3910304 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).intValue());
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
                    boolean var6EBE8138E05C6E6707EE379D88735F94_1156941846 = (fraction < nextKeyframe.getFraction());
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
                            Object var2F9C0FE5DC56964E4EF4CEA1EE7004B2_1898192649 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                                intValue());
                        } //End flattened ternary
                    } //End block
                } //End collapsed parenthetic
                prevKeyframe = nextKeyframe;
            } //End block
        } //End collapsed parenthetic
        int varC99722A1C3E627A72AEE22646D0105C9_1104435109 = (((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).intValue());
        addTaint(fraction);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308575524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308575524;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

