package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InterruptedIOException;




public class SocketTimeoutException extends InterruptedIOException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.535 -0400", hash_original_method = "4A11638BF238EC4AAC97B2692C051A84", hash_generated_method = "AA146E7357A4622B881D9BB8D6E998AE")
    public  SocketTimeoutException() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.535 -0400", hash_original_method = "09713AE8E462C0BAD085649F546AAF7D", hash_generated_method = "3B5D6C4F8CE4710610DF045731ECEC55")
    public  SocketTimeoutException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.535 -0400", hash_original_method = "154D3A6011E860B522250E3541FB283D", hash_generated_method = "E7D94C43A005F854FFE41822EDF08CF0")
    public  SocketTimeoutException(Throwable cause) {
        super(null, cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.535 -0400", hash_original_method = "A2F64A06EC646B0B6CC4F19E5E317D3C", hash_generated_method = "20DEABEF5F8F11AD604B02825B5870F4")
    public  SocketTimeoutException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.536 -0400", hash_original_field = "E32112FE3E68DFFDD08139673A877CC6", hash_generated_field = "8C635471367BCD967F4DCF81C8430878")

    private static final long serialVersionUID = -8846654841826352300L;
}

