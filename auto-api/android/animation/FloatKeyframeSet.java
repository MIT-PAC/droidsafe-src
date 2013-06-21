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
    private float firstValue;
    private float lastValue;
    private float deltaValue;
    private boolean firstTime = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.852 -0400", hash_original_method = "55E7A0FB76C458623E86CCD48BC7C81D", hash_generated_method = "342C1C550258BC726D1714208DE41252")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FloatKeyframeSet(FloatKeyframe... keyframes) {
        super(keyframes);
        dsTaint.addTaint(keyframes[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.853 -0400", hash_original_method = "860D85D6E840DECB3585A4E8387CDC5D", hash_generated_method = "B23AD9B2837B552959004F9CFFEEAD8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getValue(float fraction) {
        dsTaint.addTaint(fraction);
        Object var9BA37A56C114034154A9FA4A78B3AA25_498334421 = (getFloatValue(fraction));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFloatValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.854 -0400", hash_original_method = "EE8B91077168511971EA1FA3F5AAEF56", hash_generated_method = "3CE7BFE0A10CAA9AE50D427F0ED2BCC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatKeyframeSet clone() {
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
        return (FloatKeyframeSet)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.867 -0400", hash_original_method = "735DAFEAE6CE9149D9195E79FA6B1336", hash_generated_method = "351BA8F533860959E6C83D68E6EBD048")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloatValue(float fraction) {
        dsTaint.addTaint(fraction);
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
                float var6A14A1A9E3EDD25925C43894F04C1FCF_1485811497 = (((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).floatValue());
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
                Object var6327C23BA70D2AE50D60CF84E572CDA7_412215377 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
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
                Object var6327C23BA70D2AE50D60CF84E572CDA7_1515102648 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
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
                    boolean var6EBE8138E05C6E6707EE379D88735F94_1058933791 = (fraction < nextKeyframe.getFraction());
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
                            Object varE1B989C845B16109DDC100C25213A38C_977950209 = (((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue());
                        } //End flattened ternary
                    } //End block
                } //End collapsed parenthetic
                prevKeyframe = nextKeyframe;
            } //End block
        } //End collapsed parenthetic
        float var40CC736B23B461373B00435407E9E18A_454525631 = (((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).floatValue());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

