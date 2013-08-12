package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.io.SessionOutputBuffer;






public class ContentLengthOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.566 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.566 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.566 -0400", hash_original_field = "A036A3A714D3EE6AC55BDB96C4ABF01A", hash_generated_field = "4C6BD53EE3E09B37B86F24B0D970D840")

    private long total = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.566 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.568 -0400", hash_original_method = "CBDB2FDC82C5AFE44AFBC6A393E7627D", hash_generated_method = "41D4D12DBE52C5F9BAA5CFEAD221D681")
    public  ContentLengthOutputStream(final SessionOutputBuffer out, long contentLength) {
        super();
        if(out == null)        
        {
            IllegalArgumentException var37F5C066C9D0ECEEAAAFE6FBC9B24E18_983706271 = new IllegalArgumentException("Session output buffer may not be null");
            var37F5C066C9D0ECEEAAAFE6FBC9B24E18_983706271.addTaint(taint);
            throw var37F5C066C9D0ECEEAAAFE6FBC9B24E18_983706271;
        } //End block
        if(contentLength < 0)        
        {
            IllegalArgumentException varC9A4EC004E3A33FE21D2178F89740754_1496237326 = new IllegalArgumentException("Content length may not be negative");
            varC9A4EC004E3A33FE21D2178F89740754_1496237326.addTaint(taint);
            throw varC9A4EC004E3A33FE21D2178F89740754_1496237326;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.568 -0400", hash_original_method = "5088685B92B0533111B1789635B9B452", hash_generated_method = "2038C15770562F52AE4CF227B046AE2D")
    public void close() throws IOException {
        if(!this.closed)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.569 -0400", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "659F5DF70DF5E6C77EDF97533C3E99AE")
    public void flush() throws IOException {
        this.out.flush();
        // ---------- Original Method ----------
        //this.out.flush();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.570 -0400", hash_original_method = "C2CCC6E8489DACB9C9AD7F8549C28D94", hash_generated_method = "B5885F1688F8CEDE581DDA44E976B95F")
    public void write(byte[] b, int off, int len) throws IOException {
        addTaint(off);
        addTaint(b[0]);
        if(this.closed)        
        {
            IOException varB052DBEEB15E0A31B3EDC9E0CDC85E32_1701093249 = new IOException("Attempted write to closed stream.");
            varB052DBEEB15E0A31B3EDC9E0CDC85E32_1701093249.addTaint(taint);
            throw varB052DBEEB15E0A31B3EDC9E0CDC85E32_1701093249;
        } //End block
        if(this.total < this.contentLength)        
        {
            long max = this.contentLength - this.total;
            if(len > max)            
            {
                len = (int) max;
            } //End block
            this.out.write(b, off, len);
            this.total += len;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.570 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "904CAC0C37AF6321EC383D3EF5840D77")
    public void write(byte[] b) throws IOException {
        addTaint(b[0]);
        write(b, 0, b.length);
        // ---------- Original Method ----------
        //write(b, 0, b.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.571 -0400", hash_original_method = "671E4413F0815DA1A7C3D0AAECD8B1E8", hash_generated_method = "6C97B9FBD36D25FB1BBFF6795A55487A")
    public void write(int b) throws IOException {
        addTaint(b);
        if(this.closed)        
        {
            IOException varB052DBEEB15E0A31B3EDC9E0CDC85E32_1560075566 = new IOException("Attempted write to closed stream.");
            varB052DBEEB15E0A31B3EDC9E0CDC85E32_1560075566.addTaint(taint);
            throw varB052DBEEB15E0A31B3EDC9E0CDC85E32_1560075566;
        } //End block
        if(this.total < this.contentLength)        
        {
            this.out.write(b);
            this.total++;
        } //End block
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

