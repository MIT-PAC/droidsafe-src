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
 * Copyright (C) 2007 The Android Open Source Project
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


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

abstract class WebSyncManager implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.814 -0500", hash_original_field = "4BAA0CB66D08A8BBAE9C2CC4CE58A502", hash_generated_field = "E4D765345E06BE3C2527370BFAB10263")

    private static final int SYNC_MESSAGE = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.816 -0500", hash_original_field = "E1950E0A7B5269E5461AE785AFCB3441", hash_generated_field = "82F905345288726295999FD00CFCF6AF")

    private static int SYNC_NOW_INTERVAL = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.819 -0500", hash_original_field = "DDB9F5EB3FEEC7A25E6E3C20852E04B2", hash_generated_field = "8CE70708BB53E48ED40E4D2FD22F9CAE")

    // time delay in millisec for a sync (later) message
    private static int SYNC_LATER_INTERVAL = 5 * 60 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.832 -0500", hash_original_field = "AA75F0ADF340A699619357F9DDF47A0E", hash_generated_field = "2F0A3E5EAD0D0334CC20865767D1BA08")

    protected static final String LOGTAG = "websync";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.821 -0500", hash_original_field = "BFBEE1F8E4D6C47F4FDC1E5F9E488641", hash_generated_field = "7E960C78AE6E42650DCF6A6B709F288E")

    // thread for syncing
    private Thread mSyncThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.823 -0500", hash_original_field = "A50DCA7E6EC7EDBD369EF0D0D6F4EF73", hash_generated_field = "255E38D50E331062F1EEB5D547E791DF")

    private String mThreadName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.825 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "32E2735BA7568F02BAA8C871F1451CB8")

    protected Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.827 -0500", hash_original_field = "D432C32D33F8FDFC876BCEEC94F4E8D4", hash_generated_field = "FB041B1B4E7FD92B29065E290A0CA855")

    protected WebViewDatabase mDataBase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.829 -0500", hash_original_field = "0CA5153620097A631AD038E6E00E0384", hash_generated_field = "A9EC540100CABD12488EDBCF86572E46")

    private int mStartSyncRefCount;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.840 -0500", hash_original_method = "09DE2C11BB900513668F7B71351233D1", hash_generated_method = "C38C92E605A70613E0DAC369B2248F7D")
    
protected WebSyncManager(Context context, String name) {
        mThreadName = name;
        if (context != null) {
            mDataBase = WebViewDatabase.getInstance(context);
            mSyncThread = new Thread(this);
            mSyncThread.setName(mThreadName);
            mSyncThread.start();
        } else {
            throw new IllegalStateException(
                    "WebSyncManager can't be created without context");
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.842 -0500", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "6D3F334E8E934FE8B33726A6E75490EE")
    
protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.844 -0500", hash_original_method = "8834F89660AF74637C8D229EF4878BE6", hash_generated_method = "6636B2B637FD691BF33A67337AC8463A")
    
public void run() {
        // prepare Looper for sync handler
        Looper.prepare();
        mHandler = new SyncHandler();
        onSyncInit();
        // lower the priority after onSyncInit() is done
       Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

        Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);

        Looper.loop();
    }

    /**
     * sync() forces sync manager to sync now
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.847 -0500", hash_original_method = "51D4EC34A270685406E251162F5D8313", hash_generated_method = "46C547863995511DC41C690F766A7A6A")
    
public void sync() {
        if (DebugFlags.WEB_SYNC_MANAGER) {
            Log.v(LOGTAG, "*** WebSyncManager sync ***");
        }
        if (mHandler == null) {
            return;
        }
        mHandler.removeMessages(SYNC_MESSAGE);
        Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_NOW_INTERVAL);
    }

    /**
     * resetSync() resets sync manager's timer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.849 -0500", hash_original_method = "84BE51CDF1BC4F6FA0DB81680F35DEC3", hash_generated_method = "7E0E6AAF27DF7FCDB27FE151109ED876")
    
public void resetSync() {
        if (DebugFlags.WEB_SYNC_MANAGER) {
            Log.v(LOGTAG, "*** WebSyncManager resetSync ***");
        }
        if (mHandler == null) {
            return;
        }
        mHandler.removeMessages(SYNC_MESSAGE);
        Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
    }
    
    private class SyncHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.838 -0400", hash_original_method = "A501FFC6AE70F7E6319A21E151433B3A", hash_generated_method = "A501FFC6AE70F7E6319A21E151433B3A")
        public SyncHandler ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.836 -0500", hash_original_method = "DDFB485EC354F258C2B8352C9BF41A44", hash_generated_method = "259A297F39D483EB2856D1F18114AB3C")
        
@Override
        public void handleMessage(Message msg) {
            if (msg.what == SYNC_MESSAGE) {
                if (DebugFlags.WEB_SYNC_MANAGER) {
                    Log.v(LOGTAG, "*** WebSyncManager sync ***");
                }
                syncFromRamToFlash();

                // send a delayed message to request sync later
                Message newmsg = obtainMessage(SYNC_MESSAGE);
                sendMessageDelayed(newmsg, SYNC_LATER_INTERVAL);
            }
        }
        
    }

    /**
     * startSync() requests sync manager to start sync
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.851 -0500", hash_original_method = "2AEDBC8F7C27D5B102C45AFA67E1CB2E", hash_generated_method = "C8C8EE9E9846BF69698624665EFB69BB")
    
public void startSync() {
        if (DebugFlags.WEB_SYNC_MANAGER) {
            Log.v(LOGTAG, "***  WebSyncManager startSync ***, Ref count:" + 
                    mStartSyncRefCount);
        }
        if (mHandler == null) {
            return;
        }
        if (++mStartSyncRefCount == 1) {
            Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
            mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        }
    }

    /**
     * stopSync() requests sync manager to stop sync. remove any SYNC_MESSAGE in
     * the queue to break the sync loop
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.853 -0500", hash_original_method = "884F3EA0F4676AB73E893C1BBE34114E", hash_generated_method = "62DA5E45D3107830084059C1FF693D19")
    
public void stopSync() {
        if (DebugFlags.WEB_SYNC_MANAGER) {
            Log.v(LOGTAG, "*** WebSyncManager stopSync ***, Ref count:" + 
                    mStartSyncRefCount);
        }
        if (mHandler == null) {
            return;
        }
        if (--mStartSyncRefCount == 0) {
            mHandler.removeMessages(SYNC_MESSAGE);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.856 -0500", hash_original_method = "E2DCC4A23007ACC5EB483532AA9CED02", hash_generated_method = "3B65D8A96B238AC14E3363EEFE1D2533")
    
protected void onSyncInit() {
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.858 -0500", hash_original_method = "E5516067DC542691365D2969872CE83A", hash_generated_method = "36843EA5B418122959FB60BB87E78367")
    
abstract void syncFromRamToFlash();
}

