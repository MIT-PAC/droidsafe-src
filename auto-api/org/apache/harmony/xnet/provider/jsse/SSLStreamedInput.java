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
    private InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.280 -0400", hash_original_method = "2603FDEDA68AA1C899FD148F0716545A", hash_generated_method = "8FC324843AACAE70A779048FB530387D")
    @DSModeled(DSC.SAFE)
    public SSLStreamedInput(InputStream in) {
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.281 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "7DEE616041FCC0C081219597DA91118B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_826051139 = (in.available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.281 -0400", hash_original_method = "944A08161D308B286B46AD616F2EEC05", hash_generated_method = "30E1E404589817F9FCCBA7B78F86F374")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        int res;
        res = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EndOfSourceException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int res = in.read();
        //if (res < 0) {
            //throw new EndOfSourceException();
        //}
        //return res;
    }

    
}

