package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class WNafPreCompInfo implements PreCompInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.658 -0400", hash_original_field = "D6A1A1B6C8FBFB169D1DB96C4390357A", hash_generated_field = "8395F613D674E288AEA3589FC60978CE")

    private ECPoint[] preComp = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.659 -0400", hash_original_field = "C0E4B25051F24E1D1B86A270ABDD64A7", hash_generated_field = "90039C13600154AFFAAAA040DD6F7A32")

    private ECPoint twiceP = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.659 -0400", hash_original_method = "00CB459868C44A39A2332485F966568C", hash_generated_method = "00CB459868C44A39A2332485F966568C")
    public WNafPreCompInfo ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.659 -0400", hash_original_method = "D9023A1799AEA4DA2F04E7A2DE742CF8", hash_generated_method = "6D02FFC0FEA7E18109EE81C15448776B")
    protected ECPoint[] getPreComp() {
ECPoint[] var859A8A67374BCAAC598F1E4AD75AF98D_988559029 =         preComp;
        var859A8A67374BCAAC598F1E4AD75AF98D_988559029.addTaint(taint);
        return var859A8A67374BCAAC598F1E4AD75AF98D_988559029;
        // ---------- Original Method ----------
        //return preComp;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.660 -0400", hash_original_method = "C67EBD723D4A70E1A75A9F3EFC0063F4", hash_generated_method = "D55E81ECBEFB01EAAA7954B26FDAEF2B")
    protected void setPreComp(ECPoint[] preComp) {
        this.preComp = preComp;
        // ---------- Original Method ----------
        //this.preComp = preComp;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.660 -0400", hash_original_method = "8FA27C115153E08156D836A98C0EB130", hash_generated_method = "4F27B70BAF3C435D4558BD66F5C8A8FA")
    protected ECPoint getTwiceP() {
ECPoint var832692E64C095AA15CDB96EB510D3844_265317886 =         twiceP;
        var832692E64C095AA15CDB96EB510D3844_265317886.addTaint(taint);
        return var832692E64C095AA15CDB96EB510D3844_265317886;
        // ---------- Original Method ----------
        //return twiceP;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.661 -0400", hash_original_method = "C2D01FDCF5EDDC5BF3E92E30C339DC39", hash_generated_method = "2CF280202E0FED6BCCF80174D23321DC")
    protected void setTwiceP(ECPoint twiceThis) {
        this.twiceP = twiceThis;
        // ---------- Original Method ----------
        //this.twiceP = twiceThis;
    }

    
}

