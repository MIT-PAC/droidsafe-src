package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.SortedMap;
import java.util.TreeSet;






abstract class AreaCodeMapStorageStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.910 -0500", hash_original_field = "00F1381F548F3A5295097F2401ADFC52", hash_generated_field = "A8A65EF4F8315577299BC66787FEAF93")

  protected int numOfEntries = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.910 -0500", hash_original_field = "F27B9F27D291E9C70B7132D7F839782A", hash_generated_field = "117D2F6B6B0CD3E3A98E981A0FE51C20")

  protected final TreeSet<Integer> possibleLengths = new TreeSet<Integer>();

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.911 -0500", hash_original_method = "552FE922C6186E104B342E1C364AC348", hash_generated_method = "23406EDC9C84BF42534B33340C50DEFB")
    public AreaCodeMapStorageStrategy() {}

  /**
   * Returns whether the underlying implementation of this abstract class is flyweight.
   * It is expected to be flyweight if it implements the {@code FlyweightMapStorage} class.
   *
   * @return  whether the underlying implementation of this abstract class is flyweight
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.912 -0500", hash_original_method = "8C3DF0E4670B1B720EA4BF046177B5B2", hash_generated_method = "CB033832448114A4BA252F7449E19AB9")
    public abstract boolean isFlyweight();

  /**
   * @return  the number of entries contained in the area code map
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.913 -0500", hash_original_method = "67028691C3A13A3B8C6995CB53BC17C2", hash_generated_method = "EFB1CF74F5BD00D02AAAED4029EEF8F9")
    public int getNumOfEntries() {
    return numOfEntries;
  }

  /**
   * @return  the set containing the possible lengths of prefixes
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.913 -0500", hash_original_method = "9B53A77A841456041603E3D119D30EB4", hash_generated_method = "E9E126B336B9EFA67D1946B657F3667B")
    public TreeSet<Integer> getPossibleLengths() {
    return possibleLengths;
  }

  /**
   * Gets the phone number prefix located at the provided {@code index}.
   *
   * @param index  the index of the prefix that needs to be returned
   * @return  the phone number prefix at the provided index
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.914 -0500", hash_original_method = "CC816A42DE056FA45F4750DD0DF8C50A", hash_generated_method = "D5C1E20A41D3068C1E34614A380A7FF3")
    public abstract int getPrefix(int index);

  /**
   * Gets the description corresponding to the phone number prefix located at the provided {@code
   * index}.
   *
   * @param index  the index of the phone number prefix that needs to be returned
   * @return  the description corresponding to the phone number prefix at the provided index
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.915 -0500", hash_original_method = "41C6F1984B61B370D6BEF5F1720FA001", hash_generated_method = "166E43DDF270AD32066C2CB4EFA87421")
    public abstract String getDescription(int index);

  /**
   * Sets the internal state of the underlying storage implementation from the provided {@code
   * sortedAreaCodeMap} that maps phone number prefixes to description strings.
   *
   * @param sortedAreaCodeMap  a sorted map that maps phone number prefixes including country
   *    calling code to description strings
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.916 -0500", hash_original_method = "63AE65579CA13AF1E8A6BECB2C0ECB78", hash_generated_method = "5B489F00212DEF5896651E77C051F3BB")
    public abstract void readFromSortedMap(SortedMap<Integer, String> sortedAreaCodeMap);

  /**
   * Sets the internal state of the underlying storage implementation reading the provided {@code
   * objectInput}.
   *
   * @param objectInput  the object input stream from which the area code map is read
   * @throws IOException  if an error occurred reading the provided input stream
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.917 -0500", hash_original_method = "6FE639BDF297291E4A948A266A0FB6FB", hash_generated_method = "7C97ACD2BCD1119C2251275D5760D253")
    public abstract void readExternal(ObjectInput objectInput) throws IOException;

  /**
   * Writes the internal state of the underlying storage implementation to the provided {@code
   * objectOutput}.
   *
   * @param objectOutput  the object output stream to which the area code map is written
   * @throws IOException  if an error occurred writing to the provided output stream
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.917 -0500", hash_original_method = "78E7DE830841F23017EDA8BF3FC41760", hash_generated_method = "B4A3118C40AE051E6D6353D22AA49DED")
    public abstract void writeExternal(ObjectOutput objectOutput) throws IOException;

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.918 -0500", hash_original_method = "4D596518D97EDAAEB28E920BC89837B3", hash_generated_method = "8A1AAC2535CE3F088536231CA78CCA30")
    @Override
public String toString() {
    StringBuilder output = new StringBuilder();
    int numOfEntries = getNumOfEntries();

    for (int i = 0; i < numOfEntries; i++) {
      output.append(getPrefix(i));
      output.append("|");
      output.append(getDescription(i));
      output.append("\n");
    }
    return output.toString();
  }

    
}

