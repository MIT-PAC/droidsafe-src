package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.865 -0400", hash_original_field = "4AA2361BEE79AADD8595859693612743", hash_generated_field = "F778C7A1E11234387361395B9C2BAFEF")

    private PrivateKey privKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.865 -0400", hash_original_method = "3AF97CBDFDCCD2B098621E28E1AC9FE5", hash_generated_method = "D5581A48D5BE2E2A9830A403D5C0BA76")
    public  ServerHandshakeImpl(Object owner) {
        super(owner);
        addTaint(owner.getTaint());
        status = NEED_UNWRAP;
        // ---------- Original Method ----------
        //status = NEED_UNWRAP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.866 -0400", hash_original_method = "324CE8CF3B7F222FC5B16C98F36DFFC3", hash_generated_method = "138938AB232AD708365232723004610D")
    @Override
    public void start() {
        if(session == null)        
        {
            status = NEED_UNWRAP;
            return;
        } //End block
        if(clientHello != null && this.status != FINISHED)        
        {
            return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.871 -0400", hash_original_method = "C84D4DEAC8EBB3DD7197C18B29E2CDCD", hash_generated_method = "3A378AD03005BB3213497700CFD3717B")
    @Override
    public void unwrap(byte[] bytes) {
        addTaint(bytes[0]);
        io_stream.append(bytes);
        while
(io_stream.available() > 0)        
        {
            int handshakeType;
            int length;
            io_stream.mark();
            try 
            {
                handshakeType = io_stream.read();
                length = io_stream.readUint24();
                if(io_stream.available() < length)                
                {
                    io_stream.reset();
                    return;
                } //End block
switch(handshakeType){
                case 1:
                if(clientHello != null && this.status != FINISHED)                
                {
                    unexpectedMessage();
                    return;
                } //End block
                needSendHelloRequest = false;
                clientHello = new ClientHello(io_stream, length);
                if(nonBlocking)                
                {
                    delegatedTasks.add(new DelegatedTask(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.868 -0400", hash_original_method = "E7C0517DE997CD5395D0C07C8E102134", hash_generated_method = "BB36F1EA52E00860AED4267A4F6A4F59")
        public void run() {
            processClientHello();
            // ---------- Original Method ----------
            //processClientHello();
        }
}, this));
                    return;
                } //End block
                processClientHello();
                break;
                case 11:
                if(isResuming || certificateRequest == null
                            || serverHelloDone == null || clientCert != null)                
                {
                    unexpectedMessage();
                    return;
                } //End block
                clientCert = new CertificateMessage(io_stream, length);
                if(clientCert.certs.length == 0)                
                {
                    if(parameters.getNeedClientAuth())                    
                    {
                        fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                       "HANDSHAKE FAILURE: no client certificate received");
                    } //End block
                } //End block
                else
                {
                    String authType = clientCert.getAuthType();
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
                break;
                case 15:
                if(isResuming
                            || clientKeyExchange == null
                            || clientCert == null
                            || clientKeyExchange.isEmpty() 
                            || certificateVerify != null
                            || changeCipherSpecReceived)                
                {
                    unexpectedMessage();
                    return;
                } //End block
                certificateVerify = new CertificateVerify(io_stream, length);
                String authType = clientCert.getAuthType();
                DigitalSignature ds = new DigitalSignature(authType);
                ds.init(clientCert.certs[0]);
                byte[] md5_hash = null;
                byte[] sha_hash = null;
                if("RSA".equals(authType))                
                {
                    md5_hash = io_stream.getDigestMD5withoutLast();
                    sha_hash = io_stream.getDigestSHAwithoutLast();
                } //End block
                else
                if("DSA".equals(authType))                
                {
                    sha_hash = io_stream.getDigestSHAwithoutLast();
                } //End block
                ds.setMD5(md5_hash);
                ds.setSHA(sha_hash);
                if(!ds.verifySignature(certificateVerify.signedHash))                
                {
                    fatalAlert(AlertProtocol.DECRYPT_ERROR,
                                   "DECRYPT ERROR: CERTIFICATE_VERIFY incorrect signature");
                } //End block
                break;
                case 16:
                if(isResuming
                            || serverHelloDone == null
                            || clientKeyExchange != null
                            || (clientCert == null && parameters.getNeedClientAuth()))                
                {
                    unexpectedMessage();
                    return;
                } //End block
                if(session.cipherSuite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA
                            || session.cipherSuite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT)                
                {
                    clientKeyExchange = new ClientKeyExchange(io_stream,
                                length, serverHello.server_version[1] == 1,
                                true);
                    Cipher c = null;
                    try 
                    {
                        c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        c.init(Cipher.DECRYPT_MODE, privKey);
                        preMasterSecret = c.doFinal(clientKeyExchange.exchange_keys);
                        if(preMasterSecret.length != 48
                                    || preMasterSecret[0] != clientHello.client_version[0]
                                    || preMasterSecret[1] != clientHello.client_version[1])                        
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
                else
                {
                    clientKeyExchange = new ClientKeyExchange(io_stream,
                                length, serverHello.server_version[1] == 1,
                                false);
                    if(clientKeyExchange.isEmpty())                    
                    {
                        preMasterSecret = ((DHPublicKey) clientCert.certs[0].getPublicKey()).getY().toByteArray();
                    } //End block
                    else
                    {
                        try 
                        {
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
                        } //End block
                        catch (Exception e)
                        {
                            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                                           "INTERNAL ERROR", e);
                            return;
                        } //End block
                    } //End block
                } //End block
                computerMasterSecret();
                break;
                case 20:
                if(!isResuming && !changeCipherSpecReceived)                
                {
                    unexpectedMessage();
                    return;
                } //End block
                clientFinished = new Finished(io_stream, length);
                verifyFinished(clientFinished.getData());
                session.context = parameters.getServerSessionContext();
                parameters.getServerSessionContext().putSession(session);
                if(!isResuming)                
                {
                    sendChangeCipherSpec();
                } //End block
                else
                {
                    session.lastAccessedTime = System.currentTimeMillis();
                    status = FINISHED;
                } //End block
                break;
                default:
                unexpectedMessage();
                return;
}
            } //End block
            catch (IOException e)
            {
                io_stream.reset();
                return;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.873 -0400", hash_original_method = "866A772D6B919D9D55F9FB0C6E40CB44", hash_generated_method = "50A80328A8C13F60C7927A3A2253C70D")
    @Override
    public void unwrapSSLv2(byte[] bytes) {
        addTaint(bytes[0]);
        io_stream.append(bytes);
        io_stream.mark();
        try 
        {
            clientHello = new ClientHello(io_stream);
        } //End block
        catch (IOException e)
        {
            io_stream.reset();
            return;
        } //End block
        if(nonBlocking)        
        {
            delegatedTasks.add(new DelegatedTask(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.873 -0400", hash_original_method = "E7C0517DE997CD5395D0C07C8E102134", hash_generated_method = "BB36F1EA52E00860AED4267A4F6A4F59")
        public void run() {
            processClientHello();
            // ---------- Original Method ----------
            //processClientHello();
        }
}, this));
            return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.889 -0400", hash_original_method = "1EE7C68A79581646D3317E6FF35ECA2F", hash_generated_method = "F5935FEABE582BF33ECAA7928ABD6E72")
     void processClientHello() {
        CipherSuite cipher_suite;
        checkCompression        :
        {
for(int i = 0;i < clientHello.compression_methods.length;i++)
            {
                if(clientHello.compression_methods[i] == 0)                
                {
                    break checkCompression;
                } //End block
            } //End block
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                       "HANDSHAKE FAILURE. Incorrect client hello message");
        } //End block
        if(!ProtocolVersion.isSupported(clientHello.client_version))        
        {
            fatalAlert(AlertProtocol.PROTOCOL_VERSION,
                       "PROTOCOL VERSION. Unsupported client version "
                       + clientHello.client_version[0]
                       + clientHello.client_version[1]);
        } //End block
        isResuming = false;
        FIND        :
        if(clientHello.session_id.length != 0)        
        {
            SSLSessionImpl sessionToResume;
            boolean reuseCurrent = false;
            if(session != null
                    && Arrays.equals(session.id, clientHello.session_id))            
            {
                if(session.isValid())                
                {
                    isResuming = true;
                    break FIND;
                } //End block
                reuseCurrent = true;
            } //End block
            sessionToResume = findSessionToResume(clientHello.session_id);
            if(sessionToResume == null || !sessionToResume.isValid())            
            {
                if(!parameters.getEnableSessionCreation())                
                {
                    if(reuseCurrent)                    
                    {
                        sendWarningAlert(AlertProtocol.NO_RENEGOTIATION);
                        status = NOT_HANDSHAKING;
                        clearMessages();
                        return;
                    } //End block
                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "SSL Session may not be created");
                } //End block
                session = null;
            } //End block
            else
            {
                session = (SSLSessionImpl)sessionToResume.clone();
                isResuming = true;
            } //End block
        } //End block
        if(isResuming)        
        {
            cipher_suite = session.cipherSuite;
            checkCipherSuite            :
            {
for(int i = 0;i < clientHello.cipher_suites.length;i++)
                {
                    if(cipher_suite.equals(clientHello.cipher_suites[i]))                    
                    {
                        break checkCipherSuite;
                    } //End block
                } //End block
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                           "HANDSHAKE FAILURE. Incorrect client hello message");
            } //End block
        } //End block
        else
        {
            cipher_suite = selectSuite(clientHello.cipher_suites);
            if(cipher_suite == null)            
            {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "HANDSHAKE FAILURE. NO COMMON SUITE");
            } //End block
            if(!parameters.getEnableSessionCreation())            
            {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                           "SSL Session may not be created");
            } //End block
            session = new SSLSessionImpl(cipher_suite, parameters.getSecureRandom());
            if(engineOwner != null)            
            {
                session.setPeer(engineOwner.getPeerHost(), engineOwner.getPeerPort());
            } //End block
            else
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
        if(isResuming)        
        {
            sendChangeCipherSpec();
            return;
        } //End block
        if(!cipher_suite.isAnonymous())        
        {
            X509Certificate[] certs = null;
            String certType = cipher_suite.getServerKeyType();
            if(certType == null)            
            {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "NO CERT TYPE FOR " + cipher_suite.getName());
            } //End block
            String alias = null;
            X509KeyManager km = parameters.getKeyManager();
            if(km instanceof X509ExtendedKeyManager)            
            {
                X509ExtendedKeyManager ekm = (X509ExtendedKeyManager)km;
                if(this.socketOwner != null)                
                {
                    alias = ekm.chooseServerAlias(certType, null,
                            this.socketOwner);
                } //End block
                else
                {
                    alias = ekm.chooseEngineServerAlias(certType, null,
                            this.engineOwner);
                } //End block
                if(alias != null)                
                {
                    certs = ekm.getCertificateChain(alias);
                } //End block
            } //End block
            else
            {
                alias = km.chooseServerAlias(certType, null, this.socketOwner);
                if(alias != null)                
                {
                    certs = km.getCertificateChain(alias);
                } //End block
            } //End block
            if(certs == null)            
            {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "NO SERVER CERTIFICATE FOUND");
                return;
            } //End block
            session.localCertificates = certs;
            serverCert = new CertificateMessage(certs);
            privKey = km.getPrivateKey(alias);
            send(serverCert);
        } //End block
        RSAPublicKey rsakey = null;
        DHPublicKeySpec dhkeySpec = null;
        byte[] hash = null;
        BigInteger p = null;
        BigInteger g = null;
        KeyPairGenerator kpg = null;
        try 
        {
            if(cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT)            
            {
                PublicKey pk = serverCert.certs[0].getPublicKey();
                if(getRSAKeyLength(pk) > 512)                
                {
                    kpg = KeyPairGenerator.getInstance("RSA");
                    kpg.initialize(512);
                } //End block
            } //End block
            else
            if(cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_DSS
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_DSS_EXPORT
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_RSA
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_RSA_EXPORT
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DH_anon
                    || cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_DH_anon_EXPORT)            
            {
                kpg = KeyPairGenerator.getInstance("DH");
                p = new BigInteger(1, DHParameters.getPrime());
                g = new BigInteger("2");
                DHParameterSpec spec = new DHParameterSpec(p, g);
                kpg.initialize(spec);
            } //End block
        } //End block
        catch (Exception e)
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
        } //End block
        if(kpg != null)        
        {
            DigitalSignature ds = new DigitalSignature(cipher_suite.authType);
            KeyPair kp = null;
            try 
            {
                kp = kpg.genKeyPair();
                if(cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT)                
                {
                    rsakey = (RSAPublicKey) kp.getPublic();
                } //End block
                else
                {
                    DHPublicKey dhkey = (DHPublicKey) kp.getPublic();
                    KeyFactory kf = KeyFactory.getInstance("DH");
                    dhkeySpec = kf.getKeySpec(dhkey, DHPublicKeySpec.class);
                } //End block
                if(!cipher_suite.isAnonymous())                
                {
                    ds.init(privKey);
                    privKey = kp.getPrivate();
                    ds.update(clientHello.getRandom());
                    ds.update(serverHello.getRandom());
                    byte[] tmp;
                    byte[] tmpLength = new byte[2];
                    if(cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT)                    
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
                    else
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
                else
                {
                    privKey = kp.getPrivate();
                } //End block
            } //End block
            catch (Exception e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
            } //End block
            if(cipher_suite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT)            
            {
                serverKeyExchange = new ServerKeyExchange(rsakey.getModulus(),
                        rsakey.getPublicExponent(), null, hash);
            } //End block
            else
            {
                serverKeyExchange = new ServerKeyExchange(p,
                        g, dhkeySpec.getY(), hash);
            } //End block
            send(serverKeyExchange);
        } //End block
        certRequest        :
        if(parameters.getWantClientAuth()
                || parameters.getNeedClientAuth())        
        {
            X509Certificate[] accepted;
            try 
            {
                X509TrustManager tm = parameters.getTrustManager();
                accepted = tm.getAcceptedIssuers();
            } //End block
            catch (ClassCastException e)
            {
                break certRequest;
            } //End block
            byte[] requestedClientCertTypes = { CipherSuite.TLS_CT_RSA_SIGN,
                                                CipherSuite.TLS_CT_DSS_SIGN };
            certificateRequest = new CertificateRequest(
                    requestedClientCertTypes, accepted);
            send(certificateRequest);
        } //End block
        serverHelloDone = new ServerHelloDone();
        send(serverHelloDone);
        status = NEED_UNWRAP;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.889 -0400", hash_original_method = "B7CAA5254DC76CE96F66DEC8EF811F93", hash_generated_method = "E6BCB41AF960006D4DD2D74713DDA57E")
    @Override
    protected void makeFinished() {
        byte[] verify_data;
        boolean isTLS = (serverHello.server_version[1] == 1);
        if(isTLS)        
        {
            verify_data = new byte[12];
            computerVerifyDataTLS("server finished", verify_data);
        } //End block
        else
        {
            verify_data = new byte[36];
            computerVerifyDataSSLv3(SSLv3Constants.server, verify_data);
        } //End block
        serverFinished = new Finished(verify_data);
        send(serverFinished);
        if(isResuming)        
        {
            if(isTLS)            
            {
                computerReferenceVerifyDataTLS("client finished");
            } //End block
            else
            {
                computerReferenceVerifyDataSSLv3(SSLv3Constants.client);
            } //End block
            status = NEED_UNWRAP;
        } //End block
        else
        {
            session.lastAccessedTime = System.currentTimeMillis();
            status = FINISHED;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.890 -0400", hash_original_method = "1900CB4813DE311B701E9907815D7379", hash_generated_method = "70E822289D395CB88A5B9DDA85724E0E")
    private SSLSessionImpl findSessionToResume(byte[] session_id) {
        addTaint(session_id[0]);
SSLSessionImpl var17920C4727A1A491ECB429D01D5C0164_1854720046 =         (SSLSessionImpl)parameters.getServerSessionContext().getSession(session_id);
        var17920C4727A1A491ECB429D01D5C0164_1854720046.addTaint(taint);
        return var17920C4727A1A491ECB429D01D5C0164_1854720046;
        // ---------- Original Method ----------
        //return (SSLSessionImpl)parameters.getServerSessionContext().getSession(session_id);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.890 -0400", hash_original_method = "CED7C9E9124D8D76ECA389CBA359AC39", hash_generated_method = "FC9F7E9FD52995B94EF48725D18CD91D")
    private CipherSuite selectSuite(CipherSuite[] clientSuites) {
        addTaint(clientSuites[0].getTaint());
for(CipherSuite clientSuite : clientSuites)
        {
            if(!clientSuite.supported)            
            {
                continue;
            } //End block
for(CipherSuite enabledCipherSuite : parameters.getEnabledCipherSuitesMember())
            {
                if(clientSuite.equals(enabledCipherSuite))                
                {
CipherSuite varF085B62D70EBB2C6974C2BAD4FDA9BC8_346301048 =                     clientSuite;
                    varF085B62D70EBB2C6974C2BAD4FDA9BC8_346301048.addTaint(taint);
                    return varF085B62D70EBB2C6974C2BAD4FDA9BC8_346301048;
                } //End block
            } //End block
        } //End block
CipherSuite var540C13E9E156B687226421B24F2DF178_661939543 =         null;
        var540C13E9E156B687226421B24F2DF178_661939543.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_661939543;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.890 -0400", hash_original_method = "C3331D73871F50BD7C19021D99D59A46", hash_generated_method = "4395F563433F3BABFCA019BF725CE472")
    @Override
    public void receiveChangeCipherSpec() {
        if(isResuming)        
        {
            if(serverFinished == null)            
            {
                unexpectedMessage();
            } //End block
            else
            {
                changeCipherSpecReceived = true;
            } //End block
        } //End block
        else
        {
            if((parameters.getNeedClientAuth() && clientCert == null)
                    || clientKeyExchange == null
                    || (clientCert != null
                            && !clientKeyExchange.isEmpty()
                            && certificateVerify == null))            
            {
                unexpectedMessage();
            } //End block
            else
            {
                changeCipherSpecReceived = true;
            } //End block
            if(serverHello.server_version[1] == 1)            
            {
                computerReferenceVerifyDataTLS("client finished");
            } //End block
            else
            {
                computerReferenceVerifyDataSSLv3(SSLv3Constants.client);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

