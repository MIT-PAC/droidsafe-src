package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IncompatibleClassChangeError extends LinkageError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.900 -0400", hash_original_method = "38CC6ACCD85379A3B9DD104582709484", hash_generated_method = "E2CC95403ED1D8F0D7622D45695DC5F3")
    public  IncompatibleClassChangeError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.901 -0400", hash_original_method = "F3D6EF8EF2783206A3E0857F77261690", hash_generated_method = "1B5797BAB14A30FBA0A7AB5EAC40482A")
    public  IncompatibleClassChangeError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.901 -0400", hash_original_field = "A7573CC612D58BAE599CC94E171A0FC8", hash_generated_field = "1C23EEA3DA5024484909EB9F539BF6DF")

    private static final long serialVersionUID = -4914975503642802119L;
}

