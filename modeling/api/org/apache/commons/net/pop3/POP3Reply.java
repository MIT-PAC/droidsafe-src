/*
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net.pop3;

/***
 * POP3Reply stores POP3 reply code constants.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class POP3Reply
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.725 -0500", hash_original_field = "AE73E45FFFE246F04DC13AA08C45502F", hash_generated_field = "1296A134D8809C2E1C6CA9743251C0A8")

    public static int OK = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.728 -0500", hash_original_field = "978AE58344B7583D6BC144F01B4A89F4", hash_generated_field = "94835814EA56D90439E06CDEF5B27450")

    public static int ERROR = 1;

    // Cannot be instantiated.
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.731 -0500", hash_original_method = "D31481D2F9208B7F32B889BFCE88134D", hash_generated_method = "C6A072065C11097F0B6D6856979C0AED")
    
private POP3Reply()
    {}
}
