package java.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TooManyListenersException extends Exception {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.889 -0400", hash_original_method = "394F16F71C461EE8325C7C30649B2ED3", hash_generated_method = "55BADF54015CFE6EC75248941CAF5B26")
    public  TooManyListenersException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.890 -0400", hash_original_method = "9AD8C053A7A66FB4440B6219D5D227F2", hash_generated_method = "76463DC7BB8F3BF752953D58366FC32A")
    public  TooManyListenersException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.890 -0400", hash_original_field = "F85946716EEA793823D372EB44A8FEA3", hash_generated_field = "A9BE0D402B2678382730EEC5FD3D31D7")

    private static final long serialVersionUID = 5074640544770687831L;
}

