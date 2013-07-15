package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class Grego {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.166 -0400", hash_original_method = "C0174AAA570C46558C7AC4376248DE88", hash_generated_method = "C0174AAA570C46558C7AC4376248DE88")
    public Grego ()
    {
        //Synthesized constructor
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

    
        @DSModeled(DSC.SAFE)
    public static long floorDivide(long numerator, long denominator) {
        return (numerator >= 0) ?
            numerator / denominator :
            ((numerator + 1) / denominator) - 1;
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.170 -0400", hash_original_field = "8EA3B832CD3C302AF52945CC0DE9FBA1", hash_generated_field = "7D64A3FC8737BD139D4A4EC76A162D74")

    public static final long MIN_MILLIS = -184303902528000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.170 -0400", hash_original_field = "6AAA7EC401F32F29B2561AD89856A5D9", hash_generated_field = "AC1B834FE88F5D5F1FE88CDF0E1A7184")

    public static final long MAX_MILLIS = 183882168921600000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.170 -0400", hash_original_field = "5EED10FA88958EB199A2240A28DDEB87", hash_generated_field = "2EF9C87A008E40D02EA88BD84F8FF273")

    public static final int MILLIS_PER_SECOND = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.170 -0400", hash_original_field = "A64BE52066E4629C49F5F48269C68568", hash_generated_field = "C055A950E29AE0E28E103E4673C5C8AA")

    public static final int MILLIS_PER_MINUTE = 60*MILLIS_PER_SECOND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.170 -0400", hash_original_field = "9494A2C33DDCD8C860345014C9C75EBC", hash_generated_field = "ADBE5A05CBF815BE08BDC5F808F3D3D5")

    public static final int MILLIS_PER_HOUR = 60*MILLIS_PER_MINUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.171 -0400", hash_original_field = "A583A1C964FF431E413661B4EA189AF5", hash_generated_field = "ECE0514DCAD5F465EEEFC8CE42892C8B")

    public static final int MILLIS_PER_DAY = 24*MILLIS_PER_HOUR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.171 -0400", hash_original_field = "9A829918B2B504F94AF239579EBB02E6", hash_generated_field = "BCFDA138E95E3CDA3A60376754F31DE2")

    private static final int JULIAN_1_CE = 1721426;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.171 -0400", hash_original_field = "4E54BEDC3EFD999D27A4BE996708AD28", hash_generated_field = "8BEE75A8B21193A98359328B28D2F0CE")

    private static final int JULIAN_1970_CE = 2440588;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.171 -0400", hash_original_field = "D90A64D2D82E10047C40193B92DA90F1", hash_generated_field = "5D04FF7D45B15A8F30A186F2443B0393")

    private static final int[] MONTH_LENGTH = new int[] {
        31,28,31,30,31,30,31,31,30,31,30,31,
        31,29,31,30,31,30,31,31,30,31,30,31
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:10.171 -0400", hash_original_field = "EBD594D20EBDB6E21C2544A127075D09", hash_generated_field = "C612E5CDADBCD3552CCC1FFBA961C5ED")

    private static final int[] DAYS_BEFORE = new int[] {
        0,31,59,90,120,151,181,212,243,273,304,334,
        0,31,60,91,121,152,182,213,244,274,305,335 };
}

