package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;

public class FileBackupHelper extends FileBackupHelperBase implements BackupHelper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.287 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.287 -0400", hash_original_field = "73A71AF7C46968236F3164132333F1FD", hash_generated_field = "7B5121095E7B8659514EB86A9685C1BA")

    File mFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.287 -0400", hash_original_field = "8CD98A7016D9046BE81CB58922932728", hash_generated_field = "028DBC0509F8F6F844F413AFCE72BE73")

    String[] mFiles;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.288 -0400", hash_original_method = "7CBA866E381731475421534F9512B87B", hash_generated_method = "DA45A194F4614DC509685B444FDC577F")
    public  FileBackupHelper(Context context, String... files) {
        super(context);
        mContext = context;
        mFilesDir = context.getFilesDir();
        mFiles = files;
        // ---------- Original Method ----------
        //mContext = context;
        //mFilesDir = context.getFilesDir();
        //mFiles = files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.290 -0400", hash_original_method = "4D62E84034BBC9E292FAA30B93C18D79", hash_generated_method = "6B8618923A5C89BF1DEC956F152B4BAD")
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState) {
        addTaint(newState.getTaint());
        addTaint(data.getTaint());
        addTaint(oldState.getTaint());
        String[] files = mFiles;
        File base = mContext.getFilesDir();
        final int N = files.length;
        String[] fullPaths = new String[N];
for(int i=0;i<N;i++)
        {
            fullPaths[i] = (new File(base, files[i])).getAbsolutePath();
        } //End block
        performBackup_checked(oldState, data, newState, fullPaths, files);
        // ---------- Original Method ----------
        //String[] files = mFiles;
        //File base = mContext.getFilesDir();
        //final int N = files.length;
        //String[] fullPaths = new String[N];
        //for (int i=0; i<N; i++) {
            //fullPaths[i] = (new File(base, files[i])).getAbsolutePath();
        //}
        //performBackup_checked(oldState, data, newState, fullPaths, files);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.293 -0400", hash_original_method = "F9437E8B6CBF659BF2444D9A1AC4A769", hash_generated_method = "2621ED04CD921D98A4BF4A93676355B4")
    public void restoreEntity(BackupDataInputStream data) {
        addTaint(data.getTaint());
        if(DEBUG)        
        Log.d(TAG, "got entity '" + data.getKey() + "' size=" + data.size());
        String key = data.getKey();
        if(isKeyInList(key, mFiles))        
        {
            File f = new File(mFilesDir, key);
            writeFile(f, data);
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "got entity '" + data.getKey() + "' size=" + data.size());
        //String key = data.getKey();
        //if (isKeyInList(key, mFiles)) {
            //File f = new File(mFilesDir, key);
            //writeFile(f, data);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.293 -0400", hash_original_field = "81ABB5DB58670EE1E1B45368C639ED3D", hash_generated_field = "CDEF20CCFEFAE12DD6C95EDA4EE82D22")

    private static final String TAG = "FileBackupHelper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.294 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

