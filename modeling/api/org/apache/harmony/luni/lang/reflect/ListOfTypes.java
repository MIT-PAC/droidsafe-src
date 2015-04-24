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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ListOfTypes {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.380 -0500", hash_original_field = "3F1F6030BCDD98A28C66A50CDE6FA707", hash_generated_field = "E5BC5D3021F6BC63E6401C0642F71BC4")

    public static final ListOfTypes EMPTY = new ListOfTypes(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.382 -0500", hash_original_field = "25EE3D1DF3EFF447F1E23307BE5924F7", hash_generated_field = "8892A3AAA12E491FA3A203DD834955E2")

    private  ArrayList<Type> types;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.384 -0500", hash_original_field = "D770CE609AEA02FF918F433C4A25BBD4", hash_generated_field = "87D7847847236888863F03CF45EBFAF0")

    private Type[] resolvedTypes;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.387 -0500", hash_original_method = "1B717CC03BB3C0AEB2AD5F80BAEDAB75", hash_generated_method = "1B717CC03BB3C0AEB2AD5F80BAEDAB75")
    
ListOfTypes(int capacity) {
        types = new ArrayList<Type>(capacity);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.390 -0500", hash_original_method = "A3B43C45442B7BC58B3D5A9B17362DF9", hash_generated_method = "A3B43C45442B7BC58B3D5A9B17362DF9")
    
ListOfTypes(Type[] types) {
        this.types = new ArrayList<Type>(types.length);
        for (Type type : types) {
            this.types.add(type);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.392 -0500", hash_original_method = "521B9354050D45CFE1C9313A9C3FFED0", hash_generated_method = "521B9354050D45CFE1C9313A9C3FFED0")
    
void add(Type type) {
        if (type == null) {
            throw new NullPointerException("type == null");
        }
        types.add(type);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.394 -0500", hash_original_method = "5C54E587FAEC26FCFBB8E0F344888E86", hash_generated_method = "5C54E587FAEC26FCFBB8E0F344888E86")
    
int length() {
        return types.size();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.396 -0500", hash_original_method = "631AD2F872BA627B3C9B69A500832CF8", hash_generated_method = "7C8FA95CDCE8FEEFD2611EA1DB9E4457")
    
public Type[] getResolvedTypes() {
        Type[] result = resolvedTypes;
        return result != null ? result : (resolvedTypes = resolveTypes(types));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.399 -0500", hash_original_method = "F2767C6141E0603586233C8F8B50B3D9", hash_generated_method = "D4DD27393712A5F784F0C5FAEC33AC16")
    
private Type[] resolveTypes(List<Type> unresolved) {
        Type[] result = new Type[unresolved.size()];
        for (int i = 0; i < unresolved.size(); i++) {
            Type type = unresolved.get(i);
            try {
                result[i] = ((ImplForType) type).getResolvedType();
            } catch (ClassCastException e) {
                result[i] = type;
            }
        }
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.401 -0500", hash_original_method = "E058D2B2430FADEC45CDF66AF212F70E", hash_generated_method = "C48B5FE2503511730C3FE65E0E6BFCB8")
    
@Override public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < types.size(); i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(types.get(i));
        }
        return result.toString();
    }
}

