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

public class ContentLengthOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.812 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.812 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.812 -0400", hash_original_field = "A036A3A714D3EE6AC55BDB96C4ABF01A", hash_generated_field = "4C6BD53EE3E09B37B86F24B0D970D840")

    private long total = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.812 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.813 -0400", hash_original_method = "CBDB2FDC82C5AFE44AFBC6A393E7627D", hash_generated_method = "BF6D12F254FA3911830B20DE37D2E927")
    public  ContentLengthOutputStream(final SessionOutputBuffer out, long contentLength) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session output buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Content length may not be negative");
        } //End block
        this.out = out;
        this.contentLength = contentLength;
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new IllegalArgumentException("Session output buffer may not be null");
        //}
        //if (contentLength < 0) {
            //throw new IllegalArgumentException("Content length may not be negative");
        //}
        //this.out = out;
        //this.contentLength = contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.813 -0400", hash_original_method = "5088685B92B0533111B1789635B9B452", hash_generated_method = "341A4D07E16A7228344021CF35FB4E5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.813 -0400", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "659F5DF70DF5E6C77EDF97533C3E99AE")
    public void flush() throws IOException {
        this.out.flush();
        // ---------- Original Method ----------
        //this.out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.814 -0400", hash_original_method = "C2CCC6E8489DACB9C9AD7F8549C28D94", hash_generated_method = "35D3954DAD0E8BF4F499582CBBCC1283")
    public void write(byte[] b, int off, int len) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Attempted write to closed stream.");
        } //End block
        {
            long max = this.contentLength - this.total;
            {
                len = (int) max;
            } //End block
            this.out.write(b, off, len);
            this.total += len;
        } //End block
        addTaint(b[0]);
        addTaint(off);
        // ---------- Original Method ----------
        //if (this.closed) {
            //throw new IOException("Attempted write to closed stream.");
        //}
        //if (this.total < this.contentLength) {
            //long max = this.contentLength - this.total;
            //if (len > max) {
                //len = (int) max;
            //}
            //this.out.write(b, off, len);
            //this.total += len;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.814 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "5CD09DCFD2AF02670D810AB143DB747D")
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
        addTaint(b[0]);
        // ---------- Original Method ----------
        //write(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.814 -0400", hash_original_method = "671E4413F0815DA1A7C3D0AAECD8B1E8", hash_generated_method = "7F6F9AA888EC8C28970D5713FE2E5825")
    public void write(int b) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Attempted write to closed stream.");
        } //End block
        {
            this.out.write(b);
        } //End block
        addTaint(b);
        // ---------- Original Method ----------
        //if (this.closed) {
            //throw new IOException("Attempted write to closed stream.");
        //}
        //if (this.total < this.contentLength) {
            //this.out.write(b);
            //this.total++;
        //}
    }

    
}

