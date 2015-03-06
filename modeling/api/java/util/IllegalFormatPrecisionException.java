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

public class IllegalFormatPrecisionException extends IllegalFormatException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.528 -0500", hash_original_field = "41642E06324EC1D917263E5A0302F3E0", hash_generated_field = "0F3B243090780E8B67BC9E9961E78D1C")

    private static final long serialVersionUID = 18711008L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.530 -0500", hash_original_field = "EE1179570100C8E9834DC1ADCE714EC4", hash_generated_field = "ABEFDFA766F5A06D36323240A3BFC77D")

    private  int p;

    /**
     * Constructs a new {@code IllegalFormatPrecisionException} with specified
     * precision.
     *
     * @param p
     *           the precision.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.533 -0500", hash_original_method = "1F9B0D4B155F0DC19F08720A34E7C4BD", hash_generated_method = "56F2E9912160172A9EB81EFCD1BCF16C")
    
public IllegalFormatPrecisionException(int p) {
        this.p = p;
    }

    /**
     * Returns the precision associated with the exception.
     *
     * @return the precision.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.535 -0500", hash_original_method = "B9EA1DC143DCBA676654F6DE1FED4BDB", hash_generated_method = "DF183BBF1373017EFB15F2DD25120416")
    
public int getPrecision() {
        return p;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.537 -0500", hash_original_method = "5619344DED486463EA63A3A2966EBEEE", hash_generated_method = "76BE4486EF1E837DE116691174C5479C")
    
@Override
    public String getMessage() {
        return Integer.toString(p);
    }
}

