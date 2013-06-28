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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.521 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.521 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.522 -0400", hash_original_method = "9B52F273E26CB5D7F7BAD01E854C0200", hash_generated_method = "68AE7CE59A1FBCC69C9ADB138EB35B44")
    public  LoggingSessionOutputBuffer(final SessionOutputBuffer out, final Wire wire) {
        super();
        this.out = out;
        this.wire = wire;
        // ---------- Original Method ----------
        //this.out = out;
        //this.wire = wire;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.522 -0400", hash_original_method = "E8AA091506E0C7EDCD0C7636A9C3BA76", hash_generated_method = "3807E5B3760AEE20FB256C27A3FFAB8D")
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b,  off,  len);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_1791812531 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.522 -0400", hash_original_method = "5AAEA6F1D5C12B4807525C7221D2D4F0", hash_generated_method = "F1137D494469E53188E96D8988204339")
    public void write(int b) throws IOException {
        this.out.write(b);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_242968023 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.523 -0400", hash_original_method = "398DA088D4360963F630B5E740A28F5B", hash_generated_method = "D5CC8469AC00180239894FE2D78D68FC")
    public void write(byte[] b) throws IOException {
        this.out.write(b);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_2130617501 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.523 -0400", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "659F5DF70DF5E6C77EDF97533C3E99AE")
    public void flush() throws IOException {
        this.out.flush();
        // ---------- Original Method ----------
        //this.out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.523 -0400", hash_original_method = "E49BA3BA8C77B9A3148B4EE9C17D24AC", hash_generated_method = "F43E40A32B6E62ECF29742E982CEA8DF")
    public void writeLine(final CharArrayBuffer buffer) throws IOException {
        this.out.writeLine(buffer);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_1336234805 = (this.wire.enabled());
            {
                String s = new String(buffer.buffer(), 0, buffer.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.524 -0400", hash_original_method = "D3F9E08E28E99649C1B0B0BE6F42B853", hash_generated_method = "5F49541EADCFA2922E0E90601004886B")
    public void writeLine(final String s) throws IOException {
        this.out.writeLine(s);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_426766565 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.525 -0400", hash_original_method = "1A01B276520F9BEAE357611B160DD712", hash_generated_method = "EA2F0D488499A67BC91D09C62CEAE1CD")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_1473045508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1473045508 = this.out.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_1473045508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1473045508;
        // ---------- Original Method ----------
        //return this.out.getMetrics();
    }

    
}

