package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;

public class LoggingSessionInputBuffer implements SessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.845 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.845 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.846 -0400", hash_original_method = "30BB4C3892976F9E3644AD0D9DD12600", hash_generated_method = "9EEA0E4B8B295D49BEB21E4B83172B51")
    public  LoggingSessionInputBuffer(final SessionInputBuffer in, final Wire wire) {
        super();
        this.in = in;
        this.wire = wire;
        // ---------- Original Method ----------
        //this.in = in;
        //this.wire = wire;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.846 -0400", hash_original_method = "73B755DCF940E19A92F1412B6DE37AD9", hash_generated_method = "E2D102D96C95EBCF6777BD49DC6B6FB5")
    public boolean isDataAvailable(int timeout) throws IOException {
        boolean var716023B2867B596628D2E2DD17A315CC_1790202771 = (this.in.isDataAvailable(timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789568321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789568321;
        // ---------- Original Method ----------
        //return this.in.isDataAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.847 -0400", hash_original_method = "DA2B8DCC431BE484C4A0BB40C73A5E8B", hash_generated_method = "D432B094E91CFB997D36089D9148398E")
    public int read(byte[] b, int off, int len) throws IOException {
        int l;
        l = this.in.read(b,  off,  len);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_2132589374 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(b, off, l);
            } //End block
        } //End collapsed parenthetic
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878899191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878899191;
        // ---------- Original Method ----------
        //int l = this.in.read(b,  off,  len);
        //if (this.wire.enabled() && l > 0) {
            //this.wire.input(b, off, l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.848 -0400", hash_original_method = "33F84B16C0AA1EFA7634C96C8981DA03", hash_generated_method = "AFE63111BFF6903CC0D5F35506C9A1A3")
    public int read() throws IOException {
        int l;
        l = this.in.read();
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_1465738589 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(l);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544999775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544999775;
        // ---------- Original Method ----------
        //int l = this.in.read();
        //if (this.wire.enabled() && l > 0) { 
            //this.wire.input(l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.862 -0400", hash_original_method = "488208D8F1DE3F15889876EA1125BA0B", hash_generated_method = "7EE5100E73843291C2865A6F11FBD52E")
    public int read(byte[] b) throws IOException {
        int l;
        l = this.in.read(b);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_20677571 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(b, 0, l);
            } //End block
        } //End collapsed parenthetic
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883907106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883907106;
        // ---------- Original Method ----------
        //int l = this.in.read(b);
        //if (this.wire.enabled() && l > 0) {
            //this.wire.input(b, 0, l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.863 -0400", hash_original_method = "805C419B2A6B4FC548E6FF12081C14DD", hash_generated_method = "F5F8BC20D29908A59AE0553C100A3F8B")
    public String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_2020120433 = null; //Variable for return #1
        String s;
        s = this.in.readLine();
        {
            boolean varD37EC8DBFA184E63955F72E7E2B36DF5_1685696086 = (this.wire.enabled() && s != null);
            {
                this.wire.input(s + "[EOL]");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2020120433 = s;
        varB4EAC82CA7396A68D541C85D26508E83_2020120433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2020120433;
        // ---------- Original Method ----------
        //String s = this.in.readLine();
        //if (this.wire.enabled() && s != null) {
            //this.wire.input(s + "[EOL]");
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.864 -0400", hash_original_method = "456F99C71B313CB59FF46BB7AC385CAA", hash_generated_method = "F004E8DC81A3139BB0BBFB60137F9E7B")
    public int readLine(final CharArrayBuffer buffer) throws IOException {
        int l;
        l = this.in.readLine(buffer);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_1661810145 = (this.wire.enabled() && l > 0);
            {
                int pos;
                pos = buffer.length() - l;
                String s;
                s = new String(buffer.buffer(), pos, l);
                this.wire.input(s + "[EOL]");
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935321879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935321879;
        // ---------- Original Method ----------
        //int l = this.in.readLine(buffer);
        //if (this.wire.enabled() && l > 0) {
            //int pos = buffer.length() - l;
            //String s = new String(buffer.buffer(), pos, l);
            //this.wire.input(s + "[EOL]");
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.864 -0400", hash_original_method = "CFF2A55480460235D568A691407E3D1A", hash_generated_method = "7796A8FFD35C7B8A41BFD4A5833F6044")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_242984851 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_242984851 = this.in.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_242984851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_242984851;
        // ---------- Original Method ----------
        //return this.in.getMetrics();
    }

    
}

