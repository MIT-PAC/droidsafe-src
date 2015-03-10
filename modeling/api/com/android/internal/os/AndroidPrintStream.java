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
import droidsafe.annotations.*;
import android.util.Log;

class AndroidPrintStream extends LoggingPrintStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.421 -0500", hash_original_field = "4AD9F2E37B35E313CD211FBAFDADA238", hash_generated_field = "8E016BF5ECF2BB6A2B257594975987F0")

    private  int priority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.424 -0500", hash_original_field = "FFCA994A2F44B678330E924D8C87385D", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

    private  String tag;

    /**
     * Constructs a new logging print stream.
     *
     * @param priority from {@link android.util.Log}
     * @param tag to log
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.427 -0500", hash_original_method = "9AD980F40A2045042AAB302D5FCF2B5F", hash_generated_method = "30BC18EB056406780EC8E5E51FC6F0CF")
    
public AndroidPrintStream(int priority, String tag) {
        if (tag == null) {
            throw new NullPointerException("tag");
        }

        this.priority = priority;
        this.tag = tag;
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.429 -0500", hash_original_method = "0F469F25708F7CED7810AA1C6F552E30", hash_generated_method = "093B57ECFD6CD656AF0FC491F2F55077")
    
protected void log(String line) {
        Log.println(priority, tag, line);
    }
    
}

