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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.781 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.782 -0400", hash_original_field = "B891B62AB9BE7813B9C97AEC94A62FFF", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private Wire wire;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.782 -0400", hash_original_method = "9B52F273E26CB5D7F7BAD01E854C0200", hash_generated_method = "68AE7CE59A1FBCC69C9ADB138EB35B44")
    public  LoggingSessionOutputBuffer(final SessionOutputBuffer out, final Wire wire) {
        super();
        this.out = out;
        this.wire = wire;
        // ---------- Original Method ----------
        //this.out = out;
        //this.wire = wire;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.783 -0400", hash_original_method = "E8AA091506E0C7EDCD0C7636A9C3BA76", hash_generated_method = "06095875758B31435341D715AA0E56C6")
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b,  off,  len);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_1444248638 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.783 -0400", hash_original_method = "5AAEA6F1D5C12B4807525C7221D2D4F0", hash_generated_method = "19C4F7B2BF98E9B1A210618282FC310B")
    public void write(int b) throws IOException {
        this.out.write(b);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_2071242440 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.792 -0400", hash_original_method = "398DA088D4360963F630B5E740A28F5B", hash_generated_method = "063CAAEFF4D2ABD4594FDB76744C3D35")
    public void write(byte[] b) throws IOException {
        this.out.write(b);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_139515127 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.792 -0400", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "659F5DF70DF5E6C77EDF97533C3E99AE")
    public void flush() throws IOException {
        this.out.flush();
        // ---------- Original Method ----------
        //this.out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.793 -0400", hash_original_method = "E49BA3BA8C77B9A3148B4EE9C17D24AC", hash_generated_method = "FF675A553E82AA511F161BED232AF10E")
    public void writeLine(final CharArrayBuffer buffer) throws IOException {
        this.out.writeLine(buffer);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_741737514 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.793 -0400", hash_original_method = "D3F9E08E28E99649C1B0B0BE6F42B853", hash_generated_method = "5B4D25E3D3B545669BD456A62B0A31E5")
    public void writeLine(final String s) throws IOException {
        this.out.writeLine(s);
        {
            boolean varCD353240B2654474B24EEC5D58F8A608_1588682228 = (this.wire.enabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.795 -0400", hash_original_method = "1A01B276520F9BEAE357611B160DD712", hash_generated_method = "F76403BA7396DFF7F77FCB7245E3075D")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_457638892 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_457638892 = this.out.getMetrics();
        varB4EAC82CA7396A68D541C85D26508E83_457638892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_457638892;
        // ---------- Original Method ----------
        //return this.out.getMetrics();
    }

    
}

