package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class MappingFileProvider implements Externalizable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.135 -0500", hash_original_field = "242BE32CA84E9DE0901B0ABC120A2CEA", hash_generated_field = "98909880D8EAD8B8385A6005C50C5E65")

  private static  Map<String, String> LOCALE_NORMALIZATION_MAP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.128 -0500", hash_original_field = "00F1381F548F3A5295097F2401ADFC52", hash_generated_field = "3E0B4451FC75BFBEA7BE0888ADA52D93")

  private int numOfEntries = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.130 -0500", hash_original_field = "D31F3760FA588B3120206AC80519C001", hash_generated_field = "5D843B062DC0F709662151020D18BCC2")

  private int[] countryCallingCodes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.132 -0500", hash_original_field = "A4D45AB2AD56C87C531397805771C9A0", hash_generated_field = "297401D4476B3C0539FAD27EE481B768")

  private List<Set<String>> availableLanguages;

  /**
   * Creates an empty {@link MappingFileProvider}. The default constructor is necessary for
   * implementing {@link Externalizable}. The empty provider could later be populated by
   * {@link #readFileConfigs(java.util.SortedMap)} or {@link #readExternal(java.io.ObjectInput)}.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.137 -0500", hash_original_method = "8FB53B01F748B2BCB846F8E0ABF1A4BF", hash_generated_method = "113E1FE8A1E6BE8880D11B9E05256657")
    
public MappingFileProvider() {
  }

  /**
   * Initializes an {@link MappingFileProvider} with {@code availableDataFiles}.
   *
   * @param availableDataFiles  a map from country calling codes to sets of languages in which data
   *     files are available for the specific country calling code. The map is sorted in ascending
   *     order of the country calling codes as integers.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.140 -0500", hash_original_method = "2C1785672959EEFC03879AF7408DB866", hash_generated_method = "2F682F22C2DAF57E8C95165F90BF5063")
    
public void readFileConfigs(SortedMap<Integer, Set<String>> availableDataFiles) {
    numOfEntries = availableDataFiles.size();
    countryCallingCodes = new int[numOfEntries];
    availableLanguages = new ArrayList<Set<String>>(numOfEntries);
    int index = 0;
    for (int countryCallingCode : availableDataFiles.keySet()) {
      countryCallingCodes[index++] = countryCallingCode;
      availableLanguages.add(new HashSet<String>(availableDataFiles.get(countryCallingCode)));
    }
  }

  /**
   * Supports Java Serialization.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.143 -0500", hash_original_method = "A5B4139EF2A7D591E843D1D3DA56504C", hash_generated_method = "490E40B28DAF1C41715EE733C1CCE6DF")
    
public void readExternal(ObjectInput objectInput) throws IOException {
    numOfEntries = objectInput.readInt();
    if (countryCallingCodes == null || countryCallingCodes.length < numOfEntries) {
      countryCallingCodes = new int[numOfEntries];
    }
    if (availableLanguages == null) {
      availableLanguages = new ArrayList<Set<String>>();
    }
    for (int i = 0; i < numOfEntries; i++) {
      countryCallingCodes[i] = objectInput.readInt();
      int numOfLangs = objectInput.readInt();
      Set<String> setOfLangs = new HashSet<String>();
      for (int j = 0; j < numOfLangs; j++) {
        setOfLangs.add(objectInput.readUTF());
      }
      availableLanguages.add(setOfLangs);
    }
  }

  /**
   * Supports Java Serialization.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.145 -0500", hash_original_method = "E326CA0D62F025609F12A4A9B87E4431", hash_generated_method = "8EA038D25A6CA65C7B835AD3C41DCE6D")
    
public void writeExternal(ObjectOutput objectOutput) throws IOException {
    objectOutput.writeInt(numOfEntries);
    for (int i = 0; i < numOfEntries; i++) {
      objectOutput.writeInt(countryCallingCodes[i]);
      Set<String> setOfLangs = availableLanguages.get(i);
      int numOfLangs = setOfLangs.size();
      objectOutput.writeInt(numOfLangs);
      for (String lang : setOfLangs) {
        objectOutput.writeUTF(lang);
      }
    }
  }

  /**
   * Returns a string representing the data in this class. The string contains one line for each
   * country calling code. The country calling code is followed by a '|' and then a list of
   * comma-separated languages sorted in ascending order.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.148 -0500", hash_original_method = "17C0EB7BC2271962455DE53D535BEB5E", hash_generated_method = "F5DA2469AC3754FE916038AE7ABFBEE5")
    
@Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < numOfEntries; i++) {
      output.append(countryCallingCodes[i]);
      output.append('|');
      SortedSet<String> sortedSetOfLangs = new TreeSet<String>(availableLanguages.get(i));
      for (String lang : sortedSetOfLangs) {
        output.append(lang);
        output.append(',');
      }
      output.append('\n');
    }
    return output.toString();
  }

  /**
   * Gets the name of the file that contains the mapping data for the {@code countryCallingCode} in
   * the language specified.
   *
   * @param countryCallingCode  the country calling code of phone numbers which the data file
   *     contains
   * @param language  two-letter lowercase ISO language codes as defined by ISO 639-1
   * @param script  four-letter titlecase (the first letter is uppercase and the rest of the letters
   *     are lowercase) ISO script codes as defined in ISO 15924
   * @param region  two-letter uppercase ISO country codes as defined by ISO 3166-1
   * @return  the name of the file, or empty string if no such file can be found
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.150 -0500", hash_original_method = "F40661B16774EA00988010D992802DCB", hash_generated_method = "F40661B16774EA00988010D992802DCB")
    
String getFileName(int countryCallingCode, String language, String script, String region) {
    if (language.length() == 0) {
      return "";
    }
    int index = Arrays.binarySearch(countryCallingCodes, countryCallingCode);
    if (index < 0) {
      return "";
    }
    Set<String> setOfLangs = availableLanguages.get(index);
    if (setOfLangs.size() > 0) {
      String languageCode = findBestMatchingLanguageCode(setOfLangs, language, script, region);
      if (languageCode.length() > 0) {
        StringBuilder fileName = new StringBuilder();
        fileName.append(countryCallingCode).append('_').append(languageCode);
        return fileName.toString();
      }
    }
    return "";
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.153 -0500", hash_original_method = "18F97AE37D6D32FF4C5E8DE16502349B", hash_generated_method = "9A558B04B751C441C72BE513FB41C1B5")
    
private String findBestMatchingLanguageCode(
      Set<String> setOfLangs, String language, String script, String region) {
    StringBuilder fullLocale = constructFullLocale(language, script, region);
    String fullLocaleStr = fullLocale.toString();
    String normalizedLocale = LOCALE_NORMALIZATION_MAP.get(fullLocaleStr);
    if (normalizedLocale != null) {
      if (setOfLangs.contains(normalizedLocale)) {
        return normalizedLocale;
      }
    }
    if (setOfLangs.contains(fullLocaleStr)) {
      return fullLocaleStr;
    }

    if (onlyOneOfScriptOrRegionIsEmpty(script, region)) {
      if (setOfLangs.contains(language)) {
        return language;
      }
    } else if (script.length() > 0 && region.length() > 0) {
      StringBuilder langWithScript = new StringBuilder(language).append('_').append(script);
      String langWithScriptStr = langWithScript.toString();
      if (setOfLangs.contains(langWithScriptStr)) {
        return langWithScriptStr;
      }

      StringBuilder langWithRegion = new StringBuilder(language).append('_').append(region);
      String langWithRegionStr = langWithRegion.toString();
      if (setOfLangs.contains(langWithRegionStr)) {
        return langWithRegionStr;
      }

      if (setOfLangs.contains(language)) {
        return language;
      }
    }
    return "";
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.156 -0500", hash_original_method = "AAED8563DDED3C53862CE4371524442C", hash_generated_method = "7C004154730EA0AB439CF10D45190DA5")
    
private boolean onlyOneOfScriptOrRegionIsEmpty(String script, String region) {
    return (script.length() == 0 && region.length() > 0) ||
            (region.length() == 0 && script.length() > 0);
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.158 -0500", hash_original_method = "67AD4EAACC19DF5D4391EFA1CE27EABA", hash_generated_method = "0CB4D1F6B2111F0FFAA02160FEA4EA48")
    
private StringBuilder constructFullLocale(String language, String script, String region) {
    StringBuilder fullLocale = new StringBuilder(language);
    appendSubsequentLocalePart(script, fullLocale);
    appendSubsequentLocalePart(region, fullLocale);
    return fullLocale;
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.160 -0500", hash_original_method = "A3149B7498B5162CA69A1D6F38AF4B31", hash_generated_method = "416E345B4AD7758BDDB75B399C26D9FC")
    
private void appendSubsequentLocalePart(String subsequentLocalePart, StringBuilder fullLocale) {
    if (subsequentLocalePart.length() > 0) {
      fullLocale.append('_').append(subsequentLocalePart);
    }
  }
    static {
    Map<String, String> normalizationMap = new HashMap<String, String>();
    normalizationMap.put("zh_TW", "zh_Hant");
    normalizationMap.put("zh_HK", "zh_Hant");
    normalizationMap.put("zh_MO", "zh_Hant");
    LOCALE_NORMALIZATION_MAP = Collections.unmodifiableMap(normalizationMap);
  }
    
}

