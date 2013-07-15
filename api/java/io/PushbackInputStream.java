package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class PushbackInputStream extends FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.738 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.739 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.740 -0400", hash_original_method = "AC9553B1FAFFB4A8FBFF65B03BBACC5E", hash_generated_method = "3F5564E951E35BDFCBCD7F9B903974D4")
    public  PushbackInputStream(InputStream in) {
        super(in);
        buf = (in == null) ? null : new byte[1];
        pos = 1;
        // ---------- Original Method ----------
        //buf = (in == null) ? null : new byte[1];
        //pos = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.741 -0400", hash_original_method = "5FC607CA483EF0D15EF5263D4BBC83BA", hash_generated_method = "B73B17F26279965BCC77BAA134D02CC6")
    public  PushbackInputStream(InputStream in, int size) {
        super(in);
    if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_1968903929 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_1968903929.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_1968903929;
        } //End block
        buf = (in == null) ? null : new byte[size];
        pos = size;
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = (in == null) ? null : new byte[size];
        //pos = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.741 -0400", hash_original_method = "446E244C062F8716B384D306C558B705", hash_generated_method = "84306751773D95356068A366C1C59EB1")
    @Override
    public int available() throws IOException {
    if(buf == null)        
        {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_1796130131 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_1796130131.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_1796130131;
        } //End block
        int var3D32F8324B13BED4C9BAB5426B17A76D_1758229025 = (buf.length - pos + in.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548702911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548702911;
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException();
        //}
        //return buf.length - pos + in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.742 -0400", hash_original_method = "74DA7764B5809B26A354DD7668DF4A77", hash_generated_method = "C1903668237FDB5C713ACF10513B5390")
    @Override
    public void close() throws IOException {
    if(in != null)        
        {
            in.close();
            in = null;
            buf = null;
        } //End block
        // ---------- Original Method ----------
        //if (in != null) {
            //in.close();
            //in = null;
            //buf = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.743 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "8F76D9F6FDFC71A04FDD11BDB51E49E1")
    @Override
    public boolean markSupported() {
        boolean var68934A3E9455FA72420237EB05902327_566361186 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868531869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868531869;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.743 -0400", hash_original_method = "146BBECA823F7801A366293B4A5C7497", hash_generated_method = "C7A3DC47B842613D6F9F4DEF863A45F9")
    @Override
    public int read() throws IOException {
    if(buf == null)        
        {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_1096980682 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_1096980682.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_1096980682;
        } //End block
    if(pos < buf.length)        
        {
            int var7BA40CDA8787C8B57CD926EA9659088F_595750514 = ((buf[pos++] & 0xFF));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1928633075 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1928633075;
        } //End block
        int varC746AA2461228F1337791E992A2C4661_452173194 = (in.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172870463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172870463;
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException();
        //}
        //if (pos < buf.length) {
            //return (buf[pos++] & 0xFF);
        //}
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.758 -0400", hash_original_method = "1B53276B26E96C9AEFE2F3C951EF5EAE", hash_generated_method = "283530B99249D2383834E0A7F76642E0")
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
    if(buf == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_168255008 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_168255008.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_168255008;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        int copiedBytes = 0;
        int copyLength = 0;
        int newOffset = offset;
    if(pos < buf.length)        
        {
            copyLength = (buf.length - pos >= length) ? length : buf.length
                    - pos;
            System.arraycopy(buf, pos, buffer, newOffset, copyLength);
            newOffset += copyLength;
            copiedBytes += copyLength;
            pos += copyLength;
        } //End block
    if(copyLength == length)        
        {
            int var2FA47F7C65FEC19CC163B195725E3844_1785766786 = (length);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552396062 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552396062;
        } //End block
        int inCopied = in.read(buffer, newOffset, length - copiedBytes);
    if(inCopied > 0)        
        {
            int varDB0770958FBE9F872F2BC732090BF239_698465201 = (inCopied + copiedBytes);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408280943 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408280943;
        } //End block
    if(copiedBytes == 0)        
        {
            int var787E8700E82D0C2395ECBB8EA3AA68D6_118442676 = (inCopied);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832869710 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832869710;
        } //End block
        int var61A4D4698CE31A96A8B3DB19604C002C_1659299347 = (copiedBytes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531249998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531249998;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.760 -0400", hash_original_method = "2E2FBA951DCC3C9DB1EDAE98D88B8EBD", hash_generated_method = "68D0876E1ED6A3D1F0BA4272491923C5")
    private IOException streamClosed() throws IOException {
        IOException varA0BB301E46D4FCBF44B7C62E997ABEAD_708341249 = new IOException("PushbackInputStream is closed");
        varA0BB301E46D4FCBF44B7C62E997ABEAD_708341249.addTaint(taint);
        throw varA0BB301E46D4FCBF44B7C62E997ABEAD_708341249;
        // ---------- Original Method ----------
        //throw new IOException("PushbackInputStream is closed");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.791 -0400", hash_original_method = "640B22F7B00DCEA150CE7BE86C25A8AB", hash_generated_method = "547C6128A5E2FC2C0F7ACD5BC65365A0")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
    if(in == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_332304496 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_332304496.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_332304496;
        } //End block
    if(byteCount <= 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1507982454 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1441351875 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1441351875;
        } //End block
        int numSkipped = 0;
    if(pos < buf.length)        
        {
            numSkipped += (byteCount < buf.length - pos) ? byteCount : buf.length - pos;
            pos += numSkipped;
        } //End block
    if(numSkipped < byteCount)        
        {
            numSkipped += in.skip(byteCount - numSkipped);
        } //End block
        long var19B188D897AB08790F4D81B26C6FB431_1816415336 = (numSkipped);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1343106402 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1343106402;
        // ---------- Original Method ----------
        //if (in == null) {
            //throw streamClosed();
        //}
        //if (byteCount <= 0) {
            //return 0;
        //}
        //int numSkipped = 0;
        //if (pos < buf.length) {
            //numSkipped += (byteCount < buf.length - pos) ? byteCount : buf.length - pos;
            //pos += numSkipped;
        //}
        //if (numSkipped < byteCount) {
            //numSkipped += in.skip(byteCount - numSkipped);
        //}
        //return numSkipped;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.792 -0400", hash_original_method = "C8192A3011924069F2B71E7D3088F3DC", hash_generated_method = "FF0E04C75F4ADF97E37C2B1AC9D50386")
    public void unread(byte[] buffer) throws IOException {
        addTaint(buffer[0]);
        unread(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //unread(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.804 -0400", hash_original_method = "DF65BDEADDE37C8EC8A6D2405E9B2E68", hash_generated_method = "1814B125657AA3CDB82A36BAB1D0B7D9")
    public void unread(byte[] buffer, int offset, int length) throws IOException {
        addTaint(offset);
        addTaint(buffer[0]);
    if(length > pos)        
        {
            IOException var026BB6CEDAAF18AFE37343DFB85FF3B4_1391023383 = new IOException("Pushback buffer full");
            var026BB6CEDAAF18AFE37343DFB85FF3B4_1391023383.addTaint(taint);
            throw var026BB6CEDAAF18AFE37343DFB85FF3B4_1391023383;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
    if(buf == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_986369837 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_986369837.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_986369837;
        } //End block
        System.arraycopy(buffer, offset, buf, pos - length, length);
        pos = pos - length;
        // ---------- Original Method ----------
        //if (length > pos) {
            //throw new IOException("Pushback buffer full");
        //}
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (buf == null) {
            //throw streamClosed();
        //}
        //System.arraycopy(buffer, offset, buf, pos - length, length);
        //pos = pos - length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.816 -0400", hash_original_method = "98848F28DD25FD585D8212E035CA9267", hash_generated_method = "584753B343F36BA27B47329CC2BC0C21")
    public void unread(int oneByte) throws IOException {
    if(buf == null)        
        {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_172952794 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_172952794.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_172952794;
        } //End block
    if(pos == 0)        
        {
            IOException var026BB6CEDAAF18AFE37343DFB85FF3B4_300423361 = new IOException("Pushback buffer full");
            var026BB6CEDAAF18AFE37343DFB85FF3B4_300423361.addTaint(taint);
            throw var026BB6CEDAAF18AFE37343DFB85FF3B4_300423361;
        } //End block
        buf[--pos] = (byte) oneByte;
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException();
        //}
        //if (pos == 0) {
            //throw new IOException("Pushback buffer full");
        //}
        //buf[--pos] = (byte) oneByte;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.817 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "374E02FA36CE7C442AE21827EF6D82FC")
    @Override
    public void mark(int readlimit) {
        addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.818 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "062E18D4989C27E3AB6B3AE804D14A4F")
    @Override
    public void reset() throws IOException {
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_1550371988 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_1550371988.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_1550371988;
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
}

