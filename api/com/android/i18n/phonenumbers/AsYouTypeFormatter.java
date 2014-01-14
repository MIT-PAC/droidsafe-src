package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadata;

public class AsYouTypeFormatter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.600 -0500", hash_original_field = "4F610ABD91CFC9CA631369F0C9531122", hash_generated_field = "5B7D0B52CB21DA6A99C67E3BE1997092")

  private static final PhoneMetadata EMPTY_METADATA =
      new PhoneMetadata().setInternationalPrefix("NA");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.607 -0500", hash_original_field = "B5EB8335DB400731903C7F0E24621CAC", hash_generated_field = "FECA11287D95BE571566827B07C0213B")

  // character class is [1-4].
  private static final Pattern CHARACTER_CLASS_PATTERN = Pattern.compile("\\[([^\\[\\]])*\\]");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.609 -0500", hash_original_field = "47AB3F0D9506D333DDFA20C9BAB231CE", hash_generated_field = "E490E7DD0F2D2A685BD52E6BE64C402E")

  // expression 80[0-2]\d{6,10}, the first 2 digits (8 and 0) are standalone digits, but the rest
  // are not.
  // Two look-aheads are needed because the number following \\d could be a two-digit number, since
  // the phone number can be as long as 15 digits.
  private static final Pattern STANDALONE_DIGIT_PATTERN = Pattern.compile("\\d(?=[^,}][^,}])");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.611 -0500", hash_original_field = "A58EBDE352C6C2D9C7F889BF1F52BE3A", hash_generated_field = "65C72543172C8AF14C6EFF468807A4BE")

  // used by the AYTF. It is eligible when the format element under numberFormat contains groups of
  // the dollar sign followed by a single digit, separated by valid phone number punctuation. This
  // prevents invalid punctuation (such as the star sign in Israeli star numbers) getting into the
  // output of the AYTF.
  private static final Pattern ELIGIBLE_FORMAT_PATTERN =
      Pattern.compile("[" + PhoneNumberUtil.VALID_PUNCTUATION + "]*" +
          "(\\$\\d" + "[" + PhoneNumberUtil.VALID_PUNCTUATION + "]*)+");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.614 -0500", hash_original_field = "BD925030DB50D2F048A09D6BBB8D0278", hash_generated_field = "4794C50755391A46AE7F16875EEE4D28")

  // formatter. The first element of the leadingDigitsPattern of each numberFormat contains a
  // regular expression that matches up to this number of digits.
  private static final int MIN_LEADING_DIGITS_LENGTH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.577 -0500", hash_original_field = "4AEED790EA61715A250F6989A46A95A0", hash_generated_field = "0C350DE511BE7B52540BBA3416D1A46C")

  private String currentOutput = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.579 -0500", hash_original_field = "562B358AFA2EAB5D62DEEEE64A09A0C4", hash_generated_field = "09F9323AC7F5DB51B79E6FB4689A0073")

  private StringBuilder formattingTemplate = new StringBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.581 -0500", hash_original_field = "498908DF56F69C1AC03E6DF98A85AC0B", hash_generated_field = "6A54B02BA2C7E4165F427873C017B488")

  private String currentFormattingPattern = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.583 -0500", hash_original_field = "68746D6B5163B0F256110ED94057F568", hash_generated_field = "29CDE2D2FAA8268827B1B884DC2F18BA")

  private StringBuilder accruedInput = new StringBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.586 -0500", hash_original_field = "36B81CACC2ECC8D1B0D344D472E6AEBF", hash_generated_field = "E579FAA49690664D33A278DEA0E8B5A6")

  private StringBuilder accruedInputWithoutFormatting = new StringBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.588 -0500", hash_original_field = "593CA6264D9315F17CD0085C3B326260", hash_generated_field = "2095ACFBFC258F92C73D192F518E00D7")

  private boolean ableToFormat = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.590 -0500", hash_original_field = "E1D0717474E3316DDF38F685879A4323", hash_generated_field = "168C680E9820B2FFBEB1B9E07688ACEE")

  private boolean isInternationalFormatting = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.592 -0500", hash_original_field = "3EF7734A4F290186164D9696933BB363", hash_generated_field = "9C2BB325FBB2EC7864F760CFE394F16E")

  private boolean isExpectingCountryCallingCode = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.595 -0500", hash_original_field = "77B7FB9FF47C6498ED40292699F59FD1", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")

  private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.598 -0500", hash_original_field = "4B33155BCF5D8C05A6D135F7600B7693", hash_generated_field = "6FD38F26B0E8DBBA6EF73F09FB6B4141")

  private String defaultCountry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.602 -0500", hash_original_field = "7DF58112C4393C8F6120235A5073EF62", hash_generated_field = "120A053E2F4E55161B2E4207EE1C05CF")

  private PhoneMetadata defaultMetaData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.604 -0500", hash_original_field = "FC6BB1069F7AD44C3E5B2975AA29FCE0", hash_generated_field = "35B49383D60A264DAE321C3C26CE1990")

  private PhoneMetadata currentMetaData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.617 -0500", hash_original_field = "A862CFB51CE55232225BBF50BB54C568", hash_generated_field = "EC85B7998BF08C5C6D649CC4475E5E01")

  // space.
  private String digitPlaceholder = "\u2008";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.619 -0500", hash_original_field = "2E8086038774482920E864F69A8FA8B4", hash_generated_field = "A012D752824ECE91B83A6649421B0E5D")

  private Pattern digitPattern = Pattern.compile(digitPlaceholder);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.621 -0500", hash_original_field = "F84EA034CBA48F3F2569B37B71BDF928", hash_generated_field = "118190E2A789D8F137699A3B010FBDD5")

  private int lastMatchPosition = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.623 -0500", hash_original_field = "A506E2518185860BB89A981FBC328D5A", hash_generated_field = "92D65F4694D089B74F0AE3B0B2115874")

  // found in the original sequence of characters the user entered.
  private int originalPosition = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.625 -0500", hash_original_field = "A4C4B210631A252AA1518DE471D7C737", hash_generated_field = "D90028A2BB2DA707A2E04545352DFDD4")

  // found in accruedInputWithoutFormatting.
  private int positionToRemember = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.627 -0500", hash_original_field = "FC9BC9125A4F14B773A0CF0CD14A9B4A", hash_generated_field = "E91BED07269C3A918A7C430BB9D5D341")

  private StringBuilder prefixBeforeNationalNumber = new StringBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.630 -0500", hash_original_field = "F8E41534BED4D87AE2C33950AF3CCA69", hash_generated_field = "5578ADECAFE9EAFCE3065ED8EBE1D841")

  private StringBuilder nationalNumber = new StringBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.632 -0500", hash_original_field = "EB1F6CD901C1BA75DFB674CA2F1B4CF1", hash_generated_field = "23CDF3D9149C891AD1D66C6C35974D4E")

  private List<NumberFormat> possibleFormats = new ArrayList<NumberFormat>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.635 -0500", hash_original_field = "998E4DBD5487885AA50923485500BD5B", hash_generated_field = "FEE3B86D57B366ADF75BCFCDCCAF1CE3")

  private RegexCache regexCache = new RegexCache(64);

  /**
   * Constructs an as-you-type formatter. Should be obtained from {@link
   * PhoneNumberUtil#getAsYouTypeFormatter}.
   *
   * @param regionCode  the country/region where the phone number is being entered
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.637 -0500", hash_original_method = "936F5C412B2E8DF425145B47DD5CAEF0", hash_generated_method = "936F5C412B2E8DF425145B47DD5CAEF0")
    
AsYouTypeFormatter(String regionCode) {
    defaultCountry = regionCode;
    currentMetaData = getMetadataForRegion(defaultCountry);
    defaultMetaData = currentMetaData;
  }

  // The metadata needed by this class is the same for all regions sharing the same country calling
  // code. Therefore, we return the metadata for "main" region for this country calling code.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.639 -0500", hash_original_method = "881E62338E39DD444804F246615E6E62", hash_generated_method = "55F40A9372C3B9F172E41BCF473319BC")
    
private PhoneMetadata getMetadataForRegion(String regionCode) {
    int countryCallingCode = phoneUtil.getCountryCodeForRegion(regionCode);
    String mainCountry = phoneUtil.getRegionCodeForCountryCode(countryCallingCode);
    PhoneMetadata metadata = phoneUtil.getMetadataForRegion(mainCountry);
    if (metadata != null) {
      return metadata;
    }
    // Set to a default instance of the metadata. This allows us to function with an incorrect
    // region code, even if formatting only works for numbers specified with "+".
    return EMPTY_METADATA;
  }

  // Returns true if a new template is created as opposed to reusing the existing template.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.642 -0500", hash_original_method = "AB8E8EDD80C278D4452E081702FFED46", hash_generated_method = "71B6A1684BF531EB8752EE89AB50D9D1")
    
private boolean maybeCreateNewTemplate() {
    // When there are multiple available formats, the formatter uses the first format where a
    // formatting template could be created.
    Iterator<NumberFormat> it = possibleFormats.iterator();
    while (it.hasNext()) {
      NumberFormat numberFormat = it.next();
      String pattern = numberFormat.getPattern();
      if (currentFormattingPattern.equals(pattern)) {
        return false;
      }
      if (createFormattingTemplate(numberFormat)) {
        currentFormattingPattern = pattern;
        return true;
      } else {  // Remove the current number format from possibleFormats.
        it.remove();
      }
    }
    ableToFormat = false;
    return false;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.644 -0500", hash_original_method = "37D81E1E00F803BB98B41301D27D6488", hash_generated_method = "F1C6F430C859B83950B1360AEE22F66F")
    
private void getAvailableFormats(String leadingThreeDigits) {
    List<NumberFormat> formatList =
        (isInternationalFormatting && currentMetaData.intlNumberFormatSize() > 0)
        ? currentMetaData.intlNumberFormats()
        : currentMetaData.numberFormats();
    for (NumberFormat format : formatList) {
      if (isFormatEligible(format.getFormat())) {
        possibleFormats.add(format);
      }
    }
    narrowDownPossibleFormats(leadingThreeDigits);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.647 -0500", hash_original_method = "0CD8D9B07AADCF252FD63C0FF91E8BCD", hash_generated_method = "876E53628EBD7C17CCEAA9A77DD8BA6F")
    
private boolean isFormatEligible(String format) {
    return ELIGIBLE_FORMAT_PATTERN.matcher(format).matches();
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.649 -0500", hash_original_method = "3E367C813BED2017BCCC9CAE77808F34", hash_generated_method = "442E1C82D47C820479966DFA882E1958")
    
private void narrowDownPossibleFormats(String leadingDigits) {
    int indexOfLeadingDigitsPattern = leadingDigits.length() - MIN_LEADING_DIGITS_LENGTH;
    Iterator<NumberFormat> it = possibleFormats.iterator();
    while (it.hasNext()) {
      NumberFormat format = it.next();
      if (format.leadingDigitsPatternSize() > indexOfLeadingDigitsPattern) {
        Pattern leadingDigitsPattern =
            regexCache.getPatternForRegex(
                format.getLeadingDigitsPattern(indexOfLeadingDigitsPattern));
        Matcher m = leadingDigitsPattern.matcher(leadingDigits);
        if (!m.lookingAt()) {
          it.remove();
        }
      } // else the particular format has no more specific leadingDigitsPattern, and it should be
        // retained.
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.651 -0500", hash_original_method = "2542CBCB3D3982D996EED604A627F745", hash_generated_method = "3DD643CB057E9D720BA7A41A46BA9A25")
    
private boolean createFormattingTemplate(NumberFormat format) {
    String numberPattern = format.getPattern();

    // The formatter doesn't format numbers when numberPattern contains "|", e.g.
    // (20|3)\d{4}. In those cases we quickly return.
    if (numberPattern.indexOf('|') != -1) {
      return false;
    }

    // Replace anything in the form of [..] with \d
    numberPattern = CHARACTER_CLASS_PATTERN.matcher(numberPattern).replaceAll("\\\\d");

    // Replace any standalone digit (not the one in d{}) with \d
    numberPattern = STANDALONE_DIGIT_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
    formattingTemplate.setLength(0);
    String tempTemplate = getFormattingTemplate(numberPattern, format.getFormat());
    if (tempTemplate.length() > 0) {
      formattingTemplate.append(tempTemplate);
      return true;
    }
    return false;
  }

  // Gets a formatting template which can be used to efficiently format a partial number where
  // digits are added one by one.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.654 -0500", hash_original_method = "D11FAAF63EBAF37B7C1EC170EAFCD005", hash_generated_method = "648078D006F05F16C51735A9A42EE038")
    
private String getFormattingTemplate(String numberPattern, String numberFormat) {
    // Creates a phone number consisting only of the digit 9 that matches the
    // numberPattern by applying the pattern to the longestPhoneNumber string.
    String longestPhoneNumber = "999999999999999";
    Matcher m = regexCache.getPatternForRegex(numberPattern).matcher(longestPhoneNumber);
    m.find();  // this will always succeed
    String aPhoneNumber = m.group();
    // No formatting template can be created if the number of digits entered so far is longer than
    // the maximum the current formatting rule can accommodate.
    if (aPhoneNumber.length() < nationalNumber.length()) {
      return "";
    }
    // Formats the number according to numberFormat
    String template = aPhoneNumber.replaceAll(numberPattern, numberFormat);
    // Replaces each digit with character digitPlaceholder
    template = template.replaceAll("9", digitPlaceholder);
    return template;
  }

  /**
   * Clears the internal state of the formatter, so it can be reused.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.656 -0500", hash_original_method = "8F04C2F49656580CD2F07A034451AAD3", hash_generated_method = "A36F30A03F396A23CC6C0710B11118E8")
    
public void clear() {
    currentOutput = "";
    accruedInput.setLength(0);
    accruedInputWithoutFormatting.setLength(0);
    formattingTemplate.setLength(0);
    lastMatchPosition = 0;
    currentFormattingPattern = "";
    prefixBeforeNationalNumber.setLength(0);
    nationalNumber.setLength(0);
    ableToFormat = true;
    positionToRemember = 0;
    originalPosition = 0;
    isInternationalFormatting = false;
    isExpectingCountryCallingCode = false;
    possibleFormats.clear();
    if (!currentMetaData.equals(defaultMetaData)) {
      currentMetaData = getMetadataForRegion(defaultCountry);
    }
  }

  /**
   * Formats a phone number on-the-fly as each digit is entered.
   *
   * @param nextChar  the most recently entered digit of a phone number. Formatting characters are
   *     allowed, but as soon as they are encountered this method formats the number as entered and
   *     not "as you type" anymore. Full width digits and Arabic-indic digits are allowed, and will
   *     be shown as they are.
   * @return  the partially formatted phone number.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.658 -0500", hash_original_method = "F7260472EF36A540999D13D4CAA6ECE9", hash_generated_method = "350B06E4F070C72BD6BCCB21FA579040")
    
public String inputDigit(char nextChar) {
    currentOutput = inputDigitWithOptionToRememberPosition(nextChar, false);
    return currentOutput;
  }

  /**
   * Same as {@link #inputDigit}, but remembers the position where {@code nextChar} is inserted, so
   * that it can be retrieved later by using {@link #getRememberedPosition}. The remembered
   * position will be automatically adjusted if additional formatting characters are later
   * inserted/removed in front of {@code nextChar}.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.661 -0500", hash_original_method = "5CF2674AEE53F09D43FB9E46A011FFC0", hash_generated_method = "6F7540017AE9C883CF91EC6C3440250C")
    
public String inputDigitAndRememberPosition(char nextChar) {
    currentOutput = inputDigitWithOptionToRememberPosition(nextChar, true);
    return currentOutput;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.664 -0500", hash_original_method = "6C89C7F3A0AAC3A12D8456578D2D5E4E", hash_generated_method = "CDB7C628D2C00931657A7E23FD487A3C")
    
@SuppressWarnings("fallthrough")
  private String inputDigitWithOptionToRememberPosition(char nextChar, boolean rememberPosition) {
    accruedInput.append(nextChar);
    if (rememberPosition) {
      originalPosition = accruedInput.length();
    }
    // We do formatting on-the-fly only when each character entered is either a digit, or a plus
    // sign (accepted at the start of the number only).
    if (!isDigitOrLeadingPlusSign(nextChar)) {
      ableToFormat = false;
    }
    if (!ableToFormat) {
      return accruedInput.toString();
    }

    nextChar = normalizeAndAccrueDigitsAndPlusSign(nextChar, rememberPosition);

    // We start to attempt to format only when at least MIN_LEADING_DIGITS_LENGTH digits (the plus
    // sign is counted as a digit as well for this purpose) have been entered.
    switch (accruedInputWithoutFormatting.length()) {
      case 0:
      case 1:
      case 2:
        return accruedInput.toString();
      case 3:
        if (attemptToExtractIdd()) {
          isExpectingCountryCallingCode = true;
        } else {  // No IDD or plus sign is found, must be entering in national format.
          removeNationalPrefixFromNationalNumber();
          return attemptToChooseFormattingPattern();
        }
      case 4:
      case 5:
        if (isExpectingCountryCallingCode) {
          if (attemptToExtractCountryCallingCode()) {
            isExpectingCountryCallingCode = false;
          }
          return prefixBeforeNationalNumber + nationalNumber.toString();
        }
      // We make a last attempt to extract a country calling code at the 6th digit because the
      // maximum length of IDD and country calling code are both 3.
      case 6:
        if (isExpectingCountryCallingCode && !attemptToExtractCountryCallingCode()) {
          ableToFormat = false;
          return accruedInput.toString();
        }
      default:
        if (possibleFormats.size() > 0) {  // The formatting pattern is already chosen.
          String tempNationalNumber = inputDigitHelper(nextChar);
          // See if the accrued digits can be formatted properly already. If not, use the results
          // from inputDigitHelper, which does formatting based on the formatting pattern chosen.
          String formattedNumber = attemptToFormatAccruedDigits();
          if (formattedNumber.length() > 0) {
            return formattedNumber;
          }
          narrowDownPossibleFormats(nationalNumber.toString());
          if (maybeCreateNewTemplate()) {
            return inputAccruedNationalNumber();
          }
          return ableToFormat
             ? prefixBeforeNationalNumber + tempNationalNumber
             : accruedInput.toString();
        } else {
          return attemptToChooseFormattingPattern();
        }
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.667 -0500", hash_original_method = "3C59019883483E3D8800E37699311374", hash_generated_method = "E3B65007E973BA65ABD6EE6AD8A46FA1")
    
private boolean isDigitOrLeadingPlusSign(char nextChar) {
    return Character.isDigit(nextChar) ||
        (accruedInput.length() == 1 &&
         PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(nextChar)).matches());
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.670 -0500", hash_original_method = "9BC9DDDBE79729997007D59699BB4F8B", hash_generated_method = "9BC9DDDBE79729997007D59699BB4F8B")
    
String attemptToFormatAccruedDigits() {
    for (NumberFormat numFormat : possibleFormats) {
      Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
      if (m.matches()) {
        String formattedNumber = m.replaceAll(numFormat.getFormat());
        return prefixBeforeNationalNumber + formattedNumber;
      }
    }
    return "";
  }

  /**
   * Returns the current position in the partially formatted phone number of the character which was
   * previously passed in as the parameter of {@link #inputDigitAndRememberPosition}.
   */
  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.672 -0500", hash_original_method = "454614081331C76956AF09B40EA354E2", hash_generated_method = "41B9680BFC0E76DDEC68BF055BC1426D")
    
public int getRememberedPosition() {
    if (!ableToFormat) {
      return originalPosition;
    }
    int accruedInputIndex = 0, currentOutputIndex = 0;
    while (accruedInputIndex < positionToRemember && currentOutputIndex < currentOutput.length()) {
      if (accruedInputWithoutFormatting.charAt(accruedInputIndex) ==
          currentOutput.charAt(currentOutputIndex)) {
        accruedInputIndex++;
      }
      currentOutputIndex++;
    }
    return currentOutputIndex;
  }

  // Attempts to set the formatting template and returns a string which contains the formatted
  // version of the digits entered so far.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.674 -0500", hash_original_method = "4C8321A90BCC237ABE581FD0E018E0B0", hash_generated_method = "CF18A5CD2F9C28177D5181E04DC3DD1C")
    
private String attemptToChooseFormattingPattern() {
    // We start to attempt to format only when as least MIN_LEADING_DIGITS_LENGTH digits of national
    // number (excluding national prefix) have been entered.
    if (nationalNumber.length() >= MIN_LEADING_DIGITS_LENGTH) {
      getAvailableFormats(nationalNumber.substring(0, MIN_LEADING_DIGITS_LENGTH));
      maybeCreateNewTemplate();
      return inputAccruedNationalNumber();
    } else {
      return prefixBeforeNationalNumber + nationalNumber.toString();
    }
  }

  // Invokes inputDigitHelper on each digit of the national number accrued, and returns a formatted
  // string in the end.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.677 -0500", hash_original_method = "A0C52ED0A89DE12301F2C974C5007560", hash_generated_method = "4E9AB7CC26A266D36A79C6593165BE01")
    
private String inputAccruedNationalNumber() {
    int lengthOfNationalNumber = nationalNumber.length();
    if (lengthOfNationalNumber > 0) {
      String tempNationalNumber = "";
      for (int i = 0; i < lengthOfNationalNumber; i++) {
        tempNationalNumber = inputDigitHelper(nationalNumber.charAt(i));
      }
      return ableToFormat
          ? prefixBeforeNationalNumber + tempNationalNumber
          : accruedInput.toString();
    } else {
      return prefixBeforeNationalNumber.toString();
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.679 -0500", hash_original_method = "810622AECED476A4374C59B83D98E171", hash_generated_method = "684C47BF347C0C5B33CDF772354CBCD9")
    
private void removeNationalPrefixFromNationalNumber() {
    int startOfNationalNumber = 0;
    if (currentMetaData.getCountryCode() == 1 && nationalNumber.charAt(0) == '1') {
      startOfNationalNumber = 1;
      prefixBeforeNationalNumber.append("1 ");
      isInternationalFormatting = true;
    } else if (currentMetaData.hasNationalPrefix()) {
      Pattern nationalPrefixForParsing =
        regexCache.getPatternForRegex(currentMetaData.getNationalPrefixForParsing());
      Matcher m = nationalPrefixForParsing.matcher(nationalNumber);
      if (m.lookingAt()) {
        // When the national prefix is detected, we use international formatting rules instead of
        // national ones, because national formatting rules could contain local formatting rules
        // for numbers entered without area code.
        isInternationalFormatting = true;
        startOfNationalNumber = m.end();
        prefixBeforeNationalNumber.append(nationalNumber.substring(0, startOfNationalNumber));
      }
    }
    nationalNumber.delete(0, startOfNationalNumber);
  }

  /**
   * Extracts IDD and plus sign to prefixBeforeNationalNumber when they are available, and places
   * the remaining input into nationalNumber.
   *
   * @return  true when accruedInputWithoutFormatting begins with the plus sign or valid IDD for
   *     defaultCountry.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.682 -0500", hash_original_method = "B953FBA4B3460899EA66156C6BB3FF32", hash_generated_method = "0F2C9EA9D6463014D7258E4CC5BB8B7D")
    
private boolean attemptToExtractIdd() {
    Pattern internationalPrefix =
        regexCache.getPatternForRegex("\\" + PhoneNumberUtil.PLUS_SIGN + "|" +
            currentMetaData.getInternationalPrefix());
    Matcher iddMatcher = internationalPrefix.matcher(accruedInputWithoutFormatting);
    if (iddMatcher.lookingAt()) {
      isInternationalFormatting = true;
      int startOfCountryCallingCode = iddMatcher.end();
      nationalNumber.setLength(0);
      nationalNumber.append(accruedInputWithoutFormatting.substring(startOfCountryCallingCode));
      prefixBeforeNationalNumber.append(
          accruedInputWithoutFormatting.substring(0, startOfCountryCallingCode));
      if (accruedInputWithoutFormatting.charAt(0) != PhoneNumberUtil.PLUS_SIGN) {
        prefixBeforeNationalNumber.append(" ");
      }
      return true;
    }
    return false;
  }

  /**
   * Extracts the country calling code from the beginning of nationalNumber to
   * prefixBeforeNationalNumber when they are available, and places the remaining input into
   * nationalNumber.
   *
   * @return  true when a valid country calling code can be found.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.684 -0500", hash_original_method = "218BC2BA6DFB456EB7693A201AB85277", hash_generated_method = "F69F0AF74A9089F685343761B088AEFA")
    
private boolean attemptToExtractCountryCallingCode() {
    if (nationalNumber.length() == 0) {
      return false;
    }
    StringBuilder numberWithoutCountryCallingCode = new StringBuilder();
    int countryCode = phoneUtil.extractCountryCode(nationalNumber, numberWithoutCountryCallingCode);
    if (countryCode == 0) {
      return false;
    }
    nationalNumber.setLength(0);
    nationalNumber.append(numberWithoutCountryCallingCode);
    String newRegionCode = phoneUtil.getRegionCodeForCountryCode(countryCode);
    if (!newRegionCode.equals(defaultCountry)) {
      currentMetaData = getMetadataForRegion(newRegionCode);
    }
    String countryCodeString = Integer.toString(countryCode);
    prefixBeforeNationalNumber.append(countryCodeString).append(" ");
    return true;
  }

  // Accrues digits and the plus sign to accruedInputWithoutFormatting for later use. If nextChar
  // contains a digit in non-ASCII format (e.g. the full-width version of digits), it is first
  // normalized to the ASCII version. The return value is nextChar itself, or its normalized
  // version, if nextChar is a digit in non-ASCII format. This method assumes its input is either a
  // digit or the plus sign.
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.687 -0500", hash_original_method = "77D81BD33F378FE00304ED0E0D731511", hash_generated_method = "3D2E7794562692432F5A066068309978")
    
private char normalizeAndAccrueDigitsAndPlusSign(char nextChar, boolean rememberPosition) {
    char normalizedChar;
    if (nextChar == PhoneNumberUtil.PLUS_SIGN) {
      normalizedChar = nextChar;
      accruedInputWithoutFormatting.append(nextChar);
    } else {
      int radix = 10;
      normalizedChar = Character.forDigit(Character.digit(nextChar, radix), radix);
      accruedInputWithoutFormatting.append(normalizedChar);
      nationalNumber.append(normalizedChar);
    }
    if (rememberPosition) {
      positionToRemember = accruedInputWithoutFormatting.length();
    }
    return normalizedChar;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.689 -0500", hash_original_method = "E1A45868A03256452AD2B7163B170B11", hash_generated_method = "3E9926CFA0158697797B4A95BE8345E8")
    
private String inputDigitHelper(char nextChar) {
    Matcher digitMatcher = digitPattern.matcher(formattingTemplate);
    if (digitMatcher.find(lastMatchPosition)) {
      String tempTemplate = digitMatcher.replaceFirst(Character.toString(nextChar));
      formattingTemplate.replace(0, tempTemplate.length(), tempTemplate);
      lastMatchPosition = digitMatcher.start();
      return formattingTemplate.substring(0, lastMatchPosition + 1);
    } else {
      if (possibleFormats.size() == 1) {
        // More digits are entered than we could handle, and there are no other valid patterns to
        // try.
        ableToFormat = false;
      }  // else, we just reset the formatting pattern.
      currentFormattingPattern = "";
      return accruedInput.toString();
    }
  }
}

