package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public class InternalErrorHandler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.866 -0500", hash_original_method = "7A81082C7995C3F4388AC0936F2411E4", hash_generated_method = "5B16CCB15F07EA81FF5DF93B47D20CC8")
    public static void handleException(Exception ex) throws RuntimeException {
        System.err.println ("Unexpected internal error FIXME!! "  + ex.getMessage());
        ex.printStackTrace();
        throw new RuntimeException("Unexpected internal error FIXME!! "  + ex.getMessage(), ex);

    }
    /**
    * Handle an unexpected exception.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.867 -0500", hash_original_method = "8167B7C0F4F8028B3286DA65D9D2BA29", hash_generated_method = "505288AEE852E44A29BF5EB99C5BB468")
    public static void handleException(Exception ex, StackLogger stackLogger) {
        System.err.println ("Unexpected internal error FIXME!! "  + ex.getMessage());
        stackLogger.logError("UNEXPECTED INTERNAL ERROR FIXME " +  ex.getMessage());
        ex.printStackTrace();
        stackLogger.logException(ex);
        throw new RuntimeException("Unexpected internal error FIXME!! "  + ex.getMessage(), ex);

    }
    /**
    * Handle an unexpected condition (and print the error code).
    */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.868 -0500", hash_original_method = "4AB3E5449D99DD32AC91751756F3538E", hash_generated_method = "E9497FD0935A8BACBD1519C33DF11025")
    public static void handleException(String emsg) {
        new Exception().printStackTrace();
        System.err.println("Unexepcted INTERNAL ERROR FIXME!!");
        System.err.println(emsg);
        throw new RuntimeException(emsg);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.869 -0500", hash_original_method = "BB4ED67FC0CEB44F01338AE5E0576421", hash_generated_method = "C92605E4784E7DF7D67C53D8364E869F")
    public static void handleException(String emsg, StackLogger stackLogger) {
        stackLogger.logStackTrace();
        stackLogger.logError("Unexepcted INTERNAL ERROR FIXME!!");
        stackLogger.logFatalError(emsg);
        throw new RuntimeException(emsg);

    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.407 -0400", hash_original_method = "CDCB3F88E1EC7C264BA47051910F3667", hash_generated_method = "CDCB3F88E1EC7C264BA47051910F3667")
    public InternalErrorHandler ()
    {
        //Synthesized constructor
    }

    
}

