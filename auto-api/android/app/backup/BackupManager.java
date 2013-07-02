package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.backup.RestoreSession;
import android.app.backup.IBackupManager;
import android.app.backup.IRestoreSession;
import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class BackupManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.518 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.518 -0400", hash_original_method = "85561994F0AAB46E3AEAAB82C9107690", hash_generated_method = "0B376C856E6AD2AF391165CD38C9A30E")
    public  BackupManager(Context context) {
        mContext = context;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkServiceBinder() {
        if (sService == null) {
            sService = IBackupManager.Stub.asInterface(
                    ServiceManager.getService(Context.BACKUP_SERVICE));
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.519 -0400", hash_original_method = "ADE0596EF26D37CE11FFEC5E571C37D4", hash_generated_method = "9BA311BA7E54237547DCB21EA5B6F78C")
    public void dataChanged() {
        checkServiceBinder();
        {
            try 
            {
                sService.dataChanged(mContext.getPackageName());
            } 
            catch (RemoteException e)
            {
                Log.d(TAG, "dataChanged() couldn't connect");
            } 
        } 
        
        
        
            
                
            
                
            
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.522 -0400", hash_original_method = "0F46E379860B99708825D89131970D97", hash_generated_method = "0BCD43FA8464FD6407A9BD1288618D0E")
    public int requestRestore(RestoreObserver observer) {
        int result = -1;
        checkServiceBinder();
        {
            RestoreSession session = null;
            try 
            {
                IRestoreSession binder = sService.beginRestoreSession(mContext.getPackageName(),
                        null);
                session = new RestoreSession(mContext, binder);
                result = session.restorePackage(mContext.getPackageName(), observer);
            } 
            catch (RemoteException e)
            { }
            finally 
            {
                {
                    session.endRestoreSession();
                } 
            } 
        } 
        addTaint(observer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791170860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791170860;
        
        
        
        
            
            
                
                        
                
                
            
                
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.524 -0400", hash_original_method = "4E9AC35DE965C4DA64E27C8C094DFEC3", hash_generated_method = "93EC8D190B0D8A026117809503995DB0")
    public RestoreSession beginRestoreSession() {
        RestoreSession varB4EAC82CA7396A68D541C85D26508E83_2109488870 = null; 
        RestoreSession session = null;
        checkServiceBinder();
        {
            try 
            {
                IRestoreSession binder = sService.beginRestoreSession(null, null);
                session = new RestoreSession(mContext, binder);
            } 
            catch (RemoteException e)
            { }
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2109488870 = session;
        varB4EAC82CA7396A68D541C85D26508E83_2109488870.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2109488870;
        
        
        
        
            
                
                
            
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.524 -0400", hash_original_field = "A4EEA6554760A3C457438AA5B4D89B19", hash_generated_field = "46BC9109135FC2CB00B0B600F09C9710")

    private static final String TAG = "BackupManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.524 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "A0386DA53DF2919548B4DED4A07BF9FC")

    private static IBackupManager sService;
}

