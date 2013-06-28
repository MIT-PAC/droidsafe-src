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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.802 -0400", hash_original_method = "B3907DD288EBA16F858ADC5177372075", hash_generated_method = "B3907DD288EBA16F858ADC5177372075")
    public SSLInputStream ()
    {
        //Synthesized constructor
    }


    @Override
public abstract int available() throws IOException;

    
    @Override
public abstract int read() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.803 -0400", hash_original_method = "4E61964AC41EB7FF0B969F3A0D2A867E", hash_generated_method = "B997CC10E611DD2E66ED8EE498D87984")
    public int readUint8() throws IOException {
        int var0A245C5D7D7AF87D5AC85935D6857130_1875373417 = (read() & 0x00FF);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691309240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691309240;
        // ---------- Original Method ----------
        //return read() & 0x00FF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.804 -0400", hash_original_method = "0E243896410AF2472245902D7F89ED82", hash_generated_method = "BE11489949258B258F7AD1E65920494A")
    public int readUint16() throws IOException {
        int varB6A221FBB44243AE4B9959A8F6F94EF0_702881051 = ((read() << 8) | (read() & 0x00FF));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144956162 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144956162;
        // ---------- Original Method ----------
        //return (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.804 -0400", hash_original_method = "B71B56A9E36B8A8CD4C9FE0969EFEC79", hash_generated_method = "419B05B6CB6F23E84A01FB22FA852F9A")
    public int readUint24() throws IOException {
        int var4644244AAE0134751CFA3303634B453B_52128222 = ((read() << 16) | (read() << 8) | (read() & 0x00FF));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398951569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398951569;
        // ---------- Original Method ----------
        //return (read() << 16) | (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.805 -0400", hash_original_method = "18D59391AE7948DA8080AA965DB6CE79", hash_generated_method = "8F07BB89DCF7AD1FD15C1B23DB7F6141")
    public long readUint32() throws IOException {
        long varA4D3DD0DD1277968F4256A67EF96B630_132116240 = ((read() << 24) | (read() << 16)
              | (read() << 8) | (read() & 0x00FF));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1445398855 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1445398855;
        // ---------- Original Method ----------
        //return (read() << 24) | (read() << 16)
              //| (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.805 -0400", hash_original_method = "85B7C4B5BFF5E58A56D479C7E3A9AABB", hash_generated_method = "2EB095BC4438C5CA1751ECBE136B5324")
    public long readUint64() throws IOException {
        long hi = readUint32();
        long lo = readUint32();
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2117865435 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2117865435;
        // ---------- Original Method ----------
        //long hi = readUint32();
        //long lo = readUint32();
        //return (hi << 32) | lo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.806 -0400", hash_original_method = "22A07573F54A4BDDEECBBE8A8D080BB9", hash_generated_method = "63494D3E6833139EE1E78B71A969E5B6")
    public byte[] read(int length) throws IOException {
        byte[] res = new byte[length];
        {
            int i = 0;
            {
                res[i] = (byte) read();
            } //End block
        } //End collapsed parenthetic
        addTaint(length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1904007254 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1904007254;
        // ---------- Original Method ----------
        //byte[] res = new byte[length];
        //for (int i=0; i<length; i++) {
            //res[i] = (byte) read();
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.807 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "454D02489EB52B697ABD3BA167DADB32")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read_b;
        int i = 0;
        {
            {
                boolean var58A5278A655D93F97DA0180416078C33_1089581406 = ((read_b = read()) == -1);
            } //End collapsed parenthetic
            b[off+i] = (byte) read_b;
        } //End block
        {
            boolean var455A44C366F5A1443EF5626F0B5953C6_1065485900 = ((available() != 0) && (i<len));
        } //End collapsed parenthetic
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116611843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116611843;
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

