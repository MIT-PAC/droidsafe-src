package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;
import libcore.io.Streams;

public abstract class InputStream extends Object implements Closeable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.057 -0400", hash_original_method = "24B6F89B4CF6382DB2E4A4E334B70B5D", hash_generated_method = "232D3ABC66DDB0962216577ED704AA4D")
    public  InputStream() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.057 -0400", hash_original_method = "1AA324AC6812BCD54DB71C20D6BA0F20", hash_generated_method = "5FF599E44BC85492A9E79BD1759ED07B")
    public int available() throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2144116661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2144116661;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.057 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "74372D27DE595543DBC3B69FBB71373E")
    public void close() throws IOException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.057 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "7B9F66D07F75DF8B4C4E6E1ACAEF159F")
    public void mark(int readlimit) {
        addTaint(readlimit);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.057 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "DF861A576A6C1FA2F008B978224588D4")
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1820103271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1820103271;
        
        
    }

    
    public abstract int read() throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.058 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "272B88EBFCBF28D6E057925FDB4D48E2")
    public int read(byte[] buffer) throws IOException {
        int var6FC2792F895D13BB16201EFCBA1330E5_44515009 = (read(buffer, 0, buffer.length));
        addTaint(buffer[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184290271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184290271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.058 -0400", hash_original_method = "287E8AA63F5F0E35884524D6430753F1", hash_generated_method = "D1C2A91527A1D5632585C2E716EA1CC6")
    public int read(byte[] buffer, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            int i = 0;
            {
                int c = 'a';
                try 
                {
                    {
                        boolean var906137A6060AF34E5FF4A077340C70B0_1994901970 = ((c = read()) == -1);
                    } 
                } 
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } 
                buffer[offset + i] = (byte) c;
            } 
        } 
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623325778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623325778;
        
        
        
            
            
                
                    
                
            
                
                    
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.058 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "C0D0914B605E4163C857D6AE3F030FDE")
    public synchronized void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.059 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "50429BAE4EEDA0B074F44FD538D3147D")
    public long skip(long byteCount) throws IOException {
        long var242616A7471CF01D821614D0D0C41129_2087633342 = (Streams.skipByReading(this, byteCount));
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1829477997 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1829477997;
        
        
    }

    
}

