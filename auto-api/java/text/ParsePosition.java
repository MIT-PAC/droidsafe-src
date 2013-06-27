package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParsePosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.728 -0400", hash_original_field = "F92DCDD86E6BEEEA3E199F5D44A97241", hash_generated_field = "8A55CE2AEC9EB9B4FFBC5BD7C0750E33")

    private int currentPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.728 -0400", hash_original_field = "02A1F59FCDD6F1515C17B6F84ABA0756", hash_generated_field = "4249A53A741FB202C50A53B01C7CB1E3")

    private int errorIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.728 -0400", hash_original_method = "DC50BCA5F95CF2B530ABA250C6125033", hash_generated_method = "14D727696863DAC0F24A030F748724FE")
    public  ParsePosition(int index) {
        currentPosition = index;
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.729 -0400", hash_original_method = "7A2CC483DDAB3EA409EA20ED7AF6932E", hash_generated_method = "26568F1AFBC5B4070814F3B9877EE7C3")
    @Override
    public boolean equals(Object object) {
        ParsePosition pos;
        pos = (ParsePosition) object;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231009471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231009471;
        // ---------- Original Method ----------
        //if (!(object instanceof ParsePosition)) {
            //return false;
        //}
        //ParsePosition pos = (ParsePosition) object;
        //return currentPosition == pos.currentPosition
                //&& errorIndex == pos.errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.729 -0400", hash_original_method = "251F29749A0D498AD09891D5409959A9", hash_generated_method = "087466D847C698FDBE7C69017F4050BC")
    public int getErrorIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748620309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748620309;
        // ---------- Original Method ----------
        //return errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.730 -0400", hash_original_method = "1CFE76DD95166F56A240763AD86BFFF6", hash_generated_method = "7C0961A1B58B1C006EE45F3EC2B6FE30")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213217381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213217381;
        // ---------- Original Method ----------
        //return currentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.730 -0400", hash_original_method = "78BEA0F92DBA8060A51AB3A3D8273064", hash_generated_method = "C215D7D525DA043A855CBCAF786A9F67")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150347073 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150347073;
        // ---------- Original Method ----------
        //return currentPosition + errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.730 -0400", hash_original_method = "F3EA9276CC48A5113CA1E4D2C48DC7D4", hash_generated_method = "19BC42C8529ADD2DE558BFF9D2CE02DA")
    public void setErrorIndex(int index) {
        errorIndex = index;
        // ---------- Original Method ----------
        //errorIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.731 -0400", hash_original_method = "1C6C7B20133CCF9092C9B321C0CF7A81", hash_generated_method = "D9D656F864CC281851276926DE08C108")
    public void setIndex(int index) {
        currentPosition = index;
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.731 -0400", hash_original_method = "EA803D38773CA0193E1AA7C91AAA6A50", hash_generated_method = "75A83B79C7556ECCE359265EF6095D46")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1316481262 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1316481262 = getClass().getName() + "[index=" + currentPosition
                + ", errorIndex=" + errorIndex + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1316481262.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1316481262;
        // ---------- Original Method ----------
        //return getClass().getName() + "[index=" + currentPosition
                //+ ", errorIndex=" + errorIndex + "]";
    }

    
}

