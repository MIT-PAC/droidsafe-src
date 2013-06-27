package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class StringReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.921 -0400", hash_original_field = "341BE97D9AFF90C9978347F66F945B77", hash_generated_field = "787A2B4D426AC144FB23E0D0502FE70E")

    private String str;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.921 -0400", hash_original_field = "492E5D488B8C3F3A5B37BE9C27216BA1", hash_generated_field = "D9BE4F291B7CF1E403126100EC51CB87")

    private int markpos = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.921 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.921 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.921 -0400", hash_original_method = "FB44DCC8276A9B32CF15DCC88FC63BEE", hash_generated_method = "2BB533358CA78E399DDA1F3F66175075")
    public  StringReader(String str) {
        this.str = str;
        this.count = str.length();
        // ---------- Original Method ----------
        //this.str = str;
        //this.count = str.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.921 -0400", hash_original_method = "827A4A30AD2891E9194C78AEA719C92F", hash_generated_method = "56CB6D45E1B04874E8BB64A2135F32B4")
    @Override
    public void close() {
        str = null;
        // ---------- Original Method ----------
        //str = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.922 -0400", hash_original_method = "E02036AA0C500209CBC33A804345F86B", hash_generated_method = "CF45831C21BD30DF30543A2A26D3C014")
    private boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832977996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_832977996;
        // ---------- Original Method ----------
        //return str == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.922 -0400", hash_original_method = "F8F979F8EBA759C2F6A839AF0D90FFA4", hash_generated_method = "9477A35EF17C11B1D62E277F2ABD71F9")
    @Override
    public void mark(int readLimit) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            checkNotClosed();
            markpos = pos;
        } //End block
        addTaint(readLimit);
        // ---------- Original Method ----------
        //if (readLimit < 0) {
            //throw new IllegalArgumentException();
        //}
        //synchronized (lock) {
            //checkNotClosed();
            //markpos = pos;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.922 -0400", hash_original_method = "52097AD3D6FE0975840C468FF1E0F766", hash_generated_method = "926D294C41FD06E4641FBE9621799489")
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1520331458 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("StringReader is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("StringReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.922 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "C8A50CE92FB1F6760166B0E022DDC4ED")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663794979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663794979;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.923 -0400", hash_original_method = "7FFE2BA54C7A195E9FE8B5D995EC9572", hash_generated_method = "1944C904B51474804B8B45B8B68FD3E6")
    @Override
    public int read() throws IOException {
        {
            checkNotClosed();
            {
                int var0F580E3D69302FA8221AA508D5192A84_750581909 = (str.charAt(pos++));
            } //End block
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293983681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293983681;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos != count) {
                //return str.charAt(pos++);
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.923 -0400", hash_original_method = "85EEB2DAA826BA4238F8F98E34D3FBD9", hash_generated_method = "1558C05748D487F12CD8897B87C9ACB9")
    @Override
    public int read(char[] buf, int offset, int len) throws IOException {
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
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117314380 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117314380;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.923 -0400", hash_original_method = "3162F271739E7EAF4DA155264EC5FC94", hash_generated_method = "0A3D4FD05007AB81DBC09A9F5423488E")
    @Override
    public boolean ready() throws IOException {
        {
            checkNotClosed();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375942785 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_375942785;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.924 -0400", hash_original_method = "038BDF0065CA5B8ADE3B96C7C6A96C49", hash_generated_method = "83AB864F4946B1529535589675BD20F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.933 -0400", hash_original_method = "62CF7546C0F2369A3238D86713E4D3AD", hash_generated_method = "F9725019E5CDCF7D862B6521A3EC0742")
    @Override
    public long skip(long charCount) throws IOException {
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
            pos += charCount;
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1265710538 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1265710538;
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

