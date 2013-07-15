package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class StringReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.026 -0400", hash_original_field = "341BE97D9AFF90C9978347F66F945B77", hash_generated_field = "787A2B4D426AC144FB23E0D0502FE70E")

    private String str;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.026 -0400", hash_original_field = "492E5D488B8C3F3A5B37BE9C27216BA1", hash_generated_field = "D9BE4F291B7CF1E403126100EC51CB87")

    private int markpos = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.026 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.027 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.028 -0400", hash_original_method = "FB44DCC8276A9B32CF15DCC88FC63BEE", hash_generated_method = "2BB533358CA78E399DDA1F3F66175075")
    public  StringReader(String str) {
        this.str = str;
        this.count = str.length();
        // ---------- Original Method ----------
        //this.str = str;
        //this.count = str.length();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.029 -0400", hash_original_method = "827A4A30AD2891E9194C78AEA719C92F", hash_generated_method = "56CB6D45E1B04874E8BB64A2135F32B4")
    @Override
    public void close() {
        str = null;
        // ---------- Original Method ----------
        //str = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.029 -0400", hash_original_method = "E02036AA0C500209CBC33A804345F86B", hash_generated_method = "530730865D30A52A3CDA3B1B765C2C8B")
    private boolean isClosed() {
        boolean varC50A9EEEAF6FD0E2520283BE0DB184F5_1617953767 = (str == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149895982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149895982;
        // ---------- Original Method ----------
        //return str == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.030 -0400", hash_original_method = "F8F979F8EBA759C2F6A839AF0D90FFA4", hash_generated_method = "5DE2C6073800FC089213E03E342E7E0B")
    @Override
    public void mark(int readLimit) throws IOException {
        addTaint(readLimit);
    if(readLimit < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_814812739 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_814812739.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_814812739;
        } //End block
        synchronized
(lock)        {
            checkNotClosed();
            markpos = pos;
        } //End block
        // ---------- Original Method ----------
        //if (readLimit < 0) {
            //throw new IllegalArgumentException();
        //}
        //synchronized (lock) {
            //checkNotClosed();
            //markpos = pos;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.031 -0400", hash_original_method = "52097AD3D6FE0975840C468FF1E0F766", hash_generated_method = "D1E5065EF095D2AFB2C2F463C5D3AF39")
    private void checkNotClosed() throws IOException {
    if(isClosed())        
        {
            IOException varE9044B304B7C498A61D9652AB5D7B43B_2042776325 = new IOException("StringReader is closed");
            varE9044B304B7C498A61D9652AB5D7B43B_2042776325.addTaint(taint);
            throw varE9044B304B7C498A61D9652AB5D7B43B_2042776325;
        } //End block
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("StringReader is closed");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.031 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "9F69F6BBBF5B58AA65D10014EF13D3E7")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_1027023588 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985632952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985632952;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.033 -0400", hash_original_method = "7FFE2BA54C7A195E9FE8B5D995EC9572", hash_generated_method = "6EECBD4A7B383D6006C4517F42679884")
    @Override
    public int read() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
    if(pos != count)            
            {
                int varAC0CC86869006350AF64177B34D27451_1529194533 = (str.charAt(pos++));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_909905310 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_909905310;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1458605804 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709608600 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709608600;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos != count) {
                //return str.charAt(pos++);
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.036 -0400", hash_original_method = "85EEB2DAA826BA4238F8F98E34D3FBD9", hash_generated_method = "C964C704A5BBC89388926EA4FA623026")
    @Override
    public int read(char[] buf, int offset, int len) throws IOException {
        addTaint(len);
        addTaint(offset);
        addTaint(buf[0]);
        synchronized
(lock)        {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buf.length, offset, len);
    if(len == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1116317323 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86702668 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86702668;
            } //End block
    if(pos == this.count)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1663381249 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568838422 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568838422;
            } //End block
            int end = pos + len > this.count ? this.count : pos + len;
            str.getChars(pos, end, buf, offset);
            int read = end - pos;
            pos = end;
            int varECAE13117D6F0584C25A9DA6C8F8415E_1177055233 = (read);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994625444 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994625444;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //Arrays.checkOffsetAndCount(buf.length, offset, len);
            //if (len == 0) {
                //return 0;
            //}
            //if (pos == this.count) {
                //return -1;
            //}
            //int end = pos + len > this.count ? this.count : pos + len;
            //str.getChars(pos, end, buf, offset);
            //int read = end - pos;
            //pos = end;
            //return read;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.039 -0400", hash_original_method = "3162F271739E7EAF4DA155264EC5FC94", hash_generated_method = "87764FCF8E80E98FC8ADF3E606814D73")
    @Override
    public boolean ready() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            boolean varB326B5062B2F0E69046810717534CB09_1088917168 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638180216 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_638180216;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.040 -0400", hash_original_method = "038BDF0065CA5B8ADE3B96C7C6A96C49", hash_generated_method = "EB41247279EDB6AE8BCF64B337BF9116")
    @Override
    public void reset() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            pos = markpos != -1 ? markpos : 0;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //pos = markpos != -1 ? markpos : 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.042 -0400", hash_original_method = "62CF7546C0F2369A3238D86713E4D3AD", hash_generated_method = "3B4B7C2EE594BADCEC6D68E881BD0FD7")
    @Override
    public long skip(long charCount) throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            int minSkip = -pos;
            int maxSkip = count - pos;
    if(maxSkip == 0 || charCount > maxSkip)            
            {
                charCount = maxSkip;
            } //End block
            else
    if(charCount < minSkip)            
            {
                charCount = minSkip;
            } //End block
            pos += charCount;
            long var87B6255985D14399838576A0F7C87503_1213049441 = (charCount);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_651426533 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_651426533;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //int minSkip = -pos;
            //int maxSkip = count - pos;
            //if (maxSkip == 0 || charCount > maxSkip) {
                //charCount = maxSkip; 
            //} else if (charCount < minSkip) {
                //charCount = minSkip;
            //}
            //pos += charCount;
            //return charCount;
        //}
    }

    
}

