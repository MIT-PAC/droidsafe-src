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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/auth/NTCredentials.java $
 * $Revision: 658430 $
 * $Date: 2008-05-20 14:04:27 -0700 (Tue, 20 May 2008) $
 *
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.auth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.Principal;
import java.util.Locale;

import org.apache.http.util.LangUtils;

/** {@link Credentials} specific to the Windows platform.
 *
 * @author <a href="mailto:adrian@ephox.com">Adrian Sutton</a>
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @since 2.0
 */
public class NTCredentials implements Credentials {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.699 -0400", hash_original_field = "B3D8170BF3FA6017E9A8683298E339B4", hash_generated_field = "58DDFAB707F4D9CE9CAD7B756F00E766")

    private  NTUserPrincipal principal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.701 -0400", hash_original_field = "2AFEDC818D0EF3384B2D2537704E6E21", hash_generated_field = "690A5FCB6F6469C4B045B751039E14AE")

    private  String password;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.702 -0400", hash_original_field = "B8F45B2DE92630644C2FA786D0F2035E", hash_generated_field = "6E623614311DC2587CEE055F3EE10467")

    private  String workstation;

    /**
     * The constructor with the fully qualified username and password combined 
     * string argument.
     *
     * @param usernamePassword the domain/username:password formed string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.704 -0400", hash_original_method = "9609D9570BF4235BFFC4E536CB173E6B", hash_generated_method = "E6C33FE88300259EC35A2A0FAAAAFF61")
    
public NTCredentials(String usernamePassword) {
        super();
        if (usernamePassword == null) {
            throw new IllegalArgumentException("Username:password string may not be null");            
        }
        String username;
        int atColon = usernamePassword.indexOf(':');
        if (atColon >= 0) {
            username = usernamePassword.substring(0, atColon);
            this.password = usernamePassword.substring(atColon + 1);
        } else {
            username = usernamePassword;
            this.password = null;
        }
        int atSlash = username.indexOf('/');
        if (atSlash >= 0) {
            this.principal = new NTUserPrincipal(
                    username.substring(0, atSlash).toUpperCase(Locale.ENGLISH),
                    username.substring(atSlash + 1));
        } else {
            this.principal = new NTUserPrincipal(
                    null,
                    username.substring(atSlash + 1));
        }
        this.workstation = null;
    }

    /**
     * Constructor.
     * @param userName The user name.  This should not include the domain to authenticate with.
     * For example: "user" is correct whereas "DOMAIN\\user" is not.
     * @param password The password.
     * @param workstation The workstation the authentication request is originating from. 
     * Essentially, the computer name for this machine.
     * @param domain The domain to authenticate within.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.705 -0400", hash_original_method = "31A685D82AD7D28E6A7F5369B506B9A9", hash_generated_method = "C59339468271A0E8AA46DA0CF9889BBD")
    
public NTCredentials(
            final String userName, 
            final String password, 
            final String workstation,
            final String domain) {
        super();
        if (userName == null) {
            throw new IllegalArgumentException("User name may not be null");
        }
        this.principal = new NTUserPrincipal(domain, userName);
        this.password = password;
        if (workstation != null) {
            this.workstation = workstation.toUpperCase(Locale.ENGLISH);
        } else {
            this.workstation = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.707 -0400", hash_original_method = "BB172E7710F2C6896B8F9EADD44CB225", hash_generated_method = "A41C8FC17036BC805EB11F650E75E163")
    
public Principal getUserPrincipal() {
        return this.principal;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.708 -0400", hash_original_method = "549EF64F86147FBBC98B5D4D9F81ED47", hash_generated_method = "2D24FAE6D7F86B46B87A4CE1CB8879AC")
    
public String getUserName() {
        return this.principal.getUsername();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.709 -0400", hash_original_method = "E2BBA183CFC1CE77B80696AB85A99CB9", hash_generated_method = "0C0404DED9C8FA09BBCD0EFBDC5C30D1")
    
public String getPassword() {
        return this.password;
    }

    /**
     * Retrieves the name to authenticate with.
     *
     * @return String the domain these credentials are intended to authenticate with.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.710 -0400", hash_original_method = "FD565F46F9C3EF92C68963EC78A3D613", hash_generated_method = "5D48CBA53355351970FBBCFA84D610AE")
    
public String getDomain() {
        return this.principal.getDomain();
    }

    /**
     * Retrieves the workstation name of the computer originating the request.
     *
     * @return String the workstation the user is logged into.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.711 -0400", hash_original_method = "BBCD80C739478A0F1068E1240F0B8CD5", hash_generated_method = "A752DA36D40430A9E9EF44BC18DDBD9E")
    
public String getWorkstation() {
        return this.workstation;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.713 -0400", hash_original_method = "CF7E1A4AAA9B9D03F5C13126C7F00890", hash_generated_method = "496CE9593EB2FB939910F0885D49DA47")
    
@Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.principal);
        hash = LangUtils.hashCode(hash, this.workstation);
        return hash;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.714 -0400", hash_original_method = "51436E4149B840F18A9CD829BA6445C0", hash_generated_method = "AC967CBFF39CCC29DBA0C91A4ADF1778")
    
@Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (o instanceof NTCredentials) {
            NTCredentials that = (NTCredentials) o;
            if (LangUtils.equals(this.principal, that.principal)
                    && LangUtils.equals(this.workstation, that.workstation)) {
                return true;
            }
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.716 -0400", hash_original_method = "4A07E0A2942A85105EC73452BBD0D184", hash_generated_method = "1545E990B649D5D016F977926CCEF2E9")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[principal: ");
        buffer.append(this.principal);
        buffer.append("][workstation: ");
        buffer.append(this.workstation);
        buffer.append("]");
        return buffer.toString();
    }

}
