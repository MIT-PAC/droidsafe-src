package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.ParcelFileDescriptor;

public class FullBackupDataOutput {
    private BackupDataOutput mData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.767 -0400", hash_original_method = "F20038FDD5E96BD5179FFCE81ABE9BCA", hash_generated_method = "FF4ACC606DDB4B887D2B75861EE2B51C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FullBackupDataOutput(ParcelFileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        mData = new BackupDataOutput(fd.getFileDescriptor());
        // ---------- Original Method ----------
        //mData = new BackupDataOutput(fd.getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.768 -0400", hash_original_method = "F187747EE8138E5AF15EC08135568EB6", hash_generated_method = "FE34D87013B8080B487378C5683E1F34")
    @DSModeled(DSC.SAFE)
    public BackupDataOutput getData() {
        return (BackupDataOutput)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mData;
    }

    
}

