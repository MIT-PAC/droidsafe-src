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


package java.security.cert;

/**
 * The parameters to initialize a LDAP {@code CertStore} instance.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class LDAPCertStoreParameters implements CertStoreParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.482 -0400", hash_original_field = "2B881DFB219FC75390CE0A8F9B95275E", hash_generated_field = "5501CC61338225E0965D3A15A1F630B8")

    private static final String DEFAULT_LDAP_SERVER_NAME = "localhost";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.483 -0400", hash_original_field = "E2078D9A2C87D309DD762DF42A9A63F1", hash_generated_field = "929B6AD8AA39C9B7D8AC1E8BFBE74E93")

    private static final int DEFAULT_LDAP_PORT  = 389;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.484 -0400", hash_original_field = "106598BF50A7E4C4F61CD8CC5DDE11AF", hash_generated_field = "D91B41B049D6368CADB5048B1CE2C8E0")

    private  String serverName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.486 -0400", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private  int port;

    /**
     * Creates a new {@code LDAPCertStoreParameters} instance with the specified
     * server name and port.
     *
     * @param serverName
     *            the LDAP server name.
     * @param port
     *            the port.
     * @throws NullPointerException
     *             is {@code serverName} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.487 -0400", hash_original_method = "08089F511AA1667E881FE045B29BAEC9", hash_generated_method = "D9AABC9CA0E9DBC0E88906848D00F32E")
    
public LDAPCertStoreParameters(String serverName, int port) {
        this.port = port;
        this.serverName = serverName;
        if (this.serverName == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Creates a new {@code LDAPCertStoreParameters} instance with default
     * parameters.
     * <p>
     * The default parameters are server name "localhost" and port 389.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.488 -0400", hash_original_method = "4893A08B76D20767C87AEB0DDE3D04DA", hash_generated_method = "3035EB612FDDE40D5F01B167ED939149")
    
public LDAPCertStoreParameters() {
        this.serverName = DEFAULT_LDAP_SERVER_NAME;
        this.port = DEFAULT_LDAP_PORT;
    }

    /**
     * Creates a new {@code LDAPCertStoreParameters} instance with the specified
     * server name and default port 389.
     *
     * @param serverName
     *            the LDAP server name.
     * @throws NullPointerException
     *             if {@code serverName} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.490 -0400", hash_original_method = "98C25B24766EDEA1534126CE47528DB9", hash_generated_method = "47200993D9C2E487FA4ED956EC82D7F6")
    
public LDAPCertStoreParameters(String serverName) {
        this.port = DEFAULT_LDAP_PORT;
        this.serverName = serverName;
        if (this.serverName == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Clones this {@code LDAPCertStoreParameters} instance.
     *
     * @return the cloned instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.492 -0400", hash_original_method = "54040598955C6E8BA382734C61174608", hash_generated_method = "0239CEC56D53D9115DB8BFABFCC35553")
    
public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Returns the LDAP server port.
     *
     * @return the LDAP server port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.493 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8D4984D37D0017078DF4701090E35F25")
    
public int getPort() {
        return port;
    }

    /**
     * Returns the LDAP server name.
     *
     * @return the LDAP server name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.494 -0400", hash_original_method = "32DED34EDBBCFD5F7850D8FCCD12B5DF", hash_generated_method = "C00CFFA3F5DCF81485B496DF2955DD46")
    
public String getServerName() {
        return serverName;
    }

    /**
     * Returns the string representation of this {@code LDAPCertStoreParameters}
     * instance.
     *
     * @return the string representation of this {@code LDAPCertStoreParameters}
     *         instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.496 -0400", hash_original_method = "F31E920D445757BE6DC5480CCE7003E7", hash_generated_method = "688E769EA1135123328F091096F9D3B9")
    
public String toString() {
        StringBuilder sb =
            new StringBuilder("LDAPCertStoreParameters: [\n serverName: ");
        sb.append(getServerName());
        sb.append("\n port: ");
        sb.append(getPort());
        sb.append("\n]");
        return sb.toString();
    }
}
