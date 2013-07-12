package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.animation.Keyframe.FloatKeyframe;
import java.util.ArrayList;

class FloatKeyframeSet extends KeyframeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.272 -0400", hash_original_field = "235063B1CBCA83735C62ED6B83B05F45", hash_generated_field = "E0DB3C6AA501546F29FB528503DA896D")

    private float firstValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.273 -0400", hash_original_field = "8EFF7B65464999C8928BEF678BFFA00B", hash_generated_field = "A0475967FB564ACF21CDF7DFB3985EA7")

    private float lastValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.273 -0400", hash_original_field = "E007AB501C2996F5F53045C2F8C10AA2", hash_generated_field = "02FB16BDE777C82DCD119E6189DD52B7")

    private float deltaValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.274 -0400", hash_original_field = "A7893FAED7826B5857859A98202AF417", hash_generated_field = "38B092BB517A9D8CB0718E3125088A8D")

    private boolean firstTime = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.276 -0400", hash_original_method = "55E7A0FB76C458623E86CCD48BC7C81D", hash_generated_method = "5B66BB5D60F8E21616BC6C478FACA9AA")
    public  FloatKeyframeSet(FloatKeyframe... keyframes) {
        super(keyframes);
        addTaint(keyframes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.278 -0400", hash_original_method = "860D85D6E840DECB3585A4E8387CDC5D", hash_generated_method = "23DBED43380FA3AD6360958A62A9139B")
    @Override
    public Object getValue(float fraction) {
        addTaint(fraction);
Object var2E32B7C5398A3AE394A1D38B2942B57E_1647368281 =         getFloatValue(fraction);
        var2E32B7C5398A3AE394A1D38B2942B57E_1647368281.addTaint(taint);
        return var2E32B7C5398A3AE394A1D38B2942B57E_1647368281;
        // ---------- Original Method ----------
        //return getFloatValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.279 -0400", hash_original_method = "EE8B91077168511971EA1FA3F5AAEF56", hash_generated_method = "42BBF134E27BA231147D8B5A9438752A")
    @Override
    public FloatKeyframeSet clone() {
        ArrayList<Keyframe> keyframes = mKeyframes;
        int numKeyframes = mKeyframes.size();
        FloatKeyframe[] newKeyframes = new FloatKeyframe[numKeyframes];
for(int i = 0;i < numKeyframes;++i)
        {
            newKeyframes[i] = (FloatKeyframe) keyframes.get(i).clone();
        } //End block
        FloatKeyframeSet newSet = new FloatKeyframeSet(newKeyframes);
FloatKeyframeSet var887F3F78AE0C9FB0CC98EDF99F492138_395324897 =         newSet;
        var887F3F78AE0C9FB0CC98EDF99F492138_395324897.addTaint(taint);
        return var887F3F78AE0C9FB0CC98EDF99F492138_395324897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.289 -0400", hash_original_method = "735DAFEAE6CE9149D9195E79FA6B1336", hash_generated_method = "4BDC9065033CAD4BCAF6620FC246C944")
    public float getFloatValue(float fraction) {
        addTaint(fraction);
    if(mNumKeyframes == 2)        
        {
    if(firstTime)            
            {
                firstTime = false;
                firstValue = ((FloatKeyframe) mKeyframes.get(0)).getFloatValue();
                lastValue = ((FloatKeyframe) mKeyframes.get(1)).getFloatValue();
                deltaValue = lastValue - firstValue;
            } //End block
    if(mInterpolator != null)            
            {
                fraction = mInterpolator.getInterpolation(fraction);
            } //End block
    if(mEvaluator == null)            
            {
                float var606B6AEA39F3EB6485442E2C0F09758C_1640137926 = (firstValue + fraction * deltaValue);
                                float var546ADE640B6EDFBC8A086EF31347E768_1645267242 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1645267242;
            } //End block
            else
            {
                float varA4F3C94389B1089CCA4B45AE07641391_2037668464 = (((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).floatValue());
                                float var546ADE640B6EDFBC8A086EF31347E768_2036264644 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_2036264644;
            } //End block
        } //End block
    if(fraction <= 0f)        
        {
            final FloatKeyframe prevKeyframe = (FloatKeyframe) mKeyframes.get(0);
            final FloatKeyframe nextKeyframe = (FloatKeyframe) mKeyframes.get(1);
            float prevValue = prevKeyframe.getFloatValue();
            float nextValue = nextKeyframe.getFloatValue();
            float prevFraction = prevKeyframe.getFraction();
            float nextFraction = nextKeyframe.getFraction();
            final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
    if(interpolator != null)            
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            float intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            float varAB309C20483E03C0517F4932C3A58303_1179547628 = (mEvaluator == null ?
                    prevValue + intervalFraction * (nextValue - prevValue) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue());
                        float var546ADE640B6EDFBC8A086EF31347E768_1806200162 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1806200162;
        } //End block
        else
    if(fraction >= 1f)        
        {
            final FloatKeyframe prevKeyframe = (FloatKeyframe) mKeyframes.get(mNumKeyframes - 2);
            final FloatKeyframe nextKeyframe = (FloatKeyframe) mKeyframes.get(mNumKeyframes - 1);
            float prevValue = prevKeyframe.getFloatValue();
            float nextValue = nextKeyframe.getFloatValue();
            float prevFraction = prevKeyframe.getFraction();
            float nextFraction = nextKeyframe.getFraction();
            final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
    if(interpolator != null)            
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            float intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            float varAB309C20483E03C0517F4932C3A58303_449669084 = (mEvaluator == null ?
                    prevValue + intervalFraction * (nextValue - prevValue) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue());
                        float var546ADE640B6EDFBC8A086EF31347E768_1470144758 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1470144758;
        } //End block
        FloatKeyframe prevKeyframe = (FloatKeyframe) mKeyframes.get(0);
for(int i = 1;i < mNumKeyframes;++i)
        {
            FloatKeyframe nextKeyframe = (FloatKeyframe) mKeyframes.get(i);
    if(fraction < nextKeyframe.getFraction())            
            {
                final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
    if(interpolator != null)                
                {
                    fraction = interpolator.getInterpolation(fraction);
                } //End block
                float intervalFraction = (fraction - prevKeyframe.getFraction()) /
                    (nextKeyframe.getFraction() - prevKeyframe.getFraction());
                float prevValue = prevKeyframe.getFloatValue();
                float nextValue = nextKeyframe.getFloatValue();
                float var85C9EA278C0AE6844BDE031F6E53568F_2034362031 = (mEvaluator == null ?
                        prevValue + intervalFraction * (nextValue - prevValue) :
                        ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue());
                                float var546ADE640B6EDFBC8A086EF31347E768_1644146308 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1644146308;
            } //End block
            prevKeyframe = nextKeyframe;
        } //End block
        float varA37B2F07C0BCFC728CF950245821FAB5_664804070 = (((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).floatValue());
                float var546ADE640B6EDFBC8A086EF31347E768_150674046 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_150674046;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

