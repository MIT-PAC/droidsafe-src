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
import java.nio.ByteBuffer;

public abstract class SSLEngine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.523 -0500", hash_original_field = "C33A347C63CF676DBDFD0CCC029E433E", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private  String peerHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.525 -0500", hash_original_field = "A714E58FF483C2E33F156CBA7BFCD38B", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private  int peerPort;

    /**
     * Creates a new {@code SSLEngine} instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.528 -0500", hash_original_method = "4DB69FC0D6B2C4EA5754BFEC7A5A4921", hash_generated_method = "E2FBEE686069E89CC1293D27865A5E4A")
    
protected SSLEngine() {
        peerHost = null;
        peerPort = -1;
    }

    /**
     * Creates a new {@code SSLEngine} instance with the specified host and
     * port.
     *
     * @param host
     *            the name of the host.
     * @param port
     *            the port of the host.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.531 -0500", hash_original_method = "EEA000A850DD4012FB53C4A935EA52C0", hash_generated_method = "9EA27009D5A72C558E4954329322EEF5")
    
protected SSLEngine(String host, int port) {
        this.peerHost = host;
        this.peerPort = port;
    }

    /**
     * Returns the name of the peer host.
     *
     * @return the name of the peer host, or {@code null} if none is available.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.533 -0500", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "B884ECED502456841527EC5FB85A2015")
    
public String getPeerHost() {
        return peerHost;
    }

    /**
     * Returns the port number of the peer host.
     *
     * @return the port number of the peer host, or {@code -1} is none is
     *         available.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.535 -0500", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "0A13911FE5FD34A377B4DEB23C492969")
    
public int getPeerPort() {
        return peerPort;
    }

    /**
     * Initiates a handshake on this engine.
     * <p>
     * Calling this method is not needed for the initial handshake: it will be
     * called by {@code wrap} or {@code unwrap} if the initial handshake has not
     * been started yet.
     *
     * @throws SSLException
     *             if starting the handshake fails.
     * @throws IllegalStateException
     *             if the engine does not have all the needed settings (e.g.
     *             client/server mode not set).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.537 -0500", hash_original_method = "4F0D34DFD3D1484E91BA72BADB23162A", hash_generated_method = "9F15F3402ECD6EF74D957997E1F451C3")
    
public abstract void beginHandshake() throws SSLException;

    /**
     * Notifies this engine instance that no more inbound network data will be
     * sent to this engine.
     *
     * @throws SSLException
     *             if this engine did not receive a needed protocol specific
     *             close notification message from the peer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.540 -0500", hash_original_method = "FB93F04FA108FFF94025798660EC1B2D", hash_generated_method = "219050BA1919BE676B5E162C62166922")
    
public abstract void closeInbound() throws SSLException;

    /**
     * Notifies this engine instance that no more outbound application data will
     * be sent to this engine.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.542 -0500", hash_original_method = "157CD3ED03C993ED0BE49049AE4142F0", hash_generated_method = "2166A0162E1631064A56157DF1EDCCB3")
    
public abstract void closeOutbound();

    /**
     * Returns a delegate task for this engine instance. Some engine operations
     * may require the results of blocking or long running operations, and the
     * {@code SSLEngineResult} instances returned by this engine may indicate
     * that a delegated task result is needed. In this case the
     * {@link Runnable#run() run} method of the returned {@code Runnable}
     * delegated task must be called.
     *
     * @return a delegate task, or {@code null} if none are available.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.544 -0500", hash_original_method = "0CD857071E126D0E0E3B448940FD7605", hash_generated_method = "2C29F70C13E42E1F01A4A8EB7BF6F849")
    
public abstract Runnable getDelegatedTask();

    /**
     * Returns the SSL cipher suite names that are enabled in this engine
     * instance.
     *
     * @return the SSL cipher suite names that are enabled in this engine
     *         instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.547 -0500", hash_original_method = "BB75297504ED13529514C3177F090190", hash_generated_method = "061445B26CADFE8B5CD047D7521151EC")
    
public abstract String[] getEnabledCipherSuites();

    /**
     * Returns the protocol version names that are enabled in this engine
     * instance.
     *
     * @return the protocol version names that are enabled in this engine
     *         instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.550 -0500", hash_original_method = "32F4E828AC8F445B64955C86B1AFEAEB", hash_generated_method = "5E4CEFAED414B7670ED014CA834938CE")
    
public abstract String[] getEnabledProtocols();

    /**
     * Returns whether new SSL sessions may be established by this engine.
     *
     * @return {@code true} if new session may be established, {@code false} if
     *         existing sessions must be reused.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.552 -0500", hash_original_method = "A0E2936040B850370E4431895BC97980", hash_generated_method = "367C53128C1B81ADB8CCA01DBCE35F10")
    
public abstract boolean getEnableSessionCreation();

    /**
     * Returns the status of the handshake of this engine instance.
     *
     * @return the status of the handshake of this engine instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.554 -0500", hash_original_method = "FBF65122361485F8D84C3157103F404D", hash_generated_method = "613669FCD3C3DB0AA01B5FB2DBBC7B5F")
    
public abstract SSLEngineResult.HandshakeStatus getHandshakeStatus();

    /**
     * Returns whether this engine instance will require client authentication.
     *
     * @return {@code true} if this engine will require client authentication,
     *         {@code false} if no client authentication is needed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.556 -0500", hash_original_method = "18D8E87E8269449773EEAF111DE0F33F", hash_generated_method = "84AFAA836C2B9FD9D30E6C8E29EDA240")
    
public abstract boolean getNeedClientAuth();

    /**
     * Returns the SSL session for this engine instance.
     *
     * @return the SSL session for this engine instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.559 -0500", hash_original_method = "532A0CA5E04090EDD94B248F925615EE", hash_generated_method = "83FB733144EA2670CC9BAF632B24E628")
    
public abstract SSLSession getSession();

    /**
     * Returns the SSL cipher suite names that are supported by this engine.
     * These cipher suites can be enabled using
     * {@link #setEnabledCipherSuites(String[])}.
     *
     * @return the SSL cipher suite names that are supported by this engine.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.561 -0500", hash_original_method = "972B577B4B04B597248145E0CF6E63D2", hash_generated_method = "09D1FF6565C262832AA989BA28390929")
    
public abstract String[] getSupportedCipherSuites();

    /**
     * Returns the protocol names that are supported by this engine. These
     * protocols can be enables using {@link #setEnabledProtocols(String[])}.
     *
     * @return the protocol names that are supported by this engine.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.563 -0500", hash_original_method = "3FD91F76BC51E9E2EDFCF4A896BF5E5E", hash_generated_method = "A3356A4404800F82B6EC4AE3BBD1CECE")
    
public abstract String[] getSupportedProtocols();

    /**
     * Returns whether this engine is set to act in client mode when
     * handshaking.
     *
     * @return {@code true} if the engine is set to do handshaking in client
     *         mode.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.565 -0500", hash_original_method = "B2F0A693CA367F13693D6A3367E86206", hash_generated_method = "D17191517DC8ACFD56AD0AE6AA8D5B97")
    
public abstract boolean getUseClientMode();

    /**
     * Returns whether this engine will request client authentication.
     *
     * @return {@code true} if client authentication will be requested,
     *         {@code false} otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.568 -0500", hash_original_method = "6ABFE23F3A3B3813808D701D9CDD5E9C", hash_generated_method = "1E5ADAC3870F0177C238FC2ED806960E")
    
public abstract boolean getWantClientAuth();

    /**
     * Returns whether no more inbound data will be accepted by this engine.
     *
     * @return {@code true} if no more inbound data will be accepted by this
     *         engine, {@code false} otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.570 -0500", hash_original_method = "B7DF8CE1866B8DC99DD4341771EDAC84", hash_generated_method = "18CEF27EF141B955EE0880D76A853FF9")
    
public abstract boolean isInboundDone();

    /**
     * Returns whether no more outbound data will be produced by this engine.
     *
     * @return {@code true} if no more outbound data will be producted by this
     *         engine, {@code otherwise} false.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.572 -0500", hash_original_method = "F5D84C3147F6B1216757D31C12326703", hash_generated_method = "ACD2B177D0A0F9C3A111DB87658DB7FC")
    
public abstract boolean isOutboundDone();

    /**
     * Sets the SSL cipher suite names that should be enabled in this engine
     * instance. Only cipher suites listed by {@code getSupportedCipherSuites()}
     * are allowed.
     *
     * @param suites
     *            the SSL cipher suite names to be enabled.
     * @throws IllegalArgumentException
     *             if one of the specified cipher suites is not supported, or if
     *             {@code suites} is {@code null}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.574 -0500", hash_original_method = "84F6E139E9DDF1E455EB26E1B318EBF4", hash_generated_method = "F9805BBF1FBBA5E941AC2541C0C38322")
    
public abstract void setEnabledCipherSuites(String[] suites);

    /**
     * Sets the protocol version names that should be enabled in this engine
     * instance. Only protocols listed by {@code getSupportedProtocols()} are
     * allowed.
     *
     * @param protocols
     *            the protocol version names to be enabled.
     * @throws IllegalArgumentException
     *             if one of the protocol version names is not supported, or if
     *             {@code protocols} is {@code null}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.577 -0500", hash_original_method = "190265461F98EDDDF9AC6C5332C503B2", hash_generated_method = "30F0BE37EC8F79FDE8B6CE44A0863F4E")
    
public abstract void setEnabledProtocols(String[] protocols);

    /**
     * Sets whether new SSL sessions may be established by this engine instance.
     *
     * @param flag
     *            {@code true} if new SSL sessions may be established,
     *            {@code false} if existing SSL sessions must be reused.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.579 -0500", hash_original_method = "C22D69DDD073F51A676C7AA37CECE077", hash_generated_method = "6A8A708293722AAF79D6E19A89EDCF3F")
    
public abstract void setEnableSessionCreation(boolean flag);

    /**
     * Sets whether this engine must require client authentication. The client
     * authentication is one of:
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.582 -0500", hash_original_method = "12E2718447E521BB2126CF41CA343554", hash_generated_method = "BFF0A42DB80B794FF8EACD8B0D363AFE")
    
public abstract void setNeedClientAuth(boolean need);

    /**
     * Sets whether this engine should act in client (or server) mode when
     * handshaking.
     *
     * @param mode
     *            {@code true} if this engine should act in client mode,
     *            {@code false} if not.
     * @throws IllegalArgumentException
     *             if this method is called after starting the initial
     *             handshake.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.584 -0500", hash_original_method = "19AAB4420CED9244333FFE885F8E0B37", hash_generated_method = "AFBE53D3CEDD2FF26833A764AB296F02")
    
public abstract void setUseClientMode(boolean mode);

    /**
     * Sets whether this engine should request client authentication. The client
     * authentication is one of the following:
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.586 -0500", hash_original_method = "356948DA3BA53E1DF3CFAAEFCCB304EC", hash_generated_method = "F842593770E8FDE5B25EAE8AEA1A73A2")
    
public abstract void setWantClientAuth(boolean want);

    /**
     * Decodes the incoming network data buffer into application data buffers.
     * If a handshake has not been started yet, it will automatically be
     * started.
     *
     * @param src
     *            the buffer with incoming network data
     * @param dsts
     *            the array of destination buffers for incoming application
     *            data.
     * @param offset
     *            the offset in the array of destination buffers to which data
     *            is to be transferred.
     * @param length
     *            the maximum number of destination buffers to be used.
     * @return the result object of this operation.
     * @throws SSLException
     *             if a problem occurred while processing the data.
     * @throws IndexOutOfBoundsException
     *             if {@code length} is greater than
     *             {@code dsts.length - offset}.
     * @throws java.nio.ReadOnlyBufferException
     *             if one of the destination buffers is read-only.
     * @throws IllegalArgumentException
     *             if {@code src}, {@code dsts}, or one of the entries in
     *             {@code dsts} is {@code null}.
     * @throws IllegalStateException
     *             if the engine does not have all the needed settings (e.g.
     *             client/server mode not set).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.589 -0500", hash_original_method = "53CF3F2F5AF568B9D67F3A0608E2D611", hash_generated_method = "5F0848612F77A5F1773A61005B9102FB")
    
public abstract SSLEngineResult unwrap(ByteBuffer src,
                                           ByteBuffer[] dsts,
                                           int offset,
                                           int length) throws SSLException;

    /**
     * Encodes the outgoing application data buffers into the network data
     * buffer. If a handshake has not been started yet, it will automatically be
     * started.
     *
     * @param srcs
     *            the array of source buffers of outgoing application data.
     * @param offset
     *            the offset in the array of source buffers from which data is
     *            to be retrieved.
     * @param length
     *            the maximum number of source buffers to be used.
     * @param dst
     *            the destination buffer for network data.
     * @return the result object of this operation.
     * @throws SSLException
     *             if a problem occurred while processing the data.
     * @throws IndexOutOfBoundsException
     *             if {@code length} is greater than
     *             {@code srcs.length - offset}.
     * @throws java.nio.ReadOnlyBufferException
     *             if the destination buffer is readonly.
     * @throws IllegalArgumentException
     *             if {@code srcs}, {@code dst}, or one the entries in
     *             {@code srcs} is {@code null}.
     * @throws IllegalStateException
     *             if the engine does not have all the needed settings (e.g.
     *             client/server mode not set).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.591 -0500", hash_original_method = "910AC97486EF4CDF39EFB601F1657BCE", hash_generated_method = "4B18957461BDC41326765A8A501DA786")
    
public abstract SSLEngineResult wrap(ByteBuffer[] srcs, int offset, int length, ByteBuffer dst)
            throws SSLException;

    /**
     * Decodes the incoming network data buffer into the application data
     * buffer. If a handshake has not been started yet, it will automatically be
     * started.
     *
     * @param src
     *            the buffer with incoming network data
     * @param dst
     *            the destination buffer for incoming application data.
     * @return the result object of this operation.
     * @throws SSLException
     *             if a problem occurred while processing the data.
     * @throws java.nio.ReadOnlyBufferException
     *             if one of the destination buffers is read-only.
     * @throws IllegalArgumentException
     *             if {@code src} or {@code dst} is {@code null}.
     * @throws IllegalStateException
     *             if the engine does not have all the needed settings (e.g.
     *             client/server mode not set).
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.593 -0500", hash_original_method = "7AC56F3E97B3BF2A8A3FC335E647B318", hash_generated_method = "9ECDE8E6E145177E98F97B800C2FB6BF")
    
public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        return unwrap(src, new ByteBuffer[] { dst }, 0, 1);
    }

    /**
     * Decodes the incoming network data buffer into the application data
     * buffers. If a handshake has not been started yet, it will automatically
     * be started.
     *
     * @param src
     *            the buffer with incoming network data
     * @param dsts
     *            the array of destination buffers for incoming application
     *            data.
     * @return the result object of this operation.
     * @throws SSLException
     *             if a problem occurred while processing the data.
     * @throws java.nio.ReadOnlyBufferException
     *             if one of the destination buffers is read-only.
     * @throws IllegalArgumentException
     *             if {@code src} or {@code dsts} is {@code null}.
     * @throws IllegalStateException
     *             if the engine does not have all the needed settings (e.g.
     *             client/server mode not set).
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.596 -0500", hash_original_method = "9736EBF4FA9EEB1C5129AD63480700AA", hash_generated_method = "888840D46D3BD5AD31AB47DD90E565ED")
    
public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts) throws SSLException {
        if (dsts == null) {
            throw new IllegalArgumentException("Byte buffer array dsts is null");
        }
        return unwrap(src, dsts, 0, dsts.length);
    }

    /**
     * Encodes the outgoing application data buffers into the network data
     * buffer. If a handshake has not been started yet, it will automatically be
     * started.
     *
     * @param srcs
     *            the array of source buffers of outgoing application data.
     * @param dst
     *            the destination buffer for network data.
     * @return the result object of this operation.
     * @throws SSLException
     *             if a problem occurred while processing the data.
     * @throws java.nio.ReadOnlyBufferException
     *             if the destination buffer is readonly.
     * @throws IllegalArgumentException
     *             if {@code srcs} or {@code dst} is {@code null}.
     * @throws IllegalStateException
     *             if the engine does not have all the needed settings (e.g.
     *             client/server mode not set).
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.599 -0500", hash_original_method = "2CCA444D00129DF62214EE036E36E4DD", hash_generated_method = "BDAF0D160199EAB3940CB5B7DF30E08A")
    
public SSLEngineResult wrap(ByteBuffer[] srcs, ByteBuffer dst) throws SSLException {
        if (srcs == null) {
            throw new IllegalArgumentException("Byte buffer array srcs is null");
        }
        return wrap(srcs, 0, srcs.length, dst);
    }

    /**
     * Encodes the outgoing application data buffer into the network data
     * buffer. If a handshake has not been started yet, it will automatically be
     * started.
     *
     * @param src
     *            the source buffers of outgoing application data.
     * @param dst
     *            the destination buffer for network data.
     * @return the result object of this operation.
     * @throws SSLException
     *             if a problem occurred while processing the data.
     * @throws java.nio.ReadOnlyBufferException
     *             if the destination buffer is readonly.
     * @throws IllegalArgumentException
     *             if {@code src} or {@code dst} is {@code null}.
     * @throws IllegalStateException
     *             if the engine does not have all the needed settings (e.g.
     *             client/server mode not set).
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.601 -0500", hash_original_method = "15A7413E97A8CAC06D2DFD60F87EA34E", hash_generated_method = "A44F54844E6FA3649A0F08484526C91C")
    
public SSLEngineResult wrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        return wrap(new ByteBuffer[] { src }, 0, 1, dst);
    }

    /**
     * Returns a new SSLParameters based on this SSLSocket's current
     * cipher suites, protocols, and client authentication settings.
     *
     * @since 1.6
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.603 -0500", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "E49272E6A5C5F4C5B789C28E3A1AD325")
    
public SSLParameters getSSLParameters() {
        SSLParameters p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
        return p;
    }

    /**
     * Sets various SSL handshake parameters based on the SSLParameter
     * argument. Specifically, sets the SSLEngine's enabled cipher
     * suites if the parameter's cipher suites are non-null. Similarly
     * sets the enabled protocols. If the parameters specify the want
     * or need for client authentication, those requirements are set
     * on the SSLEngine, otherwise both are set to false.
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.606 -0500", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "B59D430B54A9E84755CD1B8DE11AFB42")
    
public void setSSLParameters(SSLParameters p) {
        String[] cipherSuites = p.getCipherSuites();
        if (cipherSuites != null) {
            setEnabledCipherSuites(cipherSuites);
        }
        String[] protocols = p.getProtocols();
        if (protocols != null) {
            setEnabledProtocols(protocols);
        }
        if (p.getNeedClientAuth()) {
            setNeedClientAuth(true);
        } else if (p.getWantClientAuth()) {
            setWantClientAuth(true);
        } else {
            setWantClientAuth(false);
        }
    }
    
}

