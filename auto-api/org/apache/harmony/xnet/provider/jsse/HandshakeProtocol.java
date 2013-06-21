package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Vector;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

public abstract class HandshakeProtocol {
    protected int status = NOT_HANDSHAKING;
    protected HandshakeIODataStream io_stream = new HandshakeIODataStream();
    protected SSLRecordProtocol recordProtocol;
    protected SSLParametersImpl parameters;
    protected Vector<DelegatedTask> delegatedTasks = new Vector<DelegatedTask>();
    protected boolean nonBlocking;
    protected SSLSessionImpl session;
    protected ClientHello clientHello;
    protected ServerHello serverHello;
    protected CertificateMessage serverCert;
    protected ServerKeyExchange serverKeyExchange;
    protected CertificateRequest certificateRequest;
    protected ServerHelloDone serverHelloDone;
    protected CertificateMessage clientCert;
    protected ClientKeyExchange clientKeyExchange;
    protected CertificateVerify certificateVerify;
    protected Finished clientFinished;
    protected Finished serverFinished;
    protected boolean changeCipherSpecReceived = false;
    protected boolean isResuming = false;
    protected byte[] preMasterSecret;
    protected Exception delegatedTaskErr;
    private byte[] verify_data = new byte[12];
    private byte[] master_secret_bytes =
            {109, 97, 115, 116, 101, 114, 32, 115, 101, 99, 114, 101, 116 };
    private boolean needSendCCSpec = false;
    protected boolean needSendHelloRequest = false;
    public SSLEngineImpl engineOwner;
    public SSLSocketImpl socketOwner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.796 -0400", hash_original_method = "6E2FD3B88BA1414C6B3F142DFE23A2F6", hash_generated_method = "81DD599B6EFAC3BEFDDE391726BB29C7")
    @DSModeled(DSC.SAFE)
    protected HandshakeProtocol(Object owner) {
        dsTaint.addTaint(owner.dsTaint);
        {
            engineOwner = (SSLEngineImpl) owner;
            nonBlocking = true;
            this.parameters = engineOwner.sslParameters;
        } //End block
        {
            socketOwner = (SSLSocketImpl) owner;
            nonBlocking = false;
            this.parameters = socketOwner.sslParameters;
        } //End block
        // ---------- Original Method ----------
        //if (owner instanceof SSLEngineImpl) {
            //engineOwner = (SSLEngineImpl) owner;
            //nonBlocking = true;
            //this.parameters = engineOwner.sslParameters;
        //}
        //else if (owner instanceof SSLSocketImpl) {
            //socketOwner = (SSLSocketImpl) owner;
            //nonBlocking = false;
            //this.parameters = socketOwner.sslParameters;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.796 -0400", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "E1DA8134FA4414F5A7C2DFC7229E95CA")
    @DSModeled(DSC.SAFE)
    public void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        dsTaint.addTaint(recordProtocol.dsTaint);
        // ---------- Original Method ----------
        //this.recordProtocol = recordProtocol;
    }

    
    public abstract void start();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.796 -0400", hash_original_method = "CCB194A714BDC12D18860313F52671E7", hash_generated_method = "378E1AD191F24D0435A262BA80FF0EED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void stop() {
        clearMessages();
        status = NOT_HANDSHAKING;
        // ---------- Original Method ----------
        //clearMessages();
        //status = NOT_HANDSHAKING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.797 -0400", hash_original_method = "0CB6BF73CCE484420EACC5A99703893D", hash_generated_method = "FFDD0B06FB880A02EAA41897AB8F6B2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLEngineResult.HandshakeStatus getStatus() {
        {
            boolean var4A912B6D5D3397A70E26E30E30B3CCC9_913651007 = (io_stream.hasData() || needSendCCSpec ||
                needSendHelloRequest || delegatedTaskErr != null);
        } //End collapsed parenthetic
        {
            boolean var9A65276F6F9B0ED8A56151AD30EBD70C_101145125 = (!delegatedTasks.isEmpty());
        } //End collapsed parenthetic
        //Begin case HandshakeProtocol.FINISHED 
        status = NOT_HANDSHAKING;
        //End case HandshakeProtocol.FINISHED 
        //Begin case HandshakeProtocol.FINISHED 
        clearMessages();
        //End case HandshakeProtocol.FINISHED 
        return (SSLEngineResult.HandshakeStatus)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (io_stream.hasData() || needSendCCSpec ||
                //needSendHelloRequest || delegatedTaskErr != null) {
            //return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        //}
        //if (!delegatedTasks.isEmpty()) {
            //return SSLEngineResult.HandshakeStatus.NEED_TASK;
        //}
        //switch (status) {
        //case HandshakeProtocol.NEED_UNWRAP:
            //return SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        //case HandshakeProtocol.FINISHED:
            //status = NOT_HANDSHAKING;
            //clearMessages();
            //return SSLEngineResult.HandshakeStatus.FINISHED;
        //default: 
            //return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.797 -0400", hash_original_method = "19D70A4F8DD7A34083C18DBEE5C3AF9E", hash_generated_method = "C1129AD37907CF118BA6EF342FB02DBB")
    @DSModeled(DSC.SAFE)
    public SSLSessionImpl getSession() {
        return (SSLSessionImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.797 -0400", hash_original_method = "95F30AE0B715D4F051584DDF5B47A5AE", hash_generated_method = "5DF4A49BCAA2F792F82CA4782AE77904")
    @DSModeled(DSC.SAFE)
    protected void sendChangeCipherSpec() {
        needSendCCSpec = true;
        // ---------- Original Method ----------
        //needSendCCSpec = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.797 -0400", hash_original_method = "CD5990AD34611898DF18221C46BBB35B", hash_generated_method = "3ED1C82D1126AC414DC77295B793F13B")
    @DSModeled(DSC.SAFE)
    protected void sendHelloRequest() {
        needSendHelloRequest = true;
        // ---------- Original Method ----------
        //needSendHelloRequest = true;
    }

    
    abstract void receiveChangeCipherSpec();

    
    abstract void makeFinished();

    
    public abstract void unwrap(byte[] bytes);

    
    public abstract void unwrapSSLv2(byte[] bytes);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.798 -0400", hash_original_method = "086592130010ECCB1C6429039BD6D57C", hash_generated_method = "135AE07D72E7A61BB60895778466D967")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] wrap() {
        {
            Exception e;
            e = delegatedTaskErr;
            delegatedTaskErr = null;
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                    "Error occured in delegated task:" + e.getMessage(), e);
        } //End block
        {
            boolean var9CC89A3A5AC109D0C018B7D53AE8276D_1654195714 = (io_stream.hasData());
            {
                byte[] var3BF1168A5F3DFA56460A41E4D5A14127_1813044902 = (recordProtocol.wrap(ContentType.HANDSHAKE, io_stream));
            } //End block
            {
                makeFinished();
                needSendCCSpec = false;
                byte[] var4EE5DBD7B96BD2A3090E287A0DDD2197_1385523422 = (recordProtocol.getChangeCipherSpecMesage(getSession()));
            } //End block
            {
                needSendHelloRequest = false;
                byte[] var1EF5A3C0CFD1B342D0B4D4B37120467E_213476732 = (recordProtocol.wrap(ContentType.HANDSHAKE,
                    new byte[] {0, 0, 0, 0}, 0, 4));
            } //End block
        } //End collapsed parenthetic
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.798 -0400", hash_original_method = "DC12A1C8331DD94D1ED64B6A8B107CCD", hash_generated_method = "9FB33287075D0C178179C22F8D49B99E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendWarningAlert(byte description) {
        dsTaint.addTaint(description);
        recordProtocol.alert(AlertProtocol.WARNING, description);
        // ---------- Original Method ----------
        //recordProtocol.alert(AlertProtocol.WARNING, description);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.798 -0400", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "D1D265223143AABF2C0A5DC01905B6F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fatalAlert(byte description, String reason) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(description);
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, new SSLHandshakeException(reason));
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLHandshakeException(reason));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.799 -0400", hash_original_method = "06E08FFEF783008AA773EFEC73CFC5B4", hash_generated_method = "446FF0DE7A802D280918AD9B748B6B32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fatalAlert(byte description, String reason, Exception cause) {
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(description);
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, new SSLException(reason, cause));
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLException(reason, cause));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.799 -0400", hash_original_method = "6E25B9A677528D560BDF206ADC0AD3D2", hash_generated_method = "04EE76C365EB45DF65BADCACBDC11C90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fatalAlert(byte description, SSLException cause) {
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(description);
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, cause);
        // ---------- Original Method ----------
        //throw new AlertException(description, cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.799 -0400", hash_original_method = "31EC19987B0E319181793E3260EF3B24", hash_generated_method = "854CBB2D37DE94428F9B45F903DEB8A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void computerReferenceVerifyDataTLS(String label) {
        dsTaint.addTaint(label);
        computerVerifyDataTLS(label, verify_data);
        // ---------- Original Method ----------
        //computerVerifyDataTLS(label, verify_data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.799 -0400", hash_original_method = "FE7E38FD7B354AD563BA3A5D1A8C1D76", hash_generated_method = "7F4D271B98EE32EEF3324EDA3B31DAEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void computerVerifyDataTLS(String label, byte[] buf) {
        dsTaint.addTaint(label);
        dsTaint.addTaint(buf[0]);
        byte[] md5_digest;
        md5_digest = io_stream.getDigestMD5();
        byte[] sha_digest;
        sha_digest = io_stream.getDigestSHA();
        byte[] digest;
        digest = new byte[md5_digest.length + sha_digest.length];
        System.arraycopy(md5_digest, 0, digest, 0, md5_digest.length);
        System.arraycopy(sha_digest, 0, digest, md5_digest.length,
                sha_digest.length);
        try 
        {
            PRF.computePRF(buf, session.master_secret,
                    label.getBytes(), digest);
        } //End block
        catch (GeneralSecurityException e)
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "PRF error", e);
        } //End block
        // ---------- Original Method ----------
        //byte[] md5_digest = io_stream.getDigestMD5();
        //byte[] sha_digest = io_stream.getDigestSHA();
        //byte[] digest = new byte[md5_digest.length + sha_digest.length];
        //System.arraycopy(md5_digest, 0, digest, 0, md5_digest.length);
        //System.arraycopy(sha_digest, 0, digest, md5_digest.length,
                //sha_digest.length);
        //try {
            //PRF.computePRF(buf, session.master_secret,
                    //label.getBytes(), digest);
        //} catch (GeneralSecurityException e) {
            //fatalAlert(AlertProtocol.INTERNAL_ERROR, "PRF error", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.799 -0400", hash_original_method = "6CF424034910BF5E3BE46A11FAF3035E", hash_generated_method = "E6D3DFF1640BA3B819D745D4CF455A09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void computerReferenceVerifyDataSSLv3(byte[] sender) {
        dsTaint.addTaint(sender[0]);
        verify_data = new byte[36];
        computerVerifyDataSSLv3(sender, verify_data);
        // ---------- Original Method ----------
        //verify_data = new byte[36];
        //computerVerifyDataSSLv3(sender, verify_data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.800 -0400", hash_original_method = "B5635FDA5542E47B9F75EEEF571EFF38", hash_generated_method = "A18DF1740E56E44843FBDC22B3BD9062")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void computerVerifyDataSSLv3(byte[] sender, byte[] buf) {
        dsTaint.addTaint(sender[0]);
        dsTaint.addTaint(buf[0]);
        MessageDigest md5;
        MessageDigest sha;
        try 
        {
            md5 = MessageDigest.getInstance("MD5");
            sha = MessageDigest.getInstance("SHA-1");
        } //End block
        catch (Exception e)
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                       "Could not initialize the Digest Algorithms.",
                       e);
        } //End block
        try 
        {
            byte[] handshake_messages;
            handshake_messages = io_stream.getMessages();
            md5.update(handshake_messages);
            md5.update(sender);
            md5.update(session.master_secret);
            byte[] b;
            b = md5.digest(SSLv3Constants.MD5pad1);
            md5.update(session.master_secret);
            md5.update(SSLv3Constants.MD5pad2);
            System.arraycopy(md5.digest(b), 0, buf, 0, 16);
            sha.update(handshake_messages);
            sha.update(sender);
            sha.update(session.master_secret);
            b = sha.digest(SSLv3Constants.SHApad1);
            sha.update(session.master_secret);
            sha.update(SSLv3Constants.SHApad2);
            System.arraycopy(sha.digest(b), 0, buf, 16, 20);
        } //End block
        catch (Exception e)
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.800 -0400", hash_original_method = "552DD0927697CAC79721F456A43352A2", hash_generated_method = "C5A87E8829FC2D2F0D9762F95A78E1D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void verifyFinished(byte[] data) {
        dsTaint.addTaint(data[0]);
        {
            boolean var077BC70DF9FFE67884E321AA2E817B02_735475489 = (!Arrays.equals(verify_data, data));
            {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Incorrect FINISED");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!Arrays.equals(verify_data, data)) {
            //fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Incorrect FINISED");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.800 -0400", hash_original_method = "BE3E381DC2DA6E41C1335D1916EA3AE1", hash_generated_method = "BB36759016C3CEDFE0C884DBCD94ACA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void unexpectedMessage() {
        fatalAlert(AlertProtocol.UNEXPECTED_MESSAGE, "UNEXPECTED MESSAGE");
        // ---------- Original Method ----------
        //fatalAlert(AlertProtocol.UNEXPECTED_MESSAGE, "UNEXPECTED MESSAGE");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.800 -0400", hash_original_method = "0009DED469C26D41942AD89710EE0C01", hash_generated_method = "1B0154C90FF05FF9C6D28D894F04D938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void send(Message message) {
        dsTaint.addTaint(message.dsTaint);
        io_stream.writeUint8(message.getType());
        io_stream.writeUint24(message.length());
        message.send(io_stream);
        // ---------- Original Method ----------
        //io_stream.writeUint8(message.getType());
        //io_stream.writeUint24(message.length());
        //message.send(io_stream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.801 -0400", hash_original_method = "BCBA6A3432596AA0D9419AF9C137B62C", hash_generated_method = "846210D23241DEDA5C77C31D66AB8AF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void computerMasterSecret() {
        byte[] seed;
        seed = new byte[64];
        System.arraycopy(clientHello.getRandom(), 0, seed, 0, 32);
        System.arraycopy(serverHello.getRandom(), 0, seed, 32, 32);
        session.master_secret = new byte[48];
        {
            try 
            {
                PRF.computePRF(session.master_secret, preMasterSecret,
                        master_secret_bytes, seed);
            } //End block
            catch (GeneralSecurityException e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR, "PRF error", e);
            } //End block
        } //End block
        {
            PRF.computePRF_SSLv3(session.master_secret, preMasterSecret, seed);
        } //End block
        Arrays.fill(preMasterSecret, (byte)0);
        preMasterSecret = null;
        // ---------- Original Method ----------
        //byte[] seed = new byte[64];
        //System.arraycopy(clientHello.getRandom(), 0, seed, 0, 32);
        //System.arraycopy(serverHello.getRandom(), 0, seed, 32, 32);
        //session.master_secret = new byte[48];
        //if (serverHello.server_version[1] == 1) { 
            //try {
                //PRF.computePRF(session.master_secret, preMasterSecret,
                        //master_secret_bytes, seed);
            //} catch (GeneralSecurityException e) {
                //fatalAlert(AlertProtocol.INTERNAL_ERROR, "PRF error", e);
            //}
        //} else { 
            //PRF.computePRF_SSLv3(session.master_secret, preMasterSecret, seed);
        //}
        //Arrays.fill(preMasterSecret, (byte)0);
        //preMasterSecret = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.801 -0400", hash_original_method = "CE5478587DF2FFE8F2A4389A21077FB6", hash_generated_method = "67CB187255C13607F5E96FB1C8D6EA04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Runnable getTask() {
        {
            boolean varAF384A5E92898F1CD09E3ACF1C440DC6_1639007306 = (delegatedTasks.isEmpty());
        } //End collapsed parenthetic
        Runnable varB1AABD17D7E64F98065DE7BAEFCF4466_1554368619 = (delegatedTasks.remove(0));
        return (Runnable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (delegatedTasks.isEmpty()) {
            //return null;
        //}
        //return delegatedTasks.remove(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.801 -0400", hash_original_method = "3D9F61EAC6A1A98FE4B8371CF8C7FA45", hash_generated_method = "A4CC7ECB0A44218E563D26940E90C14B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void clearMessages() {
        io_stream.clearBuffer();
        clientHello = null;
        serverHello = null;
        serverCert = null;
        serverKeyExchange = null;
        certificateRequest = null;
        serverHelloDone = null;
        clientCert = null;
        clientKeyExchange = null;
        certificateVerify = null;
        clientFinished = null;
        serverFinished = null;
        // ---------- Original Method ----------
        //io_stream.clearBuffer();
        //clientHello = null;
        //serverHello = null;
        //serverCert = null;
        //serverKeyExchange = null;
        //certificateRequest = null;
        //serverHelloDone = null;
        //clientCert = null;
        //clientKeyExchange = null;
        //certificateVerify = null;
        //clientFinished = null;
        //serverFinished = null;
    }

    
        protected static int getRSAKeyLength(PublicKey pk) throws NoSuchAlgorithmException, InvalidKeySpecException {
        BigInteger mod;
        if (pk instanceof RSAKey) {
            mod = ((RSAKey) pk).getModulus();
        } else {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            mod = kf.getKeySpec(pk, RSAPublicKeySpec.class)
                    .getModulus();
        }
        return mod.bitLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.802 -0400", hash_original_method = "824E291676E2CE83DD380D6DD4B4250F", hash_generated_method = "1161DD90D2A5DBD4D9E11BCBF20F168C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void shutdown() {
        clearMessages();
        session = null;
        preMasterSecret = null;
        delegatedTasks.clear();
        // ---------- Original Method ----------
        //clearMessages();
        //session = null;
        //preMasterSecret = null;
        //delegatedTasks.clear();
    }

    
    public static final int NEED_UNWRAP = 1;
    public static final int NOT_HANDSHAKING = 2;
    public static final int FINISHED = 3;
    public static final int NEED_TASK = 4;
}

