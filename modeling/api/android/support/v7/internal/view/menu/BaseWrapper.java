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
 * Copyright (C) 2012 The Android Open Source Project
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


package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
class BaseWrapper<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.227 -0400", hash_original_field = "DA09860682614DC6FCD3864BCA58A8F6", hash_generated_field = "DA09860682614DC6FCD3864BCA58A8F6")


     T mWrappedObject;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.230 -0400", hash_original_method = "37C82B9ED3326B5D6055D816FA80E769", hash_generated_method = "37C82B9ED3326B5D6055D816FA80E769")
    
BaseWrapper(T object) {
        if (null == object) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        mWrappedObject = object;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.234 -0400", hash_original_method = "E0625E96D11D7925C1B04E186D9093C0", hash_generated_method = "E3981CA04C33100F7ECC63F9694777D4")
    
public T getWrappedObject() {
        return mWrappedObject;
    }

}
