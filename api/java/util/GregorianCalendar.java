package java.util;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class GregorianCalendar extends Calendar {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "400857AF5F099B78A86D8F68DDA6A04C", hash_generated_field = "EA14FB63AF074345B169453863E64EC4")

    private long gregorianCutover = defaultGregorianCutover;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "2237A6A77C737B6DE347542050A70C16", hash_generated_field = "A0B8CA27149DD74350CDB7EC98C60162")

    private transient int changeYear = 1582;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "B31858CD0ADA5C474F1168521920B10A", hash_generated_field = "2808C9DD640CD873EE96A55ECDBB8D85")

    private transient int julianSkew = ((changeYear - 2000) / 400)
            + julianError() - ((changeYear - 2000) / 100);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "4B7219F27A11B1E89794219BC39393A8")

    private boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "48BDECEAC3EC7DF64DC015EE1647B63D", hash_generated_field = "7AF7C45B7A2B45D012327222457CC902")

    private int[] cachedFields = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "29BEE66E54150507B1EAE04F51499A76", hash_generated_field = "EAB4464060441E8E83529F625B8AC792")

    private long nextMidnightMillis = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "48A2AA6D81A9C01929B5C02CE7D1A7AD", hash_generated_field = "A139545ACF978509DA3F6AC55F657D39")

    private long lastMidnightMillis = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "4C645BB4AD56D54A8545F69CF4FCB94D", hash_generated_field = "657D9B61D3147BAB9300368D7E5B963D")

    private int currentYearSkew = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_field = "DEFBAD132BF50B6929249287EA3B13E8", hash_generated_field = "A15FC9D51CCB159121982FD9BA383E19")

    private int lastYearSkew = 0;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.756 -0400", hash_original_method = "7EB3091E87333B7AA987345512812570", hash_generated_method = "2E973698D04F2D2AAC57C914B74CED19")
    public  GregorianCalendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.757 -0400", hash_original_method = "B0762BDDD2B39759F6CE94DB8F25D3E0", hash_generated_method = "38F0A9BF75F9A56470D2031A9E0A5D2D")
    public  GregorianCalendar(int year, int month, int day) {
        super(TimeZone.getDefault(), Locale.getDefault());
        addTaint(day);
        addTaint(month);
        addTaint(year);
        set(year, month, day);
        // ---------- Original Method ----------
        //set(year, month, day);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.757 -0400", hash_original_method = "D6C72587979F1136CC7CF710B2F32D12", hash_generated_method = "F7EFABA788F844F525D02243BF9520F0")
    public  GregorianCalendar(int year, int month, int day, int hour, int minute) {
        super(TimeZone.getDefault(), Locale.getDefault());
        addTaint(minute);
        addTaint(hour);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        set(year, month, day, hour, minute);
        // ---------- Original Method ----------
        //set(year, month, day, hour, minute);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.758 -0400", hash_original_method = "BC793B84C6DC2AD69827C6FC0D0FCEDD", hash_generated_method = "FC0236E2BF577D7CE57E3BA1598443DF")
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
        // ---------- Original Method ----------
        //set(year, month, day, hour, minute, second);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.759 -0400", hash_original_method = "63C34121AB8507D7813FBAF0F269A9D2", hash_generated_method = "DBDDB5E1B686CEF0A39C004ACB03E3DF")
      GregorianCalendar(long milliseconds) {
        this(false);
        addTaint(milliseconds);
        setTimeInMillis(milliseconds);
        // ---------- Original Method ----------
        //setTimeInMillis(milliseconds);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.760 -0400", hash_original_method = "56E3B8EB09DD30B0731434891C29D1A4", hash_generated_method = "4EF55C9A9234380F5CABEBE8788FA517")
    public  GregorianCalendar(Locale locale) {
        this(TimeZone.getDefault(), locale);
        addTaint(locale.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.760 -0400", hash_original_method = "7987E4D71BE0DBF5086B038B74101A38", hash_generated_method = "1274F0C4BA04C348AAE90FD4E15265AE")
    public  GregorianCalendar(TimeZone timezone) {
        this(timezone, Locale.getDefault());
        addTaint(timezone.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.760 -0400", hash_original_method = "98E484CB97D77C9503930A8DB608CAE2", hash_generated_method = "16236B43E103E0BE92398E5AAC116A6B")
    public  GregorianCalendar(TimeZone timezone, Locale locale) {
        super(timezone, locale);
        addTaint(locale.getTaint());
        addTaint(timezone.getTaint());
        setTimeInMillis(System.currentTimeMillis());
        // ---------- Original Method ----------
        //setTimeInMillis(System.currentTimeMillis());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.761 -0400", hash_original_method = "0CE38BA4675BDF22B153CA671467EBE6", hash_generated_method = "19136D995F6410ABA81A5328621EBDCA")
      GregorianCalendar(boolean ignored) {
        super(TimeZone.getDefault());
        addTaint(ignored);
        setFirstDayOfWeek(SUNDAY);
        setMinimalDaysInFirstWeek(1);
        // ---------- Original Method ----------
        //setFirstDayOfWeek(SUNDAY);
        //setMinimalDaysInFirstWeek(1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.763 -0400", hash_original_method = "1FE1308881E1142F9D3B7A007897B586", hash_generated_method = "E9A0C82AFB3D52D59130B0C3EC476F2C")
    @Override
    public void add(int field, int value) {
        addTaint(value);
        addTaint(field);
        if(value == 0)        
        {
            return;
        } //End block
        if(field < 0 || field >= ZONE_OFFSET)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_720556094 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_720556094.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_720556094;
        } //End block
        isCached = false;
        if(field == ERA)        
        {
            complete();
            if(fields[ERA] == AD)            
            {
                if(value >= 0)                
                {
                    return;
                } //End block
                set(ERA, BC);
            } //End block
            else
            {
                if(value <= 0)                
                {
                    return;
                } //End block
                set(ERA, AD);
            } //End block
            complete();
            return;
        } //End block
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
                } //End block
                else
                {
                    value = month / 12;
                } //End block
                set(MONTH, month % 12);
            } //End block
            set(YEAR, fields[YEAR] + value);
            int days = daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]);
            if(fields[DATE] > days)            
            {
                set(DATE, days);
            } //End block
            complete();
            return;
        } //End block
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
}        if(multiplier == 0)        
        {
            areFieldsSet = false;
            complete();
            return;
        } //End block
        long delta = value * multiplier;
        int zoneOffset = getTimeZone().getRawOffset();
        int offsetBefore = getOffset(time + zoneOffset);
        int offsetAfter = getOffset(time + zoneOffset + delta);
        int dstDelta = offsetBefore - offsetAfter;
        if(getOffset(time + zoneOffset + delta + dstDelta) == offsetAfter)        
        {
            delta += dstDelta;
        } //End block
        time += delta;
        areFieldsSet = false;
        complete();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.764 -0400", hash_original_method = "4451E97BB30CB152B3F7FF3125B7AC95", hash_generated_method = "8916C04488016ED7E193981763D3D3FF")
    @Override
    public Object clone() {
        GregorianCalendar thisClone = (GregorianCalendar) super.clone();
        thisClone.cachedFields = cachedFields.clone();
Object varAEB7DF9800272FF7E732FE6AE6B21A82_667158537 =         thisClone;
        varAEB7DF9800272FF7E732FE6AE6B21A82_667158537.addTaint(taint);
        return varAEB7DF9800272FF7E732FE6AE6B21A82_667158537;
        // ---------- Original Method ----------
        //GregorianCalendar thisClone = (GregorianCalendar) super.clone();
        //thisClone.cachedFields = cachedFields.clone();
        //return thisClone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.769 -0400", hash_original_method = "005B3A99F85903E106454DD8B0079421", hash_generated_method = "B00FF7F489554B4BBE66F341253BCD66")
    private final void fullFieldsCalc(long timeVal, int millis, int zoneOffset) {
        addTaint(zoneOffset);
        addTaint(millis);
        addTaint(timeVal);
        long days = timeVal / 86400000;
        if(millis < 0)        
        {
            millis += 86400000;
            days--;
        } //End block
        millis += zoneOffset;
        while
(millis < 0)        
        {
            millis += 86400000;
            days--;
        } //End block
        while
(millis >= 86400000)        
        {
            millis -= 86400000;
            days++;
        } //End block
        int dayOfYear = computeYearAndDay(days, timeVal + zoneOffset);
        fields[DAY_OF_YEAR] = dayOfYear;
        if(fields[YEAR] == changeYear && gregorianCutover <= timeVal + zoneOffset)        
        {
            dayOfYear += currentYearSkew;
        } //End block
        int month = dayOfYear / 32;
        boolean leapYear = isLeapYear(fields[YEAR]);
        int date = dayOfYear - daysInYear(leapYear, month);
        if(date > daysInMonth(leapYear, month))        
        {
            date -= daysInMonth(leapYear, month);
            month++;
        } //End block
        fields[DAY_OF_WEEK] = mod7(days - 3) + 1;
        int dstOffset = fields[YEAR] <= 0 ? 0 : getTimeZone().getOffset(AD,
                fields[YEAR], month, date, fields[DAY_OF_WEEK], millis);
        if(fields[YEAR] > 0)        
        {
            dstOffset -= zoneOffset;
        } //End block
        fields[DST_OFFSET] = dstOffset;
        if(dstOffset != 0)        
        {
            long oldDays = days;
            millis += dstOffset;
            if(millis < 0)            
            {
                millis += 86400000;
                days--;
            } //End block
            else
            if(millis >= 86400000)            
            {
                millis -= 86400000;
                days++;
            } //End block
            if(oldDays != days)            
            {
                dayOfYear = computeYearAndDay(days, timeVal - zoneOffset
                        + dstOffset);
                fields[DAY_OF_YEAR] = dayOfYear;
                if(fields[YEAR] == changeYear && gregorianCutover <= timeVal - zoneOffset + dstOffset)                
                {
                    dayOfYear += currentYearSkew;
                } //End block
                month = dayOfYear / 32;
                leapYear = isLeapYear(fields[YEAR]);
                date = dayOfYear - daysInYear(leapYear, month);
                if(date > daysInMonth(leapYear, month))                
                {
                    date -= daysInMonth(leapYear, month);
                    month++;
                } //End block
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
        if(fields[YEAR] <= 0)        
        {
            fields[ERA] = BC;
            fields[YEAR] = -fields[YEAR] + 1;
        } //End block
        else
        {
            fields[ERA] = AD;
        } //End block
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
        } //End block
        else
        if(fields[DAY_OF_YEAR] >= (leapYear ? 367 : 366)
                - mod7(daysFromStart + (leapYear ? 2 : 1)))        
        {
            fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart + (leapYear ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 1
                    : week;
        } //End block
        else
        {
            fields[WEEK_OF_YEAR] = week;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.771 -0400", hash_original_method = "2E866A22E927A34EE822F5C0BBDFB40C", hash_generated_method = "8876970B2E20F826390CCA4B64F38729")
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
        } //End block
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.774 -0400", hash_original_method = "B0DF08CEBB1EE730F98FF9762C9FEBD4", hash_generated_method = "87253D919D628CA2225925A01EF2B0D0")
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
        } //End block
        else
        if(time < 0L && newTime > 0L && offset < 0)        
        {
            newTime = 0x8000000000000000L;
        } //End block
        if(isCached)        
        {
            if(millis < 0)            
            {
                millis += 86400000;
            } //End block
            millis += zoneOffset;
            millis += dstOffset;
            if(millis < 0)            
            {
                millis += 86400000;
            } //End block
            else
            if(millis >= 86400000)            
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
            long newTimeAdjusted = newTime;
            if(timeZone.useDaylightTime())            
            {
                int dstSavings = timeZone.getDSTSavings();
                newTimeAdjusted += (dstOffset == 0) ? dstSavings : -dstSavings;
            } //End block
            if(newTime > 0L && newTimeAdjusted < 0L && dstOffset == 0)            
            {
                newTimeAdjusted = 0x7fffffffffffffffL;
            } //End block
            else
            if(newTime < 0L && newTimeAdjusted > 0L && dstOffset != 0)            
            {
                newTimeAdjusted = 0x8000000000000000L;
            } //End block
            cachedFieldsCheckAndGet(time, newTime, newTimeAdjusted,
                    savedMillis, zoneOffset);
        } //End block
        else
        {
            fullFieldsCalc(time, savedMillis, zoneOffset);
        } //End block
for(int i = 0;i < FIELD_COUNT;i++)
        {
            isSet[i] = true;
        } //End block
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.780 -0400", hash_original_method = "2C41A89AB92A41E731883E58EB4B865A", hash_generated_method = "82D9244D4B4CB7BADFD1BF220D407922")
    @Override
    protected void computeTime() {
        if(!isLenient())        
        {
            if(isSet[HOUR_OF_DAY])            
            {
                if(fields[HOUR_OF_DAY] < 0 || fields[HOUR_OF_DAY] > 23)                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_315010141 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_315010141.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_315010141;
                } //End block
            } //End block
            else
            if(isSet[HOUR] && (fields[HOUR] < 0 || fields[HOUR] > 11))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_997466684 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_997466684.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_997466684;
            } //End block
            if(isSet[MINUTE] && (fields[MINUTE] < 0 || fields[MINUTE] > 59))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_396259016 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_396259016.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_396259016;
            } //End block
            if(isSet[SECOND] && (fields[SECOND] < 0 || fields[SECOND] > 59))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_831304194 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_831304194.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_831304194;
            } //End block
            if(isSet[MILLISECOND]
                    && (fields[MILLISECOND] < 0 || fields[MILLISECOND] > 999))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_227960880 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_227960880.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_227960880;
            } //End block
            if(isSet[WEEK_OF_YEAR]
                    && (fields[WEEK_OF_YEAR] < 1 || fields[WEEK_OF_YEAR] > 53))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1897299210 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1897299210.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1897299210;
            } //End block
            if(isSet[DAY_OF_WEEK]
                    && (fields[DAY_OF_WEEK] < 1 || fields[DAY_OF_WEEK] > 7))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_284384487 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_284384487.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_284384487;
            } //End block
            if(isSet[DAY_OF_WEEK_IN_MONTH]
                    && (fields[DAY_OF_WEEK_IN_MONTH] < 1 || fields[DAY_OF_WEEK_IN_MONTH] > 6))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_789522984 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_789522984.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_789522984;
            } //End block
            if(isSet[WEEK_OF_MONTH]
                    && (fields[WEEK_OF_MONTH] < 1 || fields[WEEK_OF_MONTH] > 6))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1801428473 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1801428473.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1801428473;
            } //End block
            if(isSet[AM_PM] && fields[AM_PM] != AM && fields[AM_PM] != PM)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1979319134 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1979319134.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1979319134;
            } //End block
            if(isSet[HOUR] && (fields[HOUR] < 0 || fields[HOUR] > 11))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1076122421 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1076122421.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1076122421;
            } //End block
            if(isSet[YEAR])            
            {
                if(isSet[ERA] && fields[ERA] == BC
                        && (fields[YEAR] < 1 || fields[YEAR] > 292269054))                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_93329016 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_93329016.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_93329016;
                } //End block
                else
                if(fields[YEAR] < 1 || fields[YEAR] > 292278994)                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_287710802 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_287710802.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_287710802;
                } //End block
            } //End block
            if(isSet[MONTH] && (fields[MONTH] < 0 || fields[MONTH] > 11))            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1059867090 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1059867090.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1059867090;
            } //End block
        } //End block
        long timeVal;
        long hour = 0;
        if(isSet[HOUR_OF_DAY] && lastTimeFieldSet != HOUR)        
        {
            hour = fields[HOUR_OF_DAY];
        } //End block
        else
        if(isSet[HOUR])        
        {
            hour = (fields[AM_PM] * 12) + fields[HOUR];
        } //End block
        timeVal = hour * 3600000;
        if(isSet[MINUTE])        
        {
            timeVal += ((long) fields[MINUTE]) * 60000;
        } //End block
        if(isSet[SECOND])        
        {
            timeVal += ((long) fields[SECOND]) * 1000;
        } //End block
        if(isSet[MILLISECOND])        
        {
            timeVal += fields[MILLISECOND];
        } //End block
        long days;
        int year = isSet[YEAR] ? fields[YEAR] : 1970;
        if(isSet[ERA])        
        {
            if(fields[ERA] != BC && fields[ERA] != AD)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2130783472 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_2130783472.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_2130783472;
            } //End block
            if(fields[ERA] == BC)            
            {
                year = 1 - year;
            } //End block
        } //End block
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
            } //End block
            else
            if(isSet[DAY_OF_YEAR])            
            {
                useMonth = isSet[DATE] && isSet[MONTH];
            } //End block
        } //End block
        if(useMonth)        
        {
            int month = fields[MONTH];
            year += month / 12;
            month %= 12;
            if(month < 0)            
            {
                year--;
                month += 12;
            } //End block
            boolean leapYear = isLeapYear(year);
            days = daysFromBaseYear(year) + daysInYear(leapYear, month);
            boolean useDate = isSet[DATE];
            if(useDate
                    && (lastDateFieldSet == DAY_OF_WEEK
                            || lastDateFieldSet == WEEK_OF_MONTH || lastDateFieldSet == DAY_OF_WEEK_IN_MONTH))            
            {
                useDate = !(isSet[DAY_OF_WEEK] && weekMonthSet);
            } //End block
            if(useDate)            
            {
                if(!isLenient()
                        && (fields[DATE] < 1 || fields[DATE] > daysInMonth(
                                leapYear, month)))                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_706586230 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_706586230.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_706586230;
                } //End block
                days += fields[DATE] - 1;
            } //End block
            else
            {
                int dayOfWeek;
                if(isSet[DAY_OF_WEEK])                
                {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } //End block
                else
                {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                } //End block
                if(isSet[WEEK_OF_MONTH]
                        && lastDateFieldSet != DAY_OF_WEEK_IN_MONTH)                
                {
                    int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += (fields[WEEK_OF_MONTH] - 1) * 7
                            + mod7(skew + dayOfWeek - (days - 3)) - skew;
                } //End block
                else
                if(isSet[DAY_OF_WEEK_IN_MONTH])                
                {
                    if(fields[DAY_OF_WEEK_IN_MONTH] >= 0)                    
                    {
                        days += mod7(dayOfWeek - (days - 3))
                                + (fields[DAY_OF_WEEK_IN_MONTH] - 1) * 7;
                    } //End block
                    else
                    {
                        days += daysInMonth(leapYear, month)
                                + mod7(dayOfWeek
                                        - (days + daysInMonth(leapYear, month) - 3))
                                + fields[DAY_OF_WEEK_IN_MONTH] * 7;
                    } //End block
                } //End block
                else
                if(isSet[DAY_OF_WEEK])                
                {
                    int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += mod7(mod7(skew + dayOfWeek - (days - 3)) - skew);
                } //End block
            } //End block
        } //End block
        else
        {
            boolean useWeekYear = isSet[WEEK_OF_YEAR]
                    && lastDateFieldSet != DAY_OF_YEAR;
            if(useWeekYear && isSet[DAY_OF_YEAR])            
            {
                useWeekYear = isSet[DAY_OF_WEEK];
            } //End block
            days = daysFromBaseYear(year);
            if(useWeekYear)            
            {
                int dayOfWeek;
                if(isSet[DAY_OF_WEEK])                
                {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } //End block
                else
                {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                } //End block
                int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                days += (fields[WEEK_OF_YEAR] - 1) * 7
                        + mod7(skew + dayOfWeek - (days - 3)) - skew;
                if(7 - skew < getMinimalDaysInFirstWeek())                
                {
                    days += 7;
                } //End block
            } //End block
            else
            if(isSet[DAY_OF_YEAR])            
            {
                if(!isLenient()
                        && (fields[DAY_OF_YEAR] < 1 || fields[DAY_OF_YEAR] > (365 + (isLeapYear(year) ? 1
                                : 0))))                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_427975504 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_427975504.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_427975504;
                } //End block
                days += fields[DAY_OF_YEAR] - 1;
            } //End block
            else
            if(isSet[DAY_OF_WEEK])            
            {
                days += mod7(fields[DAY_OF_WEEK] - 1 - (days - 3));
            } //End block
        } //End block
        lastDateFieldSet = 0;
        timeVal += days * 86400000;
        if(year == changeYear
                && timeVal >= gregorianCutover + julianError() * 86400000L)        
        {
            timeVal -= julianError() * 86400000L;
        } //End block
        long timeValWithoutDST = timeVal - getOffset(timeVal)
                + getTimeZone().getRawOffset();
        timeVal -= getOffset(timeValWithoutDST);
        this.time = timeVal;
        if(timeValWithoutDST != timeVal)        
        {
            computeFields();
            areFieldsSet = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.781 -0400", hash_original_method = "2A644CA75A846A9F294F6A7DE0BAB232", hash_generated_method = "F9D7DA65645CAC529D5385A836A450C2")
    private int computeYearAndDay(long dayCount, long localTime) {
        addTaint(localTime);
        addTaint(dayCount);
        int year = 1970;
        long days = dayCount;
        if(localTime < gregorianCutover)        
        {
            days -= julianSkew;
        } //End block
        int approxYears;
        while
((approxYears = (int) (days / 365)) != 0)        
        {
            year = year + approxYears;
            days = dayCount - daysFromBaseYear(year);
        } //End block
        if(days < 0)        
        {
            year = year - 1;
            days = days + daysInYear(year);
        } //End block
        fields[YEAR] = year;
        int var48EC4340FAAB7B695A4B92142AEF4EE9_1873340357 = ((int) days + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696406590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696406590;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.782 -0400", hash_original_method = "975CAA178CB1C52E2022FF53CD13129C", hash_generated_method = "DFA1899123F3CB099DF7E80E6637FDB7")
    private long daysFromBaseYear(int iyear) {
        addTaint(iyear);
        long year = iyear;
        if(year >= 1970)        
        {
            long days = (year - 1970) * 365 + ((year - 1969) / 4);
            if(year > changeYear)            
            {
                days -= ((year - 1901) / 100) - ((year - 1601) / 400);
            } //End block
            else
            {
                if(year == changeYear)                
                {
                    days += currentYearSkew;
                } //End block
                else
                if(year == changeYear -1)                
                {
                    days += lastYearSkew;
                } //End block
                else
                {
                    days += julianSkew;
                } //End block
            } //End block
            long var44FDEC47036F482B68B748F9D786801B_616648388 = (days);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_437818103 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_437818103;
        } //End block
        else
        if(year <= changeYear)        
        {
            long var35D6CD95761BD6926A18867D312BEE94_163237335 = ((year - 1970) * 365 + ((year - 1972) / 4) + julianSkew);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1767801173 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1767801173;
        } //End block
        long varA5D44FF3C40E933F306548B08A859B47_1544778726 = ((year - 1970) * 365 + ((year - 1972) / 4)
                - ((year - 2000) / 100) + ((year - 2000) / 400));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1673831887 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1673831887;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.782 -0400", hash_original_method = "B393AFA9309B3ECCDD74469F481095BD", hash_generated_method = "68CFBDE460DB4F9B34DC3B2BC181EEEF")
    private int daysInMonth() {
        int var215FE7C75DB0BF3B63047BEF73A9EBB3_925607990 = (daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661003869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661003869;
        // ---------- Original Method ----------
        //return daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.782 -0400", hash_original_method = "F030460418FCB84947C9AD9647C8CF35", hash_generated_method = "3F3E347B51C10A1893385980BC833ACF")
    private int daysInMonth(boolean leapYear, int month) {
        addTaint(month);
        addTaint(leapYear);
        if(leapYear && month == FEBRUARY)        
        {
            int var63A86A6898A1B5484DE8E2A6BCC88EAC_1895371382 = (DaysInMonth[month] + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145903261 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145903261;
        } //End block
        int var16BCB2966AA46E02DF92EC5081BB44E3_1775990310 = (DaysInMonth[month]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157354931 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157354931;
        // ---------- Original Method ----------
        //if (leapYear && month == FEBRUARY) {
            //return DaysInMonth[month] + 1;
        //}
        //return DaysInMonth[month];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.782 -0400", hash_original_method = "643B799339D2A3831DACB9C12752109A", hash_generated_method = "11EA9EB71C7CE01783F3A145250065D5")
    private int daysInYear(int year) {
        addTaint(year);
        int daysInYear = isLeapYear(year) ? 366 : 365;
        if(year == changeYear)        
        {
            daysInYear -= currentYearSkew;
        } //End block
        if(year == changeYear - 1)        
        {
            daysInYear -= lastYearSkew;
        } //End block
        int var6E5C2EF03C324199422107DFF3171D60_489953092 = (daysInYear);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463573277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463573277;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.782 -0400", hash_original_method = "7E255F605E98F52E53144D7126E773F6", hash_generated_method = "A4D440EF46C96A4F575731DDD7936496")
    private int daysInYear(boolean leapYear, int month) {
        addTaint(month);
        addTaint(leapYear);
        if(leapYear && month > FEBRUARY)        
        {
            int var3506CF06E4FF835EA4F1528CCE30A712_280540746 = (DaysInYear[month] + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897206480 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897206480;
        } //End block
        int var2DB45FAAFDF779F519D585E10C3F9FD7_1693360561 = (DaysInYear[month]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255422989 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255422989;
        // ---------- Original Method ----------
        //if (leapYear && month > FEBRUARY) {
            //return DaysInYear[month] + 1;
        //}
        //return DaysInYear[month];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.782 -0400", hash_original_method = "61C11EDCA3B03978A14421C2440916AB", hash_generated_method = "6DA2169DB042CDB07A0AF7895885CAE9")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(!(object instanceof GregorianCalendar))        
        {
            boolean var68934A3E9455FA72420237EB05902327_404488405 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687041417 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687041417;
        } //End block
        if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_17274684 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744236823 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_744236823;
        } //End block
        boolean var44CDC33DA152514F6A58C4E6B7562147_10834365 = (super.equals(object)
                && gregorianCutover == ((GregorianCalendar) object).gregorianCutover);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883805688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_883805688;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.783 -0400", hash_original_method = "F6A8281F341CD14B238EE5FA427449C3", hash_generated_method = "27EFF1B7E95A1A5E4C776653E1A25D33")
    @Override
    public int getActualMaximum(int field) {
        addTaint(field);
        int value;
        if((value = maximums[field]) == leastMaximums[field])        
        {
            int var2063C1608D6E0BAF80249C42E2BE5804_39607389 = (value);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451711916 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451711916;
        } //End block
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
        } //End block
        areFieldsSet = false;
        break;
        case WEEK_OF_MONTH:
        set(DATE, daysInMonth());
        result = get(WEEK_OF_MONTH);
        areFieldsSet = false;
        break;
        case DATE:
        int varDC131347AC637B3CF5167754085ADF72_813330424 = (daysInMonth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920271900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920271900;
        case DAY_OF_YEAR:
        int var87D04C2266D2A41EE2D6E5B7F0269E78_1437910673 = (daysInYear(fields[YEAR]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411141987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411141987;
        case DAY_OF_WEEK_IN_MONTH:
        result = get(DAY_OF_WEEK_IN_MONTH)
                        + ((daysInMonth() - get(DATE)) / 7);
        break;
        case YEAR:
        GregorianCalendar clone = (GregorianCalendar) clone();
        if(get(ERA) == AD)        
        {
            clone.setTimeInMillis(Long.MAX_VALUE);
        } //End block
        else
        {
            clone.setTimeInMillis(Long.MIN_VALUE);
        } //End block
        result = clone.get(YEAR);
        clone.set(YEAR, get(YEAR));
        if(clone.before(this))        
        {
            result--;
        } //End block
        break;
        case DST_OFFSET:
        result = getMaximum(DST_OFFSET);
        break;
}        time = orgTime;
        int varB4A88417B3D0170D754C647C30B7216A_713671156 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889672163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889672163;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.783 -0400", hash_original_method = "0094646504037C44C448A8626AEC2CA3", hash_generated_method = "23B67B6E08A70B6CB0A6FAF4B2FDDD47")
    @Override
    public int getActualMinimum(int field) {
        addTaint(field);
        int var46426DDAE003BEA3036B79B8FDF3849A_55338058 = (getMinimum(field));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543782820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543782820;
        // ---------- Original Method ----------
        //return getMinimum(field);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.783 -0400", hash_original_method = "F3CD156C4D2759DEA34A15A000EAB551", hash_generated_method = "8BCE155E3C10A6A493357215774F24D3")
    @Override
    public int getGreatestMinimum(int field) {
        addTaint(field);
        int varAA6E26B2CBA469CCA54B67CC2A8278AA_1226888665 = (minimums[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751497453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751497453;
        // ---------- Original Method ----------
        //return minimums[field];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.784 -0400", hash_original_method = "BD206861177D272D9EC33433339CB64F", hash_generated_method = "82CEDB5F81192A6B42F6927520A792CE")
    public final Date getGregorianChange() {
Date var30D73D984C20176C0D7FB6C2B553BF0A_58667672 =         new Date(gregorianCutover);
        var30D73D984C20176C0D7FB6C2B553BF0A_58667672.addTaint(taint);
        return var30D73D984C20176C0D7FB6C2B553BF0A_58667672;
        // ---------- Original Method ----------
        //return new Date(gregorianCutover);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.784 -0400", hash_original_method = "3B0100990EBACC07D6E54BAA89A3102A", hash_generated_method = "399025A3DA3E6984F4EFF4661A09DDBB")
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
            int var5157E3C765AF93679EA07052F30F0A6E_437477312 = (actual);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999967557 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999967557;
        } //End block
        int var857D9AA0C7F57F448846860E6BAAF48C_2029603416 = (leastMaximums[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906295093 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906295093;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.784 -0400", hash_original_method = "80794FF1ED1E8F2177114BCAA53EED59", hash_generated_method = "C15CCD9CF945C6AA1CB0C39ED3E86C4E")
    @Override
    public int getMaximum(int field) {
        addTaint(field);
        int var2115410AD9D2F23189053B80BA420D83_1970579851 = (maximums[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415397072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415397072;
        // ---------- Original Method ----------
        //return maximums[field];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.784 -0400", hash_original_method = "1A09A14EE8971B3B0503081305AF18CB", hash_generated_method = "90C1E86A8C930746A2F5D3F8ED87696E")
    @Override
    public int getMinimum(int field) {
        addTaint(field);
        int varAA6E26B2CBA469CCA54B67CC2A8278AA_2082492165 = (minimums[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952161350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952161350;
        // ---------- Original Method ----------
        //return minimums[field];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.784 -0400", hash_original_method = "A5F3F970AF018D82525827EF3879E8F1", hash_generated_method = "5174C79E0768892237CDCC1801B8C9C7")
    private int getOffset(long localTime) {
        addTaint(localTime);
        TimeZone timeZone = getTimeZone();
        long dayCount = localTime / 86400000;
        int millis = (int) (localTime % 86400000);
        if(millis < 0)        
        {
            millis += 86400000;
            dayCount--;
        } //End block
        int year = 1970;
        long days = dayCount;
        if(localTime < gregorianCutover)        
        {
            days -= julianSkew;
        } //End block
        int approxYears;
        while
((approxYears = (int) (days / 365)) != 0)        
        {
            year = year + approxYears;
            days = dayCount - daysFromBaseYear(year);
        } //End block
        if(days < 0)        
        {
            year = year - 1;
            days = days + 365 + (isLeapYear(year) ? 1 : 0);
            if(year == changeYear && localTime < gregorianCutover)            
            {
                days -= julianError();
            } //End block
        } //End block
        if(year <= 0)        
        {
            int varD55F8146D5D8F78547A7EB0E9CAC5E41_362652857 = (timeZone.getRawOffset());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822152612 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822152612;
        } //End block
        int dayOfYear = (int) days + 1;
        int month = dayOfYear / 32;
        boolean leapYear = isLeapYear(year);
        int date = dayOfYear - daysInYear(leapYear, month);
        if(date > daysInMonth(leapYear, month))        
        {
            date -= daysInMonth(leapYear, month);
            month++;
        } //End block
        int dayOfWeek = mod7(dayCount - 3) + 1;
        int offset = timeZone.getOffset(AD, year, month, date, dayOfWeek,
                millis);
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_766416441 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407813376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407813376;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.785 -0400", hash_original_method = "6907F2ED2DF57E219AB70EADED509565", hash_generated_method = "E4BB9AAEE046F9BB4FBBD0B22A0DF51F")
    @Override
    public int hashCode() {
        int var545DD072C17145ABB13A4EE7D4DA3C35_298312972 = (super.hashCode()
                + ((int) (gregorianCutover >>> 32) ^ (int) gregorianCutover));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355100351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355100351;
        // ---------- Original Method ----------
        //return super.hashCode()
                //+ ((int) (gregorianCutover >>> 32) ^ (int) gregorianCutover);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.785 -0400", hash_original_method = "FD1210B9D1DAC87CC2975B1EB57E42AE", hash_generated_method = "25B45992851BE21761E64C8E7F488FAA")
    public boolean isLeapYear(int year) {
        addTaint(year);
        if(year > changeYear)        
        {
            boolean var8D10941BA0EA240F16D860C0C63718A6_1428651580 = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718118410 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_718118410;
        } //End block
        boolean varB4F34FCD703C0F9E6D7D856801C659D4_1054372620 = (year % 4 == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_135778294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_135778294;
        // ---------- Original Method ----------
        //if (year > changeYear) {
            //return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        //}
        //return year % 4 == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.785 -0400", hash_original_method = "6792E5EC134CCE3576D348D7664F192E", hash_generated_method = "CE927DA91672A20E5B1EDDB96A5D8E20")
    private int julianError() {
        int var3697CF08EA814E7CEA6F0785303746B7_1542214476 = (changeYear / 100 - changeYear / 400 - 2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300799628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300799628;
        // ---------- Original Method ----------
        //return changeYear / 100 - changeYear / 400 - 2;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.785 -0400", hash_original_method = "C7B77E5A8B6CB394A26ACFDB4CA2A34C", hash_generated_method = "BA6B9425EA0966F53D64FC900DD20080")
    private int mod(int value, int mod) {
        addTaint(mod);
        addTaint(value);
        int rem = value % mod;
        if(value < 0 && rem < 0)        
        {
            int var8DBED730CCDB4B5FE3FF247A070AEB60_1835505585 = (rem + mod);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922116456 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922116456;
        } //End block
        int var5CADB523CB6909F92350F70F124ADFB8_1680756414 = (rem);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273569956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273569956;
        // ---------- Original Method ----------
        //int rem = value % mod;
        //if (value < 0 && rem < 0) {
            //return rem + mod;
        //}
        //return rem;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.785 -0400", hash_original_method = "B5B6FCF50F48D18673AA227255C5F0A5", hash_generated_method = "215CBD20724C0C0225608A8FD2E69B9F")
    private int mod7(long num1) {
        addTaint(num1);
        int rem = (int) (num1 % 7);
        if(num1 < 0 && rem < 0)        
        {
            int var00AD68AE71482771F548BCF4FCD10AC2_874810362 = (rem + 7);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398047445 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398047445;
        } //End block
        int var5CADB523CB6909F92350F70F124ADFB8_603930927 = (rem);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130383108 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130383108;
        // ---------- Original Method ----------
        //int rem = (int) (num1 % 7);
        //if (num1 < 0 && rem < 0) {
            //return rem + 7;
        //}
        //return rem;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.787 -0400", hash_original_method = "B265969ED1D5B160D0AFF42D0A073F4D", hash_generated_method = "D1CFF82629FD6953D333C189C15CEFC8")
    @Override
    public void roll(int field, int value) {
        addTaint(value);
        addTaint(field);
        if(value == 0)        
        {
            return;
        } //End block
        if(field < 0 || field >= ZONE_OFFSET)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1092334471 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1092334471.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1092334471;
        } //End block
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
            } //End block
            else
            {
                set(field, newWeek - 1);
            } //End block
        } //End block
        else
        if(newWeek == 1)        
        {
            int week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
            if(week > 1)            
            {
                set(field, 1);
            } //End block
            else
            {
                set(field, newWeek);
            } //End block
        } //End block
        else
        {
            set(field, newWeek);
        } //End block
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
            } //End block
            else
            {
                set(field, newWeek);
            } //End block
        } //End block
        else
        if(newWeek == 1)        
        {
            int week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
            if(week > 1)            
            {
                set(day, 1);
            } //End block
            else
            {
                set(field, newWeek);
            } //End block
        } //End block
        else
        {
            set(field, newWeek);
        } //End block
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
        } //End block
        else
        if(field == AM_PM)        
        {
            lastTimeFieldSet = HOUR;
        } //End block
        break;
}        if(max != -1)        
        {
            set(field, mod(fields[field] - 1 + value, max) + 1);
        } //End block
        complete();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.787 -0400", hash_original_method = "011BFEF6AF7823592586BFF14A1F0FAF", hash_generated_method = "137405C6FC3DEE68159AF69D7F408B1D")
    @Override
    public void roll(int field, boolean increment) {
        addTaint(increment);
        addTaint(field);
        roll(field, increment ? 1 : -1);
        // ---------- Original Method ----------
        //roll(field, increment ? 1 : -1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.788 -0400", hash_original_method = "BBA926F39AADCD3D723F5CC72B7A16F3", hash_generated_method = "4933AE1EEBDFC946CD582F25E4B2BBD5")
    public void setGregorianChange(Date date) {
        gregorianCutover = date.getTime();
        GregorianCalendar cal = new GregorianCalendar(TimeZone.GMT);
        cal.setTime(date);
        changeYear = cal.get(YEAR);
        if(cal.get(ERA) == BC)        
        {
            changeYear = 1 - changeYear;
        } //End block
        julianSkew = ((changeYear - 2000) / 400) + julianError()
                - ((changeYear - 2000) / 100);
        isCached = false;
        int dayOfYear = cal.get(DAY_OF_YEAR);
        if(dayOfYear < julianSkew)        
        {
            currentYearSkew = dayOfYear-1;
            lastYearSkew = julianSkew - dayOfYear + 1;
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.788 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "1284A1B8BFD40E947242B6FBDC302E7A")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.788 -0400", hash_original_method = "6812E7459A56AAC638E0A1455D3A3623", hash_generated_method = "876D110AFE295CBDBB402FE5D0D6EC6A")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        setGregorianChange(new Date(gregorianCutover));
        isCached = false;
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //setGregorianChange(new Date(gregorianCutover));
        //isCached = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.788 -0400", hash_original_method = "803EF27234E46811EE9F1109A1277F23", hash_generated_method = "A4334078C06FF158AFBC6F799AC1C61C")
    @Override
    public void setFirstDayOfWeek(int value) {
        addTaint(value);
        super.setFirstDayOfWeek(value);
        isCached = false;
        // ---------- Original Method ----------
        //super.setFirstDayOfWeek(value);
        //isCached = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_method = "77A4B23D11FEBAAF4DA5B074DBE88F4F", hash_generated_method = "5515E6F80BC8E1CEFFE9F4AF765D318F")
    @Override
    public void setMinimalDaysInFirstWeek(int value) {
        addTaint(value);
        super.setMinimalDaysInFirstWeek(value);
        isCached = false;
        // ---------- Original Method ----------
        //super.setMinimalDaysInFirstWeek(value);
        //isCached = false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "1C4EA65D0B85820031DB54E0B782FD43", hash_generated_field = "B9386A44E9BFA9A5ED8D3E7882B2C9E1")

    private static final long serialVersionUID = -8125100834729963327L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "9AD044AF9694EBAE04C6A843D8BD814D", hash_generated_field = "93BFF7C10A82D9138EF2CEC785C901D2")

    public static final int BC = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "B7B6AD4BCE48136317BC53C29D899D81", hash_generated_field = "BC845EBD4DA20DC255F4737CB21267E2")

    public static final int AD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "3C2061F8784D53F3CF214EF2B5C44347", hash_generated_field = "23BA66807055EDC52580EFE8B68EA6D9")

    private static final long defaultGregorianCutover = -12219292800000l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "F75D8DB91544852469A5E6BD6B9261C6", hash_generated_field = "D109403F40DEAA9D96D5485CCE288282")

    static byte[] DaysInMonth = new byte[] { 31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "FA59282D92997F8368B0D198B418DB90", hash_generated_field = "0A4DD57D0556CD2CAD7A071A46A83584")

    private static int[] DaysInYear = new int[] { 0, 31, 59, 90, 120, 151, 181,
            212, 243, 273, 304, 334 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "AB38F25D3064B346C2337034E2A43B7E", hash_generated_field = "9C039D691AF795C6B392702421AF992F")

    private static int[] maximums = new int[] { 1, 292278994, 11, 53, 6, 31,
            366, 7, 6, 1, 11, 23, 59, 59, 999, 14 * 3600 * 1000, 7200000 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "86C59D996E94DD35B58C61607BD56009", hash_generated_field = "34197BE97C1359ACB541F3CFF4B6D197")

    private static int[] minimums = new int[] { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0,
            0, 0, 0, 0, 0, -13 * 3600 * 1000, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.789 -0400", hash_original_field = "1119798B7094D66F851E9E0B02F12B51", hash_generated_field = "72A42F262CE1CA8E4E3156D2F2A817C5")

    private static int[] leastMaximums = new int[] { 1, 292269054, 11, 50, 3,
            28, 355, 7, 3, 1, 11, 23, 59, 59, 999, 50400000, 1200000 };
}

