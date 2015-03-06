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
* @author Vladimir N. Molotkov
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class ASN1UTCTime extends ASN1Time {

    /**
     * Returns ASN.1 UTCTime type default implementation
     *
     * The default implementation works with encoding
     * that is represented as Date object.
     *
     * @return ASN.1 UTCTime type default implementation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.569 -0500", hash_original_method = "88789DA35EC0F29C4ECE5348C3C6879B", hash_generated_method = "92C7BBDA37B2445AD79175E4A83E872F")
    
public static ASN1UTCTime getInstance() {
        return ASN1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.555 -0500", hash_original_field = "4069917F415747540D93692073627B5C", hash_generated_field = "C99E1AA1FD0B98FDECC7113FF17AD5A9")

    public static final int UTC_HM = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.557 -0500", hash_original_field = "7F62C7537716F28B81458DD1DE0C1566", hash_generated_field = "43229A41614441B305939A18D625BBBF")

    public static final int UTC_HMS = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.559 -0500", hash_original_field = "2D059F5FE28011BAB077416B02341751", hash_generated_field = "E277939BD96AECE8361F57CC38430D51")

    public static final int UTC_LOCAL_HM = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.562 -0500", hash_original_field = "5D318A9688FB154490AB8D79FC9959C6", hash_generated_field = "F6B17A8829ED2792E001CCEF650A209D")

    public static final int UTC_LOCAL_HMS = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.564 -0500", hash_original_field = "ACA52E9A89A23523716FB9DDDEA34915", hash_generated_field = "AFEE81C8342C509C7B7E0180DFF588E9")

    private static final ASN1UTCTime ASN1 = new ASN1UTCTime();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.578 -0500", hash_original_field = "36C4C98028F9132A2F0BF6CFA8C36767", hash_generated_field = "53E6E0ED45D4C94E454C5041DA00475B")

    //
    // According to X.680 coordinated universal time format:
    // two digit year, seconds always presented,
    // no fractional-seconds elements, 'Z' at the end
    private static final String UTC_PATTERN = "yyMMddHHmmss'Z'";

    /**
     * Constructs ASN.1 UTCTime type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 UTCTime type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.567 -0500", hash_original_method = "26950815C4CFBBF28A3CFECAD840C50B", hash_generated_method = "86C9598356A193D1F9A9F222507B558C")
    
public ASN1UTCTime() {
        super(TAG_UTCTIME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.572 -0500", hash_original_method = "A91CD5C6AC359830199B04A7EA591A03", hash_generated_method = "889F4D8B0F38B0D01608B563191B2465")
    
@Override public Object decode(BerInputStream in) throws IOException {
        in.readUTCTime();

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.575 -0500", hash_original_method = "7E6261B78AC933A3E78C661A729AB3E3", hash_generated_method = "A5B5E54D7B1D4255E6C88F87902E66E6")
    
@Override public void encodeContent(BerOutputStream out) {
        out.encodeUTCTime();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.581 -0500", hash_original_method = "DF1F65526ADDCB7D66CE158126525DF9", hash_generated_method = "788569727504E38F0D5DDEE9ADB4A6E3")
    
@Override public void setEncodingContent(BerOutputStream out) {
        SimpleDateFormat sdf = new SimpleDateFormat(UTC_PATTERN);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        out.content = sdf.format(out.content).getBytes(Charsets.UTF_8);
        out.length = ((byte[]) out.content).length;
    }
}

