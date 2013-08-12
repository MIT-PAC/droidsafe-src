package android.app.backup;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;



public class BackupManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.261 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.262 -0400", hash_original_method = "85561994F0AAB46E3AEAAB82C9107690", hash_generated_method = "0B376C856E6AD2AF391165CD38C9A30E")
    public  BackupManager(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSModeled(DSC.BAN)
    private static void checkServiceBinder() {
        if (sService == null) {
            sService = IBackupManager.Stub.asInterface(
                    ServiceManager.getService(Context.BACKUP_SERVICE));
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.263 -0400", hash_original_method = "ADE0596EF26D37CE11FFEC5E571C37D4", hash_generated_method = "57BE6CAFE4A4A5E54E5CCB7B51EC1DD7")
    public void dataChanged() {
        checkServiceBinder();
        if(sService != null)        
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.265 -0400", hash_original_method = "0F46E379860B99708825D89131970D97", hash_generated_method = "22C78B7FDCCE19171BB35BB77B620756")
    public int requestRestore(RestoreObserver observer) {
        addTaint(observer.getTaint());
        int result = -1;
        checkServiceBinder();
        if(sService != null)        
        {
            RestoreSession session = null;
            try 
            {
                IRestoreSession binder = sService.beginRestoreSession(mContext.getPackageName(),
                        null);
                session = new RestoreSession(mContext, binder);
                result = session.restorePackage(mContext.getPackageName(), observer);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            finally 
            {
                if(session != null)                
                {
                    session.endRestoreSession();
                } //End block
            } //End block
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1272729260 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619837343 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619837343;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.267 -0400", hash_original_method = "4E9AC35DE965C4DA64E27C8C094DFEC3", hash_generated_method = "C8FFCB3AB176ED67BC4BC695D851FFFF")
    public RestoreSession beginRestoreSession() {
        RestoreSession session = null;
        checkServiceBinder();
        if(sService != null)        
        {
            try 
            {
                IRestoreSession binder = sService.beginRestoreSession(null, null);
                session = new RestoreSession(mContext, binder);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
RestoreSession varD555E544A66E0F97DA6BCDE940E3E79C_632619107 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_632619107.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_632619107;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.267 -0400", hash_original_field = "A4EEA6554760A3C457438AA5B4D89B19", hash_generated_field = "46BC9109135FC2CB00B0B600F09C9710")

    private static final String TAG = "BackupManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.268 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "A0386DA53DF2919548B4DED4A07BF9FC")

    private static IBackupManager sService;
}

