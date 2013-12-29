package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;



public class PhoneNumberOfflineGeocoder {

  /**
   * Gets a {@link PhoneNumberOfflineGeocoder} instance to carry out international phone number
   * geocoding.
   *
   * <p> The {@link PhoneNumberOfflineGeocoder} is implemented as a singleton. Therefore, calling
   * this method multiple times will only result in one instance being created.
   *
   * @return  a {@link PhoneNumberOfflineGeocoder} instance
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.720 -0500", hash_original_method = "11308A387889B73C32B03C7C263563B6", hash_generated_method = "2B8705EE691AE17B84209E4C26A63A00")
    public static synchronized PhoneNumberOfflineGeocoder getInstance() {
    if (instance == null) {
      instance = new PhoneNumberOfflineGeocoder(MAPPING_DATA_DIRECTORY);
    }
    return instance;
  }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.709 -0500", hash_original_field = "65568D69E39EDF65707973EA7704E506", hash_generated_field = "E956C1F9B0B8D1D3733E94DD57FB1DEA")

  private static PhoneNumberOfflineGeocoder instance = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.710 -0500", hash_original_field = "3552DE049BC9ACABC5A0FCA6C3EB05A1", hash_generated_field = "0FB1175094D23C4E6E63D4DF27FF59A7")

  private static final String MAPPING_DATA_DIRECTORY =
      "/com/android/i18n/phonenumbers/geocoding/data/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.711 -0500", hash_original_field = "0B5120767A9FB15828BEBC877EC31DF5", hash_generated_field = "97B9B12074A1BC1CA5A6C6270FD6D366")

  private static final Logger LOGGER = Logger.getLogger(PhoneNumberOfflineGeocoder.class.getName());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.712 -0500", hash_original_field = "77B7FB9FF47C6498ED40292699F59FD1", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")


  private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.713 -0500", hash_original_field = "243A08E8BE8BA33A48E49C999E36965E", hash_generated_field = "92760DB70C2CE2B3E4C70D256B78E2F9")

  private  String phonePrefixDataDirectory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.713 -0500", hash_original_field = "E7CF358F36BEACE242E3A08DA22BFFA5", hash_generated_field = "5E8FC64FA6B02B2C1A842BDDC26D6803")

  // prefix mapping file is available in the file system, so that a file can be loaded when needed.
  private MappingFileProvider mappingFileProvider = new MappingFileProvider();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.714 -0500", hash_original_field = "2F9B4B387963561B66B6E628F4CCC4EB", hash_generated_field = "D8CF386F4866B8E30469ABC1BC31059D")

  // loaded.
  private Map<String, AreaCodeMap> availablePhonePrefixMaps = new HashMap<String, AreaCodeMap>();

  // @VisibleForTesting
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.715 -0500", hash_original_method = "22A2DBF8A31EE9DB065525841631FE26", hash_generated_method = "22A2DBF8A31EE9DB065525841631FE26")
    PhoneNumberOfflineGeocoder(String phonePrefixDataDirectory) {
    this.phonePrefixDataDirectory = phonePrefixDataDirectory;
    loadMappingFileProvider();
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.716 -0500", hash_original_method = "E1BB23E7722226D1F2FA0A624B863E50", hash_generated_method = "C90AD66BFB0F3CD6B159C88404A96968")
    private void loadMappingFileProvider() {
    InputStream source =
        PhoneNumberOfflineGeocoder.class.getResourceAsStream(phonePrefixDataDirectory + "config");
    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(source);
      mappingFileProvider.readExternal(in);
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, e.toString());
    } finally {
      close(in);
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.717 -0500", hash_original_method = "83306CA98099E8F54D458F6E7B135EF3", hash_generated_method = "E4F232503E3B16A15B2324CC5801DE2F")
    private AreaCodeMap getPhonePrefixDescriptions(
      int countryCallingCode, String language, String script, String region) {
    String fileName = mappingFileProvider.getFileName(countryCallingCode, language, script, region);
    if (fileName.length() == 0) {
      return null;
    }
    if (!availablePhonePrefixMaps.containsKey(fileName)) {
      loadAreaCodeMapFromFile(fileName);
    }
    return availablePhonePrefixMaps.get(fileName);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.718 -0500", hash_original_method = "2B0DD58A818613E514EB671D31CFE754", hash_generated_method = "E4DD1BE5359D5C4E35805998FC232B2B")
    private void loadAreaCodeMapFromFile(String fileName) {
    InputStream source =
        PhoneNumberOfflineGeocoder.class.getResourceAsStream(phonePrefixDataDirectory + fileName);
    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(source);
      AreaCodeMap map = new AreaCodeMap();
      map.readExternal(in);
      availablePhonePrefixMaps.put(fileName, map);
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, e.toString());
    } finally {
      close(in);
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.719 -0500", hash_original_method = "A1113EBAB3D0682FE612F1231142344C", hash_generated_method = "AE3245B2725FCEC74728EDFA1A599E40")
    private void close(InputStream in) {
    if (in != null) {
      try {
        in.close();
      } catch (IOException e) {
        LOGGER.log(Level.WARNING, e.toString());
      }
    }
  }

  /**
   * Returns the customary display name in the given language for the given territory the phone
   * number is from.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.721 -0500", hash_original_method = "BFC255CAA5852747525F7A463403B75F", hash_generated_method = "5E246E1D734705125312F8B71BE424A7")
    private String getCountryNameForNumber(PhoneNumber number, Locale language) {
    String regionCode = phoneUtil.getRegionCodeForNumber(number);
    return (regionCode == null || regionCode.equals("ZZ"))
        ? "" : new Locale("", regionCode).getDisplayCountry(language);
  }

  /**
   * Returns a text description for the given language code for the given phone number. The
   * description might consist of the name of the country where the phone number is from and/or the
   * name of the geographical area the phone number is from. This method assumes the validity of the
   * number passed in has already been checked.
   *
   * @param number  a valid phone number for which we want to get a text description
   * @param languageCode  the language code for which the description should be written
   * @return  a text description for the given language code for the given phone number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.721 -0500", hash_original_method = "F67DBDA157A908486C2CB4AE34C3AE55", hash_generated_method = "DC062AA4E465B53C882475105941E671")
    public String getDescriptionForValidNumber(PhoneNumber number, Locale languageCode) {
    String langStr = languageCode.getLanguage();
    String scriptStr = "";  // No script is specified
    String regionStr = languageCode.getCountry();

    String areaDescription =
        getAreaDescriptionForNumber(number, langStr, scriptStr, regionStr);
    return (areaDescription.length() > 0)
        ? areaDescription : getCountryNameForNumber(number, languageCode);
  }

  /**
   * Returns a text description for the given language code for the given phone number. The
   * description might consist of the name of the country where the phone number is from and/or the
   * name of the geographical area the phone number is from. This method explictly checkes the
   * validity of the number passed in.
   *
   * @param number  the phone number for which we want to get a text description
   * @param languageCode  the language code for which the description should be written
   * @return  a text description for the given language code for the given phone number, or empty
   *     string if the number passed in is invalid
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.722 -0500", hash_original_method = "C5758C9E624EBA9DEEAB32D591791FD6", hash_generated_method = "B2204E3EFC787F119E0BEAED9A2BCA7B")
    public String getDescriptionForNumber(PhoneNumber number, Locale languageCode) {
    if (!phoneUtil.isValidNumber(number)) {
      return "";
    }
    return getDescriptionForValidNumber(number, languageCode);
  }

  /**
   * Returns an area-level text description in the given language for the given phone number.
   *
   * @param number  the phone number for which we want to get a text description
   * @param lang  two-letter lowercase ISO language codes as defined by ISO 639-1
   * @param script  four-letter titlecase (the first letter is uppercase and the rest of the letters
   *     are lowercase) ISO script codes as defined in ISO 15924
   * @param region  two-letter uppercase ISO country codes as defined by ISO 3166-1
   * @return  an area-level text description in the given language for the given phone number, or an
   *     empty string if such a description is not available
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.723 -0500", hash_original_method = "0C41F4A14E4338A7839D0DC3A0BBE9E6", hash_generated_method = "A79E2872AFA3AB9F4CF42F8387DE692F")
    private String getAreaDescriptionForNumber(
      PhoneNumber number, String lang, String script, String region) {
    int countryCallingCode = number.getCountryCode();
    // As the NANPA data is split into multiple files covering 3-digit areas, use a phone number
    // prefix of 4 digits for NANPA instead, e.g. 1650.
    int phonePrefix = (countryCallingCode != 1) ?
        countryCallingCode : (1000 + (int) (number.getNationalNumber() / 10000000));
    AreaCodeMap phonePrefixDescriptions =
        getPhonePrefixDescriptions(phonePrefix, lang, script, region);
    return (phonePrefixDescriptions != null) ? phonePrefixDescriptions.lookup(number) : "";
  }
}

