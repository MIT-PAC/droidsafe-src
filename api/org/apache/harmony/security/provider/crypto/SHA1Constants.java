/*
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
* @author Yuri A. Kropachev
* @version $Revision$
*/


package org.apache.harmony.security.provider.crypto;


/**
 * This interface contains : <BR>
 * - a set of constant values, H0-H4, defined in "SECURE HASH STANDARD", FIPS PUB 180-2 ;<BR>
 * - implementation constant values to use in classes using SHA-1 algorithm.    <BR>
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class SHA1Constants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.993 -0400", hash_original_field = "755D7F7948AE2142BB89193BB24E181F", hash_generated_field = "E744081B6FDC330E0FD03FE3A83E9BF5")

    public static final int H0 = 0x67452301;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.993 -0400", hash_original_field = "28D53651578D9B25EBC719F37F6F42FE", hash_generated_field = "72294353794574E65830DE332FF39991")

    public static final int H1 = 0xEFCDAB89;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.994 -0400", hash_original_field = "F8E0237D927F2473BE55E0D8D3AE7EB4", hash_generated_field = "CD193D752B0C4C5BC512CDB95C6699AC")

    public static final int H2 = 0x98BADCFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.995 -0400", hash_original_field = "7FB552A64123D93EB3E64170721D1380", hash_generated_field = "A45589CA879588AFCB6A03FE571C28AE")

    public static final int H3 = 0x10325476;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.995 -0400", hash_original_field = "A6D719FC722CB432BAF67B2DFD60C932", hash_generated_field = "5BDE4676D9630D0B1042715A075D763C")

    public static final int H4 = 0xC3D2E1F0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.996 -0400", hash_original_field = "C305C0B0E8C10AC7072CD9E44204305F", hash_generated_field = "5DB3A999E68B0EDA0D0B2380375AC806")

    public static final int BYTES_OFFSET = 81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.996 -0400", hash_original_field = "1CDC7D6481401BA76CC7814D2C8ABF38", hash_generated_field = "2E23F5581D315651311934C1B467D2BC")

    public static final int HASH_OFFSET = 82;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.996 -0400", hash_original_field = "9301F8BE56680C2B760E8B6165DCF050", hash_generated_field = "F5A927077A9297D41B7BFC3CA91D71F1")

    public static final int DIGEST_LENGTH = 20;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.992 -0400", hash_original_method = "9B5AB0BDAAB80249EE30DB287D697B74", hash_generated_method = "20BD8AC5D3280A3ADC3010AEA3D8B4D1")
    
private SHA1Constants() {
    }
}
