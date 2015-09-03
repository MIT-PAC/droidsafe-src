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


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Handler;

public class HttpAuthHandler extends Handler {

    /**
     * Package-private constructor needed for API compatibility.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.453 -0500", hash_original_method = "F01806C33F7FC6D16E466FBD9D98D7F4", hash_generated_method = "F01806C33F7FC6D16E466FBD9D98D7F4")
    
HttpAuthHandler() {
    }

    /**
     * @return True if we can use user credentials on record
     * (ie, if we did not fail trying to use them last time)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.455 -0500", hash_original_method = "F0A4AAEE1F9A8307640214EBB73E6D02", hash_generated_method = "6B541B9C4187CD3A92930DD9D326A028")
    
public boolean useHttpAuthUsernamePassword() {
        return false;
    }

    /**
     * Cancel the authorization request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.457 -0500", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "03D37BD64D7EA5A498C29F3157B06CA4")
    
public void cancel() {
    }

    /**
     * Proceed with the authorization with the given credentials.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.459 -0500", hash_original_method = "7B4A8A6A74B23286EE840983B92045A0", hash_generated_method = "1E4226B8F66BE4AA92E3E4C4EF7174D4")
    
public void proceed(String username, String password) {
    }

    /**
     * return true if the prompt dialog should be suppressed.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.461 -0500", hash_original_method = "22C12092B284774CBE15329CD788E924", hash_generated_method = "D95D2FA0457C8806A430432C19769447")
    
public boolean suppressDialog() {
        return false;
    }
    
}

