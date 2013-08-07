package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;

import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;






public final class PhoneNumberMatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.604 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

    private int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.604 -0400", hash_original_field = "86C8EF5116F9F2D53104EB36EE5FEBD4", hash_generated_field = "6456B20A1E1CCB2639ECC7BC4AF85249")

    private String rawString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.604 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "DFCB3B49B2D60B2C16CC443A648E9AFE")

    private PhoneNumber number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.605 -0400", hash_original_method = "24CA5CFFCC859FAC59BD892D4A4B2393", hash_generated_method = "0DB9A664011856713AA21410A2D67232")
      PhoneNumberMatch(int start, String rawString, PhoneNumber number) {
        if(start < 0)        
        {
            IllegalArgumentException varF48BAEA41942249359BDDCDEB57AAC7F_2145878683 = new IllegalArgumentException("Start index must be >= 0.");
            varF48BAEA41942249359BDDCDEB57AAC7F_2145878683.addTaint(taint);
            throw varF48BAEA41942249359BDDCDEB57AAC7F_2145878683;
        } //End block
        if(rawString == null || number == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_283888652 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_283888652.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_283888652;
        } //End block
        this.start = start;
        this.rawString = rawString;
        this.number = number;
        // ---------- Original Method ----------
        //if (start < 0) {
      //throw new IllegalArgumentException("Start index must be >= 0.");
    //}
        //if (rawString == null || number == null) {
      //throw new NullPointerException();
    //}
        //this.start = start;
        //this.rawString = rawString;
        //this.number = number;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.605 -0400", hash_original_method = "3AF6887A924E6E03501A94FECACFA30D", hash_generated_method = "6000A4F4B2CFA4C368E45EED08062277")
    public PhoneNumber number() {
PhoneNumber var63E80DF571E08DAA47BEFBF0BD0EEBAD_631946680 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_631946680.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_631946680;
        // ---------- Original Method ----------
        //return number;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.605 -0400", hash_original_method = "5948F380AB147474B7B360324D01D8A7", hash_generated_method = "ABD18B788C5BDAB09BB13065C2A6997E")
    public int start() {
        int varEA2B2676C28C0DB26D39331A336C6B92_624743497 = (start);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221986774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221986774;
        // ---------- Original Method ----------
        //return start;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.606 -0400", hash_original_method = "7D10A3C1D28519413DA457C01967C482", hash_generated_method = "FB816A311EE1D74B96C17828FDEC4F08")
    public int end() {
        int varA8E2CD44906F908C40D0261033818B3F_1990462093 = (start + rawString.length());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980242720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980242720;
        // ---------- Original Method ----------
        //return start + rawString.length();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.606 -0400", hash_original_method = "9FB54278FE2075E29BA0E55156E431DE", hash_generated_method = "C4E0FE2AC9AD170D7910F59C23C038D8")
    public String rawString() {
String var4B9D0983C640FEFA2A1CCD188F4CB7B8_540414653 =         rawString;
        var4B9D0983C640FEFA2A1CCD188F4CB7B8_540414653.addTaint(taint);
        return var4B9D0983C640FEFA2A1CCD188F4CB7B8_540414653;
        // ---------- Original Method ----------
        //return rawString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.606 -0400", hash_original_method = "13786FFFFB16751EA6F3DAD6D70C98CC", hash_generated_method = "CFF9A9526BE4926E755FDDD2A65025CF")
    @Override
    public int hashCode() {
        int var982DF4D1160989F68DE7BB2638849663_2004436349 = (Arrays.hashCode(new Object[]{start, rawString, number}));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129299657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129299657;
        // ---------- Original Method ----------
        //return Arrays.hashCode(new Object[]{start, rawString, number});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.607 -0400", hash_original_method = "38076D29780FBE1507C47919C30AB86E", hash_generated_method = "D267C5B1F2E56FD82163203131217D7A")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_97407184 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141285861 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141285861;
        } //End block
        if(!(obj instanceof PhoneNumberMatch))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1990986235 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413286057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_413286057;
        } //End block
        PhoneNumberMatch other = (PhoneNumberMatch) obj;
        boolean var567D354993B1E4DAD15BCD755639C83F_2081965325 = (rawString.equals(other.rawString) && (start == other.start) &&
        number.equals(other.number));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_108412981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_108412981;
        // ---------- Original Method ----------
        //if (this == obj) {
      //return true;
    //}
        //if (!(obj instanceof PhoneNumberMatch)) {
      //return false;
    //}
        //PhoneNumberMatch other = (PhoneNumberMatch) obj;
        //return rawString.equals(other.rawString) && (start == other.start) &&
        //number.equals(other.number);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.607 -0400", hash_original_method = "9E681ADFB274F0FD80239D8E6C0D9096", hash_generated_method = "F05ED29D34C94A04F4F1182B43AD6117")
    @Override
    public String toString() {
String varD0C2343FF72509EFC6A2E1A0F0270FF5_652396450 =         "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
        varD0C2343FF72509EFC6A2E1A0F0270FF5_652396450.addTaint(taint);
        return varD0C2343FF72509EFC6A2E1A0F0270FF5_652396450;
        // ---------- Original Method ----------
        //return "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
    }

    
}

