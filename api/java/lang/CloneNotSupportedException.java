package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CloneNotSupportedException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.633 -0400", hash_original_method = "3D71496D40C645B60B1C6E10AB3776C0", hash_generated_method = "D990718C59BDF04A949966C4F9976823")
    public  CloneNotSupportedException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.633 -0400", hash_original_method = "19F2DAFDEBBAFFF27428A0FB57B58023", hash_generated_method = "825F226779B0E1E0EE82E2030A12B79A")
    public  CloneNotSupportedException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.633 -0400", hash_original_field = "EFDBAB6F0FFF56EFA226BF324AA14082", hash_generated_field = "02486491CED3B07CB6E05085AC582AA7")

    private static final long serialVersionUID = 5195511250079656443L;
}

