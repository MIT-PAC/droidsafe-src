/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;

import javax.net.ssl.SSLPeerUnverifiedException;

public abstract class SecureCacheResponse extends CacheResponse {

    /**
     * Creates a new instance of this class.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.203 -0500", hash_original_method = "2B60842F322CE42A5832F1BBB0BB3BBC", hash_generated_method = "E876B20AB059AEB79D3226BCAAD496CE")
    
public SecureCacheResponse() {
    }

    /**
     * Gets the cipher suite string on the connection which is originally used
     * to retrieve the network resource.
     *
     * @return the cipher suite string.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.206 -0500", hash_original_method = "DC3C51A13960575CAB20927262CC1EAA", hash_generated_method = "50C779AE7D838B9AD10E9CAAE28CA039")
    
public abstract String getCipherSuite();

    /**
     * Gets the local certificate chain. When the original connection retrieved
     * the resource data, this certificate chain was sent to the server during
     * handshaking process. This method only takes effect when certificate-based
     * cipher suite is enabled.
     *
     * @return the certificate chain that was sent to the server. If no
     *         certificate chain was sent, the method returns {@code null}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.208 -0500", hash_original_method = "311741B527CA4F39B9234C34CC3B7AFA", hash_generated_method = "35CDD61FFEE644BD96FBAF38B7C31B43")
    
public abstract List<Certificate> getLocalCertificateChain();

    /**
     * Gets the cached server's certificate chain. As part of defining the
     * session, the certificate chain was established when the original
     * connection retrieved network resource. This method can only be invoked
     * when certificated-based cipher suite is enabled. Otherwise, it throws an
     * {@code SSLPeerUnverifiedException}.
     *
     * @return the server's certificate chain.
     * @throws SSLPeerUnverifiedException
     *             if the peer is unverified.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.211 -0500", hash_original_method = "2C182CC104B6AF3A29CD53DD7A3A838C", hash_generated_method = "7467D79C70A3C6272623BFA28341E174")
    
public abstract List<Certificate> getServerCertificateChain()
            throws SSLPeerUnverifiedException;

    /**
     * Gets the server's principle. When the original connection retrieved
     * network resource, the principle was established when defining the
     * session.
     *
     * @return a principal object representing the server's principal.
     * @throws SSLPeerUnverifiedException
     *             if the peer is unverified.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.213 -0500", hash_original_method = "39836869B57D2BC0F61D16AFD90892A8", hash_generated_method = "76C69168B4B18454351FC53F4D26CA31")
    
public abstract Principal getPeerPrincipal()
            throws SSLPeerUnverifiedException;

    /**
     * Gets the local principle that the original connection sent to the server.
     * When the original connection fetched the network resource, the principle
     * was sent to the server during handshaking process.
     *
     * @return the local principal object being sent to the server. Returns an
     *         {@code X500Principal} object for X509-based cipher suites. If no
     *         principal was sent, it returns {@code null}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.216 -0500", hash_original_method = "9FFB2B18A70F76C4BCA9E2857CB5AD56", hash_generated_method = "D713221E2623AC23872545FE17F85951")
    
public abstract Principal getLocalPrincipal();
    
}

