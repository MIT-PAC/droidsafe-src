package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.245 -0400", hash_original_method = "BFD818381E149072D6480C59814A950B", hash_generated_method = "77DAF02289D0EDFB843688C7F448C11C")
    @DSModeled(DSC.SAFE)
    public StringIndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.246 -0400", hash_original_method = "7844EE32C07F0B5F2D2D2CE3133A8CE2", hash_generated_method = "90DD2A8B0A64605ACE6F250E729315BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.246 -0400", hash_original_method = "2720998883F0FDFEFA87A6BF1A5B67C6", hash_generated_method = "FFFC052E4648C9DCB9FA6C87CEA90981")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.246 -0400", hash_original_method = "FCCD2BDA38C43A03106A3DA5EA866DEA", hash_generated_method = "1B5205FEFDEC51B3A371004B807C413B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(String s, int index) {
        this(s.length(), index);
        dsTaint.addTaint(index);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.246 -0400", hash_original_method = "78176BEE1BF5E3D3E49AE6693FD0EBDF", hash_generated_method = "47F6CF288368315CA9C0C1CB74458812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
        dsTaint.addTaint(index);
        dsTaint.addTaint(sourceLength);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.246 -0400", hash_original_method = "E66129678530AEEFFFBEABAD39F4532F", hash_generated_method = "24EF913C1444A988B02959E3D329C7C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(String s, int offset, int count) {
        this(s.length(), offset, count);
        dsTaint.addTaint(count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.247 -0400", hash_original_method = "47D615FB94A12D10BEA7B6CBBC941916", hash_generated_method = "36D44FACFB795A1A068A3C6DCA2EF16D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(int sourceLength, int offset,
            int count) {
        super("length=" + sourceLength + "; regionStart=" + offset
                + "; regionLength=" + count);
        dsTaint.addTaint(count);
        dsTaint.addTaint(sourceLength);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -6762910422159637258L;
}

