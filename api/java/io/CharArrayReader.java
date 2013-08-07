package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;






public class CharArrayReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.511 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "F3184E7FC423A3DB65CA949884DB59BD")

    protected char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.511 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.511 -0400", hash_original_field = "46E1C4BCE20E32B45E5162C88BE08EE3", hash_generated_field = "1DA4646E2C60EE9C934D6CF17180F1D1")

    protected int markedPos = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.512 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.512 -0400", hash_original_method = "6DA04233D2F41366A5B785CAFAB5785D", hash_generated_method = "9D431D2D4B8EBE9BACF7AB6051854539")
    public  CharArrayReader(char[] buf) {
        this.buf = buf;
        this.count = buf.length;
        // ---------- Original Method ----------
        //this.buf = buf;
        //this.count = buf.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.513 -0400", hash_original_method = "1EBD72186921B7C86A5F89F0B57C5DD7", hash_generated_method = "E7AC43A22B207C966A4A5F4A1072F0B0")
    public  CharArrayReader(char[] buf, int offset, int length) {
        if(offset < 0 || offset > buf.length || length < 0 || offset + length < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1777113021 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1777113021.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1777113021;
        } //End block
        this.buf = buf;
        this.pos = offset;
        this.markedPos = offset;
        int bufferLength = buf.length;
        this.count = offset + length < bufferLength ? length : bufferLength;
        // ---------- Original Method ----------
        //if (offset < 0 || offset > buf.length || length < 0 || offset + length < 0) {
            //throw new IllegalArgumentException();
        //}
        //this.buf = buf;
        //this.pos = offset;
        //this.markedPos = offset;
        //int bufferLength = buf.length;
        //this.count = offset + length < bufferLength ? length : bufferLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.514 -0400", hash_original_method = "D1485373461621933BC43F45AD6A923E", hash_generated_method = "FDB89C61612626CF8A25C148DFEE2D52")
    @Override
    public void close() {
        synchronized
(lock)        {
            if(isOpen())            
            {
                buf = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (isOpen()) {
                //buf = null;
            //}
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.514 -0400", hash_original_method = "F0DC6C1F8DBE67146FDB19D4375AE051", hash_generated_method = "7E49AA90BEA532A819B1315EAA0A6F40")
    private boolean isOpen() {
        boolean var0C54AD404B2ACA93D3F8FCA41C54249F_1343164928 = (buf != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260729220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_260729220;
        // ---------- Original Method ----------
        //return buf != null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.515 -0400", hash_original_method = "1E545822701FEAEF52AB68BFB73351A8", hash_generated_method = "93093733BFA5B867040B73EC7D880EFB")
    private boolean isClosed() {
        boolean var424D22B8FEEB84C8061682CC5DE6923D_183702961 = (buf == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544634464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544634464;
        // ---------- Original Method ----------
        //return buf == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.515 -0400", hash_original_method = "364865576D00D1903D5FAEF3F67610B8", hash_generated_method = "3763EEE20F492F15A56B0410851C5AE3")
    @Override
    public void mark(int readLimit) throws IOException {
        addTaint(readLimit);
        synchronized
(lock)        {
            checkNotClosed();
            markedPos = pos;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //markedPos = pos;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.515 -0400", hash_original_method = "DD3D03D90C3AA2556C16493577BC59FF", hash_generated_method = "19EF7637637D9D5E1494C47BB45D8AFF")
    private void checkNotClosed() throws IOException {
        if(isClosed())        
        {
            IOException var6FF3D475D6B6A8CBEBE32ED673C65A5D_391299927 = new IOException("CharArrayReader is closed");
            var6FF3D475D6B6A8CBEBE32ED673C65A5D_391299927.addTaint(taint);
            throw var6FF3D475D6B6A8CBEBE32ED673C65A5D_391299927;
        } //End block
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("CharArrayReader is closed");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.516 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "66D9B36171A018F3D893965502362916")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_1960098684 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990143900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990143900;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.516 -0400", hash_original_method = "81B0DFE29130C0DF55A1485815BBFE58", hash_generated_method = "43342D39E471B904E954AD5433F715C6")
    @Override
    public int read() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(pos == count)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1661682160 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769950326 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769950326;
            } //End block
            int varB70884BE019EF8C23F78111B3A15614D_1346344384 = (buf[pos++]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286069318 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286069318;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos == count) {
                //return -1;
            //}
            //return buf[pos++];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.517 -0400", hash_original_method = "D326846A8F32FE2907A115981466F659", hash_generated_method = "A0EA52E5630DDEB265BDCF5673596DEE")
    @Override
    public int read(char[] buffer, int offset, int len) throws IOException {
        addTaint(len);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        synchronized
(lock)        {
            checkNotClosed();
            if(pos < this.count)            
            {
                int bytesRead = pos + len > this.count ? this.count - pos : len;
                System.arraycopy(this.buf, pos, buffer, offset, bytesRead);
                pos += bytesRead;
                int varD871906E18D7E876E6494103DA4BEEBD_1118689047 = (bytesRead);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810600994 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810600994;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_97392920 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421809371 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421809371;
        } //End block
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, len);
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos < this.count) {
                //int bytesRead = pos + len > this.count ? this.count - pos : len;
                //System.arraycopy(this.buf, pos, buffer, offset, bytesRead);
                //pos += bytesRead;
                //return bytesRead;
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.517 -0400", hash_original_method = "ACF01B5A9581EC6A7FB489059F8F6839", hash_generated_method = "F315F8B837985048A81F4F140DBB0229")
    @Override
    public boolean ready() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            boolean var3E3DF576B4392DC316ADFA6F86F61189_1764798731 = (pos != count);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547405177 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_547405177;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return pos != count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.518 -0400", hash_original_method = "8831F819121D6F1C65C36C6F61A61062", hash_generated_method = "7CA9920E1397BD77EA56CF95F724CD38")
    @Override
    public void reset() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            pos = markedPos != -1 ? markedPos : 0;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //pos = markedPos != -1 ? markedPos : 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.518 -0400", hash_original_method = "204384BC4BAAF8636F71AE068D63C20F", hash_generated_method = "14DF107F57A46F4F4B3D2030F978A3CE")
    @Override
    public long skip(long charCount) throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(charCount <= 0)            
            {
                long varCFCD208495D565EF66E7DFF9F98764DA_393974649 = (0);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1165142564 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1165142564;
            } //End block
            long skipped = 0;
            if(charCount < this.count - pos)            
            {
                pos = pos + (int) charCount;
                skipped = charCount;
            } //End block
            else
            {
                skipped = this.count - pos;
                pos = this.count;
            } //End block
            long varE52E279299E912838F689D4380C81F4A_1527010094 = (skipped);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1575796525 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1575796525;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (charCount <= 0) {
                //return 0;
            //}
            //long skipped = 0;
            //if (charCount < this.count - pos) {
                //pos = pos + (int) charCount;
                //skipped = charCount;
            //} else {
                //skipped = this.count - pos;
                //pos = this.count;
            //}
            //return skipped;
        //}
    }

    
}

