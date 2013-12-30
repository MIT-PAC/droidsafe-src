package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class IccIoResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.902 -0500", hash_original_field = "81A80240F451864639A7DEC71565285B", hash_generated_field = "605D00358F6732BF4A4D044EA247A970")

    public int sw1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.905 -0500", hash_original_field = "EB2E780FA9118E8754B1E57CA941C121", hash_generated_field = "3291FE8B1F0E4F6843EB8729B855E0A4")

    public int sw2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.908 -0500", hash_original_field = "379AC6F271B60152FF88CC8F1BD43D4B", hash_generated_field = "85C99161735D908FB014CA702C49895B")


    public byte[] payload;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.910 -0500", hash_original_method = "FC114C268C65B1E20AA18C3590A39E31", hash_generated_method = "925FEEBC1EDD56B4B91027FB6C84D7A6")
    
public IccIoResult(int sw1, int sw2, byte[] payload) {
        this.sw1 = sw1;
        this.sw2 = sw2;
        this.payload = payload;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.913 -0500", hash_original_method = "ECAE0DFB5EB8DE1F7EC625CCCC39CE4E", hash_generated_method = "D8F2CB6B3E48709CE789CE4F7D3EAEAB")
    
public IccIoResult(int sw1, int sw2, String hexString) {
        this(sw1, sw2, IccUtils.hexStringToBytes(hexString));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.916 -0500", hash_original_method = "C2E2D21A49FBAEB09CAD48E279230B17", hash_generated_method = "5F7907B14DF5087E1E3A698D5E1EBBE7")
    
public String toString() {
        return "IccIoResponse sw1:0x" + Integer.toHexString(sw1) + " sw2:0x"
                + Integer.toHexString(sw2);
    }

    /**
     * true if this operation was successful
     * See GSM 11.11 Section 9.4
     * (the fun stuff is absent in 51.011)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.919 -0500", hash_original_method = "E45E4CA02C1498571B14F8EF02CBA542", hash_generated_method = "E40267720A2ECD6C2D02EAE67D65E7F5")
    
public boolean success() {
        return sw1 == 0x90 || sw1 == 0x91 || sw1 == 0x9e || sw1 == 0x9f;
    }

    /**
     * Returns exception on error or null if success
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.921 -0500", hash_original_method = "6314A49369EA2E2C83A84515E57327FB", hash_generated_method = "FEE8C406F8DB898558F7556FFBD1BFDB")
    
public IccException getException() {
        if (success()) return null;

        switch (sw1) {
            case 0x94:
                if (sw2 == 0x08) {
                    return new IccFileTypeMismatch();
                } else {
                    return new IccFileNotFound();
                }
            default:
                return new IccException("sw1:" + sw1 + " sw2:" + sw2);
        }
    }

    
}

