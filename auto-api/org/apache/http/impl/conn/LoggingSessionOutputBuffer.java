package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.CharArrayBuffer;

public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.849 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.849 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.849 -0400", hash_original_method = "9B52F273E26CB5D7F7BAD01E854C0200", hash_generated_method = "68AE7CE59A1FBCC69C9ADB138EB35B44")
    public  LoggingSessionOutputBuffer(final SessionOutputBuffer out, final Wire wire) {
        super();
        this.out = out;
        this.wire = wire;
        // ---------- Original Method ----------
        //this.out = out;
        //this.wire = wire;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.850 -0400", hash_original_method = "E8AA091506E0C7EDCD0C7636A9C3BA76", hash_generated_method = "B504146AB50A99DE06D3ADCB2717D19B")
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b,  off,  len);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_1348908882 = (this.wire.enabled());
            {
                this.wire.output(b, off, len);
            } //End block
        } //End collapsed parenthetic
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        //this.out.write(b,  off,  len);
        //if (this.wire.enabled()) {
            //this.wire.output(b, off, len);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.850 -0400", hash_original_method = "5AAEA6F1D5C12B4807525C7221D2D4F0", hash_generated_method = "2EEFAB9FEE8F6DB19A836998B673EED3")
    public void write(int b) throws IOException {
        this.out.write(b);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_525326627 = (this.wire.enabled());
            {
                this.wire.output(b);
            } //End block
        } //End collapsed parenthetic
        addTaint(b);
        // ---------- Original Method ----------
        //this.out.write(b);
        //if (this.wire.enabled()) {
            //this.wire.output(b);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.850 -0400", hash_original_method = "398DA088D4360963F630B5E740A28F5B", hash_generated_method = "9C36A854964F92EAB79D01E64D318A7C")
    public void write(byte[] b) throws IOException {
        this.out.write(b);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_1263637273 = (this.wire.enabled());
            {
                this.wire.output(b);
            } //End block
        } //End collapsed parenthetic
        addTaint(b[0]);
        // ---------- Original Method ----------
        //this.out.write(b);
        //if (this.wire.enabled()) {
            //this.wire.output(b);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.851 -0400", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "659F5DF70DF5E6C77EDF97533C3E99AE")
    public void flush() throws IOException {
        this.out.flush();
        // ---------- Original Method ----------
        //this.out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.851 -0400", hash_original_method = "E49BA3BA8C77B9A3148B4EE9C17D24AC", hash_generated_method = "D0259F935073A741F6B17D893E5B85FE")
    public void writeLine(final CharArrayBuffer buffer) throws IOException {
        this.out.writeLine(buffer);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_1269832019 = (this.wire.enabled());
            {
                String s;
                s = new String(buffer.buffer(), 0, buffer.length());
                this.wire.output(s + "[EOL]");
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //this.out.writeLine(buffer);
        //if (this.wire.enabled()) {
            //String s = new String(buffer.buffer(), 0, buffer.length());
            //this.wire.output(s + "[EOL]");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.851 -0400", hash_original_method = "D3F9E08E28E99649C1B0B0BE6F42B853", hash_generated_method = "47EDB4AEBCDAD3CF1D960E8EFB756848")
    public void writeLine(final String s) throws IOException {
        this.out.writeLine(s);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_325140616 = (this.wire.enabled());
            {
                this.wire.output(s + "[EOL]");
            } //End block
        } //End collapsed parenthetic
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //this.out.writeLine(s);
        //if (this.wire.enabled()) {
            //this.wire.output(s + "[EOL]");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.858 -0400", hash_original_method = "1A01B276520F9BEAE357611B160DD712", hash_generated_method = "8D4CD89242BA671A04E36CD66B48CADA")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_1768801439 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1768801439 = this.out.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_1768801439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1768801439;
        // ---------- Original Method ----------
        //return this.out.getMetrics();
    }

    
}

