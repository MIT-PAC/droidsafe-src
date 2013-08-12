package com.android.internal.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.format.Time;





public final class HttpDateTime {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.204 -0400", hash_original_method = "7CB4B1DA681A2A8A056262512BDE8871", hash_generated_method = "7CB4B1DA681A2A8A056262512BDE8871")
    public HttpDateTime ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static long parse(String timeString) throws IllegalArgumentException {
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
        if (year >= 2038) {
            year = 2038;
            month = Calendar.JANUARY;
            date = 1;
        }
        Time time = new Time(Time.TIMEZONE_UTC);
        time.set(timeOfDay.second, timeOfDay.minute, timeOfDay.hour, date,
                month, year);
        return time.toMillis(false );
    }

    
    @DSModeled(DSC.BAN)
    private static int getDate(String dateString) {
        if (dateString.length() == 2) {
            return (dateString.charAt(0) - '0') * 10
                    + (dateString.charAt(1) - '0');
        } else {
            return (dateString.charAt(0) - '0');
        }
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static TimeOfDay getTime(String timeString) {
        int i = 0;
        int hour = timeString.charAt(i++) - '0';
        if (timeString.charAt(i) != ':')
            hour = hour * 10 + (timeString.charAt(i++) - '0');
        i++;
        int minute = (timeString.charAt(i++) - '0') * 10
                    + (timeString.charAt(i++) - '0');
        i++;
        int second = (timeString.charAt(i++) - '0') * 10
                  + (timeString.charAt(i++) - '0');
        return new TimeOfDay(hour, minute, second);
    }

    
    private static class TimeOfDay {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.206 -0400", hash_original_field = "896C55CC5E46FAB38CE9F51EBF7BFCD3", hash_generated_field = "6CAA30872566AAC3D8208DA318F04BBD")

        int hour;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.206 -0400", hash_original_field = "0A7D55BE9D12A369A6A8DA0FB517FBA4", hash_generated_field = "56A69BE5A6B1DCF64B7123BACE74483B")

        int minute;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.206 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "662760B0A001432CFE4D3F18F01B3CEF")

        int second;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.207 -0400", hash_original_method = "C386336929F1995213D1FEE1C093D027", hash_generated_method = "CFAAF78546A399AC683BE2F251F89455")
          TimeOfDay(int h, int m, int s) {
            this.hour = h;
            this.minute = m;
            this.second = s;
            // ---------- Original Method ----------
            //this.hour = h;
            //this.minute = m;
            //this.second = s;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.207 -0400", hash_original_field = "FD7202E55206853477E68E44F6EB7A02", hash_generated_field = "FE6052786411ADD829D604593BDDCE6D")

    private static final String HTTP_DATE_RFC_REGEXP = "([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]"
            + "([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.207 -0400", hash_original_field = "D50E3709391CC9457DB0688DC9EF6E68", hash_generated_field = "F1E0087178140CE39B35BFDC4DBACEA5")

    private static final String HTTP_DATE_ANSIC_REGEXP = "[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]"
            + "([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.208 -0400", hash_original_field = "0BF1B6479B0497D13965E87448F57161", hash_generated_field = "3B350C6486922908E05EA0A76E649786")

    private static final Pattern HTTP_DATE_RFC_PATTERN = Pattern.compile(HTTP_DATE_RFC_REGEXP);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.208 -0400", hash_original_field = "2CFF809512F17799A0FF368E3EC04AEB", hash_generated_field = "33F3085379241401481069397DBA78FE")

    private static final Pattern HTTP_DATE_ANSIC_PATTERN = Pattern.compile(HTTP_DATE_ANSIC_REGEXP);
}

