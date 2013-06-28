package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.AccessController;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PrivilegedExceptionAction;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

public class ClientHandshakeImpl extends HandshakeProtocol {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.832 -0400", hash_original_method = "E7725F54B70B03AB684209C7F7E63A02", hash_generated_method = "FEEBAC8AF1F679A50E59BF09FC15BB2E")
      ClientHandshakeImpl(Object owner) {
        super(owner);
        addTaint(owner.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.832 -0400", hash_original_method = "6C060C09ED0246441EBDE47DFEF048B2", hash_generated_method = "731401485E0AF54524D40DE99664ADF3")
    @Override
    public void start() {
        {
            session = findSessionToResume();
        } //End block
        {
            {
                boolean var8B18667FF77A0CB7D73ABD460F702593_857356732 = (!session.isValid());
                {
                    session = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            isResuming = true;
        } //End block
        {
            boolean var72F442C9AE4C231AB0300FF37576E182_1587547098 = (parameters.getEnableSessionCreation());
            {
                isResuming = false;
                session = new SSLSessionImpl(parameters.getSecureRandom());
                {
                    session.setPeer(engineOwner.getPeerHost(), engineOwner.getPeerPort());
                } //End block
                {
                    session.setPeer(socketOwner.getInetAddress().getHostName(), socketOwner.getPort());
                } //End block
                session.protocol = ProtocolVersion.getLatestVersion(parameters.getEnabledProtocols());
                recordProtocol.setVersion(session.protocol.version);
            } //End block
            {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "SSL Session may not be created ");
            } //End block
        } //End collapsed parenthetic
        startSession();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.833 -0400", hash_original_method = "A1AF1BC51EE82C9340D705103AD7A155", hash_generated_method = "F81E5FC8D223879EF3D35E16D4705C21")
    private void renegotiateNewSession() {
        {
            boolean var72F442C9AE4C231AB0300FF37576E182_364744808 = (parameters.getEnableSessionCreation());
            {
                isResuming = false;
                session = new SSLSessionImpl(parameters.getSecureRandom());
                {
                    session.setPeer(engineOwner.getPeerHost(), engineOwner.getPeerPort());
                } //End block
                {
                    session.setPeer(socketOwner.getInetAddress().getHostName(), socketOwner.getPort());
                } //End block
                session.protocol = ProtocolVersion.getLatestVersion(parameters.getEnabledProtocols());
                recordProtocol.setVersion(session.protocol.version);
                startSession();
            } //End block
            {
                status = NOT_HANDSHAKING;
                sendWarningAlert(AlertProtocol.NO_RENEGOTIATION);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (parameters.getEnableSessionCreation()){
            //isResuming = false;
            //session = new SSLSessionImpl(parameters.getSecureRandom());
            //if (engineOwner != null) {
                //session.setPeer(engineOwner.getPeerHost(), engineOwner.getPeerPort());
            //} else {
                //session.setPeer(socketOwner.getInetAddress().getHostName(), socketOwner.getPort());
            //}
            //session.protocol = ProtocolVersion.getLatestVersion(parameters.getEnabledProtocols());
            //recordProtocol.setVersion(session.protocol.version);
            //startSession();
        //} else {
            //status = NOT_HANDSHAKING;
            //sendWarningAlert(AlertProtocol.NO_RENEGOTIATION);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.834 -0400", hash_original_method = "FFCAFC294E61749148CA1FC19A14A2BB", hash_generated_method = "24CC0C7619460197D68A24E6D0B33A4E")
    private void startSession() {
        CipherSuite[] cipher_suites;
        {
            cipher_suites = new CipherSuite[] { session.cipherSuite };
        } //End block
        {
            cipher_suites = parameters.getEnabledCipherSuitesMember();
        } //End block
        clientHello = new ClientHello(parameters.getSecureRandom(),
                session.protocol.version, session.id, cipher_suites);
        session.clientRandom = clientHello.random;
        send(clientHello);
        status = NEED_UNWRAP;
        // ---------- Original Method ----------
        //CipherSuite[] cipher_suites;
        //if (isResuming) {
            //cipher_suites = new CipherSuite[] { session.cipherSuite };
        //} else {
            //cipher_suites = parameters.getEnabledCipherSuitesMember();
        //}
        //clientHello = new ClientHello(parameters.getSecureRandom(),
                //session.protocol.version, session.id, cipher_suites);
        //session.clientRandom = clientHello.random;
        //send(clientHello);
        //status = NEED_UNWRAP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.837 -0400", hash_original_method = "A389390FF4680222C458E1D6E9083717", hash_generated_method = "36876201415DD47868564450E0A3BEBE")
    @Override
    public void unwrap(byte[] bytes) {
        {
            Exception e = this.delegatedTaskErr;
            this.delegatedTaskErr = null;
            this.fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Error in delegated task", e);
        } //End block
        int handshakeType;
        io_stream.append(bytes);
        {
            boolean var3E10622B97BCC076CCF7AB0ED953F160_695472220 = (io_stream.available() > 0);
            {
                io_stream.mark();
                int length;
                try 
                {
                    handshakeType = io_stream.read();
                    length = io_stream.readUint24();
                    {
                        boolean var3C679A8AB58B6F3598AA40A6769F2283_407308657 = (io_stream.available() < length);
                        {
                            io_stream.reset();
                        } //End block
                    } //End collapsed parenthetic
                    //Begin case 0 
                    io_stream.removeFromMarkedPosition();
                    //End case 0 
                    //Begin case 0 
                    {
                        boolean var7005234DDBB3DCCE3DD5152EB36CF43C_353221274 = (session.isValid());
                        {
                            session = (SSLSessionImpl) session.clone();
                            isResuming = true;
                            startSession();
                        } //End block
                        {
                            renegotiateNewSession();
                        } //End block
                    } //End collapsed parenthetic
                    //End case 0 
                    //Begin case 2 
                    {
                        unexpectedMessage();
                    } //End block
                    //End case 2 
                    //Begin case 2 
                    serverHello = new ServerHello(io_stream, length);
                    //End case 2 
                    //Begin case 2 
                    ProtocolVersion servProt = ProtocolVersion.getByVersion(serverHello.server_version);
                    //End case 2 
                    //Begin case 2 
                    String[] enabled = parameters.getEnabledProtocols();
                    //End case 2 
                    //Begin case 2 
                    {
                        {
                            int i = 0;
                            {
                                {
                                    boolean var67D740701556DD1390C68C994122C886_1838902379 = (servProt.equals(ProtocolVersion.getByName(enabled[i])));
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                   "Bad server hello protocol version");
                    } //End block
                    //End case 2 
                    //Begin case 2 
                    {
                        fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                   "Bad server hello compression method");
                    } //End block
                    //End case 2 
                    //Begin case 2 
                    CipherSuite[] enabledSuites = parameters.getEnabledCipherSuitesMember();
                    //End case 2 
                    //Begin case 2 
                    {
                        {
                            int i = 0;
                            {
                                {
                                    boolean varAFA58D0F8A16216197521D121BC2E32B_1304399533 = (serverHello.cipher_suite.equals(enabledSuites[i]));
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                   "Bad server hello cipher suite");
                    } //End block
                    //End case 2 
                    //Begin case 2 
                    {
                        {
                            isResuming = false;
                        } //End block
                        {
                            boolean var44246D67BD6DB36A076ED2DAE568E498_1587700226 = (!Arrays.equals(serverHello.session_id, clientHello.session_id));
                            {
                                isResuming = false;
                            } //End block
                            {
                                boolean var98C6C21198FF318F1ED4CE74A112A802_1803498810 = (!session.protocol.equals(servProt));
                                {
                                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                       "Bad server hello protocol version");
                                } //End block
                                {
                                    boolean var0AFEEA6CF0D5512A87FE0A31F157084D_231621894 = (!session.cipherSuite.equals(serverHello.cipher_suite));
                                    {
                                        fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                       "Bad server hello cipher suite");
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                        {
                            computerReferenceVerifyDataTLS("server finished");
                        } //End block
                        {
                            computerReferenceVerifyDataSSLv3(SSLv3Constants.server);
                        } //End block
                    } //End block
                    //End case 2 
                    //Begin case 2 
                    session.protocol = servProt;
                    //End case 2 
                    //Begin case 2 
                    recordProtocol.setVersion(session.protocol.version);
                    //End case 2 
                    //Begin case 2 
                    session.cipherSuite = serverHello.cipher_suite;
                    //End case 2 
                    //Begin case 2 
                    session.id = serverHello.session_id.clone();
                    //End case 2 
                    //Begin case 2 
                    session.serverRandom = serverHello.random;
                    //End case 2 
                    //Begin case 11 
                    {
                        unexpectedMessage();
                    } //End block
                    //End case 11 
                    //Begin case 11 
                    serverCert = new CertificateMessage(io_stream, length);
                    //End case 11 
                    //Begin case 12 
                    {
                        unexpectedMessage();
                    } //End block
                    //End case 12 
                    //Begin case 12 
                    serverKeyExchange = new ServerKeyExchange(io_stream,
                            length, session.cipherSuite.keyExchange);
                    //End case 12 
                    //Begin case 13 
                    {
                        boolean varF9890FCB2C532CDBD8FF82183579BCF3_2052185185 = (serverCert == null || certificateRequest != null
                            || session.cipherSuite.isAnonymous() || isResuming);
                        {
                            unexpectedMessage();
                        } //End block
                    } //End collapsed parenthetic
                    //End case 13 
                    //Begin case 13 
                    certificateRequest = new CertificateRequest(io_stream, length);
                    //End case 13 
                    //Begin case 14 
                    {
                        unexpectedMessage();
                    } //End block
                    //End case 14 
                    //Begin case 14 
                    serverHelloDone = new ServerHelloDone(io_stream, length);
                    //End case 14 
                    //Begin case 14 
                    {
                        delegatedTasks.add(new DelegatedTask(new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.837 -0400", hash_original_method = "0DFF79E1B822BFCDEB6260105932743B", hash_generated_method = "5828D0275E43E6D76D054149775437AB")
                            public void run() {
                                processServerHelloDone();
                                // ---------- Original Method ----------
                                //processServerHelloDone();
                            }
}, this));
                    } //End block
                    //End case 14 
                    //Begin case 14 
                    processServerHelloDone();
                    //End case 14 
                    //Begin case 20 
                    {
                        unexpectedMessage();
                    } //End block
                    //End case 20 
                    //Begin case 20 
                    serverFinished = new Finished(io_stream, length);
                    //End case 20 
                    //Begin case 20 
                    verifyFinished(serverFinished.getData());
                    //End case 20 
                    //Begin case 20 
                    session.lastAccessedTime = System.currentTimeMillis();
                    //End case 20 
                    //Begin case 20 
                    session.context = parameters.getClientSessionContext();
                    //End case 20 
                    //Begin case 20 
                    parameters.getClientSessionContext().putSession(session);
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
        addTaint(bytes[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.838 -0400", hash_original_method = "A121217103E96E47F6E62859875393D7", hash_generated_method = "5AD7037F7D9A49F85FA4767ECBA0829C")
    @Override
    public void unwrapSSLv2(byte[] bytes) {
        unexpectedMessage();
        addTaint(bytes[0]);
        // ---------- Original Method ----------
        //unexpectedMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.838 -0400", hash_original_method = "8B073BF3F8F00875CF9B653567C3900A", hash_generated_method = "7ADB18054E9C29267B6FB80545872FF0")
    @Override
    protected void makeFinished() {
        byte[] verify_data;
        {
            verify_data = new byte[12];
            computerVerifyDataTLS("client finished", verify_data);
        } //End block
        {
            verify_data = new byte[36];
            computerVerifyDataSSLv3(SSLv3Constants.client, verify_data);
        } //End block
        clientFinished = new Finished(verify_data);
        send(clientFinished);
        {
            session.lastAccessedTime = System.currentTimeMillis();
            status = FINISHED;
        } //End block
        {
            {
                computerReferenceVerifyDataTLS("server finished");
            } //End block
            {
                computerReferenceVerifyDataSSLv3(SSLv3Constants.server);
            } //End block
            status = NEED_UNWRAP;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.840 -0400", hash_original_method = "2DDF37E22088D1FE8BC73EB3CA83F3A0", hash_generated_method = "23B16C52D7AB36244DEA2D72D468B67B")
     void processServerHelloDone() {
        PrivateKey clientKey = null;
        {
            {
                boolean var440E6CD9D61B610BE0CD8D5842DA38D3_754948965 = (session.cipherSuite.isAnonymous());
                {
                    unexpectedMessage();
                } //End block
            } //End collapsed parenthetic
            verifyServerCert();
        } //End block
        {
            {
                boolean var807E086399ACDA2D6CC5AE9170972539_466738738 = (!session.cipherSuite.isAnonymous());
                {
                    unexpectedMessage();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            X509Certificate[] certs = null;
            String alias = null;
            String[] certTypes = certificateRequest.getTypesAsString();
            X500Principal[] issuers = certificateRequest.certificate_authorities;
            X509KeyManager km = parameters.getKeyManager();
            {
                X509ExtendedKeyManager ekm = (X509ExtendedKeyManager)km;
                {
                    alias = ekm.chooseClientAlias(certTypes, issuers, this.socketOwner);
                } //End block
                {
                    alias = ekm.chooseEngineClientAlias(certTypes, issuers, this.engineOwner);
                } //End block
                {
                    certs = ekm.getCertificateChain(alias);
                } //End block
            } //End block
            {
                alias = km.chooseClientAlias(certTypes, issuers, this.socketOwner);
                {
                    certs = km.getCertificateChain(alias);
                } //End block
            } //End block
            session.localCertificates = certs;
            clientCert = new CertificateMessage(certs);
            clientKey = km.getPrivateKey(alias);
            send(clientCert);
        } //End block
        {
            Cipher c;
            try 
            {
                c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                {
                    c.init(Cipher.ENCRYPT_MODE, serverKeyExchange
                            .getRSAPublicKey());
                } //End block
                {
                    c.init(Cipher.ENCRYPT_MODE, serverCert.certs[0]);
                } //End block
            } //End block
            catch (Exception e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR,
                        "Unexpected exception", e);
            } //End block
            preMasterSecret = new byte[48];
            parameters.getSecureRandom().nextBytes(preMasterSecret);
            System.arraycopy(clientHello.client_version, 0, preMasterSecret, 0, 2);
            try 
            {
                clientKeyExchange = new ClientKeyExchange(c
                        .doFinal(preMasterSecret),
                        serverHello.server_version[1] == 1);
            } //End block
            catch (Exception e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR,
                        "Unexpected exception", e);
            } //End block
        } //End block
        {
            try 
            {
                KeyFactory kf = KeyFactory.getInstance("DH");
                KeyAgreement agreement = KeyAgreement.getInstance("DH");
                KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
                PublicKey serverPublic;
                DHParameterSpec spec;
                {
                    serverPublic = kf.generatePublic(new DHPublicKeySpec(
                            serverKeyExchange.par3, serverKeyExchange.par1,
                            serverKeyExchange.par2));
                    spec = new DHParameterSpec(serverKeyExchange.par1,
                            serverKeyExchange.par2);
                } //End block
                {
                    serverPublic = serverCert.certs[0].getPublicKey();
                    spec = ((DHPublicKey) serverPublic).getParams();
                } //End block
                kpg.initialize(spec);
                KeyPair kp = kpg.generateKeyPair();
                Key key = kp.getPublic();
                {
                    PublicKey client_pk = clientCert.certs[0].getPublicKey();
                    PublicKey server_pk = serverCert.certs[0].getPublicKey();
                    {
                        {
                            boolean var1FAACC0D7172F28BD0069713FCDF0707_760405697 = (((DHKey) client_pk).getParams().getG().equals(
                                ((DHKey) server_pk).getParams().getG())
                                && ((DHKey) client_pk).getParams().getP()
                                    .equals(((DHKey) server_pk).getParams().getG()));
                            {
                                clientKeyExchange = new ClientKeyExchange();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                {
                    clientKeyExchange = new ClientKeyExchange(
                            ((DHPublicKey) key).getY());
                } //End block
                key = kp.getPrivate();
                agreement.init(key);
                agreement.doPhase(serverPublic, true);
                preMasterSecret = agreement.generateSecret();
            } //End block
            catch (Exception e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR,
                        "Unexpected exception", e);
            } //End block
        } //End block
        {
            send(clientKeyExchange);
        } //End block
        computerMasterSecret();
        {
            boolean var79FBA70ED4A263B4409E8FBEC8B7D7E6_1415427371 = (clientCert != null && !clientKeyExchange.isEmpty());
            {
                String authType = clientKey.getAlgorithm();
                DigitalSignature ds = new DigitalSignature(authType);
                ds.init(clientKey);
                {
                    boolean varCBBC71C6C316C0B4E48197697176E8D9_1769932329 = ("RSA".equals(authType));
                    {
                        ds.setMD5(io_stream.getDigestMD5());
                        ds.setSHA(io_stream.getDigestSHA());
                    } //End block
                    {
                        boolean var7568AB17DB73A1C989272D7D35C72E86_185692134 = ("DSA".equals(authType));
                        {
                            ds.setSHA(io_stream.getDigestSHA());
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                certificateVerify = new CertificateVerify(ds.sign());
                send(certificateVerify);
            } //End block
        } //End collapsed parenthetic
        sendChangeCipherSpec();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.840 -0400", hash_original_method = "D4DFA4A65ECB84B5CCE7F9A88CE9F713", hash_generated_method = "A0ADAF9FE2704A6B82839BEDDB2A27C4")
    private void verifyServerCert() {
        String authType = session.cipherSuite.getAuthType(serverKeyExchange != null);
        try 
        {
            parameters.getTrustManager().checkServerTrusted(serverCert.certs, authType);
        } //End block
        catch (CertificateException e)
        {
            fatalAlert(AlertProtocol.BAD_CERTIFICATE, "Not trusted server certificate", e);
        } //End block
        session.peerCertificates = serverCert.certs;
        // ---------- Original Method ----------
        //String authType = session.cipherSuite.getAuthType(serverKeyExchange != null);
        //if (authType == null) {
            //return;
        //}
        //try {
            //parameters.getTrustManager().checkServerTrusted(serverCert.certs, authType);
        //} catch (CertificateException e) {
            //fatalAlert(AlertProtocol.BAD_CERTIFICATE, "Not trusted server certificate", e);
            //return;
        //}
        //session.peerCertificates = serverCert.certs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.841 -0400", hash_original_method = "EC675B353AC97965B98DB90ABCC2C0E4", hash_generated_method = "2DE423DA52E4BAD971F1BB0405266AB8")
    @Override
    public void receiveChangeCipherSpec() {
        {
            {
                unexpectedMessage();
            } //End block
        } //End block
        {
            unexpectedMessage();
        } //End block
        changeCipherSpecReceived = true;
        // ---------- Original Method ----------
        //if (isResuming) {
            //if (serverHello == null) {
                //unexpectedMessage();
            //}
        //} else if (clientFinished == null) {
            //unexpectedMessage();
        //}
        //changeCipherSpecReceived = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.842 -0400", hash_original_method = "BCA1C752C9C2161C7353D057736B9B80", hash_generated_method = "BCC77B2F6A9368DAD7B66B78B7350298")
    private SSLSessionImpl findSessionToResume() {
        SSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_1786096550 = null; //Variable for return #1
        SSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_1239315221 = null; //Variable for return #2
        String host = null;
        int port = -1;
        {
            host = engineOwner.getPeerHost();
            port = engineOwner.getPeerPort();
        } //End block
        {
            host = socketOwner.getInetAddress().getHostName();
            port = socketOwner.getPort();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1786096550 = null;
        } //End block
        ClientSessionContext context = parameters.getClientSessionContext();
        SSLSessionImpl session = (SSLSessionImpl) context.getSession(host, port);
        {
            session = (SSLSessionImpl) session.clone();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1239315221 = session;
        SSLSessionImpl varA7E53CE21691AB073D9660D615818899_1079149568; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1079149568 = varB4EAC82CA7396A68D541C85D26508E83_1786096550;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1079149568 = varB4EAC82CA7396A68D541C85D26508E83_1239315221;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1079149568.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1079149568;
        // ---------- Original Method ----------
        //String host = null;
        //int port = -1;
        //if (engineOwner != null) {
            //host = engineOwner.getPeerHost();
            //port = engineOwner.getPeerPort();
        //} else {
            //host = socketOwner.getInetAddress().getHostName();
            //port = socketOwner.getPort();
        //}
        //if (host == null || port == -1) {
            //return null; 
        //}
        //ClientSessionContext context = parameters.getClientSessionContext();
        //SSLSessionImpl session
                //= (SSLSessionImpl) context.getSession(host, port);
        //if (session != null) {
            //session = (SSLSessionImpl) session.clone();
        //}
        //return session;
    }

    
}

