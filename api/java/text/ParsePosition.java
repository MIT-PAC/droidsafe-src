package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ParsePosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.985 -0400", hash_original_field = "F92DCDD86E6BEEEA3E199F5D44A97241", hash_generated_field = "8A55CE2AEC9EB9B4FFBC5BD7C0750E33")

    private int currentPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.985 -0400", hash_original_field = "02A1F59FCDD6F1515C17B6F84ABA0756", hash_generated_field = "4249A53A741FB202C50A53B01C7CB1E3")

    private int errorIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.986 -0400", hash_original_method = "DC50BCA5F95CF2B530ABA250C6125033", hash_generated_method = "14D727696863DAC0F24A030F748724FE")
    public  ParsePosition(int index) {
        currentPosition = index;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.986 -0400", hash_original_method = "7A2CC483DDAB3EA409EA20ED7AF6932E", hash_generated_method = "61BAFBF24D326B8722C2471A73BCED69")
    @Override
    public boolean equals(Object object) {
        ParsePosition pos = (ParsePosition) object;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216891318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216891318;
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.986 -0400", hash_original_method = "251F29749A0D498AD09891D5409959A9", hash_generated_method = "4B36F59F434BE13802596FB6D1BF5AD7")
    public int getErrorIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457217906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457217906;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.987 -0400", hash_original_method = "1CFE76DD95166F56A240763AD86BFFF6", hash_generated_method = "E81A8FFC7B0B12D5B0896BBE30625550")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_909901508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_909901508;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.987 -0400", hash_original_method = "78BEA0F92DBA8060A51AB3A3D8273064", hash_generated_method = "16A564059B806FED49FE0927E978E5FC")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822576068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822576068;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.987 -0400", hash_original_method = "F3EA9276CC48A5113CA1E4D2C48DC7D4", hash_generated_method = "19BC42C8529ADD2DE558BFF9D2CE02DA")
    public void setErrorIndex(int index) {
        errorIndex = index;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.987 -0400", hash_original_method = "1C6C7B20133CCF9092C9B321C0CF7A81", hash_generated_method = "D9D656F864CC281851276926DE08C108")
    public void setIndex(int index) {
        currentPosition = index;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.988 -0400", hash_original_method = "EA803D38773CA0193E1AA7C91AAA6A50", hash_generated_method = "15DAF3504E9FA4A3D101CE126CD7DF16")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_946004598 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_946004598 = getClass().getName() + "[index=" + currentPosition
                + ", errorIndex=" + errorIndex + "]";
        varB4EAC82CA7396A68D541C85D26508E83_946004598.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_946004598;
        
        
                
    }

    
}

