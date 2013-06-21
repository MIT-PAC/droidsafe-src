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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.465 -0400", hash_original_method = "EE3697EE3763D0C54495C987AD1957C9", hash_generated_method = "EE3697EE3763D0C54495C987AD1957C9")
        public ICU ()
    {
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
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String getUnicodeVersion() {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String toLowerCase(String s, String localeName) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String toUpperCase(String s, String localeName) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static String[] getAvailableBreakIteratorLocalesNative() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        private static String[] getAvailableCalendarLocalesNative() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        private static String[] getAvailableCollatorLocalesNative() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        private static String[] getAvailableDateFormatLocalesNative() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        private static String[] getAvailableLocalesNative() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        private static String[] getAvailableNumberFormatLocalesNative() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        public static String[] getAvailableCurrencyCodes() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        public static String getCurrencyCode(String countryCode) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String getCurrencyDisplayName(String locale, String currencyCode) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static int getCurrencyFractionDigits(String currencyCode) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static String getCurrencySymbol(String locale, String currencyCode) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String getDisplayCountryNative(String countryCode, String locale) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String getDisplayLanguageNative(String languageCode, String locale) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String getDisplayVariantNative(String variantCode, String locale) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String getISO3CountryNative(String locale) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String getISO3LanguageNative(String locale) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String addLikelySubtags(String locale) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String getScript(String locale) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static String[] getISOLanguagesNative() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        private static String[] getISOCountriesNative() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        static boolean initLocaleDataImpl(String locale, LocaleData result) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    private static String[] isoLanguages;
    private static String[] isoCountries;
    private static Locale[] availableLocalesCache;
}

