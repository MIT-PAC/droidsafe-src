package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AsymmetricCipherKeyPair {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.772 -0400", hash_original_field = "45A87B85720D04AA0379CD95F227D1F6", hash_generated_field = "D38357BF57B4865D6AA01FDC8C1B6FE2")

    private CipherParameters publicParam;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.773 -0400", hash_original_field = "ABAA6FA54EFF1100CFAC58C89FB50347", hash_generated_field = "AB1F110C2888B18C0BF88D68B11659BF")

    private CipherParameters privateParam;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.774 -0400", hash_original_method = "65CF8F80B3A8FEDFD01C4D97F9AE7A45", hash_generated_method = "9254BC4FB058F17973370B2458B88E7F")
    public  AsymmetricCipherKeyPair(
        CipherParameters    publicParam,
        CipherParameters    privateParam) {
        this.publicParam = publicParam;
        this.privateParam = privateParam;
        // ---------- Original Method ----------
        //this.publicParam = publicParam;
        //this.privateParam = privateParam;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.774 -0400", hash_original_method = "3D299E49495FDEB066F19C28CA51812C", hash_generated_method = "8BB31CD4A80B288830BC5187222911D7")
    public CipherParameters getPublic() {
CipherParameters var96E1D8F27EFED9237328720061BDA387_2011869511 =         publicParam;
        var96E1D8F27EFED9237328720061BDA387_2011869511.addTaint(taint);
        return var96E1D8F27EFED9237328720061BDA387_2011869511;
        // ---------- Original Method ----------
        //return publicParam;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.774 -0400", hash_original_method = "E6E9A7462A68D5F39CC837AD8A41F899", hash_generated_method = "3D99B7C01FE2FF345B68E1102278CE00")
    public CipherParameters getPrivate() {
CipherParameters var7323AE44E1F2E5C42925B14B8B0CE986_1202910857 =         privateParam;
        var7323AE44E1F2E5C42925B14B8B0CE986_1202910857.addTaint(taint);
        return var7323AE44E1F2E5C42925B14B8B0CE986_1202910857;
        // ---------- Original Method ----------
        //return privateParam;
    }

    
}

