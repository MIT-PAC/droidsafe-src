package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.023 -0400", hash_original_method = "BFD818381E149072D6480C59814A950B", hash_generated_method = "77DAF02289D0EDFB843688C7F448C11C")
    public  StringIndexOutOfBoundsException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.023 -0400", hash_original_method = "7844EE32C07F0B5F2D2D2CE3133A8CE2", hash_generated_method = "B879DC24848EAD10D5E44EBC72EF69AB")
    public  StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
        addTaint(index);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.023 -0400", hash_original_method = "2720998883F0FDFEFA87A6BF1A5B67C6", hash_generated_method = "04F7FB6C85D05F87582C11C9FDF9C275")
    public  StringIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.024 -0400", hash_original_method = "FCCD2BDA38C43A03106A3DA5EA866DEA", hash_generated_method = "1ADF7BE8BD2635CC9E39C71FFF10F462")
    public  StringIndexOutOfBoundsException(String s, int index) {
        this(s.length(), index);
        addTaint(s.getTaint());
        addTaint(index);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.024 -0400", hash_original_method = "78176BEE1BF5E3D3E49AE6693FD0EBDF", hash_generated_method = "235B5B26F2B7D86CDD5CD6A2EFA06CFE")
    public  StringIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
        addTaint(sourceLength);
        addTaint(index);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.024 -0400", hash_original_method = "E66129678530AEEFFFBEABAD39F4532F", hash_generated_method = "F41B110225C0C0BDA47189F6AD274042")
    public  StringIndexOutOfBoundsException(String s, int offset, int count) {
        this(s.length(), offset, count);
        addTaint(s.getTaint());
        addTaint(offset);
        addTaint(count);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.024 -0400", hash_original_method = "47D615FB94A12D10BEA7B6CBBC941916", hash_generated_method = "D0C22E651865D362AB1F591E6DAACD29")
    public  StringIndexOutOfBoundsException(int sourceLength, int offset,
            int count) {
        super("length=" + sourceLength + "; regionStart=" + offset
                + "; regionLength=" + count);
        addTaint(sourceLength);
        addTaint(offset);
        addTaint(count);
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.024 -0400", hash_original_field = "79B628210C27D5962BCFA3940C8309F9", hash_generated_field = "AC3AE2C28E52C0DAB3994D3DB41195D6")

    private static final long serialVersionUID = -6762910422159637258L;
}

