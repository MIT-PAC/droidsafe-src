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
import java.io.IOException;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BerOutputStream;

public final class ReasonFlags {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.528 -0500", hash_original_field = "988CE29797D9C71ABAADD708314B7A21", hash_generated_field = "348B9970CC87333497E0122E357CC7BA")

    static final String[] REASONS = {
        "unused",
        "keyCompromise",
        "cACompromise",
        "affiliationChanged",
        "superseded",
        "cessationOfOperation",
        "certificateHold",
        "privilegeWithdrawn",
        "aACompromise"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.689 -0400", hash_original_field = "57F71CEED326110CDAC13EC2F1222EE2", hash_generated_field = "9A6C9509CE1B547AF3B36185903C2664")

    public static final ASN1BitString ASN1 =
                            new ASN1BitString.ASN1NamedBitList(REASONS.length) {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.538 -0500", hash_original_method = "31573B2F4CCD62BF50FDA97899BAB266", hash_generated_method = "5FABEF048C285457771625592165A3A0")
        
public Object getDecodedObject(BerInputStream in) throws IOException {
            return new ReasonFlags((boolean[]) super.getDecodedObject(in));
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.541 -0500", hash_original_method = "7CAEE2990EB6DF6257751BA848966F42", hash_generated_method = "52E4D1960D48A19C26A58844945CA40F")
        
public void setEncodingContent(BerOutputStream out) {
            out.content = ((ReasonFlags) out.content).flags;
            super.setEncodingContent(out);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.530 -0500", hash_original_field = "061396171076FD7FDA3FE013F4084C7F", hash_generated_field = "EDA6943CEE7FB962748614E813BD6977")

    private  boolean[] flags;

    /**
     * Creates the extension object corresponding to the given flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.532 -0500", hash_original_method = "0723455182874DC076BEC16F53F1DAFE", hash_generated_method = "E9ED7C304D8EC41D1D7DA7A897DA5FCA")
    
public ReasonFlags(boolean[] flags) {
        this.flags = flags;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.535 -0500", hash_original_method = "4426D7C44C68FE2DDBEE0B08652B6069", hash_generated_method = "4C84393F712D762C5A5C19DFE9F55A70")
    
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix);
        sb.append("ReasonFlags [\n");
        for (int i=0; i<flags.length; i++) {
            if (flags[i]) {
                sb.append(prefix).append("  ").append(REASONS[i]).append('\n');
            }
        }
        sb.append(prefix);
        sb.append("]\n");
    }
}

