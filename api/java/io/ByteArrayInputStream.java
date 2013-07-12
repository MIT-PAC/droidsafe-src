package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class ByteArrayInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.410 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.411 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.412 -0400", hash_original_field = "EA82410C7A9991816B5EEEEBE195E20A", hash_generated_field = "5CD36671CA275C4800A9D662FF24FD61")

    protected int mark;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.412 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.414 -0400", hash_original_method = "CF1B6A0EB8AC88640F4210354AA3396D", hash_generated_method = "A0B0F5C55FABD496502CD1493CE61372")
    public  ByteArrayInputStream(byte[] buf) {
        this.mark = 0;
        this.buf = buf;
        this.count = buf.length;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.422 -0400", hash_original_method = "CF3AD622E6B16C040D235FE2C3A31C84", hash_generated_method = "D1E790062826309E9586368E1A175542")
    public  ByteArrayInputStream(byte[] buf, int offset, int length) {
        this.buf = buf;
        pos = offset;
        mark = offset;
        count = offset + length > buf.length ? buf.length : offset + length;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.424 -0400", hash_original_method = "60B3E89517A58F980CEC13EE6BBDFCDA", hash_generated_method = "A7600B9401B0B612B21E23C1B07D297F")
    @Override
    public synchronized int available() {
        int var3AEDBC1AD1CF35D76AA1C4760AC4713F_627765303 = (count - pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919999159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919999159;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.426 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @Override
    public void close() throws IOException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.428 -0400", hash_original_method = "78F90254D622F331873962595002D35F", hash_generated_method = "94A28D4EE4F3D4D9D8A8DA95EC19A20D")
    @Override
    public synchronized void mark(int readlimit) {
        addTaint(readlimit);
        mark = pos;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.429 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "A18A8FF44DEA2CCBD49BB407DB1CF3B1")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_325496968 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704533334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704533334;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.430 -0400", hash_original_method = "BB56F6666E3E1FB5BE1E06064B4DC5BD", hash_generated_method = "8A2817BC99047245B31F97075C5BBAB9")
    @Override
    public synchronized int read() {
        int var3057749FB1E12F0A9A36204DFBCB49DC_101698643 = (pos < count ? buf[pos++] & 0xFF : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626458428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626458428;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.433 -0400", hash_original_method = "2397610A056026EF1112E9790F6EF360", hash_generated_method = "7A5794AA431BDDBF7F1D9C86C52C97E6")
    @Override
    public synchronized int read(byte[] buffer, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
    if(this.pos >= this.count)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_154577303 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013812020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013812020;
        } 
    if(length == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1654500976 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756555020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756555020;
        } 
        int copylen = this.count - pos < length ? this.count - pos : length;
        System.arraycopy(this.buf, pos, buffer, offset, copylen);
        pos += copylen;
        int varE749BA1BDEBBB97BB221866135459992_1430103503 = (copylen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899078446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899078446;
        
        
        
            
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.437 -0400", hash_original_method = "C62CA45FA6D33EC45CB5D1463505B2CA", hash_generated_method = "5F81C3DDB804B4E1ED077DCCACC7F88D")
    @Override
    public synchronized void reset() {
        pos = mark;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.440 -0400", hash_original_method = "18E56C09FFA023CF1EF098815CAD3886", hash_generated_method = "9724EF7E9FAC962DF70BB27CA9CE08DB")
    @Override
    public synchronized long skip(long byteCount) {
    if(byteCount <= 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_575133683 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1211424298 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1211424298;
        } 
        int temp = pos;
        pos = this.count - pos < byteCount ? this.count : (int) (pos + byteCount);
        long var202709155DAF502141E2579E7CD3BA61_2032567510 = (pos - temp);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1037618008 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1037618008;
        
        
            
        
        
        
        
    }

    
}

