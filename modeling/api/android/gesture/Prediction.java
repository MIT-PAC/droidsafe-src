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
 * Copyright (C) 2008-2009 The Android Open Source Project
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


package android.gesture;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class Prediction {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:42.023 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:42.026 -0500", hash_original_field = "392BAB81EE9DEBA19077E79C97B4E004", hash_generated_field = "EE3D3D796FD28332770323C22B74F7E9")

    public double score;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:42.030 -0500", hash_original_method = "644866F6976727A13BE3BCA56F0E5002", hash_generated_method = "644866F6976727A13BE3BCA56F0E5002")
    
Prediction(String label, double predictionScore) {
        name = label;
        score = predictionScore;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:42.034 -0500", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "0D841C721535905DD0E9F7FAE6757EB9")
    
@Override
    public String toString() {
        return name;
    }
}
