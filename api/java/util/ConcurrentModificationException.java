package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;





public class ConcurrentModificationException extends RuntimeException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.975 -0400", hash_original_method = "5F5AEF59023EF0CE03A16FBB12617DB7", hash_generated_method = "79688BEA5D6B303CB294241AA0949D8E")
    public  ConcurrentModificationException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.975 -0400", hash_original_method = "106C24DD3D2A07AA8584E42740C7683A", hash_generated_method = "48EF744F66E1DD67C648FF03510CC342")
    public  ConcurrentModificationException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.975 -0400", hash_original_method = "2C18D4011661B4B4C3C2AF76F80D71D0", hash_generated_method = "D54BC96BBFF941E955626CF545F2B2D1")
    public  ConcurrentModificationException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.975 -0400", hash_original_method = "1483D8E8224DDF6AD31766681C65E484", hash_generated_method = "51B1549ED82E454472609869B884B7D8")
    public  ConcurrentModificationException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.975 -0400", hash_original_field = "6F023EBCD220EEE9FD9D969786933435", hash_generated_field = "BE6788E7D91F00AD085BECEE1E4F5DE1")

    private static final long serialVersionUID = -3666751008965953603L;
}

