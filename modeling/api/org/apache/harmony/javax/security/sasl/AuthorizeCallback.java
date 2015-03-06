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


package org.apache.harmony.javax.security.sasl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;
import org.apache.harmony.javax.security.auth.callback.Callback;

public class AuthorizeCallback implements Callback, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.571 -0400", hash_original_field = "5A148F52DF250353BDABD5DDADB69D99", hash_generated_field = "B3677B3051BD517EDA47C3D5172960D7")


    private static final long serialVersionUID = -2353344186490470805L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.571 -0400", hash_original_field = "26A3B19BC4B2989FF37C1A8FE074E3EA", hash_generated_field = "9FBFC911F8AB1588C9163140EACBF422")

    private  String authenticationID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.572 -0400", hash_original_field = "637D0D1A5F876511791F70072F81AC34", hash_generated_field = "B0945085C1ED9DAB2890A06C7CEBC5C9")

    private  String authorizationID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.572 -0400", hash_original_field = "ED8F97C68A2D68EBBC718CA8094ED9E6", hash_generated_field = "D73C105B00B501DB14A5F9F7B242A9DE")

    private String authorizedID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.573 -0400", hash_original_field = "E558A8679F6D6A91E58084B64CC763AD", hash_generated_field = "B04A0070948EC42029C15DF5E1E9DB74")

    private boolean authorized;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.573 -0400", hash_original_method = "F61E44539AB66F678AF4A3F9B3E470AF", hash_generated_method = "D2B9D53339FFF1CB9845D79D656B9BEB")
    
public AuthorizeCallback(String authnID, String authzID) {
        super();
        authenticationID = authnID;
        authorizationID = authzID;
        authorizedID = authzID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.574 -0400", hash_original_method = "089681706AB7C5DB2369560C4B4A39D2", hash_generated_method = "5A390236778EA5E1EB114F88185FF097")
    
public String getAuthenticationID() {
        return authenticationID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.574 -0400", hash_original_method = "951E423A61529776418B444F9EC4F937", hash_generated_method = "9E01C7AC5D01E8FE194D0616E75B6BF0")
    
public String getAuthorizationID() {
        return authorizationID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.575 -0400", hash_original_method = "A40E3D9EA8E64723C223B146C8DDA98E", hash_generated_method = "1146E3F0BF375E4C17B89D04AC50E41C")
    
public String getAuthorizedID() {
        return (authorized ? authorizedID : null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.575 -0400", hash_original_method = "5186CDA82D4FFEC89D266270E5688AA9", hash_generated_method = "730862D08C361AE79E46932486C532A0")
    
public boolean isAuthorized() {
        return authorized;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.576 -0400", hash_original_method = "DECB709C121B5C6CAA4C63B6A5DF4720", hash_generated_method = "878754024655B18D2C1BFA65ADE085EF")
    
public void setAuthorized(boolean ok) {
        authorized = ok;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.576 -0400", hash_original_method = "8EDE6BCEC4AD82F32E7766B3FE3DDCDB", hash_generated_method = "0F39D11A80C5FD80D7800A54B1453AEF")
    
public void setAuthorizedID(String id) {
        if (id != null) {
            authorizedID = id;
        }
    }
}
