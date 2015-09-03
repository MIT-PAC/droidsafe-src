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


package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public final class VMStack {
    
    public static ClassLoader getCallingClassLoader() {
    	return (ClassLoader) new Object();
    }
    
    public static Class<?> getStackClass2() {
    	return Object.class;
    }
    
    public static Class<?>[] getClasses(int maxDepth) {
    	return new Class[]{Object.class};
    }
    
    public static StackTraceElement[] getThreadStackTrace(Thread t) {
    	return new StackTraceElement[0];
    }
    
    public static int fillStackTraceElements(Thread t,
        StackTraceElement[] stackTraceElements) {
        return t.getTaintInt() + stackTraceElements.getTaintInt() + stackTraceElements[0].getTaintInt();
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.859 -0400", hash_original_method = "48F2A5F5D0FB61BCDEE57F0E62DA7F3A", hash_generated_method = "48F2A5F5D0FB61BCDEE57F0E62DA7F3A")
    public VMStack ()
    {
        //Synthesized constructor
    }
    
}

