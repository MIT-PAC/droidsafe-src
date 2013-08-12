package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;





public abstract class SSLInputStream extends InputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.274 -0400", hash_original_method = "B3907DD288EBA16F858ADC5177372075", hash_generated_method = "B3907DD288EBA16F858ADC5177372075")
    public SSLInputStream ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @Override
public abstract int available() throws IOException;

    
    @DSModeled(DSC.SAFE)
    @Override
public abstract int read() throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.275 -0400", hash_original_method = "4E61964AC41EB7FF0B969F3A0D2A867E", hash_generated_method = "9762D204EB12B4AFFE16061E1BCDCF9C")
    public int readUint8() throws IOException {
        int varDE564EBA10F50982773C535F5DD0C71C_981688323 = (read() & 0x00FF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89076621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89076621;
        // ---------- Original Method ----------
        //return read() & 0x00FF;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.275 -0400", hash_original_method = "0E243896410AF2472245902D7F89ED82", hash_generated_method = "A4F203D275815E04E05079BCA940CDA6")
    public int readUint16() throws IOException {
        int varE92D816B59C876C1E075FB7408EC5632_1231032009 = ((read() << 8) | (read() & 0x00FF));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512707956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512707956;
        // ---------- Original Method ----------
        //return (read() << 8) | (read() & 0x00FF);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.276 -0400", hash_original_method = "B71B56A9E36B8A8CD4C9FE0969EFEC79", hash_generated_method = "0F2BAF2ADB15238AC1A8FDCD9ADE9C1D")
    public int readUint24() throws IOException {
        int var3B1BC9CE46E8D9ABE7F7ADDE655F6975_1020621217 = ((read() << 16) | (read() << 8) | (read() & 0x00FF));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970102576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970102576;
        // ---------- Original Method ----------
        //return (read() << 16) | (read() << 8) | (read() & 0x00FF);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.276 -0400", hash_original_method = "18D59391AE7948DA8080AA965DB6CE79", hash_generated_method = "BF72E0ACAB5C87BFEA0F47CB9ACBCCFD")
    public long readUint32() throws IOException {
        long var52385B0F5BA643C7B7E882733711900E_1096688019 = ((read() << 24) | (read() << 16)
              | (read() << 8) | (read() & 0x00FF));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2132547215 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2132547215;
        // ---------- Original Method ----------
        //return (read() << 24) | (read() << 16)
              //| (read() << 8) | (read() & 0x00FF);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.276 -0400", hash_original_method = "85B7C4B5BFF5E58A56D479C7E3A9AABB", hash_generated_method = "82F2221D734F10AB2F932D39D3FD3BBF")
    public long readUint64() throws IOException {
        long hi = readUint32();
        long lo = readUint32();
        long varD915340A788ED0901BEE0629617EE84E_1311019624 = ((hi << 32) | lo);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1942062520 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1942062520;
        // ---------- Original Method ----------
        //long hi = readUint32();
        //long lo = readUint32();
        //return (hi << 32) | lo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.277 -0400", hash_original_method = "22A07573F54A4BDDEECBBE8A8D080BB9", hash_generated_method = "C6BCBF33B8D75C1DA11D0F9C550CAA05")
    public byte[] read(int length) throws IOException {
        addTaint(length);
        byte[] res = new byte[length];
for(int i=0;i<length;i++)
        {
            res[i] = (byte) read();
        } //End block
        byte[] var9B207167E5381C47682C6B4F58A623FB_1634570357 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1633826047 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1633826047;
        // ---------- Original Method ----------
        //byte[] res = new byte[length];
        //for (int i=0; i<length; i++) {
            //res[i] = (byte) read();
        //}
        //return res;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.278 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "B11FB0B7570F13F0F9A443529AB52084")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        int read_b;
        int i = 0;
        do {
            {
                if((read_b = read()) == -1)                
                {
                    int var9094914C036467CD32E9F7E210E518F4_401589276 = ((i == 0) ? -1 : i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941705712 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941705712;
                } //End block
                b[off+i] = (byte) read_b;
                i++;
            } //End block
} while ((available() != 0) && (i<len));
        int var865C0C0B4AB0E063E5CAA3387C1A8741_1534397162 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116285333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116285333;
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

