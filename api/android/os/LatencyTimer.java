/*
 * Copyright (C) 2009 The Android Open Source Project
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

package android.os;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;

import java.util.HashMap;

/**
 * A class to help with measuring latency in your code.
 * 
 * Suggested usage:
 * 1) Instanciate a LatencyTimer as a class field.
 *      private [static] LatencyTimer mLt = new LatencyTimer(100, 1000);
 * 2) At various points in the code call sample with a string and the time delta to some fixed time.
 *    The string should be unique at each point of the code you are measuring.
 *      mLt.sample("before processing event", System.nanoTime() - event.getEventTimeNano());
 *      processEvent(event);
 *      mLt.sample("after processing event ", System.nanoTime() - event.getEventTimeNano());
 *
 * @hide
 */
public final class LatencyTimer
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.098 -0500", hash_original_field = "DDAFEA5773A243BDAFEA828EEE9287B8", hash_generated_field = "08A0999271C6D5823A6AC19A04F7DDE5")

    final String TAG = "LatencyTimer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.100 -0500", hash_original_field = "341AE9BAC099601FFA7F19184A5B7D01", hash_generated_field = "341AE9BAC099601FFA7F19184A5B7D01")

     int mSampleSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.102 -0500", hash_original_field = "D6E8944A61FF8754213A81D54D047CBA", hash_generated_field = "D6E8944A61FF8754213A81D54D047CBA")

     int mScaleFactor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.104 -0500", hash_original_field = "A16ED93A572834992FDE1FBB40890CE2", hash_generated_field = "51658E39095270441BD6250346D19EE4")

    volatile HashMap<String, long[]> store = new HashMap<String, long[]>();

    /**
    * Creates a LatencyTimer object
    * @param sampleSize number of samples to collect before printing out the average
    * @param scaleFactor divisor used to make each sample smaller to prevent overflow when
    *        (sampleSize * average sample value)/scaleFactor > Long.MAX_VALUE
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.107 -0500", hash_original_method = "835FE1F7A54E064837749981F903873B", hash_generated_method = "FD3D2C14491231F6263B4583056E8279")
    public LatencyTimer(int sampleSize, int scaleFactor) {
        if (scaleFactor == 0) {
            scaleFactor = 1;
        }
        mScaleFactor = scaleFactor;
        mSampleSize = sampleSize;
    }

    /**
     * Add a sample delay for averaging.
     * @param tag string used for printing out the result. This should be unique at each point of
     *  this called.
     * @param delta time difference from an unique point of reference for a particular iteration
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.110 -0500", hash_original_method = "D9E098017BDD3A062F96DACECBFE33D0", hash_generated_method = "8C9C0A073213EF6E79CE5BFC2500C0C1")
    public void sample(String tag, long delta) {
        long[] array = getArray(tag);

        // array[mSampleSize] holds the number of used entries
        final int index = (int) array[mSampleSize]++;
        array[index] = delta;
        if (array[mSampleSize] == mSampleSize) {
            long totalDelta = 0;
            for (long d : array) {
                totalDelta += d/mScaleFactor;
            }
            array[mSampleSize] = 0;
            Log.i(TAG, tag + " average = " + totalDelta / mSampleSize);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:50.113 -0500", hash_original_method = "CB4383AB457909CC128F04335BC91797", hash_generated_method = "C22542AC14FBF999F6A0D1F1C414B2FE")
    private long[] getArray(String tag) {
        long[] data = store.get(tag);
        if (data == null) {
            synchronized(store) {
                data = store.get(tag);
                if (data == null) {
                    data = new long[mSampleSize + 1];
                    store.put(tag, data);
                    data[mSampleSize] = 0;
                }
            }
        }
        return data;
    }
}
