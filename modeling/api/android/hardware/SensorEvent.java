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


package android.hardware;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SensorEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.051 -0500", hash_original_field = "34347BA7077FDF6590D0C0F92E7987C8", hash_generated_field = "4C1F93B13D708FDED2C5B6FA6458F63C")

    public final float[] values;
    public Sensor sensor = new Sensor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.056 -0500", hash_original_field = "F968021B8FC52C3A5A8A5DC1E79FDC6D", hash_generated_field = "7F2B820F3882E94A9556DB7409C1AD98")

    public int accuracy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.059 -0500", hash_original_field = "145039C09D0281F07AE1DE322AF921C0", hash_generated_field = "37EA591B5E14A037995EF6FFB5E9C3F8")

    public long timestamp;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.062 -0500", hash_original_method = "70E99143ED23AB543A4BC023624913AA", hash_generated_method = "70E99143ED23AB543A4BC023624913AA")
    
SensorEvent(int size) {
        values = new float[size];
    }
    
    // orphaned legacy method
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public SensorEvent() {
    	//Method doesn't exist in original implementation, needed for specdump
    	this(0);  //Call the original constructor with a size of 0
    }
    
}

