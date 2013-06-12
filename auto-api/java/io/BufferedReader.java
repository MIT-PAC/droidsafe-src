package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public class BufferedReader extends Reader {
    private Reader in;
    private char[] buf;
    private int pos;
    private int end;
    private int mark = -1;
    private int markLimit = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.384 -0400", hash_original_method = "942CB30D704BB0D453BC7285AF3F8F63", hash_generated_method = "5ADD883E0BC0AA6D87E453EBBDBEDD92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedReader(Reader in) {
        this(in, 8192);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.384 -0400", hash_original_method = "14FDA92282030C83FA853ED51BF21EF3", hash_generated_method = "382E35AE5B4C87203DFFD577399024B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedReader(Reader in, int size) {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(size);
        if(DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("size <= 0");
        } //End block
        buf = new char[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //this.in = in;
        //buf = new char[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.384 -0400", hash_original_method = "B09EB233D31BD7460B333EC44F947FB5", hash_generated_method = "F50C481F63CE8EE760D0E5B554D00361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        {
            {
                boolean varF957ACFD15F9CAB66C8B758689F75D93_690058270 = (!isClosed());
                {
                    in.close();
                    buf = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (!isClosed()) {
                //in.close();
                //buf = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.384 -0400", hash_original_method = "CF9579814E96BB14759649D94186035A", hash_generated_method = "4E941A3DA2C705BD5ACB94A4135A3B7D")
    @DSModeled(DSC.SAFE)
    private int fillBuf() throws IOException {
        {
            int result;
            result = in.read(buf, 0, buf.length);
            {
                mark = -1;
                pos = 0;
                end = result;
            } //End block
        } //End block
        {
            int newLength;
            newLength = buf.length * 2;
            {
                newLength = markLimit;
            } //End block
            char[] newbuf;
            newbuf = new char[newLength];
            System.arraycopy(buf, 0, newbuf, 0, buf.length);
            buf = newbuf;
        } //End block
        {
            System.arraycopy(buf, mark, buf, 0, buf.length - mark);
            pos -= mark;
            end -= mark;
            mark = 0;
        } //End block
        int count;
        count = in.read(buf, pos, buf.length - pos);
        {
            end += count;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.385 -0400", hash_original_method = "1E545822701FEAEF52AB68BFB73351A8", hash_generated_method = "2FFDC29FB8A3F15D6C850C63AA97AC5B")
    @DSModeled(DSC.SAFE)
    private boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return buf == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.385 -0400", hash_original_method = "EDD7C6600C30549E606135C51354C55D", hash_generated_method = "B9F899FC936EC0DA4B0D2220B024886C")
    @DSModeled(DSC.SAFE)
    @Override
    public void mark(int markLimit) throws IOException {
        dsTaint.addTaint(markLimit);
        if(DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException();
        } //End block
        {
            checkNotClosed();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.385 -0400", hash_original_method = "DB9CD04B651C70299E4D82CCA50FA441", hash_generated_method = "624AEAB44D72894EDBEC344728DE822A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_73534101 = (isClosed());
            {
                throw new IOException("BufferedReader is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("BufferedReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.385 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "1296A617D9B4AD609D1BB5E17D8BA087")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.385 -0400", hash_original_method = "434E790CE8DCEADB6D081C3AE915A829", hash_generated_method = "A33DD7E676DB65CB4F43FE45C0E40784")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        {
            checkNotClosed();
            {
                boolean varE1DCD7572611CFC342E281668DF15BD2_428536227 = (pos < end || fillBuf() != -1);
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos < end || fillBuf() != -1) {
                //return buf[pos++];
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.385 -0400", hash_original_method = "EFCE29DD70FA840EFC7C884DCFC84327", hash_generated_method = "4D6502B0AB127D429A7EBAB3343894DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            int outstanding;
            outstanding = length;
            {
                int available;
                available = end - pos;
                {
                    int count;
                    count = outstanding;
                    count = available;
                    System.arraycopy(buf, pos, buffer, offset, count);
                    pos += count;
                    offset += count;
                    outstanding -= count;
                } //End block
                {
                    boolean var083C8F04C054694A531EE3C49551E965_1877818645 = (outstanding == 0 || (outstanding < length && !in.ready()));
                } //End collapsed parenthetic
                {
                    int count;
                    count = in.read(buffer, offset, outstanding);
                    {
                        outstanding -= count;
                        mark = -1;
                    } //End block
                } //End block
                {
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_1872365752 = (fillBuf() == -1);
                } //End collapsed parenthetic
            } //End block
            int count;
            count = length - outstanding;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.385 -0400", hash_original_method = "5E2706ACF0BEEE9ADCFD58329E615807", hash_generated_method = "0F532E46C277615063318370CF37EFAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void chompNewline() throws IOException {
        {
            boolean var1444B0C0C85F4E3FAF371339243602E1_311034826 = ((pos != end || fillBuf() != -1)
                && buf[pos] == '\n');
            {
                pos++;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((pos != end || fillBuf() != -1)
                //&& buf[pos] == '\n') {
            //pos++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.386 -0400", hash_original_method = "2E7624AE82CF066587D6991C8B167359", hash_generated_method = "48BA29A60E8B4FA93012B749CF7660D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String readLine() throws IOException {
        {
            checkNotClosed();
            {
                boolean var7983B727EF81FA873169B09DF8640644_1881298717 = (pos == end && fillBuf() == -1);
            } //End collapsed parenthetic
            {
                int charPos;
                charPos = pos;
                {
                    char ch;
                    ch = buf[charPos];
                    {
                        String res;
                        res = new String(buf, pos, charPos - pos);
                        pos = charPos + 1;
                    } //End block
                    {
                        String res;
                        res = new String(buf, pos, charPos - pos);
                        pos = charPos + 1;
                        {
                            boolean varAAEDD6882D7066AC025BD33F2AAFB662_1153393327 = (((pos < end) || (fillBuf() != -1))
                            && (buf[pos] == '\n'));
                            {
                                pos++;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
            char eol;
            eol = '\0';
            StringBuilder result;
            result = new StringBuilder(80);
            result.append(buf, pos, end - pos);
            {
                pos = end;
                {
                    String varCD430CC847458CF28DA4CE072C2E0D33_1690698126 = (result.toString());
                } //End block
                {
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_1187270724 = (fillBuf() == -1);
                    {
                        {
                            boolean varCD710FD99EF07E8245632A4ECEF451ED_454613111 = (result.length() > 0 || eol != '\0');
                            Object varC1032D8E10FF8C1780E71B7B4F2BB762_120895889 = (result.toString());
                        } //End flattened ternary
                    } //End block
                } //End collapsed parenthetic
                {
                    int charPos;
                    charPos = pos;
                    {
                        char c;
                        c = buf[charPos];
                        {
                            {
                                eol = c;
                            } //End block
                        } //End block
                        {
                            {
                                result.append(buf, pos, charPos - pos - 1);
                            } //End block
                            pos = charPos + 1;
                            String varC1032D8E10FF8C1780E71B7B4F2BB762_1462009000 = (result.toString());
                        } //End block
                        {
                            {
                                result.append(buf, pos, charPos - pos - 1);
                            } //End block
                            pos = charPos;
                            String varC1032D8E10FF8C1780E71B7B4F2BB762_1583849559 = (result.toString());
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    result.append(buf, pos, end - pos);
                } //End block
                {
                    result.append(buf, pos, end - pos - 1);
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.386 -0400", hash_original_method = "8DBFD5F046457CCDE72CB0FF01FB7E1A", hash_generated_method = "5A9520D3B01334FC5486E78866DB8AF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean ready() throws IOException {
        {
            checkNotClosed();
            boolean var89169E58C8D8A7FBDD3FA109B0683450_1240228651 = (((end - pos) > 0) || in.ready());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return ((end - pos) > 0) || in.ready();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.386 -0400", hash_original_method = "CFE9F55B11CEBEA9E9DFCD46210902F2", hash_generated_method = "B9CAAD067EEBD08CC582AB9538C9C244")
    @DSModeled(DSC.SAFE)
    @Override
    public void reset() throws IOException {
        {
            checkNotClosed();
            if(DroidSafeAndroidRuntime.control) {
                throw new IOException("Invalid mark");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.386 -0400", hash_original_method = "6635225943CAECFE84E5456D76E9313A", hash_generated_method = "78C0E20D97858617DAB879304D91DED2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        if(DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        } //End block
        {
            checkNotClosed();
            long read;
            read = end - pos;
            pos = end;
            {
                {
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_2103864907 = (fillBuf() == -1);
                } //End collapsed parenthetic
                {
                    pos += byteCount - read;
                } //End block
                read += (end - pos);
                pos = end;
            } //End block
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


