package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class WNafPreCompInfo implements PreCompInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.432 -0400", hash_original_field = "D6A1A1B6C8FBFB169D1DB96C4390357A", hash_generated_field = "8395F613D674E288AEA3589FC60978CE")

    private ECPoint[] preComp = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.432 -0400", hash_original_field = "C0E4B25051F24E1D1B86A270ABDD64A7", hash_generated_field = "90039C13600154AFFAAAA040DD6F7A32")

    private ECPoint twiceP = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.433 -0400", hash_original_method = "00CB459868C44A39A2332485F966568C", hash_generated_method = "00CB459868C44A39A2332485F966568C")
    public WNafPreCompInfo ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.433 -0400", hash_original_method = "D9023A1799AEA4DA2F04E7A2DE742CF8", hash_generated_method = "167B5B1B03E7458D2B2EFDD2842B7897")
    protected ECPoint[] getPreComp() {
        ECPoint[] varB4EAC82CA7396A68D541C85D26508E83_1244898456 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1244898456 = preComp;
        varB4EAC82CA7396A68D541C85D26508E83_1244898456.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1244898456;
        // ---------- Original Method ----------
        //return preComp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.434 -0400", hash_original_method = "C67EBD723D4A70E1A75A9F3EFC0063F4", hash_generated_method = "D55E81ECBEFB01EAAA7954B26FDAEF2B")
    protected void setPreComp(ECPoint[] preComp) {
        this.preComp = preComp;
        // ---------- Original Method ----------
        //this.preComp = preComp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.435 -0400", hash_original_method = "8FA27C115153E08156D836A98C0EB130", hash_generated_method = "4A87FBA544129C16B6D5F78C093CB06C")
    protected ECPoint getTwiceP() {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_792469525 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_792469525 = twiceP;
        varB4EAC82CA7396A68D541C85D26508E83_792469525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_792469525;
        // ---------- Original Method ----------
        //return twiceP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.436 -0400", hash_original_method = "C2D01FDCF5EDDC5BF3E92E30C339DC39", hash_generated_method = "2CF280202E0FED6BCCF80174D23321DC")
    protected void setTwiceP(ECPoint twiceThis) {
        this.twiceP = twiceThis;
        // ---------- Original Method ----------
        //this.twiceP = twiceThis;
    }

    
}

