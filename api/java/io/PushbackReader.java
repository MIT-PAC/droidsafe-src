package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class PushbackReader extends FilterReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.873 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "40514AFF00B14ABD40D54C723F22A0B4")

    char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.874 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

    int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.874 -0400", hash_original_method = "B6B01CC88320509C49CCBB3EC0CBE41F", hash_generated_method = "62A3B3BD60076499D8409D3023072A84")
    public  PushbackReader(Reader in) {
        super(in);
        addTaint(in.getTaint());
        buf = new char[1];
        pos = 1;
        // ---------- Original Method ----------
        //buf = new char[1];
        //pos = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.875 -0400", hash_original_method = "9E5ACD5C81BD224F75A81C9C066E599D", hash_generated_method = "578D11A08876B5B6856FD7A05FB0432D")
    public  PushbackReader(Reader in, int size) {
        super(in);
        addTaint(in.getTaint());
    if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_647828675 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_647828675.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_647828675;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.875 -0400", hash_original_method = "298F8792979BB77A625D9BD803A02F79", hash_generated_method = "DD4153A262642BD08B302060931EF1F4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.875 -0400", hash_original_method = "4DEDB50585DFE7302612A8E4FFBB0FA9", hash_generated_method = "370799150047198F48443D24BF5D5E2F")
    @Override
    public void mark(int readAheadLimit) throws IOException {
        addTaint(readAheadLimit);
        IOException varF3311591D77E2C66F905CA1B4CA5DEFB_658492356 = new IOException("mark/reset not supported");
        varF3311591D77E2C66F905CA1B4CA5DEFB_658492356.addTaint(taint);
        throw varF3311591D77E2C66F905CA1B4CA5DEFB_658492356;
        // ---------- Original Method ----------
        //throw new IOException("mark/reset not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.876 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "7E03E4F886F4ECBEB68B34D9C69592D3")
    @Override
    public boolean markSupported() {
        boolean var68934A3E9455FA72420237EB05902327_1441878180 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194897070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194897070;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.876 -0400", hash_original_method = "CE14A4FF29D58642FE2BEF405E27FE95", hash_generated_method = "5507B9D9C6DC4ED7C703BE19F7D6888D")
    @Override
    public int read() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
    if(pos < buf.length)            
            {
                int varB70884BE019EF8C23F78111B3A15614D_1346040845 = (buf[pos++]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284478804 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284478804;
            } //End block
            int varC746AA2461228F1337791E992A2C4661_1879090981 = (in.read());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803634020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803634020;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.876 -0400", hash_original_method = "168C295624DB201B6537BA6FAD6078C2", hash_generated_method = "76E46D68D9212318EEDCF97EDF1B9701")
    private void checkNotClosed() throws IOException {
    if(buf == null)        
        {
            IOException var7B3501B38832105182B3AE136EAA767B_338825058 = new IOException("PushbackReader is closed");
            var7B3501B38832105182B3AE136EAA767B_338825058.addTaint(taint);
            throw var7B3501B38832105182B3AE136EAA767B_338825058;
        } //End block
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException("PushbackReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.878 -0400", hash_original_method = "B9190ABDE3B10CB37A8EAB2FF74A1B25", hash_generated_method = "93C3E65A0DB8A85517501C8629A80D00")
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
                int varE2942A04780E223B215EB8B663CF5353_1728333015 = (count);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317032342 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317032342;
            } //End block
            int inCopied = in.read(buffer, newOffset, count - copiedChars);
    if(inCopied > 0)            
            {
                int var166A9EF762FEF657CDB434EEC361E9C7_163309408 = (inCopied + copiedChars);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258194217 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258194217;
            } //End block
    if(copiedChars == 0)            
            {
                int var787E8700E82D0C2395ECBB8EA3AA68D6_887292393 = (inCopied);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281528349 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281528349;
            } //End block
            int varF869658D8E2DD1E33F978666D0818948_2059688008 = (copiedChars);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487175486 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487175486;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.878 -0400", hash_original_method = "D62FC241A8B58B8EF1EBB387C319130D", hash_generated_method = "75B2941247A057FE13D30EF08665A144")
    @Override
    public boolean ready() throws IOException {
        synchronized
(lock)        {
    if(buf == null)            
            {
                IOException var7743A3FE5EA94AC5B2DA1B811283245D_1803289302 = new IOException("Reader is closed");
                var7743A3FE5EA94AC5B2DA1B811283245D_1803289302.addTaint(taint);
                throw var7743A3FE5EA94AC5B2DA1B811283245D_1803289302;
            } //End block
            boolean var2672685A5B4F1FB14CA48CFE5A71221C_34196263 = ((buf.length - pos > 0 || in.ready()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903949179 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903949179;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (buf == null) {
                //throw new IOException("Reader is closed");
            //}
            //return (buf.length - pos > 0 || in.ready());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.879 -0400", hash_original_method = "6BB6003CEE550FAD13C0147210CF490A", hash_generated_method = "6568322F05793C02183CA2ACFE89A499")
    @Override
    public void reset() throws IOException {
        IOException varF3311591D77E2C66F905CA1B4CA5DEFB_2146281264 = new IOException("mark/reset not supported");
        varF3311591D77E2C66F905CA1B4CA5DEFB_2146281264.addTaint(taint);
        throw varF3311591D77E2C66F905CA1B4CA5DEFB_2146281264;
        // ---------- Original Method ----------
        //throw new IOException("mark/reset not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.879 -0400", hash_original_method = "3A71863D4D33CC0B41E243A7D99AFC6A", hash_generated_method = "F8AF0CE4843E548684A191D58AF92074")
    public void unread(char[] buffer) throws IOException {
        addTaint(buffer[0]);
        unread(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //unread(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.880 -0400", hash_original_method = "D820ACC6B7460811082E4447561A1371", hash_generated_method = "299BDFF625FA0D02A3F1A3B4754F685C")
    public void unread(char[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        synchronized
(lock)        {
            checkNotClosed();
    if(length > pos)            
            {
                IOException var026BB6CEDAAF18AFE37343DFB85FF3B4_385463032 = new IOException("Pushback buffer full");
                var026BB6CEDAAF18AFE37343DFB85FF3B4_385463032.addTaint(taint);
                throw var026BB6CEDAAF18AFE37343DFB85FF3B4_385463032;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.880 -0400", hash_original_method = "778C661227F8B678AE3F6B841DAAEACD", hash_generated_method = "524DD91397273A7136AFB685209AB4F6")
    public void unread(int oneChar) throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
    if(pos == 0)            
            {
                IOException var026BB6CEDAAF18AFE37343DFB85FF3B4_591040433 = new IOException("Pushback buffer full");
                var026BB6CEDAAF18AFE37343DFB85FF3B4_591040433.addTaint(taint);
                throw var026BB6CEDAAF18AFE37343DFB85FF3B4_591040433;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.881 -0400", hash_original_method = "7C49E5AFA8C1711AAA62DBD76CA3EFA0", hash_generated_method = "8695E99E676362E96BEDC1B26300AAEA")
    @Override
    public long skip(long charCount) throws IOException {
    if(charCount < 0)        
        {
            IllegalArgumentException var1938519F99623D8B8D1D15216863BFAB_1268329571 = new IllegalArgumentException("charCount < 0: " + charCount);
            var1938519F99623D8B8D1D15216863BFAB_1268329571.addTaint(taint);
            throw var1938519F99623D8B8D1D15216863BFAB_1268329571;
        } //End block
        synchronized
(lock)        {
            checkNotClosed();
    if(charCount == 0)            
            {
                long varCFCD208495D565EF66E7DFF9F98764DA_1961434833 = (0);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_595248262 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_595248262;
            } //End block
            long inSkipped;
            int availableFromBuffer = buf.length - pos;
    if(availableFromBuffer > 0)            
            {
                long requiredFromIn = charCount - availableFromBuffer;
    if(requiredFromIn <= 0)                
                {
                    pos += charCount;
                    long var87B6255985D14399838576A0F7C87503_2005441498 = (charCount);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_188035617 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_188035617;
                } //End block
                pos += availableFromBuffer;
                inSkipped = in.skip(requiredFromIn);
            } //End block
            else
            {
                inSkipped = in.skip(charCount);
            } //End block
            long var2B3F6752AF749E934595A4A941B84409_861443536 = (inSkipped + availableFromBuffer);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1366034595 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1366034595;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

