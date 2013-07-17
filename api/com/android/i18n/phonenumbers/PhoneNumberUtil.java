package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.052 -0400", hash_original_field = "E8745D64C3DDF690DBE72A168636F59F", hash_generated_field = "01E27589414D4F00E028D65F7226ED03")

    private String currentFilePrefix = META_DATA_FILE_PREFIX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.052 -0400", hash_original_field = "B57D2492E5166B044429F301D8A74EA1", hash_generated_field = "BD442BEB298EC056D47850ADBC00339A")

    private Map<Integer, List<String>> countryCallingCodeToRegionCodeMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.052 -0400", hash_original_field = "4F55F961D3BC9EA226649AD63B138E32", hash_generated_field = "445AB292FFFF955C361081EF0C7CBBDA")

    private final Set<String> supportedRegions = new HashSet<String>(300);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.052 -0400", hash_original_field = "8675D15B1E320E731CDACFDFD78EBF22", hash_generated_field = "146729E450C9E16732378FDEF2691E9D")

    private final Set<String> nanpaRegions = new HashSet<String>(35);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.052 -0400", hash_original_field = "67B854AC1D3C388AC75FA01E35F25AAD", hash_generated_field = "34A606E45DB6BE384928258B5F11EAAA")

    private final Map<String, PhoneMetadata> regionToMetadataMap = Collections.synchronizedMap(new HashMap<String, PhoneMetadata>());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.052 -0400", hash_original_field = "4955B1F9986A64262B91DC1CEA30A4DA", hash_generated_field = "D87E3F8DA6908FEB810F4EC6D5D33CCE")

    private RegexCache regexCache = new RegexCache(100);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.052 -0400", hash_original_method = "3DBAF8008FFD9E53011E9436972AF77A", hash_generated_method = "E3CE9121B94C12BEE25C8B5EDF30F992")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.053 -0400", hash_original_method = "E42A7007FDB19817C28C648F3339DD4F", hash_generated_method = "53812BD4FC22BA43056FC4EA592F45C6")
    private void init(String filePrefix) {
        currentFilePrefix = filePrefix;
for(List<String> regionCodes : countryCallingCodeToRegionCodeMap.values())
        {
            supportedRegions.addAll(regionCodes);
        } //End block
        nanpaRegions.addAll(countryCallingCodeToRegionCodeMap.get(NANPA_COUNTRY_CODE));
        // ---------- Original Method ----------
        //currentFilePrefix = filePrefix;
        //for (List<String> regionCodes : countryCallingCodeToRegionCodeMap.values()) {
      //supportedRegions.addAll(regionCodes);
    //}
        //nanpaRegions.addAll(countryCallingCodeToRegionCodeMap.get(NANPA_COUNTRY_CODE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.053 -0400", hash_original_method = "D4A5DED95C2EE22965F522507C270AF5", hash_generated_method = "B218568BADDE6A8FAEFA7547451C796B")
    private void loadMetadataForRegionFromFile(String filePrefix, String regionCode) {
        addTaint(regionCode.getTaint());
        addTaint(filePrefix.getTaint());
        InputStream source = PhoneNumberUtil.class.getResourceAsStream(filePrefix + "_" + regionCode);
        ObjectInputStream in = null;
        try 
        {
            in = new ObjectInputStream(source);
            PhoneMetadataCollection metadataCollection = new PhoneMetadataCollection();
            metadataCollection.readExternal(in);
for(PhoneMetadata metadata : metadataCollection.getMetadataList())
            {
                regionToMetadataMap.put(regionCode, metadata);
            } //End block
        } //End block
        catch (IOException e)
        {
            LOGGER.log(Level.WARNING, e.toString());
        } //End block
        finally 
        {
            close(in);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.054 -0400", hash_original_method = "A1113EBAB3D0682FE612F1231142344C", hash_generated_method = "7CE12CBA9981D7C7423F70765D3C0151")
    private void close(InputStream in) {
        addTaint(in.getTaint());
        if(in != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.057 -0400", hash_original_method = "E944B5FE31AE1466662F85766A880CA9", hash_generated_method = "EF314F17F9A7C802074A710C2ADE06E7")
    public int getLengthOfGeographicalAreaCode(PhoneNumber number) {
        addTaint(number.getTaint());
        String regionCode = getRegionCodeForNumber(number);
        if(!isValidRegionCode(regionCode))        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1584103947 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950103339 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950103339;
        } //End block
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        if(!metadata.hasNationalPrefix())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1989317824 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107222199 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107222199;
        } //End block
        PhoneNumberType type = getNumberTypeHelper(getNationalSignificantNumber(number),
                                               metadata);
        if(type != PhoneNumberType.FIXED_LINE && type != PhoneNumberType.FIXED_LINE_OR_MOBILE)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_143440848 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923326322 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923326322;
        } //End block
        int var214A2405FA77F2CDFB00BD592075E7BA_949608896 = (getLengthOfNationalDestinationCode(number));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_467960453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_467960453;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.058 -0400", hash_original_method = "8F375C460DFE06AB35507021B2E67F57", hash_generated_method = "0BF1DF70F752F2965CE86CA9477E4381")
    public int getLengthOfNationalDestinationCode(PhoneNumber number) {
        addTaint(number.getTaint());
        PhoneNumber copiedProto;
        if(number.hasExtension())        
        {
            copiedProto = new PhoneNumber();
            copiedProto.mergeFrom(number);
            copiedProto.clearExtension();
        } //End block
        else
        {
            copiedProto = number;
        } //End block
        String nationalSignificantNumber = format(copiedProto,
                                              PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        String[] numberGroups = NON_DIGITS_PATTERN.split(nationalSignificantNumber);
        if(numberGroups.length <= 3)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_55673196 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301817064 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301817064;
        } //End block
        if(getRegionCodeForNumber(number).equals("AR") &&
        getNumberType(number) == PhoneNumberType.MOBILE)        
        {
            int varE0069A57AFDEEDEE60DDD9B83B09D61C_222742263 = (numberGroups[3].length() + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565777652 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565777652;
        } //End block
        int varD92EC1443447129ADC249AAB64997E87_857194965 = (numberGroups[2].length());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862115671 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862115671;
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

    
    @DSModeled(DSC.SAFE)
    static synchronized void resetInstance() {
        instance = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.059 -0400", hash_original_method = "8806D3371D9E306571E478F8E387F5F6", hash_generated_method = "2EBA4FEEA395D1BBD1567B69D7D7F3F0")
    public Set<String> getSupportedRegions() {
Set<String> varEF2FC022A937149A8AA0A9F71AA1B744_1892158939 =         supportedRegions;
        varEF2FC022A937149A8AA0A9F71AA1B744_1892158939.addTaint(taint);
        return varEF2FC022A937149A8AA0A9F71AA1B744_1892158939;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.059 -0400", hash_original_method = "BD64224247A46B4F8D1913B12FB0926A", hash_generated_method = "1BF4E5118035E7E25522881E1CD9EF2E")
    private boolean isValidRegionCode(String regionCode) {
        addTaint(regionCode.getTaint());
        boolean varA0A34CD5E2FA976F02B24DDB19F02C75_1702156634 = (regionCode != null && supportedRegions.contains(regionCode));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131353750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131353750;
        // ---------- Original Method ----------
        //return regionCode != null && supportedRegions.contains(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.059 -0400", hash_original_method = "8968A71862E924379D457A4D52F2E514", hash_generated_method = "98D7AFD43BD1277171D3CE035A00E43F")
    private boolean hasValidRegionCode(String regionCode,
                                     int countryCallingCode, String number) {
        addTaint(number.getTaint());
        addTaint(countryCallingCode);
        addTaint(regionCode.getTaint());
        if(!isValidRegionCode(regionCode))        
        {
            LOGGER.log(Level.WARNING,
                 "Number " + number + " has invalid or missing country calling code ("
                 + countryCallingCode + ")");
            boolean var68934A3E9455FA72420237EB05902327_454855975 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166785594 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166785594;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_811789608 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753234805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_753234805;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //LOGGER.log(Level.WARNING,
                 //"Number " + number + " has invalid or missing country calling code ("
                 //+ countryCallingCode + ")");
      //return false;
    //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.059 -0400", hash_original_method = "92F92B14F8645805E8F2936964CC9FBD", hash_generated_method = "63A94607DD9ED503FE3EAE344E0F09A4")
    public String format(PhoneNumber number, PhoneNumberFormat numberFormat) {
        addTaint(numberFormat.getTaint());
        addTaint(number.getTaint());
        if(number.getNationalNumber() == 0 && number.hasRawInput())        
        {
            String rawInput = number.getRawInput();
            if(rawInput.length() > 0)            
            {
String var4C3528254D620C7EE94E1630ADB05618_1902395276 =                 rawInput;
                var4C3528254D620C7EE94E1630ADB05618_1902395276.addTaint(taint);
                return var4C3528254D620C7EE94E1630ADB05618_1902395276;
            } //End block
        } //End block
        StringBuilder formattedNumber = new StringBuilder(20);
        format(number, numberFormat, formattedNumber);
String varC697D710133C8B631DE8A735C68AF0F9_577166546 =         formattedNumber.toString();
        varC697D710133C8B631DE8A735C68AF0F9_577166546.addTaint(taint);
        return varC697D710133C8B631DE8A735C68AF0F9_577166546;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.060 -0400", hash_original_method = "0E0E29DD0B07020C65FE41B70E3EF74E", hash_generated_method = "4D79896A71F76D416203504EF8151E79")
    public void format(PhoneNumber number, PhoneNumberFormat numberFormat,
                     StringBuilder formattedNumber) {
        addTaint(formattedNumber.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(number.getTaint());
        formattedNumber.setLength(0);
        int countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if(numberFormat == PhoneNumberFormat.E164)        
        {
            formattedNumber.append(nationalSignificantNumber);
            formatNumberByFormat(countryCallingCode, PhoneNumberFormat.E164, formattedNumber);
            return;
        } //End block
        String regionCode = getRegionCodeForCountryCode(countryCallingCode);
        if(!isValidRegionCode(regionCode))        
        {
            formattedNumber.append(nationalSignificantNumber);
            return;
        } //End block
        formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode, numberFormat));
        maybeGetFormattedExtension(number, regionCode, numberFormat, formattedNumber);
        formatNumberByFormat(countryCallingCode, numberFormat, formattedNumber);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.061 -0400", hash_original_method = "9F9F17BED2EE6CF557E830A9924BD1F5", hash_generated_method = "84FE2190505046012D0211CE0BEF0FD2")
    public String formatByPattern(PhoneNumber number,
                                PhoneNumberFormat numberFormat,
                                List<NumberFormat> userDefinedFormats) {
        addTaint(userDefinedFormats.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(number.getTaint());
        int countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        String regionCode = getRegionCodeForCountryCode(countryCallingCode);
        if(!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber))        
        {
String varF05AB7F68F69868767D9858C73BDB0C1_1446196957 =             nationalSignificantNumber;
            varF05AB7F68F69868767D9858C73BDB0C1_1446196957.addTaint(taint);
            return varF05AB7F68F69868767D9858C73BDB0C1_1446196957;
        } //End block
        List<NumberFormat> userDefinedFormatsCopy = new ArrayList<NumberFormat>(userDefinedFormats.size());
for(NumberFormat numFormat : userDefinedFormats)
        {
            String nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
            if(nationalPrefixFormattingRule.length() > 0)            
            {
                NumberFormat numFormatCopy = new NumberFormat();
                numFormatCopy.mergeFrom(numFormat);
                String nationalPrefix = getMetadataForRegion(regionCode).getNationalPrefix();
                if(nationalPrefix.length() > 0)                
                {
                    nationalPrefixFormattingRule =
              NP_PATTERN.matcher(nationalPrefixFormattingRule).replaceFirst(nationalPrefix);
                    nationalPrefixFormattingRule =
              FG_PATTERN.matcher(nationalPrefixFormattingRule).replaceFirst("\\$1");
                    numFormatCopy.setNationalPrefixFormattingRule(nationalPrefixFormattingRule);
                } //End block
                else
                {
                    numFormatCopy.clearNationalPrefixFormattingRule();
                } //End block
                userDefinedFormatsCopy.add(numFormatCopy);
            } //End block
            else
            {
                userDefinedFormatsCopy.add(numFormat);
            } //End block
        } //End block
        StringBuilder formattedNumber = new StringBuilder(formatAccordingToFormats(nationalSignificantNumber,
                                                   userDefinedFormatsCopy,
                                                   numberFormat));
        maybeGetFormattedExtension(number, regionCode, numberFormat, formattedNumber);
        formatNumberByFormat(countryCallingCode, numberFormat, formattedNumber);
String varC697D710133C8B631DE8A735C68AF0F9_1562628155 =         formattedNumber.toString();
        varC697D710133C8B631DE8A735C68AF0F9_1562628155.addTaint(taint);
        return varC697D710133C8B631DE8A735C68AF0F9_1562628155;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.062 -0400", hash_original_method = "91C4446CD1D629D514A31D665364644B", hash_generated_method = "72EB221CAF8917C6F5CAD7086A3398F1")
    public String formatNationalNumberWithCarrierCode(PhoneNumber number, String carrierCode) {
        addTaint(carrierCode.getTaint());
        addTaint(number.getTaint());
        int countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        String regionCode = getRegionCodeForCountryCode(countryCallingCode);
        if(!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber))        
        {
String varF05AB7F68F69868767D9858C73BDB0C1_124383981 =             nationalSignificantNumber;
            varF05AB7F68F69868767D9858C73BDB0C1_124383981.addTaint(taint);
            return varF05AB7F68F69868767D9858C73BDB0C1_124383981;
        } //End block
        StringBuilder formattedNumber = new StringBuilder(20);
        formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode,
                                                PhoneNumberFormat.NATIONAL,
                                                carrierCode));
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.NATIONAL, formattedNumber);
        formatNumberByFormat(countryCallingCode, PhoneNumberFormat.NATIONAL, formattedNumber);
String varC697D710133C8B631DE8A735C68AF0F9_559811857 =         formattedNumber.toString();
        varC697D710133C8B631DE8A735C68AF0F9_559811857.addTaint(taint);
        return varC697D710133C8B631DE8A735C68AF0F9_559811857;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.062 -0400", hash_original_method = "4CA1ACD2C86EAA8A1981D39B6D2FA7BC", hash_generated_method = "083700446B0B356D252C7DAC6818CC78")
    public String formatNationalNumberWithPreferredCarrierCode(PhoneNumber number,
                                                             String fallbackCarrierCode) {
        addTaint(fallbackCarrierCode.getTaint());
        addTaint(number.getTaint());
String var522347F2D7718BC2C7351CAF03CEBADC_1866428058 =         formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       ? number.getPreferredDomesticCarrierCode()
                                                       : fallbackCarrierCode);
        var522347F2D7718BC2C7351CAF03CEBADC_1866428058.addTaint(taint);
        return var522347F2D7718BC2C7351CAF03CEBADC_1866428058;
        // ---------- Original Method ----------
        //return formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       //? number.getPreferredDomesticCarrierCode()
                                                       //: fallbackCarrierCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.062 -0400", hash_original_method = "F62393BCCF4A49D66E11EE7D750D9FD1", hash_generated_method = "D524040E98B3D4612AB001170660A204")
    public String formatOutOfCountryCallingNumber(PhoneNumber number,
                                                String regionCallingFrom) {
        addTaint(regionCallingFrom.getTaint());
        addTaint(number.getTaint());
        if(!isValidRegionCode(regionCallingFrom))        
        {
String varE77B1031715ED0E181D1CF060BC8A033_2116523269 =             format(number, PhoneNumberFormat.INTERNATIONAL);
            varE77B1031715ED0E181D1CF060BC8A033_2116523269.addTaint(taint);
            return varE77B1031715ED0E181D1CF060BC8A033_2116523269;
        } //End block
        int countryCallingCode = number.getCountryCode();
        String regionCode = getRegionCodeForCountryCode(countryCallingCode);
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if(!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber))        
        {
String varF05AB7F68F69868767D9858C73BDB0C1_1226322866 =             nationalSignificantNumber;
            varF05AB7F68F69868767D9858C73BDB0C1_1226322866.addTaint(taint);
            return varF05AB7F68F69868767D9858C73BDB0C1_1226322866;
        } //End block
        if(countryCallingCode == NANPA_COUNTRY_CODE)        
        {
            if(isNANPACountry(regionCallingFrom))            
            {
String var59595B0009553FA14D0A17B20B6304AF_321267809 =                 countryCallingCode + " " + format(number, PhoneNumberFormat.NATIONAL);
                var59595B0009553FA14D0A17B20B6304AF_321267809.addTaint(taint);
                return var59595B0009553FA14D0A17B20B6304AF_321267809;
            } //End block
        } //End block
        else
        if(countryCallingCode == getCountryCodeForRegion(regionCallingFrom))        
        {
String var77C261F23CC4AAED1867D91B274A40C3_211655367 =             format(number, PhoneNumberFormat.NATIONAL);
            var77C261F23CC4AAED1867D91B274A40C3_211655367.addTaint(taint);
            return var77C261F23CC4AAED1867D91B274A40C3_211655367;
        } //End block
        String formattedNationalNumber = formatNationalNumber(nationalSignificantNumber,
                             regionCode, PhoneNumberFormat.INTERNATIONAL);
        PhoneMetadata metadata = getMetadataForRegion(regionCallingFrom);
        String internationalPrefix = metadata.getInternationalPrefix();
        String internationalPrefixForFormatting = "";
        if(UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches())        
        {
            internationalPrefixForFormatting = internationalPrefix;
        } //End block
        else
        if(metadata.hasPreferredInternationalPrefix())        
        {
            internationalPrefixForFormatting = metadata.getPreferredInternationalPrefix();
        } //End block
        StringBuilder formattedNumber = new StringBuilder(formattedNationalNumber);
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
        if(internationalPrefixForFormatting.length() > 0)        
        {
            formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, " ")
          .insert(0, internationalPrefixForFormatting);
        } //End block
        else
        {
            formatNumberByFormat(countryCallingCode,
                           PhoneNumberFormat.INTERNATIONAL,
                           formattedNumber);
        } //End block
String varC697D710133C8B631DE8A735C68AF0F9_705745304 =         formattedNumber.toString();
        varC697D710133C8B631DE8A735C68AF0F9_705745304.addTaint(taint);
        return varC697D710133C8B631DE8A735C68AF0F9_705745304;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.063 -0400", hash_original_method = "DB42BF938772B1A7D3909F64DD7B67BB", hash_generated_method = "52C16A04FB1C78D2E75956429AAFD728")
    public String formatInOriginalFormat(PhoneNumber number, String regionCallingFrom) {
        addTaint(regionCallingFrom.getTaint());
        addTaint(number.getTaint());
        if(number.hasRawInput() &&
        (!hasFormattingPatternForNumber(number) || !isValidNumber(number)))        
        {
String varBA760673F1DECEF8623D74E055416911_1227214653 =             number.getRawInput();
            varBA760673F1DECEF8623D74E055416911_1227214653.addTaint(taint);
            return varBA760673F1DECEF8623D74E055416911_1227214653;
        } //End block
        if(!number.hasCountryCodeSource())        
        {
String var77C261F23CC4AAED1867D91B274A40C3_1263467931 =             format(number, PhoneNumberFormat.NATIONAL);
            var77C261F23CC4AAED1867D91B274A40C3_1263467931.addTaint(taint);
            return var77C261F23CC4AAED1867D91B274A40C3_1263467931;
        } //End block
        String formattedNumber;
switch(number.getCountryCodeSource()){
        case FROM_NUMBER_WITH_PLUS_SIGN:
        formattedNumber = format(number, PhoneNumberFormat.INTERNATIONAL);
        break;
        case FROM_NUMBER_WITH_IDD:
        formattedNumber = formatOutOfCountryCallingNumber(number, regionCallingFrom);
        break;
        case FROM_NUMBER_WITHOUT_PLUS_SIGN:
        formattedNumber = format(number, PhoneNumberFormat.INTERNATIONAL).substring(1);
        break;
        case FROM_DEFAULT_COUNTRY:
        default:
        formattedNumber = format(number, PhoneNumberFormat.NATIONAL);
        break;
}        String rawInput = number.getRawInput();
String var196F130A6783E3B2F18363B11440E834_2099172318 =         (formattedNumber != null &&
            normalizeDigitsOnly(formattedNumber).equals(normalizeDigitsOnly(rawInput)))
        ? formattedNumber
        : rawInput;
        var196F130A6783E3B2F18363B11440E834_2099172318.addTaint(taint);
        return var196F130A6783E3B2F18363B11440E834_2099172318;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.063 -0400", hash_original_method = "52E7EF7A7F940E41CFECD8D7BD9FA23C", hash_generated_method = "397E3004D9AE948F37231A7773FC7DF5")
    private boolean hasFormattingPatternForNumber(PhoneNumber number) {
        addTaint(number.getTaint());
        String phoneNumberRegion = getRegionCodeForCountryCode(number.getCountryCode());
        PhoneMetadata metadata = getMetadataForRegion(phoneNumberRegion);
        if(metadata == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_907604904 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141094269 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_141094269;
        } //End block
        String nationalNumber = getNationalSignificantNumber(number);
        NumberFormat formatRule = chooseFormattingPatternForNumber(metadata.numberFormats(), nationalNumber);
        boolean varA6A93D7B8077343D7A2269F641B2B1C9_968686060 = (formatRule != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989745502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989745502;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.064 -0400", hash_original_method = "4891B65BEA4A6D1403DAAAE11CCEEA80", hash_generated_method = "B5097B5D8A82FF1FACD66FFDD13D4F31")
    public String formatOutOfCountryKeepingAlphaChars(PhoneNumber number,
                                                    String regionCallingFrom) {
        addTaint(regionCallingFrom.getTaint());
        addTaint(number.getTaint());
        String rawInput = number.getRawInput();
        if(rawInput.length() == 0)        
        {
String var712D5C7659B26A992DC9E9DF0EF77E89_1126728925 =             formatOutOfCountryCallingNumber(number, regionCallingFrom);
            var712D5C7659B26A992DC9E9DF0EF77E89_1126728925.addTaint(taint);
            return var712D5C7659B26A992DC9E9DF0EF77E89_1126728925;
        } //End block
        int countryCode = number.getCountryCode();
        String regionCode = getRegionCodeForCountryCode(countryCode);
        if(!hasValidRegionCode(regionCode, countryCode, rawInput))        
        {
String var4C3528254D620C7EE94E1630ADB05618_782091239 =             rawInput;
            var4C3528254D620C7EE94E1630ADB05618_782091239.addTaint(taint);
            return var4C3528254D620C7EE94E1630ADB05618_782091239;
        } //End block
        rawInput = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String nationalNumber = getNationalSignificantNumber(number);
        if(nationalNumber.length() > 3)        
        {
            int firstNationalNumberDigit = rawInput.indexOf(nationalNumber.substring(0, 3));
            if(firstNationalNumberDigit != -1)            
            {
                rawInput = rawInput.substring(firstNationalNumberDigit);
            } //End block
        } //End block
        PhoneMetadata metadata = getMetadataForRegion(regionCallingFrom);
        if(countryCode == NANPA_COUNTRY_CODE)        
        {
            if(isNANPACountry(regionCallingFrom))            
            {
String var4FB790364FA40F7B59D21CAC52B0D6AD_940497928 =                 countryCode + " " + rawInput;
                var4FB790364FA40F7B59D21CAC52B0D6AD_940497928.addTaint(taint);
                return var4FB790364FA40F7B59D21CAC52B0D6AD_940497928;
            } //End block
        } //End block
        else
        if(countryCode == getCountryCodeForRegion(regionCallingFrom))        
        {
            List<NumberFormat> availableFormats = new ArrayList<NumberFormat>(metadata.numberFormatSize());
for(NumberFormat format : metadata.numberFormats())
            {
                NumberFormat newFormat = new NumberFormat();
                newFormat.mergeFrom(format);
                newFormat.setPattern("(\\d+)(.*)");
                newFormat.setFormat("$1$2");
                availableFormats.add(newFormat);
            } //End block
String var6E20D12E7928B8453A86531D6465665B_1519787582 =             formatAccordingToFormats(rawInput, availableFormats, PhoneNumberFormat.NATIONAL);
            var6E20D12E7928B8453A86531D6465665B_1519787582.addTaint(taint);
            return var6E20D12E7928B8453A86531D6465665B_1519787582;
        } //End block
        String internationalPrefix = metadata.getInternationalPrefix();
        String internationalPrefixForFormatting = UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches()
        ? internationalPrefix
        : metadata.getPreferredInternationalPrefix();
        StringBuilder formattedNumber = new StringBuilder(rawInput);
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
        if(internationalPrefixForFormatting.length() > 0)        
        {
            formattedNumber.insert(0, " ").insert(0, countryCode).insert(0, " ")
          .insert(0, internationalPrefixForFormatting);
        } //End block
        else
        {
            formatNumberByFormat(countryCode,
                           PhoneNumberFormat.INTERNATIONAL,
                           formattedNumber);
        } //End block
String varC697D710133C8B631DE8A735C68AF0F9_244798705 =         formattedNumber.toString();
        varC697D710133C8B631DE8A735C68AF0F9_244798705.addTaint(taint);
        return varC697D710133C8B631DE8A735C68AF0F9_244798705;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.064 -0400", hash_original_method = "D5C4512E5E6006B319585FD039F0D2D2", hash_generated_method = "9C1210406EC2B79641C23E89297F485B")
    public String getNationalSignificantNumber(PhoneNumber number) {
        addTaint(number.getTaint());
        StringBuilder nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");
        nationalNumber.append(number.getNationalNumber());
String var3219B8CB3BE3DDF0BB546C5507C28EE4_944905090 =         nationalNumber.toString();
        var3219B8CB3BE3DDF0BB546C5507C28EE4_944905090.addTaint(taint);
        return var3219B8CB3BE3DDF0BB546C5507C28EE4_944905090;
        // ---------- Original Method ----------
        //StringBuilder nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");
        //nationalNumber.append(number.getNationalNumber());
        //return nationalNumber.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.064 -0400", hash_original_method = "B30288467474491802F599221421F5DD", hash_generated_method = "724AC871069FECA8C18E1048492D7838")
    private void formatNumberByFormat(int countryCallingCode,
                                    PhoneNumberFormat numberFormat,
                                    StringBuilder formattedNumber) {
        addTaint(formattedNumber.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(countryCallingCode);
switch(numberFormat){
        case E164:
        formattedNumber.insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        return;
        case INTERNATIONAL:
        formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        return;
        case RFC3966:
        formattedNumber.insert(0, "-").insert(0, countryCallingCode) .insert(0, PLUS_SIGN);
        return;
        case NATIONAL:
        default:
        return;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.064 -0400", hash_original_method = "E72DB4CB518547F268CF62BAEDE813DC", hash_generated_method = "A6C5DA134E95190A9889219E64797778")
    private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat) {
        addTaint(numberFormat.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(number.getTaint());
String var587AE87B4CE6226E8FD9FCBEF4D3AB42_2054105101 =         formatNationalNumber(number, regionCode, numberFormat, null);
        var587AE87B4CE6226E8FD9FCBEF4D3AB42_2054105101.addTaint(taint);
        return var587AE87B4CE6226E8FD9FCBEF4D3AB42_2054105101;
        // ---------- Original Method ----------
        //return formatNationalNumber(number, regionCode, numberFormat, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.065 -0400", hash_original_method = "C233FF64EBF86F393338B595D4311670", hash_generated_method = "488D66FEE5BC1E8993056839A798F22C")
    private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat,
                                      String carrierCode) {
        addTaint(carrierCode.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(number.getTaint());
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        List<NumberFormat> intlNumberFormats = metadata.intlNumberFormats();
        List<NumberFormat> availableFormats = (intlNumberFormats.size() == 0 || numberFormat == PhoneNumberFormat.NATIONAL)
        ? metadata.numberFormats()
        : metadata.intlNumberFormats();
        String formattedNationalNumber = formatAccordingToFormats(number, availableFormats, numberFormat, carrierCode);
        if(numberFormat == PhoneNumberFormat.RFC3966)        
        {
            formattedNationalNumber =
          SEPARATOR_PATTERN.matcher(formattedNationalNumber).replaceAll("-");
        } //End block
String varC9D8D8395D3C2B902E9D17DAA4321F25_1016758650 =         formattedNationalNumber;
        varC9D8D8395D3C2B902E9D17DAA4321F25_1016758650.addTaint(taint);
        return varC9D8D8395D3C2B902E9D17DAA4321F25_1016758650;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.065 -0400", hash_original_method = "8234956A6CF3F674EC2E620926354B88", hash_generated_method = "ABB997CA92455F3E973F4F7CAC95B086")
    private NumberFormat chooseFormattingPatternForNumber(List<NumberFormat> availableFormats,
                                                        String nationalNumber) {
        addTaint(nationalNumber.getTaint());
        addTaint(availableFormats.getTaint());
for(NumberFormat numFormat : availableFormats)
        {
            int size = numFormat.leadingDigitsPatternSize();
            if(size == 0 || regexCache.getPatternForRegex(
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt())            
            {
                Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                if(m.matches())                
                {
NumberFormat var6C6838E70BE7E37EE46E76ACEB90F2D9_2140145744 =                     numFormat;
                    var6C6838E70BE7E37EE46E76ACEB90F2D9_2140145744.addTaint(taint);
                    return var6C6838E70BE7E37EE46E76ACEB90F2D9_2140145744;
                } //End block
            } //End block
        } //End block
NumberFormat var540C13E9E156B687226421B24F2DF178_1942517121 =         null;
        var540C13E9E156B687226421B24F2DF178_1942517121.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1942517121;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.065 -0400", hash_original_method = "ABA7814B1012D26F514E5605C0CC3287", hash_generated_method = "1CF3347B26520101BDF1960CC9ACBB72")
    private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat) {
        addTaint(numberFormat.getTaint());
        addTaint(availableFormats.getTaint());
        addTaint(nationalNumber.getTaint());
String varBC47BBB3B7E18DA29DD55CA7FDD94AC4_1837846753 =         formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null);
        varBC47BBB3B7E18DA29DD55CA7FDD94AC4_1837846753.addTaint(taint);
        return varBC47BBB3B7E18DA29DD55CA7FDD94AC4_1837846753;
        // ---------- Original Method ----------
        //return formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.066 -0400", hash_original_method = "58A13E9521CF391FA7B0E516ACC9ED0C", hash_generated_method = "5B85D0DA128C11FAFDB35B39D91E8905")
    private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat,
                                          String carrierCode) {
        addTaint(carrierCode.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(availableFormats.getTaint());
        addTaint(nationalNumber.getTaint());
for(NumberFormat numFormat : availableFormats)
        {
            int size = numFormat.leadingDigitsPatternSize();
            if(size == 0 || regexCache.getPatternForRegex(
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt())            
            {
                Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                if(m.matches())                
                {
                    String numberFormatRule = numFormat.getFormat();
                    if(numberFormat == PhoneNumberFormat.NATIONAL &&
              carrierCode != null && carrierCode.length() > 0 &&
              numFormat.getDomesticCarrierCodeFormattingRule().length() > 0)                    
                    {
                        String carrierCodeFormattingRule = numFormat.getDomesticCarrierCodeFormattingRule();
                        carrierCodeFormattingRule =
                CC_PATTERN.matcher(carrierCodeFormattingRule).replaceFirst(carrierCode);
                        numberFormatRule = FIRST_GROUP_PATTERN.matcher(numberFormatRule)
                .replaceFirst(carrierCodeFormattingRule);
String varE13976703A06B37A815BE6D1D6CF1C58_999139425 =                         m.replaceAll(numberFormatRule);
                        varE13976703A06B37A815BE6D1D6CF1C58_999139425.addTaint(taint);
                        return varE13976703A06B37A815BE6D1D6CF1C58_999139425;
                    } //End block
                    else
                    {
                        String nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
                        if(numberFormat == PhoneNumberFormat.NATIONAL &&
                nationalPrefixFormattingRule != null &&
                nationalPrefixFormattingRule.length() > 0)                        
                        {
                            Matcher firstGroupMatcher = FIRST_GROUP_PATTERN.matcher(numberFormatRule);
String varB85CC519D7734391B87E725089439404_1490535799 =                             m.replaceAll(firstGroupMatcher.replaceFirst(nationalPrefixFormattingRule));
                            varB85CC519D7734391B87E725089439404_1490535799.addTaint(taint);
                            return varB85CC519D7734391B87E725089439404_1490535799;
                        } //End block
                        else
                        {
String varE13976703A06B37A815BE6D1D6CF1C58_1332478428 =                             m.replaceAll(numberFormatRule);
                            varE13976703A06B37A815BE6D1D6CF1C58_1332478428.addTaint(taint);
                            return varE13976703A06B37A815BE6D1D6CF1C58_1332478428;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
String varDBE12C087DF4B88CF992CDC1568A8C91_1546774398 =         nationalNumber;
        varDBE12C087DF4B88CF992CDC1568A8C91_1546774398.addTaint(taint);
        return varDBE12C087DF4B88CF992CDC1568A8C91_1546774398;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.066 -0400", hash_original_method = "B3C328ACE4FF3869EFF5C65F569BC538", hash_generated_method = "8706C5D4BE042AE01384C747201A7316")
    public PhoneNumber getExampleNumber(String regionCode) {
        addTaint(regionCode.getTaint());
PhoneNumber var170931E3CA73B9CE6B96AC4128B63472_567443340 =         getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
        var170931E3CA73B9CE6B96AC4128B63472_567443340.addTaint(taint);
        return var170931E3CA73B9CE6B96AC4128B63472_567443340;
        // ---------- Original Method ----------
        //return getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.066 -0400", hash_original_method = "B7676779AEFA9EF56CC59B101D8DF6C5", hash_generated_method = "44282093DDC8F3FC7C715E7517565FDC")
    public PhoneNumber getExampleNumberForType(String regionCode, PhoneNumberType type) {
        addTaint(type.getTaint());
        addTaint(regionCode.getTaint());
        if(!isValidRegionCode(regionCode))        
        {
            LOGGER.log(Level.WARNING, "Invalid or unknown region code provided.");
PhoneNumber var540C13E9E156B687226421B24F2DF178_372394921 =             null;
            var540C13E9E156B687226421B24F2DF178_372394921.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_372394921;
        } //End block
        PhoneNumberDesc desc = getNumberDescByType(getMetadataForRegion(regionCode), type);
        try 
        {
            if(desc.hasExampleNumber())            
            {
PhoneNumber var87D4CF9C33C8EF5F644797A6044ABB3A_1320835028 =                 parse(desc.getExampleNumber(), regionCode);
                var87D4CF9C33C8EF5F644797A6044ABB3A_1320835028.addTaint(taint);
                return var87D4CF9C33C8EF5F644797A6044ABB3A_1320835028;
            } //End block
        } //End block
        catch (NumberParseException e)
        {
            LOGGER.log(Level.SEVERE, e.toString());
        } //End block
PhoneNumber var540C13E9E156B687226421B24F2DF178_1503841095 =         null;
        var540C13E9E156B687226421B24F2DF178_1503841095.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1503841095;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.066 -0400", hash_original_method = "6C2C2EA977BB9169AEFD40896548847E", hash_generated_method = "66EE1A2730398F192A11DBAC0EAF49D4")
    private void maybeGetFormattedExtension(PhoneNumber number, String regionCode,
                                          PhoneNumberFormat numberFormat,
                                          StringBuilder formattedNumber) {
        addTaint(formattedNumber.getTaint());
        addTaint(numberFormat.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(number.getTaint());
        if(number.hasExtension() && number.getExtension().length() > 0)        
        {
            if(numberFormat == PhoneNumberFormat.RFC3966)            
            {
                formattedNumber.append(RFC3966_EXTN_PREFIX).append(number.getExtension());
            } //End block
            else
            {
                formatExtension(number.getExtension(), regionCode, formattedNumber);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (number.hasExtension() && number.getExtension().length() > 0) {
      //if (numberFormat == PhoneNumberFormat.RFC3966) {
        //formattedNumber.append(RFC3966_EXTN_PREFIX).append(number.getExtension());
      //} else {
        //formatExtension(number.getExtension(), regionCode, formattedNumber);
      //}
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.066 -0400", hash_original_method = "4E1A69FB5E070DF7BC56976B37027181", hash_generated_method = "C77F5AD1472AF39E90BDDC22999DF832")
    private void formatExtension(String extensionDigits, String regionCode,
                               StringBuilder extension) {
        addTaint(extension.getTaint());
        addTaint(regionCode.getTaint());
        addTaint(extensionDigits.getTaint());
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        if(metadata.hasPreferredExtnPrefix())        
        {
            extension.append(metadata.getPreferredExtnPrefix()).append(extensionDigits);
        } //End block
        else
        {
            extension.append(DEFAULT_EXTN_PREFIX).append(extensionDigits);
        } //End block
        // ---------- Original Method ----------
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //if (metadata.hasPreferredExtnPrefix()) {
      //extension.append(metadata.getPreferredExtnPrefix()).append(extensionDigits);
    //} else {
      //extension.append(DEFAULT_EXTN_PREFIX).append(extensionDigits);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.067 -0400", hash_original_method = "B508A0D4C9257AABA72DD1888D64C9E3", hash_generated_method = "2F8EDF489773C45A97F99CED5C6CB0F3")
     PhoneNumberDesc getNumberDescByType(PhoneMetadata metadata, PhoneNumberType type) {
        addTaint(type.getTaint());
        addTaint(metadata.getTaint());
switch(type){
        case PREMIUM_RATE:
PhoneNumberDesc varB98FFB4D3430870B3A8518F9BCAFB5EC_1029944238 =         metadata.getPremiumRate();
        varB98FFB4D3430870B3A8518F9BCAFB5EC_1029944238.addTaint(taint);
        return varB98FFB4D3430870B3A8518F9BCAFB5EC_1029944238;
        case TOLL_FREE:
PhoneNumberDesc varE73742B949769457F4996102A008F5FB_1248329881 =         metadata.getTollFree();
        varE73742B949769457F4996102A008F5FB_1248329881.addTaint(taint);
        return varE73742B949769457F4996102A008F5FB_1248329881;
        case MOBILE:
PhoneNumberDesc var16CD63192A9469F4F820026E67BAB15C_1222542333 =         metadata.getMobile();
        var16CD63192A9469F4F820026E67BAB15C_1222542333.addTaint(taint);
        return var16CD63192A9469F4F820026E67BAB15C_1222542333;
        case FIXED_LINE:
        case FIXED_LINE_OR_MOBILE:
PhoneNumberDesc varDD8307D889BAD831BE4D7D729A65F922_385215864 =         metadata.getFixedLine();
        varDD8307D889BAD831BE4D7D729A65F922_385215864.addTaint(taint);
        return varDD8307D889BAD831BE4D7D729A65F922_385215864;
        case SHARED_COST:
PhoneNumberDesc var40AEBA923612AF4487C28BFDED4474B2_1685177997 =         metadata.getSharedCost();
        var40AEBA923612AF4487C28BFDED4474B2_1685177997.addTaint(taint);
        return var40AEBA923612AF4487C28BFDED4474B2_1685177997;
        case VOIP:
PhoneNumberDesc varDA6839EBD88416E7C1FA782B3AC11E60_309051604 =         metadata.getVoip();
        varDA6839EBD88416E7C1FA782B3AC11E60_309051604.addTaint(taint);
        return varDA6839EBD88416E7C1FA782B3AC11E60_309051604;
        case PERSONAL_NUMBER:
PhoneNumberDesc var7E0656691E934CE8CCDFD9BB44F0BA4A_186469825 =         metadata.getPersonalNumber();
        var7E0656691E934CE8CCDFD9BB44F0BA4A_186469825.addTaint(taint);
        return var7E0656691E934CE8CCDFD9BB44F0BA4A_186469825;
        case PAGER:
PhoneNumberDesc var595CC4620B6B05F419F22BCEEE9C8B30_268750780 =         metadata.getPager();
        var595CC4620B6B05F419F22BCEEE9C8B30_268750780.addTaint(taint);
        return var595CC4620B6B05F419F22BCEEE9C8B30_268750780;
        case UAN:
PhoneNumberDesc var3BD3CC1D11FCA4B3D741D5B1297F8935_1670683176 =         metadata.getUan();
        var3BD3CC1D11FCA4B3D741D5B1297F8935_1670683176.addTaint(taint);
        return var3BD3CC1D11FCA4B3D741D5B1297F8935_1670683176;
        default:
PhoneNumberDesc var10EF8F54415B73A4F993ACB466BF3BE3_624455029 =         metadata.getGeneralDesc();
        var10EF8F54415B73A4F993ACB466BF3BE3_624455029.addTaint(taint);
        return var10EF8F54415B73A4F993ACB466BF3BE3_624455029;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.067 -0400", hash_original_method = "261D2E3780968B6A389AA5653D83C66D", hash_generated_method = "38EFE4C3DEDB43A57E0F6CEA0597C0E7")
    public PhoneNumberType getNumberType(PhoneNumber number) {
        addTaint(number.getTaint());
        String regionCode = getRegionCodeForNumber(number);
        if(!isValidRegionCode(regionCode))        
        {
PhoneNumberType varE8B28A912349E63E1446AA322AE860DF_219036191 =             PhoneNumberType.UNKNOWN;
            varE8B28A912349E63E1446AA322AE860DF_219036191.addTaint(taint);
            return varE8B28A912349E63E1446AA322AE860DF_219036191;
        } //End block
        String nationalSignificantNumber = getNationalSignificantNumber(number);
PhoneNumberType varD45AFDB9023EFFF52CCA5817C5BA8482_1372225095 =         getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode));
        varD45AFDB9023EFFF52CCA5817C5BA8482_1372225095.addTaint(taint);
        return varD45AFDB9023EFFF52CCA5817C5BA8482_1372225095;
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //if (!isValidRegionCode(regionCode)) {
      //return PhoneNumberType.UNKNOWN;
    //}
        //String nationalSignificantNumber = getNationalSignificantNumber(number);
        //return getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.067 -0400", hash_original_method = "CFBB065FE396C61ECB0C897E1E4B66DC", hash_generated_method = "87661CAD222A813C5E90F3F36EC53A6D")
    private PhoneNumberType getNumberTypeHelper(String nationalNumber, PhoneMetadata metadata) {
        addTaint(metadata.getTaint());
        addTaint(nationalNumber.getTaint());
        PhoneNumberDesc generalNumberDesc = metadata.getGeneralDesc();
        if(!generalNumberDesc.hasNationalNumberPattern() ||
        !isNumberMatchingDesc(nationalNumber, generalNumberDesc))        
        {
PhoneNumberType varE8B28A912349E63E1446AA322AE860DF_890158250 =             PhoneNumberType.UNKNOWN;
            varE8B28A912349E63E1446AA322AE860DF_890158250.addTaint(taint);
            return varE8B28A912349E63E1446AA322AE860DF_890158250;
        } //End block
        if(isNumberMatchingDesc(nationalNumber, metadata.getPremiumRate()))        
        {
PhoneNumberType var94EFD2DDF8DF33836FD0D5E947CD692B_127635506 =             PhoneNumberType.PREMIUM_RATE;
            var94EFD2DDF8DF33836FD0D5E947CD692B_127635506.addTaint(taint);
            return var94EFD2DDF8DF33836FD0D5E947CD692B_127635506;
        } //End block
        if(isNumberMatchingDesc(nationalNumber, metadata.getTollFree()))        
        {
PhoneNumberType var0290235ED45BCDC78848EA5FA1443EC8_1002700220 =             PhoneNumberType.TOLL_FREE;
            var0290235ED45BCDC78848EA5FA1443EC8_1002700220.addTaint(taint);
            return var0290235ED45BCDC78848EA5FA1443EC8_1002700220;
        } //End block
        if(isNumberMatchingDesc(nationalNumber, metadata.getSharedCost()))        
        {
PhoneNumberType var6CFE36CB5CBAFACBC6E1FD42751D3FF5_1316161856 =             PhoneNumberType.SHARED_COST;
            var6CFE36CB5CBAFACBC6E1FD42751D3FF5_1316161856.addTaint(taint);
            return var6CFE36CB5CBAFACBC6E1FD42751D3FF5_1316161856;
        } //End block
        if(isNumberMatchingDesc(nationalNumber, metadata.getVoip()))        
        {
PhoneNumberType var663B958EA999D75AED60993F0C9071CC_1924696562 =             PhoneNumberType.VOIP;
            var663B958EA999D75AED60993F0C9071CC_1924696562.addTaint(taint);
            return var663B958EA999D75AED60993F0C9071CC_1924696562;
        } //End block
        if(isNumberMatchingDesc(nationalNumber, metadata.getPersonalNumber()))        
        {
PhoneNumberType var382B046503C149E8528897C7A0961352_514786696 =             PhoneNumberType.PERSONAL_NUMBER;
            var382B046503C149E8528897C7A0961352_514786696.addTaint(taint);
            return var382B046503C149E8528897C7A0961352_514786696;
        } //End block
        if(isNumberMatchingDesc(nationalNumber, metadata.getPager()))        
        {
PhoneNumberType var2557566AED55F8D846570E4BA1D0ECF9_1345162064 =             PhoneNumberType.PAGER;
            var2557566AED55F8D846570E4BA1D0ECF9_1345162064.addTaint(taint);
            return var2557566AED55F8D846570E4BA1D0ECF9_1345162064;
        } //End block
        if(isNumberMatchingDesc(nationalNumber, metadata.getUan()))        
        {
PhoneNumberType varE3C25A24407B504C83FF484AB7F8B031_349196531 =             PhoneNumberType.UAN;
            varE3C25A24407B504C83FF484AB7F8B031_349196531.addTaint(taint);
            return varE3C25A24407B504C83FF484AB7F8B031_349196531;
        } //End block
        boolean isFixedLine = isNumberMatchingDesc(nationalNumber, metadata.getFixedLine());
        if(isFixedLine)        
        {
            if(metadata.isSameMobileAndFixedLinePattern())            
            {
PhoneNumberType var9844C2D30AAF64C5D09AF03A244DF47A_1401676741 =                 PhoneNumberType.FIXED_LINE_OR_MOBILE;
                var9844C2D30AAF64C5D09AF03A244DF47A_1401676741.addTaint(taint);
                return var9844C2D30AAF64C5D09AF03A244DF47A_1401676741;
            } //End block
            else
            if(isNumberMatchingDesc(nationalNumber, metadata.getMobile()))            
            {
PhoneNumberType var9844C2D30AAF64C5D09AF03A244DF47A_2097583672 =                 PhoneNumberType.FIXED_LINE_OR_MOBILE;
                var9844C2D30AAF64C5D09AF03A244DF47A_2097583672.addTaint(taint);
                return var9844C2D30AAF64C5D09AF03A244DF47A_2097583672;
            } //End block
PhoneNumberType var20D5AF994D21A20F36FC88D7BBD3CD87_2056237068 =             PhoneNumberType.FIXED_LINE;
            var20D5AF994D21A20F36FC88D7BBD3CD87_2056237068.addTaint(taint);
            return var20D5AF994D21A20F36FC88D7BBD3CD87_2056237068;
        } //End block
        if(!metadata.isSameMobileAndFixedLinePattern() &&
        isNumberMatchingDesc(nationalNumber, metadata.getMobile()))        
        {
PhoneNumberType var73FD0538E8036DEA80592386053E5C02_1713653307 =             PhoneNumberType.MOBILE;
            var73FD0538E8036DEA80592386053E5C02_1713653307.addTaint(taint);
            return var73FD0538E8036DEA80592386053E5C02_1713653307;
        } //End block
PhoneNumberType varE8B28A912349E63E1446AA322AE860DF_589253958 =         PhoneNumberType.UNKNOWN;
        varE8B28A912349E63E1446AA322AE860DF_589253958.addTaint(taint);
        return varE8B28A912349E63E1446AA322AE860DF_589253958;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.068 -0400", hash_original_method = "B7D0F615A2820F4964EA69968467492C", hash_generated_method = "E09605CDAD05D9D1D77D9BE6934EF1F1")
     PhoneMetadata getMetadataForRegion(String regionCode) {
        addTaint(regionCode.getTaint());
        if(!isValidRegionCode(regionCode))        
        {
PhoneMetadata var540C13E9E156B687226421B24F2DF178_1164364815 =             null;
            var540C13E9E156B687226421B24F2DF178_1164364815.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1164364815;
        } //End block
        synchronized
(regionToMetadataMap)        {
            if(!regionToMetadataMap.containsKey(regionCode))            
            {
                loadMetadataForRegionFromFile(currentFilePrefix, regionCode);
            } //End block
        } //End block
PhoneMetadata var0F8C83A42CB9DCAAA31C5E42CBD29E40_1691340749 =         regionToMetadataMap.get(regionCode);
        var0F8C83A42CB9DCAAA31C5E42CBD29E40_1691340749.addTaint(taint);
        return var0F8C83A42CB9DCAAA31C5E42CBD29E40_1691340749;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.068 -0400", hash_original_method = "B17A0514C43E05EB90EE98CA4CB42983", hash_generated_method = "D5A49137562F41B738E71F5752D3D77D")
    private boolean isNumberMatchingDesc(String nationalNumber, PhoneNumberDesc numberDesc) {
        addTaint(numberDesc.getTaint());
        addTaint(nationalNumber.getTaint());
        Matcher possibleNumberPatternMatcher = regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            .matcher(nationalNumber);
        Matcher nationalNumberPatternMatcher = regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            .matcher(nationalNumber);
        boolean var2F21D5B1ECA4057C4893754BF2B346DA_1768209492 = (possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24881925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24881925;
        // ---------- Original Method ----------
        //Matcher possibleNumberPatternMatcher =
        //regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            //.matcher(nationalNumber);
        //Matcher nationalNumberPatternMatcher =
        //regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            //.matcher(nationalNumber);
        //return possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.068 -0400", hash_original_method = "31ADC24E14E9CE703FF2777ACEC876BF", hash_generated_method = "9591CC742B4BE835F832CA2D3465DA77")
    public boolean isValidNumber(PhoneNumber number) {
        addTaint(number.getTaint());
        String regionCode = getRegionCodeForNumber(number);
        boolean var26490563165F9A2B19FDF4CFD7BC597D_206254770 = ((isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144921467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144921467;
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //return (isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.068 -0400", hash_original_method = "C701813EA11D8E6ADA1ECC6BB90E9747", hash_generated_method = "B29F9E018C9D65BD5D4E36A07E99DED5")
    public boolean isValidNumberForRegion(PhoneNumber number, String regionCode) {
        addTaint(regionCode.getTaint());
        addTaint(number.getTaint());
        if(number.getCountryCode() != getCountryCodeForRegion(regionCode))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2046882564 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165667848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165667848;
        } //End block
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        PhoneNumberDesc generalNumDesc = metadata.getGeneralDesc();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if(!generalNumDesc.hasNationalNumberPattern())        
        {
            int numberLength = nationalSignificantNumber.length();
            boolean varAF614EA686D0BEEBDAB988A25DEF10FE_214363394 = (numberLength > MIN_LENGTH_FOR_NSN && numberLength <= MAX_LENGTH_FOR_NSN);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50087080 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_50087080;
        } //End block
        boolean var5A7F45D167D07481050C96F75D843075_539433392 = (getNumberTypeHelper(nationalSignificantNumber, metadata) != PhoneNumberType.UNKNOWN);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55530326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_55530326;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.068 -0400", hash_original_method = "C5C9CB0E93474118DAA9D7A65CA1060A", hash_generated_method = "E0DE07A6C988F9BF6B213A31BCE75B86")
    public String getRegionCodeForNumber(PhoneNumber number) {
        addTaint(number.getTaint());
        int countryCode = number.getCountryCode();
        List<String> regions = countryCallingCodeToRegionCodeMap.get(countryCode);
        if(regions == null)        
        {
String var540C13E9E156B687226421B24F2DF178_783521873 =             null;
            var540C13E9E156B687226421B24F2DF178_783521873.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_783521873;
        } //End block
        if(regions.size() == 1)        
        {
String varD2BD1F37174BAC9B0A7EA2610A4A21AE_179801159 =             regions.get(0);
            varD2BD1F37174BAC9B0A7EA2610A4A21AE_179801159.addTaint(taint);
            return varD2BD1F37174BAC9B0A7EA2610A4A21AE_179801159;
        } //End block
        else
        {
String varBC24E891C56B1FA0EBB965E18BD9F1A4_864866910 =             getRegionCodeForNumberFromRegionList(number, regions);
            varBC24E891C56B1FA0EBB965E18BD9F1A4_864866910.addTaint(taint);
            return varBC24E891C56B1FA0EBB965E18BD9F1A4_864866910;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.069 -0400", hash_original_method = "814AB76683AFE761330E661D695A8B3F", hash_generated_method = "1CEE1EF95633338D091ABC73F1D0BEDE")
    private String getRegionCodeForNumberFromRegionList(PhoneNumber number,
                                                      List<String> regionCodes) {
        addTaint(regionCodes.getTaint());
        addTaint(number.getTaint());
        String nationalNumber = getNationalSignificantNumber(number);
for(String regionCode : regionCodes)
        {
            PhoneMetadata metadata = getMetadataForRegion(regionCode);
            if(metadata.hasLeadingDigits())            
            {
                if(regexCache.getPatternForRegex(metadata.getLeadingDigits())
                .matcher(nationalNumber).lookingAt())                
                {
String var847FB4DB7646941BE8D2BF420995E2E1_979342497 =                     regionCode;
                    var847FB4DB7646941BE8D2BF420995E2E1_979342497.addTaint(taint);
                    return var847FB4DB7646941BE8D2BF420995E2E1_979342497;
                } //End block
            } //End block
            else
            if(getNumberTypeHelper(nationalNumber, metadata) != PhoneNumberType.UNKNOWN)            
            {
String var847FB4DB7646941BE8D2BF420995E2E1_1830232257 =                 regionCode;
                var847FB4DB7646941BE8D2BF420995E2E1_1830232257.addTaint(taint);
                return var847FB4DB7646941BE8D2BF420995E2E1_1830232257;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1346716495 =         null;
        var540C13E9E156B687226421B24F2DF178_1346716495.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1346716495;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.069 -0400", hash_original_method = "DA9951AEFEAF4242112AA6281301B32F", hash_generated_method = "30B89453B23750355FE5ED4E5342D232")
    public String getRegionCodeForCountryCode(int countryCallingCode) {
        addTaint(countryCallingCode);
        List<String> regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
String var9E2A9FB86E690D2E298F82B3CDEAF508_2051243033 =         regionCodes == null ? UNKNOWN_REGION : regionCodes.get(0);
        var9E2A9FB86E690D2E298F82B3CDEAF508_2051243033.addTaint(taint);
        return var9E2A9FB86E690D2E298F82B3CDEAF508_2051243033;
        // ---------- Original Method ----------
        //List<String> regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
        //return regionCodes == null ? UNKNOWN_REGION : regionCodes.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.069 -0400", hash_original_method = "D7076C7EB39C8978E29A5CA27F40EEC9", hash_generated_method = "1831DFEFDAB2CAF0AE38F18DBF314F43")
    public int getCountryCodeForRegion(String regionCode) {
        addTaint(regionCode.getTaint());
        if(!isValidRegionCode(regionCode))        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1842209767 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194585327 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194585327;
        } //End block
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        int var2F878907E3EC728ED220F35BBD311FBE_84664742 = (metadata.getCountryCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847098232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847098232;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //return 0;
    //}
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //return metadata.getCountryCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.069 -0400", hash_original_method = "E58B423D76AD6194B45901E123DB6EBF", hash_generated_method = "36D58D0109A680F4858FDF662CA10CAD")
    public String getNddPrefixForRegion(String regionCode, boolean stripNonDigits) {
        addTaint(stripNonDigits);
        addTaint(regionCode.getTaint());
        if(!isValidRegionCode(regionCode))        
        {
            LOGGER.log(Level.SEVERE, "Invalid or missing region code provided.");
String var540C13E9E156B687226421B24F2DF178_1669958724 =             null;
            var540C13E9E156B687226421B24F2DF178_1669958724.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1669958724;
        } //End block
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        String nationalPrefix = metadata.getNationalPrefix();
        if(nationalPrefix.length() == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_1957690730 =             null;
            var540C13E9E156B687226421B24F2DF178_1957690730.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1957690730;
        } //End block
        if(stripNonDigits)        
        {
            nationalPrefix = nationalPrefix.replace("~", "");
        } //End block
String var125CF9795C3A3714DEB83D441B501587_890564875 =         nationalPrefix;
        var125CF9795C3A3714DEB83D441B501587_890564875.addTaint(taint);
        return var125CF9795C3A3714DEB83D441B501587_890564875;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.069 -0400", hash_original_method = "7B63C50F103D8DC60E8A2B15ED73A093", hash_generated_method = "C61AFCC3570F6C22FBA59A26C1B80A21")
    public boolean isNANPACountry(String regionCode) {
        addTaint(regionCode.getTaint());
        boolean varFD520BDC92C1A12568C20FFA18572F0F_1420633052 = (nanpaRegions.contains(regionCode));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_624611670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_624611670;
        // ---------- Original Method ----------
        //return nanpaRegions.contains(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.070 -0400", hash_original_method = "996B7AC837898451564E65CADA674F54", hash_generated_method = "1D089990973282799F543AE9E2C17A7A")
     boolean isLeadingZeroPossible(int countryCallingCode) {
        addTaint(countryCallingCode);
        PhoneMetadata mainMetadataForCallingCode = getMetadataForRegion(
        getRegionCodeForCountryCode(countryCallingCode));
        if(mainMetadataForCallingCode == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1376588076 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579582294 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579582294;
        } //End block
        boolean varAA929E35CA432D3CE1BAAAD563A79053_608245995 = (mainMetadataForCallingCode.isLeadingZeroPossible());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195434724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195434724;
        // ---------- Original Method ----------
        //PhoneMetadata mainMetadataForCallingCode = getMetadataForRegion(
        //getRegionCodeForCountryCode(countryCallingCode));
        //if (mainMetadataForCallingCode == null) {
      //return false;
    //}
        //return mainMetadataForCallingCode.isLeadingZeroPossible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.070 -0400", hash_original_method = "4B80DFBB3D3B298395671B1C8C6F67DA", hash_generated_method = "A902A72E91E2C1BAB8897A74DA5424A9")
    public boolean isAlphaNumber(String number) {
        addTaint(number.getTaint());
        if(!isViablePhoneNumber(number))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1341324822 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636461438 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_636461438;
        } //End block
        StringBuilder strippedNumber = new StringBuilder(number);
        maybeStripExtension(strippedNumber);
        boolean varEC8D69A0C8E0FCECC89711D04552A179_2097384680 = (VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1277617367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1277617367;
        // ---------- Original Method ----------
        //if (!isViablePhoneNumber(number)) {
      //return false;
    //}
        //StringBuilder strippedNumber = new StringBuilder(number);
        //maybeStripExtension(strippedNumber);
        //return VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.070 -0400", hash_original_method = "86FEA4033CCC520A9BCC7CD67C884B0D", hash_generated_method = "8F05DDAB3BA207C2231A398E7E7A46DA")
    public boolean isPossibleNumber(PhoneNumber number) {
        addTaint(number.getTaint());
        boolean var9E032267AB5FD83D920FC35E6E549ADE_554256593 = (isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827047031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827047031;
        // ---------- Original Method ----------
        //return isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.070 -0400", hash_original_method = "B3EB56A7047F0C0039433A6E9896FBEF", hash_generated_method = "FE085C0B6FEC5936A788F0604B03156A")
    private ValidationResult testNumberLengthAgainstPattern(Pattern numberPattern, String number) {
        addTaint(number.getTaint());
        addTaint(numberPattern.getTaint());
        Matcher numberMatcher = numberPattern.matcher(number);
        if(numberMatcher.matches())        
        {
ValidationResult var5BC2E062C5A9EC7FB6B2D1B2343E8BDB_1269754430 =             ValidationResult.IS_POSSIBLE;
            var5BC2E062C5A9EC7FB6B2D1B2343E8BDB_1269754430.addTaint(taint);
            return var5BC2E062C5A9EC7FB6B2D1B2343E8BDB_1269754430;
        } //End block
        if(numberMatcher.lookingAt())        
        {
ValidationResult varAD69A845838FE8FD5F6ACD0F62EC4EFB_749687306 =             ValidationResult.TOO_LONG;
            varAD69A845838FE8FD5F6ACD0F62EC4EFB_749687306.addTaint(taint);
            return varAD69A845838FE8FD5F6ACD0F62EC4EFB_749687306;
        } //End block
        else
        {
ValidationResult var6E042EA234D0A69A19D4BD6F063A05C7_2093801574 =             ValidationResult.TOO_SHORT;
            var6E042EA234D0A69A19D4BD6F063A05C7_2093801574.addTaint(taint);
            return var6E042EA234D0A69A19D4BD6F063A05C7_2093801574;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.070 -0400", hash_original_method = "5E4449198019FBA49E61EB3BB2D3E7CD", hash_generated_method = "6A1BEB5BC960B50B3F97A4E4BF25AACC")
    public ValidationResult isPossibleNumberWithReason(PhoneNumber number) {
        addTaint(number.getTaint());
        String nationalNumber = getNationalSignificantNumber(number);
        int countryCode = number.getCountryCode();
        String regionCode = getRegionCodeForCountryCode(countryCode);
        if(!isValidRegionCode(regionCode))        
        {
ValidationResult var81B1D65374285B4B66E11C0D4B19F092_1877940022 =             ValidationResult.INVALID_COUNTRY_CODE;
            var81B1D65374285B4B66E11C0D4B19F092_1877940022.addTaint(taint);
            return var81B1D65374285B4B66E11C0D4B19F092_1877940022;
        } //End block
        PhoneNumberDesc generalNumDesc = getMetadataForRegion(regionCode).getGeneralDesc();
        if(!generalNumDesc.hasNationalNumberPattern())        
        {
            LOGGER.log(Level.FINER, "Checking if number is possible with incomplete metadata.");
            int numberLength = nationalNumber.length();
            if(numberLength < MIN_LENGTH_FOR_NSN)            
            {
ValidationResult var6E042EA234D0A69A19D4BD6F063A05C7_1011231680 =                 ValidationResult.TOO_SHORT;
                var6E042EA234D0A69A19D4BD6F063A05C7_1011231680.addTaint(taint);
                return var6E042EA234D0A69A19D4BD6F063A05C7_1011231680;
            } //End block
            else
            if(numberLength > MAX_LENGTH_FOR_NSN)            
            {
ValidationResult varAD69A845838FE8FD5F6ACD0F62EC4EFB_117195927 =                 ValidationResult.TOO_LONG;
                varAD69A845838FE8FD5F6ACD0F62EC4EFB_117195927.addTaint(taint);
                return varAD69A845838FE8FD5F6ACD0F62EC4EFB_117195927;
            } //End block
            else
            {
ValidationResult var5BC2E062C5A9EC7FB6B2D1B2343E8BDB_6154058 =                 ValidationResult.IS_POSSIBLE;
                var5BC2E062C5A9EC7FB6B2D1B2343E8BDB_6154058.addTaint(taint);
                return var5BC2E062C5A9EC7FB6B2D1B2343E8BDB_6154058;
            } //End block
        } //End block
        Pattern possibleNumberPattern = regexCache.getPatternForRegex(generalNumDesc.getPossibleNumberPattern());
ValidationResult varE8D2AC83E76431FAC265E667B2C4E5DC_1197804340 =         testNumberLengthAgainstPattern(possibleNumberPattern, nationalNumber);
        varE8D2AC83E76431FAC265E667B2C4E5DC_1197804340.addTaint(taint);
        return varE8D2AC83E76431FAC265E667B2C4E5DC_1197804340;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.071 -0400", hash_original_method = "ABB46ACB6DF1697743B661541AD5E166", hash_generated_method = "E5E73982EFB5523045E8F14EE46A333A")
    public boolean isPossibleNumber(String number, String regionDialingFrom) {
        addTaint(regionDialingFrom.getTaint());
        addTaint(number.getTaint());
        try 
        {
            boolean var4B1B04BE99C76BD948B631DFB17CC383_1299024541 = (isPossibleNumber(parse(number, regionDialingFrom)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639864645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_639864645;
        } //End block
        catch (NumberParseException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1117179726 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300228869 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_300228869;
        } //End block
        // ---------- Original Method ----------
        //try {
      //return isPossibleNumber(parse(number, regionDialingFrom));
    //} catch (NumberParseException e) {
      //return false;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.071 -0400", hash_original_method = "763BBE034FB297BC9C435FECAC40F4A1", hash_generated_method = "FAC07398C53EE482EAF54426696B89FE")
    public boolean truncateTooLongNumber(PhoneNumber number) {
        addTaint(number.getTaint());
        if(isValidNumber(number))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1817251684 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081857439 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081857439;
        } //End block
        PhoneNumber numberCopy = new PhoneNumber();
        numberCopy.mergeFrom(number);
        long nationalNumber = number.getNationalNumber();
        do {
            {
                nationalNumber /= 10;
                numberCopy.setNationalNumber(nationalNumber);
                if(isPossibleNumberWithReason(numberCopy) == ValidationResult.TOO_SHORT ||
          nationalNumber == 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_812423459 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725628806 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725628806;
                } //End block
            } //End block
} while (!isValidNumber(numberCopy));
        number.setNationalNumber(nationalNumber);
        boolean varB326B5062B2F0E69046810717534CB09_167352263 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456162982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456162982;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.071 -0400", hash_original_method = "719F2F8970F4EB169BEDB2820A702606", hash_generated_method = "4FCDEA15799C0BB89F10E3AD7FD9A8A7")
    public AsYouTypeFormatter getAsYouTypeFormatter(String regionCode) {
        addTaint(regionCode.getTaint());
AsYouTypeFormatter var2BA79AFFF62B3719E707A1AD27F0FC82_1749152475 =         new AsYouTypeFormatter(regionCode);
        var2BA79AFFF62B3719E707A1AD27F0FC82_1749152475.addTaint(taint);
        return var2BA79AFFF62B3719E707A1AD27F0FC82_1749152475;
        // ---------- Original Method ----------
        //return new AsYouTypeFormatter(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.071 -0400", hash_original_method = "2A48039CFC05A878E1A34077CDECE0D5", hash_generated_method = "4490E2A6E329AFC3DB4AC642405D24B7")
     int extractCountryCode(StringBuilder fullNumber, StringBuilder nationalNumber) {
        addTaint(nationalNumber.getTaint());
        addTaint(fullNumber.getTaint());
        int potentialCountryCode;
        int numberLength = fullNumber.length();
for(int i = 1;i <= MAX_LENGTH_COUNTRY_CODE && i <= numberLength;i++)
        {
            potentialCountryCode = Integer.parseInt(fullNumber.substring(0, i));
            if(countryCallingCodeToRegionCodeMap.containsKey(potentialCountryCode))            
            {
                nationalNumber.append(fullNumber.substring(i));
                int varCBDD1E1517859AC26BC5B6DA37C1E9D3_947743657 = (potentialCountryCode);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018705607 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018705607;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1607596925 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113913811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113913811;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.072 -0400", hash_original_method = "8166FB521487034FA9E8BD7575A0612F", hash_generated_method = "D991B9E749A7ACF1056516C758EDB213")
     int maybeExtractCountryCode(String number, PhoneMetadata defaultRegionMetadata,
                              StringBuilder nationalNumber, boolean keepRawInput,
                              PhoneNumber phoneNumber) throws NumberParseException {
        addTaint(phoneNumber.getTaint());
        addTaint(keepRawInput);
        addTaint(nationalNumber.getTaint());
        addTaint(defaultRegionMetadata.getTaint());
        addTaint(number.getTaint());
        if(number.length() == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1122570780 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658254346 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658254346;
        } //End block
        StringBuilder fullNumber = new StringBuilder(number);
        String possibleCountryIddPrefix = "NonMatch";
        if(defaultRegionMetadata != null)        
        {
            possibleCountryIddPrefix = defaultRegionMetadata.getInternationalPrefix();
        } //End block
        CountryCodeSource countryCodeSource = maybeStripInternationalPrefixAndNormalize(fullNumber, possibleCountryIddPrefix);
        if(keepRawInput)        
        {
            phoneNumber.setCountryCodeSource(countryCodeSource);
        } //End block
        if(countryCodeSource != CountryCodeSource.FROM_DEFAULT_COUNTRY)        
        {
            if(fullNumber.length() < MIN_LENGTH_FOR_NSN)            
            {
                NumberParseException var7C4841C97C59AAFC02680741C3C34B73_1912615232 = new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD,
                                       "Phone number had an IDD, but after this was not "
                                       + "long enough to be a viable phone number.");
                var7C4841C97C59AAFC02680741C3C34B73_1912615232.addTaint(taint);
                throw var7C4841C97C59AAFC02680741C3C34B73_1912615232;
            } //End block
            int potentialCountryCode = extractCountryCode(fullNumber, nationalNumber);
            if(potentialCountryCode != 0)            
            {
                phoneNumber.setCountryCode(potentialCountryCode);
                int varCBDD1E1517859AC26BC5B6DA37C1E9D3_2057757086 = (potentialCountryCode);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796741576 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796741576;
            } //End block
            NumberParseException varFACD21D49B60AD7C0022898DA2C8BA5B_774852302 = new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                                     "Country calling code supplied was not recognised.");
            varFACD21D49B60AD7C0022898DA2C8BA5B_774852302.addTaint(taint);
            throw varFACD21D49B60AD7C0022898DA2C8BA5B_774852302;
        } //End block
        else
        if(defaultRegionMetadata != null)        
        {
            int defaultCountryCode = defaultRegionMetadata.getCountryCode();
            String defaultCountryCodeString = String.valueOf(defaultCountryCode);
            String normalizedNumber = fullNumber.toString();
            if(normalizedNumber.startsWith(defaultCountryCodeString))            
            {
                StringBuilder potentialNationalNumber = new StringBuilder(normalizedNumber.substring(defaultCountryCodeString.length()));
                PhoneNumberDesc generalDesc = defaultRegionMetadata.getGeneralDesc();
                Pattern validNumberPattern = regexCache.getPatternForRegex(generalDesc.getNationalNumberPattern());
                maybeStripNationalPrefixAndCarrierCode(potentialNationalNumber, defaultRegionMetadata);
                Pattern possibleNumberPattern = regexCache.getPatternForRegex(generalDesc.getPossibleNumberPattern());
                if((!validNumberPattern.matcher(fullNumber).matches() &&
             validNumberPattern.matcher(potentialNationalNumber).matches()) ||
             testNumberLengthAgainstPattern(possibleNumberPattern, fullNumber.toString())
                  == ValidationResult.TOO_LONG)                
                {
                    nationalNumber.append(potentialNationalNumber);
                    if(keepRawInput)                    
                    {
                        phoneNumber.setCountryCodeSource(CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    } //End block
                    phoneNumber.setCountryCode(defaultCountryCode);
                    int varFE8BB3906981D8F2926AD078CDE4B0A9_803141048 = (defaultCountryCode);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233265700 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233265700;
                } //End block
            } //End block
        } //End block
        phoneNumber.setCountryCode(0);
        int varCFCD208495D565EF66E7DFF9F98764DA_607318238 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276714252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276714252;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.073 -0400", hash_original_method = "0F0B6B28B590A156D8457E403790D50B", hash_generated_method = "875AF8C6E12514EF2EE660CBDE9AA53B")
    private boolean parsePrefixAsIdd(Pattern iddPattern, StringBuilder number) {
        addTaint(number.getTaint());
        addTaint(iddPattern.getTaint());
        Matcher m = iddPattern.matcher(number);
        if(m.lookingAt())        
        {
            int matchEnd = m.end();
            Matcher digitMatcher = CAPTURING_DIGIT_PATTERN.matcher(number.substring(matchEnd));
            if(digitMatcher.find())            
            {
                String normalizedGroup = normalizeDigitsOnly(digitMatcher.group(1));
                if(normalizedGroup.equals("0"))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1299848622 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084006674 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084006674;
                } //End block
            } //End block
            number.delete(0, matchEnd);
            boolean varB326B5062B2F0E69046810717534CB09_1621835612 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024657760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024657760;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1313815822 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_781814100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_781814100;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.073 -0400", hash_original_method = "8865CBB50A1D9F6F8472F699DBF16350", hash_generated_method = "A94226C7DD8EE8719E3C0E5369388382")
     CountryCodeSource maybeStripInternationalPrefixAndNormalize(
      StringBuilder number,
      String possibleIddPrefix) {
        addTaint(possibleIddPrefix.getTaint());
        addTaint(number.getTaint());
        if(number.length() == 0)        
        {
CountryCodeSource var55995CC53F89EB778D19E1C6292C3C82_8334281 =             CountryCodeSource.FROM_DEFAULT_COUNTRY;
            var55995CC53F89EB778D19E1C6292C3C82_8334281.addTaint(taint);
            return var55995CC53F89EB778D19E1C6292C3C82_8334281;
        } //End block
        Matcher m = PLUS_CHARS_PATTERN.matcher(number);
        if(m.lookingAt())        
        {
            number.delete(0, m.end());
            normalize(number);
CountryCodeSource varAE5D515F8AB0107ED0576804AF3A5773_1767206941 =             CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            varAE5D515F8AB0107ED0576804AF3A5773_1767206941.addTaint(taint);
            return varAE5D515F8AB0107ED0576804AF3A5773_1767206941;
        } //End block
        Pattern iddPattern = regexCache.getPatternForRegex(possibleIddPrefix);
        if(parsePrefixAsIdd(iddPattern, number))        
        {
            normalize(number);
CountryCodeSource var8A3B8A2813B34DD9BB5EE31DE4F2BDEA_2012754061 =             CountryCodeSource.FROM_NUMBER_WITH_IDD;
            var8A3B8A2813B34DD9BB5EE31DE4F2BDEA_2012754061.addTaint(taint);
            return var8A3B8A2813B34DD9BB5EE31DE4F2BDEA_2012754061;
        } //End block
        normalize(number);
CountryCodeSource varB7ADE8109FFBEE34E61EFCAB380B652A_826575758 =         parsePrefixAsIdd(iddPattern, number)
           ? CountryCodeSource.FROM_NUMBER_WITH_IDD
           : CountryCodeSource.FROM_DEFAULT_COUNTRY;
        varB7ADE8109FFBEE34E61EFCAB380B652A_826575758.addTaint(taint);
        return varB7ADE8109FFBEE34E61EFCAB380B652A_826575758;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.073 -0400", hash_original_method = "8024CAA7B81A99B980BA01FE387839A1", hash_generated_method = "DD60ED497FAA9E40DF88BF71A5B40B48")
     String maybeStripNationalPrefixAndCarrierCode(StringBuilder number, PhoneMetadata metadata) {
        addTaint(metadata.getTaint());
        addTaint(number.getTaint());
        String carrierCode = "";
        int numberLength = number.length();
        String possibleNationalPrefix = metadata.getNationalPrefixForParsing();
        if(numberLength == 0 || possibleNationalPrefix.length() == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_734545722 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_734545722.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_734545722;
        } //End block
        Matcher prefixMatcher = regexCache.getPatternForRegex(possibleNationalPrefix).matcher(number);
        if(prefixMatcher.lookingAt())        
        {
            Pattern nationalNumberRule = regexCache.getPatternForRegex(metadata.getGeneralDesc().getNationalNumberPattern());
            boolean isViableOriginalNumber = nationalNumberRule.matcher(number).matches();
            int numOfGroups = prefixMatcher.groupCount();
            String transformRule = metadata.getNationalPrefixTransformRule();
            if(transformRule == null || transformRule.length() == 0 ||
          prefixMatcher.group(numOfGroups) == null)            
            {
                if(isViableOriginalNumber &&
            !nationalNumberRule.matcher(number.substring(prefixMatcher.end())).matches())                
                {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_73159000 =                     "";
                    var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_73159000.addTaint(taint);
                    return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_73159000;
                } //End block
                if(numOfGroups > 0 && prefixMatcher.group(numOfGroups) != null)                
                {
                    carrierCode = prefixMatcher.group(1);
                } //End block
                number.delete(0, prefixMatcher.end());
            } //End block
            else
            {
                StringBuilder transformedNumber = new StringBuilder(number);
                transformedNumber.replace(0, numberLength, prefixMatcher.replaceFirst(transformRule));
                if(isViableOriginalNumber &&
            !nationalNumberRule.matcher(transformedNumber.toString()).matches())                
                {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1614303460 =                     "";
                    var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1614303460.addTaint(taint);
                    return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1614303460;
                } //End block
                if(numOfGroups > 1)                
                {
                    carrierCode = prefixMatcher.group(1);
                } //End block
                number.replace(0, number.length(), transformedNumber.toString());
            } //End block
        } //End block
String var11F797CD50213A512D32FF93510BFF1B_742463984 =         carrierCode;
        var11F797CD50213A512D32FF93510BFF1B_742463984.addTaint(taint);
        return var11F797CD50213A512D32FF93510BFF1B_742463984;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.074 -0400", hash_original_method = "D072FBB7A4080E317A5210E0DF61655A", hash_generated_method = "4D9A276FCAC7B360C26BF2C8F956EA26")
     String maybeStripExtension(StringBuilder number) {
        addTaint(number.getTaint());
        Matcher m = EXTN_PATTERN.matcher(number);
        if(m.find() && isViablePhoneNumber(number.substring(0, m.start())))        
        {
for(int i = 1, length = m.groupCount();i <= length;i++)
            {
                if(m.group(i) != null)                
                {
                    String extension = m.group(i);
                    number.delete(m.start(), number.length());
String varB66922909010E86F6C51FD3DA400DECB_1462493861 =                     extension;
                    varB66922909010E86F6C51FD3DA400DECB_1462493861.addTaint(taint);
                    return varB66922909010E86F6C51FD3DA400DECB_1462493861;
                } //End block
            } //End block
        } //End block
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_174694629 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_174694629.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_174694629;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.074 -0400", hash_original_method = "E1BA4484CA3B538698D9E39D9664F7DD", hash_generated_method = "B8FE5281EB4BDEB0484A185621737AA0")
    private boolean checkRegionForParsing(String numberToParse, String defaultRegion) {
        addTaint(defaultRegion.getTaint());
        addTaint(numberToParse.getTaint());
        if(!isValidRegionCode(defaultRegion))        
        {
            if(numberToParse == null || numberToParse.length() == 0 ||
          !PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1506601219 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771127812 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_771127812;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_395381211 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1848624073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1848624073;
        // ---------- Original Method ----------
        //if (!isValidRegionCode(defaultRegion)) {
      //if (numberToParse == null || numberToParse.length() == 0 ||
          //!PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt()) {
        //return false;
      //}
    //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.074 -0400", hash_original_method = "6012972DF706A584D5C83C6971CF9392", hash_generated_method = "6AF2E42B31E4F7EFD66968A9AA885614")
    public PhoneNumber parse(String numberToParse, String defaultRegion) throws NumberParseException {
        addTaint(defaultRegion.getTaint());
        addTaint(numberToParse.getTaint());
        PhoneNumber phoneNumber = new PhoneNumber();
        parse(numberToParse, defaultRegion, phoneNumber);
PhoneNumber var80A2B48412D7084FC222C283D090147C_727799162 =         phoneNumber;
        var80A2B48412D7084FC222C283D090147C_727799162.addTaint(taint);
        return var80A2B48412D7084FC222C283D090147C_727799162;
        // ---------- Original Method ----------
        //PhoneNumber phoneNumber = new PhoneNumber();
        //parse(numberToParse, defaultRegion, phoneNumber);
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.075 -0400", hash_original_method = "6ECDB36C19DB49774718F5C4BA94B539", hash_generated_method = "B80A11162B75AC3A1A7BCA4C170B6651")
    public void parse(String numberToParse, String defaultRegion, PhoneNumber phoneNumber) throws NumberParseException {
        addTaint(phoneNumber.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(numberToParse.getTaint());
        parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
        // ---------- Original Method ----------
        //parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.075 -0400", hash_original_method = "19CBF359D0DD4BA30476F5C26D54CCE4", hash_generated_method = "0397C0E7642E1AE4CD6F0B716DDCE046")
    public PhoneNumber parseAndKeepRawInput(String numberToParse, String defaultRegion) throws NumberParseException {
        addTaint(defaultRegion.getTaint());
        addTaint(numberToParse.getTaint());
        PhoneNumber phoneNumber = new PhoneNumber();
        parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
PhoneNumber var80A2B48412D7084FC222C283D090147C_1951126294 =         phoneNumber;
        var80A2B48412D7084FC222C283D090147C_1951126294.addTaint(taint);
        return var80A2B48412D7084FC222C283D090147C_1951126294;
        // ---------- Original Method ----------
        //PhoneNumber phoneNumber = new PhoneNumber();
        //parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.075 -0400", hash_original_method = "56F5D9940BB01A0D66986596B5A9CF6E", hash_generated_method = "93230E90F67038FDB64A35A94CB61E5A")
    public void parseAndKeepRawInput(String numberToParse, String defaultRegion,
                                   PhoneNumber phoneNumber) throws NumberParseException {
        addTaint(phoneNumber.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(numberToParse.getTaint());
        parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
        // ---------- Original Method ----------
        //parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.075 -0400", hash_original_method = "FC749C2F4DF483D491476DD9FB58E6D5", hash_generated_method = "E0276D50B1AB408EA26005B9EBE3993C")
    public Iterable<PhoneNumberMatch> findNumbers(CharSequence text, String defaultRegion) {
        addTaint(defaultRegion.getTaint());
        addTaint(text.getTaint());
Iterable<PhoneNumberMatch> var1BC109E3A5A41FD4CBF09A5B341E099A_938001089 =         findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
        var1BC109E3A5A41FD4CBF09A5B341E099A_938001089.addTaint(taint);
        return var1BC109E3A5A41FD4CBF09A5B341E099A_938001089;
        // ---------- Original Method ----------
        //return findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.075 -0400", hash_original_method = "C3E745E72AE45D5E83FFDE500327E040", hash_generated_method = "31C11C291B8B80F1055F91BD105B4E94")
    public Iterable<PhoneNumberMatch> findNumbers(
      final CharSequence text, final String defaultRegion, final Leniency leniency,
      final long maxTries) {
        addTaint(maxTries);
        addTaint(leniency.getTaint());
        addTaint(defaultRegion.getTaint());
        addTaint(text.getTaint());
Iterable<PhoneNumberMatch> var9921D7755FEA661B7C23FE39DD920A7B_2121156272 =         new Iterable<PhoneNumberMatch>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.075 -0400", hash_original_method = "56A258F03FBDE6DC55F7DBEB97F457DD", hash_generated_method = "D32F911BD81AA4BFFF34495658436F45")
        public Iterator<PhoneNumberMatch> iterator() {
Iterator<PhoneNumberMatch> varB9615163DC6439272CE369ABE0A4A903_1881822500 =             new PhoneNumberMatcher(
            PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
            varB9615163DC6439272CE369ABE0A4A903_1881822500.addTaint(taint);
            return varB9615163DC6439272CE369ABE0A4A903_1881822500;
            // ---------- Original Method ----------
            //return new PhoneNumberMatcher(
            //PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
        }
};
        var9921D7755FEA661B7C23FE39DD920A7B_2121156272.addTaint(taint);
        return var9921D7755FEA661B7C23FE39DD920A7B_2121156272;
        // ---------- Original Method ----------
        //return new Iterable<PhoneNumberMatch>() {
      //public Iterator<PhoneNumberMatch> iterator() {
        //return new PhoneNumberMatcher(
            //PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
      //}
    //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.077 -0400", hash_original_method = "B3135DA9F7C362E965D50679AE934189", hash_generated_method = "0FED56FABF70E689F710A485E8C3329E")
    private void parseHelper(String numberToParse, String defaultRegion, boolean keepRawInput,
                           boolean checkRegion, PhoneNumber phoneNumber) throws NumberParseException {
        addTaint(phoneNumber.getTaint());
        addTaint(checkRegion);
        addTaint(keepRawInput);
        addTaint(defaultRegion.getTaint());
        addTaint(numberToParse.getTaint());
        if(numberToParse == null)        
        {
            NumberParseException varED8021B5632E339A5631B5300D3DF3A7_1913142221 = new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The phone number supplied was null.");
            varED8021B5632E339A5631B5300D3DF3A7_1913142221.addTaint(taint);
            throw varED8021B5632E339A5631B5300D3DF3A7_1913142221;
        } //End block
        String number = extractPossibleNumber(numberToParse);
        if(!isViablePhoneNumber(number))        
        {
            NumberParseException var602691BEEF760CD775F3C79EB0FF3F72_639228183 = new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The string supplied did not seem to be a phone number.");
            var602691BEEF760CD775F3C79EB0FF3F72_639228183.addTaint(taint);
            throw var602691BEEF760CD775F3C79EB0FF3F72_639228183;
        } //End block
        if(checkRegion && !checkRegionForParsing(number, defaultRegion))        
        {
            NumberParseException var02CD777456BB17D95E81DFD2AAF92397_188747765 = new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                                     "Missing or invalid default region.");
            var02CD777456BB17D95E81DFD2AAF92397_188747765.addTaint(taint);
            throw var02CD777456BB17D95E81DFD2AAF92397_188747765;
        } //End block
        if(keepRawInput)        
        {
            phoneNumber.setRawInput(numberToParse);
        } //End block
        StringBuilder nationalNumber = new StringBuilder(number);
        String extension = maybeStripExtension(nationalNumber);
        if(extension.length() > 0)        
        {
            phoneNumber.setExtension(extension);
        } //End block
        PhoneMetadata regionMetadata = getMetadataForRegion(defaultRegion);
        StringBuilder normalizedNationalNumber = new StringBuilder();
        int countryCode = maybeExtractCountryCode(nationalNumber.toString(), regionMetadata,
                                              normalizedNationalNumber, keepRawInput, phoneNumber);
        if(countryCode != 0)        
        {
            String phoneNumberRegion = getRegionCodeForCountryCode(countryCode);
            if(!phoneNumberRegion.equals(defaultRegion))            
            {
                regionMetadata = getMetadataForRegion(phoneNumberRegion);
            } //End block
        } //End block
        else
        {
            normalize(nationalNumber);
            normalizedNationalNumber.append(nationalNumber);
            if(defaultRegion != null)            
            {
                countryCode = regionMetadata.getCountryCode();
                phoneNumber.setCountryCode(countryCode);
            } //End block
            else
            if(keepRawInput)            
            {
                phoneNumber.clearCountryCodeSource();
            } //End block
        } //End block
        if(normalizedNationalNumber.length() < MIN_LENGTH_FOR_NSN)        
        {
            NumberParseException var7D26D6C0377A1427448ACEA5447A911F_790052002 = new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
            var7D26D6C0377A1427448ACEA5447A911F_790052002.addTaint(taint);
            throw var7D26D6C0377A1427448ACEA5447A911F_790052002;
        } //End block
        if(regionMetadata != null)        
        {
            String carrierCode = maybeStripNationalPrefixAndCarrierCode(normalizedNationalNumber, regionMetadata);
            if(keepRawInput)            
            {
                phoneNumber.setPreferredDomesticCarrierCode(carrierCode);
            } //End block
        } //End block
        int lengthOfNationalNumber = normalizedNationalNumber.length();
        if(lengthOfNationalNumber < MIN_LENGTH_FOR_NSN)        
        {
            NumberParseException var7D26D6C0377A1427448ACEA5447A911F_404701163 = new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
            var7D26D6C0377A1427448ACEA5447A911F_404701163.addTaint(taint);
            throw var7D26D6C0377A1427448ACEA5447A911F_404701163;
        } //End block
        if(lengthOfNationalNumber > MAX_LENGTH_FOR_NSN)        
        {
            NumberParseException varEA7354D93BACA86F8D35FC3E5A2E8634_1635042305 = new NumberParseException(NumberParseException.ErrorType.TOO_LONG,
                                     "The string supplied is too long to be a phone number.");
            varEA7354D93BACA86F8D35FC3E5A2E8634_1635042305.addTaint(taint);
            throw varEA7354D93BACA86F8D35FC3E5A2E8634_1635042305;
        } //End block
        if(normalizedNationalNumber.charAt(0) == '0')        
        {
            phoneNumber.setItalianLeadingZero(true);
        } //End block
        phoneNumber.setNationalNumber(Long.parseLong(normalizedNationalNumber.toString()));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.079 -0400", hash_original_method = "83C8E6F8520B32A4B2A265A569BAF2C9", hash_generated_method = "74C65B119290A314144A03BFD73B62DF")
    public MatchType isNumberMatch(PhoneNumber firstNumberIn, PhoneNumber secondNumberIn) {
        addTaint(secondNumberIn.getTaint());
        addTaint(firstNumberIn.getTaint());
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
        if(firstNumber.hasExtension() &&
        firstNumber.getExtension().length() == 0)        
        {
            firstNumber.clearExtension();
        } //End block
        if(secondNumber.hasExtension() &&
        secondNumber.getExtension().length() == 0)        
        {
            secondNumber.clearExtension();
        } //End block
        if(firstNumber.hasExtension() && secondNumber.hasExtension() &&
        !firstNumber.getExtension().equals(secondNumber.getExtension()))        
        {
MatchType varBB3E55B2BDC8BE4834676607A9C4DE63_697033608 =             MatchType.NO_MATCH;
            varBB3E55B2BDC8BE4834676607A9C4DE63_697033608.addTaint(taint);
            return varBB3E55B2BDC8BE4834676607A9C4DE63_697033608;
        } //End block
        int firstNumberCountryCode = firstNumber.getCountryCode();
        int secondNumberCountryCode = secondNumber.getCountryCode();
        if(firstNumberCountryCode != 0 && secondNumberCountryCode != 0)        
        {
            if(firstNumber.exactlySameAs(secondNumber))            
            {
MatchType var9AADDC68852A1DEE261B02A434487C75_1226744491 =                 MatchType.EXACT_MATCH;
                var9AADDC68852A1DEE261B02A434487C75_1226744491.addTaint(taint);
                return var9AADDC68852A1DEE261B02A434487C75_1226744491;
            } //End block
            else
            if(firstNumberCountryCode == secondNumberCountryCode &&
                 isNationalNumberSuffixOfTheOther(firstNumber, secondNumber))            
            {
MatchType varB16E3010269D31EAF47EAEC316278ADC_1074202430 =                 MatchType.SHORT_NSN_MATCH;
                varB16E3010269D31EAF47EAEC316278ADC_1074202430.addTaint(taint);
                return varB16E3010269D31EAF47EAEC316278ADC_1074202430;
            } //End block
MatchType varBB3E55B2BDC8BE4834676607A9C4DE63_1770645994 =             MatchType.NO_MATCH;
            varBB3E55B2BDC8BE4834676607A9C4DE63_1770645994.addTaint(taint);
            return varBB3E55B2BDC8BE4834676607A9C4DE63_1770645994;
        } //End block
        firstNumber.setCountryCode(secondNumberCountryCode);
        if(firstNumber.exactlySameAs(secondNumber))        
        {
MatchType var1ED5497128CE5525FFC0DD8A4FCB62C9_923623736 =             MatchType.NSN_MATCH;
            var1ED5497128CE5525FFC0DD8A4FCB62C9_923623736.addTaint(taint);
            return var1ED5497128CE5525FFC0DD8A4FCB62C9_923623736;
        } //End block
        if(isNationalNumberSuffixOfTheOther(firstNumber, secondNumber))        
        {
MatchType varB16E3010269D31EAF47EAEC316278ADC_375989619 =             MatchType.SHORT_NSN_MATCH;
            varB16E3010269D31EAF47EAEC316278ADC_375989619.addTaint(taint);
            return varB16E3010269D31EAF47EAEC316278ADC_375989619;
        } //End block
MatchType varBB3E55B2BDC8BE4834676607A9C4DE63_124738268 =         MatchType.NO_MATCH;
        varBB3E55B2BDC8BE4834676607A9C4DE63_124738268.addTaint(taint);
        return varBB3E55B2BDC8BE4834676607A9C4DE63_124738268;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.080 -0400", hash_original_method = "B2A134716BB483331B78911F7265BAC6", hash_generated_method = "29158BC2638076556BA9A57BF44D5226")
    private boolean isNationalNumberSuffixOfTheOther(PhoneNumber firstNumber,
                                                   PhoneNumber secondNumber) {
        addTaint(secondNumber.getTaint());
        addTaint(firstNumber.getTaint());
        String firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
        String secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
        boolean varF661F1721074F9F340385202AD151C94_169905739 = (firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           secondNumberNationalNumber.endsWith(firstNumberNationalNumber));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708877045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708877045;
        // ---------- Original Method ----------
        //String firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
        //String secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
        //return firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           //secondNumberNationalNumber.endsWith(firstNumberNationalNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.080 -0400", hash_original_method = "3C9E8BD2D7E8FA6C3BECA5B02E481416", hash_generated_method = "07DBD826E5562489E42C7091E9C9A19A")
    public MatchType isNumberMatch(String firstNumber, String secondNumber) {
        addTaint(secondNumber.getTaint());
        addTaint(firstNumber.getTaint());
        try 
        {
            PhoneNumber firstNumberAsProto = parse(firstNumber, UNKNOWN_REGION);
MatchType varF40366540DEF25F8BD17EEC320370008_724871361 =             isNumberMatch(firstNumberAsProto, secondNumber);
            varF40366540DEF25F8BD17EEC320370008_724871361.addTaint(taint);
            return varF40366540DEF25F8BD17EEC320370008_724871361;
        } //End block
        catch (NumberParseException e)
        {
            if(e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE)            
            {
                try 
                {
                    PhoneNumber secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
MatchType varFE5C3CCEEF8305AD163CB737A57FBA64_1625126695 =                     isNumberMatch(secondNumberAsProto, firstNumber);
                    varFE5C3CCEEF8305AD163CB737A57FBA64_1625126695.addTaint(taint);
                    return varFE5C3CCEEF8305AD163CB737A57FBA64_1625126695;
                } //End block
                catch (NumberParseException e2)
                {
                    if(e2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE)                    
                    {
                        try 
                        {
                            PhoneNumber firstNumberProto = new PhoneNumber();
                            PhoneNumber secondNumberProto = new PhoneNumber();
                            parseHelper(firstNumber, null, false, false, firstNumberProto);
                            parseHelper(secondNumber, null, false, false, secondNumberProto);
MatchType varFAF9A68E83CC22CA9E339A4C177EA861_2102753819 =                             isNumberMatch(firstNumberProto, secondNumberProto);
                            varFAF9A68E83CC22CA9E339A4C177EA861_2102753819.addTaint(taint);
                            return varFAF9A68E83CC22CA9E339A4C177EA861_2102753819;
                        } //End block
                        catch (NumberParseException e3)
                        {
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
MatchType varF8B37F0B3552FBDB2D5C6D7C966D0BA0_927901273 =         MatchType.NOT_A_NUMBER;
        varF8B37F0B3552FBDB2D5C6D7C966D0BA0_927901273.addTaint(taint);
        return varF8B37F0B3552FBDB2D5C6D7C966D0BA0_927901273;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.080 -0400", hash_original_method = "FA442F82D618375A0E3FFC54DA76D9E3", hash_generated_method = "544878F756B60C40EABA12CF0BF33C51")
    public MatchType isNumberMatch(PhoneNumber firstNumber, String secondNumber) {
        addTaint(secondNumber.getTaint());
        addTaint(firstNumber.getTaint());
        try 
        {
            PhoneNumber secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
MatchType var888BD6CF6E27C25A9CC5D2C7F3168863_1421415844 =             isNumberMatch(firstNumber, secondNumberAsProto);
            var888BD6CF6E27C25A9CC5D2C7F3168863_1421415844.addTaint(taint);
            return var888BD6CF6E27C25A9CC5D2C7F3168863_1421415844;
        } //End block
        catch (NumberParseException e)
        {
            if(e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE)            
            {
                String firstNumberRegion = getRegionCodeForCountryCode(firstNumber.getCountryCode());
                try 
                {
                    if(!firstNumberRegion.equals(UNKNOWN_REGION))                    
                    {
                        PhoneNumber secondNumberWithFirstNumberRegion = parse(secondNumber, firstNumberRegion);
                        MatchType match = isNumberMatch(firstNumber, secondNumberWithFirstNumberRegion);
                        if(match == MatchType.EXACT_MATCH)                        
                        {
MatchType var1ED5497128CE5525FFC0DD8A4FCB62C9_581556607 =                             MatchType.NSN_MATCH;
                            var1ED5497128CE5525FFC0DD8A4FCB62C9_581556607.addTaint(taint);
                            return var1ED5497128CE5525FFC0DD8A4FCB62C9_581556607;
                        } //End block
MatchType varED81284B0460DBAE2301CCD33AC92E85_1271067490 =                         match;
                        varED81284B0460DBAE2301CCD33AC92E85_1271067490.addTaint(taint);
                        return varED81284B0460DBAE2301CCD33AC92E85_1271067490;
                    } //End block
                    else
                    {
                        PhoneNumber secondNumberProto = new PhoneNumber();
                        parseHelper(secondNumber, null, false, false, secondNumberProto);
MatchType varB5B2FCC25A87D9B318DDA916BFBD3C46_834334261 =                         isNumberMatch(firstNumber, secondNumberProto);
                        varB5B2FCC25A87D9B318DDA916BFBD3C46_834334261.addTaint(taint);
                        return varB5B2FCC25A87D9B318DDA916BFBD3C46_834334261;
                    } //End block
                } //End block
                catch (NumberParseException e2)
                {
                } //End block
            } //End block
        } //End block
MatchType varF8B37F0B3552FBDB2D5C6D7C966D0BA0_1129257199 =         MatchType.NOT_A_NUMBER;
        varF8B37F0B3552FBDB2D5C6D7C966D0BA0_1129257199.addTaint(taint);
        return varF8B37F0B3552FBDB2D5C6D7C966D0BA0_1129257199;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.081 -0400", hash_original_method = "93167700613734CAFA37F508460EB7E3", hash_generated_method = "696A95D926BE92DF6D03557B698CCC2A")
     boolean canBeInternationallyDialled(PhoneNumber number) {
        addTaint(number.getTaint());
        String regionCode = getRegionCodeForNumber(number);
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if(!hasValidRegionCode(regionCode, number.getCountryCode(), nationalSignificantNumber))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1539595021 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116183924 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116183924;
        } //End block
        PhoneMetadata metadata = getMetadataForRegion(regionCode);
        boolean var3D01D7B78557BF5CDA20B17F5750558F_1459692398 = (!isNumberMatchingDesc(nationalSignificantNumber, metadata.getNoInternationalDialling()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955241972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955241972;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "EB11CC0E8A96949DB43176717E336CDD", hash_generated_field = "56358BB2B93B97106608814280D6666E")

    static final int REGEX_FLAGS = Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "9E0E53DE18A8BA7B34AFC44B3D12F966", hash_generated_field = "78162C39327AD811876D6287CE97DE9A")

    private static final int MIN_LENGTH_FOR_NSN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "B7B16DDA7E8A51EB6956979657455D74", hash_generated_field = "9FB78E1175F6C9C6A8605B6EDAA89F3A")

    static final int MAX_LENGTH_FOR_NSN = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "05AAEEE35BFA26C060E9E538DC8A8A9A", hash_generated_field = "B536601172E5FEA598125C5319675976")

    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "1A0EC0F17D75886D68FE0D60D02E7405", hash_generated_field = "1AB5B395372E5B768BCBBA5C4037C039")

    static final String META_DATA_FILE_PREFIX = "/com/android/i18n/phonenumbers/data/PhoneNumberMetadataProto";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "A1E873C259FA0CABBD0C9F71C2073DFA", hash_generated_field = "EE197B49B9DBA77F840ACF7281744106")

    private static final Logger LOGGER = Logger.getLogger(PhoneNumberUtil.class.getName());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "884BE42B71C8AFCCDFE2F81DD7984AEC", hash_generated_field = "37E07E112B24C23DECA9CE91C20C0533")

    private static final String UNKNOWN_REGION = "ZZ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "165C3547A5B97982AD01C097E4AB5E6F", hash_generated_field = "3781137D5EFBC743F6AF42421A78AAB0")

    private static final int NANPA_COUNTRY_CODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "3B32202ED9382EE062B7ADF2582F4E22", hash_generated_field = "DB0682C1F895DEC76B13EE471B2B2AAB")

    static final char PLUS_SIGN = '+';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "5E538434F72E6A54DF5E9589E388BB2A", hash_generated_field = "0D4345D843431079FA3A87145DDC0F83")

    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "61274886CC209D383752DF2C4E45019A", hash_generated_field = "AC50CA36F96F68F3E68F8306B67F17A6")

    private static Map<Character, Character> ALPHA_MAPPINGS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "A687A96E121E0460B5D23B2EB5227386", hash_generated_field = "6540E96DA6A170C8F59559A1CA13BA85")

    private static Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "33227356DEF684B5B69E6F1BC1B64C04", hash_generated_field = "8BA2CD3F690AB362D76BB15FA383BE12")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "B8EB3CEE9DCE9972530AFEAA48801022", hash_generated_field = "FB90ED7A2BC1A696297198B465C4CDF9")

    private static final Pattern UNIQUE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~\u2053\u223C\uFF5E][\\d]+)?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "95E7EE317F57B907866F30266B1172FE", hash_generated_field = "3544A2A0AB9952075D7051B48C75E415")

    static final String VALID_PUNCTUATION = "-x\u2010-\u2015\u2212\u30FC\uFF0D-\uFF0F " +
      "\u00A0\u200B\u2060\u3000()\uFF08\uFF09\uFF3B\uFF3D.\\[\\]/~\u2053\u223C\uFF5E";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "1A64355EF67E8035AEBC5332495B29C2", hash_generated_field = "711CAD69779EE34D5918FEE07224547C")

    private static final String DIGITS = "\\p{Nd}";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "B53AD5BC99FF6E99B2013691434E5AE0", hash_generated_field = "8C02DF099CE2D84C3EB4B1BAFB9529C4")

    private static final String VALID_ALPHA = Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", "") +
      Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "CDAC17B00A8EFF3BB0A83D83D11A2136", hash_generated_field = "7AA5C25A8B485E30A73BF5904752D094")

    static final String PLUS_CHARS = "+\uFF0B";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "E58FEF7945499412B1D8834E7B62FDFC", hash_generated_field = "401A10BEE2C1F4B3E23F174296449756")

    static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[" + PLUS_CHARS + "]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "9733A99E32EE6D850D49F03364042404", hash_generated_field = "A769130D6DB113058C6FB971BC0E9EE8")

    private static final Pattern SEPARATOR_PATTERN = Pattern.compile("[" + VALID_PUNCTUATION + "]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.082 -0400", hash_original_field = "0F0E7FFB40A9BBB6394BA2DC9D119A3E", hash_generated_field = "B9B6B3DB4626D33FCBE2CDF6FFFC1DF0")

    private static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(" + DIGITS + ")");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.083 -0400", hash_original_field = "7199DD487DD791E45C5E7ADA312C66FE", hash_generated_field = "8F354CEFF122C1734C5C5F0D756A5700")

    private static final String VALID_START_CHAR = "[" + PLUS_CHARS + DIGITS + "]";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.083 -0400", hash_original_field = "42974F132ECB34AE7B99307A1FB781B7", hash_generated_field = "5445004A965BB01D6385471341B37DC8")

    private static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.083 -0400", hash_original_field = "DF9A27A84A3B17E686546336F0E7DF17", hash_generated_field = "2972DC4B313E34CACAF4F97B2A318C7A")

    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.083 -0400", hash_original_field = "C63F4B685DE4C61316AE5B057C736F03", hash_generated_field = "1E52F9393C161A1B744DE8FBB2E11684")

    static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.083 -0400", hash_original_field = "9667044B078641F8136071D75237A26F", hash_generated_field = "1CAD8A5902F3CA177EE1ABE98BFC8985")

    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.083 -0400", hash_original_field = "3DE86B68F07EA4A22C07DE9AD7D1B843", hash_generated_field = "FB0CEF5E0208B9E75B56CCBEC3289130")

    static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.083 -0400", hash_original_field = "388E04BE9AE1682582E63208038A1441", hash_generated_field = "26B4C5D56FB4163FA672A06569A620EE")

    private static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "CFEAF1E44D986ABA68F85334B1721286", hash_generated_field = "61F58DD7A6FF0B7D647CD39920730CF2")

    private static final String VALID_PHONE_NUMBER = "[" + PLUS_CHARS + "]*(?:[" + VALID_PUNCTUATION + "]*" + DIGITS + "){3,}[" +
      VALID_PUNCTUATION + VALID_ALPHA + DIGITS + "]*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "D366A52A3A38CAB7A724B2F5FB251375", hash_generated_field = "D9A9DBC3927C0338AFC6B147AB3D683E")

    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "0196836C4DD5E6CC55770577EA98447B", hash_generated_field = "2D03BDC1FC6227A7A728133D9442643D")

    private static final String CAPTURING_EXTN_DIGITS = "(" + DIGITS + "{1,7})";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "A5DCAE8D232697D3B884F219BE6B2609", hash_generated_field = "3CBD86B8E6DD6E504D2DA4A1A75D3950")

    private static String EXTN_PATTERNS_FOR_PARSING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "09EF60EAE97616A471FBE501F4663001", hash_generated_field = "8AEC46C66A511C8270E50678714A3A2B")

    static String EXTN_PATTERNS_FOR_MATCHING;
    static {
    String singleExtnSymbolsForMatching = "x\uFF58#\uFF03~\uFF5E";
    String singleExtnSymbolsForParsing = "," + singleExtnSymbolsForMatching;
    EXTN_PATTERNS_FOR_PARSING = createExtnPattern(singleExtnSymbolsForParsing);
    EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(singleExtnSymbolsForMatching);
  }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "FB4CC22DAA10D4F465BC655E6188170A", hash_generated_field = "8452AC9CEA3E604270B031D1546941FC")

    private static final Pattern EXTN_PATTERN = Pattern.compile("(?:" + EXTN_PATTERNS_FOR_PARSING + ")$", REGEX_FLAGS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "ED5EA621ABE5320A1C34DBAD53D0A061", hash_generated_field = "8689C6F1B7C9FD8CC2152596A70CBA25")

    private static final Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile(VALID_PHONE_NUMBER + "(?:" + EXTN_PATTERNS_FOR_PARSING + ")?", REGEX_FLAGS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "4AE14BB5F2520F4E3FF1E5D12782356E", hash_generated_field = "FC9AE1E47D90D61831285D6FD294822D")

    private static final Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "CD953C1DEE4ADD552C476477C6EADD8A", hash_generated_field = "65DF000688AF80A40597848985B3362C")

    private static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "3D193ACEBF04669BC83D13231DAB8702", hash_generated_field = "76DFAE47B27AFFA44F784EF45ADDE2F5")

    private static final Pattern NP_PATTERN = Pattern.compile("\\$NP");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "A03C277F3A7F8A20EA0B481820598B2A", hash_generated_field = "D09CBC3025CAAF7951C4B16225B988EE")

    private static final Pattern FG_PATTERN = Pattern.compile("\\$FG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "DE10DE8A40C3C1EC916E7B66F64ABD87", hash_generated_field = "35A2F87A120AD2F2C401B83B05F83EA2")

    private static final Pattern CC_PATTERN = Pattern.compile("\\$CC");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.084 -0400", hash_original_field = "A81ED48CF13BC1CB56AE4320709DE841", hash_generated_field = "90932A776869C6233A72E88783493EDF")

    private static PhoneNumberUtil instance = null;
}

