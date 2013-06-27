package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class PushbackInputStream extends FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.581 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.581 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.582 -0400", hash_original_method = "AC9553B1FAFFB4A8FBFF65B03BBACC5E", hash_generated_method = "3F5564E951E35BDFCBCD7F9B903974D4")
    public  PushbackInputStream(InputStream in) {
        super(in);
        buf = (in == null) ? null : new byte[1];
        pos = 1;
        // ---------- Original Method ----------
        //buf = (in == null) ? null : new byte[1];
        //pos = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.582 -0400", hash_original_method = "5FC607CA483EF0D15EF5263D4BBC83BA", hash_generated_method = "557A561B285AE4A5FF11EBA9CAFF2AA0")
    public  PushbackInputStream(InputStream in, int size) {
        super(in);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.587 -0400", hash_original_method = "446E244C062F8716B384D306C558B705", hash_generated_method = "2CAE666DA7DB649F68619025ACA87690")
    @Override
    public int available() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } //End block
        int varA950E43363A0DE1963921B3C18F6DA58_233320736 = (buf.length - pos + in.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446569369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446569369;
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException();
        //}
        //return buf.length - pos + in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.587 -0400", hash_original_method = "74DA7764B5809B26A354DD7668DF4A77", hash_generated_method = "3C987CC4CB0AECE751E27D46E3DCA943")
    @Override
    public void close() throws IOException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.587 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "6E1DABDB95DB4064DD29B1EB297A9C73")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959258592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959258592;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.587 -0400", hash_original_method = "146BBECA823F7801A366293B4A5C7497", hash_generated_method = "A898EF2130BE96616BF75240CB410713")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } //End block
        int var2EE2703F88097027B4DEA42C13801E06_531291494 = (in.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_366969366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_366969366;
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException();
        //}
        //if (pos < buf.length) {
            //return (buf[pos++] & 0xFF);
        //}
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.590 -0400", hash_original_method = "1B53276B26E96C9AEFE2F3C951EF5EAE", hash_generated_method = "4B8ED3F3FABDE664F824560F2763098D")
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        int copiedBytes, copyLength, newOffset;
        copiedBytes = 0;
        copyLength = 0;
        newOffset = offset;
        {
            copyLength = (buf.length - pos >= length) ? length : buf.length
                    - pos;
            System.arraycopy(buf, pos, buffer, newOffset, copyLength);
            newOffset += copyLength;
            copiedBytes += copyLength;
            pos += copyLength;
        } //End block
        int inCopied;
        inCopied = in.read(buffer, newOffset, length - copiedBytes);
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677716696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677716696;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.590 -0400", hash_original_method = "2E2FBA951DCC3C9DB1EDAE98D88B8EBD", hash_generated_method = "FAE066DB8A7BB73956AD5304292735D2")
    private IOException streamClosed() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("PushbackInputStream is closed");
        // ---------- Original Method ----------
        //throw new IOException("PushbackInputStream is closed");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.604 -0400", hash_original_method = "640B22F7B00DCEA150CE7BE86C25A8AB", hash_generated_method = "4CB2EFA1B9CE518E23F9FC7DABDD8C70")
    @Override
    public long skip(long byteCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        int numSkipped;
        numSkipped = 0;
        {
            numSkipped += (byteCount < buf.length - pos) ? byteCount : buf.length - pos;
            pos += numSkipped;
        } //End block
        {
            numSkipped += in.skip(byteCount - numSkipped);
        } //End block
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1334667718 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1334667718;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.604 -0400", hash_original_method = "C8192A3011924069F2B71E7D3088F3DC", hash_generated_method = "7B45023432F7868636C37F9593E29869")
    public void unread(byte[] buffer) throws IOException {
        unread(buffer, 0, buffer.length);
        addTaint(buffer[0]);
        // ---------- Original Method ----------
        //unread(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.605 -0400", hash_original_method = "DF65BDEADDE37C8EC8A6D2405E9B2E68", hash_generated_method = "C29945E90C922C14AE31FF7AAE40127C")
    public void unread(byte[] buffer, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Pushback buffer full");
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        System.arraycopy(buffer, offset, buf, pos - length, length);
        pos = pos - length;
        addTaint(buffer[0]);
        addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.605 -0400", hash_original_method = "98848F28DD25FD585D8212E035CA9267", hash_generated_method = "FF8F5E277009446652B3889DDE2B2EA1")
    public void unread(int oneByte) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Pushback buffer full");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.605 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "374E02FA36CE7C442AE21827EF6D82FC")
    @Override
    public void mark(int readlimit) {
        addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.606 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "A9C0F826408505F69F969DEF2E274553")
    @Override
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
}

