package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public final class LocaleData {
    public Integer firstDayOfWeek;
    public Integer minimalDaysInFirstWeek;
    public String[] amPm;
    public String[] eras;
    public String[] longMonthNames;
    public String[] shortMonthNames;
    public String[] longStandAloneMonthNames;
    public String[] shortStandAloneMonthNames;
    public String[] longWeekdayNames;
    public String[] shortWeekdayNames;
    public String[] longStandAloneWeekdayNames;
    public String[] shortStandAloneWeekdayNames;
    public String fullTimeFormat;
    public String longTimeFormat;
    public String mediumTimeFormat;
    public String shortTimeFormat;
    public String fullDateFormat;
    public String longDateFormat;
    public String mediumDateFormat;
    public String shortDateFormat;
    public char zeroDigit;
    public char decimalSeparator;
    public char groupingSeparator;
    public char patternSeparator;
    public char percent;
    public char perMill;
    public char monetarySeparator;
    public char minusSign;
    public String exponentSeparator;
    public String infinity;
    public String NaN;
    public String currencySymbol;
    public String internationalCurrencySymbol;
    public String numberPattern;
    public String integerPattern;
    public String currencyPattern;
    public String percentPattern;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.260 -0400", hash_original_method = "CFFFBB83D5CAB96B8DF6F8A1F3FD834E", hash_generated_method = "D26C45D435D79556A74DEBD6612FAA64")
    @DSModeled(DSC.SAFE)
    private LocaleData() {
        // ---------- Original Method ----------
    }

    
        public static LocaleData get(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String localeName = locale.toString();
        synchronized (localeDataCache) {
            LocaleData localeData = localeDataCache.get(localeName);
            if (localeData != null) {
                return localeData;
            }
        }
        LocaleData newLocaleData = makeLocaleData(locale);
        synchronized (localeDataCache) {
            LocaleData localeData = localeDataCache.get(localeName);
            if (localeData != null) {
                return localeData;
            }
            localeDataCache.put(localeName, newLocaleData);
            return newLocaleData;
        }
    }

    
        private static LocaleData makeLocaleData(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        LocaleData result = new LocaleData();
        if (!variant.isEmpty()) {
            result.overrideWithDataFrom(get(new Locale(language, country, "")));
        } else if (!country.isEmpty()) {
            result.overrideWithDataFrom(get(new Locale(language, "", "")));
        } else if (!language.isEmpty()) {
            result.overrideWithDataFrom(get(Locale.ROOT));
        }
        result.overrideWithDataFrom(initLocaleData(locale));
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.268 -0400", hash_original_method = "784F7240396B6696F26C45143188C28A", hash_generated_method = "852641C4738999DC90E888C6D0374B8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varAB003F4600C0D451FDC042A2DE4DBE8B_594322733 = ("LocaleData[" +
                "firstDayOfWeek=" + firstDayOfWeek + "," +
                "minimalDaysInFirstWeek=" + minimalDaysInFirstWeek + "," +
                "amPm=" + Arrays.toString(amPm) + "," +
                "eras=" + Arrays.toString(eras) + "," +
                "longMonthNames=" + Arrays.toString(longMonthNames) + "," +
                "shortMonthNames=" + Arrays.toString(shortMonthNames) + "," +
                "longStandAloneMonthNames=" + Arrays.toString(longStandAloneMonthNames) + "," +
                "shortStandAloneMonthNames=" + Arrays.toString(shortStandAloneMonthNames) + "," +
                "longWeekdayNames=" + Arrays.toString(longWeekdayNames) + "," +
                "shortWeekdayNames=" + Arrays.toString(shortWeekdayNames) + "," +
                "longStandAloneWeekdayNames=" + Arrays.toString(longStandAloneWeekdayNames) + "," +
                "shortStandAloneWeekdayNames=" + Arrays.toString(shortStandAloneWeekdayNames) + "," +
                "fullTimeFormat=" + fullTimeFormat + "," +
                "longTimeFormat=" + longTimeFormat + "," +
                "mediumTimeFormat=" + mediumTimeFormat + "," +
                "shortTimeFormat=" + shortTimeFormat + "," +
                "fullDateFormat=" + fullDateFormat + "," +
                "longDateFormat=" + longDateFormat + "," +
                "mediumDateFormat=" + mediumDateFormat + "," +
                "shortDateFormat=" + shortDateFormat + "," +
                "zeroDigit=" + zeroDigit + "," +
                "decimalSeparator=" + decimalSeparator + "," +
                "groupingSeparator=" + groupingSeparator + "," +
                "patternSeparator=" + patternSeparator + "," +
                "percent=" + percent + "," +
                "perMill=" + perMill + "," +
                "monetarySeparator=" + monetarySeparator + "," +
                "minusSign=" + minusSign + "," +
                "exponentSeparator=" + exponentSeparator + "," +
                "infinity=" + infinity + "," +
                "NaN=" + NaN + "," +
                "currencySymbol=" + currencySymbol + "," +
                "internationalCurrencySymbol=" + internationalCurrencySymbol + "," +
                "numberPattern=" + numberPattern + "," +
                "integerPattern=" + integerPattern + "," +
                "currencyPattern=" + currencyPattern + "," +
                "percentPattern=" + percentPattern + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.269 -0400", hash_original_method = "97F8929D36249A9101B1710A2B088C68", hash_generated_method = "3FE8CEB241AEAEFBEAE24D3C77DD43FB")
    @DSModeled(DSC.SAFE)
    private void overrideWithDataFrom(LocaleData overrides) {
        dsTaint.addTaint(overrides.dsTaint);
        {
            firstDayOfWeek = overrides.firstDayOfWeek;
        } //End block
        {
            minimalDaysInFirstWeek = overrides.minimalDaysInFirstWeek;
        } //End block
        {
            amPm = overrides.amPm;
        } //End block
        {
            eras = overrides.eras;
        } //End block
        {
            longMonthNames = overrides.longMonthNames;
        } //End block
        {
            shortMonthNames = overrides.shortMonthNames;
        } //End block
        {
            longStandAloneMonthNames = overrides.longStandAloneMonthNames;
        } //End block
        {
            shortStandAloneMonthNames = overrides.shortStandAloneMonthNames;
        } //End block
        {
            longWeekdayNames = overrides.longWeekdayNames;
        } //End block
        {
            shortWeekdayNames = overrides.shortWeekdayNames;
        } //End block
        {
            longStandAloneWeekdayNames = overrides.longStandAloneWeekdayNames;
        } //End block
        {
            shortStandAloneWeekdayNames = overrides.shortStandAloneWeekdayNames;
        } //End block
        {
            fullTimeFormat = overrides.fullTimeFormat;
        } //End block
        {
            longTimeFormat = overrides.longTimeFormat;
        } //End block
        {
            mediumTimeFormat = overrides.mediumTimeFormat;
        } //End block
        {
            shortTimeFormat = overrides.shortTimeFormat;
        } //End block
        {
            fullDateFormat = overrides.fullDateFormat;
        } //End block
        {
            longDateFormat = overrides.longDateFormat;
        } //End block
        {
            mediumDateFormat = overrides.mediumDateFormat;
        } //End block
        {
            shortDateFormat = overrides.shortDateFormat;
        } //End block
        {
            zeroDigit = overrides.zeroDigit;
        } //End block
        {
            decimalSeparator = overrides.decimalSeparator;
        } //End block
        {
            groupingSeparator = overrides.groupingSeparator;
        } //End block
        {
            patternSeparator = overrides.patternSeparator;
        } //End block
        {
            percent = overrides.percent;
        } //End block
        {
            perMill = overrides.perMill;
        } //End block
        {
            monetarySeparator = overrides.monetarySeparator;
        } //End block
        {
            minusSign = overrides.minusSign;
        } //End block
        {
            exponentSeparator = overrides.exponentSeparator;
        } //End block
        {
            NaN = overrides.NaN;
        } //End block
        {
            infinity = overrides.infinity;
        } //End block
        {
            currencySymbol = overrides.currencySymbol;
        } //End block
        {
            internationalCurrencySymbol = overrides.internationalCurrencySymbol;
        } //End block
        {
            numberPattern = overrides.numberPattern;
        } //End block
        {
            integerPattern = overrides.integerPattern;
        } //End block
        {
            currencyPattern = overrides.currencyPattern;
        } //End block
        {
            percentPattern = overrides.percentPattern;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.269 -0400", hash_original_method = "348F1EE4DC68FC97E057A91A2366FE0E", hash_generated_method = "BDFC48BD9CDD8548B3C295AC04FA1416")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDateFormat(int style) {
        dsTaint.addTaint(style);
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //switch (style) {
        //case DateFormat.SHORT:
            //return shortDateFormat;
        //case DateFormat.MEDIUM:
            //return mediumDateFormat;
        //case DateFormat.LONG:
            //return longDateFormat;
        //case DateFormat.FULL:
            //return fullDateFormat;
        //}
        //throw new AssertionError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.269 -0400", hash_original_method = "381AB0475AE772D0631EAF7DD6B1FBEE", hash_generated_method = "7100D6890D7357F89C314568E58353EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTimeFormat(int style) {
        dsTaint.addTaint(style);
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //switch (style) {
        //case DateFormat.SHORT:
            //return shortTimeFormat;
        //case DateFormat.MEDIUM:
            //return mediumTimeFormat;
        //case DateFormat.LONG:
            //return longTimeFormat;
        //case DateFormat.FULL:
            //return fullTimeFormat;
        //}
        //throw new AssertionError();
    }

    
        private static LocaleData initLocaleData(Locale locale) {
        LocaleData localeData = new LocaleData();
        if (!ICU.initLocaleDataImpl(locale.toString(), localeData)) {
            throw new AssertionError("couldn't initialize LocaleData for locale " + locale);
        }
        if (localeData.fullTimeFormat != null) {
            localeData.fullTimeFormat = localeData.fullTimeFormat.replace('v', 'z');
        }
        if (localeData.numberPattern != null) {
            localeData.integerPattern = localeData.numberPattern.replaceAll("\\.[#,]*", "");
        }
        return localeData;
    }

    
    private static final HashMap<String, LocaleData> localeDataCache = new HashMap<String, LocaleData>();
    static {
        get(Locale.ROOT);
        get(Locale.US);
        get(Locale.getDefault());
    }
    
}

