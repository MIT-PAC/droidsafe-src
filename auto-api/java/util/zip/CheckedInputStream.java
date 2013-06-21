package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import libcore.io.Streams;

public class CheckedInputStream extends java.io.FilterInputStream {
    private Checksum check;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.683 -0400", hash_original_method = "7E1EA825FE47CC59E068EE04C6081636", hash_generated_method = "48378065F211EE59C2F4E90EF8902CA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckedInputStream(InputStream is, Checksum csum) {
        super(is);
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(csum.dsTaint);
        // ---------- Original Method ----------
        //check = csum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.684 -0400", hash_original_method = "4C16D1761C9EE9C5267A2DEA3E7C4510", hash_generated_method = "48B9E6097F9DF574BF603AFE58A906E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        int x;
        x = in.read();
        {
            check.update(x);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int x = in.read();
        //if (x != -1) {
            //check.update(x);
        //}
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.684 -0400", hash_original_method = "7EEC56472DB745F24C7F951D18194473", hash_generated_method = "BE8B6A4C17005C66214AF5B32AA47F02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buf, int off, int nbytes) throws IOException {
        dsTaint.addTaint(nbytes);
        dsTaint.addTaint(off);
        dsTaint.addTaint(buf[0]);
        int x;
        x = in.read(buf, off, nbytes);
        {
            check.update(buf, off, x);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int x = in.read(buf, off, nbytes);
        //if (x != -1) {
            //check.update(buf, off, x);
        //}
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.684 -0400", hash_original_method = "8D60BCB1BD17D4099BEB55CEF28E25BB", hash_generated_method = "273DB9B0E91763B3DF2E82159F9BFC50")
    @DSModeled(DSC.SAFE)
    public Checksum getChecksum() {
        return (Checksum)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return check;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.685 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "C5B4D4EE517F01B774EA8C638B49CBCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        long var242616A7471CF01D821614D0D0C41129_821462973 = (Streams.skipByReading(this, byteCount));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return Streams.skipByReading(this, byteCount);
    }

    
}

