package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GregorianCalendar extends Calendar {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "400857AF5F099B78A86D8F68DDA6A04C", hash_generated_field = "EA14FB63AF074345B169453863E64EC4")

    private long gregorianCutover = defaultGregorianCutover;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "2237A6A77C737B6DE347542050A70C16", hash_generated_field = "A0B8CA27149DD74350CDB7EC98C60162")

    private transient int changeYear = 1582;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "B31858CD0ADA5C474F1168521920B10A", hash_generated_field = "2808C9DD640CD873EE96A55ECDBB8D85")

    private transient int julianSkew = ((changeYear - 2000) / 400)
            + julianError() - ((changeYear - 2000) / 100);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "4B7219F27A11B1E89794219BC39393A8")

    private boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "48BDECEAC3EC7DF64DC015EE1647B63D", hash_generated_field = "7AF7C45B7A2B45D012327222457CC902")

    private int[] cachedFields = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "29BEE66E54150507B1EAE04F51499A76", hash_generated_field = "EAB4464060441E8E83529F625B8AC792")

    private long nextMidnightMillis = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "48A2AA6D81A9C01929B5C02CE7D1A7AD", hash_generated_field = "A139545ACF978509DA3F6AC55F657D39")

    private long lastMidnightMillis = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "4C645BB4AD56D54A8545F69CF4FCB94D", hash_generated_field = "657D9B61D3147BAB9300368D7E5B963D")

    private int currentYearSkew = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.812 -0400", hash_original_field = "DEFBAD132BF50B6929249287EA3B13E8", hash_generated_field = "A15FC9D51CCB159121982FD9BA383E19")

    private int lastYearSkew = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.813 -0400", hash_original_method = "7EB3091E87333B7AA987345512812570", hash_generated_method = "2E973698D04F2D2AAC57C914B74CED19")
    public  GregorianCalendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.813 -0400", hash_original_method = "B0762BDDD2B39759F6CE94DB8F25D3E0", hash_generated_method = "38C410E1E84735BCAF765E289021E81F")
    public  GregorianCalendar(int year, int month, int day) {
        super(TimeZone.getDefault(), Locale.getDefault());
        set(year, month, day);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.813 -0400", hash_original_method = "D6C72587979F1136CC7CF710B2F32D12", hash_generated_method = "EA61E3E225080418066B88D07BFAD1D5")
    public  GregorianCalendar(int year, int month, int day, int hour, int minute) {
        super(TimeZone.getDefault(), Locale.getDefault());
        set(year, month, day, hour, minute);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.813 -0400", hash_original_method = "BC793B84C6DC2AD69827C6FC0D0FCEDD", hash_generated_method = "2833CF81C00C74E618FF92AEF4964939")
    public  GregorianCalendar(int year, int month, int day, int hour,
            int minute, int second) {
        super(TimeZone.getDefault(), Locale.getDefault());
        set(year, month, day, hour, minute, second);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.813 -0400", hash_original_method = "63C34121AB8507D7813FBAF0F269A9D2", hash_generated_method = "36CC83BD8666C1DCDE0C708A8A92983C")
      GregorianCalendar(long milliseconds) {
        this(false);
        setTimeInMillis(milliseconds);
        addTaint(milliseconds);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.814 -0400", hash_original_method = "56E3B8EB09DD30B0731434891C29D1A4", hash_generated_method = "4EF55C9A9234380F5CABEBE8788FA517")
    public  GregorianCalendar(Locale locale) {
        this(TimeZone.getDefault(), locale);
        addTaint(locale.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.814 -0400", hash_original_method = "7987E4D71BE0DBF5086B038B74101A38", hash_generated_method = "1274F0C4BA04C348AAE90FD4E15265AE")
    public  GregorianCalendar(TimeZone timezone) {
        this(timezone, Locale.getDefault());
        addTaint(timezone.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.814 -0400", hash_original_method = "98E484CB97D77C9503930A8DB608CAE2", hash_generated_method = "28B09057AD952F7AA7316B7125629DD2")
    public  GregorianCalendar(TimeZone timezone, Locale locale) {
        super(timezone, locale);
        setTimeInMillis(System.currentTimeMillis());
        addTaint(timezone.getTaint());
        addTaint(locale.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.814 -0400", hash_original_method = "0CE38BA4675BDF22B153CA671467EBE6", hash_generated_method = "5D4A36EFE72FAA55E3875AF17FFAA995")
      GregorianCalendar(boolean ignored) {
        super(TimeZone.getDefault());
        setFirstDayOfWeek(SUNDAY);
        setMinimalDaysInFirstWeek(1);
        addTaint(ignored);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.815 -0400", hash_original_method = "1FE1308881E1142F9D3B7A007897B586", hash_generated_method = "5E8CA059E74F4E655A9841494233DA2C")
    @Override
    public void add(int field, int value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        isCached = false;
        {
            complete();
            {
                set(ERA, BC);
            } 
            {
                set(ERA, AD);
            } 
            complete();
        } 
        {
            complete();
            {
                int month = fields[MONTH] + value;
                {
                    value = (month - 11) / 12;
                    month = 12 + (month % 12);
                } 
                {
                    value = month / 12;
                } 
                set(MONTH, month % 12);
            } 
            set(YEAR, fields[YEAR] + value);
            int days = daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]);
            {
                set(DATE, days);
            } 
            complete();
        } 
        long multiplier = 0;
        getTimeInMillis();
        
        time += value;
        
        
        time += value * 1000L;
        
        
        time += value * 60000L;
        
        
        time += value * 3600000L;
        
        
        multiplier = 43200000L;
        
        
        multiplier = 86400000L;
        
        
        multiplier = 604800000L;
        
        {
            areFieldsSet = false;
            complete();
        } 
        long delta = value * multiplier;
        int zoneOffset = getTimeZone().getRawOffset();
        int offsetBefore = getOffset(time + zoneOffset);
        int offsetAfter = getOffset(time + zoneOffset + delta);
        int dstDelta = offsetBefore - offsetAfter;
        {
            boolean var9358D1B1EAE58BFD158E73011F5E9B63_1593756392 = (getOffset(time + zoneOffset + delta + dstDelta) == offsetAfter);
            {
                delta += dstDelta;
            } 
        } 
        time += delta;
        areFieldsSet = false;
        complete();
        addTaint(field);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.816 -0400", hash_original_method = "4451E97BB30CB152B3F7FF3125B7AC95", hash_generated_method = "7482202F70FCCA634F36A08B692D2B9F")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1357046142 = null; 
        GregorianCalendar thisClone = (GregorianCalendar) super.clone();
        thisClone.cachedFields = cachedFields.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1357046142 = thisClone;
        varB4EAC82CA7396A68D541C85D26508E83_1357046142.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1357046142;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.818 -0400", hash_original_method = "005B3A99F85903E106454DD8B0079421", hash_generated_method = "1AB487EF283FC5AE5BF8C85DA08FD549")
    private final void fullFieldsCalc(long timeVal, int millis, int zoneOffset) {
        long days = timeVal / 86400000;
        {
            millis += 86400000;
        } 
        millis += zoneOffset;
        {
            millis += 86400000;
        } 
        {
            millis -= 86400000;
        } 
        int dayOfYear = computeYearAndDay(days, timeVal + zoneOffset);
        fields[DAY_OF_YEAR] = dayOfYear;
        {
            dayOfYear += currentYearSkew;
        } 
        int month = dayOfYear / 32;
        boolean leapYear = isLeapYear(fields[YEAR]);
        int date = dayOfYear - daysInYear(leapYear, month);
        {
            boolean varBCFBCFA689BAE03ACCDE398C77284B61_1110045754 = (date > daysInMonth(leapYear, month));
            {
                date -= daysInMonth(leapYear, month);
            } 
        } 
        fields[DAY_OF_WEEK] = mod7(days - 3) + 1;
        int dstOffset;
        dstOffset = 0;
        dstOffset = getTimeZone().getOffset(AD,
                fields[YEAR], month, date, fields[DAY_OF_WEEK], millis);
        {
            dstOffset -= zoneOffset;
        } 
        fields[DST_OFFSET] = dstOffset;
        {
            long oldDays = days;
            millis += dstOffset;
            {
                millis += 86400000;
            } 
            {
                millis -= 86400000;
            } 
            {
                dayOfYear = computeYearAndDay(days, timeVal - zoneOffset
                        + dstOffset);
                fields[DAY_OF_YEAR] = dayOfYear;
                {
                    dayOfYear += currentYearSkew;
                } 
                month = dayOfYear / 32;
                leapYear = isLeapYear(fields[YEAR]);
                date = dayOfYear - daysInYear(leapYear, month);
                {
                    boolean varFF9B0C37338F3CA779F0DC4C0603FE9D_31499514 = (date > daysInMonth(leapYear, month));
                    {
                        date -= daysInMonth(leapYear, month);
                    } 
                } 
                fields[DAY_OF_WEEK] = mod7(days - 3) + 1;
            } 
        } 
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
        } 
        {
            fields[ERA] = AD;
        } 
        fields[MONTH] = month;
        fields[DATE] = date;
        fields[DAY_OF_WEEK_IN_MONTH] = (date - 1) / 7 + 1;
        fields[WEEK_OF_MONTH] = (date - 1 + mod7(days - date - 2
                - (getFirstDayOfWeek() - 1))) / 7 + 1;
        int daysFromStart = mod7(days - 3 - (fields[DAY_OF_YEAR] - 1)
                - (getFirstDayOfWeek() - 1));
        int week = (fields[DAY_OF_YEAR] - 1 + daysFromStart) / 7
                + (7 - daysFromStart >= getMinimalDaysInFirstWeek() ? 1 : 0);
        {
            fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart
                    - (isLeapYear(fields[YEAR] - 1) ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 53
                    : 52;
        } 
        {
            boolean varE7C3C9E4DCC52FFB6D2FD77C3546E93F_252806286 = (fields[DAY_OF_YEAR] >= (leapYear ? 367 : 366)
                - mod7(daysFromStart + (leapYear ? 2 : 1))); 
            {
                fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart + (leapYear ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 1
                    : week;
            } 
            {
                fields[WEEK_OF_YEAR] = week;
            } 
        } 
        addTaint(timeVal);
        addTaint(millis);
        addTaint(zoneOffset);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.819 -0400", hash_original_method = "2E866A22E927A34EE822F5C0BBDFB40C", hash_generated_method = "E98CA35E66AE64490A91481EA773517B")
    private final void cachedFieldsCheckAndGet(long timeVal,
            long newTimeMillis, long newTimeMillisAdjusted, int millis,
            int zoneOffset) {
        int dstOffset = fields[DST_OFFSET];
        {
            fullFieldsCalc(timeVal, millis, zoneOffset);
            isCached = false;
        } 
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
        } 
        addTaint(timeVal);
        addTaint(newTimeMillis);
        addTaint(newTimeMillisAdjusted);
        addTaint(millis);
        addTaint(zoneOffset);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.820 -0400", hash_original_method = "B0DF08CEBB1EE730F98FF9762C9FEBD4", hash_generated_method = "A6DD85540B65E625B9B2E8AD4BEF39E6")
    @Override
    protected void computeFields() {
        TimeZone timeZone = getTimeZone();
        int dstOffset;
        boolean var7227D111493F5C9AE3EFCCBBD3DA3A95_1451057359 = (timeZone.inDaylightTime(new Date(time)));
        dstOffset = timeZone.getDSTSavings();
        dstOffset = 0;
        int zoneOffset = timeZone.getRawOffset();
        fields[DST_OFFSET] = dstOffset;
        fields[ZONE_OFFSET] = zoneOffset;
        int millis = (int) (time % 86400000);
        int savedMillis = millis;
        int offset = zoneOffset + dstOffset;
        long newTime = time + offset;
        {
            newTime = 0x7fffffffffffffffL;
        } 
        {
            newTime = 0x8000000000000000L;
        } 
        {
            {
                millis += 86400000;
            } 
            millis += zoneOffset;
            millis += dstOffset;
            {
                millis += 86400000;
            } 
            {
                millis -= 86400000;
            } 
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
            long newTimeAdjusted = newTime;
            {
                boolean varC91B9F9D8FA1076E10F0661EFE1DB41B_1597080748 = (timeZone.useDaylightTime());
                {
                    int dstSavings = timeZone.getDSTSavings();
                    newTimeAdjusted += (dstOffset == 0) ? dstSavings : -dstSavings;
                } 
            } 
            {
                newTimeAdjusted = 0x7fffffffffffffffL;
            } 
            {
                newTimeAdjusted = 0x8000000000000000L;
            } 
            cachedFieldsCheckAndGet(time, newTime, newTimeAdjusted,
                    savedMillis, zoneOffset);
        } 
        {
            fullFieldsCalc(time, savedMillis, zoneOffset);
        } 
        {
            int i = 0;
            {
                isSet[i] = true;
            } 
        } 
        {
            boolean var9612C0EF2FD4C7A52D997E0A251788F4_1398036231 = (!isCached
                && newTime != 0x7fffffffffffffffL
                && newTime != 0x8000000000000000L
                && (!timeZone.useDaylightTime() || timeZone instanceof SimpleTimeZone));
            {
                int cacheMillis = 0;
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
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.823 -0400", hash_original_method = "2C41A89AB92A41E731883E58EB4B865A", hash_generated_method = "2AE651C2FC9AE4E6F6155DB79AA60A7D")
    @Override
    protected void computeTime() {
        {
            boolean varFACDFEC6F69DADFC305CEE68F7E56304_2073192093 = (!isLenient());
            {
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                    } 
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                    } 
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
            } 
        } 
        long timeVal;
        long hour = 0;
        {
            hour = fields[HOUR_OF_DAY];
        } 
        {
            hour = (fields[AM_PM] * 12) + fields[HOUR];
        } 
        timeVal = hour * 3600000;
        {
            timeVal += ((long) fields[MINUTE]) * 60000;
        } 
        {
            timeVal += ((long) fields[SECOND]) * 1000;
        } 
        {
            timeVal += fields[MILLISECOND];
        } 
        long days;
        int year;
        year = fields[YEAR];
        year = 1970;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
            {
                year = 1 - year;
            } 
        } 
        boolean weekMonthSet = isSet[WEEK_OF_MONTH]
                || isSet[DAY_OF_WEEK_IN_MONTH];
        boolean useMonth = (isSet[DATE] || isSet[MONTH] || weekMonthSet)
                && lastDateFieldSet != DAY_OF_YEAR;
        {
            {
                useMonth = lastDateFieldSet != WEEK_OF_YEAR && weekMonthSet
                        && isSet[DAY_OF_WEEK];
            } 
            {
                useMonth = isSet[DATE] && isSet[MONTH];
            } 
        } 
        {
            int month = fields[MONTH];
            year += month / 12;
            month %= 12;
            {
                month += 12;
            } 
            boolean leapYear = isLeapYear(year);
            days = daysFromBaseYear(year) + daysInYear(leapYear, month);
            boolean useDate = isSet[DATE];
            {
                useDate = !(isSet[DAY_OF_WEEK] && weekMonthSet);
            } 
            {
                {
                    boolean varAD72E57B80110245423B5A8B5FE79293_1093698094 = (!isLenient()
                        && (fields[DATE] < 1 || fields[DATE] > daysInMonth(
                                leapYear, month)));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                    } 
                } 
                days += fields[DATE] - 1;
            } 
            {
                int dayOfWeek;
                {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } 
                {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                } 
                {
                    int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += (fields[WEEK_OF_MONTH] - 1) * 7
                            + mod7(skew + dayOfWeek - (days - 3)) - skew;
                } 
                {
                    {
                        days += mod7(dayOfWeek - (days - 3))
                                + (fields[DAY_OF_WEEK_IN_MONTH] - 1) * 7;
                    } 
                    {
                        days += daysInMonth(leapYear, month)
                                + mod7(dayOfWeek
                                        - (days + daysInMonth(leapYear, month) - 3))
                                + fields[DAY_OF_WEEK_IN_MONTH] * 7;
                    } 
                } 
                {
                    int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += mod7(mod7(skew + dayOfWeek - (days - 3)) - skew);
                } 
            } 
        } 
        {
            boolean useWeekYear = isSet[WEEK_OF_YEAR]
                    && lastDateFieldSet != DAY_OF_YEAR;
            {
                useWeekYear = isSet[DAY_OF_WEEK];
            } 
            days = daysFromBaseYear(year);
            {
                int dayOfWeek;
                {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } 
                {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                } 
                int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                days += (fields[WEEK_OF_YEAR] - 1) * 7
                        + mod7(skew + dayOfWeek - (days - 3)) - skew;
                {
                    boolean varE26E43FD9372BC0247AD2F35115E53C0_1705610198 = (7 - skew < getMinimalDaysInFirstWeek());
                    {
                        days += 7;
                    } 
                } 
            } 
            {
                {
                    boolean var5E54B386391C54C1445EC2DD47905BC4_1463125970 = (!isLenient()
                        && (fields[DAY_OF_YEAR] < 1 || fields[DAY_OF_YEAR] > (365 + (isLeapYear(year) ? 1
                                : 0)))); 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                    } 
                } 
                days += fields[DAY_OF_YEAR] - 1;
            } 
            {
                days += mod7(fields[DAY_OF_WEEK] - 1 - (days - 3));
            } 
        } 
        lastDateFieldSet = 0;
        timeVal += days * 86400000;
        {
            boolean var4521363AC2DA99125953BA39F1463F28_443289348 = (year == changeYear
                && timeVal >= gregorianCutover + julianError() * 86400000L);
            {
                timeVal -= julianError() * 86400000L;
            } 
        } 
        long timeValWithoutDST = timeVal - getOffset(timeVal)
                + getTimeZone().getRawOffset();
        timeVal -= getOffset(timeValWithoutDST);
        this.time = timeVal;
        {
            computeFields();
            areFieldsSet = true;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.824 -0400", hash_original_method = "2A644CA75A846A9F294F6A7DE0BAB232", hash_generated_method = "86492A12948753FCECA9D3AB12859D1C")
    private int computeYearAndDay(long dayCount, long localTime) {
        int year = 1970;
        long days = dayCount;
        {
            days -= julianSkew;
        } 
        int approxYears;
        {
            boolean varA0C372859F6CDCA7B1B6C2DB149AE991_128790388 = ((approxYears = (int) (days / 365)) != 0);
            {
                year = year + approxYears;
                days = dayCount - daysFromBaseYear(year);
            } 
        } 
        {
            year = year - 1;
            days = days + daysInYear(year);
        } 
        fields[YEAR] = year;
        addTaint(dayCount);
        addTaint(localTime);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254303980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254303980;
        
        
        
        
            
        
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.825 -0400", hash_original_method = "975CAA178CB1C52E2022FF53CD13129C", hash_generated_method = "32BA60B33D6BB08B7D37FCE7037A5E8B")
    private long daysFromBaseYear(int iyear) {
        long year = iyear;
        {
            long days = (year - 1970) * 365 + ((year - 1969) / 4);
            {
                days -= ((year - 1901) / 100) - ((year - 1601) / 400);
            } 
            {
                {
                    days += currentYearSkew;
                } 
                {
                    days += lastYearSkew;
                } 
                {
                    days += julianSkew;
                } 
            } 
        } 
        addTaint(iyear);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1862918196 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1862918196;
        
        
        
            
            
                
            
                
                    
                
                    
                
                    
                
            
            
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.825 -0400", hash_original_method = "B393AFA9309B3ECCDD74469F481095BD", hash_generated_method = "FD4122CAA87867D2A1B6AC6A10A00B32")
    private int daysInMonth() {
        int varE318A98C4AE10FD73CDBBCD84B832D8D_1048936355 = (daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461359939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461359939;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.826 -0400", hash_original_method = "F030460418FCB84947C9AD9647C8CF35", hash_generated_method = "556D49699516E5C48AAD9AF651A507F5")
    private int daysInMonth(boolean leapYear, int month) {
        addTaint(leapYear);
        addTaint(month);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70216554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70216554;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.826 -0400", hash_original_method = "643B799339D2A3831DACB9C12752109A", hash_generated_method = "2CB85FB3BEA6B2972904919B2035360D")
    private int daysInYear(int year) {
        int daysInYear;
        boolean var806EDE1361E2163FF12E03ABFE47D72B_818760090 = (isLeapYear(year));
        daysInYear = 366;
        daysInYear = 365;
        {
            daysInYear -= currentYearSkew;
        } 
        {
            daysInYear -= lastYearSkew;
        } 
        addTaint(year);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1693339418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1693339418;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.827 -0400", hash_original_method = "7E255F605E98F52E53144D7126E773F6", hash_generated_method = "0B20CDFB3920D449B7CA27EE8F28F4B0")
    private int daysInYear(boolean leapYear, int month) {
        addTaint(leapYear);
        addTaint(month);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791338939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791338939;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.827 -0400", hash_original_method = "61C11EDCA3B03978A14421C2440916AB", hash_generated_method = "9B961C0728115266277C2A7094E327CB")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_1671351657 = (object == this);
        } 
        boolean var37CB9CE3CFC322844A11D9381BF57718_454821857 = (super.equals(object)
                && gregorianCutover == ((GregorianCalendar) object).gregorianCutover);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417646470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_417646470;
        
        
            
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.829 -0400", hash_original_method = "F6A8281F341CD14B238EE5FA427449C3", hash_generated_method = "0DC756AD146FDF4C7794C9CDCE8A1235")
    @Override
    public int getActualMaximum(int field) {
        int value;
        {
            boolean varF889B32F8A6F0D9644F5182C32B821CC_257547231 = ((value = maximums[field]) == leastMaximums[field]);
        } 
        
        isCached = false;
        
        complete();
        long orgTime = time;
        int result = 0;
        
        set(DATE, 31);
        
        
        set(MONTH, DECEMBER);
        
        
        result = get(WEEK_OF_YEAR);
        
        
        {
            set(DATE, 31 - 7);
            result = get(WEEK_OF_YEAR);
        } 
        
        
        areFieldsSet = false;
        
        
        set(DATE, daysInMonth());
        
        
        result = get(WEEK_OF_MONTH);
        
        
        areFieldsSet = false;
        
        
        int var5CFABCF07DB75122C7B613B74C3A77A0_1389656030 = (daysInMonth());
        
        
        int var0AC5B37CA37BB4CB746E2A8A2E3240E0_1573746074 = (daysInYear(fields[YEAR]));
        
        
        result = get(DAY_OF_WEEK_IN_MONTH)
                        + ((daysInMonth() - get(DATE)) / 7);
        
        
        GregorianCalendar clone = (GregorianCalendar) clone();
        
        
        {
            boolean varB09F384FEFE292415D2A5D3359C67CC8_2102322080 = (get(ERA) == AD);
            {
                clone.setTimeInMillis(Long.MAX_VALUE);
            } 
            {
                clone.setTimeInMillis(Long.MIN_VALUE);
            } 
        } 
        
        
        result = clone.get(YEAR);
        
        
        clone.set(YEAR, get(YEAR));
        
        
        {
            boolean var67E7F62106250BA6B0F4638123528C99_528393027 = (clone.before(this));
        } 
        
        
        result = getMaximum(DST_OFFSET);
        
        time = orgTime;
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306185437 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306185437;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.830 -0400", hash_original_method = "0094646504037C44C448A8626AEC2CA3", hash_generated_method = "803B17FB903B33D569C4F8A532CD5BCB")
    @Override
    public int getActualMinimum(int field) {
        int var5E6945756F684C789AC7D19DD344C7B7_1677670641 = (getMinimum(field));
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249765158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249765158;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.830 -0400", hash_original_method = "F3CD156C4D2759DEA34A15A000EAB551", hash_generated_method = "D1B24774E771B83161F76A6B99CCF8C8")
    @Override
    public int getGreatestMinimum(int field) {
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125761262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125761262;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.831 -0400", hash_original_method = "BD206861177D272D9EC33433339CB64F", hash_generated_method = "B8ADA3BEB9138BDE477DA72C3BA4ED5A")
    public final Date getGregorianChange() {
        Date varB4EAC82CA7396A68D541C85D26508E83_458439908 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_458439908 = new Date(gregorianCutover);
        varB4EAC82CA7396A68D541C85D26508E83_458439908.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_458439908;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.831 -0400", hash_original_method = "3B0100990EBACC07D6E54BAA89A3102A", hash_generated_method = "57A979EEDFB823BF28596D760E692D79")
    @Override
    public int getLeastMaximum(int field) {
        {
            long currentTimeInMillis = time;
            setTimeInMillis(gregorianCutover);
            int actual = getActualMaximum(field);
            setTimeInMillis(currentTimeInMillis);
        } 
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_61730285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_61730285;
        
        
                
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.832 -0400", hash_original_method = "80794FF1ED1E8F2177114BCAA53EED59", hash_generated_method = "24F66A9C15374AEA37D2D26E4DA8644D")
    @Override
    public int getMaximum(int field) {
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127632189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127632189;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.832 -0400", hash_original_method = "1A09A14EE8971B3B0503081305AF18CB", hash_generated_method = "7983453E20028E0F739C9D95B12A4A09")
    @Override
    public int getMinimum(int field) {
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169607354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169607354;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.833 -0400", hash_original_method = "A5F3F970AF018D82525827EF3879E8F1", hash_generated_method = "EC127AE0D486FFC5B5EF83F55DC5E964")
    private int getOffset(long localTime) {
        TimeZone timeZone = getTimeZone();
        long dayCount = localTime / 86400000;
        int millis = (int) (localTime % 86400000);
        {
            millis += 86400000;
        } 
        int year = 1970;
        long days = dayCount;
        {
            days -= julianSkew;
        } 
        int approxYears;
        {
            boolean varA0C372859F6CDCA7B1B6C2DB149AE991_589728812 = ((approxYears = (int) (days / 365)) != 0);
            {
                year = year + approxYears;
                days = dayCount - daysFromBaseYear(year);
            } 
        } 
        {
            year = year - 1;
            days = days + 365 + (isLeapYear(year) ? 1 : 0);
            {
                days -= julianError();
            } 
        } 
        {
            int var83195CF641F8AED9D4B81C2528687249_62450854 = (timeZone.getRawOffset());
        } 
        int dayOfYear = (int) days + 1;
        int month = dayOfYear / 32;
        boolean leapYear = isLeapYear(year);
        int date = dayOfYear - daysInYear(leapYear, month);
        {
            boolean varBCFBCFA689BAE03ACCDE398C77284B61_1087210235 = (date > daysInMonth(leapYear, month));
            {
                date -= daysInMonth(leapYear, month);
            } 
        } 
        int dayOfWeek = mod7(dayCount - 3) + 1;
        int offset = timeZone.getOffset(AD, year, month, date, dayOfWeek,
                millis);
        addTaint(localTime);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_252825770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_252825770;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.833 -0400", hash_original_method = "6907F2ED2DF57E219AB70EADED509565", hash_generated_method = "CE2FBA354A5633152F9A4E507B5BF4AB")
    @Override
    public int hashCode() {
        int var692CE3A7B5A5A51EE98F7911213C9198_1766058281 = (super.hashCode()
                + ((int) (gregorianCutover >>> 32) ^ (int) gregorianCutover));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71826492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71826492;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.833 -0400", hash_original_method = "FD1210B9D1DAC87CC2975B1EB57E42AE", hash_generated_method = "483A1BB5B3572D50906458EF4A03969B")
    public boolean isLeapYear(int year) {
        addTaint(year);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1766220807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1766220807;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.834 -0400", hash_original_method = "6792E5EC134CCE3576D348D7664F192E", hash_generated_method = "386AB4995445972875C10F2FC6073B4F")
    private int julianError() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127128610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127128610;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.834 -0400", hash_original_method = "C7B77E5A8B6CB394A26ACFDB4CA2A34C", hash_generated_method = "004B91AE78BB22667422DF1D487F8028")
    private int mod(int value, int mod) {
        int rem = value % mod;
        addTaint(value);
        addTaint(mod);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235302997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235302997;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.834 -0400", hash_original_method = "B5B6FCF50F48D18673AA227255C5F0A5", hash_generated_method = "89BD5AB55BCC7C7700EBF2934CFF8526")
    private int mod7(long num1) {
        int rem = (int) (num1 % 7);
        addTaint(num1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660745321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660745321;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.838 -0400", hash_original_method = "B265969ED1D5B160D0AFF42D0A073F4D", hash_generated_method = "83263A76E031CB0E8B9ED7DEF75FEC24")
    @Override
    public void roll(int field, int value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        isCached = false;
        complete();
        int days;
        int day;
        int mod;
        int maxWeeks;
        int newWeek;
        int max = -1;
        
        max = maximums[field];
        
        
        days = daysInYear(fields[YEAR]);
        
        
        day = DAY_OF_YEAR;
        
        
        mod = mod7(fields[DAY_OF_WEEK] - fields[day]
                    - (getFirstDayOfWeek() - 1));
        
        
        maxWeeks = (days - 1 + mod) / 7 + 1;
        
        
        newWeek = mod(fields[field] - 1 + value, maxWeeks) + 1;
        
        
        {
            int addDays = (newWeek - fields[field]) * 7;
            {
                set(field, 1);
            } 
            {
                set(field, newWeek - 1);
            } 
        } 
        {
            int week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
            {
                set(field, 1);
            } 
            {
                set(field, newWeek);
            } 
        } 
        {
            set(field, newWeek);
        } 
        
        
        days = daysInMonth();
        
        
        day = DATE;
        
        
        mod = mod7(fields[DAY_OF_WEEK] - fields[day]
                    - (getFirstDayOfWeek() - 1));
        
        
        maxWeeks = (days - 1 + mod) / 7 + 1;
        
        
        newWeek = mod(fields[field] - 1 + value, maxWeeks) + 1;
        
        
        {
            {
                set(day, days);
            } 
            {
                set(field, newWeek);
            } 
        } 
        {
            int week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
            {
                set(day, 1);
            } 
            {
                set(field, newWeek);
            } 
        } 
        {
            set(field, newWeek);
        } 
        
        
        max = daysInMonth();
        
        
        max = daysInYear(fields[YEAR]);
        
        
        max = maximums[field];
        
        
        lastDateFieldSet = WEEK_OF_MONTH;
        
        
        max = (fields[DATE] + ((daysInMonth() - fields[DATE]) / 7 * 7) - 1) / 7 + 1;
        
        
        set(field, mod(fields[field] + value, maximums[field] + 1));
        
        
        {
            boolean var996091B13023E8401BC1CAC33664D345_1403481460 = (field == MONTH && fields[DATE] > daysInMonth());
            {
                set(DATE, daysInMonth());
            } 
            {
                lastTimeFieldSet = HOUR;
            } 
        } 
        
        {
            set(field, mod(fields[field] - 1 + value, max) + 1);
        } 
        complete();
        addTaint(field);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.839 -0400", hash_original_method = "011BFEF6AF7823592586BFF14A1F0FAF", hash_generated_method = "9179DC8632F2F48A26A833FCAFC551CC")
    @Override
    public void roll(int field, boolean increment) {
        roll(field, increment ? 1 : -1);
        addTaint(field);
        addTaint(increment);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.839 -0400", hash_original_method = "BBA926F39AADCD3D723F5CC72B7A16F3", hash_generated_method = "84EA1AF57018FEE65DACBC1565324F03")
    public void setGregorianChange(Date date) {
        gregorianCutover = date.getTime();
        GregorianCalendar cal = new GregorianCalendar(TimeZone.GMT);
        cal.setTime(date);
        changeYear = cal.get(YEAR);
        {
            boolean var6B3F925C21EB7C0091F9A66AE842BD58_1034455568 = (cal.get(ERA) == BC);
            {
                changeYear = 1 - changeYear;
            } 
        } 
        julianSkew = ((changeYear - 2000) / 400) + julianError()
                - ((changeYear - 2000) / 100);
        isCached = false;
        int dayOfYear = cal.get(DAY_OF_YEAR);
        {
            currentYearSkew = dayOfYear-1;
            lastYearSkew = julianSkew - dayOfYear + 1;
        } 
        {
            lastYearSkew = 0;
            currentYearSkew = julianSkew;
        } 
        isCached = false;
        
        
        
        
        
        
            
        
        
                
        
        
        
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.840 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "DDA22F816AE77E5A06281F4F7C5D3D46")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        addTaint(stream.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.841 -0400", hash_original_method = "6812E7459A56AAC638E0A1455D3A3623", hash_generated_method = "EFBD54241490F60E81D5F8C16A7D130B")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        setGregorianChange(new Date(gregorianCutover));
        isCached = false;
        addTaint(stream.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.841 -0400", hash_original_method = "803EF27234E46811EE9F1109A1277F23", hash_generated_method = "8FFF6A46620EA36EC5C77CA65C2E152F")
    @Override
    public void setFirstDayOfWeek(int value) {
        super.setFirstDayOfWeek(value);
        isCached = false;
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_method = "77A4B23D11FEBAAF4DA5B074DBE88F4F", hash_generated_method = "5604526C3EA54DB2EC3740FC20D05BEC")
    @Override
    public void setMinimalDaysInFirstWeek(int value) {
        super.setMinimalDaysInFirstWeek(value);
        isCached = false;
        addTaint(value);
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_field = "1C4EA65D0B85820031DB54E0B782FD43", hash_generated_field = "B9386A44E9BFA9A5ED8D3E7882B2C9E1")

    private static final long serialVersionUID = -8125100834729963327L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_field = "9AD044AF9694EBAE04C6A843D8BD814D", hash_generated_field = "93BFF7C10A82D9138EF2CEC785C901D2")

    public static final int BC = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_field = "B7B6AD4BCE48136317BC53C29D899D81", hash_generated_field = "BC845EBD4DA20DC255F4737CB21267E2")

    public static final int AD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_field = "3C2061F8784D53F3CF214EF2B5C44347", hash_generated_field = "23BA66807055EDC52580EFE8B68EA6D9")

    private static final long defaultGregorianCutover = -12219292800000l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_field = "F75D8DB91544852469A5E6BD6B9261C6", hash_generated_field = "D109403F40DEAA9D96D5485CCE288282")

    static byte[] DaysInMonth = new byte[] { 31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_field = "FA59282D92997F8368B0D198B418DB90", hash_generated_field = "0A4DD57D0556CD2CAD7A071A46A83584")

    private static int[] DaysInYear = new int[] { 0, 31, 59, 90, 120, 151, 181,
            212, 243, 273, 304, 334 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_field = "AB38F25D3064B346C2337034E2A43B7E", hash_generated_field = "9C039D691AF795C6B392702421AF992F")

    private static int[] maximums = new int[] { 1, 292278994, 11, 53, 6, 31,
            366, 7, 6, 1, 11, 23, 59, 59, 999, 14 * 3600 * 1000, 7200000 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.842 -0400", hash_original_field = "86C59D996E94DD35B58C61607BD56009", hash_generated_field = "34197BE97C1359ACB541F3CFF4B6D197")

    private static int[] minimums = new int[] { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0,
            0, 0, 0, 0, 0, -13 * 3600 * 1000, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.843 -0400", hash_original_field = "1119798B7094D66F851E9E0B02F12B51", hash_generated_field = "72A42F262CE1CA8E4E3156D2F2A817C5")

    private static int[] leastMaximums = new int[] { 1, 292269054, 11, 50, 3,
            28, 355, 7, 3, 1, 11, 23, 59, 59, 999, 50400000, 1200000 };
}

