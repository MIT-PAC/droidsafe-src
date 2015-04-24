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


package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class DdmVmInternal {
    
    public static void threadNotify(boolean enable) {
    }
    
    public static boolean heapInfoNotify(int when) {
        return ((when + 0) == 1);
    }
    
    public static boolean heapSegmentNotify(int when, int what,
        boolean isNative) {
        return 1 == (when + what + ((isNative) ? 1 : 0));
    }
    
    public static byte[] getThreadStats() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_319188016 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_319188016;
    }
    
    public static StackTraceElement[] getStackTraceById(int threadId) {
    	StackTraceElement[] ste = new StackTraceElement[]{new StackTraceElement()};
    	ste[0].addTaint(threadId);
    	return ste;
    }
    
    public static void enableRecentAllocations(boolean enable) {
    }
    
    public static boolean getRecentAllocationStatus() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13685764 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_13685764;
    }
    
    public static byte[] getRecentAllocations() {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_125459604 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_125459604;
    }

    /* do not instantiate */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.377 -0500", hash_original_method = "D0F76540C42EA165AE45A0473185E42C", hash_generated_method = "ECBD8B9A7C7FA66BB37ACB1437C1F5A1")
    
private DdmVmInternal() {}
    
}

