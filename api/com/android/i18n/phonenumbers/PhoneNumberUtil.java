package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import com.android.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadataCollection;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneNumberDesc;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;

public class PhoneNumberUtil {

  /**
   * Helper initialiser method to create the regular-expression pattern to match extensions,
   * allowing the one-char extension symbols provided by {@code singleExtnSymbols}.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.502 -0500", hash_original_method = "F3F9C9A4CAA5DAE3DB959030B6EDB840", hash_generated_method = "67B293D2AF26DE41C2D417A4D0B2F3FC")
    
private static String createExtnPattern(String singleExtnSymbols) {
    // There are three regular expressions here. The first covers RFC 3966 format, where the
    // extension is added using ";ext=". The second more generic one starts with optional white
    // space and ends with an optional full stop (.), followed by zero or more spaces/tabs and then
    // the numbers themselves. The other one covers the special case of American numbers where the
    // extension is written with a hash at the end, such as "- 503#".
    // Note that the only capturing groups should be around the digits that you want to capture as
    // part of the extension, or else parsing will fail!
    // Canonical-equivalence doesn't seem to be an option with Android java, so we allow two options
    // for representing the accented o - the character itself, and one in the unicode decomposed
    // form with the combining acute accent.
    return (RFC3966_EXTN_PREFIX + CAPTURING_EXTN_DIGITS + "|" + "[ \u00A0\\t,]*" +
            "(?:ext(?:ensi(?:o\u0301?|\u00F3))?n?|\uFF45\uFF58\uFF54\uFF4E?|" +
            "[" + singleExtnSymbols + "]|int|anexo|\uFF49\uFF4E\uFF54)" +
            "[:\\.\uFF0E]?[ \u00A0\\t,-]*" + CAPTURING_EXTN_DIGITS + "#?|" +
            "[- ]+(" + DIGITS + "{1,5})#");
  }

  /**
   * Attempts to extract a possible number from the string passed in. This currently strips all
   * leading characters that cannot be used to start a phone number. Characters that can be used to
   * start a phone number are defined in the VALID_START_CHAR_PATTERN. If none of these characters
   * are found in the number passed in, an empty string is returned. This function also attempts to
   * strip off any alternative extensions or endings if two or more are present, such as in the case
   * of: (530) 583-6985 x302/x2303. The second extension here makes this actually two phone numbers,
   * (530) 583-6985 x302 and (530) 583-6985 x2303. We remove the second extension so that the first
   * number is parsed correctly.
   *
   * @param number  the string that might contain a phone number
   * @return        the number, stripped of any non-phone-number prefix (such as "Tel:") or an empty
   *                string if no character used to start phone numbers (such as + or any digit) is
   *                found in the number
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.576 -0500", hash_original_method = "D818734C49CD12D5628ABEAEEDEC1994", hash_generated_method = "1878B2C2DBB790029C3B85705DEE563D")
    
static String extractPossibleNumber(String number) {
    Matcher m = VALID_START_CHAR_PATTERN.matcher(number);
    if (m.find()) {
      number = number.substring(m.start());
      // Remove trailing non-alpha non-numerical characters.
      Matcher trailingCharsMatcher = UNWANTED_END_CHAR_PATTERN.matcher(number);
      if (trailingCharsMatcher.find()) {
        number = number.substring(0, trailingCharsMatcher.start());
        LOGGER.log(Level.FINER, "Stripped trailing characters: " + number);
      }
      // Check for extra numbers at the end.
      Matcher secondNumber = SECOND_NUMBER_START_PATTERN.matcher(number);
      if (secondNumber.find()) {
        number = number.substring(0, secondNumber.start());
      }
      return number;
    } else {
      return "";
    }
  }

  /**
   * Checks to see if the string of characters could possibly be a phone number at all. At the
   * moment, checks to see that the string begins with at least 3 digits, ignoring any punctuation
   * commonly found in phone numbers.
   * This method does not require the number to be normalized in advance - but does assume that
   * leading non-number symbols have been removed, such as by the method extractPossibleNumber.
   *
   * @param number  string to be checked for viability as a phone number
   * @return        true if the number could be a phone number of some sort, otherwise false
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.578 -0500", hash_original_method = "F8B1494236C94478C90C2AF36B5BB0DF", hash_generated_method = "B8626553B4904FE523436AA8BCB044F6")
    
static boolean isViablePhoneNumber(String number) {
    if (number.length() < MIN_LENGTH_FOR_NSN) {
      return false;
    }
    Matcher m = VALID_PHONE_NUMBER_PATTERN.matcher(number);
    return m.matches();
  }

  /**
   * Normalizes a string of characters representing a phone number. This performs the following
   * conversions:
   *   Punctuation is stripped.
   *   For ALPHA/VANITY numbers:
   *   Letters are converted to their numeric representation on a telephone keypad. The keypad
   *       used here is the one defined in ITU Recommendation E.161. This is only done if there are
   *       3 or more letters in the number, to lessen the risk that such letters are typos.
   *   For other numbers:
   *   Wide-ascii digits are converted to normal ASCII (European) digits.
   *   Arabic-Indic numerals are converted to European numerals.
   *   Spurious alpha characters are stripped.
   *
   * @param number  a string of characters representing a phone number
   * @return        the normalized string version of the phone number
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.580 -0500", hash_original_method = "B852DEDF2BEDB6040A8893210C30801F", hash_generated_method = "79B9C6D2D5970971739C153D034DB073")
    
static String normalize(String number) {
    Matcher m = VALID_ALPHA_PHONE_PATTERN.matcher(number);
    if (m.matches()) {
      return normalizeHelper(number, ALPHA_PHONE_MAPPINGS, true);
    } else {
      return normalizeDigitsOnly(number);
    }
  }

  /**
   * Normalizes a string of characters representing a phone number. This is a wrapper for
   * normalize(String number) but does in-place normalization of the StringBuilder provided.
   *
   * @param number  a StringBuilder of characters representing a phone number that will be
   *     normalized in place
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.583 -0500", hash_original_method = "D42F831C75A739394DFADDB25E708507", hash_generated_method = "9F857C9E4BC340159E71AA29BA08A6A6")
    
static void normalize(StringBuilder number) {
    String normalizedNumber = normalize(number.toString());
    number.replace(0, number.length(), normalizedNumber);
  }

  /**
   * Normalizes a string of characters representing a phone number. This converts wide-ascii and
   * arabic-indic numerals to European numerals, and strips punctuation and alpha characters.
   *
   * @param number  a string of characters representing a phone number
   * @return        the normalized string version of the phone number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.585 -0500", hash_original_method = "502EEC6D6B5F71F00D0D11A03A19BB8B", hash_generated_method = "DD31D79C2D1D691E5A7EF9F1BC80F45C")
    
public static String normalizeDigitsOnly(String number) {
    return normalizeDigits(number, false /* strip non-digits */).toString();
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.587 -0500", hash_original_method = "359C33F05F722664FD26256E64417929", hash_generated_method = "07640CBE68C49280D205745174A0A3B0")
    
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

  /**
   * Converts all alpha characters in a number to their respective digits on a keypad, but retains
   * existing formatting.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.590 -0500", hash_original_method = "9F81C9B92A40C7BE142AACFEAE731136", hash_generated_method = "E6C110CF21011A984675F29C5BCF7A72")
    
public static String convertAlphaCharactersInNumber(String number) {
    return normalizeHelper(number, ALPHA_PHONE_MAPPINGS, false);
  }

  /**
   * Normalizes a string of characters representing a phone number by replacing all characters found
   * in the accompanying map with the values therein, and stripping all other characters if
   * removeNonMatches is true.
   *
   * @param number                     a string of characters representing a phone number
   * @param normalizationReplacements  a mapping of characters to what they should be replaced by in
   *                                   the normalized version of the phone number
   * @param removeNonMatches           indicates whether characters that are not able to be replaced
   *                                   should be stripped from the number. If this is false, they
   *                                   will be left unchanged in the number.
   * @return  the normalized string version of the phone number
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.598 -0500", hash_original_method = "1633DBFD6FFC6BC177209C717F6C9736", hash_generated_method = "E18B0A0DD9E747175446C7FBE511CB94")
    
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
      // If neither of the above are true, we remove this character.
    }
    return normalizedNumber.toString();
  }

  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.600 -0500", hash_original_method = "B02D8B233D913131328D345E9D5C7AB1", hash_generated_method = "991F6C3EA19CDE01D5A23171EB1323D7")
    
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

  /**
   * Used for testing purposes only to reset the PhoneNumberUtil singleton to null.
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.603 -0500", hash_original_method = "4B942EE039798DCE4C7F36FBC1F64250", hash_generated_method = "97FE6B503DABE6F3C4DE1F19161764AE")
    
static synchronized void resetInstance() {
    instance = null;
  }

  /**
   * Gets a {@link PhoneNumberUtil} instance to carry out international phone number formatting,
   * parsing, or validation. The instance is loaded with phone number metadata for a number of most
   * commonly used regions.
   *
   * <p>The {@link PhoneNumberUtil} is implemented as a singleton. Therefore, calling getInstance
   * multiple times will only result in one instance being created.
   *
   * @return a PhoneNumberUtil instance
   */
  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.608 -0500", hash_original_method = "45DACE940983711BED948D6127B59415", hash_generated_method = "36E845520BBE50256B72281DE5C5AD05")
    
public static synchronized PhoneNumberUtil getInstance() {
    if (instance == null) {
      return getInstance(META_DATA_FILE_PREFIX,
          CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
    }
    return instance;
  }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.408 -0500", hash_original_field = "2EE254FBB2114D976030473EFCCDBFA6", hash_generated_field = "56358BB2B93B97106608814280D6666E")

  static final int REGEX_FLAGS = Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.411 -0500", hash_original_field = "2352E74E8791A0338F563D465C24F02D", hash_generated_field = "78162C39327AD811876D6287CE97DE9A")

  private static final int MIN_LENGTH_FOR_NSN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.413 -0500", hash_original_field = "17AFDDC2CA0BAC1F4D9DBA28D2D4CEA6", hash_generated_field = "9FB78E1175F6C9C6A8605B6EDAA89F3A")

  static final int MAX_LENGTH_FOR_NSN = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.415 -0500", hash_original_field = "DF0E84A9DDAA1BE7DF9DE95D72584BF4", hash_generated_field = "B536601172E5FEA598125C5319675976")

  static final int MAX_LENGTH_COUNTRY_CODE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.418 -0500", hash_original_field = "00FDD469F7DB069D6990D6B7A6A5590A", hash_generated_field = "1AB5B395372E5B768BCBBA5C4037C039")

  static final String META_DATA_FILE_PREFIX =
      "/com/android/i18n/phonenumbers/data/PhoneNumberMetadataProto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.422 -0500", hash_original_field = "E1AB85E87D4265EC79DC1618D30FF877", hash_generated_field = "EE197B49B9DBA77F840ACF7281744106")

  private static final Logger LOGGER = Logger.getLogger(PhoneNumberUtil.class.getName());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.429 -0500", hash_original_field = "F9B2DAA01D1D01E131F80262024D62C2", hash_generated_field = "37E07E112B24C23DECA9CE91C20C0533")

  private static final String UNKNOWN_REGION = "ZZ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.434 -0500", hash_original_field = "8F981D8C6EA312EDE5C0345316C7D685", hash_generated_field = "3781137D5EFBC743F6AF42421A78AAB0")

  private static final int NANPA_COUNTRY_CODE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.436 -0500", hash_original_field = "3428FEC088E09ED623FEA5D93C0F1247", hash_generated_field = "DB0682C1F895DEC76B13EE471B2B2AAB")

  static final char PLUS_SIGN = '+';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.438 -0500", hash_original_field = "2D88DAECEBE32D45C56B629647529DAB", hash_generated_field = "0D4345D843431079FA3A87145DDC0F83")

  private static final String RFC3966_EXTN_PREFIX = ";ext=";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.441 -0500", hash_original_field = "6965DFBCDFC480639A05054173361ED6", hash_generated_field = "AC50CA36F96F68F3E68F8306B67F17A6")

  private static  Map<Character, Character> ALPHA_MAPPINGS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.444 -0500", hash_original_field = "D75C3A1213EE0946FE95A805C408E597", hash_generated_field = "6540E96DA6A170C8F59559A1CA13BA85")

  private static  Map<Character, Character> ALPHA_PHONE_MAPPINGS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.446 -0500", hash_original_field = "39AB3E9BABCE8C10BCB074EC5FD379C1", hash_generated_field = "3D7C45FBAB6A653CE0CA6858498FFDAB")

  // includes digits, ASCII letters and number grouping symbols such as "-" and " ".
  private static  Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.451 -0500", hash_original_field = "A41ABC7FB28F889AF46826F8B5918D5F", hash_generated_field = "6E6EF27177B7EE7BE3E0A55B948E31E9")

  // prefix or not. If a region has a unique international prefix (e.g. 011 in USA), it will be
  // represented as a string that contains a sequence of ASCII digits. If there are multiple
  // available international prefixes in a region, they will be represented as a regex string that
  // always contains character(s) other than ASCII digits.
  // Note this regex also includes tilde, which signals waiting for the tone.
  private static final Pattern UNIQUE_INTERNATIONAL_PREFIX =
      Pattern.compile("[\\d]+(?:[~\u2053\u223C\uFF5E][\\d]+)?");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.453 -0500", hash_original_field = "4202EFDC2CB4B47E9517F3D521652046", hash_generated_field = "F8334FEDAA2C215086A3DFFCEB363B92")

  // found as a leading character only.
  // This consists of dash characters, white space characters, full stops, slashes,
  // square brackets, parentheses and tildes. It also includes the letter 'x' as that is found as a
  // placeholder for carrier information in some phone numbers. Full-width variants are also
  // present.
  static final String VALID_PUNCTUATION = "-x\u2010-\u2015\u2212\u30FC\uFF0D-\uFF0F " +
      "\u00A0\u200B\u2060\u3000()\uFF08\uFF09\uFF3B\uFF3D.\\[\\]/~\u2053\u223C\uFF5E";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.455 -0500", hash_original_field = "B73158DA109438B9AAE73E11F3A97553", hash_generated_field = "711CAD69779EE34D5918FEE07224547C")

  private static final String DIGITS = "\\p{Nd}";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.458 -0500", hash_original_field = "50285C30179D9C48D2A80776E6E54475", hash_generated_field = "8C02DF099CE2D84C3EB4B1BAFB9529C4")

  private static final String VALID_ALPHA =
      Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", "") +
      Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.460 -0500", hash_original_field = "E8B148341C573FA6588735FC52C34E3A", hash_generated_field = "7AA5C25A8B485E30A73BF5904752D094")

  static final String PLUS_CHARS = "+\uFF0B";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.463 -0500", hash_original_field = "5F6C43FF3C92D714961950CEA04D1AFA", hash_generated_field = "401A10BEE2C1F4B3E23F174296449756")

  static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[" + PLUS_CHARS + "]+");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.465 -0500", hash_original_field = "A49A7010FA75155DB1B50E9EF4396DC7", hash_generated_field = "A769130D6DB113058C6FB971BC0E9EE8")

  private static final Pattern SEPARATOR_PATTERN = Pattern.compile("[" + VALID_PUNCTUATION + "]+");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.468 -0500", hash_original_field = "9C2B81CECB97156973F34D9F32BBD02D", hash_generated_field = "B9B6B3DB4626D33FCBE2CDF6FFFC1DF0")

  private static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(" + DIGITS + ")");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.471 -0500", hash_original_field = "08DCB72CEA223C7EA6DA5F0DD892A6BC", hash_generated_field = "8ECF4F61DCCE24445FCC7EC69C3CAF43")

  // parsing. This allows us to strip away meaningless prefixes to phone numbers that may be
  // mistakenly given to us. This consists of digits, the plus symbol and arabic-indic digits. This
  // does not contain alpha characters, although they may be used later in the number. It also does
  // not include other punctuation, as this will be stripped later during parsing and is of no
  // information value when parsing a number.
  private static final String VALID_START_CHAR = "[" + PLUS_CHARS + DIGITS + "]";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.473 -0500", hash_original_field = "D9D9D6CA6226A53DA11F0104D9E2E9AE", hash_generated_field = "5445004A965BB01D6385471341B37DC8")

  private static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.476 -0500", hash_original_field = "14FF75578718A7C33E12CE6721A9A076", hash_generated_field = "226C70E4A7BFCD82A37F2590C4339C22")

  // of parsing. This allows us to strip off parts of the number that are actually the start of
  // another number, such as for: (530) 583-6985 x302/x2303 -> the second extension here makes this
  // actually two phone numbers, (530) 583-6985 x302 and (530) 583-6985 x2303. We remove the second
  // extension so that the first number is parsed correctly.
  private static final String SECOND_NUMBER_START = "[\\\\/] *x";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.478 -0500", hash_original_field = "EA305FA54C26E2B52501826320FD1028", hash_generated_field = "1E52F9393C161A1B744DE8FBB2E11684")

  static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.480 -0500", hash_original_field = "AE827B8091E8A34AB0096FB2C4D8BDF6", hash_generated_field = "61DEB39A0A48FFF0B292960E2E87C494")

  // are not alpha or numerical characters. The hash character is retained here, as it may signify
  // the previous block was an extension.
  private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.483 -0500", hash_original_field = "78E19212CE74F4E32088EB2EF135BDB9", hash_generated_field = "FB0CEF5E0208B9E75B56CCBEC3289130")

  static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.486 -0500", hash_original_field = "2B3F6D4F17399BB799AD2B7514C09FAA", hash_generated_field = "324B07E5402274CAB596808312811362")

  // we treat it as a number where some phone-number digits are represented by letters.
  private static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.489 -0500", hash_original_field = "EAC30438E9FE92FCB8DAD1988760BE5A", hash_generated_field = "79877C794AA1274ECF8919966F9F4167")

  // least three leading digits, and only valid punctuation, alpha characters and
  // digits in the phone number. Does not include extension data.
  // The symbol 'x' is allowed here as valid punctuation since it is often used as a placeholder for
  // carrier codes, for example in Brazilian phone numbers. We also allow multiple "+" characters at
  // the start.
  // Corresponds to the following:
  // plus_sign*([punctuation]*[digits]){3,}([punctuation]|[digits]|[alpha])*
  // Note VALID_PUNCTUATION starts with a -, so must be the first in the range.
  private static final String VALID_PHONE_NUMBER =
      "[" + PLUS_CHARS + "]*(?:[" + VALID_PUNCTUATION + "]*" + DIGITS + "){3,}[" +
      VALID_PUNCTUATION + VALID_ALPHA + DIGITS + "]*";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.492 -0500", hash_original_field = "BB5FFCF32747382613734D1C858A21C3", hash_generated_field = "FAAD7105CC442B975E1EC395D4501512")

  // component of the number, after the main national number is formatted. For example, if you wish
  // the default extension formatting to be " extn: 3456", then you should specify " extn: " here
  // as the default extension prefix. This can be overridden by region-specific preferences.
  private static final String DEFAULT_EXTN_PREFIX = " ext. ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.494 -0500", hash_original_field = "5C34828AF11643C7293AA3EDCEF4858E", hash_generated_field = "098DD447AC31B654629B29311E698075")

  // extension.
  private static final String CAPTURING_EXTN_DIGITS = "(" + DIGITS + "{1,7})";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.497 -0500", hash_original_field = "D23731A7BED40604A5C718491A11707D", hash_generated_field = "CC5CB6A81707833919959BD458A3D0C0")

  // case-insensitive regexp match. Wide character versions are also provided after each ASCII
  // version.
  private static  String EXTN_PATTERNS_FOR_PARSING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.499 -0500", hash_original_field = "89CD6577F89C54CC73F93BFB947EF1A8", hash_generated_field = "8AEC46C66A511C8270E50678714A3A2B")

  static  String EXTN_PATTERNS_FOR_MATCHING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.504 -0500", hash_original_field = "258FAF0880237850BEF68B5DC9E79E02", hash_generated_field = "D61C5130DAF60B2D06C0B7C8B302AFAD")

  // digits, for use when parsing.
  private static final Pattern EXTN_PATTERN =
      Pattern.compile("(?:" + EXTN_PATTERNS_FOR_PARSING + ")$", REGEX_FLAGS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.507 -0500", hash_original_field = "1D57F9FD66680DAEB6930ADA784E9FDA", hash_generated_field = "B90528D8AD220FDBA7722E7CCB3F8213")

  // have an extension prefix appended, followed by 1 or more digits.
  private static final Pattern VALID_PHONE_NUMBER_PATTERN =
      Pattern.compile(VALID_PHONE_NUMBER + "(?:" + EXTN_PATTERNS_FOR_PARSING + ")?", REGEX_FLAGS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.509 -0500", hash_original_field = "4607230F4F71F1298C5350C2695ACEB4", hash_generated_field = "FC9AE1E47D90D61831285D6FD294822D")

  private static final Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.512 -0500", hash_original_field = "6B9D1F91A31C0162B2C238BD1C3124FC", hash_generated_field = "AA36E7D11D96CAEB20FCF9BCC0C06DA2")

  // first group is not used in the national pattern (e.g. Argentina) so the $1 group does not match
  // correctly.  Therefore, we use \d, so that the first group actually used in the pattern will be
  // matched.
  private static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.516 -0500", hash_original_field = "FC60D1F885B5DCC58B28D8FEA3D4C8EA", hash_generated_field = "76DFAE47B27AFFA44F784EF45ADDE2F5")

  private static final Pattern NP_PATTERN = Pattern.compile("\\$NP");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.518 -0500", hash_original_field = "7CCF7FF67869C938E4F2FAC55BEB52C7", hash_generated_field = "D09CBC3025CAAF7951C4B16225B988EE")

  private static final Pattern FG_PATTERN = Pattern.compile("\\$FG");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.520 -0500", hash_original_field = "56B5A4C12FC2DDF4C74EE752E1297059", hash_generated_field = "35A2F87A120AD2F2C401B83B05F83EA2")

  private static final Pattern CC_PATTERN = Pattern.compile("\\$CC");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.523 -0500", hash_original_field = "236890104E115C57EC7AE6F9C0068317", hash_generated_field = "90932A776869C6233A72E88783493EDF")

  private static PhoneNumberUtil instance = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.420 -0500", hash_original_field = "68123B7DAB8881BE14176B37EE8647CB", hash_generated_field = "01E27589414D4F00E028D65F7226ED03")

  private String currentFilePrefix = META_DATA_FILE_PREFIX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.424 -0500", hash_original_field = "C0338DF5F2398AFF9095002013B83C28", hash_generated_field = "B01511052A1CC7622F8157D2143CB85D")

  // by that country calling code. In the case of multiple regions sharing a calling code, such as
  // the NANPA regions, the one indicated with "isMainCountryForCode" in the metadata should be
  // first.
  private Map<Integer, List<String>> countryCallingCodeToRegionCodeMap = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.427 -0500", hash_original_field = "B27D8E3C847FAEDFDE3E89B8D369CE44", hash_generated_field = "B67A9603ABA1B03FD8D99F033BEB0FA4")

  // There are roughly 220 of them and we set the initial capacity of the HashSet to 300 to offer a
  // load factor of roughly 0.75.
  private final Set<String> supportedRegions = new HashSet<String>(300);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.431 -0500", hash_original_field = "9C9BC4CFF77CA56F8D199F0A15584B4F", hash_generated_field = "224E38B89012D44675A611BF87EAA8A7")

  // There are roughly 26 regions and we set the initial capacity of the HashSet to 35 to offer a
  // load factor of roughly 0.75.
  private final Set<String> nanpaRegions = new HashSet<String>(35);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.525 -0500", hash_original_field = "8F1330CE2315805A3743CA9A10F29D53", hash_generated_field = "34A606E45DB6BE384928258B5F11EAAA")

  private final Map<String, PhoneMetadata> regionToMetadataMap =
      Collections.synchronizedMap(new HashMap<String, PhoneMetadata>());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.527 -0500", hash_original_field = "95C344E0DA8500700EFC70F1A6A03863", hash_generated_field = "2DB7703817299FF95F26D3D78ED6EF7A")

  // As most people use phone numbers primarily from one to two countries, and there are roughly 60
  // regular expressions needed, the initial capacity of 100 offers a rough load factor of 0.75.
  private RegexCache regexCache = new RegexCache(100);

  /**
   * This class implements a singleton, so the only constructor is private.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.566 -0500", hash_original_method = "3DBAF8008FFD9E53011E9436972AF77A", hash_generated_method = "58A526AFE359054B3C6F6D717E308EE5")
    
private PhoneNumberUtil() {
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.568 -0500", hash_original_method = "E42A7007FDB19817C28C648F3339DD4F", hash_generated_method = "B98FF5E533FD0C3B92D1F1FA46653DE4")
    
private void init(String filePrefix) {
    currentFilePrefix = filePrefix;
    for (List<String> regionCodes : countryCallingCodeToRegionCodeMap.values()) {
      supportedRegions.addAll(regionCodes);
    }
    nanpaRegions.addAll(countryCallingCodeToRegionCodeMap.get(NANPA_COUNTRY_CODE));
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.570 -0500", hash_original_method = "D4A5DED95C2EE22965F522507C270AF5", hash_generated_method = "F3D2D885F9CC0FADCB939DD34AAFF003")
    
private void loadMetadataForRegionFromFile(String filePrefix, String regionCode) {
    InputStream source =
        PhoneNumberUtil.class.getResourceAsStream(filePrefix + "_" + regionCode);
    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(source);
      PhoneMetadataCollection metadataCollection = new PhoneMetadataCollection();
      metadataCollection.readExternal(in);
      for (PhoneMetadata metadata : metadataCollection.getMetadataList()) {
        regionToMetadataMap.put(regionCode, metadata);
      }
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, e.toString());
    } finally {
      close(in);
    }
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.572 -0500", hash_original_method = "A1113EBAB3D0682FE612F1231142344C", hash_generated_method = "AE3245B2725FCEC74728EDFA1A599E40")
    
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
   * Gets the length of the geographical area code in the {@code nationalNumber_} field of the
   * PhoneNumber object passed in, so that clients could use it to split a national significant
   * number into geographical area code and subscriber number. It works in such a way that the
   * resultant subscriber number should be diallable, at least on some devices. An example of how
   * this could be used:
   *
   * <pre>
   * PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
   * PhoneNumber number = phoneUtil.parse("16502530000", "US");
   * String nationalSignificantNumber = phoneUtil.getNationalSignificantNumber(number);
   * String areaCode;
   * String subscriberNumber;
   *
   * int areaCodeLength = phoneUtil.getLengthOfGeographicalAreaCode(number);
   * if (areaCodeLength > 0) {
   *   areaCode = nationalSignificantNumber.substring(0, areaCodeLength);
   *   subscriberNumber = nationalSignificantNumber.substring(areaCodeLength);
   * } else {
   *   areaCode = "";
   *   subscriberNumber = nationalSignificantNumber;
   * }
   * </pre>
   *
   * N.B.: area code is a very ambiguous concept, so the I18N team generally recommends against
   * using it for most purposes, but recommends using the more general {@code national_number}
   * instead. Read the following carefully before deciding to use this method:
   * <ul>
   *  <li> geographical area codes change over time, and this method honors those changes;
   *    therefore, it doesn't guarantee the stability of the result it produces.
   *  <li> subscriber numbers may not be diallable from all devices (notably mobile devices, which
   *    typically requires the full national_number to be dialled in most regions).
   *  <li> most non-geographical numbers have no area codes.
   *  <li> some geographical numbers have no area codes.
   * </ul>
   * @param number  the PhoneNumber object for which clients want to know the length of the area
   *     code.
   * @return  the length of area code of the PhoneNumber object passed in.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.592 -0500", hash_original_method = "E944B5FE31AE1466662F85766A880CA9", hash_generated_method = "9C1248D167641CF2C1B4572793ABA444")
    
public int getLengthOfGeographicalAreaCode(PhoneNumber number) {
    String regionCode = getRegionCodeForNumber(number);
    if (!isValidRegionCode(regionCode)) {
      return 0;
    }
    PhoneMetadata metadata = getMetadataForRegion(regionCode);
    if (!metadata.hasNationalPrefix()) {
      return 0;
    }

    PhoneNumberType type = getNumberTypeHelper(getNationalSignificantNumber(number),
                                               metadata);
    // Most numbers other than the two types below have to be dialled in full.
    if (type != PhoneNumberType.FIXED_LINE && type != PhoneNumberType.FIXED_LINE_OR_MOBILE) {
      return 0;
    }

    return getLengthOfNationalDestinationCode(number);
  }

  /**
   * Gets the length of the national destination code (NDC) from the PhoneNumber object passed in,
   * so that clients could use it to split a national significant number into NDC and subscriber
   * number. The NDC of a phone number is normally the first group of digit(s) right after the
   * country calling code when the number is formatted in the international format, if there is a
   * subscriber number part that follows. An example of how this could be used:
   *
   * <pre>
   * PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
   * PhoneNumber number = phoneUtil.parse("18002530000", "US");
   * String nationalSignificantNumber = phoneUtil.getNationalSignificantNumber(number);
   * String nationalDestinationCode;
   * String subscriberNumber;
   *
   * int nationalDestinationCodeLength = phoneUtil.getLengthOfNationalDestinationCode(number);
   * if (nationalDestinationCodeLength > 0) {
   *   nationalDestinationCode = nationalSignificantNumber.substring(0,
   *       nationalDestinationCodeLength);
   *   subscriberNumber = nationalSignificantNumber.substring(nationalDestinationCodeLength);
   * } else {
   *   nationalDestinationCode = "";
   *   subscriberNumber = nationalSignificantNumber;
   * }
   * </pre>
   *
   * Refer to the unittests to see the difference between this function and
   * {@link #getLengthOfGeographicalAreaCode}.
   *
   * @param number  the PhoneNumber object for which clients want to know the length of the NDC.
   * @return  the length of NDC of the PhoneNumber object passed in.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.595 -0500", hash_original_method = "8F375C460DFE06AB35507021B2E67F57", hash_generated_method = "5DD8A38D9D2AF5DCDBCF8A4D2998094B")
    
public int getLengthOfNationalDestinationCode(PhoneNumber number) {
    PhoneNumber copiedProto;
    if (number.hasExtension()) {
      // We don't want to alter the proto given to us, but we don't want to include the extension
      // when we format it, so we copy it and clear the extension here.
      copiedProto = new PhoneNumber();
      copiedProto.mergeFrom(number);
      copiedProto.clearExtension();
    } else {
      copiedProto = number;
    }

    String nationalSignificantNumber = format(copiedProto,
                                              PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
    String[] numberGroups = NON_DIGITS_PATTERN.split(nationalSignificantNumber);
    // The pattern will start with "+COUNTRY_CODE " so the first group will always be the empty
    // string (before the + symbol) and the second group will be the country calling code. The third
    // group will be area code if it is not the last group.
    if (numberGroups.length <= 3) {
      return 0;
    }

    if (getRegionCodeForNumber(number).equals("AR") &&
        getNumberType(number) == PhoneNumberType.MOBILE) {
      // Argentinian mobile numbers, when formatted in the international format, are in the form of
      // +54 9 NDC XXXX.... As a result, we take the length of the third group (NDC) and add 1 for
      // the digit 9, which also forms part of the national significant number.
      //
      // TODO: Investigate the possibility of better modeling the metadata to make it
      // easier to obtain the NDC.
      return numberGroups[3].length() + 1;
    }
    return numberGroups[2].length();
  }

  /**
   * Convenience method to enable tests to get a list of what regions the library has metadata for.
   */
  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.606 -0500", hash_original_method = "8806D3371D9E306571E478F8E387F5F6", hash_generated_method = "7A63E47DA7C73A68176E74926A7271A6")
    
public Set<String> getSupportedRegions() {
    return supportedRegions;
  }

  /**
   * Helper function to check region code is not unknown or null.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.610 -0500", hash_original_method = "BD64224247A46B4F8D1913B12FB0926A", hash_generated_method = "20C4A11C84C16E3B2A340ABC8FD1643C")
    
private boolean isValidRegionCode(String regionCode) {
    return regionCode != null && supportedRegions.contains(regionCode);
  }

  /**
   * Helper function to check region code is not unknown or null and log an error message. The
   * {@code countryCallingCode} and {@code number} supplied is used only for the resultant log
   * message.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.613 -0500", hash_original_method = "8968A71862E924379D457A4D52F2E514", hash_generated_method = "C4546F917A320DFFBE238A989020BEAC")
    
private boolean hasValidRegionCode(String regionCode,
                                     int countryCallingCode, String number) {
    if (!isValidRegionCode(regionCode)) {
      LOGGER.log(Level.WARNING,
                 "Number " + number + " has invalid or missing country calling code ("
                 + countryCallingCode + ")");
      return false;
    }
    return true;
  }

  /**
   * Formats a phone number in the specified format using default rules. Note that this does not
   * promise to produce a phone number that the user can dial from where they are - although we do
   * format in either 'national' or 'international' format depending on what the client asks for, we
   * do not currently support a more abbreviated format, such as for users in the same "area" who
   * could potentially dial the number without area code. Note that if the phone number has a
   * country calling code of 0 or an otherwise invalid country calling code, we cannot work out
   * which formatting rules to apply so we return the national significant number with no formatting
   * applied.
   *
   * @param number         the phone number to be formatted
   * @param numberFormat   the format the phone number should be formatted into
   * @return  the formatted phone number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.615 -0500", hash_original_method = "92F92B14F8645805E8F2936964CC9FBD", hash_generated_method = "8751F1196ABFED4124845E28B475EB36")
    
public String format(PhoneNumber number, PhoneNumberFormat numberFormat) {
    if (number.getNationalNumber() == 0 && number.hasRawInput()) {
      String rawInput = number.getRawInput();
      if (rawInput.length() > 0) {
        return rawInput;
      }
    }
    StringBuilder formattedNumber = new StringBuilder(20);
    format(number, numberFormat, formattedNumber);
    return formattedNumber.toString();
  }

  /**
   * Same as {@link #format(Phonenumber.PhoneNumber, PhoneNumberUtil.PhoneNumberFormat)}, but
   * accepts a mutable StringBuilder as a parameter to decrease object creation when invoked many
   * times.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.617 -0500", hash_original_method = "0E0E29DD0B07020C65FE41B70E3EF74E", hash_generated_method = "A97796C4F3705AFE065A6C6B097CE360")
    
public void format(PhoneNumber number, PhoneNumberFormat numberFormat,
                     StringBuilder formattedNumber) {
    // Clear the StringBuilder first.
    formattedNumber.setLength(0);
    int countryCallingCode = number.getCountryCode();
    String nationalSignificantNumber = getNationalSignificantNumber(number);
    if (numberFormat == PhoneNumberFormat.E164) {
      // Early exit for E164 case since no formatting of the national number needs to be applied.
      // Extensions are not formatted.
      formattedNumber.append(nationalSignificantNumber);
      formatNumberByFormat(countryCallingCode, PhoneNumberFormat.E164, formattedNumber);
      return;
    }
    // Note getRegionCodeForCountryCode() is used because formatting information for regions which
    // share a country calling code is contained by only one region for performance reasons. For
    // example, for NANPA regions it will be contained in the metadata for US.
    String regionCode = getRegionCodeForCountryCode(countryCallingCode);
    if (!isValidRegionCode(regionCode)) {
      formattedNumber.append(nationalSignificantNumber);
      return;
    }

    formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode, numberFormat));
    maybeGetFormattedExtension(number, regionCode, numberFormat, formattedNumber);
    formatNumberByFormat(countryCallingCode, numberFormat, formattedNumber);
  }

  /**
   * Formats a phone number in the specified format using client-defined formatting rules. Note that
   * if the phone number has a country calling code of zero or an otherwise invalid country calling
   * code, we cannot work out things like whether there should be a national prefix applied, or how
   * to format extensions, so we return the national significant number with no formatting applied.
   *
   * @param number                        the phone number to be formatted
   * @param numberFormat                  the format the phone number should be formatted into
   * @param userDefinedFormats            formatting rules specified by clients
   * @return  the formatted phone number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.621 -0500", hash_original_method = "9F9F17BED2EE6CF557E830A9924BD1F5", hash_generated_method = "BD84DEF6BD7A8932E311D72EE473B159")
    
public String formatByPattern(PhoneNumber number,
                                PhoneNumberFormat numberFormat,
                                List<NumberFormat> userDefinedFormats) {
    int countryCallingCode = number.getCountryCode();
    String nationalSignificantNumber = getNationalSignificantNumber(number);
    // Note getRegionCodeForCountryCode() is used because formatting information for regions which
    // share a country calling code is contained by only one region for performance reasons. For
    // example, for NANPA regions it will be contained in the metadata for US.
    String regionCode = getRegionCodeForCountryCode(countryCallingCode);
    if (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber)) {
      return nationalSignificantNumber;
    }
    List<NumberFormat> userDefinedFormatsCopy =
        new ArrayList<NumberFormat>(userDefinedFormats.size());
    for (NumberFormat numFormat : userDefinedFormats) {
      String nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
      if (nationalPrefixFormattingRule.length() > 0) {
        // Before we do a replacement of the national prefix pattern $NP with the national prefix,
        // we need to copy the rule so that subsequent replacements for different numbers have the
        // appropriate national prefix.
        NumberFormat numFormatCopy = new NumberFormat();
        numFormatCopy.mergeFrom(numFormat);
        String nationalPrefix = getMetadataForRegion(regionCode).getNationalPrefix();
        if (nationalPrefix.length() > 0) {
          // Replace $NP with national prefix and $FG with the first group ($1).
          nationalPrefixFormattingRule =
              NP_PATTERN.matcher(nationalPrefixFormattingRule).replaceFirst(nationalPrefix);
          nationalPrefixFormattingRule =
              FG_PATTERN.matcher(nationalPrefixFormattingRule).replaceFirst("\\$1");
          numFormatCopy.setNationalPrefixFormattingRule(nationalPrefixFormattingRule);
        } else {
          // We don't want to have a rule for how to format the national prefix if there isn't one.
          numFormatCopy.clearNationalPrefixFormattingRule();
        }
        userDefinedFormatsCopy.add(numFormatCopy);
      } else {
        // Otherwise, we just add the original rule to the modified list of formats.
        userDefinedFormatsCopy.add(numFormat);
      }
    }

    StringBuilder formattedNumber =
        new StringBuilder(formatAccordingToFormats(nationalSignificantNumber,
                                                   userDefinedFormatsCopy,
                                                   numberFormat));
    maybeGetFormattedExtension(number, regionCode, numberFormat, formattedNumber);
    formatNumberByFormat(countryCallingCode, numberFormat, formattedNumber);
    return formattedNumber.toString();
  }

  /**
   * Formats a phone number in national format for dialing using the carrier as specified in the
   * {@code carrierCode}. The {@code carrierCode} will always be used regardless of whether the
   * phone number already has a preferred domestic carrier code stored. If {@code carrierCode}
   * contains an empty string, returns the number in national format without any carrier code.
   *
   * @param number  the phone number to be formatted
   * @param carrierCode  the carrier selection code to be used
   * @return  the formatted phone number in national format for dialing using the carrier as
   *          specified in the {@code carrierCode}
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.624 -0500", hash_original_method = "91C4446CD1D629D514A31D665364644B", hash_generated_method = "A9BB0CFDE5D5CAD72F417C1D18833850")
    
public String formatNationalNumberWithCarrierCode(PhoneNumber number, String carrierCode) {
    int countryCallingCode = number.getCountryCode();
    String nationalSignificantNumber = getNationalSignificantNumber(number);
    // Note getRegionCodeForCountryCode() is used because formatting information for regions which
    // share a country calling code is contained by only one region for performance reasons. For
    // example, for NANPA regions it will be contained in the metadata for US.
    String regionCode = getRegionCodeForCountryCode(countryCallingCode);
    if (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber)) {
      return nationalSignificantNumber;
    }

    StringBuilder formattedNumber = new StringBuilder(20);
    formattedNumber.append(formatNationalNumber(nationalSignificantNumber,
                                                regionCode,
                                                PhoneNumberFormat.NATIONAL,
                                                carrierCode));
    maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.NATIONAL, formattedNumber);
    formatNumberByFormat(countryCallingCode, PhoneNumberFormat.NATIONAL, formattedNumber);
    return formattedNumber.toString();
  }

  /**
   * Formats a phone number in national format for dialing using the carrier as specified in the
   * preferredDomesticCarrierCode field of the PhoneNumber object passed in. If that is missing,
   * use the {@code fallbackCarrierCode} passed in instead. If there is no
   * {@code preferredDomesticCarrierCode}, and the {@code fallbackCarrierCode} contains an empty
   * string, return the number in national format without any carrier code.
   *
   * <p>Use {@link #formatNationalNumberWithCarrierCode} instead if the carrier code passed in
   * should take precedence over the number's {@code preferredDomesticCarrierCode} when formatting.
   *
   * @param number  the phone number to be formatted
   * @param fallbackCarrierCode  the carrier selection code to be used, if none is found in the
   *     phone number itself
   * @return  the formatted phone number in national format for dialing using the number's
   *     {@code preferredDomesticCarrierCode}, or the {@code fallbackCarrierCode} passed in if
   *     none is found
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.626 -0500", hash_original_method = "4CA1ACD2C86EAA8A1981D39B6D2FA7BC", hash_generated_method = "7FB3FE630A903FF4A8A59C4053C3F3E0")
    
public String formatNationalNumberWithPreferredCarrierCode(PhoneNumber number,
                                                             String fallbackCarrierCode) {
    return formatNationalNumberWithCarrierCode(number, number.hasPreferredDomesticCarrierCode()
                                                       ? number.getPreferredDomesticCarrierCode()
                                                       : fallbackCarrierCode);
  }

  /**
   * Formats a phone number for out-of-country dialing purposes. If no regionCallingFrom is
   * supplied, we format the number in its INTERNATIONAL format. If the country calling code is the
   * same as that of the region where the number is from, then NATIONAL formatting will be applied.
   *
   * <p>If the number itself has a country calling code of zero or an otherwise invalid country
   * calling code, then we return the number with no formatting applied.
   *
   * <p>Note this function takes care of the case for calling inside of NANPA and between Russia and
   * Kazakhstan (who share the same country calling code). In those cases, no international prefix
   * is used. For regions which have multiple international prefixes, the number in its
   * INTERNATIONAL format will be returned instead.
   *
   * @param number               the phone number to be formatted
   * @param regionCallingFrom    the region where the call is being placed
   * @return  the formatted phone number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.630 -0500", hash_original_method = "F62393BCCF4A49D66E11EE7D750D9FD1", hash_generated_method = "C7769D4D9E71F259B552D85A4A5E6156")
    
public String formatOutOfCountryCallingNumber(PhoneNumber number,
                                                String regionCallingFrom) {
    if (!isValidRegionCode(regionCallingFrom)) {
      return format(number, PhoneNumberFormat.INTERNATIONAL);
    }
    int countryCallingCode = number.getCountryCode();
    String regionCode = getRegionCodeForCountryCode(countryCallingCode);
    String nationalSignificantNumber = getNationalSignificantNumber(number);
    if (!hasValidRegionCode(regionCode, countryCallingCode, nationalSignificantNumber)) {
      return nationalSignificantNumber;
    }
    if (countryCallingCode == NANPA_COUNTRY_CODE) {
      if (isNANPACountry(regionCallingFrom)) {
        // For NANPA regions, return the national format for these regions but prefix it with the
        // country calling code.
        return countryCallingCode + " " + format(number, PhoneNumberFormat.NATIONAL);
      }
    } else if (countryCallingCode == getCountryCodeForRegion(regionCallingFrom)) {
    // For regions that share a country calling code, the country calling code need not be dialled.
    // This also applies when dialling within a region, so this if clause covers both these cases.
    // Technically this is the case for dialling from La Reunion to other overseas departments of
    // France (French Guiana, Martinique, Guadeloupe), but not vice versa - so we don't cover this
    // edge case for now and for those cases return the version including country calling code.
    // Details here: http://www.petitfute.com/voyage/225-info-pratiques-reunion
      return format(number, PhoneNumberFormat.NATIONAL);
    }
    String formattedNationalNumber =
        formatNationalNumber(nationalSignificantNumber,
                             regionCode, PhoneNumberFormat.INTERNATIONAL);
    PhoneMetadata metadata = getMetadataForRegion(regionCallingFrom);
    String internationalPrefix = metadata.getInternationalPrefix();

    // For regions that have multiple international prefixes, the international format of the
    // number is returned, unless there is a preferred international prefix.
    String internationalPrefixForFormatting = "";
    if (UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches()) {
      internationalPrefixForFormatting = internationalPrefix;
    } else if (metadata.hasPreferredInternationalPrefix()) {
      internationalPrefixForFormatting = metadata.getPreferredInternationalPrefix();
    }

    StringBuilder formattedNumber = new StringBuilder(formattedNationalNumber);
    maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
    if (internationalPrefixForFormatting.length() > 0) {
      formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, " ")
          .insert(0, internationalPrefixForFormatting);
    } else {
      formatNumberByFormat(countryCallingCode,
                           PhoneNumberFormat.INTERNATIONAL,
                           formattedNumber);
    }
    return formattedNumber.toString();
  }

  /**
   * Formats a phone number using the original phone number format that the number is parsed from.
   * The original format is embedded in the country_code_source field of the PhoneNumber object
   * passed in. If such information is missing, the number will be formatted into the NATIONAL
   * format by default. When the number is an invalid number, the method returns the raw input when
   * it is available.
   *
   * @param number  the phone number that needs to be formatted in its original number format
   * @param regionCallingFrom  the region whose IDD needs to be prefixed if the original number
   *     has one
   * @return  the formatted phone number in its original number format
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.633 -0500", hash_original_method = "DB42BF938772B1A7D3909F64DD7B67BB", hash_generated_method = "57991C53495795310BAD1D0D0390D5DC")
    
public String formatInOriginalFormat(PhoneNumber number, String regionCallingFrom) {
    if (number.hasRawInput() &&
        (!hasFormattingPatternForNumber(number) || !isValidNumber(number))) {
      // We check if we have the formatting pattern because without that, we might format the number
      // as a group without national prefix. We also want to check the validity of the number
      // because we don't want to risk formatting the number if we don't really understand it.
      return number.getRawInput();
    }
    if (!number.hasCountryCodeSource()) {
      return format(number, PhoneNumberFormat.NATIONAL);
    }
    String formattedNumber;
    switch (number.getCountryCodeSource()) {
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
    }
    String rawInput = number.getRawInput();
    // If no digit is inserted/removed/modified as a result of our formatting, we return the
    // formatted phone number; otherwise we return the raw input the user entered.
    return (formattedNumber != null &&
            normalizeDigitsOnly(formattedNumber).equals(normalizeDigitsOnly(rawInput)))
        ? formattedNumber
        : rawInput;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.635 -0500", hash_original_method = "52E7EF7A7F940E41CFECD8D7BD9FA23C", hash_generated_method = "36AC022F8B0C1093C6102FA6E574B283")
    
private boolean hasFormattingPatternForNumber(PhoneNumber number) {
    String phoneNumberRegion = getRegionCodeForCountryCode(number.getCountryCode());
    PhoneMetadata metadata = getMetadataForRegion(phoneNumberRegion);
    if (metadata == null) {
      return false;
    }
    String nationalNumber = getNationalSignificantNumber(number);
    NumberFormat formatRule =
        chooseFormattingPatternForNumber(metadata.numberFormats(), nationalNumber);
    return formatRule != null;
  }

  /**
   * Formats a phone number for out-of-country dialing purposes.
   *
   * Note that in this version, if the number was entered originally using alpha characters and
   * this version of the number is stored in raw_input, this representation of the number will be
   * used rather than the digit representation. Grouping information, as specified by characters
   * such as "-" and " ", will be retained.
   *
   * <p><b>Caveats:</b></p>
   * <ul>
   *  <li> This will not produce good results if the country calling code is both present in the raw
   *       input _and_ is the start of the national number. This is not a problem in the regions
   *       which typically use alpha numbers.
   *  <li> This will also not produce good results if the raw input has any grouping information
   *       within the first three digits of the national number, and if the function needs to strip
   *       preceding digits/words in the raw input before these digits. Normally people group the
   *       first three digits together so this is not a huge problem - and will be fixed if it
   *       proves to be so.
   * </ul>
   *
   * @param number  the phone number that needs to be formatted
   * @param regionCallingFrom  the region where the call is being placed
   * @return  the formatted phone number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.639 -0500", hash_original_method = "4891B65BEA4A6D1403DAAAE11CCEEA80", hash_generated_method = "C846B337F6FC583FDD31C0ACD699FAE5")
    
public String formatOutOfCountryKeepingAlphaChars(PhoneNumber number,
                                                    String regionCallingFrom) {
    String rawInput = number.getRawInput();
    // If there is no raw input, then we can't keep alpha characters because there aren't any.
    // In this case, we return formatOutOfCountryCallingNumber.
    if (rawInput.length() == 0) {
      return formatOutOfCountryCallingNumber(number, regionCallingFrom);
    }
    int countryCode = number.getCountryCode();
    String regionCode = getRegionCodeForCountryCode(countryCode);
    if (!hasValidRegionCode(regionCode, countryCode, rawInput)) {
      return rawInput;
    }
    // Strip any prefix such as country calling code, IDD, that was present. We do this by comparing
    // the number in raw_input with the parsed number.
    // To do this, first we normalize punctuation. We retain number grouping symbols such as " "
    // only.
    rawInput = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
    // Now we trim everything before the first three digits in the parsed number. We choose three
    // because all valid alpha numbers have 3 digits at the start - if it does not, then we don't
    // trim anything at all. Similarly, if the national number was less than three digits, we don't
    // trim anything at all.
    String nationalNumber = getNationalSignificantNumber(number);
    if (nationalNumber.length() > 3) {
      int firstNationalNumberDigit = rawInput.indexOf(nationalNumber.substring(0, 3));
      if (firstNationalNumberDigit != -1) {
        rawInput = rawInput.substring(firstNationalNumberDigit);
      }
    }
    PhoneMetadata metadata = getMetadataForRegion(regionCallingFrom);
    if (countryCode == NANPA_COUNTRY_CODE) {
      if (isNANPACountry(regionCallingFrom)) {
        return countryCode + " " + rawInput;
      }
    } else if (countryCode == getCountryCodeForRegion(regionCallingFrom)) {
      // Here we copy the formatting rules so we can modify the pattern we expect to match against.
      List<NumberFormat> availableFormats =
          new ArrayList<NumberFormat>(metadata.numberFormatSize());
      for (NumberFormat format : metadata.numberFormats()) {
        NumberFormat newFormat = new NumberFormat();
        newFormat.mergeFrom(format);
        // The first group is the first group of digits that the user determined.
        newFormat.setPattern("(\\d+)(.*)");
        // Here we just concatenate them back together after the national prefix has been fixed.
        newFormat.setFormat("$1$2");
        availableFormats.add(newFormat);
      }
      // Now we format using these patterns instead of the default pattern, but with the national
      // prefix prefixed if necessary, by choosing the format rule based on the leading digits
      // present in the unformatted national number.
      // This will not work in the cases where the pattern (and not the leading digits) decide
      // whether a national prefix needs to be used, since we have overridden the pattern to match
      // anything, but that is not the case in the metadata to date.
      return formatAccordingToFormats(rawInput, availableFormats, PhoneNumberFormat.NATIONAL);
    }
    String internationalPrefix = metadata.getInternationalPrefix();
    // For countries that have multiple international prefixes, the international format of the
    // number is returned, unless there is a preferred international prefix.
    String internationalPrefixForFormatting =
        UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches()
        ? internationalPrefix
        : metadata.getPreferredInternationalPrefix();
    StringBuilder formattedNumber = new StringBuilder(rawInput);
    maybeGetFormattedExtension(number, regionCode, PhoneNumberFormat.INTERNATIONAL,
                               formattedNumber);
    if (internationalPrefixForFormatting.length() > 0) {
      formattedNumber.insert(0, " ").insert(0, countryCode).insert(0, " ")
          .insert(0, internationalPrefixForFormatting);
    } else {
      formatNumberByFormat(countryCode,
                           PhoneNumberFormat.INTERNATIONAL,
                           formattedNumber);
    }
    return formattedNumber.toString();
  }

  /**
   * Gets the national significant number of the a phone number. Note a national significant number
   * doesn't contain a national prefix or any formatting.
   *
   * @param number  the phone number for which the national significant number is needed
   * @return  the national significant number of the PhoneNumber object passed in
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.641 -0500", hash_original_method = "D5C4512E5E6006B319585FD039F0D2D2", hash_generated_method = "C3E49D776C51A5F3D0201F9A2718E045")
    
public String getNationalSignificantNumber(PhoneNumber number) {
    // If a leading zero has been set, we prefix this now. Note this is not a national prefix.
    StringBuilder nationalNumber = new StringBuilder(number.isItalianLeadingZero() ? "0" : "");
    nationalNumber.append(number.getNationalNumber());
    return nationalNumber.toString();
  }

  /**
   * A helper function that is used by format and formatByPattern.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.644 -0500", hash_original_method = "B30288467474491802F599221421F5DD", hash_generated_method = "427C79BD2D796E7EC25CBC8FEFE5D048")
    
private void formatNumberByFormat(int countryCallingCode,
                                    PhoneNumberFormat numberFormat,
                                    StringBuilder formattedNumber) {
    switch (numberFormat) {
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
  }

  // Simple wrapper of formatNationalNumber for the common case of no carrier code.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.646 -0500", hash_original_method = "E72DB4CB518547F268CF62BAEDE813DC", hash_generated_method = "E41EE6EE4203AD8BD5328C4669D8BBC4")
    
private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat) {
    return formatNationalNumber(number, regionCode, numberFormat, null);
  }

  // Note in some regions, the national number can be written in two completely different ways
  // depending on whether it forms part of the NATIONAL format or INTERNATIONAL format. The
  // numberFormat parameter here is used to specify which format to use for those cases. If a
  // carrierCode is specified, this will be inserted into the formatted string to replace $CC.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.649 -0500", hash_original_method = "C233FF64EBF86F393338B595D4311670", hash_generated_method = "E5D9E3D2BBEC1FB53DD17486DE016258")
    
private String formatNationalNumber(String number,
                                      String regionCode,
                                      PhoneNumberFormat numberFormat,
                                      String carrierCode) {
    PhoneMetadata metadata = getMetadataForRegion(regionCode);
    List<NumberFormat> intlNumberFormats = metadata.intlNumberFormats();
    // When the intlNumberFormats exists, we use that to format national number for the
    // INTERNATIONAL format instead of using the numberDesc.numberFormats.
    List<NumberFormat> availableFormats =
        (intlNumberFormats.size() == 0 || numberFormat == PhoneNumberFormat.NATIONAL)
        ? metadata.numberFormats()
        : metadata.intlNumberFormats();
    String formattedNationalNumber =
        formatAccordingToFormats(number, availableFormats, numberFormat, carrierCode);
    if (numberFormat == PhoneNumberFormat.RFC3966) {
      formattedNationalNumber =
          SEPARATOR_PATTERN.matcher(formattedNationalNumber).replaceAll("-");
    }
    return formattedNationalNumber;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.652 -0500", hash_original_method = "8234956A6CF3F674EC2E620926354B88", hash_generated_method = "C45E77743FA69F08863E86030F9BAC13")
    
private NumberFormat chooseFormattingPatternForNumber(List<NumberFormat> availableFormats,
                                                        String nationalNumber) {
    for (NumberFormat numFormat : availableFormats) {
      int size = numFormat.leadingDigitsPatternSize();
      if (size == 0 || regexCache.getPatternForRegex(
              // We always use the last leading_digits_pattern, as it is the most detailed.
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt()) {
        Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
        if (m.matches()) {
          return numFormat;
        }
      }
    }
    return null;
  }

  // Simple wrapper of formatAccordingToFormats for the common case of no carrier code.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.654 -0500", hash_original_method = "ABA7814B1012D26F514E5605C0CC3287", hash_generated_method = "EEA56B125F67851ED0CA5B2FEDFE9F9D")
    
private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat) {
    return formatAccordingToFormats(nationalNumber, availableFormats, numberFormat, null);
  }

  // Note that carrierCode is optional - if NULL or an empty string, no carrier code replacement
  // will take place.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.657 -0500", hash_original_method = "58A13E9521CF391FA7B0E516ACC9ED0C", hash_generated_method = "F4B13B0612D7B629EEA8C98D309D4BD8")
    
private String formatAccordingToFormats(String nationalNumber,
                                          List<NumberFormat> availableFormats,
                                          PhoneNumberFormat numberFormat,
                                          String carrierCode) {
    for (NumberFormat numFormat : availableFormats) {
      int size = numFormat.leadingDigitsPatternSize();
      if (size == 0 || regexCache.getPatternForRegex(
              // We always use the last leading_digits_pattern, as it is the most detailed.
              numFormat.getLeadingDigitsPattern(size - 1)).matcher(nationalNumber).lookingAt()) {
        Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
        if (m.matches()) {
          String numberFormatRule = numFormat.getFormat();
          if (numberFormat == PhoneNumberFormat.NATIONAL &&
              carrierCode != null && carrierCode.length() > 0 &&
              numFormat.getDomesticCarrierCodeFormattingRule().length() > 0) {
            // Replace the $CC in the formatting rule with the desired carrier code.
            String carrierCodeFormattingRule = numFormat.getDomesticCarrierCodeFormattingRule();
            carrierCodeFormattingRule =
                CC_PATTERN.matcher(carrierCodeFormattingRule).replaceFirst(carrierCode);
            // Now replace the $FG in the formatting rule with the first group and the carrier code
            // combined in the appropriate way.
            numberFormatRule = FIRST_GROUP_PATTERN.matcher(numberFormatRule)
                .replaceFirst(carrierCodeFormattingRule);
            return m.replaceAll(numberFormatRule);
          } else {
            // Use the national prefix formatting rule instead.
            String nationalPrefixFormattingRule = numFormat.getNationalPrefixFormattingRule();
            if (numberFormat == PhoneNumberFormat.NATIONAL &&
                nationalPrefixFormattingRule != null &&
                nationalPrefixFormattingRule.length() > 0) {
              Matcher firstGroupMatcher = FIRST_GROUP_PATTERN.matcher(numberFormatRule);
              return m.replaceAll(firstGroupMatcher.replaceFirst(nationalPrefixFormattingRule));
            } else {
              return m.replaceAll(numberFormatRule);
            }
          }
        }
      }
    }

    // If no pattern above is matched, we format the number as a whole.
    return nationalNumber;
  }

  /**
   * Gets a valid number for the specified region.
   *
   * @param regionCode  the region for which an example number is needed
   * @return  a valid fixed-line number for the specified region. Returns null when the metadata
   *    does not contain such information.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.660 -0500", hash_original_method = "B3C328ACE4FF3869EFF5C65F569BC538", hash_generated_method = "80F45C0F5113298585EB39A8E77BBA5D")
    
public PhoneNumber getExampleNumber(String regionCode) {
    return getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
  }

  /**
   * Gets a valid number for the specified region and number type.
   *
   * @param regionCode  the region for which an example number is needed
   * @param type  the type of number that is needed
   * @return  a valid number for the specified region and type. Returns null when the metadata
   *     does not contain such information or if an invalid region was entered.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.662 -0500", hash_original_method = "B7676779AEFA9EF56CC59B101D8DF6C5", hash_generated_method = "62F76DEB8BC9222499B88DC02473E166")
    
public PhoneNumber getExampleNumberForType(String regionCode, PhoneNumberType type) {
    // Check the region code is valid.
    if (!isValidRegionCode(regionCode)) {
      LOGGER.log(Level.WARNING, "Invalid or unknown region code provided.");
      return null;
    }
    PhoneNumberDesc desc = getNumberDescByType(getMetadataForRegion(regionCode), type);
    try {
      if (desc.hasExampleNumber()) {
        return parse(desc.getExampleNumber(), regionCode);
      }
    } catch (NumberParseException e) {
      LOGGER.log(Level.SEVERE, e.toString());
    }
    return null;
  }

  /**
   * Appends the formatted extension of a phone number to formattedNumber, if the phone number had
   * an extension specified.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.664 -0500", hash_original_method = "6C2C2EA977BB9169AEFD40896548847E", hash_generated_method = "4812754CEBC7DB7ED141B1C347E1AD87")
    
private void maybeGetFormattedExtension(PhoneNumber number, String regionCode,
                                          PhoneNumberFormat numberFormat,
                                          StringBuilder formattedNumber) {
    if (number.hasExtension() && number.getExtension().length() > 0) {
      if (numberFormat == PhoneNumberFormat.RFC3966) {
        formattedNumber.append(RFC3966_EXTN_PREFIX).append(number.getExtension());
      } else {
        formatExtension(number.getExtension(), regionCode, formattedNumber);
      }
    }
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
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.538 -0500", hash_original_method = "CACFF1960BF0F12395F09FD0D92A6AB3", hash_generated_method = "2854E6F3BAD07A32EF012BCBA5F5C5D9")
            
@Override
      boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        return util.isPossibleNumber(number);
      }
    },
    VALID {
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.541 -0500", hash_original_method = "2E9088AA6590F8142B440D6D7DF55E8C", hash_generated_method = "3FFCD53E8EF190D3673AA051570805EE")
            
@Override
      boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        if (!util.isValidNumber(number)) {
          return false;
        }
        return containsOnlyValidXChars(number, candidate, util);
      }
    },
    STRICT_GROUPING {
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.545 -0500", hash_original_method = "717159A20FF9653960C4CC33E75B4D97", hash_generated_method = "D9ADB59216435FD6CD7A5951A7D1567C")
            
@Override
      boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        if (!util.isValidNumber(number) ||
            !containsOnlyValidXChars(number, candidate, util) ||
            containsMoreThanOneSlash(candidate)) {
          return false;
        }
        // TODO: Evaluate how this works for other locales (testing has been
        // limited to NANPA regions) and optimise if necessary.
        String[] formattedNumberGroups = getNationalNumberGroups(util, number);
        StringBuilder normalizedCandidate = normalizeDigits(candidate,
                                                            true /* keep strip non-digits */);
        int fromIndex = 0;
        // Check each group of consecutive digits are not broken into separate groups in the
        // {@code candidate} string.
        for (int i = 0; i < formattedNumberGroups.length; i++) {
          // Fails if the substring of {@code candidate} starting from {@code fromIndex} doesn't
          // contain the consecutive digits in formattedNumberGroups[i].
          fromIndex = normalizedCandidate.indexOf(formattedNumberGroups[i], fromIndex);
          if (fromIndex < 0) {
            return false;
          }
          // Moves {@code fromIndex} forward.
          fromIndex += formattedNumberGroups[i].length();
          if (i == 0 && fromIndex < normalizedCandidate.length()) {
            // We are at the position right after the NDC.
            if (Character.isDigit(normalizedCandidate.charAt(fromIndex))) {
              // This means there is no formatting symbol after the NDC. In this case, we only
              // accept the number if there is no formatting symbol at all in the number, except
              // for extensions.
              String nationalSignificantNumber = util.getNationalSignificantNumber(number);
              return normalizedCandidate.substring(fromIndex - formattedNumberGroups[i].length())
                  .startsWith(nationalSignificantNumber);
            }
          }
        }
        // The check here makes sure that we haven't mistakenly already used the extension to
        // match the last group of the subscriber number. Note the extension cannot have
        // formatting in-between digits.
        return normalizedCandidate.substring(fromIndex).contains(number.getExtension());
      }
    },
    EXACT_GROUPING {
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.548 -0500", hash_original_method = "865D3CB10D4A002CEFE15FC65335742E", hash_generated_method = "85ACF347EA0727AF2D3B4B7B5542E9DA")
            
@Override
      boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util) {
        if (!util.isValidNumber(number) ||
            !containsOnlyValidXChars(number, candidate, util) ||
            containsMoreThanOneSlash(candidate)) {
          return false;
        }
        // TODO: Evaluate how this works for other locales (testing has been
        // limited to NANPA regions) and optimise if necessary.
        StringBuilder normalizedCandidate = normalizeDigits(candidate,
                                                            true /* keep strip non-digits */);
        String[] candidateGroups =
            NON_DIGITS_PATTERN.split(normalizedCandidate.toString());
        // Set this to the last group, skipping it if the number has an extension.
        int candidateNumberGroupIndex =
            number.hasExtension() ? candidateGroups.length - 2 : candidateGroups.length - 1;
        // First we check if the national significant number is formatted as a block.
        // We use contains and not equals, since the national significant number may be present with
        // a prefix such as a national number prefix, or the country code itself.
        if (candidateGroups.length == 1 ||
            candidateGroups[candidateNumberGroupIndex].contains(
                util.getNationalSignificantNumber(number))) {
          return true;
        }
        String[] formattedNumberGroups = getNationalNumberGroups(util, number);
        // Starting from the end, go through in reverse, excluding the first group, and check the
        // candidate and number groups are the same.
        for (int formattedNumberGroupIndex = (formattedNumberGroups.length - 1);
             formattedNumberGroupIndex > 0 && candidateNumberGroupIndex >= 0;
             formattedNumberGroupIndex--, candidateNumberGroupIndex--) {
          if (!candidateGroups[candidateNumberGroupIndex].equals(
              formattedNumberGroups[formattedNumberGroupIndex])) {
            return false;
          }
        }
        // Now check the first group. There may be a national prefix at the start, so we only check
        // that the candidate group ends with the formatted number group.
        return (candidateNumberGroupIndex >= 0 &&
                candidateGroups[candidateNumberGroupIndex].endsWith(formattedNumberGroups[0]));
      }
    };

    /**
     * Helper method to get the national-number part of a number, formatted without any national
     * prefix, and return it as a set of digit blocks that would be formatted together.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.551 -0500", hash_original_method = "F034A97E9C2C59009055042CF447C340", hash_generated_method = "25E08B70D3F46D2F456DA861FF9C5A0A")
            
private static String[] getNationalNumberGroups(PhoneNumberUtil util, PhoneNumber number) {
      // This will be in the format +CC-DG;ext=EXT where DG represents groups of digits.
      String rfc3966Format = util.format(number, PhoneNumberFormat.RFC3966);
      // We remove the extension part from the formatted string before splitting it into different
      // groups.
      int endIndex = rfc3966Format.indexOf(';');
      if (endIndex < 0) {
        endIndex = rfc3966Format.length();
      }
      // The country-code will have a '-' following it.
      int startIndex = rfc3966Format.indexOf('-') + 1;
      return rfc3966Format.substring(startIndex, endIndex).split("-");
    }

    @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.554 -0500", hash_original_method = "9AB9E4BD33616C807EEE356363101105", hash_generated_method = "DB239D85FE3D6B4DB81F389617574362")
            
private static boolean containsMoreThanOneSlash(String candidate) {
      int firstSlashIndex = candidate.indexOf('/');
      return (firstSlashIndex > 0 && candidate.substring(firstSlashIndex + 1).contains("/"));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.557 -0500", hash_original_method = "003C60B99EA6B7F66B7E9E7BAC9A7445", hash_generated_method = "65BF56F8DEE8103B939BA88A76F6F849")
            
private static boolean containsOnlyValidXChars(
        PhoneNumber number, String candidate, PhoneNumberUtil util) {
      // The characters 'x' and 'X' can be (1) a carrier code, in which case they always precede the
      // national significant number or (2) an extension sign, in which case they always precede the
      // extension number. We assume a carrier code is more than 1 digit, so the first case has to
      // have more than 1 consecutive 'x' or 'X', whereas the second case can only have exactly 1
      // 'x' or 'X'. We ignore the character if it appears as the last character of the string.
      for (int index = 0; index < candidate.length() - 1; index++) {
        char charAtIndex = candidate.charAt(index);
        if (charAtIndex == 'x' || charAtIndex == 'X') {
          char charAtNextIndex = candidate.charAt(index + 1);
          if (charAtNextIndex == 'x' || charAtNextIndex == 'X') {
            // This is the carrier code case, in which the 'X's always precede the national
            // significant number.
            index++;
            if (util.isNumberMatch(number, candidate.substring(index)) != MatchType.NSN_MATCH) {
              return false;
            }
          // This is the extension sign case, in which the 'x' or 'X' should always precede the
          // extension number.
          } else if (!PhoneNumberUtil.normalizeDigitsOnly(candidate.substring(index)).equals(
              number.getExtension())) {
              return false;
          }
        }
      }
      return true;
    }

    /** Returns true if {@code number} is a verified number according to this leniency. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.559 -0500", hash_original_method = "85DF74823DA7FB6CC33176621AEF84C0", hash_generated_method = "DC73E5BBD01F696A4C1CF83BE63081C2")
            
abstract boolean verify(PhoneNumber number, String candidate, PhoneNumberUtil util);
  }

  /**
   * Formats the extension part of the phone number by prefixing it with the appropriate extension
   * prefix. This will be the default extension prefix, unless overridden by a preferred
   * extension prefix for this region.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.667 -0500", hash_original_method = "4E1A69FB5E070DF7BC56976B37027181", hash_generated_method = "8E90055726D8DC8C3C9D272278AD0D74")
    
private void formatExtension(String extensionDigits, String regionCode,
                               StringBuilder extension) {
    PhoneMetadata metadata = getMetadataForRegion(regionCode);
    if (metadata.hasPreferredExtnPrefix()) {
      extension.append(metadata.getPreferredExtnPrefix()).append(extensionDigits);
    } else {
      extension.append(DEFAULT_EXTN_PREFIX).append(extensionDigits);
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.670 -0500", hash_original_method = "B508A0D4C9257AABA72DD1888D64C9E3", hash_generated_method = "B508A0D4C9257AABA72DD1888D64C9E3")
    
PhoneNumberDesc getNumberDescByType(PhoneMetadata metadata, PhoneNumberType type) {
    switch (type) {
      case PREMIUM_RATE:
        return metadata.getPremiumRate();
      case TOLL_FREE:
        return metadata.getTollFree();
      case MOBILE:
        return metadata.getMobile();
      case FIXED_LINE:
      case FIXED_LINE_OR_MOBILE:
        return metadata.getFixedLine();
      case SHARED_COST:
        return metadata.getSharedCost();
      case VOIP:
        return metadata.getVoip();
      case PERSONAL_NUMBER:
        return metadata.getPersonalNumber();
      case PAGER:
        return metadata.getPager();
      case UAN:
        return metadata.getUan();
      default:
        return metadata.getGeneralDesc();
    }
  }

  /**
   * Gets the type of a phone number.
   *
   * @param number  the phone number that we want to know the type
   * @return  the type of the phone number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.672 -0500", hash_original_method = "261D2E3780968B6A389AA5653D83C66D", hash_generated_method = "66D4CD337F88E66C183CDF7A397F79CA")
    
public PhoneNumberType getNumberType(PhoneNumber number) {
    String regionCode = getRegionCodeForNumber(number);
    if (!isValidRegionCode(regionCode)) {
      return PhoneNumberType.UNKNOWN;
    }
    String nationalSignificantNumber = getNationalSignificantNumber(number);
    return getNumberTypeHelper(nationalSignificantNumber, getMetadataForRegion(regionCode));
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.675 -0500", hash_original_method = "CFBB065FE396C61ECB0C897E1E4B66DC", hash_generated_method = "599FBC41628B7205CC53F964CEEE2E8F")
    
private PhoneNumberType getNumberTypeHelper(String nationalNumber, PhoneMetadata metadata) {
    PhoneNumberDesc generalNumberDesc = metadata.getGeneralDesc();
    if (!generalNumberDesc.hasNationalNumberPattern() ||
        !isNumberMatchingDesc(nationalNumber, generalNumberDesc)) {
      return PhoneNumberType.UNKNOWN;
    }

    if (isNumberMatchingDesc(nationalNumber, metadata.getPremiumRate())) {
      return PhoneNumberType.PREMIUM_RATE;
    }
    if (isNumberMatchingDesc(nationalNumber, metadata.getTollFree())) {
      return PhoneNumberType.TOLL_FREE;
    }
    if (isNumberMatchingDesc(nationalNumber, metadata.getSharedCost())) {
      return PhoneNumberType.SHARED_COST;
    }
    if (isNumberMatchingDesc(nationalNumber, metadata.getVoip())) {
      return PhoneNumberType.VOIP;
    }
    if (isNumberMatchingDesc(nationalNumber, metadata.getPersonalNumber())) {
      return PhoneNumberType.PERSONAL_NUMBER;
    }
    if (isNumberMatchingDesc(nationalNumber, metadata.getPager())) {
      return PhoneNumberType.PAGER;
    }
    if (isNumberMatchingDesc(nationalNumber, metadata.getUan())) {
      return PhoneNumberType.UAN;
    }

    boolean isFixedLine = isNumberMatchingDesc(nationalNumber, metadata.getFixedLine());
    if (isFixedLine) {
      if (metadata.isSameMobileAndFixedLinePattern()) {
        return PhoneNumberType.FIXED_LINE_OR_MOBILE;
      } else if (isNumberMatchingDesc(nationalNumber, metadata.getMobile())) {
        return PhoneNumberType.FIXED_LINE_OR_MOBILE;
      }
      return PhoneNumberType.FIXED_LINE;
    }
    // Otherwise, test to see if the number is mobile. Only do this if certain that the patterns for
    // mobile and fixed line aren't the same.
    if (!metadata.isSameMobileAndFixedLinePattern() &&
        isNumberMatchingDesc(nationalNumber, metadata.getMobile())) {
      return PhoneNumberType.MOBILE;
    }
    return PhoneNumberType.UNKNOWN;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.678 -0500", hash_original_method = "B7D0F615A2820F4964EA69968467492C", hash_generated_method = "B7D0F615A2820F4964EA69968467492C")
    
PhoneMetadata getMetadataForRegion(String regionCode) {
    if (!isValidRegionCode(regionCode)) {
      return null;
    }
    synchronized (regionToMetadataMap) {
      if (!regionToMetadataMap.containsKey(regionCode)) {
        loadMetadataForRegionFromFile(currentFilePrefix, regionCode);
      }
    }
    return regionToMetadataMap.get(regionCode);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.680 -0500", hash_original_method = "B17A0514C43E05EB90EE98CA4CB42983", hash_generated_method = "34861F3198A1C883917D14004748BEF1")
    
private boolean isNumberMatchingDesc(String nationalNumber, PhoneNumberDesc numberDesc) {
    Matcher possibleNumberPatternMatcher =
        regexCache.getPatternForRegex(numberDesc.getPossibleNumberPattern())
            .matcher(nationalNumber);
    Matcher nationalNumberPatternMatcher =
        regexCache.getPatternForRegex(numberDesc.getNationalNumberPattern())
            .matcher(nationalNumber);
    return possibleNumberPatternMatcher.matches() && nationalNumberPatternMatcher.matches();
  }

  /**
   * Tests whether a phone number matches a valid pattern. Note this doesn't verify the number
   * is actually in use, which is impossible to tell by just looking at a number itself.
   *
   * @param number       the phone number that we want to validate
   * @return  a boolean that indicates whether the number is of a valid pattern
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.682 -0500", hash_original_method = "31ADC24E14E9CE703FF2777ACEC876BF", hash_generated_method = "2C84842FCFC952033F967B5C35DA3B4C")
    
public boolean isValidNumber(PhoneNumber number) {
    String regionCode = getRegionCodeForNumber(number);
    return (isValidRegionCode(regionCode) && isValidNumberForRegion(number, regionCode));
  }

  /**
   * Tests whether a phone number is valid for a certain region. Note this doesn't verify the number
   * is actually in use, which is impossible to tell by just looking at a number itself. If the
   * country calling code is not the same as the country calling code for the region, this
   * immediately exits with false. After this, the specific number pattern rules for the region are
   * examined. This is useful for determining for example whether a particular number is valid for
   * Canada, rather than just a valid NANPA number.
   *
   * @param number       the phone number that we want to validate
   * @param regionCode   the region that we want to validate the phone number for
   * @return  a boolean that indicates whether the number is of a valid pattern
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.685 -0500", hash_original_method = "C701813EA11D8E6ADA1ECC6BB90E9747", hash_generated_method = "9D22583FC9ECE47A0B62700159BF8A48")
    
public boolean isValidNumberForRegion(PhoneNumber number, String regionCode) {
    if (number.getCountryCode() != getCountryCodeForRegion(regionCode)) {
      return false;
    }
    PhoneMetadata metadata = getMetadataForRegion(regionCode);
    PhoneNumberDesc generalNumDesc = metadata.getGeneralDesc();
    String nationalSignificantNumber = getNationalSignificantNumber(number);

    // For regions where we don't have metadata for PhoneNumberDesc, we treat any number passed in
    // as a valid number if its national significant number is between the minimum and maximum
    // lengths defined by ITU for a national significant number.
    if (!generalNumDesc.hasNationalNumberPattern()) {
      int numberLength = nationalSignificantNumber.length();
      return numberLength > MIN_LENGTH_FOR_NSN && numberLength <= MAX_LENGTH_FOR_NSN;
    }
    return getNumberTypeHelper(nationalSignificantNumber, metadata) != PhoneNumberType.UNKNOWN;
  }

  /**
   * Returns the region where a phone number is from. This could be used for geocoding at the region
   * level.
   *
   * @param number  the phone number whose origin we want to know
   * @return  the region where the phone number is from, or null if no region matches this calling
   *     code
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.687 -0500", hash_original_method = "C5C9CB0E93474118DAA9D7A65CA1060A", hash_generated_method = "533E705075B8E506A2EFA5EA8EF22616")
    
public String getRegionCodeForNumber(PhoneNumber number) {
    int countryCode = number.getCountryCode();
    List<String> regions = countryCallingCodeToRegionCodeMap.get(countryCode);
    if (regions == null) {
      return null;
    }
    if (regions.size() == 1) {
      return regions.get(0);
    } else {
      return getRegionCodeForNumberFromRegionList(number, regions);
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.689 -0500", hash_original_method = "814AB76683AFE761330E661D695A8B3F", hash_generated_method = "E2797ADFCEB3C986D4841483C4B414B7")
    
private String getRegionCodeForNumberFromRegionList(PhoneNumber number,
                                                      List<String> regionCodes) {
    String nationalNumber = getNationalSignificantNumber(number);
    for (String regionCode : regionCodes) {
      // If leadingDigits is present, use this. Otherwise, do full validation.
      PhoneMetadata metadata = getMetadataForRegion(regionCode);
      if (metadata.hasLeadingDigits()) {
        if (regexCache.getPatternForRegex(metadata.getLeadingDigits())
                .matcher(nationalNumber).lookingAt()) {
          return regionCode;
        }
      } else if (getNumberTypeHelper(nationalNumber, metadata) != PhoneNumberType.UNKNOWN) {
        return regionCode;
      }
    }
    return null;
  }

  /**
   * Returns the region code that matches the specific country calling code. In the case of no
   * region code being found, ZZ will be returned. In the case of multiple regions, the one
   * designated in the metadata as the "main" region for this calling code will be returned.
   */
  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.692 -0500", hash_original_method = "DA9951AEFEAF4242112AA6281301B32F", hash_generated_method = "8488CEAF9850C5426C53E0A970837380")
    
public String getRegionCodeForCountryCode(int countryCallingCode) {
    List<String> regionCodes = countryCallingCodeToRegionCodeMap.get(countryCallingCode);
    return regionCodes == null ? UNKNOWN_REGION : regionCodes.get(0);
  }

  /**
   * Returns the country calling code for a specific region. For example, this would be 1 for the
   * United States, and 64 for New Zealand.
   *
   * @param regionCode  the region that we want to get the country calling code for
   * @return  the country calling code for the region denoted by regionCode
   */
  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.695 -0500", hash_original_method = "D7076C7EB39C8978E29A5CA27F40EEC9", hash_generated_method = "5479A83A074A348AA03CF81256B68614")
    
public int getCountryCodeForRegion(String regionCode) {
    if (!isValidRegionCode(regionCode)) {
      return 0;
    }
    PhoneMetadata metadata = getMetadataForRegion(regionCode);
    return metadata.getCountryCode();
  }

  /**
   * Returns the national dialling prefix for a specific region. For example, this would be 1 for
   * the United States, and 0 for New Zealand. Set stripNonDigits to true to strip symbols like "~"
   * (which indicates a wait for a dialling tone) from the prefix returned. If no national prefix is
   * present, we return null.
   *
   * <p>Warning: Do not use this method for do-your-own formatting - for some regions, the
   * national dialling prefix is used only for certain types of numbers. Use the library's
   * formatting functions to prefix the national prefix when required.
   *
   * @param regionCode  the region that we want to get the dialling prefix for
   * @param stripNonDigits  true to strip non-digits from the national dialling prefix
   * @return  the dialling prefix for the region denoted by regionCode
   */
  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.697 -0500", hash_original_method = "E58B423D76AD6194B45901E123DB6EBF", hash_generated_method = "E3446F52EF7100B483C4297680A90C2F")
    
public String getNddPrefixForRegion(String regionCode, boolean stripNonDigits) {
    if (!isValidRegionCode(regionCode)) {
      LOGGER.log(Level.SEVERE, "Invalid or missing region code provided.");
      return null;
    }
    PhoneMetadata metadata = getMetadataForRegion(regionCode);
    String nationalPrefix = metadata.getNationalPrefix();
    // If no national prefix was found, we return null.
    if (nationalPrefix.length() == 0) {
      return null;
    }
    if (stripNonDigits) {
      // Note: if any other non-numeric symbols are ever used in national prefixes, these would have
      // to be removed here as well.
      nationalPrefix = nationalPrefix.replace("~", "");
    }
    return nationalPrefix;
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

  /**
   * Checks if this is a region under the North American Numbering Plan Administration (NANPA).
   *
   * @return  true if regionCode is one of the regions under NANPA
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.700 -0500", hash_original_method = "7B63C50F103D8DC60E8A2B15ED73A093", hash_generated_method = "72D45D51D88E5A9F7B13A221C07CF74A")
    
public boolean isNANPACountry(String regionCode) {
    return nanpaRegions.contains(regionCode);
  }

  /**
   * Checks whether the country calling code is from a region whose national significant number
   * could contain a leading zero. An example of such a region is Italy. Returns false if no
   * metadata for the country is found.
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.702 -0500", hash_original_method = "996B7AC837898451564E65CADA674F54", hash_generated_method = "996B7AC837898451564E65CADA674F54")
    
boolean isLeadingZeroPossible(int countryCallingCode) {
    PhoneMetadata mainMetadataForCallingCode = getMetadataForRegion(
        getRegionCodeForCountryCode(countryCallingCode));
    if (mainMetadataForCallingCode == null) {
      return false;
    }
    return mainMetadataForCallingCode.isLeadingZeroPossible();
  }

  /**
   * Checks if the number is a valid vanity (alpha) number such as 800 MICROSOFT. A valid vanity
   * number will start with at least 3 digits and will have three or more alpha characters. This
   * does not do region-specific checks - to work out if this number is actually valid for a region,
   * it should be parsed and methods such as {@link #isPossibleNumberWithReason} and
   * {@link #isValidNumber} should be used.
   *
   * @param number  the number that needs to be checked
   * @return  true if the number is a valid vanity number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.704 -0500", hash_original_method = "4B80DFBB3D3B298395671B1C8C6F67DA", hash_generated_method = "9C563E7EFF07F0E5B0BF06519E04131C")
    
public boolean isAlphaNumber(String number) {
    if (!isViablePhoneNumber(number)) {
      // Number is too short, or doesn't match the basic phone number pattern.
      return false;
    }
    StringBuilder strippedNumber = new StringBuilder(number);
    maybeStripExtension(strippedNumber);
    return VALID_ALPHA_PHONE_PATTERN.matcher(strippedNumber).matches();
  }

  /**
   * Convenience wrapper around {@link #isPossibleNumberWithReason}. Instead of returning the reason
   * for failure, this method returns a boolean value.
   * @param number  the number that needs to be checked
   * @return  true if the number is possible
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.706 -0500", hash_original_method = "86FEA4033CCC520A9BCC7CD67C884B0D", hash_generated_method = "94E6326C3B508B689DBE9C1D52C76AB6")
    
public boolean isPossibleNumber(PhoneNumber number) {
    return isPossibleNumberWithReason(number) == ValidationResult.IS_POSSIBLE;
  }

  /**
   * Helper method to check a number against a particular pattern and determine whether it matches,
   * or is too short or too long. Currently, if a number pattern suggests that numbers of length 7
   * and 10 are possible, and a number in between these possible lengths is entered, such as of
   * length 8, this will return TOO_LONG.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.708 -0500", hash_original_method = "B3EB56A7047F0C0039433A6E9896FBEF", hash_generated_method = "0C87CFBE9A528C99BB370925183A6378")
    
private ValidationResult testNumberLengthAgainstPattern(Pattern numberPattern, String number) {
    Matcher numberMatcher = numberPattern.matcher(number);
    if (numberMatcher.matches()) {
      return ValidationResult.IS_POSSIBLE;
    }
    if (numberMatcher.lookingAt()) {
      return ValidationResult.TOO_LONG;
    } else {
      return ValidationResult.TOO_SHORT;
    }
  }

  /**
   * Check whether a phone number is a possible number. It provides a more lenient check than
   * {@link #isValidNumber} in the following sense:
   *<ol>
   * <li> It only checks the length of phone numbers. In particular, it doesn't check starting
   *      digits of the number.
   * <li> It doesn't attempt to figure out the type of the number, but uses general rules which
   *      applies to all types of phone numbers in a region. Therefore, it is much faster than
   *      isValidNumber.
   * <li> For fixed line numbers, many regions have the concept of area code, which together with
   *      subscriber number constitute the national significant number. It is sometimes okay to dial
   *      the subscriber number only when dialing in the same area. This function will return
   *      true if the subscriber-number-only version is passed in. On the other hand, because
   *      isValidNumber validates using information on both starting digits (for fixed line
   *      numbers, that would most likely be area codes) and length (obviously includes the
   *      length of area codes for fixed line numbers), it will return false for the
   *      subscriber-number-only version.
   * </ol
   * @param number  the number that needs to be checked
   * @return  a ValidationResult object which indicates whether the number is possible
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.711 -0500", hash_original_method = "5E4449198019FBA49E61EB3BB2D3E7CD", hash_generated_method = "62CFDA3ADB4FD20D54D82ED2CE285F38")
    
public ValidationResult isPossibleNumberWithReason(PhoneNumber number) {
    String nationalNumber = getNationalSignificantNumber(number);
    int countryCode = number.getCountryCode();
    // Note: For Russian Fed and NANPA numbers, we just use the rules from the default region (US or
    // Russia) since the getRegionCodeForNumber will not work if the number is possible but not
    // valid. This would need to be revisited if the possible number pattern ever differed between
    // various regions within those plans.
    String regionCode = getRegionCodeForCountryCode(countryCode);
    if (!isValidRegionCode(regionCode)) {
      return ValidationResult.INVALID_COUNTRY_CODE;
    }
    PhoneNumberDesc generalNumDesc = getMetadataForRegion(regionCode).getGeneralDesc();
    // Handling case of numbers with no metadata.
    if (!generalNumDesc.hasNationalNumberPattern()) {
      LOGGER.log(Level.FINER, "Checking if number is possible with incomplete metadata.");
      int numberLength = nationalNumber.length();
      if (numberLength < MIN_LENGTH_FOR_NSN) {
        return ValidationResult.TOO_SHORT;
      } else if (numberLength > MAX_LENGTH_FOR_NSN) {
        return ValidationResult.TOO_LONG;
      } else {
        return ValidationResult.IS_POSSIBLE;
      }
    }
    Pattern possibleNumberPattern =
        regexCache.getPatternForRegex(generalNumDesc.getPossibleNumberPattern());
    return testNumberLengthAgainstPattern(possibleNumberPattern, nationalNumber);
  }

  /**
   * Check whether a phone number is a possible number given a number in the form of a string, and
   * the region where the number could be dialed from. It provides a more lenient check than
   * {@link #isValidNumber}. See {@link #isPossibleNumber(Phonenumber.PhoneNumber)} for details.
   *
   * <p>This method first parses the number, then invokes
   * {@link #isPossibleNumber(Phonenumber.PhoneNumber)} with the resultant PhoneNumber object.
   *
   * @param number  the number that needs to be checked, in the form of a string
   * @param regionDialingFrom  the region that we are expecting the number to be dialed from.
   *     Note this is different from the region where the number belongs.  For example, the number
   *     +1 650 253 0000 is a number that belongs to US. When written in this form, it can be
   *     dialed from any region. When it is written as 00 1 650 253 0000, it can be dialed from any
   *     region which uses an international dialling prefix of 00. When it is written as
   *     650 253 0000, it can only be dialed from within the US, and when written as 253 0000, it
   *     can only be dialed from within a smaller area in the US (Mountain View, CA, to be more
   *     specific).
   * @return  true if the number is possible
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.714 -0500", hash_original_method = "ABB46ACB6DF1697743B661541AD5E166", hash_generated_method = "DFD906F46E7E830954DFB2AB4208F916")
    
public boolean isPossibleNumber(String number, String regionDialingFrom) {
    try {
      return isPossibleNumber(parse(number, regionDialingFrom));
    } catch (NumberParseException e) {
      return false;
    }
  }

  /**
   * Attempts to extract a valid number from a phone number that is too long to be valid, and resets
   * the PhoneNumber object passed in to that valid version. If no valid number could be extracted,
   * the PhoneNumber object passed in will not be modified.
   * @param number a PhoneNumber object which contains a number that is too long to be valid.
   * @return  true if a valid phone number can be successfully extracted.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.716 -0500", hash_original_method = "763BBE034FB297BC9C435FECAC40F4A1", hash_generated_method = "0E331359EC360008B6C678F73F8C5EBE")
    
public boolean truncateTooLongNumber(PhoneNumber number) {
    if (isValidNumber(number)) {
      return true;
    }
    PhoneNumber numberCopy = new PhoneNumber();
    numberCopy.mergeFrom(number);
    long nationalNumber = number.getNationalNumber();
    do {
      nationalNumber /= 10;
      numberCopy.setNationalNumber(nationalNumber);
      if (isPossibleNumberWithReason(numberCopy) == ValidationResult.TOO_SHORT ||
          nationalNumber == 0) {
        return false;
      }
    } while (!isValidNumber(numberCopy));
    number.setNationalNumber(nationalNumber);
    return true;
  }

  /**
   * Gets an {@link com.android.i18n.phonenumbers.AsYouTypeFormatter} for the specific region.
   *
   * @param regionCode  the region where the phone number is being entered
   * @return  an {@link com.android.i18n.phonenumbers.AsYouTypeFormatter} object, which can be used
   *     to format phone numbers in the specific region "as you type"
   */
  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.718 -0500", hash_original_method = "719F2F8970F4EB169BEDB2820A702606", hash_generated_method = "A219F2B4619339D7BEE9C93951E5EC0D")
    
public AsYouTypeFormatter getAsYouTypeFormatter(String regionCode) {
    return new AsYouTypeFormatter(regionCode);
  }

  // Extracts country calling code from fullNumber, returns it and places the remaining number in
  // nationalNumber. It assumes that the leading plus sign or IDD has already been removed. Returns
  // 0 if fullNumber doesn't start with a valid country calling code, and leaves nationalNumber
  // unmodified.
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.721 -0500", hash_original_method = "2A48039CFC05A878E1A34077CDECE0D5", hash_generated_method = "2A48039CFC05A878E1A34077CDECE0D5")
    
int extractCountryCode(StringBuilder fullNumber, StringBuilder nationalNumber) {
    int potentialCountryCode;
    int numberLength = fullNumber.length();
    for (int i = 1; i <= MAX_LENGTH_COUNTRY_CODE && i <= numberLength; i++) {
      potentialCountryCode = Integer.parseInt(fullNumber.substring(0, i));
      if (countryCallingCodeToRegionCodeMap.containsKey(potentialCountryCode)) {
        nationalNumber.append(fullNumber.substring(i));
        return potentialCountryCode;
      }
    }
    return 0;
  }

  /**
   * Tries to extract a country calling code from a number. This method will return zero if no
   * country calling code is considered to be present. Country calling codes are extracted in the
   * following ways:
   * <ul>
   *  <li> by stripping the international dialing prefix of the region the person is dialing from,
   *       if this is present in the number, and looking at the next digits
   *  <li> by stripping the '+' sign if present and then looking at the next digits
   *  <li> by comparing the start of the number and the country calling code of the default region.
   *       If the number is not considered possible for the numbering plan of the default region
   *       initially, but starts with the country calling code of this region, validation will be
   *       reattempted after stripping this country calling code. If this number is considered a
   *       possible number, then the first digits will be considered the country calling code and
   *       removed as such.
   * </ul>
   * It will throw a NumberParseException if the number starts with a '+' but the country calling
   * code supplied after this does not match that of any known region.
   *
   * @param number  non-normalized telephone number that we wish to extract a country calling
   *     code from - may begin with '+'
   * @param defaultRegionMetadata  metadata about the region this number may be from
   * @param nationalNumber  a string buffer to store the national significant number in, in the case
   *     that a country calling code was extracted. The number is appended to any existing contents.
   *     If no country calling code was extracted, this will be left unchanged.
   * @param keepRawInput  true if the country_code_source and preferred_carrier_code fields of
   *     phoneNumber should be populated.
   * @param phoneNumber  the PhoneNumber object where the country_code and country_code_source need
   *     to be populated. Note the country_code is always populated, whereas country_code_source is
   *     only populated when keepCountryCodeSource is true.
   * @return  the country calling code extracted or 0 if none could be extracted
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.724 -0500", hash_original_method = "8166FB521487034FA9E8BD7575A0612F", hash_generated_method = "009924260EBBDD659A405CBBCB75AD12")
    
int maybeExtractCountryCode(String number, PhoneMetadata defaultRegionMetadata,
                              StringBuilder nationalNumber, boolean keepRawInput,
                              PhoneNumber phoneNumber)
      throws NumberParseException {
    if (number.length() == 0) {
      return 0;
    }
    StringBuilder fullNumber = new StringBuilder(number);
    // Set the default prefix to be something that will never match.
    String possibleCountryIddPrefix = "NonMatch";
    if (defaultRegionMetadata != null) {
      possibleCountryIddPrefix = defaultRegionMetadata.getInternationalPrefix();
    }

    CountryCodeSource countryCodeSource =
        maybeStripInternationalPrefixAndNormalize(fullNumber, possibleCountryIddPrefix);
    if (keepRawInput) {
      phoneNumber.setCountryCodeSource(countryCodeSource);
    }
    if (countryCodeSource != CountryCodeSource.FROM_DEFAULT_COUNTRY) {
      if (fullNumber.length() < MIN_LENGTH_FOR_NSN) {
        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD,
                                       "Phone number had an IDD, but after this was not "
                                       + "long enough to be a viable phone number.");
      }
      int potentialCountryCode = extractCountryCode(fullNumber, nationalNumber);
      if (potentialCountryCode != 0) {
        phoneNumber.setCountryCode(potentialCountryCode);
        return potentialCountryCode;
      }

      // If this fails, they must be using a strange country calling code that we don't recognize,
      // or that doesn't exist.
      throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                                     "Country calling code supplied was not recognised.");
    } else if (defaultRegionMetadata != null) {
      // Check to see if the number starts with the country calling code for the default region. If
      // so, we remove the country calling code, and do some checks on the validity of the number
      // before and after.
      int defaultCountryCode = defaultRegionMetadata.getCountryCode();
      String defaultCountryCodeString = String.valueOf(defaultCountryCode);
      String normalizedNumber = fullNumber.toString();
      if (normalizedNumber.startsWith(defaultCountryCodeString)) {
        StringBuilder potentialNationalNumber =
            new StringBuilder(normalizedNumber.substring(defaultCountryCodeString.length()));
        PhoneNumberDesc generalDesc = defaultRegionMetadata.getGeneralDesc();
        Pattern validNumberPattern =
            regexCache.getPatternForRegex(generalDesc.getNationalNumberPattern());
        maybeStripNationalPrefixAndCarrierCode(potentialNationalNumber, defaultRegionMetadata);
        Pattern possibleNumberPattern =
            regexCache.getPatternForRegex(generalDesc.getPossibleNumberPattern());
        // If the number was not valid before but is valid now, or if it was too long before, we
        // consider the number with the country calling code stripped to be a better result and
        // keep that instead.
        if ((!validNumberPattern.matcher(fullNumber).matches() &&
             validNumberPattern.matcher(potentialNationalNumber).matches()) ||
             testNumberLengthAgainstPattern(possibleNumberPattern, fullNumber.toString())
                  == ValidationResult.TOO_LONG) {
          nationalNumber.append(potentialNationalNumber);
          if (keepRawInput) {
            phoneNumber.setCountryCodeSource(CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
          }
          phoneNumber.setCountryCode(defaultCountryCode);
          return defaultCountryCode;
        }
      }
    }
    // No country calling code present.
    phoneNumber.setCountryCode(0);
    return 0;
  }

  /**
   * Strips the IDD from the start of the number if present. Helper function used by
   * maybeStripInternationalPrefixAndNormalize.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.728 -0500", hash_original_method = "0F0B6B28B590A156D8457E403790D50B", hash_generated_method = "5774B095961096FF09D2C124BA47E6AB")
    
private boolean parsePrefixAsIdd(Pattern iddPattern, StringBuilder number) {
    Matcher m = iddPattern.matcher(number);
    if (m.lookingAt()) {
      int matchEnd = m.end();
      // Only strip this if the first digit after the match is not a 0, since country calling codes
      // cannot begin with 0.
      Matcher digitMatcher = CAPTURING_DIGIT_PATTERN.matcher(number.substring(matchEnd));
      if (digitMatcher.find()) {
        String normalizedGroup = normalizeDigitsOnly(digitMatcher.group(1));
        if (normalizedGroup.equals("0")) {
          return false;
        }
      }
      number.delete(0, matchEnd);
      return true;
    }
    return false;
  }

  /**
   * Strips any international prefix (such as +, 00, 011) present in the number provided, normalizes
   * the resulting number, and indicates if an international prefix was present.
   *
   * @param number  the non-normalized telephone number that we wish to strip any international
   *     dialing prefix from.
   * @param possibleIddPrefix  the international direct dialing prefix from the region we
   *     think this number may be dialed in
   * @return  the corresponding CountryCodeSource if an international dialing prefix could be
   *     removed from the number, otherwise CountryCodeSource.FROM_DEFAULT_COUNTRY if the number did
   *     not seem to be in international format.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.730 -0500", hash_original_method = "8865CBB50A1D9F6F8472F699DBF16350", hash_generated_method = "065CBA227FD6062E35E4061CB2F80CF5")
    
CountryCodeSource maybeStripInternationalPrefixAndNormalize(
      StringBuilder number,
      String possibleIddPrefix) {
    if (number.length() == 0) {
      return CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }
    // Check to see if the number begins with one or more plus signs.
    Matcher m = PLUS_CHARS_PATTERN.matcher(number);
    if (m.lookingAt()) {
      number.delete(0, m.end());
      // Can now normalize the rest of the number since we've consumed the "+" sign at the start.
      normalize(number);
      return CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
    }
    // Attempt to parse the first digits as an international prefix.
    Pattern iddPattern = regexCache.getPatternForRegex(possibleIddPrefix);
    if (parsePrefixAsIdd(iddPattern, number)) {
      normalize(number);
      return CountryCodeSource.FROM_NUMBER_WITH_IDD;
    }
    // If still not found, then try and normalize the number and then try again. This shouldn't be
    // done before, since non-numeric characters (+ and ~) may legally be in the international
    // prefix.
    normalize(number);
    return parsePrefixAsIdd(iddPattern, number)
           ? CountryCodeSource.FROM_NUMBER_WITH_IDD
           : CountryCodeSource.FROM_DEFAULT_COUNTRY;
  }

  /**
   * Strips any national prefix (such as 0, 1) present in the number provided.
   *
   * @param number  the normalized telephone number that we wish to strip any national
   *     dialing prefix from
   * @param metadata  the metadata for the region that we think this number is from
   * @return the carrier code extracted if it is present, otherwise return an empty string.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.733 -0500", hash_original_method = "8024CAA7B81A99B980BA01FE387839A1", hash_generated_method = "6B4BF6BC644141A460379F1583721616")
    
String maybeStripNationalPrefixAndCarrierCode(StringBuilder number, PhoneMetadata metadata) {
    String carrierCode = "";
    int numberLength = number.length();
    String possibleNationalPrefix = metadata.getNationalPrefixForParsing();
    if (numberLength == 0 || possibleNationalPrefix.length() == 0) {
      // Early return for numbers of zero length.
      return "";
    }
    // Attempt to parse the first digits as a national prefix.
    Matcher prefixMatcher = regexCache.getPatternForRegex(possibleNationalPrefix).matcher(number);
    if (prefixMatcher.lookingAt()) {
      Pattern nationalNumberRule =
          regexCache.getPatternForRegex(metadata.getGeneralDesc().getNationalNumberPattern());
      // Check if the original number is viable.
      boolean isViableOriginalNumber = nationalNumberRule.matcher(number).matches();
      // prefixMatcher.group(numOfGroups) == null implies nothing was captured by the capturing
      // groups in possibleNationalPrefix; therefore, no transformation is necessary, and we just
      // remove the national prefix.
      int numOfGroups = prefixMatcher.groupCount();
      String transformRule = metadata.getNationalPrefixTransformRule();
      if (transformRule == null || transformRule.length() == 0 ||
          prefixMatcher.group(numOfGroups) == null) {
        // If the original number was viable, and the resultant number is not, we return.
        if (isViableOriginalNumber &&
            !nationalNumberRule.matcher(number.substring(prefixMatcher.end())).matches()) {
          return "";
        }
        if (numOfGroups > 0 && prefixMatcher.group(numOfGroups) != null) {
          carrierCode = prefixMatcher.group(1);
        }
        number.delete(0, prefixMatcher.end());
      } else {
        // Check that the resultant number is still viable. If not, return. Check this by copying
        // the string buffer and making the transformation on the copy first.
        StringBuilder transformedNumber = new StringBuilder(number);
        transformedNumber.replace(0, numberLength, prefixMatcher.replaceFirst(transformRule));
        if (isViableOriginalNumber &&
            !nationalNumberRule.matcher(transformedNumber.toString()).matches()) {
          return "";
        }
        if (numOfGroups > 1) {
          carrierCode = prefixMatcher.group(1);
        }
        number.replace(0, number.length(), transformedNumber.toString());
      }
    }
    return carrierCode;
  }

  /**
   * Strips any extension (as in, the part of the number dialled after the call is connected,
   * usually indicated with extn, ext, x or similar) from the end of the number, and returns it.
   *
   * @param number  the non-normalized telephone number that we wish to strip the extension from
   * @return        the phone extension
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.736 -0500", hash_original_method = "D072FBB7A4080E317A5210E0DF61655A", hash_generated_method = "CC015739D8A9978C3000EDBD8A039D39")
    
String maybeStripExtension(StringBuilder number) {
    Matcher m = EXTN_PATTERN.matcher(number);
    // If we find a potential extension, and the number preceding this is a viable number, we assume
    // it is an extension.
    if (m.find() && isViablePhoneNumber(number.substring(0, m.start()))) {
      // The numbers are captured into groups in the regular expression.
      for (int i = 1, length = m.groupCount(); i <= length; i++) {
        if (m.group(i) != null) {
          // We go through the capturing groups until we find one that captured some digits. If none
          // did, then we will return the empty string.
          String extension = m.group(i);
          number.delete(m.start(), number.length());
          return extension;
        }
      }
    }
    return "";
  }

  /**
   * Checks to see that the region code used is valid, or if it is not valid, that the number to
   * parse starts with a + symbol so that we can attempt to infer the region from the number.
   * Returns false if it cannot use the region provided and the region cannot be inferred.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.738 -0500", hash_original_method = "E1BA4484CA3B538698D9E39D9664F7DD", hash_generated_method = "094C7F76AB089269A6A4B4724A581363")
    
private boolean checkRegionForParsing(String numberToParse, String defaultRegion) {
    if (!isValidRegionCode(defaultRegion)) {
      // If the number is null or empty, we can't infer the region.
      if (numberToParse == null || numberToParse.length() == 0 ||
          !PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Parses a string and returns it in proto buffer format. This method will throw a
   * {@link com.android.i18n.phonenumbers.NumberParseException} if the number is not considered to be
   * a possible number. Note that validation of whether the number is actually a valid number for a
   * particular region is not performed. This can be done separately with {@link #isValidNumber}.
   *
   * @param numberToParse     number that we are attempting to parse. This can contain formatting
   *                          such as +, ( and -, as well as a phone number extension.
   * @param defaultRegion     region that we are expecting the number to be from. This is only used
   *                          if the number being parsed is not written in international format.
   *                          The country_code for the number in this case would be stored as that
   *                          of the default region supplied. If the number is guaranteed to
   *                          start with a '+' followed by the country calling code, then
   *                          "ZZ" or null can be supplied.
   * @return                  a phone number proto buffer filled with the parsed number
   * @throws NumberParseException  if the string is not considered to be a viable phone number or if
   *                               no default region was supplied and the number is not in
   *                               international format (does not start with +)
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.741 -0500", hash_original_method = "6012972DF706A584D5C83C6971CF9392", hash_generated_method = "7BB90B447BF775DE4595259439C2139F")
    
public PhoneNumber parse(String numberToParse, String defaultRegion)
      throws NumberParseException {
    PhoneNumber phoneNumber = new PhoneNumber();
    parse(numberToParse, defaultRegion, phoneNumber);
    return phoneNumber;
  }

  /**
   * Same as {@link #parse(String, String)}, but accepts mutable PhoneNumber as a parameter to
   * decrease object creation when invoked many times.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.743 -0500", hash_original_method = "6ECDB36C19DB49774718F5C4BA94B539", hash_generated_method = "2A6AE5BB3AD98B83BC0C84886F61E40A")
    
public void parse(String numberToParse, String defaultRegion, PhoneNumber phoneNumber)
      throws NumberParseException {
    parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
  }

  /**
   * Parses a string and returns it in proto buffer format. This method differs from {@link #parse}
   * in that it always populates the raw_input field of the protocol buffer with numberToParse as
   * well as the country_code_source field.
   *
   * @param numberToParse     number that we are attempting to parse. This can contain formatting
   *                          such as +, ( and -, as well as a phone number extension.
   * @param defaultRegion     region that we are expecting the number to be from. This is only used
   *                          if the number being parsed is not written in international format.
   *                          The country calling code for the number in this case would be stored
   *                          as that of the default region supplied.
   * @return                  a phone number proto buffer filled with the parsed number
   * @throws NumberParseException  if the string is not considered to be a viable phone number or if
   *                               no default region was supplied
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.745 -0500", hash_original_method = "19CBF359D0DD4BA30476F5C26D54CCE4", hash_generated_method = "1DCB28C85BC98D65D95D2ADC8593AF9B")
    
public PhoneNumber parseAndKeepRawInput(String numberToParse, String defaultRegion)
      throws NumberParseException {
    PhoneNumber phoneNumber = new PhoneNumber();
    parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
    return phoneNumber;
  }

  /**
   * Same as{@link #parseAndKeepRawInput(String, String)}, but accepts a mutable PhoneNumber as
   * a parameter to decrease object creation when invoked many times.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.748 -0500", hash_original_method = "56F5D9940BB01A0D66986596B5A9CF6E", hash_generated_method = "3F45ECB1B60034D8BAFADAA8E05FF854")
    
public void parseAndKeepRawInput(String numberToParse, String defaultRegion,
                                   PhoneNumber phoneNumber)
      throws NumberParseException {
    parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
  }
    static {
    String singleExtnSymbolsForMatching = "x\uFF58#\uFF03~\uFF5E";
    String singleExtnSymbolsForParsing = "," + singleExtnSymbolsForMatching;
    EXTN_PATTERNS_FOR_PARSING = createExtnPattern(singleExtnSymbolsForParsing);
    EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(singleExtnSymbolsForMatching);
  }

  /**
   * Returns an iterable over all {@link PhoneNumberMatch PhoneNumberMatches} in {@code text}. This
   * is a shortcut for {@link #findNumbers(CharSequence, String, Leniency, long)
   * getMatcher(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE)}.
   *
   * @param text              the text to search for phone numbers, null for no text
   * @param defaultRegion     region that we are expecting the number to be from. This is only used
   *                          if the number being parsed is not written in international format. The
   *                          country_code for the number in this case would be stored as that of
   *                          the default region supplied. May be null if only international
   *                          numbers are expected.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.750 -0500", hash_original_method = "FC749C2F4DF483D491476DD9FB58E6D5", hash_generated_method = "B84582DEB5A47C55193EDD1F4927F673")
    
public Iterable<PhoneNumberMatch> findNumbers(CharSequence text, String defaultRegion) {
    return findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
  }

  /**
   * Returns an iterable over all {@link PhoneNumberMatch PhoneNumberMatches} in {@code text}.
   *
   * @param text              the text to search for phone numbers, null for no text
   * @param defaultRegion     region that we are expecting the number to be from. This is only used
   *                          if the number being parsed is not written in international format. The
   *                          country_code for the number in this case would be stored as that of
   *                          the default region supplied. May be null if only international
   *                          numbers are expected.
   * @param leniency          the leniency to use when evaluating candidate phone numbers
   * @param maxTries          the maximum number of invalid numbers to try before giving up on the
   *                          text. This is to cover degenerate cases where the text has a lot of
   *                          false positives in it. Must be {@code >= 0}.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.755 -0500", hash_original_method = "C3E745E72AE45D5E83FFDE500327E040", hash_generated_method = "7B94E36C0A827F604F73429464347D86")
    
public Iterable<PhoneNumberMatch> findNumbers(
      final CharSequence text, final String defaultRegion, final Leniency leniency,
      final long maxTries) {

    return new Iterable<PhoneNumberMatch>() {
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:38.376 -0400", hash_original_method = "56A258F03FBDE6DC55F7DBEB97F457DD", hash_generated_method = "68319CC6EDC18C585FB0A57E7A49314D")
            
public Iterator<PhoneNumberMatch> iterator() {
        return new PhoneNumberMatcher(
            PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
      }
    };
  }

  /**
   * Parses a string and fills up the phoneNumber. This method is the same as the public
   * parse() method, with the exception that it allows the default region to be null, for use by
   * isNumberMatch(). checkRegion should be set to false if it is permitted for the default region
   * to be null or unknown ("ZZ").
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.760 -0500", hash_original_method = "B3135DA9F7C362E965D50679AE934189", hash_generated_method = "D7786DFE62457A3A95540647A0B65A2F")
    
private void parseHelper(String numberToParse, String defaultRegion, boolean keepRawInput,
                           boolean checkRegion, PhoneNumber phoneNumber)
      throws NumberParseException {
    if (numberToParse == null) {
      throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The phone number supplied was null.");
    }
    // Extract a possible number from the string passed in (this strips leading characters that
    // could not be the start of a phone number.)
    String number = extractPossibleNumber(numberToParse);
    if (!isViablePhoneNumber(number)) {
      throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER,
                                     "The string supplied did not seem to be a phone number.");
    }

    // Check the region supplied is valid, or that the extracted number starts with some sort of +
    // sign so the number's region can be determined.
    if (checkRegion && !checkRegionForParsing(number, defaultRegion)) {
      throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                                     "Missing or invalid default region.");
    }

    if (keepRawInput) {
      phoneNumber.setRawInput(numberToParse);
    }
    StringBuilder nationalNumber = new StringBuilder(number);
    // Attempt to parse extension first, since it doesn't require region-specific data and we want
    // to have the non-normalised number here.
    String extension = maybeStripExtension(nationalNumber);
    if (extension.length() > 0) {
      phoneNumber.setExtension(extension);
    }

    PhoneMetadata regionMetadata = getMetadataForRegion(defaultRegion);
    // Check to see if the number is given in international format so we know whether this number is
    // from the default region or not.
    StringBuilder normalizedNationalNumber = new StringBuilder();
    int countryCode = maybeExtractCountryCode(nationalNumber.toString(), regionMetadata,
                                              normalizedNationalNumber, keepRawInput, phoneNumber);
    if (countryCode != 0) {
      String phoneNumberRegion = getRegionCodeForCountryCode(countryCode);
      if (!phoneNumberRegion.equals(defaultRegion)) {
        regionMetadata = getMetadataForRegion(phoneNumberRegion);
      }
    } else {
      // If no extracted country calling code, use the region supplied instead. The national number
      // is just the normalized version of the number we were given to parse.
      normalize(nationalNumber);
      normalizedNationalNumber.append(nationalNumber);
      if (defaultRegion != null) {
        countryCode = regionMetadata.getCountryCode();
        phoneNumber.setCountryCode(countryCode);
      } else if (keepRawInput) {
        phoneNumber.clearCountryCodeSource();
      }
    }
    if (normalizedNationalNumber.length() < MIN_LENGTH_FOR_NSN) {
      throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
    }
    if (regionMetadata != null) {
      String carrierCode =
          maybeStripNationalPrefixAndCarrierCode(normalizedNationalNumber, regionMetadata);
      if (keepRawInput) {
        phoneNumber.setPreferredDomesticCarrierCode(carrierCode);
      }
    }
    int lengthOfNationalNumber = normalizedNationalNumber.length();
    if (lengthOfNationalNumber < MIN_LENGTH_FOR_NSN) {
      throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN,
                                     "The string supplied is too short to be a phone number.");
    }
    if (lengthOfNationalNumber > MAX_LENGTH_FOR_NSN) {
      throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG,
                                     "The string supplied is too long to be a phone number.");
    }
    if (normalizedNationalNumber.charAt(0) == '0') {
      phoneNumber.setItalianLeadingZero(true);
    }
    phoneNumber.setNationalNumber(Long.parseLong(normalizedNationalNumber.toString()));
  }

  /**
   * Takes two phone numbers and compares them for equality.
   *
   * <p>Returns EXACT_MATCH if the country_code, NSN, presence of a leading zero for Italian numbers
   * and any extension present are the same.
   * Returns NSN_MATCH if either or both has no region specified, and the NSNs and extensions are
   * the same.
   * Returns SHORT_NSN_MATCH if either or both has no region specified, or the region specified is
   * the same, and one NSN could be a shorter version of the other number. This includes the case
   * where one has an extension specified, and the other does not.
   * Returns NO_MATCH otherwise.
   * For example, the numbers +1 345 657 1234 and 657 1234 are a SHORT_NSN_MATCH.
   * The numbers +1 345 657 1234 and 345 657 are a NO_MATCH.
   *
   * @param firstNumberIn  first number to compare
   * @param secondNumberIn  second number to compare
   *
   * @return  NO_MATCH, SHORT_NSN_MATCH, NSN_MATCH or EXACT_MATCH depending on the level of equality
   *     of the two numbers, described in the method definition.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.763 -0500", hash_original_method = "83C8E6F8520B32A4B2A265A569BAF2C9", hash_generated_method = "EB186D79374F24DC0E4ECA5FE1F85BA8")
    
public MatchType isNumberMatch(PhoneNumber firstNumberIn, PhoneNumber secondNumberIn) {
    // Make copies of the phone number so that the numbers passed in are not edited.
    PhoneNumber firstNumber = new PhoneNumber();
    firstNumber.mergeFrom(firstNumberIn);
    PhoneNumber secondNumber = new PhoneNumber();
    secondNumber.mergeFrom(secondNumberIn);
    // First clear raw_input, country_code_source and preferred_domestic_carrier_code fields and any
    // empty-string extensions so that we can use the proto-buffer equality method.
    firstNumber.clearRawInput();
    firstNumber.clearCountryCodeSource();
    firstNumber.clearPreferredDomesticCarrierCode();
    secondNumber.clearRawInput();
    secondNumber.clearCountryCodeSource();
    secondNumber.clearPreferredDomesticCarrierCode();
    if (firstNumber.hasExtension() &&
        firstNumber.getExtension().length() == 0) {
        firstNumber.clearExtension();
    }
    if (secondNumber.hasExtension() &&
        secondNumber.getExtension().length() == 0) {
        secondNumber.clearExtension();
    }
    // Early exit if both had extensions and these are different.
    if (firstNumber.hasExtension() && secondNumber.hasExtension() &&
        !firstNumber.getExtension().equals(secondNumber.getExtension())) {
      return MatchType.NO_MATCH;
    }
    int firstNumberCountryCode = firstNumber.getCountryCode();
    int secondNumberCountryCode = secondNumber.getCountryCode();
    // Both had country_code specified.
    if (firstNumberCountryCode != 0 && secondNumberCountryCode != 0) {
      if (firstNumber.exactlySameAs(secondNumber)) {
        return MatchType.EXACT_MATCH;
      } else if (firstNumberCountryCode == secondNumberCountryCode &&
                 isNationalNumberSuffixOfTheOther(firstNumber, secondNumber)) {
        // A SHORT_NSN_MATCH occurs if there is a difference because of the presence or absence of
        // an 'Italian leading zero', the presence or absence of an extension, or one NSN being a
        // shorter variant of the other.
        return MatchType.SHORT_NSN_MATCH;
      }
      // This is not a match.
      return MatchType.NO_MATCH;
    }
    // Checks cases where one or both country_code fields were not specified. To make equality
    // checks easier, we first set the country_code fields to be equal.
    firstNumber.setCountryCode(secondNumberCountryCode);
    // If all else was the same, then this is an NSN_MATCH.
    if (firstNumber.exactlySameAs(secondNumber)) {
      return MatchType.NSN_MATCH;
    }
    if (isNationalNumberSuffixOfTheOther(firstNumber, secondNumber)) {
      return MatchType.SHORT_NSN_MATCH;
    }
    return MatchType.NO_MATCH;
  }

  // Returns true when one national number is the suffix of the other or both are the same.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.766 -0500", hash_original_method = "B2A134716BB483331B78911F7265BAC6", hash_generated_method = "56AD0B68FFF7E7385642B4DE128F1A67")
    
private boolean isNationalNumberSuffixOfTheOther(PhoneNumber firstNumber,
                                                   PhoneNumber secondNumber) {
    String firstNumberNationalNumber = String.valueOf(firstNumber.getNationalNumber());
    String secondNumberNationalNumber = String.valueOf(secondNumber.getNationalNumber());
    // Note that endsWith returns true if the numbers are equal.
    return firstNumberNationalNumber.endsWith(secondNumberNationalNumber) ||
           secondNumberNationalNumber.endsWith(firstNumberNationalNumber);
  }

  /**
   * Takes two phone numbers as strings and compares them for equality. This is a convenience
   * wrapper for {@link #isNumberMatch(Phonenumber.PhoneNumber, Phonenumber.PhoneNumber)}. No
   * default region is known.
   *
   * @param firstNumber  first number to compare. Can contain formatting, and can have country
   *     calling code specified with + at the start.
   * @param secondNumber  second number to compare. Can contain formatting, and can have country
   *     calling code specified with + at the start.
   * @return  NOT_A_NUMBER, NO_MATCH, SHORT_NSN_MATCH, NSN_MATCH, EXACT_MATCH. See
   *     {@link #isNumberMatch(Phonenumber.PhoneNumber, Phonenumber.PhoneNumber)} for more details.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.768 -0500", hash_original_method = "3C9E8BD2D7E8FA6C3BECA5B02E481416", hash_generated_method = "D074F041AF8C1DCC73258C014640F2EF")
    
public MatchType isNumberMatch(String firstNumber, String secondNumber) {
    try {
      PhoneNumber firstNumberAsProto = parse(firstNumber, UNKNOWN_REGION);
      return isNumberMatch(firstNumberAsProto, secondNumber);
    } catch (NumberParseException e) {
      if (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
        try {
          PhoneNumber secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
          return isNumberMatch(secondNumberAsProto, firstNumber);
        } catch (NumberParseException e2) {
          if (e2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
            try {
              PhoneNumber firstNumberProto = new PhoneNumber();
              PhoneNumber secondNumberProto = new PhoneNumber();
              parseHelper(firstNumber, null, false, false, firstNumberProto);
              parseHelper(secondNumber, null, false, false, secondNumberProto);
              return isNumberMatch(firstNumberProto, secondNumberProto);
            } catch (NumberParseException e3) {
              // Fall through and return MatchType.NOT_A_NUMBER.
            }
          }
        }
      }
    }
    // One or more of the phone numbers we are trying to match is not a viable phone number.
    return MatchType.NOT_A_NUMBER;
  }

  /**
   * Takes two phone numbers and compares them for equality. This is a convenience wrapper for
   * {@link #isNumberMatch(Phonenumber.PhoneNumber, Phonenumber.PhoneNumber)}. No default region is
   * known.
   *
   * @param firstNumber  first number to compare in proto buffer format.
   * @param secondNumber  second number to compare. Can contain formatting, and can have country
   *     calling code specified with + at the start.
   * @return  NOT_A_NUMBER, NO_MATCH, SHORT_NSN_MATCH, NSN_MATCH, EXACT_MATCH. See
   *     {@link #isNumberMatch(Phonenumber.PhoneNumber, Phonenumber.PhoneNumber)} for more details.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.771 -0500", hash_original_method = "FA442F82D618375A0E3FFC54DA76D9E3", hash_generated_method = "8E8C80BCAC2EBFCB31D2414C0141913B")
    
public MatchType isNumberMatch(PhoneNumber firstNumber, String secondNumber) {
    // First see if the second number has an implicit country calling code, by attempting to parse
    // it.
    try {
      PhoneNumber secondNumberAsProto = parse(secondNumber, UNKNOWN_REGION);
      return isNumberMatch(firstNumber, secondNumberAsProto);
    } catch (NumberParseException e) {
      if (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
        // The second number has no country calling code. EXACT_MATCH is no longer possible.
        // We parse it as if the region was the same as that for the first number, and if
        // EXACT_MATCH is returned, we replace this with NSN_MATCH.
        String firstNumberRegion = getRegionCodeForCountryCode(firstNumber.getCountryCode());
        try {
          if (!firstNumberRegion.equals(UNKNOWN_REGION)) {
            PhoneNumber secondNumberWithFirstNumberRegion = parse(secondNumber, firstNumberRegion);
            MatchType match = isNumberMatch(firstNumber, secondNumberWithFirstNumberRegion);
            if (match == MatchType.EXACT_MATCH) {
              return MatchType.NSN_MATCH;
            }
            return match;
          } else {
            // If the first number didn't have a valid country calling code, then we parse the
            // second number without one as well.
            PhoneNumber secondNumberProto = new PhoneNumber();
            parseHelper(secondNumber, null, false, false, secondNumberProto);
            return isNumberMatch(firstNumber, secondNumberProto);
          }
        } catch (NumberParseException e2) {
          // Fall-through to return NOT_A_NUMBER.
        }
      }
    }
    // One or more of the phone numbers we are trying to match is not a viable phone number.
    return MatchType.NOT_A_NUMBER;
  }

  /**
   * Returns true if the number can only be dialled from within the region. If unknown, or the
   * number can be dialled from outside the region as well, returns false. Does not check the
   * number is a valid number.
   * TODO: Make this method public when we have enough metadata to make it worthwhile. Currently
   * visible for testing purposes only.
   *
   * @param number  the phone-number for which we want to know whether it is only diallable from
   *     within the region
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:03.773 -0500", hash_original_method = "93167700613734CAFA37F508460EB7E3", hash_generated_method = "93167700613734CAFA37F508460EB7E3")
    
boolean canBeInternationallyDialled(PhoneNumber number) {
    String regionCode = getRegionCodeForNumber(number);
    String nationalSignificantNumber = getNationalSignificantNumber(number);
    if (!hasValidRegionCode(regionCode, number.getCountryCode(), nationalSignificantNumber)) {
      return true;
    }
    PhoneMetadata metadata = getMetadataForRegion(regionCode);
    return !isNumberMatchingDesc(nationalSignificantNumber, metadata.getNoInternationalDialling());
  }
}

