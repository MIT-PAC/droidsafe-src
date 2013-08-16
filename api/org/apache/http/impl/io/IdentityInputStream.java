package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.io.SessionInputBuffer;






public class IdentityInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.613 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.614 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.614 -0400", hash_original_method = "9BF2DB3D820A8A5E47D8F845957A3FBA", hash_generated_method = "D817F22FAD18CDE368F891A52A8BD58F")
    public  IdentityInputStream(final SessionInputBuffer in) {
        super();
        if(in == null)        
        {
            IllegalArgumentException varB3677395451B18A3F9262E9D7FE254B3_522065468 = new IllegalArgumentException("Session input buffer may not be null");
            varB3677395451B18A3F9262E9D7FE254B3_522065468.addTaint(taint);
            throw varB3677395451B18A3F9262E9D7FE254B3_522065468;
        } //End block
        this.in = in;
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new IllegalArgumentException("Session input buffer may not be null");
        //}
        //this.in = in;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.615 -0400", hash_original_method = "DCB121D8842EB51547DBC31A4230EDC6", hash_generated_method = "EAE041E496D4CE0962320B403B0A7329")
    public int available() throws IOException {
        if(!this.closed && this.in.isDataAvailable(10))        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1953957622 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629481536 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629481536;
        } //End block
        else
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_917325637 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843469286 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843469286;
        } //End block
        // ---------- Original Method ----------
        //if (!this.closed && this.in.isDataAvailable(10)) {
            //return 1;
        //} else {
            //return 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.615 -0400", hash_original_method = "311E5281CF91526FD2B39B7023BBB3B5", hash_generated_method = "189AC125925A0F1BC150A3E99E2798E2")
    public void close() throws IOException {
        this.closed = true;
        // ---------- Original Method ----------
        //this.closed = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.616 -0400", hash_original_method = "F6A0760AFCA549A5825114F4EAC4FB8F", hash_generated_method = "59B65F6CBCC786094C71EF3458F623A8")
    public int read() throws IOException {
        if(this.closed)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_307885705 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885254159 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885254159;
        } //End block
        else
        {
            int var4B24E33D3D9F67DD13235F201B80A449_1688097763 = (this.in.read());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271825003 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271825003;
        } //End block
        // ---------- Original Method ----------
        //if (this.closed) {
            //return -1;
        //} else {
            //return this.in.read();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.616 -0400", hash_original_method = "E3ECD120B22D1F545DEC5B2DDE1C9AA2", hash_generated_method = "3FD6668A7530563538B8BC74FF16969E")
    public int read(final byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(this.closed)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_741062308 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633936574 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633936574;
        } //End block
        else
        {
            int varCFE585846710E20F72A2243C249191D6_101088471 = (this.in.read(b, off, len));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650316855 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650316855;
        } //End block
        // ---------- Original Method ----------
        //if (this.closed) {
            //return -1;
        //} else {
            //return this.in.read(b, off, len);
        //}
    }

    
}

