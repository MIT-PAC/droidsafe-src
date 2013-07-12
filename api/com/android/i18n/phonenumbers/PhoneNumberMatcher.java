package com.android.i18n.phonenumbers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.i18n.phonenumbers.PhoneNumberUtil.Leniency;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.524 -0400", hash_original_field = "C778FABC1A5FC38BFB2983B44747E15A", hash_generated_field = "2E33D99F5B4A20B25B98A154596BE936")

    private PhoneNumberUtil phoneUtil;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.524 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "5FBEDC86BE77699C3F0DD393BD5C241B")

    private CharSequence text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.524 -0400", hash_original_field = "EFE6F8DFDD2D3B9FA45039EFE1DB04D5", hash_generated_field = "919257B95C0A2873677AF8F369A2FD23")

    private String preferredRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.525 -0400", hash_original_field = "F314A8846D8834145E57CA30D0A4D221", hash_generated_field = "1901EB03238813E3A90CAB00F8F24531")

    private Leniency leniency;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.525 -0400", hash_original_field = "28EA10ABCB0F4024E06EDA308866AFF1", hash_generated_field = "5BD507CEE6539816D66E14C52F3CEA0F")

    private long maxTries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.525 -0400", hash_original_field = "9F6A36C706759B1454C5A8AD55B2804D", hash_generated_field = "D868360155DE4E01C861A8C867061965")

    private State state = State.NOT_READY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.525 -0400", hash_original_field = "79FC9F825508163FEF8B1FAC1497582A", hash_generated_field = "CD2E461A3543C1B081C303C6BA322BB5")

    private PhoneNumberMatch lastMatch = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.525 -0400", hash_original_field = "A758B7341ECA03CD3A029BF7B37F751F", hash_generated_field = "73A01B8956D34AAB07FB4276843E3EFF")

    private int searchIndex = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.526 -0400", hash_original_method = "1C998965C70C11F4F601639EB7EFDC0A", hash_generated_method = "7B54DDC196F757A01B37F36A3044086E")
      PhoneNumberMatcher(PhoneNumberUtil util, CharSequence text, String country, Leniency leniency,
      long maxTries) {
    if((util == null) || (leniency == null))        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_532627118 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_532627118.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_532627118;
        } 
    if(maxTries < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_397142679 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_397142679.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_397142679;
        } 
        this.phoneUtil = util;
        this.text = (text != null) ? text : "";
        this.preferredRegion = country;
        this.leniency = leniency;
        this.maxTries = maxTries;
        
        
      
    
        
      
    
        
        
        
        
        
    }

    
        private static String limit(int lower, int upper) {
        if ((lower < 0) || (upper <= 0) || (upper < lower)) {
      throw new IllegalArgumentException();
    }
        return "{" + lower + "," + upper + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.528 -0400", hash_original_method = "2A2342D3C783955CFC983767F5F149A5", hash_generated_method = "849E408A6444121BE7E679FABA446493")
    public boolean hasNext() {
    if(state == State.NOT_READY)        
        {
            lastMatch = find(searchIndex);
    if(lastMatch == null)            
            {
                state = State.DONE;
            } 
            else
            {
                searchIndex = lastMatch.end();
                state = State.READY;
            } 
        } 
        boolean var38881D6FDDCA3C1D66798834FF18C49F_619536668 = (state == State.READY);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736342247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736342247;
        
        
      
      
        
      
        
        
      
    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.528 -0400", hash_original_method = "41BA4BAFF42817F4E65D9346C9FF2DB0", hash_generated_method = "0F95CF64BA2587CB8675471E23EBED02")
    public PhoneNumberMatch next() {
    if(!hasNext())        
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1317598435 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1317598435.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1317598435;
        } 
        PhoneNumberMatch result = lastMatch;
        lastMatch = null;
        state = State.NOT_READY;
PhoneNumberMatch varDC838461EE2FA0CA4C9BBB70A15456B0_1144279987 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1144279987.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1144279987;
        
        
      
    
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.529 -0400", hash_original_method = "100C9BD21D85AF1E644A5205A8C5603D", hash_generated_method = "592EBC499C70C0F24995B025A0313C45")
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
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_109110983 =                 match;
                varED81284B0460DBAE2301CCD33AC92E85_109110983.addTaint(taint);
                return varED81284B0460DBAE2301CCD33AC92E85_109110983;
            } 
            index = start + candidate.length();
            maxTries--;
        } 
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_2056865701 =         null;
        var540C13E9E156B687226421B24F2DF178_2056865701.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2056865701;
        
        
        
      
      
      
      
      
        
      
      
      
    
        
    }

    
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

    
        private static boolean isCurrencySymbol(char character) {
        return Character.getType(character) == Character.CURRENCY_SYMBOL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.530 -0400", hash_original_method = "5043FAFCBC10DCDD5AF37AD628E27369", hash_generated_method = "BC95A5E7B67BBFB05EA8C0FE6FCCE7A2")
    private PhoneNumberMatch extractMatch(CharSequence candidate, int offset) {
        addTaint(offset);
        addTaint(candidate.getTaint());
    if(PUB_PAGES.matcher(candidate).find() || SLASH_SEPARATED_DATES.matcher(candidate).find())        
        {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_238998892 =             null;
            var540C13E9E156B687226421B24F2DF178_238998892.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_238998892;
        } 
        String rawString = candidate.toString();
        PhoneNumberMatch match = parseAndVerify(rawString, offset);
    if(match != null)        
        {
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_591899162 =             match;
            varED81284B0460DBAE2301CCD33AC92E85_591899162.addTaint(taint);
            return varED81284B0460DBAE2301CCD33AC92E85_591899162;
        } 
PhoneNumberMatch var0A837D42E9B84724F42B85C9D42F107F_1071894051 =         extractInnerMatch(rawString, offset);
        var0A837D42E9B84724F42B85C9D42F107F_1071894051.addTaint(taint);
        return var0A837D42E9B84724F42B85C9D42F107F_1071894051;
        
        
      
    
        
        
        
      
    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.532 -0400", hash_original_method = "45043172935915C3E3D944888FE8A1AA", hash_generated_method = "36432F944FCC8396D1AA074429B29D66")
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
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_1573045270 =                 match;
                varED81284B0460DBAE2301CCD33AC92E85_1573045270.addTaint(taint);
                return varED81284B0460DBAE2301CCD33AC92E85_1573045270;
            } 
            maxTries--;
            int withoutFirstGroupStart = groupMatcher.end();
            CharSequence withoutFirstGroup = candidate.substring(withoutFirstGroupStart);
            withoutFirstGroup = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                              withoutFirstGroup);
            match = parseAndVerify(withoutFirstGroup.toString(), offset + withoutFirstGroupStart);
    if(match != null)            
            {
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_413115021 =                 match;
                varED81284B0460DBAE2301CCD33AC92E85_413115021.addTaint(taint);
                return varED81284B0460DBAE2301CCD33AC92E85_413115021;
            } 
            maxTries--;
    if(maxTries > 0)            
            {
                int lastGroupStart = withoutFirstGroupStart;
                while
(groupMatcher.find())                
                {
                    lastGroupStart = groupMatcher.start();
                } 
                CharSequence withoutLastGroup = candidate.substring(0, lastGroupStart);
                withoutLastGroup = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                               withoutLastGroup);
    if(withoutLastGroup.equals(firstGroupOnly))                
                {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_1792397468 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1792397468.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1792397468;
                } 
                match = parseAndVerify(withoutLastGroup.toString(), offset);
    if(match != null)                
                {
PhoneNumberMatch varED81284B0460DBAE2301CCD33AC92E85_1297489192 =                     match;
                    varED81284B0460DBAE2301CCD33AC92E85_1297489192.addTaint(taint);
                    return varED81284B0460DBAE2301CCD33AC92E85_1297489192;
                } 
                maxTries--;
            } 
        } 
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_1036636710 =         null;
        var540C13E9E156B687226421B24F2DF178_1036636710.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1036636710;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.532 -0400", hash_original_method = "0BFC8BA6757CC1FCC573CFBBF7AB3349", hash_generated_method = "F6E98C4DCEFA9E3D4892E65C5497201C")
    private PhoneNumberMatch parseAndVerify(String candidate, int offset) {
        addTaint(offset);
        addTaint(candidate.getTaint());
        try 
        {
    if(!MATCHING_BRACKETS.matcher(candidate).matches())            
            {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_842961663 =                 null;
                var540C13E9E156B687226421B24F2DF178_842961663.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_842961663;
            } 
    if(leniency.compareTo(Leniency.VALID) >= 0)            
            {
    if(offset > 0 && !LEAD_CLASS.matcher(candidate).lookingAt())                
                {
                    char previousChar = text.charAt(offset - 1);
    if(isCurrencySymbol(previousChar) || isLatinLetter(previousChar))                    
                    {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_1507245678 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1507245678.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1507245678;
                    } 
                } 
                int lastCharIndex = offset + candidate.length();
    if(lastCharIndex < text.length())                
                {
                    char nextChar = text.charAt(lastCharIndex);
    if(isCurrencySymbol(nextChar) || isLatinLetter(nextChar))                    
                    {
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_400175726 =                         null;
                        var540C13E9E156B687226421B24F2DF178_400175726.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_400175726;
                    } 
                } 
            } 
            PhoneNumber number = phoneUtil.parse(candidate, preferredRegion);
    if(leniency.verify(number, candidate, phoneUtil))            
            {
PhoneNumberMatch varCED9B25A3AB1D8962524DF252B5BEC1B_489898508 =                 new PhoneNumberMatch(offset, candidate, number);
                varCED9B25A3AB1D8962524DF252B5BEC1B_489898508.addTaint(taint);
                return varCED9B25A3AB1D8962524DF252B5BEC1B_489898508;
            } 
        } 
        catch (NumberParseException e)
        {
        } 
PhoneNumberMatch var540C13E9E156B687226421B24F2DF178_1426072402 =         null;
        var540C13E9E156B687226421B24F2DF178_1426072402.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1426072402;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.533 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "44F5C0A069C778729D6BD123405A4A10")
    public void remove() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_633839006 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_633839006.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_633839006;
        
        
    }

    
    private enum State {
    NOT_READY, READY, DONE
  }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.533 -0400", hash_original_field = "04AB50CD8FFC1031A09AC85AA6C5F76A", hash_generated_field = "B67DB8AD534231B3DFBCDC8FADB87CD9")

    private static Pattern PATTERN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.533 -0400", hash_original_field = "6F18EB7998D9F329CF99C23BDBD27384", hash_generated_field = "AFDD5A0D3478F459E19A9B28F0825662")

    private static final Pattern PUB_PAGES = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.533 -0400", hash_original_field = "1EE7ACB354316DCABA38EB9E7409261D", hash_generated_field = "64624B78B0314B7CE8F5D8865FF30674")

    private static final Pattern SLASH_SEPARATED_DATES = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.533 -0400", hash_original_field = "AEDD33FF1E1212064B71A25BB0BA490F", hash_generated_field = "0E3E98A4E9E55E5D5355E96742720F77")

    private static Pattern MATCHING_BRACKETS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.533 -0400", hash_original_field = "A9A2D43AF81AFB7530616D2656DF1087", hash_generated_field = "07B48D8DD762837F8558D15A298E7F7C")

    private static Pattern GROUP_SEPARATOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.533 -0400", hash_original_field = "0D3DC01484B6FE6CACF6229991DF96AE", hash_generated_field = "BFF4C6D5BA3233E2F2554B8CEE31C6BF")

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

