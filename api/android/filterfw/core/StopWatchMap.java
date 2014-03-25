/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.SystemClock;
import android.util.Log;
import java.util.HashMap;

/**
 * @hide
 */
class StopWatch {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.701 -0400", hash_original_field = "EE5B21F26DF8E8294E24DDB73B354D7A", hash_generated_field = "F1069CFE00514D7ACB7D2E26B0B846D0")


    private int STOP_WATCH_LOGGING_PERIOD = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.703 -0400", hash_original_field = "82F07ED610CB5588CAE4B4F06973ADEF", hash_generated_field = "08CDB1D7AC6B2B3AC7CF7009CC8064AD")

    private String TAG = "MFF";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.704 -0400", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")


    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.706 -0400", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.708 -0400", hash_original_field = "5D7B5BADEC3C5FF900D67D14050A9706", hash_generated_field = "648DB5BB7C366C13F2699C1F41A487A9")

    private long mTotalTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.710 -0400", hash_original_field = "775A41B7A215BDF4A347BC34A36B9BE5", hash_generated_field = "C95107FF6E24EF191DEF9995D32DC772")

    private int mNumCalls;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.712 -0400", hash_original_method = "0D9D5F2923D7B40884BA34B4E9741524", hash_generated_method = "5D9FA6AC7EDD94605F7AB9426BFB1CCA")
    
public StopWatch(String name) {
        mName = name;
        mStartTime = -1;
        mTotalTime = 0;
        mNumCalls = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.714 -0400", hash_original_method = "C85DC1F0A38405DF6E0FDC5F67B4C341", hash_generated_method = "5ECEC94311186A8CBCF9DDC043BB6D42")
    
public void start() {
        if (mStartTime != -1) {
             throw new RuntimeException(
                 "Calling start with StopWatch already running");
        }
        mStartTime = SystemClock.elapsedRealtime();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.716 -0400", hash_original_method = "14D3B10AD8E22A23C69B3E92B18B12E4", hash_generated_method = "C0F599A48FA79A4FED6484A1757F3FCC")
    
public void stop() {
        if (mStartTime == -1) {
             throw new RuntimeException(
                 "Calling stop with StopWatch already stopped");
        }
        long stopTime = SystemClock.elapsedRealtime();
        mTotalTime += stopTime - mStartTime;
        ++mNumCalls;
        mStartTime = -1;
        if (mNumCalls % STOP_WATCH_LOGGING_PERIOD == 0) {
            Log.i(TAG, "AVG ms/call " + mName + ": " +
                  String.format("%.1f", mTotalTime * 1.0f / mNumCalls));
            mTotalTime = 0;
            mNumCalls = 0;
        }
    }

}

public class StopWatchMap {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.720 -0400", hash_original_field = "3FA6D48EDE48E41164B16612F2558351", hash_generated_field = "83A2B520C0BDB04671E8BA831C751F0B")


    public boolean LOG_MFF_RUNNING_TIMES = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.722 -0400", hash_original_field = "B9E7CAB756A881DB43DE86394C201323", hash_generated_field = "1EB78790224B3AA4E3416A465578B281")


    private HashMap<String, StopWatch> mStopWatches = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.725 -0400", hash_original_method = "3BD99ED6F710FDF86CC4807541E072C9", hash_generated_method = "D638D9C6002502B87C5CA824DE748150")
    
public StopWatchMap() {
        mStopWatches = new HashMap<String, StopWatch>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.727 -0400", hash_original_method = "9A4C63CEF7BA02FABDC684ABEB88EF64", hash_generated_method = "E06AA92B9B4E34A7BCBB997A20144F3B")
    
public void start(String stopWatchName) {
        if (!LOG_MFF_RUNNING_TIMES) {
            return;
        }
        if (!mStopWatches.containsKey(stopWatchName)) {
            mStopWatches.put(stopWatchName, new StopWatch(stopWatchName));
        }
        mStopWatches.get(stopWatchName).start();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.730 -0400", hash_original_method = "CBEACDA03DFFE34A3D857DBBC4EEE846", hash_generated_method = "979C2D02282AEDDA0D3E30CFCB38021E")
    
public void stop(String stopWatchName) {
        if (!LOG_MFF_RUNNING_TIMES) {
            return;
        }
        if (!mStopWatches.containsKey(stopWatchName)) {
            throw new RuntimeException(
                "Calling stop with unknown stopWatchName: " + stopWatchName);
        }
        mStopWatches.get(stopWatchName).stop();
    }

}
