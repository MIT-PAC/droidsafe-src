package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class BufferedReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.475 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "D82948BDB5B1A4AE5A3AFAB6DC9986E6")

    private Reader in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.475 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "29466223C47F8B8BB1DFDB9869023C70")

    private char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.475 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.475 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.475 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "7486F438FD6BACD8803ADD46E32EFC8C")

    private int mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.475 -0400", hash_original_field = "AD44D772CC8F65477B44CADA956AB95F", hash_generated_field = "D78FB5CB883E6ED18FF304428EA74785")

    private int markLimit = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.475 -0400", hash_original_method = "942CB30D704BB0D453BC7285AF3F8F63", hash_generated_method = "1E283231B6628C9D10DDED98EF8AEFDD")
    public  BufferedReader(Reader in) {
        this(in, 8192);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.476 -0400", hash_original_method = "14FDA92282030C83FA853ED51BF21EF3", hash_generated_method = "F6AC7DE53CC5733821C0D5A3DBDF0929")
    public  BufferedReader(Reader in, int size) {
        super(in);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.476 -0400", hash_original_method = "B09EB233D31BD7460B333EC44F947FB5", hash_generated_method = "2C28BAB262EBC0A902BD495E7D296077")
    @Override
    public void close() throws IOException {
        {
            {
                boolean varF957ACFD15F9CAB66C8B758689F75D93_1098202567 = (!isClosed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.477 -0400", hash_original_method = "CF9579814E96BB14759649D94186035A", hash_generated_method = "826F8D868C5525A8A139458818641F6D")
    private int fillBuf() throws IOException {
        {
            int result = in.read(buf, 0, buf.length);
            {
                mark = -1;
                pos = 0;
                end = result;
            } //End block
        } //End block
        {
            int newLength = buf.length * 2;
            {
                newLength = markLimit;
            } //End block
            char[] newbuf = new char[newLength];
            System.arraycopy(buf, 0, newbuf, 0, buf.length);
            buf = newbuf;
        } //End block
        {
            System.arraycopy(buf, mark, buf, 0, buf.length - mark);
            pos -= mark;
            end -= mark;
            mark = 0;
        } //End block
        int count = in.read(buf, pos, buf.length - pos);
        {
            end += count;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544646557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544646557;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.477 -0400", hash_original_method = "1E545822701FEAEF52AB68BFB73351A8", hash_generated_method = "6DF917CD2C511329468212ABAE69B1DD")
    private boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_17590545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_17590545;
        // ---------- Original Method ----------
        //return buf == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.478 -0400", hash_original_method = "EDD7C6600C30549E606135C51354C55D", hash_generated_method = "3B5256C543C7D7B19AC758BB720F07CB")
    @Override
    public void mark(int markLimit) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.478 -0400", hash_original_method = "DB9CD04B651C70299E4D82CCA50FA441", hash_generated_method = "6048D2B7958D4483B1138167B719F50A")
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1349017318 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("BufferedReader is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("BufferedReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.479 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "179F95D673BD5051E67F67020C03F1A2")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_494549772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_494549772;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.480 -0400", hash_original_method = "434E790CE8DCEADB6D081C3AE915A829", hash_generated_method = "AB9A0B6B2DF7479544C66B8FBF5D2A6B")
    @Override
    public int read() throws IOException {
        {
            checkNotClosed();
            {
                boolean varE1DCD7572611CFC342E281668DF15BD2_407455904 = (pos < end || fillBuf() != -1);
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963838022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963838022;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos < end || fillBuf() != -1) {
                //return buf[pos++];
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.480 -0400", hash_original_method = "EFCE29DD70FA840EFC7C884DCFC84327", hash_generated_method = "DD4825FE0F805CF34B1039E6C2FCFE59")
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            int outstanding = length;
            {
                int available = end - pos;
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
                    boolean var083C8F04C054694A531EE3C49551E965_527099510 = (outstanding == 0 || (outstanding < length && !in.ready()));
                } //End collapsed parenthetic
                {
                    int count = in.read(buffer, offset, outstanding);
                    {
                        outstanding -= count;
                        mark = -1;
                    } //End block
                } //End block
                {
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_1293615440 = (fillBuf() == -1);
                } //End collapsed parenthetic
            } //End block
            int count = length - outstanding;
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1167917926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1167917926;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.481 -0400", hash_original_method = "5E2706ACF0BEEE9ADCFD58329E615807", hash_generated_method = "63764E5B1F4B58E14F894E1CA7623CAD")
    final void chompNewline() throws IOException {
        {
            boolean var1444B0C0C85F4E3FAF371339243602E1_214016103 = ((pos != end || fillBuf() != -1)
                && buf[pos] == '\n');
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((pos != end || fillBuf() != -1)
                //&& buf[pos] == '\n') {
            //pos++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.482 -0400", hash_original_method = "2E7624AE82CF066587D6991C8B167359", hash_generated_method = "83C4F06BAA7C76550001FA887F1CE469")
    public String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1444406745 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_902949530 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1222255264 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1107571848 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1061335490 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_2043692007 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_1226795503 = null; //Variable for return #7
        {
            checkNotClosed();
            {
                boolean var7983B727EF81FA873169B09DF8640644_682203885 = (pos == end && fillBuf() == -1);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1444406745 = null;
                } //End block
            } //End collapsed parenthetic
            {
                int charPos = pos;
                {
                    char ch = buf[charPos];
                    {
                        String res = new String(buf, pos, charPos - pos);
                        pos = charPos + 1;
                        varB4EAC82CA7396A68D541C85D26508E83_902949530 = res;
                    } //End block
                    {
                        String res = new String(buf, pos, charPos - pos);
                        pos = charPos + 1;
                        {
                            boolean varAAEDD6882D7066AC025BD33F2AAFB662_1314851730 = (((pos < end) || (fillBuf() != -1))
                            && (buf[pos] == '\n'));
                        } //End collapsed parenthetic
                        varB4EAC82CA7396A68D541C85D26508E83_1222255264 = res;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            char eol = '\0';
            StringBuilder result = new StringBuilder(80);
            result.append(buf, pos, end - pos);
            {
                pos = end;
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1107571848 = result.toString();
                } //End block
                {
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_1991261783 = (fillBuf() == -1);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1061335490 = result.length() > 0 || eol != '\0'
                            ? result.toString()
                            : null;
                    } //End block
                } //End collapsed parenthetic
                {
                    int charPos = pos;
                    {
                        char c = buf[charPos];
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
                            varB4EAC82CA7396A68D541C85D26508E83_2043692007 = result.toString();
                        } //End block
                        {
                            {
                                result.append(buf, pos, charPos - pos - 1);
                            } //End block
                            pos = charPos;
                            varB4EAC82CA7396A68D541C85D26508E83_1226795503 = result.toString();
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
        String varA7E53CE21691AB073D9660D615818899_759064928; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_759064928 = varB4EAC82CA7396A68D541C85D26508E83_1444406745;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_759064928 = varB4EAC82CA7396A68D541C85D26508E83_902949530;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_759064928 = varB4EAC82CA7396A68D541C85D26508E83_1222255264;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_759064928 = varB4EAC82CA7396A68D541C85D26508E83_1107571848;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_759064928 = varB4EAC82CA7396A68D541C85D26508E83_1061335490;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_759064928 = varB4EAC82CA7396A68D541C85D26508E83_2043692007;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_759064928 = varB4EAC82CA7396A68D541C85D26508E83_1226795503;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_759064928.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_759064928;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.483 -0400", hash_original_method = "8DBFD5F046457CCDE72CB0FF01FB7E1A", hash_generated_method = "E9FB4A77D098D986CFFBF23B67D2179B")
    @Override
    public boolean ready() throws IOException {
        {
            checkNotClosed();
            boolean var89169E58C8D8A7FBDD3FA109B0683450_1435867856 = (((end - pos) > 0) || in.ready());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2030807326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2030807326;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return ((end - pos) > 0) || in.ready();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.483 -0400", hash_original_method = "CFE9F55B11CEBEA9E9DFCD46210902F2", hash_generated_method = "061C92DFB7AF9F77D95B7B194D787278")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.484 -0400", hash_original_method = "6635225943CAECFE84E5456D76E9313A", hash_generated_method = "864C52676200C4B4877D6938C145C351")
    @Override
    public long skip(long byteCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        } //End block
        {
            checkNotClosed();
            {
                pos += byteCount;
            } //End block
            long read = end - pos;
            pos = end;
            {
                {
                    boolean var2F891E1904C23DFC1C9E4BA2B7129345_338122752 = (fillBuf() == -1);
                } //End collapsed parenthetic
                {
                    pos += byteCount - read;
                } //End block
                read += (end - pos);
                pos = end;
            } //End block
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_28618597 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_28618597;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

