package gov.nist.core;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class InternalErrorHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.407 -0400", hash_original_method = "CDCB3F88E1EC7C264BA47051910F3667", hash_generated_method = "CDCB3F88E1EC7C264BA47051910F3667")
    public InternalErrorHandler ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static void handleException(Exception ex) throws RuntimeException {
        System.err.println ("Unexpected internal error FIXME!! "  + ex.getMessage());
        ex.printStackTrace();
        throw new RuntimeException("Unexpected internal error FIXME!! "  + ex.getMessage(), ex);
    }

    
    @DSModeled(DSC.SAFE)
    public static void handleException(Exception ex, StackLogger stackLogger) {
        System.err.println ("Unexpected internal error FIXME!! "  + ex.getMessage());
        stackLogger.logError("UNEXPECTED INTERNAL ERROR FIXME " +  ex.getMessage());
        ex.printStackTrace();
        stackLogger.logException(ex);
        throw new RuntimeException("Unexpected internal error FIXME!! "  + ex.getMessage(), ex);
    }

    
    @DSModeled(DSC.SAFE)
    public static void handleException(String emsg) {
        new Exception().printStackTrace();
        System.err.println("Unexepcted INTERNAL ERROR FIXME!!");
        System.err.println(emsg);
        throw new RuntimeException(emsg);
    }

    
    @DSModeled(DSC.SAFE)
    public static void handleException(String emsg, StackLogger stackLogger) {
        stackLogger.logStackTrace();
        stackLogger.logError("Unexepcted INTERNAL ERROR FIXME!!");
        stackLogger.logFatalError(emsg);
        throw new RuntimeException(emsg);
    }

    
}

