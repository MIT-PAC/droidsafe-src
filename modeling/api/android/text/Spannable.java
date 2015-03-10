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

public interface Spannable
extends Spanned
{
    
    public void setSpan(Object what, int start, int end, int flags);
    
    public void removeSpan(Object what);
    
    public static class Factory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.420 -0500", hash_original_field = "55B004A6311ACDD2F2CC41A6D302D9CC", hash_generated_field = "D38268B7ECC673F62ED2EB1F6B1FFA6B")

        private static Spannable.Factory sInstance = new Spannable.Factory();

        /**
         * Returns the standard Spannable Factory.
         */ 
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.423 -0500", hash_original_method = "854342FB7AA07CACA3CB649964786E1F", hash_generated_method = "010373F6EA859BB9A59E2F60718E25C2")
        
public static Spannable.Factory getInstance() {
            return sInstance;
        }
        
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
        private Factory() {
        	//Synthetic method
        }

        /**
         * Returns a new SpannableString from the specified CharSequence.
         * You can override this to provide a different kind of Spannable.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.425 -0500", hash_original_method = "EE26FD92F5BDD12B70225AE1B2FCF67F", hash_generated_method = "5AD200519B3A1311651581156BABDB06")
        
public Spannable newSpannable(CharSequence source) {
            return new SpannableString(source);
        }
    }
}
