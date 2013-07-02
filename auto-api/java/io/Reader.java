package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;

public abstract class Reader implements Readable, Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.996 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "AB852390F41C8C6739EA01C427D6BB51")

    protected Object lock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.998 -0400", hash_original_method = "23BD0F45FCD5744DE183656F7640DB10", hash_generated_method = "34ED878B44B0872C50C8F22A6EAAAA08")
    protected  Reader() {
        lock = this;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.999 -0400", hash_original_method = "841CA56D08654DE62644A6941CD75AE9", hash_generated_method = "9352131AA8C4B9857ACBC82BF46DCFFC")
    protected  Reader(Object lock) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.lock = lock;
        
        
            
        
        
    }

    
    public abstract void close() throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.001 -0400", hash_original_method = "2066C142E0E9A9BCC65518E0FCDDA1D6", hash_generated_method = "AFAF0F7EF370F6B3675548AD803F6AC7")
    public void mark(int readLimit) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        addTaint(readLimit);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.001 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "5502B5398ED130CD434E436AF21F333D")
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225643605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_225643605;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.002 -0400", hash_original_method = "4B904F9F4843983C12271BC14A375F35", hash_generated_method = "8130902A26A429F064ECFF31C34E34C2")
    public int read() throws IOException {
        {
            char[] charArray = new char[1];
            {
                boolean var73E325C49628EE2FF23237E9667EC984_1771266877 = (read(charArray, 0, 1) != -1);
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274877190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274877190;
        
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.002 -0400", hash_original_method = "E743E3D19B5FD453D0CBC2E5CA424673", hash_generated_method = "D7B3CCA2885C1B5DA1CA75CD39A4D65F")
    public int read(char[] buf) throws IOException {
        int varCC1AB894CEDAC6AF53B5291411180A42_1479471750 = (read(buf, 0, buf.length));
        addTaint(buf[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689385553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689385553;
        
        
    }

    
    public abstract int read(char[] buf, int offset, int count) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.003 -0400", hash_original_method = "D41EE0434E50B3C6E1AA0E42EDD44E0B", hash_generated_method = "D56D18E1FAF8B82A6B6E8DF692151BFA")
    public boolean ready() throws IOException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562622863 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562622863;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.004 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "FB63651561D5F09834B18761B64A9A4D")
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.005 -0400", hash_original_method = "7E8A2F73FB8EAE936D216E90BE91676B", hash_generated_method = "D79A10CAAF2031E9C0989C96C1463E48")
    public long skip(long charCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("charCount < 0: " + charCount);
        } 
        {
            long skipped = 0;
            int toRead;
            toRead = (int) charCount;
            toRead = 512;
            char[] charsSkipped = new char[toRead];
            {
                int read = read(charsSkipped, 0, toRead);
                skipped += read;
                {
                    toRead = (int) (charCount - skipped);
                } 
            } 
        } 
        addTaint(charCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_590205858 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_590205858;
        
        
            
        
        
            
            
            
            
                
                
                    
                
                
                
                    
                
                
                    
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.005 -0400", hash_original_method = "3EEA08DE1417537F34B729CF4FE40629", hash_generated_method = "38461360385D2FD55B4A758B03A13E16")
    public int read(CharBuffer target) throws IOException {
        int length = target.length();
        char[] buf = new char[length];
        length = Math.min(length, read(buf));
        {
            target.put(buf, 0, length);
        } 
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103648764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103648764;
        
        
        
        
        
            
        
        
    }

    
}

