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
 * Copyright (C) 2013 The Android Open Source Project
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


package android.support.v4.content;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

/**
 * Helper for the common pattern of implementing a {@link BroadcastReceiver}
 * that receives a device wakeup event and then passes the work off
 * to a {@link android.app.Service}, while ensuring that the
 * device does not go back to sleep during the transition.
 *
 * <p>This class takes care of creating and managing a partial wake lock
 * for you; you must request the {@link android.Manifest.permission#WAKE_LOCK}
 * permission to use it.</p>
 *
 * <h3>Example</h3>
 *
 * <p>A {@link WakefulBroadcastReceiver} uses the method
 * {@link WakefulBroadcastReceiver#startWakefulService startWakefulService()}
 * to start the service that does the work. This method is comparable to
 * {@link android.content.Context#startService startService()}, except that
 * the {@link WakefulBroadcastReceiver} is holding a wake lock when the service
 * starts. The intent that is passed with
 * {@link WakefulBroadcastReceiver#startWakefulService startWakefulService()}
 * holds an extra identifying the wake lock.</p>
 *
 * {@sample development/samples/Support4Demos/src/com/example/android/supportv4/content/SimpleWakefulReceiver.java complete}
 *
 * <p>The service (in this example, an {@link android.app.IntentService}) does
 * some work. When it is finished, it releases the wake lock by calling
 * {@link WakefulBroadcastReceiver#completeWakefulIntent
 * completeWakefulIntent(intent)}. The intent it passes as a parameter
 * is the same intent that the {@link WakefulBroadcastReceiver} originally
 * passed in.</p>
 *
 * {@sample development/samples/Support4Demos/src/com/example/android/supportv4/content/SimpleWakefulService.java complete}
 */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:02.137 -0400", hash_original_field = "CA7A9256470069BF65FE40ACBDE5F902", hash_generated_field = "C75AE3B497AB7EF9E0A408165545EED5")

    private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:02.142 -0400", hash_original_field = "461ECF45DA142D02A050353EDEF8C4AF", hash_generated_field = "A071AA3FE7BB2665B361876E6BCC8427")

    private static final SparseArray<PowerManager.WakeLock> mActiveWakeLocks
            = new SparseArray<PowerManager.WakeLock>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:02.146 -0400", hash_original_field = "DDEBD2B6B6719B15608C92715A57FE2C", hash_generated_field = "EFF85A3A9EECB3EE43798F3C006C52C5")

    private static int mNextId = 1;

    /**
     * Do a {@link android.content.Context#startService(android.content.Intent)
     * Context.startService}, but holding a wake lock while the service starts.
     * This will modify the Intent to hold an extra identifying the wake lock;
     * when the service receives it in {@link android.app.Service#onStartCommand
     * Service.onStartCommand}, it should pass back the Intent it receives there to
     * {@link #completeWakefulIntent(android.content.Intent)} in order to release
     * the wake lock.
     *
     * @param context The Context in which it operate.
     * @param intent The Intent with which to start the service, as per
     * {@link android.content.Context#startService(android.content.Intent)
     * Context.startService}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:02.151 -0400", hash_original_method = "CA673032AF11F5C78424869802D51787", hash_generated_method = "8C119B0C7EE44A4AA7B0A20C3FAE39AD")
    
public static ComponentName startWakefulService(Context context, Intent intent) {
        synchronized (mActiveWakeLocks) {
            int id = mNextId;
            mNextId++;
            if (mNextId <= 0) {
                mNextId = 1;
            }

            intent.putExtra(EXTRA_WAKE_LOCK_ID, id);
            ComponentName comp = context.startService(intent);
            if (comp == null) {
                return null;
            }

            PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                    "wake:" + comp.flattenToShortString());
            wl.setReferenceCounted(false);
            wl.acquire(60*1000);
            mActiveWakeLocks.put(id, wl);
            return comp;
        }
    }

    /**
     * Finish the execution from a previous {@link #startWakefulService}.  Any wake lock
     * that was being held will now be released.
     *
     * @param intent The Intent as originally generated by {@link #startWakefulService}.
     * @return Returns true if the intent is associated with a wake lock that is
     * now released; returns false if there was no wake lock specified for it.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:02.158 -0400", hash_original_method = "81847DB42B8EE70124935F08B1EF516E", hash_generated_method = "94550867779F6A5C3F2A67FC7C9A3421")
    
public static boolean completeWakefulIntent(Intent intent) {
        final int id = intent.getIntExtra(EXTRA_WAKE_LOCK_ID, 0);
        if (id == 0) {
            return false;
        }
        synchronized (mActiveWakeLocks) {
            PowerManager.WakeLock wl = mActiveWakeLocks.get(id);
            if (wl != null) {
                wl.release();
                mActiveWakeLocks.remove(id);
                return true;
            }
            // We return true whether or not we actually found the wake lock
            // the return code is defined to indicate whether the Intent contained
            // an identifier for a wake lock that it was supposed to match.
            // We just log a warning here if there is no wake lock found, which could
            // happen for example if this function is called twice on the same
            // intent or the process is killed and restarted before processing the intent.
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + id);
            return true;
        }
    }
}
