package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GregorianCalendar extends Calendar {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.054 -0400", hash_original_field = "400857AF5F099B78A86D8F68DDA6A04C", hash_generated_field = "EA14FB63AF074345B169453863E64EC4")

    private long gregorianCutover = defaultGregorianCutover;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.054 -0400", hash_original_field = "2237A6A77C737B6DE347542050A70C16", hash_generated_field = "A0B8CA27149DD74350CDB7EC98C60162")

    private transient int changeYear = 1582;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.054 -0400", hash_original_field = "B31858CD0ADA5C474F1168521920B10A", hash_generated_field = "2808C9DD640CD873EE96A55ECDBB8D85")

    private transient int julianSkew = ((changeYear - 2000) / 400)
            + julianError() - ((changeYear - 2000) / 100);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.055 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "4B7219F27A11B1E89794219BC39393A8")

    private boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.055 -0400", hash_original_field = "48BDECEAC3EC7DF64DC015EE1647B63D", hash_generated_field = "7AF7C45B7A2B45D012327222457CC902")

    private int[] cachedFields = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.055 -0400", hash_original_field = "29BEE66E54150507B1EAE04F51499A76", hash_generated_field = "EAB4464060441E8E83529F625B8AC792")

    private long nextMidnightMillis = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.055 -0400", hash_original_field = "48A2AA6D81A9C01929B5C02CE7D1A7AD", hash_generated_field = "A139545ACF978509DA3F6AC55F657D39")

    private long lastMidnightMillis = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.055 -0400", hash_original_field = "4C645BB4AD56D54A8545F69CF4FCB94D", hash_generated_field = "657D9B61D3147BAB9300368D7E5B963D")

    private int currentYearSkew = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.055 -0400", hash_original_field = "DEFBAD132BF50B6929249287EA3B13E8", hash_generated_field = "A15FC9D51CCB159121982FD9BA383E19")

    private int lastYearSkew = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.056 -0400", hash_original_method = "7EB3091E87333B7AA987345512812570", hash_generated_method = "2E973698D04F2D2AAC57C914B74CED19")
    public  GregorianCalendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.058 -0400", hash_original_method = "B0762BDDD2B39759F6CE94DB8F25D3E0", hash_generated_method = "38F0A9BF75F9A56470D2031A9E0A5D2D")
    public  GregorianCalendar(int year, int month, int day) {
        super(TimeZone.getDefault(), Locale.getDefault());
        addTaint(day);
        addTaint(month);
        addTaint(year);
        set(year, month, day);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.069 -0400", hash_original_method = "D6C72587979F1136CC7CF710B2F32D12", hash_generated_method = "F7EFABA788F844F525D02243BF9520F0")
    public  GregorianCalendar(int year, int month, int day, int hour, int minute) {
        super(TimeZone.getDefault(), Locale.getDefault());
        addTaint(minute);
        addTaint(hour);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        set(year, month, day, hour, minute);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.074 -0400", hash_original_method = "BC793B84C6DC2AD69827C6FC0D0FCEDD", hash_generated_method = "FC0236E2BF577D7CE57E3BA1598443DF")
    public  GregorianCalendar(int year, int month, int day, int hour,
            int minute, int second) {
        super(TimeZone.getDefault(), Locale.getDefault());
        addTaint(second);
        addTaint(minute);
        addTaint(hour);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        set(year, month, day, hour, minute, second);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.078 -0400", hash_original_method = "63C34121AB8507D7813FBAF0F269A9D2", hash_generated_method = "DBDDB5E1B686CEF0A39C004ACB03E3DF")
      GregorianCalendar(long milliseconds) {
        this(false);
        addTaint(milliseconds);
        setTimeInMillis(milliseconds);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.080 -0400", hash_original_method = "56E3B8EB09DD30B0731434891C29D1A4", hash_generated_method = "4EF55C9A9234380F5CABEBE8788FA517")
    public  GregorianCalendar(Locale locale) {
        this(TimeZone.getDefault(), locale);
        addTaint(locale.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.080 -0400", hash_original_method = "7987E4D71BE0DBF5086B038B74101A38", hash_generated_method = "1274F0C4BA04C348AAE90FD4E15265AE")
    public  GregorianCalendar(TimeZone timezone) {
        this(timezone, Locale.getDefault());
        addTaint(timezone.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.081 -0400", hash_original_method = "98E484CB97D77C9503930A8DB608CAE2", hash_generated_method = "16236B43E103E0BE92398E5AAC116A6B")
    public  GregorianCalendar(TimeZone timezone, Locale locale) {
        super(timezone, locale);
        addTaint(locale.getTaint());
        addTaint(timezone.getTaint());
        setTimeInMillis(System.currentTimeMillis());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.082 -0400", hash_original_method = "0CE38BA4675BDF22B153CA671467EBE6", hash_generated_method = "19136D995F6410ABA81A5328621EBDCA")
      GregorianCalendar(boolean ignored) {
        super(TimeZone.getDefault());
        addTaint(ignored);
        setFirstDayOfWeek(SUNDAY);
        setMinimalDaysInFirstWeek(1);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.086 -0400", hash_original_method = "1FE1308881E1142F9D3B7A007897B586", hash_generated_method = "928A4AFA981F7D60A53B82DF1D37C8F2")
    @Override
    public void add(int field, int value) {
        addTaint(value);
        addTaint(field);
    if(value == 0)        
        {
            return;
        } 
    if(field < 0 || field >= ZONE_OFFSET)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1037868551 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1037868551.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1037868551;
        } 
        isCached = false;
    if(field == ERA)        
        {
            complete();
    if(fields[ERA] == AD)            
            {
    if(value >= 0)                
                {
                    return;
                } 
                set(ERA, BC);
            } 
            else
            {
    if(value <= 0)                
                {
                    return;
                } 
                set(ERA, AD);
            } 
            complete();
            return;
        } 
    if(field == YEAR || field == MONTH)        
        {
            complete();
    if(field == MONTH)            
            {
                int month = fields[MONTH] + value;
    if(month < 0)                
                {
                    value = (month - 11) / 12;
                    month = 12 + (month % 12);
                } 
                else
                {
                    value = month / 12;
                } 
                set(MONTH, month % 12);
            } 
            set(YEAR, fields[YEAR] + value);
            int days = daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]);
    if(fields[DATE] > days)            
            {
                set(DATE, days);
            } 
            complete();
            return;
        } 
        long multiplier = 0;
        getTimeInMillis();
switch(field){
        case MILLISECOND:
        time += value;
        break;
        case SECOND:
        time += value * 1000L;
        break;
        case MINUTE:
        time += value * 60000L;
        break;
        case HOUR:
        case HOUR_OF_DAY:
        time += value * 3600000L;
        break;
        case AM_PM:
        multiplier = 43200000L;
        break;
        case DATE:
        case DAY_OF_YEAR:
        case DAY_OF_WEEK:
        multiplier = 86400000L;
        break;
        case WEEK_OF_YEAR:
        case WEEK_OF_MONTH:
        case DAY_OF_WEEK_IN_MONTH:
        multiplier = 604800000L;
        break;
}    if(multiplier == 0)        
        {
            areFieldsSet = false;
            complete();
            return;
        } 
        long delta = value * multiplier;
        int zoneOffset = getTimeZone().getRawOffset();
        int offsetBefore = getOffset(time + zoneOffset);
        int offsetAfter = getOffset(time + zoneOffset + delta);
        int dstDelta = offsetBefore - offsetAfter;
    if(getOffset(time + zoneOffset + delta + dstDelta) == offsetAfter)        
        {
            delta += dstDelta;
        } 
        time += delta;
        areFieldsSet = false;
        complete();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.088 -0400", hash_original_method = "4451E97BB30CB152B3F7FF3125B7AC95", hash_generated_method = "D711214E44B3AE64E63651BD71EC44EC")
    @Override
    public Object clone() {
        GregorianCalendar thisClone = (GregorianCalendar) super.clone();
        thisClone.cachedFields = cachedFields.clone();
Object varAEB7DF9800272FF7E732FE6AE6B21A82_1631509430 =         thisClone;
        varAEB7DF9800272FF7E732FE6AE6B21A82_1631509430.addTaint(taint);
        return varAEB7DF9800272FF7E732FE6AE6B21A82_1631509430;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.093 -0400", hash_original_method = "005B3A99F85903E106454DD8B0079421", hash_generated_method = "B00FF7F489554B4BBE66F341253BCD66")
    private final void fullFieldsCalc(long timeVal, int millis, int zoneOffset) {
        addTaint(zoneOffset);
        addTaint(millis);
        addTaint(timeVal);
        long days = timeVal / 86400000;
    if(millis < 0)        
        {
            millis += 86400000;
            days--;
        } 
        millis += zoneOffset;
        while
(millis < 0)        
        {
            millis += 86400000;
            days--;
        } 
        while
(millis >= 86400000)        
        {
            millis -= 86400000;
            days++;
        } 
        int dayOfYear = computeYearAndDay(days, timeVal + zoneOffset);
        fields[DAY_OF_YEAR] = dayOfYear;
    if(fields[YEAR] == changeYear && gregorianCutover <= timeVal + zoneOffset)        
        {
            dayOfYear += currentYearSkew;
        } 
        int month = dayOfYear / 32;
        boolean leapYear = isLeapYear(fields[YEAR]);
        int date = dayOfYear - daysInYear(leapYear, month);
    if(date > daysInMonth(leapYear, month))        
        {
            date -= daysInMonth(leapYear, month);
            month++;
        } 
        fields[DAY_OF_WEEK] = mod7(days - 3) + 1;
        int dstOffset = fields[YEAR] <= 0 ? 0 : getTimeZone().getOffset(AD,
                fields[YEAR], month, date, fields[DAY_OF_WEEK], millis);
    if(fields[YEAR] > 0)        
        {
            dstOffset -= zoneOffset;
        } 
        fields[DST_OFFSET] = dstOffset;
    if(dstOffset != 0)        
        {
            long oldDays = days;
            millis += dstOffset;
    if(millis < 0)            
            {
                millis += 86400000;
                days--;
            } 
            else
    if(millis >= 86400000)            
            {
                millis -= 86400000;
                days++;
            } 
    if(oldDays != days)            
            {
                dayOfYear = computeYearAndDay(days, timeVal - zoneOffset
                        + dstOffset);
                fields[DAY_OF_YEAR] = dayOfYear;
    if(fields[YEAR] == changeYear && gregorianCutover <= timeVal - zoneOffset + dstOffset)                
                {
                    dayOfYear += currentYearSkew;
                } 
                month = dayOfYear / 32;
                leapYear = isLeapYear(fields[YEAR]);
                date = dayOfYear - daysInYear(leapYear, month);
    if(date > daysInMonth(leapYear, month))                
                {
                    date -= daysInMonth(leapYear, month);
                    month++;
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
    if(fields[YEAR] <= 0)        
        {
            fields[ERA] = BC;
            fields[YEAR] = -fields[YEAR] + 1;
        } 
        else
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
    if(week == 0)        
        {
            fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart
                    - (isLeapYear(fields[YEAR] - 1) ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 53
                    : 52;
        } 
        else
    if(fields[DAY_OF_YEAR] >= (leapYear ? 367 : 366)
                - mod7(daysFromStart + (leapYear ? 2 : 1)))        
        {
            fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart + (leapYear ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 1
                    : week;
        } 
        else
        {
            fields[WEEK_OF_YEAR] = week;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.095 -0400", hash_original_method = "2E866A22E927A34EE822F5C0BBDFB40C", hash_generated_method = "8876970B2E20F826390CCA4B64F38729")
    private final void cachedFieldsCheckAndGet(long timeVal,
            long newTimeMillis, long newTimeMillisAdjusted, int millis,
            int zoneOffset) {
        addTaint(zoneOffset);
        addTaint(millis);
        addTaint(newTimeMillisAdjusted);
        addTaint(newTimeMillis);
        addTaint(timeVal);
        int dstOffset = fields[DST_OFFSET];
    if(!isCached
                || newTimeMillis >= nextMidnightMillis
                || newTimeMillis <= lastMidnightMillis
                || cachedFields[4] != zoneOffset
                || (dstOffset == 0 && (newTimeMillisAdjusted >= nextMidnightMillis))
                || (dstOffset != 0 && (newTimeMillisAdjusted <= lastMidnightMillis)))        
        {
            fullFieldsCalc(timeVal, millis, zoneOffset);
            isCached = false;
        } 
        else
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.100 -0400", hash_original_method = "B0DF08CEBB1EE730F98FF9762C9FEBD4", hash_generated_method = "87253D919D628CA2225925A01EF2B0D0")
    @Override
    protected void computeFields() {
        TimeZone timeZone = getTimeZone();
        int dstOffset = timeZone.inDaylightTime(new Date(time)) ? timeZone.getDSTSavings() : 0;
        int zoneOffset = timeZone.getRawOffset();
        fields[DST_OFFSET] = dstOffset;
        fields[ZONE_OFFSET] = zoneOffset;
        int millis = (int) (time % 86400000);
        int savedMillis = millis;
        int offset = zoneOffset + dstOffset;
        long newTime = time + offset;
    if(time > 0L && newTime < 0L && offset > 0)        
        {
            newTime = 0x7fffffffffffffffL;
        } 
        else
    if(time < 0L && newTime > 0L && offset < 0)        
        {
            newTime = 0x8000000000000000L;
        } 
    if(isCached)        
        {
    if(millis < 0)            
            {
                millis += 86400000;
            } 
            millis += zoneOffset;
            millis += dstOffset;
    if(millis < 0)            
            {
                millis += 86400000;
            } 
            else
    if(millis >= 86400000)            
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
    if(timeZone.useDaylightTime())            
            {
                int dstSavings = timeZone.getDSTSavings();
                newTimeAdjusted += (dstOffset == 0) ? dstSavings : -dstSavings;
            } 
    if(newTime > 0L && newTimeAdjusted < 0L && dstOffset == 0)            
            {
                newTimeAdjusted = 0x7fffffffffffffffL;
            } 
            else
    if(newTime < 0L && newTimeAdjusted > 0L && dstOffset != 0)            
            {
                newTimeAdjusted = 0x8000000000000000L;
            } 
            cachedFieldsCheckAndGet(time, newTime, newTimeAdjusted,
                    savedMillis, zoneOffset);
        } 
        else
        {
            fullFieldsCalc(time, savedMillis, zoneOffset);
        } 
for(int i = 0;i < FIELD_COUNT;i++)
        {
            isSet[i] = true;
        } 
    if(!isCached
                && newTime != 0x7fffffffffffffffL
                && newTime != 0x8000000000000000L
                && (!timeZone.useDaylightTime() || timeZone instanceof SimpleTimeZone))        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.110 -0400", hash_original_method = "2C41A89AB92A41E731883E58EB4B865A", hash_generated_method = "14DF9FF10FF5FF103D5668BF747C39BA")
    @Override
    protected void computeTime() {
    if(!isLenient())        
        {
    if(isSet[HOUR_OF_DAY])            
            {
    if(fields[HOUR_OF_DAY] < 0 || fields[HOUR_OF_DAY] > 23)                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1301844993 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_1301844993.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_1301844993;
                } 
            } 
            else
    if(isSet[HOUR] && (fields[HOUR] < 0 || fields[HOUR] > 11))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_702641256 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_702641256.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_702641256;
            } 
    if(isSet[MINUTE] && (fields[MINUTE] < 0 || fields[MINUTE] > 59))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_703396354 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_703396354.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_703396354;
            } 
    if(isSet[SECOND] && (fields[SECOND] < 0 || fields[SECOND] > 59))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_114988978 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_114988978.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_114988978;
            } 
    if(isSet[MILLISECOND]
                    && (fields[MILLISECOND] < 0 || fields[MILLISECOND] > 999))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1783332839 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1783332839.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1783332839;
            } 
    if(isSet[WEEK_OF_YEAR]
                    && (fields[WEEK_OF_YEAR] < 1 || fields[WEEK_OF_YEAR] > 53))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_902124109 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_902124109.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_902124109;
            } 
    if(isSet[DAY_OF_WEEK]
                    && (fields[DAY_OF_WEEK] < 1 || fields[DAY_OF_WEEK] > 7))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2107506319 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_2107506319.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_2107506319;
            } 
    if(isSet[DAY_OF_WEEK_IN_MONTH]
                    && (fields[DAY_OF_WEEK_IN_MONTH] < 1 || fields[DAY_OF_WEEK_IN_MONTH] > 6))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_860738119 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_860738119.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_860738119;
            } 
    if(isSet[WEEK_OF_MONTH]
                    && (fields[WEEK_OF_MONTH] < 1 || fields[WEEK_OF_MONTH] > 6))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1713739472 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1713739472.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1713739472;
            } 
    if(isSet[AM_PM] && fields[AM_PM] != AM && fields[AM_PM] != PM)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_836583582 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_836583582.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_836583582;
            } 
    if(isSet[HOUR] && (fields[HOUR] < 0 || fields[HOUR] > 11))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_14638659 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_14638659.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_14638659;
            } 
    if(isSet[YEAR])            
            {
    if(isSet[ERA] && fields[ERA] == BC
                        && (fields[YEAR] < 1 || fields[YEAR] > 292269054))                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1479187729 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_1479187729.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_1479187729;
                } 
                else
    if(fields[YEAR] < 1 || fields[YEAR] > 292278994)                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_888093823 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_888093823.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_888093823;
                } 
            } 
    if(isSet[MONTH] && (fields[MONTH] < 0 || fields[MONTH] > 11))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1433783355 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1433783355.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1433783355;
            } 
        } 
        long timeVal;
        long hour = 0;
    if(isSet[HOUR_OF_DAY] && lastTimeFieldSet != HOUR)        
        {
            hour = fields[HOUR_OF_DAY];
        } 
        else
    if(isSet[HOUR])        
        {
            hour = (fields[AM_PM] * 12) + fields[HOUR];
        } 
        timeVal = hour * 3600000;
    if(isSet[MINUTE])        
        {
            timeVal += ((long) fields[MINUTE]) * 60000;
        } 
    if(isSet[SECOND])        
        {
            timeVal += ((long) fields[SECOND]) * 1000;
        } 
    if(isSet[MILLISECOND])        
        {
            timeVal += fields[MILLISECOND];
        } 
        long days;
        int year = isSet[YEAR] ? fields[YEAR] : 1970;
    if(isSet[ERA])        
        {
    if(fields[ERA] != BC && fields[ERA] != AD)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1066938234 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1066938234.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1066938234;
            } 
    if(fields[ERA] == BC)            
            {
                year = 1 - year;
            } 
        } 
        boolean weekMonthSet = isSet[WEEK_OF_MONTH]
                || isSet[DAY_OF_WEEK_IN_MONTH];
        boolean useMonth = (isSet[DATE] || isSet[MONTH] || weekMonthSet)
                && lastDateFieldSet != DAY_OF_YEAR;
    if(useMonth
                && (lastDateFieldSet == DAY_OF_WEEK || lastDateFieldSet == WEEK_OF_YEAR))        
        {
    if(isSet[WEEK_OF_YEAR] && isSet[DAY_OF_WEEK])            
            {
                useMonth = lastDateFieldSet != WEEK_OF_YEAR && weekMonthSet
                        && isSet[DAY_OF_WEEK];
            } 
            else
    if(isSet[DAY_OF_YEAR])            
            {
                useMonth = isSet[DATE] && isSet[MONTH];
            } 
        } 
    if(useMonth)        
        {
            int month = fields[MONTH];
            year += month / 12;
            month %= 12;
    if(month < 0)            
            {
                year--;
                month += 12;
            } 
            boolean leapYear = isLeapYear(year);
            days = daysFromBaseYear(year) + daysInYear(leapYear, month);
            boolean useDate = isSet[DATE];
    if(useDate
                    && (lastDateFieldSet == DAY_OF_WEEK
                            || lastDateFieldSet == WEEK_OF_MONTH || lastDateFieldSet == DAY_OF_WEEK_IN_MONTH))            
            {
                useDate = !(isSet[DAY_OF_WEEK] && weekMonthSet);
            } 
    if(useDate)            
            {
    if(!isLenient()
                        && (fields[DATE] < 1 || fields[DATE] > daysInMonth(
                                leapYear, month)))                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1002172019 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_1002172019.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_1002172019;
                } 
                days += fields[DATE] - 1;
            } 
            else
            {
                int dayOfWeek;
    if(isSet[DAY_OF_WEEK])                
                {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } 
                else
                {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                } 
    if(isSet[WEEK_OF_MONTH]
                        && lastDateFieldSet != DAY_OF_WEEK_IN_MONTH)                
                {
                    int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += (fields[WEEK_OF_MONTH] - 1) * 7
                            + mod7(skew + dayOfWeek - (days - 3)) - skew;
                } 
                else
    if(isSet[DAY_OF_WEEK_IN_MONTH])                
                {
    if(fields[DAY_OF_WEEK_IN_MONTH] >= 0)                    
                    {
                        days += mod7(dayOfWeek - (days - 3))
                                + (fields[DAY_OF_WEEK_IN_MONTH] - 1) * 7;
                    } 
                    else
                    {
                        days += daysInMonth(leapYear, month)
                                + mod7(dayOfWeek
                                        - (days + daysInMonth(leapYear, month) - 3))
                                + fields[DAY_OF_WEEK_IN_MONTH] * 7;
                    } 
                } 
                else
    if(isSet[DAY_OF_WEEK])                
                {
                    int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += mod7(mod7(skew + dayOfWeek - (days - 3)) - skew);
                } 
            } 
        } 
        else
        {
            boolean useWeekYear = isSet[WEEK_OF_YEAR]
                    && lastDateFieldSet != DAY_OF_YEAR;
    if(useWeekYear && isSet[DAY_OF_YEAR])            
            {
                useWeekYear = isSet[DAY_OF_WEEK];
            } 
            days = daysFromBaseYear(year);
    if(useWeekYear)            
            {
                int dayOfWeek;
    if(isSet[DAY_OF_WEEK])                
                {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } 
                else
                {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                } 
                int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                days += (fields[WEEK_OF_YEAR] - 1) * 7
                        + mod7(skew + dayOfWeek - (days - 3)) - skew;
    if(7 - skew < getMinimalDaysInFirstWeek())                
                {
                    days += 7;
                } 
            } 
            else
    if(isSet[DAY_OF_YEAR])            
            {
    if(!isLenient()
                        && (fields[DAY_OF_YEAR] < 1 || fields[DAY_OF_YEAR] > (365 + (isLeapYear(year) ? 1
                                : 0))))                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_892303565 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_892303565.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_892303565;
                } 
                days += fields[DAY_OF_YEAR] - 1;
            } 
            else
    if(isSet[DAY_OF_WEEK])            
            {
                days += mod7(fields[DAY_OF_WEEK] - 1 - (days - 3));
            } 
        } 
        lastDateFieldSet = 0;
        timeVal += days * 86400000;
    if(year == changeYear
                && timeVal >= gregorianCutover + julianError() * 86400000L)        
        {
            timeVal -= julianError() * 86400000L;
        } 
        long timeValWithoutDST = timeVal - getOffset(timeVal)
                + getTimeZone().getRawOffset();
        timeVal -= getOffset(timeValWithoutDST);
        this.time = timeVal;
    if(timeValWithoutDST != timeVal)        
        {
            computeFields();
            areFieldsSet = true;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.116 -0400", hash_original_method = "2A644CA75A846A9F294F6A7DE0BAB232", hash_generated_method = "03B12E37069A3177D8DDBF5602EDCD0E")
    private int computeYearAndDay(long dayCount, long localTime) {
        addTaint(localTime);
        addTaint(dayCount);
        int year = 1970;
        long days = dayCount;
    if(localTime < gregorianCutover)        
        {
            days -= julianSkew;
        } 
        int approxYears;
        while
((approxYears = (int) (days / 365)) != 0)        
        {
            year = year + approxYears;
            days = dayCount - daysFromBaseYear(year);
        } 
    if(days < 0)        
        {
            year = year - 1;
            days = days + daysInYear(year);
        } 
        fields[YEAR] = year;
        int var48EC4340FAAB7B695A4B92142AEF4EE9_1148026632 = ((int) days + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930891544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930891544;
        
        
        
        
            
        
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.118 -0400", hash_original_method = "975CAA178CB1C52E2022FF53CD13129C", hash_generated_method = "CD26A380B6902DC5BBB06ECA8C384866")
    private long daysFromBaseYear(int iyear) {
        addTaint(iyear);
        long year = iyear;
    if(year >= 1970)        
        {
            long days = (year - 1970) * 365 + ((year - 1969) / 4);
    if(year > changeYear)            
            {
                days -= ((year - 1901) / 100) - ((year - 1601) / 400);
            } 
            else
            {
    if(year == changeYear)                
                {
                    days += currentYearSkew;
                } 
                else
    if(year == changeYear -1)                
                {
                    days += lastYearSkew;
                } 
                else
                {
                    days += julianSkew;
                } 
            } 
            long var44FDEC47036F482B68B748F9D786801B_885878783 = (days);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_779055779 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_779055779;
        } 
        else
    if(year <= changeYear)        
        {
            long var35D6CD95761BD6926A18867D312BEE94_1207427775 = ((year - 1970) * 365 + ((year - 1972) / 4) + julianSkew);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1444111104 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1444111104;
        } 
        long varA5D44FF3C40E933F306548B08A859B47_1357513609 = ((year - 1970) * 365 + ((year - 1972) / 4)
                - ((year - 2000) / 100) + ((year - 2000) / 400));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_492911865 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_492911865;
        
        
        
            
            
                
            
                
                    
                
                    
                
                    
                
            
            
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.119 -0400", hash_original_method = "B393AFA9309B3ECCDD74469F481095BD", hash_generated_method = "ACA122D28C4FC030613DA04972E81E19")
    private int daysInMonth() {
        int var215FE7C75DB0BF3B63047BEF73A9EBB3_445957670 = (daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762475602 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762475602;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.120 -0400", hash_original_method = "F030460418FCB84947C9AD9647C8CF35", hash_generated_method = "D1F137DE82E3F9DF519D9A08000C94FA")
    private int daysInMonth(boolean leapYear, int month) {
        addTaint(month);
        addTaint(leapYear);
    if(leapYear && month == FEBRUARY)        
        {
            int var63A86A6898A1B5484DE8E2A6BCC88EAC_1351212639 = (DaysInMonth[month] + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_789703772 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_789703772;
        } 
        int var16BCB2966AA46E02DF92EC5081BB44E3_1419128386 = (DaysInMonth[month]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474611867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474611867;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.121 -0400", hash_original_method = "643B799339D2A3831DACB9C12752109A", hash_generated_method = "6BD8EA16314BC856A47FBB53ECAB99C2")
    private int daysInYear(int year) {
        addTaint(year);
        int daysInYear = isLeapYear(year) ? 366 : 365;
    if(year == changeYear)        
        {
            daysInYear -= currentYearSkew;
        } 
    if(year == changeYear - 1)        
        {
            daysInYear -= lastYearSkew;
        } 
        int var6E5C2EF03C324199422107DFF3171D60_326878708 = (daysInYear);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877227089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877227089;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.122 -0400", hash_original_method = "7E255F605E98F52E53144D7126E773F6", hash_generated_method = "10001D92823AF6E7CFD16E804A47B5AE")
    private int daysInYear(boolean leapYear, int month) {
        addTaint(month);
        addTaint(leapYear);
    if(leapYear && month > FEBRUARY)        
        {
            int var3506CF06E4FF835EA4F1528CCE30A712_158204804 = (DaysInYear[month] + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455251843 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455251843;
        } 
        int var2DB45FAAFDF779F519D585E10C3F9FD7_1886588416 = (DaysInYear[month]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660909528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660909528;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.123 -0400", hash_original_method = "61C11EDCA3B03978A14421C2440916AB", hash_generated_method = "98E11243285FB18B369EC6EF15F83C1F")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(!(object instanceof GregorianCalendar))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1151985075 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392948327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392948327;
        } 
    if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1385836627 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606393019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_606393019;
        } 
        boolean var44CDC33DA152514F6A58C4E6B7562147_354364777 = (super.equals(object)
                && gregorianCutover == ((GregorianCalendar) object).gregorianCutover);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128127113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128127113;
        
        
            
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.126 -0400", hash_original_method = "F6A8281F341CD14B238EE5FA427449C3", hash_generated_method = "F117B158EB58FB414FCC48B35A5E814C")
    @Override
    public int getActualMaximum(int field) {
        addTaint(field);
        int value;
    if((value = maximums[field]) == leastMaximums[field])        
        {
            int var2063C1608D6E0BAF80249C42E2BE5804_2097936733 = (value);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023324127 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023324127;
        } 
switch(field){
        case WEEK_OF_YEAR:
        case WEEK_OF_MONTH:
        isCached = false;
        break;
}        complete();
        long orgTime = time;
        int result = 0;
switch(field){
        case WEEK_OF_YEAR:
        set(DATE, 31);
        set(MONTH, DECEMBER);
        result = get(WEEK_OF_YEAR);
    if(result == 1)        
        {
            set(DATE, 31 - 7);
            result = get(WEEK_OF_YEAR);
        } 
        areFieldsSet = false;
        break;
        case WEEK_OF_MONTH:
        set(DATE, daysInMonth());
        result = get(WEEK_OF_MONTH);
        areFieldsSet = false;
        break;
        case DATE:
        int varDC131347AC637B3CF5167754085ADF72_1944390507 = (daysInMonth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169255743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169255743;
        case DAY_OF_YEAR:
        int var87D04C2266D2A41EE2D6E5B7F0269E78_197378425 = (daysInYear(fields[YEAR]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52894522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52894522;
        case DAY_OF_WEEK_IN_MONTH:
        result = get(DAY_OF_WEEK_IN_MONTH)
                        + ((daysInMonth() - get(DATE)) / 7);
        break;
        case YEAR:
        GregorianCalendar clone = (GregorianCalendar) clone();
    if(get(ERA) == AD)        
        {
            clone.setTimeInMillis(Long.MAX_VALUE);
        } 
        else
        {
            clone.setTimeInMillis(Long.MIN_VALUE);
        } 
        result = clone.get(YEAR);
        clone.set(YEAR, get(YEAR));
    if(clone.before(this))        
        {
            result--;
        } 
        break;
        case DST_OFFSET:
        result = getMaximum(DST_OFFSET);
        break;
}        time = orgTime;
        int varB4A88417B3D0170D754C647C30B7216A_1858561280 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917586359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917586359;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.128 -0400", hash_original_method = "0094646504037C44C448A8626AEC2CA3", hash_generated_method = "B8D59B742EFD9900826A8A5DC5087817")
    @Override
    public int getActualMinimum(int field) {
        addTaint(field);
        int var46426DDAE003BEA3036B79B8FDF3849A_521769725 = (getMinimum(field));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585633708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585633708;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.128 -0400", hash_original_method = "F3CD156C4D2759DEA34A15A000EAB551", hash_generated_method = "6546691D33492F6BAD29240047FEB4AB")
    @Override
    public int getGreatestMinimum(int field) {
        addTaint(field);
        int varAA6E26B2CBA469CCA54B67CC2A8278AA_1134563663 = (minimums[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918481494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918481494;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.129 -0400", hash_original_method = "BD206861177D272D9EC33433339CB64F", hash_generated_method = "38AF60DA8F2D34C238B080A54434B4DA")
    public final Date getGregorianChange() {
Date var30D73D984C20176C0D7FB6C2B553BF0A_605176574 =         new Date(gregorianCutover);
        var30D73D984C20176C0D7FB6C2B553BF0A_605176574.addTaint(taint);
        return var30D73D984C20176C0D7FB6C2B553BF0A_605176574;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.130 -0400", hash_original_method = "3B0100990EBACC07D6E54BAA89A3102A", hash_generated_method = "9562ED3CBC9F917E1E10C4425FB43101")
    @Override
    public int getLeastMaximum(int field) {
        addTaint(field);
    if(gregorianCutover != defaultGregorianCutover
                && field == WEEK_OF_YEAR)        
        {
            long currentTimeInMillis = time;
            setTimeInMillis(gregorianCutover);
            int actual = getActualMaximum(field);
            setTimeInMillis(currentTimeInMillis);
            int var5157E3C765AF93679EA07052F30F0A6E_2018581390 = (actual);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931305974 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931305974;
        } 
        int var857D9AA0C7F57F448846860E6BAAF48C_789359096 = (leastMaximums[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859626765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859626765;
        
        
                
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.130 -0400", hash_original_method = "80794FF1ED1E8F2177114BCAA53EED59", hash_generated_method = "D99DAD8FF6B25EBF1D2EEE35389F8888")
    @Override
    public int getMaximum(int field) {
        addTaint(field);
        int var2115410AD9D2F23189053B80BA420D83_1553569208 = (maximums[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135252279 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135252279;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.131 -0400", hash_original_method = "1A09A14EE8971B3B0503081305AF18CB", hash_generated_method = "B804DD3865FC280CBF6F4E703E9CBC80")
    @Override
    public int getMinimum(int field) {
        addTaint(field);
        int varAA6E26B2CBA469CCA54B67CC2A8278AA_792316331 = (minimums[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669812520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669812520;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.133 -0400", hash_original_method = "A5F3F970AF018D82525827EF3879E8F1", hash_generated_method = "C62DB42C488371A3FD06DB14228D1314")
    private int getOffset(long localTime) {
        addTaint(localTime);
        TimeZone timeZone = getTimeZone();
        long dayCount = localTime / 86400000;
        int millis = (int) (localTime % 86400000);
    if(millis < 0)        
        {
            millis += 86400000;
            dayCount--;
        } 
        int year = 1970;
        long days = dayCount;
    if(localTime < gregorianCutover)        
        {
            days -= julianSkew;
        } 
        int approxYears;
        while
((approxYears = (int) (days / 365)) != 0)        
        {
            year = year + approxYears;
            days = dayCount - daysFromBaseYear(year);
        } 
    if(days < 0)        
        {
            year = year - 1;
            days = days + 365 + (isLeapYear(year) ? 1 : 0);
    if(year == changeYear && localTime < gregorianCutover)            
            {
                days -= julianError();
            } 
        } 
    if(year <= 0)        
        {
            int varD55F8146D5D8F78547A7EB0E9CAC5E41_1677047414 = (timeZone.getRawOffset());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_10998318 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_10998318;
        } 
        int dayOfYear = (int) days + 1;
        int month = dayOfYear / 32;
        boolean leapYear = isLeapYear(year);
        int date = dayOfYear - daysInYear(leapYear, month);
    if(date > daysInMonth(leapYear, month))        
        {
            date -= daysInMonth(leapYear, month);
            month++;
        } 
        int dayOfWeek = mod7(dayCount - 3) + 1;
        int offset = timeZone.getOffset(AD, year, month, date, dayOfWeek,
                millis);
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_979747819 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890092960 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890092960;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.135 -0400", hash_original_method = "6907F2ED2DF57E219AB70EADED509565", hash_generated_method = "EE15D27C3FCDEF89ED1AC4BAAAF2FDB4")
    @Override
    public int hashCode() {
        int var545DD072C17145ABB13A4EE7D4DA3C35_1041282394 = (super.hashCode()
                + ((int) (gregorianCutover >>> 32) ^ (int) gregorianCutover));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564705948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564705948;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.136 -0400", hash_original_method = "FD1210B9D1DAC87CC2975B1EB57E42AE", hash_generated_method = "F3F5EDDBDB73F2B72E2FC2C53CE14770")
    public boolean isLeapYear(int year) {
        addTaint(year);
    if(year > changeYear)        
        {
            boolean var8D10941BA0EA240F16D860C0C63718A6_1340831375 = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743561904 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_743561904;
        } 
        boolean varB4F34FCD703C0F9E6D7D856801C659D4_346256130 = (year % 4 == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368501104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368501104;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.137 -0400", hash_original_method = "6792E5EC134CCE3576D348D7664F192E", hash_generated_method = "8A7B18D4E811F2AD6771C8345245FF36")
    private int julianError() {
        int var3697CF08EA814E7CEA6F0785303746B7_1538551267 = (changeYear / 100 - changeYear / 400 - 2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120806674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120806674;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.138 -0400", hash_original_method = "C7B77E5A8B6CB394A26ACFDB4CA2A34C", hash_generated_method = "CC45EA84081DA9876D409980C0DE2F54")
    private int mod(int value, int mod) {
        addTaint(mod);
        addTaint(value);
        int rem = value % mod;
    if(value < 0 && rem < 0)        
        {
            int var8DBED730CCDB4B5FE3FF247A070AEB60_875443031 = (rem + mod);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816284650 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816284650;
        } 
        int var5CADB523CB6909F92350F70F124ADFB8_451195223 = (rem);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1424295308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1424295308;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.138 -0400", hash_original_method = "B5B6FCF50F48D18673AA227255C5F0A5", hash_generated_method = "2961EF03E80BAF2B2AF57B9722331868")
    private int mod7(long num1) {
        addTaint(num1);
        int rem = (int) (num1 % 7);
    if(num1 < 0 && rem < 0)        
        {
            int var00AD68AE71482771F548BCF4FCD10AC2_1187491165 = (rem + 7);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62747519 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62747519;
        } 
        int var5CADB523CB6909F92350F70F124ADFB8_1373916694 = (rem);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643837524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643837524;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.142 -0400", hash_original_method = "B265969ED1D5B160D0AFF42D0A073F4D", hash_generated_method = "EC9D113378A2D566FEF3F6F101FA477B")
    @Override
    public void roll(int field, int value) {
        addTaint(value);
        addTaint(field);
    if(value == 0)        
        {
            return;
        } 
    if(field < 0 || field >= ZONE_OFFSET)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_826142946 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_826142946.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_826142946;
        } 
        isCached = false;
        complete();
        int days;
        int day;
        int mod;
        int maxWeeks;
        int newWeek;
        int max = -1;
switch(field){
        case YEAR:
        max = maximums[field];
        break;
        case WEEK_OF_YEAR:
        days = daysInYear(fields[YEAR]);
        day = DAY_OF_YEAR;
        mod = mod7(fields[DAY_OF_WEEK] - fields[day]
                    - (getFirstDayOfWeek() - 1));
        maxWeeks = (days - 1 + mod) / 7 + 1;
        newWeek = mod(fields[field] - 1 + value, maxWeeks) + 1;
    if(newWeek == maxWeeks)        
        {
            int addDays = (newWeek - fields[field]) * 7;
    if(fields[day] > addDays && fields[day] + addDays > days)            
            {
                set(field, 1);
            } 
            else
            {
                set(field, newWeek - 1);
            } 
        } 
        else
    if(newWeek == 1)        
        {
            int week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
    if(week > 1)            
            {
                set(field, 1);
            } 
            else
            {
                set(field, newWeek);
            } 
        } 
        else
        {
            set(field, newWeek);
        } 
        break;
        case WEEK_OF_MONTH:
        days = daysInMonth();
        day = DATE;
        mod = mod7(fields[DAY_OF_WEEK] - fields[day]
                    - (getFirstDayOfWeek() - 1));
        maxWeeks = (days - 1 + mod) / 7 + 1;
        newWeek = mod(fields[field] - 1 + value, maxWeeks) + 1;
    if(newWeek == maxWeeks)        
        {
    if(fields[day] + (newWeek - fields[field]) * 7 > days)            
            {
                set(day, days);
            } 
            else
            {
                set(field, newWeek);
            } 
        } 
        else
    if(newWeek == 1)        
        {
            int week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
    if(week > 1)            
            {
                set(day, 1);
            } 
            else
            {
                set(field, newWeek);
            } 
        } 
        else
        {
            set(field, newWeek);
        } 
        break;
        case DATE:
        max = daysInMonth();
        break;
        case DAY_OF_YEAR:
        max = daysInYear(fields[YEAR]);
        break;
        case DAY_OF_WEEK:
        max = maximums[field];
        lastDateFieldSet = WEEK_OF_MONTH;
        break;
        case DAY_OF_WEEK_IN_MONTH:
        max = (fields[DATE] + ((daysInMonth() - fields[DATE]) / 7 * 7) - 1) / 7 + 1;
        break;
        case ERA:
        case MONTH:
        case AM_PM:
        case HOUR:
        case HOUR_OF_DAY:
        case MINUTE:
        case SECOND:
        case MILLISECOND:
        set(field, mod(fields[field] + value, maximums[field] + 1));
    if(field == MONTH && fields[DATE] > daysInMonth())        
        {
            set(DATE, daysInMonth());
        } 
        else
    if(field == AM_PM)        
        {
            lastTimeFieldSet = HOUR;
        } 
        break;
}    if(max != -1)        
        {
            set(field, mod(fields[field] - 1 + value, max) + 1);
        } 
        complete();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.143 -0400", hash_original_method = "011BFEF6AF7823592586BFF14A1F0FAF", hash_generated_method = "137405C6FC3DEE68159AF69D7F408B1D")
    @Override
    public void roll(int field, boolean increment) {
        addTaint(increment);
        addTaint(field);
        roll(field, increment ? 1 : -1);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.145 -0400", hash_original_method = "BBA926F39AADCD3D723F5CC72B7A16F3", hash_generated_method = "4933AE1EEBDFC946CD582F25E4B2BBD5")
    public void setGregorianChange(Date date) {
        gregorianCutover = date.getTime();
        GregorianCalendar cal = new GregorianCalendar(TimeZone.GMT);
        cal.setTime(date);
        changeYear = cal.get(YEAR);
    if(cal.get(ERA) == BC)        
        {
            changeYear = 1 - changeYear;
        } 
        julianSkew = ((changeYear - 2000) / 400) + julianError()
                - ((changeYear - 2000) / 100);
        isCached = false;
        int dayOfYear = cal.get(DAY_OF_YEAR);
    if(dayOfYear < julianSkew)        
        {
            currentYearSkew = dayOfYear-1;
            lastYearSkew = julianSkew - dayOfYear + 1;
        } 
        else
        {
            lastYearSkew = 0;
            currentYearSkew = julianSkew;
        } 
        isCached = false;
        
        
        
        
        
        
            
        
        
                
        
        
        
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.145 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "1284A1B8BFD40E947242B6FBDC302E7A")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.146 -0400", hash_original_method = "6812E7459A56AAC638E0A1455D3A3623", hash_generated_method = "876D110AFE295CBDBB402FE5D0D6EC6A")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        setGregorianChange(new Date(gregorianCutover));
        isCached = false;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.146 -0400", hash_original_method = "803EF27234E46811EE9F1109A1277F23", hash_generated_method = "A4334078C06FF158AFBC6F799AC1C61C")
    @Override
    public void setFirstDayOfWeek(int value) {
        addTaint(value);
        super.setFirstDayOfWeek(value);
        isCached = false;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.147 -0400", hash_original_method = "77A4B23D11FEBAAF4DA5B074DBE88F4F", hash_generated_method = "5515E6F80BC8E1CEFFE9F4AF765D318F")
    @Override
    public void setMinimalDaysInFirstWeek(int value) {
        addTaint(value);
        super.setMinimalDaysInFirstWeek(value);
        isCached = false;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.147 -0400", hash_original_field = "1C4EA65D0B85820031DB54E0B782FD43", hash_generated_field = "B9386A44E9BFA9A5ED8D3E7882B2C9E1")

    private static final long serialVersionUID = -8125100834729963327L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.147 -0400", hash_original_field = "9AD044AF9694EBAE04C6A843D8BD814D", hash_generated_field = "93BFF7C10A82D9138EF2CEC785C901D2")

    public static final int BC = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.147 -0400", hash_original_field = "B7B6AD4BCE48136317BC53C29D899D81", hash_generated_field = "BC845EBD4DA20DC255F4737CB21267E2")

    public static final int AD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.147 -0400", hash_original_field = "3C2061F8784D53F3CF214EF2B5C44347", hash_generated_field = "23BA66807055EDC52580EFE8B68EA6D9")

    private static final long defaultGregorianCutover = -12219292800000l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.147 -0400", hash_original_field = "F75D8DB91544852469A5E6BD6B9261C6", hash_generated_field = "D109403F40DEAA9D96D5485CCE288282")

    static byte[] DaysInMonth = new byte[] { 31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.147 -0400", hash_original_field = "FA59282D92997F8368B0D198B418DB90", hash_generated_field = "0A4DD57D0556CD2CAD7A071A46A83584")

    private static int[] DaysInYear = new int[] { 0, 31, 59, 90, 120, 151, 181,
            212, 243, 273, 304, 334 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.147 -0400", hash_original_field = "AB38F25D3064B346C2337034E2A43B7E", hash_generated_field = "9C039D691AF795C6B392702421AF992F")

    private static int[] maximums = new int[] { 1, 292278994, 11, 53, 6, 31,
            366, 7, 6, 1, 11, 23, 59, 59, 999, 14 * 3600 * 1000, 7200000 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.148 -0400", hash_original_field = "86C59D996E94DD35B58C61607BD56009", hash_generated_field = "34197BE97C1359ACB541F3CFF4B6D197")

    private static int[] minimums = new int[] { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0,
            0, 0, 0, 0, 0, -13 * 3600 * 1000, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.148 -0400", hash_original_field = "1119798B7094D66F851E9E0B02F12B51", hash_generated_field = "72A42F262CE1CA8E4E3156D2F2A817C5")

    private static int[] leastMaximums = new int[] { 1, 292269054, 11, 50, 3,
            28, 355, 7, 3, 1, 11, 23, 59, 59, 999, 50400000, 1200000 };
}

