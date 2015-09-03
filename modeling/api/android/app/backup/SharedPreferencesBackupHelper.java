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
import java.io.File;

import android.app.QueuedWork;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;

public class SharedPreferencesBackupHelper extends FileBackupHelperBase implements BackupHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.054 -0500", hash_original_field = "441F26F60CF437254480994BF97ED0E8", hash_generated_field = "2A1678904A3C54D84365AE56750C6778")

    private static final String TAG = "SharedPreferencesBackupHelper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.057 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.059 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.061 -0500", hash_original_field = "D4FB85489DC7C988AF7D7503985618B1", hash_generated_field = "3E4AAE035E48BA7652A5EEFD3A11385A")

    private String[] mPrefGroups;

    /**
     * Construct a helper for backing up and restoring the
     * {@link android.content.SharedPreferences} under the given names.
     *
     * @param context The application {@link android.content.Context}
     * @param prefGroups The names of each {@link android.content.SharedPreferences} file to
     * back up
     */
    @DSComment("Backup subsystem")
    @DSSpec(DSCat.BACKUP_SUBSYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.064 -0500", hash_original_method = "0602A3CA84DE179918FE8DD18D4D9269", hash_generated_method = "D931D31C3BF33D248BFC44CABDB8DD4D")
    
public SharedPreferencesBackupHelper(Context context, String... prefGroups) {
        super(context);

        mContext = context;
        mPrefGroups = prefGroups;
    }

    /**
     * Backs up the configured {@link android.content.SharedPreferences} groups.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.067 -0500", hash_original_method = "32B5B5F877732DB4D4CE78DD30722FCF", hash_generated_method = "5900981249FFB6B9CC7EEE5B801290E1")
    
public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState) {
        Context context = mContext;

        // If a SharedPreference has an outstanding write in flight,
        // wait for it to finish flushing to disk.
        QueuedWork.waitToFinish();

        // make filenames for the prefGroups
        String[] prefGroups = mPrefGroups;
        final int N = prefGroups.length;
        String[] files = new String[N];
        for (int i=0; i<N; i++) {
            files[i] = context.getSharedPrefsFile(prefGroups[i]).getAbsolutePath();
        }

        // go
        performBackup_checked(oldState, data, newState, files, prefGroups);
    }

    /**
     * Restores one entity from the restore data stream to its proper shared
     * preferences file store.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.069 -0500", hash_original_method = "4157DB54FF0EFBF9F8662A7A8A8DB6F2", hash_generated_method = "894EDC9231418AEFE5ABBFFA0E812A84")
    
public void restoreEntity(BackupDataInputStream data) {
        Context context = mContext;
        
        String key = data.getKey();
        if (DEBUG) Log.d(TAG, "got entity '" + key + "' size=" + data.size());

        if (isKeyInList(key, mPrefGroups)) {
            File f = context.getSharedPrefsFile(key).getAbsoluteFile();
            writeFile(f, data);
        }
    }
}

