package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadataCollection;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneNumberDesc;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.711 -0400", hash_original_field = "E8745D64C3DDF690DBE72A168636F59F", hash_generated_field = "01E27589414D4F00E028D65F7226ED03")

    private String currentFilePrefix = META_DATA_FILE_PREFIX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.711 -0400", hash_original_field = "B57D2492E5166B044429F301D8A74EA1", hash_generated_field = "BD442BEB298EC056D47850ADBC00339A")

    private Map<Integer, List<String>> countryCallingCodeToRegionCodeMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.711 -0400", hash_original_field = "4F55F961D3BC9EA226649AD63B138E32", hash_generated_field = "AF59DC1D69ACA2D63C961BADD3CABDD3")

    private Set<String> supportedRegions = new HashSet<String>(300);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.711 -0400", hash_original_field = "8675D15B1E320E731CDACFDFD78EBF22", hash_generated_field = "2BD0A47904E1D6D0B88D2E387D27606C")

    private Set<String> nanpaRegions = new HashSet<String>(35);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.711 -0400", hash_original_field = "67B854AC1D3C388AC75FA01E35F25AAD", hash_generated_field = "C70A62DF8D5A926B48A934D799DB3D1E")

    private Map<String, PhoneMetadata> regionToMetadataMap = Collections.synchronizedMap(new HashMap<String, PhoneMetadata>());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.711 -0400", hash_original_field = "4955B1F9986A64262B91DC1CEA30A4DA", hash_generated_field = "D87E3F8DA6908FEB810F4EC6D5D33CCE")

    private RegexCache regexCache = new RegexCache(100);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.719 -0400", hash_original_method = "3DBAF8008FFD9E53011E9436972AF77A", hash_generated_method = "E3CE9121B94C12BEE25C8B5EDF30F992")
    private  PhoneNumberUtil() {
        // ---------- Original Method ----------
    }

    
        private static String createExtnPattern(String singleExtnSymbols) {
        return (RFC3966_EXTN_PREFIX + CAPTURING_EXTN_DIGITS + "|" + "[ \u00A0\\t,]*" +
            "(?:ext(?:ensi(?:o\u0301?|\u00F3))?n?|\uFF45\uFF58\uFF54\uFF4E?|" +
            "[" + singleExtnSymbols + "]|int|anexo|\uFF49\uFF4E\uFF54)" +
            "[:\\.\uFF0E]?[ \u00A0\\t,-]*" + CAPTURING_EXTN_DIGITS + "#?|" +
            "[- ]+(" + DIGITS + "{1,5})#");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.728 -0400", hash_original_method = "E42A7007FDB19817C28C648F3339DD4F", hash_generated_method = "4261582F9080D5A9B09B857FD714526C")
    private void init(String filePrefix) {
        currentFilePrefix = filePrefix;
        {
            Iterator<List<String>> var778680903355374D2ABCD15DF60BF74B_2011349308 = (countryCallingCodeToRegionCodeMap.values()).iterator();
            var778680903355374D2ABCD15DF60BF74B_2011349308.hasNext();
            List<String> regionCodes = var778680903355374D2ABCD15DF60BF74B_2011349308.next();
            {
                supportedRegions.addAll(regionCodes);
            } //End block
        } //End collapsed parenthetic
        nanpaRegions.addAll(countryCallingCodeToRegionCodeMap.get(NANPA_COUNTRY_CODE));
        // ---------- Original Method ----------
        //currentFilePrefix = filePrefix;
        //for (List<String> regionCodes : countryCallingCodeToRegionCodeMap.values()) {
      //supportedRegions.addAll(regionCodes);
    //}
        //nanpaRegions.addAll(countryCallingCodeToRegionCodeMap.get(NANPA_COUNTRY_CODE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.774 -0400", hash_original_method = "D4A5DED95C2EE22965F522507C270AF5", hash_generated_method = "A38D230ED483BF52F6092383F2518B69")
    private void loadMetadataForRegionFromFile(String filePrefix, String regionCode) {
        InputStream source;
        source = PhoneNumberUtil.class.getResourceAsStream(filePrefix + "_" + regionCode);
        ObjectInputStream in;
        in = null;
        try 
        {
            in = new ObjectInputStream(source);
            PhoneMetadataCollection metadataCollection;
            metadataCollection = new PhoneMetadataCollection();
            metadataCollection.readExternal(in);
            {
                Iterator<PhoneMetadata> var0ED4A94BB8726E6BB60B0FB5A23A1BC6_1095372525 = (metadataCollection.getMetadataList()).iterator();
                var0ED4A94BB8726E6BB60B0FB5A23A1BC6_1095372525.hasNext();
                PhoneMetadata metadata = var0ED4A94BB8726E6BB60B0FB5A23A1BC6_1095372525.next();
                {
                    regionToMetadataMap.put(regionCode, metadata);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            LOGGER.log(Level.WARNING, e.toString());
        } //End block
        finally 
        {
            close(in);
        } //End block
        addTaint(filePrefix.getTaint());
        addTaint(regionCode.getTaint());
        // ---------- Original Method ----------
        //InputStream source =
        //PhoneNumberUtil.class.getResourceAsStream(filePrefix + "_" + regionCode);
        //ObjectInputStream in = null;
        //try {
      //in = new ObjectInputStream(source);
      //PhoneMetadataCollection metadataCollection = new PhoneMetadataCollection();
      //metadataCollection.readExternal(in);
      //for (PhoneMetadata metadata : metadataCollection.getMetadataList()) {
        //regionToMetadataMap.put(regionCode, metadata);
      //}
    //} catch (IOException e) {
      //LOGGER.log(Level.WARNING, e.toString());
    //} finally {
      //close(in);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.775 -0400", hash_original_method = "A1113EBAB3D0682FE612F1231142344C", hash_generated_method = "823D516066EE954167408BC1E65F4A41")
    private void close(InputStream in) {
        {
            try 
            {
                in.close();
            } //End block
            catch (IOException e)
            {
                LOGGER.log(Level.WARNING, e.toString());
            } //End block
        } //End block
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //if (in != null) {
      //try {
        //in.close();
      //} catch (IOException e) {
        //LOGGER.log(Level.WARNING, e.toString());
      //}
    //}
    }

    
        static String extractPossibleNumber(String number) {
        Matcher m = VALID_START_CHAR_PATTERN.matcher(number);
        if (m.find()) {
      number = number.substring(m.start());
      Matcher trailingCharsMatcher = UNWANTED_END_CHAR_PATTERN.matcher(number);
      if (trailingCharsMatcher.find()) {
        number = number.substring(0, trailingCharsMatcher.start());
        LOGGER.log(Level.FINER, "Stripped trailing characters: " + number);
      }
      Matcher secondNumber = SECOND_NUMBER_START_PATTERN.matcher(number);
      if (secondNumber.find()) {
        number = number.substring(0, secondNumber.start());
      }
      return number;
    } else {
      return "";
    }
    }

    
        static boolean isViablePhoneNumber(String number) {
        if (number.length() < MIN_LENGTH_FOR_NSN) {
      return false;
    }
        Matcher m = VALID_PHONE_NUMBER_PATTERN.matcher(number);
        return m.matches();
    }

    
        static String normalize(String number) {
        Matcher m = VALID_ALPHA_PHONE_PATTERN.matcher(number);
        if (m.matches()) {
      return normalizeHelper(number, ALPHA_PHONE_MAPPINGS, true);
    } else {
      return normalizeDigitsOnly(number);
    }
    }

    
        static void normalize(StringBuilder number) {
        String normalizedNumber = normalize(number.toString());
        number.replace(0, number.length(), normalizedNumber);
    }

    
        public static String normalizeDigitsOnly(String number) {
        return normalizeDigits(number, false ).toString();
    }

    
        private static StringBuilder normalizeDigits(String number, boolean keepNonDigits) {
        StringBuilder normalizedDigits = new StringBuilder(number.length());
        for (char c : number.toCharArray()) {
      int digit = Character.digit(c, 10);
      if (digit != -1) {
        normalizedDigits.append(digit);
      } else if (keepNonDigits) {
        normalizedDigits.append(c);
      }
    }
        return normalizedDigits;
    }

    
        public static String convertAlphaCharactersInNumber(String number) {
        return normalizeHelper(number, ALPHA_PHONE_MAPPINGS, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.777 -0400", hash_original_method = "E944B5FE31AE1466662F85766A880CA9", hash_generated_method = "8C52CC6295A830F6674D53821EB778F4")
    public int getLengthOfGeographicalAreaCode(PhoneNumber number) {
        String regionCode;
        regionCode = getRegionCodeForNumber(number);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1535031296 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        {
            boolean var0F19B7C791578713C08B724D7EF83463_766104436 = (!metadata.hasNationalPrefix());
        } //End collapsed parenthetic
        PhoneNumberType type;
        type = getNumberTypeHelper(getNationalSignificantNumber(number),
                                               metadata);
        int var1A7583635198F8188F31B01169649F72_306452697 = (getLengthOfNationalDestinationCode(number));
        addTaint(number.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272889838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272889838;
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //if (!isValidRegionCode(regionCode)) {
      //return 0;
    //}
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //if (!metadata.hasNationalPrefix()) {
      //return 0;
    //}
        //PhoneNumberType type = getNumberTypeHelper(getNationalSignificantNumber(number),
                                               //metadata);
        //if (type != PhoneNumberType.FIXED_LINE && type != PhoneNumberType.FIXED_LINE_OR_MOBILE) {
      //return 0;
    //}
        //return getLengthOfNationalDestinationCode(number);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.777 -0400", hash_original_method = "8F375C460DFE06AB35507021B2E67F57", hash_generated_method = "96476B14C5D9825689B831E189875E5C")
    public int getLengthOfNationalDestinationCode(PhoneNumber number) {
        PhoneNumber copiedProto;
        {
            boolean varA0334A328D5A78F314E250C07987CBB9_1493926957 = (number.hasExtension());
            {
                copiedProto = new PhoneNumber();
                copiedProto.mergeFrom(number);
                copiedProto.clearExtension();
            } //End block
            {
                copiedProto = number;
            } //End block
        } //End collapsed parenthetic
        String nationalSignificantNumber;
        nationalSignificantNumber = format(copiedProto,
                                              PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        String[] numberGroups;
        numberGroups = NON_DIGITS_PATTERN.split(nationalSignificantNumber);
        {
            boolean varB39750E63BD6A0A6A4462637FFDF05DA_1037496179 = (getRegionCodeForNumber(number).equals("AR") &&
        getNumberType(number) == PhoneNumberType.MOBILE);
            {
                int varBE9BA5C465177F729DAFFF7C34A984CE_1851606651 = (numberGroups[3].length() + 1);
            } //End block
        } //End collapsed parenthetic
        int var9AE7A3309C2132BA3FD6101ABCDB2E2F_2060512098 = (numberGroups[2].length());
        addTaint(number.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805654690 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805654690;
        // ---------- Original Method ----------
        //PhoneNumber copiedProto;
        //if (number.hasExtension()) {
      //copiedProto = new PhoneNumber();
      //copiedProto.mergeFrom(number);
      //copiedProto.clearExtension();
    //} else {
      //copiedProto = number;
    //}
        //String nationalSignificantNumber = format(copiedProto,
                                              //PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        //String[] numberGroups = NON_DIGITS_PATTERN.split(nationalSignificantNumber);
        //if (numberGroups.length <= 3) {
      //return 0;
    //}
        //if (getRegionCodeForNumber(number).equals("AR") &&
        //getNumberType(number) == PhoneNumberType.MOBILE) {
      //return numberGroups[3].length() + 1;
    //}
        //return numberGroups[2].length();
    }

    
        private static String normalizeHelper(String number,
                                        Map<Character, Character> normalizationReplacements,
                                        boolean removeNonMatches) {
        StringBuilder normalizedNumber = new StringBuilder(number.length());
        char[] numberAsCharArray = number.toCharArray();
        for (char character : numberAsCharArray) {
      Character newDigit = normalizationReplacements.get(Character.toUpperCase(character));
      if (newDigit != null) {
        normalizedNumber.append(newDigit);
      } else if (!removeNonMatches) {
        normalizedNumber.append(character);
      }
    }
        return normalizedNumber.toString();
    }

    
        static synchronized PhoneNumberUtil getInstance(
      String baseFileLocation,
      Map<Integer, List<String>> countryCallingCodeToRegionCodeMap) {
        if (instance == null) {
      instance = new PhoneNumberUtil();
      instance.countryCallingCodeToRegionCodeMap = countryCallingCodeToRegionCodeMap;
      instance.init(baseFileLocation);
    }
        return instance;
    }

    
        static synchronized void resetInstance() {
        instance = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.779 -0400", hash_original_method = "8806D3371D9E306571E478F8E387F5F6", hash_generated_method = "05FB2B00B34070A583E2B0BAEDD70946")
    public Set<String> getSupportedRegions() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_2011883373 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2011883373 = supportedRegions;
        varB4EAC82CA7396A68D541C85D26508E83_2011883373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2011883373;
        // ---------- Original Method ----------
        //return supportedRegions;
    }

    
        public static synchronized PhoneNumberUtil getInstance() {
        if (instance == null) {
      return getInstance(META_DATA_FILE_PREFIX,
          CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
    }
        return instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.780 -0400", hash_original_method = "BD64224247A46B4F8D1913B12FB0926A", hash_generated_method = "2EB8D356165D0A1D6AEB73E2210BFC43")
    private boolean isValidRegionCode(String regionCode) {
        boolean var7DED5D1C831FA25A1913B196FCADCCAC_1895287340 = (regionCode != null && supportedRegions.contains(regionCode));
        addTaint(regionCode.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241219348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241219348;
        // ---------- Original Method ----------
        //return regionCode != null && supportedRegions.contains(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.781 -0400", hash_original_method = "8968A71862E924379D457A4D52F2E514", hash_generated_method = "BEAAE65FD0E671C21645A3E30822749D")
    private boolean hasValidRegionCode(String regionCode,
                                     int countryCallingCode, String number) {
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_999900020 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.WARNING,
                 "Number " + number + " has invalid or missing country calling code ("
                 + countryCallingCode + ")");
            } //End block
        } //End collapsed parenthetic
        addTaint(regionCode.getTaint());
        addTaint(countryCallingCode);
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1909124424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1909124424;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //LOGGER.log(Level.WARNING,
                 //"Number " + number + " has invalid or missing country calling code ("
                 //+ countryCallingCode + ")");
      //return false;
    //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.782 -0400", hash_original_method = "92F92B14F8645805E8F2936964CC9FBD", hash_generated_method = "00F7BA9979D3A543233122D0D72C9FB9")
    public String format(PhoneNumber number, PhoneNumberFormat numberFormat) {
        String varB4EAC82CA7396A68D541C85D26508E83_1719237101 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1100892068 = null; //Variable for return #2
        {
            boolean varC5703F7758E4CCF6C68B52402D8E9ACF_327185073 = (number.getNationalNumber() == 0 && number.hasRawInput());
            {
                String rawInput;
                rawInput = number.getRawInput();
                {
                    boolean var555F97EE0F80891C0AF723C26C2ED746_1372778826 = (rawInput.length() > 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1719237101 = rawInput;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        StringBuilder formattedNumber;
        formattedNumber = new StringBuilder(20);
        format(number, numberFormat, formattedNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1100892068 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(numberFormat.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1315467096; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1315467096 = varB4EAC82CA7396A68D541C85D26508E83_1719237101;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1315467096 = varB4EAC82CA7396A68D541C85D26508E83_1100892068;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1315467096.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1315467096;
        // ---------- Original Method ----------
        //if (number.getNationalNumber() == 0 && number.hasRawInput()) {
      //String rawInput = number.getRawInput();
      //if (rawInput.length() > 0) {
        //return rawInput;
      //}
    //}
        //StringBuilder formattedNumber = new StringBuilder(20);
        //format(number, numberFormat, formattedNumber);
        //return formattedNumber.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.786 -0400", hash_original_method = "0E0E29DD0B07020C65FE41B70E3EF74E", hash_generated_method = "0611240AAFC85D2E7AB62D4B5E2F1CCC")
    public void format(PhoneNumber number, PhoneNumberFormat numberFormat,
                     StringBuilder formattedNumber) {
        formattedNumber.setLength(0);
        int countryCallingCode;
        countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            formattedNumber.append(nationalSignificantNumber);
            formatNumberByFormat(countryCallingCode, PhoneNumberFormat.E164, formattedNumber);
        } //End block
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCallingCode);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1615046727 = (!isValidRegionCode(regionCode));
            {
                formattedNumber.append(nationalSignificantNumber);
            } //End block
        } //End collapsed parenthetic
        formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode, numberFormat));
        maybeGetFormattedExtension(number, regionCode, numberFormat, formattedNumber);
        formatNumberByFormat(countryCallingCode, numberFormat, formattedNumber);
        addTaint(number.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(formattedNumber.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.855 -0400", hash_original_method = "9F9F17BED2EE6CF557E830A9924BD1F5", hash_generated_method = "C45DB75AC443A4EA52AB64DF9356CB1A")
    public String formatByPattern(PhoneNumber number,
                                PhoneNumberFormat numberFormat,
                                List<NumberFormat> userDefinedFormats) {
        String varB4EAC82CA7396A68D541C85D26508E83_1036056909 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1508978046 = null; //Variable for return #2
        int countryCallingCode;
        countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCallingCode);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_1031499560 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1036056909 = nationalSignificantNumber;
            } //End block
        } //End collapsed parenthetic
        List<NumberFormat> userDefinedFormatsCopy;
        userDefinedFormatsCopy = new ArrayList<NumberFormat>(userDefinedFormats.size());
        {
            Iterator<NumberFormat> varDE538608319C22BEA07652839B747B9B_1453828139 = (userDefinedFormats).iterator();
            varDE538608319C22BEA07652839B747B9B_1453828139.hasNext();
            NumberFormat numFormat = varDE538608319C22BEA07652839B747B9B_1453828139.next();
            {
                String nationalPrefixFormattingRule;
                nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
                {
                    boolean var49F508BC12F9753C65EDF4F4D8419A12_864286322 = (nationalPrefixFormattingRule.length() > 0);
                    {
                        NumberFormat numFormatCopy;
                        numFormatCopy = new NumberFormat();
                        numFormatCopy.mergeFrom(numFormat);
                        String nationalPrefix;
                        nationalPrefix = getMetadataForRegion(regionCode).getNationalPrefix();
                        {
                            boolean var4F43214BACA2879442D7C6FFEA040E27_1452433983 = (nationalPrefix.length() > 0);
                            {
                                nationalPrefixFormattingRule =
              NP_PATTERN.matcher(nationalPrefixFormattingRule).replaceFirst(nationalPrefix);
                                nationalPrefixFormattingRule =
              FG_PATTERN.matcher(nationalPrefixFormattingRule).replaceFirst("\\$1");
                                numFormatCopy.setNationalPrefixFormattingRule(nationalPrefixFormattingRule);
                            } //End block
                            {
                                numFormatCopy.clearNationalPrefixFormattingRule();
                            } //End block
                        } //End collapsed parenthetic
                        userDefinedFormatsCopy.add(numFormatCopy);
                    } //End block
                    {
                        userDefinedFormatsCopy.add(numFormat);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        StringBuilder formattedNumber;
        formattedNumber = new StringBuilder(formatAccordingToFormats(nationalSignificantNumber,
                                                   userDefinedFormatsCopy,
                                                   numberFormat));
        maybeGetFormattedExtension(number, regionCode, numberFormat, formattedNumber);
        formatNumberByFormat(countryCallingCode, numberFormat, formattedNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1508978046 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(userDefinedFormats.getTaint());
        String varA7E53CE21691AB073D9660D615818899_445464017; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_445464017 = varB4EAC82CA7396A68D541C85D26508E83_1036056909;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_445464017 = varB4EAC82CA7396A68D541C85D26508E83_1508978046;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_445464017.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_445464017;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.870 -0400", hash_original_method = "91C4446CD1D629D514A31D665364644B", hash_generated_method = "50C312ED1FC6940671B8A9E6EEC4EDE0")
    public String formatNationalNumberWithCarrierCode(PhoneNumber number, String carrierCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_302507062 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1625957545 = null; //Variable for return #2
        int countryCallingCode;
        countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCallingCode);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_1746318069 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_302507062 = nationalSignificantNumber;
            } //End block
        } //End collapsed parenthetic
        StringBuilder formattedNumber;
        formattedNumber = new StringBuilder(20);
        formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode,
                                                PhoneNumberFormat.NATIONAL,
                                                carrierCode));
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.NATIONAL, formattedNumber);
        formatNumberByFormat(countryCallingCode, PhoneNumberFormat.NATIONAL, formattedNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1625957545 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(carrierCode.getTaint());
        String varA7E53CE21691AB073D9660D615818899_151455152; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_151455152 = varB4EAC82CA7396A68D541C85D26508E83_302507062;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_151455152 = varB4EAC82CA7396A68D541C85D26508E83_1625957545;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_151455152.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_151455152;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.871 -0400", hash_original_method = "4CA1ACD2C86EAA8A1981D39B6D2FA7BC", hash_generated_method = "23B08B52D89F74991D2145CAC5ABA49C")
    public String formatNationalNumberWithPreferredCarrierCode(PhoneNumber number,
                                                             String fallbackCarrierCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_1010703868 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1010703868 = formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       ? number.getPreferredDomesticCarrierCode()
                                                       : fallbackCarrierCode);
        addTaint(number.getTaint());
        addTaint(fallbackCarrierCode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1010703868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1010703868;
        // ---------- Original Method ----------
        //return formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       //? number.getPreferredDomesticCarrierCode()
                                                       //: fallbackCarrierCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.881 -0400", hash_original_method = "F62393BCCF4A49D66E11EE7D750D9FD1", hash_generated_method = "DDA44340B499C6985894E71F42F28A2A")
    public String formatOutOfCountryCallingNumber(PhoneNumber number,
                                                String regionCallingFrom) {
        String varB4EAC82CA7396A68D541C85D26508E83_1115316199 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1130202050 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_895536105 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1994412021 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_793421115 = null; //Variable for return #5
        {
            boolean varD048F64EC3C8401D282F486A6CF615B6_355812474 = (!isValidRegionCode(regionCallingFrom));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1115316199 = format(number, PhoneNumberFormat.INTERNATIONAL);
            } //End block
        } //End collapsed parenthetic
        int countryCallingCode;
        countryCallingCode = number.getCountryCode();
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCallingCode);
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_1642778267 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1130202050 = nationalSignificantNumber;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var87EDDF67CA1AA758C72D3792FA55B762_1917653672 = (isNANPACountry(regionCallingFrom));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_895536105 = countryCallingCode + " " + format(number, PhoneNumberFormat.NATIONAL);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var33EA6E04A6ABE181DFBBC2046931D651_889029388 = (countryCallingCode == getCountryCodeForRegion(regionCallingFrom));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1994412021 = format(number, PhoneNumberFormat.NATIONAL);
            } //End block
        } //End collapsed parenthetic
        String formattedNationalNumber;
        formattedNationalNumber = formatNationalNumber(nationalSignificantNumber,
                             regionCode, PhoneNumberFormat.INTERNATIONAL);
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCallingFrom);
        String internationalPrefix;
        internationalPrefix = metadata.getInternationalPrefix();
        String internationalPrefixForFormatting;
        internationalPrefixForFormatting = "";
        {
            boolean var98D851996F7DA14EE57E4E408EF3864D_1607962444 = (UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches());
            {
                internationalPrefixForFormatting = internationalPrefix;
            } //End block
            {
                boolean var5BD90B38377E183DFAF5B829C5613FB1_2023845301 = (metadata.hasPreferredInternationalPrefix());
                {
                    internationalPrefixForFormatting = metadata.getPreferredInternationalPrefix();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        StringBuilder formattedNumber;
        formattedNumber = new StringBuilder(formattedNationalNumber);
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
        {
            boolean varF0253AB64B70C1C22F5442932A86160B_93623757 = (internationalPrefixForFormatting.length() > 0);
            {
                formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, " ")
          .insert(0, internationalPrefixForFormatting);
            } //End block
            {
                formatNumberByFormat(countryCallingCode,
                           PhoneNumberFormat.INTERNATIONAL,
                           formattedNumber);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_793421115 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(regionCallingFrom.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1778360094; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1778360094 = varB4EAC82CA7396A68D541C85D26508E83_1115316199;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1778360094 = varB4EAC82CA7396A68D541C85D26508E83_1130202050;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1778360094 = varB4EAC82CA7396A68D541C85D26508E83_895536105;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1778360094 = varB4EAC82CA7396A68D541C85D26508E83_1994412021;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1778360094 = varB4EAC82CA7396A68D541C85D26508E83_793421115;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1778360094.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1778360094;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.889 -0400", hash_original_method = "DB42BF938772B1A7D3909F64DD7B67BB", hash_generated_method = "8C898B7F6DF0C4311052775460A1B7C0")
    public String formatInOriginalFormat(PhoneNumber number, String regionCallingFrom) {
        String varB4EAC82CA7396A68D541C85D26508E83_1216151743 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1555946386 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_540215864 = null; //Variable for return #3
        {
            boolean var2BA36454AB1825117E50288B4F67202D_2095356781 = (number.hasRawInput() &&
        (!hasFormattingPatternForNumber(number) || !isValidNumber(number)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1216151743 = number.getRawInput();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6C260429A491FE6501FBF10C9A9A3E9D_621534009 = (!number.hasCountryCodeSource());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1555946386 = format(number, PhoneNumberFormat.NATIONAL);
            } //End block
        } //End collapsed parenthetic
        String formattedNumber;
        {
            Object var3EC150F242A1103FEA1720F610B2B6E4_587343363 = (number.getCountryCodeSource());
            //Begin case FROM_NUMBER_WITH_PLUS_SIGN 
            formattedNumber = format(number, PhoneNumberFormat.INTERNATIONAL);
            //End case FROM_NUMBER_WITH_PLUS_SIGN 
            //Begin case FROM_NUMBER_WITH_IDD 
            formattedNumber = formatOutOfCountryCallingNumber(number, regionCallingFrom);
            //End case FROM_NUMBER_WITH_IDD 
            //Begin case FROM_NUMBER_WITHOUT_PLUS_SIGN 
            formattedNumber = format(number, PhoneNumberFormat.INTERNATIONAL).substring(1);
            //End case FROM_NUMBER_WITHOUT_PLUS_SIGN 
            //Begin case FROM_DEFAULT_COUNTRY default 
            formattedNumber = format(number, PhoneNumberFormat.NATIONAL);
            //End case FROM_DEFAULT_COUNTRY default 
        } //End collapsed parenthetic
        String rawInput;
        rawInput = number.getRawInput();
        varB4EAC82CA7396A68D541C85D26508E83_540215864 = (formattedNumber != null &&
            normalizeDigitsOnly(formattedNumber).equals(normalizeDigitsOnly(rawInput)))
        ? formattedNumber
        : rawInput;
        addTaint(number.getTaint());
        addTaint(regionCallingFrom.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1493673531; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1493673531 = varB4EAC82CA7396A68D541C85D26508E83_1216151743;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1493673531 = varB4EAC82CA7396A68D541C85D26508E83_1555946386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1493673531 = varB4EAC82CA7396A68D541C85D26508E83_540215864;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1493673531.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1493673531;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.897 -0400", hash_original_method = "52E7EF7A7F940E41CFECD8D7BD9FA23C", hash_generated_method = "AA5FA37C8D32C4E5E871719584747441")
    private boolean hasFormattingPatternForNumber(PhoneNumber number) {
        String phoneNumberRegion;
        phoneNumberRegion = getRegionCodeForCountryCode(number.getCountryCode());
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(phoneNumberRegion);
        String nationalNumber;
        nationalNumber = getNationalSignificantNumber(number);
        NumberFormat formatRule;
        formatRule = chooseFormattingPatternForNumber(metadata.numberFormats(), nationalNumber);
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947869719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947869719;
        // ---------- Original Method ----------
        //String phoneNumberRegion = getRegionCodeForCountryCode(number.getCountryCode());
        //PhoneMetadata metadata = getMetadataForRegion(phoneNumberRegion);
        //if (metadata == null) {
      //return false;
    //}
        //String nationalNumber = getNationalSignificantNumber(number);
        //NumberFormat formatRule =
        //chooseFormattingPatternForNumber(metadata.numberFormats(), nationalNumber);
        //return formatRule != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.053 -0400", hash_original_method = "4891B65BEA4A6D1403DAAAE11CCEEA80", hash_generated_method = "6CE3FE2062D65C91719F476258CCDA6F")
    public String formatOutOfCountryKeepingAlphaChars(PhoneNumber number,
                                                    String regionCallingFrom) {
        String varB4EAC82CA7396A68D541C85D26508E83_925625807 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_627947215 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_849963724 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1611387458 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1035178609 = null; //Variable for return #5
        String rawInput;
        rawInput = number.getRawInput();
        {
            boolean var56DE431416D41900B1A303BCD67165AA_1091330440 = (rawInput.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_925625807 = formatOutOfCountryCallingNumber(number, regionCallingFrom);
            } //End block
        } //End collapsed parenthetic
        int countryCode;
        countryCode = number.getCountryCode();
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCode);
        {
            boolean var6C6A5128B4A4E275737546ABC3B84693_439261259 = (!hasValidRegionCode(regionCode, countryCode, rawInput));
            {
                varB4EAC82CA7396A68D541C85D26508E83_627947215 = rawInput;
            } //End block
        } //End collapsed parenthetic
        rawInput = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String nationalNumber;
        nationalNumber = getNationalSignificantNumber(number);
        {
            boolean var24E952CC2DF3F15DA6E7744CA1ED0F83_477980297 = (nationalNumber.length() > 3);
            {
                int firstNationalNumberDigit;
                firstNationalNumberDigit = rawInput.indexOf(nationalNumber.substring(0, 3));
                {
                    rawInput = rawInput.substring(firstNationalNumberDigit);
                } //End block
            } //End block
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCallingFrom);
        {
            {
                boolean var87EDDF67CA1AA758C72D3792FA55B762_1575931143 = (isNANPACountry(regionCallingFrom));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_849963724 = countryCode + " " + rawInput;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varC1B02B78273EEA3A2D0CE66FFC6E6BDD_1543563529 = (countryCode == getCountryCodeForRegion(regionCallingFrom));
            {
                List<NumberFormat> availableFormats;
                availableFormats = new ArrayList<NumberFormat>(metadata.numberFormatSize());
                {
                    Iterator<NumberFormat> varC31BFE89CF3320F5E66FDF28F0557A8C_1463365712 = (metadata.numberFormats()).iterator();
                    varC31BFE89CF3320F5E66FDF28F0557A8C_1463365712.hasNext();
                    NumberFormat format = varC31BFE89CF3320F5E66FDF28F0557A8C_1463365712.next();
                    {
                        NumberFormat newFormat;
                        newFormat = new NumberFormat();
                        newFormat.mergeFrom(format);
                        newFormat.setPattern("(\\d+)(.*)");
                        newFormat.setFormat("$1$2");
                        availableFormats.add(newFormat);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1611387458 = formatAccordingToFormats(rawInput, availableFormats, PhoneNumberFormat.NATIONAL);
            } //End block
        } //End collapsed parenthetic
        String internationalPrefix;
        internationalPrefix = metadata.getInternationalPrefix();
        String internationalPrefixForFormatting;
        boolean var6BBFED3C02F379AC58D09B7252F4F751_1727425365 = (UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches());
        internationalPrefixForFormatting = internationalPrefix;
        internationalPrefixForFormatting = metadata.getPreferredInternationalPrefix();
        StringBuilder formattedNumber;
        formattedNumber = new StringBuilder(rawInput);
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
        {
            boolean varF0253AB64B70C1C22F5442932A86160B_1289543017 = (internationalPrefixForFormatting.length() > 0);
            {
                formattedNumber.insert(0, " ").insert(0, countryCode).insert(0, " ")
          .insert(0, internationalPrefixForFormatting);
            } //End block
            {
                formatNumberByFormat(countryCode,
                           PhoneNumberFormat.INTERNATIONAL,
                           formattedNumber);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1035178609 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(regionCallingFrom.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1679988812; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1679988812 = varB4EAC82CA7396A68D541C85D26508E83_925625807;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1679988812 = varB4EAC82CA7396A68D541C85D26508E83_627947215;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1679988812 = varB4EAC82CA7396A68D541C85D26508E83_849963724;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1679988812 = varB4EAC82CA7396A68D541C85D26508E83_1611387458;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1679988812 = varB4EAC82CA7396A68D541C85D26508E83_1035178609;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1679988812.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1679988812;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.062 -0400", hash_original_method = "D5C4512E5E6006B319585FD039F0D2D2", hash_generated_method = "5282263260A5BEEDC2DC8AA8556B41AB")
    public String getNationalSignificantNumber(PhoneNumber number) {
        String varB4EAC82CA7396A68D541C85D26508E83_544870875 = null; //Variable for return #1
        StringBuilder nationalNumber;
        nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");//DSFIXME:  CODE0008: Nested ternary operator in expression
        nationalNumber.append(number.getNationalNumber());
        varB4EAC82CA7396A68D541C85D26508E83_544870875 = nationalNumber.toString();
        addTaint(number.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_544870875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_544870875;
        // ---------- Original Method ----------
        //StringBuilder nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");
        //nationalNumber.append(number.getNationalNumber());
        //return nationalNumber.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.063 -0400", hash_original_method = "B30288467474491802F599221421F5DD", hash_generated_method = "25BA4C9E4452F6803D88A74F10F9E993")
    private void formatNumberByFormat(int countryCallingCode,
                                    PhoneNumberFormat numberFormat,
                                    StringBuilder formattedNumber) {
        //Begin case E164 
        formattedNumber.insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        //End case E164 
        //Begin case INTERNATIONAL 
        formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        //End case INTERNATIONAL 
        //Begin case RFC3966 
        formattedNumber.insert(0, "-").insert(0, countryCallingCode) .insert(0, PLUS_SIGN);
        //End case RFC3966 
        addTaint(countryCallingCode);
        addTaint(numberFormat.getTaint());
        addTaint(formattedNumber.getTaint());
        // ---------- Original Method ----------
        //switch (numberFormat) {
      //case E164:
        //formattedNumber.insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        //return;
      //case INTERNATIONAL:
        //formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        //return;
      //case RFC3966:
        //formattedNumber.insert(0, "-").insert(0, countryCallingCode) .insert(0, PLUS_SIGN);
        //return;
      //case NATIONAL:
      //default:
        //return;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.063 -0400", hash_original_method = "E72DB4CB518547F268CF62BAEDE813DC", hash_generated_method = "5C45B08802D6699DD87DABE29BDEC4BF")
    private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat) {
        String varB4EAC82CA7396A68D541C85D26508E83_602052200 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_602052200 = formatNationalNumber(number, regionCode, numberFormat, null);
        addTaint(number.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(numberFormat.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_602052200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_602052200;
        // ---------- Original Method ----------
        //return formatNationalNumber(number, regionCode, numberFormat, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.064 -0400", hash_original_method = "C233FF64EBF86F393338B595D4311670", hash_generated_method = "B4FBE5DB73DDC48C0C63FF9F110AACFF")
    private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat,
                                      String carrierCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_1674378528 = null; //Variable for return #1
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        List<NumberFormat> intlNumberFormats;
        intlNumberFormats = metadata.intlNumberFormats();
        List<NumberFormat> availableFormats;
        boolean var010176D6E07BAFEEE15C51961F359715_1512333673 = ((intlNumberFormats.size() == 0 || numberFormat == PhoneNumberFormat.NATIONAL));
        availableFormats = metadata.numberFormats();
        availableFormats = metadata.intlNumberFormats();
        String formattedNationalNumber;
        formattedNationalNumber = formatAccordingToFormats(number, availableFormats, numberFormat, carrierCode);
        {
            formattedNationalNumber =
          SEPARATOR_PATTERN.matcher(formattedNationalNumber).replaceAll("-");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1674378528 = formattedNationalNumber;
        addTaint(number.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(carrierCode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1674378528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1674378528;
        // ---------- Original Method ----------
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //List<NumberFormat> intlNumberFormats = metadata.intlNumberFormats();
        //List<NumberFormat> availableFormats =
        //(intlNumberFormats.size() == 0 || numberFormat == PhoneNumberFormat.NATIONAL)
        //? metadata.numberFormats()
        //: metadata.intlNumberFormats();
        //String formattedNationalNumber =
        //formatAccordingToFormats(number, availableFormats, numberFormat, carrierCode);
        //if (numberFormat == PhoneNumberFormat.RFC3966) {
      //formattedNationalNumber =
          //SEPARATOR_PATTERN.matcher(formattedNationalNumber).replaceAll("-");
    //}
        //return formattedNationalNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.105 -0400", hash_original_method = "8234956A6CF3F674EC2E620926354B88", hash_generated_method = "98A31085D65DE7E293CE36CE7F0DB7EC")
    private NumberFormat chooseFormattingPatternForNumber(List<NumberFormat> availableFormats,
                                                        String nationalNumber) {
        NumberFormat varB4EAC82CA7396A68D541C85D26508E83_864369832 = null; //Variable for return #1
        NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1457237600 = null; //Variable for return #2
        {
            Iterator<NumberFormat> varF2F667EBE5B32705ED5F28A1B5BB1A9A_1220039077 = (availableFormats).iterator();
            varF2F667EBE5B32705ED5F28A1B5BB1A9A_1220039077.hasNext();
            NumberFormat numFormat = varF2F667EBE5B32705ED5F28A1B5BB1A9A_1220039077.next();
            {
                int size;
                size = numFormat.leadingDigitsPatternSize();
                {
                    boolean var70C01298E9B9CEE3566223FF0F4729C7_1691016391 = (size == 0 || regexCache.getPatternForRegex(
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt());
                    {
                        Matcher m;
                        m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                        {
                            boolean var21FF6A85D73745B4A18613C0C4E00A23_32486994 = (m.matches());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_864369832 = numFormat;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1457237600 = null;
        addTaint(availableFormats.getTaint());
        addTaint(nationalNumber.getTaint());
        NumberFormat varA7E53CE21691AB073D9660D615818899_502077460; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_502077460 = varB4EAC82CA7396A68D541C85D26508E83_864369832;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_502077460 = varB4EAC82CA7396A68D541C85D26508E83_1457237600;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_502077460.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_502077460;
        // ---------- Original Method ----------
        //for (NumberFormat numFormat : availableFormats) {
      //int size = numFormat.leadingDigitsPatternSize();
      //if (size == 0 || regexCache.getPatternForRegex(
              //numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt()) {
        //Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
        //if (m.matches()) {
          //return numFormat;
        //}
      //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.106 -0400", hash_original_method = "ABA7814B1012D26F514E5605C0CC3287", hash_generated_method = "039257B3E5E8550EF7448B0A520E634E")
    private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat) {
        String varB4EAC82CA7396A68D541C85D26508E83_1795252301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1795252301 = formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null);
        addTaint(nationalNumber.getTaint());
        addTaint(availableFormats.getTaint());
        addTaint(numberFormat.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1795252301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1795252301;
        // ---------- Original Method ----------
        //return formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.173 -0400", hash_original_method = "58A13E9521CF391FA7B0E516ACC9ED0C", hash_generated_method = "6FBE8D36584146D8C2BE6F65E8EE2E90")
    private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat,
                                          String carrierCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_927272148 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_713873404 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_825841351 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_375596904 = null; //Variable for return #4
        {
            Iterator<NumberFormat> varF2F667EBE5B32705ED5F28A1B5BB1A9A_1038193193 = (availableFormats).iterator();
            varF2F667EBE5B32705ED5F28A1B5BB1A9A_1038193193.hasNext();
            NumberFormat numFormat = varF2F667EBE5B32705ED5F28A1B5BB1A9A_1038193193.next();
            {
                int size;
                size = numFormat.leadingDigitsPatternSize();
                {
                    boolean var70C01298E9B9CEE3566223FF0F4729C7_427834634 = (size == 0 || regexCache.getPatternForRegex(
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt());
                    {
                        Matcher m;
                        m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                        {
                            boolean var21FF6A85D73745B4A18613C0C4E00A23_498865005 = (m.matches());
                            {
                                String numberFormatRule;
                                numberFormatRule = numFormat.getFormat();
                                {
                                    boolean var27E963F632C52F6E62BE94BB8EF98A0C_2143477802 = (numberFormat == PhoneNumberFormat.NATIONAL &&
              carrierCode != null && carrierCode.length() > 0 &&
              numFormat.getDomesticCarrierCodeFormattingRule().length() > 0);
                                    {
                                        String carrierCodeFormattingRule;
                                        carrierCodeFormattingRule = numFormat.getDomesticCarrierCodeFormattingRule();
                                        carrierCodeFormattingRule =
                CC_PATTERN.matcher(carrierCodeFormattingRule).replaceFirst(carrierCode);
                                        numberFormatRule = FIRST_GROUP_PATTERN.matcher(numberFormatRule)
                .replaceFirst(carrierCodeFormattingRule);
                                        varB4EAC82CA7396A68D541C85D26508E83_927272148 = m.replaceAll(numberFormatRule);
                                    } //End block
                                    {
                                        String nationalPrefixFormattingRule;
                                        nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
                                        {
                                            boolean varFD5394A50BDD178AA2DA5B2252F56373_1070776628 = (numberFormat == PhoneNumberFormat.NATIONAL &&
                nationalPrefixFormattingRule != null &&
                nationalPrefixFormattingRule.length() > 0);
                                            {
                                                Matcher firstGroupMatcher;
                                                firstGroupMatcher = FIRST_GROUP_PATTERN.matcher(numberFormatRule);
                                                varB4EAC82CA7396A68D541C85D26508E83_713873404 = m.replaceAll(firstGroupMatcher.replaceFirst(nationalPrefixFormattingRule));
                                            } //End block
                                            {
                                                varB4EAC82CA7396A68D541C85D26508E83_825841351 = m.replaceAll(numberFormatRule);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_375596904 = nationalNumber;
        addTaint(nationalNumber.getTaint());
        addTaint(availableFormats.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(carrierCode.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1058569343; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1058569343 = varB4EAC82CA7396A68D541C85D26508E83_927272148;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1058569343 = varB4EAC82CA7396A68D541C85D26508E83_713873404;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1058569343 = varB4EAC82CA7396A68D541C85D26508E83_825841351;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1058569343 = varB4EAC82CA7396A68D541C85D26508E83_375596904;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1058569343.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1058569343;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.179 -0400", hash_original_method = "B3C328ACE4FF3869EFF5C65F569BC538", hash_generated_method = "AB962183DD081511ABECD35BFCEAF694")
    public PhoneNumber getExampleNumber(String regionCode) {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1741303629 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1741303629 = getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
        addTaint(regionCode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1741303629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1741303629;
        // ---------- Original Method ----------
        //return getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.184 -0400", hash_original_method = "B7676779AEFA9EF56CC59B101D8DF6C5", hash_generated_method = "45907E7B842AB03D6A50A863FB009A7E")
    public PhoneNumber getExampleNumberForType(String regionCode, PhoneNumberType type) {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1269097541 = null; //Variable for return #1
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1349086084 = null; //Variable for return #2
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1546137340 = null; //Variable for return #3
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_151579244 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.WARNING, "Invalid or unknown region code provided.");
                varB4EAC82CA7396A68D541C85D26508E83_1269097541 = null;
            } //End block
        } //End collapsed parenthetic
        PhoneNumberDesc desc;
        desc = getNumberDescByType(getMetadataForRegion(regionCode), type);
        try 
        {
            {
                boolean var332E3945C68B1E0C027A1E732CD697F2_561331645 = (desc.hasExampleNumber());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1349086084 = parse(desc.getExampleNumber(), regionCode);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (NumberParseException e)
        {
            LOGGER.log(Level.SEVERE, e.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1546137340 = null;
        addTaint(regionCode.getTaint());
        addTaint(type.getTaint());
        PhoneNumber varA7E53CE21691AB073D9660D615818899_1314078483; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1314078483 = varB4EAC82CA7396A68D541C85D26508E83_1269097541;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1314078483 = varB4EAC82CA7396A68D541C85D26508E83_1349086084;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1314078483 = varB4EAC82CA7396A68D541C85D26508E83_1546137340;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1314078483.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1314078483;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //LOGGER.log(Level.WARNING, "Invalid or unknown region code provided.");
      //return null;
    //}
        //PhoneNumberDesc desc = getNumberDescByType(getMetadataForRegion(regionCode), type);
        //try {
      //if (desc.hasExampleNumber()) {
        //return parse(desc.getExampleNumber(), regionCode);
      //}
    //} catch (NumberParseException e) {
      //LOGGER.log(Level.SEVERE, e.toString());
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.189 -0400", hash_original_method = "6C2C2EA977BB9169AEFD40896548847E", hash_generated_method = "C606302736B6EBDE57FC81237A798AC2")
    private void maybeGetFormattedExtension(PhoneNumber number, String regionCode,
                                          PhoneNumberFormat numberFormat,
                                          StringBuilder formattedNumber) {
        {
            boolean var6CC2B5EB06BA8F69F485F7B9578BCDBB_488644820 = (number.hasExtension() && number.getExtension().length() > 0);
            {
                {
                    formattedNumber.append(RFC3966_EXTN_PREFIX).append(number.getExtension());
                } //End block
                {
                    formatExtension(number.getExtension(), regionCode, formattedNumber);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(number.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(formattedNumber.getTaint());
        // ---------- Original Method ----------
        //if (number.hasExtension() && number.getExtension().length() > 0) {
      //if (numberFormat == PhoneNumberFormat.RFC3966) {
        //formattedNumber.append(RFC3966_EXTN_PREFIX).append(number.getExtension());
      //} else {
        //formatExtension(number.getExtension(), regionCode, formattedNumber);
      //}
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.190 -0400", hash_original_method = "4E1A69FB5E070DF7BC56976B37027181", hash_generated_method = "13975F0C754DDEE09A02E2A03741EDC5")
    private void formatExtension(String extensionDigits, String regionCode,
                               StringBuilder extension) {
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        {
            boolean varE40ED1FD3A4A1BCF90B2F107CACB31BD_326660742 = (metadata.hasPreferredExtnPrefix());
            {
                extension.append(metadata.getPreferredExtnPrefix()).append(extensionDigits);
            } //End block
            {
                extension.append(DEFAULT_EXTN_PREFIX).append(extensionDigits);
            } //End block
        } //End collapsed parenthetic
        addTaint(extensionDigits.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(extension.getTaint());
        // ---------- Original Method ----------
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //if (metadata.hasPreferredExtnPrefix()) {
      //extension.append(metadata.getPreferredExtnPrefix()).append(extensionDigits);
    //} else {
      //extension.append(DEFAULT_EXTN_PREFIX).append(extensionDigits);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.194 -0400", hash_original_method = "B508A0D4C9257AABA72DD1888D64C9E3", hash_generated_method = "CCB6D352AF56E3C83F7E142EBE18D874")
     PhoneNumberDesc getNumberDescByType(PhoneMetadata metadata, PhoneNumberType type) {
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_277318350 = null; //Variable for return #1
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1810057417 = null; //Variable for return #2
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1637758397 = null; //Variable for return #3
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_2086475842 = null; //Variable for return #4
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1221200799 = null; //Variable for return #5
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_602275863 = null; //Variable for return #6
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1843720718 = null; //Variable for return #7
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_959146522 = null; //Variable for return #8
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1178039889 = null; //Variable for return #9
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1685366731 = null; //Variable for return #10
        //Begin case PREMIUM_RATE 
        varB4EAC82CA7396A68D541C85D26508E83_277318350 = metadata.getPremiumRate();
        //End case PREMIUM_RATE 
        //Begin case TOLL_FREE 
        varB4EAC82CA7396A68D541C85D26508E83_1810057417 = metadata.getTollFree();
        //End case TOLL_FREE 
        //Begin case MOBILE 
        varB4EAC82CA7396A68D541C85D26508E83_1637758397 = metadata.getMobile();
        //End case MOBILE 
        //Begin case FIXED_LINE FIXED_LINE_OR_MOBILE 
        varB4EAC82CA7396A68D541C85D26508E83_2086475842 = metadata.getFixedLine();
        //End case FIXED_LINE FIXED_LINE_OR_MOBILE 
        //Begin case SHARED_COST 
        varB4EAC82CA7396A68D541C85D26508E83_1221200799 = metadata.getSharedCost();
        //End case SHARED_COST 
        //Begin case VOIP 
        varB4EAC82CA7396A68D541C85D26508E83_602275863 = metadata.getVoip();
        //End case VOIP 
        //Begin case PERSONAL_NUMBER 
        varB4EAC82CA7396A68D541C85D26508E83_1843720718 = metadata.getPersonalNumber();
        //End case PERSONAL_NUMBER 
        //Begin case PAGER 
        varB4EAC82CA7396A68D541C85D26508E83_959146522 = metadata.getPager();
        //End case PAGER 
        //Begin case UAN 
        varB4EAC82CA7396A68D541C85D26508E83_1178039889 = metadata.getUan();
        //End case UAN 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_1685366731 = metadata.getGeneralDesc();
        //End case default 
        addTaint(metadata.getTaint());
        addTaint(type.getTaint());
        PhoneNumberDesc varA7E53CE21691AB073D9660D615818899_349747421; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_277318350;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_1810057417;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_1637758397;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_2086475842;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_1221200799;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_602275863;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_1843720718;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_959146522;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_1178039889;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_349747421 = varB4EAC82CA7396A68D541C85D26508E83_1685366731;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_349747421.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_349747421;
        // ---------- Original Method ----------
        //switch (type) {
      //case PREMIUM_RATE:
        //return metadata.getPremiumRate();
      //case TOLL_FREE:
        //return metadata.getTollFree();
      //case MOBILE:
        //return metadata.getMobile();
      //case FIXED_LINE:
      //case FIXED_LINE_OR_MOBILE:
        //return metadata.getFixedLine();
      //case SHARED_COST:
        //return metadata.getSharedCost();
      //case VOIP:
        //return metadata.getVoip();
      //case PERSONAL_NUMBER:
        //return metadata.getPersonalNumber();
      //case PAGER:
        //return metadata.getPager();
      //case UAN:
        //return metadata.getUan();
      //default:
        //return metadata.getGeneralDesc();
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.199 -0400", hash_original_method = "261D2E3780968B6A389AA5653D83C66D", hash_generated_method = "3B262D9FF06B6DAF6D9BFD5AE4255330")
    public PhoneNumberType getNumberType(PhoneNumber number) {
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_33377850 = null; //Variable for return #1
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_749942380 = null; //Variable for return #2
        String regionCode;
        regionCode = getRegionCodeForNumber(number);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1554501591 = (!isValidRegionCode(regionCode));
            {
                varB4EAC82CA7396A68D541C85D26508E83_33377850 = PhoneNumberType.UNKNOWN;
            } //End block
        } //End collapsed parenthetic
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        varB4EAC82CA7396A68D541C85D26508E83_749942380 = getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode));
        addTaint(number.getTaint());
        PhoneNumberType varA7E53CE21691AB073D9660D615818899_221903313; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_221903313 = varB4EAC82CA7396A68D541C85D26508E83_33377850;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_221903313 = varB4EAC82CA7396A68D541C85D26508E83_749942380;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_221903313.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_221903313;
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //if (!isValidRegionCode(regionCode)) {
      //return PhoneNumberType.UNKNOWN;
    //}
        //String nationalSignificantNumber = getNationalSignificantNumber(number);
        //return getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.206 -0400", hash_original_method = "CFBB065FE396C61ECB0C897E1E4B66DC", hash_generated_method = "EE3C17B91601CD9721BD34E0F3119DE7")
    private PhoneNumberType getNumberTypeHelper(String nationalNumber, PhoneMetadata metadata) {
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1949089406 = null; //Variable for return #1
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_464484220 = null; //Variable for return #2
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_803020083 = null; //Variable for return #3
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1217755558 = null; //Variable for return #4
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1556903827 = null; //Variable for return #5
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1192388618 = null; //Variable for return #6
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1434678035 = null; //Variable for return #7
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1291360139 = null; //Variable for return #8
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_699570277 = null; //Variable for return #9
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_365886360 = null; //Variable for return #10
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1248220291 = null; //Variable for return #11
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_143223279 = null; //Variable for return #12
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_415646744 = null; //Variable for return #13
        PhoneNumberDesc generalNumberDesc;
        generalNumberDesc = metadata.getGeneralDesc();
        {
            boolean var5B173D1DFC1562F0020B057904EE0B3C_559399254 = (!generalNumberDesc.hasNationalNumberPattern() ||
        !isNumberMatchingDesc(nationalNumber, generalNumberDesc));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1949089406 = PhoneNumberType.UNKNOWN;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFC5517BA7F51C044D62329DD8DA33803_787346292 = (isNumberMatchingDesc(nationalNumber, metadata.getPremiumRate()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_464484220 = PhoneNumberType.PREMIUM_RATE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC1B0D4362E20F4D15396EDA203322A7B_1576766377 = (isNumberMatchingDesc(nationalNumber, metadata.getTollFree()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_803020083 = PhoneNumberType.TOLL_FREE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4050D2117B44C187237158BD69941F37_600815562 = (isNumberMatchingDesc(nationalNumber, metadata.getSharedCost()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1217755558 = PhoneNumberType.SHARED_COST;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391D271B9C8CED3D2BFA2E53ADE2C8A3_1029947135 = (isNumberMatchingDesc(nationalNumber, metadata.getVoip()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1556903827 = PhoneNumberType.VOIP;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBF02F0578A5A843F636ECA3493243BE6_92031508 = (isNumberMatchingDesc(nationalNumber, metadata.getPersonalNumber()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1192388618 = PhoneNumberType.PERSONAL_NUMBER;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var50FD2167C2C1685ED42EE82A11A93B25_1694713713 = (isNumberMatchingDesc(nationalNumber, metadata.getPager()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1434678035 = PhoneNumberType.PAGER;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var43080BFDC919D8A6AC3E511D3259EF4E_1027042667 = (isNumberMatchingDesc(nationalNumber, metadata.getUan()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1291360139 = PhoneNumberType.UAN;
            } //End block
        } //End collapsed parenthetic
        boolean isFixedLine;
        isFixedLine = isNumberMatchingDesc(nationalNumber, metadata.getFixedLine());
        {
            {
                boolean var54343FDE9F348C9E4056CCA96B123FA1_677116376 = (metadata.isSameMobileAndFixedLinePattern());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_699570277 = PhoneNumberType.FIXED_LINE_OR_MOBILE;
                } //End block
                {
                    boolean var0E0B18E4B567EBE5114CB7B2F558C5D5_1597753760 = (isNumberMatchingDesc(nationalNumber, metadata.getMobile()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_365886360 = PhoneNumberType.FIXED_LINE_OR_MOBILE;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1248220291 = PhoneNumberType.FIXED_LINE;
        } //End block
        {
            boolean varF3C8C9AD58504637AE43DDCCBED0DAE8_253192615 = (!metadata.isSameMobileAndFixedLinePattern() &&
        isNumberMatchingDesc(nationalNumber, metadata.getMobile()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_143223279 = PhoneNumberType.MOBILE;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_415646744 = PhoneNumberType.UNKNOWN;
        addTaint(nationalNumber.getTaint());
        addTaint(metadata.getTaint());
        PhoneNumberType varA7E53CE21691AB073D9660D615818899_1470630028; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_1949089406;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_464484220;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_803020083;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_1217755558;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_1556903827;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_1192388618;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_1434678035;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_1291360139;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_699570277;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_365886360;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_1248220291;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_143223279;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1470630028 = varB4EAC82CA7396A68D541C85D26508E83_415646744;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1470630028.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1470630028;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.207 -0400", hash_original_method = "B7D0F615A2820F4964EA69968467492C", hash_generated_method = "9BA1E9FC8EA5FCBDF62FDBA068AC3458")
     PhoneMetadata getMetadataForRegion(String regionCode) {
        PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1978937936 = null; //Variable for return #1
        PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_691072623 = null; //Variable for return #2
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_170418276 = (!isValidRegionCode(regionCode));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1978937936 = null;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var60A67063C3B37462B25FD4797CD4A0A0_1130351116 = (!regionToMetadataMap.containsKey(regionCode));
                {
                    loadMetadataForRegionFromFile(currentFilePrefix, regionCode);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_691072623 = regionToMetadataMap.get(regionCode);
        addTaint(regionCode.getTaint());
        PhoneMetadata varA7E53CE21691AB073D9660D615818899_1513354564; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1513354564 = varB4EAC82CA7396A68D541C85D26508E83_1978937936;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1513354564 = varB4EAC82CA7396A68D541C85D26508E83_691072623;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1513354564.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1513354564;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //return null;
    //}
        //synchronized (regionToMetadataMap) {
      //if (!regionToMetadataMap.containsKey(regionCode)) {
        //loadMetadataForRegionFromFile(currentFilePrefix, regionCode);
      //}
    //}
        //return regionToMetadataMap.get(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.216 -0400", hash_original_method = "B17A0514C43E05EB90EE98CA4CB42983", hash_generated_method = "CFD09C6BF558B1AFFAE128E0E974EC16")
    private boolean isNumberMatchingDesc(String nationalNumber, PhoneNumberDesc numberDesc) {
        Matcher possibleNumberPatternMatcher;
        possibleNumberPatternMatcher = regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            .matcher(nationalNumber);
        Matcher nationalNumberPatternMatcher;
        nationalNumberPatternMatcher = regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            .matcher(nationalNumber);
        boolean var59CBFCA142FE36DE1654CBFBCE0A5F21_1816366644 = (possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches());
        addTaint(nationalNumber.getTaint());
        addTaint(numberDesc.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858270112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858270112;
        // ---------- Original Method ----------
        //Matcher possibleNumberPatternMatcher =
        //regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            //.matcher(nationalNumber);
        //Matcher nationalNumberPatternMatcher =
        //regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            //.matcher(nationalNumber);
        //return possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.217 -0400", hash_original_method = "31ADC24E14E9CE703FF2777ACEC876BF", hash_generated_method = "D472A477EDDA69268465ADDAB63EDB71")
    public boolean isValidNumber(PhoneNumber number) {
        String regionCode;
        regionCode = getRegionCodeForNumber(number);
        boolean var28FBA9C4B7A68485B8D67ECFF42CF1EB_863858508 = ((isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode)));
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140685371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140685371;
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //return (isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.217 -0400", hash_original_method = "C701813EA11D8E6ADA1ECC6BB90E9747", hash_generated_method = "A6395E8414C792C952E0481BDC4DCE48")
    public boolean isValidNumberForRegion(PhoneNumber number, String regionCode) {
        {
            boolean var98525ED7F2835E26F2B24C7F8233B726_1233720198 = (number.getCountryCode() != getCountryCodeForRegion(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        PhoneNumberDesc generalNumDesc;
        generalNumDesc = metadata.getGeneralDesc();
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean var6BBB06AEDF976ADEC9072013B0735BB1_1166519208 = (!generalNumDesc.hasNationalNumberPattern());
            {
                int numberLength;
                numberLength = nationalSignificantNumber.length();
            } //End block
        } //End collapsed parenthetic
        boolean varDB2FE427898C8D8020D29E442EFBBBDB_740111251 = (getNumberTypeHelper(nationalSignificantNumber, metadata) != PhoneNumberType.UNKNOWN);
        addTaint(number.getTaint());
        addTaint(regionCode.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819268199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819268199;
        // ---------- Original Method ----------
        //if (number.getCountryCode() != getCountryCodeForRegion(regionCode)) {
      //return false;
    //}
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //PhoneNumberDesc generalNumDesc = metadata.getGeneralDesc();
        //String nationalSignificantNumber = getNationalSignificantNumber(number);
        //if (!generalNumDesc.hasNationalNumberPattern()) {
      //int numberLength = nationalSignificantNumber.length();
      //return numberLength > MIN_LENGTH_FOR_NSN && numberLength <= MAX_LENGTH_FOR_NSN;
    //}
        //return getNumberTypeHelper(nationalSignificantNumber, metadata) != PhoneNumberType.UNKNOWN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.222 -0400", hash_original_method = "C5C9CB0E93474118DAA9D7A65CA1060A", hash_generated_method = "53AA580EA01BB52EDB8AF897AEECD7D5")
    public String getRegionCodeForNumber(PhoneNumber number) {
        String varB4EAC82CA7396A68D541C85D26508E83_1161787148 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_614717483 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_707365070 = null; //Variable for return #3
        int countryCode;
        countryCode = number.getCountryCode();
        List<String> regions;
        regions = countryCallingCodeToRegionCodeMap.get(countryCode);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1161787148 = null;
        } //End block
        {
            boolean var10ED2DD9FF740B3AAF00BF9AEF0FF83C_1970165061 = (regions.size() == 1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_614717483 = regions.get(0);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_707365070 = getRegionCodeForNumberFromRegionList(number, regions);
            } //End block
        } //End collapsed parenthetic
        addTaint(number.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1813295266; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1813295266 = varB4EAC82CA7396A68D541C85D26508E83_1161787148;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1813295266 = varB4EAC82CA7396A68D541C85D26508E83_614717483;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1813295266 = varB4EAC82CA7396A68D541C85D26508E83_707365070;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1813295266.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1813295266;
        // ---------- Original Method ----------
        //int countryCode = number.getCountryCode();
        //List<String> regions = countryCallingCodeToRegionCodeMap.get(countryCode);
        //if (regions == null) {
      //return null;
    //}
        //if (regions.size() == 1) {
      //return regions.get(0);
    //} else {
      //return getRegionCodeForNumberFromRegionList(number, regions);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.285 -0400", hash_original_method = "814AB76683AFE761330E661D695A8B3F", hash_generated_method = "7C591840412B0FFE4A09B05593AFD7C3")
    private String getRegionCodeForNumberFromRegionList(PhoneNumber number,
                                                      List<String> regionCodes) {
        String varB4EAC82CA7396A68D541C85D26508E83_1753081745 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_480092684 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_299296592 = null; //Variable for return #3
        String nationalNumber;
        nationalNumber = getNationalSignificantNumber(number);
        {
            Iterator<String> varCBD98C0A7F219455C413F8EC0E9FF73F_1703029211 = (regionCodes).iterator();
            varCBD98C0A7F219455C413F8EC0E9FF73F_1703029211.hasNext();
            String regionCode = varCBD98C0A7F219455C413F8EC0E9FF73F_1703029211.next();
            {
                PhoneMetadata metadata;
                metadata = getMetadataForRegion(regionCode);
                {
                    boolean varF2BDE8A0B1D079F49328DAC6385FA645_1531536444 = (metadata.hasLeadingDigits());
                    {
                        {
                            boolean varAE03BEFF3A7C553963FE54EA102583D6_379136971 = (regexCache.getPatternForRegex(metadata.getLeadingDigits())
                .matcher(nationalNumber).lookingAt());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1753081745 = regionCode;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varF0EA7F11B601F2E7D21312C63A7500A8_265781582 = (getNumberTypeHelper(nationalNumber, metadata) != PhoneNumberType.UNKNOWN);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_480092684 = regionCode;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_299296592 = null;
        addTaint(number.getTaint());
        addTaint(regionCodes.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1861412626; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1861412626 = varB4EAC82CA7396A68D541C85D26508E83_1753081745;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1861412626 = varB4EAC82CA7396A68D541C85D26508E83_480092684;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1861412626 = varB4EAC82CA7396A68D541C85D26508E83_299296592;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1861412626.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1861412626;
        // ---------- Original Method ----------
        //String nationalNumber = getNationalSignificantNumber(number);
        //for (String regionCode : regionCodes) {
      //PhoneMetadata metadata = getMetadataForRegion(regionCode);
      //if (metadata.hasLeadingDigits()) {
        //if (regexCache.getPatternForRegex(metadata.getLeadingDigits())
                //.matcher(nationalNumber).lookingAt()) {
          //return regionCode;
        //}
      //} else if (getNumberTypeHelper(nationalNumber, metadata) != PhoneNumberType.UNKNOWN) {
        //return regionCode;
      //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.286 -0400", hash_original_method = "DA9951AEFEAF4242112AA6281301B32F", hash_generated_method = "7C11FF10F9506395F79596C3A880A5A9")
    public String getRegionCodeForCountryCode(int countryCallingCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_504432248 = null; //Variable for return #1
        List<String> regionCodes;
        regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
        varB4EAC82CA7396A68D541C85D26508E83_504432248 = regionCodes == null ? UNKNOWN_REGION : regionCodes.get(0);
        addTaint(countryCallingCode);
        varB4EAC82CA7396A68D541C85D26508E83_504432248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_504432248;
        // ---------- Original Method ----------
        //List<String> regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
        //return regionCodes == null ? UNKNOWN_REGION : regionCodes.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.287 -0400", hash_original_method = "D7076C7EB39C8978E29A5CA27F40EEC9", hash_generated_method = "557637CB919F85CFB20D01DE92456B09")
    public int getCountryCodeForRegion(String regionCode) {
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1297912029 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        int varDD48F4FF04794DCC6ACB188903D09223_1573304496 = (metadata.getCountryCode());
        addTaint(regionCode.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499974465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499974465;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //return 0;
    //}
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //return metadata.getCountryCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.288 -0400", hash_original_method = "E58B423D76AD6194B45901E123DB6EBF", hash_generated_method = "D57DFB20FF9B3AE89830B7BE2C430590")
    public String getNddPrefixForRegion(String regionCode, boolean stripNonDigits) {
        String varB4EAC82CA7396A68D541C85D26508E83_1509233725 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_80381786 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1273444188 = null; //Variable for return #3
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_2020069005 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.SEVERE, "Invalid or missing region code provided.");
                varB4EAC82CA7396A68D541C85D26508E83_1509233725 = null;
            } //End block
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        String nationalPrefix;
        nationalPrefix = metadata.getNationalPrefix();
        {
            boolean var01C0F06701D85CDE650BDE5E4D96FB06_1590424907 = (nationalPrefix.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_80381786 = null;
            } //End block
        } //End collapsed parenthetic
        {
            nationalPrefix = nationalPrefix.replace("~", "");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1273444188 = nationalPrefix;
        addTaint(regionCode.getTaint());
        addTaint(stripNonDigits);
        String varA7E53CE21691AB073D9660D615818899_1887021783; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1887021783 = varB4EAC82CA7396A68D541C85D26508E83_1509233725;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1887021783 = varB4EAC82CA7396A68D541C85D26508E83_80381786;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1887021783 = varB4EAC82CA7396A68D541C85D26508E83_1273444188;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1887021783.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1887021783;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //LOGGER.log(Level.SEVERE, "Invalid or missing region code provided.");
      //return null;
    //}
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //String nationalPrefix = metadata.getNationalPrefix();
        //if (nationalPrefix.length() == 0) {
      //return null;
    //}
        //if (stripNonDigits) {
      //nationalPrefix = nationalPrefix.replace("~", "");
    //}
        //return nationalPrefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.288 -0400", hash_original_method = "7B63C50F103D8DC60E8A2B15ED73A093", hash_generated_method = "C338155C61291C6CD825118F8A55F2B7")
    public boolean isNANPACountry(String regionCode) {
        boolean var8AEB4252BA8A65A9B8C3173CF2CBF7D8_1782546349 = (nanpaRegions.contains(regionCode));
        addTaint(regionCode.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814863841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814863841;
        // ---------- Original Method ----------
        //return nanpaRegions.contains(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.288 -0400", hash_original_method = "996B7AC837898451564E65CADA674F54", hash_generated_method = "68FC5D53EE9E197E516ABB33D06380CD")
     boolean isLeadingZeroPossible(int countryCallingCode) {
        PhoneMetadata mainMetadataForCallingCode;
        mainMetadataForCallingCode = getMetadataForRegion(
        getRegionCodeForCountryCode(countryCallingCode));
        boolean var8B12A904D1DB3A2A33A947A68C4B6146_486921644 = (mainMetadataForCallingCode.isLeadingZeroPossible());
        addTaint(countryCallingCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993655309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993655309;
        // ---------- Original Method ----------
        //PhoneMetadata mainMetadataForCallingCode = getMetadataForRegion(
        //getRegionCodeForCountryCode(countryCallingCode));
        //if (mainMetadataForCallingCode == null) {
      //return false;
    //}
        //return mainMetadataForCallingCode.isLeadingZeroPossible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.289 -0400", hash_original_method = "4B80DFBB3D3B298395671B1C8C6F67DA", hash_generated_method = "DE24AF2A91F898525F5F52FF6191DC2B")
    public boolean isAlphaNumber(String number) {
        {
            boolean var6F2D6DBE1E1842574CD6CB87FFC5DB6E_1197234104 = (!isViablePhoneNumber(number));
        } //End collapsed parenthetic
        StringBuilder strippedNumber;
        strippedNumber = new StringBuilder(number);
        maybeStripExtension(strippedNumber);
        boolean varAE4E32ECCF3EF15A647E2C1BB378DAA7_172294471 = (VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches());
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143283952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143283952;
        // ---------- Original Method ----------
        //if (!isViablePhoneNumber(number)) {
      //return false;
    //}
        //StringBuilder strippedNumber = new StringBuilder(number);
        //maybeStripExtension(strippedNumber);
        //return VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.289 -0400", hash_original_method = "86FEA4033CCC520A9BCC7CD67C884B0D", hash_generated_method = "82FA3EB5186D7081D9FD13BBDDC91C0D")
    public boolean isPossibleNumber(PhoneNumber number) {
        boolean varB638E1EBE041FE51ED0B48C92300B1AB_499564274 = (isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE);
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550481351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_550481351;
        // ---------- Original Method ----------
        //return isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.290 -0400", hash_original_method = "B3EB56A7047F0C0039433A6E9896FBEF", hash_generated_method = "E4060D3AB5A7C21E1CC271EA2970AA11")
    private ValidationResult testNumberLengthAgainstPattern(Pattern numberPattern, String number) {
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_327430345 = null; //Variable for return #1
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_162190035 = null; //Variable for return #2
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_658738414 = null; //Variable for return #3
        Matcher numberMatcher;
        numberMatcher = numberPattern.matcher(number);
        {
            boolean var71179D25353510F4890F375B5AE981E3_676035134 = (numberMatcher.matches());
            {
                varB4EAC82CA7396A68D541C85D26508E83_327430345 = ValidationResult.IS_POSSIBLE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var162373AA4FD3689E76A45288F34FBEF2_129902544 = (numberMatcher.lookingAt());
            {
                varB4EAC82CA7396A68D541C85D26508E83_162190035 = ValidationResult.TOO_LONG;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_658738414 = ValidationResult.TOO_SHORT;
            } //End block
        } //End collapsed parenthetic
        addTaint(numberPattern.getTaint());
        addTaint(number.getTaint());
        ValidationResult varA7E53CE21691AB073D9660D615818899_2073535552; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2073535552 = varB4EAC82CA7396A68D541C85D26508E83_327430345;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2073535552 = varB4EAC82CA7396A68D541C85D26508E83_162190035;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2073535552 = varB4EAC82CA7396A68D541C85D26508E83_658738414;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2073535552.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2073535552;
        // ---------- Original Method ----------
        //Matcher numberMatcher = numberPattern.matcher(number);
        //if (numberMatcher.matches()) {
      //return ValidationResult.IS_POSSIBLE;
    //}
        //if (numberMatcher.lookingAt()) {
      //return ValidationResult.TOO_LONG;
    //} else {
      //return ValidationResult.TOO_SHORT;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.307 -0400", hash_original_method = "5E4449198019FBA49E61EB3BB2D3E7CD", hash_generated_method = "E661E1FB4D15F0A5354B47157F9F47E7")
    public ValidationResult isPossibleNumberWithReason(PhoneNumber number) {
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_1483496066 = null; //Variable for return #1
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_1831694955 = null; //Variable for return #2
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_1280252166 = null; //Variable for return #3
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_242693568 = null; //Variable for return #4
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_676988707 = null; //Variable for return #5
        String nationalNumber;
        nationalNumber = getNationalSignificantNumber(number);
        int countryCode;
        countryCode = number.getCountryCode();
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCode);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1948774902 = (!isValidRegionCode(regionCode));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1483496066 = ValidationResult.INVALID_COUNTRY_CODE;
            } //End block
        } //End collapsed parenthetic
        PhoneNumberDesc generalNumDesc;
        generalNumDesc = getMetadataForRegion(regionCode).getGeneralDesc();
        {
            boolean var6BBB06AEDF976ADEC9072013B0735BB1_1611314202 = (!generalNumDesc.hasNationalNumberPattern());
            {
                LOGGER.log(Level.FINER, "Checking if number is possible with incomplete metadata.");
                int numberLength;
                numberLength = nationalNumber.length();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1831694955 = ValidationResult.TOO_SHORT;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1280252166 = ValidationResult.TOO_LONG;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_242693568 = ValidationResult.IS_POSSIBLE;
                } //End block
            } //End block
        } //End collapsed parenthetic
        Pattern possibleNumberPattern;
        possibleNumberPattern = regexCache.getPatternForRegex(generalNumDesc.getPossibleNumberPattern());
        varB4EAC82CA7396A68D541C85D26508E83_676988707 = testNumberLengthAgainstPattern(possibleNumberPattern, nationalNumber);
        addTaint(number.getTaint());
        ValidationResult varA7E53CE21691AB073D9660D615818899_1057743601; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1057743601 = varB4EAC82CA7396A68D541C85D26508E83_1483496066;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1057743601 = varB4EAC82CA7396A68D541C85D26508E83_1831694955;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1057743601 = varB4EAC82CA7396A68D541C85D26508E83_1280252166;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1057743601 = varB4EAC82CA7396A68D541C85D26508E83_242693568;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1057743601 = varB4EAC82CA7396A68D541C85D26508E83_676988707;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1057743601.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1057743601;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.308 -0400", hash_original_method = "ABB46ACB6DF1697743B661541AD5E166", hash_generated_method = "D6134A068D07077E3C2FA45A118D2AA7")
    public boolean isPossibleNumber(String number, String regionDialingFrom) {
        try 
        {
            boolean var96F965C3B92FA5515239648FCAA605FA_556809447 = (isPossibleNumber(parse(number, regionDialingFrom)));
        } //End block
        catch (NumberParseException e)
        { }
        addTaint(number.getTaint());
        addTaint(regionDialingFrom.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007978225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007978225;
        // ---------- Original Method ----------
        //try {
      //return isPossibleNumber(parse(number, regionDialingFrom));
    //} catch (NumberParseException e) {
      //return false;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.309 -0400", hash_original_method = "763BBE034FB297BC9C435FECAC40F4A1", hash_generated_method = "3CBAB12F2254AA291747A40A5C3139CC")
    public boolean truncateTooLongNumber(PhoneNumber number) {
        {
            boolean var4F293B781EB7DE5CEFDA17D5EE1DE4BB_1568565618 = (isValidNumber(number));
        } //End collapsed parenthetic
        PhoneNumber numberCopy;
        numberCopy = new PhoneNumber();
        numberCopy.mergeFrom(number);
        long nationalNumber;
        nationalNumber = number.getNationalNumber();
        {
            nationalNumber /= 10;
            numberCopy.setNationalNumber(nationalNumber);
            {
                boolean var4DE93CDC578CDDBFB1C41949B44D9A20_1362087304 = (isPossibleNumberWithReason(numberCopy) == ValidationResult.TOO_SHORT ||
          nationalNumber == 0);
            } //End collapsed parenthetic
        } //End block
        {
            boolean varFE57FF35897528475D20382F37EC3A95_821708457 = (!isValidNumber(numberCopy));
        } //End collapsed parenthetic
        number.setNationalNumber(nationalNumber);
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_859276949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_859276949;
        // ---------- Original Method ----------
        //if (isValidNumber(number)) {
      //return true;
    //}
        //PhoneNumber numberCopy = new PhoneNumber();
        //numberCopy.mergeFrom(number);
        //long nationalNumber = number.getNationalNumber();
        //do {
      //nationalNumber /= 10;
      //numberCopy.setNationalNumber(nationalNumber);
      //if (isPossibleNumberWithReason(numberCopy) == ValidationResult.TOO_SHORT ||
          //nationalNumber == 0) {
        //return false;
      //}
    //} while (!isValidNumber(numberCopy));
        //number.setNationalNumber(nationalNumber);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.322 -0400", hash_original_method = "719F2F8970F4EB169BEDB2820A702606", hash_generated_method = "2A1D07BC2EA96C2D2C051822D50E1144")
    public AsYouTypeFormatter getAsYouTypeFormatter(String regionCode) {
        AsYouTypeFormatter varB4EAC82CA7396A68D541C85D26508E83_112767237 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_112767237 = new AsYouTypeFormatter(regionCode);
        addTaint(regionCode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_112767237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_112767237;
        // ---------- Original Method ----------
        //return new AsYouTypeFormatter(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.324 -0400", hash_original_method = "2A48039CFC05A878E1A34077CDECE0D5", hash_generated_method = "58D5D0EC899E539E418056EF0ED7394F")
     int extractCountryCode(StringBuilder fullNumber, StringBuilder nationalNumber) {
        int potentialCountryCode;
        int numberLength;
        numberLength = fullNumber.length();
        {
            int i;
            i = 1;
            {
                potentialCountryCode = Integer.parseInt(fullNumber.substring(0, i));
                {
                    boolean varF6C470E7E096D4CAC6F27A27E3BF3621_630604897 = (countryCallingCodeToRegionCodeMap.containsKey(potentialCountryCode));
                    {
                        nationalNumber.append(fullNumber.substring(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(fullNumber.getTaint());
        addTaint(nationalNumber.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110743185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110743185;
        // ---------- Original Method ----------
        //int potentialCountryCode;
        //int numberLength = fullNumber.length();
        //for (int i = 1; i <= MAX_LENGTH_COUNTRY_CODE && i <= numberLength; i++) {
      //potentialCountryCode = Integer.parseInt(fullNumber.substring(0, i));
      //if (countryCallingCodeToRegionCodeMap.containsKey(potentialCountryCode)) {
        //nationalNumber.append(fullNumber.substring(i));
        //return potentialCountryCode;
      //}
    //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.327 -0400", hash_original_method = "8166FB521487034FA9E8BD7575A0612F", hash_generated_method = "1B07FCD6CC7F8BABD559BF7390630EDB")
     int maybeExtractCountryCode(String number, PhoneMetadata defaultRegionMetadata,
                              StringBuilder nationalNumber, boolean keepRawInput,
                              PhoneNumber phoneNumber) throws NumberParseException {
        {
            boolean varB5B34D967C3FC3EF34B11B7B3B931B11_2138853064 = (number.length() == 0);
        } //End collapsed parenthetic
        StringBuilder fullNumber;
        fullNumber = new StringBuilder(number);
        String possibleCountryIddPrefix;
        possibleCountryIddPrefix = "NonMatch";
        {
            possibleCountryIddPrefix = defaultRegionMetadata.getInternationalPrefix();
        } //End block
        CountryCodeSource countryCodeSource;
        countryCodeSource = maybeStripInternationalPrefixAndNormalize(fullNumber, possibleCountryIddPrefix);
        {
            phoneNumber.setCountryCodeSource(countryCodeSource);
        } //End block
        {
            {
                boolean varE7EE2B23EDD4C9364B0D3D150E7CC45E_2015335862 = (fullNumber.length() < MIN_LENGTH_FOR_NSN);
                {
                    if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD,
                                       "Phone number had an IDD, but after this was not "
                                       + "long enough to be a viable phone number.");
                } //End block
            } //End collapsed parenthetic
            int potentialCountryCode;
            potentialCountryCode = extractCountryCode(fullNumber, nationalNumber);
            {
                phoneNumber.setCountryCode(potentialCountryCode);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                                     "Country calling code supplied was not recognised.");
        } //End block
        {
            int defaultCountryCode;
            defaultCountryCode = defaultRegionMetadata.getCountryCode();
            String defaultCountryCodeString;
            defaultCountryCodeString = String.valueOf(defaultCountryCode);
            String normalizedNumber;
            normalizedNumber = fullNumber.toString();
            {
                boolean varBF0AEC43338ACB310E013283F2CF7DCB_1224851845 = (normalizedNumber.startsWith(defaultCountryCodeString));
                {
                    StringBuilder potentialNationalNumber;
                    potentialNationalNumber = new StringBuilder(normalizedNumber.substring(defaultCountryCodeString.length()));
                    PhoneNumberDesc generalDesc;
                    generalDesc = defaultRegionMetadata.getGeneralDesc();
                    Pattern validNumberPattern;
                    validNumberPattern = regexCache.getPatternForRegex(generalDesc.getNationalNumberPattern());
                    maybeStripNationalPrefixAndCarrierCode(potentialNationalNumber, defaultRegionMetadata);
                    Pattern possibleNumberPattern;
                    possibleNumberPattern = regexCache.getPatternForRegex(generalDesc.getPossibleNumberPattern());
                    {
                        boolean var0EB5BCA225D2EA4DBFFB64C37782F25D_1879307426 = ((!validNumberPattern.matcher(fullNumber).matches() &&
             validNumberPattern.matcher(potentialNationalNumber).matches()) ||
             testNumberLengthAgainstPattern(possibleNumberPattern, fullNumber.toString())
                  == ValidationResult.TOO_LONG);
                        {
                            nationalNumber.append(potentialNationalNumber);
                            {
                                phoneNumber.setCountryCodeSource(CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                            } //End block
                            phoneNumber.setCountryCode(defaultCountryCode);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        phoneNumber.setCountryCode(0);
        addTaint(number.getTaint());
        addTaint(defaultRegionMetadata.getTaint());
        addTaint(nationalNumber.getTaint());
        addTaint(keepRawInput);
        addTaint(phoneNumber.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428253406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428253406;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.327 -0400", hash_original_method = "0F0B6B28B590A156D8457E403790D50B", hash_generated_method = "AB9C97BE1C171C9814212E822C762E66")
    private boolean parsePrefixAsIdd(Pattern iddPattern, StringBuilder number) {
        Matcher m;
        m = iddPattern.matcher(number);
        {
            boolean var2E90163ED89C1EED1C54F6911454B170_172233666 = (m.lookingAt());
            {
                int matchEnd;
                matchEnd = m.end();
                Matcher digitMatcher;
                digitMatcher = CAPTURING_DIGIT_PATTERN.matcher(number.substring(matchEnd));
                {
                    boolean varD3BA2E8471CEBE61FDD93E9E325ACBC0_908337175 = (digitMatcher.find());
                    {
                        String normalizedGroup;
                        normalizedGroup = normalizeDigitsOnly(digitMatcher.group(1));
                        {
                            boolean var61EE828DD147AE02AC5DD8BACE4A9E86_522196223 = (normalizedGroup.equals("0"));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                number.delete(0, matchEnd);
            } //End block
        } //End collapsed parenthetic
        addTaint(iddPattern.getTaint());
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129326980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129326980;
        // ---------- Original Method ----------
        //Matcher m = iddPattern.matcher(number);
        //if (m.lookingAt()) {
      //int matchEnd = m.end();
      //Matcher digitMatcher = CAPTURING_DIGIT_PATTERN.matcher(number.substring(matchEnd));
      //if (digitMatcher.find()) {
        //String normalizedGroup = normalizeDigitsOnly(digitMatcher.group(1));
        //if (normalizedGroup.equals("0")) {
          //return false;
        //}
      //}
      //number.delete(0, matchEnd);
      //return true;
    //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.328 -0400", hash_original_method = "8865CBB50A1D9F6F8472F699DBF16350", hash_generated_method = "47160F4B676D45E389CB20B52E94E15A")
     CountryCodeSource maybeStripInternationalPrefixAndNormalize(
      StringBuilder number,
      String possibleIddPrefix) {
        CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_22548169 = null; //Variable for return #1
        CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_1978605863 = null; //Variable for return #2
        CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_345072273 = null; //Variable for return #3
        CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_1242385094 = null; //Variable for return #4
        {
            boolean varB5B34D967C3FC3EF34B11B7B3B931B11_144391688 = (number.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_22548169 = CountryCodeSource.FROM_DEFAULT_COUNTRY;
            } //End block
        } //End collapsed parenthetic
        Matcher m;
        m = PLUS_CHARS_PATTERN.matcher(number);
        {
            boolean var2E90163ED89C1EED1C54F6911454B170_803100672 = (m.lookingAt());
            {
                number.delete(0, m.end());
                normalize(number);
                varB4EAC82CA7396A68D541C85D26508E83_1978605863 = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            } //End block
        } //End collapsed parenthetic
        Pattern iddPattern;
        iddPattern = regexCache.getPatternForRegex(possibleIddPrefix);
        {
            boolean varCDD8918BAE2604CCF3C5EBF34E65E7DD_1042683057 = (parsePrefixAsIdd(iddPattern, number));
            {
                normalize(number);
                varB4EAC82CA7396A68D541C85D26508E83_345072273 = CountryCodeSource.FROM_NUMBER_WITH_IDD;
            } //End block
        } //End collapsed parenthetic
        normalize(number);
        varB4EAC82CA7396A68D541C85D26508E83_1242385094 = parsePrefixAsIdd(iddPattern, number)
           ? CountryCodeSource.FROM_NUMBER_WITH_IDD
           : CountryCodeSource.FROM_DEFAULT_COUNTRY;
        addTaint(number.getTaint());
        addTaint(possibleIddPrefix.getTaint());
        CountryCodeSource varA7E53CE21691AB073D9660D615818899_510338126; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_510338126 = varB4EAC82CA7396A68D541C85D26508E83_22548169;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_510338126 = varB4EAC82CA7396A68D541C85D26508E83_1978605863;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_510338126 = varB4EAC82CA7396A68D541C85D26508E83_345072273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_510338126 = varB4EAC82CA7396A68D541C85D26508E83_1242385094;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_510338126.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_510338126;
        // ---------- Original Method ----------
        //if (number.length() == 0) {
      //return CountryCodeSource.FROM_DEFAULT_COUNTRY;
    //}
        //Matcher m = PLUS_CHARS_PATTERN.matcher(number);
        //if (m.lookingAt()) {
      //number.delete(0, m.end());
      //normalize(number);
      //return CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
    //}
        //Pattern iddPattern = regexCache.getPatternForRegex(possibleIddPrefix);
        //if (parsePrefixAsIdd(iddPattern, number)) {
      //normalize(number);
      //return CountryCodeSource.FROM_NUMBER_WITH_IDD;
    //}
        //normalize(number);
        //return parsePrefixAsIdd(iddPattern, number)
           //? CountryCodeSource.FROM_NUMBER_WITH_IDD
           //: CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.337 -0400", hash_original_method = "8024CAA7B81A99B980BA01FE387839A1", hash_generated_method = "E7EE2A8781FA789D717BDCD63EC21B87")
     String maybeStripNationalPrefixAndCarrierCode(StringBuilder number, PhoneMetadata metadata) {
        String varB4EAC82CA7396A68D541C85D26508E83_143186342 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1428887375 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1449405361 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1559609203 = null; //Variable for return #4
        String carrierCode;
        carrierCode = "";
        int numberLength;
        numberLength = number.length();
        String possibleNationalPrefix;
        possibleNationalPrefix = metadata.getNationalPrefixForParsing();
        {
            boolean var2D1654E1B48CDA3CB899B11DA870015B_909472183 = (numberLength == 0 || possibleNationalPrefix.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_143186342 = "";
            } //End block
        } //End collapsed parenthetic
        Matcher prefixMatcher;
        prefixMatcher = regexCache.getPatternForRegex(possibleNationalPrefix).matcher(number);
        {
            boolean var51DEE301B078E28F95DDA21171B258E8_1745390705 = (prefixMatcher.lookingAt());
            {
                Pattern nationalNumberRule;
                nationalNumberRule = regexCache.getPatternForRegex(metadata.getGeneralDesc().getNationalNumberPattern());
                boolean isViableOriginalNumber;
                isViableOriginalNumber = nationalNumberRule.matcher(number).matches();
                int numOfGroups;
                numOfGroups = prefixMatcher.groupCount();
                String transformRule;
                transformRule = metadata.getNationalPrefixTransformRule();
                {
                    boolean var92083891923A60ACDAC45256CB34F888_404868920 = (transformRule == null || transformRule.length() == 0 ||
          prefixMatcher.group(numOfGroups) == null);
                    {
                        {
                            boolean var05FB41A7DFCB455F1C640CC42B086A52_1600519958 = (isViableOriginalNumber &&
            !nationalNumberRule.matcher(number.substring(prefixMatcher.end())).matches());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1428887375 = "";
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var731E647394C8AC8EAD72BD6A33D30533_1379236627 = (numOfGroups > 0 && prefixMatcher.group(numOfGroups) != null);
                            {
                                carrierCode = prefixMatcher.group(1);
                            } //End block
                        } //End collapsed parenthetic
                        number.delete(0, prefixMatcher.end());
                    } //End block
                    {
                        StringBuilder transformedNumber;
                        transformedNumber = new StringBuilder(number);
                        transformedNumber.replace(0, numberLength, prefixMatcher.replaceFirst(transformRule));
                        {
                            boolean var1618096EC0BE19942037320536365A62_1073592031 = (isViableOriginalNumber &&
            !nationalNumberRule.matcher(transformedNumber.toString()).matches());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1449405361 = "";
                            } //End block
                        } //End collapsed parenthetic
                        {
                            carrierCode = prefixMatcher.group(1);
                        } //End block
                        number.replace(0, number.length(), transformedNumber.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1559609203 = carrierCode;
        addTaint(number.getTaint());
        addTaint(metadata.getTaint());
        String varA7E53CE21691AB073D9660D615818899_134781624; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_134781624 = varB4EAC82CA7396A68D541C85D26508E83_143186342;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_134781624 = varB4EAC82CA7396A68D541C85D26508E83_1428887375;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_134781624 = varB4EAC82CA7396A68D541C85D26508E83_1449405361;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_134781624 = varB4EAC82CA7396A68D541C85D26508E83_1559609203;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_134781624.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_134781624;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.347 -0400", hash_original_method = "D072FBB7A4080E317A5210E0DF61655A", hash_generated_method = "F4EC4B40E55C3FFBC5039735C368C71C")
     String maybeStripExtension(StringBuilder number) {
        String varB4EAC82CA7396A68D541C85D26508E83_644685904 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_346780631 = null; //Variable for return #2
        Matcher m;
        m = EXTN_PATTERN.matcher(number);
        {
            boolean var361B236D5550943CE1D4B9E817C41F2D_553885985 = (m.find() && isViablePhoneNumber(number.substring(0, m.start())));
            {
                {
                    int i, length;
                    i = 1;
                    length = m.groupCount();
                    {
                        {
                            boolean varEF8B426B8C4D7A4B4377DDF02EDEE0A6_963787233 = (m.group(i) != null);
                            {
                                String extension;
                                extension = m.group(i);
                                number.delete(m.start(), number.length());
                                varB4EAC82CA7396A68D541C85D26508E83_644685904 = extension;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_346780631 = "";
        addTaint(number.getTaint());
        String varA7E53CE21691AB073D9660D615818899_531600971; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_531600971 = varB4EAC82CA7396A68D541C85D26508E83_644685904;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_531600971 = varB4EAC82CA7396A68D541C85D26508E83_346780631;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_531600971.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_531600971;
        // ---------- Original Method ----------
        //Matcher m = EXTN_PATTERN.matcher(number);
        //if (m.find() && isViablePhoneNumber(number.substring(0, m.start()))) {
      //for (int i = 1, length = m.groupCount(); i <= length; i++) {
        //if (m.group(i) != null) {
          //String extension = m.group(i);
          //number.delete(m.start(), number.length());
          //return extension;
        //}
      //}
    //}
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.347 -0400", hash_original_method = "E1BA4484CA3B538698D9E39D9664F7DD", hash_generated_method = "7856B7B5B3E658E6B0B23A943C6C1EB6")
    private boolean checkRegionForParsing(String numberToParse, String defaultRegion) {
        {
            boolean varC4FBE20839E7B322BE8202F31EB24419_1916310146 = (!isValidRegionCode(defaultRegion));
            {
                {
                    boolean varAC73D73EEB94A3B214186B0F9C923AF3_368284180 = (numberToParse == null || numberToParse.length() == 0 ||
          !PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1020430243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1020430243;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(defaultRegion)) {
      //if (numberToParse == null || numberToParse.length() == 0 ||
          //!PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt()) {
        //return false;
      //}
    //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.348 -0400", hash_original_method = "6012972DF706A584D5C83C6971CF9392", hash_generated_method = "9875B9424016624167B1234BDED6850F")
    public PhoneNumber parse(String numberToParse, String defaultRegion) throws NumberParseException {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1436130440 = null; //Variable for return #1
        PhoneNumber phoneNumber;
        phoneNumber = new PhoneNumber();
        parse(numberToParse, defaultRegion, phoneNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1436130440 = phoneNumber;
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1436130440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1436130440;
        // ---------- Original Method ----------
        //PhoneNumber phoneNumber = new PhoneNumber();
        //parse(numberToParse, defaultRegion, phoneNumber);
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.348 -0400", hash_original_method = "6ECDB36C19DB49774718F5C4BA94B539", hash_generated_method = "0B03E5B379B81B8F5BEF078A04733AB3")
    public void parse(String numberToParse, String defaultRegion, PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(phoneNumber.getTaint());
        // ---------- Original Method ----------
        //parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.349 -0400", hash_original_method = "19CBF359D0DD4BA30476F5C26D54CCE4", hash_generated_method = "41EAD8DC7B80CEAD2B0308EF7D24167F")
    public PhoneNumber parseAndKeepRawInput(String numberToParse, String defaultRegion) throws NumberParseException {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1681818721 = null; //Variable for return #1
        PhoneNumber phoneNumber;
        phoneNumber = new PhoneNumber();
        parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1681818721 = phoneNumber;
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1681818721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1681818721;
        // ---------- Original Method ----------
        //PhoneNumber phoneNumber = new PhoneNumber();
        //parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.350 -0400", hash_original_method = "56F5D9940BB01A0D66986596B5A9CF6E", hash_generated_method = "8CE39E71A4F75F548446D8BCEAB5DE37")
    public void parseAndKeepRawInput(String numberToParse, String defaultRegion,
                                   PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(phoneNumber.getTaint());
        // ---------- Original Method ----------
        //parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.358 -0400", hash_original_method = "FC749C2F4DF483D491476DD9FB58E6D5", hash_generated_method = "829AAF58CC1B6ED586F6B8EB520609FB")
    public Iterable<PhoneNumberMatch> findNumbers(CharSequence text, String defaultRegion) {
        Iterable<PhoneNumberMatch> varB4EAC82CA7396A68D541C85D26508E83_1017498866 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1017498866 = findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
        addTaint(text.getTaint());
        addTaint(defaultRegion.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1017498866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1017498866;
        // ---------- Original Method ----------
        //return findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.359 -0400", hash_original_method = "C3E745E72AE45D5E83FFDE500327E040", hash_generated_method = "E389B9F1FE6E0C729B1861E710620A69")
    public Iterable<PhoneNumberMatch> findNumbers(
      final CharSequence text, final String defaultRegion, final Leniency leniency,
      final long maxTries) {
        Iterable<PhoneNumberMatch> varB4EAC82CA7396A68D541C85D26508E83_513925707 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_513925707 = new Iterable<PhoneNumberMatch>() {
      public Iterator<PhoneNumberMatch> iterator() {
        return new PhoneNumberMatcher(
            PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
      }
    };
        addTaint(text.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(leniency.getTaint());
        addTaint(maxTries);
        varB4EAC82CA7396A68D541C85D26508E83_513925707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_513925707;
        // ---------- Original Method ----------
        //return new Iterable<PhoneNumberMatch>() {
      //public Iterator<PhoneNumberMatch> iterator() {
        //return new PhoneNumberMatcher(
            //PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
      //}
    //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.379 -0400", hash_original_method = "B3135DA9F7C362E965D50679AE934189", hash_generated_method = "DB11F42297821172CF11A0C27F181FF4")
    private void parseHelper(String numberToParse, String defaultRegion, boolean keepRawInput,
                           boolean checkRegion, PhoneNumber phoneNumber) throws NumberParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The phone number supplied was null.");
        } //End block
        String number;
        number = extractPossibleNumber(numberToParse);
        {
            boolean var6F2D6DBE1E1842574CD6CB87FFC5DB6E_1336727908 = (!isViablePhoneNumber(number));
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The string supplied did not seem to be a phone number.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var06E9F76E4F889EF52DC311C4A976B26A_931733946 = (checkRegion && !checkRegionForParsing(number, defaultRegion));
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                                     "Missing or invalid default region.");
            } //End block
        } //End collapsed parenthetic
        {
            phoneNumber.setRawInput(numberToParse);
        } //End block
        StringBuilder nationalNumber;
        nationalNumber = new StringBuilder(number);
        String extension;
        extension = maybeStripExtension(nationalNumber);
        {
            boolean var3CC30422F1FA8C39327BDA102088343B_1739402171 = (extension.length() > 0);
            {
                phoneNumber.setExtension(extension);
            } //End block
        } //End collapsed parenthetic
        PhoneMetadata regionMetadata;
        regionMetadata = getMetadataForRegion(defaultRegion);
        StringBuilder normalizedNationalNumber;
        normalizedNationalNumber = new StringBuilder();
        int countryCode;
        countryCode = maybeExtractCountryCode(nationalNumber.toString(), regionMetadata,
                                              normalizedNationalNumber, keepRawInput, phoneNumber);
        {
            String phoneNumberRegion;
            phoneNumberRegion = getRegionCodeForCountryCode(countryCode);
            {
                boolean varF49D20E798CCB0BC5377F0D78E2C4831_70222654 = (!phoneNumberRegion.equals(defaultRegion));
                {
                    regionMetadata = getMetadataForRegion(phoneNumberRegion);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            normalize(nationalNumber);
            normalizedNationalNumber.append(nationalNumber);
            {
                countryCode = regionMetadata.getCountryCode();
                phoneNumber.setCountryCode(countryCode);
            } //End block
            {
                phoneNumber.clearCountryCodeSource();
            } //End block
        } //End block
        {
            boolean varE256D1ABB8A26FE912AD1B0C28F9428D_609270689 = (normalizedNationalNumber.length() < MIN_LENGTH_FOR_NSN);
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
            } //End block
        } //End collapsed parenthetic
        {
            String carrierCode;
            carrierCode = maybeStripNationalPrefixAndCarrierCode(normalizedNationalNumber, regionMetadata);
            {
                phoneNumber.setPreferredDomesticCarrierCode(carrierCode);
            } //End block
        } //End block
        int lengthOfNationalNumber;
        lengthOfNationalNumber = normalizedNationalNumber.length();
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG,
                                     "The string supplied is too long to be a phone number.");
        } //End block
        {
            boolean varACF04B28E2A0B5A46318EA7197F780A3_202524441 = (normalizedNationalNumber.charAt(0) == '0');
            {
                phoneNumber.setItalianLeadingZero(true);
            } //End block
        } //End collapsed parenthetic
        phoneNumber.setNationalNumber(Long.parseLong(normalizedNationalNumber.toString()));
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(keepRawInput);
        addTaint(checkRegion);
        addTaint(phoneNumber.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.400 -0400", hash_original_method = "83C8E6F8520B32A4B2A265A569BAF2C9", hash_generated_method = "D174D9FD15C95D3984DE9297AD05CCAA")
    public MatchType isNumberMatch(PhoneNumber firstNumberIn, PhoneNumber secondNumberIn) {
        MatchType varB4EAC82CA7396A68D541C85D26508E83_2072701893 = null; //Variable for return #1
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1550208972 = null; //Variable for return #2
        MatchType varB4EAC82CA7396A68D541C85D26508E83_48144589 = null; //Variable for return #3
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1236779314 = null; //Variable for return #4
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1647857395 = null; //Variable for return #5
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1255195107 = null; //Variable for return #6
        MatchType varB4EAC82CA7396A68D541C85D26508E83_231974973 = null; //Variable for return #7
        PhoneNumber firstNumber;
        firstNumber = new PhoneNumber();
        firstNumber.mergeFrom(firstNumberIn);
        PhoneNumber secondNumber;
        secondNumber = new PhoneNumber();
        secondNumber.mergeFrom(secondNumberIn);
        firstNumber.clearRawInput();
        firstNumber.clearCountryCodeSource();
        firstNumber.clearPreferredDomesticCarrierCode();
        secondNumber.clearRawInput();
        secondNumber.clearCountryCodeSource();
        secondNumber.clearPreferredDomesticCarrierCode();
        {
            boolean varD218A2F73AAFCD618CDCC1518EFA486F_1797152788 = (firstNumber.hasExtension() &&
        firstNumber.getExtension().length() == 0);
            {
                firstNumber.clearExtension();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var60C5BEE8803B911C5831EA8EC7969A40_1601687246 = (secondNumber.hasExtension() &&
        secondNumber.getExtension().length() == 0);
            {
                secondNumber.clearExtension();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF31A145523293CCF9F54D3055A0EFC09_774764593 = (firstNumber.hasExtension() && secondNumber.hasExtension() &&
        !firstNumber.getExtension().equals(secondNumber.getExtension()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2072701893 = MatchType.NO_MATCH;
            } //End block
        } //End collapsed parenthetic
        int firstNumberCountryCode;
        firstNumberCountryCode = firstNumber.getCountryCode();
        int secondNumberCountryCode;
        secondNumberCountryCode = secondNumber.getCountryCode();
        {
            {
                boolean var9B921E1924AE2BDB9C722839D617A98E_464845150 = (firstNumber.exactlySameAs(secondNumber));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1550208972 = MatchType.EXACT_MATCH;
                } //End block
                {
                    boolean var51FF660A6085B2E42A72E7B10CEF8B05_1496729962 = (firstNumberCountryCode == secondNumberCountryCode &&
                 isNationalNumberSuffixOfTheOther(firstNumber, secondNumber));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_48144589 = MatchType.SHORT_NSN_MATCH;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1236779314 = MatchType.NO_MATCH;
        } //End block
        firstNumber.setCountryCode(secondNumberCountryCode);
        {
            boolean varFF0709B6FD4A212C6A2A3AAFF8AF6F2C_2099172473 = (firstNumber.exactlySameAs(secondNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1647857395 = MatchType.NSN_MATCH;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5CAFDF8CDD6EF1F618DB5BB207D00EF6_218366833 = (isNationalNumberSuffixOfTheOther(firstNumber, secondNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1255195107 = MatchType.SHORT_NSN_MATCH;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_231974973 = MatchType.NO_MATCH;
        addTaint(firstNumberIn.getTaint());
        addTaint(secondNumberIn.getTaint());
        MatchType varA7E53CE21691AB073D9660D615818899_1449958933; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1449958933 = varB4EAC82CA7396A68D541C85D26508E83_2072701893;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1449958933 = varB4EAC82CA7396A68D541C85D26508E83_1550208972;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1449958933 = varB4EAC82CA7396A68D541C85D26508E83_48144589;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1449958933 = varB4EAC82CA7396A68D541C85D26508E83_1236779314;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1449958933 = varB4EAC82CA7396A68D541C85D26508E83_1647857395;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1449958933 = varB4EAC82CA7396A68D541C85D26508E83_1255195107;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1449958933 = varB4EAC82CA7396A68D541C85D26508E83_231974973;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1449958933.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1449958933;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.402 -0400", hash_original_method = "B2A134716BB483331B78911F7265BAC6", hash_generated_method = "4C8A79A9300983F4E6786E9BAB619751")
    private boolean isNationalNumberSuffixOfTheOther(PhoneNumber firstNumber,
                                                   PhoneNumber secondNumber) {
        String firstNumberNationalNumber;
        firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
        String secondNumberNationalNumber;
        secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
        boolean var7CCB98E4B8319542AA88D60C5E29610E_696868205 = (firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           secondNumberNationalNumber.endsWith(firstNumberNationalNumber));
        addTaint(firstNumber.getTaint());
        addTaint(secondNumber.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128649438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128649438;
        // ---------- Original Method ----------
        //String firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
        //String secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
        //return firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           //secondNumberNationalNumber.endsWith(firstNumberNationalNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.405 -0400", hash_original_method = "3C9E8BD2D7E8FA6C3BECA5B02E481416", hash_generated_method = "18952CA1ADBC6CC374CE6362F1649E21")
    public MatchType isNumberMatch(String firstNumber, String secondNumber) {
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1404911193 = null; //Variable for return #1
        MatchType varB4EAC82CA7396A68D541C85D26508E83_664218514 = null; //Variable for return #2
        MatchType varB4EAC82CA7396A68D541C85D26508E83_512577308 = null; //Variable for return #3
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1142215577 = null; //Variable for return #4
        try 
        {
            PhoneNumber firstNumberAsProto;
            firstNumberAsProto = parse(firstNumber, UNKNOWN_REGION);
            varB4EAC82CA7396A68D541C85D26508E83_1404911193 = isNumberMatch(firstNumberAsProto, secondNumber);
        } //End block
        catch (NumberParseException e)
        {
            {
                boolean var89D3BC3CCC46DE71B07129DA6A1C3D48_364685498 = (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                {
                    try 
                    {
                        PhoneNumber secondNumberAsProto;
                        secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
                        varB4EAC82CA7396A68D541C85D26508E83_664218514 = isNumberMatch(secondNumberAsProto, firstNumber);
                    } //End block
                    catch (NumberParseException e2)
                    {
                        {
                            boolean var463CDF6189F8ADE5C6F8D6C11E45E3C7_691905291 = (e2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                            {
                                try 
                                {
                                    PhoneNumber firstNumberProto;
                                    firstNumberProto = new PhoneNumber();
                                    PhoneNumber secondNumberProto;
                                    secondNumberProto = new PhoneNumber();
                                    parseHelper(firstNumber, null, false, false, firstNumberProto);
                                    parseHelper(secondNumber, null, false, false, secondNumberProto);
                                    varB4EAC82CA7396A68D541C85D26508E83_512577308 = isNumberMatch(firstNumberProto, secondNumberProto);
                                } //End block
                                catch (NumberParseException e3)
                                { }
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1142215577 = MatchType.NOT_A_NUMBER;
        addTaint(firstNumber.getTaint());
        addTaint(secondNumber.getTaint());
        MatchType varA7E53CE21691AB073D9660D615818899_1980481436; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1980481436 = varB4EAC82CA7396A68D541C85D26508E83_1404911193;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1980481436 = varB4EAC82CA7396A68D541C85D26508E83_664218514;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1980481436 = varB4EAC82CA7396A68D541C85D26508E83_512577308;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1980481436 = varB4EAC82CA7396A68D541C85D26508E83_1142215577;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1980481436.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1980481436;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.406 -0400", hash_original_method = "FA442F82D618375A0E3FFC54DA76D9E3", hash_generated_method = "89B4913B48EBC805FF99B6CBDC5B34B1")
    public MatchType isNumberMatch(PhoneNumber firstNumber, String secondNumber) {
        MatchType varB4EAC82CA7396A68D541C85D26508E83_2071916807 = null; //Variable for return #1
        MatchType varB4EAC82CA7396A68D541C85D26508E83_85127355 = null; //Variable for return #2
        MatchType varB4EAC82CA7396A68D541C85D26508E83_491537119 = null; //Variable for return #3
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1650487560 = null; //Variable for return #4
        MatchType varB4EAC82CA7396A68D541C85D26508E83_816902889 = null; //Variable for return #5
        try 
        {
            PhoneNumber secondNumberAsProto;
            secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
            varB4EAC82CA7396A68D541C85D26508E83_2071916807 = isNumberMatch(firstNumber, secondNumberAsProto);
        } //End block
        catch (NumberParseException e)
        {
            {
                boolean var89D3BC3CCC46DE71B07129DA6A1C3D48_1881743911 = (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                {
                    String firstNumberRegion;
                    firstNumberRegion = getRegionCodeForCountryCode(firstNumber.getCountryCode());
                    try 
                    {
                        {
                            boolean var255106447960ACE253D342CF9EF0C76A_1921064307 = (!firstNumberRegion.equals(UNKNOWN_REGION));
                            {
                                PhoneNumber secondNumberWithFirstNumberRegion;
                                secondNumberWithFirstNumberRegion = parse(secondNumber, firstNumberRegion);
                                MatchType match;
                                match = isNumberMatch(firstNumber, secondNumberWithFirstNumberRegion);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_85127355 = MatchType.NSN_MATCH;
                                } //End block
                                varB4EAC82CA7396A68D541C85D26508E83_491537119 = match;
                            } //End block
                            {
                                PhoneNumber secondNumberProto;
                                secondNumberProto = new PhoneNumber();
                                parseHelper(secondNumber, null, false, false, secondNumberProto);
                                varB4EAC82CA7396A68D541C85D26508E83_1650487560 = isNumberMatch(firstNumber, secondNumberProto);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (NumberParseException e2)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_816902889 = MatchType.NOT_A_NUMBER;
        addTaint(firstNumber.getTaint());
        addTaint(secondNumber.getTaint());
        MatchType varA7E53CE21691AB073D9660D615818899_1983453487; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1983453487 = varB4EAC82CA7396A68D541C85D26508E83_2071916807;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1983453487 = varB4EAC82CA7396A68D541C85D26508E83_85127355;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1983453487 = varB4EAC82CA7396A68D541C85D26508E83_491537119;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1983453487 = varB4EAC82CA7396A68D541C85D26508E83_1650487560;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1983453487 = varB4EAC82CA7396A68D541C85D26508E83_816902889;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1983453487.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1983453487;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.419 -0400", hash_original_method = "93167700613734CAFA37F508460EB7E3", hash_generated_method = "07BA12BA02D56B55C61BB63B015995D0")
     boolean canBeInternationallyDialled(PhoneNumber number) {
        String regionCode;
        regionCode = getRegionCodeForNumber(number);
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean var49E3803795D2C1A2A31963B43E424E43_1478570209 = (!hasValidRegionCode(regionCode, number.getCountryCode(), nationalSignificantNumber));
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        boolean varB254B21720CD001C28A66C6976015DBA_1305647929 = (!isNumberMatchingDesc(nationalSignificantNumber, metadata.getNoInternationalDialling()));
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213619883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_213619883;
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //String nationalSignificantNumber = getNationalSignificantNumber(number);
        //if (!hasValidRegionCode(regionCode, number.getCountryCode(), nationalSignificantNumber)) {
      //return true;
    //}
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //return !isNumberMatchingDesc(nationalSignificantNumber, metadata.getNoInternationalDialling());
    }

    
    public enum PhoneNumberFormat {
    E164,
    INTERNATIONAL,
    NATIONAL,
    RFC3966
  }

    
    public enum PhoneNumberType {
    FIXED_LINE,
    MOBILE,
    FIXED_LINE_OR_MOBILE,
    TOLL_FREE,
    PREMIUM_RATE,
    SHARED_COST,
    VOIP,
    PERSONAL_NUMBER,
    PAGER,
    UAN,
    UNKNOWN
  }

    
    public enum MatchType {
    NOT_A_NUMBER,
    NO_MATCH,
    SHORT_NSN_MATCH,
    NSN_MATCH,
    EXACT_MATCH,
  }

    
    public enum ValidationResult {
    IS_POSSIBLE,
    INVALID_COUNTRY_CODE,
    TOO_SHORT,
    TOO_LONG,
  }

    
    public enum Leniency {
    POSSIBLE {
      @Override
      boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        return util.isPossibleNumber(number);
      }
    },
    VALID {
      @Override
      boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        if (!util.isValidNumber(number)) {
          return false;
        }
        return containsOnlyValidXChars(number, candidate, util);
      }
    },
    STRICT_GROUPING {
      @Override
      boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        if (!util.isValidNumber(number) ||
            !containsOnlyValidXChars(number, candidate, util) ||
            containsMoreThanOneSlash(candidate)) {
          return false;
        }
        String[] formattedNumberGroups = getNationalNumberGroups(util, number);
        StringBuilder normalizedCandidate = normalizeDigits(candidate,
                                                            true );
        int fromIndex = 0;
        for (int i = 0; i < formattedNumberGroups.length; i++) {
          fromIndex = normalizedCandidate.indexOf(formattedNumberGroups[i], fromIndex);
          if (fromIndex < 0) {
            return false;
          }
          fromIndex += formattedNumberGroups[i].length();
          if (i == 0 && fromIndex < normalizedCandidate.length()) {
            if (Character.isDigit(normalizedCandidate.charAt(fromIndex))) {
              String nationalSignificantNumber = util.getNationalSignificantNumber(number);
              return normalizedCandidate.substring(fromIndex - formattedNumberGroups[i].length())
                  .startsWith(nationalSignificantNumber);
            }
          }
        }
        return normalizedCandidate.substring(fromIndex).contains(number.getExtension());
      }
    },
    EXACT_GROUPING {
      @Override
      boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        if (!util.isValidNumber(number) ||
            !containsOnlyValidXChars(number, candidate, util) ||
            containsMoreThanOneSlash(candidate)) {
          return false;
        }
        StringBuilder normalizedCandidate = normalizeDigits(candidate,
                                                            true );
        String[] candidateGroups =
            NON_DIGITS_PATTERN.split(normalizedCandidate.toString());
        int candidateNumberGroupIndex =
            number.hasExtension() ? candidateGroups.length - 2 : candidateGroups.length - 1;
        if (candidateGroups.length == 1 ||
            candidateGroups[candidateNumberGroupIndex].contains(
                util.getNationalSignificantNumber(number))) {
          return true;
        }
        String[] formattedNumberGroups = getNationalNumberGroups(util, number);
        for (int formattedNumberGroupIndex = (formattedNumberGroups.length - 1);
             formattedNumberGroupIndex > 0 && candidateNumberGroupIndex >= 0;
             formattedNumberGroupIndex--, candidateNumberGroupIndex--) {
          if (!candidateGroups[candidateNumberGroupIndex].equals(
              formattedNumberGroups[formattedNumberGroupIndex])) {
            return false;
          }
        }
        return (candidateNumberGroupIndex >= 0 &&
                candidateGroups[candidateNumberGroupIndex].endsWith(formattedNumberGroups[0]));
      }
    };
    private static String[] getNationalNumberGroups(PhoneNumberUtil util, PhoneNumber number) {
      String rfc3966Format = util.format(number, PhoneNumberFormat.RFC3966);
      int endIndex = rfc3966Format.indexOf(';');
      if (endIndex < 0) {
        endIndex = rfc3966Format.length();
      }
      int startIndex = rfc3966Format.indexOf('-') + 1;
      return rfc3966Format.substring(startIndex, endIndex).split("-");
    }
    private static boolean containsMoreThanOneSlash(String candidate) {
      int firstSlashIndex = candidate.indexOf('/');
      return (firstSlashIndex > 0 && candidate.substring(firstSlashIndex + 1).contains("/"));
    }
    private static boolean containsOnlyValidXChars(
        PhoneNumber number, String candidate, PhoneNumberUtil util) {
      for (int index = 0; index < candidate.length() - 1; index++) {
        char charAtIndex = candidate.charAt(index);
        if (charAtIndex == 'x' || charAtIndex == 'X') {
          char charAtNextIndex = candidate.charAt(index + 1);
          if (charAtNextIndex == 'x' || charAtNextIndex == 'X') {
            index++;
            if (util.isNumberMatch(number, candidate.substring(index)) != MatchType.NSN_MATCH) {
              return false;
            }
          } else if (!PhoneNumberUtil.normalizeDigitsOnly(candidate.substring(index)).equals(
              number.getExtension())) {
              return false;
          }
        }
      }
      return true;
    }
    abstract boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util);
  }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "EB11CC0E8A96949DB43176717E336CDD", hash_generated_field = "3F6C2A2BFA8F30263AFEEAEC3E6237AA")

    static int REGEX_FLAGS = Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "9E0E53DE18A8BA7B34AFC44B3D12F966", hash_generated_field = "C56636706A9D3FC2C6BC8B67D442ED7C")

    private static int MIN_LENGTH_FOR_NSN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "B7B16DDA7E8A51EB6956979657455D74", hash_generated_field = "59999B530267A37EF987B21404825123")

    static int MAX_LENGTH_FOR_NSN = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "05AAEEE35BFA26C060E9E538DC8A8A9A", hash_generated_field = "E83E37892882C4324F62AA4D6BFD121E")

    static int MAX_LENGTH_COUNTRY_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "1A0EC0F17D75886D68FE0D60D02E7405", hash_generated_field = "A58B0A23D0CBF1355ADBCC6D2A251110")

    static String META_DATA_FILE_PREFIX = "/com/android/i18n/phonenumbers/data/PhoneNumberMetadataProto";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "A1E873C259FA0CABBD0C9F71C2073DFA", hash_generated_field = "FFCF358692D0F0CDFA743A5745A37A80")

    private static Logger LOGGER = Logger.getLogger(PhoneNumberUtil.class.getName());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "884BE42B71C8AFCCDFE2F81DD7984AEC", hash_generated_field = "E8D70D579EE71EED8B98C0388E1E577B")

    private static String UNKNOWN_REGION = "ZZ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "165C3547A5B97982AD01C097E4AB5E6F", hash_generated_field = "F90C911C442DF857E4F72DF3FB3716B3")

    private static int NANPA_COUNTRY_CODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "3B32202ED9382EE062B7ADF2582F4E22", hash_generated_field = "05451B4448AC4BD80FDC8D563286022C")

    static char PLUS_SIGN = '+';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "5E538434F72E6A54DF5E9589E388BB2A", hash_generated_field = "9808699BE52871273B0DB0A9BF921BB9")

    private static String RFC3966_EXTN_PREFIX = ";ext=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "61274886CC209D383752DF2C4E45019A", hash_generated_field = "AC50CA36F96F68F3E68F8306B67F17A6")

    private static Map<Character, Character> ALPHA_MAPPINGS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "A687A96E121E0460B5D23B2EB5227386", hash_generated_field = "6540E96DA6A170C8F59559A1CA13BA85")

    private static Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "33227356DEF684B5B69E6F1BC1B64C04", hash_generated_field = "8BA2CD3F690AB362D76BB15FA383BE12")

    private static Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    static {
    HashMap<Character, Character> asciiDigitMappings = new HashMap<Character, Character>();
    asciiDigitMappings.put('0', '0');
    asciiDigitMappings.put('1', '1');
    asciiDigitMappings.put('2', '2');
    asciiDigitMappings.put('3', '3');
    asciiDigitMappings.put('4', '4');
    asciiDigitMappings.put('5', '5');
    asciiDigitMappings.put('6', '6');
    asciiDigitMappings.put('7', '7');
    asciiDigitMappings.put('8', '8');
    asciiDigitMappings.put('9', '9');
    HashMap<Character, Character> alphaMap = new HashMap<Character, Character>(40);
    alphaMap.put('A', '2');
    alphaMap.put('B', '2');
    alphaMap.put('C', '2');
    alphaMap.put('D', '3');
    alphaMap.put('E', '3');
    alphaMap.put('F', '3');
    alphaMap.put('G', '4');
    alphaMap.put('H', '4');
    alphaMap.put('I', '4');
    alphaMap.put('J', '5');
    alphaMap.put('K', '5');
    alphaMap.put('L', '5');
    alphaMap.put('M', '6');
    alphaMap.put('N', '6');
    alphaMap.put('O', '6');
    alphaMap.put('P', '7');
    alphaMap.put('Q', '7');
    alphaMap.put('R', '7');
    alphaMap.put('S', '7');
    alphaMap.put('T', '8');
    alphaMap.put('U', '8');
    alphaMap.put('V', '8');
    alphaMap.put('W', '9');
    alphaMap.put('X', '9');
    alphaMap.put('Y', '9');
    alphaMap.put('Z', '9');
    ALPHA_MAPPINGS = Collections.unmodifiableMap(alphaMap);
    HashMap<Character, Character> combinedMap = new HashMap<Character, Character>(100);
    combinedMap.putAll(ALPHA_MAPPINGS);
    combinedMap.putAll(asciiDigitMappings);
    ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(combinedMap);
    HashMap<Character, Character> allPlusNumberGroupings = new HashMap<Character, Character>();
    for (char c : ALPHA_MAPPINGS.keySet()) {
      allPlusNumberGroupings.put(Character.toLowerCase(c), c);
      allPlusNumberGroupings.put(c, c);
    }
    allPlusNumberGroupings.putAll(asciiDigitMappings);
    allPlusNumberGroupings.put('-', '-');
    allPlusNumberGroupings.put('\uFF0D', '-');
    allPlusNumberGroupings.put('\u2010', '-');
    allPlusNumberGroupings.put('\u2011', '-');
    allPlusNumberGroupings.put('\u2012', '-');
    allPlusNumberGroupings.put('\u2013', '-');
    allPlusNumberGroupings.put('\u2014', '-');
    allPlusNumberGroupings.put('\u2015', '-');
    allPlusNumberGroupings.put('\u2212', '-');
    allPlusNumberGroupings.put('/', '/');
    allPlusNumberGroupings.put('\uFF0F', '/');
    allPlusNumberGroupings.put(' ', ' ');
    allPlusNumberGroupings.put('\u3000', ' ');
    allPlusNumberGroupings.put('\u2060', ' ');
    allPlusNumberGroupings.put('.', '.');
    allPlusNumberGroupings.put('\uFF0E', '.');
    ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(allPlusNumberGroupings);
  }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "B8EB3CEE9DCE9972530AFEAA48801022", hash_generated_field = "23B3B56C27E9B51D1C901C6BEAE06D7B")

    private static Pattern UNIQUE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~\u2053\u223C\uFF5E][\\d]+)?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "95E7EE317F57B907866F30266B1172FE", hash_generated_field = "A4971D0B125403D91F2CEC146A313DC5")

    static String VALID_PUNCTUATION = "-x\u2010-\u2015\u2212\u30FC\uFF0D-\uFF0F " +
      "\u00A0\u200B\u2060\u3000()\uFF08\uFF09\uFF3B\uFF3D.\\[\\]/~\u2053\u223C\uFF5E";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "1A64355EF67E8035AEBC5332495B29C2", hash_generated_field = "396CF1B4E75D6D298845FED3B721D85E")

    private static String DIGITS = "\\p{Nd}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "B53AD5BC99FF6E99B2013691434E5AE0", hash_generated_field = "7B87B42D318FB2814EF0C509D4E892D2")

    private static String VALID_ALPHA = Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", "") +
      Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "CDAC17B00A8EFF3BB0A83D83D11A2136", hash_generated_field = "3144EC4D2739554198D221061872AFD3")

    static String PLUS_CHARS = "+\uFF0B";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "E58FEF7945499412B1D8834E7B62FDFC", hash_generated_field = "821C90A57EEC14D2FEBD91E106BE6F03")

    static Pattern PLUS_CHARS_PATTERN = Pattern.compile("[" + PLUS_CHARS + "]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "9733A99E32EE6D850D49F03364042404", hash_generated_field = "AA113F2F28705FAFC00D22E96DEAF1A5")

    private static Pattern SEPARATOR_PATTERN = Pattern.compile("[" + VALID_PUNCTUATION + "]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "0F0E7FFB40A9BBB6394BA2DC9D119A3E", hash_generated_field = "57E42F0FC7F95B34387F195B3532B565")

    private static Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(" + DIGITS + ")");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_field = "7199DD487DD791E45C5E7ADA312C66FE", hash_generated_field = "737B85E7CE042D2D7EC40A6A12C0D837")

    private static String VALID_START_CHAR = "[" + PLUS_CHARS + DIGITS + "]";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "42974F132ECB34AE7B99307A1FB781B7", hash_generated_field = "78DED11A2556ADF27D0DD084472172A3")

    private static Pattern VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "DF9A27A84A3B17E686546336F0E7DF17", hash_generated_field = "357C089BBBA12318E6787ECCFDCA3AAD")

    private static String SECOND_NUMBER_START = "[\\\\/] *x";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "C63F4B685DE4C61316AE5B057C736F03", hash_generated_field = "BD1E97E62C1999958A5D6F7A50A384D3")

    static Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "9667044B078641F8136071D75237A26F", hash_generated_field = "D15189479E20EC249549A934311BB3AA")

    private static String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "3DE86B68F07EA4A22C07DE9AD7D1B843", hash_generated_field = "7FE50463072C379EADA38216E98DFD83")

    static Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "388E04BE9AE1682582E63208038A1441", hash_generated_field = "66728C09F2FB534896B0E6ECF8490975")

    private static Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "CFEAF1E44D986ABA68F85334B1721286", hash_generated_field = "816CB881F59F9FF42D309B7915ECDAAF")

    private static String VALID_PHONE_NUMBER = "[" + PLUS_CHARS + "]*(?:[" + VALID_PUNCTUATION + "]*" + DIGITS + "){3,}[" +
      VALID_PUNCTUATION + VALID_ALPHA + DIGITS + "]*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "D366A52A3A38CAB7A724B2F5FB251375", hash_generated_field = "B6DC71600C88F1DF5C6ACD84290F4F32")

    private static String DEFAULT_EXTN_PREFIX = " ext. ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "0196836C4DD5E6CC55770577EA98447B", hash_generated_field = "46FB46A67EC2F174E1CC7D16B2270902")

    private static String CAPTURING_EXTN_DIGITS = "(" + DIGITS + "{1,7})";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "A5DCAE8D232697D3B884F219BE6B2609", hash_generated_field = "3CBD86B8E6DD6E504D2DA4A1A75D3950")

    private static String EXTN_PATTERNS_FOR_PARSING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "09EF60EAE97616A471FBE501F4663001", hash_generated_field = "8AEC46C66A511C8270E50678714A3A2B")

    static String EXTN_PATTERNS_FOR_MATCHING;
    static {
    String singleExtnSymbolsForMatching = "x\uFF58#\uFF03~\uFF5E";
    String singleExtnSymbolsForParsing = "," + singleExtnSymbolsForMatching;
    EXTN_PATTERNS_FOR_PARSING = createExtnPattern(singleExtnSymbolsForParsing);
    EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(singleExtnSymbolsForMatching);
  }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "FB4CC22DAA10D4F465BC655E6188170A", hash_generated_field = "4CB3CAF20B72ED776D54DC7A1C9971F5")

    private static Pattern EXTN_PATTERN = Pattern.compile("(?:" + EXTN_PATTERNS_FOR_PARSING + ")$", REGEX_FLAGS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "ED5EA621ABE5320A1C34DBAD53D0A061", hash_generated_field = "EF2C0EC2E3AEEDFBCEE56BCEE52B7447")

    private static Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile(VALID_PHONE_NUMBER + "(?:" + EXTN_PATTERNS_FOR_PARSING + ")?", REGEX_FLAGS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "4AE14BB5F2520F4E3FF1E5D12782356E", hash_generated_field = "62C7FC29F360FBD91A7A4983FCB7E19C")

    private static Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "CD953C1DEE4ADD552C476477C6EADD8A", hash_generated_field = "2F2F7D30E7878B30AB23C36055C55B00")

    private static Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "3D193ACEBF04669BC83D13231DAB8702", hash_generated_field = "F7C29ABF8D9B811768871B7BE58AB586")

    private static Pattern NP_PATTERN = Pattern.compile("\\$NP");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "A03C277F3A7F8A20EA0B481820598B2A", hash_generated_field = "C9DF1AEAB17CE2F84A7E73A23EC34D27")

    private static Pattern FG_PATTERN = Pattern.compile("\\$FG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "DE10DE8A40C3C1EC916E7B66F64ABD87", hash_generated_field = "80E847296E22111FB8197C1BEF222D3A")

    private static Pattern CC_PATTERN = Pattern.compile("\\$CC");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.435 -0400", hash_original_field = "A81ED48CF13BC1CB56AE4320709DE841", hash_generated_field = "90932A776869C6233A72E88783493EDF")

    private static PhoneNumberUtil instance = null;
}

