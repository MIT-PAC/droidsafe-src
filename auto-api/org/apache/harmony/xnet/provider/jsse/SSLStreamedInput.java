package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class SSLStreamedInput extends SSLInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.101 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.102 -0400", hash_original_method = "2603FDEDA68AA1C899FD148F0716545A", hash_generated_method = "85D6DFF45943A1150F3CC11B41730323")
    public  SSLStreamedInput(InputStream in) {
        this.in = in;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.102 -0400", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "B82E04CC4D5544D1A40123C384902056")
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_1591547780 = (in.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237075287 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237075287;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.103 -0400", hash_original_method = "944A08161D308B286B46AD616F2EEC05", hash_generated_method = "9246710F21725C1C1B9C7EEC677292E7")
    @Override
    public int read() throws IOException {
        int res = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EndOfSourceException();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166926118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166926118;
        
        
        
            
        
        
    }

    
}

