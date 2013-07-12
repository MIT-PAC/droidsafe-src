package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

public class IdentityOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.235 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.236 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.236 -0400", hash_original_method = "E16B6A29C07B7180AFC28B24A819F792", hash_generated_method = "5A8F1FFE2D2B609B1A9135676593C80E")
    public  IdentityOutputStream(final SessionOutputBuffer out) {
        super();
    if(out == null)        
        {
            IllegalArgumentException var37F5C066C9D0ECEEAAAFE6FBC9B24E18_954898588 = new IllegalArgumentException("Session output buffer may not be null");
            var37F5C066C9D0ECEEAAAFE6FBC9B24E18_954898588.addTaint(taint);
            throw var37F5C066C9D0ECEEAAAFE6FBC9B24E18_954898588;
        } 
        this.out = out;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.236 -0400", hash_original_method = "5088685B92B0533111B1789635B9B452", hash_generated_method = "2038C15770562F52AE4CF227B046AE2D")
    public void close() throws IOException {
    if(!this.closed)        
        {
            this.closed = true;
            this.out.flush();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.237 -0400", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "659F5DF70DF5E6C77EDF97533C3E99AE")
    public void flush() throws IOException {
        this.out.flush();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.237 -0400", hash_original_method = "48248C1CEDDF87D374745F5C11B9054E", hash_generated_method = "58980632F8333A384240D14E293A0C41")
    public void write(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(this.closed)        
        {
            IOException varB052DBEEB15E0A31B3EDC9E0CDC85E32_2022823807 = new IOException("Attempted write to closed stream.");
            varB052DBEEB15E0A31B3EDC9E0CDC85E32_2022823807.addTaint(taint);
            throw varB052DBEEB15E0A31B3EDC9E0CDC85E32_2022823807;
        } 
        this.out.write(b, off, len);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.237 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "904CAC0C37AF6321EC383D3EF5840D77")
    public void write(byte[] b) throws IOException {
        addTaint(b[0]);
        write(b, 0, b.length);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.238 -0400", hash_original_method = "A7A4BE3D6472F4EA278A930E01512219", hash_generated_method = "DAA3D293DB3761582CDC23A01E9F31D0")
    public void write(int b) throws IOException {
        addTaint(b);
    if(this.closed)        
        {
            IOException varB052DBEEB15E0A31B3EDC9E0CDC85E32_250655237 = new IOException("Attempted write to closed stream.");
            varB052DBEEB15E0A31B3EDC9E0CDC85E32_250655237.addTaint(taint);
            throw varB052DBEEB15E0A31B3EDC9E0CDC85E32_250655237;
        } 
        this.out.write(b);
        
        
            
        
        
    }

    
}

