package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class PushbackReader extends FilterReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.400 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "40514AFF00B14ABD40D54C723F22A0B4")

    char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.400 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

    int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.400 -0400", hash_original_method = "B6B01CC88320509C49CCBB3EC0CBE41F", hash_generated_method = "62A3B3BD60076499D8409D3023072A84")
    public  PushbackReader(Reader in) {
        super(in);
        addTaint(in.getTaint());
        buf = new char[1];
        pos = 1;
        // ---------- Original Method ----------
        //buf = new char[1];
        //pos = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.401 -0400", hash_original_method = "9E5ACD5C81BD224F75A81C9C066E599D", hash_generated_method = "8224A9B00508510CF3279E754832F282")
    public  PushbackReader(Reader in, int size) {
        super(in);
        addTaint(in.getTaint());
        if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_1025270323 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_1025270323.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_1025270323;
        } //End block
        buf = new char[size];
        pos = size;
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = new char[size];
        //pos = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.401 -0400", hash_original_method = "298F8792979BB77A625D9BD803A02F79", hash_generated_method = "DD4153A262642BD08B302060931EF1F4")
    @Override
    public void close() throws IOException {
        synchronized
(lock)        {
            buf = null;
            in.close();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //buf = null;
            //in.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.401 -0400", hash_original_method = "4DEDB50585DFE7302612A8E4FFBB0FA9", hash_generated_method = "40EF216F27837D55FF7EF413887A088A")
    @Override
    public void mark(int readAheadLimit) throws IOException {
        addTaint(readAheadLimit);
        IOException varF3311591D77E2C66F905CA1B4CA5DEFB_1361057026 = new IOException("mark/reset not supported");
        varF3311591D77E2C66F905CA1B4CA5DEFB_1361057026.addTaint(taint);
        throw varF3311591D77E2C66F905CA1B4CA5DEFB_1361057026;
        // ---------- Original Method ----------
        //throw new IOException("mark/reset not supported");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.402 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "32A957D3BCA4575E6F396D8CDCADE903")
    @Override
    public boolean markSupported() {
        boolean var68934A3E9455FA72420237EB05902327_1198318812 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1532547376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1532547376;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.402 -0400", hash_original_method = "CE14A4FF29D58642FE2BEF405E27FE95", hash_generated_method = "2E0DDC187B3537DBF0E48ECBCA67F6EE")
    @Override
    public int read() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(pos < buf.length)            
            {
                int varB70884BE019EF8C23F78111B3A15614D_1314916569 = (buf[pos++]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094301711 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094301711;
            } //End block
            int varC746AA2461228F1337791E992A2C4661_336616744 = (in.read());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254574869 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254574869;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos < buf.length) {
                //return buf[pos++];
            //}
            //return in.read();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.403 -0400", hash_original_method = "168C295624DB201B6537BA6FAD6078C2", hash_generated_method = "90FBE3EA66EBEEF883005BF0DDB0746E")
    private void checkNotClosed() throws IOException {
        if(buf == null)        
        {
            IOException var7B3501B38832105182B3AE136EAA767B_639947184 = new IOException("PushbackReader is closed");
            var7B3501B38832105182B3AE136EAA767B_639947184.addTaint(taint);
            throw var7B3501B38832105182B3AE136EAA767B_639947184;
        } //End block
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException("PushbackReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.404 -0400", hash_original_method = "B9190ABDE3B10CB37A8EAB2FF74A1B25", hash_generated_method = "205C131954FFF1D82154787DB6285382")
    @Override
    public int read(char[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        synchronized
(lock)        {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buffer.length, offset, count);
            int copiedChars = 0;
            int copyLength = 0;
            int newOffset = offset;
            if(pos < buf.length)            
            {
                copyLength = (buf.length - pos >= count) ? count : buf.length
                        - pos;
                System.arraycopy(buf, pos, buffer, newOffset, copyLength);
                newOffset += copyLength;
                copiedChars += copyLength;
                pos += copyLength;
            } //End block
            if(copyLength == count)            
            {
                int varE2942A04780E223B215EB8B663CF5353_882034269 = (count);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447754464 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447754464;
            } //End block
            int inCopied = in.read(buffer, newOffset, count - copiedChars);
            if(inCopied > 0)            
            {
                int var166A9EF762FEF657CDB434EEC361E9C7_1614723066 = (inCopied + copiedChars);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940668028 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940668028;
            } //End block
            if(copiedChars == 0)            
            {
                int var787E8700E82D0C2395ECBB8EA3AA68D6_1663638669 = (inCopied);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778977147 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778977147;
            } //End block
            int varF869658D8E2DD1E33F978666D0818948_1985854947 = (copiedChars);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649934531 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649934531;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.405 -0400", hash_original_method = "D62FC241A8B58B8EF1EBB387C319130D", hash_generated_method = "E22A20C407C21BF5F72668BBEC7027D7")
    @Override
    public boolean ready() throws IOException {
        synchronized
(lock)        {
            if(buf == null)            
            {
                IOException var7743A3FE5EA94AC5B2DA1B811283245D_1903545357 = new IOException("Reader is closed");
                var7743A3FE5EA94AC5B2DA1B811283245D_1903545357.addTaint(taint);
                throw var7743A3FE5EA94AC5B2DA1B811283245D_1903545357;
            } //End block
            boolean var2672685A5B4F1FB14CA48CFE5A71221C_1245309139 = ((buf.length - pos > 0 || in.ready()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178472690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_178472690;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (buf == null) {
                //throw new IOException("Reader is closed");
            //}
            //return (buf.length - pos > 0 || in.ready());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.405 -0400", hash_original_method = "6BB6003CEE550FAD13C0147210CF490A", hash_generated_method = "1134DFC043040BF301FCCCFD9B8894BB")
    @Override
    public void reset() throws IOException {
        IOException varF3311591D77E2C66F905CA1B4CA5DEFB_1066006140 = new IOException("mark/reset not supported");
        varF3311591D77E2C66F905CA1B4CA5DEFB_1066006140.addTaint(taint);
        throw varF3311591D77E2C66F905CA1B4CA5DEFB_1066006140;
        // ---------- Original Method ----------
        //throw new IOException("mark/reset not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.406 -0400", hash_original_method = "3A71863D4D33CC0B41E243A7D99AFC6A", hash_generated_method = "F8AF0CE4843E548684A191D58AF92074")
    public void unread(char[] buffer) throws IOException {
        addTaint(buffer[0]);
        unread(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //unread(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.407 -0400", hash_original_method = "D820ACC6B7460811082E4447561A1371", hash_generated_method = "0489F8B66A077F0CD7E9F4392293EE98")
    public void unread(char[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        synchronized
(lock)        {
            checkNotClosed();
            if(length > pos)            
            {
                IOException var026BB6CEDAAF18AFE37343DFB85FF3B4_1742446985 = new IOException("Pushback buffer full");
                var026BB6CEDAAF18AFE37343DFB85FF3B4_1742446985.addTaint(taint);
                throw var026BB6CEDAAF18AFE37343DFB85FF3B4_1742446985;
            } //End block
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
for(int i = offset + length - 1;i >= offset;i--)
            {
                unread(buffer[i]);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (length > pos) {
                //throw new IOException("Pushback buffer full");
            //}
            //Arrays.checkOffsetAndCount(buffer.length, offset, length);
            //for (int i = offset + length - 1; i >= offset; i--) {
                //unread(buffer[i]);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.407 -0400", hash_original_method = "778C661227F8B678AE3F6B841DAAEACD", hash_generated_method = "7AA9CA3EBB9EF5D68B581BC1A3892029")
    public void unread(int oneChar) throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(pos == 0)            
            {
                IOException var026BB6CEDAAF18AFE37343DFB85FF3B4_1838543760 = new IOException("Pushback buffer full");
                var026BB6CEDAAF18AFE37343DFB85FF3B4_1838543760.addTaint(taint);
                throw var026BB6CEDAAF18AFE37343DFB85FF3B4_1838543760;
            } //End block
            buf[--pos] = (char) oneChar;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos == 0) {
                //throw new IOException("Pushback buffer full");
            //}
            //buf[--pos] = (char) oneChar;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.408 -0400", hash_original_method = "7C49E5AFA8C1711AAA62DBD76CA3EFA0", hash_generated_method = "09D74C735D08753090B231C2C6B6CB5E")
    @Override
    public long skip(long charCount) throws IOException {
        if(charCount < 0)        
        {
            IllegalArgumentException var1938519F99623D8B8D1D15216863BFAB_713272613 = new IllegalArgumentException("charCount < 0: " + charCount);
            var1938519F99623D8B8D1D15216863BFAB_713272613.addTaint(taint);
            throw var1938519F99623D8B8D1D15216863BFAB_713272613;
        } //End block
        synchronized
(lock)        {
            checkNotClosed();
            if(charCount == 0)            
            {
                long varCFCD208495D565EF66E7DFF9F98764DA_123285963 = (0);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_762324100 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_762324100;
            } //End block
            long inSkipped;
            int availableFromBuffer = buf.length - pos;
            if(availableFromBuffer > 0)            
            {
                long requiredFromIn = charCount - availableFromBuffer;
                if(requiredFromIn <= 0)                
                {
                    pos += charCount;
                    long var87B6255985D14399838576A0F7C87503_1869693362 = (charCount);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1022393429 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1022393429;
                } //End block
                pos += availableFromBuffer;
                inSkipped = in.skip(requiredFromIn);
            } //End block
            else
            {
                inSkipped = in.skip(charCount);
            } //End block
            long var2B3F6752AF749E934595A4A941B84409_260499957 = (inSkipped + availableFromBuffer);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_453349294 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_453349294;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

