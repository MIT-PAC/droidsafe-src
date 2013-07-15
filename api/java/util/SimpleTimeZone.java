package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

public class SimpleTimeZone extends TimeZone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.026 -0400", hash_original_field = "9EAE9BC39BBA20610F9CA26BA8609746", hash_generated_field = "02FD65C4AE6246DF84FF429CBB8EEA00")

    private int rawOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.026 -0400", hash_original_field = "78B902B91A7DB6AE4440D916F8C1C0E1", hash_generated_field = "D96A347FAB9C04C4C794424684EFB084")

    private int startYear;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.026 -0400", hash_original_field = "E8122CC997AB2C59FCE8C314426F4F68", hash_generated_field = "940B798A01BC8ABB2CE78C90F3BCFFD3")

    private int startMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.026 -0400", hash_original_field = "F9C17BD1FAD2884297D4CC252E94B554", hash_generated_field = "C94A63CC5ED4704D0C2CA8DCAD9FD876")

    private int startDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.026 -0400", hash_original_field = "4C26E00B6B24E29E71510CA729F0973C", hash_generated_field = "43E2727F657E2CD398223A6F1FA2BD3F")

    private int startDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "5B2A579F62087D17D79CE59F3DE5F6D1", hash_generated_field = "C0B40C0BA543A9EB6854A39344BC26D4")

    private int startTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "211595262C719DC6A6D21AE48FD0734D", hash_generated_field = "FF7508574F08AAF5CB8B3A9500D95481")

    private int endMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "993848D0DEA30349854C28B46462E893", hash_generated_field = "71D6BC1B0CA52DA20C0737FDC0586303")

    private int endDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "0446C45DF1D67C67D576C73B791C3225", hash_generated_field = "2FB4FAECAEDA119C4460DBD2706193A4")

    private int endDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "C5B5790B8B74A68D0CDE09C8F1080FC5", hash_generated_field = "D0D7BC1269A7BA712BB9A8CDDA9E82F8")

    private int endTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "6A3EC46E8E89018DABF9BC20BD89E0EF", hash_generated_field = "0E9AA7511822CAC3FB3D4A8874DCE60D")

    private int startMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "38C063B6C1F84E1D761E186944C0FD3D", hash_generated_field = "5C6BDD12C029B639E093E1584B7C3AD2")

    private int endMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "11E85DB5D0550BA98C32E008D18D6B1F", hash_generated_field = "6E9DFCBD335172F280DBFDE8886FC716")

    private boolean useDaylight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.027 -0400", hash_original_field = "1D390B0D116BD8D4F5C43896444648F1", hash_generated_field = "5B4639FCCF517E827D012B95CA754FED")

    private int dstSavings = 3600000;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.028 -0400", hash_original_method = "A73AE5A515785364E3BAF8A0CE898B7F", hash_generated_method = "5F21045727ED24DEBB6477ACC1DAABB8")
    public  SimpleTimeZone(int offset, final String name) {
        addTaint(name.getTaint());
        setID(name);
        rawOffset = offset;
        // ---------- Original Method ----------
        //setID(name);
        //rawOffset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.028 -0400", hash_original_method = "8CE6DF24772062229638C2D4C95CF5BA", hash_generated_method = "38D3D253CC2E2CB5FD407DDF3977B709")
    public  SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime) {
        this(offset, name, startMonth, startDay, startDayOfWeek, startTime,
                endMonth, endDay, endDayOfWeek, endTime, 3600000);
        addTaint(endTime);
        addTaint(endDayOfWeek);
        addTaint(endDay);
        addTaint(endMonth);
        addTaint(startTime);
        addTaint(startDayOfWeek);
        addTaint(startDay);
        addTaint(startMonth);
        addTaint(name.getTaint());
        addTaint(offset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.029 -0400", hash_original_method = "8623FC95180B9E56345F7D06857248B1", hash_generated_method = "BBC20B945F47CB5AEE1E8D963A3D89F3")
    public  SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime, int daylightSavings) {
        this(offset, name);
        addTaint(endTime);
        addTaint(endDayOfWeek);
        addTaint(endDay);
        addTaint(endMonth);
        addTaint(startTime);
        addTaint(startDayOfWeek);
        addTaint(startDay);
        addTaint(startMonth);
        addTaint(name.getTaint());
        addTaint(offset);
    if(daylightSavings <= 0)        
        {
            IllegalArgumentException var73CBA700A3C07B6F721DDA5AC81A0F41_1760282702 = new IllegalArgumentException("Invalid daylightSavings: " + daylightSavings);
            var73CBA700A3C07B6F721DDA5AC81A0F41_1760282702.addTaint(taint);
            throw var73CBA700A3C07B6F721DDA5AC81A0F41_1760282702;
        } //End block
        dstSavings = daylightSavings;
        setStartRule(startMonth, startDay, startDayOfWeek, startTime);
        setEndRule(endMonth, endDay, endDayOfWeek, endTime);
        // ---------- Original Method ----------
        //if (daylightSavings <= 0) {
            //throw new IllegalArgumentException("Invalid daylightSavings: " + daylightSavings);
        //}
        //dstSavings = daylightSavings;
        //setStartRule(startMonth, startDay, startDayOfWeek, startTime);
        //setEndRule(endMonth, endDay, endDayOfWeek, endTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.030 -0400", hash_original_method = "79A83CB077FC893587B86C22BBA871F3", hash_generated_method = "A2B5A6045C003AB476F80E12B43CD1EE")
    public  SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int startTimeMode,
            int endMonth, int endDay, int endDayOfWeek, int endTime,
            int endTimeMode, int daylightSavings) {
        this(offset, name, startMonth, startDay, startDayOfWeek, startTime,
                endMonth, endDay, endDayOfWeek, endTime, daylightSavings);
        addTaint(daylightSavings);
        addTaint(endTime);
        addTaint(endDayOfWeek);
        addTaint(endDay);
        addTaint(endMonth);
        addTaint(startTime);
        addTaint(startDayOfWeek);
        addTaint(startDay);
        addTaint(startMonth);
        addTaint(name.getTaint());
        addTaint(offset);
        startMode = startTimeMode;
        endMode = endTimeMode;
        // ---------- Original Method ----------
        //startMode = startTimeMode;
        //endMode = endTimeMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.031 -0400", hash_original_method = "826DFB88845863F51C3C619017A5C62F", hash_generated_method = "3296E88D8812F184B51A15723C39B516")
    @Override
    public Object clone() {
        SimpleTimeZone zone = (SimpleTimeZone) super.clone();
Object var61F6902A567A932064AABE0702479FA5_55040939 =         zone;
        var61F6902A567A932064AABE0702479FA5_55040939.addTaint(taint);
        return var61F6902A567A932064AABE0702479FA5_55040939;
        // ---------- Original Method ----------
        //SimpleTimeZone zone = (SimpleTimeZone) super.clone();
        //return zone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.031 -0400", hash_original_method = "6B0E934BFCA438C9EF8D8ACC7F42CB32", hash_generated_method = "7B101B5E68076656642A4C187414373A")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(!(object instanceof SimpleTimeZone))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1156646902 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761823692 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761823692;
        } //End block
        SimpleTimeZone tz = (SimpleTimeZone) object;
        boolean varE64616880E6E4EC60801059397DE48F4_306581445 = (getID().equals(tz.getID())
                && rawOffset == tz.rawOffset
                && useDaylight == tz.useDaylight
                && (!useDaylight || (startYear == tz.startYear
                        && startMonth == tz.startMonth
                        && startDay == tz.startDay && startMode == tz.startMode
                        && startDayOfWeek == tz.startDayOfWeek
                        && startTime == tz.startTime && endMonth == tz.endMonth
                        && endDay == tz.endDay
                        && endDayOfWeek == tz.endDayOfWeek
                        && endTime == tz.endTime && endMode == tz.endMode && dstSavings == tz.dstSavings)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308405551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308405551;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.032 -0400", hash_original_method = "80F5C5F4A535ECB3386672D31D5CF9AA", hash_generated_method = "A4E7FD5EA79604FB046444C0ADD5060D")
    @Override
    public int getDSTSavings() {
    if(!useDaylight)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1829463504 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_436310854 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_436310854;
        } //End block
        int var5A9ACA7844414251460ABB9B8123A5BB_1978688362 = (dstSavings);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107187079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107187079;
        // ---------- Original Method ----------
        //if (!useDaylight) {
            //return 0;
        //}
        //return dstSavings;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.035 -0400", hash_original_method = "8DB3C09D8D79030897991A8AF2C3603A", hash_generated_method = "929589E95406E7BBC980F2D2DFA836C1")
    @Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int time) {
        addTaint(time);
        addTaint(dayOfWeek);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        addTaint(era);
    if(era != GregorianCalendar.BC && era != GregorianCalendar.AD)        
        {
            IllegalArgumentException var5FA660FD77CEA7E9740EDB1C65C44E65_1088674295 = new IllegalArgumentException("Invalid era: " + era);
            var5FA660FD77CEA7E9740EDB1C65C44E65_1088674295.addTaint(taint);
            throw var5FA660FD77CEA7E9740EDB1C65C44E65_1088674295;
        } //End block
        checkRange(month, dayOfWeek, time);
    if(month != Calendar.FEBRUARY || day != 29 || !isLeapYear(year))        
        {
            checkDay(month, day);
        } //End block
    if(!useDaylightTime() || era != GregorianCalendar.AD || year < startYear)        
        {
            int var9EAE9BC39BBA20610F9CA26BA8609746_1519514506 = (rawOffset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977328339 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977328339;
        } //End block
    if(endMonth < startMonth)        
        {
    if(month > endMonth && month < startMonth)            
            {
                int var9EAE9BC39BBA20610F9CA26BA8609746_2053943257 = (rawOffset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364830634 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364830634;
            } //End block
        } //End block
        else
        {
    if(month < startMonth || month > endMonth)            
            {
                int var9EAE9BC39BBA20610F9CA26BA8609746_902227425 = (rawOffset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709237541 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709237541;
            } //End block
        } //End block
        int ruleDay = 0;
        int daysInMonth;
        int firstDayOfMonth = mod7(dayOfWeek - day);
    if(month == startMonth)        
        {
switch(startMode){
            case DOM_MODE:
            ruleDay = startDay;
            break;
            case DOW_IN_MONTH_MODE:
    if(startDay >= 0)            
            {
                ruleDay = mod7(startDayOfWeek - firstDayOfMonth) + 1
                                + (startDay - 1) * 7;
            } //End block
            else
            {
                daysInMonth = GregorianCalendar.DaysInMonth[startMonth];
    if(startMonth == Calendar.FEBRUARY && isLeapYear(
                                year))                
                {
                    daysInMonth += 1;
                } //End block
                ruleDay = daysInMonth
                                + 1
                                + mod7(startDayOfWeek
                                - (firstDayOfMonth + daysInMonth))
                                + startDay * 7;
            } //End block
            break;
            case DOW_GE_DOM_MODE:
            ruleDay = startDay
                            + mod7(startDayOfWeek
                            - (firstDayOfMonth + startDay - 1));
            break;
            case DOW_LE_DOM_MODE:
            ruleDay = startDay
                            + mod7(startDayOfWeek
                            - (firstDayOfMonth + startDay - 1));
    if(ruleDay != startDay)            
            {
                ruleDay -= 7;
            } //End block
            break;
}    if(ruleDay > day || ruleDay == day && time < startTime)            
            {
                int var9EAE9BC39BBA20610F9CA26BA8609746_410737756 = (rawOffset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698452915 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698452915;
            } //End block
        } //End block
        int ruleTime = endTime - dstSavings;
        int nextMonth = (month + 1) % 12;
    if(month == endMonth || (ruleTime < 0 && nextMonth == endMonth))        
        {
switch(endMode){
            case DOM_MODE:
            ruleDay = endDay;
            break;
            case DOW_IN_MONTH_MODE:
    if(endDay >= 0)            
            {
                ruleDay = mod7(endDayOfWeek - firstDayOfMonth) + 1
                                + (endDay - 1) * 7;
            } //End block
            else
            {
                daysInMonth = GregorianCalendar.DaysInMonth[endMonth];
    if(endMonth == Calendar.FEBRUARY && isLeapYear(year))                
                {
                    daysInMonth++;
                } //End block
                ruleDay = daysInMonth
                                + 1
                                + mod7(endDayOfWeek
                                - (firstDayOfMonth + daysInMonth)) + endDay
                                * 7;
            } //End block
            break;
            case DOW_GE_DOM_MODE:
            ruleDay = endDay
                            + mod7(
                            endDayOfWeek - (firstDayOfMonth + endDay - 1));
            break;
            case DOW_LE_DOM_MODE:
            ruleDay = endDay
                            + mod7(
                            endDayOfWeek - (firstDayOfMonth + endDay - 1));
    if(ruleDay != endDay)            
            {
                ruleDay -= 7;
            } //End block
            break;
}            int ruleMonth = endMonth;
    if(ruleTime < 0)            
            {
                int changeDays = 1 - (ruleTime / 86400000);
                ruleTime = (ruleTime % 86400000) + 86400000;
                ruleDay -= changeDays;
    if(ruleDay <= 0)                
                {
    if(--ruleMonth < Calendar.JANUARY)                    
                    {
                        ruleMonth = Calendar.DECEMBER;
                    } //End block
                    ruleDay += GregorianCalendar.DaysInMonth[ruleMonth];
    if(ruleMonth == Calendar.FEBRUARY && isLeapYear(year))                    
                    {
                        ruleDay++;
                    } //End block
                } //End block
            } //End block
    if(month == ruleMonth)            
            {
    if(ruleDay < day || ruleDay == day && time >= ruleTime)                
                {
                    int var9EAE9BC39BBA20610F9CA26BA8609746_343553325 = (rawOffset);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925609581 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925609581;
                } //End block
            } //End block
            else
    if(nextMonth != ruleMonth)            
            {
                int var9EAE9BC39BBA20610F9CA26BA8609746_279743652 = (rawOffset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046934493 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046934493;
            } //End block
        } //End block
        int var914667C8F68257020A61685CD2F07AA7_219032493 = (rawOffset + dstSavings);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_406234912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_406234912;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.037 -0400", hash_original_method = "6DBE603182E450BA9A410285A6D6CE41", hash_generated_method = "C0D55296F4558D3BF90576BEB3351989")
    @Override
    public int getOffset(long time) {
        addTaint(time);
    if(!useDaylightTime())        
        {
            int var9EAE9BC39BBA20610F9CA26BA8609746_806506837 = (rawOffset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552525172 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552525172;
        } //End block
        int[] fields = Grego.timeToFields(time + rawOffset, null);
        int var12B334D4023B6D6031DCF8CD82B1ADD7_2063434423 = (getOffset(GregorianCalendar.AD, fields[0], fields[1], fields[2],
                fields[3], fields[5]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173352599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173352599;
        // ---------- Original Method ----------
        //if (!useDaylightTime()) {
            //return rawOffset;
        //}
        //int[] fields = Grego.timeToFields(time + rawOffset, null);
        //return getOffset(GregorianCalendar.AD, fields[0], fields[1], fields[2],
                //fields[3], fields[5]);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.037 -0400", hash_original_method = "D90129E49D21D0E2F7EA4F6539F9D2CB", hash_generated_method = "19D07465AA82D8362A583FA00BDA33EE")
    @Override
    public int getRawOffset() {
        int var9EAE9BC39BBA20610F9CA26BA8609746_1028020061 = (rawOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399655647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399655647;
        // ---------- Original Method ----------
        //return rawOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.038 -0400", hash_original_method = "543AFBFA58DD3885C5C6D68F749BE5FB", hash_generated_method = "BDE80A23876C56F0ED16CEBF9019A2EA")
    @Override
    public synchronized int hashCode() {
        int hashCode = getID().hashCode() + rawOffset;
    if(useDaylight)        
        {
            hashCode += startYear + startMonth + startDay + startDayOfWeek
                    + startTime + startMode + endMonth + endDay + endDayOfWeek
                    + endTime + endMode + dstSavings;
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_1064988254 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2095076419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2095076419;
        // ---------- Original Method ----------
        //int hashCode = getID().hashCode() + rawOffset;
        //if (useDaylight) {
            //hashCode += startYear + startMonth + startDay + startDayOfWeek
                    //+ startTime + startMode + endMonth + endDay + endDayOfWeek
                    //+ endTime + endMode + dstSavings;
        //}
        //return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.039 -0400", hash_original_method = "4BB4BBFFC89848EE3A9E98B493F95D5F", hash_generated_method = "181014FDDD73AC3AB3505E0FC5D26AC0")
    @Override
    public boolean hasSameRules(TimeZone zone) {
        addTaint(zone.getTaint());
    if(!(zone instanceof SimpleTimeZone))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1004334973 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007535227 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007535227;
        } //End block
        SimpleTimeZone tz = (SimpleTimeZone) zone;
    if(useDaylight != tz.useDaylight)        
        {
            boolean var68934A3E9455FA72420237EB05902327_485929148 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501718052 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501718052;
        } //End block
    if(!useDaylight)        
        {
            boolean var832EB8B5DD31AF1C270F8EE480BB6EF3_2145974841 = (rawOffset == tz.rawOffset);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265273645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265273645;
        } //End block
        boolean var57FA5F1091414171EBC6E8124CB913C3_1482034318 = (rawOffset == tz.rawOffset && dstSavings == tz.dstSavings
                && startYear == tz.startYear && startMonth == tz.startMonth
                && startDay == tz.startDay && startMode == tz.startMode
                && startDayOfWeek == tz.startDayOfWeek
                && startTime == tz.startTime && endMonth == tz.endMonth
                && endDay == tz.endDay && endDayOfWeek == tz.endDayOfWeek
                && endTime == tz.endTime && endMode == tz.endMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_549883229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_549883229;
        // ---------- Original Method ----------
        //if (!(zone instanceof SimpleTimeZone)) {
            //return false;
        //}
        //SimpleTimeZone tz = (SimpleTimeZone) zone;
        //if (useDaylight != tz.useDaylight) {
            //return false;
        //}
        //if (!useDaylight) {
            //return rawOffset == tz.rawOffset;
        //}
        //return rawOffset == tz.rawOffset && dstSavings == tz.dstSavings
                //&& startYear == tz.startYear && startMonth == tz.startMonth
                //&& startDay == tz.startDay && startMode == tz.startMode
                //&& startDayOfWeek == tz.startDayOfWeek
                //&& startTime == tz.startTime && endMonth == tz.endMonth
                //&& endDay == tz.endDay && endDayOfWeek == tz.endDayOfWeek
                //&& endTime == tz.endTime && endMode == tz.endMode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.039 -0400", hash_original_method = "C51A338C9795AC2507162C0CE1A08702", hash_generated_method = "7EA7E0A0691061BBB47F66F8B4EE70C8")
    @Override
    public boolean inDaylightTime(Date time) {
        addTaint(time.getTaint());
        boolean varDD29844C022A4DF4303AB633133B4FB9_2068308500 = (useDaylightTime() && getOffset(time.getTime()) != getRawOffset());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_22631501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_22631501;
        // ---------- Original Method ----------
        //return useDaylightTime() && getOffset(time.getTime()) != getRawOffset();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.040 -0400", hash_original_method = "8AD8F18B8E2CE991A6AB313B3340B306", hash_generated_method = "61EB00FDA7AD2B7EBD62A46FFA8FF181")
    private boolean isLeapYear(int year) {
        addTaint(year);
    if(year > 1582)        
        {
            boolean var8D10941BA0EA240F16D860C0C63718A6_157010712 = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593931073 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593931073;
        } //End block
        boolean varB4F34FCD703C0F9E6D7D856801C659D4_35152238 = (year % 4 == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514612589 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514612589;
        // ---------- Original Method ----------
        //if (year > 1582) {
            //return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        //}
        //return year % 4 == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.040 -0400", hash_original_method = "EABB822EA3A4CED689A420DE5F07AD18", hash_generated_method = "9B8445A3576E0AF599D70A23A2EFC04B")
    private int mod7(int num1) {
        addTaint(num1);
        int rem = num1 % 7;
        int varEB502A5E913EDFAA27A48DFF28164353_500953481 = ((num1 < 0 && rem < 0) ? 7 + rem : rem);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960714946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960714946;
        // ---------- Original Method ----------
        //int rem = num1 % 7;
        //return (num1 < 0 && rem < 0) ? 7 + rem : rem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.041 -0400", hash_original_method = "37D938F55D2005A7FF3D5AC31467EF4C", hash_generated_method = "02B19A3BC5EBBA2229CD041060D84632")
    public void setDSTSavings(int milliseconds) {
    if(milliseconds > 0)        
        {
            dstSavings = milliseconds;
        } //End block
        else
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_876511385 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_876511385.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_876511385;
        } //End block
        // ---------- Original Method ----------
        //if (milliseconds > 0) {
            //dstSavings = milliseconds;
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.041 -0400", hash_original_method = "29EACAF13C91B179EA825409505E4565", hash_generated_method = "A4F39AA52BC512D999B77023BF00553F")
    private void checkRange(int month, int dayOfWeek, int time) {
        addTaint(time);
        addTaint(dayOfWeek);
        addTaint(month);
    if(month < Calendar.JANUARY || month > Calendar.DECEMBER)        
        {
            IllegalArgumentException varD4A03A96450767E6DF4B8411A471D197_53442098 = new IllegalArgumentException("Invalid month: " + month);
            varD4A03A96450767E6DF4B8411A471D197_53442098.addTaint(taint);
            throw varD4A03A96450767E6DF4B8411A471D197_53442098;
        } //End block
    if(dayOfWeek < Calendar.SUNDAY || dayOfWeek > Calendar.SATURDAY)        
        {
            IllegalArgumentException var860A368995C7A73C98C966603F358824_1291078538 = new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
            var860A368995C7A73C98C966603F358824_1291078538.addTaint(taint);
            throw var860A368995C7A73C98C966603F358824_1291078538;
        } //End block
    if(time < 0 || time >= 24 * 3600000)        
        {
            IllegalArgumentException varE58B10D24E93617131DC98C2E08747C5_1508947508 = new IllegalArgumentException("Invalid time: " + time);
            varE58B10D24E93617131DC98C2E08747C5_1508947508.addTaint(taint);
            throw varE58B10D24E93617131DC98C2E08747C5_1508947508;
        } //End block
        // ---------- Original Method ----------
        //if (month < Calendar.JANUARY || month > Calendar.DECEMBER) {
            //throw new IllegalArgumentException("Invalid month: " + month);
        //}
        //if (dayOfWeek < Calendar.SUNDAY || dayOfWeek > Calendar.SATURDAY) {
            //throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
        //}
        //if (time < 0 || time >= 24 * 3600000) {
            //throw new IllegalArgumentException("Invalid time: " + time);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.042 -0400", hash_original_method = "F04B5CC4561F29CBDFD2A63D85494102", hash_generated_method = "7D26BEF2507EB24BAA13E6D7922540E3")
    private void checkDay(int month, int day) {
        addTaint(day);
        addTaint(month);
    if(day <= 0 || day > GregorianCalendar.DaysInMonth[month])        
        {
            IllegalArgumentException varE01C0AC7C2133B4202BCE62672FB1616_1823185111 = new IllegalArgumentException("Invalid day of month: " + day);
            varE01C0AC7C2133B4202BCE62672FB1616_1823185111.addTaint(taint);
            throw varE01C0AC7C2133B4202BCE62672FB1616_1823185111;
        } //End block
        // ---------- Original Method ----------
        //if (day <= 0 || day > GregorianCalendar.DaysInMonth[month]) {
            //throw new IllegalArgumentException("Invalid day of month: " + day);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.043 -0400", hash_original_method = "E98C141304510A5F08CF5DF5CC63E118", hash_generated_method = "862DB308C772A213B90440B634A79104")
    private void setEndMode() {
    if(endDayOfWeek == 0)        
        {
            endMode = DOM_MODE;
        } //End block
        else
    if(endDayOfWeek < 0)        
        {
            endDayOfWeek = -endDayOfWeek;
    if(endDay < 0)            
            {
                endDay = -endDay;
                endMode = DOW_LE_DOM_MODE;
            } //End block
            else
            {
                endMode = DOW_GE_DOM_MODE;
            } //End block
        } //End block
        else
        {
            endMode = DOW_IN_MONTH_MODE;
        } //End block
        useDaylight = startDay != 0 && endDay != 0;
    if(endDay != 0)        
        {
            checkRange(endMonth, endMode == DOM_MODE ? 1 : endDayOfWeek,
                    endTime);
    if(endMode != DOW_IN_MONTH_MODE)            
            {
                checkDay(endMonth, endDay);
            } //End block
            else
            {
    if(endDay < -5 || endDay > 5)                
                {
                    IllegalArgumentException varF3F21AEBB96DF33C4B180298BDEB54B2_972070336 = new IllegalArgumentException("Day of week in month: " + endDay);
                    varF3F21AEBB96DF33C4B180298BDEB54B2_972070336.addTaint(taint);
                    throw varF3F21AEBB96DF33C4B180298BDEB54B2_972070336;
                } //End block
            } //End block
        } //End block
    if(endMode != DOM_MODE)        
        {
            endDayOfWeek--;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.045 -0400", hash_original_method = "B4162090EB008A9B00DF0FE1EF92B7AC", hash_generated_method = "C0562577D3BEFBBA8D48F9088BA817C4")
    public void setEndRule(int month, int dayOfMonth, int time) {
        endMonth = month;
        endDay = dayOfMonth;
        endDayOfWeek = 0;
        endTime = time;
        setEndMode();
        // ---------- Original Method ----------
        //endMonth = month;
        //endDay = dayOfMonth;
        //endDayOfWeek = 0;
        //endTime = time;
        //setEndMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.047 -0400", hash_original_method = "582DA5383125C3306AD7EBC943F58F20", hash_generated_method = "A6CE6CC12A87A78BAED4267F777AF0F3")
    public void setEndRule(int month, int day, int dayOfWeek, int time) {
        endMonth = month;
        endDay = day;
        endDayOfWeek = dayOfWeek;
        endTime = time;
        setEndMode();
        // ---------- Original Method ----------
        //endMonth = month;
        //endDay = day;
        //endDayOfWeek = dayOfWeek;
        //endTime = time;
        //setEndMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.048 -0400", hash_original_method = "2E94B36A00113021CB8FDF603EDAA945", hash_generated_method = "92A47AE4EC7D81F56ABC3D44E434CD83")
    public void setEndRule(int month, int day, int dayOfWeek, int time, boolean after) {
        endMonth = month;
        endDay = after ? day : -day;
        endDayOfWeek = -dayOfWeek;
        endTime = time;
        setEndMode();
        // ---------- Original Method ----------
        //endMonth = month;
        //endDay = after ? day : -day;
        //endDayOfWeek = -dayOfWeek;
        //endTime = time;
        //setEndMode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.048 -0400", hash_original_method = "C8A257B93E1C51862FD9A30D6A75C66A", hash_generated_method = "565DCC6768A82C6D61497D0F194E6405")
    @Override
    public void setRawOffset(int offset) {
        rawOffset = offset;
        // ---------- Original Method ----------
        //rawOffset = offset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.049 -0400", hash_original_method = "4370DAC820CAB38F82466934EE4F5C8D", hash_generated_method = "9AFC0EE9DA1BA4E9AFD8356AF30CDC29")
    private void setStartMode() {
    if(startDayOfWeek == 0)        
        {
            startMode = DOM_MODE;
        } //End block
        else
    if(startDayOfWeek < 0)        
        {
            startDayOfWeek = -startDayOfWeek;
    if(startDay < 0)            
            {
                startDay = -startDay;
                startMode = DOW_LE_DOM_MODE;
            } //End block
            else
            {
                startMode = DOW_GE_DOM_MODE;
            } //End block
        } //End block
        else
        {
            startMode = DOW_IN_MONTH_MODE;
        } //End block
        useDaylight = startDay != 0 && endDay != 0;
    if(startDay != 0)        
        {
            checkRange(startMonth, startMode == DOM_MODE ? 1 : startDayOfWeek,
                    startTime);
    if(startMode != DOW_IN_MONTH_MODE)            
            {
                checkDay(startMonth, startDay);
            } //End block
            else
            {
    if(startDay < -5 || startDay > 5)                
                {
                    IllegalArgumentException varEE4EDFB38C4DD3E2381D34169BCED6F8_273320763 = new IllegalArgumentException("Day of week in month: " + startDay);
                    varEE4EDFB38C4DD3E2381D34169BCED6F8_273320763.addTaint(taint);
                    throw varEE4EDFB38C4DD3E2381D34169BCED6F8_273320763;
                } //End block
            } //End block
        } //End block
    if(startMode != DOM_MODE)        
        {
            startDayOfWeek--;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.086 -0400", hash_original_method = "1B6B9F6DA0D38FD2E6B0C75070F8A774", hash_generated_method = "8E3473DDB37FF6F7006F9986018B7502")
    public void setStartRule(int month, int dayOfMonth, int time) {
        startMonth = month;
        startDay = dayOfMonth;
        startDayOfWeek = 0;
        startTime = time;
        setStartMode();
        // ---------- Original Method ----------
        //startMonth = month;
        //startDay = dayOfMonth;
        //startDayOfWeek = 0;
        //startTime = time;
        //setStartMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.087 -0400", hash_original_method = "05B57A1DF0091079AD9D1D4FB9E42767", hash_generated_method = "21B93F0AA81CC56EFC6B90272C1612AB")
    public void setStartRule(int month, int day, int dayOfWeek, int time) {
        startMonth = month;
        startDay = day;
        startDayOfWeek = dayOfWeek;
        startTime = time;
        setStartMode();
        // ---------- Original Method ----------
        //startMonth = month;
        //startDay = day;
        //startDayOfWeek = dayOfWeek;
        //startTime = time;
        //setStartMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.088 -0400", hash_original_method = "D71B6352FE444D82D409CFA5438BDAA8", hash_generated_method = "538156448C614086085AEF11A2495F76")
    public void setStartRule(int month, int day, int dayOfWeek, int time, boolean after) {
        startMonth = month;
        startDay = after ? day : -day;
        startDayOfWeek = -dayOfWeek;
        startTime = time;
        setStartMode();
        // ---------- Original Method ----------
        //startMonth = month;
        //startDay = after ? day : -day;
        //startDayOfWeek = -dayOfWeek;
        //startTime = time;
        //setStartMode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.089 -0400", hash_original_method = "7CBF25AFDCF863C97C11F8D0CB7F66E7", hash_generated_method = "0EAB2221FE5CC0E50F7ABB3F73F14E8B")
    public void setStartYear(int year) {
        startYear = year;
        useDaylight = true;
        // ---------- Original Method ----------
        //startYear = year;
        //useDaylight = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.090 -0400", hash_original_method = "8DB4BEB563F494A2FC46832022F4609E", hash_generated_method = "F8AD29333D19DFCB02B61F327E926D37")
    @Override
    public String toString() {
String var20F954FD534D7F6240714D87A28A185A_443538627 =         getClass().getName()
                + "[id="
                + getID()
                + ",offset="
                + rawOffset
                + ",dstSavings="
                + dstSavings
                + ",useDaylight="
                + useDaylight
                + ",startYear="
                + startYear
                + ",startMode="
                + startMode
                + ",startMonth="
                + startMonth
                + ",startDay="
                + startDay
                + ",startDayOfWeek="
                + (useDaylight && (startMode != DOM_MODE) ? startDayOfWeek + 1
                        : 0) + ",startTime=" + startTime + ",endMode="
                + endMode + ",endMonth=" + endMonth + ",endDay=" + endDay
                + ",endDayOfWeek="
                + (useDaylight && (endMode != DOM_MODE) ? endDayOfWeek + 1 : 0)
                + ",endTime=" + endTime + "]";
        var20F954FD534D7F6240714D87A28A185A_443538627.addTaint(taint);
        return var20F954FD534D7F6240714D87A28A185A_443538627;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.090 -0400", hash_original_method = "7C1BE50DE9C29B43BADE36CF66AF8A96", hash_generated_method = "B8CCBD9DCEE9810B887F4B36FA85ABEF")
    @Override
    public boolean useDaylightTime() {
        boolean var11E85DB5D0550BA98C32E008D18D6B1F_2026599627 = (useDaylight);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192155198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192155198;
        // ---------- Original Method ----------
        //return useDaylight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.092 -0400", hash_original_method = "F4691E6CC75F84FE0527C352A6F6F1B9", hash_generated_method = "3AF6E77932D09CDDA4B26B268AA87FAA")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        int sEndDay = endDay;
        int sEndDayOfWeek = endDayOfWeek + 1;
        int sStartDay = startDay;
        int sStartDayOfWeek = startDayOfWeek + 1;
    if(useDaylight
                && (startMode != DOW_IN_MONTH_MODE || endMode != DOW_IN_MONTH_MODE))        
        {
            Calendar cal = new GregorianCalendar(this);
    if(endMode != DOW_IN_MONTH_MODE)            
            {
                cal.set(Calendar.MONTH, endMonth);
                cal.set(Calendar.DATE, endDay);
                sEndDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    if(endMode == DOM_MODE)                
                {
                    sEndDayOfWeek = cal.getFirstDayOfWeek();
                } //End block
            } //End block
    if(startMode != DOW_IN_MONTH_MODE)            
            {
                cal.set(Calendar.MONTH, startMonth);
                cal.set(Calendar.DATE, startDay);
                sStartDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    if(startMode == DOM_MODE)                
                {
                    sStartDayOfWeek = cal.getFirstDayOfWeek();
                } //End block
            } //End block
        } //End block
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("dstSavings", dstSavings);
        fields.put("endDay", sEndDay);
        fields.put("endDayOfWeek", sEndDayOfWeek);
        fields.put("endMode", endMode);
        fields.put("endMonth", endMonth);
        fields.put("endTime", endTime);
        fields.put("monthLength", GregorianCalendar.DaysInMonth);
        fields.put("rawOffset", rawOffset);
        fields.put("serialVersionOnStream", 1);
        fields.put("startDay", sStartDay);
        fields.put("startDayOfWeek", sStartDayOfWeek);
        fields.put("startMode", startMode);
        fields.put("startMonth", startMonth);
        fields.put("startTime", startTime);
        fields.put("startYear", startYear);
        fields.put("useDaylight", useDaylight);
        stream.writeFields();
        stream.writeInt(4);
        byte[] values = new byte[4];
        values[0] = (byte) startDay;
        values[1] = (byte) (startMode == DOM_MODE ? 0 : startDayOfWeek + 1);
        values[2] = (byte) endDay;
        values[3] = (byte) (endMode == DOM_MODE ? 0 : endDayOfWeek + 1);
        stream.write(values);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.094 -0400", hash_original_method = "19765306B3DA0529AD0AFD53EDC0B4B8", hash_generated_method = "A3CA1DC8A42EACF155A580603E8449CF")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
        rawOffset = fields.get("rawOffset", 0);
        useDaylight = fields.get("useDaylight", false);
    if(useDaylight)        
        {
            endMonth = fields.get("endMonth", 0);
            endTime = fields.get("endTime", 0);
            startMonth = fields.get("startMonth", 0);
            startTime = fields.get("startTime", 0);
            startYear = fields.get("startYear", 0);
        } //End block
    if(fields.get("serialVersionOnStream", 0) == 0)        
        {
    if(useDaylight)            
            {
                startMode = endMode = DOW_IN_MONTH_MODE;
                endDay = fields.get("endDay", 0);
                endDayOfWeek = fields.get("endDayOfWeek", 0) - 1;
                startDay = fields.get("startDay", 0);
                startDayOfWeek = fields.get("startDayOfWeek", 0) - 1;
            } //End block
        } //End block
        else
        {
            dstSavings = fields.get("dstSavings", 0);
    if(useDaylight)            
            {
                endMode = fields.get("endMode", 0);
                startMode = fields.get("startMode", 0);
                int length = stream.readInt();
                byte[] values = new byte[length];
                stream.readFully(values);
    if(length >= 4)                
                {
                    startDay = values[0];
                    startDayOfWeek = values[1];
    if(startMode != DOM_MODE)                    
                    {
                        startDayOfWeek--;
                    } //End block
                    endDay = values[2];
                    endDayOfWeek = values[3];
    if(endMode != DOM_MODE)                    
                    {
                        endDayOfWeek--;
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.095 -0400", hash_original_field = "8502F83FA777B7BAEC96DD1642714A6A", hash_generated_field = "1CF196C479DD1F282A55928D9D41E39D")

    private static final long serialVersionUID = -403250971215465050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.095 -0400", hash_original_field = "A16CDC7A98B9FE1707BCB38A5FD0B490", hash_generated_field = "3037D344D26C320D59D8AAFE3A431E48")

    private static final int DOM_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.096 -0400", hash_original_field = "B27995F1E6069CEF7A0FF35116D534B6", hash_generated_field = "2C93A32BCFE1ECF0127BDA095E88DC8A")

    private static final int DOW_IN_MONTH_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.096 -0400", hash_original_field = "04A0BC6AA9754653D5751ED4E151C000", hash_generated_field = "F1DC93233ED325B0B7BD9D456CA553CF")

    private static final int DOW_GE_DOM_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.096 -0400", hash_original_field = "31ABAC6414B935DA144D0D6AEB5168DC", hash_generated_field = "E441A9DEBF4A92E218DA7693E0A9869F")

    private static final int DOW_LE_DOM_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.096 -0400", hash_original_field = "346488806B5A9C262B4E154D9F31D394", hash_generated_field = "61DB737AECFE59272E81B27E825907AA")

    public static final int UTC_TIME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.096 -0400", hash_original_field = "CAB987564C6E2151DEA026DF1C3F228F", hash_generated_field = "DC2E634827EAB82F13E8E712A81C7981")

    public static final int STANDARD_TIME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.096 -0400", hash_original_field = "3ECC377EE99AA75ADE5DFA23CC69BF01", hash_generated_field = "847DF430EF9ED807826F046224B40B8D")

    public static final int WALL_TIME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.097 -0400", hash_original_field = "1C772818B060E4B20F2D1A5C10F9D69F", hash_generated_field = "2894821EF324A43745E14FE4AD86DCFF")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("dstSavings", int.class),
        new ObjectStreamField("endDay", int.class),
        new ObjectStreamField("endDayOfWeek", int.class),
        new ObjectStreamField("endMode", int.class),
        new ObjectStreamField("endMonth", int.class),
        new ObjectStreamField("endTime", int.class),
        new ObjectStreamField("monthLength", byte[].class),
        new ObjectStreamField("rawOffset", int.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
        new ObjectStreamField("startDay", int.class),
        new ObjectStreamField("startDayOfWeek", int.class),
        new ObjectStreamField("startMode", int.class),
        new ObjectStreamField("startMonth", int.class),
        new ObjectStreamField("startTime", int.class),
        new ObjectStreamField("startYear", int.class),
        new ObjectStreamField("useDaylight", boolean.class),
    };
}

