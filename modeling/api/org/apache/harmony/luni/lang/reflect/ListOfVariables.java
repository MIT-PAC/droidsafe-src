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
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

class ListOfVariables {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.128 -0500", hash_original_field = "A17304FEBED4ADC14900CE4BD8265A40", hash_generated_field = "D64E397C4F832C91E31EE342BD369971")

    public static final TypeVariable[] EMPTY = new ImplForVariable[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.130 -0500", hash_original_field = "ADB884948D4C2258B0B63DC54D3E2A0F", hash_generated_field = "ADB884948D4C2258B0B63DC54D3E2A0F")

    ArrayList<TypeVariable<?>> array = new ArrayList<TypeVariable<?>>();
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.025 -0400", hash_original_method = "41422E53316C05168ACE5C5221EA93B8", hash_generated_method = "41422E53316C05168ACE5C5221EA93B8")
    public ListOfVariables ()
    {
        //Synthesized constructor
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.132 -0500", hash_original_method = "E8D6FFF820F0D97573E6E2C017665088", hash_generated_method = "E8D6FFF820F0D97573E6E2C017665088")
    
void add (TypeVariable<?> elem) {
        array.add(elem);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.134 -0500", hash_original_method = "89100BC351666DED1BC5DAB11AB3C4DD", hash_generated_method = "89100BC351666DED1BC5DAB11AB3C4DD")
    
TypeVariable<?>[] getArray() {
        TypeVariable<?>[] a = new TypeVariable[array.size()];
        return array.toArray(a);
    }
}

