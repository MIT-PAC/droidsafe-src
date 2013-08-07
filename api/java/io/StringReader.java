package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;






public class StringReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.755 -0400", hash_original_field = "341BE97D9AFF90C9978347F66F945B77", hash_generated_field = "787A2B4D426AC144FB23E0D0502FE70E")

    private String str;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.755 -0400", hash_original_field = "492E5D488B8C3F3A5B37BE9C27216BA1", hash_generated_field = "D9BE4F291B7CF1E403126100EC51CB87")

    private int markpos = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.755 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.755 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.756 -0400", hash_original_method = "FB44DCC8276A9B32CF15DCC88FC63BEE", hash_generated_method = "2BB533358CA78E399DDA1F3F66175075")
    public  StringReader(String str) {
        this.str = str;
        this.count = str.length();
        // ---------- Original Method ----------
        //this.str = str;
        //this.count = str.length();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.756 -0400", hash_original_method = "827A4A30AD2891E9194C78AEA719C92F", hash_generated_method = "56CB6D45E1B04874E8BB64A2135F32B4")
    @Override
    public void close() {
        str = null;
        // ---------- Original Method ----------
        //str = null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.756 -0400", hash_original_method = "E02036AA0C500209CBC33A804345F86B", hash_generated_method = "1F3F18D6AA999E38860EAD4B0D88C829")
    private boolean isClosed() {
        boolean varC50A9EEEAF6FD0E2520283BE0DB184F5_1244640365 = (str == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1596645580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1596645580;
        // ---------- Original Method ----------
        //return str == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.757 -0400", hash_original_method = "F8F979F8EBA759C2F6A839AF0D90FFA4", hash_generated_method = "4144D9B768B12AB9C752DDDADC12E93C")
    @Override
    public void mark(int readLimit) throws IOException {
        addTaint(readLimit);
        if(readLimit < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_599139254 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_599139254.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_599139254;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.757 -0400", hash_original_method = "52097AD3D6FE0975840C468FF1E0F766", hash_generated_method = "42A2FE3EDE053CD449DBAE926D9F987C")
    private void checkNotClosed() throws IOException {
        if(isClosed())        
        {
            IOException varE9044B304B7C498A61D9652AB5D7B43B_1947524568 = new IOException("StringReader is closed");
            varE9044B304B7C498A61D9652AB5D7B43B_1947524568.addTaint(taint);
            throw varE9044B304B7C498A61D9652AB5D7B43B_1947524568;
        } //End block
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("StringReader is closed");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.757 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "35B9C3F46BE57FCBAD39D8AE7792EE8A")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_1099354878 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_764948621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_764948621;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.758 -0400", hash_original_method = "7FFE2BA54C7A195E9FE8B5D995EC9572", hash_generated_method = "8F20BF8E9BF43C0408ED57C421834626")
    @Override
    public int read() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(pos != count)            
            {
                int varAC0CC86869006350AF64177B34D27451_522174427 = (str.charAt(pos++));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942216703 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942216703;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_265048272 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869608084 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869608084;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.758 -0400", hash_original_method = "85EEB2DAA826BA4238F8F98E34D3FBD9", hash_generated_method = "6639F10D131AB32E92734B00D7488645")
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
                int varCFCD208495D565EF66E7DFF9F98764DA_1046376252 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394145986 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394145986;
            } //End block
            if(pos == this.count)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_684800547 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_520993310 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_520993310;
            } //End block
            int end = pos + len > this.count ? this.count : pos + len;
            str.getChars(pos, end, buf, offset);
            int read = end - pos;
            pos = end;
            int varECAE13117D6F0584C25A9DA6C8F8415E_407730944 = (read);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702396151 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702396151;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.759 -0400", hash_original_method = "3162F271739E7EAF4DA155264EC5FC94", hash_generated_method = "118A97341E83A12AA129FA89AD0B8CDC")
    @Override
    public boolean ready() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            boolean varB326B5062B2F0E69046810717534CB09_436375650 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763041876 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763041876;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.759 -0400", hash_original_method = "038BDF0065CA5B8ADE3B96C7C6A96C49", hash_generated_method = "EB41247279EDB6AE8BCF64B337BF9116")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.760 -0400", hash_original_method = "62CF7546C0F2369A3238D86713E4D3AD", hash_generated_method = "BD434A584E11C43F8BDAF4CB7E0433C6")
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
            long var87B6255985D14399838576A0F7C87503_875287612 = (charCount);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1369750009 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1369750009;
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

