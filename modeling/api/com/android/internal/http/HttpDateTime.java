package com.android.internal.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.format.Time;

public final class HttpDateTime {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.669 -0500", hash_original_method = "E4B152074829BA57285EA96C40C0EF3C", hash_generated_method = "043C6A7B9943BFC8EAD1243FD9CEA784")
    
public static long parse(String timeString)
            throws IllegalArgumentException {

        int date = 1;
        int month = Calendar.JANUARY;
        int year = 1970;
        TimeOfDay timeOfDay;

        Matcher rfcMatcher = HTTP_DATE_RFC_PATTERN.matcher(timeString);
        if (rfcMatcher.find()) {
            date = getDate(rfcMatcher.group(1));
            month = getMonth(rfcMatcher.group(2));
            year = getYear(rfcMatcher.group(3));
            timeOfDay = getTime(rfcMatcher.group(4));
        } else {
            Matcher ansicMatcher = HTTP_DATE_ANSIC_PATTERN.matcher(timeString);
            if (ansicMatcher.find()) {
                month = getMonth(ansicMatcher.group(1));
                date = getDate(ansicMatcher.group(2));
                timeOfDay = getTime(ansicMatcher.group(3));
                year = getYear(ansicMatcher.group(4));
            } else {
                throw new IllegalArgumentException();
            }
        }

        // FIXME: Y2038 BUG!
        if (year >= 2038) {
            year = 2038;
            month = Calendar.JANUARY;
            date = 1;
        }

        Time time = new Time(Time.TIMEZONE_UTC);
        time.set(timeOfDay.second, timeOfDay.minute, timeOfDay.hour, date,
                month, year);
        return time.toMillis(false /* use isDst */);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.671 -0500", hash_original_method = "30B6FF51139E27406DD1403F4EBB1DD0", hash_generated_method = "3F0E1EA038483742D9B631FF8B6BBA5E")
    
private static int getDate(String dateString) {
        if (dateString.length() == 2) {
            return (dateString.charAt(0) - '0') * 10
                    + (dateString.charAt(1) - '0');
        } else {
            return (dateString.charAt(0) - '0');
        }
    }

    /*
     * jan = 9 + 0 + 13 = 22
     * feb = 5 + 4 + 1 = 10
     * mar = 12 + 0 + 17 = 29
     * apr = 0 + 15 + 17 = 32
     * may = 12 + 0 + 24 = 36
     * jun = 9 + 20 + 13 = 42
     * jul = 9 + 20 + 11 = 40
     * aug = 0 + 20 + 6 = 26
     * sep = 18 + 4 + 15 = 37
     * oct = 14 + 2 + 19 = 35
     * nov = 13 + 14 + 21 = 48
     * dec = 3 + 4 + 2 = 9
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.674 -0500", hash_original_method = "0A426422E428E0144F4BE4D097CCF45E", hash_generated_method = "56BC5656E9D4416F406A8512030AA642")
    
private static int getMonth(String monthString) {
        int hash = Character.toLowerCase(monthString.charAt(0)) +
                Character.toLowerCase(monthString.charAt(1)) +
                Character.toLowerCase(monthString.charAt(2)) - 3 * 'a';
        switch (hash) {
            case 22:
                return Calendar.JANUARY;
            case 10:
                return Calendar.FEBRUARY;
            case 29:
                return Calendar.MARCH;
            case 32:
                return Calendar.APRIL;
            case 36:
                return Calendar.MAY;
            case 42:
                return Calendar.JUNE;
            case 40:
                return Calendar.JULY;
            case 26:
                return Calendar.AUGUST;
            case 37:
                return Calendar.SEPTEMBER;
            case 35:
                return Calendar.OCTOBER;
            case 48:
                return Calendar.NOVEMBER;
            case 9:
                return Calendar.DECEMBER;
            default:
                throw new IllegalArgumentException();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.676 -0500", hash_original_method = "94B20CBAF1BF7E8BAB0748EC1D668BD7", hash_generated_method = "FFB9AB22F7CE2366C68ACBC5B0DF0569")
    
private static int getYear(String yearString) {
        if (yearString.length() == 2) {
            int year = (yearString.charAt(0) - '0') * 10
                    + (yearString.charAt(1) - '0');
            if (year >= 70) {
                return year + 1900;
            } else {
                return year + 2000;
            }
        } else if (yearString.length() == 3) {
            // According to RFC 2822, three digit years should be added to 1900.
            int year = (yearString.charAt(0) - '0') * 100
                    + (yearString.charAt(1) - '0') * 10
                    + (yearString.charAt(2) - '0');
            return year + 1900;
        } else if (yearString.length() == 4) {
             return (yearString.charAt(0) - '0') * 1000
                    + (yearString.charAt(1) - '0') * 100
                    + (yearString.charAt(2) - '0') * 10
                    + (yearString.charAt(3) - '0');
        } else {
             return 1970;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.680 -0500", hash_original_method = "8BD5B80F119DF5823EBA332CB5B94E39", hash_generated_method = "F4FA7F7DD350DBDD7BB2D2CBD873DAAC")
    
private static TimeOfDay getTime(String timeString) {
        // HH might be H
        int i = 0;
        int hour = timeString.charAt(i++) - '0';
        if (timeString.charAt(i) != ':')
            hour = hour * 10 + (timeString.charAt(i++) - '0');
        // Skip ':'
        i++;
        
        int minute = (timeString.charAt(i++) - '0') * 10
                    + (timeString.charAt(i++) - '0');
        // Skip ':'
        i++;
        
        int second = (timeString.charAt(i++) - '0') * 10
                  + (timeString.charAt(i++) - '0');

        return new TimeOfDay(hour, minute, second);        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.644 -0500", hash_original_field = "614692C4FDE08663AC3A0512C3873EFC", hash_generated_field = "FE6052786411ADD829D604593BDDCE6D")

    private static final String HTTP_DATE_RFC_REGEXP =
            "([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]"
            + "([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])";
    
    private static class TimeOfDay {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.658 -0500", hash_original_field = "6CAA30872566AAC3D8208DA318F04BBD", hash_generated_field = "6CAA30872566AAC3D8208DA318F04BBD")
        
        int hour;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.661 -0500", hash_original_field = "56A69BE5A6B1DCF64B7123BACE74483B", hash_generated_field = "56A69BE5A6B1DCF64B7123BACE74483B")

        int minute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.663 -0500", hash_original_field = "662760B0A001432CFE4D3F18F01B3CEF", hash_generated_field = "662760B0A001432CFE4D3F18F01B3CEF")

        int second;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.656 -0500", hash_original_method = "C386336929F1995213D1FEE1C093D027", hash_generated_method = "C386336929F1995213D1FEE1C093D027")
        
TimeOfDay(int h, int m, int s) {
            this.hour = h;
            this.minute = m;
            this.second = s;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.646 -0500", hash_original_field = "206191F7C4755BCD8025FA103E8BF230", hash_generated_field = "F1E0087178140CE39B35BFDC4DBACEA5")

    private static final String HTTP_DATE_ANSIC_REGEXP =
            "[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]"
            + "([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.649 -0500", hash_original_field = "79413240D59D2F2FD43648E9947CFB11", hash_generated_field = "3B350C6486922908E05EA0A76E649786")

    private static final Pattern HTTP_DATE_RFC_PATTERN =
            Pattern.compile(HTTP_DATE_RFC_REGEXP);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.653 -0500", hash_original_field = "8AE1C74BD667CC6AFF09B3F107E94003", hash_generated_field = "33F3085379241401481069397DBA78FE")

    private static final Pattern HTTP_DATE_ANSIC_PATTERN =
            Pattern.compile(HTTP_DATE_ANSIC_REGEXP);
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.204 -0400", hash_original_method = "7CB4B1DA681A2A8A056262512BDE8871", hash_generated_method = "7CB4B1DA681A2A8A056262512BDE8871")
    public HttpDateTime ()
    {
        //Synthesized constructor
    }
}

