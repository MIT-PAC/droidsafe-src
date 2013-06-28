package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.QueuedWork;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;

public class SharedPreferencesBackupHelper extends FileBackupHelperBase implements BackupHelper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.838 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.838 -0400", hash_original_field = "F0C78206B70401B929414E0F2480CF51", hash_generated_field = "3E4AAE035E48BA7652A5EEFD3A11385A")

    private String[] mPrefGroups;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.839 -0400", hash_original_method = "0602A3CA84DE179918FE8DD18D4D9269", hash_generated_method = "EBE642E7D513D7E674082B518D8DB45E")
    public  SharedPreferencesBackupHelper(Context context, String... prefGroups) {
        super(context);
        mContext = context;
        mPrefGroups = prefGroups;
        // ---------- Original Method ----------
        //mContext = context;
        //mPrefGroups = prefGroups;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.839 -0400", hash_original_method = "32B5B5F877732DB4D4CE78DD30722FCF", hash_generated_method = "361EEBA1125A39CDA04F4921DEB21C48")
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState) {
        Context context = mContext;
        QueuedWork.waitToFinish();
        String[] prefGroups = mPrefGroups;
        final int N = prefGroups.length;
        String[] files = new String[N];
        {
            int i = 0;
            {
                files[i] = context.getSharedPrefsFile(prefGroups[i]).getAbsolutePath();
            } //End block
        } //End collapsed parenthetic
        performBackup_checked(oldState, data, newState, files, prefGroups);
        addTaint(oldState.getTaint());
        addTaint(data.getTaint());
        addTaint(newState.getTaint());
        // ---------- Original Method ----------
        //Context context = mContext;
        //QueuedWork.waitToFinish();
        //String[] prefGroups = mPrefGroups;
        //final int N = prefGroups.length;
        //String[] files = new String[N];
        //for (int i=0; i<N; i++) {
            //files[i] = context.getSharedPrefsFile(prefGroups[i]).getAbsolutePath();
        //}
        //performBackup_checked(oldState, data, newState, files, prefGroups);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.840 -0400", hash_original_method = "4157DB54FF0EFBF9F8662A7A8A8DB6F2", hash_generated_method = "D2F0CFC992C15CA9B379ADEC4C844D4B")
    public void restoreEntity(BackupDataInputStream data) {
        Context context = mContext;
        String key = data.getKey();
        Log.d(TAG, "got entity '" + key + "' size=" + data.size());
        {
            boolean var43C83FA77B8308F4A4A9FE8770EDDD30_1819656818 = (isKeyInList(key, mPrefGroups));
            {
                File f = context.getSharedPrefsFile(key).getAbsoluteFile();
                writeFile(f, data);
            } //End block
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //Context context = mContext;
        //String key = data.getKey();
        //if (DEBUG) Log.d(TAG, "got entity '" + key + "' size=" + data.size());
        //if (isKeyInList(key, mPrefGroups)) {
            //File f = context.getSharedPrefsFile(key).getAbsoluteFile();
            //writeFile(f, data);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.840 -0400", hash_original_field = "070D1D1C1A0A52FBDA796851804C0781", hash_generated_field = "2A1678904A3C54D84365AE56750C6778")

    private static final String TAG = "SharedPreferencesBackupHelper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.840 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

