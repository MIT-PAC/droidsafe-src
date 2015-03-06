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


package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SoundEffectConstants {

    /**
     * Get the sonification constant for the focus directions.
     * @param direction One of {@link View#FOCUS_UP}, {@link View#FOCUS_DOWN},
     *     {@link View#FOCUS_LEFT}, {@link View#FOCUS_RIGHT}, {@link View#FOCUS_FORWARD}
     *     or {@link View#FOCUS_BACKWARD}

     * @return The appropriate sonification constant.
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:29.109 -0500", hash_original_method = "975CB3430388B53E2334113DC7870A4A", hash_generated_method = "1809AE194BC69154A7C4FD122CC41E61")
    
public static int getContantForFocusDirection(int direction) {
        switch (direction) {
            case View.FOCUS_RIGHT:
                return SoundEffectConstants.NAVIGATION_RIGHT;
            case View.FOCUS_FORWARD:
            case View.FOCUS_DOWN:
                return SoundEffectConstants.NAVIGATION_DOWN;
            case View.FOCUS_LEFT:
                return SoundEffectConstants.NAVIGATION_LEFT;
            case View.FOCUS_BACKWARD:
            case View.FOCUS_UP:
                return SoundEffectConstants.NAVIGATION_UP;
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:29.095 -0500", hash_original_field = "C16599C87D20CC8B2C34D6DC122791AA", hash_generated_field = "842011BA204767E970B6FF04330AC6F7")

    public static final int CLICK = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:29.098 -0500", hash_original_field = "E020AF1279A153FF33B8371B47D5A756", hash_generated_field = "46B8495A67E10249C4EEB9EC55DBA5FB")

    public static final int NAVIGATION_LEFT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:29.100 -0500", hash_original_field = "5A92B619A037ABC84211CE0F778BC77C", hash_generated_field = "D84D0C65CA4D7F96B230BC929FB4712A")

    public static final int NAVIGATION_UP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:29.102 -0500", hash_original_field = "4EF2814DDD42A753117B765C6707DF20", hash_generated_field = "8EE0B662BC7D73676FD543978DA23BBE")

    public static final int NAVIGATION_RIGHT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:29.105 -0500", hash_original_field = "DDA98BB1A0FBF4B30B4CDA70ED45E07F", hash_generated_field = "EE4649B90CD478CCF358B3C657EE8B88")

    public static final int NAVIGATION_DOWN = 4;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:29.093 -0500", hash_original_method = "A319F34C5C5FF8EBCB8ED9E8C1DFDB18", hash_generated_method = "4129C50D0A507655FBF1F651D920A4AF")
    
private SoundEffectConstants() {}
}

