package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.annotations.*;





class WNafPreCompInfo implements PreCompInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.899 -0400", hash_original_field = "D6A1A1B6C8FBFB169D1DB96C4390357A", hash_generated_field = "8395F613D674E288AEA3589FC60978CE")

    private ECPoint[] preComp = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.899 -0400", hash_original_field = "C0E4B25051F24E1D1B86A270ABDD64A7", hash_generated_field = "90039C13600154AFFAAAA040DD6F7A32")

    private ECPoint twiceP = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.899 -0400", hash_original_method = "00CB459868C44A39A2332485F966568C", hash_generated_method = "00CB459868C44A39A2332485F966568C")
    public WNafPreCompInfo ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.900 -0400", hash_original_method = "D9023A1799AEA4DA2F04E7A2DE742CF8", hash_generated_method = "14B704CC2CC92426A8B14A40B6C36213")
    protected ECPoint[] getPreComp() {
ECPoint[] var859A8A67374BCAAC598F1E4AD75AF98D_1268324035 =         preComp;
        var859A8A67374BCAAC598F1E4AD75AF98D_1268324035.addTaint(taint);
        return var859A8A67374BCAAC598F1E4AD75AF98D_1268324035;
        // ---------- Original Method ----------
        //return preComp;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.900 -0400", hash_original_method = "C67EBD723D4A70E1A75A9F3EFC0063F4", hash_generated_method = "D55E81ECBEFB01EAAA7954B26FDAEF2B")
    protected void setPreComp(ECPoint[] preComp) {
        this.preComp = preComp;
        // ---------- Original Method ----------
        //this.preComp = preComp;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.901 -0400", hash_original_method = "8FA27C115153E08156D836A98C0EB130", hash_generated_method = "9A537BE3CF8128495AE689208DC05D67")
    protected ECPoint getTwiceP() {
ECPoint var832692E64C095AA15CDB96EB510D3844_844368259 =         twiceP;
        var832692E64C095AA15CDB96EB510D3844_844368259.addTaint(taint);
        return var832692E64C095AA15CDB96EB510D3844_844368259;
        // ---------- Original Method ----------
        //return twiceP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.901 -0400", hash_original_method = "C2D01FDCF5EDDC5BF3E92E30C339DC39", hash_generated_method = "2CF280202E0FED6BCCF80174D23321DC")
    protected void setTwiceP(ECPoint twiceThis) {
        this.twiceP = twiceThis;
        // ---------- Original Method ----------
        //this.twiceP = twiceThis;
    }

    
}

