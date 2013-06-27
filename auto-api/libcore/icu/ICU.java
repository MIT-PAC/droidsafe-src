package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class ICU {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.039 -0400", hash_original_method = "41D0A20E3850008EA50DF809FC4EB919", hash_generated_method = "41D0A20E3850008EA50DF809FC4EB919")
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

    
        public static String getIcuVersion() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getUnicodeVersion() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String toLowerCase(String s, String localeName) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String toUpperCase(String s, String localeName) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[] getAvailableBreakIteratorLocalesNative() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[] getAvailableCalendarLocalesNative() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[] getAvailableCollatorLocalesNative() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[] getAvailableDateFormatLocalesNative() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[] getAvailableLocalesNative() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[] getAvailableNumberFormatLocalesNative() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String[] getAvailableCurrencyCodes() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getCurrencyCode(String countryCode) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getCurrencyDisplayName(String locale, String currencyCode) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static int getCurrencyFractionDigits(String currencyCode) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static String getCurrencySymbol(String locale, String currencyCode) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getDisplayCountryNative(String countryCode, String locale) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getDisplayLanguageNative(String languageCode, String locale) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getDisplayVariantNative(String variantCode, String locale) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getISO3CountryNative(String locale) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getISO3LanguageNative(String locale) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String addLikelySubtags(String locale) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String getScript(String locale) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[] getISOLanguagesNative() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[] getISOCountriesNative() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static boolean initLocaleDataImpl(String locale, LocaleData result) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.084 -0400", hash_original_field = "88013DEF7F73488714320DFBA5CBDA04", hash_generated_field = "BE35828B892076AC7390E82ED7757E24")

    private static String[] isoLanguages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.084 -0400", hash_original_field = "5608ECD95723058790445D0401D02553", hash_generated_field = "DD8EDDECCA2B05E89485367EA0F1D58F")

    private static String[] isoCountries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.084 -0400", hash_original_field = "5FB2CB19CCC322B383B07F128D410B7F", hash_generated_field = "5054072110B01E76431E0948BDF07C94")

    private static Locale[] availableLocalesCache;
}

