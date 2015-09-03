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
 * Copyright (C) 2008 The Android Open Source Project
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


package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class ImplForArray implements GenericArrayType {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.091 -0500", hash_original_field = "F00973532948845018B52A37FE021D3D", hash_generated_field = "E5C2178136BA4F8025942E6B948C4074")

    private  Type componentType;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.094 -0500", hash_original_method = "2027F862B9235E5067268A95F39519F4", hash_generated_method = "FF87340AB7A0B61B9F8FC14E23DB9FB4")
    
public ImplForArray(Type componentType) {
        this.componentType = componentType;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.096 -0500", hash_original_method = "DF2F4D0FDA59F8B376BF76172F429ABC", hash_generated_method = "F54BF30A1F49AEE5A1AF09CA296E86D0")
    
public Type getGenericComponentType() {
        try {
            return ((ImplForType)componentType).getResolvedType();
        } catch (ClassCastException e) {
            return componentType;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.098 -0500", hash_original_method = "4E93C574A33186DE87D5834EAA369B51", hash_generated_method = "406518163465E3F00AFF50CA1CF0EF49")
    
public String toString() {
        return componentType.toString() + "[]";
    }
    
}

