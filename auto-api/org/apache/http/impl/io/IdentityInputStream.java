package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.io.SessionInputBuffer;

public class IdentityInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.843 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.843 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.844 -0400", hash_original_method = "9BF2DB3D820A8A5E47D8F845957A3FBA", hash_generated_method = "88F7BD9068BD0CF87982753E78EF1E94")
    public  IdentityInputStream(final SessionInputBuffer in) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session input buffer may not be null");
        } //End block
        this.in = in;
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new IllegalArgumentException("Session input buffer may not be null");
        //}
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.844 -0400", hash_original_method = "DCB121D8842EB51547DBC31A4230EDC6", hash_generated_method = "6144D4DECE7E15C7EC4E83CF2313B86C")
    public int available() throws IOException {
        {
            boolean var746B940C8D4EFBE901778D2AAB8F79F7_2104797275 = (!this.closed && this.in.isDataAvailable(10));
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563848814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563848814;
        // ---------- Original Method ----------
        //if (!this.closed && this.in.isDataAvailable(10)) {
            //return 1;
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.844 -0400", hash_original_method = "311E5281CF91526FD2B39B7023BBB3B5", hash_generated_method = "189AC125925A0F1BC150A3E99E2798E2")
    public void close() throws IOException {
        this.closed = true;
        // ---------- Original Method ----------
        //this.closed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.844 -0400", hash_original_method = "F6A0760AFCA549A5825114F4EAC4FB8F", hash_generated_method = "84A153129EF29604B8D0D73A17E9C316")
    public int read() throws IOException {
        {
            int var737744DC8D1F0D5E4A51D264CDB60748_330868159 = (this.in.read());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103769236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103769236;
        // ---------- Original Method ----------
        //if (this.closed) {
            //return -1;
        //} else {
            //return this.in.read();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.845 -0400", hash_original_method = "E3ECD120B22D1F545DEC5B2DDE1C9AA2", hash_generated_method = "49CDF6B47342DA98806602AEDF122E43")
    public int read(final byte[] b, int off, int len) throws IOException {
        {
            int varFFB206EE847AC72E4E154CE31485D922_608309558 = (this.in.read(b, off, len));
        } //End block
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102595789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102595789;
        // ---------- Original Method ----------
        //if (this.closed) {
            //return -1;
        //} else {
            //return this.in.read(b, off, len);
        //}
    }

    
}

