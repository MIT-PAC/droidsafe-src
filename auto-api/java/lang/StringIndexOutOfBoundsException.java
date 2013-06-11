package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = -6762910422159637258L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.540 -0400", hash_original_method = "BFD818381E149072D6480C59814A950B", hash_generated_method = "BA8F92AD8AF360B67F28BA4AFD59E76E")
    @DSModeled(DSC.SAFE)
    public StringIndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.549 -0400", hash_original_method = "7844EE32C07F0B5F2D2D2CE3133A8CE2", hash_generated_method = "D8E19BBBB5E27157055446A38684BAF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.555 -0400", hash_original_method = "2720998883F0FDFEFA87A6BF1A5B67C6", hash_generated_method = "2E93D6D81BE1B2B5DB57A698CF24AA92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.558 -0400", hash_original_method = "FCCD2BDA38C43A03106A3DA5EA866DEA", hash_generated_method = "BA02C09DE120AFD5280009D52FF92663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(String s, int index) {
        this(s.length(), index);
        dsTaint.addTaint(index);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.562 -0400", hash_original_method = "78176BEE1BF5E3D3E49AE6693FD0EBDF", hash_generated_method = "9B74DF59D0E8DC4C9A2C0B73E8A0480B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
        dsTaint.addTaint(index);
        dsTaint.addTaint(sourceLength);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.566 -0400", hash_original_method = "E66129678530AEEFFFBEABAD39F4532F", hash_generated_method = "CC4F4E8FA13F9561CB119FA0D90A5BA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringIndexOutOfBoundsException(String s, int offset, int count) {
        this(s.length(), offset, count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.578 -0400", hash_original_method = "47D615FB94A12D10BEA7B6CBBC941916", hash_generated_method = "23326F9F76057F99DEDF9FAEE5E14F2D")
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

    
}


