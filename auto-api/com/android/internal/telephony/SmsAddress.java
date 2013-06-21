package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class SmsAddress {
    public int ton;
    public String address;
    public byte[] origBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.428 -0400", hash_original_method = "78E5E6B46C4E6D0A08BD5178F0930DE8", hash_generated_method = "78E5E6B46C4E6D0A08BD5178F0930DE8")
        public SmsAddress ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.428 -0400", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "B5EDFF72FFAD56D4F84712449E3063E9")
    @DSModeled(DSC.SAFE)
    public String getAddressString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.428 -0400", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "CEDE5334FB33C91BAB0D9C952428ADAD")
    @DSModeled(DSC.SAFE)
    public boolean isAlphanumeric() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ton == TON_ALPHANUMERIC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.428 -0400", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "BA85489B178F5808CF835EC96833DBFC")
    @DSModeled(DSC.SAFE)
    public boolean isNetworkSpecific() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ton == TON_NETWORK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.428 -0400", hash_original_method = "62AA39399884507545860A1B63B7D677", hash_generated_method = "332F9B6F3DA323E0633302C98178E8A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean couldBeEmailGateway() {
        boolean var5F8CA1C53D86A02AC2A1F17461AE53DF_721025 = (address.length() <= 4);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return address.length() <= 4;
    }

    
    public static final int TON_UNKNOWN = 0;
    public static final int TON_INTERNATIONAL = 1;
    public static final int TON_NATIONAL = 2;
    public static final int TON_NETWORK = 3;
    public static final int TON_SUBSCRIBER = 4;
    public static final int TON_ALPHANUMERIC = 5;
    public static final int TON_ABBREVIATED = 6;
}

