package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = -5116101128118950844L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:44.909 -0400", hash_original_method = "2927C5AB3FFF56BF1DCC2EADE5C9261A", hash_generated_method = "D6A7E2D0C3ECB262BE1BA40B70D9CCBB")
    @DSModeled(DSC.SAFE)
    public ArrayIndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:44.921 -0400", hash_original_method = "A2D257A78FEA506C4C8D36FA0F1793DA", hash_generated_method = "5A68C4EF24B411F2A68F0F2A84C17717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayIndexOutOfBoundsException(int index) {
        super("index=" + index);
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:44.928 -0400", hash_original_method = "1D48A4D94F5DE13F2F12604B33D446C2", hash_generated_method = "C8AB843FE821BC18873EBECE7FB6D0EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:44.954 -0400", hash_original_method = "FD6957908D778700DE2EEE696A8B754C", hash_generated_method = "49EBBAD010544362D152FEC8C5232103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
        dsTaint.addTaint(index);
        dsTaint.addTaint(sourceLength);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:44.962 -0400", hash_original_method = "5D0675654F8D9644AC21F8916F1DF9DD", hash_generated_method = "EE3E6C842A3AE06629ACD87D5A553D1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayIndexOutOfBoundsException(int sourceLength, int offset,
            int count) {
        super("length=" + sourceLength + "; regionStart=" + offset
                + "; regionLength=" + count);
        dsTaint.addTaint(count);
        dsTaint.addTaint(sourceLength);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
    }

    
}


