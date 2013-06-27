package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.167 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.167 -0400", hash_original_field = "59251AD7EF4786A1A863CD24E536AB17", hash_generated_field = "7A6145C040AB8C4767279CC3AE6AB5D4")

    IRestoreSession mBinder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.167 -0400", hash_original_field = "7D1185DB2A19E0D7F95FB13A361826A9", hash_generated_field = "968F7FFCD0ED9347FEBCC336042661C5")

    RestoreObserverWrapper mObserver = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.169 -0400", hash_original_method = "603F247D543111CC62EE9EB2C3201E30", hash_generated_method = "F3BECFC9424092C247E9FC4DE58DECD3")
      RestoreSession(Context context, IRestoreSession binder) {
        mContext = context;
        mBinder = binder;
        // ---------- Original Method ----------
        //mContext = context;
        //mBinder = binder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.190 -0400", hash_original_method = "85E5CD06982622FBF40B882974335BE2", hash_generated_method = "F9460B987878FD7BB40BB8E377F5E89F")
    public int getAvailableRestoreSets(RestoreObserver observer) {
        int err;
        err = -1;
        RestoreObserverWrapper obsWrapper;
        obsWrapper = new RestoreObserverWrapper(mContext, observer);
        try 
        {
            err = mBinder.getAvailableRestoreSets(obsWrapper);
        } //End block
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to get available sets");
        } //End block
        addTaint(observer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046783356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046783356;
        // ---------- Original Method ----------
        //int err = -1;
        //RestoreObserverWrapper obsWrapper = new RestoreObserverWrapper(mContext, observer);
        //try {
            //err = mBinder.getAvailableRestoreSets(obsWrapper);
        //} catch (RemoteException e) {
            //Log.d(TAG, "Can't contact server to get available sets");
        //}
        //return err;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.191 -0400", hash_original_method = "C8DAB2ADB788499C67FF0E8E9408ECE5", hash_generated_method = "68AB39E777B0541745D32ADAFFC95E72")
    public int restoreAll(long token, RestoreObserver observer) {
        int err;
        err = -1;
        {
            Log.d(TAG, "restoreAll() called during active restore");
        } //End block
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try 
        {
            err = mBinder.restoreAll(token, mObserver);
        } //End block
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to restore");
        } //End block
        addTaint(token);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113692303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113692303;
        // ---------- Original Method ----------
        //int err = -1;
        //if (mObserver != null) {
            //Log.d(TAG, "restoreAll() called during active restore");
            //return -1;
        //}
        //mObserver = new RestoreObserverWrapper(mContext, observer);
        //try {
            //err = mBinder.restoreAll(token, mObserver);
        //} catch (RemoteException e) {
            //Log.d(TAG, "Can't contact server to restore");
        //}
        //return err;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.193 -0400", hash_original_method = "F5EFDD74303F049C8AACBA4BE897E134", hash_generated_method = "D989088739D8EFC69F5A76F98BE527A0")
    public int restoreSome(long token, RestoreObserver observer, String[] packages) {
        int err;
        err = -1;
        {
            Log.d(TAG, "restoreAll() called during active restore");
        } //End block
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try 
        {
            err = mBinder.restoreSome(token, mObserver, packages);
        } //End block
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to restore packages");
        } //End block
        addTaint(token);
        addTaint(packages[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424538952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424538952;
        // ---------- Original Method ----------
        //int err = -1;
        //if (mObserver != null) {
            //Log.d(TAG, "restoreAll() called during active restore");
            //return -1;
        //}
        //mObserver = new RestoreObserverWrapper(mContext, observer);
        //try {
            //err = mBinder.restoreSome(token, mObserver, packages);
        //} catch (RemoteException e) {
            //Log.d(TAG, "Can't contact server to restore packages");
        //}
        //return err;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.198 -0400", hash_original_method = "45656BEA7940AC3102C43782877B83F7", hash_generated_method = "79A863435A94BD59E6F102DD48923540")
    public int restorePackage(String packageName, RestoreObserver observer) {
        int err;
        err = -1;
        {
            Log.d(TAG, "restorePackage() called during active restore");
        } //End block
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try 
        {
            err = mBinder.restorePackage(packageName, mObserver);
        } //End block
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to restore package");
        } //End block
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669695177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669695177;
        // ---------- Original Method ----------
        //int err = -1;
        //if (mObserver != null) {
            //Log.d(TAG, "restorePackage() called during active restore");
            //return -1;
        //}
        //mObserver = new RestoreObserverWrapper(mContext, observer);
        //try {
            //err = mBinder.restorePackage(packageName, mObserver);
        //} catch (RemoteException e) {
            //Log.d(TAG, "Can't contact server to restore package");
        //}
        //return err;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.199 -0400", hash_original_method = "97A09429CDECAD0EA89948A618DDD793", hash_generated_method = "612247F4837A4CAF2A74D43F84ECBE92")
    public void endRestoreSession() {
        try 
        {
            mBinder.endRestoreSession();
        } //End block
        catch (RemoteException e)
        {
            Log.d(TAG, "Can't contact server to get available sets");
        } //End block
        finally 
        {
            mBinder = null;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mBinder.endRestoreSession();
        //} catch (RemoteException e) {
            //Log.d(TAG, "Can't contact server to get available sets");
        //} finally {
            //mBinder = null;
        //}
    }

    
    private class RestoreObserverWrapper extends IRestoreObserver.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.214 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.214 -0400", hash_original_field = "85CF6A4156B908A7AB70D634083F9E84", hash_generated_field = "005F4DF6C8F6B731652C05EB1AE4CFEE")

        RestoreObserver mAppObserver;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.220 -0400", hash_original_method = "A8439BCE69D3AC67FEB783862C52DBDA", hash_generated_method = "E5A0E152FD47F73AB39AAE903F404777")
          RestoreObserverWrapper(Context context, RestoreObserver appObserver) {
            mHandler = new Handler(context.getMainLooper()) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.219 -0400", hash_original_method = "84BAABEE28F8F0BF3FE3DAD5813E1DC7", hash_generated_method = "DCE9EE46CEA488FF69889BC84D9BFD0F")
                @Override
                public void handleMessage(Message msg) {
                    //Begin case MSG_RESTORE_STARTING 
                    mAppObserver.restoreStarting(msg.arg1);
                    //End case MSG_RESTORE_STARTING 
                    //Begin case MSG_UPDATE 
                    mAppObserver.onUpdate(msg.arg1, (String)msg.obj);
                    //End case MSG_UPDATE 
                    //Begin case MSG_RESTORE_FINISHED 
                    mAppObserver.restoreFinished(msg.arg1);
                    //End case MSG_RESTORE_FINISHED 
                    //Begin case MSG_RESTORE_SETS_AVAILABLE 
                    mAppObserver.restoreSetsAvailable((RestoreSet[])msg.obj);
                    //End case MSG_RESTORE_SETS_AVAILABLE 
                    addTaint(msg.getTaint());
                    // ---------- Original Method ----------
                    //switch (msg.what) {
                    //case MSG_RESTORE_STARTING:
                        //mAppObserver.restoreStarting(msg.arg1);
                        //break;
                    //case MSG_UPDATE:
                        //mAppObserver.onUpdate(msg.arg1, (String)msg.obj);
                        //break;
                    //case MSG_RESTORE_FINISHED:
                        //mAppObserver.restoreFinished(msg.arg1);
                        //break;
                    //case MSG_RESTORE_SETS_AVAILABLE:
                        //mAppObserver.restoreSetsAvailable((RestoreSet[])msg.obj);
                        //break;
                    //}
                }
};
            mAppObserver = appObserver;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.221 -0400", hash_original_method = "856BC446A8E3590AAA97D30784AFC7AF", hash_generated_method = "0F4B48B16503E021BF125AFDA4C930A6")
        public void restoreSetsAvailable(RestoreSet[] result) {
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_SETS_AVAILABLE, result));
            addTaint(result[0].getTaint());
            // ---------- Original Method ----------
            //mHandler.sendMessage(
                    //mHandler.obtainMessage(MSG_RESTORE_SETS_AVAILABLE, result));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.240 -0400", hash_original_method = "09B9DD73C3E4A1439A279C7C4D1CFC03", hash_generated_method = "43168A6BD30BBBCA70222C2DD2FCEC24")
        public void restoreStarting(int numPackages) {
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_STARTING, numPackages, 0));
            addTaint(numPackages);
            // ---------- Original Method ----------
            //mHandler.sendMessage(
                    //mHandler.obtainMessage(MSG_RESTORE_STARTING, numPackages, 0));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.241 -0400", hash_original_method = "4CFF49A8B007F8B448F2967D6A75009D", hash_generated_method = "D71A39D5EA6E0448F3E7603350D16E7C")
        public void onUpdate(int nowBeingRestored, String currentPackage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_UPDATE, nowBeingRestored, 0, currentPackage));
            addTaint(nowBeingRestored);
            addTaint(currentPackage.getTaint());
            // ---------- Original Method ----------
            //mHandler.sendMessage(
                    //mHandler.obtainMessage(MSG_UPDATE, nowBeingRestored, 0, currentPackage));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.254 -0400", hash_original_method = "9021095FD560CADBADD83E17671DA995", hash_generated_method = "A7F7596524BE4CE656B05C6F5D4A045C")
        public void restoreFinished(int error) {
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_FINISHED, error, 0));
            addTaint(error);
            // ---------- Original Method ----------
            //mHandler.sendMessage(
                    //mHandler.obtainMessage(MSG_RESTORE_FINISHED, error, 0));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.254 -0400", hash_original_field = "E422503876A122A2D1B32BFB63C3D499", hash_generated_field = "C35743E6236412F066B6205E54E8EA22")

        static int MSG_RESTORE_STARTING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.254 -0400", hash_original_field = "97DA6AB7E0DB84751C215FE1CE90A9F6", hash_generated_field = "26531C9D6D357E178BA18A02054D119A")

        static int MSG_UPDATE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.255 -0400", hash_original_field = "AF04D5E088FEF797B05F7A90370D83A7", hash_generated_field = "82F0FE6CB649DE7545DADA4BC6C2FFE9")

        static int MSG_RESTORE_FINISHED = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.256 -0400", hash_original_field = "6712CCE62254369D8B798E8F6D0F7F36", hash_generated_field = "5A0B39F513E3B588CEB49A68D560A7F8")

        static int MSG_RESTORE_SETS_AVAILABLE = 4;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.256 -0400", hash_original_field = "99E9F4CCB1D6B84BCFEB4B56833CD506", hash_generated_field = "17F55DAAF2B364CB88DD8B8E98B60561")

    static String TAG = "RestoreSession";
}

