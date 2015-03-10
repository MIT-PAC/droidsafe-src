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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

public final class NfcFragment extends Fragment {

    /**
     * Attach NfcFragment to an activity (if not already attached).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.386 -0500", hash_original_method = "5F5F86625FDBBD98601D769A68A08C9E", hash_generated_method = "08C79EF4DE23BE7E2F54C7FF5009B2AE")
    
public static void attach(Activity activity) {
        FragmentManager manager = activity.getFragmentManager();
        if (manager.findFragmentByTag(FRAGMENT_TAG) == null) {
            manager.beginTransaction().add(new NfcFragment(), FRAGMENT_TAG).commit();
        }
    }

    /**
     * Remove NfcFragment from activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.389 -0500", hash_original_method = "B22A6A9FCAC23A7432F783A7943584BE", hash_generated_method = "1C3883CD016118ED827CE462FA5E440B")
    
public static void remove(Activity activity) {
        FragmentManager manager = activity.getFragmentManager();
        Fragment fragment = manager.findFragmentByTag(FRAGMENT_TAG);
        if (fragment != null) {
            // We allow state loss at this point, because the state is only
            // lost when activity is being paused *AND* subsequently destroyed.
            // In that case, the app will setup foreground dispatch again anyway.
            manager.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.378 -0500", hash_original_field = "6B027DAB93221C0A4B206727F47A890F", hash_generated_field = "A53AF82FE2AA77C2599D3D25AA595627")

    static final String FRAGMENT_TAG = "android.nfc.NfcFragment";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.381 -0500", hash_original_field = "85B25108193CD96000076C9FEB763F37", hash_generated_field = "F9BB84E3D4C91D00C4A915F1D24BE4F8")

    static boolean sIsInitialized = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.383 -0500", hash_original_field = "64F9D0BD0BD1C818A6DCF5C315B898C7", hash_generated_field = "90C87A13104818C85EE1C6CB0A407D60")

    static NfcActivityManager sNfcActivityManager;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.274 -0400", hash_original_method = "F4666E8353F6FA3AAFC2948046892751", hash_generated_method = "F4666E8353F6FA3AAFC2948046892751")
    public NfcFragment ()
    {
        //Synthesized constructor
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.392 -0500", hash_original_method = "9E8EF57626D62E2B7C3743DD3C3689D3", hash_generated_method = "578BCD98040E82A839BAC9BE66745CC4")
    
@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!sIsInitialized) {
            sIsInitialized = true;
            NfcAdapter adapter = NfcAdapter.getDefaultAdapter(
                    activity.getApplicationContext());
            if (adapter != null) {
                sNfcActivityManager = adapter.mNfcActivityManager;
            }
        }
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.394 -0500", hash_original_method = "94292D3BC9674D261A6EF4BCCF7C8037", hash_generated_method = "83EB981B596EF031ACD1ED4CD85BB59F")
    
@Override
    public void onResume() {
        super.onResume();
        if (sNfcActivityManager != null) {
            sNfcActivityManager.onResume(getActivity());
        }
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.397 -0500", hash_original_method = "3DB00EC587E995AABF9F1C949970BD43", hash_generated_method = "006AC812CA663BB84799CA8A15F305D3")
    
@Override
    public void onPause() {
        super.onPause();
        if (sNfcActivityManager != null) {
            sNfcActivityManager.onPause(getActivity());
        }
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.399 -0500", hash_original_method = "CC535C4F2465D6A6983D04B0B890F971", hash_generated_method = "C508A9E7E733198973F07FD56AF9B547")
    
@Override
    public void onDestroy() {
        super.onDestroy();
        if (sNfcActivityManager != null) {
            sNfcActivityManager.onDestroy(getActivity());
        }
    }
}

