package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.ParcelFileDescriptor;

public class FullBackupDataOutput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.391 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "95CD9513D49C95A59EDDF775AA30563D")

    private BackupDataOutput mData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.403 -0400", hash_original_method = "F20038FDD5E96BD5179FFCE81ABE9BCA", hash_generated_method = "336EF307BBCD1C14672BB6762218FCFC")
    public  FullBackupDataOutput(ParcelFileDescriptor fd) {
        mData = new BackupDataOutput(fd.getFileDescriptor());
        // ---------- Original Method ----------
        //mData = new BackupDataOutput(fd.getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.404 -0400", hash_original_method = "F187747EE8138E5AF15EC08135568EB6", hash_generated_method = "B9680264E0660EDBB7E16F206DABDD2C")
    public BackupDataOutput getData() {
        BackupDataOutput varB4EAC82CA7396A68D541C85D26508E83_1155733362 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1155733362 = mData;
        varB4EAC82CA7396A68D541C85D26508E83_1155733362.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1155733362;
        // ---------- Original Method ----------
        //return mData;
    }

    
}

