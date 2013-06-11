package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final int REGEX_FLAGS = Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE;
    private static final int MIN_LENGTH_FOR_NSN = 3;
    static final int MAX_LENGTH_FOR_NSN = 15;
    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    static final String META_DATA_FILE_PREFIX =
      "/com/android/i18n/phonenumbers/data/PhoneNumberMetadataProto";
    private String currentFilePrefix = META_DATA_FILE_PREFIX;
    private static final Logger LOGGER = Logger.getLogger(PhoneNumberUtil.class.getName());
    private Map<Integer, List<String>> countryCallingCodeToRegionCodeMap = null;
    private final Set<String> supportedRegions = new HashSet<String>(300);
    private static final String UNKNOWN_REGION = "ZZ";
    private final Set<String> nanpaRegions = new HashSet<String>(35);
    private static final int NANPA_COUNTRY_CODE = 1;
    static final char PLUS_SIGN = '+';
    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Pattern UNIQUE_INTERNATIONAL_PREFIX =
      Pattern.compile("[\\d]+(?:[~\u2053\u223C\uFF5E][\\d]+)?");
    static final String VALID_PUNCTUATION = "-x\u2010-\u2015\u2212\u30FC\uFF0D-\uFF0F " +
      "\u00A0\u200B\u2060\u3000()\uFF08\uFF09\uFF3B\uFF3D.\\[\\]/~\u2053\u223C\uFF5E";
    private static final String DIGITS = "\\p{Nd}";
    private static final String VALID_ALPHA =
      Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", "") +
      Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "");
    static final String PLUS_CHARS = "+\uFF0B";
    static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[" + PLUS_CHARS + "]+");
    private static final Pattern SEPARATOR_PATTERN = Pattern.compile("[" + VALID_PUNCTUATION + "]+");
    private static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(" + DIGITS + ")");
    private static final String VALID_START_CHAR = "[" + PLUS_CHARS + DIGITS + "]";
    private static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
    private static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String VALID_PHONE_NUMBER =
      "[" + PLUS_CHARS + "]*(?:[" + VALID_PUNCTUATION + "]*" + DIGITS + "){3,}[" +
      VALID_PUNCTUATION + VALID_ALPHA + DIGITS + "]*";
    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    private static final String CAPTURING_EXTN_DIGITS = "(" + DIGITS + "{1,7})";
    private static final String EXTN_PATTERNS_FOR_PARSING;
    static final String EXTN_PATTERNS_FOR_MATCHING;
    private static final Pattern EXTN_PATTERN =
      Pattern.compile("(?:" + EXTN_PATTERNS_FOR_PARSING + ")$", REGEX_FLAGS);
    private static final Pattern VALID_PHONE_NUMBER_PATTERN =
      Pattern.compile(VALID_PHONE_NUMBER + "(?:" + EXTN_PATTERNS_FOR_PARSING + ")?", REGEX_FLAGS);
    private static final Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
    private static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    private static final Pattern NP_PATTERN = Pattern.compile("\\$NP");
    private static final Pattern FG_PATTERN = Pattern.compile("\\$FG");
    private static final Pattern CC_PATTERN = Pattern.compile("\\$CC");
    private static PhoneNumberUtil instance = null;
    private final Map<String, PhoneMetadata> regionToMetadataMap =
      Collections.synchronizedMap(new HashMap<String, PhoneMetadata>());
    private RegexCache regexCache = new RegexCache(100);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.364 -0400", hash_original_method = "3DBAF8008FFD9E53011E9436972AF77A", hash_generated_method = "F4D56E1C0D1F4D348468201DC82048FE")
    @DSModeled(DSC.SAFE)
    private PhoneNumberUtil() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.364 -0400", hash_original_method = "F3F9C9A4CAA5DAE3DB959030B6EDB840", hash_generated_method = "F40FBC3A12F10F6CCD163EE689714F0F")
    private static String createExtnPattern(String singleExtnSymbols) {
        return (RFC3966_EXTN_PREFIX + CAPTURING_EXTN_DIGITS + "|" + "[ \u00A0\\t,]*" +
            "(?:ext(?:ensi(?:o\u0301?|\u00F3))?n?|\uFF45\uFF58\uFF54\uFF4E?|" +
            "[" + singleExtnSymbols + "]|int|anexo|\uFF49\uFF4E\uFF54)" +
            "[:\\.\uFF0E]?[ \u00A0\\t,-]*" + CAPTURING_EXTN_DIGITS + "#?|" +
            "[- ]+(" + DIGITS + "{1,5})#");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.364 -0400", hash_original_method = "E42A7007FDB19817C28C648F3339DD4F", hash_generated_method = "DC171414F7EA73BBE03681EBA6BB5A9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(String filePrefix) {
        dsTaint.addTaint(filePrefix);
        {
            Iterator<List<String>> seatecAstronomy42 = countryCallingCodeToRegionCodeMap.values().iterator();
            seatecAstronomy42.hasNext();
            List<String> regionCodes = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "D4A5DED95C2EE22965F522507C270AF5", hash_generated_method = "767212976CC2E1C55214C8EF97DB354B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadMetadataForRegionFromFile(String filePrefix, String regionCode) {
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(filePrefix);
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
                Iterator<PhoneMetadata> seatecAstronomy42 = metadataCollection.getMetadataList().iterator();
                seatecAstronomy42.hasNext();
                PhoneMetadata metadata = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "A1113EBAB3D0682FE612F1231142344C", hash_generated_method = "6C806EA8FEC443B1F4A873495286BC59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void close(InputStream in) {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "D818734C49CD12D5628ABEAEEDEC1994", hash_generated_method = "B63D2E0C3768F02603E6ECB8400B3275")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "F8B1494236C94478C90C2AF36B5BB0DF", hash_generated_method = "B8626553B4904FE523436AA8BCB044F6")
    static boolean isViablePhoneNumber(String number) {
        if (number.length() < MIN_LENGTH_FOR_NSN) {
      return false;
    }
        Matcher m = VALID_PHONE_NUMBER_PATTERN.matcher(number);
        return m.matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "B852DEDF2BEDB6040A8893210C30801F", hash_generated_method = "79B9C6D2D5970971739C153D034DB073")
    static String normalize(String number) {
        Matcher m = VALID_ALPHA_PHONE_PATTERN.matcher(number);
        if (m.matches()) {
      return normalizeHelper(number, ALPHA_PHONE_MAPPINGS, true);
    } else {
      return normalizeDigitsOnly(number);
    }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "D42F831C75A739394DFADDB25E708507", hash_generated_method = "9F857C9E4BC340159E71AA29BA08A6A6")
    static void normalize(StringBuilder number) {
        String normalizedNumber = normalize(number.toString());
        number.replace(0, number.length(), normalizedNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "502EEC6D6B5F71F00D0D11A03A19BB8B", hash_generated_method = "162DED37E54B3F072EB8F3D1CBE52E07")
    public static String normalizeDigitsOnly(String number) {
        return normalizeDigits(number, false ).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "359C33F05F722664FD26256E64417929", hash_generated_method = "07640CBE68C49280D205745174A0A3B0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "9F81C9B92A40C7BE142AACFEAE731136", hash_generated_method = "E6C110CF21011A984675F29C5BCF7A72")
    public static String convertAlphaCharactersInNumber(String number) {
        return normalizeHelper(number, ALPHA_PHONE_MAPPINGS, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "E944B5FE31AE1466662F85766A880CA9", hash_generated_method = "2AE5CA5A301AC05A555DC3E0A41BD9C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLengthOfGeographicalAreaCode(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        String regionCode;
        regionCode = getRegionCodeForNumber(number);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1309453836 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        {
            boolean var0F19B7C791578713C08B724D7EF83463_821351238 = (!metadata.hasNationalPrefix());
        } //End collapsed parenthetic
        PhoneNumberType type;
        type = getNumberTypeHelper(getNationalSignificantNumber(number),
                                               metadata);
        int var1A7583635198F8188F31B01169649F72_233930590 = (getLengthOfNationalDestinationCode(number));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.365 -0400", hash_original_method = "8F375C460DFE06AB35507021B2E67F57", hash_generated_method = "E7870B0A0FAB5B4C13864008C2A1F44E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLengthOfNationalDestinationCode(PhoneNumber number) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(number.dsTaint);
        PhoneNumber copiedProto;
        {
            boolean varA0334A328D5A78F314E250C07987CBB9_802312459 = (number.hasExtension());
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
            boolean varB39750E63BD6A0A6A4462637FFDF05DA_1895440379 = (getRegionCodeForNumber(number).equals("AR") &&
        getNumberType(number) == PhoneNumberType.MOBILE);
            {
                int varBE9BA5C465177F729DAFFF7C34A984CE_1724590344 = (numberGroups[3].length() + 1);
            } //End block
        } //End collapsed parenthetic
        int var9AE7A3309C2132BA3FD6101ABCDB2E2F_970773929 = (numberGroups[2].length());
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "1633DBFD6FFC6BC177209C717F6C9736", hash_generated_method = "A3A7C2F37873ED8CEF731B06315DE2BB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "B02D8B233D913131328D345E9D5C7AB1", hash_generated_method = "991F6C3EA19CDE01D5A23171EB1323D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "4B942EE039798DCE4C7F36FBC1F64250", hash_generated_method = "97FE6B503DABE6F3C4DE1F19161764AE")
    static synchronized void resetInstance() {
        instance = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "8806D3371D9E306571E478F8E387F5F6", hash_generated_method = "90F757DE8BC0239AD0C7EE9F443BAD03")
    @DSModeled(DSC.SAFE)
    public Set<String> getSupportedRegions() {
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return supportedRegions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "45DACE940983711BED948D6127B59415", hash_generated_method = "36E845520BBE50256B72281DE5C5AD05")
    public static synchronized PhoneNumberUtil getInstance() {
        if (instance == null) {
      return getInstance(META_DATA_FILE_PREFIX,
          CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
    }
        return instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "BD64224247A46B4F8D1913B12FB0926A", hash_generated_method = "DC420C0286A207479478B0E4DD56E027")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isValidRegionCode(String regionCode) {
        dsTaint.addTaint(regionCode);
        boolean var7DED5D1C831FA25A1913B196FCADCCAC_1191453838 = (regionCode != null && supportedRegions.contains(regionCode));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return regionCode != null && supportedRegions.contains(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "8968A71862E924379D457A4D52F2E514", hash_generated_method = "9C2A64946A3C4427A2201D0D13C4F0BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasValidRegionCode(String regionCode,
                                     int countryCallingCode, String number) {
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(countryCallingCode);
        dsTaint.addTaint(number);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1219667442 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.WARNING,
                 "Number " + number + " has invalid or missing country calling code ("
                 + countryCallingCode + ")");
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //LOGGER.log(Level.WARNING,
                 //"Number " + number + " has invalid or missing country calling code ("
                 //+ countryCallingCode + ")");
      //return false;
    //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "92F92B14F8645805E8F2936964CC9FBD", hash_generated_method = "07C11C5272C0B461538D65B0BC04D1DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String format(PhoneNumber number, PhoneNumberFormat numberFormat) {
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(number.dsTaint);
        {
            boolean varC5703F7758E4CCF6C68B52402D8E9ACF_1353199449 = (number.getNationalNumber() == 0 && number.hasRawInput());
            {
                String rawInput;
                rawInput = number.getRawInput();
                {
                    boolean var555F97EE0F80891C0AF723C26C2ED746_1312382593 = (rawInput.length() > 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        StringBuilder formattedNumber;
        formattedNumber = new StringBuilder(20);
        format(number, numberFormat, formattedNumber);
        String var3BC8BC448167065F44A7A19E2453EA3F_1014512854 = (formattedNumber.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "0E0E29DD0B07020C65FE41B70E3EF74E", hash_generated_method = "A721936B19054E0AC6B932550C114104")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void format(PhoneNumber number, PhoneNumberFormat numberFormat,
                     StringBuilder formattedNumber) {
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(formattedNumber.dsTaint);
        dsTaint.addTaint(number.dsTaint);
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
            boolean varA4E49614424C964001097A22AEE7E7BD_928462137 = (!isValidRegionCode(regionCode));
            {
                formattedNumber.append(nationalSignificantNumber);
            } //End block
        } //End collapsed parenthetic
        formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode, numberFormat));
        maybeGetFormattedExtension(number, regionCode, numberFormat, formattedNumber);
        formatNumberByFormat(countryCallingCode, numberFormat, formattedNumber);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.366 -0400", hash_original_method = "9F9F17BED2EE6CF557E830A9924BD1F5", hash_generated_method = "B542F72EDAA9D190169452B0B2F2E3E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String formatByPattern(PhoneNumber number,
                                PhoneNumberFormat numberFormat,
                                List<NumberFormat> userDefinedFormats) {
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(userDefinedFormats.dsTaint);
        dsTaint.addTaint(number.dsTaint);
        int countryCallingCode;
        countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCallingCode);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_191729884 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
        } //End collapsed parenthetic
        List<NumberFormat> userDefinedFormatsCopy;
        userDefinedFormatsCopy = new ArrayList<NumberFormat>(userDefinedFormats.size());
        {
            Iterator<NumberFormat> seatecAstronomy42 = userDefinedFormats.iterator();
            seatecAstronomy42.hasNext();
            NumberFormat numFormat = seatecAstronomy42.next();
            {
                String nationalPrefixFormattingRule;
                nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
                {
                    boolean var49F508BC12F9753C65EDF4F4D8419A12_2097408518 = (nationalPrefixFormattingRule.length() > 0);
                    {
                        NumberFormat numFormatCopy;
                        numFormatCopy = new NumberFormat();
                        numFormatCopy.mergeFrom(numFormat);
                        String nationalPrefix;
                        nationalPrefix = getMetadataForRegion(regionCode).getNationalPrefix();
                        {
                            boolean var4F43214BACA2879442D7C6FFEA040E27_1334218814 = (nationalPrefix.length() > 0);
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
        String var3BC8BC448167065F44A7A19E2453EA3F_1181536049 = (formattedNumber.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.367 -0400", hash_original_method = "91C4446CD1D629D514A31D665364644B", hash_generated_method = "B6F7AD8FF8F934E76D779502D5C9FFFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String formatNationalNumberWithCarrierCode(PhoneNumber number, String carrierCode) {
        dsTaint.addTaint(number.dsTaint);
        dsTaint.addTaint(carrierCode);
        int countryCallingCode;
        countryCallingCode = number.getCountryCode();
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCallingCode);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_1796953930 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
        } //End collapsed parenthetic
        StringBuilder formattedNumber;
        formattedNumber = new StringBuilder(20);
        formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode,
                                                PhoneNumberFormat.NATIONAL,
                                                carrierCode));
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.NATIONAL, formattedNumber);
        formatNumberByFormat(countryCallingCode, PhoneNumberFormat.NATIONAL, formattedNumber);
        String var3BC8BC448167065F44A7A19E2453EA3F_411965694 = (formattedNumber.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.367 -0400", hash_original_method = "4CA1ACD2C86EAA8A1981D39B6D2FA7BC", hash_generated_method = "B55FA213461191BE7D5C0AE7F49B6EBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String formatNationalNumberWithPreferredCarrierCode(PhoneNumber number,
                                                             String fallbackCarrierCode) {
        dsTaint.addTaint(fallbackCarrierCode);
        dsTaint.addTaint(number.dsTaint);
        String varEFA455084DF7DB59202FF32CE02A0C67_1764814825 = (formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       ? number.getPreferredDomesticCarrierCode()
                                                       : fallbackCarrierCode)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       //? number.getPreferredDomesticCarrierCode()
                                                       //: fallbackCarrierCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.367 -0400", hash_original_method = "F62393BCCF4A49D66E11EE7D750D9FD1", hash_generated_method = "02DA785978E7464FD0F3C21549FB5FBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String formatOutOfCountryCallingNumber(PhoneNumber number,
                                                String regionCallingFrom) {
        dsTaint.addTaint(number.dsTaint);
        dsTaint.addTaint(regionCallingFrom);
        {
            boolean varD048F64EC3C8401D282F486A6CF615B6_1754719270 = (!isValidRegionCode(regionCallingFrom));
            {
                String var602C420B4BF7841E3F826586243916C1_1697150697 = (format(number, PhoneNumberFormat.INTERNATIONAL));
            } //End block
        } //End collapsed parenthetic
        int countryCallingCode;
        countryCallingCode = number.getCountryCode();
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCallingCode);
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean varBDF5BAB4A5910678A561C311D8F0FCE1_1982014346 = (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber));
        } //End collapsed parenthetic
        {
            {
                boolean var87EDDF67CA1AA758C72D3792FA55B762_341252346 = (isNANPACountry(regionCallingFrom));
                {
                    String varCABE58D13B04EB574BA3524A87D7C8D6_1999724173 = (countryCallingCode + " " + format(number, PhoneNumberFormat.NATIONAL));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var33EA6E04A6ABE181DFBBC2046931D651_1817935607 = (countryCallingCode == getCountryCodeForRegion(regionCallingFrom));
            {
                String var0A687F2D0EA4B230D581A7383E74633C_162502654 = (format(number, PhoneNumberFormat.NATIONAL));
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
            boolean var98D851996F7DA14EE57E4E408EF3864D_1712097807 = (UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches());
            {
                internationalPrefixForFormatting = internationalPrefix;
            } //End block
            {
                boolean var5BD90B38377E183DFAF5B829C5613FB1_1519826045 = (metadata.hasPreferredInternationalPrefix());
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
            boolean varF0253AB64B70C1C22F5442932A86160B_204628728 = (internationalPrefixForFormatting.length() > 0);
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
        String var3BC8BC448167065F44A7A19E2453EA3F_1055396041 = (formattedNumber.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.368 -0400", hash_original_method = "DB42BF938772B1A7D3909F64DD7B67BB", hash_generated_method = "C047C958DA55AD1F69193B15DCBACE31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String formatInOriginalFormat(PhoneNumber number, String regionCallingFrom) {
        dsTaint.addTaint(number.dsTaint);
        dsTaint.addTaint(regionCallingFrom);
        {
            boolean var2BA36454AB1825117E50288B4F67202D_385359095 = (number.hasRawInput() &&
        (!hasFormattingPatternForNumber(number) || !isValidNumber(number)));
            {
                String var271D39D64E768653B4D7AB675FE350F1_820183170 = (number.getRawInput());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6C260429A491FE6501FBF10C9A9A3E9D_1730826499 = (!number.hasCountryCodeSource());
            {
                String var0A687F2D0EA4B230D581A7383E74633C_1920690944 = (format(number, PhoneNumberFormat.NATIONAL));
            } //End block
        } //End collapsed parenthetic
        String formattedNumber;
        {
            Object var3EC150F242A1103FEA1720F610B2B6E4_64144049 = (number.getCountryCodeSource());
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
        {
            boolean var0DF63ECCCF5A09E189F1D5F3C5B2503A_1320969800 = ((formattedNumber != null &&
            normalizeDigitsOnly(formattedNumber).equals(normalizeDigitsOnly(rawInput))));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.368 -0400", hash_original_method = "52E7EF7A7F940E41CFECD8D7BD9FA23C", hash_generated_method = "92E4A3BA5416C2A293F2E2236D514508")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasFormattingPatternForNumber(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        String phoneNumberRegion;
        phoneNumberRegion = getRegionCodeForCountryCode(number.getCountryCode());
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(phoneNumberRegion);
        String nationalNumber;
        nationalNumber = getNationalSignificantNumber(number);
        NumberFormat formatRule;
        formatRule = chooseFormattingPatternForNumber(metadata.numberFormats(), nationalNumber);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.368 -0400", hash_original_method = "4891B65BEA4A6D1403DAAAE11CCEEA80", hash_generated_method = "D65EA45D2D7CB0C6BF0758690CC7C38E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String formatOutOfCountryKeepingAlphaChars(PhoneNumber number,
                                                    String regionCallingFrom) {
        dsTaint.addTaint(number.dsTaint);
        dsTaint.addTaint(regionCallingFrom);
        String rawInput;
        rawInput = number.getRawInput();
        {
            boolean var56DE431416D41900B1A303BCD67165AA_28770086 = (rawInput.length() == 0);
            {
                String varF9EC1BFFD76E2BBA6735FD36AEE26FCA_1591942085 = (formatOutOfCountryCallingNumber(number, regionCallingFrom));
            } //End block
        } //End collapsed parenthetic
        int countryCode;
        countryCode = number.getCountryCode();
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCode);
        {
            boolean var6C6A5128B4A4E275737546ABC3B84693_293072067 = (!hasValidRegionCode(regionCode, countryCode, rawInput));
        } //End collapsed parenthetic
        rawInput = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String nationalNumber;
        nationalNumber = getNationalSignificantNumber(number);
        {
            boolean var24E952CC2DF3F15DA6E7744CA1ED0F83_532283082 = (nationalNumber.length() > 3);
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
                boolean var87EDDF67CA1AA758C72D3792FA55B762_544183248 = (isNANPACountry(regionCallingFrom));
            } //End collapsed parenthetic
        } //End block
        {
            boolean varC1B02B78273EEA3A2D0CE66FFC6E6BDD_883138678 = (countryCode == getCountryCodeForRegion(regionCallingFrom));
            {
                List<NumberFormat> availableFormats;
                availableFormats = new ArrayList<NumberFormat>(metadata.numberFormatSize());
                {
                    Iterator<NumberFormat> seatecAstronomy42 = metadata.numberFormats().iterator();
                    seatecAstronomy42.hasNext();
                    NumberFormat format = seatecAstronomy42.next();
                    {
                        NumberFormat newFormat;
                        newFormat = new NumberFormat();
                        newFormat.mergeFrom(format);
                        newFormat.setPattern("(\\d+)(.*)");
                        newFormat.setFormat("$1$2");
                        availableFormats.add(newFormat);
                    } //End block
                } //End collapsed parenthetic
                String var22A754B4674ED4A2FE9162480D3AA057_494769026 = (formatAccordingToFormats(rawInput, availableFormats, PhoneNumberFormat.NATIONAL));
            } //End block
        } //End collapsed parenthetic
        String internationalPrefix;
        internationalPrefix = metadata.getInternationalPrefix();
        String internationalPrefixForFormatting;
        boolean var6BBFED3C02F379AC58D09B7252F4F751_2075354586 = (UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches());
        internationalPrefixForFormatting = internationalPrefix;
        internationalPrefixForFormatting = metadata.getPreferredInternationalPrefix();
        StringBuilder formattedNumber;
        formattedNumber = new StringBuilder(rawInput);
        maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
        {
            boolean varF0253AB64B70C1C22F5442932A86160B_1206125131 = (internationalPrefixForFormatting.length() > 0);
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
        String var3BC8BC448167065F44A7A19E2453EA3F_1053285406 = (formattedNumber.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.368 -0400", hash_original_method = "D5C4512E5E6006B319585FD039F0D2D2", hash_generated_method = "8CDBA1013A698EABDAFC4B341AA69FC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNationalSignificantNumber(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        StringBuilder nationalNumber;
        nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");//DSFIXME:  CODE0008: Nested ternary operator in expression
        nationalNumber.append(number.getNationalNumber());
        String varAC0CF4A90BB56F0AA106DEE037DEDF5E_1634596209 = (nationalNumber.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");
        //nationalNumber.append(number.getNationalNumber());
        //return nationalNumber.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.368 -0400", hash_original_method = "B30288467474491802F599221421F5DD", hash_generated_method = "76AEBE3E9D0E4B91B87444DD43354828")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void formatNumberByFormat(int countryCallingCode,
                                    PhoneNumberFormat numberFormat,
                                    StringBuilder formattedNumber) {
        dsTaint.addTaint(countryCallingCode);
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(formattedNumber.dsTaint);
        //Begin case E164 
        formattedNumber.insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        //End case E164 
        //Begin case INTERNATIONAL 
        formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        //End case INTERNATIONAL 
        //Begin case RFC3966 
        formattedNumber.insert(0, "-").insert(0, countryCallingCode) .insert(0, PLUS_SIGN);
        //End case RFC3966 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.369 -0400", hash_original_method = "E72DB4CB518547F268CF62BAEDE813DC", hash_generated_method = "F07F5E91830891061C36F73215A5DFFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat) {
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(number);
        String var325F10AD333E0C8FAEBC8C24CD4FF291_1007773932 = (formatNationalNumber(number, regionCode, numberFormat, null));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return formatNationalNumber(number, regionCode, numberFormat, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.369 -0400", hash_original_method = "C233FF64EBF86F393338B595D4311670", hash_generated_method = "02CCE38F88D44EB4BA53AA24CCE8AF5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat,
                                      String carrierCode) {
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(carrierCode);
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        List<NumberFormat> intlNumberFormats;
        intlNumberFormats = metadata.intlNumberFormats();
        List<NumberFormat> availableFormats;
        boolean var010176D6E07BAFEEE15C51961F359715_983407365 = ((intlNumberFormats.size() == 0 || numberFormat == PhoneNumberFormat.NATIONAL));
        availableFormats = metadata.numberFormats();
        availableFormats = metadata.intlNumberFormats();
        String formattedNationalNumber;
        formattedNationalNumber = formatAccordingToFormats(number, availableFormats, numberFormat, carrierCode);
        {
            formattedNationalNumber =
          SEPARATOR_PATTERN.matcher(formattedNationalNumber).replaceAll("-");
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.369 -0400", hash_original_method = "8234956A6CF3F674EC2E620926354B88", hash_generated_method = "926E0D69ECF8D2882D4774DDD9C48AA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NumberFormat chooseFormattingPatternForNumber(List<NumberFormat> availableFormats,
                                                        String nationalNumber) {
        dsTaint.addTaint(availableFormats.dsTaint);
        dsTaint.addTaint(nationalNumber);
        {
            Iterator<NumberFormat> seatecAstronomy42 = availableFormats.iterator();
            seatecAstronomy42.hasNext();
            NumberFormat numFormat = seatecAstronomy42.next();
            {
                int size;
                size = numFormat.leadingDigitsPatternSize();
                {
                    boolean var70C01298E9B9CEE3566223FF0F4729C7_1738446705 = (size == 0 || regexCache.getPatternForRegex(
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt());
                    {
                        Matcher m;
                        m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                        {
                            boolean var21FF6A85D73745B4A18613C0C4E00A23_1745504663 = (m.matches());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (NumberFormat)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.369 -0400", hash_original_method = "ABA7814B1012D26F514E5605C0CC3287", hash_generated_method = "58CAACC70B16BB509456DE8C0056F78A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat) {
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(availableFormats.dsTaint);
        dsTaint.addTaint(nationalNumber);
        String var14D7233C634D4C610F8E8F5013B6F4C7_1782493833 = (formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.369 -0400", hash_original_method = "58A13E9521CF391FA7B0E516ACC9ED0C", hash_generated_method = "2BD1C243792714A3E218FD2F5D541C1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat,
                                          String carrierCode) {
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(availableFormats.dsTaint);
        dsTaint.addTaint(carrierCode);
        dsTaint.addTaint(nationalNumber);
        {
            Iterator<NumberFormat> seatecAstronomy42 = availableFormats.iterator();
            seatecAstronomy42.hasNext();
            NumberFormat numFormat = seatecAstronomy42.next();
            {
                int size;
                size = numFormat.leadingDigitsPatternSize();
                {
                    boolean var70C01298E9B9CEE3566223FF0F4729C7_12588504 = (size == 0 || regexCache.getPatternForRegex(
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt());
                    {
                        Matcher m;
                        m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                        {
                            boolean var21FF6A85D73745B4A18613C0C4E00A23_173578720 = (m.matches());
                            {
                                String numberFormatRule;
                                numberFormatRule = numFormat.getFormat();
                                {
                                    boolean var27E963F632C52F6E62BE94BB8EF98A0C_987807709 = (numberFormat == PhoneNumberFormat.NATIONAL &&
              carrierCode != null && carrierCode.length() > 0 &&
              numFormat.getDomesticCarrierCodeFormattingRule().length() > 0);
                                    {
                                        String carrierCodeFormattingRule;
                                        carrierCodeFormattingRule = numFormat.getDomesticCarrierCodeFormattingRule();
                                        carrierCodeFormattingRule =
                CC_PATTERN.matcher(carrierCodeFormattingRule).replaceFirst(carrierCode);
                                        numberFormatRule = FIRST_GROUP_PATTERN.matcher(numberFormatRule)
                .replaceFirst(carrierCodeFormattingRule);
                                        String var477FB912BEFB34356C16B5B6644B0CAF_1924349387 = (m.replaceAll(numberFormatRule));
                                    } //End block
                                    {
                                        String nationalPrefixFormattingRule;
                                        nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
                                        {
                                            boolean varFD5394A50BDD178AA2DA5B2252F56373_474899677 = (numberFormat == PhoneNumberFormat.NATIONAL &&
                nationalPrefixFormattingRule != null &&
                nationalPrefixFormattingRule.length() > 0);
                                            {
                                                Matcher firstGroupMatcher;
                                                firstGroupMatcher = FIRST_GROUP_PATTERN.matcher(numberFormatRule);
                                                String var052311BE27269CFC15C239CC3D6221B7_890824441 = (m.replaceAll(firstGroupMatcher.replaceFirst(nationalPrefixFormattingRule)));
                                            } //End block
                                            {
                                                String var68A2F7C8AD57D6F98D369E544D6A4B9C_1960907213 = (m.replaceAll(numberFormatRule));
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.369 -0400", hash_original_method = "B3C328ACE4FF3869EFF5C65F569BC538", hash_generated_method = "8A9316C773E6C928F972905820886F0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PhoneNumber getExampleNumber(String regionCode) {
        dsTaint.addTaint(regionCode);
        PhoneNumber var0523E936793DED99B5FEA78A9AD15BE8_72885818 = (getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE));
        return (PhoneNumber)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.370 -0400", hash_original_method = "B7676779AEFA9EF56CC59B101D8DF6C5", hash_generated_method = "94CF06949EBCB33691A5602965FCC342")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PhoneNumber getExampleNumberForType(String regionCode, PhoneNumberType type) {
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(type.dsTaint);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_473277306 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.WARNING, "Invalid or unknown region code provided.");
            } //End block
        } //End collapsed parenthetic
        PhoneNumberDesc desc;
        desc = getNumberDescByType(getMetadataForRegion(regionCode), type);
        try 
        {
            {
                boolean var332E3945C68B1E0C027A1E732CD697F2_1448843230 = (desc.hasExampleNumber());
                {
                    PhoneNumber varA72AD8E082D74F635CB1B219F850870F_1413456367 = (parse(desc.getExampleNumber(), regionCode));
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (NumberParseException e)
        {
            LOGGER.log(Level.SEVERE, e.toString());
        } //End block
        return (PhoneNumber)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.370 -0400", hash_original_method = "6C2C2EA977BB9169AEFD40896548847E", hash_generated_method = "3E030B0C3D3D934B1C045C83E641C1C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void maybeGetFormattedExtension(PhoneNumber number, String regionCode,
                                          PhoneNumberFormat numberFormat,
                                          StringBuilder formattedNumber) {
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(numberFormat.dsTaint);
        dsTaint.addTaint(formattedNumber.dsTaint);
        dsTaint.addTaint(number.dsTaint);
        {
            boolean var6CC2B5EB06BA8F69F485F7B9578BCDBB_19550904 = (number.hasExtension() && number.getExtension().length() > 0);
            {
                {
                    formattedNumber.append(RFC3966_EXTN_PREFIX).append(number.getExtension());
                } //End block
                {
                    formatExtension(number.getExtension(), regionCode, formattedNumber);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (number.hasExtension() && number.getExtension().length() > 0) {
      //if (numberFormat == PhoneNumberFormat.RFC3966) {
        //formattedNumber.append(RFC3966_EXTN_PREFIX).append(number.getExtension());
      //} else {
        //formatExtension(number.getExtension(), regionCode, formattedNumber);
      //}
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.370 -0400", hash_original_method = "4E1A69FB5E070DF7BC56976B37027181", hash_generated_method = "788C65BF55001FFEF534E37D3286EE72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void formatExtension(String extensionDigits, String regionCode,
                               StringBuilder extension) {
        dsTaint.addTaint(extension.dsTaint);
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(extensionDigits);
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        {
            boolean varE40ED1FD3A4A1BCF90B2F107CACB31BD_226677258 = (metadata.hasPreferredExtnPrefix());
            {
                extension.append(metadata.getPreferredExtnPrefix()).append(extensionDigits);
            } //End block
            {
                extension.append(DEFAULT_EXTN_PREFIX).append(extensionDigits);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //if (metadata.hasPreferredExtnPrefix()) {
      //extension.append(metadata.getPreferredExtnPrefix()).append(extensionDigits);
    //} else {
      //extension.append(DEFAULT_EXTN_PREFIX).append(extensionDigits);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.370 -0400", hash_original_method = "B508A0D4C9257AABA72DD1888D64C9E3", hash_generated_method = "4F72681A90341D37C092509DA3ADC485")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PhoneNumberDesc getNumberDescByType(PhoneMetadata metadata, PhoneNumberType type) {
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(metadata.dsTaint);
        //Begin case PREMIUM_RATE 
        PhoneNumberDesc var49E829B5886A903620E63B365CC61B96_1510798372 = (metadata.getPremiumRate());
        //End case PREMIUM_RATE 
        //Begin case TOLL_FREE 
        PhoneNumberDesc varD035427458BB54B1911D868D56712CA7_1890762512 = (metadata.getTollFree());
        //End case TOLL_FREE 
        //Begin case MOBILE 
        PhoneNumberDesc varD8A09D24DBE3C7574A23E76867465077_2141850271 = (metadata.getMobile());
        //End case MOBILE 
        //Begin case FIXED_LINE FIXED_LINE_OR_MOBILE 
        PhoneNumberDesc varF24B869779F60C164DE2900EBBEDE3B8_1547025752 = (metadata.getFixedLine());
        //End case FIXED_LINE FIXED_LINE_OR_MOBILE 
        //Begin case SHARED_COST 
        PhoneNumberDesc var54C88C1E8019A0138C9EF6467916F1D1_307141473 = (metadata.getSharedCost());
        //End case SHARED_COST 
        //Begin case VOIP 
        PhoneNumberDesc var88055DF48ABCEB617F4092CB6FAEAFB3_303021753 = (metadata.getVoip());
        //End case VOIP 
        //Begin case PERSONAL_NUMBER 
        PhoneNumberDesc varE9C90163D3D11096512C014743CD411C_1487674980 = (metadata.getPersonalNumber());
        //End case PERSONAL_NUMBER 
        //Begin case PAGER 
        PhoneNumberDesc var56640B351D5CC97E4B58B98D3BDD3373_1169790163 = (metadata.getPager());
        //End case PAGER 
        //Begin case UAN 
        PhoneNumberDesc var0C07F64DD56FEAF7D5DBA798EEC4723A_930186144 = (metadata.getUan());
        //End case UAN 
        //Begin case default 
        PhoneNumberDesc var61BC5DE85553DC6EC99F93333EC7284F_831108884 = (metadata.getGeneralDesc());
        //End case default 
        return (PhoneNumberDesc)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.370 -0400", hash_original_method = "261D2E3780968B6A389AA5653D83C66D", hash_generated_method = "6A0EB04F5FAB2E84AF2FD0CDCEDE7E00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PhoneNumberType getNumberType(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        String regionCode;
        regionCode = getRegionCodeForNumber(number);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_874328516 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        PhoneNumberType var04A9818FBA3413C5F725EF6EC046A940_93792462 = (getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode)));
        return (PhoneNumberType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //if (!isValidRegionCode(regionCode)) {
      //return PhoneNumberType.UNKNOWN;
    //}
        //String nationalSignificantNumber = getNationalSignificantNumber(number);
        //return getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.371 -0400", hash_original_method = "CFBB065FE396C61ECB0C897E1E4B66DC", hash_generated_method = "235FE59211C58881C48BB84BFEE893EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PhoneNumberType getNumberTypeHelper(String nationalNumber, PhoneMetadata metadata) {
        dsTaint.addTaint(nationalNumber);
        dsTaint.addTaint(metadata.dsTaint);
        PhoneNumberDesc generalNumberDesc;
        generalNumberDesc = metadata.getGeneralDesc();
        {
            boolean var5B173D1DFC1562F0020B057904EE0B3C_1498997538 = (!generalNumberDesc.hasNationalNumberPattern() ||
        !isNumberMatchingDesc(nationalNumber, generalNumberDesc));
        } //End collapsed parenthetic
        {
            boolean varFC5517BA7F51C044D62329DD8DA33803_1841397107 = (isNumberMatchingDesc(nationalNumber, metadata.getPremiumRate()));
        } //End collapsed parenthetic
        {
            boolean varC1B0D4362E20F4D15396EDA203322A7B_1845719550 = (isNumberMatchingDesc(nationalNumber, metadata.getTollFree()));
        } //End collapsed parenthetic
        {
            boolean var4050D2117B44C187237158BD69941F37_1325677254 = (isNumberMatchingDesc(nationalNumber, metadata.getSharedCost()));
        } //End collapsed parenthetic
        {
            boolean var391D271B9C8CED3D2BFA2E53ADE2C8A3_371644046 = (isNumberMatchingDesc(nationalNumber, metadata.getVoip()));
        } //End collapsed parenthetic
        {
            boolean varBF02F0578A5A843F636ECA3493243BE6_1519732407 = (isNumberMatchingDesc(nationalNumber, metadata.getPersonalNumber()));
        } //End collapsed parenthetic
        {
            boolean var50FD2167C2C1685ED42EE82A11A93B25_1330970801 = (isNumberMatchingDesc(nationalNumber, metadata.getPager()));
        } //End collapsed parenthetic
        {
            boolean var43080BFDC919D8A6AC3E511D3259EF4E_17380254 = (isNumberMatchingDesc(nationalNumber, metadata.getUan()));
        } //End collapsed parenthetic
        boolean isFixedLine;
        isFixedLine = isNumberMatchingDesc(nationalNumber, metadata.getFixedLine());
        {
            {
                boolean var54343FDE9F348C9E4056CCA96B123FA1_375291400 = (metadata.isSameMobileAndFixedLinePattern());
                {
                    boolean var0E0B18E4B567EBE5114CB7B2F558C5D5_408983051 = (isNumberMatchingDesc(nationalNumber, metadata.getMobile()));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            boolean varF3C8C9AD58504637AE43DDCCBED0DAE8_1591909620 = (!metadata.isSameMobileAndFixedLinePattern() &&
        isNumberMatchingDesc(nationalNumber, metadata.getMobile()));
        } //End collapsed parenthetic
        return (PhoneNumberType)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.371 -0400", hash_original_method = "B7D0F615A2820F4964EA69968467492C", hash_generated_method = "343BDFF1BAB228DF29028888CF544097")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PhoneMetadata getMetadataForRegion(String regionCode) {
        dsTaint.addTaint(regionCode);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_787684821 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        {
            {
                boolean var60A67063C3B37462B25FD4797CD4A0A0_98180371 = (!regionToMetadataMap.containsKey(regionCode));
                {
                    loadMetadataForRegionFromFile(currentFilePrefix, regionCode);
                } //End block
            } //End collapsed parenthetic
        } //End block
        PhoneMetadata var39E4D1FF34C51D8F7EB17BED8894665D_385078954 = (regionToMetadataMap.get(regionCode));
        return (PhoneMetadata)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.371 -0400", hash_original_method = "B17A0514C43E05EB90EE98CA4CB42983", hash_generated_method = "31516D738CA977F5138241E0F09126C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isNumberMatchingDesc(String nationalNumber, PhoneNumberDesc numberDesc) {
        dsTaint.addTaint(numberDesc.dsTaint);
        dsTaint.addTaint(nationalNumber);
        Matcher possibleNumberPatternMatcher;
        possibleNumberPatternMatcher = regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            .matcher(nationalNumber);
        Matcher nationalNumberPatternMatcher;
        nationalNumberPatternMatcher = regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            .matcher(nationalNumber);
        boolean var59CBFCA142FE36DE1654CBFBCE0A5F21_1140627387 = (possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Matcher possibleNumberPatternMatcher =
        //regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            //.matcher(nationalNumber);
        //Matcher nationalNumberPatternMatcher =
        //regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            //.matcher(nationalNumber);
        //return possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.371 -0400", hash_original_method = "31ADC24E14E9CE703FF2777ACEC876BF", hash_generated_method = "870E24ECAC1A5E5FB6BD357B4E0CE854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValidNumber(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        String regionCode;
        regionCode = getRegionCodeForNumber(number);
        boolean var28FBA9C4B7A68485B8D67ECFF42CF1EB_1082406411 = ((isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String regionCode = getRegionCodeForNumber(number);
        //return (isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.371 -0400", hash_original_method = "C701813EA11D8E6ADA1ECC6BB90E9747", hash_generated_method = "619EC2B21FBA16DC05C29FA15FFF60C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValidNumberForRegion(PhoneNumber number, String regionCode) {
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(number.dsTaint);
        {
            boolean var98525ED7F2835E26F2B24C7F8233B726_2127181631 = (number.getCountryCode() != getCountryCodeForRegion(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        PhoneNumberDesc generalNumDesc;
        generalNumDesc = metadata.getGeneralDesc();
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean var6BBB06AEDF976ADEC9072013B0735BB1_109618494 = (!generalNumDesc.hasNationalNumberPattern());
            {
                int numberLength;
                numberLength = nationalSignificantNumber.length();
            } //End block
        } //End collapsed parenthetic
        boolean varDB2FE427898C8D8020D29E442EFBBBDB_1890807366 = (getNumberTypeHelper(nationalSignificantNumber, metadata) != PhoneNumberType.UNKNOWN);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.371 -0400", hash_original_method = "C5C9CB0E93474118DAA9D7A65CA1060A", hash_generated_method = "D528BD1854DC0E21318B50609468BC0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRegionCodeForNumber(PhoneNumber number) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(number.dsTaint);
        int countryCode;
        countryCode = number.getCountryCode();
        List<String> regions;
        regions = countryCallingCodeToRegionCodeMap.get(countryCode);
        {
            boolean var10ED2DD9FF740B3AAF00BF9AEF0FF83C_1254550137 = (regions.size() == 1);
            {
                String varEAA4B3A0E95A7729C90898BADCF1579E_891517808 = (regions.get(0));
            } //End block
            {
                String var43626E25549574895FCC80F441ED6405_880058961 = (getRegionCodeForNumberFromRegionList(number, regions));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.371 -0400", hash_original_method = "814AB76683AFE761330E661D695A8B3F", hash_generated_method = "DCC812E428D3321E3DDE8F4A1E1122E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getRegionCodeForNumberFromRegionList(PhoneNumber number,
                                                      List<String> regionCodes) {
        dsTaint.addTaint(number.dsTaint);
        dsTaint.addTaint(regionCodes.dsTaint);
        String nationalNumber;
        nationalNumber = getNationalSignificantNumber(number);
        {
            Iterator<String> seatecAstronomy42 = regionCodes.iterator();
            seatecAstronomy42.hasNext();
            String regionCode = seatecAstronomy42.next();
            {
                PhoneMetadata metadata;
                metadata = getMetadataForRegion(regionCode);
                {
                    boolean varF2BDE8A0B1D079F49328DAC6385FA645_1685071846 = (metadata.hasLeadingDigits());
                    {
                        {
                            boolean varAE03BEFF3A7C553963FE54EA102583D6_727410620 = (regexCache.getPatternForRegex(metadata.getLeadingDigits())
                .matcher(nationalNumber).lookingAt());
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varF0EA7F11B601F2E7D21312C63A7500A8_1705413793 = (getNumberTypeHelper(nationalNumber, metadata) != PhoneNumberType.UNKNOWN);
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "DA9951AEFEAF4242112AA6281301B32F", hash_generated_method = "EA3F7749A96729FEF7BBFBD5D3793D2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRegionCodeForCountryCode(int countryCallingCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(countryCallingCode);
        List<String> regionCodes;
        regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
        {
            Object var8AE4002CB68D3E051327E58C29D063CE_1566107120 = (regionCodes.get(0));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //List<String> regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
        //return regionCodes == null ? UNKNOWN_REGION : regionCodes.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "D7076C7EB39C8978E29A5CA27F40EEC9", hash_generated_method = "3F5532CF52AC392C1BB206424F3EF197")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCountryCodeForRegion(String regionCode) {
        dsTaint.addTaint(regionCode);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1150752303 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        int varDD48F4FF04794DCC6ACB188903D09223_1359177958 = (metadata.getCountryCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isValidRegionCode(regionCode)) {
      //return 0;
    //}
        //PhoneMetadata metadata = getMetadataForRegion(regionCode);
        //return metadata.getCountryCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "E58B423D76AD6194B45901E123DB6EBF", hash_generated_method = "3BEADC483667505E1C74922B2F604152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNddPrefixForRegion(String regionCode, boolean stripNonDigits) {
        dsTaint.addTaint(regionCode);
        dsTaint.addTaint(stripNonDigits);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1490470312 = (!isValidRegionCode(regionCode));
            {
                LOGGER.log(Level.SEVERE, "Invalid or missing region code provided.");
            } //End block
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        String nationalPrefix;
        nationalPrefix = metadata.getNationalPrefix();
        {
            boolean var01C0F06701D85CDE650BDE5E4D96FB06_1814933097 = (nationalPrefix.length() == 0);
        } //End collapsed parenthetic
        {
            nationalPrefix = nationalPrefix.replace("~", "");
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "7B63C50F103D8DC60E8A2B15ED73A093", hash_generated_method = "F7C68038A6BA2CE4177CD066C0A8BE39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNANPACountry(String regionCode) {
        dsTaint.addTaint(regionCode);
        boolean var8AEB4252BA8A65A9B8C3173CF2CBF7D8_1288376875 = (nanpaRegions.contains(regionCode));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nanpaRegions.contains(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "996B7AC837898451564E65CADA674F54", hash_generated_method = "5AC562876B8C72F298B518B08B4F3141")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isLeadingZeroPossible(int countryCallingCode) {
        dsTaint.addTaint(countryCallingCode);
        PhoneMetadata mainMetadataForCallingCode;
        mainMetadataForCallingCode = getMetadataForRegion(
        getRegionCodeForCountryCode(countryCallingCode));
        boolean var8B12A904D1DB3A2A33A947A68C4B6146_897000733 = (mainMetadataForCallingCode.isLeadingZeroPossible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //PhoneMetadata mainMetadataForCallingCode = getMetadataForRegion(
        //getRegionCodeForCountryCode(countryCallingCode));
        //if (mainMetadataForCallingCode == null) {
      //return false;
    //}
        //return mainMetadataForCallingCode.isLeadingZeroPossible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "4B80DFBB3D3B298395671B1C8C6F67DA", hash_generated_method = "470F2290211626C423D85090F589FC1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAlphaNumber(String number) {
        dsTaint.addTaint(number);
        {
            boolean var6F2D6DBE1E1842574CD6CB87FFC5DB6E_1463187 = (!isViablePhoneNumber(number));
        } //End collapsed parenthetic
        StringBuilder strippedNumber;
        strippedNumber = new StringBuilder(number);
        maybeStripExtension(strippedNumber);
        boolean varAE4E32ECCF3EF15A647E2C1BB378DAA7_1746929872 = (VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isViablePhoneNumber(number)) {
      //return false;
    //}
        //StringBuilder strippedNumber = new StringBuilder(number);
        //maybeStripExtension(strippedNumber);
        //return VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "86FEA4033CCC520A9BCC7CD67C884B0D", hash_generated_method = "6EE680296B70838F9CDB0B23F5B08AEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPossibleNumber(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        boolean varB638E1EBE041FE51ED0B48C92300B1AB_787672171 = (isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "B3EB56A7047F0C0039433A6E9896FBEF", hash_generated_method = "C5735DE505B0349BB2ABBB0F3B77111D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ValidationResult testNumberLengthAgainstPattern(Pattern numberPattern, String number) {
        dsTaint.addTaint(numberPattern.dsTaint);
        dsTaint.addTaint(number);
        Matcher numberMatcher;
        numberMatcher = numberPattern.matcher(number);
        {
            boolean var71179D25353510F4890F375B5AE981E3_610933859 = (numberMatcher.matches());
        } //End collapsed parenthetic
        {
            boolean var162373AA4FD3689E76A45288F34FBEF2_848299089 = (numberMatcher.lookingAt());
        } //End collapsed parenthetic
        return (ValidationResult)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.372 -0400", hash_original_method = "5E4449198019FBA49E61EB3BB2D3E7CD", hash_generated_method = "9B09FE20457E06A2CCE1B55E8532768F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ValidationResult isPossibleNumberWithReason(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        String nationalNumber;
        nationalNumber = getNationalSignificantNumber(number);
        int countryCode;
        countryCode = number.getCountryCode();
        String regionCode;
        regionCode = getRegionCodeForCountryCode(countryCode);
        {
            boolean varA4E49614424C964001097A22AEE7E7BD_1440467594 = (!isValidRegionCode(regionCode));
        } //End collapsed parenthetic
        PhoneNumberDesc generalNumDesc;
        generalNumDesc = getMetadataForRegion(regionCode).getGeneralDesc();
        {
            boolean var6BBB06AEDF976ADEC9072013B0735BB1_1776041149 = (!generalNumDesc.hasNationalNumberPattern());
            {
                LOGGER.log(Level.FINER, "Checking if number is possible with incomplete metadata.");
                int numberLength;
                numberLength = nationalNumber.length();
            } //End block
        } //End collapsed parenthetic
        Pattern possibleNumberPattern;
        possibleNumberPattern = regexCache.getPatternForRegex(generalNumDesc.getPossibleNumberPattern());
        ValidationResult varEAB10B18D5C189969AACE466E20F8C8A_1271237651 = (testNumberLengthAgainstPattern(possibleNumberPattern, nationalNumber));
        return (ValidationResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.373 -0400", hash_original_method = "ABB46ACB6DF1697743B661541AD5E166", hash_generated_method = "27E91D9182591086A51B521E079E21CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPossibleNumber(String number, String regionDialingFrom) {
        dsTaint.addTaint(regionDialingFrom);
        dsTaint.addTaint(number);
        try 
        {
            boolean var96F965C3B92FA5515239648FCAA605FA_463622870 = (isPossibleNumber(parse(number, regionDialingFrom)));
        } //End block
        catch (NumberParseException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
      //return isPossibleNumber(parse(number, regionDialingFrom));
    //} catch (NumberParseException e) {
      //return false;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.373 -0400", hash_original_method = "763BBE034FB297BC9C435FECAC40F4A1", hash_generated_method = "0D3308E6EAEB40E6822D6BAFE34F2E65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean truncateTooLongNumber(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        {
            boolean var4F293B781EB7DE5CEFDA17D5EE1DE4BB_175427253 = (isValidNumber(number));
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
                boolean var4DE93CDC578CDDBFB1C41949B44D9A20_1496319591 = (isPossibleNumberWithReason(numberCopy) == ValidationResult.TOO_SHORT ||
          nationalNumber == 0);
            } //End collapsed parenthetic
        } //End block
        {
            boolean varFE57FF35897528475D20382F37EC3A95_989231495 = (!isValidNumber(numberCopy));
        } //End collapsed parenthetic
        number.setNationalNumber(nationalNumber);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.373 -0400", hash_original_method = "719F2F8970F4EB169BEDB2820A702606", hash_generated_method = "2B207799BAB57D1074539D4D774EBD91")
    @DSModeled(DSC.SAFE)
    public AsYouTypeFormatter getAsYouTypeFormatter(String regionCode) {
        dsTaint.addTaint(regionCode);
        return (AsYouTypeFormatter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AsYouTypeFormatter(regionCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.373 -0400", hash_original_method = "2A48039CFC05A878E1A34077CDECE0D5", hash_generated_method = "2416CDCDFF4CC13B109608249ED08253")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int extractCountryCode(StringBuilder fullNumber, StringBuilder nationalNumber) {
        dsTaint.addTaint(fullNumber.dsTaint);
        dsTaint.addTaint(nationalNumber.dsTaint);
        int potentialCountryCode;
        int numberLength;
        numberLength = fullNumber.length();
        {
            int i;
            i = 1;
            {
                potentialCountryCode = Integer.parseInt(fullNumber.substring(0, i));
                {
                    boolean varF6C470E7E096D4CAC6F27A27E3BF3621_765182452 = (countryCallingCodeToRegionCodeMap.containsKey(potentialCountryCode));
                    {
                        nationalNumber.append(fullNumber.substring(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.373 -0400", hash_original_method = "8166FB521487034FA9E8BD7575A0612F", hash_generated_method = "C800B3EF4E5B7A33261857F993AB6E6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int maybeExtractCountryCode(String number, PhoneMetadata defaultRegionMetadata,
                              StringBuilder nationalNumber, boolean keepRawInput,
                              PhoneNumber phoneNumber) throws NumberParseException {
        dsTaint.addTaint(phoneNumber.dsTaint);
        dsTaint.addTaint(defaultRegionMetadata.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(keepRawInput);
        dsTaint.addTaint(nationalNumber.dsTaint);
        {
            boolean varB5B34D967C3FC3EF34B11B7B3B931B11_1297542655 = (number.length() == 0);
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
                boolean varE7EE2B23EDD4C9364B0D3D150E7CC45E_1947190041 = (fullNumber.length() < MIN_LENGTH_FOR_NSN);
                {
                    throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD,
                                       "Phone number had an IDD, but after this was not "
                                       + "long enough to be a viable phone number.");
                } //End block
            } //End collapsed parenthetic
            int potentialCountryCode;
            potentialCountryCode = extractCountryCode(fullNumber, nationalNumber);
            {
                phoneNumber.setCountryCode(potentialCountryCode);
            } //End block
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
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
                boolean varBF0AEC43338ACB310E013283F2CF7DCB_701195710 = (normalizedNumber.startsWith(defaultCountryCodeString));
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
                        boolean var0EB5BCA225D2EA4DBFFB64C37782F25D_17751048 = ((!validNumberPattern.matcher(fullNumber).matches() &&
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.374 -0400", hash_original_method = "0F0B6B28B590A156D8457E403790D50B", hash_generated_method = "4E6F583C64208025EA601D1B0B6056F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean parsePrefixAsIdd(Pattern iddPattern, StringBuilder number) {
        dsTaint.addTaint(iddPattern.dsTaint);
        dsTaint.addTaint(number.dsTaint);
        Matcher m;
        m = iddPattern.matcher(number);
        {
            boolean var2E90163ED89C1EED1C54F6911454B170_992049644 = (m.lookingAt());
            {
                int matchEnd;
                matchEnd = m.end();
                Matcher digitMatcher;
                digitMatcher = CAPTURING_DIGIT_PATTERN.matcher(number.substring(matchEnd));
                {
                    boolean varD3BA2E8471CEBE61FDD93E9E325ACBC0_81016637 = (digitMatcher.find());
                    {
                        String normalizedGroup;
                        normalizedGroup = normalizeDigitsOnly(digitMatcher.group(1));
                        {
                            boolean var61EE828DD147AE02AC5DD8BACE4A9E86_384744753 = (normalizedGroup.equals("0"));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                number.delete(0, matchEnd);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.374 -0400", hash_original_method = "8865CBB50A1D9F6F8472F699DBF16350", hash_generated_method = "56DEF73A416BA0E8DAFE994CD1AE484D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CountryCodeSource maybeStripInternationalPrefixAndNormalize(
      StringBuilder number,
      String possibleIddPrefix) {
        dsTaint.addTaint(possibleIddPrefix);
        dsTaint.addTaint(number.dsTaint);
        {
            boolean varB5B34D967C3FC3EF34B11B7B3B931B11_1979591284 = (number.length() == 0);
        } //End collapsed parenthetic
        Matcher m;
        m = PLUS_CHARS_PATTERN.matcher(number);
        {
            boolean var2E90163ED89C1EED1C54F6911454B170_79698455 = (m.lookingAt());
            {
                number.delete(0, m.end());
                normalize(number);
            } //End block
        } //End collapsed parenthetic
        Pattern iddPattern;
        iddPattern = regexCache.getPatternForRegex(possibleIddPrefix);
        {
            boolean varCDD8918BAE2604CCF3C5EBF34E65E7DD_364250575 = (parsePrefixAsIdd(iddPattern, number));
            {
                normalize(number);
            } //End block
        } //End collapsed parenthetic
        normalize(number);
        {
            boolean varCDD8918BAE2604CCF3C5EBF34E65E7DD_48691908 = (parsePrefixAsIdd(iddPattern, number));
        } //End flattened ternary
        return (CountryCodeSource)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.374 -0400", hash_original_method = "8024CAA7B81A99B980BA01FE387839A1", hash_generated_method = "74F5ED3370A4D75ABE738C1A144AA035")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String maybeStripNationalPrefixAndCarrierCode(StringBuilder number, PhoneMetadata metadata) {
        dsTaint.addTaint(number.dsTaint);
        dsTaint.addTaint(metadata.dsTaint);
        String carrierCode;
        carrierCode = "";
        int numberLength;
        numberLength = number.length();
        String possibleNationalPrefix;
        possibleNationalPrefix = metadata.getNationalPrefixForParsing();
        {
            boolean var2D1654E1B48CDA3CB899B11DA870015B_1055539411 = (numberLength == 0 || possibleNationalPrefix.length() == 0);
        } //End collapsed parenthetic
        Matcher prefixMatcher;
        prefixMatcher = regexCache.getPatternForRegex(possibleNationalPrefix).matcher(number);
        {
            boolean var51DEE301B078E28F95DDA21171B258E8_624309479 = (prefixMatcher.lookingAt());
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
                    boolean var92083891923A60ACDAC45256CB34F888_1201374928 = (transformRule == null || transformRule.length() == 0 ||
          prefixMatcher.group(numOfGroups) == null);
                    {
                        {
                            boolean var05FB41A7DFCB455F1C640CC42B086A52_873970525 = (isViableOriginalNumber &&
            !nationalNumberRule.matcher(number.substring(prefixMatcher.end())).matches());
                        } //End collapsed parenthetic
                        {
                            boolean var731E647394C8AC8EAD72BD6A33D30533_1630469387 = (numOfGroups > 0 && prefixMatcher.group(numOfGroups) != null);
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
                            boolean var1618096EC0BE19942037320536365A62_425861624 = (isViableOriginalNumber &&
            !nationalNumberRule.matcher(transformedNumber.toString()).matches());
                        } //End collapsed parenthetic
                        {
                            carrierCode = prefixMatcher.group(1);
                        } //End block
                        number.replace(0, number.length(), transformedNumber.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.375 -0400", hash_original_method = "D072FBB7A4080E317A5210E0DF61655A", hash_generated_method = "FA42340B82C9D535C0431FEEBAD05A6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String maybeStripExtension(StringBuilder number) {
        dsTaint.addTaint(number.dsTaint);
        Matcher m;
        m = EXTN_PATTERN.matcher(number);
        {
            boolean var361B236D5550943CE1D4B9E817C41F2D_1666530674 = (m.find() && isViablePhoneNumber(number.substring(0, m.start())));
            {
                {
                    int i, length;
                    i = 1;
                    length = m.groupCount();
                    {
                        {
                            boolean varEF8B426B8C4D7A4B4377DDF02EDEE0A6_514945852 = (m.group(i) != null);
                            {
                                String extension;
                                extension = m.group(i);
                                number.delete(m.start(), number.length());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.375 -0400", hash_original_method = "E1BA4484CA3B538698D9E39D9664F7DD", hash_generated_method = "C5ED2496E99D5EB0DBA4FE1E0FBFB708")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean checkRegionForParsing(String numberToParse, String defaultRegion) {
        dsTaint.addTaint(numberToParse);
        dsTaint.addTaint(defaultRegion);
        {
            boolean varC4FBE20839E7B322BE8202F31EB24419_1897742603 = (!isValidRegionCode(defaultRegion));
            {
                {
                    boolean varAC73D73EEB94A3B214186B0F9C923AF3_307053422 = (numberToParse == null || numberToParse.length() == 0 ||
          !PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isValidRegionCode(defaultRegion)) {
      //if (numberToParse == null || numberToParse.length() == 0 ||
          //!PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt()) {
        //return false;
      //}
    //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.375 -0400", hash_original_method = "6012972DF706A584D5C83C6971CF9392", hash_generated_method = "A8E65FF4AB0BAE0C93D4FB405D795997")
    @DSModeled(DSC.SAFE)
    public PhoneNumber parse(String numberToParse, String defaultRegion) throws NumberParseException {
        dsTaint.addTaint(numberToParse);
        dsTaint.addTaint(defaultRegion);
        PhoneNumber phoneNumber;
        phoneNumber = new PhoneNumber();
        parse(numberToParse, defaultRegion, phoneNumber);
        return (PhoneNumber)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PhoneNumber phoneNumber = new PhoneNumber();
        //parse(numberToParse, defaultRegion, phoneNumber);
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.375 -0400", hash_original_method = "6ECDB36C19DB49774718F5C4BA94B539", hash_generated_method = "D31BB8BA2E456C44CDB3BA4BC143D366")
    @DSModeled(DSC.SAFE)
    public void parse(String numberToParse, String defaultRegion, PhoneNumber phoneNumber) throws NumberParseException {
        dsTaint.addTaint(phoneNumber.dsTaint);
        dsTaint.addTaint(numberToParse);
        dsTaint.addTaint(defaultRegion);
        parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
        // ---------- Original Method ----------
        //parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.375 -0400", hash_original_method = "19CBF359D0DD4BA30476F5C26D54CCE4", hash_generated_method = "4B1D5F4A555C49BFBC18192710CF12AD")
    @DSModeled(DSC.SAFE)
    public PhoneNumber parseAndKeepRawInput(String numberToParse, String defaultRegion) throws NumberParseException {
        dsTaint.addTaint(numberToParse);
        dsTaint.addTaint(defaultRegion);
        PhoneNumber phoneNumber;
        phoneNumber = new PhoneNumber();
        parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
        return (PhoneNumber)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PhoneNumber phoneNumber = new PhoneNumber();
        //parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.375 -0400", hash_original_method = "56F5D9940BB01A0D66986596B5A9CF6E", hash_generated_method = "2C7B0074E05D95BB35B05ADF1AF330E3")
    @DSModeled(DSC.SAFE)
    public void parseAndKeepRawInput(String numberToParse, String defaultRegion,
                                   PhoneNumber phoneNumber) throws NumberParseException {
        dsTaint.addTaint(phoneNumber.dsTaint);
        dsTaint.addTaint(numberToParse);
        dsTaint.addTaint(defaultRegion);
        parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
        // ---------- Original Method ----------
        //parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.375 -0400", hash_original_method = "FC749C2F4DF483D491476DD9FB58E6D5", hash_generated_method = "440EA4DA73DE545F7D744DF9A9C33D82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterable<PhoneNumberMatch> findNumbers(CharSequence text, String defaultRegion) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(defaultRegion);
        Iterable<PhoneNumberMatch> var2E3BC5EF3EF473A9990BA1B8D7CB67EC_1946799261 = (findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE));
        return (Iterable<PhoneNumberMatch>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.375 -0400", hash_original_method = "C3E745E72AE45D5E83FFDE500327E040", hash_generated_method = "4E4BCAD7CAC986A1E3153FB1AE08E710")
    @DSModeled(DSC.SAFE)
    public Iterable<PhoneNumberMatch> findNumbers(
      final CharSequence text, final String defaultRegion, final Leniency leniency,
      final long maxTries) {
        dsTaint.addTaint(leniency.dsTaint);
        dsTaint.addTaint(maxTries);
        dsTaint.addTaint(text);
        dsTaint.addTaint(defaultRegion);
        return (Iterable<PhoneNumberMatch>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Iterable<PhoneNumberMatch>() {
      //public Iterator<PhoneNumberMatch> iterator() {
        //return new PhoneNumberMatcher(
            //PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
      //}
    //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.376 -0400", hash_original_method = "B3135DA9F7C362E965D50679AE934189", hash_generated_method = "65EC271AE2789A7DDBBEFA89C9C1062E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseHelper(String numberToParse, String defaultRegion, boolean keepRawInput,
                           boolean checkRegion, PhoneNumber phoneNumber) throws NumberParseException {
        dsTaint.addTaint(phoneNumber.dsTaint);
        dsTaint.addTaint(numberToParse);
        dsTaint.addTaint(defaultRegion);
        dsTaint.addTaint(checkRegion);
        dsTaint.addTaint(keepRawInput);
        {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The phone number supplied was null.");
        } //End block
        String number;
        number = extractPossibleNumber(numberToParse);
        {
            boolean var6F2D6DBE1E1842574CD6CB87FFC5DB6E_1321105015 = (!isViablePhoneNumber(number));
            {
                throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The string supplied did not seem to be a phone number.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var06E9F76E4F889EF52DC311C4A976B26A_1799833558 = (checkRegion && !checkRegionForParsing(number, defaultRegion));
            {
                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
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
            boolean var3CC30422F1FA8C39327BDA102088343B_1403170665 = (extension.length() > 0);
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
                boolean varF49D20E798CCB0BC5377F0D78E2C4831_414372994 = (!phoneNumberRegion.equals(defaultRegion));
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
            boolean varE256D1ABB8A26FE912AD1B0C28F9428D_622186416 = (normalizedNationalNumber.length() < MIN_LENGTH_FOR_NSN);
            {
                throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
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
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
        } //End block
        {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG,
                                     "The string supplied is too long to be a phone number.");
        } //End block
        {
            boolean varACF04B28E2A0B5A46318EA7197F780A3_1379711086 = (normalizedNationalNumber.charAt(0) == '0');
            {
                phoneNumber.setItalianLeadingZero(true);
            } //End block
        } //End collapsed parenthetic
        phoneNumber.setNationalNumber(Long.parseLong(normalizedNationalNumber.toString()));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.376 -0400", hash_original_method = "83C8E6F8520B32A4B2A265A569BAF2C9", hash_generated_method = "C6E165AC0A8E72CE900484288F9B2BD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MatchType isNumberMatch(PhoneNumber firstNumberIn, PhoneNumber secondNumberIn) {
        dsTaint.addTaint(firstNumberIn.dsTaint);
        dsTaint.addTaint(secondNumberIn.dsTaint);
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
            boolean varD218A2F73AAFCD618CDCC1518EFA486F_2028350490 = (firstNumber.hasExtension() &&
        firstNumber.getExtension().length() == 0);
            {
                firstNumber.clearExtension();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var60C5BEE8803B911C5831EA8EC7969A40_1924250140 = (secondNumber.hasExtension() &&
        secondNumber.getExtension().length() == 0);
            {
                secondNumber.clearExtension();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF31A145523293CCF9F54D3055A0EFC09_18847265 = (firstNumber.hasExtension() && secondNumber.hasExtension() &&
        !firstNumber.getExtension().equals(secondNumber.getExtension()));
        } //End collapsed parenthetic
        int firstNumberCountryCode;
        firstNumberCountryCode = firstNumber.getCountryCode();
        int secondNumberCountryCode;
        secondNumberCountryCode = secondNumber.getCountryCode();
        {
            {
                boolean var9B921E1924AE2BDB9C722839D617A98E_2090118844 = (firstNumber.exactlySameAs(secondNumber));
                {
                    boolean var51FF660A6085B2E42A72E7B10CEF8B05_347460278 = (firstNumberCountryCode == secondNumberCountryCode &&
                 isNationalNumberSuffixOfTheOther(firstNumber, secondNumber));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        firstNumber.setCountryCode(secondNumberCountryCode);
        {
            boolean varFF0709B6FD4A212C6A2A3AAFF8AF6F2C_378494374 = (firstNumber.exactlySameAs(secondNumber));
        } //End collapsed parenthetic
        {
            boolean var5CAFDF8CDD6EF1F618DB5BB207D00EF6_1675288025 = (isNationalNumberSuffixOfTheOther(firstNumber, secondNumber));
        } //End collapsed parenthetic
        return (MatchType)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.376 -0400", hash_original_method = "B2A134716BB483331B78911F7265BAC6", hash_generated_method = "CCBA7D0D04560E7C5352DD445B05F2FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isNationalNumberSuffixOfTheOther(PhoneNumber firstNumber,
                                                   PhoneNumber secondNumber) {
        dsTaint.addTaint(secondNumber.dsTaint);
        dsTaint.addTaint(firstNumber.dsTaint);
        String firstNumberNationalNumber;
        firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
        String secondNumberNationalNumber;
        secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
        boolean var7CCB98E4B8319542AA88D60C5E29610E_2005884890 = (firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           secondNumberNationalNumber.endsWith(firstNumberNationalNumber));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
        //String secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
        //return firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           //secondNumberNationalNumber.endsWith(firstNumberNationalNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.376 -0400", hash_original_method = "3C9E8BD2D7E8FA6C3BECA5B02E481416", hash_generated_method = "BED84C0DBEC8EAB1FB31A39B0DC15B70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MatchType isNumberMatch(String firstNumber, String secondNumber) {
        dsTaint.addTaint(secondNumber);
        dsTaint.addTaint(firstNumber);
        try 
        {
            PhoneNumber firstNumberAsProto;
            firstNumberAsProto = parse(firstNumber, UNKNOWN_REGION);
            MatchType varBC2D973F90C04F918A0C1206A1B12DD8_211380478 = (isNumberMatch(firstNumberAsProto, secondNumber));
        } //End block
        catch (NumberParseException e)
        {
            {
                boolean var89D3BC3CCC46DE71B07129DA6A1C3D48_1306756040 = (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                {
                    try 
                    {
                        PhoneNumber secondNumberAsProto;
                        secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
                        MatchType var7530C3C94E536A2F812FD2AF01F5FF04_1005541694 = (isNumberMatch(secondNumberAsProto, firstNumber));
                    } //End block
                    catch (NumberParseException e2)
                    {
                        {
                            boolean var463CDF6189F8ADE5C6F8D6C11E45E3C7_1468380382 = (e2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                            {
                                try 
                                {
                                    PhoneNumber firstNumberProto;
                                    firstNumberProto = new PhoneNumber();
                                    PhoneNumber secondNumberProto;
                                    secondNumberProto = new PhoneNumber();
                                    parseHelper(firstNumber, null, false, false, firstNumberProto);
                                    parseHelper(secondNumber, null, false, false, secondNumberProto);
                                    MatchType var690578F988EF9684C19C5AF5306E29A1_1325345840 = (isNumberMatch(firstNumberProto, secondNumberProto));
                                } //End block
                                catch (NumberParseException e3)
                                { }
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (MatchType)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.377 -0400", hash_original_method = "FA442F82D618375A0E3FFC54DA76D9E3", hash_generated_method = "404AAF4153D958272A3A1904246716CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MatchType isNumberMatch(PhoneNumber firstNumber, String secondNumber) {
        dsTaint.addTaint(secondNumber);
        dsTaint.addTaint(firstNumber.dsTaint);
        try 
        {
            PhoneNumber secondNumberAsProto;
            secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
            MatchType var6B4893CBADDA3C3C7D38C31B80F1348F_1694091562 = (isNumberMatch(firstNumber, secondNumberAsProto));
        } //End block
        catch (NumberParseException e)
        {
            {
                boolean var89D3BC3CCC46DE71B07129DA6A1C3D48_2087676143 = (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE);
                {
                    String firstNumberRegion;
                    firstNumberRegion = getRegionCodeForCountryCode(firstNumber.getCountryCode());
                    try 
                    {
                        {
                            boolean var255106447960ACE253D342CF9EF0C76A_1286828849 = (!firstNumberRegion.equals(UNKNOWN_REGION));
                            {
                                PhoneNumber secondNumberWithFirstNumberRegion;
                                secondNumberWithFirstNumberRegion = parse(secondNumber, firstNumberRegion);
                                MatchType match;
                                match = isNumberMatch(firstNumber, secondNumberWithFirstNumberRegion);
                            } //End block
                            {
                                PhoneNumber secondNumberProto;
                                secondNumberProto = new PhoneNumber();
                                parseHelper(secondNumber, null, false, false, secondNumberProto);
                                MatchType var48B728FEABEF7DCA484D81FEBC5038C7_816380840 = (isNumberMatch(firstNumber, secondNumberProto));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (NumberParseException e2)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (MatchType)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.377 -0400", hash_original_method = "93167700613734CAFA37F508460EB7E3", hash_generated_method = "2059BF7F296393F50F2BF93ED5F798B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean canBeInternationallyDialled(PhoneNumber number) {
        dsTaint.addTaint(number.dsTaint);
        String regionCode;
        regionCode = getRegionCodeForNumber(number);
        String nationalSignificantNumber;
        nationalSignificantNumber = getNationalSignificantNumber(number);
        {
            boolean var49E3803795D2C1A2A31963B43E424E43_322831359 = (!hasValidRegionCode(regionCode, number.getCountryCode(), nationalSignificantNumber));
        } //End collapsed parenthetic
        PhoneMetadata metadata;
        metadata = getMetadataForRegion(regionCode);
        boolean varB254B21720CD001C28A66C6976015DBA_2057249196 = (!isNumberMatchingDesc(nationalSignificantNumber, metadata.getNoInternationalDialling()));
        return dsTaint.getTaintBoolean();
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
    
    static {
    String singleExtnSymbolsForMatching = "x\uFF58#\uFF03~\uFF5E";
    String singleExtnSymbolsForParsing = "," + singleExtnSymbolsForMatching;
    EXTN_PATTERNS_FOR_PARSING = createExtnPattern(singleExtnSymbolsForParsing);
    EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(singleExtnSymbolsForMatching);
  }
    
}


