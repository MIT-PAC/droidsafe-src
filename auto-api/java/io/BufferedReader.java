package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class BufferedReader extends Reader {
    private Reader in;
    private char[] buf;
    private int pos;
    private int end;
    private int mark = -1;
    private int markLimit = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.412 -0400", hash_original_method = "942CB30D704BB0D453BC7285AF3F8F63", hash_generated_method = "63C9704C59CCE22EF83F20F4DDF01A51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedReader(Reader in) {
        this(in, 8192);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.412 -0400", hash_original_method = "14FDA92282030C83FA853ED51BF21EF3", hash_generated_method = "6B68218B9863FEA4F1F060956BEEBBF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedReader(Reader in, int size) {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
        } //End block
        buf = new char[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //this.in = in;
        //buf = new char[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.413 -0400", hash_original_method = "B09EB233D31BD7460B333EC44F947FB5", hash_generated_method = "98C33C326604264D427EDB3F608636E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        {
            {
                boolean varF957ACFD15F9CAB66C8B758689F75D93_1078184535 = (!isClosed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.413 -0400", hash_original_method = "CF9579814E96BB14759649D94186035A", hash_generated_method = "5ED0743282878AA96878349048AC68E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.413 -0400", hash_original_method = "1E545822701FEAEF52AB68BFB73351A8", hash_generated_method = "8CA111BDA923EE13B5D1AEEADFE636B1")
    @DSModeled(DSC.SAFE)
    private boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return buf == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.413 -0400", hash_original_method = "EDD7C6600C30549E606135C51354C55D", hash_generated_method = "8C2CFC9B6B8BE9D0811ED3B940788FAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void mark(int markLimit) throws IOException {
        dsTaint.addTaint(markLimit);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.414 -0400", hash_original_method = "DB9CD04B651C70299E4D82CCA50FA441", hash_generated_method = "78BAAA59316814811A201F75BA8401F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1543160977 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("BufferedReader is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("BufferedReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.414 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "4C8BC0E845541479E10014C1D7864553")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.414 -0400", hash_original_method = "434E790CE8DCEADB6D081C3AE915A829", hash_generated_method = "DCDFF864E5A2A4C05B422F8BB24353F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        {
            checkNotClosed();
            {
                boolean varE1DCD7572611CFC342E281668DF15BD2_116949988 = (pos < end || fillBuf() != -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.414 -0400", hash_original_method = "EFCE29DD70FA840EFC7C884DCFC84327", hash_generated_method = "32D9E8FC8FAE8091AFEF00622427979D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
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
                    boolean var083C8F04C054694A531EE3C49551E965_233350052 = (outstanding == 0 || (outstanding < length && !in.ready()));
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
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_823106134 = (fillBuf() == -1);
                } //End collapsed parenthetic
            } //End block
            int count;
            count = length - outstanding;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.415 -0400", hash_original_method = "5E2706ACF0BEEE9ADCFD58329E615807", hash_generated_method = "9AABA6AC903FDEA63BD4F0CC33E71352")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void chompNewline() throws IOException {
        {
            boolean var1444B0C0C85F4E3FAF371339243602E1_989021546 = ((pos != end || fillBuf() != -1)
                && buf[pos] == '\n');
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((pos != end || fillBuf() != -1)
                //&& buf[pos] == '\n') {
            //pos++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.416 -0400", hash_original_method = "2E7624AE82CF066587D6991C8B167359", hash_generated_method = "9A98C209286BEEDB1F12FD15CDD8F188")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String readLine() throws IOException {
        {
            checkNotClosed();
            {
                boolean var7983B727EF81FA873169B09DF8640644_1896154611 = (pos == end && fillBuf() == -1);
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
                            boolean varAAEDD6882D7066AC025BD33F2AAFB662_401419165 = (((pos < end) || (fillBuf() != -1))
                            && (buf[pos] == '\n'));
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
                    String varCD430CC847458CF28DA4CE072C2E0D33_1768112761 = (result.toString());
                } //End block
                {
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_425494114 = (fillBuf() == -1);
                    {
                        {
                            boolean varCD710FD99EF07E8245632A4ECEF451ED_366895503 = (result.length() > 0 || eol != '\0');
                            Object varC1032D8E10FF8C1780E71B7B4F2BB762_939083997 = (result.toString());
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
                            String varC1032D8E10FF8C1780E71B7B4F2BB762_205916447 = (result.toString());
                        } //End block
                        {
                            {
                                result.append(buf, pos, charPos - pos - 1);
                            } //End block
                            pos = charPos;
                            String varC1032D8E10FF8C1780E71B7B4F2BB762_1557618989 = (result.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.416 -0400", hash_original_method = "8DBFD5F046457CCDE72CB0FF01FB7E1A", hash_generated_method = "0327CE7C1875125C0B69BB79944596DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean ready() throws IOException {
        {
            checkNotClosed();
            boolean var89169E58C8D8A7FBDD3FA109B0683450_1866432764 = (((end - pos) > 0) || in.ready());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return ((end - pos) > 0) || in.ready();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.416 -0400", hash_original_method = "CFE9F55B11CEBEA9E9DFCD46210902F2", hash_generated_method = "061C92DFB7AF9F77D95B7B194D787278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void reset() throws IOException {
        {
            checkNotClosed();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid mark");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.417 -0400", hash_original_method = "6635225943CAECFE84E5456D76E9313A", hash_generated_method = "E1CEB8357730BF9F7945EDCDF3464217")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        } //End block
        {
            checkNotClosed();
            long read;
            read = end - pos;
            pos = end;
            {
                {
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_489557385 = (fillBuf() == -1);
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

