package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.LinkedHashSet;
import java.util.Locale;

public final class ICU {
    private static String[] isoLanguages;
    private static String[] isoCountries;
    private static Locale[] availableLocalesCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "509D5B8CE5FC83B9D0900D9B7C790D74", hash_generated_method = "EAFEA24166D1DA7CF30CA6C7C06E9594")
    public static String[] getISOLanguages() {
        if (isoLanguages == null) {
            isoLanguages = getISOLanguagesNative();
        }
        return isoLanguages.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "102D0A5E24B77353672A2269797A301F", hash_generated_method = "F95D1A8D23D779809A0DBD23FDC8C5AB")
    public static String[] getISOCountries() {
        if (isoCountries == null) {
            isoCountries = getISOCountriesNative();
        }
        return isoCountries.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "DE70B8E20357F852E9649E70ADFC5252", hash_generated_method = "46AE9928F813B032C2178490F24CE05C")
    public static Locale localeFromString(String localeName) {
        int first = localeName.indexOf('_');
        int second = localeName.indexOf('_', first + 1);
        if (first == -1) {
            return new Locale(localeName);
        } else if (second == -1) {
            return new Locale(localeName.substring(0, first), localeName.substring(first + 1));
        } else {
            return new Locale(localeName.substring(0, first), localeName.substring(first + 1, second), localeName.substring(second + 1));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "0E0B41818AADD5D0637B410FFCEEE676", hash_generated_method = "AFDC99343B0DF9997689AC49DCA37A2D")
    public static Locale[] localesFromStrings(String[] localeNames) {
        LinkedHashSet<Locale> set = new LinkedHashSet<Locale>();
        for (String localeName : localeNames) {
            set.add(localeFromString(localeName));
        }
        return set.toArray(new Locale[set.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "3E112AF6E3DC4400B71053E26A928383", hash_generated_method = "2C64BE7220AA82C338A4316786D0210C")
    public static Locale[] getAvailableLocales() {
        if (availableLocalesCache == null) {
            availableLocalesCache = localesFromStrings(getAvailableLocalesNative());
        }
        return availableLocalesCache.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "0D4772815B96EB61912A46B16324322E", hash_generated_method = "15FF48BD01D4DEC6C8B6C846BD5CB897")
    public static Locale[] getAvailableBreakIteratorLocales() {
        return localesFromStrings(getAvailableBreakIteratorLocalesNative());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "5B33E8B0148ADDA0B1D51C5A7E496DA3", hash_generated_method = "E686F8E017ABA50DC00D1E3AED40FA34")
    public static Locale[] getAvailableCalendarLocales() {
        return localesFromStrings(getAvailableCalendarLocalesNative());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "16185219CFF0D820CCDEF7A36FC48B97", hash_generated_method = "681FBAB148FA2C495153BE819C8B53AD")
    public static Locale[] getAvailableCollatorLocales() {
        return localesFromStrings(getAvailableCollatorLocalesNative());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "E8133574F6597D3A8E101FF9A92A188A", hash_generated_method = "964ABC80FB911A412EAAE953D22ABD63")
    public static Locale[] getAvailableDateFormatLocales() {
        return localesFromStrings(getAvailableDateFormatLocalesNative());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "25C74CA84C04BAF31250F68BC2561933", hash_generated_method = "B19CB5793364E74DFA727A53DEF88518")
    public static Locale[] getAvailableDateFormatSymbolsLocales() {
        return getAvailableDateFormatLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "A676D00EA76BF0759F92977081995763", hash_generated_method = "CDBE9D778C4C1E0968A7AEB34B4E05DB")
    public static Locale[] getAvailableDecimalFormatSymbolsLocales() {
        return getAvailableNumberFormatLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "D57B055A916F473879A092395335539A", hash_generated_method = "DE44D9439B498F693F2B2662EE45CD47")
    public static Locale[] getAvailableNumberFormatLocales() {
        return localesFromStrings(getAvailableNumberFormatLocalesNative());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "F48E6CE3D0613EC345B51AFCC3FE38EE", hash_generated_method = "46E6D00B76512D0F2796DCCAD07DDE15")
    public static String getIcuVersion() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "FF6A3CD49AF4AC3D3B77422F3B2473C0", hash_generated_method = "952D22DA96F9367E1084ED79A0070BC2")
    public static String getUnicodeVersion() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "AA30ED412C4ED5263D0F6B4AC5F79B1B", hash_generated_method = "C8C007453CCC314B64624109ABE1DCCF")
    public static String toLowerCase(String s, String localeName) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "C2FAAA2BE9C7CEC1B018EF251E70BDA6", hash_generated_method = "7C8B97640B2CDF395A403868AAB06B04")
    public static String toUpperCase(String s, String localeName) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "AD2C4153701B7197239624ADA1C08948", hash_generated_method = "D8A8ACA0A36FD5A20A92622C0F353DFD")
    private static String[] getAvailableBreakIteratorLocalesNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "035F49749DA4F1B5552ED910002D1CB6", hash_generated_method = "3E6846E187F60A2BD39E82A028743B8D")
    private static String[] getAvailableCalendarLocalesNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "E0D2E150BEC7AB539A04D91C5242D51F", hash_generated_method = "E4234947A2FCE286E504ABE9BEF24608")
    private static String[] getAvailableCollatorLocalesNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "D42D12EF77D64759A8A55D5D9067C78E", hash_generated_method = "401CB15D969F5A8527B20D37E7C22305")
    private static String[] getAvailableDateFormatLocalesNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "1A0F37C329C87669F404AF79ED45E090", hash_generated_method = "1AD7CAFF2A380B605459A710C5CC5305")
    private static String[] getAvailableLocalesNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "E401A90FF9AC4A40EA3E00F74C54582C", hash_generated_method = "145DC92358A22AC2DF1B28C408BA4A13")
    private static String[] getAvailableNumberFormatLocalesNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "43301BA7D29C1FAC94D99ACF38CE72D5", hash_generated_method = "FCB93DB848AC94BE5A59C2EB3D9348FC")
    public static String[] getAvailableCurrencyCodes() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "914DF80A920C3E1577EB290FD7AE037E", hash_generated_method = "CE1464AEF50B16B8EDAF84BD768B079A")
    public static String getCurrencyCode(String countryCode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "70976021BC9136BB262BCF1DC8BF9144", hash_generated_method = "309563C6C2203E5D880CB41060331317")
    public static String getCurrencyDisplayName(String locale, String currencyCode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "884740DD70B0BC7540F19936190A93EC", hash_generated_method = "DF25FCE94D2C15C9915C6C9790E6C4B6")
    public static int getCurrencyFractionDigits(String currencyCode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
        //DSFIXME:  CODE0009: Possible callback target function detected
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "8FB67204E077714406421F914623E4F0", hash_generated_method = "0D19D27D80F301E6A54E30913393839A")
    public static String getCurrencySymbol(String locale, String currencyCode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.603 -0400", hash_original_method = "2705995BB7E6A0F1781FA559E240BBC1", hash_generated_method = "E43B2427F39AB615A766731017232659")
    public static String getDisplayCountryNative(String countryCode, String locale) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "889A06A641064A730870ECCA5F642C94", hash_generated_method = "FA811339AE61D60289FAC98E68F4F1A5")
    public static String getDisplayLanguageNative(String languageCode, String locale) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "79B6247BB39E177347E505878F5CDF6F", hash_generated_method = "50B6491868A93A2ECF71DD260AE69668")
    public static String getDisplayVariantNative(String variantCode, String locale) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "67B809DB07B2A86265FC50ED09AB15AA", hash_generated_method = "8E0E4279277A3428D2E4BC797CB8E47E")
    public static String getISO3CountryNative(String locale) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "55937CF72C6FE6234900FF21074EDB12", hash_generated_method = "BF40342FA2209F09D10B55F6991A6CB3")
    public static String getISO3LanguageNative(String locale) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "67C81A06F8AAD0291D408185C0996024", hash_generated_method = "BB68BA6CFCDB14A516D7543BA2F27A74")
    public static String addLikelySubtags(String locale) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "C4D0AD5687C03555FFB79052FE63188C", hash_generated_method = "753AAB26491AE8FDB4D8F709E9A6A4D9")
    public static String getScript(String locale) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "10184C1D8142AE57730300197FF11A4F", hash_generated_method = "C7B784CA2C96D9A76C0C783F13C3994E")
    private static String[] getISOLanguagesNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "FD6C8FEA8D2C0F946003A7E1FB2169D1", hash_generated_method = "C14C7267FE9EDDB19B79BC1ED64AA1FF")
    private static String[] getISOCountriesNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.604 -0400", hash_original_method = "B64649F6488B8E0E2A76206A9FEC63E1", hash_generated_method = "4C83455FB6495E5CE63A41148249810A")
    static boolean initLocaleDataImpl(String locale, LocaleData result) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


