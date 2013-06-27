package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class SSLStreamedInput extends SSLInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.807 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.808 -0400", hash_original_method = "2603FDEDA68AA1C899FD148F0716545A", hash_generated_method = "85D6DFF45943A1150F3CC11B41730323")
    public  SSLStreamedInput(InputStream in) {
        this.in = in;
        // ---------- Original Method ----------
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.809 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "CE903D4A9A940BAAB910543110662352")
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_1255785343 = (in.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_831754164 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_831754164;
        // ---------- Original Method ----------
        //return in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.809 -0400", hash_original_method = "944A08161D308B286B46AD616F2EEC05", hash_generated_method = "10FB7DF591C2DC27487FF79C7753EF2F")
    @Override
    public int read() throws IOException {
        int res;
        res = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EndOfSourceException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536202075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536202075;
        // ---------- Original Method ----------
        //int res = in.read();
        //if (res < 0) {
            //throw new EndOfSourceException();
        //}
        //return res;
    }

    
}

