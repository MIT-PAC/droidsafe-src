package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;

public class SSLStreamedInput extends SSLInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.436 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.436 -0400", hash_original_method = "2603FDEDA68AA1C899FD148F0716545A", hash_generated_method = "85D6DFF45943A1150F3CC11B41730323")
    public  SSLStreamedInput(InputStream in) {
        this.in = in;
        // ---------- Original Method ----------
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.436 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "EED1FC9A1AE61BEDA8DEE40520DC19A0")
    @Override
    public int available() throws IOException {
        int var443A4CD22A314221356D4EA83AFE1E61_1107825139 = (in.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477596140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477596140;
        // ---------- Original Method ----------
        //return in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.436 -0400", hash_original_method = "944A08161D308B286B46AD616F2EEC05", hash_generated_method = "9D3083CAA0CA783CE9BA748D94D20B36")
    @Override
    public int read() throws IOException {
        int res = in.read();
    if(res < 0)        
        {
            EndOfSourceException var6ABBC3A72E0A5669B60B0ADF303EF8C9_1607515992 = new EndOfSourceException();
            var6ABBC3A72E0A5669B60B0ADF303EF8C9_1607515992.addTaint(taint);
            throw var6ABBC3A72E0A5669B60B0ADF303EF8C9_1607515992;
        } //End block
        int var9B207167E5381C47682C6B4F58A623FB_130346555 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080308602 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080308602;
        // ---------- Original Method ----------
        //int res = in.read();
        //if (res < 0) {
            //throw new EndOfSourceException();
        //}
        //return res;
    }

    
}

