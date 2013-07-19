package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class SSLProtocolException extends SSLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.753 -0400", hash_original_method = "980B3B5BE05602C62F726F0E6039DCA2", hash_generated_method = "22DED081DADFA478B92918CE793AB0A3")
    public  SSLProtocolException(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.753 -0400", hash_original_field = "A0455F84B19BE9FF25703066AE4C4CCC", hash_generated_field = "6C50D38407180FECBFC4FCDCF44B613A")

    private static final long serialVersionUID = 5445067063799134928L;
}

