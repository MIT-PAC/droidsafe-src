package java.io;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class WriteAbortedException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.808 -0400", hash_original_field = "951DA6B7179A4F697CC89D36ACF74E52", hash_generated_field = "C3243AD40E57E22F6ED814DD71D64096")

    public Exception detail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.809 -0400", hash_original_method = "DA6C07DB36CBC207B190B4B4ECB6B2B2", hash_generated_method = "2A0929E1F9918CB7629DE62333BFDC40")
    public  WriteAbortedException(String detailMessage, Exception rootCause) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        detail = rootCause;
        initCause(rootCause);
        // ---------- Original Method ----------
        //detail = rootCause;
        //initCause(rootCause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.810 -0400", hash_original_method = "F8C8FA3813C752D5C72108208FEF04C6", hash_generated_method = "4E1677ACF439EDE24EAF5BE4544BD510")
    @Override
    public String getMessage() {
        String msg = super.getMessage();
        if(detail != null)        
        {
            msg = msg + "; " + detail.toString();
        } //End block
String varEDC5B72465A7F0BEE288689BCB1DD141_444539859 =         msg;
        varEDC5B72465A7F0BEE288689BCB1DD141_444539859.addTaint(taint);
        return varEDC5B72465A7F0BEE288689BCB1DD141_444539859;
        // ---------- Original Method ----------
        //String msg = super.getMessage();
        //if (detail != null) {
            //msg = msg + "; " + detail.toString();
        //}
        //return msg;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.810 -0400", hash_original_method = "CA6C7AF43E4792C258E5E6922F45606C", hash_generated_method = "B1A908544CFCD0A573711C045A6C3CBF")
    @Override
    public Throwable getCause() {
Throwable var7D32F5AE0FDCBBF6DD3F34C021592055_197024634 =         detail;
        var7D32F5AE0FDCBBF6DD3F34C021592055_197024634.addTaint(taint);
        return var7D32F5AE0FDCBBF6DD3F34C021592055_197024634;
        // ---------- Original Method ----------
        //return detail;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.810 -0400", hash_original_field = "D14F55C6FD23B1D97DB4AE900326A4F8", hash_generated_field = "AA38F28709E0DCA1A936B26B13871FE3")

    private static final long serialVersionUID = -3326426625597282442L;
}

