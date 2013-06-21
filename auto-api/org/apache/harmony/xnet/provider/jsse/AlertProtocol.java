package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AlertProtocol {
    private byte[] alert = new byte[2];
    private SSLRecordProtocol recordProtocol;
    private Logger.Stream logger = Logger.getStream("alert");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.525 -0400", hash_original_method = "E092E2209250C02F09C22B7C95E9AB91", hash_generated_method = "89DDAFEDBDC6600ADF822412966FC90D")
    @DSModeled(DSC.SAFE)
    protected AlertProtocol() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.525 -0400", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "61C32BF109EE32F25FF25A8EA639C225")
    @DSModeled(DSC.SAFE)
    protected void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        dsTaint.addTaint(recordProtocol.dsTaint);
        // ---------- Original Method ----------
        //this.recordProtocol = recordProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.526 -0400", hash_original_method = "F413EBA539C7D7D57656EE1032BAAF7C", hash_generated_method = "137228D98978F2709DB43717083CAE52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void alert(byte level, byte description) {
        dsTaint.addTaint(level);
        dsTaint.addTaint(description);
        {
            logger.println("Alert.alert: "+level+" "+description);
        } //End block
        this.alert[0] = level;
        this.alert[1] = description;
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("Alert.alert: "+level+" "+description);
        //}
        //this.alert[0] = level;
        //this.alert[1] = description;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.526 -0400", hash_original_method = "5D3BF0EC0666EBF860C9DC61576F480B", hash_generated_method = "BFCF99C3AC702B73135FFADFC5A6CC61")
    @DSModeled(DSC.SAFE)
    protected byte getDescriptionCode() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (alert[0] != 0) ? alert[1] : -100;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.526 -0400", hash_original_method = "87AB9C19E1A7EED4E3BFCF946809E0DA", hash_generated_method = "A0DF94AF8223CEFC3C62A1275D1D3B6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setProcessed() {
        {
            logger.println("Alert.setProcessed");
        } //End block
        this.alert[0] = 0;
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("Alert.setProcessed");
        //}
        //this.alert[0] = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.526 -0400", hash_original_method = "45A2D96003EBC85CF21133EEF592859F", hash_generated_method = "610315F7CA7B8C00AE05592B63A99C3E")
    @DSModeled(DSC.SAFE)
    protected boolean hasAlert() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (alert[0] != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.526 -0400", hash_original_method = "7F9DD2505076B3CAC6687DC8D86BE7DC", hash_generated_method = "82411469CF9E2E7B2FE3D64D7DB297EB")
    @DSModeled(DSC.SAFE)
    protected boolean isFatalAlert() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (alert[0] == 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.527 -0400", hash_original_method = "4ED335C5479EFEAB65BE48D985C7B953", hash_generated_method = "1F82922F52BEC67E2FF4B75F2C06DFC0")
    @DSModeled(DSC.SAFE)
    protected String getAlertDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.527 -0400", hash_original_method = "124BFC00035B67AF657D6336BEA07CC5", hash_generated_method = "9B73CA92A126509892075BB6C2FB54BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] wrap() {
        byte[] res;
        res = recordProtocol.wrap(ContentType.ALERT, alert, 0, 2);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] res = recordProtocol.wrap(ContentType.ALERT, alert, 0, 2);
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.527 -0400", hash_original_method = "18F927F44CECC98A241CC5D3FE86DBCB", hash_generated_method = "F942F8E12961415D1B4D2C24C8077619")
    @DSModeled(DSC.SAFE)
    protected void shutdown() {
        alert[0] = 0;
        alert[1] = 0;
        recordProtocol = null;
        // ---------- Original Method ----------
        //alert[0] = 0;
        //alert[1] = 0;
        //recordProtocol = null;
    }

    
    protected static final byte WARNING = 1;
    protected static final byte FATAL = 2;
    protected static final byte CLOSE_NOTIFY = 0;
    protected static final byte UNEXPECTED_MESSAGE = 10;
    protected static final byte BAD_RECORD_MAC = 20;
    protected static final byte DECRYPTION_FAILED = 21;
    protected static final byte RECORD_OVERFLOW = 22;
    protected static final byte DECOMPRESSION_FAILURE = 30;
    protected static final byte HANDSHAKE_FAILURE = 40;
    protected static final byte BAD_CERTIFICATE = 42;
    protected static final byte UNSUPPORTED_CERTIFICATE = 43;
    protected static final byte CERTIFICATE_REVOKED = 44;
    protected static final byte CERTIFICATE_EXPIRED = 45;
    protected static final byte CERTIFICATE_UNKNOWN = 46;
    protected static final byte ILLEGAL_PARAMETER = 47;
    protected static final byte UNKNOWN_CA = 48;
    protected static final byte ACCESS_DENIED = 49;
    protected static final byte DECODE_ERROR = 50;
    protected static final byte DECRYPT_ERROR = 51;
    protected static final byte EXPORT_RESTRICTION = 60;
    protected static final byte PROTOCOL_VERSION = 70;
    protected static final byte INSUFFICIENT_SECURITY = 71;
    protected static final byte INTERNAL_ERROR = 80;
    protected static final byte USER_CANCELED = 90;
    protected static final byte NO_RENEGOTIATION = 100;
}

