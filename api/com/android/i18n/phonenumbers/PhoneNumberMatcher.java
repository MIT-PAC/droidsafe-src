package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.i18n.phonenumbers.PhoneNumberUtil.Leniency;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;

final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {

  /** Returns a regular expression quantifier with an upper and lower limit. */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.118 -0500", hash_original_method = "FEB84A328EE7F3166E4E0FA71F02D2E0", hash_generated_method = "A8A19550D0A1B28AF44CDAE5D0E2399B")
    
private static String limit(int lower, int upper) {
    if ((lower < 0) || (upper <= 0) || (upper < lower)) {
      throw new IllegalArgumentException();
    }
    return "{" + lower + "," + upper + "}";
  }

  /**
   * Trims away any characters after the first match of {@code pattern} in {@code candidate},
   * returning the trimmed version.
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.153 -0500", hash_original_method = "AB1D11A817737E1FAD20796B1941F248", hash_generated_method = "25FCE6A88C437FD6A09F9BF4EDF639F0")
    
private static CharSequence trimAfterFirstMatch(Pattern pattern, CharSequence candidate) {
    Matcher trailingCharsMatcher = pattern.matcher(candidate);
    if (trailingCharsMatcher.find()) {
      candidate = candidate.subSequence(0, trailingCharsMatcher.start());
    }
    return candidate;
  }

  /**
   * Helper method to determine if a character is a Latin-script letter or not. For our purposes,
   * combining marks should also return true since we assume they have been added to a preceding
   * Latin character.
   */
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.156 -0500", hash_original_method = "554CF3040E9CF07F05663E3B5F16517A", hash_generated_method = "A8F0E5EA62744C26D0169D65C29CE734")
    
static boolean isLatinLetter(char letter) {
    // Combining marks are a subset of non-spacing-mark.
    if (!Character.isLetter(letter) && Character.getType(letter) != Character.NON_SPACING_MARK) {
      return false;
    }
    UnicodeBlock block = UnicodeBlock.of(letter);
    return block.equals(UnicodeBlock.BASIC_LATIN) ||
        block.equals(UnicodeBlock.LATIN_1_SUPPLEMENT) ||
        block.equals(UnicodeBlock.LATIN_EXTENDED_A) ||
        block.equals(UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) ||
        block.equals(UnicodeBlock.LATIN_EXTENDED_B) ||
        block.equals(UnicodeBlock.COMBINING_DIACRITICAL_MARKS);
  }

  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.159 -0500", hash_original_method = "D59D72E25010879107B56CC21125EBDA", hash_generated_method = "C8247B36BE222BC06BFD92CBA4FFD281")
    
private static boolean isCurrencySymbol(char character) {
    return Character.getType(character) == Character.CURRENCY_SYMBOL;
  }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.103 -0500", hash_original_field = "F989734BE55AF97D011F6C951500BE39", hash_generated_field = "B67DB8AD534231B3DFBCDC8FADB87CD9")

  private static  Pattern PATTERN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.105 -0500", hash_original_field = "269B231576FE10F93DF42B8FE6C71550", hash_generated_field = "AFDD5A0D3478F459E19A9B28F0825662")

  private static final Pattern PUB_PAGES = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.108 -0500", hash_original_field = "C42DD7CC48069621EBCA9EAF7036C1F3", hash_generated_field = "64624B78B0314B7CE8F5D8865FF30674")

  private static final Pattern SLASH_SEPARATED_DATES =
      Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.111 -0500", hash_original_field = "54EFF20C086F9452E499390077FCD5FA", hash_generated_field = "0E3E98A4E9E55E5D5355E96742720F77")

  private static  Pattern MATCHING_BRACKETS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.113 -0500", hash_original_field = "CA4F6714E53E82DA8AEED27C72D80F0F", hash_generated_field = "07B48D8DD762837F8558D15A298E7F7C")

  private static  Pattern GROUP_SEPARATOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.116 -0500", hash_original_field = "4162D79F7224F9776226BEFCBC32F05F", hash_generated_field = "BFF4C6D5BA3233E2F2554B8CEE31C6BF")

  private static  Pattern LEAD_CLASS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.123 -0500", hash_original_field = "84443D8F5E184105D6EA71883B0EB14B", hash_generated_field = "2E33D99F5B4A20B25B98A154596BE936")

  private  PhoneNumberUtil phoneUtil;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.126 -0500", hash_original_field = "0F26345BF87C16C80BAC76779863E330", hash_generated_field = "5FBEDC86BE77699C3F0DD393BD5C241B")

  private  CharSequence text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.129 -0500", hash_original_field = "13130F7B833A14B0C4E2ECB42DFD1397", hash_generated_field = "919257B95C0A2873677AF8F369A2FD23")

  private  String preferredRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.131 -0500", hash_original_field = "DBBD7C3F740D4C76D639D28725877A6D", hash_generated_field = "1901EB03238813E3A90CAB00F8F24531")

  private  Leniency leniency;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.133 -0500", hash_original_field = "5D3D8DDD2BE3EBABFAD78342587A0162", hash_generated_field = "5BD507CEE6539816D66E14C52F3CEA0F")

  private long maxTries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.136 -0500", hash_original_field = "CF3F75B688BD7BB4EF0AF07117F933EF", hash_generated_field = "D868360155DE4E01C861A8C867061965")

  private State state = State.NOT_READY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.138 -0500", hash_original_field = "B35557E4AA4A5D68F1C14EF3D6D0F13F", hash_generated_field = "CD2E461A3543C1B081C303C6BA322BB5")

  private PhoneNumberMatch lastMatch = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.140 -0500", hash_original_field = "60EFD01467875E2618FA1956B806EA36", hash_generated_field = "73A01B8956D34AAB07FB4276843E3EFF")

  private int searchIndex = 0;

  /**
   * Creates a new instance. See the factory methods in {@link PhoneNumberUtil} on how to obtain a
   * new instance.
   *
   * @param util      the phone number util to use
   * @param text      the character sequence that we will search, null for no text
   * @param country   the country to assume for phone numbers not written in international format
   *                  (with a leading plus, or with the international dialing prefix of the
   *                  specified region). May be null or "ZZ" if only numbers with a
   *                  leading plus should be considered.
   * @param leniency  the leniency to use when evaluating candidate phone numbers
   * @param maxTries  the maximum number of invalid numbers to try before giving up on the text.
   *                  This is to cover degenerate cases where the text has a lot of false positives
   *                  in it. Must be {@code >= 0}.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.143 -0500", hash_original_method = "1C998965C70C11F4F601639EB7EFDC0A", hash_generated_method = "1C998965C70C11F4F601639EB7EFDC0A")
    
PhoneNumberMatcher(PhoneNumberUtil util, CharSequence text, String country, Leniency leniency,
      long maxTries) {

    if ((util == null) || (leniency == null)) {
      throw new NullPointerException();
    }
    if (maxTries < 0) {
      throw new IllegalArgumentException();
    }
    this.phoneUtil = util;
    this.text = (text != null) ? text : "";
    this.preferredRegion = country;
    this.leniency = leniency;
    this.maxTries = maxTries;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.145 -0500", hash_original_method = "2A2342D3C783955CFC983767F5F149A5", hash_generated_method = "C6DACE382E8C51CBA13CBC8F7B386FEE")
    
public boolean hasNext() {
    if (state == State.NOT_READY) {
      lastMatch = find(searchIndex);
      if (lastMatch == null) {
        state = State.DONE;
      } else {
        searchIndex = lastMatch.end();
        state = State.READY;
      }
    }
    return state == State.READY;
  }
    
    private enum State {
    NOT_READY, READY, DONE
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.148 -0500", hash_original_method = "41BA4BAFF42817F4E65D9346C9FF2DB0", hash_generated_method = "A8303C9A79DA35E0B1C59721487E2DF7")
    
public PhoneNumberMatch next() {
    // Check the state and find the next match as a side-effect if necessary.
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    // Don't retain that memory any longer than necessary.
    PhoneNumberMatch result = lastMatch;
    lastMatch = null;
    state = State.NOT_READY;
    return result;
  }

  /**
   * Attempts to find the next subsequence in the searched sequence on or after {@code searchIndex}
   * that represents a phone number. Returns the next match, null if none was found.
   *
   * @param index  the search index to start searching at
   * @return  the phone number match found, null if none can be found
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.150 -0500", hash_original_method = "100C9BD21D85AF1E644A5205A8C5603D", hash_generated_method = "26C29AB2CDD6239ED3186A0364BE41D2")
    
private PhoneNumberMatch find(int index) {
    Matcher matcher = PATTERN.matcher(text);
    while ((maxTries > 0) && matcher.find(index)) {
      int start = matcher.start();
      CharSequence candidate = text.subSequence(start, matcher.end());

      // Check for extra numbers at the end.
      // TODO: This is the place to start when trying to support extraction of multiple phone number
      // from split notations (+41 79 123 45 67 / 68).
      candidate = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, candidate);

      PhoneNumberMatch match = extractMatch(candidate, start);
      if (match != null) {
        return match;
      }

      index = start + candidate.length();
      maxTries--;
    }

    return null;
  }

  /**
   * Attempts to extract a match from a {@code candidate} character sequence.
   *
   * @param candidate  the candidate text that might contain a phone number
   * @param offset  the offset of {@code candidate} within {@link #text}
   * @return  the match found, null if none can be found
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.161 -0500", hash_original_method = "5043FAFCBC10DCDD5AF37AD628E27369", hash_generated_method = "758DD38C53E2DA0F40F876AA51633F80")
    
private PhoneNumberMatch extractMatch(CharSequence candidate, int offset) {
    // Skip a match that is more likely a publication page reference or a date.
    if (PUB_PAGES.matcher(candidate).find() || SLASH_SEPARATED_DATES.matcher(candidate).find()) {
      return null;
    }

    // Try to come up with a valid match given the entire candidate.
    String rawString = candidate.toString();
    PhoneNumberMatch match = parseAndVerify(rawString, offset);
    if (match != null) {
      return match;
    }

    // If that failed, try to find an "inner match" - there might be a phone number within this
    // candidate.
    return extractInnerMatch(rawString, offset);
  }

  /**
   * Attempts to extract a match from {@code candidate} if the whole candidate does not qualify as a
   * match.
   *
   * @param candidate  the candidate text that might contain a phone number
   * @param offset  the current offset of {@code candidate} within {@link #text}
   * @return  the match found, null if none can be found
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.165 -0500", hash_original_method = "45043172935915C3E3D944888FE8A1AA", hash_generated_method = "1592748F2767C48208EACB2EFF97A07A")
    
private PhoneNumberMatch extractInnerMatch(String candidate, int offset) {
    // Try removing either the first or last "group" in the number and see if this gives a result.
    // We consider white space to be a possible indication of the start or end of the phone number.
    Matcher groupMatcher = GROUP_SEPARATOR.matcher(candidate);

    if (groupMatcher.find()) {
      // Try the first group by itself.
      CharSequence firstGroupOnly = candidate.substring(0, groupMatcher.start());
      firstGroupOnly = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                           firstGroupOnly);
      PhoneNumberMatch match = parseAndVerify(firstGroupOnly.toString(), offset);
      if (match != null) {
        return match;
      }
      maxTries--;

      int withoutFirstGroupStart = groupMatcher.end();
      // Try the rest of the candidate without the first group.
      CharSequence withoutFirstGroup = candidate.substring(withoutFirstGroupStart);
      withoutFirstGroup = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                              withoutFirstGroup);
      match = parseAndVerify(withoutFirstGroup.toString(), offset + withoutFirstGroupStart);
      if (match != null) {
        return match;
      }
      maxTries--;

      if (maxTries > 0) {
        int lastGroupStart = withoutFirstGroupStart;
        while (groupMatcher.find()) {
          // Find the last group.
          lastGroupStart = groupMatcher.start();
        }
        CharSequence withoutLastGroup = candidate.substring(0, lastGroupStart);
        withoutLastGroup = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                               withoutLastGroup);
        if (withoutLastGroup.equals(firstGroupOnly)) {
          // If there are only two groups, then the group "without the last group" is the same as
          // the first group. In these cases, we don't want to re-check the number group, so we exit
          // already.
          return null;
        }
        match = parseAndVerify(withoutLastGroup.toString(), offset);
        if (match != null) {
          return match;
        }
        maxTries--;
      }
    }
    return null;
  }

  /**
   * Parses a phone number from the {@code candidate} using {@link PhoneNumberUtil#parse} and
   * verifies it matches the requested {@link #leniency}. If parsing and verification succeed, a
   * corresponding {@link PhoneNumberMatch} is returned, otherwise this method returns null.
   *
   * @param candidate  the candidate match
   * @param offset  the offset of {@code candidate} within {@link #text}
   * @return  the parsed and validated phone number match, or null
   */
  @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.167 -0500", hash_original_method = "0BFC8BA6757CC1FCC573CFBBF7AB3349", hash_generated_method = "D54292D6C692A99EFE0E67B181185304")
    
private PhoneNumberMatch parseAndVerify(String candidate, int offset) {
    try {
      // Check the candidate doesn't contain any formatting which would indicate that it really
      // isn't a phone number.
      if (!MATCHING_BRACKETS.matcher(candidate).matches()) {
        return null;
      }

      // If leniency is set to VALID or stricter, we also want to skip numbers that are surrounded
      // by Latin alphabetic characters, to skip cases like abc8005001234 or 8005001234def.
      if (leniency.compareTo(Leniency.VALID) >= 0) {
        // If the candidate is not at the start of the text, and does not start with phone-number
        // punctuation, check the previous character.
        if (offset > 0 && !LEAD_CLASS.matcher(candidate).lookingAt()) {
          char previousChar = text.charAt(offset - 1);
          // We return null if it is a latin letter or a currency symbol.
          if (isCurrencySymbol(previousChar) || isLatinLetter(previousChar)) {
            return null;
          }
        }
        int lastCharIndex = offset + candidate.length();
        if (lastCharIndex < text.length()) {
          char nextChar = text.charAt(lastCharIndex);
          if (isCurrencySymbol(nextChar) || isLatinLetter(nextChar)) {
            return null;
          }
        }
      }

      PhoneNumber number = phoneUtil.parse(candidate, preferredRegion);
      if (leniency.verify(number, candidate, phoneUtil)) {
        return new PhoneNumberMatch(offset, candidate, number);
      }
    } catch (NumberParseException e) {
      // ignore and continue
    }
    return null;
  }

  /**
   * Always throws {@link UnsupportedOperationException} as removal is not supported.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.169 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "5B2A4852FF2684177E07742561C615C2")
    
public void remove() {
    throw new UnsupportedOperationException();
  }
    static {
    String openingParens = "(\\[\uFF08\uFF3B";
    String closingParens = ")\\]\uFF09\uFF3D";
    String nonParens = "[^" + openingParens + closingParens + "]";
    String bracketPairLimit = limit(0, 3);
    MATCHING_BRACKETS = Pattern.compile(
        "(?:[" + openingParens + "])?" + "(?:" + nonParens + "+" + "[" + closingParens + "])?" +
        nonParens + "+" +
        "(?:[" + openingParens + "]" + nonParens + "+[" + closingParens + "])" + bracketPairLimit +
        nonParens + "*");
    String leadLimit = limit(0, 2);
    String punctuationLimit = limit(0, 4);
    int digitBlockLimit =
        PhoneNumberUtil.MAX_LENGTH_FOR_NSN + PhoneNumberUtil.MAX_LENGTH_COUNTRY_CODE;
    String blockLimit = limit(0, digitBlockLimit);
    String punctuation = "[" + PhoneNumberUtil.VALID_PUNCTUATION + "]" + punctuationLimit;
    String digitSequence = "\\p{Nd}" + limit(1, digitBlockLimit);
    String leadClassChars = openingParens + PhoneNumberUtil.PLUS_CHARS;
    String leadClass = "[" + leadClassChars + "]";
    LEAD_CLASS = Pattern.compile(leadClass);
    GROUP_SEPARATOR = Pattern.compile("\\p{Z}" + "[^" + leadClassChars  + "\\p{Nd}]*");
    PATTERN = Pattern.compile(
        "(?:" + leadClass + punctuation + ")" + leadLimit +
        digitSequence + "(?:" + punctuation + digitSequence + ")" + blockLimit +
        "(?:" + PhoneNumberUtil.EXTN_PATTERNS_FOR_MATCHING + ")?",
        PhoneNumberUtil.REGEX_FLAGS);
  }
    
}

