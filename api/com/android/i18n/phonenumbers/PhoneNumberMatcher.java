package com.android.i18n.phonenumbers;

// Droidsafe Imports
import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.i18n.phonenumbers.PhoneNumberUtil.Leniency;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;

import droidsafe.annotations.*;

final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.701 -0400", hash_original_field = "C778FABC1A5FC38BFB2983B44747E15A", hash_generated_field = "2E33D99F5B4A20B25B98A154596BE936")

    private PhoneNumberUtil phoneUtil;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.701 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "5FBEDC86BE77699C3F0DD393BD5C241B")

    private CharSequence text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.701 -0400", hash_original_field = "EFE6F8DFDD2D3B9FA45039EFE1DB04D5", hash_generated_field = "919257B95C0A2873677AF8F369A2FD23")

    private String preferredRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.701 -0400", hash_original_field = "F314A8846D8834145E57CA30D0A4D221", hash_generated_field = "1901EB03238813E3A90CAB00F8F24531")

    private Leniency leniency;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.701 -0400", hash_original_field = "28EA10ABCB0F4024E06EDA308866AFF1", hash_generated_field = "5BD507CEE6539816D66E14C52F3CEA0F")

    private long maxTries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.701 -0400", hash_original_field = "9F6A36C706759B1454C5A8AD55B2804D", hash_generated_field = "D868360155DE4E01C861A8C867061965")

    private State state = State.NOT_READY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.701 -0400", hash_original_field = "79FC9F825508163FEF8B1FAC1497582A", hash_generated_field = "CD2E461A3543C1B081C303C6BA322BB5")

    private PhoneNumberMatch lastMatch = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.701 -0400", hash_original_field = "A758B7341ECA03CD3A029BF7B37F751F", hash_generated_field = "73A01B8956D34AAB07FB4276843E3EFF")

    private int searchIndex = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.703 -0400", hash_original_method = "1C998965C70C11F4F601639EB7EFDC0A", hash_generated_method = "EBE4856C151778B0A1399EF9B1F1CAB6")
      PhoneNumberMatcher(PhoneNumberUtil util, CharSequence text, String country, Leniency leniency,
      long maxTries) {
        if((util == null) || (leniency == null))        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1638246438 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1638246438.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1638246438;
        } //End block
        if(maxTries < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1991008594 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1991008594.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1991008594;
        } //End block
        this.phoneUtil = util;
        this.text = (text != null) ? text : "";
        this.preferredRegion = country;
        this.leniency = leniency;
        this.maxTries = maxTries;
        // ---------- Original Method ----------
        //if ((util == null) || (leniency == null)) {
      //throw new NullPointerException();
    //}
        //if (maxTries < 0) {
      //throw new IllegalArgumentException();
    //}
        //this.phoneUtil = util;
        //this.text = (text != null) ? text : "";
        //this.preferredRegion = country;
        //this.leniency = leniency;
        //this.maxTries = maxTries;
    }

    
    @DSModeled(DSC.BAN)
    private static String limit(int lower, int upper) {
        if ((lower < 0) || (upper <= 0) || (upper < lower)) {
      throw new IllegalArgumentException();
    }
        return "{" + lower + "," + upper + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.704 -0400", hash_original_method = "2A2342D3C783955CFC983767F5F149A5", hash_generated_method = "F3DB61B138B521414BBA507719E01DDF")
    public boolean hasNext() {
        if(state == State.NOT_READY)        
        {
            lastMatch = find(searchIndex);
            if(lastMatch == null)            
            {
                state = State.DONE;
            } //End block
            else
            {
                searchIndex = lastMatch.end();
                state = State.READY;
            } //End block
        } //End block
        boolean var38881D6FDDCA3C1D66798834FF18C49F_44150349 = (state == State.READY);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377103308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377103308;
        // ---------- Original Method ----------
        //if (state == State.NOT_READY) {
      //lastMatch = find(searchIndex);
      //if (lastMatch == null) {
        //state = State.DONE;
      //} else {
        //searchIndex = lastMatch.end();
        //state = State.READY;
      //}
    //}
        //return state == State.READY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.705 -0400", hash_original_method = "41BA4BAFF42817F4E65D9346C9FF2DB0", hash_generated_method = "C04DC874A3832E6EB289A5AA806DF56A")
    public PhoneNumberMatch next() {
        if(!hasNext())        
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1326930629 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1326930629.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1326930629;
        } //End block
        PhoneNumberMatch result = lastMatch;
        lastMatch = null;
        state = State.NOT_READY;
PhoneNumberMatch varDC838461EE2FA0CA4C9BBB70A15456B0_855783461 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_855783461.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_855783461;
        // ---------- Original Method ----------
        //if (!hasNext()) {
      //throw new NoSuchElementException();
    //}
        //PhoneNumberMatch result = lastMatch;
        //lastMatch = null;
        //state = State.NOT_READY;
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.706 -0400", hash_original_method = "100C9BD21D85AF1E644A5205A8C5603D", hash_generated_method = "D7515F330BC289E0F03459B12AC14EFF")
    private PhoneNumberMatch find(int index) {
        addTaint(index);
        Matcher matcher = PATTERN.matcher(text);
        while
((maxTries > 0) && matcher.find(index))        
        {
            int start = matcher.start();
            CharSequence candidate = text.subSequence(start, matcher.end());
            candidate = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, candidate);
            PhoneNumberMatch match = extractMatch(candidate, start);
            if(match != null)            
            {
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_1459666368 =                 match;
                varED81284B0460DBAE2301CCD33AC92E85_1459666368.addTaint(taint);
                return varED81284B0460DBAE2301CCD33AC92E85_1459666368;
            } //End block
            index = start + candidate.length();
            maxTries--;
        } //End block
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_164927099 =         null;
        var540C13E9E156B687226421B24F2DF178_164927099.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_164927099;
        // ---------- Original Method ----------
        //Matcher matcher = PATTERN.matcher(text);
        //while ((maxTries > 0) && matcher.find(index)) {
      //int start = matcher.start();
      //CharSequence candidate = text.subSequence(start, matcher.end());
      //candidate = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, candidate);
      //PhoneNumberMatch match = extractMatch(candidate, start);
      //if (match != null) {
        //return match;
      //}
      //index = start + candidate.length();
      //maxTries--;
    //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    private static CharSequence trimAfterFirstMatch(Pattern pattern, CharSequence candidate) {
        Matcher trailingCharsMatcher = pattern.matcher(candidate);
        if (trailingCharsMatcher.find()) {
      candidate = candidate.subSequence(0, trailingCharsMatcher.start());
    }
        return candidate;
    }

    
    static boolean isLatinLetter(char letter) {
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

    
    @DSModeled(DSC.BAN)
    private static boolean isCurrencySymbol(char character) {
        return Character.getType(character) == Character.CURRENCY_SYMBOL;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.707 -0400", hash_original_method = "5043FAFCBC10DCDD5AF37AD628E27369", hash_generated_method = "3B1B5A3DDE0A9C237F7B8BD867CDCE47")
    private PhoneNumberMatch extractMatch(CharSequence candidate, int offset) {
        addTaint(offset);
        addTaint(candidate.getTaint());
        if(PUB_PAGES.matcher(candidate).find() || SLASH_SEPARATED_DATES.matcher(candidate).find())        
        {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_110073298 =             null;
            var540C13E9E156B687226421B24F2DF178_110073298.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_110073298;
        } //End block
        String rawString = candidate.toString();
        PhoneNumberMatch match = parseAndVerify(rawString, offset);
        if(match != null)        
        {
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_31851240 =             match;
            varED81284B0460DBAE2301CCD33AC92E85_31851240.addTaint(taint);
            return varED81284B0460DBAE2301CCD33AC92E85_31851240;
        } //End block
PhoneNumberMatch var0A837D42E9B84724F42B85C9D42F107F_2037011663 =         extractInnerMatch(rawString, offset);
        var0A837D42E9B84724F42B85C9D42F107F_2037011663.addTaint(taint);
        return var0A837D42E9B84724F42B85C9D42F107F_2037011663;
        // ---------- Original Method ----------
        //if (PUB_PAGES.matcher(candidate).find() || SLASH_SEPARATED_DATES.matcher(candidate).find()) {
      //return null;
    //}
        //String rawString = candidate.toString();
        //PhoneNumberMatch match = parseAndVerify(rawString, offset);
        //if (match != null) {
      //return match;
    //}
        //return extractInnerMatch(rawString, offset);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.709 -0400", hash_original_method = "45043172935915C3E3D944888FE8A1AA", hash_generated_method = "6E0E022887421172DE60E5E05CF40988")
    private PhoneNumberMatch extractInnerMatch(String candidate, int offset) {
        addTaint(offset);
        addTaint(candidate.getTaint());
        Matcher groupMatcher = GROUP_SEPARATOR.matcher(candidate);
        if(groupMatcher.find())        
        {
            CharSequence firstGroupOnly = candidate.substring(0, groupMatcher.start());
            firstGroupOnly = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                           firstGroupOnly);
            PhoneNumberMatch match = parseAndVerify(firstGroupOnly.toString(), offset);
            if(match != null)            
            {
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_115456497 =                 match;
                varED81284B0460DBAE2301CCD33AC92E85_115456497.addTaint(taint);
                return varED81284B0460DBAE2301CCD33AC92E85_115456497;
            } //End block
            maxTries--;
            int withoutFirstGroupStart = groupMatcher.end();
            CharSequence withoutFirstGroup = candidate.substring(withoutFirstGroupStart);
            withoutFirstGroup = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                              withoutFirstGroup);
            match = parseAndVerify(withoutFirstGroup.toString(), offset + withoutFirstGroupStart);
            if(match != null)            
            {
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_723357187 =                 match;
                varED81284B0460DBAE2301CCD33AC92E85_723357187.addTaint(taint);
                return varED81284B0460DBAE2301CCD33AC92E85_723357187;
            } //End block
            maxTries--;
            if(maxTries > 0)            
            {
                int lastGroupStart = withoutFirstGroupStart;
                while
(groupMatcher.find())                
                {
                    lastGroupStart = groupMatcher.start();
                } //End block
                CharSequence withoutLastGroup = candidate.substring(0, lastGroupStart);
                withoutLastGroup = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                               withoutLastGroup);
                if(withoutLastGroup.equals(firstGroupOnly))                
                {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_108514687 =                     null;
                    var540C13E9E156B687226421B24F2DF178_108514687.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_108514687;
                } //End block
                match = parseAndVerify(withoutLastGroup.toString(), offset);
                if(match != null)                
                {
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_1311529820 =                     match;
                    varED81284B0460DBAE2301CCD33AC92E85_1311529820.addTaint(taint);
                    return varED81284B0460DBAE2301CCD33AC92E85_1311529820;
                } //End block
                maxTries--;
            } //End block
        } //End block
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_1335905192 =         null;
        var540C13E9E156B687226421B24F2DF178_1335905192.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1335905192;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.709 -0400", hash_original_method = "0BFC8BA6757CC1FCC573CFBBF7AB3349", hash_generated_method = "C77036E3359E826742E5881A5795C015")
    private PhoneNumberMatch parseAndVerify(String candidate, int offset) {
        addTaint(offset);
        addTaint(candidate.getTaint());
        try 
        {
            if(!MATCHING_BRACKETS.matcher(candidate).matches())            
            {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_635447837 =                 null;
                var540C13E9E156B687226421B24F2DF178_635447837.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_635447837;
            } //End block
            if(leniency.compareTo(Leniency.VALID) >= 0)            
            {
                if(offset > 0 && !LEAD_CLASS.matcher(candidate).lookingAt())                
                {
                    char previousChar = text.charAt(offset - 1);
                    if(isCurrencySymbol(previousChar) || isLatinLetter(previousChar))                    
                    {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_124876457 =                         null;
                        var540C13E9E156B687226421B24F2DF178_124876457.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_124876457;
                    } //End block
                } //End block
                int lastCharIndex = offset + candidate.length();
                if(lastCharIndex < text.length())                
                {
                    char nextChar = text.charAt(lastCharIndex);
                    if(isCurrencySymbol(nextChar) || isLatinLetter(nextChar))                    
                    {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_65447908 =                         null;
                        var540C13E9E156B687226421B24F2DF178_65447908.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_65447908;
                    } //End block
                } //End block
            } //End block
            PhoneNumber number = phoneUtil.parse(candidate, preferredRegion);
            if(leniency.verify(number, candidate, phoneUtil))            
            {
PhoneNumberMatch varCED9B25A3AB1D8962524DF252B5BEC1B_190963566 =                 new PhoneNumberMatch(offset, candidate, number);
                varCED9B25A3AB1D8962524DF252B5BEC1B_190963566.addTaint(taint);
                return varCED9B25A3AB1D8962524DF252B5BEC1B_190963566;
            } //End block
        } //End block
        catch (NumberParseException e)
        {
        } //End block
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_262661934 =         null;
        var540C13E9E156B687226421B24F2DF178_262661934.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_262661934;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.710 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "EF5394225C932C10E6494AD27CF9B24A")
    public void remove() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1052370502 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1052370502.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1052370502;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    private enum State {
    NOT_READY, READY, DONE
  }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.710 -0400", hash_original_field = "04AB50CD8FFC1031A09AC85AA6C5F76A", hash_generated_field = "B67DB8AD534231B3DFBCDC8FADB87CD9")

    private static Pattern PATTERN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.710 -0400", hash_original_field = "6F18EB7998D9F329CF99C23BDBD27384", hash_generated_field = "AFDD5A0D3478F459E19A9B28F0825662")

    private static final Pattern PUB_PAGES = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.710 -0400", hash_original_field = "1EE7ACB354316DCABA38EB9E7409261D", hash_generated_field = "64624B78B0314B7CE8F5D8865FF30674")

    private static final Pattern SLASH_SEPARATED_DATES = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.710 -0400", hash_original_field = "AEDD33FF1E1212064B71A25BB0BA490F", hash_generated_field = "0E3E98A4E9E55E5D5355E96742720F77")

    private static Pattern MATCHING_BRACKETS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.710 -0400", hash_original_field = "A9A2D43AF81AFB7530616D2656DF1087", hash_generated_field = "07B48D8DD762837F8558D15A298E7F7C")

    private static Pattern GROUP_SEPARATOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.710 -0400", hash_original_field = "0D3DC01484B6FE6CACF6229991DF96AE", hash_generated_field = "BFF4C6D5BA3233E2F2554B8CEE31C6BF")

    private static Pattern LEAD_CLASS;
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

