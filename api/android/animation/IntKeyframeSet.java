package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.animation.Keyframe.IntKeyframe;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.343 -0400", hash_original_field = "235063B1CBCA83735C62ED6B83B05F45", hash_generated_field = "CCD07B82BF514AF2BA45DC7821C1FB70")

    private int firstValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.344 -0400", hash_original_field = "8EFF7B65464999C8928BEF678BFFA00B", hash_generated_field = "C61F9B7F3773608B569D6EA3B1F7CFAB")

    private int lastValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.345 -0400", hash_original_field = "E007AB501C2996F5F53045C2F8C10AA2", hash_generated_field = "AF830F3ABC6E7D884EA4ED2FCFAB117E")

    private int deltaValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.346 -0400", hash_original_field = "A7893FAED7826B5857859A98202AF417", hash_generated_field = "38B092BB517A9D8CB0718E3125088A8D")

    private boolean firstTime = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.347 -0400", hash_original_method = "64E77D5D4265D6E8D649F0A18EA66E47", hash_generated_method = "6C4421523E75FD4F9637AF40E17C4367")
    public  IntKeyframeSet(IntKeyframe... keyframes) {
        super(keyframes);
        addTaint(keyframes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.348 -0400", hash_original_method = "9A8CA9046BD131DAA0650B91E65A3FB9", hash_generated_method = "71013C432351EF58B4F8E4724777349E")
    @Override
    public Object getValue(float fraction) {
        addTaint(fraction);
Object var3985029DEDBD38B26428925A8A7331F2_753228785 =         getIntValue(fraction);
        var3985029DEDBD38B26428925A8A7331F2_753228785.addTaint(taint);
        return var3985029DEDBD38B26428925A8A7331F2_753228785;
        // ---------- Original Method ----------
        //return getIntValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.352 -0400", hash_original_method = "9997EE114626B9F926D48E4DA6AD12AC", hash_generated_method = "DEB9D5435900DC67DB724771ED6EC66B")
    @Override
    public IntKeyframeSet clone() {
        ArrayList<Keyframe> keyframes = mKeyframes;
        int numKeyframes = mKeyframes.size();
        IntKeyframe[] newKeyframes = new IntKeyframe[numKeyframes];
for(int i = 0;i < numKeyframes;++i)
        {
            newKeyframes[i] = (IntKeyframe) keyframes.get(i).clone();
        } //End block
        IntKeyframeSet newSet = new IntKeyframeSet(newKeyframes);
IntKeyframeSet var887F3F78AE0C9FB0CC98EDF99F492138_927164215 =         newSet;
        var887F3F78AE0C9FB0CC98EDF99F492138_927164215.addTaint(taint);
        return var887F3F78AE0C9FB0CC98EDF99F492138_927164215;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.366 -0400", hash_original_method = "7B6E2369DEAB44F75E4F137274BA59BB", hash_generated_method = "69AD9675D496ED002CE80DE456BD501D")
    public int getIntValue(float fraction) {
        addTaint(fraction);
    if(mNumKeyframes == 2)        
        {
    if(firstTime)            
            {
                firstTime = false;
                firstValue = ((IntKeyframe) mKeyframes.get(0)).getIntValue();
                lastValue = ((IntKeyframe) mKeyframes.get(1)).getIntValue();
                deltaValue = lastValue - firstValue;
            } //End block
    if(mInterpolator != null)            
            {
                fraction = mInterpolator.getInterpolation(fraction);
            } //End block
    if(mEvaluator == null)            
            {
                int varAF30D29E9B50E82F512C293E14AE687B_141417247 = (firstValue + (int)(fraction * deltaValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_277399159 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_277399159;
            } //End block
            else
            {
                int varCC7664A623574ECCF07CE310B2E0F08B_1502800790 = (((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).intValue());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896206439 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896206439;
            } //End block
        } //End block
    if(fraction <= 0f)        
        {
            final IntKeyframe prevKeyframe = (IntKeyframe) mKeyframes.get(0);
            final IntKeyframe nextKeyframe = (IntKeyframe) mKeyframes.get(1);
            int prevValue = prevKeyframe.getIntValue();
            int nextValue = nextKeyframe.getIntValue();
            float prevFraction = prevKeyframe.getFraction();
            float nextFraction = nextKeyframe.getFraction();
            final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
    if(interpolator != null)            
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            float intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            int varD872A655BF0293CA4E1695266E91C6D2_1802476837 = (mEvaluator == null ?
                    prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96735935 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96735935;
        } //End block
        else
    if(fraction >= 1f)        
        {
            final IntKeyframe prevKeyframe = (IntKeyframe) mKeyframes.get(mNumKeyframes - 2);
            final IntKeyframe nextKeyframe = (IntKeyframe) mKeyframes.get(mNumKeyframes - 1);
            int prevValue = prevKeyframe.getIntValue();
            int nextValue = nextKeyframe.getIntValue();
            float prevFraction = prevKeyframe.getFraction();
            float nextFraction = nextKeyframe.getFraction();
            final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
    if(interpolator != null)            
            {
                fraction = interpolator.getInterpolation(fraction);
            } //End block
            float intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            int varE4AC9FD6713B29414000FE956D0110E7_1761612175 = (mEvaluator == null ?
                    prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_513904950 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_513904950;
        } //End block
        IntKeyframe prevKeyframe = (IntKeyframe) mKeyframes.get(0);
for(int i = 1;i < mNumKeyframes;++i)
        {
            IntKeyframe nextKeyframe = (IntKeyframe) mKeyframes.get(i);
    if(fraction < nextKeyframe.getFraction())            
            {
                final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
    if(interpolator != null)                
                {
                    fraction = interpolator.getInterpolation(fraction);
                } //End block
                float intervalFraction = (fraction - prevKeyframe.getFraction()) /
                    (nextKeyframe.getFraction() - prevKeyframe.getFraction());
                int prevValue = prevKeyframe.getIntValue();
                int nextValue = nextKeyframe.getIntValue();
                int var0C51C231D0AAC9EEABC587A461CE45D7_713186263 = (mEvaluator == null ?
                        prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                        ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                                intValue());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376147691 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376147691;
            } //End block
            prevKeyframe = nextKeyframe;
        } //End block
        int varC8125D008825E472B7F808433A6C2B68_1381615955 = (((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548485170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548485170;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

