package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;

import android.app.QueuedWork;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;



public class SharedPreferencesBackupHelper extends FileBackupHelperBase implements BackupHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.914 -0500", hash_original_field = "441F26F60CF437254480994BF97ED0E8", hash_generated_field = "2A1678904A3C54D84365AE56750C6778")

    private static final String TAG = "SharedPreferencesBackupHelper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.915 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.916 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.916 -0500", hash_original_field = "D4FB85489DC7C988AF7D7503985618B1", hash_generated_field = "3E4AAE035E48BA7652A5EEFD3A11385A")

    private String[] mPrefGroups;

    /**
     * Construct a helper for backing up and restoring the
     * {@link android.content.SharedPreferences} under the given names.
     *
     * @param context The application {@link android.content.Context}
     * @param prefGroups The names of each {@link android.content.SharedPreferences} file to
     * back up
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.917 -0500", hash_original_method = "0602A3CA84DE179918FE8DD18D4D9269", hash_generated_method = "D931D31C3BF33D248BFC44CABDB8DD4D")
    public SharedPreferencesBackupHelper(Context context, String... prefGroups) {
        super(context);

        mContext = context;
        mPrefGroups = prefGroups;
    }

    /**
     * Backs up the configured {@link android.content.SharedPreferences} groups.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.918 -0500", hash_original_method = "32B5B5F877732DB4D4CE78DD30722FCF", hash_generated_method = "5900981249FFB6B9CC7EEE5B801290E1")
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState) {
        Context context = mContext;

        // If a SharedPreference has an outstanding write in flight,
        // wait for it to finish flushing to disk.
        QueuedWork.waitToFinish();

        // make filenames for the prefGroups
        String[] prefGroups = mPrefGroups;
        final int N = prefGroups.length;
        String[] files = new String[N];
        for (int i=0; i<N; i++) {
            files[i] = context.getSharedPrefsFile(prefGroups[i]).getAbsolutePath();
        }

        // go
        performBackup_checked(oldState, data, newState, files, prefGroups);
    }

    /**
     * Restores one entity from the restore data stream to its proper shared
     * preferences file store.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.919 -0500", hash_original_method = "4157DB54FF0EFBF9F8662A7A8A8DB6F2", hash_generated_method = "894EDC9231418AEFE5ABBFFA0E812A84")
    public void restoreEntity(BackupDataInputStream data) {
        Context context = mContext;
        
        String key = data.getKey();
        if (DEBUG) Log.d(TAG, "got entity '" + key + "' size=" + data.size());

        if (isKeyInList(key, mPrefGroups)) {
            File f = context.getSharedPrefsFile(key).getAbsoluteFile();
            writeFile(f, data);
        }
    }
}

