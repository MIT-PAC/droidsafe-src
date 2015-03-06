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


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

public class ServerHandshakeImpl extends HandshakeProtocol {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.857 -0500", hash_original_field = "9BA8921B2F332EF312E273931A2A17B1", hash_generated_field = "F778C7A1E11234387361395B9C2BAFEF")

    private PrivateKey privKey;

    /**
     * Creates Server Handshake Implementation
     *
     * @param owner
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.860 -0500", hash_original_method = "3AF97CBDFDCCD2B098621E28E1AC9FE5", hash_generated_method = "2455CF65E192FB55C11922832421064B")
    
public ServerHandshakeImpl(Object owner) {
        super(owner);
        status = NEED_UNWRAP;
    }

    /**
     * Start session negotiation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.862 -0500", hash_original_method = "324CE8CF3B7F222FC5B16C98F36DFFC3", hash_generated_method = "23D1B1DB72236D151D62668338636E7B")
    
@Override
    public void start() {
        if (session == null) { // initial handshake
            status = NEED_UNWRAP;
            return; // wait client hello
        }
        if (clientHello != null && this.status != FINISHED) {
            // current negotiation has not completed
            return; // ignore
        }

        // renegotiation
        sendHelloRequest();
        status = NEED_UNWRAP;
    }

    /**
     * Proceses inbound handshake messages
     * @param bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.872 -0500", hash_original_method = "C84D4DEAC8EBB3DD7197C18B29E2CDCD", hash_generated_method = "150F7CEC711DE079383B622AC9E88F89")
    
@Override
    public void unwrap(byte[] bytes) {

        io_stream.append(bytes);
        while (io_stream.available() > 0) {
            int handshakeType;
            int length;
            io_stream.mark();
            try {
                handshakeType = io_stream.read();
                length = io_stream.readUint24();
                if (io_stream.available() < length) {
                    io_stream.reset();
                    return;
                }

                switch (handshakeType) {
                case 1: // CLIENT_HELLO
                    if (clientHello != null && this.status != FINISHED) {
                            // Client hello has been received during handshake
                            unexpectedMessage();
                            return;
                    }
                    // if protocol planed to send Hello Request message
                    // - cancel this demand.
                    needSendHelloRequest = false;
                    clientHello = new ClientHello(io_stream, length);
                    if (nonBlocking) {
                        delegatedTasks.add(new DelegatedTask(new Runnable() {
                            @DSSafe(DSCat.SAFE_LIST)
        public void run() {
                                processClientHello();
                            }
                        }, this));
                        return;
                    }
                    processClientHello();
                    break;

                case 11: //    CLIENT CERTIFICATE
                    if (isResuming || certificateRequest == null
                            || serverHelloDone == null || clientCert != null) {
                        unexpectedMessage();
                        return;
                    }
                    clientCert = new CertificateMessage(io_stream, length);
                    if (clientCert.certs.length == 0) {
                        if (parameters.getNeedClientAuth()) {
                            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                       "HANDSHAKE FAILURE: no client certificate received");
                        }
                    } else {
                        String authType = clientCert.getAuthType();
                        try {
                            parameters.getTrustManager().checkClientTrusted(
                                    clientCert.certs, authType);
                        } catch (CertificateException e) {
                            fatalAlert(AlertProtocol.BAD_CERTIFICATE,
                                       "Untrusted Client Certificate ", e);
                        }
                        session.peerCertificates = clientCert.certs;
                    }
                    break;

                case 15: // CERTIFICATE_VERIFY
                    if (isResuming
                            || clientKeyExchange == null
                            || clientCert == null
                            || clientKeyExchange.isEmpty() //client certificate
                                                           // contains fixed DH
                                                           // parameters
                            || certificateVerify != null
                            || changeCipherSpecReceived) {
                        unexpectedMessage();
                        return;
                    }
                    certificateVerify = new CertificateVerify(io_stream, length);

                    String authType = clientCert.getAuthType();
                    DigitalSignature ds = new DigitalSignature(authType);
                    ds.init(clientCert.certs[0]);
                    byte[] md5_hash = null;
                    byte[] sha_hash = null;

                    if ("RSA".equals(authType)) {
                        md5_hash = io_stream.getDigestMD5withoutLast();
                        sha_hash = io_stream.getDigestSHAwithoutLast();
                    } else if ("DSA".equals(authType)) {
                        sha_hash = io_stream.getDigestSHAwithoutLast();
                    // The Signature should be empty in case of anonymous signature algorithm:
                    // } else if ("DH".equals(authType)) {
                    }
                    ds.setMD5(md5_hash);
                    ds.setSHA(sha_hash);
                    if (!ds.verifySignature(certificateVerify.signedHash)) {
                        fatalAlert(AlertProtocol.DECRYPT_ERROR,
                                   "DECRYPT ERROR: CERTIFICATE_VERIFY incorrect signature");
                    }
                    break;
                case 16: // CLIENT_KEY_EXCHANGE
                    if (isResuming
                            || serverHelloDone == null
                            || clientKeyExchange != null
                            || (clientCert == null && parameters.getNeedClientAuth())) {
                        unexpectedMessage();
                        return;
                    }
                    if (session.cipherSuite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA
                            || session.cipherSuite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT) {
                        clientKeyExchange = new ClientKeyExchange(io_stream,
                                length, serverHello.server_version[1] == 1,
                                true);
                        Cipher c = null;
                        try {
                            c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                            c.init(Cipher.DECRYPT_MODE, privKey);
                            preMasterSecret = c.doFinal(clientKeyExchange.exchange_keys);
                            // check preMasterSecret:
                            if (preMasterSecret.length != 48
                                    || preMasterSecret[0] != clientHello.client_version[0]
                                    || preMasterSecret[1] != clientHello.client_version[1]) {
                                // incorrect preMasterSecret
                                // prevent an attack (see TLS 1.0 spec., 7.4.7.1.)
                                preMasterSecret = new byte[48];
                                parameters.getSecureRandom().nextBytes(
                                        preMasterSecret);
                            }
                        } catch (Exception e) {
                            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                                       "INTERNAL ERROR", e);
                        }
                    } else { // diffie hellman key exchange
                        clientKeyExchange = new ClientKeyExchange(io_stream,
                                length, serverHello.server_version[1] == 1,
                                false);
                        if (clientKeyExchange.isEmpty()) {
                            // TODO check that client cert. DH params
                            // matched server cert. DH params

                            // client cert. contains fixed DH parameters
                            preMasterSecret = ((DHPublicKey) clientCert.certs[0].getPublicKey()).getY().toByteArray();
                        } else {
                            try {
                                KeyFactory kf = KeyFactory.getInstance("DH");
                                KeyAgreement agreement = KeyAgreement.getInstance("DH");
                                PublicKey clientPublic = kf.generatePublic(new DHPublicKeySpec(
                                                new BigInteger(
                                                        1,
                                                        clientKeyExchange.exchange_keys),
                                                serverKeyExchange.par1,
                                                serverKeyExchange.par2));
                                agreement.init(privKey);
                                agreement.doPhase(clientPublic, true);
                                preMasterSecret = agreement.generateSecret();
                            } catch (Exception e) {
                                fatalAlert(AlertProtocol.INTERNAL_ERROR,
                                           "INTERNAL ERROR", e);
                                return;
                            }
                        }
                    }

                    computerMasterSecret();
                    break;

                case 20: // FINISHED
                    if (!isResuming && !changeCipherSpecReceived) {
                        unexpectedMessage();
                        return;
                    }

                    clientFinished = new Finished(io_stream, length);
                    verifyFinished(clientFinished.getData());
                    session.context = parameters.getServerSessionContext();
                    parameters.getServerSessionContext().putSession(session);
                    if (!isResuming) {
                        sendChangeCipherSpec();
                    } else {
                        session.lastAccessedTime = System.currentTimeMillis();
                        status = FINISHED;
                    }
                    break;
                default:
                    unexpectedMessage();
                    return;
                }
            } catch (IOException e) {
                // io stream dosn't contain complete handshake message
                io_stream.reset();
                return;
            }
        }
    }
    /**
     * Processes SSLv2 Hello message
     * @ see TLS 1.0 spec., E.1. Version 2 client hello
     * @param bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.878 -0500", hash_original_method = "866A772D6B919D9D55F9FB0C6E40CB44", hash_generated_method = "2152E89EAA7412615C2E63E8AF235EDD")
    
@Override
    public void unwrapSSLv2(byte[] bytes) {
        io_stream.append(bytes);
        io_stream.mark();
        try {
            clientHello = new ClientHello(io_stream);
        } catch (IOException e) {
            io_stream.reset();
            return;
        }
        if (nonBlocking) {
            delegatedTasks.add(new DelegatedTask(new Runnable() {
                @DSSafe(DSCat.SAFE_LIST)
        public void run() {
                    processClientHello();
                }
            }, this));
            return;
        }
        processClientHello();
    }

    /**
     *
     * Processes Client Hello message.
     * Server responds to client hello message with server hello
     * and (if necessary) server certificate, server key exchange,
     * certificate request, and server hello done messages.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.885 -0500", hash_original_method = "1EE7C68A79581646D3317E6FF35ECA2F", hash_generated_method = "086A9D938367E6358DB7E7C1B324BC3D")
    
void processClientHello() {
        CipherSuite cipher_suite;

        // check that clientHello contains CompressionMethod.null
        checkCompression: {
            for (int i = 0; i < clientHello.compression_methods.length; i++) {
                if (clientHello.compression_methods[i] == 0) {
                    break checkCompression;
                }
            }
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                       "HANDSHAKE FAILURE. Incorrect client hello message");
        }

        if (!ProtocolVersion.isSupported(clientHello.client_version)) {
            fatalAlert(AlertProtocol.PROTOCOL_VERSION,
                       "PROTOCOL VERSION. Unsupported client version "
                       + clientHello.client_version[0]
                       + clientHello.client_version[1]);
        }

        isResuming = false;
        FIND: if (clientHello.session_id.length != 0) {
            // client wishes to reuse session

            SSLSessionImpl sessionToResume;
            boolean reuseCurrent = false;

            // reuse current session
            if (session != null
                    && Arrays.equals(session.id, clientHello.session_id)) {
                if (session.isValid()) {
                    isResuming = true;
                    break FIND;
                }
                reuseCurrent = true;
            }

            // find session in cash
            sessionToResume = findSessionToResume(clientHello.session_id);
            if (sessionToResume == null || !sessionToResume.isValid()) {
                if (!parameters.getEnableSessionCreation()) {
                    if (reuseCurrent) {
                        // we can continue current session
                        sendWarningAlert(AlertProtocol.NO_RENEGOTIATION);
                        status = NOT_HANDSHAKING;
                        clearMessages();
                        return;
                    }
                    // throw AlertException
                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "SSL Session may not be created");
                }
                session = null;
            } else {
                session = (SSLSessionImpl)sessionToResume.clone();
                isResuming = true;
            }
        }

        if (isResuming) {
            cipher_suite = session.cipherSuite;
            // clientHello.cipher_suites must include at least cipher_suite from the session
            checkCipherSuite: {
                for (int i = 0; i < clientHello.cipher_suites.length; i++) {
                    if (cipher_suite.equals(clientHello.cipher_suites[i])) {
                        break checkCipherSuite;
                    }
                }
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                           "HANDSHAKE FAILURE. Incorrect client hello message");
            }
        } else {
            cipher_suite = selectSuite(clientHello.cipher_suites);
            if (cipher_suite == null) {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "HANDSHAKE FAILURE. NO COMMON SUITE");
            }
            if (!parameters.getEnableSessionCreation()) {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                           "SSL Session may not be created");
            }
            session = new SSLSessionImpl(cipher_suite, parameters.getSecureRandom());
            if (engineOwner != null) {
                session.setPeer(engineOwner.getPeerHost(), engineOwner.getPeerPort());
            } else {
                session.setPeer(socketOwner.getInetAddress().getHostName(), socketOwner.getPort());
            }
        }

        recordProtocol.setVersion(clientHello.client_version);
        session.protocol = ProtocolVersion.getByVersion(clientHello.client_version);
        session.clientRandom = clientHello.random;

        // create server hello message
        serverHello = new ServerHello(parameters.getSecureRandom(),
                clientHello.client_version,
                session.getId(), cipher_suite, (byte) 0); //CompressionMethod.null
        session.serverRandom = serverHello.random;
        send(serverHello);
        if (isResuming) {
            sendChangeCipherSpec();
            return;
        }

        //    create and send server certificate message if needed
        if (!cipher_suite.isAnonymous()) { // need to send server certificate
            X509Certificate[] certs = null;
            String certType = cipher_suite.getServerKeyType();
            if (certType == null) {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "NO CERT TYPE FOR " + cipher_suite.getName());
            }
            // obtain certificates from key manager
            String alias = null;
            X509KeyManager km = parameters.getKeyManager();
            if (km instanceof X509ExtendedKeyManager) {
                X509ExtendedKeyManager ekm = (X509ExtendedKeyManager)km;
                if (this.socketOwner != null) {
                    alias = ekm.chooseServerAlias(certType, null,
                            this.socketOwner);
                } else {
                    alias = ekm.chooseEngineServerAlias(certType, null,
                            this.engineOwner);
                }
                if (alias != null) {
                    certs = ekm.getCertificateChain(alias);
                }
            } else {
                alias = km.chooseServerAlias(certType, null, this.socketOwner);
                if (alias != null) {
                    certs = km.getCertificateChain(alias);
                }
            }

            if (certs == null) {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "NO SERVER CERTIFICATE FOUND");
                return;
            }
            session.localCertificates = certs;
            serverCert = new CertificateMessage(certs);
            privKey = km.getPrivateKey(alias);
            send(serverCert);
        }

        // create and send server key exchange message if needed
        RSAPublicKey rsakey = null;
        DHPublicKeySpec dhkeySpec = null;
        byte[] hash = null;
        BigInteger p = null;
        BigInteger g = null;

        KeyPairGenerator kpg = null;

        try {
            if (cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT) {
                PublicKey pk = serverCert.certs[0].getPublicKey();
                if (getRSAKeyLength(pk) > 512) {
                    // key is longer than 512 bits
                    kpg = KeyPairGenerator.getInstance("RSA");
                    kpg.initialize(512);
                }
            } else if (cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_DSS
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_DSS_EXPORT
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_RSA
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_RSA_EXPORT
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DH_anon
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DH_anon_EXPORT) {
                kpg = KeyPairGenerator.getInstance("DH");
                p = new BigInteger(1, DHParameters.getPrime());
                g = new BigInteger("2");
                DHParameterSpec spec = new DHParameterSpec(p, g);
                kpg.initialize(spec);
            }
        } catch (Exception e) {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
        }

        if (kpg != null) {
            // need to send server key exchange message
            DigitalSignature ds = new DigitalSignature(cipher_suite.authType);
            KeyPair kp = null;
            try {
                kp = kpg.genKeyPair();
                if (cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT) {
                    rsakey = (RSAPublicKey) kp.getPublic();
                } else {
                    DHPublicKey dhkey = (DHPublicKey) kp.getPublic();
                    KeyFactory kf = KeyFactory.getInstance("DH");
                    dhkeySpec = kf.getKeySpec(dhkey, DHPublicKeySpec.class);
                }
                if (!cipher_suite.isAnonymous()) { // calculate signed_params

                    // init by private key which correspond to
                    // server certificate
                    ds.init(privKey);

                    // use emphemeral key for key exchange
                    privKey = kp.getPrivate();
                    ds.update(clientHello.getRandom());
                    ds.update(serverHello.getRandom());

                    byte[] tmp;
                    byte[] tmpLength = new byte[2];
//FIXME 1_byte==0x00
                    if (cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT) {
                        tmp = ServerKeyExchange.toUnsignedByteArray(rsakey.getModulus());
                        tmpLength[0] = (byte) ((tmp.length & 0xFF00) >>> 8);
                        tmpLength[1] = (byte) (tmp.length & 0xFF);
                        ds.update(tmpLength);
                        ds.update(tmp);
                        tmp = ServerKeyExchange.toUnsignedByteArray(rsakey.getPublicExponent());
                        tmpLength[0] = (byte) ((tmp.length & 0xFF00) >>> 8);
                        tmpLength[1] = (byte) (tmp.length & 0xFF);
                        ds.update(tmpLength);
                        ds.update(tmp);
                    } else {
                        tmp = ServerKeyExchange.toUnsignedByteArray(dhkeySpec.getP());
                        tmpLength[0] = (byte) ((tmp.length & 0xFF00) >>> 8);
                        tmpLength[1] = (byte) (tmp.length & 0xFF);
                        ds.update(tmpLength);
                        ds.update(tmp);
                        tmp = ServerKeyExchange.toUnsignedByteArray(dhkeySpec.getG());
                        tmpLength[0] = (byte) ((tmp.length & 0xFF00) >>> 8);
                        tmpLength[1] = (byte) (tmp.length & 0xFF);
                        ds.update(tmpLength);
                        ds.update(tmp);
                        tmp = ServerKeyExchange.toUnsignedByteArray(dhkeySpec.getY());
                        tmpLength[0] = (byte) ((tmp.length & 0xFF00) >>> 8);
                        tmpLength[1] = (byte) (tmp.length & 0xFF);
                        ds.update(tmpLength);
                        ds.update(tmp);
                    }
                    hash = ds.sign();
                } else {
                    privKey = kp.getPrivate(); // use emphemeral key for key exchange
                }
            } catch (Exception e) {
                fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
            }

            if (cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT) {
                serverKeyExchange = new ServerKeyExchange(rsakey.getModulus(),
                        rsakey.getPublicExponent(), null, hash);
            } else {
                serverKeyExchange = new ServerKeyExchange(p,
                        g, dhkeySpec.getY(), hash);
            }
            send(serverKeyExchange);
        }

        // CERTIFICATE_REQUEST
        certRequest: if (parameters.getWantClientAuth()
                || parameters.getNeedClientAuth()) {
            X509Certificate[] accepted;
            try {
                X509TrustManager tm = parameters.getTrustManager();
                accepted = tm.getAcceptedIssuers();
            } catch (ClassCastException e) {
                // don't send certificateRequest
                break certRequest;
            }
            byte[] requestedClientCertTypes = { CipherSuite.TLS_CT_RSA_SIGN,
                                                CipherSuite.TLS_CT_DSS_SIGN };
            certificateRequest = new CertificateRequest(
                    requestedClientCertTypes, accepted);
            send(certificateRequest);
        }

        // SERVER_HELLO_DONE
        serverHelloDone = new ServerHelloDone();
        send(serverHelloDone);
        status = NEED_UNWRAP;
    }

    /**
     * Creates and sends finished message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.888 -0500", hash_original_method = "B7CAA5254DC76CE96F66DEC8EF811F93", hash_generated_method = "C8138A9E2D479ADC662923C60CBB32D3")
    
@Override
    protected void makeFinished() {
        byte[] verify_data;
        boolean isTLS = (serverHello.server_version[1] == 1); // TLS 1.0 protocol
        if (isTLS) {
            verify_data = new byte[12];
            computerVerifyDataTLS("server finished", verify_data);
        } else { // SSL 3.0 protocol (http://wp.netscape.com/eng/ssl3)
            verify_data = new byte[36];
            computerVerifyDataSSLv3(SSLv3Constants.server, verify_data);
        }
        serverFinished = new Finished(verify_data);
        send(serverFinished);
        if (isResuming) {
            if (isTLS) {
                computerReferenceVerifyDataTLS("client finished");
            } else {
                computerReferenceVerifyDataSSLv3(SSLv3Constants.client);
            }
            status = NEED_UNWRAP;
        } else {
            session.lastAccessedTime = System.currentTimeMillis();
            status = FINISHED;
        }
    }

    // find sesssion in the session hash
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.891 -0500", hash_original_method = "1900CB4813DE311B701E9907815D7379", hash_generated_method = "D72A43C9B363D13A87AA4AED5103AFA4")
    
private SSLSessionImpl findSessionToResume(byte[] session_id) {
        return (SSLSessionImpl)parameters.getServerSessionContext().getSession(session_id);
    }

    // find appropriate cipher_suite in the client suites
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.893 -0500", hash_original_method = "CED7C9E9124D8D76ECA389CBA359AC39", hash_generated_method = "7DC0230207EAF3B1A908A92DFFE7622F")
    
private CipherSuite selectSuite(CipherSuite[] clientSuites) {
        for (CipherSuite clientSuite : clientSuites) {
            if (!clientSuite.supported) {
                continue;
            }
            for (CipherSuite enabledCipherSuite : parameters.getEnabledCipherSuitesMember()) {
                if (clientSuite.equals(enabledCipherSuite)) {
                    return clientSuite;
                }
            }
        }
        return null;
    }

    /**
     * Processes inbound ChangeCipherSpec message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.896 -0500", hash_original_method = "C3331D73871F50BD7C19021D99D59A46", hash_generated_method = "C7C216D10BC9308CDAAF149A21EDA914")
    
@Override
    public void receiveChangeCipherSpec() {
        if (isResuming) {
            if (serverFinished == null) {
                unexpectedMessage();
            } else {
                changeCipherSpecReceived = true;
            }
        } else {
            if ((parameters.getNeedClientAuth() && clientCert == null)
                    || clientKeyExchange == null
                    || (clientCert != null
                            && !clientKeyExchange.isEmpty()
                            && certificateVerify == null)) {
                unexpectedMessage();
            } else {
                changeCipherSpecReceived = true;
            }
            if (serverHello.server_version[1] == 1) {
                computerReferenceVerifyDataTLS("client finished");
            } else {
                computerReferenceVerifyDataSSLv3(SSLv3Constants.client);
            }
        }
    }
    
}

