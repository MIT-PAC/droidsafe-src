package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.io.SessionInputBuffer;

public class ContentLengthInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.987 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.987 -0400", hash_original_field = "30905E6E8D02502121446F7E78ED3C72", hash_generated_field = "337E67B29A254DB50F39D690161DCA16")

    private long pos = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.987 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.987 -0400", hash_original_field = "8184C339823DFB91A7F30328C371321E", hash_generated_field = "12C364DD3F2CEF8D8A2DC449FD12693B")

    private SessionInputBuffer in = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.988 -0400", hash_original_method = "EB9A16D491B02E1C854609CD55105FA5", hash_generated_method = "A84A5CA229FF6464182866F07A52E363")
    public  ContentLengthInputStream(final SessionInputBuffer in, long contentLength) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Input stream may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Content length may not be negative");
        } //End block
        this.in = in;
        this.contentLength = contentLength;
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new IllegalArgumentException("Input stream may not be null");
        //}
        //if (contentLength < 0) {
            //throw new IllegalArgumentException("Content length may not be negative");
        //}
        //this.in = in;
        //this.contentLength = contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.989 -0400", hash_original_method = "37495B10D833FDE07627744A97E6F360", hash_generated_method = "F15E172BDC4E57C9E55AA91092163C05")
    public void close() throws IOException {
        {
            try 
            {
                byte buffer[];
                buffer = new byte[BUFFER_SIZE];
                {
                    boolean var50BC07FE915EB44A6278E4214CD8B4B4_1794041944 = (read(buffer) >= 0);
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                closed = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!closed) {
            //try {
                //byte buffer[] = new byte[BUFFER_SIZE];
                //while (read(buffer) >= 0) {
                //}
            //} finally {
                //closed = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.989 -0400", hash_original_method = "829D665E9575B14A2545A678B846DF03", hash_generated_method = "8D66B2288A3C29BC1FB280B7094DAC5E")
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Attempted read from closed stream.");
        } //End block
        int var7ADC6115C92BC1E13131B9420A76E4AC_1791584349 = (this.in.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261240583 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261240583;
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Attempted read from closed stream.");
        //}
        //if (pos >= contentLength) {
            //return -1;
        //}
        //pos++;
        //return this.in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.990 -0400", hash_original_method = "7953751167B17924FE4F5EE632E22C6C", hash_generated_method = "DF3FC73617B709AFBF8BC63F11749CB3")
    public int read(byte[] b, int off, int len) throws java.io.IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Attempted read from closed stream.");
        } //End block
        {
            len = (int) (contentLength - pos);
        } //End block
        int count;
        count = this.in.read(b, off, len);
        pos += count;
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36440772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36440772;
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Attempted read from closed stream.");
        //}
        //if (pos >= contentLength) {
            //return -1;
        //}
        //if (pos + len > contentLength) {
            //len = (int) (contentLength - pos);
        //}
        //int count = this.in.read(b, off, len);
        //pos += count;
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.990 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "D3501D7AF6EA8890EE9C515FDBEA0B6D")
    public int read(byte[] b) throws IOException {
        int var38A74F3EE8B05A9B738F2B8C0F60B1F0_479336180 = (read(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_12856378 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_12856378;
        // ---------- Original Method ----------
        //return read(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.994 -0400", hash_original_method = "F403C2DD7869661F9202FB887EC75E9B", hash_generated_method = "F9595F2E8BB6175C018AADD11C380A0B")
    public long skip(long n) throws IOException {
        byte[] buffer;
        buffer = new byte[BUFFER_SIZE];
        long remaining;
        remaining = Math.min(n, this.contentLength - this.pos);
        long count;
        count = 0;
        {
            int l;
            l = read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
            count += l;
            remaining -= l;
        } //End block
        this.pos += count;
        addTaint(n);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1881083417 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1881083417;
        // ---------- Original Method ----------
        //if (n <= 0) {
            //return 0;
        //}
        //byte[] buffer = new byte[BUFFER_SIZE];
        //long remaining = Math.min(n, this.contentLength - this.pos);
        //long count = 0;
        //while (remaining > 0) {
            //int l = read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
            //if (l == -1) {
                //break;
            //}
            //count += l;
            //remaining -= l;
        //}
        //this.pos += count;
        //return count;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.994 -0400", hash_original_field = "D4808A3FE7592153FBF8721DE2EDDCBC", hash_generated_field = "C3C5E694D870BDC8ED228168ED2566CC")

    private static int BUFFER_SIZE = 2048;
}

