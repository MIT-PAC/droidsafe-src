package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;





public class ASN1ParsingException extends IllegalStateException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.748 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.749 -0400", hash_original_method = "A04BEE8A9A73EAD532708A0AE36FAA5C", hash_generated_method = "B74E3B8C969CC011DCD96E67B42BFF1B")
      ASN1ParsingException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.750 -0400", hash_original_method = "9ABB1845457B0FD65DC264E5CAAB1469", hash_generated_method = "18BF7A2B1AFF0B7FE09CB5BBE740B59B")
      ASN1ParsingException(String message, Throwable cause) {
        super(message);
        addTaint(message.getTaint());
        this.cause = cause;
        // ---------- Original Method ----------
        //this.cause = cause;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.751 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "71C9798E92E7CC1DC8F954F1E51919D3")
    public Throwable getCause() {
Throwable var3C8F3313F49435961542E8707E527956_78050001 =         cause;
        var3C8F3313F49435961542E8707E527956_78050001.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_78050001;
        // ---------- Original Method ----------
        //return cause;
    }

    
}

