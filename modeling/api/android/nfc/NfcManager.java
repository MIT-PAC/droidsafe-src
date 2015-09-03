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


package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;

public final class NfcManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.350 -0500", hash_original_field = "278F7851F6317C51C418D85323A63D34", hash_generated_field = "ED79E91C532F555A55D38CC488E317EF")

    private  NfcAdapter mAdapter;

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.352 -0500", hash_original_method = "5612BA010CEBE1CDB104E5EE130CB87B", hash_generated_method = "832009535D5905BC98603D93F5423842")
    
public NfcManager(Context context) {
        NfcAdapter adapter;
        context = context.getApplicationContext();
        try {
            adapter = NfcAdapter.getNfcAdapter(context);
        } catch (UnsupportedOperationException e) {
            adapter = null;
        }
        mAdapter = adapter;
    }

    /**
     * Get the default NFC Adapter for this device.
     *
     * @return the default NFC Adapter
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.355 -0500", hash_original_method = "4CC1396725247CE50C996383E5F907DD", hash_generated_method = "803C3CA85BB70A9D891EDBBF5726E533")
    
public NfcAdapter getDefaultAdapter() {
        return mAdapter;
    }
    
}

