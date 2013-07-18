package java.io;

// Droidsafe Imports
import java.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ByteArrayInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.442 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.442 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.442 -0400", hash_original_field = "EA82410C7A9991816B5EEEEBE195E20A", hash_generated_field = "5CD36671CA275C4800A9D662FF24FD61")

    protected int mark;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.442 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.444 -0400", hash_original_method = "CF1B6A0EB8AC88640F4210354AA3396D", hash_generated_method = "A0B0F5C55FABD496502CD1493CE61372")
    public  ByteArrayInputStream(byte[] buf) {
        this.mark = 0;
        this.buf = buf;
        this.count = buf.length;
        // ---------- Original Method ----------
        //this.mark = 0;
        //this.buf = buf;
        //this.count = buf.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.446 -0400", hash_original_method = "CF3AD622E6B16C040D235FE2C3A31C84", hash_generated_method = "D1E790062826309E9586368E1A175542")
    public  ByteArrayInputStream(byte[] buf, int offset, int length) {
        this.buf = buf;
        pos = offset;
        mark = offset;
        count = offset + length > buf.length ? buf.length : offset + length;
        // ---------- Original Method ----------
        //this.buf = buf;
        //pos = offset;
        //mark = offset;
        //count = offset + length > buf.length ? buf.length : offset + length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.447 -0400", hash_original_method = "60B3E89517A58F980CEC13EE6BBDFCDA", hash_generated_method = "5DBAE435612BFCC8CE7BC86567F16F2E")
    @Override
    public synchronized int available() {
        int var3AEDBC1AD1CF35D76AA1C4760AC4713F_227359011 = (count - pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1174722218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1174722218;
        // ---------- Original Method ----------
        //return count - pos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.448 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.449 -0400", hash_original_method = "78F90254D622F331873962595002D35F", hash_generated_method = "94A28D4EE4F3D4D9D8A8DA95EC19A20D")
    @Override
    public synchronized void mark(int readlimit) {
        addTaint(readlimit);
        mark = pos;
        // ---------- Original Method ----------
        //mark = pos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.449 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "E82BB8901B1DAB30A8EEBEAA869F06D9")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_926613000 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399220891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399220891;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.450 -0400", hash_original_method = "BB56F6666E3E1FB5BE1E06064B4DC5BD", hash_generated_method = "98CA417B2BB69E31109C00D0666A8D07")
    @Override
    public synchronized int read() {
        int var3057749FB1E12F0A9A36204DFBCB49DC_281722268 = (pos < count ? buf[pos++] & 0xFF : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59107858 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59107858;
        // ---------- Original Method ----------
        //return pos < count ? buf[pos++] & 0xFF : -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.451 -0400", hash_original_method = "2397610A056026EF1112E9790F6EF360", hash_generated_method = "F624026390B34103A8E1AF6FE7FF907D")
    @Override
    public synchronized int read(byte[] buffer, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        if(this.pos >= this.count)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1538715394 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039659448 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039659448;
        } //End block
        if(length == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1774163946 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054368974 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054368974;
        } //End block
        int copylen = this.count - pos < length ? this.count - pos : length;
        System.arraycopy(this.buf, pos, buffer, offset, copylen);
        pos += copylen;
        int varE749BA1BDEBBB97BB221866135459992_199514827 = (copylen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705191298 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705191298;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (this.pos >= this.count) {
            //return -1;
        //}
        //if (length == 0) {
            //return 0;
        //}
        //int copylen = this.count - pos < length ? this.count - pos : length;
        //System.arraycopy(this.buf, pos, buffer, offset, copylen);
        //pos += copylen;
        //return copylen;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.451 -0400", hash_original_method = "C62CA45FA6D33EC45CB5D1463505B2CA", hash_generated_method = "5F81C3DDB804B4E1ED077DCCACC7F88D")
    @Override
    public synchronized void reset() {
        pos = mark;
        // ---------- Original Method ----------
        //pos = mark;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.452 -0400", hash_original_method = "18E56C09FFA023CF1EF098815CAD3886", hash_generated_method = "07954AAB03C2D3B11BF5E4E688296CEC")
    @Override
    public synchronized long skip(long byteCount) {
        if(byteCount <= 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_566308693 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1318786598 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1318786598;
        } //End block
        int temp = pos;
        pos = this.count - pos < byteCount ? this.count : (int) (pos + byteCount);
        long var202709155DAF502141E2579E7CD3BA61_171770326 = (pos - temp);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1693573820 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1693573820;
        // ---------- Original Method ----------
        //if (byteCount <= 0) {
            //return 0;
        //}
        //int temp = pos;
        //pos = this.count - pos < byteCount ? this.count : (int) (pos + byteCount);
        //return pos - temp;
    }

    
}

