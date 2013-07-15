package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.InputStream;

abstract class LimitedInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.893 -0400", hash_original_field = "678DB741D1B48B4477A490AEDCFD1EC9", hash_generated_field = "274538152B8B82436D94F9F1A496F39B")

    protected InputStream _in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.893 -0400", hash_original_field = "21B59360B06F124AC143A9061C12E7FA", hash_generated_field = "CC1F761CCB044A54710FD1E5F22ED61A")

    private int _limit;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.893 -0400", hash_original_method = "0D8C2EADFFB47C1CBCA5E0CC8CF6BC20", hash_generated_method = "055279600C3D6430555A03116D898451")
      LimitedInputStream(
        InputStream in,
        int         limit) {
        this._in = in;
        this._limit = limit;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.893 -0400", hash_original_method = "40872598AE6AA3CD657ADA29CC622AC7", hash_generated_method = "FB088EB84283B279D2743645A9AC4B58")
     int getRemaining() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959727913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959727913;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.893 -0400", hash_original_method = "C0E0722B99096B33B184C9FBB5E52E11", hash_generated_method = "9060C0B632F1AC12AA0911861BC8A8BB")
    protected void setParentEofDetect(boolean on) {
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(on);
        } 
        addTaint(on);
        
        
        
            
        
    }

    
}

