package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.469 -0400", hash_original_method = "2927C5AB3FFF56BF1DCC2EADE5C9261A", hash_generated_method = "0A09B158E5799C73FE56AC7696514B31")
    public  ArrayIndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.470 -0400", hash_original_method = "A2D257A78FEA506C4C8D36FA0F1793DA", hash_generated_method = "B641B941FB6A61CB2317662000CBC027")
    public  ArrayIndexOutOfBoundsException(int index) {
        super("index=" + index);
        addTaint(index);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.470 -0400", hash_original_method = "1D48A4D94F5DE13F2F12604B33D446C2", hash_generated_method = "B5591AC4DA48478CF15C54188680F441")
    public  ArrayIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.471 -0400", hash_original_method = "FD6957908D778700DE2EEE696A8B754C", hash_generated_method = "D65DC335579DE7B4C96FFF445E2330F1")
    public  ArrayIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
        addTaint(index);
        addTaint(sourceLength);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.471 -0400", hash_original_method = "5D0675654F8D9644AC21F8916F1DF9DD", hash_generated_method = "A608D0436D8A874940145873D7790E20")
    public  ArrayIndexOutOfBoundsException(int sourceLength, int offset,
            int count) {
        super("length=" + sourceLength + "; regionStart=" + offset
                + "; regionLength=" + count);
        addTaint(count);
        addTaint(offset);
        addTaint(sourceLength);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.471 -0400", hash_original_field = "2CBA047385EDDA03EA4011F726013120", hash_generated_field = "6CD7B1F210CD187D17EA805F9FEEEB81")

    private static final long serialVersionUID = -5116101128118950844L;
}

