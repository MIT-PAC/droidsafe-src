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


package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public abstract class SSLServerSocket extends ServerSocket {

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP server socket with the default authentication context.
     *
     * @throws IOException
     *             if creating the socket fails.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.915 -0500", hash_original_method = "0C32E268EE0846B0058E51DE9119BB88", hash_generated_method = "5B51B10964DA93A3055EC005CD7C304D")
    
protected SSLServerSocket() throws IOException {
    }

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP server socket on the specified port with the default
     * authentication context. The connection's default backlog size is 50
     * connections.
     * @param port
     *            the port to listen on.
     * @throws IOException
     *             if creating the socket fails.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.917 -0500", hash_original_method = "6BF605439AB4EACD05FCE94D8066CA51", hash_generated_method = "419EF33FAD140A7F0B998C17FB501FB0")
    
protected SSLServerSocket(int port) throws IOException {
        super(port);
    }

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP server socket on the specified port using the specified
     * backlog and the default authentication context.
     *
     * @param port
     *            the port to listen on.
     * @param backlog
     *            the number of pending connections to queue.
     * @throws IOException
     *             if creating the socket fails.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.920 -0500", hash_original_method = "B059A4E5C7C0ACF77295A5FB6F9F0E0C", hash_generated_method = "4D6BA631027E01646DD5DADA2E526176")
    
protected SSLServerSocket(int port, int backlog) throws IOException {
        super(port, backlog);
    }

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP server socket on the specified port, using the specified
     * backlog, listening on the specified interface, and using the default
     * authentication context.
     *
     * @param port
     *            the port the listen on.
     * @param backlog
     *            the number of pending connections to queue.
     * @param address
     *            the address of the interface to accept connections on.
     * @throws IOException
     *             if creating the socket fails.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.922 -0500", hash_original_method = "52663793633798E1236728C0ACB46452", hash_generated_method = "E22A2A023BF325A7A62A6CCDD23EAF79")
    
protected SSLServerSocket(int port, int backlog, InetAddress address) throws IOException {
        super(port, backlog, address);
    }

    /**
     * Returns the names of the enabled cipher suites to be used for new
     * connections.
     *
     * @return the names of the enabled cipher suites to be used for new
     *         connections.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.924 -0500", hash_original_method = "BB75297504ED13529514C3177F090190", hash_generated_method = "061445B26CADFE8B5CD047D7521151EC")
    
public abstract String[] getEnabledCipherSuites();

    /**
     * Sets the names of the cipher suites to be enabled for new connections.
     * Only cipher suites returned by {@link #getSupportedCipherSuites()} are
     * allowed.
     *
     * @param suites
     *            the names of the to be enabled cipher suites.
     * @throws IllegalArgumentException
     *             if one of the cipher suite names is not supported.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.927 -0500", hash_original_method = "84F6E139E9DDF1E455EB26E1B318EBF4", hash_generated_method = "F9805BBF1FBBA5E941AC2541C0C38322")
    
public abstract void setEnabledCipherSuites(String[] suites);

    /**
     * Returns the names of the supported cipher suites.
     *
     * @return the names of the supported cipher suites.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.930 -0500", hash_original_method = "972B577B4B04B597248145E0CF6E63D2", hash_generated_method = "09D1FF6565C262832AA989BA28390929")
    
public abstract String[] getSupportedCipherSuites();

    /**
     * Returns the names of the supported protocols.
     *
     * @return the names of the supported protocols.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.932 -0500", hash_original_method = "3FD91F76BC51E9E2EDFCF4A896BF5E5E", hash_generated_method = "A3356A4404800F82B6EC4AE3BBD1CECE")
    
public abstract String[] getSupportedProtocols();

    /**
     * Returns the names of the enabled protocols to be used for new
     * connections.
     *
     * @return the names of the enabled protocols to be used for new
     *         connections.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.934 -0500", hash_original_method = "32F4E828AC8F445B64955C86B1AFEAEB", hash_generated_method = "5E4CEFAED414B7670ED014CA834938CE")
    
public abstract String[] getEnabledProtocols();

    /**
     * Sets the names of the protocols to be enabled for new connections. Only
     * protocols returned by {@link #getSupportedProtocols()} are allowed.
     *
     * @param protocols
     *            the names of the to be enabled protocols.
     * @throws IllegalArgumentException
     *             if one of the protocols is not supported.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.936 -0500", hash_original_method = "190265461F98EDDDF9AC6C5332C503B2", hash_generated_method = "30F0BE37EC8F79FDE8B6CE44A0863F4E")
    
public abstract void setEnabledProtocols(String[] protocols);

    /**
     * Sets whether server-mode connections will be configured to require client
     * authentication. The client authentication is one of the following:
     * <ul>
     * <li>authentication required</li>
     * <li>authentication requested</li>
     * <li>no authentication needed</li>
     * </ul>
     * This method overrides the setting of {@link #setWantClientAuth(boolean)}.
     *
     * @param need
     *            {@code true} if client authentication is required,
     *            {@code false} if no authentication is needed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.940 -0500", hash_original_method = "12E2718447E521BB2126CF41CA343554", hash_generated_method = "BFF0A42DB80B794FF8EACD8B0D363AFE")
    
public abstract void setNeedClientAuth(boolean need);

    /**
     * Returns whether server-mode connections will be configured to require
     * client authentication.
     *
     * @return {@code true} if client authentication is required, {@code false}
     *         if no client authentication is needed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.942 -0500", hash_original_method = "18D8E87E8269449773EEAF111DE0F33F", hash_generated_method = "84AFAA836C2B9FD9D30E6C8E29EDA240")
    
public abstract boolean getNeedClientAuth();

    /**
     * Sets whether server-mode connections will be configured to request client
     * authentication. The client authentication is one of the following:
     * <ul>
     * <li>authentication required</li>
     * <li>authentication requested</li>
     * <li>no authentication needed</li>
     * </ul>
     * This method overrides the setting of {@link #setNeedClientAuth(boolean)}.
     *
     * @param want
     *            {@code true} if client authentication should be requested,
     *            {@code false} if no authentication is needed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.944 -0500", hash_original_method = "356948DA3BA53E1DF3CFAAEFCCB304EC", hash_generated_method = "F842593770E8FDE5B25EAE8AEA1A73A2")
    
public abstract void setWantClientAuth(boolean want);

    /**
     * Returns whether server-mode connections will be configured to request
     * client authentication.
     *
     * @return {@code true} is client authentication will be requested,
     *         {@code false} if no client authentication is needed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.946 -0500", hash_original_method = "6ABFE23F3A3B3813808D701D9CDD5E9C", hash_generated_method = "1E5ADAC3870F0177C238FC2ED806960E")
    
public abstract boolean getWantClientAuth();

    /**
     * Sets whether new connections should act in client mode when handshaking.
     *
     * @param mode
     *            {@code true} if new connections should act in client mode,
     *            {@code false} if not.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.949 -0500", hash_original_method = "19AAB4420CED9244333FFE885F8E0B37", hash_generated_method = "AFBE53D3CEDD2FF26833A764AB296F02")
    
public abstract void setUseClientMode(boolean mode);

    /**
     * Returns whether new connection will act in client mode when handshaking.
     *
     * @return {@code true} if new connections will act in client mode when
     *         handshaking, {@code false} if not.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.951 -0500", hash_original_method = "B2F0A693CA367F13693D6A3367E86206", hash_generated_method = "D17191517DC8ACFD56AD0AE6AA8D5B97")
    
public abstract boolean getUseClientMode();

    /**
     * Sets whether new SSL sessions may be established for new connections.
     *
     * @param flag
     *            {@code true} if new SSL sessions may be established,
     *            {@code false} if existing SSL sessions must be reused.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.953 -0500", hash_original_method = "C22D69DDD073F51A676C7AA37CECE077", hash_generated_method = "6A8A708293722AAF79D6E19A89EDCF3F")
    
public abstract void setEnableSessionCreation(boolean flag);

    /**
     * Returns whether new SSL sessions may be established for new connections.
     *
     * @return {@code true} if new SSL sessions may be established,
     *         {@code false} if existing SSL sessions must be reused.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.956 -0500", hash_original_method = "A0E2936040B850370E4431895BC97980", hash_generated_method = "367C53128C1B81ADB8CCA01DBCE35F10")
    
public abstract boolean getEnableSessionCreation();
    
}

