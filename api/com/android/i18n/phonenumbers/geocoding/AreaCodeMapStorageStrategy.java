package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.SortedMap;
import java.util.TreeSet;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

abstract class AreaCodeMapStorageStrategy {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.448 -0400", hash_original_field = "69F496FCE87C6BC7DC2D0257BB43A268", hash_generated_field = "A8A65EF4F8315577299BC66787FEAF93")

    protected int numOfEntries = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.448 -0400", hash_original_field = "EB8252013E98AADDBA6044825CEFC6EF", hash_generated_field = "117D2F6B6B0CD3E3A98E981A0FE51C20")

    protected final TreeSet<Integer> possibleLengths = new TreeSet<Integer>();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.449 -0400", hash_original_method = "552FE922C6186E104B342E1C364AC348", hash_generated_method = "78F311E4855CBA2D4A156E20751234C3")
    public  AreaCodeMapStorageStrategy() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isFlyweight();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.449 -0400", hash_original_method = "67028691C3A13A3B8C6995CB53BC17C2", hash_generated_method = "71FFF1C3B61284938355ABE6E576A614")
    public int getNumOfEntries() {
        int var881EB9BA7A3B2170EFED470F473D8D5B_1933079006 = (numOfEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88253866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88253866;
        // ---------- Original Method ----------
        //return numOfEntries;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.450 -0400", hash_original_method = "9B53A77A841456041603E3D119D30EB4", hash_generated_method = "7727A06155BF871AA5728A790B0D6566")
    public TreeSet<Integer> getPossibleLengths() {
TreeSet<Integer> var439F4A98FBDEDBC4D02BC8BC3F605BAF_598450754 =         possibleLengths;
        var439F4A98FBDEDBC4D02BC8BC3F605BAF_598450754.addTaint(taint);
        return var439F4A98FBDEDBC4D02BC8BC3F605BAF_598450754;
        // ---------- Original Method ----------
        //return possibleLengths;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int getPrefix(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract String getDescription(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract void readFromSortedMap(SortedMap<Integer, String> sortedAreaCodeMap);

    
    @DSModeled(DSC.SAFE)
    public abstract void readExternal(ObjectInput objectInput) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract void writeExternal(ObjectOutput objectOutput) throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.453 -0400", hash_original_method = "4D596518D97EDAAEB28E920BC89837B3", hash_generated_method = "92E410D9085EAE1E50FAC4EE2C40DB22")
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
String varEBF0387156E2D98F471F997058C674A5_1034171401 =         output.toString();
        varEBF0387156E2D98F471F997058C674A5_1034171401.addTaint(taint);
        return varEBF0387156E2D98F471F997058C674A5_1034171401;
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

