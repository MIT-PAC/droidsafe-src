package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class BufferedReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.360 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "D82948BDB5B1A4AE5A3AFAB6DC9986E6")

    private Reader in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.360 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "29466223C47F8B8BB1DFDB9869023C70")

    private char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.360 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.360 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.360 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "7486F438FD6BACD8803ADD46E32EFC8C")

    private int mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.360 -0400", hash_original_field = "AD44D772CC8F65477B44CADA956AB95F", hash_generated_field = "D78FB5CB883E6ED18FF304428EA74785")

    private int markLimit = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.360 -0400", hash_original_method = "942CB30D704BB0D453BC7285AF3F8F63", hash_generated_method = "1E283231B6628C9D10DDED98EF8AEFDD")
    public  BufferedReader(Reader in) {
        this(in, 8192);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.361 -0400", hash_original_method = "14FDA92282030C83FA853ED51BF21EF3", hash_generated_method = "7DE0FD15C8CD0BAD03F36B0F0B624B9B")
    public  BufferedReader(Reader in, int size) {
        super(in);
        if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_553458580 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_553458580.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_553458580;
        } //End block
        this.in = in;
        buf = new char[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //this.in = in;
        //buf = new char[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.362 -0400", hash_original_method = "B09EB233D31BD7460B333EC44F947FB5", hash_generated_method = "24027C403C7C0374B7EA2222DB95D040")
    @Override
    public void close() throws IOException {
        synchronized
(lock)        {
            if(!isClosed())            
            {
                in.close();
                buf = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (!isClosed()) {
                //in.close();
                //buf = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.363 -0400", hash_original_method = "CF9579814E96BB14759649D94186035A", hash_generated_method = "8C7FECA201D8681A9AB4B4F7E63A1605")
    private int fillBuf() throws IOException {
        if(mark == -1 || (pos - mark >= markLimit))        
        {
            int result = in.read(buf, 0, buf.length);
            if(result > 0)            
            {
                mark = -1;
                pos = 0;
                end = result;
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_729383145 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281593446 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281593446;
        } //End block
        if(mark == 0 && markLimit > buf.length)        
        {
            int newLength = buf.length * 2;
            if(newLength > markLimit)            
            {
                newLength = markLimit;
            } //End block
            char[] newbuf = new char[newLength];
            System.arraycopy(buf, 0, newbuf, 0, buf.length);
            buf = newbuf;
        } //End block
        else
        if(mark > 0)        
        {
            System.arraycopy(buf, mark, buf, 0, buf.length - mark);
            pos -= mark;
            end -= mark;
            mark = 0;
        } //End block
        int count = in.read(buf, pos, buf.length - pos);
        if(count != -1)        
        {
            end += count;
        } //End block
        int varE2942A04780E223B215EB8B663CF5353_79803898 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439364792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439364792;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.364 -0400", hash_original_method = "1E545822701FEAEF52AB68BFB73351A8", hash_generated_method = "F283A32F101E75C44DB0A66E786D915B")
    private boolean isClosed() {
        boolean var424D22B8FEEB84C8061682CC5DE6923D_206533586 = (buf == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312090591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_312090591;
        // ---------- Original Method ----------
        //return buf == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.364 -0400", hash_original_method = "EDD7C6600C30549E606135C51354C55D", hash_generated_method = "A1C696FA5A919D72C261A94906419DC9")
    @Override
    public void mark(int markLimit) throws IOException {
        if(markLimit < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1824177988 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1824177988.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1824177988;
        } //End block
        synchronized
(lock)        {
            checkNotClosed();
            this.markLimit = markLimit;
            mark = pos;
        } //End block
        // ---------- Original Method ----------
        //if (markLimit < 0) {
            //throw new IllegalArgumentException();
        //}
        //synchronized (lock) {
            //checkNotClosed();
            //this.markLimit = markLimit;
            //mark = pos;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.365 -0400", hash_original_method = "DB9CD04B651C70299E4D82CCA50FA441", hash_generated_method = "F48ADBE2E5FF94B73FAB787906F98C1C")
    private void checkNotClosed() throws IOException {
        if(isClosed())        
        {
            IOException var773CF08A86433AFB48FB4822457098D4_221539244 = new IOException("BufferedReader is closed");
            var773CF08A86433AFB48FB4822457098D4_221539244.addTaint(taint);
            throw var773CF08A86433AFB48FB4822457098D4_221539244;
        } //End block
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("BufferedReader is closed");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.365 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "2171C4F714FEF1729565748386DB0EF7")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_768223355 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1625253985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1625253985;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.365 -0400", hash_original_method = "434E790CE8DCEADB6D081C3AE915A829", hash_generated_method = "74044E9BFBE1831F5E6C4CF5B1AB73E9")
    @Override
    public int read() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(pos < end || fillBuf() != -1)            
            {
                int varB70884BE019EF8C23F78111B3A15614D_328380900 = (buf[pos++]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442211984 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442211984;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_399505639 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679944084 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679944084;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos < end || fillBuf() != -1) {
                //return buf[pos++];
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.367 -0400", hash_original_method = "EFCE29DD70FA840EFC7C884DCFC84327", hash_generated_method = "370D0F50776AA01CD4857D0F2D671255")
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        synchronized
(lock)        {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            int outstanding = length;
            while
(outstanding > 0)            
            {
                int available = end - pos;
                if(available > 0)                
                {
                    int count = available >= outstanding ? outstanding : available;
                    System.arraycopy(buf, pos, buffer, offset, count);
                    pos += count;
                    offset += count;
                    outstanding -= count;
                } //End block
                if(outstanding == 0 || (outstanding < length && !in.ready()))                
                {
                    break;
                } //End block
                if((mark == -1 || (pos - mark >= markLimit)) && outstanding >= buf.length)                
                {
                    int count = in.read(buffer, offset, outstanding);
                    if(count > 0)                    
                    {
                        outstanding -= count;
                        mark = -1;
                    } //End block
                    break;
                } //End block
                if(fillBuf() == -1)                
                {
                    break;
                } //End block
            } //End block
            int count = length - outstanding;
            int var3F4530AEEB9DE39C06A8F31E42B1FD8F_144237342 = ((count > 0 || count == length) ? count : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513150306 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513150306;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.368 -0400", hash_original_method = "5E2706ACF0BEEE9ADCFD58329E615807", hash_generated_method = "CFB7A766D5BADFE9817321AF207EA165")
    final void chompNewline() throws IOException {
        if((pos != end || fillBuf() != -1)
                && buf[pos] == '\n')        
        {
            pos++;
        } //End block
        // ---------- Original Method ----------
        //if ((pos != end || fillBuf() != -1)
                //&& buf[pos] == '\n') {
            //pos++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.372 -0400", hash_original_method = "2E7624AE82CF066587D6991C8B167359", hash_generated_method = "BA927ABE7EE6D520F24F9370A9FD6B22")
    public String readLine() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(pos == end && fillBuf() == -1)            
            {
String var540C13E9E156B687226421B24F2DF178_719797647 =                 null;
                var540C13E9E156B687226421B24F2DF178_719797647.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_719797647;
            } //End block
for(int charPos = pos;charPos < end;charPos++)
            {
                char ch = buf[charPos];
                if(ch > '\r')                
                {
                    continue;
                } //End block
                if(ch == '\n')                
                {
                    String res = new String(buf, pos, charPos - pos);
                    pos = charPos + 1;
String varB5053E025797B3BF768F5C37934C244D_1046684927 =                     res;
                    varB5053E025797B3BF768F5C37934C244D_1046684927.addTaint(taint);
                    return varB5053E025797B3BF768F5C37934C244D_1046684927;
                } //End block
                else
                if(ch == '\r')                
                {
                    String res = new String(buf, pos, charPos - pos);
                    pos = charPos + 1;
                    if(((pos < end) || (fillBuf() != -1))
                            && (buf[pos] == '\n'))                    
                    {
                        pos++;
                    } //End block
String varB5053E025797B3BF768F5C37934C244D_1259667738 =                     res;
                    varB5053E025797B3BF768F5C37934C244D_1259667738.addTaint(taint);
                    return varB5053E025797B3BF768F5C37934C244D_1259667738;
                } //End block
            } //End block
            char eol = '\0';
            StringBuilder result = new StringBuilder(80);
            result.append(buf, pos, end - pos);
            while
(true)            
            {
                pos = end;
                if(eol == '\n')                
                {
String varE65B3A02759122992CB82C0E651AD408_227736061 =                     result.toString();
                    varE65B3A02759122992CB82C0E651AD408_227736061.addTaint(taint);
                    return varE65B3A02759122992CB82C0E651AD408_227736061;
                } //End block
                if(fillBuf() == -1)                
                {
String var1490B320368AC741C1C3B31B0E693849_1186118130 =                     result.length() > 0 || eol != '\0'
                            ? result.toString()
                            : null;
                    var1490B320368AC741C1C3B31B0E693849_1186118130.addTaint(taint);
                    return var1490B320368AC741C1C3B31B0E693849_1186118130;
                } //End block
for(int charPos = pos;charPos < end;charPos++)
                {
                    char c = buf[charPos];
                    if(eol == '\0')                    
                    {
                        if((c == '\n' || c == '\r'))                        
                        {
                            eol = c;
                        } //End block
                    } //End block
                    else
                    if(eol == '\r' && c == '\n')                    
                    {
                        if(charPos > pos)                        
                        {
                            result.append(buf, pos, charPos - pos - 1);
                        } //End block
                        pos = charPos + 1;
String varE65B3A02759122992CB82C0E651AD408_2059324016 =                         result.toString();
                        varE65B3A02759122992CB82C0E651AD408_2059324016.addTaint(taint);
                        return varE65B3A02759122992CB82C0E651AD408_2059324016;
                    } //End block
                    else
                    {
                        if(charPos > pos)                        
                        {
                            result.append(buf, pos, charPos - pos - 1);
                        } //End block
                        pos = charPos;
String varE65B3A02759122992CB82C0E651AD408_1552686172 =                         result.toString();
                        varE65B3A02759122992CB82C0E651AD408_1552686172.addTaint(taint);
                        return varE65B3A02759122992CB82C0E651AD408_1552686172;
                    } //End block
                } //End block
                if(eol == '\0')                
                {
                    result.append(buf, pos, end - pos);
                } //End block
                else
                {
                    result.append(buf, pos, end - pos - 1);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.373 -0400", hash_original_method = "8DBFD5F046457CCDE72CB0FF01FB7E1A", hash_generated_method = "0D8D73EB2CCE05939B396A7397D9A55B")
    @Override
    public boolean ready() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            boolean var60CA1460E090F38094E9E2CD495E04A1_2083336577 = (((end - pos) > 0) || in.ready());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_380325745 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_380325745;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return ((end - pos) > 0) || in.ready();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.373 -0400", hash_original_method = "CFE9F55B11CEBEA9E9DFCD46210902F2", hash_generated_method = "06CD05105F50E066B4FE16C10FB3A80C")
    @Override
    public void reset() throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(mark == -1)            
            {
                IOException var4F1C6E834A8374D577B52D8C74A83D86_497358079 = new IOException("Invalid mark");
                var4F1C6E834A8374D577B52D8C74A83D86_497358079.addTaint(taint);
                throw var4F1C6E834A8374D577B52D8C74A83D86_497358079;
            } //End block
            pos = mark;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (mark == -1) {
                //throw new IOException("Invalid mark");
            //}
            //pos = mark;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.374 -0400", hash_original_method = "6635225943CAECFE84E5456D76E9313A", hash_generated_method = "D0C993DFFF038AEC6B34DD7A7B9BE1DE")
    @Override
    public long skip(long byteCount) throws IOException {
        if(byteCount < 0)        
        {
            IllegalArgumentException var900667B0838C150D775E63B4D4D6DD8D_1482780072 = new IllegalArgumentException("byteCount < 0: " + byteCount);
            var900667B0838C150D775E63B4D4D6DD8D_1482780072.addTaint(taint);
            throw var900667B0838C150D775E63B4D4D6DD8D_1482780072;
        } //End block
        synchronized
(lock)        {
            checkNotClosed();
            if(byteCount < 1)            
            {
                long varCFCD208495D565EF66E7DFF9F98764DA_1005990341 = (0);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_89502730 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_89502730;
            } //End block
            if(end - pos >= byteCount)            
            {
                pos += byteCount;
                long varA43EF6D60A83013EA1A61A23BDB16029_654798391 = (byteCount);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1852529901 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1852529901;
            } //End block
            long read = end - pos;
            pos = end;
            while
(read < byteCount)            
            {
                if(fillBuf() == -1)                
                {
                    long varECAE13117D6F0584C25A9DA6C8F8415E_338854775 = (read);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1016696623 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1016696623;
                } //End block
                if(end - pos >= byteCount - read)                
                {
                    pos += byteCount - read;
                    long varA43EF6D60A83013EA1A61A23BDB16029_1212824169 = (byteCount);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_776696832 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_776696832;
                } //End block
                read += (end - pos);
                pos = end;
            } //End block
            long varA43EF6D60A83013EA1A61A23BDB16029_1902642537 = (byteCount);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1791196413 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1791196413;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

