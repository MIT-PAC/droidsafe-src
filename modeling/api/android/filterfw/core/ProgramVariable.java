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

/**
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ProgramVariable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.794 -0400", hash_original_field = "4F468238F1FA728D50ED45F1F20249D0", hash_generated_field = "F681A238880E006F78AF8B4B7BB89C3C")


    private Program mProgram;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.796 -0400", hash_original_field = "60062C9CB6406B5ABE6C6187173918AE", hash_generated_field = "094B12A16EA8F3922B6C53660EBFD45E")

    private String mVarName;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.798 -0400", hash_original_method = "A4B58271522A33E2EA16AEAC32E74797", hash_generated_method = "E102844790CCE008973582CC674B2533")
    
public ProgramVariable(Program program, String varName) {
        mProgram = program;
        mVarName = varName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.800 -0400", hash_original_method = "EDEC9FBF239C7887DD0AD8A02B413E1B", hash_generated_method = "11FAA77F1406D5D36E6DCB868402892E")
    
public Program getProgram() {
        return mProgram;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.802 -0400", hash_original_method = "5585270324B938753C62BDD90C6088E3", hash_generated_method = "BFCDA8F553937FD10556A5196B8659D7")
    
public String getVariableName() {
        return mVarName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.804 -0400", hash_original_method = "D38963E005D5A9A3A34A1284CB80241E", hash_generated_method = "A0A5A663CEAB5E62AEFBA8B8447B6E4E")
    
public void setValue(Object value) {
        if (mProgram == null) {
            throw new RuntimeException("Attempting to set program variable '" + mVarName
                + "' but the program is null!");
        }
        mProgram.setHostValue(mVarName, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.807 -0400", hash_original_method = "D68218AC574C24265E195636E2326CCC", hash_generated_method = "C8735996384973B74842D727A1CB0C4D")
    
public Object getValue() {
        if (mProgram == null) {
            throw new RuntimeException("Attempting to get program variable '" + mVarName
                + "' but the program is null!");
        }
        return mProgram.getHostValue(mVarName);
    }

}
