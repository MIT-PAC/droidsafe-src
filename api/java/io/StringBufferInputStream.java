package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;
public class StringBufferInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.730 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "ED717DDCA3146879332E3CB1E590C4E3")

    protected String buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.735 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.747 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.760 -0400", hash_original_method = "76979FB4443A3642C3C41F9A7D4BA5B1", hash_generated_method = "B3B83E9DCB5DFF1B0A2A5A5EE3F6F3B0")
    public  StringBufferInputStream(String str) {
        if(str == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1324611262 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1324611262.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1324611262;
        } //End block
        buffer = str;
        count = str.length();
        // ---------- Original Method ----------
        //if (str == null) {
            //throw new NullPointerException();
        //}
        //buffer = str;
        //count = str.length();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.769 -0400", hash_original_method = "60B3E89517A58F980CEC13EE6BBDFCDA", hash_generated_method = "91618CAD2E542EC6F52F0B20184B51EB")
    @Override
    public synchronized int available() {
        int var3AEDBC1AD1CF35D76AA1C4760AC4713F_2078758250 = (count - pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176112212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176112212;
        // ---------- Original Method ----------
        //return count - pos;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.776 -0400", hash_original_method = "13B1BC43B8C5BB9B164E62DA1A0BBF2A", hash_generated_method = "E0D0190554C486D4D2264FE02B57983A")
    @Override
    public synchronized int read() {
        int var41E9AEB0F968DECA7B195864CFD02800_1328087028 = (pos < count ? buffer.charAt(pos++) & 0xFF : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947803734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947803734;
        // ---------- Original Method ----------
        //return pos < count ? buffer.charAt(pos++) & 0xFF : -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.797 -0400", hash_original_method = "72F57B370F566A93B2245D6F4EE475E3", hash_generated_method = "F96F2521E70CE2CA019AA54B209CFACF")
    @Override
    public synchronized int read(byte[] buffer, int offset, int length) {
        addTaint(length);
        if(buffer == null)        
        {
            NullPointerException varD1F0B530B211C354FD4DD40207900970_484885337 = new NullPointerException("buffer == null");
            varD1F0B530B211C354FD4DD40207900970_484885337.addTaint(taint);
            throw varD1F0B530B211C354FD4DD40207900970_484885337;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        if(length == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1875239436 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_880213667 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_880213667;
        } //End block
        int copylen = count - pos < length ? count - pos : length;
for(int i = 0;i < copylen;i++)
        {
            buffer[offset + i] = (byte) this.buffer.charAt(pos + i);
        } //End block
        pos += copylen;
        int varE749BA1BDEBBB97BB221866135459992_2093673655 = (copylen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254491751 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254491751;
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (length == 0) {
            //return 0;
        //}
        //int copylen = count - pos < length ? count - pos : length;
        //for (int i = 0; i < copylen; i++) {
            //buffer[offset + i] = (byte) this.buffer.charAt(pos + i);
        //}
        //pos += copylen;
        //return copylen;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.809 -0400", hash_original_method = "4A8566B6C9E948D021F9A160FC69F9F0", hash_generated_method = "D301CA85D98A198D15253B8AF6DDF229")
    @Override
    public synchronized void reset() {
        pos = 0;
        // ---------- Original Method ----------
        //pos = 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:55:22.850 -0400", hash_original_method = "CF6031E947756BEE937415A3AF461C41", hash_generated_method = "27020BB85884DAFD011A76677F5EFFA6")
    @Override
    public synchronized long skip(long charCount) {
        if(charCount <= 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_127912967 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_768031516 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_768031516;
        } //End block
        int numskipped;
        if(this.count - pos < charCount)        
        {
            numskipped = this.count - pos;
            pos = this.count;
        } //End block
        else
        {
            numskipped = (int) charCount;
            pos += charCount;
        } //End block
        long var169B535DE5BAB520CD07F5B2CBB04E84_1311870534 = (numskipped);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_927378991 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_927378991;
        // ---------- Original Method ----------
        //if (charCount <= 0) {
            //return 0;
        //}
        //int numskipped;
        //if (this.count - pos < charCount) {
            //numskipped = this.count - pos;
            //pos = this.count;
        //} else {
            //numskipped = (int) charCount;
            //pos += charCount;
        //}
        //return numskipped;
    }

    
}

