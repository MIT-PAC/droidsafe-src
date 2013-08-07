package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;





public class NumberFormatException extends IllegalArgumentException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.376 -0400", hash_original_method = "5EB9584C9C40374DC4817FFEDC3C2AF2", hash_generated_method = "CD0AD29B716E5461A290DCEA6E30AEFB")
    public  NumberFormatException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.376 -0400", hash_original_method = "E8CAE1FBBA27FF2762363375A55E9E2D", hash_generated_method = "412D1BFE498F71BF71A0CE8E8E2BB12F")
    public  NumberFormatException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.376 -0400", hash_original_field = "467749A1C61D0A6A779AF4BAE05032B4", hash_generated_field = "4EECED22A3600992D325F6581476D42F")

    private static final long serialVersionUID = -2848938806368998894L;
}

