package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SmsResponse {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.002 -0400", hash_original_field = "3DD57A6A28CB3BA5D3DDB93FBFBCD8F0", hash_generated_field = "E6F7BFC22487D00A28F9E36C2AA573F1")

    int messageRef;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.003 -0400", hash_original_field = "BD83253369470ACA828003EFEC253E8A", hash_generated_field = "447B56C16ADE1A3EBD20B53504F3A1D8")

    String ackPdu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.003 -0400", hash_original_field = "0279985CDCA9AD2836B5DC949AF215C8", hash_generated_field = "882AAD94CF961762112192DCF3E37119")

    int errorCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.004 -0400", hash_original_method = "3700DD8B61A34F0B0DF8E5BCBD18E935", hash_generated_method = "C465187D5327EC890864B613CFFFDF9C")
    public  SmsResponse(int messageRef, String ackPdu, int errorCode) {
        this.messageRef = messageRef;
        this.ackPdu = ackPdu;
        this.errorCode = errorCode;
        // ---------- Original Method ----------
        //this.messageRef = messageRef;
        //this.ackPdu = ackPdu;
        //this.errorCode = errorCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.006 -0400", hash_original_method = "713734C16C162CC185BDF9249475CA58", hash_generated_method = "F41CF0A328FAD3DE9F1C21241B90124B")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_777099876 = null; //Variable for return #1
        String ret;
        ret = "{ messageRef = " + messageRef
                        + ", errorCode = " + errorCode
                        + ", ackPdu = " + ackPdu
                        + "}";
        varB4EAC82CA7396A68D541C85D26508E83_777099876 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_777099876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_777099876;
        // ---------- Original Method ----------
        //String ret = "{ messageRef = " + messageRef
                        //+ ", errorCode = " + errorCode
                        //+ ", ackPdu = " + ackPdu
                        //+ "}";
        //return ret;
    }

    
}

