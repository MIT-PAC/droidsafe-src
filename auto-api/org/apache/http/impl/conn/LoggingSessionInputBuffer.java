package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;

public class LoggingSessionInputBuffer implements SessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.510 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.510 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.510 -0400", hash_original_method = "30BB4C3892976F9E3644AD0D9DD12600", hash_generated_method = "9EEA0E4B8B295D49BEB21E4B83172B51")
    public  LoggingSessionInputBuffer(final SessionInputBuffer in, final Wire wire) {
        super();
        this.in = in;
        this.wire = wire;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.511 -0400", hash_original_method = "73B755DCF940E19A92F1412B6DE37AD9", hash_generated_method = "681A8F9DC483E613A2904B348D16512F")
    public boolean isDataAvailable(int timeout) throws IOException {
        boolean var716023B2867B596628D2E2DD17A315CC_228585809 = (this.in.isDataAvailable(timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418225928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418225928;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.511 -0400", hash_original_method = "DA2B8DCC431BE484C4A0BB40C73A5E8B", hash_generated_method = "1CBCA4B5E071A7CAB5094039166D60E9")
    public int read(byte[] b, int off, int len) throws IOException {
        int l = this.in.read(b,  off,  len);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_1529195388 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(b, off, l);
            } 
        } 
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955661052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955661052;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.511 -0400", hash_original_method = "33F84B16C0AA1EFA7634C96C8981DA03", hash_generated_method = "C58C24A74798871DA86358C0F386AB86")
    public int read() throws IOException {
        int l = this.in.read();
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_17965210 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(l);
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202113946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202113946;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.512 -0400", hash_original_method = "488208D8F1DE3F15889876EA1125BA0B", hash_generated_method = "CBB9C892CC005170D0F355617569DEF9")
    public int read(byte[] b) throws IOException {
        int l = this.in.read(b);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_1798826198 = (this.wire.enabled() && l > 0);
            {
                this.wire.input(b, 0, l);
            } 
        } 
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_324165042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_324165042;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.512 -0400", hash_original_method = "805C419B2A6B4FC548E6FF12081C14DD", hash_generated_method = "5AC9D82ECBB4B4102FC05D682DF6094C")
    public String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1008895380 = null; 
        String s = this.in.readLine();
        {
            boolean varD37EC8DBFA184E63955F72E7E2B36DF5_191942616 = (this.wire.enabled() && s != null);
            {
                this.wire.input(s + "[EOL]");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1008895380 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1008895380.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1008895380;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.513 -0400", hash_original_method = "456F99C71B313CB59FF46BB7AC385CAA", hash_generated_method = "EBCB500E79EFB6C863FBED43C3210E25")
    public int readLine(final CharArrayBuffer buffer) throws IOException {
        int l = this.in.readLine(buffer);
        {
            boolean varB0E4109DBA4526BCD8B129859F85C0BF_571823937 = (this.wire.enabled() && l > 0);
            {
                int pos = buffer.length() - l;
                String s = new String(buffer.buffer(), pos, l);
                this.wire.input(s + "[EOL]");
            } 
        } 
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962261401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962261401;
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.513 -0400", hash_original_method = "CFF2A55480460235D568A691407E3D1A", hash_generated_method = "1955076DE55610793435EF19861A4E6D")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_1591426474 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1591426474 = this.in.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_1591426474.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1591426474;
        
        
    }

    
}

