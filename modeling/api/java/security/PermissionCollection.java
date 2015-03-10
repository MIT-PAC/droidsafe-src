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
import java.util.Enumeration;

public abstract class PermissionCollection implements Serializable {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.124 -0400", hash_original_method = "9068D0108294B13066862778786146D9", hash_generated_method = "9068D0108294B13066862778786146D9")
    public PermissionCollection ()
    {
        //Synthesized constructor
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.049 -0500", hash_original_method = "A893CEBA2C1B71EC9B6720287A34E992", hash_generated_method = "51058B02CF300A57D579EC9F1DE7873E")
    
public abstract void add(Permission permission);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.052 -0500", hash_original_method = "F81820C7A45D25FB2ECB06B8428FC1F6", hash_generated_method = "DAB6A40E19EF8A6639F31AB37799F968")
    
public abstract Enumeration<Permission> elements();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.054 -0500", hash_original_method = "EFDD42BDCC8AFC7DB3076C40E1EA19C3", hash_generated_method = "7DCD9075AD00F391A9B7B11ED234E399")
    
public abstract boolean implies(Permission permission);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.057 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "2994F1C62F4372688739CAB83B342357")
    
public boolean isReadOnly() { return true; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.059 -0500", hash_original_method = "32FE512F278ECF7FA2513E0F8F8332CC", hash_generated_method = "B136FF95B5A3D3070009D24507706350")
    
public void setReadOnly() { }
    
}

