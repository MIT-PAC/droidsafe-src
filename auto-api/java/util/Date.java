package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final long serialVersionUID = 7523967970034938905L;
    private static int creationYear = new Date().getYear();
    private transient long milliseconds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "117F9B64DCE96B425DE39D6FF0E7C956", hash_generated_method = "3084B38B14C82536717A9F355D0FF3F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date() {
        this(System.currentTimeMillis());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "1DCF8B1AF6198BC90A64E56405CA39AF", hash_generated_method = "F53DD0916478BF07A77BBA9BD47656F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "426C20A19A7753D3CB1FAC13BA7CC9BA", hash_generated_method = "2B5B748BC52C97AA4C57A447F70E3C93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Date(int year, int month, int day, int hour, int minute) {
        dsTaint.addTaint(minute);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        dsTaint.addTaint(hour);
        GregorianCalendar cal;
        cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day, hour, minute);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "139F1B989333E9F68B465E1B19165668", hash_generated_method = "41011801AE29AACDFA08EA71DD7E1DEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Date(int year, int month, int day, int hour, int minute, int second) {
        dsTaint.addTaint(minute);
        dsTaint.addTaint(second);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        dsTaint.addTaint(hour);
        GregorianCalendar cal;
        cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute, second);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day, hour, minute, second);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "F91B8E0C111622A18C17EB4FC5AA472B", hash_generated_method = "F7BBB419B4B7AF6921247A5404C925DE")
    @DSModeled(DSC.SAFE)
    public Date(long milliseconds) {
        dsTaint.addTaint(milliseconds);
        // ---------- Original Method ----------
        //this.milliseconds = milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "2B1036AFFF9E6DD3B4220E3E27A88A34", hash_generated_method = "E770BA055C9886863647D3BB65088457")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Date(String string) {
        dsTaint.addTaint(string);
        milliseconds = parse(string);
        // ---------- Original Method ----------
        //milliseconds = parse(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "A5A1DDC35C23D543E612D23967A596DA", hash_generated_method = "C5358179C723557143A8FD40EBC81D08")
    @DSModeled(DSC.SAFE)
    public boolean after(Date date) {
        dsTaint.addTaint(date.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return milliseconds > date.milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "EB21B83A31DD3DBD1842C230376F433E", hash_generated_method = "D5D0046D7F8447D2CBA6FAD59F2575E0")
    @DSModeled(DSC.SAFE)
    public boolean before(Date date) {
        dsTaint.addTaint(date.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return milliseconds < date.milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "B6A013511AE4BC74A141B1D846BDC7FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_1055853677 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.124 -0400", hash_original_method = "7C9742DC24BA8DF560999557E5DD5087", hash_generated_method = "A8095D35A4020C8E501551CDB3773C36")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "DDDF9262D80550B9DB77ACA0997BD3D6", hash_generated_method = "EB6B0A6D6393E5933F5C6786E21EC54D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object == this) || (object instanceof Date)
                //&& (milliseconds == ((Date) object).milliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "9CDBB71B4B3C803B1AA8EE69EFD3E0ED", hash_generated_method = "997BAA5B45E23A8F5289B114E2EFB2E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getDate() {
        int varC0A714720A6D4DAC31FEF058D8440CD7_1233875961 = (new GregorianCalendar(milliseconds).get(Calendar.DATE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.DATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "A7B9A9C37FFBE4D61CB1113163F9DEB3", hash_generated_method = "D136881B54CECE8BB3E9D0F0F1706DE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getDay() {
        int var3FE3B012F56C52737C59335A2FCB89A8_1569033890 = (new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "E9FAB79941832FB5BB28A56A75132611", hash_generated_method = "777C278A227885FB3D23535DAAD41566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getHours() {
        int var4CFAA335C0802D591C180C590651DB9C_1035496958 = (new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "905F61D3BDD6A004D6695A8C4C0A588F", hash_generated_method = "7E655A9E97B8A764DB7C1412AE462165")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getMinutes() {
        int varB9975022E7FEA5A13782580C91D0E1A8_2067509215 = (new GregorianCalendar(milliseconds).get(Calendar.MINUTE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.MINUTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "62BF86AE189F2A0680B405E29E252A59", hash_generated_method = "3E504D0B1515AFAECA4FE1DA596CB4A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getMonth() {
        int varBFC3339A9B04E6CFC333A192D60231AA_485400060 = (new GregorianCalendar(milliseconds).get(Calendar.MONTH));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.MONTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "21461173A59BCEF943A6FBABC454A724", hash_generated_method = "ED24F5D2A952EA3267C253D0B8F88F3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getSeconds() {
        int varA854ACC5DFBE36B1C5F437CD467A3D27_2069144334 = (new GregorianCalendar(milliseconds).get(Calendar.SECOND));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.SECOND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "6634404A1A66BE1A7302C8A8E427A289", hash_generated_method = "E4F256366403581143FA9BD487C11D08")
    @DSModeled(DSC.SAFE)
    public long getTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "1B1108BADA7A1EB96631D5AF2C5C5E87", hash_generated_method = "E212DDF6691F4BA7D156159551E81015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getTimezoneOffset() {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        int varFFFB7142DA303EFC159034F99D5D2BAC_1247321229 = (-(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //return -(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "C799A54F09693A95BB69288113BB6509", hash_generated_method = "9DF69D566B8F08851B15EF78C95DF679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getYear() {
        int var8A0F590C032321D56632D8913269C9D8_1856126879 = (new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "B128FED5B5AAAF883404F36E34AD6524", hash_generated_method = "9D745894EA43B0A6E366E694CEED57E3")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) (milliseconds >>> 32) ^ (int) milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "000F0F69BA8739697FCA4FE0C538316B", hash_generated_method = "4CAA8F423C86610AB9A4DC527B436221")
    private static int parse(String string, String[] array) {
        for (int i = 0, alength = array.length, slength = string.length(); i < alength; i++) {
            if (string.regionMatches(true, 0, array[i], 0, slength)) {
                return i;
            }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.125 -0400", hash_original_method = "26CEAF17592ACE33BD9CA17B808F7A9D", hash_generated_method = "535233CC874036DDECD6C99B0C4734BE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "CA2D09B2D9B2F9BDCD2321E1B3353343", hash_generated_method = "4DB2ED6558A6BF2FB813E93191E14E6D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "DAB8B4072C80F91D1F54942852D0B029", hash_generated_method = "C410254A4499750E5552E033C5C84826")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "9DC7826FE54BE20D0703E6C2CC9AB71D", hash_generated_method = "0556486D71A6601FFE4686A0B839BB3E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "CBC4CDF52C0128D6B57913B17A16C753", hash_generated_method = "DEB566DCDC0DA8C55DAC5D97DB9032A5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "2FB8CB70BDB70CDBCF22A1F179F9FAD0", hash_generated_method = "669113BCE2723B496DBB9DBAB03BFA42")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "9E6A699B7F6421DBF4934C3ED6E82161", hash_generated_method = "F1C1895A752D427B42DBF8AD4ACCC0E5")
    @DSModeled(DSC.SAFE)
    public void setTime(long milliseconds) {
        dsTaint.addTaint(milliseconds);
        // ---------- Original Method ----------
        //this.milliseconds = milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "6618142CAD2C334ADC07B7799C053111", hash_generated_method = "FD5CD344AAE8578E19C42E4EAF3D993B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "3D40A4C7B327D97106C4C4EC9B9A341F", hash_generated_method = "446BB43B7AE78CEA9A8D3203B1C52DFF")
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
        String var80FD1B3DD621A9ECFAAF22472D76FBF2_1115839277 = (sdf.format(this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //SimpleDateFormat sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        //TimeZone gmtZone = TimeZone.getTimeZone("GMT");
        //sdf.setTimeZone(gmtZone);
        //GregorianCalendar gc = new GregorianCalendar(gmtZone);
        //gc.setTimeInMillis(milliseconds);
        //return sdf.format(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "D0CA357369B8BFBAFFC49AE023576C24", hash_generated_method = "020915D6AED2D2A08C06FAA58F3EC1AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String toLocaleString() {
        String varCD10F257CC4627286D81728D32AE9C08_1195046034 = (DateFormat.getDateTimeInstance().format(this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return DateFormat.getDateTimeInstance().format(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.126 -0400", hash_original_method = "6C5F0B4EE91530ACACAA7ACB374F6D90", hash_generated_method = "406027FFCF42CC5ED7CE67FA89233E3C")
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
        String varEA70154FDA28CC59402440C6317B57EF_806284476 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.127 -0400", hash_original_method = "36BC9397BA7EB541FFE75F65C1FDFC91", hash_generated_method = "AED77C3BCF21E4A96669B0606306F259")
    private static void appendTwoDigits(StringBuilder sb, int n) {
        if (n < 10) {
            sb.append('0');
        }
        sb.append(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.127 -0400", hash_original_method = "70F846D8FDB0E87F2FB9AE4E0EB18175", hash_generated_method = "9B05589635D862B5D833B705C4EEAAB3")
    @Deprecated
    public static long UTC(int year, int month, int day, int hour, int minute,
            int second) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.set(1900 + year, month, day, hour, minute, second);
        return cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.127 -0400", hash_original_method = "AD2AD2E6D9D4EAA290D91166777B213B", hash_generated_method = "86E9BCCDB2DF1EDB770370F1C0989B3E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.127 -0400", hash_original_method = "A8D1E2059FF037BF4B3478BBC82EA0DD", hash_generated_method = "22A1E21C8BE9CACCE173043E6D6319DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeLong(getTime());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeLong(getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.127 -0400", hash_original_method = "59F27179ED4F1C5D53DD2971937048C1", hash_generated_method = "F5958D093D5E56755ED0B9A12CCBA1A1")
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

    
}


