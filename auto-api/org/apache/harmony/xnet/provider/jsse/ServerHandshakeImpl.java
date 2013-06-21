package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PrivilegedExceptionAction;
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
    private PrivateKey privKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.362 -0400", hash_original_method = "3AF97CBDFDCCD2B098621E28E1AC9FE5", hash_generated_method = "9BB867BE670D109AD682F66A85E5F94E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerHandshakeImpl(Object owner) {
        super(owner);
        dsTaint.addTaint(owner.dsTaint);
        status = NEED_UNWRAP;
        // ---------- Original Method ----------
        //status = NEED_UNWRAP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.362 -0400", hash_original_method = "324CE8CF3B7F222FC5B16C98F36DFFC3", hash_generated_method = "5830822045DD7FB0B140C73F79077942")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void start() {
        {
            status = NEED_UNWRAP;
        } //End block
        sendHelloRequest();
        status = NEED_UNWRAP;
        // ---------- Original Method ----------
        //if (session == null) { 
            //status = NEED_UNWRAP;
            //return; 
        //}
        //if (clientHello != null && this.status != FINISHED) {
            //return; 
        //}
        //sendHelloRequest();
        //status = NEED_UNWRAP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.364 -0400", hash_original_method = "C84D4DEAC8EBB3DD7197C18B29E2CDCD", hash_generated_method = "284BD6E9894EFF1F26BBE765B1E6FD33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unwrap(byte[] bytes) {
        dsTaint.addTaint(bytes[0]);
        io_stream.append(bytes);
        {
            boolean var3E10622B97BCC076CCF7AB0ED953F160_481404367 = (io_stream.available() > 0);
            {
                int handshakeType;
                int length;
                io_stream.mark();
                try 
                {
                    handshakeType = io_stream.read();
                    length = io_stream.readUint24();
                    {
                        boolean var3C679A8AB58B6F3598AA40A6769F2283_1432547693 = (io_stream.available() < length);
                        {
                            io_stream.reset();
                        } //End block
                    } //End collapsed parenthetic
                    //Begin case 1 
                    {
                        unexpectedMessage();
                    } //End block
                    //End case 1 
                    //Begin case 1 
                    needSendHelloRequest = false;
                    //End case 1 
                    //Begin case 1 
                    clientHello = new ClientHello(io_stream, length);
                    //End case 1 
                    //Begin case 1 
                    {
                        delegatedTasks.add(new DelegatedTask(new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.363 -0400", hash_original_method = "E7C0517DE997CD5395D0C07C8E102134", hash_generated_method = "BB36F1EA52E00860AED4267A4F6A4F59")
                            //DSFIXME:  CODE0002: Requires DSC value to be set
                            public void run() {
                                processClientHello();
                                // ---------- Original Method ----------
                                //processClientHello();
                            }
}, this));
                    } //End block
                    //End case 1 
                    //Begin case 1 
                    processClientHello();
                    //End case 1 
                    //Begin case 11 
                    {
                        unexpectedMessage();
                    } //End block
                    //End case 11 
                    //Begin case 11 
                    clientCert = new CertificateMessage(io_stream, length);
                    //End case 11 
                    //Begin case 11 
                    {
                        {
                            boolean varC9E6F6858148ADCAF20C359360060880_1287205040 = (parameters.getNeedClientAuth());
                            {
                                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                       "HANDSHAKE FAILURE: no client certificate received");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        String authType;
                        authType = clientCert.getAuthType();
                        try 
                        {
                            parameters.getTrustManager().checkClientTrusted(
                                    clientCert.certs, authType);
                        } //End block
                        catch (CertificateException e)
                        {
                            fatalAlert(AlertProtocol.BAD_CERTIFICATE,
                                       "Untrusted Client Certificate ", e);
                        } //End block
                        session.peerCertificates = clientCert.certs;
                    } //End block
                    //End case 11 
                    //Begin case 15 
                    {
                        boolean varAF8A39DE161C8E9974E0BB444210F44E_1373833059 = (isResuming
                            || clientKeyExchange == null
                            || clientCert == null
                            || clientKeyExchange.isEmpty() 
                            || certificateVerify != null
                            || changeCipherSpecReceived);
                        {
                            unexpectedMessage();
                        } //End block
                    } //End collapsed parenthetic
                    //End case 15 
                    //Begin case 15 
                    certificateVerify = new CertificateVerify(io_stream, length);
                    //End case 15 
                    //Begin case 15 
                    String authType;
                    authType = clientCert.getAuthType();
                    //End case 15 
                    //Begin case 15 
                    DigitalSignature ds;
                    ds = new DigitalSignature(authType);
                    //End case 15 
                    //Begin case 15 
                    ds.init(clientCert.certs[0]);
                    //End case 15 
                    //Begin case 15 
                    byte[] md5_hash;
                    md5_hash = null;
                    //End case 15 
                    //Begin case 15 
                    byte[] sha_hash;
                    sha_hash = null;
                    //End case 15 
                    //Begin case 15 
                    {
                        boolean var18EB7A6B16B91D37B5C220ED2903A1D8_1750796521 = ("RSA".equals(authType));
                        {
                            md5_hash = io_stream.getDigestMD5withoutLast();
                            sha_hash = io_stream.getDigestSHAwithoutLast();
                        } //End block
                        {
                            boolean varB51211E32FDC16700AE71AA3387C9B7E_266404993 = ("DSA".equals(authType));
                            {
                                sha_hash = io_stream.getDigestSHAwithoutLast();
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    //End case 15 
                    //Begin case 15 
                    ds.setMD5(md5_hash);
                    //End case 15 
                    //Begin case 15 
                    ds.setSHA(sha_hash);
                    //End case 15 
                    //Begin case 15 
                    {
                        boolean varC7AD4571E6594DD19A4D11C5E6620F52_576700265 = (!ds.verifySignature(certificateVerify.signedHash));
                        {
                            fatalAlert(AlertProtocol.DECRYPT_ERROR,
                                   "DECRYPT ERROR: CERTIFICATE_VERIFY incorrect signature");
                        } //End block
                    } //End collapsed parenthetic
                    //End case 15 
                    //Begin case 16 
                    {
                        boolean var1C9CDB327E63AB6978798DE98C250E92_1006652928 = (isResuming
                            || serverHelloDone == null
                            || clientKeyExchange != null
                            || (clientCert == null && parameters.getNeedClientAuth()));
                        {
                            unexpectedMessage();
                        } //End block
                    } //End collapsed parenthetic
                    //End case 16 
                    //Begin case 16 
                    {
                        clientKeyExchange = new ClientKeyExchange(io_stream,
                                length, serverHello.server_version[1] == 1,
                                true);
                        Cipher c;
                        c = null;
                        try 
                        {
                            c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                            c.init(Cipher.DECRYPT_MODE, privKey);
                            preMasterSecret = c.doFinal(clientKeyExchange.exchange_keys);
                            {
                                preMasterSecret = new byte[48];
                                parameters.getSecureRandom().nextBytes(
                                        preMasterSecret);
                            } //End block
                        } //End block
                        catch (Exception e)
                        {
                            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                                       "INTERNAL ERROR", e);
                        } //End block
                    } //End block
                    {
                        clientKeyExchange = new ClientKeyExchange(io_stream,
                                length, serverHello.server_version[1] == 1,
                                false);
                        {
                            boolean var1794A2760AB9467B1447369EA82A03F5_2088736091 = (clientKeyExchange.isEmpty());
                            {
                                preMasterSecret = ((DHPublicKey) clientCert.certs[0].getPublicKey()).getY().toByteArray();
                            } //End block
                            {
                                try 
                                {
                                    KeyFactory kf;
                                    kf = KeyFactory.getInstance("DH");
                                    KeyAgreement agreement;
                                    agreement = KeyAgreement.getInstance("DH");
                                    PublicKey clientPublic;
                                    clientPublic = kf.generatePublic(new DHPublicKeySpec(
                                                new BigInteger(
                                                        1,
                                                        clientKeyExchange.exchange_keys),
                                                serverKeyExchange.par1,
                                                serverKeyExchange.par2));
                                    agreement.init(privKey);
                                    agreement.doPhase(clientPublic, true);
                                    preMasterSecret = agreement.generateSecret();
                                } //End block
                                catch (Exception e)
                                {
                                    fatalAlert(AlertProtocol.INTERNAL_ERROR,
                                           "INTERNAL ERROR", e);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    //End case 16 
                    //Begin case 16 
                    computerMasterSecret();
                    //End case 16 
                    //Begin case 20 
                    {
                        unexpectedMessage();
                    } //End block
                    //End case 20 
                    //Begin case 20 
                    clientFinished = new Finished(io_stream, length);
                    //End case 20 
                    //Begin case 20 
                    verifyFinished(clientFinished.getData());
                    //End case 20 
                    //Begin case 20 
                    session.context = parameters.getServerSessionContext();
                    //End case 20 
                    //Begin case 20 
                    parameters.getServerSessionContext().putSession(session);
                    //End case 20 
                    //Begin case 20 
                    {
                        sendChangeCipherSpec();
                    } //End block
                    {
                        session.lastAccessedTime = System.currentTimeMillis();
                        status = FINISHED;
                    } //End block
                    //End case 20 
                    //Begin case default 
                    unexpectedMessage();
                    //End case default 
                } //End block
                catch (IOException e)
                {
                    io_stream.reset();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.365 -0400", hash_original_method = "866A772D6B919D9D55F9FB0C6E40CB44", hash_generated_method = "AEE1B8F219CD36E4F5B25B5B22FD0618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unwrapSSLv2(byte[] bytes) {
        dsTaint.addTaint(bytes[0]);
        io_stream.append(bytes);
        io_stream.mark();
        try 
        {
            clientHello = new ClientHello(io_stream);
        } //End block
        catch (IOException e)
        {
            io_stream.reset();
        } //End block
        {
            delegatedTasks.add(new DelegatedTask(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.365 -0400", hash_original_method = "E7C0517DE997CD5395D0C07C8E102134", hash_generated_method = "BB36F1EA52E00860AED4267A4F6A4F59")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    processClientHello();
                    // ---------- Original Method ----------
                    //processClientHello();
                }
}, this));
        } //End block
        processClientHello();
        // ---------- Original Method ----------
        //io_stream.append(bytes);
        //io_stream.mark();
        //try {
            //clientHello = new ClientHello(io_stream);
        //} catch (IOException e) {
            //io_stream.reset();
            //return;
        //}
        //if (nonBlocking) {
            //delegatedTasks.add(new DelegatedTask(new Runnable() {
                //public void run() {
                    //processClientHello();
                //}
            //}, this));
            //return;
        //}
        //processClientHello();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.368 -0400", hash_original_method = "1EE7C68A79581646D3317E6FF35ECA2F", hash_generated_method = "341A5AA27F128AACF1B1F7D61D5226A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void processClientHello() {
        CipherSuite cipher_suite;
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                       "HANDSHAKE FAILURE. Incorrect client hello message");
        } //End block
        {
            boolean varEC4BF2D3C932DCD54126C3E7DEC7E78C_1960268947 = (!ProtocolVersion.isSupported(clientHello.client_version));
            {
                fatalAlert(AlertProtocol.PROTOCOL_VERSION,
                       "PROTOCOL VERSION. Unsupported client version "
                       + clientHello.client_version[0]
                       + clientHello.client_version[1]);
            } //End block
        } //End collapsed parenthetic
        isResuming = false;
        {
            SSLSessionImpl sessionToResume;
            boolean reuseCurrent;
            reuseCurrent = false;
            {
                boolean varC3EB608F958704B01CF5FA7FBCC3C70C_955655214 = (session != null
                    && Arrays.equals(session.id, clientHello.session_id));
                {
                    {
                        boolean var7005234DDBB3DCCE3DD5152EB36CF43C_304599216 = (session.isValid());
                        {
                            isResuming = true;
                        } //End block
                    } //End collapsed parenthetic
                    reuseCurrent = true;
                } //End block
            } //End collapsed parenthetic
            sessionToResume = findSessionToResume(clientHello.session_id);
            {
                boolean var4A069E5C70DBDCFA67B5FC703A18CEA8_1670607487 = (sessionToResume == null || !sessionToResume.isValid());
                {
                    {
                        boolean var72B825718E86CFDC2D1ACE8C15EF1B82_1102755561 = (!parameters.getEnableSessionCreation());
                        {
                            {
                                sendWarningAlert(AlertProtocol.NO_RENEGOTIATION);
                                status = NOT_HANDSHAKING;
                                clearMessages();
                            } //End block
                            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "SSL Session may not be created");
                        } //End block
                    } //End collapsed parenthetic
                    session = null;
                } //End block
                {
                    session = (SSLSessionImpl)sessionToResume.clone();
                    isResuming = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            cipher_suite = session.cipherSuite;
            {
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var18D4044EAC2BBBA188F56165F5E80AD5_111627505 = (cipher_suite.equals(clientHello.cipher_suites[i]));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                           "HANDSHAKE FAILURE. Incorrect client hello message");
            } //End block
        } //End block
        {
            cipher_suite = selectSuite(clientHello.cipher_suites);
            {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "HANDSHAKE FAILURE. NO COMMON SUITE");
            } //End block
            {
                boolean var1D30D9F66EF381050E56475097F3FC84_977655912 = (!parameters.getEnableSessionCreation());
                {
                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                           "SSL Session may not be created");
                } //End block
            } //End collapsed parenthetic
            session = new SSLSessionImpl(cipher_suite, parameters.getSecureRandom());
            {
                session.setPeer(engineOwner.getPeerHost(), engineOwner.getPeerPort());
            } //End block
            {
                session.setPeer(socketOwner.getInetAddress().getHostName(), socketOwner.getPort());
            } //End block
        } //End block
        recordProtocol.setVersion(clientHello.client_version);
        session.protocol = ProtocolVersion.getByVersion(clientHello.client_version);
        session.clientRandom = clientHello.random;
        serverHello = new ServerHello(parameters.getSecureRandom(),
                clientHello.client_version,
                session.getId(), cipher_suite, (byte) 0);
        session.serverRandom = serverHello.random;
        send(serverHello);
        {
            sendChangeCipherSpec();
        } //End block
        {
            boolean varB1B44AAE4AABDE77268F565DF69F2509_1930053692 = (!cipher_suite.isAnonymous());
            {
                X509Certificate[] certs;
                certs = null;
                String certType;
                certType = cipher_suite.getServerKeyType();
                {
                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "NO CERT TYPE FOR " + cipher_suite.getName());
                } //End block
                String alias;
                alias = null;
                X509KeyManager km;
                km = parameters.getKeyManager();
                {
                    X509ExtendedKeyManager ekm;
                    ekm = (X509ExtendedKeyManager)km;
                    {
                        alias = ekm.chooseServerAlias(certType, null,
                            this.socketOwner);
                    } //End block
                    {
                        alias = ekm.chooseEngineServerAlias(certType, null,
                            this.engineOwner);
                    } //End block
                    {
                        certs = ekm.getCertificateChain(alias);
                    } //End block
                } //End block
                {
                    alias = km.chooseServerAlias(certType, null, this.socketOwner);
                    {
                        certs = km.getCertificateChain(alias);
                    } //End block
                } //End block
                {
                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "NO SERVER CERTIFICATE FOUND");
                } //End block
                session.localCertificates = certs;
                serverCert = new CertificateMessage(certs);
                privKey = km.getPrivateKey(alias);
                send(serverCert);
            } //End block
        } //End collapsed parenthetic
        RSAPublicKey rsakey;
        rsakey = null;
        DHPublicKeySpec dhkeySpec;
        dhkeySpec = null;
        byte[] hash;
        hash = null;
        BigInteger p;
        p = null;
        BigInteger g;
        g = null;
        KeyPairGenerator kpg;
        kpg = null;
        try 
        {
            {
                PublicKey pk;
                pk = serverCert.certs[0].getPublicKey();
                {
                    boolean var0EBE03D98DFAA869597C67152383F614_64896777 = (getRSAKeyLength(pk) > 512);
                    {
                        kpg = KeyPairGenerator.getInstance("RSA");
                        kpg.initialize(512);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                kpg = KeyPairGenerator.getInstance("DH");
                p = new BigInteger(1, DHParameters.getPrime());
                g = new BigInteger("2");
                DHParameterSpec spec;
                spec = new DHParameterSpec(p, g);
                kpg.initialize(spec);
            } //End block
        } //End block
        catch (Exception e)
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
        } //End block
        {
            DigitalSignature ds;
            ds = new DigitalSignature(cipher_suite.authType);
            KeyPair kp;
            kp = null;
            try 
            {
                kp = kpg.genKeyPair();
                {
                    rsakey = (RSAPublicKey) kp.getPublic();
                } //End block
                {
                    DHPublicKey dhkey;
                    dhkey = (DHPublicKey) kp.getPublic();
                    KeyFactory kf;
                    kf = KeyFactory.getInstance("DH");
                    dhkeySpec = kf.getKeySpec(dhkey, DHPublicKeySpec.class);
                } //End block
                {
                    boolean varEFCCB3C47B9AB7D0847DE50BC56806BC_1998553904 = (!cipher_suite.isAnonymous());
                    {
                        ds.init(privKey);
                        privKey = kp.getPrivate();
                        ds.update(clientHello.getRandom());
                        ds.update(serverHello.getRandom());
                        byte[] tmp;
                        byte[] tmpLength;
                        tmpLength = new byte[2];
                        {
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
                        } //End block
                        {
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
                        } //End block
                        hash = ds.sign();
                    } //End block
                    {
                        privKey = kp.getPrivate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (Exception e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
            } //End block
            {
                serverKeyExchange = new ServerKeyExchange(rsakey.getModulus(),
                        rsakey.getPublicExponent(), null, hash);
            } //End block
            {
                serverKeyExchange = new ServerKeyExchange(p,
                        g, dhkeySpec.getY(), hash);
            } //End block
            send(serverKeyExchange);
        } //End block
        {
            boolean var494316DEEDFDBEC0083E4AD7C074E8F6_2073712946 = (parameters.getWantClientAuth()
                || parameters.getNeedClientAuth());
            {
                X509Certificate[] accepted;
                try 
                {
                    X509TrustManager tm;
                    tm = parameters.getTrustManager();
                    accepted = tm.getAcceptedIssuers();
                } //End block
                catch (ClassCastException e)
                { }
                byte[] requestedClientCertTypes;
                certificateRequest = new CertificateRequest(
                    requestedClientCertTypes, accepted);
                send(certificateRequest);
            } //End block
        } //End collapsed parenthetic
        serverHelloDone = new ServerHelloDone();
        send(serverHelloDone);
        status = NEED_UNWRAP;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.369 -0400", hash_original_method = "B7CAA5254DC76CE96F66DEC8EF811F93", hash_generated_method = "DE799FB7134F2E87333CC07DE674A503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void makeFinished() {
        byte[] verify_data;
        boolean isTLS;
        isTLS = (serverHello.server_version[1] == 1);
        {
            verify_data = new byte[12];
            computerVerifyDataTLS("server finished", verify_data);
        } //End block
        {
            verify_data = new byte[36];
            computerVerifyDataSSLv3(SSLv3Constants.server, verify_data);
        } //End block
        serverFinished = new Finished(verify_data);
        send(serverFinished);
        {
            {
                computerReferenceVerifyDataTLS("client finished");
            } //End block
            {
                computerReferenceVerifyDataSSLv3(SSLv3Constants.client);
            } //End block
            status = NEED_UNWRAP;
        } //End block
        {
            session.lastAccessedTime = System.currentTimeMillis();
            status = FINISHED;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.369 -0400", hash_original_method = "1900CB4813DE311B701E9907815D7379", hash_generated_method = "93F4FA55E3B6CFCA832D57C9972A7521")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SSLSessionImpl findSessionToResume(byte[] session_id) {
        dsTaint.addTaint(session_id[0]);
        SSLSessionImpl varF5914B4ED92938D1BC566ED59623F647_1938301241 = ((SSLSessionImpl)parameters.getServerSessionContext().getSession(session_id));
        return (SSLSessionImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLSessionImpl)parameters.getServerSessionContext().getSession(session_id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.372 -0400", hash_original_method = "CED7C9E9124D8D76ECA389CBA359AC39", hash_generated_method = "D72358AF00F94B2FCD49BFEDDFEC7E14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CipherSuite selectSuite(CipherSuite[] clientSuites) {
        dsTaint.addTaint(clientSuites[0].dsTaint);
        {
            CipherSuite clientSuite = clientSuites[0];
            {
                {
                    CipherSuite enabledCipherSuite = parameters.getEnabledCipherSuitesMember()[0];
                    {
                        {
                            boolean varE93C96DE8A6190DA385CE0A2DCDCB29A_1524403492 = (clientSuite.equals(enabledCipherSuite));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (CipherSuite)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (CipherSuite clientSuite : clientSuites) {
            //if (!clientSuite.supported) {
                //continue;
            //}
            //for (CipherSuite enabledCipherSuite : parameters.getEnabledCipherSuitesMember()) {
                //if (clientSuite.equals(enabledCipherSuite)) {
                    //return clientSuite;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.372 -0400", hash_original_method = "C3331D73871F50BD7C19021D99D59A46", hash_generated_method = "6B74184A1D65D1B8B30BF7E85E58008F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void receiveChangeCipherSpec() {
        {
            {
                unexpectedMessage();
            } //End block
            {
                changeCipherSpecReceived = true;
            } //End block
        } //End block
        {
            {
                boolean varC71AB6B6C1F08637A92809E0C58EC3AD_1151712360 = ((parameters.getNeedClientAuth() && clientCert == null)
                    || clientKeyExchange == null
                    || (clientCert != null
                            && !clientKeyExchange.isEmpty()
                            && certificateVerify == null));
                {
                    unexpectedMessage();
                } //End block
                {
                    changeCipherSpecReceived = true;
                } //End block
            } //End collapsed parenthetic
            {
                computerReferenceVerifyDataTLS("client finished");
            } //End block
            {
                computerReferenceVerifyDataSSLv3(SSLv3Constants.client);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

