package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.backup.RestoreSession;
import android.app.backup.IBackupManager;
import android.app.backup.IRestoreSession;
import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class BackupManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.988 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.001 -0400", hash_original_method = "85561994F0AAB46E3AEAAB82C9107690", hash_generated_method = "0B376C856E6AD2AF391165CD38C9A30E")
    public  BackupManager(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
        private static void checkServiceBinder() {
        if (sService == null) {
            sService = IBackupManager.Stub.asInterface(
                    ServiceManager.getService(Context.BACKUP_SERVICE));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.003 -0400", hash_original_method = "ADE0596EF26D37CE11FFEC5E571C37D4", hash_generated_method = "9BA311BA7E54237547DCB21EA5B6F78C")
    public void dataChanged() {
        checkServiceBinder();
        {
            try 
            {
                sService.dataChanged(mContext.getPackageName());
            } //End block
            catch (RemoteException e)
            {
                Log.d(TAG, "dataChanged() couldn't connect");
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkServiceBinder();
        //if (sService != null) {
            //try {
                //sService.dataChanged(mContext.getPackageName());
            //} catch (RemoteException e) {
                //Log.d(TAG, "dataChanged() couldn't connect");
            //}
        //}
    }

    
        public static void dataChanged(String packageName) {
        checkServiceBinder();
        if (sService != null) {
            try {
                sService.dataChanged(packageName);
            } catch (RemoteException e) {
                Log.d(TAG, "dataChanged(pkg) couldn't connect");
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.033 -0400", hash_original_method = "0F46E379860B99708825D89131970D97", hash_generated_method = "B8DB8EA0E464DD5EED1B4321C3234519")
    public int requestRestore(RestoreObserver observer) {
        int result;
        result = -1;
        checkServiceBinder();
        {
            RestoreSession session;
            session = null;
            try 
            {
                IRestoreSession binder;
                binder = sService.beginRestoreSession(mContext.getPackageName(),
                        null);
                session = new RestoreSession(mContext, binder);
                result = session.restorePackage(mContext.getPackageName(), observer);
            } //End block
            catch (RemoteException e)
            { }
            finally 
            {
                {
                    session.endRestoreSession();
                } //End block
            } //End block
        } //End block
        addTaint(observer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187393765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187393765;
        // ---------- Original Method ----------
        //int result = -1;
        //checkServiceBinder();
        //if (sService != null) {
            //RestoreSession session = null;
            //try {
                //IRestoreSession binder = sService.beginRestoreSession(mContext.getPackageName(),
                        //null);
                //session = new RestoreSession(mContext, binder);
                //result = session.restorePackage(mContext.getPackageName(), observer);
            //} catch (RemoteException e) {
                //Log.w(TAG, "restoreSelf() unable to contact service");
            //} finally {
                //if (session != null) {
                    //session.endRestoreSession();
                //}
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.048 -0400", hash_original_method = "4E9AC35DE965C4DA64E27C8C094DFEC3", hash_generated_method = "C2D18908C6FB4C65772AA988F1C1B109")
    public RestoreSession beginRestoreSession() {
        RestoreSession varB4EAC82CA7396A68D541C85D26508E83_515180257 = null; //Variable for return #1
        RestoreSession session;
        session = null;
        checkServiceBinder();
        {
            try 
            {
                IRestoreSession binder;
                binder = sService.beginRestoreSession(null, null);
                session = new RestoreSession(mContext, binder);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_515180257 = session;
        varB4EAC82CA7396A68D541C85D26508E83_515180257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_515180257;
        // ---------- Original Method ----------
        //RestoreSession session = null;
        //checkServiceBinder();
        //if (sService != null) {
            //try {
                //IRestoreSession binder = sService.beginRestoreSession(null, null);
                //session = new RestoreSession(mContext, binder);
            //} catch (RemoteException e) {
                //Log.w(TAG, "beginRestoreSession() couldn't connect");
            //}
        //}
        //return session;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.049 -0400", hash_original_field = "A4EEA6554760A3C457438AA5B4D89B19", hash_generated_field = "184948296327761AA2960CFBE61B9EB6")

    private static String TAG = "BackupManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.049 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "A0386DA53DF2919548B4DED4A07BF9FC")

    private static IBackupManager sService;
}

