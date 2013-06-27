package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.Keyframe.FloatKeyframe;
import java.util.ArrayList;

class FloatKeyframeSet extends KeyframeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.211 -0400", hash_original_field = "235063B1CBCA83735C62ED6B83B05F45", hash_generated_field = "E0DB3C6AA501546F29FB528503DA896D")

    private float firstValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.213 -0400", hash_original_field = "8EFF7B65464999C8928BEF678BFFA00B", hash_generated_field = "A0475967FB564ACF21CDF7DFB3985EA7")

    private float lastValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.214 -0400", hash_original_field = "E007AB501C2996F5F53045C2F8C10AA2", hash_generated_field = "02FB16BDE777C82DCD119E6189DD52B7")

    private float deltaValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.229 -0400", hash_original_field = "A7893FAED7826B5857859A98202AF417", hash_generated_field = "38B092BB517A9D8CB0718E3125088A8D")

    private boolean firstTime = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.242 -0400", hash_original_method = "55E7A0FB76C458623E86CCD48BC7C81D", hash_generated_method = "5B66BB5D60F8E21616BC6C478FACA9AA")
    public  FloatKeyframeSet(FloatKeyframe... keyframes) {
        super(keyframes);
        addTaint(keyframes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.278 -0400", hash_original_method = "860D85D6E840DECB3585A4E8387CDC5D", hash_generated_method = "071B4647D090D50C35D43BA479029307")
    @Override
    public Object getValue(float fraction) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1592478160 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1592478160 = getFloatValue(fraction);
        addTaint(fraction);
        varB4EAC82CA7396A68D541C85D26508E83_1592478160.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1592478160;
        // ---------- Original Method ----------
        //return getFloatValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.387 -0400", hash_original_method = "EE8B91077168511971EA1FA3F5AAEF56", hash_generated_method = "E759B839E2D61CC869940BD68A977074")
    @Override
    public FloatKeyframeSet clone() {
        FloatKeyframeSet varB4EAC82CA7396A68D541C85D26508E83_999850716 = null; //Variable for return #1
        ArrayList<Keyframe> keyframes;
        keyframes = mKeyframes;
        int numKeyframes;
        numKeyframes = mKeyframes.size();
        FloatKeyframe[] newKeyframes;
        newKeyframes = new FloatKeyframe[numKeyframes];
        {
            int i;
            i = 0;
            {
                newKeyframes[i] = (FloatKeyframe) keyframes.get(i).clone();
            } //End block
        } //End collapsed parenthetic
        FloatKeyframeSet newSet;
        newSet = new FloatKeyframeSet(newKeyframes);
        varB4EAC82CA7396A68D541C85D26508E83_999850716 = newSet;
        varB4EAC82CA7396A68D541C85D26508E83_999850716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_999850716;
        // ---------- Original Method ----------
        //ArrayList<Keyframe> keyframes = mKeyframes;
        //int numKeyframes = mKeyframes.size();
        //FloatKeyframe[] newKeyframes = new FloatKeyframe[numKeyframes];
        //for (int i = 0; i < numKeyframes; ++i) {
            //newKeyframes[i] = (FloatKeyframe) keyframes.get(i).clone();
        //}
        //FloatKeyframeSet newSet = new FloatKeyframeSet(newKeyframes);
        //return newSet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:50.857 -0400", hash_original_method = "735DAFEAE6CE9149D9195E79FA6B1336", hash_generated_method = "58A3008CE12C224ED35070451A6AB6C6")
    public float getFloatValue(float fraction) {
        {
            {
                firstTime = false;
                firstValue = ((FloatKeyframe) mKeyframes.get(0)).getFloatValue();
                lastValue = ((FloatKeyframe) mKeyframes.get(1)).getFloatValue();
                deltaValue = lastValue - firstValue;
            } //End block
            {
                fraction = mInterpolator.getInterpolation(fraction);
            } //End block
            {
                float var6A14A1A9E3EDD25925C43894F04C1FCF_1643991897 = (((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).floatValue());
            } //End block
        } //End block
        {
            FloatKeyframe prevKeyframe;
            prevKeyframe = (FloatKeyframe) mKeyframes.get(0);
            FloatKeyframe nextKeyframe;
            nextKeyframe = (FloatKeyframe) mKeyframes.get(1);
            float prevValue;
            prevValue = prevKeyframe.getFloatValue();
            float nextValue;
            nextValue = nextKeyframe.getFloatValue();
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
                Object var6327C23BA70D2AE50D60CF84E572CDA7_834735956 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue());
            } //End flattened ternary
        } //End block
        {
            FloatKeyframe prevKeyframe;
            prevKeyframe = (FloatKeyframe) mKeyframes.get(mNumKeyframes - 2);
            FloatKeyframe nextKeyframe;
            nextKeyframe = (FloatKeyframe) mKeyframes.get(mNumKeyframes - 1);
            float prevValue;
            prevValue = prevKeyframe.getFloatValue();
            float nextValue;
            nextValue = nextKeyframe.getFloatValue();
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
                Object var6327C23BA70D2AE50D60CF84E572CDA7_364648769 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue());
            } //End flattened ternary
        } //End block
        FloatKeyframe prevKeyframe;
        prevKeyframe = (FloatKeyframe) mKeyframes.get(0);
        {
            int i;
            i = 1;
            {
                FloatKeyframe nextKeyframe;
                nextKeyframe = (FloatKeyframe) mKeyframes.get(i);
                {
                    boolean var6EBE8138E05C6E6707EE379D88735F94_76289257 = (fraction < nextKeyframe.getFraction());
                    {
                        TimeInterpolator interpolator;
                        interpolator = nextKeyframe.getInterpolator();
                        {
                            fraction = interpolator.getInterpolation(fraction);
                        } //End block
                        float intervalFraction;
                        intervalFraction = (fraction - prevKeyframe.getFraction()) /
                    (nextKeyframe.getFraction() - prevKeyframe.getFraction());
                        float prevValue;
                        prevValue = prevKeyframe.getFloatValue();
                        float nextValue;
                        nextValue = nextKeyframe.getFloatValue();
                        {
                            Object varE1B989C845B16109DDC100C25213A38C_637317772 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue());
                        } //End flattened ternary
                    } //End block
                } //End collapsed parenthetic
                prevKeyframe = nextKeyframe;
            } //End block
        } //End collapsed parenthetic
        float var40CC736B23B461373B00435407E9E18A_36480300 = (((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).floatValue());
        addTaint(fraction);
        float var546ADE640B6EDFBC8A086EF31347E768_328266359 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_328266359;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

