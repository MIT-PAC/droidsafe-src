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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import android.os.ParcelFileDescriptor;
import android.util.Log;

import droidsafe.helpers.DSUtils;

public class BackupHelperDispatcher {
    
    private static int readHeader_native(Header h, FileDescriptor fd) {
        h.addTaint(fd.getTaint());
        return h.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int skipChunk_native(FileDescriptor fd, int bytesToSkip) {
        fd.addTaint(bytesToSkip);
        return fd.getTaintInt();
    }
    
    private static int allocateHeader_native(Header h, FileDescriptor fd) {
        fd.addTaint(h.getTaint());
        h.addTaint(fd.getTaint());
        return h.getTaintInt();
    }
    
    private static int writeHeader_native(Header h, FileDescriptor fd, int pos) {
        fd.addTaint(h.getTaint());
        fd.addTaint(pos);
        return fd.getTaintInt();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.660 -0500", hash_original_field = "D272C13E9A9C0E3E4CA27E55BE191CFA", hash_generated_field = "AEF462BF91D0B416E4E3B66437F12C41")

    private static final String TAG = "BackupHelperDispatcher";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.668 -0500", hash_original_field = "087B9083817AA3054FE76BD13CD55CBF", hash_generated_field = "087B9083817AA3054FE76BD13CD55CBF")

    TreeMap<String,BackupHelper> mHelpers = new TreeMap<String,BackupHelper>();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.672 -0500", hash_original_method = "85B87DA3FD92CDAA8B7FFA5F20C0A756", hash_generated_method = "02FD004804F6626B90557A7727E0C650")
    
public BackupHelperDispatcher() {
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.674 -0500", hash_original_method = "A8E840254EBF3392B798809BE9F9086F", hash_generated_method = "79730BB33F60087E0AEB7F734D673C2E")
    
public void addHelper(String keyPrefix, BackupHelper helper) {
        mHelpers.put(keyPrefix, helper);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.677 -0500", hash_original_method = "B596D5B1B749A849E47ABD34415972F7", hash_generated_method = "2DB6F46FC080896E1612FC549CC80A3D")
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSVerified
public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException {
        // First, do the helpers that we've already done, since they're already in the state
        // file.
        int err;
        Header header = new Header();
        TreeMap<String,BackupHelper> helpers = (TreeMap<String,BackupHelper>)mHelpers.clone();
        FileDescriptor oldStateFD = null;
        FileDescriptor newStateFD = newState.getFileDescriptor();

        if (oldState != null) {
            oldStateFD = oldState.getFileDescriptor();
            while ((err = readHeader_native(header, oldStateFD)) >= 0) {
                if (err == 0) {
                    BackupHelper helper = helpers.get(header.keyPrefix);
                    Log.d(TAG, "handling existing helper '" + header.keyPrefix + "' " + helper);
                    if (helper != null) {
                        doOneBackup(oldState, data, newState, header, helper);
                        helpers.remove(header.keyPrefix);
                    } else {
                        skipChunk_native(oldStateFD, header.chunkSize);
                    }
                }
            }
        }

        // Then go through and do the rest that we haven't done.
        for (Map.Entry<String,BackupHelper> entry: helpers.entrySet()) {
            header.keyPrefix = entry.getKey();
            Log.d(TAG, "handling new helper '" + header.keyPrefix + "'");
            BackupHelper helper = entry.getValue();
            doOneBackup(oldState, data, newState, header, helper);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.680 -0500", hash_original_method = "B20B211F99695DC29EC53BF566272BED", hash_generated_method = "4239511687B764C693CD981B780FDE23")
    
private void doOneBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState, Header header, BackupHelper helper) 
            throws IOException {
        int err;
        FileDescriptor newStateFD = newState.getFileDescriptor();

        // allocate space for the header in the file
        int pos = allocateHeader_native(header, newStateFD);
        if (pos < 0) {
            throw new IOException("allocateHeader_native failed (error " + pos + ")");
        }

        data.setKeyPrefix(header.keyPrefix);

        // do the backup
        helper.performBackup(oldState, data, newState);

        // fill in the header (seeking back to pos).  The file pointer will be returned to
        // where it was at the end of performBackup.  Header.chunkSize will not be filled in.
        err = writeHeader_native(header, newStateFD, pos);
        if (err != 0) {
            throw new IOException("writeHeader_native failed (error " + err + ")");
        }
    }
    
    private static class Header {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.663 -0500", hash_original_field = "8D4654446C9DD3E766BE07B4267F3234", hash_generated_field = "8D4654446C9DD3E766BE07B4267F3234")

        int chunkSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.665 -0500", hash_original_field = "A9486E3C3418813783566D03E4768EE1", hash_generated_field = "A9486E3C3418813783566D03E4768EE1")

        String keyPrefix;
        
        @DSComment("Private Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.244 -0400", hash_original_method = "7DC9F4B0B6F0B6B866C998FD2825EB34", hash_generated_method = "7DC9F4B0B6F0B6B866C998FD2825EB34")
        public Header ()
        {
            //Synthesized constructor
        }

    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.683 -0500", hash_original_method = "5D2E23956580E2A3306D4050F8218E29", hash_generated_method = "C8CBD5B804A52AAF69F30F351ED21240")
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSVerified
public void performRestore(BackupDataInput input, int appVersionCode,
            ParcelFileDescriptor newState)
            throws IOException {
        boolean alreadyComplained = false;

        BackupDataInputStream stream = new BackupDataInputStream(input);
        while (input.readNextHeader()) {

            String rawKey = input.getKey();
            int pos = rawKey.indexOf(':');
            if (pos > 0) {
                String prefix = rawKey.substring(0, pos);
                BackupHelper helper = mHelpers.get(prefix);
                if (helper != null) {
                    stream.dataSize = input.getDataSize();
                    stream.key = rawKey.substring(pos+1);
                    helper.restoreEntity(stream);
                } else {
                    if (!alreadyComplained) {
                        Log.w(TAG, "Couldn't find helper for: '" + rawKey + "'");
                        alreadyComplained = true;
                    }
                }
            } else {
                if (!alreadyComplained) {
                    Log.w(TAG, "Entity with no prefix: '" + rawKey + "'");
                    alreadyComplained = true;
                }
            }
            input.skipEntityData(); // In case they didn't consume the data.
        }

        // Write out the state files -- mHelpers is a TreeMap, so the order is well defined.
        for (BackupHelper helper: mHelpers.values()) {
            helper.writeNewStateDescription(newState);
        }
    }
}

