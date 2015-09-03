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


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.Filter;
import android.filterfw.core.FilterGraph;

/**
 * @hide
 */
public abstract class Scheduler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.908 -0400", hash_original_field = "E3357D6D3E4D428AD86D983CD865711F", hash_generated_field = "9E32B4D3FABC553ED224E39F060C6C8D")


    private FilterGraph mGraph;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.910 -0400", hash_original_method = "8EE1D1EE541AE974C840E43E5428F55F", hash_generated_method = "8EE1D1EE541AE974C840E43E5428F55F")
    
Scheduler(FilterGraph graph) {
        mGraph = graph;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.911 -0400", hash_original_method = "C7273845EE9D33E9DD5A368F4B5DE174", hash_generated_method = "C7273845EE9D33E9DD5A368F4B5DE174")
    
FilterGraph getGraph() {
        return mGraph;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.913 -0400", hash_original_method = "7BEB446FE26B948F797F8DE87E46C23D", hash_generated_method = "C8EC33808500569A3C0D3A9B5856EF66")
    
abstract void reset();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.914 -0400", hash_original_method = "0A23D40A09E3BBAE84009B702866A512", hash_generated_method = "3EF62C22C0F45E46C13FE82CFA282C6D")
    
abstract Filter scheduleNextNode();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.915 -0400", hash_original_method = "81AEE3FA2CFC89828F47823EAAC71C35", hash_generated_method = "53E984AC7AAFEA93AB7B9E5B83FB8A45")
    
boolean finished() {
        // TODO: Check that the state of all nodes is FINISHED.
        return true;
    }
}
