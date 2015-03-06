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


package android.view;

/**
 * An instance of this class represents a connection to the surface
 * flinger, in which you can create one or more Surface instances that will
 * be composited to the screen.
 * {@hide}
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class SurfaceSession {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:51.073 -0500", hash_original_field = "2F6FF5EA29921F70A9C5DDA8BCF79233", hash_generated_field = "3E3D5E9063EF194136095621B51E9E94")
    
    private int mClient;
    /** Create a new connection with the surface flinger. */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:51.061 -0500", hash_original_method = "3090E932217661E4843C4AD83F04C6C8", hash_generated_method = "D9A3006296F54DC57E69AF99BF01795B")
    public SurfaceSession() {
        init();
    }

    /** Forcibly detach native resources associated with this object.
     *  Unlike destroy(), after this call any surfaces that were created
     *  from the session will no longer work. The session itself is destroyed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:51.064 -0500", hash_original_method = "6DB7562090EFDF2A4E3B2737D0D72CFB", hash_generated_method = "76D0D37EABC0A2F95218F1C62A5F7518")
    public native void kill();

    /* no user serviceable parts here ... */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:51.066 -0500", hash_original_method = "EC5E3125F13C4F48F4208EA7F748E31A", hash_generated_method = "7AA697ADBFEAED8C69705D222C71A8C1")
    @Override
protected void finalize() throws Throwable {
        destroy();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:51.068 -0500", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "F81DCAEA02333A19E1E156A74DA49C13")
    private native void init();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:51.071 -0500", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "31D0D9F10F6714E67704A655F4167D74")
    private native void destroy();
}

