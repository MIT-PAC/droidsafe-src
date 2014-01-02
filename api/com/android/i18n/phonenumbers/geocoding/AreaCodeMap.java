package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.logging.Logger;

import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;






public class AreaCodeMap implements Externalizable {

  /**
   * Gets the size of the provided area code map storage. The map storage passed-in will be filled
   * as a result.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.575 -0500", hash_original_method = "66990EFDE27B5042FF2B21540E9F1A4A", hash_generated_method = "374C8EC76876E11AC2B2E2C7A5749910")
    
private static int getSizeOfAreaCodeMapStorage(AreaCodeMapStorageStrategy mapStorage,
      SortedMap<Integer, String> areaCodeMap) throws IOException {
    mapStorage.readFromSortedMap(areaCodeMap);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    mapStorage.writeExternal(objectOutputStream);
    objectOutputStream.flush();
    int sizeOfStorage = byteArrayOutputStream.size();
    objectOutputStream.close();
    return sizeOfStorage;
  }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.565 -0500", hash_original_field = "D7329A68D755F6984BFACB464A1EE5DC", hash_generated_field = "6AC19EA0C920B63C3669AAC19476698A")

  private static final Logger LOGGER = Logger.getLogger(AreaCodeMap.class.getName());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.563 -0500", hash_original_field = "77B7FB9FF47C6498ED40292699F59FD1", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")

  private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.567 -0500", hash_original_field = "42C7CEEFF27F1DF7294680FC44588504", hash_generated_field = "ED1850D47B6862466E3813601569EB4C")


  private AreaCodeMapStorageStrategy areaCodeMapStorage;

  /**
   * Creates an empty {@link AreaCodeMap}. The default constructor is necessary for implementing
   * {@link Externalizable}. The empty map could later be populated by
   * {@link #readAreaCodeMap(java.util.SortedMap)} or {@link #readExternal(java.io.ObjectInput)}.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.571 -0500", hash_original_method = "F2335FCA92B9F7475991523B74CDEDE4", hash_generated_method = "E8845103160A945A6235E4DA785232E3")
    
public AreaCodeMap() {}

  // @VisibleForTesting
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.569 -0500", hash_original_method = "2F443A9F7F25B3F1F0013A418F926218", hash_generated_method = "2F443A9F7F25B3F1F0013A418F926218")
    
AreaCodeMapStorageStrategy getAreaCodeMapStorage() {
    return areaCodeMapStorage;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.577 -0500", hash_original_method = "541ED4E710A19E1EDF02867FA9DD727B", hash_generated_method = "7F6AED160DB0F6D85068F090C20A2B43")
    
private AreaCodeMapStorageStrategy createDefaultMapStorage() {
    return new DefaultMapStorage();
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.579 -0500", hash_original_method = "A0A2E6205BB60A092B8D66A75357AACD", hash_generated_method = "D3C0F00EDFA68771E24688DA13682235")
    
private AreaCodeMapStorageStrategy createFlyweightMapStorage() {
    return new FlyweightMapStorage();
  }

  /**
   * Gets the smaller area code map storage strategy according to the provided area code map. It
   * actually uses (outputs the data to a stream) both strategies and retains the best one which
   * make this method quite expensive.
   */
  // @VisibleForTesting
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.581 -0500", hash_original_method = "F7090ADB0D57C526EAAF391F3C19F58E", hash_generated_method = "F7090ADB0D57C526EAAF391F3C19F58E")
    
AreaCodeMapStorageStrategy getSmallerMapStorage(SortedMap<Integer, String> areaCodeMap) {
    try {
      AreaCodeMapStorageStrategy flyweightMapStorage = createFlyweightMapStorage();
      int sizeOfFlyweightMapStorage = getSizeOfAreaCodeMapStorage(flyweightMapStorage, areaCodeMap);

      AreaCodeMapStorageStrategy defaultMapStorage = createDefaultMapStorage();
      int sizeOfDefaultMapStorage = getSizeOfAreaCodeMapStorage(defaultMapStorage, areaCodeMap);

      return sizeOfFlyweightMapStorage < sizeOfDefaultMapStorage
          ? flyweightMapStorage : defaultMapStorage;
    } catch (IOException e) {
      LOGGER.severe(e.getMessage());
      return createFlyweightMapStorage();
    }
  }

  /**
   * Creates an {@link AreaCodeMap} initialized with {@code sortedAreaCodeMap}.  Note that the
   * underlying implementation of this method is expensive thus should not be called by
   * time-critical applications.
   *
   * @param sortedAreaCodeMap  a map from phone number prefixes to descriptions of corresponding
   *     geographical areas, sorted in ascending order of the phone number prefixes as integers.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.583 -0500", hash_original_method = "B49B377AC81241FFFF2815B40FB81171", hash_generated_method = "121EB050167F0F0A2CB786925B824439")
    
public void readAreaCodeMap(SortedMap<Integer, String> sortedAreaCodeMap) {
    areaCodeMapStorage = getSmallerMapStorage(sortedAreaCodeMap);
  }

  /**
   * Supports Java Serialization.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.585 -0500", hash_original_method = "E451B33DF0760BCBC0A94001216332F0", hash_generated_method = "61DC1FEC35105D4CA9CB72BF594E062E")
    
public void readExternal(ObjectInput objectInput) throws IOException {
    // Read the area code map storage strategy flag.
    boolean useFlyweightMapStorage = objectInput.readBoolean();
    if (useFlyweightMapStorage) {
      areaCodeMapStorage = new FlyweightMapStorage();
    } else {
      areaCodeMapStorage = new DefaultMapStorage();
    }
    areaCodeMapStorage.readExternal(objectInput);
  }

  /**
   * Supports Java Serialization.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.587 -0500", hash_original_method = "E6F2985648B73053281BC07D9BFD7460", hash_generated_method = "AE67E77026FB90BEAB4F6A3069598601")
    
public void writeExternal(ObjectOutput objectOutput) throws IOException {
    objectOutput.writeBoolean(areaCodeMapStorage.isFlyweight());
    areaCodeMapStorage.writeExternal(objectOutput);
  }

  /**
   * Returns the description of the geographical area the {@code number} corresponds to.
   *
   * @param number  the phone number to look up
   * @return  the description of the geographical area
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.591 -0500", hash_original_method = "C66AA501CE9C84CB206C0DD0D1F37167", hash_generated_method = "C66AA501CE9C84CB206C0DD0D1F37167")
    
String lookup(PhoneNumber number) {
    int numOfEntries = areaCodeMapStorage.getNumOfEntries();
    if (numOfEntries == 0) {
      return "";
    }
    long phonePrefix =
        Long.parseLong(number.getCountryCode() + phoneUtil.getNationalSignificantNumber(number));
    int currentIndex = numOfEntries - 1;
    SortedSet<Integer> currentSetOfLengths = areaCodeMapStorage.getPossibleLengths();
    while (currentSetOfLengths.size() > 0) {
      Integer possibleLength = currentSetOfLengths.last();
      String phonePrefixStr = String.valueOf(phonePrefix);
      if (phonePrefixStr.length() > possibleLength) {
        phonePrefix = Long.parseLong(phonePrefixStr.substring(0, possibleLength));
      }
      currentIndex = binarySearch(0, currentIndex, phonePrefix);
      if (currentIndex < 0) {
        return "";
      }
      int currentPrefix = areaCodeMapStorage.getPrefix(currentIndex);
      if (phonePrefix == currentPrefix) {
        return areaCodeMapStorage.getDescription(currentIndex);
      }
      currentSetOfLengths = currentSetOfLengths.headSet(possibleLength);
    }
    return "";
  }

  /**
   * Does a binary search for {@code value} in the provided array from {@code start} to {@code end}
   * (inclusive). Returns the position if {@code value} is found; otherwise, returns the
   * position which has the largest value that is less than {@code value}. This means if
   * {@code value} is the smallest, -1 will be returned.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.594 -0500", hash_original_method = "D192E9C758CA69648AA3FDEEAB806454", hash_generated_method = "18C829A4A8DE5396E093073CF5829DC1")
    
private int binarySearch(int start, int end, long value) {
    int current = 0;
    while (start <= end) {
      current = (start + end) >>> 1;
      int currentValue = areaCodeMapStorage.getPrefix(current);
      if (currentValue == value) {
        return current;
      } else if (currentValue > value) {
        current--;
        end = current;
      } else {
        start = current + 1;
      }
    }
    return current;
  }

  /**
   * Dumps the mappings contained in the area code map.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.597 -0500", hash_original_method = "23EEAC8EFBFA0286A27EC362841462A0", hash_generated_method = "DA24FCBDA3F16A02AD5B756164919AFC")
    
@Override
  public String toString() {
    return areaCodeMapStorage.toString();
  }
}

