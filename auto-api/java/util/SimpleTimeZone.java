package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

public class SimpleTimeZone extends TimeZone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "9EAE9BC39BBA20610F9CA26BA8609746", hash_generated_field = "02FD65C4AE6246DF84FF429CBB8EEA00")

    private int rawOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "78B902B91A7DB6AE4440D916F8C1C0E1", hash_generated_field = "D96A347FAB9C04C4C794424684EFB084")

    private int startYear;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "E8122CC997AB2C59FCE8C314426F4F68", hash_generated_field = "940B798A01BC8ABB2CE78C90F3BCFFD3")

    private int startMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "F9C17BD1FAD2884297D4CC252E94B554", hash_generated_field = "C94A63CC5ED4704D0C2CA8DCAD9FD876")

    private int startDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "4C26E00B6B24E29E71510CA729F0973C", hash_generated_field = "43E2727F657E2CD398223A6F1FA2BD3F")

    private int startDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "5B2A579F62087D17D79CE59F3DE5F6D1", hash_generated_field = "C0B40C0BA543A9EB6854A39344BC26D4")

    private int startTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "211595262C719DC6A6D21AE48FD0734D", hash_generated_field = "FF7508574F08AAF5CB8B3A9500D95481")

    private int endMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "993848D0DEA30349854C28B46462E893", hash_generated_field = "71D6BC1B0CA52DA20C0737FDC0586303")

    private int endDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "0446C45DF1D67C67D576C73B791C3225", hash_generated_field = "2FB4FAECAEDA119C4460DBD2706193A4")

    private int endDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "C5B5790B8B74A68D0CDE09C8F1080FC5", hash_generated_field = "D0D7BC1269A7BA712BB9A8CDDA9E82F8")

    private int endTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "6A3EC46E8E89018DABF9BC20BD89E0EF", hash_generated_field = "0E9AA7511822CAC3FB3D4A8874DCE60D")

    private int startMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "38C063B6C1F84E1D761E186944C0FD3D", hash_generated_field = "5C6BDD12C029B639E093E1584B7C3AD2")

    private int endMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "11E85DB5D0550BA98C32E008D18D6B1F", hash_generated_field = "6E9DFCBD335172F280DBFDE8886FC716")

    private boolean useDaylight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_field = "1D390B0D116BD8D4F5C43896444648F1", hash_generated_field = "5B4639FCCF517E827D012B95CA754FED")

    private int dstSavings = 3600000;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.527 -0400", hash_original_method = "A73AE5A515785364E3BAF8A0CE898B7F", hash_generated_method = "3A9E6AEDA958B94BAB4EE9010D147424")
    public  SimpleTimeZone(int offset, final String name) {
        setID(name);
        rawOffset = offset;
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //setID(name);
        //rawOffset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.528 -0400", hash_original_method = "8CE6DF24772062229638C2D4C95CF5BA", hash_generated_method = "B485F06187536D3E94DC0FCF6EC8A1A0")
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
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.529 -0400", hash_original_method = "8623FC95180B9E56345F7D06857248B1", hash_generated_method = "788EA47225519FF2EB2AC5334DD45DA9")
    public  SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime, int daylightSavings) {
        this(offset, name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid daylightSavings: " + daylightSavings);
        } //End block
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
        // ---------- Original Method ----------
        //if (daylightSavings <= 0) {
            //throw new IllegalArgumentException("Invalid daylightSavings: " + daylightSavings);
        //}
        //dstSavings = daylightSavings;
        //setStartRule(startMonth, startDay, startDayOfWeek, startTime);
        //setEndRule(endMonth, endDay, endDayOfWeek, endTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.529 -0400", hash_original_method = "79A83CB077FC893587B86C22BBA871F3", hash_generated_method = "4ABA149209F4616F092D2879700C698C")
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
        // ---------- Original Method ----------
        //startMode = startTimeMode;
        //endMode = endTimeMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.530 -0400", hash_original_method = "826DFB88845863F51C3C619017A5C62F", hash_generated_method = "D2199ED49241F5DDBBD5631AB433D781")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2074272733 = null; //Variable for return #1
        SimpleTimeZone zone;
        zone = (SimpleTimeZone) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2074272733 = zone;
        varB4EAC82CA7396A68D541C85D26508E83_2074272733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2074272733;
        // ---------- Original Method ----------
        //SimpleTimeZone zone = (SimpleTimeZone) super.clone();
        //return zone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.530 -0400", hash_original_method = "6B0E934BFCA438C9EF8D8ACC7F42CB32", hash_generated_method = "9C324E88F5C071612DDECC856F2D4118")
    @Override
    public boolean equals(Object object) {
        SimpleTimeZone tz;
        tz = (SimpleTimeZone) object;
        boolean varAEEAE6FFE43EE54ACEB5105F2E3707CA_1660156691 = (getID().equals(tz.getID())
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713958317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713958317;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.547 -0400", hash_original_method = "80F5C5F4A535ECB3386672D31D5CF9AA", hash_generated_method = "35EA15096B3FF73CC2BA49AD6BDC10C8")
    @Override
    public int getDSTSavings() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356785523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356785523;
        // ---------- Original Method ----------
        //if (!useDaylight) {
            //return 0;
        //}
        //return dstSavings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.550 -0400", hash_original_method = "8DB3C09D8D79030897991A8AF2C3603A", hash_generated_method = "2B895EE101B71708E5E9C30C4D577443")
    @Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int time) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid era: " + era);
        } //End block
        checkRange(month, dayOfWeek, time);
        {
            boolean varDDE26ED6F6F2D378E54C9D0FD807F9B0_1980024184 = (month != Calendar.FEBRUARY || day != 29 || !isLeapYear(year));
            {
                checkDay(month, day);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAE28A042D21B15EB2BF786A48B929263_785145533 = (!useDaylightTime() || era != GregorianCalendar.AD || year < startYear);
        } //End collapsed parenthetic
        int ruleDay, daysInMonth, firstDayOfMonth;
        ruleDay = 0;
        firstDayOfMonth = mod7(dayOfWeek - day);
        {
            //Begin case DOM_MODE 
            ruleDay = startDay;
            //End case DOM_MODE 
            //Begin case DOW_IN_MONTH_MODE 
            {
                ruleDay = mod7(startDayOfWeek - firstDayOfMonth) + 1
                                + (startDay - 1) * 7;
            } //End block
            {
                daysInMonth = GregorianCalendar.DaysInMonth[startMonth];
                {
                    boolean var34F59880D95385B2DD6E1245C2952EE3_1873353547 = (startMonth == Calendar.FEBRUARY && isLeapYear(
                                year));
                    {
                        daysInMonth += 1;
                    } //End block
                } //End collapsed parenthetic
                ruleDay = daysInMonth
                                + 1
                                + mod7(startDayOfWeek
                                - (firstDayOfMonth + daysInMonth))
                                + startDay * 7;
            } //End block
            //End case DOW_IN_MONTH_MODE 
            //Begin case DOW_GE_DOM_MODE 
            ruleDay = startDay
                            + mod7(startDayOfWeek
                            - (firstDayOfMonth + startDay - 1));
            //End case DOW_GE_DOM_MODE 
            //Begin case DOW_LE_DOM_MODE 
            ruleDay = startDay
                            + mod7(startDayOfWeek
                            - (firstDayOfMonth + startDay - 1));
            //End case DOW_LE_DOM_MODE 
            //Begin case DOW_LE_DOM_MODE 
            {
                ruleDay -= 7;
            } //End block
            //End case DOW_LE_DOM_MODE 
        } //End block
        int ruleTime;
        ruleTime = endTime - dstSavings;
        int nextMonth;
        nextMonth = (month + 1) % 12;
        {
            //Begin case DOM_MODE 
            ruleDay = endDay;
            //End case DOM_MODE 
            //Begin case DOW_IN_MONTH_MODE 
            {
                ruleDay = mod7(endDayOfWeek - firstDayOfMonth) + 1
                                + (endDay - 1) * 7;
            } //End block
            {
                daysInMonth = GregorianCalendar.DaysInMonth[endMonth];
                {
                    boolean varA62BC480A841AF891471E24690DA3AEC_938142482 = (endMonth == Calendar.FEBRUARY && isLeapYear(year));
                } //End collapsed parenthetic
                ruleDay = daysInMonth
                                + 1
                                + mod7(endDayOfWeek
                                - (firstDayOfMonth + daysInMonth)) + endDay
                                * 7;
            } //End block
            //End case DOW_IN_MONTH_MODE 
            //Begin case DOW_GE_DOM_MODE 
            ruleDay = endDay
                            + mod7(
                            endDayOfWeek - (firstDayOfMonth + endDay - 1));
            //End case DOW_GE_DOM_MODE 
            //Begin case DOW_LE_DOM_MODE 
            ruleDay = endDay
                            + mod7(
                            endDayOfWeek - (firstDayOfMonth + endDay - 1));
            //End case DOW_LE_DOM_MODE 
            //Begin case DOW_LE_DOM_MODE 
            {
                ruleDay -= 7;
            } //End block
            //End case DOW_LE_DOM_MODE 
            int ruleMonth;
            ruleMonth = endMonth;
            {
                int changeDays;
                changeDays = 1 - (ruleTime / 86400000);
                ruleTime = (ruleTime % 86400000) + 86400000;
                ruleDay -= changeDays;
                {
                    {
                        ruleMonth = Calendar.DECEMBER;
                    } //End block
                    ruleDay += GregorianCalendar.DaysInMonth[ruleMonth];
                    {
                        boolean var942B201C9F9DC371A222C49906220991_208323113 = (ruleMonth == Calendar.FEBRUARY && isLeapYear(year));
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        addTaint(era);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(dayOfWeek);
        addTaint(time);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370909126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370909126;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.563 -0400", hash_original_method = "6DBE603182E450BA9A410285A6D6CE41", hash_generated_method = "50659039288953A947799D48D88A48FD")
    @Override
    public int getOffset(long time) {
        {
            boolean varAC33886EBC7D5E71649B935B25265F07_54947281 = (!useDaylightTime());
        } //End collapsed parenthetic
        int[] fields;
        fields = Grego.timeToFields(time + rawOffset, null);
        int var68E2FD47563B72F3EFF55569C2664413_778435883 = (getOffset(GregorianCalendar.AD, fields[0], fields[1], fields[2],
                fields[3], fields[5]));
        addTaint(time);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524581634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524581634;
        // ---------- Original Method ----------
        //if (!useDaylightTime()) {
            //return rawOffset;
        //}
        //int[] fields = Grego.timeToFields(time + rawOffset, null);
        //return getOffset(GregorianCalendar.AD, fields[0], fields[1], fields[2],
                //fields[3], fields[5]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.564 -0400", hash_original_method = "D90129E49D21D0E2F7EA4F6539F9D2CB", hash_generated_method = "91C1BBF48B31E1A378080E2B45E6F6D5")
    @Override
    public int getRawOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703399160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703399160;
        // ---------- Original Method ----------
        //return rawOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.564 -0400", hash_original_method = "543AFBFA58DD3885C5C6D68F749BE5FB", hash_generated_method = "49D00678E68FA6992E24C679019488BC")
    @Override
    public synchronized int hashCode() {
        int hashCode;
        hashCode = getID().hashCode() + rawOffset;
        {
            hashCode += startYear + startMonth + startDay + startDayOfWeek
                    + startTime + startMode + endMonth + endDay + endDayOfWeek
                    + endTime + endMode + dstSavings;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316039734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316039734;
        // ---------- Original Method ----------
        //int hashCode = getID().hashCode() + rawOffset;
        //if (useDaylight) {
            //hashCode += startYear + startMonth + startDay + startDayOfWeek
                    //+ startTime + startMode + endMonth + endDay + endDayOfWeek
                    //+ endTime + endMode + dstSavings;
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.565 -0400", hash_original_method = "4BB4BBFFC89848EE3A9E98B493F95D5F", hash_generated_method = "9D69D907811F1D6DFADA363289BCB90B")
    @Override
    public boolean hasSameRules(TimeZone zone) {
        SimpleTimeZone tz;
        tz = (SimpleTimeZone) zone;
        addTaint(zone.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166283902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166283902;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.565 -0400", hash_original_method = "C51A338C9795AC2507162C0CE1A08702", hash_generated_method = "5D663D7F529CDFF41DBCEED56FFB4C20")
    @Override
    public boolean inDaylightTime(Date time) {
        boolean varEE507C2978DFF3408523E16B966BE7F9_1964484630 = (useDaylightTime() && getOffset(time.getTime()) != getRawOffset());
        addTaint(time.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_687241926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_687241926;
        // ---------- Original Method ----------
        //return useDaylightTime() && getOffset(time.getTime()) != getRawOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.565 -0400", hash_original_method = "8AD8F18B8E2CE991A6AB313B3340B306", hash_generated_method = "576CCB3B069F9A95CB3B94F52B46DAC2")
    private boolean isLeapYear(int year) {
        addTaint(year);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925904886 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_925904886;
        // ---------- Original Method ----------
        //if (year > 1582) {
            //return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        //}
        //return year % 4 == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.566 -0400", hash_original_method = "EABB822EA3A4CED689A420DE5F07AD18", hash_generated_method = "A1DBCF398FB51C4B69ED3D90E085AA3B")
    private int mod7(int num1) {
        int rem;
        rem = num1 % 7;
        addTaint(num1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881558308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881558308;
        // ---------- Original Method ----------
        //int rem = num1 % 7;
        //return (num1 < 0 && rem < 0) ? 7 + rem : rem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.566 -0400", hash_original_method = "37D938F55D2005A7FF3D5AC31467EF4C", hash_generated_method = "CBB22A08F16C106C2CAD1E7AEC343566")
    public void setDSTSavings(int milliseconds) {
        {
            dstSavings = milliseconds;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (milliseconds > 0) {
            //dstSavings = milliseconds;
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.566 -0400", hash_original_method = "29EACAF13C91B179EA825409505E4565", hash_generated_method = "EC2606E51A82463E30FF345C52C29710")
    private void checkRange(int month, int dayOfWeek, int time) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid month: " + month);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid time: " + time);
        } //End block
        addTaint(month);
        addTaint(dayOfWeek);
        addTaint(time);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.567 -0400", hash_original_method = "F04B5CC4561F29CBDFD2A63D85494102", hash_generated_method = "DC092CA7AB51B0A36201C97DA17437A2")
    private void checkDay(int month, int day) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid day of month: " + day);
        } //End block
        addTaint(month);
        addTaint(day);
        // ---------- Original Method ----------
        //if (day <= 0 || day > GregorianCalendar.DaysInMonth[month]) {
            //throw new IllegalArgumentException("Invalid day of month: " + day);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.578 -0400", hash_original_method = "E98C141304510A5F08CF5DF5CC63E118", hash_generated_method = "F8DEE44AD3F0DB21DB13D763ADEAA1D3")
    private void setEndMode() {
        {
            endMode = DOM_MODE;
        } //End block
        {
            endDayOfWeek = -endDayOfWeek;
            {
                endDay = -endDay;
                endMode = DOW_LE_DOM_MODE;
            } //End block
            {
                endMode = DOW_GE_DOM_MODE;
            } //End block
        } //End block
        {
            endMode = DOW_IN_MONTH_MODE;
        } //End block
        useDaylight = startDay != 0 && endDay != 0;
        {
            checkRange(endMonth, endMode == DOM_MODE ? 1 : endDayOfWeek,
                    endTime);
            {
                checkDay(endMonth, endDay);
            } //End block
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Day of week in month: " + endDay);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.579 -0400", hash_original_method = "B4162090EB008A9B00DF0FE1EF92B7AC", hash_generated_method = "C0562577D3BEFBBA8D48F9088BA817C4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.579 -0400", hash_original_method = "582DA5383125C3306AD7EBC943F58F20", hash_generated_method = "A6CE6CC12A87A78BAED4267F777AF0F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.579 -0400", hash_original_method = "2E94B36A00113021CB8FDF603EDAA945", hash_generated_method = "92A47AE4EC7D81F56ABC3D44E434CD83")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.580 -0400", hash_original_method = "C8A257B93E1C51862FD9A30D6A75C66A", hash_generated_method = "565DCC6768A82C6D61497D0F194E6405")
    @Override
    public void setRawOffset(int offset) {
        rawOffset = offset;
        // ---------- Original Method ----------
        //rawOffset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.580 -0400", hash_original_method = "4370DAC820CAB38F82466934EE4F5C8D", hash_generated_method = "F78AC451ED09031C844DED4FA305FC9D")
    private void setStartMode() {
        {
            startMode = DOM_MODE;
        } //End block
        {
            startDayOfWeek = -startDayOfWeek;
            {
                startDay = -startDay;
                startMode = DOW_LE_DOM_MODE;
            } //End block
            {
                startMode = DOW_GE_DOM_MODE;
            } //End block
        } //End block
        {
            startMode = DOW_IN_MONTH_MODE;
        } //End block
        useDaylight = startDay != 0 && endDay != 0;
        {
            checkRange(startMonth, startMode == DOM_MODE ? 1 : startDayOfWeek,
                    startTime);
            {
                checkDay(startMonth, startDay);
            } //End block
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Day of week in month: " + startDay);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.591 -0400", hash_original_method = "1B6B9F6DA0D38FD2E6B0C75070F8A774", hash_generated_method = "8E3473DDB37FF6F7006F9986018B7502")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.591 -0400", hash_original_method = "05B57A1DF0091079AD9D1D4FB9E42767", hash_generated_method = "21B93F0AA81CC56EFC6B90272C1612AB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.592 -0400", hash_original_method = "D71B6352FE444D82D409CFA5438BDAA8", hash_generated_method = "538156448C614086085AEF11A2495F76")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.592 -0400", hash_original_method = "7CBF25AFDCF863C97C11F8D0CB7F66E7", hash_generated_method = "0EAB2221FE5CC0E50F7ABB3F73F14E8B")
    public void setStartYear(int year) {
        startYear = year;
        useDaylight = true;
        // ---------- Original Method ----------
        //startYear = year;
        //useDaylight = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.600 -0400", hash_original_method = "8DB4BEB563F494A2FC46832022F4609E", hash_generated_method = "5D2705E78F0269273DF3600AF9789B06")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1277398807 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1277398807 = getClass().getName()
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
        varB4EAC82CA7396A68D541C85D26508E83_1277398807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1277398807;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.600 -0400", hash_original_method = "7C1BE50DE9C29B43BADE36CF66AF8A96", hash_generated_method = "5E69BAE0BF37C78C29123BDE9C7422FC")
    @Override
    public boolean useDaylightTime() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580561142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580561142;
        // ---------- Original Method ----------
        //return useDaylight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.607 -0400", hash_original_method = "F4691E6CC75F84FE0527C352A6F6F1B9", hash_generated_method = "1F8BBCA03B00AF88566C246823370B1E")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        int sEndDay, sEndDayOfWeek, sStartDay, sStartDayOfWeek;
        sEndDay = endDay;
        sEndDayOfWeek = endDayOfWeek + 1;
        sStartDay = startDay;
        sStartDayOfWeek = startDayOfWeek + 1;
        {
            Calendar cal;
            cal = new GregorianCalendar(this);
            {
                cal.set(Calendar.MONTH, endMonth);
                cal.set(Calendar.DATE, endDay);
                sEndDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                {
                    sEndDayOfWeek = cal.getFirstDayOfWeek();
                } //End block
            } //End block
            {
                cal.set(Calendar.MONTH, startMonth);
                cal.set(Calendar.DATE, startDay);
                sStartDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                {
                    sStartDayOfWeek = cal.getFirstDayOfWeek();
                } //End block
            } //End block
        } //End block
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
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
        byte[] values;
        values = new byte[4];
        values[0] = (byte) startDay;
        values[1] = (byte) (startMode == DOM_MODE ? 0 : startDayOfWeek + 1);
        values[2] = (byte) endDay;
        values[3] = (byte) (endMode == DOM_MODE ? 0 : endDayOfWeek + 1);
        stream.write(values);
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.623 -0400", hash_original_method = "19765306B3DA0529AD0AFD53EDC0B4B8", hash_generated_method = "472B52F821A0BE3904450AA3C8FD7414")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        rawOffset = fields.get("rawOffset", 0);
        useDaylight = fields.get("useDaylight", false);
        {
            endMonth = fields.get("endMonth", 0);
            endTime = fields.get("endTime", 0);
            startMonth = fields.get("startMonth", 0);
            startTime = fields.get("startTime", 0);
            startYear = fields.get("startYear", 0);
        } //End block
        {
            boolean varB1402D125FA51CA7547D890DB81A6275_1274387421 = (fields.get("serialVersionOnStream", 0) == 0);
            {
                {
                    startMode = endMode = DOW_IN_MONTH_MODE;
                    endDay = fields.get("endDay", 0);
                    endDayOfWeek = fields.get("endDayOfWeek", 0) - 1;
                    startDay = fields.get("startDay", 0);
                    startDayOfWeek = fields.get("startDayOfWeek", 0) - 1;
                } //End block
            } //End block
            {
                dstSavings = fields.get("dstSavings", 0);
                {
                    endMode = fields.get("endMode", 0);
                    startMode = fields.get("startMode", 0);
                    int length;
                    length = stream.readInt();
                    byte[] values;
                    values = new byte[length];
                    stream.readFully(values);
                    {
                        startDay = values[0];
                        startDayOfWeek = values[1];
                        endDay = values[2];
                        endDayOfWeek = values[3];
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.623 -0400", hash_original_field = "8502F83FA777B7BAEC96DD1642714A6A", hash_generated_field = "B8124DE1626A5AD51C2FE361C000642A")

    private static long serialVersionUID = -403250971215465050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.623 -0400", hash_original_field = "A16CDC7A98B9FE1707BCB38A5FD0B490", hash_generated_field = "55C512FC8A94B3DE90A052856296C2D8")

    private static int DOM_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.624 -0400", hash_original_field = "B27995F1E6069CEF7A0FF35116D534B6", hash_generated_field = "C4FAB5A8BC4E673B3B0F6C401FB650FB")

    private static int DOW_IN_MONTH_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.624 -0400", hash_original_field = "04A0BC6AA9754653D5751ED4E151C000", hash_generated_field = "8B2A2BCC5BD25072C4233A98AB25C53F")

    private static int DOW_GE_DOM_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.624 -0400", hash_original_field = "31ABAC6414B935DA144D0D6AEB5168DC", hash_generated_field = "A8042AF2B47DC6B64C8E805D1130AEA1")

    private static int DOW_LE_DOM_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.624 -0400", hash_original_field = "346488806B5A9C262B4E154D9F31D394", hash_generated_field = "61DB737AECFE59272E81B27E825907AA")

    public static final int UTC_TIME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.624 -0400", hash_original_field = "CAB987564C6E2151DEA026DF1C3F228F", hash_generated_field = "DC2E634827EAB82F13E8E712A81C7981")

    public static final int STANDARD_TIME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.624 -0400", hash_original_field = "3ECC377EE99AA75ADE5DFA23CC69BF01", hash_generated_field = "847DF430EF9ED807826F046224B40B8D")

    public static final int WALL_TIME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.624 -0400", hash_original_field = "1C772818B060E4B20F2D1A5C10F9D69F", hash_generated_field = "DF3B779AC65293AACA2C768A9CD43464")

    private static ObjectStreamField[] serialPersistentFields = ;
}

