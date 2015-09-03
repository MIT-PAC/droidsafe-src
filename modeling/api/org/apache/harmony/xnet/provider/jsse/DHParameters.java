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


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class DHParameters {

    /**
     * Returns prime bytes
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.543 -0500", hash_original_method = "5A0A21527AD2CDDB88C677469F0B4186", hash_generated_method = "40FF0E36783A0A5E664E968CC3D7885A")
    
public static byte[] getPrime() {
        return prime;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.531 -0500", hash_original_field = "B0AD8BBBE6A3105790A28C08BBAA1B04", hash_generated_field = "0623B04222DE03635B36EFA39C6B3CFE")

    // http://news.hping.org/sci.crypt.archive/2370.html
    private static byte[] prime512 = new byte[] { (byte) 0xF5, (byte) 0x2A, (byte) 0xFF,
            (byte) 0x3C, (byte) 0xE1, (byte) 0xB1, (byte) 0x29, (byte) 0x40,
            (byte) 0x18, (byte) 0x11, (byte) 0x8D, (byte) 0x7C, (byte) 0x84,
            (byte) 0xA7, (byte) 0x0A, (byte) 0x72, (byte) 0xD6, (byte) 0x86,
            (byte) 0xC4, (byte) 0x03, (byte) 0x19, (byte) 0xC8, (byte) 0x07,
            (byte) 0x29, (byte) 0x7A, (byte) 0xCA, (byte) 0x95, (byte) 0x0C,
            (byte) 0xD9, (byte) 0x96, (byte) 0x9F, (byte) 0xAB, (byte) 0xD0,
            (byte) 0x0A, (byte) 0x50, (byte) 0x9B, (byte) 0x02, (byte) 0x46,
            (byte) 0xD3, (byte) 0x08, (byte) 0x3D, (byte) 0x66, (byte) 0xA4,
            (byte) 0x5D, (byte) 0x41, (byte) 0x9F, (byte) 0x9C, (byte) 0x7C,
            (byte) 0xBD, (byte) 0x89, (byte) 0x4B, (byte) 0x22, (byte) 0x19,
            (byte) 0x26, (byte) 0xBA, (byte) 0xAB, (byte) 0xA2, (byte) 0x5E,
            (byte) 0xC3, (byte) 0x55, (byte) 0xE9, (byte) 0x2A, (byte) 0x05,
            (byte) 0x5F };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.534 -0500", hash_original_field = "0BB65DE81EEF340133812EBB996EB759", hash_generated_field = "4509DAA58AF8D72B04DA8472AD38C8B5")

    // (http://www.ietf.org/rfc/rfc2539.txt?number=2539)
    private static byte[] primeGroup1 = { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xC9,
            (byte) 0x0F, (byte) 0xDA, (byte) 0xA2, (byte) 0x21, (byte) 0x68,
            (byte) 0xC2, (byte) 0x34, (byte) 0xC4, (byte) 0xC6, (byte) 0x62,
            (byte) 0x8B, (byte) 0x80, (byte) 0xDC, (byte) 0x1C, (byte) 0xD1,
            (byte) 0x29, (byte) 0x02, (byte) 0x4E, (byte) 0x08, (byte) 0x8A,
            (byte) 0x67, (byte) 0xCC, (byte) 0x74, (byte) 0x02, (byte) 0x0B,
            (byte) 0xBE, (byte) 0xA6, (byte) 0x3B, (byte) 0x13, (byte) 0x9B,
            (byte) 0x22, (byte) 0x51, (byte) 0x4A, (byte) 0x08, (byte) 0x79,
            (byte) 0x8E, (byte) 0x34, (byte) 0x04, (byte) 0xDD, (byte) 0xEF,
            (byte) 0x95, (byte) 0x19, (byte) 0xB3, (byte) 0xCD, (byte) 0x3A,
            (byte) 0x43, (byte) 0x1B, (byte) 0x30, (byte) 0x2B, (byte) 0x0A,
            (byte) 0x6D, (byte) 0xF2, (byte) 0x5F, (byte) 0x14, (byte) 0x37,
            (byte) 0x4F, (byte) 0xE1, (byte) 0x35, (byte) 0x6D, (byte) 0x6D,
            (byte) 0x51, (byte) 0xC2, (byte) 0x45, (byte) 0xE4, (byte) 0x85,
            (byte) 0xB5, (byte) 0x76, (byte) 0x62, (byte) 0x5E, (byte) 0x7E,
            (byte) 0xC6, (byte) 0xF4, (byte) 0x4C, (byte) 0x42, (byte) 0xE9,
            (byte) 0xA6, (byte) 0x3A, (byte) 0x36, (byte) 0x20, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.538 -0500", hash_original_field = "100B94C4516FA5215F242669ECB23FEC", hash_generated_field = "8319E6B27737DB6E247EA6365F56E9BE")

    // (http://www.ietf.org/rfc/rfc2539.txt?number=2539)
    private static byte[] primeGroup2 = { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xC9,
            (byte) 0x0F, (byte) 0xDA, (byte) 0xA2, (byte) 0x21, (byte) 0x68,
            (byte) 0xC2, (byte) 0x34, (byte) 0xC4, (byte) 0xC6, (byte) 0x62,
            (byte) 0x8B, (byte) 0x80, (byte) 0xDC, (byte) 0x1C, (byte) 0xD1,
            (byte) 0x29, (byte) 0x02, (byte) 0x4E, (byte) 0x08, (byte) 0x8A,
            (byte) 0x67, (byte) 0xCC, (byte) 0x74, (byte) 0x02, (byte) 0x0B,
            (byte) 0xBE, (byte) 0xA6, (byte) 0x3B, (byte) 0x13, (byte) 0x9B,
            (byte) 0x22, (byte) 0x51, (byte) 0x4A, (byte) 0x08, (byte) 0x79,
            (byte) 0x8E, (byte) 0x34, (byte) 0x04, (byte) 0xDD, (byte) 0xEF,
            (byte) 0x95, (byte) 0x19, (byte) 0xB3, (byte) 0xCD, (byte) 0x3A,
            (byte) 0x43, (byte) 0x1B, (byte) 0x30, (byte) 0x2B, (byte) 0x0A,
            (byte) 0x6D, (byte) 0xF2, (byte) 0x5F, (byte) 0x14, (byte) 0x37,
            (byte) 0x4F, (byte) 0xE1, (byte) 0x35, (byte) 0x6D, (byte) 0x6D,
            (byte) 0x51, (byte) 0xC2, (byte) 0x45, (byte) 0xE4, (byte) 0x85,
            (byte) 0xB5, (byte) 0x76, (byte) 0x62, (byte) 0x5E, (byte) 0x7E,
            (byte) 0xC6, (byte) 0xF4, (byte) 0x4C, (byte) 0x42, (byte) 0xE9,
            (byte) 0xA6, (byte) 0x37, (byte) 0xED, (byte) 0x6B, (byte) 0x0B,
            (byte) 0xFF, (byte) 0x5C, (byte) 0xB6, (byte) 0xF4, (byte) 0x06,
            (byte) 0xB7, (byte) 0xED, (byte) 0xEE, (byte) 0x38, (byte) 0x6B,
            (byte) 0xFB, (byte) 0x5A, (byte) 0x89, (byte) 0x9F, (byte) 0xA5,
            (byte) 0xAE, (byte) 0x9F, (byte) 0x24, (byte) 0x11, (byte) 0x7C,
            (byte) 0x4B, (byte) 0x1F, (byte) 0xE6, (byte) 0x49, (byte) 0x28,
            (byte) 0x66, (byte) 0x51, (byte) 0xEC, (byte) 0xE6, (byte) 0x53,
            (byte) 0x81, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.540 -0500", hash_original_field = "14702BAE11A1A43483F11F4A56766F60", hash_generated_field = "E308A45DAEAECF2B8BCC430FCFA81CB6")

    private static byte[] prime;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.409 -0400", hash_original_method = "808CB0297624A41B24EE6EECFB636C09", hash_generated_method = "808CB0297624A41B24EE6EECFB636C09")
    public DHParameters ()
    {
        //Synthesized constructor
    }
    static {
        prime = prime512;
    }
    
}

