package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class PushbackInputStream extends FilterInputStream {
    protected byte[] buf;
    protected int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.239 -0400", hash_original_method = "AC9553B1FAFFB4A8FBFF65B03BBACC5E", hash_generated_method = "3EA4C3F6820B69D77D347A6C786D0808")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PushbackInputStream(InputStream in) {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        buf = (in == null) ? null : new byte[1];
        pos = 1;
        // ---------- Original Method ----------
        //buf = (in == null) ? null : new byte[1];
        //pos = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.240 -0400", hash_original_method = "5FC607CA483EF0D15EF5263D4BBC83BA", hash_generated_method = "12C7857FDEF9B861ECA8FB17D9FFD153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PushbackInputStream(InputStream in, int size) {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
        } //End block
        buf = (in == null) ? null : new byte[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = (in == null) ? null : new byte[size];
        //pos = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.241 -0400", hash_original_method = "446E244C062F8716B384D306C558B705", hash_generated_method = "8866BD9858D75FF921046C4B49B09B69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } //End block
        int varA950E43363A0DE1963921B3C18F6DA58_159878726 = (buf.length - pos + in.available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException();
        //}
        //return buf.length - pos + in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.241 -0400", hash_original_method = "74DA7764B5809B26A354DD7668DF4A77", hash_generated_method = "3C987CC4CB0AECE751E27D46E3DCA943")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.241 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "68288F8CAFD57F6B45948F556AADD5DE")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.241 -0400", hash_original_method = "146BBECA823F7801A366293B4A5C7497", hash_generated_method = "6017DA84956048D88137CD8375103FA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } //End block
        int var2EE2703F88097027B4DEA42C13801E06_88832068 = (in.read());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException();
        //}
        //if (pos < buf.length) {
            //return (buf[pos++] & 0xFF);
        //}
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.242 -0400", hash_original_method = "1B53276B26E96C9AEFE2F3C951EF5EAE", hash_generated_method = "850269ABC7418A971920076E6092817E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.242 -0400", hash_original_method = "2E2FBA951DCC3C9DB1EDAE98D88B8EBD", hash_generated_method = "5587775E37268521FE1AF2E5489B92BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IOException streamClosed() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("PushbackInputStream is closed");
        return (IOException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new IOException("PushbackInputStream is closed");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.242 -0400", hash_original_method = "640B22F7B00DCEA150CE7BE86C25A8AB", hash_generated_method = "89CCCAEC91CEEAB7B0CA81E06B39E5B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
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
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.242 -0400", hash_original_method = "C8192A3011924069F2B71E7D3088F3DC", hash_generated_method = "40F47FADBDA460FD51FB701EAD7B0C74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unread(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer[0]);
        unread(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //unread(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.243 -0400", hash_original_method = "DF65BDEADDE37C8EC8A6D2405E9B2E68", hash_generated_method = "BF2C6CB65ECED5ADE696D87F0783BE3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unread(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Pushback buffer full");
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.243 -0400", hash_original_method = "98848F28DD25FD585D8212E035CA9267", hash_generated_method = "2F598F35F19B4C94C635864E7E34AC1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unread(int oneByte) throws IOException {
        dsTaint.addTaint(oneByte);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.243 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "B31C26BECE0372A4FA48EE5727FE34E2")
    @DSModeled(DSC.SAFE)
    @Override
    public void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.243 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "A9C0F826408505F69F969DEF2E274553")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
}

