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
 * Copyright (C) 2006 The Android Open Source Project
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
import java.util.ArrayList;

import android.util.Log;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class MessageQueue {
    
    Message mMessages;
    private final ArrayList<IdleHandler> mIdleHandlers = new ArrayList<IdleHandler>();
    private IdleHandler[] mPendingIdleHandlers;
    private boolean mQuiting;
    boolean mQuitAllowed = true;
    private boolean mBlocked;
    @SuppressWarnings("unused")
    private int mPtr;
    
    @DSModeled(DSC.SAFE)
    private void nativeInit(){
        //Formerly a native function
        
    }
    
    @DSModeled(DSC.SAFE)
    private void nativeDestroy(){
        //Formerly a native function
        
    }
    
    private void nativePollOnce(int ptr, int timeoutMillis){
        //Formerly a native function
        
    }
    
    private void nativeWake(int ptr){
        //Formerly a native function
        
    }
    
    public static interface IdleHandler {
        
        boolean queueIdle();
    }
    
    public final void addIdleHandler(IdleHandler handler){
        //throw new NullPointerException("Can't add a null IdleHandler");
        mIdleHandlers.add(handler);
        // Original method
        /*
        {
        if (handler == null) {
            throw new NullPointerException("Can't add a null IdleHandler");
        }
        synchronized (this) {
            mIdleHandlers.add(handler);
        }
    }
        */
    }
    
    public final void removeIdleHandler(IdleHandler handler){
        mIdleHandlers.remove(handler);
        // Original method
        /*
        {
        synchronized (this) {
            mIdleHandlers.remove(handler);
        }
    }
        */
    }
    
    @DSModeled(DSC.SAFE)
    MessageQueue(){
        nativeInit();
        /*
        nativeInit();
        */
    }
    
    @DSModeled(DSC.SAFE)
    @Override protected void finalize(){
        nativeDestroy();
        try {
			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
		}
        // Original method
        /*
        {
        try {
            nativeDestroy();
        } finally {
            super.finalize();
        }
    }
        */
    }
    
    final Message next(){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //int pendingIdleHandlerCount = -1;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        int nextPollTimeoutMillis = 0;
        Binder.flushPendingCommands();
        nativePollOnce(mPtr, nextPollTimeoutMillis);
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //final long now = SystemClock.uptimeMillis();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        final Message msg = mMessages;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //final long when = msg.when;
        Log.v("MessageQueue", "Returning message: " + msg);
        msg.markInUse();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        final IdleHandler idler = mPendingIdleHandlers[0];
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //boolean keep = false;
        mIdleHandlers.remove(idler);
        return msg;  //DSFIXME:  CODE0001: Unresolved return type/value combination

        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    final boolean enqueueMessage(Message msg, long when){
        //throw new AndroidRuntimeException(msg + " This message is already in use.");
        //throw new RuntimeException("Main thread not allowed to quit");
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //final boolean needWake;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //RuntimeException e = new RuntimeException( msg.target + " sending message to a Handler on a dead thread");
        //Log.w("MessageQueue", e.getMessage(), e);
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message p = mMessages;
        mMessages = msg;  //DSFIXME:  CODE0003: Field assignment should be reviewed
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message prev = null;
        nativeWake(mPtr);
        return getTaintBoolean();

        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    final boolean removeMessages(Handler h, int what, Object object,
            boolean doRemove){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message p = mMessages;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //boolean found = false;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message n = p.next;
        p.recycle();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message n = p.next;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message nn = n.next;
        n.recycle();
        return getTaintBoolean();

        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    final void removeMessages(Handler h, Runnable r, Object object){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message p = mMessages;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message n = p.next;
        p.recycle();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message n = p.next;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message nn = n.next;
        n.recycle();
        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    final void removeCallbacksAndMessages(Handler h, Object object){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message p = mMessages;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message n = p.next;
        p.recycle();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message n = p.next;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message nn = n.next;
        n.recycle();
        // Original method
        /*
        {
        synchronized (this) {
            Message p = mMessages;

            
            while (p != null && p.target == h
                    && (object == null || p.obj == object)) {
                Message n = p.next;
                mMessages = n;
                p.recycle();
                p = n;
            }

            
            while (p != null) {
                Message n = p.next;
                if (n != null) {
                    if (n.target == h && (object == null || n.obj == object)) {
                        Message nn = n.next;
                        n.recycle();
                        p.next = nn;
                        continue;
                    }
                }
                p = n;
            }
        }
    }
        */
    }
}

