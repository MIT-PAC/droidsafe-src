package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class SmsAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.864 -0400", hash_original_field = "51194287DEA464E6BE6D483240E1DBA0", hash_generated_field = "5E46769E3138C30BA726827EC521CE4C")

    public int ton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.864 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "94F51CF62708E9C4165D74975525630C")

    public String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.864 -0400", hash_original_field = "721A54522517C26820622B82AEB56C71", hash_generated_field = "F4D84AFDC233D2206E605DACECAD70BE")

    public byte[] origBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.864 -0400", hash_original_method = "B8327960B9CD15772A1562BB89169838", hash_generated_method = "B8327960B9CD15772A1562BB89169838")
    public SmsAddress ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.865 -0400", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "B9927172AA47F54BE0D99235F50888B7")
    public String getAddressString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1850055276 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1850055276 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1850055276.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1850055276;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.866 -0400", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "71497536A5072CBA97F756E444C167EB")
    public boolean isAlphanumeric() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1625470722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1625470722;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.866 -0400", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "AC726019DF782906A02E228E9551FECD")
    public boolean isNetworkSpecific() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265942568 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265942568;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.866 -0400", hash_original_method = "62AA39399884507545860A1B63B7D677", hash_generated_method = "745F9A9FD1D3C6083D834A3AEF6E6329")
    public boolean couldBeEmailGateway() {
        boolean var5F8CA1C53D86A02AC2A1F17461AE53DF_1960268006 = (address.length() <= 4);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725993145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725993145;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.867 -0400", hash_original_field = "45D187857CA75B5EF5FC72C5041C3830", hash_generated_field = "360D3E600C2C24EDB5C4BA32F6D57F29")

    public static final int TON_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.867 -0400", hash_original_field = "4A877ADAC412EA44209CB47458FF04C9", hash_generated_field = "7C4DD7039CD935B4355F3220600CCA84")

    public static final int TON_INTERNATIONAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.867 -0400", hash_original_field = "2631BD40AA0ACA64A6234476E49BC054", hash_generated_field = "47E9E4937C9A711F1A1BC88F0FCCD413")

    public static final int TON_NATIONAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.867 -0400", hash_original_field = "9F8A07FF2BB063521A350A657E82CE87", hash_generated_field = "14594A4D7ED15988204D1F95A3FD6427")

    public static final int TON_NETWORK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.867 -0400", hash_original_field = "D788BAE1812E880B94F556245CAFEA45", hash_generated_field = "87F6B3B2B6CFA7E2EC850536FE8A80CD")

    public static final int TON_SUBSCRIBER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.867 -0400", hash_original_field = "09B7C836A3146A803A3891F1D4676C72", hash_generated_field = "3D86FAA129E3D7F7E09EF64145E92966")

    public static final int TON_ALPHANUMERIC = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.867 -0400", hash_original_field = "6787CFA09866136FC4171A11B96956DB", hash_generated_field = "D3D6BEF2BB43AEB214BFC3146F4F95F4")

    public static final int TON_ABBREVIATED = 6;
}

