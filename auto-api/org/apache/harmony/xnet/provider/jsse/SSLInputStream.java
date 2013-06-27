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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.592 -0400", hash_original_method = "B3907DD288EBA16F858ADC5177372075", hash_generated_method = "B3907DD288EBA16F858ADC5177372075")
    public SSLInputStream ()
    {
        //Synthesized constructor
    }


        @Override
public abstract int available() throws IOException;

    
        @Override
public abstract int read() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.593 -0400", hash_original_method = "4E61964AC41EB7FF0B969F3A0D2A867E", hash_generated_method = "385392F0BAF3165DDB961CF87F38FF9C")
    public int readUint8() throws IOException {
        int var0A245C5D7D7AF87D5AC85935D6857130_786793208 = (read() & 0x00FF);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853109679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853109679;
        // ---------- Original Method ----------
        //return read() & 0x00FF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.594 -0400", hash_original_method = "0E243896410AF2472245902D7F89ED82", hash_generated_method = "78E3801119CB9FD34B5DE1EA01DF7B2F")
    public int readUint16() throws IOException {
        int varB6A221FBB44243AE4B9959A8F6F94EF0_418302597 = ((read() << 8) | (read() & 0x00FF));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036112089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036112089;
        // ---------- Original Method ----------
        //return (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.594 -0400", hash_original_method = "B71B56A9E36B8A8CD4C9FE0969EFEC79", hash_generated_method = "5B405F7F9B22C2D54A41F58F21940F4A")
    public int readUint24() throws IOException {
        int var4644244AAE0134751CFA3303634B453B_1120294645 = ((read() << 16) | (read() << 8) | (read() & 0x00FF));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670375065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670375065;
        // ---------- Original Method ----------
        //return (read() << 16) | (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.594 -0400", hash_original_method = "18D59391AE7948DA8080AA965DB6CE79", hash_generated_method = "A9AD49C9E94E3A1410F2C50F4A37E26B")
    public long readUint32() throws IOException {
        long varA4D3DD0DD1277968F4256A67EF96B630_146188671 = ((read() << 24) | (read() << 16)
              | (read() << 8) | (read() & 0x00FF));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1282266616 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1282266616;
        // ---------- Original Method ----------
        //return (read() << 24) | (read() << 16)
              //| (read() << 8) | (read() & 0x00FF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.594 -0400", hash_original_method = "85B7C4B5BFF5E58A56D479C7E3A9AABB", hash_generated_method = "6E483832F836F1CF98609C739D99E3D8")
    public long readUint64() throws IOException {
        long hi;
        hi = readUint32();
        long lo;
        lo = readUint32();
        long var0F5264038205EDFB1AC05FBB0E8C5E94_850764779 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_850764779;
        // ---------- Original Method ----------
        //long hi = readUint32();
        //long lo = readUint32();
        //return (hi << 32) | lo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.595 -0400", hash_original_method = "22A07573F54A4BDDEECBBE8A8D080BB9", hash_generated_method = "FCC71DDDDE3734DA2EB90782B954BDFE")
    public byte[] read(int length) throws IOException {
        byte[] res;
        res = new byte[length];
        {
            int i;
            i = 0;
            {
                res[i] = (byte) read();
            } //End block
        } //End collapsed parenthetic
        addTaint(length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_249561251 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_249561251;
        // ---------- Original Method ----------
        //byte[] res = new byte[length];
        //for (int i=0; i<length; i++) {
            //res[i] = (byte) read();
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.595 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "445DA8369A51BDACAD56770C4D2822B0")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read_b;
        int i;
        i = 0;
        {
            {
                boolean var58A5278A655D93F97DA0180416078C33_1109209685 = ((read_b = read()) == -1);
            } //End collapsed parenthetic
            b[off+i] = (byte) read_b;
        } //End block
        {
            boolean var455A44C366F5A1443EF5626F0B5953C6_1283401352 = ((available() != 0) && (i<len));
        } //End collapsed parenthetic
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276129457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276129457;
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

