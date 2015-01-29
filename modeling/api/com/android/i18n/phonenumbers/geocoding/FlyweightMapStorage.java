package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

class FlyweightMapStorage extends AreaCodeMapStorageStrategy {

  /**
   * Gets the minimum number of bytes that can be used to store the provided {@code value}.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.788 -0500", hash_original_method = "D8527B07722D3007E049CCA84C0C170A", hash_generated_method = "28DF19F3917E469FC137AF24E17B99F0")
    
private static int getOptimalNumberOfBytesForValue(int value) {
    return value <= Short.MAX_VALUE ? SHORT_SIZE : INT_SIZE;
  }

  /**
   * Stores the provided {@code value} to the provided byte {@code buffer} at the specified {@code
   * index} using the provided {@code wordSize} in bytes. Note that only integer and short sizes are
   * supported.
   *
   * @param buffer  the byte buffer to which the value is stored
   * @param wordSize  the number of bytes used to store the provided value
   * @param index  the index to which the value is stored
   * @param value  the value that is stored assuming it does not require more than the specified
   *    number of bytes.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.791 -0500", hash_original_method = "43DAEAD9EA7B46F448427A6E33AF9E4F", hash_generated_method = "92B87D21BFF877AEE8BAC0D33BD234B4")
    
private static void storeWordInBuffer(ByteBuffer buffer, int wordSize, int index, int value) {
    index *= wordSize;

    if (wordSize == SHORT_SIZE) {
      buffer.putShort(index, (short) value);
    } else {
      buffer.putInt(index, value);
    }
  }

  /**
   * Reads the {@code value} at the specified {@code index} from the provided byte {@code buffer}.
   * Note that only integer and short sizes are supported.
   *
   * @param buffer  the byte buffer from which the value is read
   * @param wordSize  the number of bytes used to store the value
   * @param index  the index where the value is read from
   *
   * @return  the value read from the buffer
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.793 -0500", hash_original_method = "95351EDF4B775D7B91EF7507601BCE06", hash_generated_method = "55C1C0283C6B3B0AD5D57E775A00F162")
    
private static int readWordFromBuffer(ByteBuffer buffer, int wordSize, int index) {
    index *= wordSize;
    return wordSize == SHORT_SIZE ? buffer.getShort(index) : buffer.getInt(index);
  }

  /**
   * Stores a value which is read from the provided {@code objectInput} to the provided byte {@code
   * buffer} at the specified {@code index}.
   *
   * @param objectInput  the object input stream from which the value is read
   * @param wordSize  the number of bytes used to store the value read from the stream
   * @param outputBuffer  the byte buffer to which the value is stored
   * @param index  the index where the value is stored in the buffer
   * @throws IOException  if an error occurred reading from the object input stream
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.809 -0500", hash_original_method = "2A9DB5BB18B5DDB19F65168B47450AF6", hash_generated_method = "5756F7C0ABDD863B66AD77BB7303A91C")
    
private static void readExternalWord(ObjectInput objectInput, int wordSize,
                                       ByteBuffer outputBuffer, int index) throws IOException {
    index *= wordSize;
    if (wordSize == SHORT_SIZE) {
      outputBuffer.putShort(index, objectInput.readShort());
    } else {
      outputBuffer.putInt(index, objectInput.readInt());
    }
  }

  /**
   * Writes the value read from the provided byte {@code buffer} at the specified {@code index} to
   * the provided {@code objectOutput}.
   *
   * @param objectOutput  the object output stream to which the value is written
   * @param wordSize  the number of bytes used to store the value
   * @param inputBuffer  the byte buffer from which the value is read
   * @param index  the index of the value in the the byte buffer
   * @throws IOException if an error occurred writing to the provided object output stream
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.815 -0500", hash_original_method = "0809A12CC25D71B91D45BE96B1DF5C4D", hash_generated_method = "8BD7FB637BF974B0577F6CD6F2EA10B8")
    
private static void writeExternalWord(ObjectOutput objectOutput, int wordSize,
                                        ByteBuffer inputBuffer, int index) throws IOException {
    index *= wordSize;
    if (wordSize == SHORT_SIZE) {
      objectOutput.writeShort(inputBuffer.getShort(index));
    } else {
      objectOutput.writeInt(inputBuffer.getInt(index));
    }
  }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.764 -0500", hash_original_field = "900D9DA1E23E55C0BE78719794C34598", hash_generated_field = "37950681DC02C7D8897292B6699B2A15")

  private static final int SHORT_SIZE = Short.SIZE / 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.768 -0500", hash_original_field = "DD7D7C1C899E5E70B37210CA8A8D2F37", hash_generated_field = "9B36A8CD72FCA278DBEC63477DFCC506")

  private static final int INT_SIZE = Integer.SIZE / 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.770 -0500", hash_original_field = "91F6DC2920091403D12F6390F5849561", hash_generated_field = "F76986CA8B87BC245B249A85A8272854")

  private int prefixSizeInBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.773 -0500", hash_original_field = "5458F94173F606B1880C9C6674029E4A", hash_generated_field = "EAE81EB1E3FCC524B34D3A5A70878B1E")

  // description pool containing all the strings.
  private int descIndexSizeInBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.775 -0500", hash_original_field = "D0680C3D8B7F418EFCE236A960FA7194", hash_generated_field = "FB05A510369364A4962318241B573EEF")

  private ByteBuffer phoneNumberPrefixes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.778 -0500", hash_original_field = "361583A7A379577174766D23A35BDF4B", hash_generated_field = "8DD3BA710A227D567B0C909055F247B4")

  private ByteBuffer descriptionIndexes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.780 -0500", hash_original_field = "41C8AA8D8B05130CE2D84CD37ED04B3B", hash_generated_field = "3FD4D5B3EAEAE753A19E3DEE1164A725")

  private String[] descriptionPool;

  @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.783 -0500", hash_original_method = "17265440A4150496F4E4B3AED89DBE4A", hash_generated_method = "0C9658EBFEBC2002E4752BB8AB3C7CA4")
    
public FlyweightMapStorage() {}

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.786 -0500", hash_original_method = "8579179DB51630AA1D46F39490760068", hash_generated_method = "630C8E8807E635C519A12BE0DABA6AC2")
    
@Override
  public boolean isFlyweight() {
    return true;
  }

  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.795 -0500", hash_original_method = "2F4ECD8A243390FA1987AE315BD02BED", hash_generated_method = "59BF6591498625BC0E2D9B52CCE13C19")
    
@Override
  public int getPrefix(int index) {
    return readWordFromBuffer(phoneNumberPrefixes, prefixSizeInBytes, index);
  }

  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.798 -0500", hash_original_method = "22178ADBDB18A4450F9D0DCE4A5B21CB", hash_generated_method = "C4C63EF05A7A12E0C1D2E42BED612D85")
    
@Override
  public String getDescription(int index) {
    return descriptionPool[readWordFromBuffer(descriptionIndexes, descIndexSizeInBytes, index)];
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.806 -0500", hash_original_method = "5E35085461C9905BDA49B756DC2968D6", hash_generated_method = "468C7D1F62E2E7C82A58F7227141C5A9")
    
@Override
  public void readFromSortedMap(SortedMap<Integer, String> sortedAreaCodeMap) {
    SortedSet<String> descriptionsSet = new TreeSet<String>();
    numOfEntries = sortedAreaCodeMap.size();
    prefixSizeInBytes = getOptimalNumberOfBytesForValue(sortedAreaCodeMap.lastKey());
    phoneNumberPrefixes = ByteBuffer.allocate(numOfEntries * prefixSizeInBytes);

    // Fill the phone number prefixes byte buffer, the set of possible lengths of prefixes and the
    // description set.
    int index = 0;
    for (Entry<Integer, String> entry : sortedAreaCodeMap.entrySet()) {
      int prefix = entry.getKey();
      storeWordInBuffer(phoneNumberPrefixes, prefixSizeInBytes, index++, prefix);
      possibleLengths.add((int) Math.log10(prefix) + 1);
      descriptionsSet.add(entry.getValue());
    }

    // Create the description pool.
    descIndexSizeInBytes = getOptimalNumberOfBytesForValue(descriptionsSet.size() - 1);
    descriptionIndexes = ByteBuffer.allocate(numOfEntries * descIndexSizeInBytes);
    descriptionPool = new String[descriptionsSet.size()];
    descriptionsSet.toArray(descriptionPool);

    // Map the phone number prefixes to the descriptions.
    index = 0;
    for (int i = 0; i < numOfEntries; i++) {
      int prefix = readWordFromBuffer(phoneNumberPrefixes, prefixSizeInBytes, i);
      String description = sortedAreaCodeMap.get(prefix);
      int positionInDescriptionPool =
          Arrays.binarySearch(descriptionPool, description, new Comparator<String>() {
            @DSSafe(DSCat.SAFE_LIST)
        public int compare(String o1, String o2) { return o1.compareTo(o2); }
          });
      storeWordInBuffer(descriptionIndexes, descIndexSizeInBytes, index++,
                        positionInDescriptionPool);
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.813 -0500", hash_original_method = "34B883F6EE399DBE00C99A62ABAF8CA0", hash_generated_method = "EEA4A038D66DEF661A15B4A921DC6A1D")
    
@Override
  public void readExternal(ObjectInput objectInput) throws IOException {
    // Read binary words sizes.
    prefixSizeInBytes = objectInput.readInt();
    descIndexSizeInBytes = objectInput.readInt();
    // Read possible lengths.
    int sizeOfLengths = objectInput.readInt();
    possibleLengths.clear();
    for (int i = 0; i < sizeOfLengths; i++) {
      possibleLengths.add(objectInput.readInt());
    }
    // Read description pool size.
    int descriptionPoolSize = objectInput.readInt();
    // Read description pool.
    if (descriptionPool == null || descriptionPool.length < descriptionPoolSize) {
      descriptionPool = new String[descriptionPoolSize];
    }
    for (int i = 0; i < descriptionPoolSize; i++) {
      String description = objectInput.readUTF();
      descriptionPool[i] = description;
    }
    // Read entries.
    numOfEntries = objectInput.readInt();
    if (phoneNumberPrefixes == null || phoneNumberPrefixes.capacity() < numOfEntries) {
        phoneNumberPrefixes = ByteBuffer.allocate(numOfEntries * prefixSizeInBytes);
    }
    if (descriptionIndexes == null || descriptionIndexes.capacity() < numOfEntries) {
      descriptionIndexes = ByteBuffer.allocate(numOfEntries * descIndexSizeInBytes);
    }
    for (int i = 0; i < numOfEntries; i++) {
      readExternalWord(objectInput, prefixSizeInBytes, phoneNumberPrefixes, i);
      readExternalWord(objectInput, descIndexSizeInBytes, descriptionIndexes, i);
    }
  }

  @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.818 -0500", hash_original_method = "6F391CD50156CF53BBA3CDABE0E437A9", hash_generated_method = "DEA9F38DAC4B06B52B88D00B2B436137")
    
@Override
  public void writeExternal(ObjectOutput objectOutput) throws IOException {
    // Write binary words sizes.
    objectOutput.writeInt(prefixSizeInBytes);
    objectOutput.writeInt(descIndexSizeInBytes);
    // Write possible lengths.
    int sizeOfLengths = possibleLengths.size();
    objectOutput.writeInt(sizeOfLengths);
    for (Integer length : possibleLengths) {
      objectOutput.writeInt(length);
    }
    // Write description pool size.
    objectOutput.writeInt(descriptionPool.length);
    // Write description pool.
    for (String description : descriptionPool) {
      objectOutput.writeUTF(description);
    }
    // Write entries.
    objectOutput.writeInt(numOfEntries);
    for (int i = 0; i < numOfEntries; i++) {
      writeExternalWord(objectOutput, prefixSizeInBytes, phoneNumberPrefixes, i);
      writeExternalWord(objectOutput, descIndexSizeInBytes, descriptionIndexes, i);
    }
  }
}

