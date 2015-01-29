package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import android.os.ParcelFileDescriptor;

public class BackupAgentHelper extends BackupAgent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.123 -0500", hash_original_field = "79738B260E9056D178D21C2CED187600", hash_generated_field = "20CA2E7D14616BCC61CA084E80B8022D")

    static final String TAG = "BackupAgentHelper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.125 -0500", hash_original_field = "60A0C9A2E37C523B1D67C9306AA95150", hash_generated_field = "60A0C9A2E37C523B1D67C9306AA95150")

    BackupHelperDispatcher mDispatcher = new BackupHelperDispatcher();
    
    @DSComment("Backup subsystem")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.140 -0400", hash_original_method = "DE5015AA9AF8D8BEBF76E2231F1F38FA", hash_generated_method = "DE5015AA9AF8D8BEBF76E2231F1F38FA")
    public BackupAgentHelper ()
    {
        //Synthesized constructor
    }

    /**
     * Run the backup process on each of the configured handlers.
     */
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.127 -0500", hash_original_method = "9A231220123F2F65AC76F55439204202", hash_generated_method = "4B27DE55ED62E3465E0AE69468C5694B")
    @DSVerified("Called from BackupManager")
@Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException {
        mDispatcher.performBackup(oldState, data, newState);
    }

    /**
     * Run the restore process on each of the configured handlers.
     */
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.130 -0500", hash_original_method = "73F73FE661E634DA2EF3458F6B4B1263", hash_generated_method = "3057EF61A5E1D3097A01AB9DA476A12D")
    @DSVerified("Called from BackupManager")
    
@Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState)
            throws IOException {
        mDispatcher.performRestore(data, appVersionCode, newState);
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.133 -0500", hash_original_method = "846FCA7C7B95F7683BAEC473D9697583", hash_generated_method = "B1CF8ABC069741BD2E7D239784E01135")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public BackupHelperDispatcher getDispatcher() {
        return mDispatcher;
    }

    /**
     * Add a helper for a given data subset to the agent's configuration.  Each helper
     * must have a prefix string that is unique within this backup agent's set of
     * helpers.
     *
     * @param keyPrefix A string used to disambiguate the various helpers within this agent
     * @param helper A backup/restore helper object to be invoked during backup and restore
     *    operations.
     */
    @DSComment("Backup subsystem")
    @DSSpec(DSCat.BACKUP_SUBSYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.135 -0500", hash_original_method = "6BB48EA11B41145F61B4C8931E48479C", hash_generated_method = "2F398251A4B4BA69F0D269FB2F029880")
    
public void addHelper(String keyPrefix, BackupHelper helper) {
        mDispatcher.addHelper(keyPrefix, helper);
    }
}

