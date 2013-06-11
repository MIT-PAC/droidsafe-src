package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public class StringReader extends Reader {
    private String str;
    private int markpos = -1;
    private int pos;
    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.708 -0400", hash_original_method = "FB44DCC8276A9B32CF15DCC88FC63BEE", hash_generated_method = "13E62696DE792624FD378D6AF42BB7F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringReader(String str) {
        dsTaint.addTaint(str);
        this.count = str.length();
        // ---------- Original Method ----------
        //this.str = str;
        //this.count = str.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.708 -0400", hash_original_method = "827A4A30AD2891E9194C78AEA719C92F", hash_generated_method = "94AF55E755DC4C2A80898F7A7990F313")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        str = null;
        // ---------- Original Method ----------
        //str = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.708 -0400", hash_original_method = "E02036AA0C500209CBC33A804345F86B", hash_generated_method = "7AD3D75AE4376A40A81B9AC3C45A3D86")
    @DSModeled(DSC.SAFE)
    private boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return str == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.708 -0400", hash_original_method = "F8F979F8EBA759C2F6A839AF0D90FFA4", hash_generated_method = "5E029A7C831B32A8C5B26BE8452700C9")
    @DSModeled(DSC.SAFE)
    @Override
    public void mark(int readLimit) throws IOException {
        dsTaint.addTaint(readLimit);
        {
            throw new IllegalArgumentException();
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.708 -0400", hash_original_method = "52097AD3D6FE0975840C468FF1E0F766", hash_generated_method = "F11FD7F4E6E1953EAEB7B04F1AA50067")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1911285202 = (isClosed());
            {
                throw new IOException("StringReader is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("StringReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.709 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "1296A617D9B4AD609D1BB5E17D8BA087")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.709 -0400", hash_original_method = "7FFE2BA54C7A195E9FE8B5D995EC9572", hash_generated_method = "CC86F69E56D629BC7D5BB158C89F29C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        {
            checkNotClosed();
            {
                int var0F580E3D69302FA8221AA508D5192A84_317820189 = (str.charAt(pos++));
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos != count) {
                //return str.charAt(pos++);
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.709 -0400", hash_original_method = "85EEB2DAA826BA4238F8F98E34D3FBD9", hash_generated_method = "C499353038BCDE055D34FB35D05ADE32")
    @DSModeled(DSC.SAFE)
    @Override
    public int read(char[] buf, int offset, int len) throws IOException {
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf);
        {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buf.length, offset, len);
            int end;
            end = this.count;
            end = pos + len;
            str.getChars(pos, end, buf, offset);
            int read;
            read = end - pos;
            pos = end;
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.709 -0400", hash_original_method = "3162F271739E7EAF4DA155264EC5FC94", hash_generated_method = "F4ED8CB598787685BF686499DB91099D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean ready() throws IOException {
        {
            checkNotClosed();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.709 -0400", hash_original_method = "038BDF0065CA5B8ADE3B96C7C6A96C49", hash_generated_method = "484EF7F551A599F965AC66412E093C3F")
    @DSModeled(DSC.SAFE)
    @Override
    public void reset() throws IOException {
        {
            checkNotClosed();
            pos = markpos != -1 ? markpos : 0;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //pos = markpos != -1 ? markpos : 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.709 -0400", hash_original_method = "62CF7546C0F2369A3238D86713E4D3AD", hash_generated_method = "89935A8C029CCD1D911418E91F9DF030")
    @DSModeled(DSC.SAFE)
    @Override
    public long skip(long charCount) throws IOException {
        dsTaint.addTaint(charCount);
        {
            checkNotClosed();
            int minSkip;
            minSkip = -pos;
            int maxSkip;
            maxSkip = count - pos;
            {
                charCount = maxSkip;
            } //End block
            {
                charCount = minSkip;
            } //End block
        } //End block
        return dsTaint.getTaintLong();
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


