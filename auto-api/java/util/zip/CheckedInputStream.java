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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.717 -0400", hash_original_field = "0BA4439EE9A46D9D9F14C60F88F45F87", hash_generated_field = "17891C0CAF0BD7DDA9A721E3165E41B4")

    private Checksum check;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.717 -0400", hash_original_method = "7E1EA825FE47CC59E068EE04C6081636", hash_generated_method = "4F3004B0970C588167D7A76BE6F1ADCB")
    public  CheckedInputStream(InputStream is, Checksum csum) {
        super(is);
        check = csum;
        addTaint(is.getTaint());
        // ---------- Original Method ----------
        //check = csum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.717 -0400", hash_original_method = "4C16D1761C9EE9C5267A2DEA3E7C4510", hash_generated_method = "EC3E257AF30064242B32F7C6A2318B53")
    @Override
    public int read() throws IOException {
        int x = in.read();
        {
            check.update(x);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341311035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341311035;
        // ---------- Original Method ----------
        //int x = in.read();
        //if (x != -1) {
            //check.update(x);
        //}
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.718 -0400", hash_original_method = "7EEC56472DB745F24C7F951D18194473", hash_generated_method = "DB736FDF96946D1B423B2E2928F29E14")
    @Override
    public int read(byte[] buf, int off, int nbytes) throws IOException {
        int x = in.read(buf, off, nbytes);
        {
            check.update(buf, off, x);
        } //End block
        addTaint(buf[0]);
        addTaint(off);
        addTaint(nbytes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882355469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882355469;
        // ---------- Original Method ----------
        //int x = in.read(buf, off, nbytes);
        //if (x != -1) {
            //check.update(buf, off, x);
        //}
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.718 -0400", hash_original_method = "8D60BCB1BD17D4099BEB55CEF28E25BB", hash_generated_method = "872119C18A85EB5A15A8FA8FB7009026")
    public Checksum getChecksum() {
        Checksum varB4EAC82CA7396A68D541C85D26508E83_2016657355 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2016657355 = check;
        varB4EAC82CA7396A68D541C85D26508E83_2016657355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2016657355;
        // ---------- Original Method ----------
        //return check;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.718 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "568C9C2A9701A26E48FE35537CA6E9A9")
    @Override
    public long skip(long byteCount) throws IOException {
        long var242616A7471CF01D821614D0D0C41129_2050862276 = (Streams.skipByReading(this, byteCount));
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1205905297 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1205905297;
        // ---------- Original Method ----------
        //return Streams.skipByReading(this, byteCount);
    }

    
}

