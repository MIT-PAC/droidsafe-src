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


package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.MotionEvent;

class MotionEventCompatEclair {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.499 -0500", hash_original_method = "4532F0A9C8412F2F18F248FA9DC36704", hash_generated_method = "07394EB775CDD65867A9302D3C85D64A")
    
public static int findPointerIndex(MotionEvent event, int pointerId) {
        return event.findPointerIndex(pointerId);
    }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.501 -0500", hash_original_method = "0313DEEDC2C2EBC5612C0D1F7EE1D400", hash_generated_method = "A64F52BCDA66FABECF4DB57D2C1DD113")
    
public static int getPointerId(MotionEvent event, int pointerIndex) {
        return event.getPointerId(pointerIndex);
    }
    @DSSource({DSSourceKind.SENSOR})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.503 -0500", hash_original_method = "71037EC82E25334B8658FE7CAF74254C", hash_generated_method = "2A62E5EB8B53070140816646ABF8B82F")
    
public static float getX(MotionEvent event, int pointerIndex) {
        return event.getX(pointerIndex);
    }
    @DSSource({DSSourceKind.SENSOR})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.506 -0500", hash_original_method = "E6751B9CCEB4AE9E9D1DFA2B571CCFF4", hash_generated_method = "F2EA8628AE2361A523076152891B6FF4")
    
public static float getY(MotionEvent event, int pointerIndex) {
        return event.getY(pointerIndex);
    }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.508 -0500", hash_original_method = "35653BBE54B1920FB4D0E64EA7E26E6C", hash_generated_method = "DE1B0BA5CE673EAA99F15BF6532BB078")
    
public static int getPointerCount(MotionEvent event) {
        return event.getPointerCount();
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.302 -0400", hash_original_method = "5ACF9ABC04422C9663D1A845A64C1366", hash_generated_method = "5ACF9ABC04422C9663D1A845A64C1366")
    public MotionEventCompatEclair ()
    {
        //Synthesized constructor
    }
    
}

