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


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

public interface SearchBox {
    
    void setQuery(String query);

    
    void setVerbatim(boolean verbatim);

    
    void setSelection(int selectionStart, int selectionEnd);

    
    void setDimensions(int x, int y, int width, int height);

    
    void onchange(SearchBoxListener listener);
    void onsubmit(SearchBoxListener listener);
    void onresize(SearchBoxListener listener);
    void oncancel(SearchBoxListener listener);

    
    void addSearchBoxListener(SearchBoxListener l);
    void removeSearchBoxListener(SearchBoxListener l);

    
    void isSupported(IsSupportedCallback callback);

    
    public abstract class SearchBoxListener {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.977 -0500", hash_original_method = "34F5C706F91A884D119852D6C8BF6FAD", hash_generated_method = "3B83392905C42909BDA6B661AD3CC33F")
        
public void onSuggestionsReceived(String query, List<String> suggestions) {}
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.979 -0500", hash_original_method = "7FBD69DAC5C0E0CD9F75A1373E78C361", hash_generated_method = "8CFD3FED61336E9B08786A83EC73B1D4")
        
public void onChangeComplete(boolean called) {}
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.982 -0500", hash_original_method = "71C1F711B035883DED4604B2FD6D0051", hash_generated_method = "0DFF9ECA004E73A6E6DCC71862AE1376")
        
public void onSubmitComplete(boolean called) {}
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.984 -0500", hash_original_method = "ECE45247FBD4A7444883FCD9FA98954D", hash_generated_method = "33CFDC3B2B53FADA2EE697D2C873DF7D")
        
public void onResizeComplete(boolean called) {}
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.986 -0500", hash_original_method = "DB666216EC7EE451D53F334FF294554F", hash_generated_method = "80FBDF2DC7B69CDE25AA6B5E84D2742D")
        
public void onCancelComplete(boolean called) {}
    }

    interface IsSupportedCallback {
        void searchBoxIsSupported(boolean supported);
    }
}
