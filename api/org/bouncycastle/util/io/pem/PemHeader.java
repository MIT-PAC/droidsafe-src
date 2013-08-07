package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.annotations.*;





public class PemHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.376 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.376 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.377 -0400", hash_original_method = "4509DA5CCC6D5B482BEA6C1D7CD04168", hash_generated_method = "7833D43EC03F2988C72B201F1918A3BB")
    public  PemHeader(String name, String value) {
        this.name = name;
        this.value = value;
        // ---------- Original Method ----------
        //this.name = name;
        //this.value = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.377 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "232E00CBFE0CDB241F683F3FC2906E82")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_392665741 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_392665741.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_392665741;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.378 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "0775103BBF81DAB0129420956D6AE13E")
    public String getValue() {
String varAF280DA2BC37D8BE783D8499160168DE_241523726 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_241523726.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_241523726;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.378 -0400", hash_original_method = "D2F99D4FA1F9F9DCD18FFC2807839B4D", hash_generated_method = "BD8A7C116FCA6EBC130CB8715765BB1A")
    public int hashCode() {
        int varB55AA251EA7EFA452366B12918988F86_1605988791 = (getHashCode(this.name) + 31 * getHashCode(this.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937631041 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937631041;
        // ---------- Original Method ----------
        //return getHashCode(this.name) + 31 * getHashCode(this.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.379 -0400", hash_original_method = "008350332C23D1093274CD2597D3DC3D", hash_generated_method = "262B7C8B200C220499836D78E6869BA3")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof PemHeader))        
        {
            boolean var68934A3E9455FA72420237EB05902327_129712187 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515119691 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515119691;
        } //End block
        PemHeader other = (PemHeader)o;
        boolean varE30BD5D45ADC9EC6D45B3A1491931CDD_324921451 = (other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396642140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396642140;
        // ---------- Original Method ----------
        //if (!(o instanceof PemHeader))
        //{
            //return false;
        //}
        //PemHeader other = (PemHeader)o;
        //return other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.380 -0400", hash_original_method = "552BFCCB5F897360ADAD8A79D56E72F9", hash_generated_method = "2AED66DD37DE2FC55F5DA5540BD23A43")
    private int getHashCode(String s) {
        addTaint(s.getTaint());
        if(s == null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1470393444 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325316457 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325316457;
        } //End block
        int var4C8AC03F4D998D80C4FDFCF9D8EE7706_598100665 = (s.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679199364 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679199364;
        // ---------- Original Method ----------
        //if (s == null)
        //{
            //return 1;
        //}
        //return s.hashCode();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.380 -0400", hash_original_method = "56C7E9071A8414DCCD1359B9AFE0CC30", hash_generated_method = "53C44651438D46A37EEA001FE298D39E")
    private boolean isEqual(String s1, String s2) {
        addTaint(s2.getTaint());
        addTaint(s1.getTaint());
        if(s1 == s2)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1524233374 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298295196 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_298295196;
        } //End block
        if(s1 == null || s2 == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1194407894 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935759778 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_935759778;
        } //End block
        boolean var1C7B33A408F214F5B9F1DA421AC799BC_114620863 = (s1.equals(s2));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337103752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337103752;
        // ---------- Original Method ----------
        //if (s1 == s2)
        //{
            //return true;
        //}
        //if (s1 == null || s2 == null)
        //{
            //return false;
        //}
        //return s1.equals(s2);
    }

    
}

