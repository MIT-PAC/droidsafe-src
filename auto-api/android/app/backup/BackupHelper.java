package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.ParcelFileDescriptor;

public interface BackupHelper {
    
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState);

    
    public void restoreEntity(BackupDataInputStream data);

    
    public void writeNewStateDescription(ParcelFileDescriptor newState);
}
