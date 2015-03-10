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
 * Copyright (C) 2010 The Android Open Source Project
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

public abstract class WebBackForwardListClient {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.340 -0400", hash_original_method = "3EE15C74E8939A7E4FFBB261B684E6CA", hash_generated_method = "3EE15C74E8939A7E4FFBB261B684E6CA")
    public WebBackForwardListClient ()
    {
        //Synthesized constructor
    }

    /**
     * Notify the client that <var>item</var> has been added to the
     * WebBackForwardList.
     * @param item The newly created WebHistoryItem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.838 -0500", hash_original_method = "1F6D8177500DFC3D1F576E07196A0774", hash_generated_method = "98B7C3854156F83ED7D3C6F9613B5879")
    
public void onNewHistoryItem(WebHistoryItem item) { }

    /**
     * Notify the client that the <var>item</var> at <var>index</var> is now
     * the current history item.
     * @param item A WebHistoryItem
     * @param index The new history index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.841 -0500", hash_original_method = "DA8164C67D7B3779FDED447EEF1649BA", hash_generated_method = "D1F90A23A260AF74142BEABDA486C7C2")
    
public void onIndexChanged(WebHistoryItem item, int index) { }
    
}

