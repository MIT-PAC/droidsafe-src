package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.SortedMap;
import java.util.TreeSet;

abstract class AreaCodeMapStorageStrategy {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.315 -0400", hash_original_field = "69F496FCE87C6BC7DC2D0257BB43A268", hash_generated_field = "A8A65EF4F8315577299BC66787FEAF93")

    protected int numOfEntries = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.315 -0400", hash_original_field = "EB8252013E98AADDBA6044825CEFC6EF", hash_generated_field = "117D2F6B6B0CD3E3A98E981A0FE51C20")

    protected final TreeSet<Integer> possibleLengths = new TreeSet<Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.315 -0400", hash_original_method = "552FE922C6186E104B342E1C364AC348", hash_generated_method = "78F311E4855CBA2D4A156E20751234C3")
    public  AreaCodeMapStorageStrategy() {
        // ---------- Original Method ----------
    }

    
    public abstract boolean isFlyweight();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.316 -0400", hash_original_method = "67028691C3A13A3B8C6995CB53BC17C2", hash_generated_method = "2A5F3F9620821C974A06206D27132648")
    public int getNumOfEntries() {
        int var881EB9BA7A3B2170EFED470F473D8D5B_267675265 = (numOfEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583812330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583812330;
        // ---------- Original Method ----------
        //return numOfEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.316 -0400", hash_original_method = "9B53A77A841456041603E3D119D30EB4", hash_generated_method = "F5138CB051FC3BA61285E02604F38B73")
    public TreeSet<Integer> getPossibleLengths() {
TreeSet<Integer> var439F4A98FBDEDBC4D02BC8BC3F605BAF_2046447022 =         possibleLengths;
        var439F4A98FBDEDBC4D02BC8BC3F605BAF_2046447022.addTaint(taint);
        return var439F4A98FBDEDBC4D02BC8BC3F605BAF_2046447022;
        // ---------- Original Method ----------
        //return possibleLengths;
    }

    
    public abstract int getPrefix(int index);

    
    public abstract String getDescription(int index);

    
    public abstract void readFromSortedMap(SortedMap<Integer, String> sortedAreaCodeMap);

    
    public abstract void readExternal(ObjectInput objectInput) throws IOException;

    
    public abstract void writeExternal(ObjectOutput objectOutput) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.317 -0400", hash_original_method = "4D596518D97EDAAEB28E920BC89837B3", hash_generated_method = "C2B04EC839960647F17C83C5A07953E9")
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int numOfEntries = getNumOfEntries();
for(int i = 0;i < numOfEntries;i++)
        {
            output.append(getPrefix(i));
            output.append("|");
            output.append(getDescription(i));
            output.append("\n");
        } //End block
String varEBF0387156E2D98F471F997058C674A5_191312654 =         output.toString();
        varEBF0387156E2D98F471F997058C674A5_191312654.addTaint(taint);
        return varEBF0387156E2D98F471F997058C674A5_191312654;
        // ---------- Original Method ----------
        //StringBuilder output = new StringBuilder();
        //int numOfEntries = getNumOfEntries();
        //for (int i = 0; i < numOfEntries; i++) {
      //output.append(getPrefix(i));
      //output.append("|");
      //output.append(getDescription(i));
      //output.append("\n");
    //}
        //return output.toString();
    }

    
}

