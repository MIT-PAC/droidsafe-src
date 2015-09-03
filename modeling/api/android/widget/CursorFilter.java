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


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.Cursor;

class CursorFilter extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.218 -0500", hash_original_field = "D7B21BB19581EA5872B7B46EEFBFEFD2", hash_generated_field = "D7B21BB19581EA5872B7B46EEFBFEFD2")
    
    CursorFilterClient mClient;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.222 -0500", hash_original_method = "D61DC331CF58D286B36C03C7DC72D315", hash_generated_method = "D61DC331CF58D286B36C03C7DC72D315")
    
CursorFilter(CursorFilterClient client) {
        mClient = client;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.224 -0500", hash_original_method = "13FD068C641361B638C17FBE36928984", hash_generated_method = "FF91822F802434705CBC4C09319997FF")
    
@Override
    public CharSequence convertResultToString(Object resultValue) {
        return mClient.convertToString((Cursor) resultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.226 -0500", hash_original_method = "A46F4651EB2D092BF8983D238E1886EF", hash_generated_method = "E68AF8F684BAC8BB9C76E876AB44A3BD")
    
@Override
    protected FilterResults performFiltering(CharSequence constraint) {
        Cursor cursor = mClient.runQueryOnBackgroundThread(constraint);

        FilterResults results = new FilterResults();
        if (cursor != null) {
            results.count = cursor.getCount();
            results.values = cursor;
        } else {
            results.count = 0;
            results.values = null;
        }
        return results;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.229 -0500", hash_original_method = "9BA8484E000B7F5A5243E4175A8A6AA1", hash_generated_method = "F36CBE0D47BEC60B532B63E6A8C401B3")
    
@Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        Cursor oldCursor = mClient.getCursor();
        
        if (results.values != null && results.values != oldCursor) {
            mClient.changeCursor((Cursor) results.values);
        }
    }
    
    interface CursorFilterClient {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        CharSequence convertToString(Cursor cursor);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Cursor runQueryOnBackgroundThread(CharSequence constraint);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Cursor getCursor();
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void changeCursor(Cursor cursor);
    }
    
}

