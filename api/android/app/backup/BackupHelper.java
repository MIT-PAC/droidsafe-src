package android.app.backup;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.ParcelFileDescriptor;

public interface BackupHelper {
    
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState);

    
    public void restoreEntity(BackupDataInputStream data);

    
    public void writeNewStateDescription(ParcelFileDescriptor newState);
}
