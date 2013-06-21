package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class StringReader extends Reader {
    private String str;
    private int markpos = -1;
    private int pos;
    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.341 -0400", hash_original_method = "FB44DCC8276A9B32CF15DCC88FC63BEE", hash_generated_method = "F74623862265BE1C91BB5274AD134D0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringReader(String str) {
        dsTaint.addTaint(str);
        this.count = str.length();
        // ---------- Original Method ----------
        //this.str = str;
        //this.count = str.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.342 -0400", hash_original_method = "827A4A30AD2891E9194C78AEA719C92F", hash_generated_method = "56CB6D45E1B04874E8BB64A2135F32B4")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        str = null;
        // ---------- Original Method ----------
        //str = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.342 -0400", hash_original_method = "E02036AA0C500209CBC33A804345F86B", hash_generated_method = "627FEA8D7C2106B9F807B833B7DE036E")
    @DSModeled(DSC.SAFE)
    private boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return str == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.342 -0400", hash_original_method = "F8F979F8EBA759C2F6A839AF0D90FFA4", hash_generated_method = "2EF20C10E4A60E6E2E1B6472EEC1A73F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void mark(int readLimit) throws IOException {
        dsTaint.addTaint(readLimit);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.342 -0400", hash_original_method = "52097AD3D6FE0975840C468FF1E0F766", hash_generated_method = "EAC21384C45FF19AFC4924DD28F456EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1634607493 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("StringReader is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("StringReader is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.342 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "4C8BC0E845541479E10014C1D7864553")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.342 -0400", hash_original_method = "7FFE2BA54C7A195E9FE8B5D995EC9572", hash_generated_method = "B03F1306A38241292DD3DCAE2D50622A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        {
            checkNotClosed();
            {
                int var0F580E3D69302FA8221AA508D5192A84_1085503808 = (str.charAt(pos++));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.343 -0400", hash_original_method = "85EEB2DAA826BA4238F8F98E34D3FBD9", hash_generated_method = "5E87C197D1FCF4F16E73777C5A24E76D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(char[] buf, int offset, int len) throws IOException {
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.343 -0400", hash_original_method = "3162F271739E7EAF4DA155264EC5FC94", hash_generated_method = "26B26044EC41387C75F3C410F3ABF1EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.343 -0400", hash_original_method = "038BDF0065CA5B8ADE3B96C7C6A96C49", hash_generated_method = "83AB864F4946B1529535589675BD20F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.343 -0400", hash_original_method = "62CF7546C0F2369A3238D86713E4D3AD", hash_generated_method = "68BAD3583C71FE472DFF32B7D59E553F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

