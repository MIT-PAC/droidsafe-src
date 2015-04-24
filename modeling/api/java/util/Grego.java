/**
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
 *******************************************************************************
 * Copyright (C) 2003-2008, International Business Machines Corporation and
 * others. All Rights Reserved.
 *******************************************************************************
 * Partial port from ICU4C's Grego class in i18n/gregoimp.h.
 *
 * Methods ported, or moved here from OlsonTimeZone, initially
 * for work on Jitterbug 5470:
 *   tzdata2006n Brazil incorrect fall-back date 2009-mar-01
 * Only the methods necessary for that work are provided - this is not a full
 * port of ICU4C's Grego class (yet).
 *
 * These utilities are used by both OlsonTimeZone and SimpleTimeZone.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class Grego {

    /**
     * Return true if the given year is a leap year.
     * @param year Gregorian year, with 0 == 1 BCE, -1 == 2 BCE, etc.
     * @return true if the year is a leap year
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.781 -0500", hash_original_method = "192D43C371764131BDB0630448D12BDC", hash_generated_method = "40A0890DA922D9A9D0D325D6B3F19E65")
    
public static final boolean isLeapYear(int year) {
        // year&0x3 == year%4
        return ((year&0x3) == 0) && ((year%100 != 0) || (year%400 == 0));
    }

    /**
     * Return the number of days in the given month.
     * @param year Gregorian year, with 0 == 1 BCE, -1 == 2 BCE, etc.
     * @param month 0-based month, with 0==Jan
     * @return the number of days in the given month
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.784 -0500", hash_original_method = "7E5B8A1FC3A005C68D4CF79F1DDB3E59", hash_generated_method = "046A9E375E57315795A579CE2B0A01B3")
    
public static final int monthLength(int year, int month) {
        return MONTH_LENGTH[month + (isLeapYear(year) ? 12 : 0)];
    }

    /**
     * Return the length of a previous month of the Gregorian calendar.
     * @param year Gregorian year, with 0 == 1 BCE, -1 == 2 BCE, etc.
     * @param month 0-based month, with 0==Jan
     * @return the number of days in the month previous to the given month
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.787 -0500", hash_original_method = "86686EC8BCE04537608D53CE27870697", hash_generated_method = "2429F219A5ECADD05BBD27CA86C6F295")
    
public static final int previousMonthLength(int year, int month) {
        return (month > 0) ? monthLength(year, month-1) : 31;
    }

    /**
     * Convert a year, month, and day-of-month, given in the proleptic
     * Gregorian calendar, to 1970 epoch days.
     * @param year Gregorian year, with 0 == 1 BCE, -1 == 2 BCE, etc.
     * @param month 0-based month, with 0==Jan
     * @param dom 1-based day of month
     * @return the day number, with day 0 == Jan 1 1970
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.789 -0500", hash_original_method = "9E3D2B1FB08CF1797AC579D62B860551", hash_generated_method = "F8DE0D2F60DE4172922B582382B2C7B7")
    
public static long fieldsToDay(int year, int month, int dom) {
        int y = year - 1;
        long julian =
            365 * y + floorDivide(y, 4) + (JULIAN_1_CE - 3) +    // Julian cal
            floorDivide(y, 400) - floorDivide(y, 100) + 2 +   // => Gregorian cal
            DAYS_BEFORE[month + (isLeapYear(year) ? 12 : 0)] + dom; // => month/dom
        return julian - JULIAN_1970_CE; // JD => epoch day
    }

    /**
     * Return the day of week on the 1970-epoch day
     * @param day the 1970-epoch day (integral value)
     * @return the day of week
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.792 -0500", hash_original_method = "C077B4946269706F964CA3940CC4AA2E", hash_generated_method = "AF411624480E64C3111B8156228B8BC3")
    
public static int dayOfWeek(long day) {
        long[] remainder = new long[1];
        floorDivide(day + Calendar.THURSDAY, 7, remainder);
        int dayOfWeek = (int)remainder[0];
        dayOfWeek = (dayOfWeek == 0) ? 7 : dayOfWeek;
        return dayOfWeek;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.796 -0500", hash_original_method = "05CF7463362040B9CA3E2679DDC67965", hash_generated_method = "52BB4F456E1C9A725A87B3184A2FFA89")
    
public static int[] dayToFields(long day, int[] fields) {
        if (fields == null || fields.length < 5) {
            fields = new int[5];
        }
        // Convert from 1970 CE epoch to 1 CE epoch (Gregorian calendar)
        day += JULIAN_1970_CE - JULIAN_1_CE;

        long[] rem = new long[1];
        long n400 = floorDivide(day, 146097, rem);
        long n100 = floorDivide(rem[0], 36524, rem);
        long n4 = floorDivide(rem[0], 1461, rem);
        long n1 = floorDivide(rem[0], 365, rem);

        int year = (int)(400 * n400 + 100 * n100 + 4 * n4 + n1);
        int dayOfYear = (int)rem[0];
        if (n100 == 4 || n1 == 4) {
            dayOfYear = 365;    // Dec 31 at end of 4- or 400-yr cycle
        }
        else {
            ++year;
        }

        boolean isLeap = isLeapYear(year);
        int correction = 0;
        int march1 = isLeap ? 60 : 59;  // zero-based DOY for March 1
        if (dayOfYear >= march1) {
            correction = isLeap ? 1 : 2;
        }
        int month = (12 * (dayOfYear + correction) + 6) / 367;  // zero-based month
        int dayOfMonth = dayOfYear - DAYS_BEFORE[isLeap ? month + 12 : month] + 1; // one-based DOM
        int dayOfWeek = (int)((day + 2) % 7);  // day 0 is Monday(2)
        if (dayOfWeek < 1 /* Sunday */) {
            dayOfWeek += 7;
        }
        dayOfYear++; // 1-based day of year

        fields[0] = year;
        fields[1] = month;
        fields[2] = dayOfMonth;
        fields[3] = dayOfWeek;
        fields[4] = dayOfYear;

        return fields;
    }

    /*
     * Convert long time to date/time fields
     * 
     * result[0] : year
     * result[1] : month
     * result[2] : dayOfMonth
     * result[3] : dayOfWeek
     * result[4] : dayOfYear
     * result[5] : millisecond in day
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.799 -0500", hash_original_method = "64ED8F8372BA45CFBD94DFEC77311CD5", hash_generated_method = "67A26BF0B10A3E97B756D5F161B0CDE0")
    
public static int[] timeToFields(long time, int[] fields) {
        if (fields == null || fields.length < 6) {
            fields = new int[6];
        }
        long[] remainder = new long[1];
        long day = floorDivide(time, 24*60*60*1000 /* milliseconds per day */, remainder);
        dayToFields(day, fields);
        fields[5] = (int)remainder[0];
        return fields;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.802 -0500", hash_original_method = "EFACC3882108925BDAD486676F2CB0C0", hash_generated_method = "4D831AC7904956939A583CA839080A78")
    
public static long floorDivide(long numerator, long denominator) {
        // We do this computation in order to handle
        // a numerator of Long.MIN_VALUE correctly
        return (numerator >= 0) ?
            numerator / denominator :
            ((numerator + 1) / denominator) - 1;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.805 -0500", hash_original_method = "7B5B06C7A3E570E8E507C06240E8B6CC", hash_generated_method = "322295894089126D76740056BE91971A")
    
private static long floorDivide(long numerator, long denominator, long[] remainder) {
        if (numerator >= 0) {
            remainder[0] = numerator % denominator;
            return numerator / denominator;
        }
        long quotient = ((numerator + 1) / denominator) - 1;
        remainder[0] = numerator - (quotient * denominator);
        return quotient;
    }

    /*
     * Returns the ordinal number for the specified day of week in the month.
     * The valid return value is 1, 2, 3, 4 or -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.807 -0500", hash_original_method = "FF736B43F9DDF6F913CCB8CF35622D9B", hash_generated_method = "D418422E8CFB681E2EE996C5BE963A1C")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.754 -0500", hash_original_field = "2AFF2F3D07C8DA5D3689F176D61E30F0", hash_generated_field = "7D64A3FC8737BD139D4A4EC76A162D74")

    public static final long MIN_MILLIS = -184303902528000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.757 -0500", hash_original_field = "54509830DF4C01BB1CC06A613569D81E", hash_generated_field = "AC1B834FE88F5D5F1FE88CDF0E1A7184")

    public static final long MAX_MILLIS = 183882168921600000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.760 -0500", hash_original_field = "9D3905275F611B4F5F0C815F0B8CD030", hash_generated_field = "2EF9C87A008E40D02EA88BD84F8FF273")

    public static final int MILLIS_PER_SECOND = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.762 -0500", hash_original_field = "C84E5855533E75D9D07CE28836631B78", hash_generated_field = "C055A950E29AE0E28E103E4673C5C8AA")

    public static final int MILLIS_PER_MINUTE = 60*MILLIS_PER_SECOND;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.765 -0500", hash_original_field = "8CBED7EEC0C650964B5AED0327E7C686", hash_generated_field = "ADBE5A05CBF815BE08BDC5F808F3D3D5")

    public static final int MILLIS_PER_HOUR = 60*MILLIS_PER_MINUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.768 -0500", hash_original_field = "73121F4395E3855BD6027904ADA0FA00", hash_generated_field = "ECE0514DCAD5F465EEEFC8CE42892C8B")

    public static final int MILLIS_PER_DAY = 24*MILLIS_PER_HOUR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.770 -0500", hash_original_field = "8D627D9941CC5A1A3FDCFBF244555023", hash_generated_field = "BCFDA138E95E3CDA3A60376754F31DE2")

    private static final int JULIAN_1_CE = 1721426;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.773 -0500", hash_original_field = "A5603C401250D06FF6EA5DBF68364FAA", hash_generated_field = "8BEE75A8B21193A98359328B28D2F0CE")

    private static final int JULIAN_1970_CE = 2440588;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.776 -0500", hash_original_field = "E1E59FBF70D5B5F17F1DCC3DB36C8FC9", hash_generated_field = "5D04FF7D45B15A8F30A186F2443B0393")

    private static final int[] MONTH_LENGTH = new int[] {
        31,28,31,30,31,30,31,31,30,31,30,31,
        31,29,31,30,31,30,31,31,30,31,30,31
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.779 -0500", hash_original_field = "03E81969C5843D088353A91115CEE6F7", hash_generated_field = "C612E5CDADBCD3552CCC1FFBA961C5ED")

    private static final int[] DAYS_BEFORE = new int[] {
        0,31,59,90,120,151,181,212,243,273,304,334,
        0,31,60,91,121,152,182,213,244,274,305,335 };
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.494 -0400", hash_original_method = "C0174AAA570C46558C7AC4376248DE88", hash_generated_method = "C0174AAA570C46558C7AC4376248DE88")
    public Grego ()
    {
        //Synthesized constructor
    }
}

