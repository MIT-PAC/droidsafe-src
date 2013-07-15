package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import libcore.io.Streams;

public class CheckedInputStream extends java.io.FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.532 -0400", hash_original_field = "0BA4439EE9A46D9D9F14C60F88F45F87", hash_generated_field = "17891C0CAF0BD7DDA9A721E3165E41B4")

    private Checksum check;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.533 -0400", hash_original_method = "7E1EA825FE47CC59E068EE04C6081636", hash_generated_method = "B239B269541FE8A75DE38E84F5231D3D")
    public  CheckedInputStream(InputStream is, Checksum csum) {
        super(is);
        addTaint(is.getTaint());
        check = csum;
        // ---------- Original Method ----------
        //check = csum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.534 -0400", hash_original_method = "4C16D1761C9EE9C5267A2DEA3E7C4510", hash_generated_method = "AB493A142C088F9B9F4202773FD05FD3")
    @Override
    public int read() throws IOException {
        int x = in.read();
    if(x != -1)        
        {
            check.update(x);
        } //End block
        int var9DD4E461268C8034F5C8564E155C67A6_1015290782 = (x);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82539832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82539832;
        // ---------- Original Method ----------
        //int x = in.read();
        //if (x != -1) {
            //check.update(x);
        //}
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.537 -0400", hash_original_method = "7EEC56472DB745F24C7F951D18194473", hash_generated_method = "667337492A711E82F432D0B01161BFCA")
    @Override
    public int read(byte[] buf, int off, int nbytes) throws IOException {
        addTaint(nbytes);
        addTaint(off);
        addTaint(buf[0]);
        int x = in.read(buf, off, nbytes);
    if(x != -1)        
        {
            check.update(buf, off, x);
        } //End block
        int var9DD4E461268C8034F5C8564E155C67A6_705953269 = (x);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066720501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066720501;
        // ---------- Original Method ----------
        //int x = in.read(buf, off, nbytes);
        //if (x != -1) {
            //check.update(buf, off, x);
        //}
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.537 -0400", hash_original_method = "8D60BCB1BD17D4099BEB55CEF28E25BB", hash_generated_method = "03CD7DE9F2C82B7D2BB6054777ABA1AA")
    public Checksum getChecksum() {
Checksum var9CC2FC46D445C20863EA381528DFA086_2121419141 =         check;
        var9CC2FC46D445C20863EA381528DFA086_2121419141.addTaint(taint);
        return var9CC2FC46D445C20863EA381528DFA086_2121419141;
        // ---------- Original Method ----------
        //return check;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.538 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "67701C11B63A0A14D89018FFA409C743")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
        long var905193B4CE519E6DD3D91E1E370ADA87_1720785202 = (Streams.skipByReading(this, byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_232705092 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_232705092;
        // ---------- Original Method ----------
        //return Streams.skipByReading(this, byteCount);
    }

    
}

