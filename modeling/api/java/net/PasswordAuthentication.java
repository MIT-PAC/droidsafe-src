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


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class PasswordAuthentication {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.452 -0500", hash_original_field = "603671BF518F3A411771AE6211095177", hash_generated_field = "4011AE72656FEC39CB60833262E361C8")

    private String userName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.454 -0500", hash_original_field = "21BCD293DE862031F898430214E88677", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;

    /**
     * Creates an instance of a password authentication with a specified
     * username and password.
     *
     * @param userName
     *            the username to store.
     * @param password
     *            the associated password to store.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.457 -0500", hash_original_method = "5D7214C35F0B8EFCD4776395D10A0F27", hash_generated_method = "29ACC9DE2D8A4C1B8CFCE6AA59A2D59D")
    
public PasswordAuthentication(String userName, char[] password) {
        this.userName = userName;
        this.password = password.clone();
    }

    /**
     * Gets a clone of the password stored by this instance. The user is
     * responsible to finalize the returned array if the password clone is no
     * longer needed.
     *
     * @return the copied password.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.459 -0500", hash_original_method = "79A6CAB64FA4B390A39CA60FAD9B839D", hash_generated_method = "C814E988AE5D6DF03B812A5ABE48A46E")
    
public char[] getPassword() {
        return password.clone();
    }

    /**
     * Gets the username stored by this instance.
     *
     * @return the stored username.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.461 -0500", hash_original_method = "AE8C8ADC981355D9DAA86F7D72E53644", hash_generated_method = "A531C69D4F950205F39A1FFF6AFE3034")
    
public String getUserName() {
        return userName;
    }
    
}

