/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InvalidPropertiesFormatException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.406 -0500", hash_original_field = "362039E2C09E51A13B3A3C4A67C1B751", hash_generated_field = "93913771B2FCBA3B43BB2EE292214671")

    private static final long serialVersionUID = 7763056076009360219L;

    /**
     * Constructs a new {@code InvalidPropertiesFormatException} with the
     * current stack trace and message filled in.
     *
     * @param m
     *           the detail message for the exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.409 -0500", hash_original_method = "00EAAF64B023AA3E2882C7003D2FFD8D", hash_generated_method = "2FB795669C0D2802E0D2036FBFAD9A1D")
    
public InvalidPropertiesFormatException(String m) {
        super(m);
    }

    /**
     * Constructs a new {@code InvalidPropertiesFormatException} with the cause
     * for the Exception.
     *
     * @param c
     *           the cause for the Exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.411 -0500", hash_original_method = "9AA9838C1FE2F17D83D4EAE179EF6104", hash_generated_method = "06080380A5A8481E0B23FB5794C23A34")
    
public InvalidPropertiesFormatException(Throwable c) {
        initCause(c);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.413 -0500", hash_original_method = "D501A96831B009EDE0E99C982A162728", hash_generated_method = "E0E51ABDC4A1C83A34A44CAB91BCD4DF")
    
private void writeObject(ObjectOutputStream out)
            throws NotSerializableException{
        throw new NotSerializableException();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.416 -0500", hash_original_method = "B2CAB4BC3D811DD242C577EA7CF7F980", hash_generated_method = "6DA2B5814233900D0C9799A9B75FF106")
    
private void readObject(ObjectInputStream in)
            throws NotSerializableException{
        throw new NotSerializableException();
    }
}

