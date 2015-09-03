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


package android.ddm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.dalvik.ddmc.DdmServer;

import android.util.Log;

public class DdmRegister {

    /**
     * Register handlers for all known chunk types.
     *
     * If you write a handler, add a registration call here.
     *
     * Note that this is invoked by the application (usually through a
     * static initializer in the main class), not the VM.  It's done this
     * way so that the handlers can use Android classes with native calls
     * that aren't registered until after the VM is initialized (e.g.
     * logging).  It also allows debugging of DDM handler initialization.
     *
     * The chunk dispatcher will pause until we call registrationComplete(),
     * so that we don't have a race that causes us to drop packets before
     * we finish here.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.504 -0500", hash_original_method = "0DBD2DB13D23998CD61361463D21566E", hash_generated_method = "E33EB1237E6138E6794C576FE6A01A09")
    
public static void registerHandlers() {
        if (false)
            Log.v("ddm", "Registering DDM message handlers");
        DdmHandleHello.register();
        DdmHandleThread.register();
        DdmHandleHeap.register();
        DdmHandleNativeHeap.register();
        DdmHandleProfiling.register();
        DdmHandleExit.register();

        DdmServer.registrationComplete();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.502 -0500", hash_original_method = "7B8C628EED4FBAEB3F2321039DB7D59A", hash_generated_method = "BD6F90C15B5A507D2DACDA65C5C77EF3")
    
private DdmRegister() {}
    
}

