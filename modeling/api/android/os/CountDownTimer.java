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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class CountDownTimer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.299 -0500", hash_original_field = "8557F663F2CA791045D2FF3466462D8B", hash_generated_field = "33207288B866F3DDE85211D1B4FA47BB")

    private static final int MSG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.280 -0500", hash_original_field = "6DF1C9262208697CB00895711C8436E7", hash_generated_field = "55875BD3E9D866BEA2C437122061CD6E")

    private  long mMillisInFuture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.283 -0500", hash_original_field = "3586F9519F642C2CCD43DF193EE51580", hash_generated_field = "680815491847B69D8671F5F72C72E2CE")

    private  long mCountdownInterval;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.285 -0500", hash_original_field = "BEE62FB3FBD7F45B8344325BC083E555", hash_generated_field = "6E03F58BFB699FC4A4C5B3CDD86B2F5D")

    private long mStopTimeInFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.068 -0400", hash_original_field = "5ACB42150E6910CF60F8ACA03F3FCF2B", hash_generated_field = "42F1EE03623FE9A5876F5AA26D4DF01A")

    private Handler mHandler = new Handler() {        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.068 -0400", hash_original_method = "7B84927A7A341E4B7E3F8DD42DA9B8B6", hash_generated_method = "0C36A2A611F570EA11A2EE877F8B441B")
        @Override
        public void handleMessage(Message msg) {
            {
                Object var551173F8929BB98D218065CC95BB0441_260042709 = (CountDownTimer.this);
                {
                    final long millisLeft = mStopTimeInFuture - SystemClock.elapsedRealtime();
                    {
                        onFinish();
                    } 
                    {
                        sendMessageDelayed(obtainMessage(MSG), millisLeft);
                    } 
                    {
                        long lastTickStart = SystemClock.elapsedRealtime();
                        onTick(millisLeft);
                        long delay = lastTickStart + mCountdownInterval - SystemClock.elapsedRealtime();
                        delay += mCountdownInterval;
                        sendMessageDelayed(obtainMessage(MSG), delay);
                    } 
                } 
            } 
            addTaint(msg.getTaint());
            
        }
        
};

    /**
     * @param millisInFuture The number of millis in the future from the call
     *   to {@link #start()} until the countdown is done and {@link #onFinish()}
     *   is called.
     * @param countDownInterval The interval along the way to receive
     *   {@link #onTick(long)} callbacks.
     */
    @DSComment("General OS service, check callback")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.287 -0500", hash_original_method = "64AD26CC4F853CBE40630E575971F568", hash_generated_method = "3CB4D91D5AE8165405421B633073217D")
    
public CountDownTimer(long millisInFuture, long countDownInterval) {
        mMillisInFuture = millisInFuture;
        mCountdownInterval = countDownInterval;
    }

    /**
     * Cancel the countdown.
     */
    @DSComment("General OS service, check callback")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.290 -0500", hash_original_method = "668A5D3225CBBDE8895EF9129976DF1D", hash_generated_method = "BE37793361F718607EE062AB62F0D328")
    
public final void cancel() {
        mHandler.removeMessages(MSG);
    }

    /**
     * Start the countdown.
     */
    @DSComment("General OS service, check callback")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.293 -0500", hash_original_method = "9B88C24B384B8F4F3D5DCE994477E303", hash_generated_method = "CE7A286EC6CED7A9478DE9B4617AF590")
    
public synchronized final CountDownTimer start() {
        if (mMillisInFuture <= 0) {
            onFinish();
            return this;
        }
        mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
        return this;
    }

    /**
     * Callback fired on regular interval.
     * @param millisUntilFinished The amount of time until finished.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.295 -0500", hash_original_method = "68C489D797DF2A96C0EEDEC59003AE1B", hash_generated_method = "0DA4D4CB02C38A9B8CBAAACB5DAAAC69")
    
public abstract void onTick(long millisUntilFinished);

    /**
     * Callback fired when the time is up.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.297 -0500", hash_original_method = "1D32CADD71AC39A935B309A8116CB641", hash_generated_method = "CF6F808962E70040A3C1C9EEBCB2B8A8")
    
public abstract void onFinish();
}

