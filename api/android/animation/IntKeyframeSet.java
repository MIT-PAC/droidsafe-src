package android.animation;

// Droidsafe Imports
import java.util.ArrayList;

import android.animation.Keyframe.IntKeyframe;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

class IntKeyframeSet extends KeyframeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.672 -0400", hash_original_field = "235063B1CBCA83735C62ED6B83B05F45", hash_generated_field = "CCD07B82BF514AF2BA45DC7821C1FB70")

    private int firstValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.673 -0400", hash_original_field = "8EFF7B65464999C8928BEF678BFFA00B", hash_generated_field = "C61F9B7F3773608B569D6EA3B1F7CFAB")

    private int lastValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.675 -0400", hash_original_field = "E007AB501C2996F5F53045C2F8C10AA2", hash_generated_field = "AF830F3ABC6E7D884EA4ED2FCFAB117E")

    private int deltaValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.677 -0400", hash_original_field = "A7893FAED7826B5857859A98202AF417", hash_generated_field = "38B092BB517A9D8CB0718E3125088A8D")

    private boolean firstTime = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.678 -0400", hash_original_method = "64E77D5D4265D6E8D649F0A18EA66E47", hash_generated_method = "6C4421523E75FD4F9637AF40E17C4367")
    public  IntKeyframeSet(IntKeyframe... keyframes) {
        super(keyframes);
        addTaint(keyframes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.681 -0400", hash_original_method = "9A8CA9046BD131DAA0650B91E65A3FB9", hash_generated_method = "6B4223F7C5A95047B148F53F85050A1A")
    @Override
    public Object getValue(float fraction) {
        addTaint(fraction);
Object var3985029DEDBD38B26428925A8A7331F2_231053745 =         getIntValue(fraction);
        var3985029DEDBD38B26428925A8A7331F2_231053745.addTaint(taint);
        return var3985029DEDBD38B26428925A8A7331F2_231053745;
        // ---------- Original Method ----------
        //return getIntValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.684 -0400", hash_original_method = "9997EE114626B9F926D48E4DA6AD12AC", hash_generated_method = "0EF71EA9FCA587D44EA3BBAD20C4F5D3")
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
IntKeyframeSet var887F3F78AE0C9FB0CC98EDF99F492138_1405039933 =         newSet;
        var887F3F78AE0C9FB0CC98EDF99F492138_1405039933.addTaint(taint);
        return var887F3F78AE0C9FB0CC98EDF99F492138_1405039933;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.699 -0400", hash_original_method = "7B6E2369DEAB44F75E4F137274BA59BB", hash_generated_method = "7DDB685A3985E203837B55F8AFF6E651")
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
                int varAF30D29E9B50E82F512C293E14AE687B_690859660 = (firstValue + (int)(fraction * deltaValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14781476 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14781476;
            } //End block
            else
            {
                int varCC7664A623574ECCF07CE310B2E0F08B_11002462 = (((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).intValue());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519458391 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519458391;
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
            int varD872A655BF0293CA4E1695266E91C6D2_1191549605 = (mEvaluator == null ?
                    prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348587561 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348587561;
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
            int varE4AC9FD6713B29414000FE956D0110E7_1039599816 = (mEvaluator == null ?
                    prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862548398 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862548398;
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
                int var0C51C231D0AAC9EEABC587A461CE45D7_1552661283 = (mEvaluator == null ?
                        prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                        ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                                intValue());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098011742 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098011742;
            } //End block
            prevKeyframe = nextKeyframe;
        } //End block
        int varC8125D008825E472B7F808433A6C2B68_800052370 = (((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911242341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911242341;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

