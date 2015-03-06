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
import java.io.Serializable;

public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.418 -0500", hash_original_field = "1BB64411CE2C82F526EDC7EC1A02E1CC", hash_generated_field = "25B9B9FD75AC3506217DC397F5D20733")

    private static final long serialVersionUID = 17000126L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.420 -0500", hash_original_field = "7DEFA5881D592344AB5D4C2684DE1F7D", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private  char c;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.424 -0500", hash_original_field = "B3DDF44BEA90EBB229C8217DB24F6E20", hash_generated_field = "2ECA6A70BD4E757E3F8651900978568C")

    private  Class<?> arg;

    /**
     * Constructs a new {@code IllegalFormatConversionException} with the class
     * of the mismatched conversion and corresponding parameter.
     *
     * @param c
     *           the class of the mismatched conversion.
     * @param arg
     *           the corresponding parameter.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.426 -0500", hash_original_method = "0438EEFB69B3388326CD0DDEA30A5038", hash_generated_method = "7C2405B3E2DB77423CC05BE2D30DEE47")
    
public IllegalFormatConversionException(char c, Class<?> arg) {
        this.c = c;
        if (arg == null) {
            throw new NullPointerException();
        }
        this.arg = arg;
    }

    /**
     * Returns the class of the mismatched parameter.
     *
     * @return the class of the mismatched parameter.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.429 -0500", hash_original_method = "F6AB4FB57CDBF80A2EA14BA003E8B6E3", hash_generated_method = "86946FDB0EF9612D985BF1B5238E7B31")
    
public Class<?> getArgumentClass() {
        return arg;
    }

    /**
     * Returns the incompatible conversion.
     *
     * @return the incompatible conversion.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.431 -0500", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "A01009E7FAC2235AB14D99D1342E319D")
    
public char getConversion() {
        return c;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.433 -0500", hash_original_method = "F4CE0F8EC3805161966118C119A25B11", hash_generated_method = "A115DD607857A62D4CFD586C57126BA6")
    
@Override
    public String getMessage() {
        return "%" + c + " can't format " + arg.getName() + " arguments";
    }
}

