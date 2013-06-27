package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class PushbackReader extends FilterReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.536 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "40514AFF00B14ABD40D54C723F22A0B4")

    char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.536 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

    int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.537 -0400", hash_original_method = "B6B01CC88320509C49CCBB3EC0CBE41F", hash_generated_method = "9CD1BC6B24BA3EA7BE18E1DF68C675DA")
    public  PushbackReader(Reader in) {
        super(in);
        buf = new char[1];
        pos = 1;
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //buf = new char[1];
        //pos = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.537 -0400", hash_original_method = "9E5ACD5C81BD224F75A81C9C066E599D", hash_generated_method = "0F092F2C5E6B838873E238009DFBA1E3")
    public  PushbackReader(Reader in, int size) {
        super(in);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
        } //End block
        buf = new char[size];
        pos = size;
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = new char[size];
        //pos = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.538 -0400", hash_original_method = "298F8792979BB77A625D9BD803A02F79", hash_generated_method = "5938D3879106881A3AFC3B6B66933B62")
    @Override
    public void close() throws IOException {
        {
            buf = null;
            in.close();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //buf = null;
            //in.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.538 -0400", hash_original_method = "4DEDB50585DFE7302612A8E4FFBB0FA9", hash_generated_method = "3263673EBDFB4B43435B2B680CCB531D")
    @Override
    public void mark(int readAheadLimit) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("mark/reset not supported");
        addTaint(readAheadLimit);
        // ---------- Original Method ----------
        //throw new IOException("mark/reset not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.538 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "0B89F4E8B9DA24234A92662FCF8CF8A3")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585240944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_585240944;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.538 -0400", hash_original_method = "CE14A4FF29D58642FE2BEF405E27FE95", hash_generated_method = "3D96DE3853F21CC70439D8A6310ACE23")
    @Override
    public int read() throws IOException {
        {
            checkNotClosed();
            int varDAF10C977F6298D4B794A37C0307BFC8_562970080 = (in.read());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545928770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545928770;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos < buf.length) {
                //return buf[pos++];
            //}
            //return in.read();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.539 -0400", hash_original_method = "168C295624DB201B6537BA6FAD6078C2", hash_generated_method = "DBEAFA5E83B086DFBE94EF8E9150351C")
    private void checkNotClosed() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("PushbackReader is closed");
        } //End block
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException("PushbackReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.551 -0400", hash_original_method = "B9190ABDE3B10CB37A8EAB2FF74A1B25", hash_generated_method = "1D6138A6F7598A0955C8095DD0947916")
    @Override
    public int read(char[] buffer, int offset, int count) throws IOException {
        {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buffer.length, offset, count);
            int copiedChars;
            copiedChars = 0;
            int copyLength;
            copyLength = 0;
            int newOffset;
            newOffset = offset;
            {
                copyLength = (buf.length - pos >= count) ? count : buf.length
                        - pos;
                System.arraycopy(buf, pos, buffer, newOffset, copyLength);
                newOffset += copyLength;
                copiedChars += copyLength;
                pos += copyLength;
            } //End block
            int inCopied;
            inCopied = in.read(buffer, newOffset, count - copiedChars);
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098917192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098917192;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.551 -0400", hash_original_method = "D62FC241A8B58B8EF1EBB387C319130D", hash_generated_method = "4E678694EBE06A92F2F5BF5D4F84A289")
    @Override
    public boolean ready() throws IOException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Reader is closed");
            } //End block
            boolean var1EE18980AA880E850D75CAACFEF4D633_1439480353 = ((buf.length - pos > 0 || in.ready()));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022641513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022641513;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (buf == null) {
                //throw new IOException("Reader is closed");
            //}
            //return (buf.length - pos > 0 || in.ready());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.551 -0400", hash_original_method = "6BB6003CEE550FAD13C0147210CF490A", hash_generated_method = "A2AE0DE94D752A2CC5B6DBE8CB3BDB31")
    @Override
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("mark/reset not supported");
        // ---------- Original Method ----------
        //throw new IOException("mark/reset not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.551 -0400", hash_original_method = "3A71863D4D33CC0B41E243A7D99AFC6A", hash_generated_method = "9D27FB00F91C8863C906092FE7B114B6")
    public void unread(char[] buffer) throws IOException {
        unread(buffer, 0, buffer.length);
        addTaint(buffer[0]);
        // ---------- Original Method ----------
        //unread(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.552 -0400", hash_original_method = "D820ACC6B7460811082E4447561A1371", hash_generated_method = "6C49026C6D70CAE7DB8CC11505BDCA37")
    public void unread(char[] buffer, int offset, int length) throws IOException {
        {
            checkNotClosed();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Pushback buffer full");
            } //End block
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            {
                int i;
                i = offset + length - 1;
                {
                    unread(buffer[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.552 -0400", hash_original_method = "778C661227F8B678AE3F6B841DAAEACD", hash_generated_method = "AA3D5117AA174BD30AB94CC1714B44D3")
    public void unread(int oneChar) throws IOException {
        {
            checkNotClosed();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Pushback buffer full");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.553 -0400", hash_original_method = "7C49E5AFA8C1711AAA62DBD76CA3EFA0", hash_generated_method = "B69793D1C7C12F6E469845702F81CC8D")
    @Override
    public long skip(long charCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("charCount < 0: " + charCount);
        } //End block
        {
            checkNotClosed();
            long inSkipped;
            int availableFromBuffer;
            availableFromBuffer = buf.length - pos;
            {
                long requiredFromIn;
                requiredFromIn = charCount - availableFromBuffer;
                {
                    pos += charCount;
                } //End block
                pos += availableFromBuffer;
                inSkipped = in.skip(requiredFromIn);
            } //End block
            {
                inSkipped = in.skip(charCount);
            } //End block
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1462833232 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1462833232;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

