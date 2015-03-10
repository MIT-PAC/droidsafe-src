/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

public class RestoreSession {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.470 -0500", hash_original_field = "572DB331C1E9E94335EF137CE4D9301B", hash_generated_field = "95A135350987A8A35D57A3465B636A5F")

    static final String TAG = "RestoreSession";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.472 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

     Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.475 -0500", hash_original_field = "7A6145C040AB8C4767279CC3AE6AB5D4", hash_generated_field = "7A6145C040AB8C4767279CC3AE6AB5D4")

    IRestoreSession mBinder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.477 -0500", hash_original_field = "968F7FFCD0ED9347FEBCC336042661C5", hash_generated_field = "968F7FFCD0ED9347FEBCC336042661C5")

    RestoreObserverWrapper mObserver = null;

    /*
     * Nonpublic implementation here
     */

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.493 -0500", hash_original_method = "603F247D543111CC62EE9EB2C3201E30", hash_generated_method = "603F247D543111CC62EE9EB2C3201E30")
    
RestoreSession(Context context, IRestoreSession binder) {
        mContext = context;
        mBinder = binder;
    }

    /**
     * Ask the current transport what the available restore sets are.
     *
     * @param observer a RestoreObserver object whose restoreSetsAvailable() method will
     *   be called on the application's main thread in order to supply the results of
     *   the restore set lookup by the backup transport.  This parameter must not be
     *   null.
     * @return Zero on success, nonzero on error.  The observer's restoreSetsAvailable()
     *   method will only be called if this method returned zero.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.479 -0500", hash_original_method = "85E5CD06982622FBF40B882974335BE2", hash_generated_method = "F88AB1159CB48AD9123BACF633596C0B")
    
public int getAvailableRestoreSets(RestoreObserver observer) {
        int err = -1;
        RestoreObserverWrapper obsWrapper = new RestoreObserverWrapper(mContext, observer);
        try {
            err = mBinder.getAvailableRestoreSets(obsWrapper);
        } catch (RemoteException e) {
            Log.d(TAG, "Can't contact server to get available sets");
        }
        return err;
    }

    /**
     * Restore the given set onto the device, replacing the current data of any app
     * contained in the restore set with the data previously backed up.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     *
     * @return Zero on success; nonzero on error.  The observer will only receive
     *   progress callbacks if this method returned zero.
     * @param token The token from {@link #getAvailableRestoreSets()} corresponding to
     *   the restore set that should be used.
     * @param observer If non-null, this binder points to an object that will receive
     *   progress callbacks during the restore operation.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.483 -0500", hash_original_method = "C8DAB2ADB788499C67FF0E8E9408ECE5", hash_generated_method = "643D65C3E0FADDCD503AC887A11DE305")
    
public int restoreAll(long token, RestoreObserver observer) {
        int err = -1;
        if (mObserver != null) {
            Log.d(TAG, "restoreAll() called during active restore");
            return -1;
        }
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try {
            err = mBinder.restoreAll(token, mObserver);
        } catch (RemoteException e) {
            Log.d(TAG, "Can't contact server to restore");
        }
        return err;
    }

    /**
     * Restore select packages from the given set onto the device, replacing the
     * current data of any app contained in the set with the data previously
     * backed up.
     *
     * <p>Callers must hold the android.permission.BACKUP permission to use this method.
     *
     * @return Zero on success, nonzero on error. The observer will only receive
     *   progress callbacks if this method returned zero.
     * @param token The token from {@link getAvailableRestoreSets()} corresponding to
     *   the restore set that should be used.
     * @param observer If non-null, this binder points to an object that will receive
     *   progress callbacks during the restore operation.
     * @param packages The set of packages for which to attempt a restore.  Regardless of
     *   the contents of the actual back-end dataset named by {@code token}, only
     *   applications mentioned in this list will have their data restored.
     *
     * @hide
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.486 -0500", hash_original_method = "F5EFDD74303F049C8AACBA4BE897E134", hash_generated_method = "11A6EA209A7DC274BF9B69BE19754CAD")
    
public int restoreSome(long token, RestoreObserver observer, String[] packages) {
        int err = -1;
        if (mObserver != null) {
            Log.d(TAG, "restoreAll() called during active restore");
            return -1;
        }
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try {
            err = mBinder.restoreSome(token, mObserver, packages);
        } catch (RemoteException e) {
            Log.d(TAG, "Can't contact server to restore packages");
        }
        return err;
    }

    /**
     * Restore a single application from backup.  The data will be restored from the
     * current backup dataset if the given package has stored data there, or from
     * the dataset used during the last full device setup operation if the current
     * backup dataset has no matching data.  If no backup data exists for this package
     * in either source, a nonzero value will be returned.
     *
     * @return Zero on success; nonzero on error.  The observer will only receive
     *   progress callbacks if this method returned zero.
     * @param packageName The name of the package whose data to restore.  If this is
     *   not the name of the caller's own package, then the android.permission.BACKUP
     *   permission must be held.
     * @param observer If non-null, this binder points to an object that will receive
     *   progress callbacks during the restore operation.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.488 -0500", hash_original_method = "45656BEA7940AC3102C43782877B83F7", hash_generated_method = "14B8BD2AD5AE0301F8239686BB8B06C7")
    
public int restorePackage(String packageName, RestoreObserver observer) {
        int err = -1;
        if (mObserver != null) {
            Log.d(TAG, "restorePackage() called during active restore");
            return -1;
        }
        mObserver = new RestoreObserverWrapper(mContext, observer);
        try {
            err = mBinder.restorePackage(packageName, mObserver);
        } catch (RemoteException e) {
            Log.d(TAG, "Can't contact server to restore package");
        }
        return err;
    }
    
    private class RestoreObserverWrapper extends IRestoreObserver.Stub {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.814 -0400", hash_original_field = "E422503876A122A2D1B32BFB63C3D499", hash_generated_field = "C35743E6236412F066B6205E54E8EA22")

        final static int MSG_RESTORE_STARTING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.815 -0400", hash_original_field = "97DA6AB7E0DB84751C215FE1CE90A9F6", hash_generated_field = "26531C9D6D357E178BA18A02054D119A")

        final static int MSG_UPDATE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.815 -0400", hash_original_field = "AF04D5E088FEF797B05F7A90370D83A7", hash_generated_field = "82F0FE6CB649DE7545DADA4BC6C2FFE9")

        static final int MSG_RESTORE_FINISHED = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.816 -0400", hash_original_field = "6712CCE62254369D8B798E8F6D0F7F36", hash_generated_field = "5A0B39F513E3B588CEB49A68D560A7F8")

        static final int MSG_RESTORE_SETS_AVAILABLE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.497 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

         Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.500 -0500", hash_original_field = "005F4DF6C8F6B731652C05EB1AE4CFEE", hash_generated_field = "005F4DF6C8F6B731652C05EB1AE4CFEE")

         RestoreObserver mAppObserver;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.519 -0500", hash_original_method = "A8439BCE69D3AC67FEB783862C52DBDA", hash_generated_method = "A8439BCE69D3AC67FEB783862C52DBDA")
        
RestoreObserverWrapper(Context context, RestoreObserver appObserver) {
            mHandler = new Handler(context.getMainLooper()) {
                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
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

        // Binder calls into this object just enqueue on the main-thread handler
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.521 -0500", hash_original_method = "856BC446A8E3590AAA97D30784AFC7AF", hash_generated_method = "4B63F674D5A1AABC1043935E5ED2D796")
        
public void restoreSetsAvailable(RestoreSet[] result) {
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_SETS_AVAILABLE, result));
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.524 -0500", hash_original_method = "09B9DD73C3E4A1439A279C7C4D1CFC03", hash_generated_method = "02EBF0481B3FA6FA91C2DAACE271B53E")
        
public void restoreStarting(int numPackages) {
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_STARTING, numPackages, 0));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.527 -0500", hash_original_method = "4CFF49A8B007F8B448F2967D6A75009D", hash_generated_method = "90769D759157D223623BC8A20D0D9F57")
        
public void onUpdate(int nowBeingRestored, String currentPackage) {
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_UPDATE, nowBeingRestored, 0, currentPackage));
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.529 -0500", hash_original_method = "9021095FD560CADBADD83E17671DA995", hash_generated_method = "3E5ABAB0B146B5775FA89C324FCFBDA6")
        
public void restoreFinished(int error) {
            mHandler.sendMessage(
                    mHandler.obtainMessage(MSG_RESTORE_FINISHED, error, 0));
        }
    }

    /**
     * End this restore session.  After this method is called, the RestoreSession
     * object is no longer valid.
     *
     * <p><b>Note:</b> The caller <i>must</i> invoke this method to end the restore session,
     *   even if {@link #restorePackage(String, RestoreObserver)} failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:47.491 -0500", hash_original_method = "97A09429CDECAD0EA89948A618DDD793", hash_generated_method = "BD3295FCEBD243797146C5A37BF0B514")
    
public void endRestoreSession() {
        try {
            mBinder.endRestoreSession();
        } catch (RemoteException e) {
            Log.d(TAG, "Can't contact server to get available sets");
        } finally {
            mBinder = null;
        }
    }
}

