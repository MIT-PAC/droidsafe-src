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
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class HandlerThread extends Thread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.197 -0500", hash_original_field = "1D8CA7654CC48BAF402334392A1619BF", hash_generated_field = "1D8CA7654CC48BAF402334392A1619BF")

    int mPriority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.199 -0500", hash_original_field = "443BB6C8F0508752717F617F7353B13A", hash_generated_field = "443BB6C8F0508752717F617F7353B13A")

    int mTid = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.201 -0500", hash_original_field = "4C6A73D1D5351706C43659B423CF9288", hash_generated_field = "4C6A73D1D5351706C43659B423CF9288")

    Looper mLooper;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.204 -0500", hash_original_method = "E5F101A858C2AB40D5C2E9617BFE5E37", hash_generated_method = "3E0C0881ECB68AF6855B784013C5EA28")
    
public HandlerThread(String name) {
        super(name);
        mPriority = Process.THREAD_PRIORITY_DEFAULT;
    }
    
    /**
     * Constructs a HandlerThread.
     * @param name
     * @param priority The priority to run the thread at. The value supplied must be from 
     * {@link android.os.Process} and not from java.lang.Thread.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.207 -0500", hash_original_method = "E70E3F12F9547EDCFC1C795A424416CD", hash_generated_method = "965A538D3098226CBCAF41065E4CD7F9")
    
public HandlerThread(String name, int priority) {
        super(name);
        mPriority = priority;
    }
    
    /**
     * Call back method that can be explicitly over ridden if needed to execute some
     * setup before Looper loops.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.209 -0500", hash_original_method = "7869505C1EE96F329E4F7F0EA5AF9C5D", hash_generated_method = "F5B9F1894C2B7AD20F6F29B9231F6283")
    
protected void onLooperPrepared() {
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.212 -0500", hash_original_method = "9E0B8BC0299FD7F24B369B7431C1A009", hash_generated_method = "10FDEB337D9B6B5924296A208F963B2B")
    
public void run() {
        mTid = Process.myTid();
        Looper.prepare();
        synchronized (this) {
            mLooper = Looper.myLooper();
            notifyAll();
        }
        Process.setThreadPriority(mPriority);
        onLooperPrepared();
        Looper.loop();
        mTid = -1;
    }
    
    /**
     * This method returns the Looper associated with this thread. If this thread not been started
     * or for any reason is isAlive() returns false, this method will return null. If this thread 
     * has been started, this method will block until the looper has been initialized.  
     * @return The looper.
     */
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.214 -0500", hash_original_method = "0FC13809696BA2D6DC441C842770D0F1", hash_generated_method = "4B1708DC77C7D7E3B2BA2EC8692FAEBE")
    
public Looper getLooper() {
        if (!isAlive()) {
            return null;
        }
        
        // If the thread has been started, wait until the looper has been created.
        synchronized (this) {
            while (isAlive() && mLooper == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return mLooper;
    }
    
    /**
     * Ask the currently running looper to quit.  If the thread has not
     * been started or has finished (that is if {@link #getLooper} returns
     * null), then false is returned.  Otherwise the looper is asked to
     * quit and true is returned.
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.216 -0500", hash_original_method = "45988F35C3EAC3EE4988825F5EC29D45", hash_generated_method = "61D5C501697D0C9B0E5B1637868ED248")
    
public boolean quit() {
        Looper looper = getLooper();
        if (looper != null) {
            looper.quit();
            return true;
        }
        return false;
    }

    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)   
    public boolean quitSafely() {
            return true;
    }
    
    /**
     * Returns the identifier of this thread. See Process.myTid().
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.219 -0500", hash_original_method = "EC4E0EE5AEE6B394A49A3FA195776A82", hash_generated_method = "8D563438E811E72E71A9B78483890840")
    
public int getThreadId() {
        return mTid;
    }
    
}

