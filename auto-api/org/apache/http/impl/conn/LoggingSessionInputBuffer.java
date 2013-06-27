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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.739 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.739 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.740 -0400", hash_original_method = "30BB4C3892976F9E3644AD0D9DD12600", hash_generated_method = "9EEA0E4B8B295D49BEB21E4B83172B51")
    public  LoggingSessionInputBuffer(final SessionInputBuffer in, final Wire wire) {
        super();
        this.in = in;
        this.wire = wire;
        // ---------- Original Method ----------
        //this.in = in;
        //this.wire = wire;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.741 -0400", hash_original_method = "73B755DCF940E19A92F1412B6DE37AD9", hash_generated_method = "98556397E3FA3A7046EBE7E464A0F824")
    public boolean isDataAvailable(int timeout) throws IOException {
        boolean var716023B2867B596628D2E2DD17A315CC_2126645918 = (this.in.isDataAvailable(timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750222630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_750222630;
        // ---------- Original Method ----------
        //return this.in.isDataAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.742 -0400", hash_original_method = "DA2B8DCC431BE484C4A0BB40C73A5E8B", hash_generated_method = "526ACB43E9EAE22C65720277024EC5EA")
    public int read(byte[] b, int off, int len) throws IOException {
        int l;
        l = this.in.read(b,  off,  len);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_642490746 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(b, off, l);
            } //End block
        } //End collapsed parenthetic
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649690243 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649690243;
        // ---------- Original Method ----------
        //int l = this.in.read(b,  off,  len);
        //if (this.wire.enabled() && l > 0) {
            //this.wire.input(b, off, l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.743 -0400", hash_original_method = "33F84B16C0AA1EFA7634C96C8981DA03", hash_generated_method = "604DFB4689C08B3BBE453232356F6073")
    public int read() throws IOException {
        int l;
        l = this.in.read();
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_1586311284 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(l);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048244113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048244113;
        // ---------- Original Method ----------
        //int l = this.in.read();
        //if (this.wire.enabled() && l > 0) { 
            //this.wire.input(l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.743 -0400", hash_original_method = "488208D8F1DE3F15889876EA1125BA0B", hash_generated_method = "2C2A2D2E53D15983F36F101E7844F557")
    public int read(byte[] b) throws IOException {
        int l;
        l = this.in.read(b);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_1549378777 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(b, 0, l);
            } //End block
        } //End collapsed parenthetic
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051273866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051273866;
        // ---------- Original Method ----------
        //int l = this.in.read(b);
        //if (this.wire.enabled() && l > 0) {
            //this.wire.input(b, 0, l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.750 -0400", hash_original_method = "805C419B2A6B4FC548E6FF12081C14DD", hash_generated_method = "40FBAE5A24C71B98833F58736C2CFAEE")
    public String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_953376596 = null; //Variable for return #1
        String s;
        s = this.in.readLine();
        {
            boolean varD37EC8DBFA184E63955F72E7E2B36DF5_1250223561 = (this.wire.enabled() && s != null);
            {
                this.wire.input(s + "[EOL]");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_953376596 = s;
        varB4EAC82CA7396A68D541C85D26508E83_953376596.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_953376596;
        // ---------- Original Method ----------
        //String s = this.in.readLine();
        //if (this.wire.enabled() && s != null) {
            //this.wire.input(s + "[EOL]");
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.750 -0400", hash_original_method = "456F99C71B313CB59FF46BB7AC385CAA", hash_generated_method = "9FBC7DD67F89B2C281C3D0E4EAE9BE50")
    public int readLine(final CharArrayBuffer buffer) throws IOException {
        int l;
        l = this.in.readLine(buffer);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_541833367 = (this.wire.enabled() && l > 0);
            {
                int pos;
                pos = buffer.length() - l;
                String s;
                s = new String(buffer.buffer(), pos, l);
                this.wire.input(s + "[EOL]");
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750964359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750964359;
        // ---------- Original Method ----------
        //int l = this.in.readLine(buffer);
        //if (this.wire.enabled() && l > 0) {
            //int pos = buffer.length() - l;
            //String s = new String(buffer.buffer(), pos, l);
            //this.wire.input(s + "[EOL]");
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.759 -0400", hash_original_method = "CFF2A55480460235D568A691407E3D1A", hash_generated_method = "69E693A74CC3998CED07ED5AD6FDEC05")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_958441469 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_958441469 = this.in.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_958441469.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_958441469;
        // ---------- Original Method ----------
        //return this.in.getMetrics();
    }

    
}

