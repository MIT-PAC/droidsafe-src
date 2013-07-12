package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PemHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.586 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.586 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.587 -0400", hash_original_method = "4509DA5CCC6D5B482BEA6C1D7CD04168", hash_generated_method = "7833D43EC03F2988C72B201F1918A3BB")
    public  PemHeader(String name, String value) {
        this.name = name;
        this.value = value;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.588 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "19C6BE330E10438D6873BD738CB66F11")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1419674450 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1419674450.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1419674450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.588 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "B64A3F4D1A246F8DFB40911EDC73B4DC")
    public String getValue() {
String varAF280DA2BC37D8BE783D8499160168DE_72393627 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_72393627.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_72393627;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.588 -0400", hash_original_method = "D2F99D4FA1F9F9DCD18FFC2807839B4D", hash_generated_method = "E0E7F9CEAD8A1F8EB83009ADFBA25354")
    public int hashCode() {
        int varB55AA251EA7EFA452366B12918988F86_1014793658 = (getHashCode(this.name) + 31 * getHashCode(this.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719925341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719925341;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.588 -0400", hash_original_method = "008350332C23D1093274CD2597D3DC3D", hash_generated_method = "66D5E868DA8E812F6FCC7BD024ACD6DD")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof PemHeader))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1212327293 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472834675 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472834675;
        } 
        PemHeader other = (PemHeader)o;
        boolean varE30BD5D45ADC9EC6D45B3A1491931CDD_1764260292 = (other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546545287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546545287;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.589 -0400", hash_original_method = "552BFCCB5F897360ADAD8A79D56E72F9", hash_generated_method = "5986FAF01822CCBEEBA0DC0975EDFF29")
    private int getHashCode(String s) {
        addTaint(s.getTaint());
    if(s == null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1306374642 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_252395419 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_252395419;
        } 
        int var4C8AC03F4D998D80C4FDFCF9D8EE7706_494201083 = (s.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681540135 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681540135;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.589 -0400", hash_original_method = "56C7E9071A8414DCCD1359B9AFE0CC30", hash_generated_method = "CF5947776FDC186E2BE239C6D798070B")
    private boolean isEqual(String s1, String s2) {
        addTaint(s2.getTaint());
        addTaint(s1.getTaint());
    if(s1 == s2)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_161992750 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_712503316 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_712503316;
        } 
    if(s1 == null || s2 == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1988133871 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_84458552 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_84458552;
        } 
        boolean var1C7B33A408F214F5B9F1DA421AC799BC_720684522 = (s1.equals(s2));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1744583380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1744583380;
        
        
        
            
        
        
        
            
        
        
    }

    
}

