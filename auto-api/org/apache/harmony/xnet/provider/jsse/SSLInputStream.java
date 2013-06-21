package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public abstract class SSLInputStream extends InputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.134 -0400", hash_original_method = "10A555D326B1264D31F2966D88548B45", hash_generated_method = "10A555D326B1264D31F2966D88548B45")
        public SSLInputStream ()
    {
    }


        @Override
public abstract int available() throws IOException;

    
        @Override
public abstract int read() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.135 -0400", hash_original_method = "4E61964AC41EB7FF0B969F3A0D2A867E", hash_generated_method = "B083E46D6F002DBFF188027E0E49B5B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readUint8() throws IOException {
        int var0A245C5D7D7AF87D5AC85935D6857130_1490244764 = (read() & 0x00FF);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return read() & 0x00FF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.135 -0400", hash_original_method = "0E243896410AF2472245902D7F89ED82", hash_generated_method = "E99C3E1291D320CEC3FC7AD955AABEBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readUint16() throws IOException {
        int varB6A221FBB44243AE4B9959A8F6F94EF0_1484730228 = ((read() << 8) | (read() & 0x00FF));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.136 -0400", hash_original_method = "B71B56A9E36B8A8CD4C9FE0969EFEC79", hash_generated_method = "1365256378E4D198D63ED6BD81F26B81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readUint24() throws IOException {
        int var4644244AAE0134751CFA3303634B453B_2072624584 = ((read() << 16) | (read() << 8) | (read() & 0x00FF));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (read() << 16) | (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.136 -0400", hash_original_method = "18D59391AE7948DA8080AA965DB6CE79", hash_generated_method = "E8DE12371700EBCE560FAA526C6F220E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long readUint32() throws IOException {
        long varA4D3DD0DD1277968F4256A67EF96B630_475621799 = ((read() << 24) | (read() << 16)
              | (read() << 8) | (read() & 0x00FF));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (read() << 24) | (read() << 16)
              //| (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.136 -0400", hash_original_method = "85B7C4B5BFF5E58A56D479C7E3A9AABB", hash_generated_method = "80FA536FB4C89B3510F52F11411E6AAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long readUint64() throws IOException {
        long hi;
        hi = readUint32();
        long lo;
        lo = readUint32();
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long hi = readUint32();
        //long lo = readUint32();
        //return (hi << 32) | lo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.136 -0400", hash_original_method = "22A07573F54A4BDDEECBBE8A8D080BB9", hash_generated_method = "08A013F7224CD0C6AEEC5A04C3651FAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] read(int length) throws IOException {
        dsTaint.addTaint(length);
        byte[] res;
        res = new byte[length];
        {
            int i;
            i = 0;
            {
                res[i] = (byte) read();
            } //End block
        } //End collapsed parenthetic
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] res = new byte[length];
        //for (int i=0; i<length; i++) {
            //res[i] = (byte) read();
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.137 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "B3A9A1E668E6F3FEC8FAC98A177E47B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        int read_b;
        int i;
        i = 0;
        {
            {
                boolean var58A5278A655D93F97DA0180416078C33_2033609745 = ((read_b = read()) == -1);
            } //End collapsed parenthetic
            b[off+i] = (byte) read_b;
        } //End block
        {
            boolean var455A44C366F5A1443EF5626F0B5953C6_1525162539 = ((available() != 0) && (i<len));
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int read_b;
        //int i = 0;
        //do {
            //if ((read_b = read()) == -1) {
                //return (i == 0) ? -1 : i;
            //}
            //b[off+i] = (byte) read_b;
            //i++;
        //} while ((available() != 0) && (i<len));
        //return i;
    }

    
}

