package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;
import libcore.io.Streams;

public abstract class InputStream extends Object implements Closeable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.789 -0400", hash_original_method = "24B6F89B4CF6382DB2E4A4E334B70B5D", hash_generated_method = "232D3ABC66DDB0962216577ED704AA4D")
    public  InputStream() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.791 -0400", hash_original_method = "1AA324AC6812BCD54DB71C20D6BA0F20", hash_generated_method = "5E195D901BA0EDC476AD43D553F7AB57")
    public int available() throws IOException {
        int varCFCD208495D565EF66E7DFF9F98764DA_87695820 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283406934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283406934;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.792 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "74372D27DE595543DBC3B69FBB71373E")
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.793 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "7B9F66D07F75DF8B4C4E6E1ACAEF159F")
    public void mark(int readlimit) {
        addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.794 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "02AD83BE9BF01AB7ACF37CAFF5E10ADD")
    public boolean markSupported() {
        boolean var68934A3E9455FA72420237EB05902327_1426093727 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711010620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711010620;
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract int read() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.796 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "A573003CEBCA3549578E81C2573F2770")
    public int read(byte[] buffer) throws IOException {
        addTaint(buffer[0]);
        int varB17F7FC0C34BA0A2828AFE480EE84868_89453182 = (read(buffer, 0, buffer.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382951299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382951299;
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.800 -0400", hash_original_method = "287E8AA63F5F0E35884524D6430753F1", hash_generated_method = "4354307A14110B5D7E846D4386CE184D")
    public int read(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
for(int i = 0;i < length;i++)
        {
            int c;
            try 
            {
    if((c = read()) == -1)                
                {
                    int varE8B135E4621FEB767F268FD0E3A92F43_1841906661 = (i == 0 ? -1 : i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009165804 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009165804;
                } //End block
            } //End block
            catch (IOException e)
            {
    if(i != 0)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1790983336 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046393861 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046393861;
                } //End block
                e.addTaint(taint);
                throw e;
            } //End block
            buffer[offset + i] = (byte) c;
        } //End block
        int var2FA47F7C65FEC19CC163B195725E3844_1093490400 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803058793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803058793;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //for (int i = 0; i < length; i++) {
            //int c;
            //try {
                //if ((c = read()) == -1) {
                    //return i == 0 ? -1 : i;
                //}
            //} catch (IOException e) {
                //if (i != 0) {
                    //return i;
                //}
                //throw e;
            //}
            //buffer[offset + i] = (byte) c;
        //}
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.802 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "3E178738C04720F2CF98D26CE74EAE69")
    public synchronized void reset() throws IOException {
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_1490313812 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_1490313812.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_1490313812;
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.803 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "D9C9368C02079A81C36BDCF31F05F926")
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
        long var905193B4CE519E6DD3D91E1E370ADA87_897471013 = (Streams.skipByReading(this, byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1602366859 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1602366859;
        // ---------- Original Method ----------
        //return Streams.skipByReading(this, byteCount);
    }

    
}

