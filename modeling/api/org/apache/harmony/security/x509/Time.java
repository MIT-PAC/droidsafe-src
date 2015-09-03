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


package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.ASN1UTCTime;

public final class Time {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.851 -0500", hash_original_field = "60242AE01E95CBC9C36412DAF548E178", hash_generated_field = "A147BD616196E23C70F2EDFA7D6297B4")

    private static final long JAN_01_2050 = 2524608000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.950 -0400", hash_original_field = "D4CE7ED758AC0A209131DFF4462353A2", hash_generated_field = "E0A02F87CBE396A8FFA512F3071B8CD6")

    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
            ASN1GeneralizedTime.getInstance(), ASN1UTCTime.getInstance() }) {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.854 -0500", hash_original_method = "27F8E5451C765B5FECADBB8DC1A06F26", hash_generated_method = "7D96EE05A3E416D1467EAF698386C5B2")
        
public int getIndex(java.lang.Object object) {
            // choose encoding method (see RFC 3280 p. 22)
            if (((java.util.Date) object).getTime() < JAN_01_2050) {
                return 1; // it is before 2050, so encode as UTCTime
            } else {
                return 0; // it is after 2050, encode as GeneralizedTime
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.857 -0500", hash_original_method = "75F68B3A16DBDA02F9B0A49BA52B584E", hash_generated_method = "636A79B73F9AB00153E188E5DD1C5DB2")
        
public Object getObjectToEncode(Object object) {
            return object;
        }
    };
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.949 -0400", hash_original_method = "60A6F367D2F724DF18FDD3D5AB6D0102", hash_generated_method = "60A6F367D2F724DF18FDD3D5AB6D0102")
    public Time ()
    {
        //Synthesized constructor
    }
}

