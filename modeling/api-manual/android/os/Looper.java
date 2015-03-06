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
import android.util.Printer;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Looper {
    
    private static final String TAG = "Looper";
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    final MessageQueue mQueue;
    final Thread mThread;
    volatile boolean mRun;
    private Printer mLogging = null;
    private static Looper mMainLooper = null;
    
    // DSModeled adding LocalLooper member to short circuit
    private static Looper mLocalLooper = new Looper();
    
    public static void prepare() {
    	/*
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        static }
        sThreadLocal.set(new Looper());
        */
    }
    
    public static void prepareMainLooper() {
        prepare();
        setMainLooper(myLooper());
       // myLooper().mQueue.mQuitAllowed = false;
    }
    
    private synchronized static void setMainLooper(Looper looper) {
        mMainLooper = looper;
    }
    
    public synchronized static Looper getMainLooper() {
        return mMainLooper;
    }
    
    public static void loop() {
        Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        MessageQueue queue = me.mQueue;
        
        Binder.clearCallingIdentity();
        long ident = Binder.clearCallingIdentity();
        Message msg = queue.next(); 

        msg.target.dispatchMessage(msg);

        long newIdent = Binder.clearCallingIdentity();
            msg.recycle();
    }
    
    @DSModeled(DSC.SAFE)
    public static Looper myLooper() {
        return mLocalLooper;
    }
    
    public void setMessageLogging(Printer printer){
        mLogging = printer;  //DSFIXME:  CODE0003: Field assignment should be reviewed
        // Original method
        /*
        {
        mLogging = printer;
    }
        */
    }
    
    public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }
    
    @DSModeled(DSC.SAFE)
    private Looper(){
        mQueue = new MessageQueue();
        mRun = true;
        mThread = Thread.currentThread();
    }
    
    public void quit(){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message msg = Message.obtain();
        //mQueue.enqueueMessage(msg, 0);
        // Original method
        /*
        {
        Message msg = Message.obtain();
        
        
        
        mQueue.enqueueMessage(msg, 0);
    }
        */
    }
    
    public Thread getThread(){
        return mThread;  //DSFIXME:  CODE0001: Unresolved return type/value combination

        // Original method
        /*
        {
        return mThread;
    }
        */
    }
    
    public MessageQueue getQueue(){
        return mQueue;  //DSFIXME:  CODE0001: Unresolved return type/value combination
    }
    
    public void dump(Printer pw, String prefix){
    }
    
    public String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }
    
    public static interface Profiler {
        void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime);
    }
}

