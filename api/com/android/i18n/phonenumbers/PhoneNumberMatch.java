package com.android.i18n.phonenumbers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Arrays;

public final class PhoneNumberMatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.433 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

    private int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.433 -0400", hash_original_field = "86C8EF5116F9F2D53104EB36EE5FEBD4", hash_generated_field = "6456B20A1E1CCB2639ECC7BC4AF85249")

    private String rawString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.433 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "DFCB3B49B2D60B2C16CC443A648E9AFE")

    private PhoneNumber number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.434 -0400", hash_original_method = "24CA5CFFCC859FAC59BD892D4A4B2393", hash_generated_method = "DABE787F0AB2C166ABB0DE3321CFE2B6")
      PhoneNumberMatch(int start, String rawString, PhoneNumber number) {
    if(start < 0)        
        {
            IllegalArgumentException varF48BAEA41942249359BDDCDEB57AAC7F_1872416018 = new IllegalArgumentException("Start index must be >= 0.");
            varF48BAEA41942249359BDDCDEB57AAC7F_1872416018.addTaint(taint);
            throw varF48BAEA41942249359BDDCDEB57AAC7F_1872416018;
        } 
    if(rawString == null || number == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_214606498 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_214606498.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_214606498;
        } 
        this.start = start;
        this.rawString = rawString;
        this.number = number;
        
        
      
    
        
      
    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.434 -0400", hash_original_method = "3AF6887A924E6E03501A94FECACFA30D", hash_generated_method = "5AA388F08595ED254D185F3B34FC769A")
    public PhoneNumber number() {
PhoneNumber var63E80DF571E08DAA47BEFBF0BD0EEBAD_1962592817 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_1962592817.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_1962592817;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.434 -0400", hash_original_method = "5948F380AB147474B7B360324D01D8A7", hash_generated_method = "2C8CCF491EE854D19FDEF002227CE39C")
    public int start() {
        int varEA2B2676C28C0DB26D39331A336C6B92_542662325 = (start);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205069804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205069804;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.434 -0400", hash_original_method = "7D10A3C1D28519413DA457C01967C482", hash_generated_method = "A4D3755EF6238A39603DCCD63CD07DF3")
    public int end() {
        int varA8E2CD44906F908C40D0261033818B3F_401420324 = (start + rawString.length());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_950875807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_950875807;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.435 -0400", hash_original_method = "9FB54278FE2075E29BA0E55156E431DE", hash_generated_method = "40CC8EF0BA15F6AB7D31CF49A9BB10E8")
    public String rawString() {
String var4B9D0983C640FEFA2A1CCD188F4CB7B8_1521522879 =         rawString;
        var4B9D0983C640FEFA2A1CCD188F4CB7B8_1521522879.addTaint(taint);
        return var4B9D0983C640FEFA2A1CCD188F4CB7B8_1521522879;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.435 -0400", hash_original_method = "13786FFFFB16751EA6F3DAD6D70C98CC", hash_generated_method = "3FC9CEC78100B2296BCEE062584A2898")
    @Override
    public int hashCode() {
        int var982DF4D1160989F68DE7BB2638849663_187029282 = (Arrays.hashCode(new Object[]{start, rawString, number}));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204521493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204521493;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.435 -0400", hash_original_method = "38076D29780FBE1507C47919C30AB86E", hash_generated_method = "50A05E2C6B236E37FE2664CA8E49BE01")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_811221440 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008334007 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008334007;
        } 
    if(!(obj instanceof PhoneNumberMatch))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2128724802 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146488019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146488019;
        } 
        PhoneNumberMatch other = (PhoneNumberMatch) obj;
        boolean var567D354993B1E4DAD15BCD755639C83F_1832536074 = (rawString.equals(other.rawString) && (start == other.start) &&
        number.equals(other.number));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1076201625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1076201625;
        
        
      
    
        
      
    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.436 -0400", hash_original_method = "9E681ADFB274F0FD80239D8E6C0D9096", hash_generated_method = "2007F9E6061F5C7319A8E0A226CC9419")
    @Override
    public String toString() {
String varD0C2343FF72509EFC6A2E1A0F0270FF5_782827950 =         "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
        varD0C2343FF72509EFC6A2E1A0F0270FF5_782827950.addTaint(taint);
        return varD0C2343FF72509EFC6A2E1A0F0270FF5_782827950;
        
        
    }

    
}

