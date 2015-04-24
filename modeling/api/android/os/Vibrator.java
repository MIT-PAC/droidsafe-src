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
 * Copyright (C) 2006 The Android Open Source Project
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
import android.util.Log;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class Vibrator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.201 -0500", hash_original_field = "978871C473963B7B85160A7F3D0A428F", hash_generated_field = "58FE1B639F58F6B845A5213089DAFE03")

    private static final String TAG = "Vibrator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.203 -0500", hash_original_field = "6D5176DB6DC642185DCF8E32C5EC1BC9", hash_generated_field = "6D5176DB6DC642185DCF8E32C5EC1BC9")

    IVibratorService mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.205 -0500", hash_original_field = "B6655DE5A418A8AD5DE782E8D5BD3E0A", hash_generated_field = "338AF9C7C3937329885532B2150C11ED")

    private final Binder mToken = new Binder();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_method = "EB80C050D853B4D9B5A1231C0F61B7C6", hash_generated_method = "4A65C1EF3E63664EB269704222364679")
    public  Vibrator() {
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_method = "340743421AEB659E5123D51116E8257B", hash_generated_method = "151D3F2E4276DA07BF42252D33EAFAD7")
    public boolean hasVibrator() {
        return getTaintBoolean();
        // ---------- Original Method ----------
        //if (mService == null) {
            //Log.w(TAG, "Failed to vibrate; no vibrator service.");
            //return false;
        //}
        //try {
            //return mService.hasVibrator();
        //} catch (RemoteException e) {
        //}
        //return false;
    }
        
@DSComment("only vibrating the device")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_method = "7274B01F62B26782B2CB11F21188B55D", hash_generated_method = "923B04A13431F62D932999C01EF768BD")
    public void vibrate(long milliseconds) {
        addTaint(milliseconds);
        //End block
        // ---------- Original Method ----------
        //if (mService == null) {
            //Log.w(TAG, "Failed to vibrate; no vibrator service.");
            //return;
        //}
        //try {
            //mService.vibrate(milliseconds, mToken);
        //} catch (RemoteException e) {
            //Log.w(TAG, "Failed to vibrate.", e);
        //}
    }
    
    @DSComment("only vibrating the device")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.819 -0400", hash_original_method = "7A7D54B587DD258FAC49023E7C932C75", hash_generated_method = "4FEC1D25C674D0C4EBF3B684610D737E")
    public void vibrate(long[] pattern, int repeat) {
        addTaint((int)pattern[0] + repeat);
    	//End block
        // ---------- Original Method ----------
        //if (mService == null) {
            //Log.w(TAG, "Failed to vibrate; no vibrator service.");
            //return;
        //}
        //if (repeat < pattern.length) {
            //try {
                //mService.vibratePattern(pattern, repeat, mToken);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed to vibrate.", e);
            //}
        //} else {
            //throw new ArrayIndexOutOfBoundsException();
        //}
    }

    /**
     * Turn the vibrator off.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.217 -0500", hash_original_method = "9CFB04510A80ABA723862EE634095A2D", hash_generated_method = "9713832FE84F3FCBD8DE0E9E6E792254")
    
public void cancel()
    {
        if (mService == null) {
            return;
        }
        try {
            mService.cancelVibrate(mToken);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to cancel vibration.", e);
        }
    }
}

