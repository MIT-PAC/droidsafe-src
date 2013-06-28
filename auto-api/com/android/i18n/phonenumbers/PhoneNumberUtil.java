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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.179 -0400", hash_original_field = "E8745D64C3DDF690DBE72A168636F59F", hash_generated_field = "01E27589414D4F00E028D65F7226ED03")

    private String currentFilePrefix = META_DATA_FILE_PREFIX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.179 -0400", hash_original_field = "B57D2492E5166B044429F301D8A74EA1", hash_generated_field = "BD442BEB298EC056D47850ADBC00339A")

    private Map<Integer, List<String>> countryCallingCodeToRegionCodeMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.179 -0400", hash_original_field = "4F55F961D3BC9EA226649AD63B138E32", hash_generated_field = "445AB292FFFF955C361081EF0C7CBBDA")

    private final Set<String> supportedRegions = new HashSet<String>(300);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.179 -0400", hash_original_field = "8675D15B1E320E731CDACFDFD78EBF22", hash_generated_field = "146729E450C9E16732378FDEF2691E9D")

    private final Set<String> nanpaRegions = new HashSet<String>(35);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.179 -0400", hash_original_field = "67B854AC1D3C388AC75FA01E35F25AAD", hash_generated_field = "34A606E45DB6BE384928258B5F11EAAA")

    private final Map<String, PhoneMetadata> regionToMetadataMap = Collections.synchronizedMap(new HashMap<String, PhoneMetadata>());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.179 -0400", hash_original_field = "4955B1F9986A64262B91DC1CEA30A4DA", hash_generated_field = "D87E3F8DA6908FEB810F4EC6D5D33CCE")

    private RegexCache regexCache = new RegexCache(100);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.180 -0400", hash_original_method = "3DBAF8008FFD9E53011E9436972AF77A", hash_generated_method = "E3CE9121B94C12BEE25C8B5EDF30F992")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.186 -0400", hash_original_method = "E42A7007FDB19817C28C648F3339DD4F", hash_generated_method = "78C610DB809EA4F224550548F03EE6D4")
    private void init(String filePrefix) {
        currentFilePrefix = filePrefix;
        {
            Iterator<List<String>> var778680903355374D2ABCD15DF60BF74B_101926472 = (countryCallingCodeToRegionCodeMap.values()).iterator();
            var778680903355374D2ABCD15DF60BF74B_101926472.hasNext();
            List<String> regionCodes = var778680903355374D2ABCD15DF60BF74B_101926472.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.198 -0400", hash_original_method = "D4A5DED95C2EE22965F522507C270AF5", hash_generated_method = "79A2156CD074A49EB9923274507AA4E1")
    private void loadMetadataForRegionFromFile(String filePrefix, String regionCode) {
        InputStream source = PhoneNumberUtil.class.getResourceAsStream(filePrefix + "_" + regionCode);
        ObjectInputStream in = null;
        try 
        {
            in = new ObjectInputStream(source);
            PhoneMetadataCollection metadataCollection = new PhoneMetadataCollection();
            metadataCollection.readExternal(in);
            {
                Iterator<PhoneMetadata> var0ED4A94BB8726E6BB60B0FB5A23A1BC6_1672256635 = (metadataCollection.getMetadataList()).iterator();
                var0ED4A94BB8726E6BB60B0FB5A23A1BC6_1672256635.hasNext();
                PhoneMetadata metadata = var0ED4A94BB8726E6BB60B0FB5A23A1BC6_1672256635.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.200 -0400", hash_original_method = "A1113EBAB3D0682FE612F1231142344C", hash_generated_method = "823D516066EE954167408BC1E65F4A41")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.210 -0400", hash_original_method = "E944B5FE31AE1466662F85766A880CA9", hash_generated_method = "00BE35C2240FD2332E95A6ACC62725D0")
    public int getLengthOfGeographicalAreaCode(PhoneNumber number) {
        String regionCode = getRegionCodeForNumber(number);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1680481576 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        {
            boolean var0F19B7C791578713C08B724D7EF83463_960713125 = (!metadata.hasNationalPrefix());
        } //End collapsed parenthetic
        PhoneNumberType type = getNumberTypeHelper(getNationalSignificantNumber(number),
                                               metadata);
        int var1A7583635198F8188F31B01169649F72_2088279054 = (getLengthOfNationalDestinationCode(number));
        addTaint(number.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819526905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819526905;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.212 -0400", hash_original_method = "8F375C460DFE06AB35507021B2E67F57", hash_generated_method = "7683A9D4813E901BDE8CEB0165487723")
    public int getLengthOfNationalDestinationCode(PhoneNumber number) {
        PhoneNumber copiedProto;
        {
            boolean varA0334A328D5A78F314E250C07987CBB9_2145370407 = (number.hasExtension());
            {
                copiedProto = new PhoneNumber();
                copiedProto.mergeFrom(number);
                copiedProto.clearExtension();
            } //End block
            {
                copiedProto = number;
            } //End block
        } //End collapsed parenthetic
        String nationalSignificantNumber = format(copiedProto,
                                              PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        String[] numberGroups = NON_DIGITS_PATTERN.split(nationalSignificantNumber);
        {
            boolean varB39750E63BD6A0A6A4462637FFDF05DA_1401530973 = (getRegionCodeForNumber(number).equals("AR") &&
        getNumberType(number) == PhoneNumberType.MOBILE);
            {
                int varBE9BA5C465177F729DAFFF7C34A984CE_269183153 = (numberGroups[3].length() + 1);
            } //End block
        } //End collapsed parenthetic
        int var9AE7A3309C2132BA3FD6101ABCDB2E2F_1137697181 = (numberGroups[2].length());
        addTaint(number.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063544385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063544385;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.213 -0400", hash_original_method = "8806D3371D9E306571E478F8E387F5F6", hash_generated_method = "D0F2A57B1555FFD178A459AD51FDA627")
    public Set<String> getSupportedRegions() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_15284941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_15284941 = supportedRegions;
        varB4EAC82CA7396A68D541C85D26508E83_15284941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_15284941;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.214 -0400", hash_original_method = "BD64224247A46B4F8D1913B12FB0926A", hash_generated_method = "6DC3E93E8DFE0EAF48B983AD802AE250")
    private boolean isValidRegionCode(String regionCode) {
        boolean var7DED5D1C831FA25A1913B196FCADCCAC_1878675861 = (regionCode != null && supportedRegions.contains(regionCode));
        addTaint(regionCode.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945570960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945570960;
        // ---------- Original Method ----------
        //return regionCode != null && supportedRegions.contains(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.214 -0400", hash_original_method = "8968A71862E924379D457A4D52F2E514", hash_generated_method = "D05E30512EBE2C5B37CF562FBB37ACE0")
    private boolean hasValidRegionCode(String regionCode,
                                     int countryCallingCode, String number) {
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1411352563 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.WARNING,
                 "Number " + number + " has invalid or missing country calling code ("
                 + countryCallingCode + ")");
            } //End block
        } //End collapsed parenthetic
        addTaint(regionCode.getTaint());
        addTaint(countryCallingCode);
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865016237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_865016237;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //LOGGER.log(Level.WARNING,
                 //"Number " + number + " has invalid or missing country calling code ("
                 //+ countryCallingCode + ")");
      //return false;
    //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.214 -0400", hash_original_method = "92F92B14F8645805E8F2936964CC9FBD", hash_generated_method = "6853DD103B0EA47617A4EE49C31B0504")
    public String format(PhoneNumber number, PhoneNumberFormat numberFormat) {
        String varB4EAC82CA7396A68D541C85D26508E83_1550354338 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_349567326 = null; //Variable for return #2
        {
            boolean varC5703F7758E4CCF6C68B52402D8E9ACF_130954096 = (number.getNationalNumber() == 0 && number.hasRawInput());
            {
                String rawInput = number.getRawInput();
                {
                    boolean var555F97EE0F80891C0AF723C26C2ED746_717137637 = (rawInput.length() > 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1550354338 = rawInput;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        StringBuilder formattedNumber = new StringBuilder(20);
        format(number, numberFormat, formattedNumber);
        varB4EAC82CA7396A68D541C85D26508E83_349567326 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(numberFormat.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1631071415; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1631071415 = varB4EAC82CA7396A68D541C85D26508E83_1550354338;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1631071415 = varB4EAC82CA7396A68D541C85D26508E83_349567326;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1631071415.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1631071415;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.215 -0400", hash_original_method = "0E0E29DD0B07020C65FE41B70E3EF74E", hash_generated_method = "7E9E8D4444253FCD103DDA5A0845AD27")
    public void format(PhoneNumber number, PhoneNumberFormat numberFormat,
                     StringBuilder formattedNumber) {
        formattedNumber.setLength(0);
        int countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            formattedNumber.append(nationalSignificantNumber);
            formatNumberByFormat(countryCallingCode, PhoneNumberFormat.E164, formattedNumber);
        } //End block
        String regionCode = getRegionCodeForCountryCode(countryCallingCode);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1352340658 = (!isValidRegionCode(regionCode));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.224 -0400", hash_original_method = "9F9F17BED2EE6CF557E830A9924BD1F5", hash_generated_method = "589183557A8AA073DA5CBC4DE8B42CC3")
    public String formatByPattern(PhoneNumber number,
                                PhoneNumberFormat numberFormat,
                                List<NumberFormat> userDefinedFormats) {
        String varB4EAC82CA7396A68D541C85D26508E83_1036305994 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_207638444 = null; //Variable for return #2
        int countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        String regionCode = getRegionCodeForCountryCode(countryCallingCode);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_1038556408 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1036305994 = nationalSignificantNumber;
            } //End block
        } //End collapsed parenthetic
        List<NumberFormat> userDefinedFormatsCopy = new ArrayList<NumberFormat>(userDefinedFormats.size());
        {
            Iterator<NumberFormat> varDE538608319C22BEA07652839B747B9B_1551427304 = (userDefinedFormats).iterator();
            varDE538608319C22BEA07652839B747B9B_1551427304.hasNext();
            NumberFormat numFormat = varDE538608319C22BEA07652839B747B9B_1551427304.next();
            {
                String nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
                {
                    boolean var49F508BC12F9753C65EDF4F4D8419A12_400645259 = (nationalPrefixFormattingRule.length() > 0);
                    {
                        NumberFormat numFormatCopy = new NumberFormat();
                        numFormatCopy.mergeFrom(numFormat);
                        String nationalPrefix = getMetadataForRegion(regionCode).getNationalPrefix();
                        {
                            boolean var4F43214BACA2879442D7C6FFEA040E27_646635204 = (nationalPrefix.length() > 0);
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
        StringBuilder formattedNumber = new StringBuilder(formatAccordingToFormats(nationalSignificantNumber,
                                                   userDefinedFormatsCopy,
                                                   numberFormat));
        maybeGetFormattedExtension(number, regionCode, numberFormat, formattedNumber);
        formatNumberByFormat(countryCallingCode, numberFormat, formattedNumber);
        varB4EAC82CA7396A68D541C85D26508E83_207638444 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(userDefinedFormats.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1729711201; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1729711201 = varB4EAC82CA7396A68D541C85D26508E83_1036305994;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1729711201 = varB4EAC82CA7396A68D541C85D26508E83_207638444;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1729711201.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1729711201;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.226 -0400", hash_original_method = "91C4446CD1D629D514A31D665364644B", hash_generated_method = "049956384DA3A158A94E2221C0BA59CB")
    public String formatNationalNumberWithCarrierCode(PhoneNumber number, String carrierCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_885659942 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_257048286 = null; //Variable for return #2
        int countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        String regionCode = getRegionCodeForCountryCode(countryCallingCode);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_1175472679 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_885659942 = nationalSignificantNumber;
            } //End block
        } //End collapsed parenthetic
        StringBuilder formattedNumber = new StringBuilder(20);
        formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode,
                                                PhoneNumberFormat.NATIONAL,
                                                carrierCode));
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.NATIONAL, formattedNumber);
        formatNumberByFormat(countryCallingCode, PhoneNumberFormat.NATIONAL, formattedNumber);
        varB4EAC82CA7396A68D541C85D26508E83_257048286 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(carrierCode.getTaint());
        String varA7E53CE21691AB073D9660D615818899_905705213; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_905705213 = varB4EAC82CA7396A68D541C85D26508E83_885659942;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_905705213 = varB4EAC82CA7396A68D541C85D26508E83_257048286;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_905705213.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_905705213;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.227 -0400", hash_original_method = "4CA1ACD2C86EAA8A1981D39B6D2FA7BC", hash_generated_method = "82631ED5CC04679263DA0CD287852249")
    public String formatNationalNumberWithPreferredCarrierCode(PhoneNumber number,
                                                             String fallbackCarrierCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_345470814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_345470814 = formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       ? number.getPreferredDomesticCarrierCode()
                                                       : fallbackCarrierCode);
        addTaint(number.getTaint());
        addTaint(fallbackCarrierCode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_345470814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345470814;
        // ---------- Original Method ----------
        //return formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       //? number.getPreferredDomesticCarrierCode()
                                                       //: fallbackCarrierCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.228 -0400", hash_original_method = "F62393BCCF4A49D66E11EE7D750D9FD1", hash_generated_method = "ACBBF230DE66691B9C0AD82EC338CE91")
    public String formatOutOfCountryCallingNumber(PhoneNumber number,
                                                String regionCallingFrom) {
        String varB4EAC82CA7396A68D541C85D26508E83_1124687728 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_17861425 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_979069875 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1859396967 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_420645524 = null; //Variable for return #5
        {
            boolean varD048F64EC3C8401D282F486A6CF615B6_2077005567 = (!isValidRegionCode(regionCallingFrom));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1124687728 = format(number, PhoneNumberFormat.INTERNATIONAL);
            } //End block
        } //End collapsed parenthetic
        int countryCallingCode = number.getCountryCode();
        String regionCode = getRegionCodeForCountryCode(countryCallingCode);
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_1814146292 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_17861425 = nationalSignificantNumber;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var87EDDF67CA1AA758C72D3792FA55B762_2068765890 = (isNANPACountry(regionCallingFrom));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_979069875 = countryCallingCode + " " + format(number, PhoneNumberFormat.NATIONAL);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var33EA6E04A6ABE181DFBBC2046931D651_1657280601 = (countryCallingCode == getCountryCodeForRegion(regionCallingFrom));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1859396967 = format(number, PhoneNumberFormat.NATIONAL);
            } //End block
        } //End collapsed parenthetic
        String formattedNationalNumber = formatNationalNumber(nationalSignificantNumber,
                             regionCode, PhoneNumberFormat.INTERNATIONAL);
        PhoneMetadata metadata = getMetadataForRegion(regionCallingFrom);
        String internationalPrefix = metadata.getInternationalPrefix();
        String internationalPrefixForFormatting = "";
        {
            boolean var98D851996F7DA14EE57E4E408EF3864D_1203519080 = (UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches());
            {
                internationalPrefixForFormatting = internationalPrefix;
            } //End block
            {
                boolean var5BD90B38377E183DFAF5B829C5613FB1_1455872003 = (metadata.hasPreferredInternationalPrefix());
                {
                    internationalPrefixForFormatting = metadata.getPreferredInternationalPrefix();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        StringBuilder formattedNumber = new StringBuilder(formattedNationalNumber);
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
        {
            boolean varF0253AB64B70C1C22F5442932A86160B_822714415 = (internationalPrefixForFormatting.length() > 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_420645524 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(regionCallingFrom.getTaint());
        String varA7E53CE21691AB073D9660D615818899_764301644; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_764301644 = varB4EAC82CA7396A68D541C85D26508E83_1124687728;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_764301644 = varB4EAC82CA7396A68D541C85D26508E83_17861425;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_764301644 = varB4EAC82CA7396A68D541C85D26508E83_979069875;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_764301644 = varB4EAC82CA7396A68D541C85D26508E83_1859396967;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_764301644 = varB4EAC82CA7396A68D541C85D26508E83_420645524;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_764301644.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_764301644;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.230 -0400", hash_original_method = "DB42BF938772B1A7D3909F64DD7B67BB", hash_generated_method = "2C05F4E207833AAB962D533B78FF2E26")
    public String formatInOriginalFormat(PhoneNumber number, String regionCallingFrom) {
        String varB4EAC82CA7396A68D541C85D26508E83_1651522902 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1060179188 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1951379145 = null; //Variable for return #3
        {
            boolean var2BA36454AB1825117E50288B4F67202D_1945317512 = (number.hasRawInput() &&
        (!hasFormattingPatternForNumber(number) || !isValidNumber(number)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1651522902 = number.getRawInput();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6C260429A491FE6501FBF10C9A9A3E9D_303939763 = (!number.hasCountryCodeSource());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1060179188 = format(number, PhoneNumberFormat.NATIONAL);
            } //End block
        } //End collapsed parenthetic
        String formattedNumber;
        {
            Object var3EC150F242A1103FEA1720F610B2B6E4_1011867991 = (number.getCountryCodeSource());
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
        String rawInput = number.getRawInput();
        varB4EAC82CA7396A68D541C85D26508E83_1951379145 = (formattedNumber != null &&
            normalizeDigitsOnly(formattedNumber).equals(normalizeDigitsOnly(rawInput)))
        ? formattedNumber
        : rawInput;
        addTaint(number.getTaint());
        addTaint(regionCallingFrom.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1592504070; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1592504070 = varB4EAC82CA7396A68D541C85D26508E83_1651522902;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1592504070 = varB4EAC82CA7396A68D541C85D26508E83_1060179188;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1592504070 = varB4EAC82CA7396A68D541C85D26508E83_1951379145;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1592504070.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1592504070;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.231 -0400", hash_original_method = "52E7EF7A7F940E41CFECD8D7BD9FA23C", hash_generated_method = "712CDDC46D81A272C1E324EA6CBA399D")
    private boolean hasFormattingPatternForNumber(PhoneNumber number) {
        String phoneNumberRegion = getRegionCodeForCountryCode(number.getCountryCode());
        PhoneMetadata metadata = getMetadataForRegion(phoneNumberRegion);
        String nationalNumber = getNationalSignificantNumber(number);
        NumberFormat formatRule = chooseFormattingPatternForNumber(metadata.numberFormats(), nationalNumber);
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1190184297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1190184297;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.244 -0400", hash_original_method = "4891B65BEA4A6D1403DAAAE11CCEEA80", hash_generated_method = "CD2312498D63032743636A2F73D7B6F7")
    public String formatOutOfCountryKeepingAlphaChars(PhoneNumber number,
                                                    String regionCallingFrom) {
        String varB4EAC82CA7396A68D541C85D26508E83_1824319822 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1456688213 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1119909126 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1741425452 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_362439284 = null; //Variable for return #5
        String rawInput = number.getRawInput();
        {
            boolean var56DE431416D41900B1A303BCD67165AA_621864314 = (rawInput.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1824319822 = formatOutOfCountryCallingNumber(number, regionCallingFrom);
            } //End block
        } //End collapsed parenthetic
        int countryCode = number.getCountryCode();
        String regionCode = getRegionCodeForCountryCode(countryCode);
        {
            boolean var6C6A5128B4A4E275737546ABC3B84693_1769219590 = (!hasValidRegionCode(regionCode, countryCode, rawInput));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1456688213 = rawInput;
            } //End block
        } //End collapsed parenthetic
        rawInput = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String nationalNumber = getNationalSignificantNumber(number);
        {
            boolean var24E952CC2DF3F15DA6E7744CA1ED0F83_1370895940 = (nationalNumber.length() > 3);
            {
                int firstNationalNumberDigit = rawInput.indexOf(nationalNumber.substring(0, 3));
                {
                    rawInput = rawInput.substring(firstNationalNumberDigit);
                } //End block
            } //End block
        } //End collapsed parenthetic
        PhoneMetadata metadata = getMetadataForRegion(regionCallingFrom);
        {
            {
                boolean var87EDDF67CA1AA758C72D3792FA55B762_1105831987 = (isNANPACountry(regionCallingFrom));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1119909126 = countryCode + " " + rawInput;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varC1B02B78273EEA3A2D0CE66FFC6E6BDD_448562619 = (countryCode == getCountryCodeForRegion(regionCallingFrom));
            {
                List<NumberFormat> availableFormats = new ArrayList<NumberFormat>(metadata.numberFormatSize());
                {
                    Iterator<NumberFormat> varC31BFE89CF3320F5E66FDF28F0557A8C_435052049 = (metadata.numberFormats()).iterator();
                    varC31BFE89CF3320F5E66FDF28F0557A8C_435052049.hasNext();
                    NumberFormat format = varC31BFE89CF3320F5E66FDF28F0557A8C_435052049.next();
                    {
                        NumberFormat newFormat = new NumberFormat();
                        newFormat.mergeFrom(format);
                        newFormat.setPattern("(\\d+)(.*)");
                        newFormat.setFormat("$1$2");
                        availableFormats.add(newFormat);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1741425452 = formatAccordingToFormats(rawInput, availableFormats, PhoneNumberFormat.NATIONAL);
            } //End block
        } //End collapsed parenthetic
        String internationalPrefix = metadata.getInternationalPrefix();
        String internationalPrefixForFormatting;
        boolean var6BBFED3C02F379AC58D09B7252F4F751_1152502742 = (UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches());
        internationalPrefixForFormatting = internationalPrefix;
        internationalPrefixForFormatting = metadata.getPreferredInternationalPrefix();
        StringBuilder formattedNumber = new StringBuilder(rawInput);
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
        {
            boolean varF0253AB64B70C1C22F5442932A86160B_806481821 = (internationalPrefixForFormatting.length() > 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_362439284 = formattedNumber.toString();
        addTaint(number.getTaint());
        addTaint(regionCallingFrom.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1511209859; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1511209859 = varB4EAC82CA7396A68D541C85D26508E83_1824319822;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1511209859 = varB4EAC82CA7396A68D541C85D26508E83_1456688213;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1511209859 = varB4EAC82CA7396A68D541C85D26508E83_1119909126;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1511209859 = varB4EAC82CA7396A68D541C85D26508E83_1741425452;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1511209859 = varB4EAC82CA7396A68D541C85D26508E83_362439284;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1511209859.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1511209859;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.246 -0400", hash_original_method = "D5C4512E5E6006B319585FD039F0D2D2", hash_generated_method = "CAACA3BEDE738E3E443CC2E5952CF29B")
    public String getNationalSignificantNumber(PhoneNumber number) {
        String varB4EAC82CA7396A68D541C85D26508E83_264346753 = null; //Variable for return #1
        StringBuilder nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");//DSFIXME:  CODE0008: Nested ternary operator in expression
        nationalNumber.append(number.getNationalNumber());
        varB4EAC82CA7396A68D541C85D26508E83_264346753 = nationalNumber.toString();
        addTaint(number.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_264346753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_264346753;
        // ---------- Original Method ----------
        //StringBuilder nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");
        //nationalNumber.append(number.getNationalNumber());
        //return nationalNumber.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.248 -0400", hash_original_method = "B30288467474491802F599221421F5DD", hash_generated_method = "25BA4C9E4452F6803D88A74F10F9E993")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.250 -0400", hash_original_method = "E72DB4CB518547F268CF62BAEDE813DC", hash_generated_method = "1BAB822E3D531E70A535DD5E4885A2D6")
    private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat) {
        String varB4EAC82CA7396A68D541C85D26508E83_2000912710 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2000912710 = formatNationalNumber(number, regionCode, numberFormat, null);
        addTaint(number.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(numberFormat.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2000912710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2000912710;
        // ---------- Original Method ----------
        //return formatNationalNumber(number, regionCode, numberFormat, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.251 -0400", hash_original_method = "C233FF64EBF86F393338B595D4311670", hash_generated_method = "DBEDFD8C63DF15D73179079A5C27F3FF")
    private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat,
                                      String carrierCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_1934707103 = null; //Variable for return #1
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        List<NumberFormat> intlNumberFormats = metadata.intlNumberFormats();
        List<NumberFormat> availableFormats;
        boolean var010176D6E07BAFEEE15C51961F359715_1791982268 = ((intlNumberFormats.size() == 0 || numberFormat == PhoneNumberFormat.NATIONAL));
        availableFormats = metadata.numberFormats();
        availableFormats = metadata.intlNumberFormats();
        String formattedNationalNumber = formatAccordingToFormats(number, availableFormats, numberFormat, carrierCode);
        {
            formattedNationalNumber =
          SEPARATOR_PATTERN.matcher(formattedNationalNumber).replaceAll("-");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1934707103 = formattedNationalNumber;
        addTaint(number.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(carrierCode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1934707103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1934707103;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.258 -0400", hash_original_method = "8234956A6CF3F674EC2E620926354B88", hash_generated_method = "3ED114E58CBAD9FA79D9500DC28BD50C")
    private NumberFormat chooseFormattingPatternForNumber(List<NumberFormat> availableFormats,
                                                        String nationalNumber) {
        NumberFormat varB4EAC82CA7396A68D541C85D26508E83_2054648241 = null; //Variable for return #1
        NumberFormat varB4EAC82CA7396A68D541C85D26508E83_899581422 = null; //Variable for return #2
        {
            Iterator<NumberFormat> varF2F667EBE5B32705ED5F28A1B5BB1A9A_219637191 = (availableFormats).iterator();
            varF2F667EBE5B32705ED5F28A1B5BB1A9A_219637191.hasNext();
            NumberFormat numFormat = varF2F667EBE5B32705ED5F28A1B5BB1A9A_219637191.next();
            {
                int size = numFormat.leadingDigitsPatternSize();
                {
                    boolean var70C01298E9B9CEE3566223FF0F4729C7_1604623056 = (size == 0 || regexCache.getPatternForRegex(
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt());
                    {
                        Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                        {
                            boolean var21FF6A85D73745B4A18613C0C4E00A23_842192110 = (m.matches());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_2054648241 = numFormat;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_899581422 = null;
        addTaint(availableFormats.getTaint());
        addTaint(nationalNumber.getTaint());
        NumberFormat varA7E53CE21691AB073D9660D615818899_383879841; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_383879841 = varB4EAC82CA7396A68D541C85D26508E83_2054648241;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_383879841 = varB4EAC82CA7396A68D541C85D26508E83_899581422;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_383879841.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_383879841;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.259 -0400", hash_original_method = "ABA7814B1012D26F514E5605C0CC3287", hash_generated_method = "F658BDA899B4529852BE2B7A34A55A89")
    private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat) {
        String varB4EAC82CA7396A68D541C85D26508E83_1930340096 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1930340096 = formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null);
        addTaint(nationalNumber.getTaint());
        addTaint(availableFormats.getTaint());
        addTaint(numberFormat.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1930340096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1930340096;
        // ---------- Original Method ----------
        //return formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.267 -0400", hash_original_method = "58A13E9521CF391FA7B0E516ACC9ED0C", hash_generated_method = "171AF5224318B894D2889D7DBE5E83B5")
    private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat,
                                          String carrierCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_1891665248 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2012967566 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1488266182 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1718563554 = null; //Variable for return #4
        {
            Iterator<NumberFormat> varF2F667EBE5B32705ED5F28A1B5BB1A9A_445794733 = (availableFormats).iterator();
            varF2F667EBE5B32705ED5F28A1B5BB1A9A_445794733.hasNext();
            NumberFormat numFormat = varF2F667EBE5B32705ED5F28A1B5BB1A9A_445794733.next();
            {
                int size = numFormat.leadingDigitsPatternSize();
                {
                    boolean var70C01298E9B9CEE3566223FF0F4729C7_162431919 = (size == 0 || regexCache.getPatternForRegex(
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt());
                    {
                        Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                        {
                            boolean var21FF6A85D73745B4A18613C0C4E00A23_1437033289 = (m.matches());
                            {
                                String numberFormatRule = numFormat.getFormat();
                                {
                                    boolean var27E963F632C52F6E62BE94BB8EF98A0C_978878742 = (numberFormat == PhoneNumberFormat.NATIONAL &&
              carrierCode != null && carrierCode.length() > 0 &&
              numFormat.getDomesticCarrierCodeFormattingRule().length() > 0);
                                    {
                                        String carrierCodeFormattingRule = numFormat.getDomesticCarrierCodeFormattingRule();
                                        carrierCodeFormattingRule =
                CC_PATTERN.matcher(carrierCodeFormattingRule).replaceFirst(carrierCode);
                                        numberFormatRule = FIRST_GROUP_PATTERN.matcher(numberFormatRule)
                .replaceFirst(carrierCodeFormattingRule);
                                        varB4EAC82CA7396A68D541C85D26508E83_1891665248 = m.replaceAll(numberFormatRule);
                                    } //End block
                                    {
                                        String nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
                                        {
                                            boolean varFD5394A50BDD178AA2DA5B2252F56373_323039834 = (numberFormat == PhoneNumberFormat.NATIONAL &&
                nationalPrefixFormattingRule != null &&
                nationalPrefixFormattingRule.length() > 0);
                                            {
                                                Matcher firstGroupMatcher = FIRST_GROUP_PATTERN.matcher(numberFormatRule);
                                                varB4EAC82CA7396A68D541C85D26508E83_2012967566 = m.replaceAll(firstGroupMatcher.replaceFirst(nationalPrefixFormattingRule));
                                            } //End block
                                            {
                                                varB4EAC82CA7396A68D541C85D26508E83_1488266182 = m.replaceAll(numberFormatRule);
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
        varB4EAC82CA7396A68D541C85D26508E83_1718563554 = nationalNumber;
        addTaint(nationalNumber.getTaint());
        addTaint(availableFormats.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(carrierCode.getTaint());
        String varA7E53CE21691AB073D9660D615818899_957539320; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_957539320 = varB4EAC82CA7396A68D541C85D26508E83_1891665248;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_957539320 = varB4EAC82CA7396A68D541C85D26508E83_2012967566;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_957539320 = varB4EAC82CA7396A68D541C85D26508E83_1488266182;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_957539320 = varB4EAC82CA7396A68D541C85D26508E83_1718563554;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_957539320.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_957539320;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.267 -0400", hash_original_method = "B3C328ACE4FF3869EFF5C65F569BC538", hash_generated_method = "2D1F2E4F8E7C00C5BE87D9F37C4BD22C")
    public PhoneNumber getExampleNumber(String regionCode) {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1219096484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1219096484 = getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
        addTaint(regionCode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1219096484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1219096484;
        // ---------- Original Method ----------
        //return getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.268 -0400", hash_original_method = "B7676779AEFA9EF56CC59B101D8DF6C5", hash_generated_method = "81DDDFDF46EC9B64D9303A0328D7EF62")
    public PhoneNumber getExampleNumberForType(String regionCode, PhoneNumberType type) {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_2112264900 = null; //Variable for return #1
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1199256526 = null; //Variable for return #2
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1765639861 = null; //Variable for return #3
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_188794651 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.WARNING, "Invalid or unknown region code provided.");
                varB4EAC82CA7396A68D541C85D26508E83_2112264900 = null;
            } //End block
        } //End collapsed parenthetic
        PhoneNumberDesc desc = getNumberDescByType(getMetadataForRegion(regionCode), type);
        try 
        {
            {
                boolean var332E3945C68B1E0C027A1E732CD697F2_2018362227 = (desc.hasExampleNumber());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1199256526 = parse(desc.getExampleNumber(), regionCode);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (NumberParseException e)
        {
            LOGGER.log(Level.SEVERE, e.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1765639861 = null;
        addTaint(regionCode.getTaint());
        addTaint(type.getTaint());
        PhoneNumber varA7E53CE21691AB073D9660D615818899_1529589161; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1529589161 = varB4EAC82CA7396A68D541C85D26508E83_2112264900;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1529589161 = varB4EAC82CA7396A68D541C85D26508E83_1199256526;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1529589161 = varB4EAC82CA7396A68D541C85D26508E83_1765639861;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1529589161.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1529589161;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.268 -0400", hash_original_method = "6C2C2EA977BB9169AEFD40896548847E", hash_generated_method = "D698A70A1A8148EA7D5150BFF5840B3F")
    private void maybeGetFormattedExtension(PhoneNumber number, String regionCode,
                                          PhoneNumberFormat numberFormat,
                                          StringBuilder formattedNumber) {
        {
            boolean var6CC2B5EB06BA8F69F485F7B9578BCDBB_470161238 = (number.hasExtension() && number.getExtension().length() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.268 -0400", hash_original_method = "4E1A69FB5E070DF7BC56976B37027181", hash_generated_method = "559553FC6D5BB809F30419DAB02B868D")
    private void formatExtension(String extensionDigits, String regionCode,
                               StringBuilder extension) {
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        {
            boolean varE40ED1FD3A4A1BCF90B2F107CACB31BD_663781971 = (metadata.hasPreferredExtnPrefix());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.269 -0400", hash_original_method = "B508A0D4C9257AABA72DD1888D64C9E3", hash_generated_method = "B101D55F27418A24D722E33123D9AF90")
     PhoneNumberDesc getNumberDescByType(PhoneMetadata metadata, PhoneNumberType type) {
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_74430410 = null; //Variable for return #1
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_69917106 = null; //Variable for return #2
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_285006849 = null; //Variable for return #3
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_463342638 = null; //Variable for return #4
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_368929386 = null; //Variable for return #5
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_953679991 = null; //Variable for return #6
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1972584932 = null; //Variable for return #7
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_314138633 = null; //Variable for return #8
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1866252226 = null; //Variable for return #9
        PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1422502460 = null; //Variable for return #10
        //Begin case PREMIUM_RATE 
        varB4EAC82CA7396A68D541C85D26508E83_74430410 = metadata.getPremiumRate();
        //End case PREMIUM_RATE 
        //Begin case TOLL_FREE 
        varB4EAC82CA7396A68D541C85D26508E83_69917106 = metadata.getTollFree();
        //End case TOLL_FREE 
        //Begin case MOBILE 
        varB4EAC82CA7396A68D541C85D26508E83_285006849 = metadata.getMobile();
        //End case MOBILE 
        //Begin case FIXED_LINE FIXED_LINE_OR_MOBILE 
        varB4EAC82CA7396A68D541C85D26508E83_463342638 = metadata.getFixedLine();
        //End case FIXED_LINE FIXED_LINE_OR_MOBILE 
        //Begin case SHARED_COST 
        varB4EAC82CA7396A68D541C85D26508E83_368929386 = metadata.getSharedCost();
        //End case SHARED_COST 
        //Begin case VOIP 
        varB4EAC82CA7396A68D541C85D26508E83_953679991 = metadata.getVoip();
        //End case VOIP 
        //Begin case PERSONAL_NUMBER 
        varB4EAC82CA7396A68D541C85D26508E83_1972584932 = metadata.getPersonalNumber();
        //End case PERSONAL_NUMBER 
        //Begin case PAGER 
        varB4EAC82CA7396A68D541C85D26508E83_314138633 = metadata.getPager();
        //End case PAGER 
        //Begin case UAN 
        varB4EAC82CA7396A68D541C85D26508E83_1866252226 = metadata.getUan();
        //End case UAN 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_1422502460 = metadata.getGeneralDesc();
        //End case default 
        addTaint(metadata.getTaint());
        addTaint(type.getTaint());
        PhoneNumberDesc varA7E53CE21691AB073D9660D615818899_418627101; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_74430410;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_69917106;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_285006849;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_463342638;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_368929386;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_953679991;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_1972584932;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_314138633;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_1866252226;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_418627101 = varB4EAC82CA7396A68D541C85D26508E83_1422502460;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_418627101.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_418627101;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.269 -0400", hash_original_method = "261D2E3780968B6A389AA5653D83C66D", hash_generated_method = "CD95FDB39133927693EB3F61F8B9808D")
    public PhoneNumberType getNumberType(PhoneNumber number) {
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_967672509 = null; //Variable for return #1
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1501860759 = null; //Variable for return #2
        String regionCode = getRegionCodeForNumber(number);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_990158876 = (!isValidRegionCode(regionCode));
            {
                varB4EAC82CA7396A68D541C85D26508E83_967672509 = PhoneNumberType.UNKNOWN;
            } //End block
        } //End collapsed parenthetic
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        varB4EAC82CA7396A68D541C85D26508E83_1501860759 = getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode));
        addTaint(number.getTaint());
        PhoneNumberType varA7E53CE21691AB073D9660D615818899_1832157234; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1832157234 = varB4EAC82CA7396A68D541C85D26508E83_967672509;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1832157234 = varB4EAC82CA7396A68D541C85D26508E83_1501860759;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1832157234.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1832157234;
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //if (!isValidRegionCode(regionCode)) {
      //return PhoneNumberType.UNKNOWN;
    //}
        //String nationalSignificantNumber = getNationalSignificantNumber(number);
        //return getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.270 -0400", hash_original_method = "CFBB065FE396C61ECB0C897E1E4B66DC", hash_generated_method = "70DB86154FAF3275B4C25DC0333C4CBB")
    private PhoneNumberType getNumberTypeHelper(String nationalNumber, PhoneMetadata metadata) {
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1378501759 = null; //Variable for return #1
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1760116725 = null; //Variable for return #2
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_148856428 = null; //Variable for return #3
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_506603937 = null; //Variable for return #4
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1938249403 = null; //Variable for return #5
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_513225790 = null; //Variable for return #6
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1261226271 = null; //Variable for return #7
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_792616553 = null; //Variable for return #8
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1916307452 = null; //Variable for return #9
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_1839765115 = null; //Variable for return #10
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_180605532 = null; //Variable for return #11
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_735407440 = null; //Variable for return #12
        PhoneNumberType varB4EAC82CA7396A68D541C85D26508E83_303088874 = null; //Variable for return #13
        PhoneNumberDesc generalNumberDesc = metadata.getGeneralDesc();
        {
            boolean var5B173D1DFC1562F0020B057904EE0B3C_436844516 = (!generalNumberDesc.hasNationalNumberPattern() ||
        !isNumberMatchingDesc(nationalNumber, generalNumberDesc));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1378501759 = PhoneNumberType.UNKNOWN;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFC5517BA7F51C044D62329DD8DA33803_1855361534 = (isNumberMatchingDesc(nationalNumber, metadata.getPremiumRate()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1760116725 = PhoneNumberType.PREMIUM_RATE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC1B0D4362E20F4D15396EDA203322A7B_1602520763 = (isNumberMatchingDesc(nationalNumber, metadata.getTollFree()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_148856428 = PhoneNumberType.TOLL_FREE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4050D2117B44C187237158BD69941F37_1346765090 = (isNumberMatchingDesc(nationalNumber, metadata.getSharedCost()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_506603937 = PhoneNumberType.SHARED_COST;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391D271B9C8CED3D2BFA2E53ADE2C8A3_1606079083 = (isNumberMatchingDesc(nationalNumber, metadata.getVoip()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1938249403 = PhoneNumberType.VOIP;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBF02F0578A5A843F636ECA3493243BE6_1054286491 = (isNumberMatchingDesc(nationalNumber, metadata.getPersonalNumber()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_513225790 = PhoneNumberType.PERSONAL_NUMBER;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var50FD2167C2C1685ED42EE82A11A93B25_880593529 = (isNumberMatchingDesc(nationalNumber, metadata.getPager()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1261226271 = PhoneNumberType.PAGER;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var43080BFDC919D8A6AC3E511D3259EF4E_167401883 = (isNumberMatchingDesc(nationalNumber, metadata.getUan()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_792616553 = PhoneNumberType.UAN;
            } //End block
        } //End collapsed parenthetic
        boolean isFixedLine = isNumberMatchingDesc(nationalNumber, metadata.getFixedLine());
        {
            {
                boolean var54343FDE9F348C9E4056CCA96B123FA1_1302669571 = (metadata.isSameMobileAndFixedLinePattern());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1916307452 = PhoneNumberType.FIXED_LINE_OR_MOBILE;
                } //End block
                {
                    boolean var0E0B18E4B567EBE5114CB7B2F558C5D5_228293317 = (isNumberMatchingDesc(nationalNumber, metadata.getMobile()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1839765115 = PhoneNumberType.FIXED_LINE_OR_MOBILE;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_180605532 = PhoneNumberType.FIXED_LINE;
        } //End block
        {
            boolean varF3C8C9AD58504637AE43DDCCBED0DAE8_664535038 = (!metadata.isSameMobileAndFixedLinePattern() &&
        isNumberMatchingDesc(nationalNumber, metadata.getMobile()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_735407440 = PhoneNumberType.MOBILE;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_303088874 = PhoneNumberType.UNKNOWN;
        addTaint(nationalNumber.getTaint());
        addTaint(metadata.getTaint());
        PhoneNumberType varA7E53CE21691AB073D9660D615818899_2084268396; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_1378501759;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_1760116725;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_148856428;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_506603937;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_1938249403;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_513225790;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_1261226271;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_792616553;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_1916307452;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_1839765115;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_180605532;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_735407440;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2084268396 = varB4EAC82CA7396A68D541C85D26508E83_303088874;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2084268396.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2084268396;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.271 -0400", hash_original_method = "B7D0F615A2820F4964EA69968467492C", hash_generated_method = "83DB8742D57B35F671A0031C3110D3DC")
     PhoneMetadata getMetadataForRegion(String regionCode) {
        PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1325972466 = null; //Variable for return #1
        PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1266696338 = null; //Variable for return #2
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1479021752 = (!isValidRegionCode(regionCode));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1325972466 = null;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var60A67063C3B37462B25FD4797CD4A0A0_1440697378 = (!regionToMetadataMap.containsKey(regionCode));
                {
                    loadMetadataForRegionFromFile(currentFilePrefix, regionCode);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1266696338 = regionToMetadataMap.get(regionCode);
        addTaint(regionCode.getTaint());
        PhoneMetadata varA7E53CE21691AB073D9660D615818899_158876328; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_158876328 = varB4EAC82CA7396A68D541C85D26508E83_1325972466;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_158876328 = varB4EAC82CA7396A68D541C85D26508E83_1266696338;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_158876328.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_158876328;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.271 -0400", hash_original_method = "B17A0514C43E05EB90EE98CA4CB42983", hash_generated_method = "A770B18ACE1ACCC7667363A4E8F22B10")
    private boolean isNumberMatchingDesc(String nationalNumber, PhoneNumberDesc numberDesc) {
        Matcher possibleNumberPatternMatcher = regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            .matcher(nationalNumber);
        Matcher nationalNumberPatternMatcher = regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            .matcher(nationalNumber);
        boolean var59CBFCA142FE36DE1654CBFBCE0A5F21_682948510 = (possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches());
        addTaint(nationalNumber.getTaint());
        addTaint(numberDesc.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184514593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184514593;
        // ---------- Original Method ----------
        //Matcher possibleNumberPatternMatcher =
        //regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            //.matcher(nationalNumber);
        //Matcher nationalNumberPatternMatcher =
        //regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            //.matcher(nationalNumber);
        //return possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.272 -0400", hash_original_method = "31ADC24E14E9CE703FF2777ACEC876BF", hash_generated_method = "5756A5ECB51B4AAE1A5CA8687C056B4B")
    public boolean isValidNumber(PhoneNumber number) {
        String regionCode = getRegionCodeForNumber(number);
        boolean var28FBA9C4B7A68485B8D67ECFF42CF1EB_1826827442 = ((isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode)));
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488628026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488628026;
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //return (isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.272 -0400", hash_original_method = "C701813EA11D8E6ADA1ECC6BB90E9747", hash_generated_method = "EE7BADB479E7BD5BCAA4605AA1A9AAE1")
    public boolean isValidNumberForRegion(PhoneNumber number, String regionCode) {
        {
            boolean var98525ED7F2835E26F2B24C7F8233B726_1146568110 = (number.getCountryCode() != getCountryCodeForRegion(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        PhoneNumberDesc generalNumDesc = metadata.getGeneralDesc();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean var6BBB06AEDF976ADEC9072013B0735BB1_769289524 = (!generalNumDesc.hasNationalNumberPattern());
            {
                int numberLength = nationalSignificantNumber.length();
            } //End block
        } //End collapsed parenthetic
        boolean varDB2FE427898C8D8020D29E442EFBBBDB_1615323646 = (getNumberTypeHelper(nationalSignificantNumber, metadata) != PhoneNumberType.UNKNOWN);
        addTaint(number.getTaint());
        addTaint(regionCode.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792543083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792543083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.274 -0400", hash_original_method = "C5C9CB0E93474118DAA9D7A65CA1060A", hash_generated_method = "B5950B4CE34A32D33B1700813E08F48B")
    public String getRegionCodeForNumber(PhoneNumber number) {
        String varB4EAC82CA7396A68D541C85D26508E83_337018800 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1050548294 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2014651141 = null; //Variable for return #3
        int countryCode = number.getCountryCode();
        List<String> regions = countryCallingCodeToRegionCodeMap.get(countryCode);
        {
            varB4EAC82CA7396A68D541C85D26508E83_337018800 = null;
        } //End block
        {
            boolean var10ED2DD9FF740B3AAF00BF9AEF0FF83C_1797438026 = (regions.size() == 1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1050548294 = regions.get(0);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_2014651141 = getRegionCodeForNumberFromRegionList(number, regions);
            } //End block
        } //End collapsed parenthetic
        addTaint(number.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1729662276; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1729662276 = varB4EAC82CA7396A68D541C85D26508E83_337018800;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1729662276 = varB4EAC82CA7396A68D541C85D26508E83_1050548294;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1729662276 = varB4EAC82CA7396A68D541C85D26508E83_2014651141;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1729662276.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1729662276;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.284 -0400", hash_original_method = "814AB76683AFE761330E661D695A8B3F", hash_generated_method = "B03CA363361350B46A422C0436343C69")
    private String getRegionCodeForNumberFromRegionList(PhoneNumber number,
                                                      List<String> regionCodes) {
        String varB4EAC82CA7396A68D541C85D26508E83_1043137215 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_652384454 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1925406776 = null; //Variable for return #3
        String nationalNumber = getNationalSignificantNumber(number);
        {
            Iterator<String> varCBD98C0A7F219455C413F8EC0E9FF73F_2061807617 = (regionCodes).iterator();
            varCBD98C0A7F219455C413F8EC0E9FF73F_2061807617.hasNext();
            String regionCode = varCBD98C0A7F219455C413F8EC0E9FF73F_2061807617.next();
            {
                PhoneMetadata metadata = getMetadataForRegion(regionCode);
                {
                    boolean varF2BDE8A0B1D079F49328DAC6385FA645_752135355 = (metadata.hasLeadingDigits());
                    {
                        {
                            boolean varAE03BEFF3A7C553963FE54EA102583D6_1178068625 = (regexCache.getPatternForRegex(metadata.getLeadingDigits())
                .matcher(nationalNumber).lookingAt());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1043137215 = regionCode;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varF0EA7F11B601F2E7D21312C63A7500A8_1817863250 = (getNumberTypeHelper(nationalNumber, metadata) != PhoneNumberType.UNKNOWN);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_652384454 = regionCode;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1925406776 = null;
        addTaint(number.getTaint());
        addTaint(regionCodes.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2070436481; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2070436481 = varB4EAC82CA7396A68D541C85D26508E83_1043137215;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2070436481 = varB4EAC82CA7396A68D541C85D26508E83_652384454;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2070436481 = varB4EAC82CA7396A68D541C85D26508E83_1925406776;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2070436481.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2070436481;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.285 -0400", hash_original_method = "DA9951AEFEAF4242112AA6281301B32F", hash_generated_method = "E7BC1A075F23519660B817BEB455153B")
    public String getRegionCodeForCountryCode(int countryCallingCode) {
        String varB4EAC82CA7396A68D541C85D26508E83_1534213826 = null; //Variable for return #1
        List<String> regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
        varB4EAC82CA7396A68D541C85D26508E83_1534213826 = regionCodes == null ? UNKNOWN_REGION : regionCodes.get(0);
        addTaint(countryCallingCode);
        varB4EAC82CA7396A68D541C85D26508E83_1534213826.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1534213826;
        // ---------- Original Method ----------
        //List<String> regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
        //return regionCodes == null ? UNKNOWN_REGION : regionCodes.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.286 -0400", hash_original_method = "D7076C7EB39C8978E29A5CA27F40EEC9", hash_generated_method = "84AAFA8B468E373EBA2035E8B0FB214E")
    public int getCountryCodeForRegion(String regionCode) {
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1716832518 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        int varDD48F4FF04794DCC6ACB188903D09223_281771027 = (metadata.getCountryCode());
        addTaint(regionCode.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558314394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558314394;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //return 0;
    //}
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //return metadata.getCountryCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.287 -0400", hash_original_method = "E58B423D76AD6194B45901E123DB6EBF", hash_generated_method = "EBB2928EDD5625A911F583A8C8505384")
    public String getNddPrefixForRegion(String regionCode, boolean stripNonDigits) {
        String varB4EAC82CA7396A68D541C85D26508E83_1822798808 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_508346694 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_704210242 = null; //Variable for return #3
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_461734158 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.SEVERE, "Invalid or missing region code provided.");
                varB4EAC82CA7396A68D541C85D26508E83_1822798808 = null;
            } //End block
        } //End collapsed parenthetic
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        String nationalPrefix = metadata.getNationalPrefix();
        {
            boolean var01C0F06701D85CDE650BDE5E4D96FB06_774790678 = (nationalPrefix.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_508346694 = null;
            } //End block
        } //End collapsed parenthetic
        {
            nationalPrefix = nationalPrefix.replace("~", "");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_704210242 = nationalPrefix;
        addTaint(regionCode.getTaint());
        addTaint(stripNonDigits);
        String varA7E53CE21691AB073D9660D615818899_240918725; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_240918725 = varB4EAC82CA7396A68D541C85D26508E83_1822798808;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_240918725 = varB4EAC82CA7396A68D541C85D26508E83_508346694;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_240918725 = varB4EAC82CA7396A68D541C85D26508E83_704210242;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_240918725.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_240918725;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.287 -0400", hash_original_method = "7B63C50F103D8DC60E8A2B15ED73A093", hash_generated_method = "64F8FC4F3C56C607AB62ADE2D5113B6C")
    public boolean isNANPACountry(String regionCode) {
        boolean var8AEB4252BA8A65A9B8C3173CF2CBF7D8_1023456554 = (nanpaRegions.contains(regionCode));
        addTaint(regionCode.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370186904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370186904;
        // ---------- Original Method ----------
        //return nanpaRegions.contains(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.288 -0400", hash_original_method = "996B7AC837898451564E65CADA674F54", hash_generated_method = "9AFB6ABC546073589EFF0C4A06246DE9")
     boolean isLeadingZeroPossible(int countryCallingCode) {
        PhoneMetadata mainMetadataForCallingCode = getMetadataForRegion(
        getRegionCodeForCountryCode(countryCallingCode));
        boolean var8B12A904D1DB3A2A33A947A68C4B6146_2004535635 = (mainMetadataForCallingCode.isLeadingZeroPossible());
        addTaint(countryCallingCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101497504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101497504;
        // ---------- Original Method ----------
        //PhoneMetadata mainMetadataForCallingCode = getMetadataForRegion(
        //getRegionCodeForCountryCode(countryCallingCode));
        //if (mainMetadataForCallingCode == null) {
      //return false;
    //}
        //return mainMetadataForCallingCode.isLeadingZeroPossible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.288 -0400", hash_original_method = "4B80DFBB3D3B298395671B1C8C6F67DA", hash_generated_method = "3070027228EF2F254A26C207C7025A32")
    public boolean isAlphaNumber(String number) {
        {
            boolean var6F2D6DBE1E1842574CD6CB87FFC5DB6E_671149653 = (!isViablePhoneNumber(number));
        } //End collapsed parenthetic
        StringBuilder strippedNumber = new StringBuilder(number);
        maybeStripExtension(strippedNumber);
        boolean varAE4E32ECCF3EF15A647E2C1BB378DAA7_1251555023 = (VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches());
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446683455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_446683455;
        // ---------- Original Method ----------
        //if (!isViablePhoneNumber(number)) {
      //return false;
    //}
        //StringBuilder strippedNumber = new StringBuilder(number);
        //maybeStripExtension(strippedNumber);
        //return VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.289 -0400", hash_original_method = "86FEA4033CCC520A9BCC7CD67C884B0D", hash_generated_method = "02B1C000F1972FBBCF32CB99CA2312E0")
    public boolean isPossibleNumber(PhoneNumber number) {
        boolean varB638E1EBE041FE51ED0B48C92300B1AB_308744456 = (isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE);
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404068824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_404068824;
        // ---------- Original Method ----------
        //return isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.290 -0400", hash_original_method = "B3EB56A7047F0C0039433A6E9896FBEF", hash_generated_method = "04701ACE3D2C516D80150478BDD1FF70")
    private ValidationResult testNumberLengthAgainstPattern(Pattern numberPattern, String number) {
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_558282385 = null; //Variable for return #1
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_849525816 = null; //Variable for return #2
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_1596887442 = null; //Variable for return #3
        Matcher numberMatcher = numberPattern.matcher(number);
        {
            boolean var71179D25353510F4890F375B5AE981E3_1537680439 = (numberMatcher.matches());
            {
                varB4EAC82CA7396A68D541C85D26508E83_558282385 = ValidationResult.IS_POSSIBLE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var162373AA4FD3689E76A45288F34FBEF2_613953291 = (numberMatcher.lookingAt());
            {
                varB4EAC82CA7396A68D541C85D26508E83_849525816 = ValidationResult.TOO_LONG;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1596887442 = ValidationResult.TOO_SHORT;
            } //End block
        } //End collapsed parenthetic
        addTaint(numberPattern.getTaint());
        addTaint(number.getTaint());
        ValidationResult varA7E53CE21691AB073D9660D615818899_824267202; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_824267202 = varB4EAC82CA7396A68D541C85D26508E83_558282385;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_824267202 = varB4EAC82CA7396A68D541C85D26508E83_849525816;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_824267202 = varB4EAC82CA7396A68D541C85D26508E83_1596887442;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_824267202.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_824267202;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.292 -0400", hash_original_method = "5E4449198019FBA49E61EB3BB2D3E7CD", hash_generated_method = "E0C3AA4BFB059A4A0DEE3401F29A2FAD")
    public ValidationResult isPossibleNumberWithReason(PhoneNumber number) {
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_1480083859 = null; //Variable for return #1
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_1528779654 = null; //Variable for return #2
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_1334925533 = null; //Variable for return #3
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_1533963234 = null; //Variable for return #4
        ValidationResult varB4EAC82CA7396A68D541C85D26508E83_347604479 = null; //Variable for return #5
        String nationalNumber = getNationalSignificantNumber(number);
        int countryCode = number.getCountryCode();
        String regionCode = getRegionCodeForCountryCode(countryCode);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_152052476 = (!isValidRegionCode(regionCode));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1480083859 = ValidationResult.INVALID_COUNTRY_CODE;
            } //End block
        } //End collapsed parenthetic
        PhoneNumberDesc generalNumDesc = getMetadataForRegion(regionCode).getGeneralDesc();
        {
            boolean var6BBB06AEDF976ADEC9072013B0735BB1_318537899 = (!generalNumDesc.hasNationalNumberPattern());
            {
                LOGGER.log(Level.FINER, "Checking if number is possible with incomplete metadata.");
                int numberLength = nationalNumber.length();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1528779654 = ValidationResult.TOO_SHORT;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1334925533 = ValidationResult.TOO_LONG;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1533963234 = ValidationResult.IS_POSSIBLE;
                } //End block
            } //End block
        } //End collapsed parenthetic
        Pattern possibleNumberPattern = regexCache.getPatternForRegex(generalNumDesc.getPossibleNumberPattern());
        varB4EAC82CA7396A68D541C85D26508E83_347604479 = testNumberLengthAgainstPattern(possibleNumberPattern, nationalNumber);
        addTaint(number.getTaint());
        ValidationResult varA7E53CE21691AB073D9660D615818899_1246798168; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1246798168 = varB4EAC82CA7396A68D541C85D26508E83_1480083859;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1246798168 = varB4EAC82CA7396A68D541C85D26508E83_1528779654;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1246798168 = varB4EAC82CA7396A68D541C85D26508E83_1334925533;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1246798168 = varB4EAC82CA7396A68D541C85D26508E83_1533963234;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1246798168 = varB4EAC82CA7396A68D541C85D26508E83_347604479;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1246798168.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1246798168;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.293 -0400", hash_original_method = "ABB46ACB6DF1697743B661541AD5E166", hash_generated_method = "8D4842B61B48C791242EFBD95B21C937")
    public boolean isPossibleNumber(String number, String regionDialingFrom) {
        try 
        {
            boolean var96F965C3B92FA5515239648FCAA605FA_476501478 = (isPossibleNumber(parse(number, regionDialingFrom)));
        } //End block
        catch (NumberParseException e)
        { }
        addTaint(number.getTaint());
        addTaint(regionDialingFrom.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045313410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045313410;
        // ---------- Original Method ----------
        //try {
      //return isPossibleNumber(parse(number, regionDialingFrom));
    //} catch (NumberParseException e) {
      //return false;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.294 -0400", hash_original_method = "763BBE034FB297BC9C435FECAC40F4A1", hash_generated_method = "785750F645224B2C2A3609C196B375DB")
    public boolean truncateTooLongNumber(PhoneNumber number) {
        {
            boolean var4F293B781EB7DE5CEFDA17D5EE1DE4BB_1192642962 = (isValidNumber(number));
        } //End collapsed parenthetic
        PhoneNumber numberCopy = new PhoneNumber();
        numberCopy.mergeFrom(number);
        long nationalNumber = number.getNationalNumber();
        {
            nationalNumber /= 10;
            numberCopy.setNationalNumber(nationalNumber);
            {
                boolean var4DE93CDC578CDDBFB1C41949B44D9A20_1346200188 = (isPossibleNumberWithReason(numberCopy) == ValidationResult.TOO_SHORT ||
          nationalNumber == 0);
            } //End collapsed parenthetic
        } //End block
        {
            boolean varFE57FF35897528475D20382F37EC3A95_1586365814 = (!isValidNumber(numberCopy));
        } //End collapsed parenthetic
        number.setNationalNumber(nationalNumber);
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068713329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068713329;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.295 -0400", hash_original_method = "719F2F8970F4EB169BEDB2820A702606", hash_generated_method = "2465FFA602633E811FE587AD5AA0061E")
    public AsYouTypeFormatter getAsYouTypeFormatter(String regionCode) {
        AsYouTypeFormatter varB4EAC82CA7396A68D541C85D26508E83_1169067876 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1169067876 = new AsYouTypeFormatter(regionCode);
        addTaint(regionCode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1169067876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1169067876;
        // ---------- Original Method ----------
        //return new AsYouTypeFormatter(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.295 -0400", hash_original_method = "2A48039CFC05A878E1A34077CDECE0D5", hash_generated_method = "667EB439676CE7E7DFC2EC686824E2DD")
     int extractCountryCode(StringBuilder fullNumber, StringBuilder nationalNumber) {
        int potentialCountryCode;
        int numberLength = fullNumber.length();
        {
            int i = 1;
            {
                potentialCountryCode = Integer.parseInt(fullNumber.substring(0, i));
                {
                    boolean varF6C470E7E096D4CAC6F27A27E3BF3621_1300933519 = (countryCallingCodeToRegionCodeMap.containsKey(potentialCountryCode));
                    {
                        nationalNumber.append(fullNumber.substring(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(fullNumber.getTaint());
        addTaint(nationalNumber.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120026955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120026955;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.296 -0400", hash_original_method = "8166FB521487034FA9E8BD7575A0612F", hash_generated_method = "D52A8B54CFD8741A9D75A24422F920CA")
     int maybeExtractCountryCode(String number, PhoneMetadata defaultRegionMetadata,
                              StringBuilder nationalNumber, boolean keepRawInput,
                              PhoneNumber phoneNumber) throws NumberParseException {
        {
            boolean varB5B34D967C3FC3EF34B11B7B3B931B11_1796664821 = (number.length() == 0);
        } //End collapsed parenthetic
        StringBuilder fullNumber = new StringBuilder(number);
        String possibleCountryIddPrefix = "NonMatch";
        {
            possibleCountryIddPrefix = defaultRegionMetadata.getInternationalPrefix();
        } //End block
        CountryCodeSource countryCodeSource = maybeStripInternationalPrefixAndNormalize(fullNumber, possibleCountryIddPrefix);
        {
            phoneNumber.setCountryCodeSource(countryCodeSource);
        } //End block
        {
            {
                boolean varE7EE2B23EDD4C9364B0D3D150E7CC45E_1829329511 = (fullNumber.length() < MIN_LENGTH_FOR_NSN);
                {
                    if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD,
                                       "Phone number had an IDD, but after this was not "
                                       + "long enough to be a viable phone number.");
                } //End block
            } //End collapsed parenthetic
            int potentialCountryCode = extractCountryCode(fullNumber, nationalNumber);
            {
                phoneNumber.setCountryCode(potentialCountryCode);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                                     "Country calling code supplied was not recognised.");
        } //End block
        {
            int defaultCountryCode = defaultRegionMetadata.getCountryCode();
            String defaultCountryCodeString = String.valueOf(defaultCountryCode);
            String normalizedNumber = fullNumber.toString();
            {
                boolean varBF0AEC43338ACB310E013283F2CF7DCB_1741189477 = (normalizedNumber.startsWith(defaultCountryCodeString));
                {
                    StringBuilder potentialNationalNumber = new StringBuilder(normalizedNumber.substring(defaultCountryCodeString.length()));
                    PhoneNumberDesc generalDesc = defaultRegionMetadata.getGeneralDesc();
                    Pattern validNumberPattern = regexCache.getPatternForRegex(generalDesc.getNationalNumberPattern());
                    maybeStripNationalPrefixAndCarrierCode(potentialNationalNumber, defaultRegionMetadata);
                    Pattern possibleNumberPattern = regexCache.getPatternForRegex(generalDesc.getPossibleNumberPattern());
                    {
                        boolean var0EB5BCA225D2EA4DBFFB64C37782F25D_632084588 = ((!validNumberPattern.matcher(fullNumber).matches() &&
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853461167 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853461167;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.297 -0400", hash_original_method = "0F0B6B28B590A156D8457E403790D50B", hash_generated_method = "101363DB5EB52F1C54C1EC72975DC8FC")
    private boolean parsePrefixAsIdd(Pattern iddPattern, StringBuilder number) {
        Matcher m = iddPattern.matcher(number);
        {
            boolean var2E90163ED89C1EED1C54F6911454B170_1838618487 = (m.lookingAt());
            {
                int matchEnd = m.end();
                Matcher digitMatcher = CAPTURING_DIGIT_PATTERN.matcher(number.substring(matchEnd));
                {
                    boolean varD3BA2E8471CEBE61FDD93E9E325ACBC0_2017933983 = (digitMatcher.find());
                    {
                        String normalizedGroup = normalizeDigitsOnly(digitMatcher.group(1));
                        {
                            boolean var61EE828DD147AE02AC5DD8BACE4A9E86_1249221216 = (normalizedGroup.equals("0"));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                number.delete(0, matchEnd);
            } //End block
        } //End collapsed parenthetic
        addTaint(iddPattern.getTaint());
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564394514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_564394514;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.299 -0400", hash_original_method = "8865CBB50A1D9F6F8472F699DBF16350", hash_generated_method = "9CFF0364028BFCD416954658056C6824")
     CountryCodeSource maybeStripInternationalPrefixAndNormalize(
      StringBuilder number,
      String possibleIddPrefix) {
        CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_1847588533 = null; //Variable for return #1
        CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_1457327892 = null; //Variable for return #2
        CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_676015313 = null; //Variable for return #3
        CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_1134656655 = null; //Variable for return #4
        {
            boolean varB5B34D967C3FC3EF34B11B7B3B931B11_1254505217 = (number.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1847588533 = CountryCodeSource.FROM_DEFAULT_COUNTRY;
            } //End block
        } //End collapsed parenthetic
        Matcher m = PLUS_CHARS_PATTERN.matcher(number);
        {
            boolean var2E90163ED89C1EED1C54F6911454B170_1503700874 = (m.lookingAt());
            {
                number.delete(0, m.end());
                normalize(number);
                varB4EAC82CA7396A68D541C85D26508E83_1457327892 = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            } //End block
        } //End collapsed parenthetic
        Pattern iddPattern = regexCache.getPatternForRegex(possibleIddPrefix);
        {
            boolean varCDD8918BAE2604CCF3C5EBF34E65E7DD_487549820 = (parsePrefixAsIdd(iddPattern, number));
            {
                normalize(number);
                varB4EAC82CA7396A68D541C85D26508E83_676015313 = CountryCodeSource.FROM_NUMBER_WITH_IDD;
            } //End block
        } //End collapsed parenthetic
        normalize(number);
        varB4EAC82CA7396A68D541C85D26508E83_1134656655 = parsePrefixAsIdd(iddPattern, number)
           ? CountryCodeSource.FROM_NUMBER_WITH_IDD
           : CountryCodeSource.FROM_DEFAULT_COUNTRY;
        addTaint(number.getTaint());
        addTaint(possibleIddPrefix.getTaint());
        CountryCodeSource varA7E53CE21691AB073D9660D615818899_1424780057; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1424780057 = varB4EAC82CA7396A68D541C85D26508E83_1847588533;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1424780057 = varB4EAC82CA7396A68D541C85D26508E83_1457327892;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1424780057 = varB4EAC82CA7396A68D541C85D26508E83_676015313;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1424780057 = varB4EAC82CA7396A68D541C85D26508E83_1134656655;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1424780057.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1424780057;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.303 -0400", hash_original_method = "8024CAA7B81A99B980BA01FE387839A1", hash_generated_method = "76B0CA6B15706DF84A758150E1DC9B74")
     String maybeStripNationalPrefixAndCarrierCode(StringBuilder number, PhoneMetadata metadata) {
        String varB4EAC82CA7396A68D541C85D26508E83_1273607730 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1699670932 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1563929467 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1834896316 = null; //Variable for return #4
        String carrierCode = "";
        int numberLength = number.length();
        String possibleNationalPrefix = metadata.getNationalPrefixForParsing();
        {
            boolean var2D1654E1B48CDA3CB899B11DA870015B_1800067168 = (numberLength == 0 || possibleNationalPrefix.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1273607730 = "";
            } //End block
        } //End collapsed parenthetic
        Matcher prefixMatcher = regexCache.getPatternForRegex(possibleNationalPrefix).matcher(number);
        {
            boolean var51DEE301B078E28F95DDA21171B258E8_66630384 = (prefixMatcher.lookingAt());
            {
                Pattern nationalNumberRule = regexCache.getPatternForRegex(metadata.getGeneralDesc().getNationalNumberPattern());
                boolean isViableOriginalNumber = nationalNumberRule.matcher(number).matches();
                int numOfGroups = prefixMatcher.groupCount();
                String transformRule = metadata.getNationalPrefixTransformRule();
                {
                    boolean var92083891923A60ACDAC45256CB34F888_1885673396 = (transformRule == null || transformRule.length() == 0 ||
          prefixMatcher.group(numOfGroups) == null);
                    {
                        {
                            boolean var05FB41A7DFCB455F1C640CC42B086A52_1948030152 = (isViableOriginalNumber &&
            !nationalNumberRule.matcher(number.substring(prefixMatcher.end())).matches());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1699670932 = "";
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var731E647394C8AC8EAD72BD6A33D30533_2066793089 = (numOfGroups > 0 && prefixMatcher.group(numOfGroups) != null);
                            {
                                carrierCode = prefixMatcher.group(1);
                            } //End block
                        } //End collapsed parenthetic
                        number.delete(0, prefixMatcher.end());
                    } //End block
                    {
                        StringBuilder transformedNumber = new StringBuilder(number);
                        transformedNumber.replace(0, numberLength, prefixMatcher.replaceFirst(transformRule));
                        {
                            boolean var1618096EC0BE19942037320536365A62_1376523084 = (isViableOriginalNumber &&
            !nationalNumberRule.matcher(transformedNumber.toString()).matches());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1563929467 = "";
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
        varB4EAC82CA7396A68D541C85D26508E83_1834896316 = carrierCode;
        addTaint(number.getTaint());
        addTaint(metadata.getTaint());
        String varA7E53CE21691AB073D9660D615818899_295640057; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_295640057 = varB4EAC82CA7396A68D541C85D26508E83_1273607730;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_295640057 = varB4EAC82CA7396A68D541C85D26508E83_1699670932;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_295640057 = varB4EAC82CA7396A68D541C85D26508E83_1563929467;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_295640057 = varB4EAC82CA7396A68D541C85D26508E83_1834896316;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_295640057.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_295640057;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.305 -0400", hash_original_method = "D072FBB7A4080E317A5210E0DF61655A", hash_generated_method = "EA819D7B747984AA7F84A535C37D159D")
     String maybeStripExtension(StringBuilder number) {
        String varB4EAC82CA7396A68D541C85D26508E83_892380619 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1815327049 = null; //Variable for return #2
        Matcher m = EXTN_PATTERN.matcher(number);
        {
            boolean var361B236D5550943CE1D4B9E817C41F2D_2057083516 = (m.find() && isViablePhoneNumber(number.substring(0, m.start())));
            {
                {
                    int i = 1;
                    int length = m.groupCount();
                    {
                        {
                            boolean varEF8B426B8C4D7A4B4377DDF02EDEE0A6_874607993 = (m.group(i) != null);
                            {
                                String extension = m.group(i);
                                number.delete(m.start(), number.length());
                                varB4EAC82CA7396A68D541C85D26508E83_892380619 = extension;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1815327049 = "";
        addTaint(number.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1483566754; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1483566754 = varB4EAC82CA7396A68D541C85D26508E83_892380619;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1483566754 = varB4EAC82CA7396A68D541C85D26508E83_1815327049;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1483566754.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1483566754;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.306 -0400", hash_original_method = "E1BA4484CA3B538698D9E39D9664F7DD", hash_generated_method = "6EE50AEF3E73DB1259364AF849BA08D4")
    private boolean checkRegionForParsing(String numberToParse, String defaultRegion) {
        {
            boolean varC4FBE20839E7B322BE8202F31EB24419_1977973096 = (!isValidRegionCode(defaultRegion));
            {
                {
                    boolean varAC73D73EEB94A3B214186B0F9C923AF3_53203181 = (numberToParse == null || numberToParse.length() == 0 ||
          !PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212223830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212223830;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(defaultRegion)) {
      //if (numberToParse == null || numberToParse.length() == 0 ||
          //!PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt()) {
        //return false;
      //}
    //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.307 -0400", hash_original_method = "6012972DF706A584D5C83C6971CF9392", hash_generated_method = "A928AC59E19DEE61E98B5B23B6A1DB87")
    public PhoneNumber parse(String numberToParse, String defaultRegion) throws NumberParseException {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1385678255 = null; //Variable for return #1
        PhoneNumber phoneNumber = new PhoneNumber();
        parse(numberToParse, defaultRegion, phoneNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1385678255 = phoneNumber;
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1385678255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1385678255;
        // ---------- Original Method ----------
        //PhoneNumber phoneNumber = new PhoneNumber();
        //parse(numberToParse, defaultRegion, phoneNumber);
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.307 -0400", hash_original_method = "6ECDB36C19DB49774718F5C4BA94B539", hash_generated_method = "0B03E5B379B81B8F5BEF078A04733AB3")
    public void parse(String numberToParse, String defaultRegion, PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(phoneNumber.getTaint());
        // ---------- Original Method ----------
        //parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.308 -0400", hash_original_method = "19CBF359D0DD4BA30476F5C26D54CCE4", hash_generated_method = "DC54C79D096516F23E0B6EBECC579385")
    public PhoneNumber parseAndKeepRawInput(String numberToParse, String defaultRegion) throws NumberParseException {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1561832850 = null; //Variable for return #1
        PhoneNumber phoneNumber = new PhoneNumber();
        parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1561832850 = phoneNumber;
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1561832850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561832850;
        // ---------- Original Method ----------
        //PhoneNumber phoneNumber = new PhoneNumber();
        //parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.309 -0400", hash_original_method = "56F5D9940BB01A0D66986596B5A9CF6E", hash_generated_method = "8CE39E71A4F75F548446D8BCEAB5DE37")
    public void parseAndKeepRawInput(String numberToParse, String defaultRegion,
                                   PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
        addTaint(numberToParse.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(phoneNumber.getTaint());
        // ---------- Original Method ----------
        //parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.309 -0400", hash_original_method = "FC749C2F4DF483D491476DD9FB58E6D5", hash_generated_method = "79A5F6F3032DFADC321E22300D9BE70B")
    public Iterable<PhoneNumberMatch> findNumbers(CharSequence text, String defaultRegion) {
        Iterable<PhoneNumberMatch> varB4EAC82CA7396A68D541C85D26508E83_11232986 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_11232986 = findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
        addTaint(text.getTaint());
        addTaint(defaultRegion.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_11232986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_11232986;
        // ---------- Original Method ----------
        //return findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.310 -0400", hash_original_method = "C3E745E72AE45D5E83FFDE500327E040", hash_generated_method = "85CF5C12A5282433660EC707A678119D")
    public Iterable<PhoneNumberMatch> findNumbers(
      final CharSequence text, final String defaultRegion, final Leniency leniency,
      final long maxTries) {
        Iterable<PhoneNumberMatch> varB4EAC82CA7396A68D541C85D26508E83_1417013105 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1417013105 = new Iterable<PhoneNumberMatch>() {
      public Iterator<PhoneNumberMatch> iterator() {
        return new PhoneNumberMatcher(
            PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
      }
    };
        addTaint(text.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(leniency.getTaint());
        addTaint(maxTries);
        varB4EAC82CA7396A68D541C85D26508E83_1417013105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1417013105;
        // ---------- Original Method ----------
        //return new Iterable<PhoneNumberMatch>() {
      //public Iterator<PhoneNumberMatch> iterator() {
        //return new PhoneNumberMatcher(
            //PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
      //}
    //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.311 -0400", hash_original_method = "B3135DA9F7C362E965D50679AE934189", hash_generated_method = "12212037E84063008C83998CF1994722")
    private void parseHelper(String numberToParse, String defaultRegion, boolean keepRawInput,
                           boolean checkRegion, PhoneNumber phoneNumber) throws NumberParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The phone number supplied was null.");
        } //End block
        String number = extractPossibleNumber(numberToParse);
        {
            boolean var6F2D6DBE1E1842574CD6CB87FFC5DB6E_215037631 = (!isViablePhoneNumber(number));
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The string supplied did not seem to be a phone number.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var06E9F76E4F889EF52DC311C4A976B26A_1087297115 = (checkRegion && !checkRegionForParsing(number, defaultRegion));
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                                     "Missing or invalid default region.");
            } //End block
        } //End collapsed parenthetic
        {
            phoneNumber.setRawInput(numberToParse);
        } //End block
        StringBuilder nationalNumber = new StringBuilder(number);
        String extension = maybeStripExtension(nationalNumber);
        {
            boolean var3CC30422F1FA8C39327BDA102088343B_373760939 = (extension.length() > 0);
            {
                phoneNumber.setExtension(extension);
            } //End block
        } //End collapsed parenthetic
        PhoneMetadata regionMetadata = getMetadataForRegion(defaultRegion);
        StringBuilder normalizedNationalNumber = new StringBuilder();
        int countryCode = maybeExtractCountryCode(nationalNumber.toString(), regionMetadata,
                                              normalizedNationalNumber, keepRawInput, phoneNumber);
        {
            String phoneNumberRegion = getRegionCodeForCountryCode(countryCode);
            {
                boolean varF49D20E798CCB0BC5377F0D78E2C4831_495359553 = (!phoneNumberRegion.equals(defaultRegion));
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
            boolean varE256D1ABB8A26FE912AD1B0C28F9428D_1248578101 = (normalizedNationalNumber.length() < MIN_LENGTH_FOR_NSN);
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
            } //End block
        } //End collapsed parenthetic
        {
            String carrierCode = maybeStripNationalPrefixAndCarrierCode(normalizedNationalNumber, regionMetadata);
            {
                phoneNumber.setPreferredDomesticCarrierCode(carrierCode);
            } //End block
        } //End block
        int lengthOfNationalNumber = normalizedNationalNumber.length();
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG,
                                     "The string supplied is too long to be a phone number.");
        } //End block
        {
            boolean varACF04B28E2A0B5A46318EA7197F780A3_1573310895 = (normalizedNationalNumber.charAt(0) == '0');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.313 -0400", hash_original_method = "83C8E6F8520B32A4B2A265A569BAF2C9", hash_generated_method = "429F7127433AF6E0716D6D944A5729CD")
    public MatchType isNumberMatch(PhoneNumber firstNumberIn, PhoneNumber secondNumberIn) {
        MatchType varB4EAC82CA7396A68D541C85D26508E83_582132209 = null; //Variable for return #1
        MatchType varB4EAC82CA7396A68D541C85D26508E83_86978686 = null; //Variable for return #2
        MatchType varB4EAC82CA7396A68D541C85D26508E83_990745459 = null; //Variable for return #3
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1526423564 = null; //Variable for return #4
        MatchType varB4EAC82CA7396A68D541C85D26508E83_558912344 = null; //Variable for return #5
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1096216826 = null; //Variable for return #6
        MatchType varB4EAC82CA7396A68D541C85D26508E83_2064528042 = null; //Variable for return #7
        PhoneNumber firstNumber = new PhoneNumber();
        firstNumber.mergeFrom(firstNumberIn);
        PhoneNumber secondNumber = new PhoneNumber();
        secondNumber.mergeFrom(secondNumberIn);
        firstNumber.clearRawInput();
        firstNumber.clearCountryCodeSource();
        firstNumber.clearPreferredDomesticCarrierCode();
        secondNumber.clearRawInput();
        secondNumber.clearCountryCodeSource();
        secondNumber.clearPreferredDomesticCarrierCode();
        {
            boolean varD218A2F73AAFCD618CDCC1518EFA486F_815130858 = (firstNumber.hasExtension() &&
        firstNumber.getExtension().length() == 0);
            {
                firstNumber.clearExtension();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var60C5BEE8803B911C5831EA8EC7969A40_861356748 = (secondNumber.hasExtension() &&
        secondNumber.getExtension().length() == 0);
            {
                secondNumber.clearExtension();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF31A145523293CCF9F54D3055A0EFC09_960675353 = (firstNumber.hasExtension() && secondNumber.hasExtension() &&
        !firstNumber.getExtension().equals(secondNumber.getExtension()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_582132209 = MatchType.NO_MATCH;
            } //End block
        } //End collapsed parenthetic
        int firstNumberCountryCode = firstNumber.getCountryCode();
        int secondNumberCountryCode = secondNumber.getCountryCode();
        {
            {
                boolean var9B921E1924AE2BDB9C722839D617A98E_1915191070 = (firstNumber.exactlySameAs(secondNumber));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_86978686 = MatchType.EXACT_MATCH;
                } //End block
                {
                    boolean var51FF660A6085B2E42A72E7B10CEF8B05_1576434838 = (firstNumberCountryCode == secondNumberCountryCode &&
                 isNationalNumberSuffixOfTheOther(firstNumber, secondNumber));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_990745459 = MatchType.SHORT_NSN_MATCH;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1526423564 = MatchType.NO_MATCH;
        } //End block
        firstNumber.setCountryCode(secondNumberCountryCode);
        {
            boolean varFF0709B6FD4A212C6A2A3AAFF8AF6F2C_192991893 = (firstNumber.exactlySameAs(secondNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_558912344 = MatchType.NSN_MATCH;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5CAFDF8CDD6EF1F618DB5BB207D00EF6_96880418 = (isNationalNumberSuffixOfTheOther(firstNumber, secondNumber));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1096216826 = MatchType.SHORT_NSN_MATCH;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2064528042 = MatchType.NO_MATCH;
        addTaint(firstNumberIn.getTaint());
        addTaint(secondNumberIn.getTaint());
        MatchType varA7E53CE21691AB073D9660D615818899_51181276; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_51181276 = varB4EAC82CA7396A68D541C85D26508E83_582132209;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_51181276 = varB4EAC82CA7396A68D541C85D26508E83_86978686;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_51181276 = varB4EAC82CA7396A68D541C85D26508E83_990745459;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_51181276 = varB4EAC82CA7396A68D541C85D26508E83_1526423564;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_51181276 = varB4EAC82CA7396A68D541C85D26508E83_558912344;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_51181276 = varB4EAC82CA7396A68D541C85D26508E83_1096216826;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_51181276 = varB4EAC82CA7396A68D541C85D26508E83_2064528042;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_51181276.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_51181276;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.314 -0400", hash_original_method = "B2A134716BB483331B78911F7265BAC6", hash_generated_method = "C88C1AB9BB24901F6D1267BCAEC57DC8")
    private boolean isNationalNumberSuffixOfTheOther(PhoneNumber firstNumber,
                                                   PhoneNumber secondNumber) {
        String firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
        String secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
        boolean var7CCB98E4B8319542AA88D60C5E29610E_773855407 = (firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           secondNumberNationalNumber.endsWith(firstNumberNationalNumber));
        addTaint(firstNumber.getTaint());
        addTaint(secondNumber.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012225075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012225075;
        // ---------- Original Method ----------
        //String firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
        //String secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
        //return firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           //secondNumberNationalNumber.endsWith(firstNumberNationalNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.316 -0400", hash_original_method = "3C9E8BD2D7E8FA6C3BECA5B02E481416", hash_generated_method = "30E45658CD0AE6748B46630050EBE34A")
    public MatchType isNumberMatch(String firstNumber, String secondNumber) {
        MatchType varB4EAC82CA7396A68D541C85D26508E83_860044442 = null; //Variable for return #1
        MatchType varB4EAC82CA7396A68D541C85D26508E83_545467880 = null; //Variable for return #2
        MatchType varB4EAC82CA7396A68D541C85D26508E83_490961615 = null; //Variable for return #3
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1054847293 = null; //Variable for return #4
        try 
        {
            PhoneNumber firstNumberAsProto = parse(firstNumber, UNKNOWN_REGION);
            varB4EAC82CA7396A68D541C85D26508E83_860044442 = isNumberMatch(firstNumberAsProto, secondNumber);
        } //End block
        catch (NumberParseException e)
        {
            {
                boolean var89D3BC3CCC46DE71B07129DA6A1C3D48_277441363 = (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                {
                    try 
                    {
                        PhoneNumber secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
                        varB4EAC82CA7396A68D541C85D26508E83_545467880 = isNumberMatch(secondNumberAsProto, firstNumber);
                    } //End block
                    catch (NumberParseException e2)
                    {
                        {
                            boolean var463CDF6189F8ADE5C6F8D6C11E45E3C7_1116358333 = (e2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                            {
                                try 
                                {
                                    PhoneNumber firstNumberProto = new PhoneNumber();
                                    PhoneNumber secondNumberProto = new PhoneNumber();
                                    parseHelper(firstNumber, null, false, false, firstNumberProto);
                                    parseHelper(secondNumber, null, false, false, secondNumberProto);
                                    varB4EAC82CA7396A68D541C85D26508E83_490961615 = isNumberMatch(firstNumberProto, secondNumberProto);
                                } //End block
                                catch (NumberParseException e3)
                                { }
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1054847293 = MatchType.NOT_A_NUMBER;
        addTaint(firstNumber.getTaint());
        addTaint(secondNumber.getTaint());
        MatchType varA7E53CE21691AB073D9660D615818899_470981795; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_470981795 = varB4EAC82CA7396A68D541C85D26508E83_860044442;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_470981795 = varB4EAC82CA7396A68D541C85D26508E83_545467880;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_470981795 = varB4EAC82CA7396A68D541C85D26508E83_490961615;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_470981795 = varB4EAC82CA7396A68D541C85D26508E83_1054847293;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_470981795.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_470981795;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.319 -0400", hash_original_method = "FA442F82D618375A0E3FFC54DA76D9E3", hash_generated_method = "FCEF003A3E070FD51D7EF21E4836DF15")
    public MatchType isNumberMatch(PhoneNumber firstNumber, String secondNumber) {
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1241792174 = null; //Variable for return #1
        MatchType varB4EAC82CA7396A68D541C85D26508E83_2013066724 = null; //Variable for return #2
        MatchType varB4EAC82CA7396A68D541C85D26508E83_817839155 = null; //Variable for return #3
        MatchType varB4EAC82CA7396A68D541C85D26508E83_904744297 = null; //Variable for return #4
        MatchType varB4EAC82CA7396A68D541C85D26508E83_1961902514 = null; //Variable for return #5
        try 
        {
            PhoneNumber secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
            varB4EAC82CA7396A68D541C85D26508E83_1241792174 = isNumberMatch(firstNumber, secondNumberAsProto);
        } //End block
        catch (NumberParseException e)
        {
            {
                boolean var89D3BC3CCC46DE71B07129DA6A1C3D48_240396132 = (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                {
                    String firstNumberRegion = getRegionCodeForCountryCode(firstNumber.getCountryCode());
                    try 
                    {
                        {
                            boolean var255106447960ACE253D342CF9EF0C76A_1191550547 = (!firstNumberRegion.equals(UNKNOWN_REGION));
                            {
                                PhoneNumber secondNumberWithFirstNumberRegion = parse(secondNumber, firstNumberRegion);
                                MatchType match = isNumberMatch(firstNumber, secondNumberWithFirstNumberRegion);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_2013066724 = MatchType.NSN_MATCH;
                                } //End block
                                varB4EAC82CA7396A68D541C85D26508E83_817839155 = match;
                            } //End block
                            {
                                PhoneNumber secondNumberProto = new PhoneNumber();
                                parseHelper(secondNumber, null, false, false, secondNumberProto);
                                varB4EAC82CA7396A68D541C85D26508E83_904744297 = isNumberMatch(firstNumber, secondNumberProto);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (NumberParseException e2)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1961902514 = MatchType.NOT_A_NUMBER;
        addTaint(firstNumber.getTaint());
        addTaint(secondNumber.getTaint());
        MatchType varA7E53CE21691AB073D9660D615818899_598040391; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_598040391 = varB4EAC82CA7396A68D541C85D26508E83_1241792174;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_598040391 = varB4EAC82CA7396A68D541C85D26508E83_2013066724;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_598040391 = varB4EAC82CA7396A68D541C85D26508E83_817839155;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_598040391 = varB4EAC82CA7396A68D541C85D26508E83_904744297;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_598040391 = varB4EAC82CA7396A68D541C85D26508E83_1961902514;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_598040391.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_598040391;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.319 -0400", hash_original_method = "93167700613734CAFA37F508460EB7E3", hash_generated_method = "9CF14D143AFBFC1A4293EE086F372FB2")
     boolean canBeInternationallyDialled(PhoneNumber number) {
        String regionCode = getRegionCodeForNumber(number);
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean var49E3803795D2C1A2A31963B43E424E43_1841655887 = (!hasValidRegionCode(regionCode, number.getCountryCode(), nationalSignificantNumber));
        } //End collapsed parenthetic
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        boolean varB254B21720CD001C28A66C6976015DBA_553934880 = (!isNumberMatchingDesc(nationalSignificantNumber, metadata.getNoInternationalDialling()));
        addTaint(number.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880631873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880631873;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.319 -0400", hash_original_field = "EB11CC0E8A96949DB43176717E336CDD", hash_generated_field = "56358BB2B93B97106608814280D6666E")

    static final int REGEX_FLAGS = Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.319 -0400", hash_original_field = "9E0E53DE18A8BA7B34AFC44B3D12F966", hash_generated_field = "78162C39327AD811876D6287CE97DE9A")

    private static final int MIN_LENGTH_FOR_NSN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.319 -0400", hash_original_field = "B7B16DDA7E8A51EB6956979657455D74", hash_generated_field = "9FB78E1175F6C9C6A8605B6EDAA89F3A")

    static final int MAX_LENGTH_FOR_NSN = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.319 -0400", hash_original_field = "05AAEEE35BFA26C060E9E538DC8A8A9A", hash_generated_field = "B536601172E5FEA598125C5319675976")

    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.319 -0400", hash_original_field = "1A0EC0F17D75886D68FE0D60D02E7405", hash_generated_field = "1AB5B395372E5B768BCBBA5C4037C039")

    static final String META_DATA_FILE_PREFIX = "/com/android/i18n/phonenumbers/data/PhoneNumberMetadataProto";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "A1E873C259FA0CABBD0C9F71C2073DFA", hash_generated_field = "EE197B49B9DBA77F840ACF7281744106")

    private static final Logger LOGGER = Logger.getLogger(PhoneNumberUtil.class.getName());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "884BE42B71C8AFCCDFE2F81DD7984AEC", hash_generated_field = "37E07E112B24C23DECA9CE91C20C0533")

    private static final String UNKNOWN_REGION = "ZZ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "165C3547A5B97982AD01C097E4AB5E6F", hash_generated_field = "3781137D5EFBC743F6AF42421A78AAB0")

    private static final int NANPA_COUNTRY_CODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "3B32202ED9382EE062B7ADF2582F4E22", hash_generated_field = "DB0682C1F895DEC76B13EE471B2B2AAB")

    static final char PLUS_SIGN = '+';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "5E538434F72E6A54DF5E9589E388BB2A", hash_generated_field = "0D4345D843431079FA3A87145DDC0F83")

    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "61274886CC209D383752DF2C4E45019A", hash_generated_field = "AC50CA36F96F68F3E68F8306B67F17A6")

    private static Map<Character, Character> ALPHA_MAPPINGS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "A687A96E121E0460B5D23B2EB5227386", hash_generated_field = "6540E96DA6A170C8F59559A1CA13BA85")

    private static Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "33227356DEF684B5B69E6F1BC1B64C04", hash_generated_field = "8BA2CD3F690AB362D76BB15FA383BE12")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "B8EB3CEE9DCE9972530AFEAA48801022", hash_generated_field = "FB90ED7A2BC1A696297198B465C4CDF9")

    private static final Pattern UNIQUE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~\u2053\u223C\uFF5E][\\d]+)?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "95E7EE317F57B907866F30266B1172FE", hash_generated_field = "3544A2A0AB9952075D7051B48C75E415")

    static final String VALID_PUNCTUATION = "-x\u2010-\u2015\u2212\u30FC\uFF0D-\uFF0F " +
      "\u00A0\u200B\u2060\u3000()\uFF08\uFF09\uFF3B\uFF3D.\\[\\]/~\u2053\u223C\uFF5E";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "1A64355EF67E8035AEBC5332495B29C2", hash_generated_field = "711CAD69779EE34D5918FEE07224547C")

    private static final String DIGITS = "\\p{Nd}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "B53AD5BC99FF6E99B2013691434E5AE0", hash_generated_field = "8C02DF099CE2D84C3EB4B1BAFB9529C4")

    private static final String VALID_ALPHA = Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", "") +
      Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "CDAC17B00A8EFF3BB0A83D83D11A2136", hash_generated_field = "7AA5C25A8B485E30A73BF5904752D094")

    static final String PLUS_CHARS = "+\uFF0B";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "E58FEF7945499412B1D8834E7B62FDFC", hash_generated_field = "401A10BEE2C1F4B3E23F174296449756")

    static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[" + PLUS_CHARS + "]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "9733A99E32EE6D850D49F03364042404", hash_generated_field = "A769130D6DB113058C6FB971BC0E9EE8")

    private static final Pattern SEPARATOR_PATTERN = Pattern.compile("[" + VALID_PUNCTUATION + "]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "0F0E7FFB40A9BBB6394BA2DC9D119A3E", hash_generated_field = "B9B6B3DB4626D33FCBE2CDF6FFFC1DF0")

    private static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(" + DIGITS + ")");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "7199DD487DD791E45C5E7ADA312C66FE", hash_generated_field = "8F354CEFF122C1734C5C5F0D756A5700")

    private static final String VALID_START_CHAR = "[" + PLUS_CHARS + DIGITS + "]";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "42974F132ECB34AE7B99307A1FB781B7", hash_generated_field = "5445004A965BB01D6385471341B37DC8")

    private static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "DF9A27A84A3B17E686546336F0E7DF17", hash_generated_field = "2972DC4B313E34CACAF4F97B2A318C7A")

    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "C63F4B685DE4C61316AE5B057C736F03", hash_generated_field = "1E52F9393C161A1B744DE8FBB2E11684")

    static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "9667044B078641F8136071D75237A26F", hash_generated_field = "1CAD8A5902F3CA177EE1ABE98BFC8985")

    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "3DE86B68F07EA4A22C07DE9AD7D1B843", hash_generated_field = "FB0CEF5E0208B9E75B56CCBEC3289130")

    static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "388E04BE9AE1682582E63208038A1441", hash_generated_field = "26B4C5D56FB4163FA672A06569A620EE")

    private static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "CFEAF1E44D986ABA68F85334B1721286", hash_generated_field = "61F58DD7A6FF0B7D647CD39920730CF2")

    private static final String VALID_PHONE_NUMBER = "[" + PLUS_CHARS + "]*(?:[" + VALID_PUNCTUATION + "]*" + DIGITS + "){3,}[" +
      VALID_PUNCTUATION + VALID_ALPHA + DIGITS + "]*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "D366A52A3A38CAB7A724B2F5FB251375", hash_generated_field = "D9A9DBC3927C0338AFC6B147AB3D683E")

    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "0196836C4DD5E6CC55770577EA98447B", hash_generated_field = "2D03BDC1FC6227A7A728133D9442643D")

    private static final String CAPTURING_EXTN_DIGITS = "(" + DIGITS + "{1,7})";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "A5DCAE8D232697D3B884F219BE6B2609", hash_generated_field = "3CBD86B8E6DD6E504D2DA4A1A75D3950")

    private static String EXTN_PATTERNS_FOR_PARSING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "09EF60EAE97616A471FBE501F4663001", hash_generated_field = "8AEC46C66A511C8270E50678714A3A2B")

    static String EXTN_PATTERNS_FOR_MATCHING;
    static {
    String singleExtnSymbolsForMatching = "x\uFF58#\uFF03~\uFF5E";
    String singleExtnSymbolsForParsing = "," + singleExtnSymbolsForMatching;
    EXTN_PATTERNS_FOR_PARSING = createExtnPattern(singleExtnSymbolsForParsing);
    EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(singleExtnSymbolsForMatching);
  }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "FB4CC22DAA10D4F465BC655E6188170A", hash_generated_field = "8452AC9CEA3E604270B031D1546941FC")

    private static final Pattern EXTN_PATTERN = Pattern.compile("(?:" + EXTN_PATTERNS_FOR_PARSING + ")$", REGEX_FLAGS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "ED5EA621ABE5320A1C34DBAD53D0A061", hash_generated_field = "8689C6F1B7C9FD8CC2152596A70CBA25")

    private static final Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile(VALID_PHONE_NUMBER + "(?:" + EXTN_PATTERNS_FOR_PARSING + ")?", REGEX_FLAGS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "4AE14BB5F2520F4E3FF1E5D12782356E", hash_generated_field = "FC9AE1E47D90D61831285D6FD294822D")

    private static final Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "CD953C1DEE4ADD552C476477C6EADD8A", hash_generated_field = "65DF000688AF80A40597848985B3362C")

    private static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "3D193ACEBF04669BC83D13231DAB8702", hash_generated_field = "76DFAE47B27AFFA44F784EF45ADDE2F5")

    private static final Pattern NP_PATTERN = Pattern.compile("\\$NP");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "A03C277F3A7F8A20EA0B481820598B2A", hash_generated_field = "D09CBC3025CAAF7951C4B16225B988EE")

    private static final Pattern FG_PATTERN = Pattern.compile("\\$FG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "DE10DE8A40C3C1EC916E7B66F64ABD87", hash_generated_field = "35A2F87A120AD2F2C401B83B05F83EA2")

    private static final Pattern CC_PATTERN = Pattern.compile("\\$CC");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.320 -0400", hash_original_field = "A81ED48CF13BC1CB56AE4320709DE841", hash_generated_field = "90932A776869C6233A72E88783493EDF")

    private static PhoneNumberUtil instance = null;
}

