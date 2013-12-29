package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;






public class LoggingSessionInputBuffer implements SessionInputBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.224 -0500", hash_original_field = "70993BC56EC5FB33DD67D98C82018650", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private  SessionInputBuffer in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.226 -0500", hash_original_field = "D2667BBCCA848CAF9353759FA5A43764", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private  Wire wire;
    
    /**
     * Create an instance that wraps the specified session input buffer.
     * @param in The session input buffer.
     * @param wire The wire log to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.226 -0500", hash_original_method = "30BB4C3892976F9E3644AD0D9DD12600", hash_generated_method = "EB14FD867DDE50A2C3E7F0837BEBA57C")
    public LoggingSessionInputBuffer(final SessionInputBuffer in, final Wire wire) {
        super();
        this.in = in;
        this.wire = wire;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.227 -0500", hash_original_method = "73B755DCF940E19A92F1412B6DE37AD9", hash_generated_method = "817E96C03E188551603CF73A82532702")
    public boolean isDataAvailable(int timeout) throws IOException {
        return this.in.isDataAvailable(timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.228 -0500", hash_original_method = "DA2B8DCC431BE484C4A0BB40C73A5E8B", hash_generated_method = "297A359718DBB02BCF7E00D00A9859BD")
    public int read(byte[] b, int off, int len) throws IOException {
        int l = this.in.read(b,  off,  len);
        if (this.wire.enabled() && l > 0) {
            this.wire.input(b, off, l);
        }
        return l;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.229 -0500", hash_original_method = "33F84B16C0AA1EFA7634C96C8981DA03", hash_generated_method = "EC2F5139F9E349C17D8EE8298CA1EB55")
    public int read() throws IOException {
        int l = this.in.read();
        if (this.wire.enabled() && l > 0) { 
            this.wire.input(l);
        }
        return l;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.230 -0500", hash_original_method = "488208D8F1DE3F15889876EA1125BA0B", hash_generated_method = "EBA3D09853F2ADFC7B7684041D53DF99")
    public int read(byte[] b) throws IOException {
        int l = this.in.read(b);
        if (this.wire.enabled() && l > 0) {
            this.wire.input(b, 0, l);
        }
        return l;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.230 -0500", hash_original_method = "805C419B2A6B4FC548E6FF12081C14DD", hash_generated_method = "8B38B92E8A8B73351CDD36211B498690")
    public String readLine() throws IOException {
        String s = this.in.readLine();
        if (this.wire.enabled() && s != null) {
            this.wire.input(s + "[EOL]");
        }
        return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.231 -0500", hash_original_method = "456F99C71B313CB59FF46BB7AC385CAA", hash_generated_method = "F45AE35035610D818035C2AE67C3117C")
    public int readLine(final CharArrayBuffer buffer) throws IOException {
        int l = this.in.readLine(buffer);
        if (this.wire.enabled() && l > 0) {
            int pos = buffer.length() - l;
            String s = new String(buffer.buffer(), pos, l);
            this.wire.input(s + "[EOL]");
        }
        return l;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.232 -0500", hash_original_method = "CFF2A55480460235D568A691407E3D1A", hash_generated_method = "DCFED0A8BE0589CC98CEF3B1A38B7114")
    public HttpTransportMetrics getMetrics() {
        return this.in.getMetrics();
    }

    
}

