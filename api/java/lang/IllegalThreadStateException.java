package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class IllegalThreadStateException extends IllegalArgumentException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.050 -0400", hash_original_method = "5791A934E1D6D40F1C86D615B455C03B", hash_generated_method = "298A639F0F6CE69715D3CB67F1B0216A")
    public  IllegalThreadStateException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.050 -0400", hash_original_method = "3CBEBFECA4223415F4314CC0B87A4ECE", hash_generated_method = "F3A1A13066998D97467C5D3E334EAAF1")
    public  IllegalThreadStateException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.050 -0400", hash_original_field = "79084BBDA638CDAE70E8BD007B3FACD0", hash_generated_field = "816FD291B6FE29E09EF042CECC4919EF")

    private static final long serialVersionUID = -7626246362397460174L;
}

