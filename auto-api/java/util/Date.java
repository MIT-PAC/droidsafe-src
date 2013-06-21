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
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import libcore.icu.LocaleData;

public class Date implements Serializable, Cloneable, Comparable<Date> {
    private transient long milliseconds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.834 -0400", hash_original_method = "117F9B64DCE96B425DE39D6FF0E7C956", hash_generated_method = "B532C1831EBB14D72EFD726653EE6196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date() {
        this(System.currentTimeMillis());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.835 -0400", hash_original_method = "1DCF8B1AF6198BC90A64E56405CA39AF", hash_generated_method = "351C1951BAB288B6B235C61A40D4DE91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Date(int year, int month, int day) {
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        GregorianCalendar cal;
        cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.835 -0400", hash_original_method = "426C20A19A7753D3CB1FAC13BA7CC9BA", hash_generated_method = "4FC87E5A70EA8A06C4D32D77AD215A9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Date(int year, int month, int day, int hour, int minute) {
        dsTaint.addTaint(minute);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(hour);
        dsTaint.addTaint(day);
        GregorianCalendar cal;
        cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day, hour, minute);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.835 -0400", hash_original_method = "139F1B989333E9F68B465E1B19165668", hash_generated_method = "660A1F4AD56F107D03A10E715DE4BD1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Date(int year, int month, int day, int hour, int minute, int second) {
        dsTaint.addTaint(minute);
        dsTaint.addTaint(second);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(hour);
        dsTaint.addTaint(day);
        GregorianCalendar cal;
        cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute, second);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day, hour, minute, second);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.835 -0400", hash_original_method = "F91B8E0C111622A18C17EB4FC5AA472B", hash_generated_method = "AA54BCAF60B8121A267EA6F812EED924")
    @DSModeled(DSC.SAFE)
    public Date(long milliseconds) {
        dsTaint.addTaint(milliseconds);
        // ---------- Original Method ----------
        //this.milliseconds = milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.836 -0400", hash_original_method = "2B1036AFFF9E6DD3B4220E3E27A88A34", hash_generated_method = "84E80D589709C76E5367E3838A24D987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Date(String string) {
        dsTaint.addTaint(string);
        milliseconds = parse(string);
        // ---------- Original Method ----------
        //milliseconds = parse(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.836 -0400", hash_original_method = "A5A1DDC35C23D543E612D23967A596DA", hash_generated_method = "4D57B35FD3EDB674FA7534BA6F1D26DF")
    @DSModeled(DSC.SAFE)
    public boolean after(Date date) {
        dsTaint.addTaint(date.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return milliseconds > date.milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.836 -0400", hash_original_method = "EB21B83A31DD3DBD1842C230376F433E", hash_generated_method = "4AED47E74A23F41256387E227C220353")
    @DSModeled(DSC.SAFE)
    public boolean before(Date date) {
        dsTaint.addTaint(date.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return milliseconds < date.milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.836 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "ED3264871F70A85F4DE73B7EA0F8C7BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_901638063 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.837 -0400", hash_original_method = "7C9742DC24BA8DF560999557E5DD5087", hash_generated_method = "8B8603800A4BBB0BDD74BDA5AFF90DA9")
    @DSModeled(DSC.SAFE)
    public int compareTo(Date date) {
        dsTaint.addTaint(date.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (milliseconds < date.milliseconds) {
            //return -1;
        //}
        //if (milliseconds == date.milliseconds) {
            //return 0;
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.837 -0400", hash_original_method = "DDDF9262D80550B9DB77ACA0997BD3D6", hash_generated_method = "BC34E16DC250AE697AAE07FEDF58383A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varEAE97717131044CA6F192EFDC5FF5D60_119351363 = ((object == this) || (object instanceof Date)
                && (milliseconds == ((Date) object).milliseconds));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object == this) || (object instanceof Date)
                //&& (milliseconds == ((Date) object).milliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.837 -0400", hash_original_method = "9CDBB71B4B3C803B1AA8EE69EFD3E0ED", hash_generated_method = "F80119795C8DC802C7AF2E3C1AE834C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getDate() {
        int varC0A714720A6D4DAC31FEF058D8440CD7_1003741867 = (new GregorianCalendar(milliseconds).get(Calendar.DATE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.DATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.837 -0400", hash_original_method = "A7B9A9C37FFBE4D61CB1113163F9DEB3", hash_generated_method = "AE76E7022F5D351B7CC26FE7BEF4EE47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getDay() {
        int var3FE3B012F56C52737C59335A2FCB89A8_792398255 = (new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.837 -0400", hash_original_method = "E9FAB79941832FB5BB28A56A75132611", hash_generated_method = "2265672E7F4F045B34CEB2C957CEE491")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getHours() {
        int var4CFAA335C0802D591C180C590651DB9C_282781412 = (new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.838 -0400", hash_original_method = "905F61D3BDD6A004D6695A8C4C0A588F", hash_generated_method = "CE045FB4B9F95092997EAE43B33B923A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getMinutes() {
        int varB9975022E7FEA5A13782580C91D0E1A8_278687964 = (new GregorianCalendar(milliseconds).get(Calendar.MINUTE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.MINUTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.838 -0400", hash_original_method = "62BF86AE189F2A0680B405E29E252A59", hash_generated_method = "61B698F04105A89975BBC695B0674BBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getMonth() {
        int varBFC3339A9B04E6CFC333A192D60231AA_1660344388 = (new GregorianCalendar(milliseconds).get(Calendar.MONTH));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.MONTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.838 -0400", hash_original_method = "21461173A59BCEF943A6FBABC454A724", hash_generated_method = "3527AD36CB06EB85FC53D9A46A37E34F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getSeconds() {
        int varA854ACC5DFBE36B1C5F437CD467A3D27_114336966 = (new GregorianCalendar(milliseconds).get(Calendar.SECOND));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.SECOND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.838 -0400", hash_original_method = "6634404A1A66BE1A7302C8A8E427A289", hash_generated_method = "9DEDFE93BF5EAD6558AFD32C00E61483")
    @DSModeled(DSC.SAFE)
    public long getTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.838 -0400", hash_original_method = "1B1108BADA7A1EB96631D5AF2C5C5E87", hash_generated_method = "477DA0699E4386C280C98799C83F1BD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getTimezoneOffset() {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        int varFFFB7142DA303EFC159034F99D5D2BAC_1667094521 = (-(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //return -(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.839 -0400", hash_original_method = "C799A54F09693A95BB69288113BB6509", hash_generated_method = "24EB75D4ABCD45FAE9F67B527ED6FFA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getYear() {
        int var8A0F590C032321D56632D8913269C9D8_1398960120 = (new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.839 -0400", hash_original_method = "B128FED5B5AAAF883404F36E34AD6524", hash_generated_method = "D9B5260338760AA0D29231ECB6F6FBD2")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) (milliseconds >>> 32) ^ (int) milliseconds;
    }

    
        private static int parse(String string, String[] array) {
        for (int i = 0, alength = array.length, slength = string.length(); i < alength; i++) {
            if (string.regionMatches(true, 0, array[i], 0, slength)) {
                return i;
            }
        }
        return -1;
    }

    
        @Deprecated
    public static long parse(String string) {
        if (string == null) {
            throw new IllegalArgumentException("The string argument is null");
        }
        char sign = 0;
        int commentLevel = 0;
        int offset = 0, length = string.length(), state = 0;
        int year = -1, month = -1, date = -1;
        int hour = -1, minute = -1, second = -1, zoneOffset = 0, minutesOffset = 0;
        boolean zone = false;
        final int PAD = 0, LETTERS = 1, NUMBERS = 2;
        StringBuilder buffer = new StringBuilder();
        while (offset <= length) {
            char next = offset < length ? string.charAt(offset) : '\r';
            offset++;
            if (next == '(') {
                commentLevel++;
            }
            if (commentLevel > 0) {
                if (next == ')') {
                    commentLevel--;
                }
                if (commentLevel == 0) {
                    next = ' ';
                } else {
                    continue;
                }
            }
            int nextState = PAD;
            if ('a' <= next && next <= 'z' || 'A' <= next && next <= 'Z') {
                nextState = LETTERS;
            } else if ('0' <= next && next <= '9') {
                nextState = NUMBERS;
            } else if (!Character.isSpace(next) && ",+-:/".indexOf(next) == -1) {
                throw new IllegalArgumentException();
            }
            if (state == NUMBERS && nextState != NUMBERS) {
                int digit = Integer.parseInt(buffer.toString());
                buffer.setLength(0);
                if (sign == '+' || sign == '-') {
                    if (zoneOffset == 0) {
                        zone = true;
                        if (next == ':') {
                            minutesOffset = sign == '-' ? -Integer
                                    .parseInt(string.substring(offset,
                                            offset + 2)) : Integer
                                    .parseInt(string.substring(offset,
                                            offset + 2));
                            offset += 2;
                        }
                        zoneOffset = sign == '-' ? -digit : digit;
                        sign = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (digit >= 70) {
                    if (year == -1
                            && (Character.isSpace(next) || next == ','
                                    || next == '/' || next == '\r')) {
                        year = digit;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (next == ':') {
                    if (hour == -1) {
                        hour = digit;
                    } else if (minute == -1) {
                        minute = digit;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (next == '/') {
                    if (month == -1) {
                        month = digit - 1;
                    } else if (date == -1) {
                        date = digit;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (Character.isSpace(next) || next == ','
                        || next == '-' || next == '\r') {
                    if (hour != -1 && minute == -1) {
                        minute = digit;
                    } else if (minute != -1 && second == -1) {
                        second = digit;
                    } else if (date == -1) {
                        date = digit;
                    } else if (year == -1) {
                        year = digit;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (year == -1 && month != -1 && date != -1) {
                    year = digit;
                } else {
                    throw new IllegalArgumentException();
                }
            } else if (state == LETTERS && nextState != LETTERS) {
                String text = buffer.toString().toUpperCase(Locale.US);
                buffer.setLength(0);
                if (text.length() == 1) {
                    throw new IllegalArgumentException();
                }
                if (text.equals("AM")) {
                    if (hour == 12) {
                        hour = 0;
                    } else if (hour < 1 || hour > 12) {
                        throw new IllegalArgumentException();
                    }
                } else if (text.equals("PM")) {
                    if (hour == 12) {
                        hour = 0;
                    } else if (hour < 1 || hour > 12) {
                        throw new IllegalArgumentException();
                    }
                    hour += 12;
                } else {
                    DateFormatSymbols symbols = new DateFormatSymbols(Locale.US);
                    String[] weekdays = symbols.getWeekdays(), months = symbols
                            .getMonths();
                    int value;
                    if (parse(text, weekdays) != -1) {
                    } else if (month == -1 && (month = parse(text, months)) != -1) {
                    } else if (text.equals("GMT") || text.equals("UT") || text.equals("UTC")) {
                        zone = true;
                        zoneOffset = 0;
                    } else if ((value = zone(text)) != 0) {
                        zone = true;
                        zoneOffset = value;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
            if (next == '+' || (year != -1 && next == '-')) {
                sign = next;
            } else if (!Character.isSpace(next) && next != ','
                    && nextState != NUMBERS) {
                sign = 0;
            }
            if (nextState == LETTERS || nextState == NUMBERS) {
                buffer.append(next);
            }
            state = nextState;
        }
        if (year != -1 && month != -1 && date != -1) {
            if (hour == -1) {
                hour = 0;
            }
            if (minute == -1) {
                minute = 0;
            }
            if (second == -1) {
                second = 0;
            }
            if (year < (creationYear - 80)) {
                year += 2000;
            } else if (year < 100) {
                year += 1900;
            }
            minute -= minutesOffset;
            if (zone) {
                if (zoneOffset >= 24 || zoneOffset <= -24) {
                    hour -= zoneOffset / 100;
                    minute -= zoneOffset % 100;
                } else {
                    hour -= zoneOffset;
                }
                return UTC(year - 1900, month, date, hour, minute, second);
            }
            return new Date(year - 1900, month, date, hour, minute, second)
                    .getTime();
        }
        throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.840 -0400", hash_original_method = "CA2D09B2D9B2F9BDCD2321E1B3353343", hash_generated_method = "5EAC46126672EB7DC2F50C59FAB5A801")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setDate(int day) {
        dsTaint.addTaint(day);
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.DATE, day);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.DATE, day);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.840 -0400", hash_original_method = "DAB8B4072C80F91D1F54942852D0B029", hash_generated_method = "00CA4B497FA44E980736476E47A19764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setHours(int hour) {
        dsTaint.addTaint(hour);
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.HOUR_OF_DAY, hour);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.840 -0400", hash_original_method = "9DC7826FE54BE20D0703E6C2CC9AB71D", hash_generated_method = "01FD8D7E2A819D3F3EC53F0993D758BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setMinutes(int minute) {
        dsTaint.addTaint(minute);
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MINUTE, minute);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.MINUTE, minute);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.840 -0400", hash_original_method = "CBC4CDF52C0128D6B57913B17A16C753", hash_generated_method = "6972BE94B3C2622D66990AFBEE8C4EFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setMonth(int month) {
        dsTaint.addTaint(month);
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MONTH, month);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.MONTH, month);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.841 -0400", hash_original_method = "2FB8CB70BDB70CDBCF22A1F179F9FAD0", hash_generated_method = "C072E51C51B445D008B12042340CD0FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setSeconds(int second) {
        dsTaint.addTaint(second);
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.SECOND, second);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.SECOND, second);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.841 -0400", hash_original_method = "9E6A699B7F6421DBF4934C3ED6E82161", hash_generated_method = "CE1B0CC2896111A2EC89F6D9AF5DC5ED")
    @DSModeled(DSC.SAFE)
    public void setTime(long milliseconds) {
        dsTaint.addTaint(milliseconds);
        // ---------- Original Method ----------
        //this.milliseconds = milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.841 -0400", hash_original_method = "6618142CAD2C334ADC07B7799C053111", hash_generated_method = "67B0A452CBA292B5875B207BDC8E9DE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setYear(int year) {
        dsTaint.addTaint(year);
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.YEAR, year + 1900);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.YEAR, year + 1900);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.841 -0400", hash_original_method = "3D40A4C7B327D97106C4C4EC9B9A341F", hash_generated_method = "B62847386D5AF5C5CC64825987BBA460")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String toGMTString() {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        TimeZone gmtZone;
        gmtZone = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(gmtZone);
        GregorianCalendar gc;
        gc = new GregorianCalendar(gmtZone);
        gc.setTimeInMillis(milliseconds);
        String var80FD1B3DD621A9ECFAAF22472D76FBF2_1637814957 = (sdf.format(this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //SimpleDateFormat sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        //TimeZone gmtZone = TimeZone.getTimeZone("GMT");
        //sdf.setTimeZone(gmtZone);
        //GregorianCalendar gc = new GregorianCalendar(gmtZone);
        //gc.setTimeInMillis(milliseconds);
        //return sdf.format(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.842 -0400", hash_original_method = "D0CA357369B8BFBAFFC49AE023576C24", hash_generated_method = "B769EF62C581E0FD21C3D6CCBB9580BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String toLocaleString() {
        String varCD10F257CC4627286D81728D32AE9C08_1331879555 = (DateFormat.getDateTimeInstance().format(this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return DateFormat.getDateTimeInstance().format(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.842 -0400", hash_original_method = "6C5F0B4EE91530ACACAA7ACB374F6D90", hash_generated_method = "200E9332730682D7A6CF67FE2EDAF7CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        LocaleData localeData;
        localeData = LocaleData.get(Locale.US);
        Calendar cal;
        cal = new GregorianCalendar(milliseconds);
        TimeZone tz;
        tz = cal.getTimeZone();
        StringBuilder result;
        result = new StringBuilder();
        result.append(localeData.shortWeekdayNames[cal.get(Calendar.DAY_OF_WEEK)]);
        result.append(' ');
        result.append(localeData.shortMonthNames[cal.get(Calendar.MONTH)]);
        result.append(' ');
        appendTwoDigits(result, cal.get(Calendar.DAY_OF_MONTH));
        result.append(' ');
        appendTwoDigits(result, cal.get(Calendar.HOUR_OF_DAY));
        result.append(':');
        appendTwoDigits(result, cal.get(Calendar.MINUTE));
        result.append(':');
        appendTwoDigits(result, cal.get(Calendar.SECOND));
        result.append(' ');
        result.append(tz.getDisplayName(tz.inDaylightTime(this), TimeZone.SHORT));
        result.append(' ');
        result.append(cal.get(Calendar.YEAR));
        String varEA70154FDA28CC59402440C6317B57EF_1627392851 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void appendTwoDigits(StringBuilder sb, int n) {
        if (n < 10) {
            sb.append('0');
        }
        sb.append(n);
    }

    
        @Deprecated
    public static long UTC(int year, int month, int day, int hour, int minute,
            int second) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.set(1900 + year, month, day, hour, minute, second);
        return cal.getTimeInMillis();
    }

    
        private static int zone(String text) {
        if (text.equals("EST")) {
            return -5;
        }
        if (text.equals("EDT")) {
            return -4;
        }
        if (text.equals("CST")) {
            return -6;
        }
        if (text.equals("CDT")) {
            return -5;
        }
        if (text.equals("MST")) {
            return -7;
        }
        if (text.equals("MDT")) {
            return -6;
        }
        if (text.equals("PST")) {
            return -8;
        }
        if (text.equals("PDT")) {
            return -7;
        }
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.843 -0400", hash_original_method = "A8D1E2059FF037BF4B3478BBC82EA0DD", hash_generated_method = "3DF3E4A65609F9FB9F2ECBC7B36EFB42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeLong(getTime());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeLong(getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.843 -0400", hash_original_method = "59F27179ED4F1C5D53DD2971937048C1", hash_generated_method = "63ABE1500BB356285BBF36FA25485AFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        setTime(stream.readLong());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //setTime(stream.readLong());
    }

    
    private static final long serialVersionUID = 7523967970034938905L;
    private static int creationYear = new Date().getYear();
}

