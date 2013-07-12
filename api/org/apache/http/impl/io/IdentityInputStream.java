package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.io.SessionInputBuffer;

public class IdentityInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.225 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.226 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.227 -0400", hash_original_method = "9BF2DB3D820A8A5E47D8F845957A3FBA", hash_generated_method = "E39418DB16E7D677F8FCED1939FCD6A3")
    public  IdentityInputStream(final SessionInputBuffer in) {
        super();
    if(in == null)        
        {
            IllegalArgumentException varB3677395451B18A3F9262E9D7FE254B3_2047274465 = new IllegalArgumentException("Session input buffer may not be null");
            varB3677395451B18A3F9262E9D7FE254B3_2047274465.addTaint(taint);
            throw varB3677395451B18A3F9262E9D7FE254B3_2047274465;
        } 
        this.in = in;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.227 -0400", hash_original_method = "DCB121D8842EB51547DBC31A4230EDC6", hash_generated_method = "0360B330F6D336E906EE1AA509E26DD5")
    public int available() throws IOException {
    if(!this.closed && this.in.isDataAvailable(10))        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1819049322 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602588353 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602588353;
        } 
        else
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1483201162 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_582013960 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_582013960;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.228 -0400", hash_original_method = "311E5281CF91526FD2B39B7023BBB3B5", hash_generated_method = "189AC125925A0F1BC150A3E99E2798E2")
    public void close() throws IOException {
        this.closed = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.228 -0400", hash_original_method = "F6A0760AFCA549A5825114F4EAC4FB8F", hash_generated_method = "4F5921D4166363193380793F91C9712A")
    public int read() throws IOException {
    if(this.closed)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1816263114 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953563219 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953563219;
        } 
        else
        {
            int var4B24E33D3D9F67DD13235F201B80A449_183597870 = (this.in.read());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814857171 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814857171;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.229 -0400", hash_original_method = "E3ECD120B22D1F545DEC5B2DDE1C9AA2", hash_generated_method = "9E8D9B443E6C6C660430BEEA78C8B960")
    public int read(final byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(this.closed)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1120751677 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1453391619 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1453391619;
        } 
        else
        {
            int varCFE585846710E20F72A2243C249191D6_149455141 = (this.in.read(b, off, len));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797386016 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797386016;
        } 
        
        
            
        
            
        
    }

    
}

