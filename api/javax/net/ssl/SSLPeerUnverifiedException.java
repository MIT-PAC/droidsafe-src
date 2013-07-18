package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class SSLPeerUnverifiedException extends SSLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.749 -0400", hash_original_method = "198A20ABB6370047567C4951E56F9C8C", hash_generated_method = "5CFD4B00A4BD790EDA2EC86D0197F0CA")
    public  SSLPeerUnverifiedException(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.749 -0400", hash_original_field = "A0BD1239B498850B8CA77FFA94C57673", hash_generated_field = "529865C8061FB502ADFD15F514107B36")

    private static final long serialVersionUID = -8919512675000600547L;
}

