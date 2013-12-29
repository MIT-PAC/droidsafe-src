package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.SortedMap;






class DefaultMapStorage extends AreaCodeMapStorageStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.671 -0500", hash_original_field = "2E090E0FDA3569C48E6CB697457074C8", hash_generated_field = "8F024CB0AD263019B845A09CCEFC6C3E")


  private int[] phoneNumberPrefixes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.672 -0500", hash_original_field = "CF80C9B5078DC8177B2555E30F0611BC", hash_generated_field = "11DEDEF7B2B3D57903FB4636F9144ACA")

  private String[] descriptions;

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.671 -0500", hash_original_method = "303B051C40F1A8F79D475AA40AA2373B", hash_generated_method = "A1E44B78E3244E61FAD94973D60073EA")
    public DefaultMapStorage() {}

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.673 -0500", hash_original_method = "F69095453A9ABCA4791C551DEF1AF820", hash_generated_method = "F19F06CC825DDFF7B7389190C5054373")
    @Override
public boolean isFlyweight() {
    return false;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.674 -0500", hash_original_method = "499E30A17B0C3429D0791D94BC3FA75F", hash_generated_method = "EFF44D4B0F50336CBC383D5F64CA9353")
    @Override
public int getPrefix(int index) {
    return phoneNumberPrefixes[index];
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.675 -0500", hash_original_method = "9F6ED4FEDAB6F7BCB8C7B74F1377FE11", hash_generated_method = "203D35EEE8AB45A79E92B5EFACE487A0")
    @Override
public String getDescription(int index) {
    return descriptions[index];
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.676 -0500", hash_original_method = "133A71C9726C43F724F7FEB46F2DAD1A", hash_generated_method = "231DD45DDC1F8AF9A2FE913A17A4E660")
    @Override
public void readFromSortedMap(SortedMap<Integer, String> sortedAreaCodeMap) {
    numOfEntries = sortedAreaCodeMap.size();
    phoneNumberPrefixes = new int[numOfEntries];
    descriptions = new String[numOfEntries];
    int index = 0;
    for (int prefix : sortedAreaCodeMap.keySet()) {
      phoneNumberPrefixes[index++] = prefix;
      possibleLengths.add((int) Math.log10(prefix) + 1);
    }
    sortedAreaCodeMap.values().toArray(descriptions);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.676 -0500", hash_original_method = "0264417E3D0614273CCDCAAD5EB78429", hash_generated_method = "8E212B3735F31CE564A774FA50EEA0C9")
    @Override
public void readExternal(ObjectInput objectInput) throws IOException {
    numOfEntries = objectInput.readInt();
    if (phoneNumberPrefixes == null || phoneNumberPrefixes.length < numOfEntries) {
      phoneNumberPrefixes = new int[numOfEntries];
    }
    if (descriptions == null || descriptions.length < numOfEntries) {
      descriptions = new String[numOfEntries];
    }
    for (int i = 0; i < numOfEntries; i++) {
      phoneNumberPrefixes[i] = objectInput.readInt();
      descriptions[i] = objectInput.readUTF();
    }
    int sizeOfLengths = objectInput.readInt();
    possibleLengths.clear();
    for (int i = 0; i < sizeOfLengths; i++) {
      possibleLengths.add(objectInput.readInt());
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.677 -0500", hash_original_method = "7B03681C04FCB0BC9386533E4F9ED1FB", hash_generated_method = "687D01A1D286BB03018DCBCE75D1CDC2")
    @Override
public void writeExternal(ObjectOutput objectOutput) throws IOException {
    objectOutput.writeInt(numOfEntries);
    for (int i = 0; i < numOfEntries; i++) {
      objectOutput.writeInt(phoneNumberPrefixes[i]);
      objectOutput.writeUTF(descriptions[i]);
    }
    int sizeOfLengths = possibleLengths.size();
    objectOutput.writeInt(sizeOfLengths);
    for (Integer length : possibleLengths) {
      objectOutput.writeInt(length);
    }
  }

    
}

