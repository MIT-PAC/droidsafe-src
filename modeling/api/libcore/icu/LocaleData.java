/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public final class LocaleData {

    /**
     * Returns a shared LocaleData for the given locale.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.457 -0500", hash_original_method = "454901B37172A9DA196A9083C6F7CD55", hash_generated_method = "CA340BBB1FC2BAF9920FC327A2533A9C")
    
public static LocaleData get(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String localeName = locale.toString();
        
        LocaleData localeData = new LocaleData();
        localeData.addTaint(locale.getTaint());
        return localeData;
        /*
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
        */
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.460 -0500", hash_original_method = "79D4FC8C2ABEB0A938BC6FE7010C2BAD", hash_generated_method = "56DB64939831588B89054D58D320D8AA")
    
private static LocaleData makeLocaleData(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        // Start with data from the parent (next-most-specific) locale...
        LocaleData result = new LocaleData();
        if (!variant.isEmpty()) {
            result.overrideWithDataFrom(get(new Locale(language, country, "")));
        } else if (!country.isEmpty()) {
            result.overrideWithDataFrom(get(new Locale(language, "", "")));
        } else if (!language.isEmpty()) {
            result.overrideWithDataFrom(get(Locale.ROOT));
        }
        // Override with data from this locale.
        result.overrideWithDataFrom(initLocaleData(locale));
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.476 -0500", hash_original_method = "FA71E4202D4AE5CBCEEA55A7373875A9", hash_generated_method = "FA990B249DB35B8134DF25A33C7940B6")
    
private static LocaleData initLocaleData(Locale locale) {
        LocaleData localeData = new LocaleData();
        if (!ICU.initLocaleDataImpl(locale.toString(), localeData)) {
            throw new AssertionError("couldn't initialize LocaleData for locale " + locale);
        }
        if (localeData.fullTimeFormat != null) {
            // There are some full time format patterns in ICU that use the pattern character 'v'.
            // Java doesn't accept this, so we replace it with 'z' which has about the same result
            // as 'v', the timezone name.
            // 'v' -> "PT", 'z' -> "PST", v is the generic timezone and z the standard tz
            // "vvvv" -> "Pacific Time", "zzzz" -> "Pacific Standard Time"
            localeData.fullTimeFormat = localeData.fullTimeFormat.replace('v', 'z');
        }
        if (localeData.numberPattern != null) {
            // The number pattern might contain positive and negative subpatterns. Arabic, for
            // example, might look like "#,##0.###;#,##0.###-" because the minus sign should be
            // written last. Macedonian supposedly looks something like "#,##0.###;(#,##0.###)".
            // (The negative subpattern is optional, though, and not present in most locales.)
            // By only swallowing '#'es and ','s after the '.', we ensure that we don't
            // accidentally eat too much.
            localeData.integerPattern = localeData.numberPattern.replaceAll("\\.[#,]*", "");
        }
        return localeData;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.370 -0500", hash_original_field = "EACEB04927336316131A17D0EBE1E267", hash_generated_field = "5A93A59B8C598AAE6C743E64FAFC9883")

    private static final HashMap<String, LocaleData> localeDataCache = new HashMap<String, LocaleData>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.372 -0500", hash_original_field = "2E976E6B78D5FFD7DAB70ECE74EE82F5", hash_generated_field = "8A13F0EA9FFA1E934CE8561DD3C5989E")

    public Integer firstDayOfWeek;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.374 -0500", hash_original_field = "753A47FB02A05682B9B2E50F6E6F73F6", hash_generated_field = "03D4DF0C331BF703C630DB3CF80ED225")

    public Integer minimalDaysInFirstWeek;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.376 -0500", hash_original_field = "249892A8A1EA54288B5665DD220AABF4", hash_generated_field = "213FC9B381F9FD6CC3287737355F39E7")

    public String[] amPm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.379 -0500", hash_original_field = "E0691941E69B86E10AC79FC9DFFC272D", hash_generated_field = "0C7432EFCA179700DEFB07441E17C241")

    public String[] eras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.381 -0500", hash_original_field = "224B21F3D147051C73AA3CCBB5FD6E9A", hash_generated_field = "4185736CD0C48B464D4536B3488BB3C2")

    public String[] longMonthNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.383 -0500", hash_original_field = "C003915A1925D77E2FA6F245B23833AD", hash_generated_field = "C9B0BE34CCC3507AA77C40623159A080")

    public String[] shortMonthNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.385 -0500", hash_original_field = "3172A63DCF89BB5AD30D01275AA8DBF6", hash_generated_field = "34E5539EC5A76BE352031DB9A3085C41")

    public String[] longStandAloneMonthNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.388 -0500", hash_original_field = "41DAE87BD19BC1BC637BAC3612FD89D9", hash_generated_field = "5C5A6411256AB4A1E90F1F6C871AC8FC")

    public String[] shortStandAloneMonthNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.390 -0500", hash_original_field = "E5D80B2F48FF250F244A5F4434051709", hash_generated_field = "C3AE2E018004F552B964BCCAFD874935")

    public String[] longWeekdayNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.392 -0500", hash_original_field = "B30592ADC5B3D987042D44C4C2B9C401", hash_generated_field = "F94D89296B2F63E5B79A74F258E30993")

    public String[] shortWeekdayNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.395 -0500", hash_original_field = "793F55E87563A78848C17769652EB6A4", hash_generated_field = "1D47E5E3C2881492F63ED7CCFBCD5E22")

    public String[] longStandAloneWeekdayNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.397 -0500", hash_original_field = "E725C35BC6DB9FB8DD052D3FD02B5B45", hash_generated_field = "07175FBDE37014F8440D3E7AE21FA651")

    public String[] shortStandAloneWeekdayNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.399 -0500", hash_original_field = "E807C7A6DAB331E6AC21137D1141B78A", hash_generated_field = "1E68C4F12D0CF34DDE7994AB138806E1")

    public String fullTimeFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.401 -0500", hash_original_field = "589CA08DA4C237B50D1295BB307B1921", hash_generated_field = "78D3925C0C39754AEC93A487210285B8")

    public String longTimeFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.403 -0500", hash_original_field = "2D9BA41D10C9F1EA8E67F22B5A215C2B", hash_generated_field = "F2E510CEAA1E15F91C2011ED4F242732")

    public String mediumTimeFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.406 -0500", hash_original_field = "D87F2C2B2AC568F09AFF2035EADED3D6", hash_generated_field = "ACB523060E571DEA6B84F3C7BA1E8675")

    public String shortTimeFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.408 -0500", hash_original_field = "82696F27F0B18A040AA0D686AB0100DF", hash_generated_field = "4D53B22725CC478319F8EB2DB917D8D8")

    public String fullDateFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.410 -0500", hash_original_field = "EB927B54EF5A3F623E86C33AE9CE4A48", hash_generated_field = "C5A04CB5D384F7C0638BF2C80E7F94E7")

    public String longDateFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.412 -0500", hash_original_field = "BD24B84425A56D3E4AC8FFC4F933AA0E", hash_generated_field = "854F946C7A5E5E8189651579B59F06BD")

    public String mediumDateFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.414 -0500", hash_original_field = "0CE2FAB18C84DA46B92557EFD1487497", hash_generated_field = "D99113CA10FA94AF2FCE804652348B56")

    public String shortDateFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.416 -0500", hash_original_field = "17DFD5FF22509500C57E1B2A7C4E9225", hash_generated_field = "4888B60DABE88AB42231B4ADC4A02CA0")

    public char zeroDigit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.419 -0500", hash_original_field = "1038FD332ED44A7DF96FEF42F0B6917E", hash_generated_field = "35DDBB85537BF0F9807E26101DBEA26E")

    public char decimalSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.421 -0500", hash_original_field = "387522DF55114ECCD5B758AE0FB4960A", hash_generated_field = "9B69BAC717BFFD8B7436EE206FD9A125")

    public char groupingSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.423 -0500", hash_original_field = "5C37B6EBDB9BD228E12EA493827F167B", hash_generated_field = "4DFD5CCD9A735920501A4CD74952610F")

    public char patternSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.425 -0500", hash_original_field = "3F2A0F7E47175E72985257908756B0D4", hash_generated_field = "0EF4D992455EAB6F4D76C77D9E176A8A")

    public char percent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.427 -0500", hash_original_field = "362DA8A2EA348381739AA1AA9E01F08D", hash_generated_field = "B91658C178B36F90659298B733B0697C")

    public char perMill;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.429 -0500", hash_original_field = "CB2E5B66AD2B613B8806B2371335452C", hash_generated_field = "4E2FAA088364B280E497C1EB718A4292")

    public char monetarySeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.432 -0500", hash_original_field = "1D678252731BB3F550006E1A687D6282", hash_generated_field = "F2C15C2423BCA068978BE230503ED8C9")

    public char minusSign;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.434 -0500", hash_original_field = "D6E7D74106B64434AFE81AD1BEF608B8", hash_generated_field = "1C4D7AC3B4908F09C2F992F288F21FD0")

    public String exponentSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.437 -0500", hash_original_field = "10817E444ABECCADF42DD0086415F07C", hash_generated_field = "52788164AF36FD8480328F81CA27D813")

    public String infinity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.439 -0500", hash_original_field = "7BC719822E58B1E9A181D87ED4339FF5", hash_generated_field = "1ACE7DA05AF67826290EE2F37998213B")

    public String NaN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.441 -0500", hash_original_field = "94B9DBA9228ABD61F5468FCC9AA3593F", hash_generated_field = "3A1AA78D098C0361A3F77A45D4D29064")

    public String currencySymbol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.443 -0500", hash_original_field = "C435ADB7295935E9C6C834C68305BA43", hash_generated_field = "33E347BE6A63944341A881F74532F9D0")

    public String internationalCurrencySymbol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.445 -0500", hash_original_field = "D518A537F8CB636279980C9B1030DAD9", hash_generated_field = "D8B3481EB6C0D581859B565C481F869F")

    public String numberPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.447 -0500", hash_original_field = "7CAD03290E0501975FE4468B27F2FE8D", hash_generated_field = "DA8D3E0E29515F1E2517989802DC8F5B")

    public String integerPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.449 -0500", hash_original_field = "541D22F566EBCDD2914A564C6B96F50B", hash_generated_field = "66F5A7220B0DE657C90A1C9851B9E9E4")

    public String currencyPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.452 -0500", hash_original_field = "726BC4291E41B726A691AF4DA0A8A2CC", hash_generated_field = "C4072630D2D98FE2320BACD3DD2692A3")

    public String percentPattern;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.455 -0500", hash_original_method = "CFFFBB83D5CAB96B8DF6F8A1F3FD834E", hash_generated_method = "3B99322668F78B6210F1E35DB1EAC8AD")
    
private LocaleData() {
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.463 -0500", hash_original_method = "784F7240396B6696F26C45143188C28A", hash_generated_method = "599E7D1A81C2948E35A3C5FDB8CF35FC")
    
@Override public String toString() {
        return "LocaleData[" +
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
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.467 -0500", hash_original_method = "97F8929D36249A9101B1710A2B088C68", hash_generated_method = "1918EF1D72275CED5C83739339A9F81A")
    
private void overrideWithDataFrom(LocaleData overrides) {
        if (overrides.firstDayOfWeek != null) {
            firstDayOfWeek = overrides.firstDayOfWeek;
        }
        if (overrides.minimalDaysInFirstWeek != null) {
            minimalDaysInFirstWeek = overrides.minimalDaysInFirstWeek;
        }
        if (overrides.amPm != null) {
            amPm = overrides.amPm;
        }
        if (overrides.eras != null) {
            eras = overrides.eras;
        }
        if (overrides.longMonthNames != null) {
            longMonthNames = overrides.longMonthNames;
        }
        if (overrides.shortMonthNames != null) {
            shortMonthNames = overrides.shortMonthNames;
        }
        if (overrides.longStandAloneMonthNames != null) {
            longStandAloneMonthNames = overrides.longStandAloneMonthNames;
        }
        if (overrides.shortStandAloneMonthNames != null) {
            shortStandAloneMonthNames = overrides.shortStandAloneMonthNames;
        }
        if (overrides.longWeekdayNames != null) {
            longWeekdayNames = overrides.longWeekdayNames;
        }
        if (overrides.shortWeekdayNames != null) {
            shortWeekdayNames = overrides.shortWeekdayNames;
        }
        if (overrides.longStandAloneWeekdayNames != null) {
            longStandAloneWeekdayNames = overrides.longStandAloneWeekdayNames;
        }
        if (overrides.shortStandAloneWeekdayNames != null) {
            shortStandAloneWeekdayNames = overrides.shortStandAloneWeekdayNames;
        }
        if (overrides.fullTimeFormat != null) {
            fullTimeFormat = overrides.fullTimeFormat;
        }
        if (overrides.longTimeFormat != null) {
            longTimeFormat = overrides.longTimeFormat;
        }
        if (overrides.mediumTimeFormat != null) {
            mediumTimeFormat = overrides.mediumTimeFormat;
        }
        if (overrides.shortTimeFormat != null) {
            shortTimeFormat = overrides.shortTimeFormat;
        }
        if (overrides.fullDateFormat != null) {
            fullDateFormat = overrides.fullDateFormat;
        }
        if (overrides.longDateFormat != null) {
            longDateFormat = overrides.longDateFormat;
        }
        if (overrides.mediumDateFormat != null) {
            mediumDateFormat = overrides.mediumDateFormat;
        }
        if (overrides.shortDateFormat != null) {
            shortDateFormat = overrides.shortDateFormat;
        }
        if (overrides.zeroDigit != '\0') {
            zeroDigit = overrides.zeroDigit;
        }
        if (overrides.decimalSeparator != '\0') {
            decimalSeparator = overrides.decimalSeparator;
        }
        if (overrides.groupingSeparator != '\0') {
            groupingSeparator = overrides.groupingSeparator;
        }
        if (overrides.patternSeparator != '\0') {
            patternSeparator = overrides.patternSeparator;
        }
        if (overrides.percent != '\0') {
            percent = overrides.percent;
        }
        if (overrides.perMill != '\0') {
            perMill = overrides.perMill;
        }
        if (overrides.monetarySeparator != '\0') {
            monetarySeparator = overrides.monetarySeparator;
        }
        if (overrides.minusSign != '\0') {
            minusSign = overrides.minusSign;
        }
        if (overrides.exponentSeparator != null) {
            exponentSeparator = overrides.exponentSeparator;
        }
        if (overrides.NaN != null) {
            NaN = overrides.NaN;
        }
        if (overrides.infinity != null) {
            infinity = overrides.infinity;
        }
        if (overrides.currencySymbol != null) {
            currencySymbol = overrides.currencySymbol;
        }
        if (overrides.internationalCurrencySymbol != null) {
            internationalCurrencySymbol = overrides.internationalCurrencySymbol;
        }
        if (overrides.numberPattern != null) {
            numberPattern = overrides.numberPattern;
        }
        if (overrides.integerPattern != null) {
            integerPattern = overrides.integerPattern;
        }
        if (overrides.currencyPattern != null) {
            currencyPattern = overrides.currencyPattern;
        }
        if (overrides.percentPattern != null) {
            percentPattern = overrides.percentPattern;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.470 -0500", hash_original_method = "348F1EE4DC68FC97E057A91A2366FE0E", hash_generated_method = "71ED4BCB4598FFB10DC0C402FADA9D5D")
    
public String getDateFormat(int style) {
        switch (style) {
        case DateFormat.SHORT:
            return shortDateFormat;
        case DateFormat.MEDIUM:
            return mediumDateFormat;
        case DateFormat.LONG:
            return longDateFormat;
        case DateFormat.FULL:
            return fullDateFormat;
        }
        throw new AssertionError();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:17.472 -0500", hash_original_method = "381AB0475AE772D0631EAF7DD6B1FBEE", hash_generated_method = "DA8A3C0334E8EF93209CB0402B09C9BF")
    
public String getTimeFormat(int style) {
        switch (style) {
        case DateFormat.SHORT:
            return shortTimeFormat;
        case DateFormat.MEDIUM:
            return mediumTimeFormat;
        case DateFormat.LONG:
            return longTimeFormat;
        case DateFormat.FULL:
            return fullTimeFormat;
        }
        throw new AssertionError();
    }
    static {
        get(Locale.ROOT);
        get(Locale.US);
        get(Locale.getDefault());
    }
    
}

