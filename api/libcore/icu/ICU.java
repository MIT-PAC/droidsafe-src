package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class ICU {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.567 -0400", hash_original_method = "41D0A20E3850008EA50DF809FC4EB919", hash_generated_method = "41D0A20E3850008EA50DF809FC4EB919")
    public ICU ()
    {
        //Synthesized constructor
    }


    public static String[] getISOLanguages() {
        if (isoLanguages == null) {
            isoLanguages = getISOLanguagesNative();
        }
        return isoLanguages.clone();
    }

    
    public static String[] getISOCountries() {
        if (isoCountries == null) {
            isoCountries = getISOCountriesNative();
        }
        return isoCountries.clone();
    }

    
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

    
    @DSModeled(DSC.SPEC)
    public static Locale[] localesFromStrings(String[] localeNames) {
        LinkedHashSet<Locale> set = new LinkedHashSet<Locale>();
        for (String localeName : localeNames) {
            set.add(localeFromString(localeName));
        }
        return set.toArray(new Locale[set.size()]);
    }

    
    public static Locale[] getAvailableLocales() {
        if (availableLocalesCache == null) {
            availableLocalesCache = localesFromStrings(getAvailableLocalesNative());
        }
        return availableLocalesCache.clone();
    }

    
    public static Locale[] getAvailableBreakIteratorLocales() {
        return localesFromStrings(getAvailableBreakIteratorLocalesNative());
    }

    
    public static Locale[] getAvailableCalendarLocales() {
        return localesFromStrings(getAvailableCalendarLocalesNative());
    }

    
    public static Locale[] getAvailableCollatorLocales() {
        return localesFromStrings(getAvailableCollatorLocalesNative());
    }

    
    public static Locale[] getAvailableDateFormatLocales() {
        return localesFromStrings(getAvailableDateFormatLocalesNative());
    }

    
    public static Locale[] getAvailableDateFormatSymbolsLocales() {
        return getAvailableDateFormatLocales();
    }

    
    public static Locale[] getAvailableDecimalFormatSymbolsLocales() {
        return getAvailableNumberFormatLocales();
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.573 -0400", hash_original_field = "88013DEF7F73488714320DFBA5CBDA04", hash_generated_field = "BE35828B892076AC7390E82ED7757E24")

    private static String[] isoLanguages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.573 -0400", hash_original_field = "5608ECD95723058790445D0401D02553", hash_generated_field = "DD8EDDECCA2B05E89485367EA0F1D58F")

    private static String[] isoCountries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.573 -0400", hash_original_field = "5FB2CB19CCC322B383B07F128D410B7F", hash_generated_field = "5054072110B01E76431E0948BDF07C94")

    private static Locale[] availableLocalesCache;
}

