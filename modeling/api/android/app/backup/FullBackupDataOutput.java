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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.ParcelFileDescriptor;

public class FullBackupDataOutput {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.658 -0500", hash_original_field = "F7A31641E42F40DC97555D68D21A3967", hash_generated_field = "95CD9513D49C95A59EDDF775AA30563D")

    private BackupDataOutput mData;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.661 -0500", hash_original_method = "F20038FDD5E96BD5179FFCE81ABE9BCA", hash_generated_method = "B03E7A41733942583B4341B7861B589D")
    
public FullBackupDataOutput(ParcelFileDescriptor fd) {
        mData = new BackupDataOutput(fd.getFileDescriptor());
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.663 -0500", hash_original_method = "F187747EE8138E5AF15EC08135568EB6", hash_generated_method = "1999C1F37224972E9413C282F4DC28AC")
    
public BackupDataOutput getData() { return mData; }
    
}

