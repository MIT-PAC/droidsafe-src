package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;

public class LoggingSessionInputBuffer implements SessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.857 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.857 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.858 -0400", hash_original_method = "30BB4C3892976F9E3644AD0D9DD12600", hash_generated_method = "9EEA0E4B8B295D49BEB21E4B83172B51")
    public  LoggingSessionInputBuffer(final SessionInputBuffer in, final Wire wire) {
        super();
        this.in = in;
        this.wire = wire;
        // ---------- Original Method ----------
        //this.in = in;
        //this.wire = wire;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.858 -0400", hash_original_method = "73B755DCF940E19A92F1412B6DE37AD9", hash_generated_method = "C8B6293A8F6E92BF6EFC95D4A9224065")
    public boolean isDataAvailable(int timeout) throws IOException {
        addTaint(timeout);
        boolean varBE1B82656804E94E74B9419C8500EFC7_1439323317 = (this.in.isDataAvailable(timeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127466911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127466911;
        // ---------- Original Method ----------
        //return this.in.isDataAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.858 -0400", hash_original_method = "DA2B8DCC431BE484C4A0BB40C73A5E8B", hash_generated_method = "19DE80477E72F685511664FA59113183")
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        int l = this.in.read(b,  off,  len);
    if(this.wire.enabled() && l > 0)        
        {
            this.wire.input(b, off, l);
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_376205781 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233135731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233135731;
        // ---------- Original Method ----------
        //int l = this.in.read(b,  off,  len);
        //if (this.wire.enabled() && l > 0) {
            //this.wire.input(b, off, l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.859 -0400", hash_original_method = "33F84B16C0AA1EFA7634C96C8981DA03", hash_generated_method = "572C278C0846CBC0BB07580E304B10B1")
    public int read() throws IOException {
        int l = this.in.read();
    if(this.wire.enabled() && l > 0)        
        {
            this.wire.input(l);
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_2130747863 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050898185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050898185;
        // ---------- Original Method ----------
        //int l = this.in.read();
        //if (this.wire.enabled() && l > 0) { 
            //this.wire.input(l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.859 -0400", hash_original_method = "488208D8F1DE3F15889876EA1125BA0B", hash_generated_method = "AA5B5E77AF7C7FD3F7BA4B806BD869AB")
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int l = this.in.read(b);
    if(this.wire.enabled() && l > 0)        
        {
            this.wire.input(b, 0, l);
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_587772380 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227688448 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227688448;
        // ---------- Original Method ----------
        //int l = this.in.read(b);
        //if (this.wire.enabled() && l > 0) {
            //this.wire.input(b, 0, l);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.860 -0400", hash_original_method = "805C419B2A6B4FC548E6FF12081C14DD", hash_generated_method = "66AD84BA946969AB3B394720661126F1")
    public String readLine() throws IOException {
        String s = this.in.readLine();
    if(this.wire.enabled() && s != null)        
        {
            this.wire.input(s + "[EOL]");
        } //End block
String var0478718F0636FB61899C13801CE9FE09_879318989 =         s;
        var0478718F0636FB61899C13801CE9FE09_879318989.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_879318989;
        // ---------- Original Method ----------
        //String s = this.in.readLine();
        //if (this.wire.enabled() && s != null) {
            //this.wire.input(s + "[EOL]");
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.860 -0400", hash_original_method = "456F99C71B313CB59FF46BB7AC385CAA", hash_generated_method = "C6CE49B23C3776E926006918E7447754")
    public int readLine(final CharArrayBuffer buffer) throws IOException {
        addTaint(buffer.getTaint());
        int l = this.in.readLine(buffer);
    if(this.wire.enabled() && l > 0)        
        {
            int pos = buffer.length() - l;
            String s = new String(buffer.buffer(), pos, l);
            this.wire.input(s + "[EOL]");
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_529181740 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228677795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228677795;
        // ---------- Original Method ----------
        //int l = this.in.readLine(buffer);
        //if (this.wire.enabled() && l > 0) {
            //int pos = buffer.length() - l;
            //String s = new String(buffer.buffer(), pos, l);
            //this.wire.input(s + "[EOL]");
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.861 -0400", hash_original_method = "CFF2A55480460235D568A691407E3D1A", hash_generated_method = "DD982D93B273E72208BEF4F1C34C0654")
    public HttpTransportMetrics getMetrics() {
HttpTransportMetrics var9067750D6C9B0996803EF7528D8C8DC3_1814798855 =         this.in.getMetrics();
        var9067750D6C9B0996803EF7528D8C8DC3_1814798855.addTaint(taint);
        return var9067750D6C9B0996803EF7528D8C8DC3_1814798855;
        // ---------- Original Method ----------
        //return this.in.getMetrics();
    }

    
}

