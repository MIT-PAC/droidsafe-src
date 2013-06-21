package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.419 -0400", hash_original_method = "2927C5AB3FFF56BF1DCC2EADE5C9261A", hash_generated_method = "0A09B158E5799C73FE56AC7696514B31")
    @DSModeled(DSC.SAFE)
    public ArrayIndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.419 -0400", hash_original_method = "A2D257A78FEA506C4C8D36FA0F1793DA", hash_generated_method = "03706C77F30C41A93CD48F2FF61F93D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayIndexOutOfBoundsException(int index) {
        super("index=" + index);
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.419 -0400", hash_original_method = "1D48A4D94F5DE13F2F12604B33D446C2", hash_generated_method = "EA262899E8BB7A1ED5CE28FE5D66C045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.419 -0400", hash_original_method = "FD6957908D778700DE2EEE696A8B754C", hash_generated_method = "0DE4B436A6F6D18D3CB22942CE1161D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
        dsTaint.addTaint(index);
        dsTaint.addTaint(sourceLength);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.420 -0400", hash_original_method = "5D0675654F8D9644AC21F8916F1DF9DD", hash_generated_method = "B43A3FF8787E06832192DC73FE476FCB")
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

    
    private static final long serialVersionUID = -5116101128118950844L;
}

