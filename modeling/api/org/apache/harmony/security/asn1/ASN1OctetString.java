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
* @author Vladimir N. Molotkov, Stepan M. Mishura
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Arrays;

public class ASN1OctetString extends ASN1StringType {

    /**
     * Returns ASN.1 octet string type default implementation
     *
     * The default implementation works with encoding
     * that is represented as byte array.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.965 -0500", hash_original_method = "F77C5F3582B223C2ECF09C45F802AA0C", hash_generated_method = "374FB482A9F4BD4CF808640CD919DEF5")
    
public static ASN1OctetString getInstance() {
        return ASN1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.960 -0500", hash_original_field = "619AC1C12C02F4C1DB819DA5FD37CB4A", hash_generated_field = "BBC2F7EF6217ADF6A8ED0EF7FBD1ADB4")

    private static final ASN1OctetString ASN1 = new ASN1OctetString();

    /**
     * Constructs ASN.1 octet string type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 octet string type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.963 -0500", hash_original_method = "FE8C061A61754FEAD4E80D2F91CDD232", hash_generated_method = "9BC78B95E5579B87EF4717DF3A05097B")
    
public ASN1OctetString() {
        super(TAG_OCTETSTRING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.968 -0500", hash_original_method = "28376DFC29A2213C4817BE9D28454968", hash_generated_method = "D52F93EDBB3C86D8A27C1CEDE36B2E4B")
    
@Override public Object decode(BerInputStream in) throws IOException {
        in.readOctetString();

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    /**
     * Extracts array of bytes from BER input stream.
     *
     * @return array of bytes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.971 -0500", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "97033F5FC3E52425F6CF50D667821545")
    
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
        return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.973 -0500", hash_original_method = "612A16573B17613AF81AE7469C8D7FB4", hash_generated_method = "F921B2DFEAEC13798795DCF6CC1E5F34")
    
@Override public void encodeContent(BerOutputStream out) {
        out.encodeOctetString();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.976 -0500", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "180CA1AEB1CE9F7B268BC78AC57F4A6B")
    
@Override public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
    }
}

