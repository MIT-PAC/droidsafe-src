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


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class JsPromptResult extends JsResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.310 -0500", hash_original_field = "2053E8C09D9532D7178A8C6035EA0C79", hash_generated_field = "EBA696E93844251FD8576C3F0CF71EE9")

    private String mStringResult;

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.315 -0500", hash_original_method = "7ABE9E090B5E64D2572624CACEEEAFE1", hash_generated_method = "9E37D98FDA33A4F76FED61A9E0A14B68")
    
JsPromptResult(CallbackProxy proxy) {
        super(proxy, /* unused */ false);
    }

    /**
     * Handle a confirmation response from the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.312 -0500", hash_original_method = "50CD500D47F4FCEE0A0F59D7183F0AD5", hash_generated_method = "6BA4FAFF5E710B22D2B7E38FD8D68A75")
    
public void confirm(String result) {
        mStringResult = result;
        confirm();
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.317 -0500", hash_original_method = "A6887DA895C48DFEB95F5B019D028B73", hash_generated_method = "A6887DA895C48DFEB95F5B019D028B73")
    
String getStringResult() {
        return mStringResult;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:15.319 -0500", hash_original_method = "7194C2D571222CB4C5E996180C4D4F3B", hash_generated_method = "C92D3EEE7E204BFD9B51C2A5DC9B9988")
    
@Override
    /*package*/ void handleDefault() {
        mStringResult = null;
        super.handleDefault();
    }
    
}

