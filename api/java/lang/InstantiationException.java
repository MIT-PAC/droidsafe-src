package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;





public class InstantiationException extends Exception {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.086 -0400", hash_original_method = "4FE52ED96718E49A2C12E29EB6D41BB1", hash_generated_method = "41A9F8C5A9604CBE4AC2140585ED8858")
    public  InstantiationException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.087 -0400", hash_original_method = "5F54417A31BE783961475C78B79DF3BE", hash_generated_method = "BC53AD53B6A263E4868C2D5DB52E8A85")
    public  InstantiationException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.087 -0400", hash_original_method = "6F408C13CB22C61379FA2022EB73B671", hash_generated_method = "977D14F1D6A052030A3E1B44F8E5929D")
      InstantiationException(Class<?> clazz) {
        super(clazz.getName());
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.087 -0400", hash_original_field = "DAF32CAD109904827A958F0CCCFE02F2", hash_generated_field = "57E92CFED008DEE9CBA7BDD040519D1D")

    private static final long serialVersionUID = -8441929162975509110L;
}

