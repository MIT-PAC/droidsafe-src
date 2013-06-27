package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import libcore.io.Streams;

public abstract class InputStream extends Object implements Closeable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.978 -0400", hash_original_method = "24B6F89B4CF6382DB2E4A4E334B70B5D", hash_generated_method = "232D3ABC66DDB0962216577ED704AA4D")
    public  InputStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.979 -0400", hash_original_method = "1AA324AC6812BCD54DB71C20D6BA0F20", hash_generated_method = "C3EB5F1B82260CBFEEB4AE3A740A4415")
    public int available() throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399341354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399341354;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.979 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "74372D27DE595543DBC3B69FBB71373E")
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.979 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "7B9F66D07F75DF8B4C4E6E1ACAEF159F")
    public void mark(int readlimit) {
        addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.979 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "D82AAA176517D7C43B4D653587CAA89F")
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587301970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_587301970;
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract int read() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.986 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "5F538F9E4B27661A5D2ABA1CFBE8A87F")
    public int read(byte[] buffer) throws IOException {
        int var6FC2792F895D13BB16201EFCBA1330E5_1538949725 = (read(buffer, 0, buffer.length));
        addTaint(buffer[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_617425437 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_617425437;
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.987 -0400", hash_original_method = "287E8AA63F5F0E35884524D6430753F1", hash_generated_method = "FCF07E93A3A7A1D3B24D7AB27A6C8AD2")
    public int read(byte[] buffer, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            int i;
            i = 0;
            {
                int c;
                try 
                {
                    {
                        boolean var906137A6060AF34E5FF4A077340C70B0_1341975101 = ((c = read()) == -1);
                    } //End collapsed parenthetic
                } //End block
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
                buffer[offset + i] = (byte) c;
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849093728 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849093728;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.987 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "C0D0914B605E4163C857D6AE3F030FDE")
    public synchronized void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.987 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "4991665C0B45CE15CA21908AB55DCCBD")
    public long skip(long byteCount) throws IOException {
        long var242616A7471CF01D821614D0D0C41129_1288556555 = (Streams.skipByReading(this, byteCount));
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_734409658 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_734409658;
        // ---------- Original Method ----------
        //return Streams.skipByReading(this, byteCount);
    }

    
}

