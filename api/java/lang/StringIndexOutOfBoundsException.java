package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;





public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.278 -0400", hash_original_method = "BFD818381E149072D6480C59814A950B", hash_generated_method = "77DAF02289D0EDFB843688C7F448C11C")
    public  StringIndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.279 -0400", hash_original_method = "7844EE32C07F0B5F2D2D2CE3133A8CE2", hash_generated_method = "B879DC24848EAD10D5E44EBC72EF69AB")
    public  StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
        addTaint(index);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.279 -0400", hash_original_method = "2720998883F0FDFEFA87A6BF1A5B67C6", hash_generated_method = "04F7FB6C85D05F87582C11C9FDF9C275")
    public  StringIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.279 -0400", hash_original_method = "FCCD2BDA38C43A03106A3DA5EA866DEA", hash_generated_method = "DA14F557B0862047DB80DD324FF09EC1")
    public  StringIndexOutOfBoundsException(String s, int index) {
        this(s.length(), index);
        addTaint(index);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.280 -0400", hash_original_method = "78176BEE1BF5E3D3E49AE6693FD0EBDF", hash_generated_method = "2679EC849F08B1F36D38E289625FF876")
    public  StringIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
        addTaint(index);
        addTaint(sourceLength);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.280 -0400", hash_original_method = "E66129678530AEEFFFBEABAD39F4532F", hash_generated_method = "C03D3CFBA15A060D7AECB3D6A3CDAB03")
    public  StringIndexOutOfBoundsException(String s, int offset, int count) {
        this(s.length(), offset, count);
        addTaint(count);
        addTaint(offset);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.280 -0400", hash_original_method = "47D615FB94A12D10BEA7B6CBBC941916", hash_generated_method = "7C1B7B96D1E68363DCF368740C7F68DD")
    public  StringIndexOutOfBoundsException(int sourceLength, int offset,
            int count) {
        super("length=" + sourceLength + "; regionStart=" + offset
                + "; regionLength=" + count);
        addTaint(count);
        addTaint(offset);
        addTaint(sourceLength);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.280 -0400", hash_original_field = "79B628210C27D5962BCFA3940C8309F9", hash_generated_field = "AC3AE2C28E52C0DAB3994D3DB41195D6")

    private static final long serialVersionUID = -6762910422159637258L;
}

