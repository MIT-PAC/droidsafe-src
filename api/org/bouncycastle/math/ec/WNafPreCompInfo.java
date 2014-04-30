package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class WNafPreCompInfo implements PreCompInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.646 -0500", hash_original_field = "62ACEF08F2D2C038DD15DFD492CE20D9", hash_generated_field = "8395F613D674E288AEA3589FC60978CE")

    private ECPoint[] preComp = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.648 -0500", hash_original_field = "6903454F78A1AAA557C91EFF9001243D", hash_generated_field = "90039C13600154AFFAAAA040DD6F7A32")

    private ECPoint twiceP = null;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.899 -0400", hash_original_method = "00CB459868C44A39A2332485F966568C", hash_generated_method = "00CB459868C44A39A2332485F966568C")
    public WNafPreCompInfo ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.651 -0500", hash_original_method = "D9023A1799AEA4DA2F04E7A2DE742CF8", hash_generated_method = "1EF723948639D5C09C2A1800E6B9136D")
    
protected ECPoint[] getPreComp()
    {
        return preComp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.653 -0500", hash_original_method = "C67EBD723D4A70E1A75A9F3EFC0063F4", hash_generated_method = "4511C6A15154383722005EFDDE77DEFF")
    
protected void setPreComp(ECPoint[] preComp)
    {
        this.preComp = preComp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.656 -0500", hash_original_method = "8FA27C115153E08156D836A98C0EB130", hash_generated_method = "BD5612BBF858D1B951CF71FE7047833D")
    
protected ECPoint getTwiceP()
    {
        return twiceP;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.658 -0500", hash_original_method = "C2D01FDCF5EDDC5BF3E92E30C339DC39", hash_generated_method = "5E5F9623B1B13147FB3324F3D619B8C0")
    
protected void setTwiceP(ECPoint twiceThis)
    {
        this.twiceP = twiceThis;
    }
    
}

