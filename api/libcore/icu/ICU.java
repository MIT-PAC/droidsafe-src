package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.LinkedHashSet;
import java.util.Locale;





import droidsafe.helpers.DSUtils;

public final class ICU {

    /**
     * Returns an array of ISO language names (two-letter codes), fetched either
     * from ICU's database or from our memory cache.
     *
     * @return The array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.186 -0500", hash_original_method = "509D5B8CE5FC83B9D0900D9B7C790D74", hash_generated_method = "EAFEA24166D1DA7CF30CA6C7C06E9594")
    public static String[] getISOLanguages() {
        if (isoLanguages == null) {
            isoLanguages = getISOLanguagesNative();
        }
        return isoLanguages.clone();
    }

    /**
     * Returns an array of ISO country names (two-letter codes), fetched either
     * from ICU's database or from our memory cache.
     *
     * @return The array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.187 -0500", hash_original_method = "102D0A5E24B77353672A2269797A301F", hash_generated_method = "F95D1A8D23D779809A0DBD23FDC8C5AB")
    public static String[] getISOCountries() {
        if (isoCountries == null) {
            isoCountries = getISOCountriesNative();
        }
        return isoCountries.clone();
    }

    /**
     * Returns the appropriate {@code Locale} given a {@code String} of the form returned
     * by {@code toString}. This is very lenient, and doesn't care what's between the underscores:
     * this method can parse strings that {@code Locale.toString} won't produce.
     * Used to remove duplication.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.188 -0500", hash_original_method = "DE70B8E20357F852E9649E70ADFC5252", hash_generated_method = "2BB3062D52DE996C270CCF64E58CADD4")
    public static Locale localeFromString(String localeName) {
        int first = localeName.indexOf('_');
        int second = localeName.indexOf('_', first + 1);
        if (first == -1) {
            // Language only ("ja").
            return new Locale(localeName);
        } else if (second == -1) {
            // Language and country ("ja_JP").
            return new Locale(localeName.substring(0, first), localeName.substring(first + 1));
        } else {
            // Language and country and variant ("ja_JP_TRADITIONAL").
            return new Locale(localeName.substring(0, first), localeName.substring(first + 1, second), localeName.substring(second + 1));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.188 -0500", hash_original_method = "0E0B41818AADD5D0637B410FFCEEE676", hash_generated_method = "D870914E752414FF6513AE82DBB3284B")
    public static Locale[] localesFromStrings(String[] localeNames) {
        // We need to remove duplicates caused by the conversion of "he" to "iw", et cetera.
        // Java needs the obsolete code, ICU needs the modern code, but we let ICU know about
        // both so that we never need to convert back when talking to it.
        LinkedHashSet<Locale> set = new LinkedHashSet<Locale>();
        for (String localeName : localeNames) {
            set.add(localeFromString(localeName));
        }
        return set.toArray(new Locale[set.size()]);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.191 -0500", hash_original_method = "3E112AF6E3DC4400B71053E26A928383", hash_generated_method = "2C64BE7220AA82C338A4316786D0210C")
    public static Locale[] getAvailableLocales() {
        if (availableLocalesCache == null) {
            availableLocalesCache = localesFromStrings(getAvailableLocalesNative());
        }
        return availableLocalesCache.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.192 -0500", hash_original_method = "0D4772815B96EB61912A46B16324322E", hash_generated_method = "15FF48BD01D4DEC6C8B6C846BD5CB897")
    public static Locale[] getAvailableBreakIteratorLocales() {
        return localesFromStrings(getAvailableBreakIteratorLocalesNative());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.192 -0500", hash_original_method = "5B33E8B0148ADDA0B1D51C5A7E496DA3", hash_generated_method = "E686F8E017ABA50DC00D1E3AED40FA34")
    public static Locale[] getAvailableCalendarLocales() {
        return localesFromStrings(getAvailableCalendarLocalesNative());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.193 -0500", hash_original_method = "16185219CFF0D820CCDEF7A36FC48B97", hash_generated_method = "681FBAB148FA2C495153BE819C8B53AD")
    public static Locale[] getAvailableCollatorLocales() {
        return localesFromStrings(getAvailableCollatorLocalesNative());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.194 -0500", hash_original_method = "E8133574F6597D3A8E101FF9A92A188A", hash_generated_method = "964ABC80FB911A412EAAE953D22ABD63")
    public static Locale[] getAvailableDateFormatLocales() {
        return localesFromStrings(getAvailableDateFormatLocalesNative());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.195 -0500", hash_original_method = "25C74CA84C04BAF31250F68BC2561933", hash_generated_method = "B19CB5793364E74DFA727A53DEF88518")
    public static Locale[] getAvailableDateFormatSymbolsLocales() {
        return getAvailableDateFormatLocales();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.196 -0500", hash_original_method = "A676D00EA76BF0759F92977081995763", hash_generated_method = "CDBE9D778C4C1E0968A7AEB34B4E05DB")
    public static Locale[] getAvailableDecimalFormatSymbolsLocales() {
        return getAvailableNumberFormatLocales();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.196 -0500", hash_original_method = "D57B055A916F473879A092395335539A", hash_generated_method = "DE44D9439B498F693F2B2662EE45CD47")
    public static Locale[] getAvailableNumberFormatLocales() {
        return localesFromStrings(getAvailableNumberFormatLocalesNative());
    }

    
    @DSModeled(DSC.SAFE)
    public static String getIcuVersion() {
    	return new String();
    }

    
    @DSModeled(DSC.SAFE)
    public static String getUnicodeVersion() {
    	return new String();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toLowerCase(String s, String localeName) {
    	String ret = new String(s);
    	ret.addTaint(localeName.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String toUpperCase(String s, String localeName) {
    	String ret = new String(s);
    	ret.addTaint(localeName.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] getAvailableBreakIteratorLocalesNative() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] getAvailableCalendarLocalesNative() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] getAvailableCollatorLocalesNative() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] getAvailableDateFormatLocalesNative() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] getAvailableLocalesNative() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] getAvailableNumberFormatLocalesNative() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] getAvailableCurrencyCodes() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getCurrencyCode(String countryCode) {
    	String ret = new String();
    	ret.addTaint(countryCode.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getCurrencyDisplayName(String locale, String currencyCode) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	ret.addTaint(currencyCode.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getCurrencyFractionDigits(String currencyCode) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785716854 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785716854;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getCurrencySymbol(String locale, String currencyCode) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	ret.addTaint(currencyCode.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getDisplayCountryNative(String countryCode, String locale) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	ret.addTaint(countryCode.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getDisplayLanguageNative(String languageCode, String locale) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	ret.addTaint(languageCode.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getDisplayVariantNative(String variantCode, String locale) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	ret.addTaint(variantCode.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getISO3CountryNative(String locale) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getISO3LanguageNative(String locale) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String addLikelySubtags(String locale) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getScript(String locale) {
    	String ret = new String();
    	ret.addTaint(locale.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] getISOLanguagesNative() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] getISOCountriesNative() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    static boolean initLocaleDataImpl(String locale, LocaleData result) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1011393629 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1011393629;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.184 -0500", hash_original_field = "90AA6CFBDEE696F6EF43191174536FDC", hash_generated_field = "BE35828B892076AC7390E82ED7757E24")

    private static String[] isoLanguages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.185 -0500", hash_original_field = "3C7A51A882CA618112F9CF452425EF9D", hash_generated_field = "DD8EDDECCA2B05E89485367EA0F1D58F")

    private static String[] isoCountries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.190 -0500", hash_original_field = "3BE82B955F6797ED2E573E3423ACAACE", hash_generated_field = "5054072110B01E76431E0948BDF07C94")


    private static Locale[] availableLocalesCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.567 -0400", hash_original_method = "41D0A20E3850008EA50DF809FC4EB919", hash_generated_method = "41D0A20E3850008EA50DF809FC4EB919")
    public ICU ()
    {
        //Synthesized constructor
    }
}

