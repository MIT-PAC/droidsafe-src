package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;

public abstract class Reader implements Readable, Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.949 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "AB852390F41C8C6739EA01C427D6BB51")

    protected Object lock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.949 -0400", hash_original_method = "23BD0F45FCD5744DE183656F7640DB10", hash_generated_method = "34ED878B44B0872C50C8F22A6EAAAA08")
    protected  Reader() {
        lock = this;
        // ---------- Original Method ----------
        //lock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.950 -0400", hash_original_method = "841CA56D08654DE62644A6941CD75AE9", hash_generated_method = "FF2A58ADC1ACF9E2C2B97737EDCD977B")
    protected  Reader(Object lock) {
    if(lock == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1150829133 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1150829133.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1150829133;
        } //End block
        this.lock = lock;
        // ---------- Original Method ----------
        //if (lock == null) {
            //throw new NullPointerException();
        //}
        //this.lock = lock;
    }

    
    public abstract void close() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.951 -0400", hash_original_method = "2066C142E0E9A9BCC65518E0FCDDA1D6", hash_generated_method = "9D2061A81986A1BD2D4C90BF5C8AB930")
    public void mark(int readLimit) throws IOException {
        addTaint(readLimit);
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_1484499688 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_1484499688.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_1484499688;
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.952 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "21350C4434B8A868B793E9D1839A10B7")
    public boolean markSupported() {
        boolean var68934A3E9455FA72420237EB05902327_1854795426 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704195219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704195219;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.952 -0400", hash_original_method = "4B904F9F4843983C12271BC14A375F35", hash_generated_method = "D95F270773B7BC02A7C416A5437F1A0B")
    public int read() throws IOException {
        synchronized
(lock)        {
            char[] charArray = new char[1];
    if(read(charArray, 0, 1) != -1)            
            {
                int var5B6AEFF299C84706C52041B8081F3370_996353476 = (charArray[0]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_743812444 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_743812444;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1519234335 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587878656 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587878656;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.953 -0400", hash_original_method = "E743E3D19B5FD453D0CBC2E5CA424673", hash_generated_method = "F6A01B46CF5B694298DCAFE15FD8F7AE")
    public int read(char[] buf) throws IOException {
        addTaint(buf[0]);
        int var4828354AC0CD4A28CE476D719F00E912_434255972 = (read(buf, 0, buf.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817486076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817486076;
        // ---------- Original Method ----------
        //return read(buf, 0, buf.length);
    }

    
    public abstract int read(char[] buf, int offset, int count) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.954 -0400", hash_original_method = "D41EE0434E50B3C6E1AA0E42EDD44E0B", hash_generated_method = "55B049812EF39A97B075B6B848028795")
    public boolean ready() throws IOException {
        boolean var68934A3E9455FA72420237EB05902327_1271823751 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567673433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567673433;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.955 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "359A7D1B007E8C9E03EE29004F6C9F75")
    public void reset() throws IOException {
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_934754458 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_934754458.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_934754458;
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.956 -0400", hash_original_method = "7E8A2F73FB8EAE936D216E90BE91676B", hash_generated_method = "2C3FB6D6097308594437B2AB6A90A96E")
    public long skip(long charCount) throws IOException {
        addTaint(charCount);
    if(charCount < 0)        
        {
            IllegalArgumentException var1938519F99623D8B8D1D15216863BFAB_1496935932 = new IllegalArgumentException("charCount < 0: " + charCount);
            var1938519F99623D8B8D1D15216863BFAB_1496935932.addTaint(taint);
            throw var1938519F99623D8B8D1D15216863BFAB_1496935932;
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
                    long varE52E279299E912838F689D4380C81F4A_636336101 = (skipped);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1122761774 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1122761774;
                } //End block
                skipped += read;
    if(read < toRead)                
                {
                    long varE52E279299E912838F689D4380C81F4A_171669530 = (skipped);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1734272223 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1734272223;
                } //End block
    if(charCount - skipped < toRead)                
                {
                    toRead = (int) (charCount - skipped);
                } //End block
            } //End block
            long varE52E279299E912838F689D4380C81F4A_1045370425 = (skipped);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1259375588 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1259375588;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.958 -0400", hash_original_method = "3EEA08DE1417537F34B729CF4FE40629", hash_generated_method = "9A294E3DBFFF9E2CE7D58FF1818C22A5")
    public int read(CharBuffer target) throws IOException {
        addTaint(target.getTaint());
        int length = target.length();
        char[] buf = new char[length];
        length = Math.min(length, read(buf));
    if(length > 0)        
        {
            target.put(buf, 0, length);
        } //End block
        int var2FA47F7C65FEC19CC163B195725E3844_467464825 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248864896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248864896;
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

