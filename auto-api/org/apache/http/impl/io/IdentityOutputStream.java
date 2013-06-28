package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

public class IdentityOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.850 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.850 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.851 -0400", hash_original_method = "E16B6A29C07B7180AFC28B24A819F792", hash_generated_method = "63BB6690A387CDEAFDAD49B62D1389CF")
    public  IdentityOutputStream(final SessionOutputBuffer out) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session output buffer may not be null");
        } //End block
        this.out = out;
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new IllegalArgumentException("Session output buffer may not be null");
        //}
        //this.out = out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.851 -0400", hash_original_method = "5088685B92B0533111B1789635B9B452", hash_generated_method = "341A4D07E16A7228344021CF35FB4E5A")
    public void close() throws IOException {
        {
            this.closed = true;
            this.out.flush();
        } //End block
        // ---------- Original Method ----------
        //if (!this.closed) {
            //this.closed = true;
            //this.out.flush();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.852 -0400", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "659F5DF70DF5E6C77EDF97533C3E99AE")
    public void flush() throws IOException {
        this.out.flush();
        // ---------- Original Method ----------
        //this.out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.852 -0400", hash_original_method = "48248C1CEDDF87D374745F5C11B9054E", hash_generated_method = "BE528FFAD6A4136BDF1EAD8386E976F2")
    public void write(byte[] b, int off, int len) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Attempted write to closed stream.");
        } //End block
        this.out.write(b, off, len);
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        //if (this.closed) {
            //throw new IOException("Attempted write to closed stream.");
        //}
        //this.out.write(b, off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.853 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "5CD09DCFD2AF02670D810AB143DB747D")
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
        addTaint(b[0]);
        // ---------- Original Method ----------
        //write(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.853 -0400", hash_original_method = "A7A4BE3D6472F4EA278A930E01512219", hash_generated_method = "ACCF5812726C0DA70E596F1DE144C0DC")
    public void write(int b) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Attempted write to closed stream.");
        } //End block
        this.out.write(b);
        addTaint(b);
        // ---------- Original Method ----------
        //if (this.closed) {
            //throw new IOException("Attempted write to closed stream.");
        //}
        //this.out.write(b);
    }

    
}

