package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class BitString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.817 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "1395852C401E496F85701A0A9D82F003")

    public byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.817 -0400", hash_original_field = "0281DE09EFFCE9B1D9513C05E900A565", hash_generated_field = "21A6E7EB9F35414374A81AF4C0F0F758")

    public int unusedBits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.818 -0400", hash_original_method = "4AD7912E7289EAB288F9F3EC6E0E1363", hash_generated_method = "2498849A18EE20D1E2226913F5744A78")
    public  BitString(byte[] bytes, int unusedBits) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Number of unused bits MUST be in range 0-7");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("For empty bit string unused bits MUST be 0");
        } 
        this.bytes = bytes;
        this.unusedBits = unusedBits;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.818 -0400", hash_original_method = "8BDC421B437B146AA72D15C02ACDA1CF", hash_generated_method = "9DC1C01EC52ADF05D3E392EA74777A52")
    public  BitString(boolean[] values) {
        unusedBits = values.length % 8;
        int size = values.length / 8;
        bytes = new byte[size];
        {
            int i = 0;
            {
                setBit(i, values[i]);
            } 
        } 
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.819 -0400", hash_original_method = "286435896BFB2C2EB12779836BDE2B3F", hash_generated_method = "1371CCE63AF8AB34CBE1E12507A22882")
    public boolean getBit(int bit) {
        int offset = bit % 8;
        int index = bit / 8;
        addTaint(bit);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_389889187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_389889187;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.819 -0400", hash_original_method = "64B37589A76FCD4AF41D04B8A51CCBFB", hash_generated_method = "1AFAEDF9C77D153125A3380E62FA9A3C")
    public void setBit(int bit, boolean value) {
        int offset = bit % 8;
        int index = bit / 8;
        {
            bytes[index] |= SET_MASK[offset];
        } 
        {
            bytes[index] &= RESET_MASK[offset];
        } 
        addTaint(bit);
        addTaint(value);
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.820 -0400", hash_original_method = "6591A9422CBA64DB7D3ADDA84BA94652", hash_generated_method = "F23E5185BFD0E88A79A244D82ACEFB92")
    public boolean[] toBooleanArray() {
        boolean[] result = new boolean[bytes.length * 8 - unusedBits];
        {
            int i = 0;
            {
                result[i] = getBit(i);
            } 
        } 
        boolean[] var503EB2F420079C4024483971CE5EDEA8_565474614 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_565474614;
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.820 -0400", hash_original_field = "82B8116D8A84475E2750CC92DE9DE1EE", hash_generated_field = "AEC1F0C6EBA822C84ED8236810752976")

    private static final byte[] SET_MASK = { (byte) 128, 64, 32, 16, 8, 4, 2, 1 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.820 -0400", hash_original_field = "D7A1EDCFA63975E1CFA228C21847FC5C", hash_generated_field = "3E26BC5C80F6AADE58A6D4789BE0B931")

    private static final byte[] RESET_MASK = { 0x7f, (byte) 0xbf, (byte) 0xdf,
            (byte) 0xef, (byte) 0xf7, (byte) 0xfb, (byte) 0xfd, (byte) 0xfe, };
}

