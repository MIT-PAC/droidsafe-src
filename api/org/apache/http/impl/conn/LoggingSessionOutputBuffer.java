package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.CharArrayBuffer;

public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.165 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.165 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.166 -0400", hash_original_method = "9B52F273E26CB5D7F7BAD01E854C0200", hash_generated_method = "68AE7CE59A1FBCC69C9ADB138EB35B44")
    public  LoggingSessionOutputBuffer(final SessionOutputBuffer out, final Wire wire) {
        super();
        this.out = out;
        this.wire = wire;
        // ---------- Original Method ----------
        //this.out = out;
        //this.wire = wire;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.167 -0400", hash_original_method = "E8AA091506E0C7EDCD0C7636A9C3BA76", hash_generated_method = "5FDC2D03186779504998E4E2B99FD937")
    public void write(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        this.out.write(b,  off,  len);
        if(this.wire.enabled())        
        {
            this.wire.output(b, off, len);
        } //End block
        // ---------- Original Method ----------
        //this.out.write(b,  off,  len);
        //if (this.wire.enabled()) {
            //this.wire.output(b, off, len);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.167 -0400", hash_original_method = "5AAEA6F1D5C12B4807525C7221D2D4F0", hash_generated_method = "4B152F58BFBD1D01468D9DDC23A1FD74")
    public void write(int b) throws IOException {
        addTaint(b);
        this.out.write(b);
        if(this.wire.enabled())        
        {
            this.wire.output(b);
        } //End block
        // ---------- Original Method ----------
        //this.out.write(b);
        //if (this.wire.enabled()) {
            //this.wire.output(b);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.168 -0400", hash_original_method = "398DA088D4360963F630B5E740A28F5B", hash_generated_method = "9AE926A31D415F5F24FBB6B8FA4A6F4B")
    public void write(byte[] b) throws IOException {
        addTaint(b[0]);
        this.out.write(b);
        if(this.wire.enabled())        
        {
            this.wire.output(b);
        } //End block
        // ---------- Original Method ----------
        //this.out.write(b);
        //if (this.wire.enabled()) {
            //this.wire.output(b);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.169 -0400", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "659F5DF70DF5E6C77EDF97533C3E99AE")
    public void flush() throws IOException {
        this.out.flush();
        // ---------- Original Method ----------
        //this.out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.169 -0400", hash_original_method = "E49BA3BA8C77B9A3148B4EE9C17D24AC", hash_generated_method = "30A67FE2CC3D57E2104C3C3F7D2F83F9")
    public void writeLine(final CharArrayBuffer buffer) throws IOException {
        addTaint(buffer.getTaint());
        this.out.writeLine(buffer);
        if(this.wire.enabled())        
        {
            String s = new String(buffer.buffer(), 0, buffer.length());
            this.wire.output(s + "[EOL]");
        } //End block
        // ---------- Original Method ----------
        //this.out.writeLine(buffer);
        //if (this.wire.enabled()) {
            //String s = new String(buffer.buffer(), 0, buffer.length());
            //this.wire.output(s + "[EOL]");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.170 -0400", hash_original_method = "D3F9E08E28E99649C1B0B0BE6F42B853", hash_generated_method = "BEC2D2ECEAAA03B1AB25E3AF8758E357")
    public void writeLine(final String s) throws IOException {
        addTaint(s.getTaint());
        this.out.writeLine(s);
        if(this.wire.enabled())        
        {
            this.wire.output(s + "[EOL]");
        } //End block
        // ---------- Original Method ----------
        //this.out.writeLine(s);
        //if (this.wire.enabled()) {
            //this.wire.output(s + "[EOL]");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.170 -0400", hash_original_method = "1A01B276520F9BEAE357611B160DD712", hash_generated_method = "966C4245EDE0DA32772E916029A67515")
    public HttpTransportMetrics getMetrics() {
HttpTransportMetrics var720CA9FBB3D3518FCE8644278DFC2DC3_1459710818 =         this.out.getMetrics();
        var720CA9FBB3D3518FCE8644278DFC2DC3_1459710818.addTaint(taint);
        return var720CA9FBB3D3518FCE8644278DFC2DC3_1459710818;
        // ---------- Original Method ----------
        //return this.out.getMetrics();
    }

    
}

