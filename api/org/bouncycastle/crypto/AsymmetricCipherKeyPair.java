package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AsymmetricCipherKeyPair {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.424 -0400", hash_original_field = "45A87B85720D04AA0379CD95F227D1F6", hash_generated_field = "D38357BF57B4865D6AA01FDC8C1B6FE2")

    private CipherParameters publicParam;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.424 -0400", hash_original_field = "ABAA6FA54EFF1100CFAC58C89FB50347", hash_generated_field = "AB1F110C2888B18C0BF88D68B11659BF")

    private CipherParameters privateParam;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.425 -0400", hash_original_method = "65CF8F80B3A8FEDFD01C4D97F9AE7A45", hash_generated_method = "9254BC4FB058F17973370B2458B88E7F")
    public  AsymmetricCipherKeyPair(
        CipherParameters    publicParam,
        CipherParameters    privateParam) {
        this.publicParam = publicParam;
        this.privateParam = privateParam;
        // ---------- Original Method ----------
        //this.publicParam = publicParam;
        //this.privateParam = privateParam;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.425 -0400", hash_original_method = "3D299E49495FDEB066F19C28CA51812C", hash_generated_method = "F77A45D52C7652D99A1D4E3A9CEDA3AF")
    public CipherParameters getPublic() {
CipherParameters var96E1D8F27EFED9237328720061BDA387_1983096934 =         publicParam;
        var96E1D8F27EFED9237328720061BDA387_1983096934.addTaint(taint);
        return var96E1D8F27EFED9237328720061BDA387_1983096934;
        // ---------- Original Method ----------
        //return publicParam;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.426 -0400", hash_original_method = "E6E9A7462A68D5F39CC837AD8A41F899", hash_generated_method = "0497EF97E05F8DB115BD2089F0FFDA1F")
    public CipherParameters getPrivate() {
CipherParameters var7323AE44E1F2E5C42925B14B8B0CE986_1514421847 =         privateParam;
        var7323AE44E1F2E5C42925B14B8B0CE986_1514421847.addTaint(taint);
        return var7323AE44E1F2E5C42925B14B8B0CE986_1514421847;
        // ---------- Original Method ----------
        //return privateParam;
    }

    
}

