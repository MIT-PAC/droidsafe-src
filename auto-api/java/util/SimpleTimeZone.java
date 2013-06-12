package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

public class SimpleTimeZone extends TimeZone {
    private static final long serialVersionUID = -403250971215465050L;
    private int rawOffset;
    private int startYear, startMonth, startDay, startDayOfWeek, startTime;
    private int endMonth, endDay, endDayOfWeek, endTime;
    private int startMode, endMode;
    private static final int DOM_MODE = 1, DOW_IN_MONTH_MODE = 2,
            DOW_GE_DOM_MODE = 3, DOW_LE_DOM_MODE = 4;
    public static final int UTC_TIME = 2;
    public static final int STANDARD_TIME = 1;
    public static final int WALL_TIME = 0;
    private boolean useDaylight;
    private int dstSavings = 3600000;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.157 -0400", hash_original_method = "A73AE5A515785364E3BAF8A0CE898B7F", hash_generated_method = "7CDF2C4FAA58375396FCF320AB870E98")
    @DSModeled(DSC.SAFE)
    public SimpleTimeZone(int offset, final String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(offset);
        setID(name);
        // ---------- Original Method ----------
        //setID(name);
        //rawOffset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.157 -0400", hash_original_method = "8CE6DF24772062229638C2D4C95CF5BA", hash_generated_method = "1BAEA432F6119EBEAD86EC680B80768D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime) {
        this(offset, name, startMonth, startDay, startDayOfWeek, startTime,
                endMonth, endDay, endDayOfWeek, endTime, 3600000);
        dsTaint.addTaint(startTime);
        dsTaint.addTaint(startDayOfWeek);
        dsTaint.addTaint(endDay);
        dsTaint.addTaint(startDay);
        dsTaint.addTaint(endDayOfWeek);
        dsTaint.addTaint(name);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(startMonth);
        dsTaint.addTaint(endTime);
        dsTaint.addTaint(endMonth);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.158 -0400", hash_original_method = "8623FC95180B9E56345F7D06857248B1", hash_generated_method = "F279E6A6C12F6FD46C46ABC436A7CE9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime, int daylightSavings) {
        this(offset, name);
        dsTaint.addTaint(startTime);
        dsTaint.addTaint(startDayOfWeek);
        dsTaint.addTaint(endDay);
        dsTaint.addTaint(startDay);
        dsTaint.addTaint(endDayOfWeek);
        dsTaint.addTaint(name);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(startMonth);
        dsTaint.addTaint(endTime);
        dsTaint.addTaint(daylightSavings);
        dsTaint.addTaint(endMonth);
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("Invalid daylightSavings: " + daylightSavings);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.158 -0400", hash_original_method = "79A83CB077FC893587B86C22BBA871F3", hash_generated_method = "268F2F3643B98C8FB9092F6B4C352EC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int startTimeMode,
            int endMonth, int endDay, int endDayOfWeek, int endTime,
            int endTimeMode, int daylightSavings) {
        this(offset, name, startMonth, startDay, startDayOfWeek, startTime,
                endMonth, endDay, endDayOfWeek, endTime, daylightSavings);
        dsTaint.addTaint(endDay);
        dsTaint.addTaint(endTimeMode);
        dsTaint.addTaint(startTimeMode);
        dsTaint.addTaint(endTime);
        dsTaint.addTaint(daylightSavings);
        dsTaint.addTaint(startTime);
        dsTaint.addTaint(startDayOfWeek);
        dsTaint.addTaint(endDayOfWeek);
        dsTaint.addTaint(startDay);
        dsTaint.addTaint(name);
        dsTaint.addTaint(startMonth);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(endMonth);
        // ---------- Original Method ----------
        //startMode = startTimeMode;
        //endMode = endTimeMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.158 -0400", hash_original_method = "826DFB88845863F51C3C619017A5C62F", hash_generated_method = "097AC71F294A9BB32B466C0A71015E35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        SimpleTimeZone zone;
        zone = (SimpleTimeZone) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SimpleTimeZone zone = (SimpleTimeZone) super.clone();
        //return zone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.158 -0400", hash_original_method = "6B0E934BFCA438C9EF8D8ACC7F42CB32", hash_generated_method = "364459DCE0396F50596E04CF205888F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        SimpleTimeZone tz;
        tz = (SimpleTimeZone) object;
        boolean varAEEAE6FFE43EE54ACEB5105F2E3707CA_1032494165 = (getID().equals(tz.getID())
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.158 -0400", hash_original_method = "80F5C5F4A535ECB3386672D31D5CF9AA", hash_generated_method = "F0AA435EA202CFB64F1155516D55F2EA")
    @DSModeled(DSC.SAFE)
    @Override
    public int getDSTSavings() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!useDaylight) {
            //return 0;
        //}
        //return dstSavings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.159 -0400", hash_original_method = "8DB3C09D8D79030897991A8AF2C3603A", hash_generated_method = "109BE87D50578A6301F658123BCF1F08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int time) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(month);
        dsTaint.addTaint(era);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        dsTaint.addTaint(dayOfWeek);
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("Invalid era: " + era);
        } //End block
        
        checkRange(month, dayOfWeek, time);
        {
            boolean varDDE26ED6F6F2D378E54C9D0FD807F9B0_784688023 = (month != Calendar.FEBRUARY || day != 29 || !isLeapYear(year));
            {
                checkDay(month, day);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAE28A042D21B15EB2BF786A48B929263_68987478 = (!useDaylightTime() || era != GregorianCalendar.AD || year < startYear);
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
                    boolean var34F59880D95385B2DD6E1245C2952EE3_1623307062 = (startMonth == Calendar.FEBRUARY && isLeapYear(
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
                    boolean varA62BC480A841AF891471E24690DA3AEC_2117300201 = (endMonth == Calendar.FEBRUARY && isLeapYear(year));
                    {
                        daysInMonth++;
                    } //End block
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
                        boolean var942B201C9F9DC371A222C49906220991_222692358 = (ruleMonth == Calendar.FEBRUARY && isLeapYear(year));
                        {
                            ruleDay++;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.159 -0400", hash_original_method = "6DBE603182E450BA9A410285A6D6CE41", hash_generated_method = "8CBEC32C829D4D2F1BD159699152B06B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOffset(long time) {
        dsTaint.addTaint(time);
        {
            boolean varAC33886EBC7D5E71649B935B25265F07_958385809 = (!useDaylightTime());
        } //End collapsed parenthetic
        int[] fields;
        fields = Grego.timeToFields(time + rawOffset, null);
        int var68E2FD47563B72F3EFF55569C2664413_1400327513 = (getOffset(GregorianCalendar.AD, fields[0], fields[1], fields[2],
                fields[3], fields[5]));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!useDaylightTime()) {
            //return rawOffset;
        //}
        //int[] fields = Grego.timeToFields(time + rawOffset, null);
        //return getOffset(GregorianCalendar.AD, fields[0], fields[1], fields[2],
                //fields[3], fields[5]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.159 -0400", hash_original_method = "D90129E49D21D0E2F7EA4F6539F9D2CB", hash_generated_method = "FA9F2CCBB5383D2FABCE6E5CC715FEAC")
    @DSModeled(DSC.SAFE)
    @Override
    public int getRawOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return rawOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.159 -0400", hash_original_method = "543AFBFA58DD3885C5C6D68F749BE5FB", hash_generated_method = "3922FB2CAA137465B57EB830E7D5E669")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int hashCode() {
        int hashCode;
        hashCode = getID().hashCode() + rawOffset;
        {
            hashCode += startYear + startMonth + startDay + startDayOfWeek
                    + startTime + startMode + endMonth + endDay + endDayOfWeek
                    + endTime + endMode + dstSavings;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hashCode = getID().hashCode() + rawOffset;
        //if (useDaylight) {
            //hashCode += startYear + startMonth + startDay + startDayOfWeek
                    //+ startTime + startMode + endMonth + endDay + endDayOfWeek
                    //+ endTime + endMode + dstSavings;
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.160 -0400", hash_original_method = "4BB4BBFFC89848EE3A9E98B493F95D5F", hash_generated_method = "70FFB2102E13EFFB3AC91E400A672435")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasSameRules(TimeZone zone) {
        dsTaint.addTaint(zone.dsTaint);
        SimpleTimeZone tz;
        tz = (SimpleTimeZone) zone;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.160 -0400", hash_original_method = "C51A338C9795AC2507162C0CE1A08702", hash_generated_method = "0791EE284DB95F2EC042E6D7162EEA37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean inDaylightTime(Date time) {
        dsTaint.addTaint(time.dsTaint);
        boolean varEE507C2978DFF3408523E16B966BE7F9_173017344 = (useDaylightTime() && getOffset(time.getTime()) != getRawOffset());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return useDaylightTime() && getOffset(time.getTime()) != getRawOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.160 -0400", hash_original_method = "8AD8F18B8E2CE991A6AB313B3340B306", hash_generated_method = "34FEC65D9C893E3356DC067BA314697F")
    @DSModeled(DSC.SAFE)
    private boolean isLeapYear(int year) {
        dsTaint.addTaint(year);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (year > 1582) {
            //return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        //}
        //return year % 4 == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.160 -0400", hash_original_method = "EABB822EA3A4CED689A420DE5F07AD18", hash_generated_method = "826B307B4BDCF3941F7E27ACF128ABCF")
    @DSModeled(DSC.SAFE)
    private int mod7(int num1) {
        dsTaint.addTaint(num1);
        int rem;
        rem = num1 % 7;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int rem = num1 % 7;
        //return (num1 < 0 && rem < 0) ? 7 + rem : rem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.160 -0400", hash_original_method = "37D938F55D2005A7FF3D5AC31467EF4C", hash_generated_method = "068B7392E20B71879789DE1BA6900F6B")
    @DSModeled(DSC.SAFE)
    public void setDSTSavings(int milliseconds) {
        dsTaint.addTaint(milliseconds);
        {
            throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (milliseconds > 0) {
            //dstSavings = milliseconds;
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.160 -0400", hash_original_method = "29EACAF13C91B179EA825409505E4565", hash_generated_method = "18AC07BEDA2E4308201A2383ED4A88A4")
    @DSModeled(DSC.SAFE)
    private void checkRange(int month, int dayOfWeek, int time) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(month);
        dsTaint.addTaint(dayOfWeek);
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("Invalid month: " + month);
        } //End block
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
        } //End block
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("Invalid time: " + time);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.160 -0400", hash_original_method = "F04B5CC4561F29CBDFD2A63D85494102", hash_generated_method = "83DD15B31AACA940C48BBB03C97B5F43")
    @DSModeled(DSC.SAFE)
    private void checkDay(int month, int day) {
        dsTaint.addTaint(month);
        dsTaint.addTaint(day);
        {
            throw new IllegalArgumentException("Invalid day of month: " + day);
        } //End block
        // ---------- Original Method ----------
        //if (day <= 0 || day > GregorianCalendar.DaysInMonth[month]) {
            //throw new IllegalArgumentException("Invalid day of month: " + day);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.160 -0400", hash_original_method = "E98C141304510A5F08CF5DF5CC63E118", hash_generated_method = "0294889BE95880C0106985256CA8C5A5")
    @DSModeled(DSC.SAFE)
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
            if (DroidSafeAndroidRuntime.control) {
                    throw new IllegalArgumentException("Day of week in month: " + endDay);
            } //End block
        } //End block
        {
            endDayOfWeek--;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "B4162090EB008A9B00DF0FE1EF92B7AC", hash_generated_method = "1EF388A5A55349013F595842BAA4FE02")
    @DSModeled(DSC.SAFE)
    public void setEndRule(int month, int dayOfMonth, int time) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(dayOfMonth);
        dsTaint.addTaint(month);
        endDayOfWeek = 0;
        setEndMode();
        // ---------- Original Method ----------
        //endMonth = month;
        //endDay = dayOfMonth;
        //endDayOfWeek = 0;
        //endTime = time;
        //setEndMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "582DA5383125C3306AD7EBC943F58F20", hash_generated_method = "215FF300A4C8137D98A75DFBB862E658")
    @DSModeled(DSC.SAFE)
    public void setEndRule(int month, int day, int dayOfWeek, int time) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(month);
        dsTaint.addTaint(day);
        dsTaint.addTaint(dayOfWeek);
        setEndMode();
        // ---------- Original Method ----------
        //endMonth = month;
        //endDay = day;
        //endDayOfWeek = dayOfWeek;
        //endTime = time;
        //setEndMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "2E94B36A00113021CB8FDF603EDAA945", hash_generated_method = "02F48BFF3158AC6CA6F171AA5DB335EF")
    @DSModeled(DSC.SAFE)
    public void setEndRule(int month, int day, int dayOfWeek, int time, boolean after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(time);
        dsTaint.addTaint(month);
        dsTaint.addTaint(day);
        dsTaint.addTaint(dayOfWeek);
        endDay = after ? day : -day;
        endDayOfWeek = -dayOfWeek;
        setEndMode();
        // ---------- Original Method ----------
        //endMonth = month;
        //endDay = after ? day : -day;
        //endDayOfWeek = -dayOfWeek;
        //endTime = time;
        //setEndMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "C8A257B93E1C51862FD9A30D6A75C66A", hash_generated_method = "E596B424BD9F7673D7BC2CC492F63C5A")
    @DSModeled(DSC.SAFE)
    @Override
    public void setRawOffset(int offset) {
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //rawOffset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "4370DAC820CAB38F82466934EE4F5C8D", hash_generated_method = "0D0D2D61FB92027A11331CE0653F4762")
    @DSModeled(DSC.SAFE)
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
            	if (DroidSafeAndroidRuntime.control) {
                    throw new IllegalArgumentException("Day of week in month: " + startDay);
                } //End block
            } //End block
        } //End block
        {
            startDayOfWeek--;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "1B6B9F6DA0D38FD2E6B0C75070F8A774", hash_generated_method = "2FFC3B58EA26E16FADB6CF38EAA4A7FA")
    @DSModeled(DSC.SAFE)
    public void setStartRule(int month, int dayOfMonth, int time) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(dayOfMonth);
        dsTaint.addTaint(month);
        startDayOfWeek = 0;
        setStartMode();
        // ---------- Original Method ----------
        //startMonth = month;
        //startDay = dayOfMonth;
        //startDayOfWeek = 0;
        //startTime = time;
        //setStartMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "05B57A1DF0091079AD9D1D4FB9E42767", hash_generated_method = "795F581CEA0DEA341076E797857BC1B2")
    @DSModeled(DSC.SAFE)
    public void setStartRule(int month, int day, int dayOfWeek, int time) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(month);
        dsTaint.addTaint(day);
        dsTaint.addTaint(dayOfWeek);
        setStartMode();
        // ---------- Original Method ----------
        //startMonth = month;
        //startDay = day;
        //startDayOfWeek = dayOfWeek;
        //startTime = time;
        //setStartMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "D71B6352FE444D82D409CFA5438BDAA8", hash_generated_method = "9A0B79F8B5365ABABA6B96556FAE7A05")
    @DSModeled(DSC.SAFE)
    public void setStartRule(int month, int day, int dayOfWeek, int time, boolean after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(time);
        dsTaint.addTaint(month);
        dsTaint.addTaint(day);
        dsTaint.addTaint(dayOfWeek);
        startDay = after ? day : -day;
        startDayOfWeek = -dayOfWeek;
        setStartMode();
        // ---------- Original Method ----------
        //startMonth = month;
        //startDay = after ? day : -day;
        //startDayOfWeek = -dayOfWeek;
        //startTime = time;
        //setStartMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.161 -0400", hash_original_method = "7CBF25AFDCF863C97C11F8D0CB7F66E7", hash_generated_method = "18A64CF22A6F1A6BC46E2A4D43EA627C")
    @DSModeled(DSC.SAFE)
    public void setStartYear(int year) {
        dsTaint.addTaint(year);
        useDaylight = true;
        // ---------- Original Method ----------
        //startYear = year;
        //useDaylight = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.162 -0400", hash_original_method = "8DB4BEB563F494A2FC46832022F4609E", hash_generated_method = "CAE8A18FBBD68676EBFE6DE3202A8FFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var325814D57C729356073E55069D93EAFE_100380728 = (getClass().getName()
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
                + ",endTime=" + endTime + "]"); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.162 -0400", hash_original_method = "7C1BE50DE9C29B43BADE36CF66AF8A96", hash_generated_method = "AB135649369340087F147EFF32862440")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean useDaylightTime() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return useDaylight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.162 -0400", hash_original_method = "F4691E6CC75F84FE0527C352A6F6F1B9", hash_generated_method = "57C2D7F371D1233726AF3123D9F59C93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.163 -0400", hash_original_method = "19765306B3DA0529AD0AFD53EDC0B4B8", hash_generated_method = "1F8C6EC8A7630C86E87E9D34950E21C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
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
            boolean varB1402D125FA51CA7547D890DB81A6275_1868162591 = (fields.get("serialVersionOnStream", 0) == 0);
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
                        {
                            startDayOfWeek--;
                        } //End block
                        endDay = values[2];
                        endDayOfWeek = values[3];
                        {
                            endDayOfWeek--;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


