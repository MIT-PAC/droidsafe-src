package libcore.icu;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;






public final class LocaleData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.922 -0400", hash_original_field = "3CD3E760E15423653736E26E4D21E54A", hash_generated_field = "8A13F0EA9FFA1E934CE8561DD3C5989E")

    public Integer firstDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.922 -0400", hash_original_field = "84FAA04375A171B334639F6BBA18E901", hash_generated_field = "03D4DF0C331BF703C630DB3CF80ED225")

    public Integer minimalDaysInFirstWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.922 -0400", hash_original_field = "E666AAA958212AEBD6993F91D63AE6E2", hash_generated_field = "213FC9B381F9FD6CC3287737355F39E7")

    public String[] amPm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.922 -0400", hash_original_field = "D026F0E07E8726FB52E3CC3E3D0D1375", hash_generated_field = "0C7432EFCA179700DEFB07441E17C241")

    public String[] eras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "FC16B67DBF06565ECCCA335FC46E56CE", hash_generated_field = "4185736CD0C48B464D4536B3488BB3C2")

    public String[] longMonthNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "27616FDC52D6DA6F1FB1AED8CC1734C6", hash_generated_field = "C9B0BE34CCC3507AA77C40623159A080")

    public String[] shortMonthNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "7AE383119F441230C222EC935D537CCB", hash_generated_field = "34E5539EC5A76BE352031DB9A3085C41")

    public String[] longStandAloneMonthNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "1537BE4D5B205756DF0F6CED781FF6BF", hash_generated_field = "5C5A6411256AB4A1E90F1F6C871AC8FC")

    public String[] shortStandAloneMonthNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "E347DB26B8D1BAA887A00B54304AB2EF", hash_generated_field = "C3AE2E018004F552B964BCCAFD874935")

    public String[] longWeekdayNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "F3BEE510D504CD7B3274F37FCE475596", hash_generated_field = "F94D89296B2F63E5B79A74F258E30993")

    public String[] shortWeekdayNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "78A7FA0DCAD6C5ECAAF6E3365B2D38DF", hash_generated_field = "1D47E5E3C2881492F63ED7CCFBCD5E22")

    public String[] longStandAloneWeekdayNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "52F7F90AAA18A56EF574BA794E135D84", hash_generated_field = "07175FBDE37014F8440D3E7AE21FA651")

    public String[] shortStandAloneWeekdayNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "B6533A30C4AD7DB6814C52E7DD7F70A8", hash_generated_field = "1E68C4F12D0CF34DDE7994AB138806E1")

    public String fullTimeFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "16E0537F1F9C7C279FE0EA3B758E156E", hash_generated_field = "78D3925C0C39754AEC93A487210285B8")

    public String longTimeFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "9D78790C120717A411235D02333B73BB", hash_generated_field = "F2E510CEAA1E15F91C2011ED4F242732")

    public String mediumTimeFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "7AAF48FABBA82698CD76002CAC617B39", hash_generated_field = "ACB523060E571DEA6B84F3C7BA1E8675")

    public String shortTimeFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "A889479F3C14428E2E5E57A1144691F3", hash_generated_field = "4D53B22725CC478319F8EB2DB917D8D8")

    public String fullDateFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "4FB2E138EFFBA0C3EABD787845D24451", hash_generated_field = "C5A04CB5D384F7C0638BF2C80E7F94E7")

    public String longDateFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "137385F80AB843E33BCBA013057F6ADC", hash_generated_field = "854F946C7A5E5E8189651579B59F06BD")

    public String mediumDateFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "6E40622A5C660D8DA9AD4B6EA9FD25A6", hash_generated_field = "D99113CA10FA94AF2FCE804652348B56")

    public String shortDateFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "8AD80D213027B16530912C1C1C7453EF", hash_generated_field = "4888B60DABE88AB42231B4ADC4A02CA0")

    public char zeroDigit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "48A6CA504F67CF2BD9895069CD4472FA", hash_generated_field = "35DDBB85537BF0F9807E26101DBEA26E")

    public char decimalSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.923 -0400", hash_original_field = "3A708173CA04CA37E5B22F97B4BC43CF", hash_generated_field = "9B69BAC717BFFD8B7436EE206FD9A125")

    public char groupingSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "CD221E3F127BA556BCF5DA2798A424B3", hash_generated_field = "4DFD5CCD9A735920501A4CD74952610F")

    public char patternSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "354F047BA64552895B016BBDD60AB174", hash_generated_field = "0EF4D992455EAB6F4D76C77D9E176A8A")

    public char percent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "D6C9C9F61F0116B9930F4EDD0F9D8227", hash_generated_field = "B91658C178B36F90659298B733B0697C")

    public char perMill;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "368D90094DFA80CD83BD48905254BFA2", hash_generated_field = "4E2FAA088364B280E497C1EB718A4292")

    public char monetarySeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "094850D5B1A3856672905D85A426AC77", hash_generated_field = "F2C15C2423BCA068978BE230503ED8C9")

    public char minusSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "95B0BA924E85C891BF81984E42E23DBB", hash_generated_field = "1C4D7AC3B4908F09C2F992F288F21FD0")

    public String exponentSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "52788164AF36FD8480328F81CA27D813")

    public String infinity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "7ECFB3BF076A6A9635F975FE96AC97FD", hash_generated_field = "1ACE7DA05AF67826290EE2F37998213B")

    public String NaN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "C5613A5A91579972FBAE451ACABEB080", hash_generated_field = "3A1AA78D098C0361A3F77A45D4D29064")

    public String currencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "EFD4066FEBBDFA7754722F52490DC0B3", hash_generated_field = "33E347BE6A63944341A881F74532F9D0")

    public String internationalCurrencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "3C9CDDF5DF1FA448EC5A43DED28F472E", hash_generated_field = "D8B3481EB6C0D581859B565C481F869F")

    public String numberPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "9CDA6BC30F326DAFADEBE8DC4BA899F6", hash_generated_field = "DA8D3E0E29515F1E2517989802DC8F5B")

    public String integerPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "8360247515A05D871CC7311AE419A8B0", hash_generated_field = "66F5A7220B0DE657C90A1C9851B9E9E4")

    public String currencyPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.924 -0400", hash_original_field = "8D10826B8C66A4F18961712C404F4F75", hash_generated_field = "C4072630D2D98FE2320BACD3DD2692A3")

    public String percentPattern;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.925 -0400", hash_original_method = "CFFFBB83D5CAB96B8DF6F8A1F3FD834E", hash_generated_method = "D26C45D435D79556A74DEBD6612FAA64")
    private  LocaleData() {
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.935 -0400", hash_original_method = "784F7240396B6696F26C45143188C28A", hash_generated_method = "AE4043A7E6DDEB1C39AC3DA292D40FB1")
    @Override
    public String toString() {
String var5A6DE645536F723A5172C7B3F4462C9F_1616582546 =         "LocaleData[" +
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
                "percentPattern=" + percentPattern + "]";
        var5A6DE645536F723A5172C7B3F4462C9F_1616582546.addTaint(taint);
        return var5A6DE645536F723A5172C7B3F4462C9F_1616582546;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.940 -0400", hash_original_method = "97F8929D36249A9101B1710A2B088C68", hash_generated_method = "661A5D0F5903D7BE6EB7261ACD81ADE1")
    private void overrideWithDataFrom(LocaleData overrides) {
        if(overrides.firstDayOfWeek != null)        
        {
            firstDayOfWeek = overrides.firstDayOfWeek;
        } //End block
        if(overrides.minimalDaysInFirstWeek != null)        
        {
            minimalDaysInFirstWeek = overrides.minimalDaysInFirstWeek;
        } //End block
        if(overrides.amPm != null)        
        {
            amPm = overrides.amPm;
        } //End block
        if(overrides.eras != null)        
        {
            eras = overrides.eras;
        } //End block
        if(overrides.longMonthNames != null)        
        {
            longMonthNames = overrides.longMonthNames;
        } //End block
        if(overrides.shortMonthNames != null)        
        {
            shortMonthNames = overrides.shortMonthNames;
        } //End block
        if(overrides.longStandAloneMonthNames != null)        
        {
            longStandAloneMonthNames = overrides.longStandAloneMonthNames;
        } //End block
        if(overrides.shortStandAloneMonthNames != null)        
        {
            shortStandAloneMonthNames = overrides.shortStandAloneMonthNames;
        } //End block
        if(overrides.longWeekdayNames != null)        
        {
            longWeekdayNames = overrides.longWeekdayNames;
        } //End block
        if(overrides.shortWeekdayNames != null)        
        {
            shortWeekdayNames = overrides.shortWeekdayNames;
        } //End block
        if(overrides.longStandAloneWeekdayNames != null)        
        {
            longStandAloneWeekdayNames = overrides.longStandAloneWeekdayNames;
        } //End block
        if(overrides.shortStandAloneWeekdayNames != null)        
        {
            shortStandAloneWeekdayNames = overrides.shortStandAloneWeekdayNames;
        } //End block
        if(overrides.fullTimeFormat != null)        
        {
            fullTimeFormat = overrides.fullTimeFormat;
        } //End block
        if(overrides.longTimeFormat != null)        
        {
            longTimeFormat = overrides.longTimeFormat;
        } //End block
        if(overrides.mediumTimeFormat != null)        
        {
            mediumTimeFormat = overrides.mediumTimeFormat;
        } //End block
        if(overrides.shortTimeFormat != null)        
        {
            shortTimeFormat = overrides.shortTimeFormat;
        } //End block
        if(overrides.fullDateFormat != null)        
        {
            fullDateFormat = overrides.fullDateFormat;
        } //End block
        if(overrides.longDateFormat != null)        
        {
            longDateFormat = overrides.longDateFormat;
        } //End block
        if(overrides.mediumDateFormat != null)        
        {
            mediumDateFormat = overrides.mediumDateFormat;
        } //End block
        if(overrides.shortDateFormat != null)        
        {
            shortDateFormat = overrides.shortDateFormat;
        } //End block
        if(overrides.zeroDigit != '\0')        
        {
            zeroDigit = overrides.zeroDigit;
        } //End block
        if(overrides.decimalSeparator != '\0')        
        {
            decimalSeparator = overrides.decimalSeparator;
        } //End block
        if(overrides.groupingSeparator != '\0')        
        {
            groupingSeparator = overrides.groupingSeparator;
        } //End block
        if(overrides.patternSeparator != '\0')        
        {
            patternSeparator = overrides.patternSeparator;
        } //End block
        if(overrides.percent != '\0')        
        {
            percent = overrides.percent;
        } //End block
        if(overrides.perMill != '\0')        
        {
            perMill = overrides.perMill;
        } //End block
        if(overrides.monetarySeparator != '\0')        
        {
            monetarySeparator = overrides.monetarySeparator;
        } //End block
        if(overrides.minusSign != '\0')        
        {
            minusSign = overrides.minusSign;
        } //End block
        if(overrides.exponentSeparator != null)        
        {
            exponentSeparator = overrides.exponentSeparator;
        } //End block
        if(overrides.NaN != null)        
        {
            NaN = overrides.NaN;
        } //End block
        if(overrides.infinity != null)        
        {
            infinity = overrides.infinity;
        } //End block
        if(overrides.currencySymbol != null)        
        {
            currencySymbol = overrides.currencySymbol;
        } //End block
        if(overrides.internationalCurrencySymbol != null)        
        {
            internationalCurrencySymbol = overrides.internationalCurrencySymbol;
        } //End block
        if(overrides.numberPattern != null)        
        {
            numberPattern = overrides.numberPattern;
        } //End block
        if(overrides.integerPattern != null)        
        {
            integerPattern = overrides.integerPattern;
        } //End block
        if(overrides.currencyPattern != null)        
        {
            currencyPattern = overrides.currencyPattern;
        } //End block
        if(overrides.percentPattern != null)        
        {
            percentPattern = overrides.percentPattern;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.941 -0400", hash_original_method = "348F1EE4DC68FC97E057A91A2366FE0E", hash_generated_method = "5308B8527008289E579F18F90DC1F1EA")
    public String getDateFormat(int style) {
        addTaint(style);
switch(style){
        case DateFormat.SHORT:
String varF944ACF7A5EA9A7168916FFE94FF7DFE_334576045 =         shortDateFormat;
        varF944ACF7A5EA9A7168916FFE94FF7DFE_334576045.addTaint(taint);
        return varF944ACF7A5EA9A7168916FFE94FF7DFE_334576045;
        case DateFormat.MEDIUM:
String var6EADEEC01C923A6EDCA3A088EA11A9B8_2064970425 =         mediumDateFormat;
        var6EADEEC01C923A6EDCA3A088EA11A9B8_2064970425.addTaint(taint);
        return var6EADEEC01C923A6EDCA3A088EA11A9B8_2064970425;
        case DateFormat.LONG:
String var637CF6025ABDDC1CFC8046182423008B_686325146 =         longDateFormat;
        var637CF6025ABDDC1CFC8046182423008B_686325146.addTaint(taint);
        return var637CF6025ABDDC1CFC8046182423008B_686325146;
        case DateFormat.FULL:
String var4634C217D946CAB44464F86454585E44_1729294978 =         fullDateFormat;
        var4634C217D946CAB44464F86454585E44_1729294978.addTaint(taint);
        return var4634C217D946CAB44464F86454585E44_1729294978;
}        AssertionError varA81442E36297E737EB908877E58260E8_1887250255 = new AssertionError();
        varA81442E36297E737EB908877E58260E8_1887250255.addTaint(taint);
        throw varA81442E36297E737EB908877E58260E8_1887250255;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.941 -0400", hash_original_method = "381AB0475AE772D0631EAF7DD6B1FBEE", hash_generated_method = "C5997EB424C8F6655A701FD8F1F46D67")
    public String getTimeFormat(int style) {
        addTaint(style);
switch(style){
        case DateFormat.SHORT:
String varB589CC7067EEE68A906826572FDA8ED1_1336931403 =         shortTimeFormat;
        varB589CC7067EEE68A906826572FDA8ED1_1336931403.addTaint(taint);
        return varB589CC7067EEE68A906826572FDA8ED1_1336931403;
        case DateFormat.MEDIUM:
String var360D62D48CEAD6FE6A84B1900547370C_908278461 =         mediumTimeFormat;
        var360D62D48CEAD6FE6A84B1900547370C_908278461.addTaint(taint);
        return var360D62D48CEAD6FE6A84B1900547370C_908278461;
        case DateFormat.LONG:
String var566C7E57B78D41118E8A8BE3D5A59676_1175649800 =         longTimeFormat;
        var566C7E57B78D41118E8A8BE3D5A59676_1175649800.addTaint(taint);
        return var566C7E57B78D41118E8A8BE3D5A59676_1175649800;
        case DateFormat.FULL:
String var47A9C88E8999743CB5904718E9A01273_637681337 =         fullTimeFormat;
        var47A9C88E8999743CB5904718E9A01273_637681337.addTaint(taint);
        return var47A9C88E8999743CB5904718E9A01273_637681337;
}        AssertionError varA81442E36297E737EB908877E58260E8_554783260 = new AssertionError();
        varA81442E36297E737EB908877E58260E8_554783260.addTaint(taint);
        throw varA81442E36297E737EB908877E58260E8_554783260;
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.942 -0400", hash_original_field = "0F51A85617E995062B0A5B55D20B7BFD", hash_generated_field = "5A93A59B8C598AAE6C743E64FAFC9883")

    private static final HashMap<String, LocaleData> localeDataCache = new HashMap<String, LocaleData>();
    static {
        get(Locale.ROOT);
        get(Locale.US);
        get(Locale.getDefault());
    }
    
}

