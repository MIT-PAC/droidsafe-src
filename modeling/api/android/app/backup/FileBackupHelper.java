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

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;

public class FileBackupHelper extends FileBackupHelperBase implements BackupHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.156 -0500", hash_original_field = "4AA8978EA595B617A916023CE6C2E2ED", hash_generated_field = "CDEF20CCFEFAE12DD6C95EDA4EE82D22")

    private static final String TAG = "FileBackupHelper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.159 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.161 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.163 -0500", hash_original_field = "7B5121095E7B8659514EB86A9685C1BA", hash_generated_field = "7B5121095E7B8659514EB86A9685C1BA")

    File mFilesDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.165 -0500", hash_original_field = "028DBC0509F8F6F844F413AFCE72BE73", hash_generated_field = "028DBC0509F8F6F844F413AFCE72BE73")

    String[] mFiles;

    /**
     * Construct a helper to manage backup/restore of entire files within the
     * application's data directory hierarchy.
     *
     * @param context The backup agent's Context object
     * @param files A list of the files to be backed up or restored.
     */
    @DSComment("Backup subsystem")
    @DSSpec(DSCat.BACKUP_SUBSYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.168 -0500", hash_original_method = "7CBA866E381731475421534F9512B87B", hash_generated_method = "34184F7083DF5923092C9E735C13DE99")
    
public FileBackupHelper(Context context, String... files) {
        super(context);

        mContext = context;
        mFilesDir = context.getFilesDir();
        mFiles = files;
    }

    /**
     * Based on <code>oldState</code>, determine which of the files from the
     * application's data directory need to be backed up, write them to the data
     * stream, and fill in <code>newState</code> with the state as it exists
     * now. When <code>oldState</code> is <code>null</code>, all the files will
     * be backed up.
     * <p>
     * This should only be called directly from within the {@link BackupAgentHelper}
     * implementation. See
     * {@link android.app.backup.BackupAgent#onBackup(ParcelFileDescriptor, BackupDataOutput, ParcelFileDescriptor)}
     * for a description of parameter meanings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.170 -0500", hash_original_method = "4D62E84034BBC9E292FAA30B93C18D79", hash_generated_method = "3B9A62204A18233DBF8835B06D630E96")
    
public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState) {
        // file names
        String[] files = mFiles;
        File base = mContext.getFilesDir();
        final int N = files.length;
        String[] fullPaths = new String[N];
        for (int i=0; i<N; i++) {
            fullPaths[i] = (new File(base, files[i])).getAbsolutePath();
        }

        // go
        performBackup_checked(oldState, data, newState, fullPaths, files);
    }

    /**
     * Restore one record [representing a single file] from the restore dataset.
     * <p>
     * This should only be called directly from within the {@link BackupAgentHelper}
     * implementation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.173 -0500", hash_original_method = "F9437E8B6CBF659BF2444D9A1AC4A769", hash_generated_method = "A8981D9DFEAFC0A9477CC7646ADDC551")
    
public void restoreEntity(BackupDataInputStream data) {
        if (DEBUG) Log.d(TAG, "got entity '" + data.getKey() + "' size=" + data.size());
        String key = data.getKey();
        if (isKeyInList(key, mFiles)) {
            File f = new File(mFilesDir, key);
            writeFile(f, data);
        }
    }
}

