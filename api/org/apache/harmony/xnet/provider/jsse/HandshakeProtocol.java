package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "D031B2072EB1FD157EF6CDA9254DBAE6", hash_generated_field = "597F0BA1953FC2B5C0F1020CDF336C17")

    protected int status = NOT_HANDSHAKING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "DD56F1A66958E3BCA8719029FE31F35B", hash_generated_field = "D957C814D7DDC4DE68646ED82591E597")

    protected HandshakeIODataStream io_stream = new HandshakeIODataStream();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "A83F354A385D300E1D99A939D6779E05")

    protected SSLParametersImpl parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "264F8AE662B2A43E9A119F183CDE4D85", hash_generated_field = "D6CA1371030D664F22454B50AD613A0D")

    protected Vector<DelegatedTask> delegatedTasks = new Vector<DelegatedTask>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "72E9DE442D0453D90FC4586A414DDAF5", hash_generated_field = "E0C542497E078B0356FB026B83FC6DAC")

    protected boolean nonBlocking;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "54015856F8B3ADE4D412900D43506FBE")

    protected SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "090B39A76AC6C27A97008B8EA6E41391", hash_generated_field = "ACF7DA0E852E79D7B75C237DA4C6F842")

    protected ClientHello clientHello;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "C51ADEDA366C8CCE06AF3D95FC990707", hash_generated_field = "8B69E7E0014D0E4A520BA94C6DF912E7")

    protected ServerHello serverHello;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "88283BF65DB1D0F0F6B7BAC7C0E827B9", hash_generated_field = "0857B8B3E0B2556A43C4E871799E9C3A")

    protected CertificateMessage serverCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "6EE028EF337651331388B844F15A0BBE", hash_generated_field = "C10DD678F336F87A2A967BB6CE43AA31")

    protected ServerKeyExchange serverKeyExchange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "1F62FEB37B4676717D68E3BD2B91E13D", hash_generated_field = "A7C994D5B94625763599B38967F6D619")

    protected CertificateRequest certificateRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "79AA6C24183D70C84C699665F635843B", hash_generated_field = "311D6CC91E1261CB2219BFD680A34ED7")

    protected ServerHelloDone serverHelloDone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "3810BD9F662DB780A70DBF5E73CE45C3", hash_generated_field = "120EF91C3AEB56EAF89BD1DC628C3D8E")

    protected CertificateMessage clientCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "EF2D3634C568BCA2258FDD7CC307A452", hash_generated_field = "3042BF6E7C9186362E2806973B117594")

    protected ClientKeyExchange clientKeyExchange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.461 -0400", hash_original_field = "6DF6E7ACC642E1B9610CB6122E118A69", hash_generated_field = "E6601A892E11FB0E707AE92A13BE9250")

    protected CertificateVerify certificateVerify;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "7882DA5A0DC3333C808C73621E67D6AF", hash_generated_field = "F72588D72CE9A70C1D9E9A02FB100720")

    protected Finished clientFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "9B007CC0E4FA2CBD528BD091B9693592", hash_generated_field = "838F69C87275716C2CB41FF8B062A1EB")

    protected Finished serverFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "30A30FE3418030B83A3E93A37C600E65", hash_generated_field = "2B21DA75A471E4F8FD57E7A74CF5A839")

    protected boolean changeCipherSpecReceived = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "8229BA97BAA9C8AA3E5373075540D2A4", hash_generated_field = "073BEE8ECF208262FA22AE60C7A7E408")

    protected boolean isResuming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "5433ADA7B504868EB051257010284899", hash_generated_field = "09BEA74EF7BF60D1E0F8AAEF721F959E")

    protected byte[] preMasterSecret;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "C302C9F58DAA7C348639E6A6530B5A03", hash_generated_field = "6C41066754654FAEB221A3575B3C8A94")

    protected Exception delegatedTaskErr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "8FDD2DCA85C272890616565EDC2B4846", hash_generated_field = "B7F7AF914C75D62F9C046707AA00D246")

    private byte[] verify_data = new byte[12];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "C6A04A7E7C7F2C00799A674022AA96F4", hash_generated_field = "3360FE09C9B33FCDEACC6393D52D3521")

    private byte[] master_secret_bytes = {109, 97, 115, 116, 101, 114, 32, 115, 101, 99, 114, 101, 116 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "27405B242A3871174421549303248E7B", hash_generated_field = "08A3C395C25FA33954ABB3113D25005D")

    private boolean needSendCCSpec = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "2651C1BDD16216147BD238CE808EA141", hash_generated_field = "0414170F3F4CD9022F7CF2296786CD6B")

    protected boolean needSendHelloRequest = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "C8DB43D8D2A4303529C380C051BD89DC", hash_generated_field = "40BD57490518025F0552439D9BE23C2C")

    public SSLEngineImpl engineOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.462 -0400", hash_original_field = "8156C9A5256EE423CC5C5E7367C9A103", hash_generated_field = "DD8FCC1CBD92ED56404D03CE5246006F")

    public SSLSocketImpl socketOwner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.463 -0400", hash_original_method = "6E2FD3B88BA1414C6B3F142DFE23A2F6", hash_generated_method = "F71C033E0C4580167C8F05355A419151")
    protected  HandshakeProtocol(Object owner) {
    if(owner instanceof SSLEngineImpl)        
        {
            engineOwner = (SSLEngineImpl) owner;
            nonBlocking = true;
            this.parameters = engineOwner.sslParameters;
        } //End block
        else
    if(owner instanceof SSLSocketImpl)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.464 -0400", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "C9083453A9DF96FB9488FD8E42A9D875")
    public void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        this.recordProtocol = recordProtocol;
        // ---------- Original Method ----------
        //this.recordProtocol = recordProtocol;
    }

    
    public abstract void start();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.464 -0400", hash_original_method = "CCB194A714BDC12D18860313F52671E7", hash_generated_method = "378E1AD191F24D0435A262BA80FF0EED")
    protected void stop() {
        clearMessages();
        status = NOT_HANDSHAKING;
        // ---------- Original Method ----------
        //clearMessages();
        //status = NOT_HANDSHAKING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.465 -0400", hash_original_method = "0CB6BF73CCE484420EACC5A99703893D", hash_generated_method = "4AEEC4656DDF5C866505D45E97967DF0")
    public SSLEngineResult.HandshakeStatus getStatus() {
    if(io_stream.hasData() || needSendCCSpec ||
                needSendHelloRequest || delegatedTaskErr != null)        
        {
SSLEngineResult.HandshakeStatus varD93BC47E4428FB80139BCF884A7D0255_972411984 =             SSLEngineResult.HandshakeStatus.NEED_WRAP;
            varD93BC47E4428FB80139BCF884A7D0255_972411984.addTaint(taint);
            return varD93BC47E4428FB80139BCF884A7D0255_972411984;
        } //End block
    if(!delegatedTasks.isEmpty())        
        {
SSLEngineResult.HandshakeStatus var66C6E1C839111D0AF19785858C8C7668_1582282066 =             SSLEngineResult.HandshakeStatus.NEED_TASK;
            var66C6E1C839111D0AF19785858C8C7668_1582282066.addTaint(taint);
            return var66C6E1C839111D0AF19785858C8C7668_1582282066;
        } //End block
switch(status){
        case HandshakeProtocol.NEED_UNWRAP:
SSLEngineResult.HandshakeStatus var410FAE431F4BF2BADF6C4EA25EB0AEE4_2029588497 =         SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        var410FAE431F4BF2BADF6C4EA25EB0AEE4_2029588497.addTaint(taint);
        return var410FAE431F4BF2BADF6C4EA25EB0AEE4_2029588497;
        case HandshakeProtocol.FINISHED:
        status = NOT_HANDSHAKING;
        clearMessages();
SSLEngineResult.HandshakeStatus varE2C5D559C52609E96F283E191C1CD7BA_1738670737 =         SSLEngineResult.HandshakeStatus.FINISHED;
        varE2C5D559C52609E96F283E191C1CD7BA_1738670737.addTaint(taint);
        return varE2C5D559C52609E96F283E191C1CD7BA_1738670737;
        default:
SSLEngineResult.HandshakeStatus var68E71D62754FEACD6A50A6182D14BA78_116038222 =         SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        var68E71D62754FEACD6A50A6182D14BA78_116038222.addTaint(taint);
        return var68E71D62754FEACD6A50A6182D14BA78_116038222;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.465 -0400", hash_original_method = "19D70A4F8DD7A34083C18DBEE5C3AF9E", hash_generated_method = "9277AFCF40B641D75735A70FC37CEF61")
    public SSLSessionImpl getSession() {
SSLSessionImpl varD555E544A66E0F97DA6BCDE940E3E79C_2045241958 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_2045241958.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_2045241958;
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.466 -0400", hash_original_method = "95F30AE0B715D4F051584DDF5B47A5AE", hash_generated_method = "5DF4A49BCAA2F792F82CA4782AE77904")
    protected void sendChangeCipherSpec() {
        needSendCCSpec = true;
        // ---------- Original Method ----------
        //needSendCCSpec = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.466 -0400", hash_original_method = "CD5990AD34611898DF18221C46BBB35B", hash_generated_method = "3ED1C82D1126AC414DC77295B793F13B")
    protected void sendHelloRequest() {
        needSendHelloRequest = true;
        // ---------- Original Method ----------
        //needSendHelloRequest = true;
    }

    
    abstract void receiveChangeCipherSpec();

    
    abstract void makeFinished();

    
    public abstract void unwrap(byte[] bytes);

    
    public abstract void unwrapSSLv2(byte[] bytes);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.467 -0400", hash_original_method = "086592130010ECCB1C6429039BD6D57C", hash_generated_method = "639C6223D9598F79A746887E706BBD4A")
    public byte[] wrap() {
    if(delegatedTaskErr != null)        
        {
            Exception e = delegatedTaskErr;
            delegatedTaskErr = null;
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                    "Error occured in delegated task:" + e.getMessage(), e);
        } //End block
    if(io_stream.hasData())        
        {
            byte[] varC3BAFD57CDA596F2A9ACE9ACB2E2AD34_681495709 = (recordProtocol.wrap(ContentType.HANDSHAKE, io_stream));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1993389249 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1993389249;
        } //End block
        else
    if(needSendCCSpec)        
        {
            makeFinished();
            needSendCCSpec = false;
            byte[] var365C71722FB9582534E9FBEF8559C0EC_1610867987 = (recordProtocol.getChangeCipherSpecMesage(getSession()));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_137885357 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_137885357;
        } //End block
        else
    if(needSendHelloRequest)        
        {
            needSendHelloRequest = false;
            byte[] varC76031574324F1DDADD22BE21702CDD5_676234598 = (recordProtocol.wrap(ContentType.HANDSHAKE,
                    new byte[] {0, 0, 0, 0}, 0, 4));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_880375216 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_880375216;
        } //End block
        else
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_921384268 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_254377595 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_254377595;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.468 -0400", hash_original_method = "DC12A1C8331DD94D1ED64B6A8B107CCD", hash_generated_method = "FBB67FF6294AE2481D2D96FE6E48EA00")
    protected void sendWarningAlert(byte description) {
        addTaint(description);
        recordProtocol.alert(AlertProtocol.WARNING, description);
        // ---------- Original Method ----------
        //recordProtocol.alert(AlertProtocol.WARNING, description);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.468 -0400", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "34058502A9C75CFDB4575C379EF00CAF")
    protected void fatalAlert(byte description, String reason) {
        addTaint(reason.getTaint());
        addTaint(description);
        AlertException var799552F05CBB23D97AC6FE1EE17DC122_1347330632 = new AlertException(description, new SSLHandshakeException(reason));
        var799552F05CBB23D97AC6FE1EE17DC122_1347330632.addTaint(taint);
        throw var799552F05CBB23D97AC6FE1EE17DC122_1347330632;
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLHandshakeException(reason));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.468 -0400", hash_original_method = "06E08FFEF783008AA773EFEC73CFC5B4", hash_generated_method = "E93424A25AC01DFD477486739AE617A8")
    protected void fatalAlert(byte description, String reason, Exception cause) {
        addTaint(cause.getTaint());
        addTaint(reason.getTaint());
        addTaint(description);
        AlertException varAB600E5C2470883884CE64C72AED6B37_1481223569 = new AlertException(description, new SSLException(reason, cause));
        varAB600E5C2470883884CE64C72AED6B37_1481223569.addTaint(taint);
        throw varAB600E5C2470883884CE64C72AED6B37_1481223569;
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLException(reason, cause));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.469 -0400", hash_original_method = "6E25B9A677528D560BDF206ADC0AD3D2", hash_generated_method = "51B0473D9C3AAD2BCB392788CA6EC583")
    protected void fatalAlert(byte description, SSLException cause) {
        addTaint(cause.getTaint());
        addTaint(description);
        AlertException varD81CE1ACBFEF9CC9BC82E95B34A392F7_31831001 = new AlertException(description, cause);
        varD81CE1ACBFEF9CC9BC82E95B34A392F7_31831001.addTaint(taint);
        throw varD81CE1ACBFEF9CC9BC82E95B34A392F7_31831001;
        // ---------- Original Method ----------
        //throw new AlertException(description, cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.469 -0400", hash_original_method = "31EC19987B0E319181793E3260EF3B24", hash_generated_method = "3949D01C34DA1350F729F53E24A28044")
    protected void computerReferenceVerifyDataTLS(String label) {
        addTaint(label.getTaint());
        computerVerifyDataTLS(label, verify_data);
        // ---------- Original Method ----------
        //computerVerifyDataTLS(label, verify_data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.469 -0400", hash_original_method = "FE7E38FD7B354AD563BA3A5D1A8C1D76", hash_generated_method = "E9676E6F2BD801DEC90D829BEAE82FCA")
    protected void computerVerifyDataTLS(String label, byte[] buf) {
        addTaint(buf[0]);
        addTaint(label.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.470 -0400", hash_original_method = "6CF424034910BF5E3BE46A11FAF3035E", hash_generated_method = "037A490884601EFFBE9DDEDF1C6735CD")
    protected void computerReferenceVerifyDataSSLv3(byte[] sender) {
        addTaint(sender[0]);
        verify_data = new byte[36];
        computerVerifyDataSSLv3(sender, verify_data);
        // ---------- Original Method ----------
        //verify_data = new byte[36];
        //computerVerifyDataSSLv3(sender, verify_data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.471 -0400", hash_original_method = "B5635FDA5542E47B9F75EEEF571EFF38", hash_generated_method = "14B090939C4C4F0FCC2B9237E1293C03")
    protected void computerVerifyDataSSLv3(byte[] sender, byte[] buf) {
        addTaint(buf[0]);
        addTaint(sender[0]);
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
            return;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.471 -0400", hash_original_method = "552DD0927697CAC79721F456A43352A2", hash_generated_method = "2DFEEBAFAB175EFBC3A9714AEF9D50B6")
    protected void verifyFinished(byte[] data) {
        addTaint(data[0]);
    if(!Arrays.equals(verify_data, data))        
        {
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Incorrect FINISED");
        } //End block
        // ---------- Original Method ----------
        //if (!Arrays.equals(verify_data, data)) {
            //fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Incorrect FINISED");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.471 -0400", hash_original_method = "BE3E381DC2DA6E41C1335D1916EA3AE1", hash_generated_method = "BB36759016C3CEDFE0C884DBCD94ACA3")
    protected void unexpectedMessage() {
        fatalAlert(AlertProtocol.UNEXPECTED_MESSAGE, "UNEXPECTED MESSAGE");
        // ---------- Original Method ----------
        //fatalAlert(AlertProtocol.UNEXPECTED_MESSAGE, "UNEXPECTED MESSAGE");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.472 -0400", hash_original_method = "0009DED469C26D41942AD89710EE0C01", hash_generated_method = "E542A31BC24FF5919214DEDD845699A2")
    public void send(Message message) {
        addTaint(message.getTaint());
        io_stream.writeUint8(message.getType());
        io_stream.writeUint24(message.length());
        message.send(io_stream);
        // ---------- Original Method ----------
        //io_stream.writeUint8(message.getType());
        //io_stream.writeUint24(message.length());
        //message.send(io_stream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.472 -0400", hash_original_method = "BCBA6A3432596AA0D9419AF9C137B62C", hash_generated_method = "5D0124ED7DB0C4D74AB574FB472893F5")
    public void computerMasterSecret() {
        byte[] seed = new byte[64];
        System.arraycopy(clientHello.getRandom(), 0, seed, 0, 32);
        System.arraycopy(serverHello.getRandom(), 0, seed, 32, 32);
        session.master_secret = new byte[48];
    if(serverHello.server_version[1] == 1)        
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
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.473 -0400", hash_original_method = "CE5478587DF2FFE8F2A4389A21077FB6", hash_generated_method = "071C5860B9315DA6FE55460EA3E3D70D")
    public Runnable getTask() {
    if(delegatedTasks.isEmpty())        
        {
Runnable var540C13E9E156B687226421B24F2DF178_36191908 =             null;
            var540C13E9E156B687226421B24F2DF178_36191908.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_36191908;
        } //End block
Runnable var26C8C3773B386D0D496AF0D33B0E53BA_1091736267 =         delegatedTasks.remove(0);
        var26C8C3773B386D0D496AF0D33B0E53BA_1091736267.addTaint(taint);
        return var26C8C3773B386D0D496AF0D33B0E53BA_1091736267;
        // ---------- Original Method ----------
        //if (delegatedTasks.isEmpty()) {
            //return null;
        //}
        //return delegatedTasks.remove(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.473 -0400", hash_original_method = "3D9F61EAC6A1A98FE4B8371CF8C7FA45", hash_generated_method = "A4CC7ECB0A44218E563D26940E90C14B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.474 -0400", hash_original_method = "824E291676E2CE83DD380D6DD4B4250F", hash_generated_method = "1161DD90D2A5DBD4D9E11BCBF20F168C")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.474 -0400", hash_original_field = "01625DD2CB69E6E4446F5DE3188934E6", hash_generated_field = "EAF7D9CFB689B1388474224901240735")

    public static final int NEED_UNWRAP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.474 -0400", hash_original_field = "64913DCAD6DC1F12154127680F7970E0", hash_generated_field = "90705CA5B4FF381448F09A068A97D8E9")

    public static final int NOT_HANDSHAKING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.474 -0400", hash_original_field = "4028E04681E015295E6D0CA122AA6677", hash_generated_field = "BAAE4FE8EC4F4E0DE52B661DD80FFEA9")

    public static final int FINISHED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.474 -0400", hash_original_field = "8C6461A5350D74451AEBB0E2BE5A048C", hash_generated_field = "C038332DD4AA9866529EF19B28D3E8DC")

    public static final int NEED_TASK = 4;
}

