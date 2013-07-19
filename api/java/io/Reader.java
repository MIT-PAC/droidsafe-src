package java.io;

// Droidsafe Imports
import java.nio.CharBuffer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Reader implements Readable, Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.559 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "AB852390F41C8C6739EA01C427D6BB51")

    protected Object lock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.559 -0400", hash_original_method = "23BD0F45FCD5744DE183656F7640DB10", hash_generated_method = "34ED878B44B0872C50C8F22A6EAAAA08")
    protected  Reader() {
        lock = this;
        // ---------- Original Method ----------
        //lock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.560 -0400", hash_original_method = "841CA56D08654DE62644A6941CD75AE9", hash_generated_method = "6ACC0117984130FEF270F8A8B65EEA39")
    protected  Reader(Object lock) {
        if(lock == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1130269748 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1130269748.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1130269748;
        } //End block
        this.lock = lock;
        // ---------- Original Method ----------
        //if (lock == null) {
            //throw new NullPointerException();
        //}
        //this.lock = lock;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void close() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.560 -0400", hash_original_method = "2066C142E0E9A9BCC65518E0FCDDA1D6", hash_generated_method = "2FA2C63572C6BB3E092699AC1428BB82")
    public void mark(int readLimit) throws IOException {
        addTaint(readLimit);
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_198267087 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_198267087.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_198267087;
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.561 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "119DC9F213F1DAF82196F6D9D3F1392E")
    public boolean markSupported() {
        boolean var68934A3E9455FA72420237EB05902327_212776920 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121786310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121786310;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.561 -0400", hash_original_method = "4B904F9F4843983C12271BC14A375F35", hash_generated_method = "53FD29739C2536D59A3E4D34635FC8EF")
    public int read() throws IOException {
        synchronized
(lock)        {
            char[] charArray = new char[1];
            if(read(charArray, 0, 1) != -1)            
            {
                int var5B6AEFF299C84706C52041B8081F3370_467175230 = (charArray[0]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603867010 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603867010;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1596382483 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_151368181 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_151368181;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //char[] charArray = new char[1];
            //if (read(charArray, 0, 1) != -1) {
                //return charArray[0];
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.562 -0400", hash_original_method = "E743E3D19B5FD453D0CBC2E5CA424673", hash_generated_method = "C34F63961F0884DC63CA06ADEC1498AE")
    public int read(char[] buf) throws IOException {
        addTaint(buf[0]);
        int var4828354AC0CD4A28CE476D719F00E912_624196172 = (read(buf, 0, buf.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672564327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672564327;
        // ---------- Original Method ----------
        //return read(buf, 0, buf.length);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int read(char[] buf, int offset, int count) throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.562 -0400", hash_original_method = "D41EE0434E50B3C6E1AA0E42EDD44E0B", hash_generated_method = "87D0550D57E2E56A71E37C9419F96770")
    public boolean ready() throws IOException {
        boolean var68934A3E9455FA72420237EB05902327_1851989275 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961464190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961464190;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.563 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "A59EB893AD90CAFAE7C8C9BB0ECEF97C")
    public void reset() throws IOException {
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_2032160395 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_2032160395.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_2032160395;
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.563 -0400", hash_original_method = "7E8A2F73FB8EAE936D216E90BE91676B", hash_generated_method = "DF34705AF9DA8AD14EA1CCC68B333D82")
    public long skip(long charCount) throws IOException {
        addTaint(charCount);
        if(charCount < 0)        
        {
            IllegalArgumentException var1938519F99623D8B8D1D15216863BFAB_844314565 = new IllegalArgumentException("charCount < 0: " + charCount);
            var1938519F99623D8B8D1D15216863BFAB_844314565.addTaint(taint);
            throw var1938519F99623D8B8D1D15216863BFAB_844314565;
        } //End block
        synchronized
(lock)        {
            long skipped = 0;
            int toRead = charCount < 512 ? (int) charCount : 512;
            char[] charsSkipped = new char[toRead];
            while
(skipped < charCount)            
            {
                int read = read(charsSkipped, 0, toRead);
                if(read == -1)                
                {
                    long varE52E279299E912838F689D4380C81F4A_2052213478 = (skipped);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_370181174 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_370181174;
                } //End block
                skipped += read;
                if(read < toRead)                
                {
                    long varE52E279299E912838F689D4380C81F4A_1375794625 = (skipped);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1664152784 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1664152784;
                } //End block
                if(charCount - skipped < toRead)                
                {
                    toRead = (int) (charCount - skipped);
                } //End block
            } //End block
            long varE52E279299E912838F689D4380C81F4A_1365417727 = (skipped);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_265083516 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_265083516;
        } //End block
        // ---------- Original Method ----------
        //if (charCount < 0) {
            //throw new IllegalArgumentException("charCount < 0: " + charCount);
        //}
        //synchronized (lock) {
            //long skipped = 0;
            //int toRead = charCount < 512 ? (int) charCount : 512;
            //char[] charsSkipped = new char[toRead];
            //while (skipped < charCount) {
                //int read = read(charsSkipped, 0, toRead);
                //if (read == -1) {
                    //return skipped;
                //}
                //skipped += read;
                //if (read < toRead) {
                    //return skipped;
                //}
                //if (charCount - skipped < toRead) {
                    //toRead = (int) (charCount - skipped);
                //}
            //}
            //return skipped;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.564 -0400", hash_original_method = "3EEA08DE1417537F34B729CF4FE40629", hash_generated_method = "AF72018FA5B2DB253969FA2595202A0F")
    public int read(CharBuffer target) throws IOException {
        addTaint(target.getTaint());
        int length = target.length();
        char[] buf = new char[length];
        length = Math.min(length, read(buf));
        if(length > 0)        
        {
            target.put(buf, 0, length);
        } //End block
        int var2FA47F7C65FEC19CC163B195725E3844_1972091792 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635520017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635520017;
        // ---------- Original Method ----------
        //int length = target.length();
        //char[] buf = new char[length];
        //length = Math.min(length, read(buf));
        //if (length > 0) {
            //target.put(buf, 0, length);
        //}
        //return length;
    }

    
}

