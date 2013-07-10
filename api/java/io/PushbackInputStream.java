package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public class PushbackInputStream extends FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.893 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.893 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.893 -0400", hash_original_method = "AC9553B1FAFFB4A8FBFF65B03BBACC5E", hash_generated_method = "3F5564E951E35BDFCBCD7F9B903974D4")
    public  PushbackInputStream(InputStream in) {
        super(in);
        buf = (in == null) ? null : new byte[1];
        pos = 1;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.894 -0400", hash_original_method = "5FC607CA483EF0D15EF5263D4BBC83BA", hash_generated_method = "557A561B285AE4A5FF11EBA9CAFF2AA0")
    public  PushbackInputStream(InputStream in, int size) {
        super(in);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
        } 
        buf = (in == null) ? null : new byte[size];
        pos = size;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.894 -0400", hash_original_method = "446E244C062F8716B384D306C558B705", hash_generated_method = "64D2CE40F7C3D85E11225312FF4D6C6D")
    @Override
    public int available() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } 
        int varA950E43363A0DE1963921B3C18F6DA58_1837307045 = (buf.length - pos + in.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311916994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311916994;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.895 -0400", hash_original_method = "74DA7764B5809B26A354DD7668DF4A77", hash_generated_method = "3C987CC4CB0AECE751E27D46E3DCA943")
    @Override
    public void close() throws IOException {
        {
            in.close();
            in = null;
            buf = null;
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.897 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "3A94EA52CE336C2ADA0B6F24A3FF21F3")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894174946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894174946;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.898 -0400", hash_original_method = "146BBECA823F7801A366293B4A5C7497", hash_generated_method = "931A39D0C103CCCFC8ED951C2271742A")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } 
        int var2EE2703F88097027B4DEA42C13801E06_1284888308 = (in.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384563784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384563784;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.899 -0400", hash_original_method = "1B53276B26E96C9AEFE2F3C951EF5EAE", hash_generated_method = "2C3C42D2F35BD43ACF5A54282ECA5BFF")
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } 
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        int copiedBytes = 0;
        int copyLength = 0;
        int newOffset = offset;
        {
            copyLength = (buf.length - pos >= length) ? length : buf.length
                    - pos;
            System.arraycopy(buf, pos, buffer, newOffset, copyLength);
            newOffset += copyLength;
            copiedBytes += copyLength;
            pos += copyLength;
        } 
        int inCopied = in.read(buffer, newOffset, length - copiedBytes);
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793140953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793140953;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.902 -0400", hash_original_method = "2E2FBA951DCC3C9DB1EDAE98D88B8EBD", hash_generated_method = "FAE066DB8A7BB73956AD5304292735D2")
    private IOException streamClosed() throws IOException {
        throw new IOException("PushbackInputStream is closed");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.902 -0400", hash_original_method = "640B22F7B00DCEA150CE7BE86C25A8AB", hash_generated_method = "1BE6F4474C952B2BDD5C51C7D3B95936")
    @Override
    public long skip(long byteCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } 
        int numSkipped = 0;
        {
            numSkipped += (byteCount < buf.length - pos) ? byteCount : buf.length - pos;
            pos += numSkipped;
        } 
        {
            numSkipped += in.skip(byteCount - numSkipped);
        } 
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2017993636 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2017993636;
        
        
            
        
        
            
        
        
        
            
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.903 -0400", hash_original_method = "C8192A3011924069F2B71E7D3088F3DC", hash_generated_method = "7B45023432F7868636C37F9593E29869")
    public void unread(byte[] buffer) throws IOException {
        unread(buffer, 0, buffer.length);
        addTaint(buffer[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.904 -0400", hash_original_method = "DF65BDEADDE37C8EC8A6D2405E9B2E68", hash_generated_method = "C29945E90C922C14AE31FF7AAE40127C")
    public void unread(byte[] buffer, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Pushback buffer full");
        } 
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } 
        System.arraycopy(buffer, offset, buf, pos - length, length);
        pos = pos - length;
        addTaint(buffer[0]);
        addTaint(offset);
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.904 -0400", hash_original_method = "98848F28DD25FD585D8212E035CA9267", hash_generated_method = "FF8F5E277009446652B3889DDE2B2EA1")
    public void unread(int oneByte) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Pushback buffer full");
        } 
        buf[--pos] = (byte) oneByte;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.904 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "374E02FA36CE7C442AE21827EF6D82FC")
    @Override
    public void mark(int readlimit) {
        addTaint(readlimit);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.905 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "A9C0F826408505F69F969DEF2E274553")
    @Override
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        
        
    }

    
}

