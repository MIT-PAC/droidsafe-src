package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class Grego {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.139 -0400", hash_original_method = "781533361B1A3C2878A623AB7A311302", hash_generated_method = "781533361B1A3C2878A623AB7A311302")
        public Grego ()
    {
    }


        public static final boolean isLeapYear(int year) {
        return ((year&0x3) == 0) && ((year%100 != 0) || (year%400 == 0));
    }

    
        public static final int monthLength(int year, int month) {
        return MONTH_LENGTH[month + (isLeapYear(year) ? 12 : 0)];
    }

    
        public static final int previousMonthLength(int year, int month) {
        return (month > 0) ? monthLength(year, month-1) : 31;
    }

    
        public static long fieldsToDay(int year, int month, int dom) {
        int y = year - 1;
        long julian =
            365 * y + floorDivide(y, 4) + (JULIAN_1_CE - 3) +    
            floorDivide(y, 400) - floorDivide(y, 100) + 2 +   
            DAYS_BEFORE[month + (isLeapYear(year) ? 12 : 0)] + dom;
        return julian - JULIAN_1970_CE;
    }

    
        public static int dayOfWeek(long day) {
        long[] remainder = new long[1];
        floorDivide(day + Calendar.THURSDAY, 7, remainder);
        int dayOfWeek = (int)remainder[0];
        dayOfWeek = (dayOfWeek == 0) ? 7 : dayOfWeek;
        return dayOfWeek;
    }

    
        public static int[] dayToFields(long day, int[] fields) {
        if (fields == null || fields.length < 5) {
            fields = new int[5];
        }
        day += JULIAN_1970_CE - JULIAN_1_CE;
        long[] rem = new long[1];
        long n400 = floorDivide(day, 146097, rem);
        long n100 = floorDivide(rem[0], 36524, rem);
        long n4 = floorDivide(rem[0], 1461, rem);
        long n1 = floorDivide(rem[0], 365, rem);
        int year = (int)(400 * n400 + 100 * n100 + 4 * n4 + n1);
        int dayOfYear = (int)rem[0];
        if (n100 == 4 || n1 == 4) {
            dayOfYear = 365;    
        }
        else {
            ++year;
        }
        boolean isLeap = isLeapYear(year);
        int correction = 0;
        int march1 = isLeap ? 60 : 59;
        if (dayOfYear >= march1) {
            correction = isLeap ? 1 : 2;
        }
        int month = (12 * (dayOfYear + correction) + 6) / 367;
        int dayOfMonth = dayOfYear - DAYS_BEFORE[isLeap ? month + 12 : month] + 1;
        int dayOfWeek = (int)((day + 2) % 7);
        if (dayOfWeek < 1 ) {
            dayOfWeek += 7;
        }
        dayOfYear++;
        fields[0] = year;
        fields[1] = month;
        fields[2] = dayOfMonth;
        fields[3] = dayOfWeek;
        fields[4] = dayOfYear;
        return fields;
    }

    
        public static int[] timeToFields(long time, int[] fields) {
        if (fields == null || fields.length < 6) {
            fields = new int[6];
        }
        long[] remainder = new long[1];
        long day = floorDivide(time, 24*60*60*1000 , remainder);
        dayToFields(day, fields);
        fields[5] = (int)remainder[0];
        return fields;
    }

    
        public static long floorDivide(long numerator, long denominator) {
        return (numerator >= 0) ?
            numerator / denominator :
            ((numerator + 1) / denominator) - 1;
    }

    
        private static long floorDivide(long numerator, long denominator, long[] remainder) {
        if (numerator >= 0) {
            remainder[0] = numerator % denominator;
            return numerator / denominator;
        }
        long quotient = ((numerator + 1) / denominator) - 1;
        remainder[0] = numerator - (quotient * denominator);
        return quotient;
    }

    
        public static int getDayOfWeekInMonth(int year, int month, int dayOfMonth) {
        int weekInMonth = (dayOfMonth + 6)/7;
        if (weekInMonth == 4) {
            if (dayOfMonth + 7 > monthLength(year, month)) {
                weekInMonth = -1;
            }
        } else if (weekInMonth == 5) {
            weekInMonth = -1;
        }
        return weekInMonth;
    }

    
    public static final long MIN_MILLIS = -184303902528000000L;
    public static final long MAX_MILLIS = 183882168921600000L;
    public static final int MILLIS_PER_SECOND = 1000;
    public static final int MILLIS_PER_MINUTE = 60*MILLIS_PER_SECOND;
    public static final int MILLIS_PER_HOUR = 60*MILLIS_PER_MINUTE;
    public static final int MILLIS_PER_DAY = 24*MILLIS_PER_HOUR;
    private static final int JULIAN_1_CE = 1721426;
    private static final int JULIAN_1970_CE = 2440588;
    private static final int[] MONTH_LENGTH = new int[] {
        31,28,31,30,31,30,31,31,30,31,30,31,
        31,29,31,30,31,30,31,31,30,31,30,31
    };
    private static final int[] DAYS_BEFORE = new int[] {
        0,31,59,90,120,151,181,212,243,273,304,334,
        0,31,60,91,121,152,182,213,244,274,305,335 };
}

