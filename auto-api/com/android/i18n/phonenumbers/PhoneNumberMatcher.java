package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.i18n.phonenumbers.PhoneNumberUtil.Leniency;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.440 -0400", hash_original_field = "C778FABC1A5FC38BFB2983B44747E15A", hash_generated_field = "2E33D99F5B4A20B25B98A154596BE936")

    private PhoneNumberUtil phoneUtil;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.440 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "5FBEDC86BE77699C3F0DD393BD5C241B")

    private CharSequence text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.440 -0400", hash_original_field = "EFE6F8DFDD2D3B9FA45039EFE1DB04D5", hash_generated_field = "919257B95C0A2873677AF8F369A2FD23")

    private String preferredRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.440 -0400", hash_original_field = "F314A8846D8834145E57CA30D0A4D221", hash_generated_field = "1901EB03238813E3A90CAB00F8F24531")

    private Leniency leniency;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.440 -0400", hash_original_field = "28EA10ABCB0F4024E06EDA308866AFF1", hash_generated_field = "5BD507CEE6539816D66E14C52F3CEA0F")

    private long maxTries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.440 -0400", hash_original_field = "9F6A36C706759B1454C5A8AD55B2804D", hash_generated_field = "D868360155DE4E01C861A8C867061965")

    private State state = State.NOT_READY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.440 -0400", hash_original_field = "79FC9F825508163FEF8B1FAC1497582A", hash_generated_field = "CD2E461A3543C1B081C303C6BA322BB5")

    private PhoneNumberMatch lastMatch = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.440 -0400", hash_original_field = "A758B7341ECA03CD3A029BF7B37F751F", hash_generated_field = "73A01B8956D34AAB07FB4276843E3EFF")

    private int searchIndex = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.447 -0400", hash_original_method = "1C998965C70C11F4F601639EB7EFDC0A", hash_generated_method = "B14AF8DC2CAB911EEA01BEC8EB864A53")
      PhoneNumberMatcher(PhoneNumberUtil util, CharSequence text, String country, Leniency leniency,
      long maxTries) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
        private static String limit(int lower, int upper) {
        if ((lower < 0) || (upper <= 0) || (upper < lower)) {
      throw new IllegalArgumentException();
    }
        return "{" + lower + "," + upper + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.448 -0400", hash_original_method = "2A2342D3C783955CFC983767F5F149A5", hash_generated_method = "F3826F9693ABCD9E969C6F340D309CAD")
    public boolean hasNext() {
        {
            lastMatch = find(searchIndex);
            {
                state = State.DONE;
            } //End block
            {
                searchIndex = lastMatch.end();
                state = State.READY;
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124526749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124526749;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.449 -0400", hash_original_method = "41BA4BAFF42817F4E65D9346C9FF2DB0", hash_generated_method = "25725B13A9BE622A5B38397CFA969CCA")
    public PhoneNumberMatch next() {
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_577463742 = null; //Variable for return #1
        {
            boolean var2CC10AB3C52DD03176ADB3A939341751_160005929 = (!hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
        } //End collapsed parenthetic
        PhoneNumberMatch result;
        result = lastMatch;
        lastMatch = null;
        state = State.NOT_READY;
        varB4EAC82CA7396A68D541C85D26508E83_577463742 = result;
        varB4EAC82CA7396A68D541C85D26508E83_577463742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_577463742;
        // ---------- Original Method ----------
        //if (!hasNext()) {
      //throw new NoSuchElementException();
    //}
        //PhoneNumberMatch result = lastMatch;
        //lastMatch = null;
        //state = State.NOT_READY;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.450 -0400", hash_original_method = "100C9BD21D85AF1E644A5205A8C5603D", hash_generated_method = "6937128A0D9C25752534E9EC46756E4A")
    private PhoneNumberMatch find(int index) {
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_1349222010 = null; //Variable for return #1
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_1905726132 = null; //Variable for return #2
        Matcher matcher;
        matcher = PATTERN.matcher(text);
        {
            boolean var70A262963BB640CFFE62F1ED3403FFD9_177515622 = ((maxTries > 0) && matcher.find(index));
            {
                int start;
                start = matcher.start();
                CharSequence candidate;
                candidate = text.subSequence(start, matcher.end());
                candidate = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, candidate);
                PhoneNumberMatch match;
                match = extractMatch(candidate, start);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1349222010 = match;
                } //End block
                index = start + candidate.length();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1905726132 = null;
        addTaint(index);
        PhoneNumberMatch varA7E53CE21691AB073D9660D615818899_1165026905; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1165026905 = varB4EAC82CA7396A68D541C85D26508E83_1349222010;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1165026905 = varB4EAC82CA7396A68D541C85D26508E83_1905726132;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1165026905.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1165026905;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.479 -0400", hash_original_method = "5043FAFCBC10DCDD5AF37AD628E27369", hash_generated_method = "6C51CD25EDB25F60D3CFDED8C2EDEB41")
    private PhoneNumberMatch extractMatch(CharSequence candidate, int offset) {
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_1762168883 = null; //Variable for return #1
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_736129654 = null; //Variable for return #2
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_935054279 = null; //Variable for return #3
        {
            boolean var254AAF12E60F9404C12A967ECDA96096_1650919663 = (PUB_PAGES.matcher(candidate).find() || SLASH_SEPARATED_DATES.matcher(candidate).find());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1762168883 = null;
            } //End block
        } //End collapsed parenthetic
        String rawString;
        rawString = candidate.toString();
        PhoneNumberMatch match;
        match = parseAndVerify(rawString, offset);
        {
            varB4EAC82CA7396A68D541C85D26508E83_736129654 = match;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_935054279 = extractInnerMatch(rawString, offset);
        addTaint(candidate.getTaint());
        addTaint(offset);
        PhoneNumberMatch varA7E53CE21691AB073D9660D615818899_332906620; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_332906620 = varB4EAC82CA7396A68D541C85D26508E83_1762168883;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_332906620 = varB4EAC82CA7396A68D541C85D26508E83_736129654;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_332906620 = varB4EAC82CA7396A68D541C85D26508E83_935054279;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_332906620.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_332906620;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.484 -0400", hash_original_method = "45043172935915C3E3D944888FE8A1AA", hash_generated_method = "FFAAB3BF037659B7541868696E17150B")
    private PhoneNumberMatch extractInnerMatch(String candidate, int offset) {
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_488236248 = null; //Variable for return #1
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_1519269066 = null; //Variable for return #2
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_398821372 = null; //Variable for return #3
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_1397817858 = null; //Variable for return #4
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_155100992 = null; //Variable for return #5
        Matcher groupMatcher;
        groupMatcher = GROUP_SEPARATOR.matcher(candidate);
        {
            boolean varB62918D92E238C12370BCE9B0B6DF03A_869445346 = (groupMatcher.find());
            {
                CharSequence firstGroupOnly;
                firstGroupOnly = candidate.substring(0, groupMatcher.start());
                firstGroupOnly = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                           firstGroupOnly);
                PhoneNumberMatch match;
                match = parseAndVerify(firstGroupOnly.toString(), offset);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_488236248 = match;
                } //End block
                int withoutFirstGroupStart;
                withoutFirstGroupStart = groupMatcher.end();
                CharSequence withoutFirstGroup;
                withoutFirstGroup = candidate.substring(withoutFirstGroupStart);
                withoutFirstGroup = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                              withoutFirstGroup);
                match = parseAndVerify(withoutFirstGroup.toString(), offset + withoutFirstGroupStart);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1519269066 = match;
                } //End block
                {
                    int lastGroupStart;
                    lastGroupStart = withoutFirstGroupStart;
                    {
                        boolean var131C4FD6D86EBEB6B7FA68866238C151_449583189 = (groupMatcher.find());
                        {
                            lastGroupStart = groupMatcher.start();
                        } //End block
                    } //End collapsed parenthetic
                    CharSequence withoutLastGroup;
                    withoutLastGroup = candidate.substring(0, lastGroupStart);
                    withoutLastGroup = trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN,
                                               withoutLastGroup);
                    {
                        boolean varAA4AB35CFEAED1D5DDDC4E93328CC09D_1656496499 = (withoutLastGroup.equals(firstGroupOnly));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_398821372 = null;
                        } //End block
                    } //End collapsed parenthetic
                    match = parseAndVerify(withoutLastGroup.toString(), offset);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1397817858 = match;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_155100992 = null;
        addTaint(candidate.getTaint());
        addTaint(offset);
        PhoneNumberMatch varA7E53CE21691AB073D9660D615818899_160363120; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_160363120 = varB4EAC82CA7396A68D541C85D26508E83_488236248;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_160363120 = varB4EAC82CA7396A68D541C85D26508E83_1519269066;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_160363120 = varB4EAC82CA7396A68D541C85D26508E83_398821372;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_160363120 = varB4EAC82CA7396A68D541C85D26508E83_1397817858;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_160363120 = varB4EAC82CA7396A68D541C85D26508E83_155100992;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_160363120.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_160363120;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.492 -0400", hash_original_method = "0BFC8BA6757CC1FCC573CFBBF7AB3349", hash_generated_method = "CD0D5D7D7D742F79FA3DC351DC324D40")
    private PhoneNumberMatch parseAndVerify(String candidate, int offset) {
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_1607090555 = null; //Variable for return #1
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_1068660780 = null; //Variable for return #2
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_420954491 = null; //Variable for return #3
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_823217374 = null; //Variable for return #4
        PhoneNumberMatch varB4EAC82CA7396A68D541C85D26508E83_2028926652 = null; //Variable for return #5
        try 
        {
            {
                boolean var84D8F98B9DA881AB4189B8689DE1F0E6_44240159 = (!MATCHING_BRACKETS.matcher(candidate).matches());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1607090555 = null;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var841F11E867D027A78CD25880D79FAFC8_123462713 = (leniency.compareTo(Leniency.VALID) >= 0);
                {
                    {
                        boolean var23422A7C42C1B427640CED2DBF38E7DB_1405616394 = (offset > 0 && !LEAD_CLASS.matcher(candidate).lookingAt());
                        {
                            char previousChar;
                            previousChar = text.charAt(offset - 1);
                            {
                                boolean varA7C53DEEA814E4193F2F88C0A63B64DD_1322442973 = (isCurrencySymbol(previousChar) || isLatinLetter(previousChar));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1068660780 = null;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    int lastCharIndex;
                    lastCharIndex = offset + candidate.length();
                    {
                        boolean var4609CC18DA9CBC02D4E6C4621B6C3055_855807502 = (lastCharIndex < text.length());
                        {
                            char nextChar;
                            nextChar = text.charAt(lastCharIndex);
                            {
                                boolean var23132C4475BD3AF3D4CEF7040B49D136_267811150 = (isCurrencySymbol(nextChar) || isLatinLetter(nextChar));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_420954491 = null;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            PhoneNumber number;
            number = phoneUtil.parse(candidate, preferredRegion);
            {
                boolean varD0AB3CCA271D44E3FC0B90FD8DF0E28C_1420747696 = (leniency.verify(number, candidate, phoneUtil));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_823217374 = new PhoneNumberMatch(offset, candidate, number);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (NumberParseException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_2028926652 = null;
        addTaint(candidate.getTaint());
        addTaint(offset);
        PhoneNumberMatch varA7E53CE21691AB073D9660D615818899_211136160; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_211136160 = varB4EAC82CA7396A68D541C85D26508E83_1607090555;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_211136160 = varB4EAC82CA7396A68D541C85D26508E83_1068660780;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_211136160 = varB4EAC82CA7396A68D541C85D26508E83_420954491;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_211136160 = varB4EAC82CA7396A68D541C85D26508E83_823217374;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_211136160 = varB4EAC82CA7396A68D541C85D26508E83_2028926652;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_211136160.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_211136160;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.496 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
    public void remove() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    private enum State {
    NOT_READY, READY, DONE
  }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.497 -0400", hash_original_field = "04AB50CD8FFC1031A09AC85AA6C5F76A", hash_generated_field = "B67DB8AD534231B3DFBCDC8FADB87CD9")

    private static Pattern PATTERN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.497 -0400", hash_original_field = "6F18EB7998D9F329CF99C23BDBD27384", hash_generated_field = "21306B5BBC3CE347888A77AC450672F1")

    private static Pattern PUB_PAGES = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.497 -0400", hash_original_field = "1EE7ACB354316DCABA38EB9E7409261D", hash_generated_field = "21AF91BC6186D3A161DFD6ACCB0C3848")

    private static Pattern SLASH_SEPARATED_DATES = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.497 -0400", hash_original_field = "AEDD33FF1E1212064B71A25BB0BA490F", hash_generated_field = "0E3E98A4E9E55E5D5355E96742720F77")

    private static Pattern MATCHING_BRACKETS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.497 -0400", hash_original_field = "A9A2D43AF81AFB7530616D2656DF1087", hash_generated_field = "07B48D8DD762837F8558D15A298E7F7C")

    private static Pattern GROUP_SEPARATOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.497 -0400", hash_original_field = "0D3DC01484B6FE6CACF6229991DF96AE", hash_generated_field = "BFF4C6D5BA3233E2F2554B8CEE31C6BF")

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

