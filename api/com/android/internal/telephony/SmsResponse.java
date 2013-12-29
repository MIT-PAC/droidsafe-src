package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class SmsResponse {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:08.326 -0500", hash_original_field = "E6F7BFC22487D00A28F9E36C2AA573F1", hash_generated_field = "E6F7BFC22487D00A28F9E36C2AA573F1")

    int messageRef;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:08.327 -0500", hash_original_field = "447B56C16ADE1A3EBD20B53504F3A1D8", hash_generated_field = "447B56C16ADE1A3EBD20B53504F3A1D8")

    String ackPdu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:08.328 -0500", hash_original_field = "882AAD94CF961762112192DCF3E37119", hash_generated_field = "882AAD94CF961762112192DCF3E37119")

    int errorCode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:08.329 -0500", hash_original_method = "3700DD8B61A34F0B0DF8E5BCBD18E935", hash_generated_method = "862F856DD52DE47D969EA6BC32E4AF97")
    public SmsResponse(int messageRef, String ackPdu, int errorCode) {
        this.messageRef = messageRef;
        this.ackPdu = ackPdu;
        this.errorCode = errorCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:08.329 -0500", hash_original_method = "713734C16C162CC185BDF9249475CA58", hash_generated_method = "B5147131D2C4BB90C91C47A69831E916")
    public String toString() {
        String ret = "{ messageRef = " + messageRef
                        + ", errorCode = " + errorCode
                        + ", ackPdu = " + ackPdu
                        + "}";
        return ret;
    }

    
}

