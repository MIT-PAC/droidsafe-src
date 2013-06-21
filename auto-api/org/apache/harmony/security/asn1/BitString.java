package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class BitString {
    public byte[] bytes;
    public int unusedBits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.093 -0400", hash_original_method = "4AD7912E7289EAB288F9F3EC6E0E1363", hash_generated_method = "5406418085F383FAB276B034B1CC9EEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitString(byte[] bytes, int unusedBits) {
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(unusedBits);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Number of unused bits MUST be in range 0-7");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("For empty bit string unused bits MUST be 0");
        } //End block
        // ---------- Original Method ----------
        //if (unusedBits < 0 || unusedBits > 7) {
            //throw new IllegalArgumentException("Number of unused bits MUST be in range 0-7");
        //}
        //if (bytes.length == 0 && unusedBits != 0) {
            //throw new IllegalArgumentException("For empty bit string unused bits MUST be 0");
        //}
        //this.bytes = bytes;
        //this.unusedBits = unusedBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.093 -0400", hash_original_method = "8BDC421B437B146AA72D15C02ACDA1CF", hash_generated_method = "2BA54163CD8BB2A61ED213806AC5F255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitString(boolean[] values) {
        dsTaint.addTaint(values[0]);
        unusedBits = values.length % 8;
        int size;
        size = values.length / 8;
        bytes = new byte[size];
        {
            int i;
            i = 0;
            {
                setBit(i, values[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //unusedBits = values.length % 8;
        //int size = values.length / 8;
        //if (unusedBits != 0) {
            //size++;
        //}
        //bytes = new byte[size];
        //for (int i = 0; i < values.length; i++) {
            //setBit(i, values[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.094 -0400", hash_original_method = "286435896BFB2C2EB12779836BDE2B3F", hash_generated_method = "ACFDB759932B2CB1265FB4B794867610")
    @DSModeled(DSC.SAFE)
    public boolean getBit(int bit) {
        dsTaint.addTaint(bit);
        int offset;
        offset = bit % 8;
        int index;
        index = bit / 8;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int offset = bit % 8;
        //int index = bit / 8;
        //return (bytes[index] & SET_MASK[offset]) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.094 -0400", hash_original_method = "64B37589A76FCD4AF41D04B8A51CCBFB", hash_generated_method = "262D05F784C77BA148048497634B2021")
    @DSModeled(DSC.SAFE)
    public void setBit(int bit, boolean value) {
        dsTaint.addTaint(bit);
        dsTaint.addTaint(value);
        int offset;
        offset = bit % 8;
        int index;
        index = bit / 8;
        {
            bytes[index] |= SET_MASK[offset];
        } //End block
        {
            bytes[index] &= RESET_MASK[offset];
        } //End block
        // ---------- Original Method ----------
        //int offset = bit % 8;
        //int index = bit / 8;
        //if (value) {
            //bytes[index] |= SET_MASK[offset];
        //} else {
            //bytes[index] &= RESET_MASK[offset];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.094 -0400", hash_original_method = "6591A9422CBA64DB7D3ADDA84BA94652", hash_generated_method = "83E299D1778040430249E177448E1C6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] toBooleanArray() {
        boolean[] result;
        result = new boolean[bytes.length * 8 - unusedBits];
        {
            int i;
            i = 0;
            {
                result[i] = getBit(i);
            } //End block
        } //End collapsed parenthetic
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //boolean[] result = new boolean[bytes.length * 8 - unusedBits];
        //for (int i = 0; i < result.length; i++) {
            //result[i] = getBit(i);
        //}
        //return result;
    }

    
    private static final byte[] SET_MASK = { (byte) 128, 64, 32, 16, 8, 4, 2, 1 };
    private static final byte[] RESET_MASK = { 0x7f, (byte) 0xbf, (byte) 0xdf,
            (byte) 0xef, (byte) 0xf7, (byte) 0xfb, (byte) 0xfd, (byte) 0xfe, };
}

