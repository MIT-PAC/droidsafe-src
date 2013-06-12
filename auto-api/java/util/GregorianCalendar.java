package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GregorianCalendar extends Calendar {
    private static final long serialVersionUID = -8125100834729963327L;
    public static final int BC = 0;
    public static final int AD = 1;
    private static final long defaultGregorianCutover = -12219292800000l;
    private long gregorianCutover = defaultGregorianCutover;
    private transient int changeYear = 1582;
    private transient int julianSkew = ((changeYear - 2000) / 400)
            + julianError() - ((changeYear - 2000) / 100);
    static byte[] DaysInMonth = new byte[] { 31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31 };
    private static int[] DaysInYear = new int[] { 0, 31, 59, 90, 120, 151, 181,
            212, 243, 273, 304, 334 };
    private static int[] maximums = new int[] { 1, 292278994, 11, 53, 6, 31,
            366, 7, 6, 1, 11, 23, 59, 59, 999, 14 * 3600 * 1000, 7200000 };
    private static int[] minimums = new int[] { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0,
            0, 0, 0, 0, 0, -13 * 3600 * 1000, 0 };
    private static int[] leastMaximums = new int[] { 1, 292269054, 11, 50, 3,
            28, 355, 7, 3, 1, 11, 23, 59, 59, 999, 50400000, 1200000 };
    private boolean isCached;
    private int[] cachedFields = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    private long nextMidnightMillis = 0L;
    private long lastMidnightMillis = 0L;
    private int currentYearSkew = 10;
    private int lastYearSkew = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.337 -0400", hash_original_method = "7EB3091E87333B7AA987345512812570", hash_generated_method = "95B23C008011C3DCD3F4CF29F5337241")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GregorianCalendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.337 -0400", hash_original_method = "B0762BDDD2B39759F6CE94DB8F25D3E0", hash_generated_method = "35E4012DBFC1F6C82A349E2EA230840A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GregorianCalendar(int year, int month, int day) {
        super(TimeZone.getDefault(), Locale.getDefault());
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        set(year, month, day);
        // ---------- Original Method ----------
        //set(year, month, day);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.337 -0400", hash_original_method = "D6C72587979F1136CC7CF710B2F32D12", hash_generated_method = "7246C20E574E6259176F556778D69DF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GregorianCalendar(int year, int month, int day, int hour, int minute) {
        super(TimeZone.getDefault(), Locale.getDefault());
        dsTaint.addTaint(minute);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        dsTaint.addTaint(hour);
        set(year, month, day, hour, minute);
        // ---------- Original Method ----------
        //set(year, month, day, hour, minute);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.338 -0400", hash_original_method = "BC793B84C6DC2AD69827C6FC0D0FCEDD", hash_generated_method = "CF7B93E35A270062930D348D6825FD27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GregorianCalendar(int year, int month, int day, int hour,
            int minute, int second) {
        super(TimeZone.getDefault(), Locale.getDefault());
        dsTaint.addTaint(minute);
        dsTaint.addTaint(second);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        dsTaint.addTaint(hour);
        set(year, month, day, hour, minute, second);
        // ---------- Original Method ----------
        //set(year, month, day, hour, minute, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.338 -0400", hash_original_method = "63C34121AB8507D7813FBAF0F269A9D2", hash_generated_method = "5ADB36A91D8276884DE1679C906233EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GregorianCalendar(long milliseconds) {
        this(false);
        dsTaint.addTaint(milliseconds);
        setTimeInMillis(milliseconds);
        // ---------- Original Method ----------
        //setTimeInMillis(milliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.338 -0400", hash_original_method = "56E3B8EB09DD30B0731434891C29D1A4", hash_generated_method = "C5FB2A70E3266B335673F0BEEDCE5FA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GregorianCalendar(Locale locale) {
        this(TimeZone.getDefault(), locale);
        dsTaint.addTaint(locale.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.338 -0400", hash_original_method = "7987E4D71BE0DBF5086B038B74101A38", hash_generated_method = "B02AFFF48F569E2A5D059B87CC79F919")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GregorianCalendar(TimeZone timezone) {
        this(timezone, Locale.getDefault());
        dsTaint.addTaint(timezone.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.338 -0400", hash_original_method = "98E484CB97D77C9503930A8DB608CAE2", hash_generated_method = "535D43382999EB0CA7FDCACE65F23B55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GregorianCalendar(TimeZone timezone, Locale locale) {
        super(timezone, locale);
        dsTaint.addTaint(timezone.dsTaint);
        dsTaint.addTaint(locale.dsTaint);
        setTimeInMillis(System.currentTimeMillis());
        // ---------- Original Method ----------
        //setTimeInMillis(System.currentTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.338 -0400", hash_original_method = "0CE38BA4675BDF22B153CA671467EBE6", hash_generated_method = "BE6AABFB406BD262E0EE9933D62F4A17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GregorianCalendar(boolean ignored) {
        super(TimeZone.getDefault());
        dsTaint.addTaint(ignored);
        setFirstDayOfWeek(SUNDAY);
        setMinimalDaysInFirstWeek(1);
        // ---------- Original Method ----------
        //setFirstDayOfWeek(SUNDAY);
        //setMinimalDaysInFirstWeek(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.338 -0400", hash_original_method = "1FE1308881E1142F9D3B7A007897B586", hash_generated_method = "9E1B70BE415F3B73742C547B24503AE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void add(int field, int value) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(value);
        {
            throw new IllegalArgumentException();
        } //End block
        isCached = false;
        {
            complete();
            {
                set(ERA, BC);
            } //End block
            {
                set(ERA, AD);
            } //End block
            complete();
        } //End block
        {
            complete();
            {
                int month;
                month = fields[MONTH] + value;
                {
                    value = (month - 11) / 12;
                    month = 12 + (month % 12);
                } //End block
                {
                    value = month / 12;
                } //End block
                set(MONTH, month % 12);
            } //End block
            set(YEAR, fields[YEAR] + value);
            int days;
            days = daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]);
            {
                set(DATE, days);
            } //End block
            complete();
        } //End block
        long multiplier;
        multiplier = 0;
        getTimeInMillis();
        //Begin case MILLISECOND 
        time += value;
        //End case MILLISECOND 
        //Begin case SECOND 
        time += value * 1000L;
        //End case SECOND 
        //Begin case MINUTE 
        time += value * 60000L;
        //End case MINUTE 
        //Begin case HOUR HOUR_OF_DAY 
        time += value * 3600000L;
        //End case HOUR HOUR_OF_DAY 
        //Begin case AM_PM 
        multiplier = 43200000L;
        //End case AM_PM 
        //Begin case DATE DAY_OF_YEAR DAY_OF_WEEK 
        multiplier = 86400000L;
        //End case DATE DAY_OF_YEAR DAY_OF_WEEK 
        //Begin case WEEK_OF_YEAR WEEK_OF_MONTH DAY_OF_WEEK_IN_MONTH 
        multiplier = 604800000L;
        //End case WEEK_OF_YEAR WEEK_OF_MONTH DAY_OF_WEEK_IN_MONTH 
        {
            areFieldsSet = false;
            complete();
        } //End block
        long delta;
        delta = value * multiplier;
        int zoneOffset;
        zoneOffset = getTimeZone().getRawOffset();
        int offsetBefore;
        offsetBefore = getOffset(time + zoneOffset);
        int offsetAfter;
        offsetAfter = getOffset(time + zoneOffset + delta);
        int dstDelta;
        dstDelta = offsetBefore - offsetAfter;
        {
            boolean var9358D1B1EAE58BFD158E73011F5E9B63_394551666 = (getOffset(time + zoneOffset + delta + dstDelta) == offsetAfter);
            {
                delta += dstDelta;
            } //End block
        } //End collapsed parenthetic
        time += delta;
        areFieldsSet = false;
        complete();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.338 -0400", hash_original_method = "4451E97BB30CB152B3F7FF3125B7AC95", hash_generated_method = "AC1757CCFD06446D8476EF766EFD2AB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        GregorianCalendar thisClone;
        thisClone = (GregorianCalendar) super.clone();
        thisClone.cachedFields = cachedFields.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //GregorianCalendar thisClone = (GregorianCalendar) super.clone();
        //thisClone.cachedFields = cachedFields.clone();
        //return thisClone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.339 -0400", hash_original_method = "005B3A99F85903E106454DD8B0079421", hash_generated_method = "412DF2975B689E525813A05A07BC7A4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void fullFieldsCalc(long timeVal, int millis, int zoneOffset) {
        dsTaint.addTaint(timeVal);
        dsTaint.addTaint(millis);
        dsTaint.addTaint(zoneOffset);
        long days;
        days = timeVal / 86400000;
        {
            millis += 86400000;
            days--;
        } //End block
        millis += zoneOffset;
        {
            millis += 86400000;
            days--;
        } //End block
        {
            millis -= 86400000;
            days++;
        } //End block
        int dayOfYear;
        dayOfYear = computeYearAndDay(days, timeVal + zoneOffset);
        fields[DAY_OF_YEAR] = dayOfYear;
        {
            dayOfYear += currentYearSkew;
        } //End block
        int month;
        month = dayOfYear / 32;
        boolean leapYear;
        leapYear = isLeapYear(fields[YEAR]);
        int date;
        date = dayOfYear - daysInYear(leapYear, month);
        {
            boolean varBCFBCFA689BAE03ACCDE398C77284B61_1154027988 = (date > daysInMonth(leapYear, month));
            {
                date -= daysInMonth(leapYear, month);
                month++;
            } //End block
        } //End collapsed parenthetic
        fields[DAY_OF_WEEK] = mod7(days - 3) + 1;
        int dstOffset;
        dstOffset = 0;
        dstOffset = getTimeZone().getOffset(AD,
                fields[YEAR], month, date, fields[DAY_OF_WEEK], millis);
        {
            dstOffset -= zoneOffset;
        } //End block
        fields[DST_OFFSET] = dstOffset;
        {
            long oldDays;
            oldDays = days;
            millis += dstOffset;
            {
                millis += 86400000;
                days--;
            } //End block
            {
                millis -= 86400000;
                days++;
            } //End block
            {
                dayOfYear = computeYearAndDay(days, timeVal - zoneOffset
                        + dstOffset);
                fields[DAY_OF_YEAR] = dayOfYear;
                {
                    dayOfYear += currentYearSkew;
                } //End block
                month = dayOfYear / 32;
                leapYear = isLeapYear(fields[YEAR]);
                date = dayOfYear - daysInYear(leapYear, month);
                {
                    boolean varFF9B0C37338F3CA779F0DC4C0603FE9D_209544062 = (date > daysInMonth(leapYear, month));
                    {
                        date -= daysInMonth(leapYear, month);
                        month++;
                    } //End block
                } //End collapsed parenthetic
                fields[DAY_OF_WEEK] = mod7(days - 3) + 1;
            } //End block
        } //End block
        fields[MILLISECOND] = (millis % 1000);
        millis /= 1000;
        fields[SECOND] = (millis % 60);
        millis /= 60;
        fields[MINUTE] = (millis % 60);
        millis /= 60;
        fields[HOUR_OF_DAY] = (millis % 24);
        fields[AM_PM] = fields[HOUR_OF_DAY] > 11 ? 1 : 0;
        fields[HOUR] = fields[HOUR_OF_DAY] % 12;
        {
            fields[ERA] = BC;
            fields[YEAR] = -fields[YEAR] + 1;
        } //End block
        {
            fields[ERA] = AD;
        } //End block
        fields[MONTH] = month;
        fields[DATE] = date;
        fields[DAY_OF_WEEK_IN_MONTH] = (date - 1) / 7 + 1;
        fields[WEEK_OF_MONTH] = (date - 1 + mod7(days - date - 2
                - (getFirstDayOfWeek() - 1))) / 7 + 1;
        int daysFromStart;
        daysFromStart = mod7(days - 3 - (fields[DAY_OF_YEAR] - 1)
                - (getFirstDayOfWeek() - 1));
        int week;
        week = (fields[DAY_OF_YEAR] - 1 + daysFromStart) / 7
                + (7 - daysFromStart >= getMinimalDaysInFirstWeek() ? 1 : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart
                    - (isLeapYear(fields[YEAR] - 1) ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 53
                    : 52;
        } //End block
        {
            boolean varE7C3C9E4DCC52FFB6D2FD77C3546E93F_900262647 = (fields[DAY_OF_YEAR] >= (leapYear ? 367 : 366)
                - mod7(daysFromStart + (leapYear ? 2 : 1))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart + (leapYear ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 1
                    : week;
            } //End block
            {
                fields[WEEK_OF_YEAR] = week;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.340 -0400", hash_original_method = "2E866A22E927A34EE822F5C0BBDFB40C", hash_generated_method = "2FB61618B2D95DD180CFF81B70AA5EEB")
    @DSModeled(DSC.SAFE)
    private final void cachedFieldsCheckAndGet(long timeVal,
            long newTimeMillis, long newTimeMillisAdjusted, int millis,
            int zoneOffset) {
        dsTaint.addTaint(newTimeMillis);
        dsTaint.addTaint(newTimeMillisAdjusted);
        dsTaint.addTaint(timeVal);
        dsTaint.addTaint(millis);
        dsTaint.addTaint(zoneOffset);
        int dstOffset;
        dstOffset = fields[DST_OFFSET];
        {
            fullFieldsCalc(timeVal, millis, zoneOffset);
            isCached = false;
        } //End block
        {
            fields[YEAR] = cachedFields[0];
            fields[MONTH] = cachedFields[1];
            fields[DATE] = cachedFields[2];
            fields[DAY_OF_WEEK] = cachedFields[3];
            fields[ERA] = cachedFields[5];
            fields[WEEK_OF_YEAR] = cachedFields[6];
            fields[WEEK_OF_MONTH] = cachedFields[7];
            fields[DAY_OF_YEAR] = cachedFields[8];
            fields[DAY_OF_WEEK_IN_MONTH] = cachedFields[9];
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.340 -0400", hash_original_method = "B0DF08CEBB1EE730F98FF9762C9FEBD4", hash_generated_method = "F7099062B5161D4BE588E8365FE541C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void computeFields() {
        TimeZone timeZone;
        timeZone = getTimeZone();
        int dstOffset;
        boolean var7227D111493F5C9AE3EFCCBBD3DA3A95_1194127764 = (timeZone.inDaylightTime(new Date(time)));
        dstOffset = timeZone.getDSTSavings();
        dstOffset = 0;
        int zoneOffset;
        zoneOffset = timeZone.getRawOffset();
        fields[DST_OFFSET] = dstOffset;
        fields[ZONE_OFFSET] = zoneOffset;
        int millis;
        millis = (int) (time % 86400000);
        int savedMillis;
        savedMillis = millis;
        int offset;
        offset = zoneOffset + dstOffset;
        long newTime;
        newTime = time + offset;
        {
            newTime = 0x7fffffffffffffffL;
        } //End block
        {
            newTime = 0x8000000000000000L;
        } //End block
        {
            {
                millis += 86400000;
            } //End block
            millis += zoneOffset;
            millis += dstOffset;
            {
                millis += 86400000;
            } //End block
            {
                millis -= 86400000;
            } //End block
            fields[MILLISECOND] = (millis % 1000);
            millis /= 1000;
            fields[SECOND] = (millis % 60);
            millis /= 60;
            fields[MINUTE] = (millis % 60);
            millis /= 60;
            fields[HOUR_OF_DAY] = (millis % 24);
            millis /= 24;
            fields[AM_PM] = fields[HOUR_OF_DAY] > 11 ? 1 : 0;
            fields[HOUR] = fields[HOUR_OF_DAY] % 12;
            long newTimeAdjusted;
            newTimeAdjusted = newTime;
            {
                boolean varC91B9F9D8FA1076E10F0661EFE1DB41B_505908060 = (timeZone.useDaylightTime());
                {
                    int dstSavings;
                    dstSavings = timeZone.getDSTSavings();
                    newTimeAdjusted += (dstOffset == 0) ? dstSavings : -dstSavings;
                } //End block
            } //End collapsed parenthetic
            {
                newTimeAdjusted = 0x7fffffffffffffffL;
            } //End block
            {
                newTimeAdjusted = 0x8000000000000000L;
            } //End block
            cachedFieldsCheckAndGet(time, newTime, newTimeAdjusted,
                    savedMillis, zoneOffset);
        } //End block
        {
            fullFieldsCalc(time, savedMillis, zoneOffset);
        } //End block
        {
            int i;
            i = 0;
            {
                isSet[i] = true;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9612C0EF2FD4C7A52D997E0A251788F4_546701125 = (!isCached
                && newTime != 0x7fffffffffffffffL
                && newTime != 0x8000000000000000L
                && (!timeZone.useDaylightTime() || timeZone instanceof SimpleTimeZone));
            {
                int cacheMillis;
                cacheMillis = 0;
                cachedFields[0] = fields[YEAR];
                cachedFields[1] = fields[MONTH];
                cachedFields[2] = fields[DATE];
                cachedFields[3] = fields[DAY_OF_WEEK];
                cachedFields[4] = zoneOffset;
                cachedFields[5] = fields[ERA];
                cachedFields[6] = fields[WEEK_OF_YEAR];
                cachedFields[7] = fields[WEEK_OF_MONTH];
                cachedFields[8] = fields[DAY_OF_YEAR];
                cachedFields[9] = fields[DAY_OF_WEEK_IN_MONTH];
                cacheMillis += (23 - fields[HOUR_OF_DAY]) * 60 * 60 * 1000;
                cacheMillis += (59 - fields[MINUTE]) * 60 * 1000;
                cacheMillis += (59 - fields[SECOND]) * 1000;
                nextMidnightMillis = newTime + cacheMillis;
                cacheMillis = fields[HOUR_OF_DAY] * 60 * 60 * 1000;
                cacheMillis += fields[MINUTE] * 60 * 1000;
                cacheMillis += fields[SECOND] * 1000;
                lastMidnightMillis = newTime - cacheMillis;
                isCached = true;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.342 -0400", hash_original_method = "2C41A89AB92A41E731883E58EB4B865A", hash_generated_method = "32B20602A32B0F1BD5DC80ACFA234D68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void computeTime() {
        {
            boolean varFACDFEC6F69DADFC305CEE68F7E56304_658280687 = (!isLenient());
            {
                {
                    {
                        throw new IllegalArgumentException();
                    } //End block
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
                {
                    {
                        throw new IllegalArgumentException();
                    } //End block
                    {
                        throw new IllegalArgumentException();
                    } //End block
                } //End block
                {
                    throw new IllegalArgumentException();
                } //End block
            } //End block
        } //End collapsed parenthetic
        long timeVal;
        long hour;
        hour = 0;
        {
            hour = fields[HOUR_OF_DAY];
        } //End block
        {
            hour = (fields[AM_PM] * 12) + fields[HOUR];
        } //End block
        timeVal = hour * 3600000;
        {
            timeVal += ((long) fields[MINUTE]) * 60000;
        } //End block
        {
            timeVal += ((long) fields[SECOND]) * 1000;
        } //End block
        {
            timeVal += fields[MILLISECOND];
        } //End block
        long days;
        int year;
        year = fields[YEAR];
        year = 1970;
        {
            {
                throw new IllegalArgumentException();
            } //End block
            {
                year = 1 - year;
            } //End block
        } //End block
        boolean weekMonthSet;
        weekMonthSet = isSet[WEEK_OF_MONTH]
                || isSet[DAY_OF_WEEK_IN_MONTH];
        boolean useMonth;
        useMonth = (isSet[DATE] || isSet[MONTH] || weekMonthSet)
                && lastDateFieldSet != DAY_OF_YEAR;
        {
            {
                useMonth = lastDateFieldSet != WEEK_OF_YEAR && weekMonthSet
                        && isSet[DAY_OF_WEEK];
            } //End block
            {
                useMonth = isSet[DATE] && isSet[MONTH];
            } //End block
        } //End block
        {
            int month;
            month = fields[MONTH];
            year += month / 12;
            month %= 12;
            {
                year--;
                month += 12;
            } //End block
            boolean leapYear;
            leapYear = isLeapYear(year);
            days = daysFromBaseYear(year) + daysInYear(leapYear, month);
            boolean useDate;
            useDate = isSet[DATE];
            {
                useDate = !(isSet[DAY_OF_WEEK] && weekMonthSet);
            } //End block
            {
                {
                    boolean varAD72E57B80110245423B5A8B5FE79293_2039705735 = (!isLenient()
                        && (fields[DATE] < 1 || fields[DATE] > daysInMonth(
                                leapYear, month)));
                    {
                        throw new IllegalArgumentException();
                    } //End block
                } //End collapsed parenthetic
                days += fields[DATE] - 1;
            } //End block
            {
                int dayOfWeek;
                {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } //End block
                {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                } //End block
                {
                    int skew;
                    skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += (fields[WEEK_OF_MONTH] - 1) * 7
                            + mod7(skew + dayOfWeek - (days - 3)) - skew;
                } //End block
                {
                    {
                        days += mod7(dayOfWeek - (days - 3))
                                + (fields[DAY_OF_WEEK_IN_MONTH] - 1) * 7;
                    } //End block
                    {
                        days += daysInMonth(leapYear, month)
                                + mod7(dayOfWeek
                                        - (days + daysInMonth(leapYear, month) - 3))
                                + fields[DAY_OF_WEEK_IN_MONTH] * 7;
                    } //End block
                } //End block
                {
                    int skew;
                    skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += mod7(mod7(skew + dayOfWeek - (days - 3)) - skew);
                } //End block
            } //End block
        } //End block
        {
            boolean useWeekYear;
            useWeekYear = isSet[WEEK_OF_YEAR]
                    && lastDateFieldSet != DAY_OF_YEAR;
            {
                useWeekYear = isSet[DAY_OF_WEEK];
            } //End block
            days = daysFromBaseYear(year);
            {
                int dayOfWeek;
                {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } //End block
                {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                } //End block
                int skew;
                skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                days += (fields[WEEK_OF_YEAR] - 1) * 7
                        + mod7(skew + dayOfWeek - (days - 3)) - skew;
                {
                    boolean varE26E43FD9372BC0247AD2F35115E53C0_27160895 = (7 - skew < getMinimalDaysInFirstWeek());
                    {
                        days += 7;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var5E54B386391C54C1445EC2DD47905BC4_458291964 = (!isLenient()
                        && (fields[DAY_OF_YEAR] < 1 || fields[DAY_OF_YEAR] > (365 + (isLeapYear(year) ? 1
                                : 0)))); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        throw new IllegalArgumentException();
                    } //End block
                } //End collapsed parenthetic
                days += fields[DAY_OF_YEAR] - 1;
            } //End block
            {
                days += mod7(fields[DAY_OF_WEEK] - 1 - (days - 3));
            } //End block
        } //End block
        lastDateFieldSet = 0;
        timeVal += days * 86400000;
        {
            boolean var4521363AC2DA99125953BA39F1463F28_888899476 = (year == changeYear
                && timeVal >= gregorianCutover + julianError() * 86400000L);
            {
                timeVal -= julianError() * 86400000L;
            } //End block
        } //End collapsed parenthetic
        long timeValWithoutDST;
        timeValWithoutDST = timeVal - getOffset(timeVal)
                + getTimeZone().getRawOffset();
        timeVal -= getOffset(timeValWithoutDST);
        this.time = timeVal;
        {
            computeFields();
            areFieldsSet = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.342 -0400", hash_original_method = "2A644CA75A846A9F294F6A7DE0BAB232", hash_generated_method = "1A1258D4D7639D01C253F4CCF5D61024")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int computeYearAndDay(long dayCount, long localTime) {
        dsTaint.addTaint(localTime);
        dsTaint.addTaint(dayCount);
        int year;
        year = 1970;
        long days;
        days = dayCount;
        {
            days -= julianSkew;
        } //End block
        int approxYears;
        {
            boolean varA0C372859F6CDCA7B1B6C2DB149AE991_567846570 = ((approxYears = (int) (days / 365)) != 0);
            {
                year = year + approxYears;
                days = dayCount - daysFromBaseYear(year);
            } //End block
        } //End collapsed parenthetic
        {
            year = year - 1;
            days = days + daysInYear(year);
        } //End block
        fields[YEAR] = year;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int year = 1970;
        //long days = dayCount;
        //if (localTime < gregorianCutover) {
            //days -= julianSkew;
        //}
        //int approxYears;
        //while ((approxYears = (int) (days / 365)) != 0) {
            //year = year + approxYears;
            //days = dayCount - daysFromBaseYear(year);
        //}
        //if (days < 0) {
            //year = year - 1;
            //days = days + daysInYear(year);
        //}
        //fields[YEAR] = year;
        //return (int) days + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.342 -0400", hash_original_method = "975CAA178CB1C52E2022FF53CD13129C", hash_generated_method = "1E0331620B7CB3E93B659D1AA1D65FE7")
    @DSModeled(DSC.SAFE)
    private long daysFromBaseYear(int iyear) {
        dsTaint.addTaint(iyear);
        long year;
        year = iyear;
        {
            long days;
            days = (year - 1970) * 365 + ((year - 1969) / 4);
            {
                days -= ((year - 1901) / 100) - ((year - 1601) / 400);
            } //End block
            {
                {
                    days += currentYearSkew;
                } //End block
                {
                    days += lastYearSkew;
                } //End block
                {
                    days += julianSkew;
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long year = iyear;
        //if (year >= 1970) {
            //long days = (year - 1970) * 365 + ((year - 1969) / 4);
            //if (year > changeYear) {
                //days -= ((year - 1901) / 100) - ((year - 1601) / 400);
            //} else {
                //if(year == changeYear){
                    //days += currentYearSkew;
                //}else if(year == changeYear -1){
                    //days += lastYearSkew;
                //}else{
                    //days += julianSkew;
                //}
            //}
            //return days;
        //} else if (year <= changeYear) {
            //return (year - 1970) * 365 + ((year - 1972) / 4) + julianSkew;
        //}
        //return (year - 1970) * 365 + ((year - 1972) / 4)
                //- ((year - 2000) / 100) + ((year - 2000) / 400);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "B393AFA9309B3ECCDD74469F481095BD", hash_generated_method = "A4CCD941D2668EA92B9FA8A8575CFB4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int daysInMonth() {
        int varE318A98C4AE10FD73CDBBCD84B832D8D_1185664109 = (daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "F030460418FCB84947C9AD9647C8CF35", hash_generated_method = "6ABEB4DDB5CD260B0421229D9EE48B7E")
    @DSModeled(DSC.SAFE)
    private int daysInMonth(boolean leapYear, int month) {
        dsTaint.addTaint(month);
        dsTaint.addTaint(leapYear);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (leapYear && month == FEBRUARY) {
            //return DaysInMonth[month] + 1;
        //}
        //return DaysInMonth[month];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "643B799339D2A3831DACB9C12752109A", hash_generated_method = "1F14B1269D91053A657F9E14A9A8930F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int daysInYear(int year) {
        dsTaint.addTaint(year);
        int daysInYear;
        boolean var806EDE1361E2163FF12E03ABFE47D72B_556769560 = (isLeapYear(year));
        daysInYear = 366;
        daysInYear = 365;
        {
            daysInYear -= currentYearSkew;
        } //End block
        {
            daysInYear -= lastYearSkew;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int daysInYear = isLeapYear(year) ? 366 : 365;
        //if (year == changeYear) {
            //daysInYear -= currentYearSkew;
        //}
        //if (year == changeYear - 1) {
            //daysInYear -= lastYearSkew;
        //}
        //return daysInYear;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "7E255F605E98F52E53144D7126E773F6", hash_generated_method = "14B5533A090938A9AB4BA153000FA424")
    @DSModeled(DSC.SAFE)
    private int daysInYear(boolean leapYear, int month) {
        dsTaint.addTaint(month);
        dsTaint.addTaint(leapYear);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (leapYear && month > FEBRUARY) {
            //return DaysInYear[month] + 1;
        //}
        //return DaysInYear[month];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "61C11EDCA3B03978A14421C2440916AB", hash_generated_method = "F8141873F51CC3B8E5E6CA15A2A0390A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var37CB9CE3CFC322844A11D9381BF57718_367995721 = (super.equals(object)
                && gregorianCutover == ((GregorianCalendar) object).gregorianCutover);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(object instanceof GregorianCalendar)) {
            //return false;
        //}
        //if (object == this) {
            //return true;
        //}
        //return super.equals(object)
                //&& gregorianCutover == ((GregorianCalendar) object).gregorianCutover;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "F6A8281F341CD14B238EE5FA427449C3", hash_generated_method = "7C3EB7DD22028B9A07B49A2EF6D15159")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getActualMaximum(int field) {
        dsTaint.addTaint(field);
        int value;
        {
            boolean varF889B32F8A6F0D9644F5182C32B821CC_179035862 = ((value = maximums[field]) == leastMaximums[field]);
        } //End collapsed parenthetic
        //Begin case WEEK_OF_YEAR WEEK_OF_MONTH 
        isCached = false;
        //End case WEEK_OF_YEAR WEEK_OF_MONTH 
        complete();
        long orgTime;
        orgTime = time;
        int result;
        result = 0;
        //Begin case WEEK_OF_YEAR 
        set(DATE, 31);
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        set(MONTH, DECEMBER);
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        result = get(WEEK_OF_YEAR);
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        {
            set(DATE, 31 - 7);
            result = get(WEEK_OF_YEAR);
        } //End block
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        areFieldsSet = false;
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_MONTH 
        set(DATE, daysInMonth());
        //End case WEEK_OF_MONTH 
        //Begin case WEEK_OF_MONTH 
        result = get(WEEK_OF_MONTH);
        //End case WEEK_OF_MONTH 
        //Begin case WEEK_OF_MONTH 
        areFieldsSet = false;
        //End case WEEK_OF_MONTH 
        //Begin case DATE 
        int var5CFABCF07DB75122C7B613B74C3A77A0_232020824 = (daysInMonth());
        //End case DATE 
        //Begin case DAY_OF_YEAR 
        int var0AC5B37CA37BB4CB746E2A8A2E3240E0_82692304 = (daysInYear(fields[YEAR]));
        //End case DAY_OF_YEAR 
        //Begin case DAY_OF_WEEK_IN_MONTH 
        result = get(DAY_OF_WEEK_IN_MONTH)
                        + ((daysInMonth() - get(DATE)) / 7);
        //End case DAY_OF_WEEK_IN_MONTH 
        //Begin case YEAR 
        GregorianCalendar clone;
        clone = (GregorianCalendar) clone();
        //End case YEAR 
        //Begin case YEAR 
        {
            boolean varB09F384FEFE292415D2A5D3359C67CC8_1807488974 = (get(ERA) == AD);
            {
                clone.setTimeInMillis(Long.MAX_VALUE);
            } //End block
            {
                clone.setTimeInMillis(Long.MIN_VALUE);
            } //End block
        } //End collapsed parenthetic
        //End case YEAR 
        //Begin case YEAR 
        result = clone.get(YEAR);
        //End case YEAR 
        //Begin case YEAR 
        clone.set(YEAR, get(YEAR));
        //End case YEAR 
        //Begin case YEAR 
        {
            boolean var67E7F62106250BA6B0F4638123528C99_689562623 = (clone.before(this));
            {
                result--;
            } //End block
        } //End collapsed parenthetic
        //End case YEAR 
        //Begin case DST_OFFSET 
        result = getMaximum(DST_OFFSET);
        //End case DST_OFFSET 
        time = orgTime;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "0094646504037C44C448A8626AEC2CA3", hash_generated_method = "10DC7BD4D701218359F80591F27B21DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getActualMinimum(int field) {
        dsTaint.addTaint(field);
        int var5E6945756F684C789AC7D19DD344C7B7_730119205 = (getMinimum(field));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMinimum(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "F3CD156C4D2759DEA34A15A000EAB551", hash_generated_method = "95AE167106F9ED2D7A20E3A5169E3DEE")
    @DSModeled(DSC.SAFE)
    @Override
    public int getGreatestMinimum(int field) {
        dsTaint.addTaint(field);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minimums[field];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.343 -0400", hash_original_method = "BD206861177D272D9EC33433339CB64F", hash_generated_method = "9BD694324037E6E487F8D54C25E97E39")
    @DSModeled(DSC.SAFE)
    public final Date getGregorianChange() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Date(gregorianCutover);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "3B0100990EBACC07D6E54BAA89A3102A", hash_generated_method = "A37F93B4B541497ACD8E684B952D3A62")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLeastMaximum(int field) {
        dsTaint.addTaint(field);
        {
            long currentTimeInMillis;
            currentTimeInMillis = time;
            setTimeInMillis(gregorianCutover);
            int actual;
            actual = getActualMaximum(field);
            setTimeInMillis(currentTimeInMillis);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (gregorianCutover != defaultGregorianCutover
                //&& field == WEEK_OF_YEAR) {
            //long currentTimeInMillis = time;
            //setTimeInMillis(gregorianCutover);
            //int actual = getActualMaximum(field);
            //setTimeInMillis(currentTimeInMillis);
            //return actual;
        //}
        //return leastMaximums[field];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "80794FF1ED1E8F2177114BCAA53EED59", hash_generated_method = "6B5CAE5E596DCCAE5D15D8AA14EFF9EB")
    @DSModeled(DSC.SAFE)
    @Override
    public int getMaximum(int field) {
        dsTaint.addTaint(field);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximums[field];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "1A09A14EE8971B3B0503081305AF18CB", hash_generated_method = "0A2695BE4941EE961A8412531AF25895")
    @DSModeled(DSC.SAFE)
    @Override
    public int getMinimum(int field) {
        dsTaint.addTaint(field);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minimums[field];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "A5F3F970AF018D82525827EF3879E8F1", hash_generated_method = "6E22E1C1CE364782C30A46A509EC4E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getOffset(long localTime) {
        dsTaint.addTaint(localTime);
        TimeZone timeZone;
        timeZone = getTimeZone();
        long dayCount;
        dayCount = localTime / 86400000;
        int millis;
        millis = (int) (localTime % 86400000);
        {
            millis += 86400000;
            dayCount--;
        } //End block
        int year;
        year = 1970;
        long days;
        days = dayCount;
        {
            days -= julianSkew;
        } //End block
        int approxYears;
        {
            boolean varA0C372859F6CDCA7B1B6C2DB149AE991_696155368 = ((approxYears = (int) (days / 365)) != 0);
            {
                year = year + approxYears;
                days = dayCount - daysFromBaseYear(year);
            } //End block
        } //End collapsed parenthetic
        {
            year = year - 1;
            days = days + 365 + (isLeapYear(year) ? 1 : 0);
            {
                days -= julianError();
            } //End block
        } //End block
        {
            int var83195CF641F8AED9D4B81C2528687249_2046564242 = (timeZone.getRawOffset());
        } //End block
        int dayOfYear;
        dayOfYear = (int) days + 1;
        int month;
        month = dayOfYear / 32;
        boolean leapYear;
        leapYear = isLeapYear(year);
        int date;
        date = dayOfYear - daysInYear(leapYear, month);
        {
            boolean varBCFBCFA689BAE03ACCDE398C77284B61_651478812 = (date > daysInMonth(leapYear, month));
            {
                date -= daysInMonth(leapYear, month);
                month++;
            } //End block
        } //End collapsed parenthetic
        int dayOfWeek;
        dayOfWeek = mod7(dayCount - 3) + 1;
        int offset;
        offset = timeZone.getOffset(AD, year, month, date, dayOfWeek,
                millis);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "6907F2ED2DF57E219AB70EADED509565", hash_generated_method = "7C32203CD5DD8E8EA7052168AF5A9922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var692CE3A7B5A5A51EE98F7911213C9198_60518908 = (super.hashCode()
                + ((int) (gregorianCutover >>> 32) ^ (int) gregorianCutover));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.hashCode()
                //+ ((int) (gregorianCutover >>> 32) ^ (int) gregorianCutover);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "FD1210B9D1DAC87CC2975B1EB57E42AE", hash_generated_method = "DCDF0182FDCA2D014CE3E815887C48D2")
    @DSModeled(DSC.SAFE)
    public boolean isLeapYear(int year) {
        dsTaint.addTaint(year);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (year > changeYear) {
            //return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        //}
        //return year % 4 == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "6792E5EC134CCE3576D348D7664F192E", hash_generated_method = "5944CB417BF3CA9172F7BB551AF7F778")
    @DSModeled(DSC.SAFE)
    private int julianError() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return changeYear / 100 - changeYear / 400 - 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "C7B77E5A8B6CB394A26ACFDB4CA2A34C", hash_generated_method = "170D997152F156A6069B4B234261BA4C")
    @DSModeled(DSC.SAFE)
    private int mod(int value, int mod) {
        dsTaint.addTaint(mod);
        dsTaint.addTaint(value);
        int rem;
        rem = value % mod;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int rem = value % mod;
        //if (value < 0 && rem < 0) {
            //return rem + mod;
        //}
        //return rem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.344 -0400", hash_original_method = "B5B6FCF50F48D18673AA227255C5F0A5", hash_generated_method = "63A872B1CB44C26398C640A815317DD0")
    @DSModeled(DSC.SAFE)
    private int mod7(long num1) {
        dsTaint.addTaint(num1);
        int rem;
        rem = (int) (num1 % 7);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int rem = (int) (num1 % 7);
        //if (num1 < 0 && rem < 0) {
            //return rem + 7;
        //}
        //return rem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.345 -0400", hash_original_method = "B265969ED1D5B160D0AFF42D0A073F4D", hash_generated_method = "A4DC97AB10082B2DD02A4D5FB9A549A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void roll(int field, int value) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(value);
        {
            throw new IllegalArgumentException();
        } //End block
        isCached = false;
        complete();
        int days, day, mod, maxWeeks, newWeek;
        int max;
        max = -1;
        //Begin case YEAR 
        max = maximums[field];
        //End case YEAR 
        //Begin case WEEK_OF_YEAR 
        days = daysInYear(fields[YEAR]);
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        day = DAY_OF_YEAR;
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        mod = mod7(fields[DAY_OF_WEEK] - fields[day]
                    - (getFirstDayOfWeek() - 1));
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        maxWeeks = (days - 1 + mod) / 7 + 1;
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        newWeek = mod(fields[field] - 1 + value, maxWeeks) + 1;
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_YEAR 
        {
            int addDays;
            addDays = (newWeek - fields[field]) * 7;
            {
                set(field, 1);
            } //End block
            {
                set(field, newWeek - 1);
            } //End block
        } //End block
        {
            int week;
            week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
            {
                set(field, 1);
            } //End block
            {
                set(field, newWeek);
            } //End block
        } //End block
        {
            set(field, newWeek);
        } //End block
        //End case WEEK_OF_YEAR 
        //Begin case WEEK_OF_MONTH 
        days = daysInMonth();
        //End case WEEK_OF_MONTH 
        //Begin case WEEK_OF_MONTH 
        day = DATE;
        //End case WEEK_OF_MONTH 
        //Begin case WEEK_OF_MONTH 
        mod = mod7(fields[DAY_OF_WEEK] - fields[day]
                    - (getFirstDayOfWeek() - 1));
        //End case WEEK_OF_MONTH 
        //Begin case WEEK_OF_MONTH 
        maxWeeks = (days - 1 + mod) / 7 + 1;
        //End case WEEK_OF_MONTH 
        //Begin case WEEK_OF_MONTH 
        newWeek = mod(fields[field] - 1 + value, maxWeeks) + 1;
        //End case WEEK_OF_MONTH 
        //Begin case WEEK_OF_MONTH 
        {
            {
                set(day, days);
            } //End block
            {
                set(field, newWeek);
            } //End block
        } //End block
        {
            int week;
            week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
            {
                set(day, 1);
            } //End block
            {
                set(field, newWeek);
            } //End block
        } //End block
        {
            set(field, newWeek);
        } //End block
        //End case WEEK_OF_MONTH 
        //Begin case DATE 
        max = daysInMonth();
        //End case DATE 
        //Begin case DAY_OF_YEAR 
        max = daysInYear(fields[YEAR]);
        //End case DAY_OF_YEAR 
        //Begin case DAY_OF_WEEK 
        max = maximums[field];
        //End case DAY_OF_WEEK 
        //Begin case DAY_OF_WEEK 
        lastDateFieldSet = WEEK_OF_MONTH;
        //End case DAY_OF_WEEK 
        //Begin case DAY_OF_WEEK_IN_MONTH 
        max = (fields[DATE] + ((daysInMonth() - fields[DATE]) / 7 * 7) - 1) / 7 + 1;
        //End case DAY_OF_WEEK_IN_MONTH 
        //Begin case ERA MONTH AM_PM HOUR HOUR_OF_DAY MINUTE SECOND MILLISECOND 
        set(field, mod(fields[field] + value, maximums[field] + 1));
        //End case ERA MONTH AM_PM HOUR HOUR_OF_DAY MINUTE SECOND MILLISECOND 
        //Begin case ERA MONTH AM_PM HOUR HOUR_OF_DAY MINUTE SECOND MILLISECOND 
        {
            boolean var996091B13023E8401BC1CAC33664D345_2120420653 = (field == MONTH && fields[DATE] > daysInMonth());
            {
                set(DATE, daysInMonth());
            } //End block
            {
                lastTimeFieldSet = HOUR;
            } //End block
        } //End collapsed parenthetic
        //End case ERA MONTH AM_PM HOUR HOUR_OF_DAY MINUTE SECOND MILLISECOND 
        {
            set(field, mod(fields[field] - 1 + value, max) + 1);
        } //End block
        complete();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.345 -0400", hash_original_method = "011BFEF6AF7823592586BFF14A1F0FAF", hash_generated_method = "557FD4A7844791AE6B3E403904901404")
    @DSModeled(DSC.SAFE)
    @Override
    public void roll(int field, boolean increment) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(increment);
        roll(field, increment ? 1 : -1);
        // ---------- Original Method ----------
        //roll(field, increment ? 1 : -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.346 -0400", hash_original_method = "BBA926F39AADCD3D723F5CC72B7A16F3", hash_generated_method = "EDBA6D03AB1632BD75D1468F351FF587")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGregorianChange(Date date) {
        dsTaint.addTaint(date.dsTaint);
        gregorianCutover = date.getTime();
        GregorianCalendar cal;
        cal = new GregorianCalendar(TimeZone.GMT);
        cal.setTime(date);
        changeYear = cal.get(YEAR);
        {
            boolean var6B3F925C21EB7C0091F9A66AE842BD58_1779556214 = (cal.get(ERA) == BC);
            {
                changeYear = 1 - changeYear;
            } //End block
        } //End collapsed parenthetic
        julianSkew = ((changeYear - 2000) / 400) + julianError()
                - ((changeYear - 2000) / 100);
        isCached = false;
        int dayOfYear;
        dayOfYear = cal.get(DAY_OF_YEAR);
        {
            currentYearSkew = dayOfYear-1;
            lastYearSkew = julianSkew - dayOfYear + 1;
        } //End block
        {
            lastYearSkew = 0;
            currentYearSkew = julianSkew;
        } //End block
        isCached = false;
        // ---------- Original Method ----------
        //gregorianCutover = date.getTime();
        //GregorianCalendar cal = new GregorianCalendar(TimeZone.GMT);
        //cal.setTime(date);
        //changeYear = cal.get(YEAR);
        //if (cal.get(ERA) == BC) {
            //changeYear = 1 - changeYear;
        //}
        //julianSkew = ((changeYear - 2000) / 400) + julianError()
                //- ((changeYear - 2000) / 100);
        //isCached = false;
        //int dayOfYear = cal.get(DAY_OF_YEAR);
        //if (dayOfYear < julianSkew) {
            //currentYearSkew = dayOfYear-1;
            //lastYearSkew = julianSkew - dayOfYear + 1;
        //} else {
            //lastYearSkew = 0;
            //currentYearSkew = julianSkew;
        //}
        //isCached = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.346 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "30618BF31E3EF9B57496D830B4496A05")
    @DSModeled(DSC.SAFE)
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.346 -0400", hash_original_method = "6812E7459A56AAC638E0A1455D3A3623", hash_generated_method = "7B57F65846BE78D95D3495A4AA8E2731")
    @DSModeled(DSC.SAFE)
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        setGregorianChange(new Date(gregorianCutover));
        isCached = false;
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //setGregorianChange(new Date(gregorianCutover));
        //isCached = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.346 -0400", hash_original_method = "803EF27234E46811EE9F1109A1277F23", hash_generated_method = "EBACC9C393C383D7AD4781E044B98D9D")
    @DSModeled(DSC.SAFE)
    @Override
    public void setFirstDayOfWeek(int value) {
        dsTaint.addTaint(value);
        super.setFirstDayOfWeek(value);
        isCached = false;
        // ---------- Original Method ----------
        //super.setFirstDayOfWeek(value);
        //isCached = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.346 -0400", hash_original_method = "77A4B23D11FEBAAF4DA5B074DBE88F4F", hash_generated_method = "DDA7BC32D1FF3BD7620E2E441BF8B0D3")
    @DSModeled(DSC.SAFE)
    @Override
    public void setMinimalDaysInFirstWeek(int value) {
        dsTaint.addTaint(value);
        super.setMinimalDaysInFirstWeek(value);
        isCached = false;
        // ---------- Original Method ----------
        //super.setMinimalDaysInFirstWeek(value);
        //isCached = false;
    }

    
}


