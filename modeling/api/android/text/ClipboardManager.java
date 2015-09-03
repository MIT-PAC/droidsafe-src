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


package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class ClipboardManager {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.480 -0400", hash_original_method = "47A2DF210DD8BA7527F7EBA65DD74954", hash_generated_method = "47A2DF210DD8BA7527F7EBA65DD74954")
    public ClipboardManager ()
    {
        //Synthesized constructor
    }
    /**
     * Returns the text on the clipboard.  It will eventually be possible
     * to store types other than text too, in which case this will return
     * null if the type cannot be coerced to text.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.647 -0500", hash_original_method = "F253B5A800FFE39B36B9B816BB348763", hash_generated_method = "748527C2FC98E6C1FD97D7948B23BF56")
    
public abstract CharSequence getText();

    /**
     * Sets the contents of the clipboard to the specified text.
     */
    @DSSink({DSSinkKind.CLIPBOARD})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.649 -0500", hash_original_method = "7694500E873F3B5A010FB45AB92E588E", hash_generated_method = "1B0356A0E99BE3853E335A9D1544F6DC")
    
public abstract void setText(CharSequence text);

    /**
     * Returns true if the clipboard contains text; false otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.652 -0500", hash_original_method = "FEE95F46D40A81ECD11480FFA4D48D25", hash_generated_method = "62298B6995888C651FA05A1C1F62E311")
    
public abstract boolean hasText();
    
}

