package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class WriteAbortedException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.080 -0400", hash_original_field = "951DA6B7179A4F697CC89D36ACF74E52", hash_generated_field = "C3243AD40E57E22F6ED814DD71D64096")

    public Exception detail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.081 -0400", hash_original_method = "DA6C07DB36CBC207B190B4B4ECB6B2B2", hash_generated_method = "2A0929E1F9918CB7629DE62333BFDC40")
    public  WriteAbortedException(String detailMessage, Exception rootCause) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        detail = rootCause;
        initCause(rootCause);
        // ---------- Original Method ----------
        //detail = rootCause;
        //initCause(rootCause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.082 -0400", hash_original_method = "F8C8FA3813C752D5C72108208FEF04C6", hash_generated_method = "2B5CBBB4F23D910FD08E90FEBF5B0606")
    @Override
    public String getMessage() {
        String msg = super.getMessage();
    if(detail != null)        
        {
            msg = msg + "; " + detail.toString();
        } //End block
String varEDC5B72465A7F0BEE288689BCB1DD141_1043689755 =         msg;
        varEDC5B72465A7F0BEE288689BCB1DD141_1043689755.addTaint(taint);
        return varEDC5B72465A7F0BEE288689BCB1DD141_1043689755;
        // ---------- Original Method ----------
        //String msg = super.getMessage();
        //if (detail != null) {
            //msg = msg + "; " + detail.toString();
        //}
        //return msg;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.082 -0400", hash_original_method = "CA6C7AF43E4792C258E5E6922F45606C", hash_generated_method = "B91B7474BBDD96095D3F2C14FADCA2C4")
    @Override
    public Throwable getCause() {
Throwable var7D32F5AE0FDCBBF6DD3F34C021592055_709118040 =         detail;
        var7D32F5AE0FDCBBF6DD3F34C021592055_709118040.addTaint(taint);
        return var7D32F5AE0FDCBBF6DD3F34C021592055_709118040;
        // ---------- Original Method ----------
        //return detail;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.083 -0400", hash_original_field = "D14F55C6FD23B1D97DB4AE900326A4F8", hash_generated_field = "AA38F28709E0DCA1A936B26B13871FE3")

    private static final long serialVersionUID = -3326426625597282442L;
}

