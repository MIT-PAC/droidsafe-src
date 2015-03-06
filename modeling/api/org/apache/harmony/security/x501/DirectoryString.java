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

/**
* @author Alexander Y. Kleymenov
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;

public final class DirectoryString {

    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.725 -0400", hash_original_field = "E7E2E2A95D92BDA7E2FD183733591C19", hash_generated_field = "9D15DB0196D54BA7CB009367A7A70C68")

    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
           ASN1StringType.TELETEXSTRING,
           ASN1StringType.PRINTABLESTRING,
           ASN1StringType.UNIVERSALSTRING,
           ASN1StringType.UTF8STRING,
           ASN1StringType.BMPSTRING }) {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.783 -0500", hash_original_method = "B50919D6E7CA13884A6C9F096964941D", hash_generated_method = "2DAEED78DFC2C3E9F8119D345D247A3C")
        
public int getIndex(java.lang.Object object) {
            return 1; // always code as ASN1 printableString
            //return 4; // always code as ASN1 utf8String
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:54.785 -0500", hash_original_method = "75F68B3A16DBDA02F9B0A49BA52B584E", hash_generated_method = "C5D20895330F23B0CE04BF0739FBC835")
        
public Object getObjectToEncode(Object object) {
            return /*(String)*/ object;
        }
    };
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.725 -0400", hash_original_method = "53F57E3BE98311F5CEA26B08849D5BFD", hash_generated_method = "53F57E3BE98311F5CEA26B08849D5BFD")
    public DirectoryString ()
    {
        //Synthesized constructor
    }
    // orphaned legacy method
    public int getIndex(java.lang.Object object) {
            return 1;
            
        }
    
    // orphaned legacy method
    public Object getObjectToEncode(Object object) {
            return  object;
        }
    
}

