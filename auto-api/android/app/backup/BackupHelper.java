package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.ParcelFileDescriptor;

public interface BackupHelper {
    
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState);

    
    public void restoreEntity(BackupDataInputStream data);

    
    public void writeNewStateDescription(ParcelFileDescriptor newState);
}
