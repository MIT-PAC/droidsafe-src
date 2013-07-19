package java.util.zip;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;

import libcore.io.Streams;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CheckedInputStream extends java.io.FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.495 -0400", hash_original_field = "0BA4439EE9A46D9D9F14C60F88F45F87", hash_generated_field = "17891C0CAF0BD7DDA9A721E3165E41B4")

    private Checksum check;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.495 -0400", hash_original_method = "7E1EA825FE47CC59E068EE04C6081636", hash_generated_method = "B239B269541FE8A75DE38E84F5231D3D")
    public  CheckedInputStream(InputStream is, Checksum csum) {
        super(is);
        addTaint(is.getTaint());
        check = csum;
        // ---------- Original Method ----------
        //check = csum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.496 -0400", hash_original_method = "4C16D1761C9EE9C5267A2DEA3E7C4510", hash_generated_method = "9E46CBB927AF8C60D483509DA0D61526")
    @Override
    public int read() throws IOException {
        int x = in.read();
        if(x != -1)        
        {
            check.update(x);
        } //End block
        int var9DD4E461268C8034F5C8564E155C67A6_11341637 = (x);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797761401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797761401;
        // ---------- Original Method ----------
        //int x = in.read();
        //if (x != -1) {
            //check.update(x);
        //}
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.496 -0400", hash_original_method = "7EEC56472DB745F24C7F951D18194473", hash_generated_method = "5A9E5EA668DE6288FC5DEF66B37D58EF")
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
        int var9DD4E461268C8034F5C8564E155C67A6_252414966 = (x);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_50362875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_50362875;
        // ---------- Original Method ----------
        //int x = in.read(buf, off, nbytes);
        //if (x != -1) {
            //check.update(buf, off, x);
        //}
        //return x;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.497 -0400", hash_original_method = "8D60BCB1BD17D4099BEB55CEF28E25BB", hash_generated_method = "7F59D90DF5924185093E839D0912BFA9")
    public Checksum getChecksum() {
Checksum var9CC2FC46D445C20863EA381528DFA086_992966526 =         check;
        var9CC2FC46D445C20863EA381528DFA086_992966526.addTaint(taint);
        return var9CC2FC46D445C20863EA381528DFA086_992966526;
        // ---------- Original Method ----------
        //return check;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.497 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "CE4431795F0A514F7ED9009BA58B1C00")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
        long var905193B4CE519E6DD3D91E1E370ADA87_502594383 = (Streams.skipByReading(this, byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_761954354 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_761954354;
        // ---------- Original Method ----------
        //return Streams.skipByReading(this, byteCount);
    }

    
}

