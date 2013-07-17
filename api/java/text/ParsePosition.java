package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ParsePosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.878 -0400", hash_original_field = "F92DCDD86E6BEEEA3E199F5D44A97241", hash_generated_field = "8A55CE2AEC9EB9B4FFBC5BD7C0750E33")

    private int currentPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.878 -0400", hash_original_field = "02A1F59FCDD6F1515C17B6F84ABA0756", hash_generated_field = "4249A53A741FB202C50A53B01C7CB1E3")

    private int errorIndex = -1;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.879 -0400", hash_original_method = "DC50BCA5F95CF2B530ABA250C6125033", hash_generated_method = "14D727696863DAC0F24A030F748724FE")
    public  ParsePosition(int index) {
        currentPosition = index;
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.880 -0400", hash_original_method = "7A2CC483DDAB3EA409EA20ED7AF6932E", hash_generated_method = "541DDE636B5416A89919062F62A3AA08")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(!(object instanceof ParsePosition))        
        {
            boolean var68934A3E9455FA72420237EB05902327_183104834 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043846343 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043846343;
        } //End block
        ParsePosition pos = (ParsePosition) object;
        boolean var768585B512E51609815A83F472C1C371_729700058 = (currentPosition == pos.currentPosition
                && errorIndex == pos.errorIndex);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966293124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966293124;
        // ---------- Original Method ----------
        //if (!(object instanceof ParsePosition)) {
            //return false;
        //}
        //ParsePosition pos = (ParsePosition) object;
        //return currentPosition == pos.currentPosition
                //&& errorIndex == pos.errorIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.880 -0400", hash_original_method = "251F29749A0D498AD09891D5409959A9", hash_generated_method = "FB82BCFB5E4FE8FCF6F73283AB110703")
    public int getErrorIndex() {
        int var9BEB71D3C627DEA11B9CF92BA54AA661_1138662656 = (errorIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063151618 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063151618;
        // ---------- Original Method ----------
        //return errorIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.881 -0400", hash_original_method = "1CFE76DD95166F56A240763AD86BFFF6", hash_generated_method = "871DCDE453F08B2ED90155ED17BF7BEB")
    public int getIndex() {
        int varF92DCDD86E6BEEEA3E199F5D44A97241_639359262 = (currentPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330255869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330255869;
        // ---------- Original Method ----------
        //return currentPosition;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.881 -0400", hash_original_method = "78BEA0F92DBA8060A51AB3A3D8273064", hash_generated_method = "9AD9BEF5117219F6D66AB96DAF7D4B3E")
    @Override
    public int hashCode() {
        int var37600BC320839CE77399CF8E33A0736B_1494862825 = (currentPosition + errorIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596626929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596626929;
        // ---------- Original Method ----------
        //return currentPosition + errorIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.882 -0400", hash_original_method = "F3EA9276CC48A5113CA1E4D2C48DC7D4", hash_generated_method = "19BC42C8529ADD2DE558BFF9D2CE02DA")
    public void setErrorIndex(int index) {
        errorIndex = index;
        // ---------- Original Method ----------
        //errorIndex = index;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.883 -0400", hash_original_method = "1C6C7B20133CCF9092C9B321C0CF7A81", hash_generated_method = "D9D656F864CC281851276926DE08C108")
    public void setIndex(int index) {
        currentPosition = index;
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.883 -0400", hash_original_method = "EA803D38773CA0193E1AA7C91AAA6A50", hash_generated_method = "819BBE888E125787FDEF5D826BF40466")
    @Override
    public String toString() {
String var72AF384AE508D5DB40E7A36BEF2F7A11_1084981647 =         getClass().getName() + "[index=" + currentPosition
                + ", errorIndex=" + errorIndex + "]";
        var72AF384AE508D5DB40E7A36BEF2F7A11_1084981647.addTaint(taint);
        return var72AF384AE508D5DB40E7A36BEF2F7A11_1084981647;
        // ---------- Original Method ----------
        //return getClass().getName() + "[index=" + currentPosition
                //+ ", errorIndex=" + errorIndex + "]";
    }

    
}

