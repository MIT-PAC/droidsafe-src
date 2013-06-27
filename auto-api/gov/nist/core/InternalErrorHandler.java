package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InternalErrorHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.607 -0400", hash_original_method = "CDCB3F88E1EC7C264BA47051910F3667", hash_generated_method = "CDCB3F88E1EC7C264BA47051910F3667")
    public InternalErrorHandler ()
    {
        //Synthesized constructor
    }


        public static void handleException(Exception ex) throws RuntimeException {
        System.err.println ("Unexpected internal error FIXME!! "  + ex.getMessage());
        ex.printStackTrace();
        throw new RuntimeException("Unexpected internal error FIXME!! "  + ex.getMessage(), ex);
    }

    
        public static void handleException(Exception ex, StackLogger stackLogger) {
        System.err.println ("Unexpected internal error FIXME!! "  + ex.getMessage());
        stackLogger.logError("UNEXPECTED INTERNAL ERROR FIXME " +  ex.getMessage());
        ex.printStackTrace();
        stackLogger.logException(ex);
        throw new RuntimeException("Unexpected internal error FIXME!! "  + ex.getMessage(), ex);
    }

    
        public static void handleException(String emsg) {
        new Exception().printStackTrace();
        System.err.println("Unexepcted INTERNAL ERROR FIXME!!");
        System.err.println(emsg);
        throw new RuntimeException(emsg);
    }

    
        public static void handleException(String emsg, StackLogger stackLogger) {
        stackLogger.logStackTrace();
        stackLogger.logError("Unexepcted INTERNAL ERROR FIXME!!");
        stackLogger.logFatalError(emsg);
        throw new RuntimeException(emsg);
    }

    
}

