package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class BitString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.974 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "1395852C401E496F85701A0A9D82F003")

    public byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.974 -0400", hash_original_field = "0281DE09EFFCE9B1D9513C05E900A565", hash_generated_field = "21A6E7EB9F35414374A81AF4C0F0F758")

    public int unusedBits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.975 -0400", hash_original_method = "4AD7912E7289EAB288F9F3EC6E0E1363", hash_generated_method = "CD65A732ECBC86D3F443EC2DBF9D1664")
    public  BitString(byte[] bytes, int unusedBits) {
    if(unusedBits < 0 || unusedBits > 7)        
        {
            IllegalArgumentException var08120D9B6ADD6481A4C536E6FEC143C4_37241664 = new IllegalArgumentException("Number of unused bits MUST be in range 0-7");
            var08120D9B6ADD6481A4C536E6FEC143C4_37241664.addTaint(taint);
            throw var08120D9B6ADD6481A4C536E6FEC143C4_37241664;
        } 
    if(bytes.length == 0 && unusedBits != 0)        
        {
            IllegalArgumentException var91B82456DE87D1E4499172BB4FAE44C7_1106829158 = new IllegalArgumentException("For empty bit string unused bits MUST be 0");
            var91B82456DE87D1E4499172BB4FAE44C7_1106829158.addTaint(taint);
            throw var91B82456DE87D1E4499172BB4FAE44C7_1106829158;
        } 
        this.bytes = bytes;
        this.unusedBits = unusedBits;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.976 -0400", hash_original_method = "8BDC421B437B146AA72D15C02ACDA1CF", hash_generated_method = "D5B08642D98F005EEC07E4AB2AB29E63")
    public  BitString(boolean[] values) {
        unusedBits = values.length % 8;
        int size = values.length / 8;
    if(unusedBits != 0)        
        {
            size++;
        } 
        bytes = new byte[size];
for(int i = 0;i < values.length;i++)
        {
            setBit(i, values[i]);
        } 
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.976 -0400", hash_original_method = "286435896BFB2C2EB12779836BDE2B3F", hash_generated_method = "1BEEACF60339FC3E0C38A049DAE54033")
    public boolean getBit(int bit) {
        addTaint(bit);
        int offset = bit % 8;
        int index = bit / 8;
        boolean var920ACE372C3491BDE0ED7B5D71D8B806_1357891665 = ((bytes[index] & SET_MASK[offset]) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2122093045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2122093045;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.977 -0400", hash_original_method = "64B37589A76FCD4AF41D04B8A51CCBFB", hash_generated_method = "A9CE8AE95D58FDCF2BD1F021CC72529C")
    public void setBit(int bit, boolean value) {
        addTaint(value);
        addTaint(bit);
        int offset = bit % 8;
        int index = bit / 8;
    if(value)        
        {
            bytes[index] |= SET_MASK[offset];
        } 
        else
        {
            bytes[index] &= RESET_MASK[offset];
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.977 -0400", hash_original_method = "6591A9422CBA64DB7D3ADDA84BA94652", hash_generated_method = "056CC2A12CB928EECBE9A60C4C63FA3A")
    public boolean[] toBooleanArray() {
        boolean[] result = new boolean[bytes.length * 8 - unusedBits];
for(int i = 0;i < result.length;i++)
        {
            result[i] = getBit(i);
        } 
        boolean[] varB4A88417B3D0170D754C647C30B7216A_765597627 = (result);
                boolean[] var503EB2F420079C4024483971CE5EDEA8_702121224 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_702121224;
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.977 -0400", hash_original_field = "82B8116D8A84475E2750CC92DE9DE1EE", hash_generated_field = "AEC1F0C6EBA822C84ED8236810752976")

    private static final byte[] SET_MASK = { (byte) 128, 64, 32, 16, 8, 4, 2, 1 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.977 -0400", hash_original_field = "D7A1EDCFA63975E1CFA228C21847FC5C", hash_generated_field = "3E26BC5C80F6AADE58A6D4789BE0B931")

    private static final byte[] RESET_MASK = { 0x7f, (byte) 0xbf, (byte) 0xdf,
            (byte) 0xef, (byte) 0xf7, (byte) 0xfb, (byte) 0xfd, (byte) 0xfe, };
}

