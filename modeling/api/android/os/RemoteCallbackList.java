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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;

public class RemoteCallbackList<E extends IInterface> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.311 -0500", hash_original_field = "A3014188D001ACE7213D971AD3B4EFAD", hash_generated_field = "A3014188D001ACE7213D971AD3B4EFAD")
 HashMap<IBinder, Callback> mCallbacks
            = new HashMap<IBinder, Callback>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.313 -0500", hash_original_field = "29E32C0259DD425589A0C9B8D055C676", hash_generated_field = "B75B95317849640E22DFE7A92A9E9DF6")

    private Object[] mActiveBroadcast;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.317 -0500", hash_original_field = "380B3FC98996D421223AC5094D5B2552", hash_generated_field = "CB5FB74014BCEB13346A3C70AF8D1481")

    private int mBroadcastCount = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.319 -0500", hash_original_field = "344D596E5F0D6CDFF41A591F61670A78", hash_generated_field = "9A32E5255010279867B3E477F7AB34C4")

    private boolean mKilled = false;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.498 -0400", hash_original_method = "7510693ACC17AC22B2C7AA646F89D542", hash_generated_method = "7510693ACC17AC22B2C7AA646F89D542")
    public RemoteCallbackList ()
    {
        //Synthesized constructor
    }

    /**
     * Simple version of {@link RemoteCallbackList#register(E, Object)}
     * that does not take a cookie object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.332 -0500", hash_original_method = "46F1FD6FBAE5A826BE086BA154A601C8", hash_generated_method = "9226C971F9CA03B5EB718A21EE05AADA")
    
public boolean register(E callback) {
        return register(callback, null);
    }
    
    /**
     * Add a new callback to the list.  This callback will remain in the list
     * until a corresponding call to {@link #unregister} or its hosting process
     * goes away.  If the callback was already registered (determined by
     * checking to see if the {@link IInterface#asBinder callback.asBinder()}
     * object is already in the list), then it will be left as-is.
     * Registrations are not counted; a single call to {@link #unregister}
     * will remove a callback after any number calls to register it.
     *
     * @param callback The callback interface to be added to the list.  Must
     * not be null -- passing null here will cause a NullPointerException.
     * Most services will want to check for null before calling this with
     * an object given from a client, so that clients can't crash the
     * service with bad data.
     *
     * @param cookie Optional additional data to be associated with this
     * callback.
     * 
     * @return Returns true if the callback was successfully added to the list.
     * Returns false if it was not added, either because {@link #kill} had
     * previously been called or the callback's process has gone away.
     *
     * @see #unregister
     * @see #kill
     * @see #onCallbackDied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.335 -0500", hash_original_method = "228836B43DD98CF5855A1427021AF94C", hash_generated_method = "17E6C693B5A4FF59FE09A0C3148A1939")
    
public boolean register(E callback, Object cookie) {
        synchronized (mCallbacks) {
            if (mKilled) {
                return false;
            }
            IBinder binder = callback.asBinder();
            try {
                Callback cb = new Callback(callback, cookie);
                binder.linkToDeath(cb, 0);
                mCallbacks.put(binder, cb);
                return true;
            } catch (RemoteException e) {
                return false;
            }
        }
    }

    /**
     * Remove from the list a callback that was previously added with
     * {@link #register}.  This uses the
     * {@link IInterface#asBinder callback.asBinder()} object to correctly
     * find the previous registration.
     * Registrations are not counted; a single unregister call will remove
     * a callback after any number calls to {@link #register} for it.
     *
     * @param callback The callback to be removed from the list.  Passing
     * null here will cause a NullPointerException, so you will generally want
     * to check for null before calling.
     *
     * @return Returns true if the callback was found and unregistered.  Returns
     * false if the given callback was not found on the list.
     *
     * @see #register
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.337 -0500", hash_original_method = "E94D872448628F2BAA0FD192A750EA6D", hash_generated_method = "0327530A3110BD11C7A6CB6CD2CDC1B4")
    
public boolean unregister(E callback) {
        synchronized (mCallbacks) {
            Callback cb = mCallbacks.remove(callback.asBinder());
            if (cb != null) {
                cb.mCallback.asBinder().unlinkToDeath(cb, 0);
                return true;
            }
            return false;
        }
    }

    /**
     * Disable this callback list.  All registered callbacks are unregistered,
     * and the list is disabled so that future calls to {@link #register} will
     * fail.  This should be used when a Service is stopping, to prevent clients
     * from registering callbacks after it is stopped.
     *
     * @see #register
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.339 -0500", hash_original_method = "143F9A34B740B6676238190B04E5358A", hash_generated_method = "07483B072732FDDAC6FA92D7B47E0CDF")
    
public void kill() {
        synchronized (mCallbacks) {
            for (Callback cb : mCallbacks.values()) {
                cb.mCallback.asBinder().unlinkToDeath(cb, 0);
            }
            mCallbacks.clear();
            mKilled = true;
        }
    }

    /**
     * Old version of {@link #onCallbackDied(E, Object)} that
     * does not provide a cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.341 -0500", hash_original_method = "B434989CEB936B9194BF8BFB60F8F696", hash_generated_method = "4BF54ACB8774850DB1D58D7E4879FA70")
    
public void onCallbackDied(E callback) {
    }
    
    /**
     * Called when the process hosting a callback in the list has gone away.
     * The default implementation calls {@link #onCallbackDied(E)}
     * for backwards compatibility.
     * 
     * @param callback The callback whose process has died.  Note that, since
     * its process has died, you can not make any calls on to this interface.
     * You can, however, retrieve its IBinder and compare it with another
     * IBinder to see if it is the same object.
     * @param cookie The cookie object original provided to
     * {@link #register(E, Object)}.
     * 
     * @see #register
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.343 -0500", hash_original_method = "0963A4798BF8140F1109AA736DE1F9A0", hash_generated_method = "A747490DF63CD54980667B186064A343")
    
public void onCallbackDied(E callback, Object cookie) {
        onCallbackDied(callback);
    }

    /**
     * Prepare to start making calls to the currently registered callbacks.
     * This creates a copy of the callback list, which you can retrieve items
     * from using {@link #getBroadcastItem}.  Note that only one broadcast can
     * be active at a time, so you must be sure to always call this from the
     * same thread (usually by scheduling with {@link Handler}) or
     * do your own synchronization.  You must call {@link #finishBroadcast}
     * when done.
     *
     * <p>A typical loop delivering a broadcast looks like this:
     *
     * <pre>
     * int i = callbacks.beginBroadcast();
     * while (i &gt; 0) {
     *     i--;
     *     try {
     *         callbacks.getBroadcastItem(i).somethingHappened();
     *     } catch (RemoteException e) {
     *         // The RemoteCallbackList will take care of removing
     *         // the dead object for us.
     *     }
     * }
     * callbacks.finishBroadcast();</pre>
     *
     * @return Returns the number of callbacks in the broadcast, to be used
     * with {@link #getBroadcastItem} to determine the range of indices you
     * can supply.
     *
     * @see #getBroadcastItem
     * @see #finishBroadcast
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.346 -0500", hash_original_method = "1FD0E6F07E109275C9353B8621589475", hash_generated_method = "B29A2068DAA53EA10AD23A77E668F10C")
    
public int beginBroadcast() {
        synchronized (mCallbacks) {
            if (mBroadcastCount > 0) {
                throw new IllegalStateException(
                        "beginBroadcast() called while already in a broadcast");
            }
            
            final int N = mBroadcastCount = mCallbacks.size();
            if (N <= 0) {
                return 0;
            }
            Object[] active = mActiveBroadcast;
            if (active == null || active.length < N) {
                mActiveBroadcast = active = new Object[N];
            }
            int i=0;
            for (Callback cb : mCallbacks.values()) {
                active[i++] = cb;
            }
            return i;
        }
    }

    /**
     * Retrieve an item in the active broadcast that was previously started
     * with {@link #beginBroadcast}.  This can <em>only</em> be called after
     * the broadcast is started, and its data is no longer valid after
     * calling {@link #finishBroadcast}.
     *
     * <p>Note that it is possible for the process of one of the returned
     * callbacks to go away before you call it, so you will need to catch
     * {@link RemoteException} when calling on to the returned object.
     * The callback list itself, however, will take care of unregistering
     * these objects once it detects that it is no longer valid, so you can
     * handle such an exception by simply ignoring it.
     *
     * @param index Which of the registered callbacks you would like to
     * retrieve.  Ranges from 0 to 1-{@link #beginBroadcast}.
     *
     * @return Returns the callback interface that you can call.  This will
     * always be non-null.
     *
     * @see #beginBroadcast
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.348 -0500", hash_original_method = "C48AB0BBF7A76319F21B51268A720A67", hash_generated_method = "4FC1E5B77D827E51A022888487CE19C4")
    
public E getBroadcastItem(int index) {
        return ((Callback)mActiveBroadcast[index]).mCallback;
    }
    
    /**
     * Retrieve the cookie associated with the item
     * returned by {@link #getBroadcastItem(int)}.
     * 
     * @see #getBroadcastItem
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.350 -0500", hash_original_method = "25A2DBE745AB094B33E63C6F1B03FB52", hash_generated_method = "A8AC5A173DE5A6BAB66262097C68072D")
    
public Object getBroadcastCookie(int index) {
        return ((Callback)mActiveBroadcast[index]).mCookie;
    }

    /**
     * Clean up the state of a broadcast previously initiated by calling
     * {@link #beginBroadcast}.  This must always be called when you are done
     * with a broadcast.
     *
     * @see #beginBroadcast
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.352 -0500", hash_original_method = "2675E2000594C860776B6FA43AA81FEA", hash_generated_method = "1CB566FA9DD36805AAE6D7444664087E")
    
public void finishBroadcast() {
        if (mBroadcastCount < 0) {
            throw new IllegalStateException(
                    "finishBroadcast() called outside of a broadcast");
        }
        
        Object[] active = mActiveBroadcast;
        if (active != null) {
            final int N = mBroadcastCount;
            for (int i=0; i<N; i++) {
                active[i] = null;
            }
        }
        
        mBroadcastCount = -1;
    }
    
    private final class Callback implements IBinder.DeathRecipient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.322 -0500", hash_original_field = "C5FF175C3C7088F24551555CDBB26192", hash_generated_field = "C5FF175C3C7088F24551555CDBB26192")

         E mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.324 -0500", hash_original_field = "3AD67F45247C091A10339EB1DB868D56", hash_generated_field = "3AD67F45247C091A10339EB1DB868D56")

         Object mCookie;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.326 -0500", hash_original_method = "C2984F09CEF5592866E406A38791BD39", hash_generated_method = "C2984F09CEF5592866E406A38791BD39")
        
Callback(E callback, Object cookie) {
            mCallback = callback;
            mCookie = cookie;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.329 -0500", hash_original_method = "984D7C16BA519E420EB37CE7E59C8134", hash_generated_method = "C2B995AE0E880DCC2FE38C4DFAEC460E")
        
public void binderDied() {
            synchronized (mCallbacks) {
                mCallbacks.remove(mCallback.asBinder());
            }
            onCallbackDied(mCallback, mCookie);
        }
        
    }
    
}

