package android.app.backup;

// Droidsafe Imports
import android.os.ParcelFileDescriptor;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class FullBackupDataOutput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.351 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "95CD9513D49C95A59EDDF775AA30563D")

    private BackupDataOutput mData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.352 -0400", hash_original_method = "F20038FDD5E96BD5179FFCE81ABE9BCA", hash_generated_method = "336EF307BBCD1C14672BB6762218FCFC")
    public  FullBackupDataOutput(ParcelFileDescriptor fd) {
        mData = new BackupDataOutput(fd.getFileDescriptor());
        // ---------- Original Method ----------
        //mData = new BackupDataOutput(fd.getFileDescriptor());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.352 -0400", hash_original_method = "F187747EE8138E5AF15EC08135568EB6", hash_generated_method = "E6CBFA716895F8B1BF3A70D44E4FD411")
    public BackupDataOutput getData() {
BackupDataOutput var623C3F1D556EBC2E104B1DFEC3C5702A_1811793460 =         mData;
        var623C3F1D556EBC2E104B1DFEC3C5702A_1811793460.addTaint(taint);
        return var623C3F1D556EBC2E104B1DFEC3C5702A_1811793460;
        // ---------- Original Method ----------
        //return mData;
    }

    
}

