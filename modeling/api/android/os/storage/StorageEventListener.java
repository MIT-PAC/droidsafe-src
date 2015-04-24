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


package android.os.storage;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class StorageEventListener {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.025 -0400", hash_original_method = "61076BC963620255AB850D9EEFFDEDA8", hash_generated_method = "61076BC963620255AB850D9EEFFDEDA8")
    public StorageEventListener ()
    {
        //Synthesized constructor
    }
    /**
     * Called when the detection state of a USB Mass Storage host has changed.
     * @param connected true if the USB mass storage is connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.620 -0500", hash_original_method = "08B6588D85EC619CC2E0611C0812F3DA", hash_generated_method = "C90550FE6E97011D369405A6A248602A")
    
public void onUsbMassStorageConnectionChanged(boolean connected) {
    }

    /**
     * Called when storage has changed state
     * @param path the filesystem path for the storage
     * @param oldState the old state as returned by {@link android.os.Environment#getExternalStorageState()}.
     * @param newState the old state as returned by {@link android.os.Environment#getExternalStorageState()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.622 -0500", hash_original_method = "B80645FD27258B59A3B650E166B00E17", hash_generated_method = "A5B61089733833334EA5476745C29883")
    
public void onStorageStateChanged(String path, String oldState, String newState) {
    }
    
}

