package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParsePosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.523 -0400", hash_original_field = "F92DCDD86E6BEEEA3E199F5D44A97241", hash_generated_field = "8A55CE2AEC9EB9B4FFBC5BD7C0750E33")

    private int currentPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.523 -0400", hash_original_field = "02A1F59FCDD6F1515C17B6F84ABA0756", hash_generated_field = "4249A53A741FB202C50A53B01C7CB1E3")

    private int errorIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.534 -0400", hash_original_method = "DC50BCA5F95CF2B530ABA250C6125033", hash_generated_method = "14D727696863DAC0F24A030F748724FE")
    public  ParsePosition(int index) {
        currentPosition = index;
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.535 -0400", hash_original_method = "7A2CC483DDAB3EA409EA20ED7AF6932E", hash_generated_method = "623CBF9F7D7B9ADE6D4184BBB6127E06")
    @Override
    public boolean equals(Object object) {
        ParsePosition pos;
        pos = (ParsePosition) object;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_836231283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_836231283;
        // ---------- Original Method ----------
        //if (!(object instanceof ParsePosition)) {
            //return false;
        //}
        //ParsePosition pos = (ParsePosition) object;
        //return currentPosition == pos.currentPosition
                //&& errorIndex == pos.errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.535 -0400", hash_original_method = "251F29749A0D498AD09891D5409959A9", hash_generated_method = "35C58465F7B9BA7E55F5A1B62D0549C3")
    public int getErrorIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472241392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472241392;
        // ---------- Original Method ----------
        //return errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.535 -0400", hash_original_method = "1CFE76DD95166F56A240763AD86BFFF6", hash_generated_method = "43EC1E8C5CEE63FB314AEA83676B527E")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449017648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449017648;
        // ---------- Original Method ----------
        //return currentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.535 -0400", hash_original_method = "78BEA0F92DBA8060A51AB3A3D8273064", hash_generated_method = "C11AEC4D980B7EF800879E1591540F87")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_10041204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_10041204;
        // ---------- Original Method ----------
        //return currentPosition + errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.536 -0400", hash_original_method = "F3EA9276CC48A5113CA1E4D2C48DC7D4", hash_generated_method = "19BC42C8529ADD2DE558BFF9D2CE02DA")
    public void setErrorIndex(int index) {
        errorIndex = index;
        // ---------- Original Method ----------
        //errorIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.536 -0400", hash_original_method = "1C6C7B20133CCF9092C9B321C0CF7A81", hash_generated_method = "D9D656F864CC281851276926DE08C108")
    public void setIndex(int index) {
        currentPosition = index;
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.536 -0400", hash_original_method = "EA803D38773CA0193E1AA7C91AAA6A50", hash_generated_method = "FDE1A224D176EADB31AB049A5BBA4C1E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_95333160 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_95333160 = getClass().getName() + "[index=" + currentPosition
                + ", errorIndex=" + errorIndex + "]";
        varB4EAC82CA7396A68D541C85D26508E83_95333160.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_95333160;
        // ---------- Original Method ----------
        //return getClass().getName() + "[index=" + currentPosition
                //+ ", errorIndex=" + errorIndex + "]";
    }

    
}

