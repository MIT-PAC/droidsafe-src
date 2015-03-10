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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public abstract class Permission implements Guard, Serializable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.121 -0500", hash_original_method = "A3ABD4D844A912132701BDB49CC172D4", hash_generated_method = "FEB85F07824311712D827DF553B65F8F")
    
public Permission(String name) { }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SECURITY_INFO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.123 -0500", hash_original_method = "BD1D69B57EF82CC836CADC372B210DA8", hash_generated_method = "1FEC139DF0BDEA5B2B34BC8A24D414EF")
    
public final String getName() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.127 -0500", hash_original_method = "C84962AC42FE97CD37014EB04A226348", hash_generated_method = "9EFCB6759A3AA73FFE07BE8351A09694")
    
public void checkGuard(Object obj) throws SecurityException { }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.129 -0500", hash_original_method = "3B418AF4D3F113F25455A16498EE96FC", hash_generated_method = "72CEE043BC58F57AADD951EAAC71C1D6")
    
public PermissionCollection newPermissionCollection() {
        return new AllPermissionCollection();
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.132 -0500", hash_original_method = "29B5CE65D8821EF2AD74234125DFF7AA", hash_generated_method = "9CF50528387D48395BA46B8306AF52D6")
    
public abstract String getActions();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.134 -0500", hash_original_method = "EFDD42BDCC8AFC7DB3076C40E1EA19C3", hash_generated_method = "7DCD9075AD00F391A9B7B11ED234E399")
    
public abstract boolean implies(Permission permission);
    
}

