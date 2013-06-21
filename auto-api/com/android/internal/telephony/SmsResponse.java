package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SmsResponse {
    int messageRef;
    String ackPdu;
    int errorCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.506 -0400", hash_original_method = "3700DD8B61A34F0B0DF8E5BCBD18E935", hash_generated_method = "0DC16D59F1876B0DB84F801F53441DB1")
    @DSModeled(DSC.SAFE)
    public SmsResponse(int messageRef, String ackPdu, int errorCode) {
        dsTaint.addTaint(messageRef);
        dsTaint.addTaint(errorCode);
        dsTaint.addTaint(ackPdu);
        // ---------- Original Method ----------
        //this.messageRef = messageRef;
        //this.ackPdu = ackPdu;
        //this.errorCode = errorCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.507 -0400", hash_original_method = "713734C16C162CC185BDF9249475CA58", hash_generated_method = "0FA96412630E289AC4D2A12C96151729")
    @DSModeled(DSC.SAFE)
    public String toString() {
        String ret;
        ret = "{ messageRef = " + messageRef
                        + ", errorCode = " + errorCode
                        + ", ackPdu = " + ackPdu
                        + "}";
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String ret = "{ messageRef = " + messageRef
                        //+ ", errorCode = " + errorCode
                        //+ ", ackPdu = " + ackPdu
                        //+ "}";
        //return ret;
    }

    
}

