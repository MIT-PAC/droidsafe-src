package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class BitString {
    private static final byte[] SET_MASK = { (byte) 128, 64, 32, 16, 8, 4, 2, 1 };
    private static final byte[] RESET_MASK = { 0x7f, (byte) 0xbf, (byte) 0xdf,
            (byte) 0xef, (byte) 0xf7, (byte) 0xfb, (byte) 0xfd, (byte) 0xfe, };
    public final byte[] bytes;
    public final int unusedBits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.706 -0400", hash_original_method = "4AD7912E7289EAB288F9F3EC6E0E1363", hash_generated_method = "D5452444FE8089E9CD2B0442D059B1A4")
    @DSModeled(DSC.SAFE)
    public BitString(byte[] bytes, int unusedBits) {
        dsTaint.addTaint(bytes);
        dsTaint.addTaint(unusedBits);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Number of unused bits MUST be in range 0-7");
        } //End block
        {
            throw new IllegalArgumentException("For empty bit string unused bits MUST be 0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.706 -0400", hash_original_method = "8BDC421B437B146AA72D15C02ACDA1CF", hash_generated_method = "52A5FE97F98F47F6C818A419F90A8B37")
    @DSModeled(DSC.SAFE)
    public BitString(boolean[] values) {
        dsTaint.addTaint(values);
        unusedBits = values.length % 8;
        int size;
        size = values.length / 8;
        {
            size++;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.706 -0400", hash_original_method = "286435896BFB2C2EB12779836BDE2B3F", hash_generated_method = "B11299C73CF150F359FC8875F3F51B18")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.706 -0400", hash_original_method = "64B37589A76FCD4AF41D04B8A51CCBFB", hash_generated_method = "7EA3EE52A05BD6682046B021CB9CAB43")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.707 -0400", hash_original_method = "6591A9422CBA64DB7D3ADDA84BA94652", hash_generated_method = "90FF0C4F87CEF5DBFDD808DED2DBE208")
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

    
}


