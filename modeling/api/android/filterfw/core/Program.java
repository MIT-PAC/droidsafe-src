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
import android.filterfw.core.Frame;

/**
 * @hide
 */
public abstract class Program {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.725 -0400", hash_original_method = "5D4B182C13FDFB605816A92AA939C024", hash_generated_method = "3D31C5113D8F550E7C1980C4B52398A1")
    
public abstract void process(Frame[] inputs, Frame output);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.727 -0400", hash_original_method = "84FA7FFCB6D2EAC45947929AAAB93B5F", hash_generated_method = "E669F6279E60DE03FC859284D41B5B72")
    
public void process(Frame input, Frame output) {
        Frame[] inputs = new Frame[1];
        inputs[0] = input;
        process(inputs, output);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.729 -0400", hash_original_method = "CB6ED5A319B8FBE16E4EA544EA358C38", hash_generated_method = "004338EC2FBF44DF7FDB75222393F838")
    
public abstract void setHostValue(String variableName, Object value);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.731 -0400", hash_original_method = "CFE55283BEF1363CBEFC7663E47BD350", hash_generated_method = "458E97A0770B0BA11798613E304C3152")
    
public abstract Object getHostValue(String variableName);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.732 -0400", hash_original_method = "4EF91A3E15873EFCED84A853021A57CF", hash_generated_method = "68478A36EBC757665318F6F90B9E59FB")
    
public void reset() {
    }
}
