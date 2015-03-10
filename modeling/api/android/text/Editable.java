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


package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Editable
extends CharSequence, GetChars, Spannable, Appendable
{
    
    public Editable replace(int st, int en, CharSequence source, int start, int end);
    
    public Editable replace(int st, int en, CharSequence text);
    
    public Editable insert(int where, CharSequence text, int start, int end);
    
    public Editable insert(int where, CharSequence text);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public Editable delete(int st, int en);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SCREEN})
    public Editable append(CharSequence text);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SCREEN})
    public Editable append(CharSequence text, int start, int end);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SCREEN})
    public Editable append(char text);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public void clear();
    
    public void clearSpans();
    
    public void setFilters(InputFilter[] filters);
    
    public InputFilter[] getFilters();
    
    public static class Factory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.811 -0500", hash_original_field = "65E9316609C84FFB5CA83C3D42FAE896", hash_generated_field = "B3CC448774E7F8087983631BC24BCBA2")

        private static Editable.Factory sInstance = new Editable.Factory();

        /**
         * Returns the standard Editable Factory.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.814 -0500", hash_original_method = "9A0E6307B69C9A35763295D22146612F", hash_generated_method = "7E23A453D9DEAF97B61DCAC37ED207A7")
        
public static Editable.Factory getInstance() {
            return sInstance;
        }
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        private Factory() {
        	//Synthensized constructor
        }

        /**
         * Returns a new SpannedStringBuilder from the specified
         * CharSequence.  You can override this to provide
         * a different kind of Spanned.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.817 -0500", hash_original_method = "94DC09761C02587DB61BD4F9F3F80E82", hash_generated_method = "65F50A661763606C8326FD0B68BE9239")
        
public Editable newEditable(CharSequence source) {
            return new SpannableStringBuilder(source);
        }
    }
}
