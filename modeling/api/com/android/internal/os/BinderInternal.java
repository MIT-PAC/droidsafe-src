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


package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;

import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.EventLog;

public class BinderInternal {
    
    public static final void joinThreadPool() {
    }
    
    /**
     * Return the system time (as reported by {@link SystemClock#uptimeMillis
     * SystemClock.uptimeMillis()}) that the last garbage collection occurred
     * in this process.  This is not for general application use, and the
     * meaning of "when a garbage collection occurred" will change as the
     * garbage collector evolves.
     * 
     * @return Returns the time as per {@link SystemClock#uptimeMillis
     * SystemClock.uptimeMillis()} of the last garbage collection.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.469 -0500", hash_original_method = "97EE1367F7D21A2061B5C261F1E7F987", hash_generated_method = "93E1464CFF71D32450A26A70F1E8933A")
    
public static long getLastGcTime() {
        return mLastGcTime;
    }
    
    public static final IBinder getContextObject() {
    	return new Binder();
    }
    
    public static final void disableBackgroundScheduling(boolean disable) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static final void handleGc() {
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.483 -0500", hash_original_method = "C06A63825025685CD72A0C7EB0DA954F", hash_generated_method = "2A120C37FE09D2BBCA349EC198BD8790")
    
public static void forceGc(String reason) {
        EventLog.writeEvent(2741, reason);
        Runtime.getRuntime().gc();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.486 -0500", hash_original_method = "C8BAA80AD02F89B5235BAA5DBC498303", hash_generated_method = "9FA534FAAC552D584AAD550252C07FB9")
    
static void forceBinderGc() {
        forceGc("Binder");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.455 -0500", hash_original_field = "97A81D7F56367AE21A0331CDF22407E7", hash_generated_field = "4909DFFCC1B301559EF73389910CBE90")

    static WeakReference<GcWatcher> mGcWatcher
            = new WeakReference<GcWatcher>(new GcWatcher());
    
    static final class GcWatcher {
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.469 -0400", hash_original_method = "23BF1C701EF3B7F131F4805BD4892CC0", hash_generated_method = "23BF1C701EF3B7F131F4805BD4892CC0")
        public GcWatcher ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.461 -0500", hash_original_method = "D42E2C52A602997A5DDE899C13954EBC", hash_generated_method = "2835620AD59CBECDB4AE305DEB0923E8")
        
@Override
        protected void finalize() throws Throwable {
            handleGc();
            mLastGcTime = SystemClock.uptimeMillis();
            mGcWatcher = new WeakReference<GcWatcher>(new GcWatcher());
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.457 -0500", hash_original_field = "8CAF103EDA9DB77FDE721BD1922741E3", hash_generated_field = "D78279B3A9A95C1743A81AEED357F5B0")

    static long mLastGcTime;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.467 -0400", hash_original_method = "574B8095C5FEB674167544EA24FDCEF4", hash_generated_method = "574B8095C5FEB674167544EA24FDCEF4")
    public BinderInternal ()
    {
        //Synthesized constructor
    }
}

