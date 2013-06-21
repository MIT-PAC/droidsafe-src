package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class BufferedOutputStream extends FilterOutputStream {
    protected byte[] buf;
    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.399 -0400", hash_original_method = "D896F62F17EBF4CCE50C0B823DA78DD6", hash_generated_method = "126262DE53B3C49CE3147059210DA02F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedOutputStream(OutputStream out) {
        this(out, 8192);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.399 -0400", hash_original_method = "D77D548D42DBDD230976FC72C0A9CFDA", hash_generated_method = "856D63E3206AE81EE937192C659EA6D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedOutputStream(OutputStream out, int size) {
        super(out);
        dsTaint.addTaint(size);
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
        } //End block
        buf = new byte[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = new byte[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.399 -0400", hash_original_method = "1ACC3FF49FD09C78DA86C982A642A64A", hash_generated_method = "5BF171C333DC6B7D2DE5007FBC651EFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void flush() throws IOException {
        checkNotClosed();
        flushInternal();
        out.flush();
        // ---------- Original Method ----------
        //checkNotClosed();
        //flushInternal();
        //out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.399 -0400", hash_original_method = "E23D99313D714FF4FE33BC33C5A12E3B", hash_generated_method = "DDEB4E71DB5F9E863DF5CE471686D51B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("BufferedOutputStream is closed");
        } //End block
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException("BufferedOutputStream is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.400 -0400", hash_original_method = "EC14898AF1C6D500DEF61C098384315C", hash_generated_method = "96058ED34D2643EE321ED2734DD707D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void write(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        checkNotClosed();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
        } //End block
        byte[] internalBuffer;
        internalBuffer = buf;
        {
            flushInternal();
            out.write(buffer, offset, length);
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            flushInternal();
        } //End block
        System.arraycopy(buffer, offset, internalBuffer, count, length);
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //byte[] internalBuffer = buf;
        //if (length >= internalBuffer.length) {
            //flushInternal();
            //out.write(buffer, offset, length);
            //return;
        //}
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (length > (internalBuffer.length - count)) {
            //flushInternal();
        //}
        //System.arraycopy(buffer, offset, internalBuffer, count, length);
        //count += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.400 -0400", hash_original_method = "C551C170B690A76D4989DEC0BC19E3FB", hash_generated_method = "4D85B03975F8849CF391CD30EF012287")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void close() throws IOException {
        try 
        {
            super.close();
        } //End block
        finally 
        {
            buf = null;
        } //End block
        // ---------- Original Method ----------
        //if (buf == null) {
            //return;
        //}
        //try {
            //super.close();
        //} finally {
            //buf = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.400 -0400", hash_original_method = "45333A97ED5F96C22A3D88C235B79D5A", hash_generated_method = "85046B6D8BA87AF3E0928DC901EBD3FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void write(int oneByte) throws IOException {
        dsTaint.addTaint(oneByte);
        checkNotClosed();
        {
            out.write(buf, 0, count);
            count = 0;
        } //End block
        buf[count++] = (byte) oneByte;
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (count == buf.length) {
            //out.write(buf, 0, count);
            //count = 0;
        //}
        //buf[count++] = (byte) oneByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.400 -0400", hash_original_method = "AAC3F75032624F788E22A2E407A017DD", hash_generated_method = "6594BE588B21DD6F677F8C15C2973C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void flushInternal() throws IOException {
        {
            out.write(buf, 0, count);
            count = 0;
        } //End block
        // ---------- Original Method ----------
        //if (count > 0) {
            //out.write(buf, 0, count);
            //count = 0;
        //}
    }

    
}

