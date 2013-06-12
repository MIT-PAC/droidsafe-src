package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class Exception extends Throwable {
    private static final long serialVersionUID = -3387516993124229948L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.831 -0400", hash_original_method = "D33746B9B653741A49B1BE35D2346C75", hash_generated_method = "07385F0EB4B6E21732DB5429AAB84EB6")
    @DSModeled(DSC.SAFE)
    public Exception() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.833 -0400", hash_original_method = "830A2EF4A7E30C0BE0D23F3C6E3EB88B", hash_generated_method = "9CAF51EEEB6DA11DC08A7CD6991F52FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Exception(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.840 -0400", hash_original_method = "1CCC5FB7B2239F395100A328B05F71D2", hash_generated_method = "CF8FBF5F6FA1FE55A21F8E5FB9A28A96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Exception(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        dsTaint.addTaint(throwable.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.843 -0400", hash_original_method = "521C63C689E06CBA8E8D56AF626D043A", hash_generated_method = "DF5F0BAF323B39235F98BF43E4373EBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Exception(Throwable throwable) {
        super(throwable);
        dsTaint.addTaint(throwable.dsTaint);
        // ---------- Original Method ----------
    }

    
}


