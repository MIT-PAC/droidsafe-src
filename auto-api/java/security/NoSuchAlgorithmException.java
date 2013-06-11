package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class NoSuchAlgorithmException extends GeneralSecurityException {
    private static final long serialVersionUID = -7443947487218346562L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.613 -0400", hash_original_method = "8378123FC231FFDF9C6899E890D8DBB0", hash_generated_method = "4CDC471154D052CE3AF257112D3F9401")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchAlgorithmException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.613 -0400", hash_original_method = "BDAEA1DD03CDDD29A73CAE9E450C10A2", hash_generated_method = "5A998712338D93B965AA771F2A024184")
    @DSModeled(DSC.SAFE)
    public NoSuchAlgorithmException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.613 -0400", hash_original_method = "738326F937D05503D0FB4C9FA84CE359", hash_generated_method = "13852B58B2A1885F6901C0EDF5348924")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchAlgorithmException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.613 -0400", hash_original_method = "24E352B1812045F462874BBBC93C9102", hash_generated_method = "3087C8D63CF6208890C2E3D9E48BAA03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchAlgorithmException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


