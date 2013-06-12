package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;

public class AbsoluteFileBackupHelper extends FileBackupHelperBase implements BackupHelper {
    private static String TAG = "AbsoluteFileBackupHelper";
    private static boolean DEBUG = false;
    Context mContext;
    String[] mFiles;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:00:30.902 -0400", hash_original_method = "E062E59C2FF313ED74BF17F545FA7B23", hash_generated_method = "E14CEF826F52E164BA198936D5029812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteFileBackupHelper(Context context, String... files) {
        super(context);
        dsTaint.addTaint(files);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
        //mFiles = files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:00:30.926 -0400", hash_original_method = "550273E8BE265087DF39C2618EEA7AE3", hash_generated_method = "081403771CAC695533AC585B04F080D8")
    @DSModeled(DSC.SAFE)
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState) {
        dsTaint.addTaint(oldState.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(newState.dsTaint);
        performBackup_checked(oldState, data, newState, mFiles, mFiles);
        // ---------- Original Method ----------
        //performBackup_checked(oldState, data, newState, mFiles, mFiles);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:00:30.970 -0400", hash_original_method = "63191FD51B76078F0FF4C83354368B49", hash_generated_method = "850391E81754D0E9DE3AA58DC4173FE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreEntity(BackupDataInputStream data) {
        dsTaint.addTaint(data.dsTaint);
        Log.d(TAG, "got entity '" + data.getKey() + "' size=" + data.size());
        String key;
        key = data.getKey();
        {
            boolean varD9E5131F618EF6756ADDB8E913817864_442904449 = (isKeyInList(key, mFiles));
            {
                File f;
                f = new File(key);
                writeFile(f, data);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "got entity '" + data.getKey() + "' size=" + data.size());
        //String key = data.getKey();
        //if (isKeyInList(key, mFiles)) {
            //File f = new File(key);
            //writeFile(f, data);
        //}
    }

    
}


