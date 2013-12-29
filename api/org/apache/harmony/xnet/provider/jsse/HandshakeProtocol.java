package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Returns RSA key length
     * @param pk
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.495 -0500", hash_original_method = "6DB15DD0BD60828A881DB21CE4013970", hash_generated_method = "397D1164D4C04040EFB466BC8E4ED0FD")
    protected static int getRSAKeyLength(PublicKey pk)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.445 -0500", hash_original_field = "7C84707E7788F8311955011A560B318A", hash_generated_field = "EAF7D9CFB689B1388474224901240735")

    public static final int NEED_UNWRAP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.446 -0500", hash_original_field = "2327998E658E0D7146277AD66FF0F6B8", hash_generated_field = "90705CA5B4FF381448F09A068A97D8E9")

    public static final int NOT_HANDSHAKING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.447 -0500", hash_original_field = "13C0421C39868879F2C68E238B1D3145", hash_generated_field = "BAAE4FE8EC4F4E0DE52B661DD80FFEA9")

    public static final int FINISHED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.448 -0500", hash_original_field = "37244B8FC5FD64B371B8086FFF842B18", hash_generated_field = "C038332DD4AA9866529EF19B28D3E8DC")

    public static final int NEED_TASK = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.449 -0500", hash_original_field = "6565A5A4C01012A4EA4B1C7E954E0014", hash_generated_field = "597F0BA1953FC2B5C0F1020CDF336C17")

    protected int status = NOT_HANDSHAKING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.450 -0500", hash_original_field = "72C9F62F86D6FCBB37DF599BE3F8B7D9", hash_generated_field = "D957C814D7DDC4DE68646ED82591E597")

    protected HandshakeIODataStream io_stream = new HandshakeIODataStream();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.451 -0500", hash_original_field = "450F49BACBC7E7E38A182C4284626ACE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.451 -0500", hash_original_field = "9E7529EC3EF011CF01BAF182FEE33F5D", hash_generated_field = "A83F354A385D300E1D99A939D6779E05")

    protected SSLParametersImpl parameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.452 -0500", hash_original_field = "2D37D5B31469FD0D479CB90FC3B38359", hash_generated_field = "D6CA1371030D664F22454B50AD613A0D")

    protected Vector<DelegatedTask> delegatedTasks = new Vector<DelegatedTask>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.453 -0500", hash_original_field = "5E48BA7123A80CCF8E68545EE53696B3", hash_generated_field = "E0C542497E078B0356FB026B83FC6DAC")

    protected boolean nonBlocking;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.454 -0500", hash_original_field = "2FEA9607120FF1F874D7A8B19B248896", hash_generated_field = "54015856F8B3ADE4D412900D43506FBE")

    protected SSLSessionImpl session;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.454 -0500", hash_original_field = "807C897CC0A16A47E06AB32356ACC2A1", hash_generated_field = "ACF7DA0E852E79D7B75C237DA4C6F842")

    protected ClientHello clientHello;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.455 -0500", hash_original_field = "35B21451B7D8D60D88D28CE3DB16529F", hash_generated_field = "8B69E7E0014D0E4A520BA94C6DF912E7")

    protected ServerHello serverHello;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.456 -0500", hash_original_field = "99D74B46D2CDDF7885E46DA9E98A9F45", hash_generated_field = "0857B8B3E0B2556A43C4E871799E9C3A")

    protected CertificateMessage serverCert;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.457 -0500", hash_original_field = "8632FAF7CF9E6F953CECEC5DBAD9CEC0", hash_generated_field = "C10DD678F336F87A2A967BB6CE43AA31")

    protected ServerKeyExchange serverKeyExchange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.457 -0500", hash_original_field = "30006506240091BF1351EF112C9FD346", hash_generated_field = "A7C994D5B94625763599B38967F6D619")

    protected CertificateRequest certificateRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.458 -0500", hash_original_field = "2BA70941B6195D288E3A38A2F2485C32", hash_generated_field = "311D6CC91E1261CB2219BFD680A34ED7")

    protected ServerHelloDone serverHelloDone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.459 -0500", hash_original_field = "B444B40843881558BCE9EBAA12C7BF8B", hash_generated_field = "120EF91C3AEB56EAF89BD1DC628C3D8E")

    protected CertificateMessage clientCert;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.460 -0500", hash_original_field = "128B37324F0DC03EF6DDC9AC4D56E9BA", hash_generated_field = "3042BF6E7C9186362E2806973B117594")

    protected ClientKeyExchange clientKeyExchange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.461 -0500", hash_original_field = "FCEC20461E09BA6782C482694F197D9B", hash_generated_field = "E6601A892E11FB0E707AE92A13BE9250")

    protected CertificateVerify certificateVerify;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.462 -0500", hash_original_field = "704A3BBF23B9D4B89209C05D9DD968BB", hash_generated_field = "F72588D72CE9A70C1D9E9A02FB100720")

    protected Finished clientFinished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.462 -0500", hash_original_field = "371C6CAA1E2089DED22172BBE2C58CE2", hash_generated_field = "838F69C87275716C2CB41FF8B062A1EB")

    protected Finished serverFinished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.463 -0500", hash_original_field = "CDE9A3A19B14BD47065B7354B9A608BD", hash_generated_field = "2B21DA75A471E4F8FD57E7A74CF5A839")

    protected boolean changeCipherSpecReceived = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.464 -0500", hash_original_field = "A02988B8F1EC223210C6C16C9E736B2F", hash_generated_field = "073BEE8ECF208262FA22AE60C7A7E408")

    protected boolean isResuming = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.465 -0500", hash_original_field = "FC376A60B4E22DBEB884EA41BD97DFAD", hash_generated_field = "09BEA74EF7BF60D1E0F8AAEF721F959E")

    protected byte[] preMasterSecret;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.466 -0500", hash_original_field = "EAC7965F27D5716C026404D878BE62C3", hash_generated_field = "6C41066754654FAEB221A3575B3C8A94")

    protected Exception delegatedTaskErr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.467 -0500", hash_original_field = "4FB373D2066EEC9780C0152FDC430B0E", hash_generated_field = "B7F7AF914C75D62F9C046707AA00D246")

    private byte[] verify_data = new byte[12];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.467 -0500", hash_original_field = "D95328A464B8481EBF45A686ACEB06C1", hash_generated_field = "3360FE09C9B33FCDEACC6393D52D3521")

    private byte[] master_secret_bytes =
            {109, 97, 115, 116, 101, 114, 32, 115, 101, 99, 114, 101, 116 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.468 -0500", hash_original_field = "938140E259ABA54248FDC2668E86AA9E", hash_generated_field = "08A3C395C25FA33954ABB3113D25005D")

    private boolean needSendCCSpec = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.469 -0500", hash_original_field = "E6F15B48231337D95B1B4173343804F7", hash_generated_field = "0414170F3F4CD9022F7CF2296786CD6B")

    protected boolean needSendHelloRequest = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.470 -0500", hash_original_field = "4C0C615FD8E492C0561DE353AAA2B3C6", hash_generated_field = "40BD57490518025F0552439D9BE23C2C")

    public SSLEngineImpl engineOwner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.470 -0500", hash_original_field = "4F898E82BDDC0A417D5647C1E21DB903", hash_generated_field = "DD8FCC1CBD92ED56404D03CE5246006F")

    public SSLSocketImpl socketOwner;

    /**
     * Creates HandshakeProtocol instance
     * @param owner
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.471 -0500", hash_original_method = "6E2FD3B88BA1414C6B3F142DFE23A2F6", hash_generated_method = "7047D26FF558EDD6DC5A4364FE0666EC")
    protected HandshakeProtocol(Object owner) {
        if (owner instanceof SSLEngineImpl) {
            engineOwner = (SSLEngineImpl) owner;
            nonBlocking = true;
            this.parameters = engineOwner.sslParameters;
        }
        else if (owner instanceof SSLSocketImpl) {
            socketOwner = (SSLSocketImpl) owner;
            nonBlocking = false;
            this.parameters = socketOwner.sslParameters;
        }
    }

    /**
     * Sets SSL Record Protocol
     * @param recordProtocol
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.472 -0500", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "BFEEA8D29C230474377B140B6C2C33C1")
    public void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        this.recordProtocol = recordProtocol;
    }

    /**
     * Start session negotiation
     * @param session
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.473 -0500", hash_original_method = "F8A4DBF1E6F2CEC0927301856B440BE5", hash_generated_method = "70F2B76AB4E373BB2D2DD8B7A0409F0C")
    public abstract void start();

    /**
     * Stops the current session renegotiation process.
     * Such functionality is needed when it is session renegotiation
     * process and no_renegotiation alert message is received
     * from another peer.
     * @param session
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.473 -0500", hash_original_method = "CCB194A714BDC12D18860313F52671E7", hash_generated_method = "31A34714C6E662B7EF2E6359B85486E8")
    protected void stop() {
        clearMessages();
        status = NOT_HANDSHAKING;
    }

    /**
     * Returns handshake status
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.475 -0500", hash_original_method = "0CB6BF73CCE484420EACC5A99703893D", hash_generated_method = "5FA7F147417F485E969740493461ED4B")
    public SSLEngineResult.HandshakeStatus getStatus() {
        if (io_stream.hasData() || needSendCCSpec ||
                needSendHelloRequest || delegatedTaskErr != null) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        if (!delegatedTasks.isEmpty()) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }

        switch (status) {
        case HandshakeProtocol.NEED_UNWRAP:
            return SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        case HandshakeProtocol.FINISHED:
            status = NOT_HANDSHAKING;
            clearMessages();
            return SSLEngineResult.HandshakeStatus.FINISHED;
        default: // HandshakeProtocol.NOT_HANDSHAKING:
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
    }

    /**
     * Returns pending session
     * @return session
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.476 -0500", hash_original_method = "19D70A4F8DD7A34083C18DBEE5C3AF9E", hash_generated_method = "629850FA49FD101BEC165A6DAF84CE06")
    public SSLSessionImpl getSession() {
        return session;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.477 -0500", hash_original_method = "95F30AE0B715D4F051584DDF5B47A5AE", hash_generated_method = "30E94A10CD3D2294E0889420FB38DEC2")
    protected void sendChangeCipherSpec() {
        needSendCCSpec = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.477 -0500", hash_original_method = "CD5990AD34611898DF18221C46BBB35B", hash_generated_method = "CE09B5BC2AB9A30A1C4528019BF865FF")
    protected void sendHelloRequest() {
        needSendHelloRequest = true;
    }

    /**
     * Proceses inbound ChangeCipherSpec message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.478 -0500", hash_original_method = "6A3A0B0C26526B0D6E04B0DD204B8614", hash_generated_method = "C0CA24B351F2CB89B06F27615BB0A34A")
    abstract void receiveChangeCipherSpec();

    /**
     * Creates and sends finished message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.479 -0500", hash_original_method = "CC2414E222628E693519C21AEB277F5D", hash_generated_method = "EABD2DD5E4BA22FC8EEFAA18647F6AAA")
    abstract void makeFinished();

    /**
     * Proceses inbound handshake messages
     * @param bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.480 -0500", hash_original_method = "50A905395944DD5BD4D38FF882717F8E", hash_generated_method = "8ECCD1520AF0DB75006E120605B7FB00")
    public abstract void unwrap(byte[] bytes);

    /**
     * Processes SSLv2 Hello message
     * @param bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.481 -0500", hash_original_method = "FCB333C8686CED00C54558985DF56619", hash_generated_method = "0EE769189B7034EEC63A1F3D98B338D7")
    public abstract void unwrapSSLv2(byte[] bytes);

    /**
     * Proceses outbound handshake messages
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.482 -0500", hash_original_method = "086592130010ECCB1C6429039BD6D57C", hash_generated_method = "2158E90FA8CF495C7349DE9CB8A3B094")
    public byte[] wrap() {
        if (delegatedTaskErr != null) {
            // process error occured in delegated task
            Exception e = delegatedTaskErr;
            delegatedTaskErr = null;
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                    "Error occured in delegated task:" + e.getMessage(), e);
        }
        if (io_stream.hasData()) {
            return recordProtocol.wrap(ContentType.HANDSHAKE, io_stream);
        } else if (needSendCCSpec) {
            makeFinished();
            needSendCCSpec = false;
            return recordProtocol.getChangeCipherSpecMesage(getSession());
        } else if (needSendHelloRequest) {
            needSendHelloRequest = false;
            return recordProtocol.wrap(ContentType.HANDSHAKE,
                    // hello request message
                    // (see TLS v 1 specification:
                    // http://www.ietf.org/rfc/rfc2246.txt)
                    new byte[] {0, 0, 0, 0}, 0, 4);
        } else {
            return null; // nothing to send;
        }
    }

    /**
     * Sends fatal alert, breaks execution
     *
     * @param description
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.482 -0500", hash_original_method = "DC12A1C8331DD94D1ED64B6A8B107CCD", hash_generated_method = "C23B0BDF05DC8FE4E3D66D1BBD27A8C7")
    protected void sendWarningAlert(byte description) {
        recordProtocol.alert(AlertProtocol.WARNING, description);
    }

    /**
     * Sends fatal alert, breaks execution
     *
     * @param description
     * @param reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.483 -0500", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "9867DC8FBFE9F1B9BC6DB5E6A4B30F51")
    protected void fatalAlert(byte description, String reason) {
        throw new AlertException(description, new SSLHandshakeException(reason));
    }

    /**
     * Sends fatal alert, breaks execution
     *
     * @param description
     * @param reason
     * @param cause
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.484 -0500", hash_original_method = "06E08FFEF783008AA773EFEC73CFC5B4", hash_generated_method = "15CA365E49E82623C6856C21BD52246D")
    protected void fatalAlert(byte description, String reason, Exception cause) {
        throw new AlertException(description, new SSLException(reason, cause));
    }

    /**
     * Sends fatal alert, breaks execution
     *
     * @param description
     * @param cause
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.485 -0500", hash_original_method = "6E25B9A677528D560BDF206ADC0AD3D2", hash_generated_method = "61AA41E75628EFEA6E5DF73FD310FA4D")
    protected void fatalAlert(byte description, SSLException cause) {
        throw new AlertException(description, cause);
    }

    /**
     * Computers reference TLS verify_data that is used to verify finished message
     * @see <a href="http://www.ietf.org/rfc/rfc2246.txt">TLS spec. 7.4.9. Finished</a>
     * @param label
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.486 -0500", hash_original_method = "31EC19987B0E319181793E3260EF3B24", hash_generated_method = "012ACDAE862F6AC2E4C7B7D26B9BCE2F")
    protected void computerReferenceVerifyDataTLS(String label) {
        computerVerifyDataTLS(label, verify_data);
    }

    /**
     * Computer TLS verify_data
     * @see <a href="http://www.ietf.org/rfc/rfc2246.txt">TLS spec. 7.4.9. Finished</a>
     * @param label
     * @param buf
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.487 -0500", hash_original_method = "FE7E38FD7B354AD563BA3A5D1A8C1D76", hash_generated_method = "78E9AE1C8A1AB209AE4E689BC3E57DEE")
    protected void computerVerifyDataTLS(String label, byte[] buf) {
        byte[] md5_digest = io_stream.getDigestMD5();
        byte[] sha_digest = io_stream.getDigestSHA();

        byte[] digest = new byte[md5_digest.length + sha_digest.length];
        System.arraycopy(md5_digest, 0, digest, 0, md5_digest.length);
        System.arraycopy(sha_digest, 0, digest, md5_digest.length,
                sha_digest.length);
        try {
            PRF.computePRF(buf, session.master_secret,
                    label.getBytes(), digest);
        } catch (GeneralSecurityException e) {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "PRF error", e);
        }
    }

    /**
     * Computer reference SSLv3 verify_data that is used to verify finished message
     * @see "SSLv3 spec. 7.6.9. Finished"
     * @param label
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.488 -0500", hash_original_method = "6CF424034910BF5E3BE46A11FAF3035E", hash_generated_method = "CFB88D25F50896AE6E7E696C6C789BA8")
    protected void computerReferenceVerifyDataSSLv3(byte[] sender) {
        verify_data = new byte[36];
        computerVerifyDataSSLv3(sender, verify_data);
    }

    /**
     * Computer SSLv3 verify_data
     * @see "SSLv3 spec. 7.6.9. Finished"
     * @param label
     * @param buf
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.489 -0500", hash_original_method = "B5635FDA5542E47B9F75EEEF571EFF38", hash_generated_method = "348CD1643FFEB0EF0CBC6841E74E6F82")
    protected void computerVerifyDataSSLv3(byte[] sender, byte[] buf) {
        MessageDigest md5;
        MessageDigest sha;
        try {
            md5 = MessageDigest.getInstance("MD5");
            sha = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                       "Could not initialize the Digest Algorithms.",
                       e);
            return;
        }
        try {
            byte[] handshake_messages = io_stream.getMessages();
            md5.update(handshake_messages);
            md5.update(sender);
            md5.update(session.master_secret);
            byte[] b = md5.digest(SSLv3Constants.MD5pad1);
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
        } catch (Exception e) {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);

        }
    }

    /**
     * Verifies finished data
     *
     * @param data
     * @param isServer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.489 -0500", hash_original_method = "552DD0927697CAC79721F456A43352A2", hash_generated_method = "3C0773FA6D8088662F9FEACA98CE259E")
    protected void verifyFinished(byte[] data) {
        if (!Arrays.equals(verify_data, data)) {
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Incorrect FINISED");
        }
    }

    /**
     * Sends fatal alert "UNEXPECTED MESSAGE"
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.490 -0500", hash_original_method = "BE3E381DC2DA6E41C1335D1916EA3AE1", hash_generated_method = "644742F3E12E1DBE1D0162AB5C937114")
    protected void unexpectedMessage() {
        fatalAlert(AlertProtocol.UNEXPECTED_MESSAGE, "UNEXPECTED MESSAGE");
    }

    /**
     * Writes message to HandshakeIODataStream
     *
     * @param message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.491 -0500", hash_original_method = "0009DED469C26D41942AD89710EE0C01", hash_generated_method = "2225A3335F1D8E53AB255168629B865D")
    public void send(Message message) {
        io_stream.writeUint8(message.getType());
        io_stream.writeUint24(message.length());
        message.send(io_stream);
    }

    /**
     * Computers master secret
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.492 -0500", hash_original_method = "BCBA6A3432596AA0D9419AF9C137B62C", hash_generated_method = "EBD8F633A76A3608E8BFC876F9C37430")
    public void computerMasterSecret() {
        byte[] seed = new byte[64];
        System.arraycopy(clientHello.getRandom(), 0, seed, 0, 32);
        System.arraycopy(serverHello.getRandom(), 0, seed, 32, 32);
        session.master_secret = new byte[48];
        if (serverHello.server_version[1] == 1) { // TLSv1
            try {
                PRF.computePRF(session.master_secret, preMasterSecret,
                        master_secret_bytes, seed);
            } catch (GeneralSecurityException e) {
                fatalAlert(AlertProtocol.INTERNAL_ERROR, "PRF error", e);
            }
        } else { // SSL3.0
            PRF.computePRF_SSLv3(session.master_secret, preMasterSecret, seed);
        }

        //delete preMasterSecret from memory
        Arrays.fill(preMasterSecret, (byte)0);
        preMasterSecret = null;
    }

    /**
     * Returns a delegated task.
     * @return Delegated task or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.493 -0500", hash_original_method = "CE5478587DF2FFE8F2A4389A21077FB6", hash_generated_method = "76519B8D7CE9A665A89BA0194B92C1FA")
    public Runnable getTask() {
        if (delegatedTasks.isEmpty()) {
            return null;
        }
        return delegatedTasks.remove(0);
    }

    /**
     * Clears previously sent and received handshake messages
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.494 -0500", hash_original_method = "3D9F61EAC6A1A98FE4B8371CF8C7FA45", hash_generated_method = "65EC01E99AAB6E5A68EF399B7CC9276A")
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
    }

    /**
     * Shuts down the protocol. It will be impossible to use the instance
     * after calling this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.496 -0500", hash_original_method = "824E291676E2CE83DD380D6DD4B4250F", hash_generated_method = "5D5B2295438B6F70B9815281DA3F617D")
    protected void shutdown() {
        clearMessages();
        session = null;
        preMasterSecret = null;
        delegatedTasks.clear();
    }
}

