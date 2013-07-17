package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class BitString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.856 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "1395852C401E496F85701A0A9D82F003")

    public byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.857 -0400", hash_original_field = "0281DE09EFFCE9B1D9513C05E900A565", hash_generated_field = "21A6E7EB9F35414374A81AF4C0F0F758")

    public int unusedBits;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.857 -0400", hash_original_method = "4AD7912E7289EAB288F9F3EC6E0E1363", hash_generated_method = "D3904DEC1DFAD8FE38654D626D099A8A")
    public  BitString(byte[] bytes, int unusedBits) {
        if(unusedBits < 0 || unusedBits > 7)        
        {
            IllegalArgumentException var08120D9B6ADD6481A4C536E6FEC143C4_419116646 = new IllegalArgumentException("Number of unused bits MUST be in range 0-7");
            var08120D9B6ADD6481A4C536E6FEC143C4_419116646.addTaint(taint);
            throw var08120D9B6ADD6481A4C536E6FEC143C4_419116646;
        } //End block
        if(bytes.length == 0 && unusedBits != 0)        
        {
            IllegalArgumentException var91B82456DE87D1E4499172BB4FAE44C7_1900842391 = new IllegalArgumentException("For empty bit string unused bits MUST be 0");
            var91B82456DE87D1E4499172BB4FAE44C7_1900842391.addTaint(taint);
            throw var91B82456DE87D1E4499172BB4FAE44C7_1900842391;
        } //End block
        this.bytes = bytes;
        this.unusedBits = unusedBits;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.859 -0400", hash_original_method = "8BDC421B437B146AA72D15C02ACDA1CF", hash_generated_method = "D5B08642D98F005EEC07E4AB2AB29E63")
    public  BitString(boolean[] values) {
        unusedBits = values.length % 8;
        int size = values.length / 8;
        if(unusedBits != 0)        
        {
            size++;
        } //End block
        bytes = new byte[size];
for(int i = 0;i < values.length;i++)
        {
            setBit(i, values[i]);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.860 -0400", hash_original_method = "286435896BFB2C2EB12779836BDE2B3F", hash_generated_method = "2DD21C153367E3ECD3951D8A35F79422")
    public boolean getBit(int bit) {
        addTaint(bit);
        int offset = bit % 8;
        int index = bit / 8;
        boolean var920ACE372C3491BDE0ED7B5D71D8B806_1170605622 = ((bytes[index] & SET_MASK[offset]) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584081415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584081415;
        // ---------- Original Method ----------
        //int offset = bit % 8;
        //int index = bit / 8;
        //return (bytes[index] & SET_MASK[offset]) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.861 -0400", hash_original_method = "64B37589A76FCD4AF41D04B8A51CCBFB", hash_generated_method = "A9CE8AE95D58FDCF2BD1F021CC72529C")
    public void setBit(int bit, boolean value) {
        addTaint(value);
        addTaint(bit);
        int offset = bit % 8;
        int index = bit / 8;
        if(value)        
        {
            bytes[index] |= SET_MASK[offset];
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.862 -0400", hash_original_method = "6591A9422CBA64DB7D3ADDA84BA94652", hash_generated_method = "32FCA02FC674EB58B51640853B2E8C13")
    public boolean[] toBooleanArray() {
        boolean[] result = new boolean[bytes.length * 8 - unusedBits];
for(int i = 0;i < result.length;i++)
        {
            result[i] = getBit(i);
        } //End block
        boolean[] varB4A88417B3D0170D754C647C30B7216A_1400176075 = (result);
                boolean[] var503EB2F420079C4024483971CE5EDEA8_451554419 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_451554419;
        // ---------- Original Method ----------
        //boolean[] result = new boolean[bytes.length * 8 - unusedBits];
        //for (int i = 0; i < result.length; i++) {
            //result[i] = getBit(i);
        //}
        //return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.863 -0400", hash_original_field = "82B8116D8A84475E2750CC92DE9DE1EE", hash_generated_field = "AEC1F0C6EBA822C84ED8236810752976")

    private static final byte[] SET_MASK = { (byte) 128, 64, 32, 16, 8, 4, 2, 1 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.863 -0400", hash_original_field = "D7A1EDCFA63975E1CFA228C21847FC5C", hash_generated_field = "3E26BC5C80F6AADE58A6D4789BE0B931")

    private static final byte[] RESET_MASK = { 0x7f, (byte) 0xbf, (byte) 0xdf,
            (byte) 0xef, (byte) 0xf7, (byte) 0xfb, (byte) 0xfd, (byte) 0xfe, };
}

