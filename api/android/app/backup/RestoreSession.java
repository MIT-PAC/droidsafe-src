package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.backup.RestoreObserver;
import android.app.backup.RestoreSet;
import android.app.backup.IRestoreObserver;
import android.app.backup.IRestoreSession;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

public class RestoreSession {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.397 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.397 -0400", hash_original_field = "59251AD7EF4786A1A863CD24E536AB17", hash_generated_field = "7A6145C040AB8C4767279CC3AE6AB5D4")

    IRestoreSession mBinder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.397 -0400", hash_original_field = "7D1185DB2A19E0D7F95FB13A361826A9", hash_generated_field = "968F7FFCD0ED9347FEBCC336042661C5")

    RestoreObserverWrapper mObserver = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.398 -0400", hash_original_method = "603F247D543111CC62EE9EB2C3201E30", hash_generated_method = "F3BECFC9424092C247E9FC4DE58DECD3")
      RestoreSession(Context context, IRestoreSession binder) {
        mContext = context;
        mBinder = binder;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.398 -0400", hash_original_method = "85E5CD06982622FBF40B882974335BE2", hash_generated_method = "D11CAA68DB37DF26A19592635B00DBB1")
    public int getAvailableRestoreSets(RestoreObserver observer) {
        addTaint(observer.getTaint());
        int err = -1;
        RestoreObserverWrapper obsWrapper = new RestoreObserverWrapper(mContext, observer);
        try 
        {
            err = mBinder.getAvailableRestoreSets(obsWrapper);
        } 
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to get available sets");
        } 
        int var56BD7107802EBE56C6918992F0608EC6_535276464 = (err);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496622414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496622414;
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.400 -0400", hash_original_method = "C8DAB2ADB788499C67FF0E8E9408ECE5", hash_generated_method = "96F6036045EB28F600F26A6942EF65D4")
    public int restoreAll(long token, RestoreObserver observer) {
        addTaint(token);
        int err = -1;
    if(mObserver != null)        
        {
            Log.d(TAG, "restoreAll() called during active restore");
            int var6BB61E3B7BCE0931DA574D19D1D82C88_286166874 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_688138533 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_688138533;
        } 
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try 
        {
            err = mBinder.restoreAll(token, mObserver);
        } 
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to restore");
        } 
        int var56BD7107802EBE56C6918992F0608EC6_143123587 = (err);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_880501706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_880501706;
        
        
        
            
            
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.402 -0400", hash_original_method = "F5EFDD74303F049C8AACBA4BE897E134", hash_generated_method = "9F462BFFAC72960A2964DB237F5B2372")
    public int restoreSome(long token, RestoreObserver observer, String[] packages) {
        addTaint(packages[0].getTaint());
        addTaint(token);
        int err = -1;
    if(mObserver != null)        
        {
            Log.d(TAG, "restoreAll() called during active restore");
            int var6BB61E3B7BCE0931DA574D19D1D82C88_756281613 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457769816 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457769816;
        } 
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try 
        {
            err = mBinder.restoreSome(token, mObserver, packages);
        } 
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to restore packages");
        } 
        int var56BD7107802EBE56C6918992F0608EC6_675203357 = (err);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_772416433 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_772416433;
        
        
        
            
            
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.403 -0400", hash_original_method = "45656BEA7940AC3102C43782877B83F7", hash_generated_method = "DE48749F458C368784E607850C23E407")
    public int restorePackage(String packageName, RestoreObserver observer) {
        addTaint(packageName.getTaint());
        int err = -1;
    if(mObserver != null)        
        {
            Log.d(TAG, "restorePackage() called during active restore");
            int var6BB61E3B7BCE0931DA574D19D1D82C88_454933847 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730551357 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730551357;
        } 
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try 
        {
            err = mBinder.restorePackage(packageName, mObserver);
        } 
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to restore package");
        } 
        int var56BD7107802EBE56C6918992F0608EC6_648552164 = (err);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661395600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661395600;
        
        
        
            
            
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.404 -0400", hash_original_method = "97A09429CDECAD0EA89948A618DDD793", hash_generated_method = "612247F4837A4CAF2A74D43F84ECBE92")
    public void endRestoreSession() {
        try 
        {
            mBinder.endRestoreSession();
        } 
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to get available sets");
        } 
        finally 
        {
            mBinder = null;
        } 
        
        
            
        
            
        
            
        
    }

    
    private class RestoreObserverWrapper extends IRestoreObserver.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.404 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.404 -0400", hash_original_field = "85CF6A4156B908A7AB70D634083F9E84", hash_generated_field = "005F4DF6C8F6B731652C05EB1AE4CFEE")

        RestoreObserver mAppObserver;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.406 -0400", hash_original_method = "A8439BCE69D3AC67FEB783862C52DBDA", hash_generated_method = "C1DE457769D33B2DF94F4DE642AEFDD2")
          RestoreObserverWrapper(Context context, RestoreObserver appObserver) {
            mHandler = new Handler(context.getMainLooper()) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.405 -0400", hash_original_method = "84BAABEE28F8F0BF3FE3DAD5813E1DC7", hash_generated_method = "B90F8D19932ED8B4DCF2E0EC7FB5333E")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
switch(msg.what){
                case MSG_RESTORE_STARTING:
                mAppObserver.restoreStarting(msg.arg1);
                break;
                case MSG_UPDATE:
                mAppObserver.onUpdate(msg.arg1, (String)msg.obj);
                break;
                case MSG_RESTORE_FINISHED:
                mAppObserver.restoreFinished(msg.arg1);
                break;
                case MSG_RESTORE_SETS_AVAILABLE:
                mAppObserver.restoreSetsAvailable((RestoreSet[])msg.obj);
                break;
}
                
                
                    
                        
                        
                    
                        
                        
                    
                        
                        
                    
                        
                        
                    
            }
};
            mAppObserver = appObserver;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.406 -0400", hash_original_method = "856BC446A8E3590AAA97D30784AFC7AF", hash_generated_method = "A74DD86EEB964679872C2579E3BF5CCE")
        public void restoreSetsAvailable(RestoreSet[] result) {
            addTaint(result[0].getTaint());
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_SETS_AVAILABLE, result));
            
            
                    
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.406 -0400", hash_original_method = "09B9DD73C3E4A1439A279C7C4D1CFC03", hash_generated_method = "2F50BAFD1BE78E86C546D0C5DFA814CB")
        public void restoreStarting(int numPackages) {
            addTaint(numPackages);
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_STARTING, numPackages, 0));
            
            
                    
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.407 -0400", hash_original_method = "4CFF49A8B007F8B448F2967D6A75009D", hash_generated_method = "31766C357506570A5FADBB1195FA94D3")
        public void onUpdate(int nowBeingRestored, String currentPackage) {
            
            addTaint(currentPackage.getTaint());
            addTaint(nowBeingRestored);
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_UPDATE, nowBeingRestored, 0, currentPackage));
            
            
                    
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.407 -0400", hash_original_method = "9021095FD560CADBADD83E17671DA995", hash_generated_method = "CA417BC5B0D06FEA4D8A0973BA34390A")
        public void restoreFinished(int error) {
            addTaint(error);
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_FINISHED, error, 0));
            
            
                    
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.814 -0400", hash_original_field = "E422503876A122A2D1B32BFB63C3D499", hash_generated_field = "C35743E6236412F066B6205E54E8EA22")

        final static int MSG_RESTORE_STARTING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.815 -0400", hash_original_field = "97DA6AB7E0DB84751C215FE1CE90A9F6", hash_generated_field = "26531C9D6D357E178BA18A02054D119A")

        final static int MSG_UPDATE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.815 -0400", hash_original_field = "AF04D5E088FEF797B05F7A90370D83A7", hash_generated_field = "82F0FE6CB649DE7545DADA4BC6C2FFE9")

        static final int MSG_RESTORE_FINISHED = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.816 -0400", hash_original_field = "6712CCE62254369D8B798E8F6D0F7F36", hash_generated_field = "5A0B39F513E3B588CEB49A68D560A7F8")

        static final int MSG_RESTORE_SETS_AVAILABLE = 4;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.408 -0400", hash_original_field = "99E9F4CCB1D6B84BCFEB4B56833CD506", hash_generated_field = "95A135350987A8A35D57A3465B636A5F")

    static final String TAG = "RestoreSession";
}

