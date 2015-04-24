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
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

import libcore.io.Streams;

import org.apache.harmony.security.provider.cert.X509CertImpl;

import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;

public class OpenSSLSocketImpl extends javax.net.ssl.SSLSocket implements NativeCrypto.SSLHandshakeCallbacks {

    /**
     * Return a possibly null array of X509Certificates given the
     * possibly null array of DER encoded bytes.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.432 -0500", hash_original_method = "20B392F81EB563515A5AD0702F74C046", hash_generated_method = "EBE22081BF4F609A10ADE825A5E979C7")
    
private static X509Certificate[] createCertChain(byte[][] certificatesBytes) {
        if (certificatesBytes == null) {
            return null;
        }
        X509Certificate[] certificates = new X509Certificate[certificatesBytes.length];
        for (int i = 0; i < certificatesBytes.length; i++) {
            try {
                certificates[i] = new X509CertImpl(certificatesBytes[i]);
            } catch (IOException e) {
                return null;
            }
        }
        return certificates;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.340 -0500", hash_original_field = "B6F754963517A8E24052D31CA5B96417", hash_generated_field = "748A6049ACB01D98F85E21799F2EB11A")

    private int sslNativePointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.342 -0500", hash_original_field = "B25CAE9BF82BA95FEFAA4B1FEB647560", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.344 -0500", hash_original_field = "6516E64974FF88B82386745392C5E14B", hash_generated_field = "BFEC39E15FADDFA148ED8D3CE22EABA4")

    private OutputStream os;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.346 -0500", hash_original_field = "5ACBDB2FD1BFE121C5FF157D8EAE838E", hash_generated_field = "BBF990300E3830CE6A958CDB35B29B27")

    private final Object handshakeLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.349 -0500", hash_original_field = "250488CBE536209C574C50F3A29378C0", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.352 -0500", hash_original_field = "4280965CC4B75048AF13050687F80AFE", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.355 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.358 -0500", hash_original_field = "56710F860A483DEC3E9BBA4072A66C57", hash_generated_field = "85F0E10109EFE4B8F58BC1776613705B")

    private String[] enabledProtocols;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.360 -0500", hash_original_field = "3E04D402738DE5E13740996FD5888CDA", hash_generated_field = "7AD17E190B7E5C8B7D224A9E272C550F")

    private String[] enabledCipherSuites;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.363 -0500", hash_original_field = "F6BAF93DB9B7468FC1834CFE965D6B3A", hash_generated_field = "3ED2FE1E30316545E9184B9907A7D6E3")

    private String[] enabledCompressionMethods;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.365 -0500", hash_original_field = "43A7FCD8C9B9912A807CABC90E30BE7C", hash_generated_field = "A2F538231066932F5915EF28021541F1")

    private boolean useSessionTickets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.367 -0500", hash_original_field = "6B66041FD39815DF98C48C22668D1653", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    private String hostname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.369 -0500", hash_original_field = "F21F1661DC467B500BB0D2559153384C", hash_generated_field = "368A75AAABC6FBEB91272F5EA8465622")

    private OpenSSLSessionImpl sslSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.372 -0500", hash_original_field = "5019B3EE05D6098E4ECE32F00F7F88CA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private  Socket socket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.374 -0500", hash_original_field = "314CBCF9AA3FDF00F16B4F5F8F65CAC6", hash_generated_field = "AEB05A26C586581FD503591C56751340")

    private boolean autoClose;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.376 -0500", hash_original_field = "182F4836E10E1A35ECA8072F27955778", hash_generated_field = "5B583CD79FBEC6280A38CE8E3A8DAA8A")

    private boolean handshakeStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.378 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.381 -0500", hash_original_field = "F7A4B14D16A91683409F751614EE0186", hash_generated_field = "2D23168D66D17A93982E63C6133878AC")

    private boolean handshakeCompleted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.383 -0500", hash_original_field = "62277C468EB34D88444F90B52C9C2418", hash_generated_field = "18AE5B2EA1E4D2608E5F816AEC3235B3")

    private ArrayList<HandshakeCompletedListener> listeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.385 -0500", hash_original_field = "2FF78E4028756639B46028940691AE6C", hash_generated_field = "D9040C82E2DDED5191E6D7AE598F1DB8")

    private int timeoutMilliseconds = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.388 -0500", hash_original_field = "BDDB36D409EA0D64A6A41682D7A84874", hash_generated_field = "924BC0B5E41E0BD4B8C4C178AB494DA8")

    private int handshakeTimeoutMilliseconds = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.390 -0500", hash_original_field = "18D966D008FF5B53642F609B9F98BF6D", hash_generated_field = "6FB2C77C604FE1268BFA3B979F3F3054")

    private String wrappedHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.392 -0500", hash_original_field = "8E5392274D48EA0F598401FA029FD3ED", hash_generated_field = "B7D8F64F41E806C80BDECFDD8FA68EFA")

    private int wrappedPort;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.394 -0500", hash_original_method = "1E0B4679EC7761107339F1A8D3A55F9F", hash_generated_method = "36E508E1A3C08057CE093C85268BCF0F")
    
protected OpenSSLSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.socket = this;
        init(sslParameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.397 -0500", hash_original_method = "7190C9F3617EA957D6C6C5547D61E7DA", hash_generated_method = "B753B8129C6347AF4B27F9B429DA4599")
    
protected OpenSSLSocketImpl(SSLParametersImpl sslParameters,
                                String[] enabledProtocols,
                                String[] enabledCipherSuites,
                                String[] enabledCompressionMethods) throws IOException {
        this.socket = this;
        init(sslParameters, enabledProtocols, enabledCipherSuites, enabledCompressionMethods);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.400 -0500", hash_original_method = "8EFC55677F513E24A665A5B10C8DD781", hash_generated_method = "170877FF84EAB320204E5F887B082A04")
    
protected OpenSSLSocketImpl(String host, int port, SSLParametersImpl sslParameters)
            throws IOException {
        super(host, port);
        this.socket = this;
        init(sslParameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.403 -0500", hash_original_method = "3B4C2FC0F73F444026E804CAAB2D3AA5", hash_generated_method = "C7DEE26544482B7B314F21959549572A")
    
protected OpenSSLSocketImpl(InetAddress address, int port, SSLParametersImpl sslParameters)
            throws IOException {
        super(address, port);
        this.socket = this;
        init(sslParameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.405 -0500", hash_original_method = "3EB3C6E00E78F272783CA82B1518096D", hash_generated_method = "1E0A9FE4CD04F94470CC5376B30473D7")
    
protected OpenSSLSocketImpl(String host, int port,
                                InetAddress clientAddress, int clientPort,
                                SSLParametersImpl sslParameters) throws IOException {
        super(host, port, clientAddress, clientPort);
        this.socket = this;
        init(sslParameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.408 -0500", hash_original_method = "BF524C761FC1FBF2285E42FB758995EF", hash_generated_method = "3A3014E3707EB3D1DEF1E6F20A7D3BD7")
    
protected OpenSSLSocketImpl(InetAddress address, int port,
                                InetAddress clientAddress, int clientPort,
                                SSLParametersImpl sslParameters) throws IOException {
        super(address, port, clientAddress, clientPort);
        this.socket = this;
        init(sslParameters);
    }

    /**
     * Create an SSL socket that wraps another socket. Invoked by
     * OpenSSLSocketImplWrapper constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.411 -0500", hash_original_method = "E8402FE2BCEFBC2883099C44FF33F005", hash_generated_method = "0F165B8BD05BFD648984966CE620E458")
    
protected OpenSSLSocketImpl(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        this.socket = socket;
        this.wrappedHost = host;
        this.wrappedPort = port;
        this.autoClose = autoClose;
        init(sslParameters);

        // this.timeout is not set intentionally.
        // OpenSSLSocketImplWrapper.getSoTimeout will delegate timeout
        // to wrapped socket
    }

    /**
     * Initialize the SSL socket and set the certificates for the
     * future handshaking.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.413 -0500", hash_original_method = "33D1B746D20986D17267826F3151AB68", hash_generated_method = "40C8212AA2D38D28244FD69F411134EA")
    
private void init(SSLParametersImpl sslParameters) throws IOException {
        init(sslParameters,
             NativeCrypto.getSupportedProtocols(),
             NativeCrypto.getDefaultCipherSuites(),
             NativeCrypto.getDefaultCompressionMethods());
    }

    /**
     * Initialize the SSL socket and set the certificates for the
     * future handshaking.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.416 -0500", hash_original_method = "28ECC4752D5D2759E8F75423B7F304E1", hash_generated_method = "BBB3090F62ED648158D9F2807E79B389")
    
private void init(SSLParametersImpl sslParameters,
                      String[] enabledProtocols,
                      String[] enabledCipherSuites,
                      String[] enabledCompressionMethods) throws IOException {
        this.sslParameters = sslParameters;
        this.enabledProtocols = enabledProtocols;
        this.enabledCipherSuites = enabledCipherSuites;
        this.enabledCompressionMethods = enabledCompressionMethods;
    }

    /**
     * Gets the suitable session reference from the session cache container.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.419 -0500", hash_original_method = "DB9C757E33C47645F1FC9AEA51E10B24", hash_generated_method = "18534E169AD61D74DD431E99A6108961")
    
private OpenSSLSessionImpl getCachedClientSession(ClientSessionContext sessionContext) {
        if (super.getInetAddress() == null ||
                super.getInetAddress().getHostAddress() == null ||
                super.getInetAddress().getHostName() == null) {
            return null;
        }
        OpenSSLSessionImpl session = (OpenSSLSessionImpl) sessionContext.getSession(
                super.getInetAddress().getHostName(),
                super.getPort());
        if (session == null) {
            return null;
        }

        String protocol = session.getProtocol();
        boolean protocolFound = false;
        for (String enabledProtocol : enabledProtocols) {
            if (protocol.equals(enabledProtocol)) {
                protocolFound = true;
                break;
            }
        }
        if (!protocolFound) {
            return null;
        }

        String cipherSuite = session.getCipherSuite();
        boolean cipherSuiteFound = false;
        for (String enabledCipherSuite : enabledCipherSuites) {
            if (cipherSuite.equals(enabledCipherSuite)) {
                cipherSuiteFound = true;
                break;
            }
        }
        if (!cipherSuiteFound) {
            return null;
        }

        String compressionMethod = session.getCompressionMethod();
        boolean compressionMethodFound = false;
        for (String enabledCompressionMethod : enabledCompressionMethods) {
            if (compressionMethod.equals(enabledCompressionMethod)) {
                compressionMethodFound = true;
                break;
            }
        }
        if (!compressionMethodFound) {
            return null;
        }

        return session;
    }

    /**
     * Starts a TLS/SSL handshake on this connection using some native methods
     * from the OpenSSL library. It can negotiate new encryption keys, change
     * cipher suites, or initiate a new session. The certificate chain is
     * verified if the correspondent property in java.Security is set. All
     * listeners are notified at the end of the TLS/SSL handshake.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.421 -0500", hash_original_method = "6F34DF1209370488AD4C31DC9A9003CA", hash_generated_method = "29A8E7DAF93426AA1001E56F42877247")
    
@Override
    public void startHandshake() throws IOException {
        startHandshake(true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.424 -0500", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "7588EA0B4439101A03904302427A4E46")
    
private void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    /**
     * Perform the handshake
     *
     * @param full If true, disable handshake cutthrough for a fully synchronous handshake
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.429 -0500", hash_original_method = "7D68DA7254C24BFF3C6F787A75CF4E46", hash_generated_method = "A3746014CF1BC3E00B0BE85D5DD3D3F5")
    
public synchronized void startHandshake(boolean full) throws IOException {
        synchronized (handshakeLock) {
            checkOpen();
            if (!handshakeStarted) {
                handshakeStarted = true;
            } else {
                return;
            }
        }

        // note that this modifies the global seed, not something specific to the connection
        final int seedLengthInBytes = NativeCrypto.RAND_SEED_LENGTH_IN_BYTES;
        final SecureRandom secureRandom = sslParameters.getSecureRandomMember();
        if (secureRandom == null) {
            NativeCrypto.RAND_load_file("/dev/urandom", seedLengthInBytes);
        } else {
            NativeCrypto.RAND_seed(secureRandom.generateSeed(seedLengthInBytes));
        }

        final boolean client = sslParameters.getUseClientMode();

        final int sslCtxNativePointer = (client) ?
            sslParameters.getClientSessionContext().sslCtxNativePointer :
            sslParameters.getServerSessionContext().sslCtxNativePointer;

        this.sslNativePointer = 0;
        boolean exception = true;
        try {
            sslNativePointer = NativeCrypto.SSL_new(sslCtxNativePointer);
            guard.open("close");

            // setup server certificates and private keys.
            // clients will receive a call back to request certificates.
            if (!client) {
                Set<String> keyTypes = new HashSet<String>();
                for (String enabledCipherSuite : enabledCipherSuites) {
                    if (enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV)) {
                        continue;
                    }
                    String keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
                    if (keyType != null) {
                        keyTypes.add(keyType);
                    }
                }
                for (String keyType : keyTypes) {
                    try {
                        setCertificate(sslParameters.getKeyManager().chooseServerAlias(keyType,
                                                                                       null,
                                                                                       this));
                    } catch (CertificateEncodingException e) {
                        throw new IOException(e);
                    }
                }
            }

            NativeCrypto.setEnabledProtocols(sslNativePointer, enabledProtocols);
            NativeCrypto.setEnabledCipherSuites(sslNativePointer, enabledCipherSuites);
            if (enabledCompressionMethods.length != 0) {
                NativeCrypto.setEnabledCompressionMethods(sslNativePointer,
                                                          enabledCompressionMethods);
            }
            if (useSessionTickets) {
                NativeCrypto.SSL_clear_options(sslNativePointer, NativeCrypto.SSL_OP_NO_TICKET);
            }
            if (hostname != null) {
                NativeCrypto.SSL_set_tlsext_host_name(sslNativePointer, hostname);
            }

            boolean enableSessionCreation = sslParameters.getEnableSessionCreation();
            if (!enableSessionCreation) {
                NativeCrypto.SSL_set_session_creation_enabled(sslNativePointer,
                                                              enableSessionCreation);
            }

            AbstractSessionContext sessionContext;
            if (client) {
                // look for client session to reuse
                ClientSessionContext clientSessionContext = sslParameters.getClientSessionContext();
                sessionContext = clientSessionContext;
                OpenSSLSessionImpl session = getCachedClientSession(clientSessionContext);
                if (session != null) {
                    NativeCrypto.SSL_set_session(sslNativePointer,
                                                 session.sslSessionNativePointer);
                }
            } else {
                sessionContext = sslParameters.getServerSessionContext();
            }

            // setup peer certificate verification
            if (client) {
                // TODO support for anonymous cipher would require us to
                // conditionally use SSL_VERIFY_NONE
            } else {
                // needing client auth takes priority...
                boolean certRequested;
                if (sslParameters.getNeedClientAuth()) {
                    NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER
                                                | NativeCrypto.SSL_VERIFY_FAIL_IF_NO_PEER_CERT);
                    certRequested = true;
                // ... over just wanting it...
                } else if (sslParameters.getWantClientAuth()) {
                    NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER);
                    certRequested = true;
                // ... and it defaults properly so don't call SSL_set_verify in the common case.
                } else {
                    certRequested = false;
                }

                if (certRequested) {
                    X509TrustManager trustManager = sslParameters.getTrustManager();
                    X509Certificate[] issuers = trustManager.getAcceptedIssuers();
                    if (issuers != null && issuers.length != 0) {
                        byte[][] issuersBytes;
                        try {
                            issuersBytes = NativeCrypto.encodeIssuerX509Principals(issuers);
                        } catch (CertificateEncodingException e) {
                            throw new IOException("Problem encoding principals", e);
                        }
                        NativeCrypto.SSL_set_client_CA_list(sslNativePointer, issuersBytes);
                    }
                }
            }

            if (client && full) {
                // we want to do a full synchronous handshake, so turn off cutthrough
                NativeCrypto.SSL_clear_mode(sslNativePointer,
                                            NativeCrypto.SSL_MODE_HANDSHAKE_CUTTHROUGH);
            }

            // Temporarily use a different timeout for the handshake process
            int savedTimeoutMilliseconds = getSoTimeout();
            if (handshakeTimeoutMilliseconds >= 0) {
                setSoTimeout(handshakeTimeoutMilliseconds);
            }

            int sslSessionNativePointer;
            try {
                sslSessionNativePointer = NativeCrypto.SSL_do_handshake(sslNativePointer,
                        socket.getFileDescriptor$(), this, getSoTimeout(), client);
            } catch (CertificateException e) {
                SSLHandshakeException wrapper = new SSLHandshakeException(e.getMessage());
                wrapper.initCause(e);
                throw wrapper;
            }
            byte[] sessionId = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
            sslSession = (OpenSSLSessionImpl) sessionContext.getSession(sessionId);
            if (sslSession != null) {
                sslSession.lastAccessedTime = System.currentTimeMillis();
                NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
            } else {
                if (!enableSessionCreation) {
                    // Should have been prevented by NativeCrypto.SSL_set_session_creation_enabled
                    throw new IllegalStateException("SSL Session may not be created");
                }
                X509Certificate[] localCertificates
                        = createCertChain(NativeCrypto.SSL_get_certificate(sslNativePointer));
                X509Certificate[] peerCertificates
                        = createCertChain(NativeCrypto.SSL_get_peer_cert_chain(sslNativePointer));
                if (wrappedHost == null) {
                    sslSession = new OpenSSLSessionImpl(sslSessionNativePointer,
                                                        localCertificates, peerCertificates,
                                                        super.getInetAddress().getHostName(),
                                                        super.getPort(), sessionContext);
                } else  {
                    sslSession = new OpenSSLSessionImpl(sslSessionNativePointer,
                                                        localCertificates, peerCertificates,
                                                        wrappedHost, wrappedPort,
                                                        sessionContext);
                }
                // if not, putSession later in handshakeCompleted() callback
                if (handshakeCompleted) {
                    sessionContext.putSession(sslSession);
                }
            }

            // Restore the original timeout now that the handshake is complete
            if (handshakeTimeoutMilliseconds >= 0) {
                setSoTimeout(savedTimeoutMilliseconds);
            }

            // if not, notifyHandshakeCompletedListeners later in handshakeCompleted() callback
            if (handshakeCompleted) {
                notifyHandshakeCompletedListeners();
            }

            exception = false;
        } catch (SSLProtocolException e) {
            throw new SSLHandshakeException(e);
        } finally {
            // on exceptional exit, treat the socket as closed
            if (exception) {
                close();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.435 -0500", hash_original_method = "447042B984B2D213A231B86095B05FCC", hash_generated_method = "BDDDEB720902D80B38BE06B77895BE39")
    
private void setCertificate(String alias) throws CertificateEncodingException, SSLException {
        if (alias == null) {
            return;
        }
        PrivateKey privateKey = sslParameters.getKeyManager().getPrivateKey(alias);
        if (privateKey == null) {
            return;
        }
        X509Certificate[] certificates = sslParameters.getKeyManager().getCertificateChain(alias);
        if (certificates == null) {
            return;
        }

        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[][] certificateBytes = NativeCrypto.encodeCertificates(certificates);
        NativeCrypto.SSL_use_PrivateKey(sslNativePointer, privateKeyBytes);
        NativeCrypto.SSL_use_certificate(sslNativePointer, certificateBytes);

        // checks the last installed private key and certificate,
        // so need to do this once per loop iteration
        NativeCrypto.SSL_check_private_key(sslNativePointer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.437 -0500", hash_original_method = "4494930597AF8911ABFC977B28D550D9", hash_generated_method = "44986F78C073B44F122DE64D903DBD50")
    
@SuppressWarnings("unused") // used by NativeCrypto.SSLHandshakeCallbacks / client_cert_cb
    public void clientCertificateRequested(byte[] keyTypeBytes, byte[][] asn1DerEncodedPrincipals)
            throws CertificateEncodingException, SSLException {

        String[] keyTypes = new String[keyTypeBytes.length];
        for (int i = 0; i < keyTypeBytes.length; i++) {
            keyTypes[i] = CipherSuite.getClientKeyType(keyTypeBytes[i]);
        }

        X500Principal[] issuers;
        if (asn1DerEncodedPrincipals == null) {
            issuers = null;
        } else {
            issuers = new X500Principal[asn1DerEncodedPrincipals.length];
            for (int i = 0; i < asn1DerEncodedPrincipals.length; i++) {
                issuers[i] = new X500Principal(asn1DerEncodedPrincipals[i]);
            }
        }
        setCertificate(sslParameters.getKeyManager().chooseClientAlias(keyTypes, issuers, this));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.440 -0500", hash_original_method = "4135185E706706A43228536D20F5AD94", hash_generated_method = "59B99C30AB1BE52D6DF6EBF793106EA6")
    
@SuppressWarnings("unused") // used by NativeCrypto.SSLHandshakeCallbacks / info_callback
    public void handshakeCompleted() {
        handshakeCompleted = true;

        // If sslSession is null, the handshake was completed during
        // the call to NativeCrypto.SSL_do_handshake and not during a
        // later read operation. That means we do not need to fix up
        // the SSLSession and session cache or notify
        // HandshakeCompletedListeners, it will be done in
        // startHandshake.
        if (sslSession == null) {
            return;
        }

        // reset session id from the native pointer and update the
        // appropriate cache.
        sslSession.resetId();
        AbstractSessionContext sessionContext =
            (sslParameters.getUseClientMode())
            ? sslParameters.getClientSessionContext()
                : sslParameters.getServerSessionContext();
        sessionContext.putSession(sslSession);

        // let listeners know we are finally done
        notifyHandshakeCompletedListeners();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.443 -0500", hash_original_method = "7C2534895E7335878B6E22FB6F2D87D0", hash_generated_method = "2B2541D256E9C5DFF6ABB79BE38221DE")
    
private void notifyHandshakeCompletedListeners() {
        if (listeners != null && !listeners.isEmpty()) {
            // notify the listeners
            HandshakeCompletedEvent event =
                new HandshakeCompletedEvent(this, sslSession);
            for (HandshakeCompletedListener listener : listeners) {
                try {
                    listener.handshakeCompleted(event);
                } catch (RuntimeException e) {
                    // The RI runs the handlers in a separate thread,
                    // which we do not. But we try to preserve their
                    // behavior of logging a problem and not killing
                    // the handshaking thread just because a listener
                    // has a problem.
                    Thread thread = Thread.currentThread();
                    thread.getUncaughtExceptionHandler().uncaughtException(thread, e);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.446 -0500", hash_original_method = "ED84B1AF9EB80DCCE7D2C3DBC193F549", hash_generated_method = "4203833E4943C4A389A9BB8104EAAED0")
    
@SuppressWarnings("unused") // used by NativeCrypto.SSLHandshakeCallbacks
    @Override public void verifyCertificateChain(byte[][] bytes, String authMethod)
            throws CertificateException {
        try {
            if (bytes == null || bytes.length == 0) {
                throw new SSLException("Peer sent no certificate");
            }
            X509Certificate[] peerCertificateChain = new X509Certificate[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                peerCertificateChain[i] = new X509CertImpl(bytes[i]);
            }
            boolean client = sslParameters.getUseClientMode();
            if (client) {
                sslParameters.getTrustManager().checkServerTrusted(peerCertificateChain,
                                                                   authMethod);
            } else {
                String authType = peerCertificateChain[0].getPublicKey().getAlgorithm();
                sslParameters.getTrustManager().checkClientTrusted(peerCertificateChain,
                                                                   authType);
            }

        } catch (CertificateException e) {
            throw e;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.448 -0500", hash_original_method = "E61C85BF5C63F4E04D0D50BF3BBE2593", hash_generated_method = "9C95B417085D7551D5EC0712704BED9B")
    
@Override public InputStream getInputStream() throws IOException {
        checkOpen();
        synchronized (this) {
            if (is == null) {
                is = new SSLInputStream();
            }

            return is;
        }
    }

    @DSSafe(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.451 -0500", hash_original_method = "5EE71E3DCC35A33F08AD90BC3313950F", hash_generated_method = "6CE39E410CF8CCCF59840355AC2838A9")
    
@Override public OutputStream getOutputStream() throws IOException {
        checkOpen();
        synchronized (this) {
            if (os == null) {
                os = new SSLOutputStream();
            }

            return os;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.474 -0500", hash_original_method = "E137442CFB021C112EB3F3EAC9C4FE47", hash_generated_method = "5404D5B750F5D910F78A2D18A8E4A5C7")
    
@Override public SSLSession getSession() {
        if (sslSession == null) {
            try {
                startHandshake(true);
            } catch (IOException e) {
                // return an invalid session with
                // invalid cipher suite of "SSL_NULL_WITH_NULL_NULL"
                return SSLSessionImpl.NULL_SESSION;
            }
        }
        return sslSession;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.477 -0500", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "7933A4C77A4CFD3C8964936A38D20F91")
    
@Override public void addHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Provided listener is null");
        }
        if (listeners == null) {
            listeners = new ArrayList<HandshakeCompletedListener>();
        }
        listeners.add(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.479 -0500", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "9ACD4602144599915DF0E9850F80A4D8")
    
@Override public void removeHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Provided listener is null");
        }
        if (listeners == null) {
            throw new IllegalArgumentException(
                    "Provided listener is not registered");
        }
        if (!listeners.remove(listener)) {
            throw new IllegalArgumentException(
                    "Provided listener is not registered");
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.482 -0500", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "F0850E2B8F230278D1EE6575AFA464E6")
    
@Override public boolean getEnableSessionCreation() {
        return sslParameters.getEnableSessionCreation();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.484 -0500", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "3DEA9628617E70F67E1471694350041C")
    
@Override public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.486 -0500", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "FC9C3F1BC74E6756C08730F8099184A3")
    
@Override public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.488 -0500", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "9609D63D06C0561070F00E8FC5B0E108")
    
@Override public String[] getEnabledCipherSuites() {
        return enabledCipherSuites.clone();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.491 -0500", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "7334BD36327A5C0E4641C62AF79624D8")
    
@Override public void setEnabledCipherSuites(String[] suites) {
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.493 -0500", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "AC03A33ED96900A1F6F22E082B4D218D")
    
@Override public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.495 -0500", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "F66B93BEA1257A9D34745668F1A12518")
    
@Override public String[] getEnabledProtocols() {
        return enabledProtocols.clone();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.498 -0500", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "1247E6E288197D24DA3BC8CBC688F7CB")
    
@Override public void setEnabledProtocols(String[] protocols) {
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
    }

    /**
     * The names of the compression methods that may be used on this SSL
     * connection.
     * @return an array of compression methods
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.500 -0500", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "2000058BEAA332AE77D61F063BCEA525")
    
public String[] getSupportedCompressionMethods() {
        return NativeCrypto.getSupportedCompressionMethods();
    }

    /**
     * The names of the compression methods versions that are in use
     * on this SSL connection.
     *
     * @return an array of compression methods
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.502 -0500", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "10DC971DCE29DCF3C55D4ADAA3DDF81D")
    
public String[] getEnabledCompressionMethods() {
        return enabledCompressionMethods.clone();
    }

    /**
     * Enables compression methods listed by getSupportedCompressionMethods().
     *
     * @throws IllegalArgumentException when one or more of the names in the
     *             array are not supported, or when the array is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.504 -0500", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "0DCC27219D70BDB0B9608EAB28F41BF8")
    
public void setEnabledCompressionMethods(String[] methods) {
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
    }

    /**
     * This method enables session ticket support.
     *
     * @param useSessionTickets True to enable session tickets
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.507 -0500", hash_original_method = "1BC96C488FBD7622E9D1B33430C794F4", hash_generated_method = "F5DACF14A2AFA75883A2166361BD2571")
    
public void setUseSessionTickets(boolean useSessionTickets) {
        this.useSessionTickets = useSessionTickets;
    }

    /**
     * This method enables Server Name Indication
     *
     * @param hostname the desired SNI hostname, or null to disable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.509 -0500", hash_original_method = "A3C6DFBE0DD33FFBDB883F2D56D0E9E8", hash_generated_method = "E1E92B40ADCD1A6D8A2667618A9736B6")
    
public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.511 -0500", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "C189C4A91AE7529C93E5FE1A68636F7D")
    
@Override public boolean getUseClientMode() {
        return sslParameters.getUseClientMode();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.513 -0500", hash_original_method = "796A366B3F70011E31FF500388066E2F", hash_generated_method = "DD2B09427C90AA110167FA1F9789AFAE")
    
@Override public void setUseClientMode(boolean mode) {
        if (handshakeStarted) {
            throw new IllegalArgumentException(
                    "Could not change the mode after the initial handshake has begun.");
        }
        sslParameters.setUseClientMode(mode);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.516 -0500", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "C498EFFB7EA33937BE58E3D8E2A82C77")
    
@Override public boolean getWantClientAuth() {
        return sslParameters.getWantClientAuth();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.519 -0500", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "1AC7C5FF07516804848811840A468A8B")
    
@Override public boolean getNeedClientAuth() {
        return sslParameters.getNeedClientAuth();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.522 -0500", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "C446CA4D04BF46EBA63D06A750C2C8C1")
    
@Override public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.524 -0500", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "21E8FF7B7CE0E4FB146B4F3F0EE91E86")
    
@Override public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.526 -0500", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "B7DDBD1D342472346CC4D037D1CE3585")
    
@Override public void sendUrgentData(int data) throws IOException {
        throw new SocketException("Method sendUrgentData() is not supported.");
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.529 -0500", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "B9FF049CD8864259C2E7D0184D2DD414")
    
@Override public void setOOBInline(boolean on) throws SocketException {
        throw new SocketException("Methods sendUrgentData, setOOBInline are not supported.");
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.531 -0500", hash_original_method = "E02183BB387F9960402CB70797EE289E", hash_generated_method = "32B36D8D7361BAC8ED0E0F8D32011628")
    
@Override public void setSoTimeout(int timeoutMilliseconds) throws SocketException {
        super.setSoTimeout(timeoutMilliseconds);
        this.timeoutMilliseconds = timeoutMilliseconds;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.533 -0500", hash_original_method = "5DC72E2D363A272A051BD7C43DA762A2", hash_generated_method = "D32334B4CD482D6200A332CBDFCB967B")
    
@Override public int getSoTimeout() throws SocketException {
        return timeoutMilliseconds;
    }

    /**
     * Set the handshake timeout on this socket.  This timeout is specified in
     * milliseconds and will be used only during the handshake process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.536 -0500", hash_original_method = "CE465C7A533FEAB3164F103F1DBDF364", hash_generated_method = "747AF37C74AD7B6CAD9B0868C1AB3233")
    
public void setHandshakeTimeout(int timeoutMilliseconds) throws SocketException {
        this.handshakeTimeoutMilliseconds = timeoutMilliseconds;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.539 -0500", hash_original_method = "B24ED3F34169856B1F2602ADA3894B40", hash_generated_method = "A80605B25B40A3072796A70B81151DC2")
    
@Override public void close() throws IOException {
        // TODO: Close SSL sockets using a background thread so they close gracefully.

        synchronized (handshakeLock) {
            if (!handshakeStarted) {
                // prevent further attempts to start handshake
                handshakeStarted = true;

                synchronized (this) {
                    free();

                    if (socket != this) {
                        if (autoClose && !socket.isClosed()) socket.close();
                    } else {
                        if (!super.isClosed()) super.close();
                    }
                }

                return;
            }
        }

        NativeCrypto.SSL_interrupt(sslNativePointer);

        synchronized (this) {
            synchronized (writeLock) {
                synchronized (readLock) {

                    // Shut down the SSL connection, per se.
                    try {
                        if (handshakeStarted) {
                            BlockGuard.getThreadPolicy().onNetwork();
                            NativeCrypto.SSL_shutdown(sslNativePointer, socket.getFileDescriptor$(),
                                    this);
                        }
                    } catch (IOException ignored) {
                        /*
                         * Note that although close() can throw
                         * IOException, the RI does not throw if there
                         * is problem sending a "close notify" which
                         * can happen if the underlying socket is closed.
                         */
                    } finally {
                        /*
                         * Even if the above call failed, it is still safe to free
                         * the native structs, and we need to do so lest we leak
                         * memory.
                         */
                        free();

                        if (socket != this) {
                            if (autoClose && !socket.isClosed()) {
                                socket.close();
                            }
                        } else {
                            if (!super.isClosed()) {
                                super.close();
                            }
                        }
                    }
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.541 -0500", hash_original_method = "0B5EFC2C593350712C0760AFE47F069D", hash_generated_method = "DF748779C8DC18F4B07A6D990E480B29")
    
private void free() {
        if (sslNativePointer == 0) {
            return;
        }
        NativeCrypto.SSL_free(sslNativePointer);
        sslNativePointer = 0;
        guard.close();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.543 -0500", hash_original_method = "48478F0D5C609BA19837DA284D888FF0", hash_generated_method = "082623D36BB08A27362F90E4DF4CDA8E")
    
@Override protected void finalize() throws Throwable {
        try {
            /*
             * Just worry about our own state. Notably we do not try and
             * close anything. The SocketImpl, either our own
             * PlainSocketImpl, or the Socket we are wrapping, will do
             * that. This might mean we do not properly SSL_shutdown, but
             * if you want to do that, properly close the socket yourself.
             *
             * The reason why we don't try to SSL_shutdown, is that there
             * can be a race between finalizers where the PlainSocketImpl
             * finalizer runs first and closes the socket. However, in the
             * meanwhile, the underlying file descriptor could be reused
             * for another purpose. If we call SSL_shutdown, the
             * underlying socket BIOs still have the old file descriptor
             * and will write the close notify to some unsuspecting
             * reader.
             */
            if (guard != null) {
                guard.warnIfOpen();
            }
            free();
        } finally {
            super.finalize();
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.546 -0500", hash_original_method = "E6BCE3543B6D551909C5B870C6A9DC54", hash_generated_method = "EDAEE0423D9B231EEFFA718C2EB95FD7")
    
@Override
    public FileDescriptor getFileDescriptor$() {
        if (socket == this) {
            return super.getFileDescriptor$();
        } else {
            return socket.getFileDescriptor$();
        }
    }
    
    private class SSLInputStream extends InputStream {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.454 -0500", hash_original_method = "B153503C58DDB9DC7588696F0617BD77", hash_generated_method = "16F7E00F57CCEFC91E5AB324805F2083")
        
SSLInputStream() throws IOException {
            /**
            /* Note: When startHandshake() throws an exception, no
             * SSLInputStream object will be created.
             */
            OpenSSLSocketImpl.this.startHandshake(false);
        }

        /**
         * Reads one byte. If there is no data in the underlying buffer,
         * this operation can block until the data will be
         * available.
         * @return read value.
         * @throws <code>IOException</code>
         */
        @DSSource({DSSourceKind.NETWORK})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.457 -0500", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "259E44B8B64C1FF49A2A2EC42CFB5CBE")
        
@Override
        public int read() throws IOException {
            return Streams.readSingleByte(this);
        }

        /**
         * Method acts as described in spec for superclass.
         * @see java.io.InputStream#read(byte[],int,int)
         */
        @DSSpec(DSCat.IO)
        @DSSource({DSSourceKind.IO})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.459 -0500", hash_original_method = "DB2A9854396CBE443BE0852C07C28BD2", hash_generated_method = "ECBC97609AB96B474232BAA571BAA079")
        
@Override
        public int read(byte[] buf, int offset, int byteCount) throws IOException {
            BlockGuard.getThreadPolicy().onNetwork();
            synchronized (readLock) {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                if (byteCount == 0) {
                    return 0;
                }
                return NativeCrypto.SSL_read(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount, getSoTimeout());
            }
        }
        
    }
    
    private class SSLOutputStream extends OutputStream {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.464 -0500", hash_original_method = "1E1541DFFE880DA1B7719D7E370B4D89", hash_generated_method = "4443FB3358873B4291D48BB3A1033CEF")
        
SSLOutputStream() throws IOException {
            /**
            /* Note: When startHandshake() throws an exception, no
             * SSLOutputStream object will be created.
             */
            OpenSSLSocketImpl.this.startHandshake(false);
        }

        /**
         * Method acts as described in spec for superclass.
         * @see java.io.OutputStream#write(int)
         */
        @DSSpec(DSCat.IO)
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.466 -0500", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "2F6F8FCE8DC2AA447CE6E550ABE70F33")
        
@Override
        public void write(int oneByte) throws IOException {
            Streams.writeSingleByte(this, oneByte);
        }

        /**
         * Method acts as described in spec for superclass.
         * @see java.io.OutputStream#write(byte[],int,int)
         */
        @DSSink({DSSinkKind.NETWORK})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:09.469 -0500", hash_original_method = "D98A6CBE7C5513FE6A9CDBBB263207DD", hash_generated_method = "3497AA2BACB57E1B8AC8F3075A18C057")
        
@Override
        public void write(byte[] buf, int offset, int byteCount) throws IOException {
            BlockGuard.getThreadPolicy().onNetwork();
            synchronized (writeLock) {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                if (byteCount == 0) {
                    return;
                }
                NativeCrypto.SSL_write(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount);
            }
        }
        
    }
    
}

