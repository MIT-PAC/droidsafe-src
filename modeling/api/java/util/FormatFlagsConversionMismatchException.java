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

public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.596 -0500", hash_original_field = "1D47537BFEDD1D5CD10CEAB7FF89B2CC", hash_generated_field = "7B2DE80EAB584F9CC96F84F00ED41767")

    private static final long serialVersionUID = 19120414L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.598 -0500", hash_original_field = "63BC8A515FA40187EB689315E9499B4D", hash_generated_field = "30060080FF41A1FD21A71F3606BA90A8")

    private  String f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.600 -0500", hash_original_field = "7DEFA5881D592344AB5D4C2684DE1F7D", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private  char c;

    /**
     * Constructs a new {@code FormatFlagsConversionMismatchException} with the
     * flags and conversion specified.
     *
     * @param f
     *           the flags.
     * @param c
     *           the conversion.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.603 -0500", hash_original_method = "23601B02BC801B28ADE07C396E4C34FF", hash_generated_method = "63347355FC94ACD3FDFABA214AAB07C9")
    
public FormatFlagsConversionMismatchException(String f, char c) {
        if (f == null) {
            throw new NullPointerException();
        }
        this.f = f;
        this.c = c;
    }

    /**
     * Returns the incompatible format flag.
     *
     * @return the incompatible format flag.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.605 -0500", hash_original_method = "3582970EABB5B296536802E98213C512", hash_generated_method = "A71527FD2C89DAA2C9521A9786BC25FE")
    
public String getFlags() {
        return f;
    }

    /**
     * Returns the incompatible conversion.
     *
     * @return the incompatible conversion.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.608 -0500", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "A01009E7FAC2235AB14D99D1342E319D")
    
public char getConversion() {
        return c;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.612 -0500", hash_original_method = "767287C022ACF72AAFFBED8242F4CC5C", hash_generated_method = "1F22EDA272F75C3502E6A58A746CB24B")
    
@Override
    public String getMessage() {
        return "%" + c + " does not support '" + f + "'";
    }
}

