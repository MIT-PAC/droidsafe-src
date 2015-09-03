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

import droidsafe.helpers.DSUtils;

public final class SystemClock {

    /**
     * Waits a given number of milliseconds (of uptimeMillis) before returning.
     * Similar to {@link java.lang.Thread#sleep(long)}, but does not throw
     * {@link InterruptedException}; {@link Thread#interrupt()} events are
     * deferred until the next interruptible operation.  Does not return until
     * at least the specified number of milliseconds has elapsed.
     *
     * @param ms to sleep before returning, in milliseconds of uptime.
     */
    @DSComment("SystemClock only allows reading time")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.628 -0500", hash_original_method = "D4BA21E42781D683EDE66760B12EFE55", hash_generated_method = "7BE0E448310CD35EBF03CDB3833013C9")
    
public static void sleep(long ms)
    {
        long start = uptimeMillis();
        long duration = ms;
        boolean interrupted = false;
        do {
            try {
                Thread.sleep(duration);
            }
            catch (InterruptedException e) {
                interrupted = true;
            }
            duration = start + ms - uptimeMillis();
        } while (duration > 0);
        
        if (interrupted) {
            // Important: we don't want to quietly eat an interrupt() event,
            // so we make sure to re-interrupt the thread so that the next
            // call to Thread.sleep() or Object.wait() will be interrupted.
            Thread.currentThread().interrupt();
        }
    }
    
    public static boolean setCurrentTimeMillis(long millis) {
        return ((millis + 0) == 1);
    }
    
    @DSComment("SystemClock only allows reading time")
    @DSSpec(DSCat.SPEC_OTHERS)
    public static long uptimeMillis() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSComment("SystemClock only allows reading time")
    @DSSpec(DSCat.SPEC_OTHERS)
    public static long elapsedRealtime() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    public static long currentThreadTimeMillis() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    public static long currentThreadTimeMicro() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    public static long currentTimeMicro() {
        return DSUtils.UNKNOWN_LONG;
    }
    /**
     * This class is uninstantiable.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.625 -0500", hash_original_method = "447AF20F3E8B0F9406C259A46D1AF12B", hash_generated_method = "874F5813A3F49589CCC4C945CC392D71")
    
private SystemClock() {
        // This space intentionally left blank.
    }
    
}

