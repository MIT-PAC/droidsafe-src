package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;






public class LoggingSessionInputBuffer implements SessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.146 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.147 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.148 -0400", hash_original_method = "30BB4C3892976F9E3644AD0D9DD12600", hash_generated_method = "9EEA0E4B8B295D49BEB21E4B83172B51")
    public  LoggingSessionInputBuffer(final SessionInputBuffer in, final Wire wire) {
        super();
        this.in = in;
        this.wire = wire;
        // ---------- Original Method ----------
        //this.in = in;
        //this.wire = wire;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.150 -0400", hash_original_method = "73B755DCF940E19A92F1412B6DE37AD9", hash_generated_method = "CE4B61CCB935CAB241B86443F52771F0")
    public boolean isDataAvailable(int timeout) throws IOException {
        addTaint(timeout);
        boolean varBE1B82656804E94E74B9419C8500EFC7_2031737075 = (this.in.isDataAvailable(timeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454966060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454966060;
        // ---------- Original Method ----------
        //return this.in.isDataAvailable(timeout);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.151 -0400", hash_original_method = "DA2B8DCC431BE484C4A0BB40C73A5E8B", hash_generated_method = "BBBE3CB8CF5756B49DE54A8F253D21C8")
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        int l = this.in.read(b,  off,  len);
        if(this.wire.enabled() && l > 0)        
        {
            this.wire.input(b, off, l);
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_880076215 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062527528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062527528;
        // ---------- Original Method ----------
        //int l = this.in.read(b,  off,  len);
        //if (this.wire.enabled() && l > 0) {
            //this.wire.input(b, off, l);
        //}
        //return l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.151 -0400", hash_original_method = "33F84B16C0AA1EFA7634C96C8981DA03", hash_generated_method = "09DDD8D5D5A3E141091424F78EC4728C")
    public int read() throws IOException {
        int l = this.in.read();
        if(this.wire.enabled() && l > 0)        
        {
            this.wire.input(l);
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_724172963 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598014007 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598014007;
        // ---------- Original Method ----------
        //int l = this.in.read();
        //if (this.wire.enabled() && l > 0) { 
            //this.wire.input(l);
        //}
        //return l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.152 -0400", hash_original_method = "488208D8F1DE3F15889876EA1125BA0B", hash_generated_method = "857DD44020875CC7F28DFD5BAB862A32")
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int l = this.in.read(b);
        if(this.wire.enabled() && l > 0)        
        {
            this.wire.input(b, 0, l);
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_891542635 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607650387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607650387;
        // ---------- Original Method ----------
        //int l = this.in.read(b);
        //if (this.wire.enabled() && l > 0) {
            //this.wire.input(b, 0, l);
        //}
        //return l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.153 -0400", hash_original_method = "805C419B2A6B4FC548E6FF12081C14DD", hash_generated_method = "8C811E89067E6C9A4A2751B0E9022E3A")
    public String readLine() throws IOException {
        String s = this.in.readLine();
        if(this.wire.enabled() && s != null)        
        {
            this.wire.input(s + "[EOL]");
        } //End block
String var0478718F0636FB61899C13801CE9FE09_187277600 =         s;
        var0478718F0636FB61899C13801CE9FE09_187277600.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_187277600;
        // ---------- Original Method ----------
        //String s = this.in.readLine();
        //if (this.wire.enabled() && s != null) {
            //this.wire.input(s + "[EOL]");
        //}
        //return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.154 -0400", hash_original_method = "456F99C71B313CB59FF46BB7AC385CAA", hash_generated_method = "7DEF71F264D4432C025F730CBCB065BF")
    public int readLine(final CharArrayBuffer buffer) throws IOException {
        addTaint(buffer.getTaint());
        int l = this.in.readLine(buffer);
        if(this.wire.enabled() && l > 0)        
        {
            int pos = buffer.length() - l;
            String s = new String(buffer.buffer(), pos, l);
            this.wire.input(s + "[EOL]");
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_903492433 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328485679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328485679;
        // ---------- Original Method ----------
        //int l = this.in.readLine(buffer);
        //if (this.wire.enabled() && l > 0) {
            //int pos = buffer.length() - l;
            //String s = new String(buffer.buffer(), pos, l);
            //this.wire.input(s + "[EOL]");
        //}
        //return l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.154 -0400", hash_original_method = "CFF2A55480460235D568A691407E3D1A", hash_generated_method = "CDB735A4C5BB29B8FE7243ECAE258570")
    public HttpTransportMetrics getMetrics() {
HttpTransportMetrics var9067750D6C9B0996803EF7528D8C8DC3_374990839 =         this.in.getMetrics();
        var9067750D6C9B0996803EF7528D8C8DC3_374990839.addTaint(taint);
        return var9067750D6C9B0996803EF7528D8C8DC3_374990839;
        // ---------- Original Method ----------
        //return this.in.getMetrics();
    }

    
}

