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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:47.749 -0400", hash_original_field = "235063B1CBCA83735C62ED6B83B05F45", hash_generated_field = "E0DB3C6AA501546F29FB528503DA896D")

    private float firstValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:47.751 -0400", hash_original_field = "8EFF7B65464999C8928BEF678BFFA00B", hash_generated_field = "A0475967FB564ACF21CDF7DFB3985EA7")

    private float lastValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:47.752 -0400", hash_original_field = "E007AB501C2996F5F53045C2F8C10AA2", hash_generated_field = "02FB16BDE777C82DCD119E6189DD52B7")

    private float deltaValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:47.757 -0400", hash_original_field = "A7893FAED7826B5857859A98202AF417", hash_generated_field = "38B092BB517A9D8CB0718E3125088A8D")

    private boolean firstTime = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:47.776 -0400", hash_original_method = "55E7A0FB76C458623E86CCD48BC7C81D", hash_generated_method = "5B66BB5D60F8E21616BC6C478FACA9AA")
    public  FloatKeyframeSet(FloatKeyframe... keyframes) {
        super(keyframes);
        addTaint(keyframes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:47.804 -0400", hash_original_method = "860D85D6E840DECB3585A4E8387CDC5D", hash_generated_method = "7E33ADE3D3615E049D5B8C3A08F47E69")
    @Override
    public Object getValue(float fraction) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1206160558 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1206160558 = getFloatValue(fraction);
        addTaint(fraction);
        varB4EAC82CA7396A68D541C85D26508E83_1206160558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206160558;
        // ---------- Original Method ----------
        //return getFloatValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:47.828 -0400", hash_original_method = "EE8B91077168511971EA1FA3F5AAEF56", hash_generated_method = "F7ACC61713728309D3AF6D54F8C65A17")
    @Override
    public FloatKeyframeSet clone() {
        FloatKeyframeSet varB4EAC82CA7396A68D541C85D26508E83_895794765 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_895794765 = newSet;
        varB4EAC82CA7396A68D541C85D26508E83_895794765.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_895794765;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:47.987 -0400", hash_original_method = "735DAFEAE6CE9149D9195E79FA6B1336", hash_generated_method = "11C57F2218A170CB4FA699987CA51D40")
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
                float var6A14A1A9E3EDD25925C43894F04C1FCF_1806526658 = (((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).floatValue());
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
                Object var6327C23BA70D2AE50D60CF84E572CDA7_920528393 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
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
                Object var6327C23BA70D2AE50D60CF84E572CDA7_2105678858 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
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
                    boolean var6EBE8138E05C6E6707EE379D88735F94_1632092050 = (fraction < nextKeyframe.getFraction());
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
                            Object varE1B989C845B16109DDC100C25213A38C_176460808 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue());
                        } //End flattened ternary
                    } //End block
                } //End collapsed parenthetic
                prevKeyframe = nextKeyframe;
            } //End block
        } //End collapsed parenthetic
        float var40CC736B23B461373B00435407E9E18A_152070012 = (((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).floatValue());
        addTaint(fraction);
        float var546ADE640B6EDFBC8A086EF31347E768_9482869 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_9482869;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

