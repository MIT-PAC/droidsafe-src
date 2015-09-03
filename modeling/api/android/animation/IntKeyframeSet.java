/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.animation.Keyframe.IntKeyframe;

class IntKeyframeSet extends KeyframeSet {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.280 -0500", hash_original_field = "D7C570C1A8BC4A63589CBEB595FA32A4", hash_generated_field = "CCD07B82BF514AF2BA45DC7821C1FB70")

    private int firstValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.282 -0500", hash_original_field = "F6660164170FAEB6EBE204DD70033325", hash_generated_field = "C61F9B7F3773608B569D6EA3B1F7CFAB")

    private int lastValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.284 -0500", hash_original_field = "188BB588952B109C42F8A434D5AA24CC", hash_generated_field = "AF830F3ABC6E7D884EA4ED2FCFAB117E")

    private int deltaValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.287 -0500", hash_original_field = "F412180418A11B6AA562D209649B7A4F", hash_generated_field = "38B092BB517A9D8CB0718E3125088A8D")

    private boolean firstTime = true;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.290 -0500", hash_original_method = "64E77D5D4265D6E8D649F0A18EA66E47", hash_generated_method = "7BB77F9600CAA520A18582235F2C1E1C")
    
public IntKeyframeSet(IntKeyframe... keyframes) {
        super(keyframes);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.292 -0500", hash_original_method = "9A8CA9046BD131DAA0650B91E65A3FB9", hash_generated_method = "24F6A53CF731B7867C333CCC5DA206D6")
    
@Override
    public Object getValue(float fraction) {
        return getIntValue(fraction);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.294 -0500", hash_original_method = "9997EE114626B9F926D48E4DA6AD12AC", hash_generated_method = "DA3DC9C66EE70173E0F7E1A807F7BFB8")
    
@Override
    public IntKeyframeSet clone() {
        ArrayList<Keyframe> keyframes = mKeyframes;
        int numKeyframes = mKeyframes.size();
        IntKeyframe[] newKeyframes = new IntKeyframe[numKeyframes];
        for (int i = 0; i < numKeyframes; ++i) {
            newKeyframes[i] = (IntKeyframe) keyframes.get(i).clone();
        }
        IntKeyframeSet newSet = new IntKeyframeSet(newKeyframes);
        return newSet;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.298 -0500", hash_original_method = "7B6E2369DEAB44F75E4F137274BA59BB", hash_generated_method = "566B4FE64534C71386D22372B7BA3C5A")
    
public int getIntValue(float fraction) {
        if (mNumKeyframes == 2) {
            if (firstTime) {
                firstTime = false;
                firstValue = ((IntKeyframe) mKeyframes.get(0)).getIntValue();
                lastValue = ((IntKeyframe) mKeyframes.get(1)).getIntValue();
                deltaValue = lastValue - firstValue;
            }
            if (mInterpolator != null) {
                fraction = mInterpolator.getInterpolation(fraction);
            }
            if (mEvaluator == null) {
                return firstValue + (int)(fraction * deltaValue);
            } else {
                return ((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).intValue();
            }
        }
        if (fraction <= 0f) {
            final IntKeyframe prevKeyframe = (IntKeyframe) mKeyframes.get(0);
            final IntKeyframe nextKeyframe = (IntKeyframe) mKeyframes.get(1);
            int prevValue = prevKeyframe.getIntValue();
            int nextValue = nextKeyframe.getIntValue();
            float prevFraction = prevKeyframe.getFraction();
            float nextFraction = nextKeyframe.getFraction();
            final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            float intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            return mEvaluator == null ?
                    prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            intValue();
        } else if (fraction >= 1f) {
            final IntKeyframe prevKeyframe = (IntKeyframe) mKeyframes.get(mNumKeyframes - 2);
            final IntKeyframe nextKeyframe = (IntKeyframe) mKeyframes.get(mNumKeyframes - 1);
            int prevValue = prevKeyframe.getIntValue();
            int nextValue = nextKeyframe.getIntValue();
            float prevFraction = prevKeyframe.getFraction();
            float nextFraction = nextKeyframe.getFraction();
            final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            float intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            return mEvaluator == null ?
                    prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).intValue();
        }
        IntKeyframe prevKeyframe = (IntKeyframe) mKeyframes.get(0);
        for (int i = 1; i < mNumKeyframes; ++i) {
            IntKeyframe nextKeyframe = (IntKeyframe) mKeyframes.get(i);
            if (fraction < nextKeyframe.getFraction()) {
                final TimeInterpolator interpolator = nextKeyframe.getInterpolator();
                if (interpolator != null) {
                    fraction = interpolator.getInterpolation(fraction);
                }
                float intervalFraction = (fraction - prevKeyframe.getFraction()) /
                    (nextKeyframe.getFraction() - prevKeyframe.getFraction());
                int prevValue = prevKeyframe.getIntValue();
                int nextValue = nextKeyframe.getIntValue();
                return mEvaluator == null ?
                        prevValue + (int)(intervalFraction * (nextValue - prevValue)) :
                        ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                                intValue();
            }
            prevKeyframe = nextKeyframe;
        }
        // shouldn't get here
        return ((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).intValue();
    }
    
}

