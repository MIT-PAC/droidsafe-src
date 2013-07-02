package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

public class SimpleTimeZone extends TimeZone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "9EAE9BC39BBA20610F9CA26BA8609746", hash_generated_field = "02FD65C4AE6246DF84FF429CBB8EEA00")

    private int rawOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "78B902B91A7DB6AE4440D916F8C1C0E1", hash_generated_field = "D96A347FAB9C04C4C794424684EFB084")

    private int startYear;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "E8122CC997AB2C59FCE8C314426F4F68", hash_generated_field = "940B798A01BC8ABB2CE78C90F3BCFFD3")

    private int startMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "F9C17BD1FAD2884297D4CC252E94B554", hash_generated_field = "C94A63CC5ED4704D0C2CA8DCAD9FD876")

    private int startDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "4C26E00B6B24E29E71510CA729F0973C", hash_generated_field = "43E2727F657E2CD398223A6F1FA2BD3F")

    private int startDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "5B2A579F62087D17D79CE59F3DE5F6D1", hash_generated_field = "C0B40C0BA543A9EB6854A39344BC26D4")

    private int startTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "211595262C719DC6A6D21AE48FD0734D", hash_generated_field = "FF7508574F08AAF5CB8B3A9500D95481")

    private int endMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "993848D0DEA30349854C28B46462E893", hash_generated_field = "71D6BC1B0CA52DA20C0737FDC0586303")

    private int endDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "0446C45DF1D67C67D576C73B791C3225", hash_generated_field = "2FB4FAECAEDA119C4460DBD2706193A4")

    private int endDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "C5B5790B8B74A68D0CDE09C8F1080FC5", hash_generated_field = "D0D7BC1269A7BA712BB9A8CDDA9E82F8")

    private int endTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "6A3EC46E8E89018DABF9BC20BD89E0EF", hash_generated_field = "0E9AA7511822CAC3FB3D4A8874DCE60D")

    private int startMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "38C063B6C1F84E1D761E186944C0FD3D", hash_generated_field = "5C6BDD12C029B639E093E1584B7C3AD2")

    private int endMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "11E85DB5D0550BA98C32E008D18D6B1F", hash_generated_field = "6E9DFCBD335172F280DBFDE8886FC716")

    private boolean useDaylight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.677 -0400", hash_original_field = "1D390B0D116BD8D4F5C43896444648F1", hash_generated_field = "5B4639FCCF517E827D012B95CA754FED")

    private int dstSavings = 3600000;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.678 -0400", hash_original_method = "A73AE5A515785364E3BAF8A0CE898B7F", hash_generated_method = "3A9E6AEDA958B94BAB4EE9010D147424")
    public  SimpleTimeZone(int offset, final String name) {
        setID(name);
        rawOffset = offset;
        addTaint(name.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.678 -0400", hash_original_method = "8CE6DF24772062229638C2D4C95CF5BA", hash_generated_method = "B485F06187536D3E94DC0FCF6EC8A1A0")
    public  SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime) {
        this(offset, name, startMonth, startDay, startDayOfWeek, startTime,
                endMonth, endDay, endDayOfWeek, endTime, 3600000);
        addTaint(offset);
        addTaint(name.getTaint());
        addTaint(startMonth);
        addTaint(startDay);
        addTaint(startDayOfWeek);
        addTaint(startTime);
        addTaint(endMonth);
        addTaint(endDay);
        addTaint(endDayOfWeek);
        addTaint(endTime);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.679 -0400", hash_original_method = "8623FC95180B9E56345F7D06857248B1", hash_generated_method = "788EA47225519FF2EB2AC5334DD45DA9")
    public  SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime, int daylightSavings) {
        this(offset, name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid daylightSavings: " + daylightSavings);
        } 
        dstSavings = daylightSavings;
        setStartRule(startMonth, startDay, startDayOfWeek, startTime);
        setEndRule(endMonth, endDay, endDayOfWeek, endTime);
        addTaint(offset);
        addTaint(name.getTaint());
        addTaint(startMonth);
        addTaint(startDay);
        addTaint(startDayOfWeek);
        addTaint(startTime);
        addTaint(endMonth);
        addTaint(endDay);
        addTaint(endDayOfWeek);
        addTaint(endTime);
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.679 -0400", hash_original_method = "79A83CB077FC893587B86C22BBA871F3", hash_generated_method = "4ABA149209F4616F092D2879700C698C")
    public  SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int startTimeMode,
            int endMonth, int endDay, int endDayOfWeek, int endTime,
            int endTimeMode, int daylightSavings) {
        this(offset, name, startMonth, startDay, startDayOfWeek, startTime,
                endMonth, endDay, endDayOfWeek, endTime, daylightSavings);
        startMode = startTimeMode;
        endMode = endTimeMode;
        addTaint(offset);
        addTaint(name.getTaint());
        addTaint(startMonth);
        addTaint(startDay);
        addTaint(startDayOfWeek);
        addTaint(startTime);
        addTaint(endMonth);
        addTaint(endDay);
        addTaint(endDayOfWeek);
        addTaint(endTime);
        addTaint(daylightSavings);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.680 -0400", hash_original_method = "826DFB88845863F51C3C619017A5C62F", hash_generated_method = "ABA001B67314D6EBF31AA87FC1B382D2")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2058011632 = null; 
        SimpleTimeZone zone = (SimpleTimeZone) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2058011632 = zone;
        varB4EAC82CA7396A68D541C85D26508E83_2058011632.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2058011632;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.680 -0400", hash_original_method = "6B0E934BFCA438C9EF8D8ACC7F42CB32", hash_generated_method = "417406E00638757F814E0EE841919658")
    @Override
    public boolean equals(Object object) {
        SimpleTimeZone tz = (SimpleTimeZone) object;
        boolean varAEEAE6FFE43EE54ACEB5105F2E3707CA_445901990 = (getID().equals(tz.getID())
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
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_349859591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_349859591;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.681 -0400", hash_original_method = "80F5C5F4A535ECB3386672D31D5CF9AA", hash_generated_method = "9D97BA4DD2819B6BE677A95F162BB738")
    @Override
    public int getDSTSavings() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037831502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037831502;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.683 -0400", hash_original_method = "8DB3C09D8D79030897991A8AF2C3603A", hash_generated_method = "5CC0C0A1B6789D782B49785D2A4A6199")
    @Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int time) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid era: " + era);
        } 
        checkRange(month, dayOfWeek, time);
        {
            boolean varDDE26ED6F6F2D378E54C9D0FD807F9B0_299879802 = (month != Calendar.FEBRUARY || day != 29 || !isLeapYear(year));
            {
                checkDay(month, day);
            } 
        } 
        {
            boolean varAE28A042D21B15EB2BF786A48B929263_932141976 = (!useDaylightTime() || era != GregorianCalendar.AD || year < startYear);
        } 
        int ruleDay = 0;
        int daysInMonth;
        int firstDayOfMonth = mod7(dayOfWeek - day);
        {
            
            ruleDay = startDay;
            
            
            {
                ruleDay = mod7(startDayOfWeek - firstDayOfMonth) + 1
                                + (startDay - 1) * 7;
            } 
            {
                daysInMonth = GregorianCalendar.DaysInMonth[startMonth];
                {
                    boolean var34F59880D95385B2DD6E1245C2952EE3_1190654653 = (startMonth == Calendar.FEBRUARY && isLeapYear(
                                year));
                    {
                        daysInMonth += 1;
                    } 
                } 
                ruleDay = daysInMonth
                                + 1
                                + mod7(startDayOfWeek
                                - (firstDayOfMonth + daysInMonth))
                                + startDay * 7;
            } 
            
            
            ruleDay = startDay
                            + mod7(startDayOfWeek
                            - (firstDayOfMonth + startDay - 1));
            
            
            ruleDay = startDay
                            + mod7(startDayOfWeek
                            - (firstDayOfMonth + startDay - 1));
            
            
            {
                ruleDay -= 7;
            } 
            
        } 
        int ruleTime = endTime - dstSavings;
        int nextMonth = (month + 1) % 12;
        {
            
            ruleDay = endDay;
            
            
            {
                ruleDay = mod7(endDayOfWeek - firstDayOfMonth) + 1
                                + (endDay - 1) * 7;
            } 
            {
                daysInMonth = GregorianCalendar.DaysInMonth[endMonth];
                {
                    boolean varA62BC480A841AF891471E24690DA3AEC_1152029209 = (endMonth == Calendar.FEBRUARY && isLeapYear(year));
                } 
                ruleDay = daysInMonth
                                + 1
                                + mod7(endDayOfWeek
                                - (firstDayOfMonth + daysInMonth)) + endDay
                                * 7;
            } 
            
            
            ruleDay = endDay
                            + mod7(
                            endDayOfWeek - (firstDayOfMonth + endDay - 1));
            
            
            ruleDay = endDay
                            + mod7(
                            endDayOfWeek - (firstDayOfMonth + endDay - 1));
            
            
            {
                ruleDay -= 7;
            } 
            
            int ruleMonth = endMonth;
            {
                int changeDays = 1 - (ruleTime / 86400000);
                ruleTime = (ruleTime % 86400000) + 86400000;
                ruleDay -= changeDays;
                {
                    {
                        ruleMonth = Calendar.DECEMBER;
                    } 
                    ruleDay += GregorianCalendar.DaysInMonth[ruleMonth];
                    {
                        boolean var942B201C9F9DC371A222C49906220991_1977435309 = (ruleMonth == Calendar.FEBRUARY && isLeapYear(year));
                    } 
                } 
            } 
        } 
        addTaint(era);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(dayOfWeek);
        addTaint(time);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759968360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759968360;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.683 -0400", hash_original_method = "6DBE603182E450BA9A410285A6D6CE41", hash_generated_method = "CB2F4D4363AC621BE5D88053AF21F13C")
    @Override
    public int getOffset(long time) {
        {
            boolean varAC33886EBC7D5E71649B935B25265F07_237405047 = (!useDaylightTime());
        } 
        int[] fields = Grego.timeToFields(time + rawOffset, null);
        int var68E2FD47563B72F3EFF55569C2664413_1626882678 = (getOffset(GregorianCalendar.AD, fields[0], fields[1], fields[2],
                fields[3], fields[5]));
        addTaint(time);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_933836359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_933836359;
        
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.684 -0400", hash_original_method = "D90129E49D21D0E2F7EA4F6539F9D2CB", hash_generated_method = "8AEFF96ACCA79C956FC1E960C3D5A722")
    @Override
    public int getRawOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862186152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862186152;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.684 -0400", hash_original_method = "543AFBFA58DD3885C5C6D68F749BE5FB", hash_generated_method = "E93C6358D5A70168447D01D8825A042A")
    @Override
    public synchronized int hashCode() {
        int hashCode = getID().hashCode() + rawOffset;
        {
            hashCode += startYear + startMonth + startDay + startDayOfWeek
                    + startTime + startMode + endMonth + endDay + endDayOfWeek
                    + endTime + endMode + dstSavings;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479114208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479114208;
        
        
        
            
                    
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.685 -0400", hash_original_method = "4BB4BBFFC89848EE3A9E98B493F95D5F", hash_generated_method = "9F195DEEB86BBD7EB2E0F80EB90EB86F")
    @Override
    public boolean hasSameRules(TimeZone zone) {
        SimpleTimeZone tz = (SimpleTimeZone) zone;
        addTaint(zone.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1572348350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1572348350;
        
        
            
        
        
        
            
        
        
            
        
        
                
                
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.685 -0400", hash_original_method = "C51A338C9795AC2507162C0CE1A08702", hash_generated_method = "77BB458406A22AF259506AB67096EA7F")
    @Override
    public boolean inDaylightTime(Date time) {
        boolean varEE507C2978DFF3408523E16B966BE7F9_1922870327 = (useDaylightTime() && getOffset(time.getTime()) != getRawOffset());
        addTaint(time.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500735670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_500735670;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.685 -0400", hash_original_method = "8AD8F18B8E2CE991A6AB313B3340B306", hash_generated_method = "9C4BAFF48E5092821609717299ADE873")
    private boolean isLeapYear(int year) {
        addTaint(year);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_512313576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_512313576;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.686 -0400", hash_original_method = "EABB822EA3A4CED689A420DE5F07AD18", hash_generated_method = "CDA3756AD03EAAAF7FD0AFFAC5ACD26D")
    private int mod7(int num1) {
        int rem = num1 % 7;
        addTaint(num1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447111823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447111823;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.686 -0400", hash_original_method = "37D938F55D2005A7FF3D5AC31467EF4C", hash_generated_method = "CBB22A08F16C106C2CAD1E7AEC343566")
    public void setDSTSavings(int milliseconds) {
        {
            dstSavings = milliseconds;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.686 -0400", hash_original_method = "29EACAF13C91B179EA825409505E4565", hash_generated_method = "EC2606E51A82463E30FF345C52C29710")
    private void checkRange(int month, int dayOfWeek, int time) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid month: " + month);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid time: " + time);
        } 
        addTaint(month);
        addTaint(dayOfWeek);
        addTaint(time);
        
        
            
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.687 -0400", hash_original_method = "F04B5CC4561F29CBDFD2A63D85494102", hash_generated_method = "DC092CA7AB51B0A36201C97DA17437A2")
    private void checkDay(int month, int day) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid day of month: " + day);
        } 
        addTaint(month);
        addTaint(day);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.687 -0400", hash_original_method = "E98C141304510A5F08CF5DF5CC63E118", hash_generated_method = "F8DEE44AD3F0DB21DB13D763ADEAA1D3")
    private void setEndMode() {
        {
            endMode = DOM_MODE;
        } 
        {
            endDayOfWeek = -endDayOfWeek;
            {
                endDay = -endDay;
                endMode = DOW_LE_DOM_MODE;
            } 
            {
                endMode = DOW_GE_DOM_MODE;
            } 
        } 
        {
            endMode = DOW_IN_MONTH_MODE;
        } 
        useDaylight = startDay != 0 && endDay != 0;
        {
            checkRange(endMonth, endMode == DOM_MODE ? 1 : endDayOfWeek,
                    endTime);
            {
                checkDay(endMonth, endDay);
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Day of week in month: " + endDay);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.688 -0400", hash_original_method = "B4162090EB008A9B00DF0FE1EF92B7AC", hash_generated_method = "C0562577D3BEFBBA8D48F9088BA817C4")
    public void setEndRule(int month, int dayOfMonth, int time) {
        endMonth = month;
        endDay = dayOfMonth;
        endDayOfWeek = 0;
        endTime = time;
        setEndMode();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.688 -0400", hash_original_method = "582DA5383125C3306AD7EBC943F58F20", hash_generated_method = "A6CE6CC12A87A78BAED4267F777AF0F3")
    public void setEndRule(int month, int day, int dayOfWeek, int time) {
        endMonth = month;
        endDay = day;
        endDayOfWeek = dayOfWeek;
        endTime = time;
        setEndMode();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.688 -0400", hash_original_method = "2E94B36A00113021CB8FDF603EDAA945", hash_generated_method = "92A47AE4EC7D81F56ABC3D44E434CD83")
    public void setEndRule(int month, int day, int dayOfWeek, int time, boolean after) {
        endMonth = month;
        endDay = after ? day : -day;
        endDayOfWeek = -dayOfWeek;
        endTime = time;
        setEndMode();
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.688 -0400", hash_original_method = "C8A257B93E1C51862FD9A30D6A75C66A", hash_generated_method = "565DCC6768A82C6D61497D0F194E6405")
    @Override
    public void setRawOffset(int offset) {
        rawOffset = offset;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.689 -0400", hash_original_method = "4370DAC820CAB38F82466934EE4F5C8D", hash_generated_method = "F78AC451ED09031C844DED4FA305FC9D")
    private void setStartMode() {
        {
            startMode = DOM_MODE;
        } 
        {
            startDayOfWeek = -startDayOfWeek;
            {
                startDay = -startDay;
                startMode = DOW_LE_DOM_MODE;
            } 
            {
                startMode = DOW_GE_DOM_MODE;
            } 
        } 
        {
            startMode = DOW_IN_MONTH_MODE;
        } 
        useDaylight = startDay != 0 && endDay != 0;
        {
            checkRange(startMonth, startMode == DOM_MODE ? 1 : startDayOfWeek,
                    startTime);
            {
                checkDay(startMonth, startDay);
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Day of week in month: " + startDay);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.689 -0400", hash_original_method = "1B6B9F6DA0D38FD2E6B0C75070F8A774", hash_generated_method = "8E3473DDB37FF6F7006F9986018B7502")
    public void setStartRule(int month, int dayOfMonth, int time) {
        startMonth = month;
        startDay = dayOfMonth;
        startDayOfWeek = 0;
        startTime = time;
        setStartMode();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.690 -0400", hash_original_method = "05B57A1DF0091079AD9D1D4FB9E42767", hash_generated_method = "21B93F0AA81CC56EFC6B90272C1612AB")
    public void setStartRule(int month, int day, int dayOfWeek, int time) {
        startMonth = month;
        startDay = day;
        startDayOfWeek = dayOfWeek;
        startTime = time;
        setStartMode();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.691 -0400", hash_original_method = "D71B6352FE444D82D409CFA5438BDAA8", hash_generated_method = "538156448C614086085AEF11A2495F76")
    public void setStartRule(int month, int day, int dayOfWeek, int time, boolean after) {
        startMonth = month;
        startDay = after ? day : -day;
        startDayOfWeek = -dayOfWeek;
        startTime = time;
        setStartMode();
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.691 -0400", hash_original_method = "7CBF25AFDCF863C97C11F8D0CB7F66E7", hash_generated_method = "0EAB2221FE5CC0E50F7ABB3F73F14E8B")
    public void setStartYear(int year) {
        startYear = year;
        useDaylight = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.693 -0400", hash_original_method = "8DB4BEB563F494A2FC46832022F4609E", hash_generated_method = "540CF05A2086A40EBB4E30F67079C801")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_243233497 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_243233497 = getClass().getName()
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
        varB4EAC82CA7396A68D541C85D26508E83_243233497.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_243233497;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.694 -0400", hash_original_method = "7C1BE50DE9C29B43BADE36CF66AF8A96", hash_generated_method = "3ED8C8D1AA1118DC8BE132AF2D2081B5")
    @Override
    public boolean useDaylightTime() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836752916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836752916;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.695 -0400", hash_original_method = "F4691E6CC75F84FE0527C352A6F6F1B9", hash_generated_method = "76DF1AC6F1C6645FE0396A059EF52936")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        int sEndDay = endDay;
        int sEndDayOfWeek = endDayOfWeek + 1;
        int sStartDay = startDay;
        int sStartDayOfWeek = startDayOfWeek + 1;
        {
            Calendar cal = new GregorianCalendar(this);
            {
                cal.set(Calendar.MONTH, endMonth);
                cal.set(Calendar.DATE, endDay);
                sEndDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                {
                    sEndDayOfWeek = cal.getFirstDayOfWeek();
                } 
            } 
            {
                cal.set(Calendar.MONTH, startMonth);
                cal.set(Calendar.DATE, startDay);
                sStartDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                {
                    sStartDayOfWeek = cal.getFirstDayOfWeek();
                } 
            } 
        } 
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
        addTaint(stream.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.696 -0400", hash_original_method = "19765306B3DA0529AD0AFD53EDC0B4B8", hash_generated_method = "51692A36BA68F77C8534647DEBF3CDC0")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        rawOffset = fields.get("rawOffset", 0);
        useDaylight = fields.get("useDaylight", false);
        {
            endMonth = fields.get("endMonth", 0);
            endTime = fields.get("endTime", 0);
            startMonth = fields.get("startMonth", 0);
            startTime = fields.get("startTime", 0);
            startYear = fields.get("startYear", 0);
        } 
        {
            boolean varB1402D125FA51CA7547D890DB81A6275_103523491 = (fields.get("serialVersionOnStream", 0) == 0);
            {
                {
                    startMode = endMode = DOW_IN_MONTH_MODE;
                    endDay = fields.get("endDay", 0);
                    endDayOfWeek = fields.get("endDayOfWeek", 0) - 1;
                    startDay = fields.get("startDay", 0);
                    startDayOfWeek = fields.get("startDayOfWeek", 0) - 1;
                } 
            } 
            {
                dstSavings = fields.get("dstSavings", 0);
                {
                    endMode = fields.get("endMode", 0);
                    startMode = fields.get("startMode", 0);
                    int length = stream.readInt();
                    byte[] values = new byte[length];
                    stream.readFully(values);
                    {
                        startDay = values[0];
                        startDayOfWeek = values[1];
                        endDay = values[2];
                        endDayOfWeek = values[3];
                    } 
                } 
            } 
        } 
        addTaint(stream.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "8502F83FA777B7BAEC96DD1642714A6A", hash_generated_field = "1CF196C479DD1F282A55928D9D41E39D")

    private static final long serialVersionUID = -403250971215465050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "A16CDC7A98B9FE1707BCB38A5FD0B490", hash_generated_field = "3037D344D26C320D59D8AAFE3A431E48")

    private static final int DOM_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "B27995F1E6069CEF7A0FF35116D534B6", hash_generated_field = "2C93A32BCFE1ECF0127BDA095E88DC8A")

    private static final int DOW_IN_MONTH_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "04A0BC6AA9754653D5751ED4E151C000", hash_generated_field = "F1DC93233ED325B0B7BD9D456CA553CF")

    private static final int DOW_GE_DOM_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "31ABAC6414B935DA144D0D6AEB5168DC", hash_generated_field = "E441A9DEBF4A92E218DA7693E0A9869F")

    private static final int DOW_LE_DOM_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "346488806B5A9C262B4E154D9F31D394", hash_generated_field = "61DB737AECFE59272E81B27E825907AA")

    public static final int UTC_TIME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "CAB987564C6E2151DEA026DF1C3F228F", hash_generated_field = "DC2E634827EAB82F13E8E712A81C7981")

    public static final int STANDARD_TIME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "3ECC377EE99AA75ADE5DFA23CC69BF01", hash_generated_field = "847DF430EF9ED807826F046224B40B8D")

    public static final int WALL_TIME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.697 -0400", hash_original_field = "1C772818B060E4B20F2D1A5C10F9D69F", hash_generated_field = "2894821EF324A43745E14FE4AD86DCFF")

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

