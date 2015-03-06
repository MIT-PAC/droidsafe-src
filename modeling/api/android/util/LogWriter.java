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
 * Copyright (C) 2011 The Android Open Source Project
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


package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.Writer;

public class LogWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.502 -0500", hash_original_field = "1D8CA7654CC48BAF402334392A1619BF", hash_generated_field = "032B46B6D9E42E1E80E269F8E583852A")

    private  int mPriority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.504 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private  String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.506 -0500", hash_original_field = "05EFAA6CD83F38E391B4F74E75C8B5CC", hash_generated_field = "364E92680041A3D3F5423C96BD78F11B")

    private  int mBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.508 -0500", hash_original_field = "F56AAA678AD284A339D9BF0BD3A2B91B", hash_generated_field = "E8A32971F664F41D368D321D04FCC115")

    private StringBuilder mBuilder = new StringBuilder(128);

    /**
     * Create a new Writer that sends to the log with the given priority
     * and tag.
     *
     * @param priority The desired log priority:
     * {@link android.util.Log#VERBOSE Log.VERBOSE},
     * {@link android.util.Log#DEBUG Log.DEBUG},
     * {@link android.util.Log#INFO Log.INFO},
     * {@link android.util.Log#WARN Log.WARN}, or
     * {@link android.util.Log#ERROR Log.ERROR}.
     * @param tag A string tag to associate with each printed log statement.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.511 -0500", hash_original_method = "E44EE0F95315B8E0B0AD825ED26FE77A", hash_generated_method = "188CCFB5B246EE5D89A18D68BA88246D")
    
public LogWriter(int priority, String tag) {
        mPriority = priority;
        mTag = tag;
        mBuffer = Log.LOG_ID_MAIN;
    }

    /**
     * @hide
     * Same as above, but buffer is one of the LOG_ID_ constants from android.util.Log.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.513 -0500", hash_original_method = "ABBE3E1E49A04D726DE9335FE3D64F4B", hash_generated_method = "A8E3F3EFC7065750A1B0080EAE6EE77C")
    
public LogWriter(int priority, String tag, int buffer) {
        mPriority = priority;
        mTag = tag;
        mBuffer = buffer;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.516 -0500", hash_original_method = "651C3299C6098C5206251D3395E7F56C", hash_generated_method = "1CD08D4D2256B0899718D98755C4D248")
    
@Override public void close() {
        flushBuilder();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.518 -0500", hash_original_method = "4397D4B6CC585AD9A2FABC1DB1031654", hash_generated_method = "64C92D353792C9C77A9951308C9A0855")
    
@Override public void flush() {
        flushBuilder();
    }

    @DSSink({DSSinkKind.FILE})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.521 -0500", hash_original_method = "87C8CDE1CE20D2763C465BB465CBAFDD", hash_generated_method = "72F623F59FC9F90F70CCD532565A22B3")
    
@Override public void write(char[] buf, int offset, int count) {
        for(int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if ( c == '\n') {
                flushBuilder();
            }
            else {
                mBuilder.append(c);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.523 -0500", hash_original_method = "365F60E44B7DA4848E76578B1D312F6F", hash_generated_method = "D50175F96A203B6C6D18C23FC2D8164A")
    
private void flushBuilder() {
        if (mBuilder.length() > 0) {
            Log.println_native(mBuffer, mPriority, mTag, mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
        }
    }
    
}

