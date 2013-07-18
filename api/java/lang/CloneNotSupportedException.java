package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CloneNotSupportedException extends Exception {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.717 -0400", hash_original_method = "3D71496D40C645B60B1C6E10AB3776C0", hash_generated_method = "D990718C59BDF04A949966C4F9976823")
    public  CloneNotSupportedException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.717 -0400", hash_original_method = "19F2DAFDEBBAFFF27428A0FB57B58023", hash_generated_method = "825F226779B0E1E0EE82E2030A12B79A")
    public  CloneNotSupportedException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.717 -0400", hash_original_field = "EFDBAB6F0FFF56EFA226BF324AA14082", hash_generated_field = "02486491CED3B07CB6E05085AC582AA7")

    private static final long serialVersionUID = 5195511250079656443L;
}

