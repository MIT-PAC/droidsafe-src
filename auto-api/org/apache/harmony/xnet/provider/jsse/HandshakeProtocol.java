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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "D031B2072EB1FD157EF6CDA9254DBAE6", hash_generated_field = "597F0BA1953FC2B5C0F1020CDF336C17")

    protected int status = NOT_HANDSHAKING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "DD56F1A66958E3BCA8719029FE31F35B", hash_generated_field = "D957C814D7DDC4DE68646ED82591E597")

    protected HandshakeIODataStream io_stream = new HandshakeIODataStream();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "A83F354A385D300E1D99A939D6779E05")

    protected SSLParametersImpl parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "264F8AE662B2A43E9A119F183CDE4D85", hash_generated_field = "D6CA1371030D664F22454B50AD613A0D")

    protected Vector<DelegatedTask> delegatedTasks = new Vector<DelegatedTask>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "72E9DE442D0453D90FC4586A414DDAF5", hash_generated_field = "E0C542497E078B0356FB026B83FC6DAC")

    protected boolean nonBlocking;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "54015856F8B3ADE4D412900D43506FBE")

    protected SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "090B39A76AC6C27A97008B8EA6E41391", hash_generated_field = "ACF7DA0E852E79D7B75C237DA4C6F842")

    protected ClientHello clientHello;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "C51ADEDA366C8CCE06AF3D95FC990707", hash_generated_field = "8B69E7E0014D0E4A520BA94C6DF912E7")

    protected ServerHello serverHello;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "88283BF65DB1D0F0F6B7BAC7C0E827B9", hash_generated_field = "0857B8B3E0B2556A43C4E871799E9C3A")

    protected CertificateMessage serverCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "6EE028EF337651331388B844F15A0BBE", hash_generated_field = "C10DD678F336F87A2A967BB6CE43AA31")

    protected ServerKeyExchange serverKeyExchange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "1F62FEB37B4676717D68E3BD2B91E13D", hash_generated_field = "A7C994D5B94625763599B38967F6D619")

    protected CertificateRequest certificateRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "79AA6C24183D70C84C699665F635843B", hash_generated_field = "311D6CC91E1261CB2219BFD680A34ED7")

    protected ServerHelloDone serverHelloDone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "3810BD9F662DB780A70DBF5E73CE45C3", hash_generated_field = "120EF91C3AEB56EAF89BD1DC628C3D8E")

    protected CertificateMessage clientCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "EF2D3634C568BCA2258FDD7CC307A452", hash_generated_field = "3042BF6E7C9186362E2806973B117594")

    protected ClientKeyExchange clientKeyExchange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "6DF6E7ACC642E1B9610CB6122E118A69", hash_generated_field = "E6601A892E11FB0E707AE92A13BE9250")

    protected CertificateVerify certificateVerify;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "7882DA5A0DC3333C808C73621E67D6AF", hash_generated_field = "F72588D72CE9A70C1D9E9A02FB100720")

    protected Finished clientFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "9B007CC0E4FA2CBD528BD091B9693592", hash_generated_field = "838F69C87275716C2CB41FF8B062A1EB")

    protected Finished serverFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "30A30FE3418030B83A3E93A37C600E65", hash_generated_field = "2B21DA75A471E4F8FD57E7A74CF5A839")

    protected boolean changeCipherSpecReceived = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "8229BA97BAA9C8AA3E5373075540D2A4", hash_generated_field = "073BEE8ECF208262FA22AE60C7A7E408")

    protected boolean isResuming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "5433ADA7B504868EB051257010284899", hash_generated_field = "09BEA74EF7BF60D1E0F8AAEF721F959E")

    protected byte[] preMasterSecret;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "C302C9F58DAA7C348639E6A6530B5A03", hash_generated_field = "6C41066754654FAEB221A3575B3C8A94")

    protected Exception delegatedTaskErr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "8FDD2DCA85C272890616565EDC2B4846", hash_generated_field = "B7F7AF914C75D62F9C046707AA00D246")

    private byte[] verify_data = new byte[12];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "C6A04A7E7C7F2C00799A674022AA96F4", hash_generated_field = "3360FE09C9B33FCDEACC6393D52D3521")

    private byte[] master_secret_bytes = {109, 97, 115, 116, 101, 114, 32, 115, 101, 99, 114, 101, 116 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "27405B242A3871174421549303248E7B", hash_generated_field = "08A3C395C25FA33954ABB3113D25005D")

    private boolean needSendCCSpec = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "2651C1BDD16216147BD238CE808EA141", hash_generated_field = "0414170F3F4CD9022F7CF2296786CD6B")

    protected boolean needSendHelloRequest = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "C8DB43D8D2A4303529C380C051BD89DC", hash_generated_field = "40BD57490518025F0552439D9BE23C2C")

    public SSLEngineImpl engineOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.178 -0400", hash_original_field = "8156C9A5256EE423CC5C5E7367C9A103", hash_generated_field = "DD8FCC1CBD92ED56404D03CE5246006F")

    public SSLSocketImpl socketOwner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.179 -0400", hash_original_method = "6E2FD3B88BA1414C6B3F142DFE23A2F6", hash_generated_method = "AF6C7D92DC54DB7195DF68FBF54013D1")
    protected  HandshakeProtocol(Object owner) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.179 -0400", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "C9083453A9DF96FB9488FD8E42A9D875")
    public void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        this.recordProtocol = recordProtocol;
        // ---------- Original Method ----------
        //this.recordProtocol = recordProtocol;
    }

    
    public abstract void start();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.180 -0400", hash_original_method = "CCB194A714BDC12D18860313F52671E7", hash_generated_method = "378E1AD191F24D0435A262BA80FF0EED")
    protected void stop() {
        clearMessages();
        status = NOT_HANDSHAKING;
        // ---------- Original Method ----------
        //clearMessages();
        //status = NOT_HANDSHAKING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.180 -0400", hash_original_method = "0CB6BF73CCE484420EACC5A99703893D", hash_generated_method = "F9A0D059891D3B2629C3E3655DCCC17B")
    public SSLEngineResult.HandshakeStatus getStatus() {
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1811700253 = null; //Variable for return #1
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1797988295 = null; //Variable for return #2
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1281645371 = null; //Variable for return #3
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1026856713 = null; //Variable for return #4
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_71802072 = null; //Variable for return #5
        {
            boolean var4A912B6D5D3397A70E26E30E30B3CCC9_1276869773 = (io_stream.hasData() || needSendCCSpec ||
                needSendHelloRequest || delegatedTaskErr != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1811700253 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9A65276F6F9B0ED8A56151AD30EBD70C_1376590047 = (!delegatedTasks.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1797988295 = SSLEngineResult.HandshakeStatus.NEED_TASK;
            } //End block
        } //End collapsed parenthetic
        //Begin case HandshakeProtocol.NEED_UNWRAP 
        varB4EAC82CA7396A68D541C85D26508E83_1281645371 = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        //End case HandshakeProtocol.NEED_UNWRAP 
        //Begin case HandshakeProtocol.FINISHED 
        status = NOT_HANDSHAKING;
        //End case HandshakeProtocol.FINISHED 
        //Begin case HandshakeProtocol.FINISHED 
        clearMessages();
        //End case HandshakeProtocol.FINISHED 
        //Begin case HandshakeProtocol.FINISHED 
        varB4EAC82CA7396A68D541C85D26508E83_1026856713 = SSLEngineResult.HandshakeStatus.FINISHED;
        //End case HandshakeProtocol.FINISHED 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_71802072 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        //End case default 
        SSLEngineResult.HandshakeStatus varA7E53CE21691AB073D9660D615818899_613409277; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_613409277 = varB4EAC82CA7396A68D541C85D26508E83_1811700253;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_613409277 = varB4EAC82CA7396A68D541C85D26508E83_1797988295;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_613409277 = varB4EAC82CA7396A68D541C85D26508E83_1281645371;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_613409277 = varB4EAC82CA7396A68D541C85D26508E83_1026856713;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_613409277 = varB4EAC82CA7396A68D541C85D26508E83_71802072;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_613409277.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_613409277;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.182 -0400", hash_original_method = "19D70A4F8DD7A34083C18DBEE5C3AF9E", hash_generated_method = "421D8BBC4E76E03731FE10395FE7C518")
    public SSLSessionImpl getSession() {
        SSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_1286227433 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1286227433 = session;
        varB4EAC82CA7396A68D541C85D26508E83_1286227433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1286227433;
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.182 -0400", hash_original_method = "95F30AE0B715D4F051584DDF5B47A5AE", hash_generated_method = "5DF4A49BCAA2F792F82CA4782AE77904")
    protected void sendChangeCipherSpec() {
        needSendCCSpec = true;
        // ---------- Original Method ----------
        //needSendCCSpec = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.183 -0400", hash_original_method = "CD5990AD34611898DF18221C46BBB35B", hash_generated_method = "3ED1C82D1126AC414DC77295B793F13B")
    protected void sendHelloRequest() {
        needSendHelloRequest = true;
        // ---------- Original Method ----------
        //needSendHelloRequest = true;
    }

    
    abstract void receiveChangeCipherSpec();

    
    abstract void makeFinished();

    
    public abstract void unwrap(byte[] bytes);

    
    public abstract void unwrapSSLv2(byte[] bytes);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.184 -0400", hash_original_method = "086592130010ECCB1C6429039BD6D57C", hash_generated_method = "D763F036352C78CAA19BDF5DF11DDA45")
    public byte[] wrap() {
        {
            Exception e = delegatedTaskErr;
            delegatedTaskErr = null;
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                    "Error occured in delegated task:" + e.getMessage(), e);
        } //End block
        {
            boolean var9CC89A3A5AC109D0C018B7D53AE8276D_210920386 = (io_stream.hasData());
            {
                byte[] var3BF1168A5F3DFA56460A41E4D5A14127_785680237 = (recordProtocol.wrap(ContentType.HANDSHAKE, io_stream));
            } //End block
            {
                makeFinished();
                needSendCCSpec = false;
                byte[] var4EE5DBD7B96BD2A3090E287A0DDD2197_2087321880 = (recordProtocol.getChangeCipherSpecMesage(getSession()));
            } //End block
            {
                needSendHelloRequest = false;
                byte[] var1EF5A3C0CFD1B342D0B4D4B37120467E_934397125 = (recordProtocol.wrap(ContentType.HANDSHAKE,
                    new byte[] {0, 0, 0, 0}, 0, 4));
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2078775111 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2078775111;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.185 -0400", hash_original_method = "DC12A1C8331DD94D1ED64B6A8B107CCD", hash_generated_method = "1FF3788E4C5B9DD3E3A9C1B54B79322B")
    protected void sendWarningAlert(byte description) {
        recordProtocol.alert(AlertProtocol.WARNING, description);
        addTaint(description);
        // ---------- Original Method ----------
        //recordProtocol.alert(AlertProtocol.WARNING, description);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.185 -0400", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "F69AC1801CF91CF5B116C4A126917FF1")
    protected void fatalAlert(byte description, String reason) {
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, new SSLHandshakeException(reason));
        addTaint(description);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLHandshakeException(reason));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.185 -0400", hash_original_method = "06E08FFEF783008AA773EFEC73CFC5B4", hash_generated_method = "77DABCD1F8FE0D629CDBD6565D1D4986")
    protected void fatalAlert(byte description, String reason, Exception cause) {
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, new SSLException(reason, cause));
        addTaint(description);
        addTaint(reason.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLException(reason, cause));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.185 -0400", hash_original_method = "6E25B9A677528D560BDF206ADC0AD3D2", hash_generated_method = "CEB84A16F4AA15E97DC9076EE04DAD56")
    protected void fatalAlert(byte description, SSLException cause) {
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, cause);
        addTaint(description);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //throw new AlertException(description, cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.186 -0400", hash_original_method = "31EC19987B0E319181793E3260EF3B24", hash_generated_method = "D2C484D6ECCF1CD38EE7FB4846E2B688")
    protected void computerReferenceVerifyDataTLS(String label) {
        computerVerifyDataTLS(label, verify_data);
        addTaint(label.getTaint());
        // ---------- Original Method ----------
        //computerVerifyDataTLS(label, verify_data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.186 -0400", hash_original_method = "FE7E38FD7B354AD563BA3A5D1A8C1D76", hash_generated_method = "618A1F2A1DD60C3D3CAD3DD07CD0744E")
    protected void computerVerifyDataTLS(String label, byte[] buf) {
        byte[] md5_digest = io_stream.getDigestMD5();
        byte[] sha_digest = io_stream.getDigestSHA();
        byte[] digest = new byte[md5_digest.length + sha_digest.length];
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
        addTaint(label.getTaint());
        addTaint(buf[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.186 -0400", hash_original_method = "6CF424034910BF5E3BE46A11FAF3035E", hash_generated_method = "46867EFAA6391B9F54CB8BE8CD536BB6")
    protected void computerReferenceVerifyDataSSLv3(byte[] sender) {
        verify_data = new byte[36];
        computerVerifyDataSSLv3(sender, verify_data);
        addTaint(sender[0]);
        // ---------- Original Method ----------
        //verify_data = new byte[36];
        //computerVerifyDataSSLv3(sender, verify_data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.187 -0400", hash_original_method = "B5635FDA5542E47B9F75EEEF571EFF38", hash_generated_method = "C44E96A83E7BDD2779031CF983A5074B")
    protected void computerVerifyDataSSLv3(byte[] sender, byte[] buf) {
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
        } //End block
        catch (Exception e)
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
        } //End block
        addTaint(sender[0]);
        addTaint(buf[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.187 -0400", hash_original_method = "552DD0927697CAC79721F456A43352A2", hash_generated_method = "CF14DCDEB15FAF6115138296FDA43535")
    protected void verifyFinished(byte[] data) {
        {
            boolean var077BC70DF9FFE67884E321AA2E817B02_2002384796 = (!Arrays.equals(verify_data, data));
            {
                fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Incorrect FINISED");
            } //End block
        } //End collapsed parenthetic
        addTaint(data[0]);
        // ---------- Original Method ----------
        //if (!Arrays.equals(verify_data, data)) {
            //fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Incorrect FINISED");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.188 -0400", hash_original_method = "BE3E381DC2DA6E41C1335D1916EA3AE1", hash_generated_method = "BB36759016C3CEDFE0C884DBCD94ACA3")
    protected void unexpectedMessage() {
        fatalAlert(AlertProtocol.UNEXPECTED_MESSAGE, "UNEXPECTED MESSAGE");
        // ---------- Original Method ----------
        //fatalAlert(AlertProtocol.UNEXPECTED_MESSAGE, "UNEXPECTED MESSAGE");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.188 -0400", hash_original_method = "0009DED469C26D41942AD89710EE0C01", hash_generated_method = "3DC80A41D7289B224BBFBD622ADAC89A")
    public void send(Message message) {
        io_stream.writeUint8(message.getType());
        io_stream.writeUint24(message.length());
        message.send(io_stream);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //io_stream.writeUint8(message.getType());
        //io_stream.writeUint24(message.length());
        //message.send(io_stream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.188 -0400", hash_original_method = "BCBA6A3432596AA0D9419AF9C137B62C", hash_generated_method = "EE060BF40C47ADFA5199C7CF930EF74C")
    public void computerMasterSecret() {
        byte[] seed = new byte[64];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.189 -0400", hash_original_method = "CE5478587DF2FFE8F2A4389A21077FB6", hash_generated_method = "0441B29FD8A817DAE096CD5E1E35C582")
    public Runnable getTask() {
        Runnable varB4EAC82CA7396A68D541C85D26508E83_939239320 = null; //Variable for return #1
        Runnable varB4EAC82CA7396A68D541C85D26508E83_1985126426 = null; //Variable for return #2
        {
            boolean varAF384A5E92898F1CD09E3ACF1C440DC6_294508345 = (delegatedTasks.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_939239320 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1985126426 = delegatedTasks.remove(0);
        Runnable varA7E53CE21691AB073D9660D615818899_2039255643; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2039255643 = varB4EAC82CA7396A68D541C85D26508E83_939239320;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2039255643 = varB4EAC82CA7396A68D541C85D26508E83_1985126426;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2039255643.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2039255643;
        // ---------- Original Method ----------
        //if (delegatedTasks.isEmpty()) {
            //return null;
        //}
        //return delegatedTasks.remove(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.189 -0400", hash_original_method = "3D9F61EAC6A1A98FE4B8371CF8C7FA45", hash_generated_method = "A4CC7ECB0A44218E563D26940E90C14B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.190 -0400", hash_original_method = "824E291676E2CE83DD380D6DD4B4250F", hash_generated_method = "1161DD90D2A5DBD4D9E11BCBF20F168C")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.190 -0400", hash_original_field = "01625DD2CB69E6E4446F5DE3188934E6", hash_generated_field = "EAF7D9CFB689B1388474224901240735")

    public static final int NEED_UNWRAP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.190 -0400", hash_original_field = "64913DCAD6DC1F12154127680F7970E0", hash_generated_field = "90705CA5B4FF381448F09A068A97D8E9")

    public static final int NOT_HANDSHAKING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.190 -0400", hash_original_field = "4028E04681E015295E6D0CA122AA6677", hash_generated_field = "BAAE4FE8EC4F4E0DE52B661DD80FFEA9")

    public static final int FINISHED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.190 -0400", hash_original_field = "8C6461A5350D74451AEBB0E2BE5A048C", hash_generated_field = "C038332DD4AA9866529EF19B28D3E8DC")

    public static final int NEED_TASK = 4;
}

