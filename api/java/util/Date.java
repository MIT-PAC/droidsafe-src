package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

import libcore.icu.LocaleData;

public class Date implements Serializable, Cloneable, Comparable<Date> {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.963 -0500", hash_original_method = "000F0F69BA8739697FCA4FE0C538316B", hash_generated_method = "4CAA8F423C86610AB9A4DC527B436221")
    
private static int parse(String string, String[] array) {
        for (int i = 0, alength = array.length, slength = string.length(); i < alength; i++) {
            if (string.regionMatches(true, 0, array[i], 0, slength)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the millisecond value of the date and time parsed from the
     * specified {@code String}. Many date/time formats are recognized, including IETF
     * standard syntax, i.e. Tue, 22 Jun 1999 12:16:00 GMT-0500
     *
     * @param string
     *            the String to parse.
     * @return the millisecond value parsed from the String.
     *
     * @deprecated use {@link DateFormat}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.970 -0500", hash_original_method = "26CEAF17592ACE33BD9CA17B808F7A9D", hash_generated_method = "BCAB08E12BDF9DF7505895BDAEA04BE9")
    
@Deprecated
    public static long parse(String string) {

        if (DroidSafeAndroidRuntime.control)
           throw new IllegalArgumentException();
        
        return string.getTaintInt();
       /* 
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
        */
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.999 -0500", hash_original_method = "36BC9397BA7EB541FFE75F65C1FDFC91", hash_generated_method = "AED77C3BCF21E4A96669B0606306F259")
    
private static void appendTwoDigits(StringBuilder sb, int n) {
        if (n < 10) {
            sb.append('0');
        }
        sb.append(n);
    }

    /**
     * Returns the millisecond value of the specified date and time in GMT.
     *
     * @param year
     *            the year, 0 is 1900.
     * @param month
     *            the month, 0 - 11.
     * @param day
     *            the day of the month, 1 - 31.
     * @param hour
     *            the hour of day, 0 - 23.
     * @param minute
     *            the minute of the hour, 0 - 59.
     * @param second
     *            the second of the minute, 0 - 59.
     * @return the date and time in GMT in milliseconds.
     *
     * @deprecated use: <code>
     *  Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
     *  cal.set(year + 1900, month, day, hour, minute, second);
     *  cal.getTime().getTime();</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.002 -0500", hash_original_method = "70F846D8FDB0E87F2FB9AE4E0EB18175", hash_generated_method = "9B05589635D862B5D833B705C4EEAAB3")
    
@Deprecated
    public static long UTC(int year, int month, int day, int hour, int minute,
            int second) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.set(1900 + year, month, day, hour, minute, second);
        return cal.getTimeInMillis();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.005 -0500", hash_original_method = "AD2AD2E6D9D4EAA290D91166777B213B", hash_generated_method = "86E9BCCDB2DF1EDB770370F1C0989B3E")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.901 -0500", hash_original_field = "F854CC3110F1DC417C8120C26CD53E56", hash_generated_field = "CD3049977F52AE47136F3048623BF2B1")

    private static final long serialVersionUID = 7523967970034938905L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.904 -0500", hash_original_field = "E9D2CE86AF0A20FBF638F53C3AFC3F0D", hash_generated_field = "86DAAEAAB92B64CADF16DC4975B9F626")

    private static int creationYear = new Date().getYear();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.906 -0500", hash_original_field = "12E73FABB6840CD953EDD926E801F037", hash_generated_field = "6BC5295E2736F8077860853450F996C9")

    private transient long milliseconds;

    /**
     * Initializes this {@code Date} instance to the current time.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.909 -0500", hash_original_method = "117F9B64DCE96B425DE39D6FF0E7C956", hash_generated_method = "474DEEC95109DC78EDD8476E9FBAEB33")
    
public Date() {
        //this(System.currentTimeMillis());
        this(0);
    }

    /**
     * Constructs a new {@code Date} initialized to midnight in the default {@code TimeZone} on
     * the specified date.
     *
     * @param year
     *            the year, 0 is 1900.
     * @param month
     *            the month, 0 - 11.
     * @param day
     *            the day of the month, 1 - 31.
     *
     * @deprecated use
     *             {@link GregorianCalendar#GregorianCalendar(int, int, int)}
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.911 -0500", hash_original_method = "1DCF8B1AF6198BC90A64E56405CA39AF", hash_generated_method = "B9BC8A445D049E77665A0D01DAEEA279")
    
@Deprecated
    public Date(int year, int month, int day) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Constructs a new {@code Date} initialized to the specified date and time in the
     * default {@code TimeZone}.
     *
     * @param year
     *            the year, 0 is 1900.
     * @param month
     *            the month, 0 - 11.
     * @param day
     *            the day of the month, 1 - 31.
     * @param hour
     *            the hour of day, 0 - 23.
     * @param minute
     *            the minute of the hour, 0 - 59.
     *
     * @deprecated use
     *             {@link GregorianCalendar#GregorianCalendar(int, int, int, int, int)}
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.915 -0500", hash_original_method = "426C20A19A7753D3CB1FAC13BA7CC9BA", hash_generated_method = "A3033D0F5C592FA204A8EA9084279716")
    
@Deprecated
    public Date(int year, int month, int day, int hour, int minute) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Constructs a new {@code Date} initialized to the specified date and time in the
     * default {@code TimeZone}.
     *
     * @param year
     *            the year, 0 is 1900.
     * @param month
     *            the month, 0 - 11.
     * @param day
     *            the day of the month, 1 - 31.
     * @param hour
     *            the hour of day, 0 - 23.
     * @param minute
     *            the minute of the hour, 0 - 59.
     * @param second
     *            the second of the minute, 0 - 59.
     *
     * @deprecated use
     *             {@link GregorianCalendar#GregorianCalendar(int, int, int, int, int, int)}
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.917 -0500", hash_original_method = "139F1B989333E9F68B465E1B19165668", hash_generated_method = "99A2818CBC360D73AB84C354E29C0060")
    
@Deprecated
    public Date(int year, int month, int day, int hour, int minute, int second) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute, second);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Initializes this {@code Date} instance using the specified millisecond value. The
     * value is the number of milliseconds since Jan. 1, 1970 GMT.
     *
     * @param milliseconds
     *            the number of milliseconds since Jan. 1, 1970 GMT.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.921 -0500", hash_original_method = "F91B8E0C111622A18C17EB4FC5AA472B", hash_generated_method = "FD8B232B005EE7105E8510DB09E5C300")
public Date(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    /**
     * Constructs a new {@code Date} initialized to the date and time parsed from the
     * specified String.
     *
     * @param string
     *            the String to parse.
     *
     * @deprecated use {@link DateFormat}
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.923 -0500", hash_original_method = "2B1036AFFF9E6DD3B4220E3E27A88A34", hash_generated_method = "196119DC940251BFA737BD86B7A55ACB")
    
@Deprecated
    public Date(String string) {
        milliseconds = parse(string);
    }

    /**
     * Returns if this {@code Date} is after the specified Date.
     *
     * @param date
     *            a Date instance to compare.
     * @return {@code true} if this {@code Date} is after the specified {@code Date},
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.926 -0500", hash_original_method = "A5A1DDC35C23D543E612D23967A596DA", hash_generated_method = "87A78078C3DF1A7ADCBEEDE885C5F4B2")
    
public boolean after(Date date) {
        return milliseconds > date.milliseconds;
    }

    /**
     * Returns if this {@code Date} is before the specified Date.
     *
     * @param date
     *            a {@code Date} instance to compare.
     * @return {@code true} if this {@code Date} is before the specified {@code Date},
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.928 -0500", hash_original_method = "EB21B83A31DD3DBD1842C230376F433E", hash_generated_method = "E0137EB8EDE8D78F6CC82CE799F2E2C2")
    
public boolean before(Date date) {
        return milliseconds < date.milliseconds;
    }

    /**
     * Returns a new {@code Date} with the same millisecond value as this {@code Date}.
     *
     * @return a shallow copy of this {@code Date}.
     *
     * @see java.lang.Cloneable
     */
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.931 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "88F588A1F8F1E65DC62D9CB72E24BF48")
    
@Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Compare the receiver to the specified {@code Date} to determine the relative
     * ordering.
     *
     * @param date
     *            a {@code Date} to compare against.
     * @return an {@code int < 0} if this {@code Date} is less than the specified {@code Date}, {@code 0} if
     *         they are equal, and an {@code int > 0} if this {@code Date} is greater.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.933 -0500", hash_original_method = "7C9742DC24BA8DF560999557E5DD5087", hash_generated_method = "F59E4670EF4BD5DDEFA3B1166341ED83")
    
public int compareTo(Date date) {
        if (milliseconds < date.milliseconds) {
            return -1;
        }
        if (milliseconds == date.milliseconds) {
            return 0;
        }
        return 1;
    }

    /**
     * Compares the specified object to this {@code Date} and returns if they are equal.
     * To be equal, the object must be an instance of {@code Date} and have the same millisecond
     * value.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this {@code Date}, {@code false}
     *         otherwise.
     *
     * @see #hashCode
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.936 -0500", hash_original_method = "DDDF9262D80550B9DB77ACA0997BD3D6", hash_generated_method = "BF420294DB7A0F905CBE21AC20CBA48F")
    
@Override
    public boolean equals(Object object) {
        return (object == this) || (object instanceof Date)
                && (milliseconds == ((Date) object).milliseconds);
    }

    /**
     * Returns the gregorian calendar day of the month for this {@code Date} object.
     *
     * @return the day of the month.
     *
     * @deprecated use {@code Calendar.get(Calendar.DATE)}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.939 -0500", hash_original_method = "9CDBB71B4B3C803B1AA8EE69EFD3E0ED", hash_generated_method = "935712F01B21C8301B5FB1FE1C7B864C")
    
@Deprecated
    public int getDate() {
        return new GregorianCalendar(milliseconds).get(Calendar.DATE);
    }

    /**
     * Returns the gregorian calendar day of the week for this {@code Date} object.
     *
     * @return the day of the week.
     *
     * @deprecated use {@code Calendar.get(Calendar.DAY_OF_WEEK)}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.941 -0500", hash_original_method = "A7B9A9C37FFBE4D61CB1113163F9DEB3", hash_generated_method = "F6601B512E3AFB999150BC732806EE09")
    
@Deprecated
    public int getDay() {
        return new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * Returns the gregorian calendar hour of the day for this {@code Date} object.
     *
     * @return the hour of the day.
     *
     * @deprecated use {@code Calendar.get(Calendar.HOUR_OF_DAY)}
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.TRIGGER)
    @DSSource({DSSourceKind.DATE_TIME})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.943 -0500", hash_original_method = "E9FAB79941832FB5BB28A56A75132611", hash_generated_method = "C7916E717A7AB29533C2BB1C1C15BB2D")
    
@Deprecated
    public int getHours() {
        return new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Returns the gregorian calendar minute of the hour for this {@code Date} object.
     *
     * @return the minutes.
     *
     * @deprecated use {@code Calendar.get(Calendar.MINUTE)}
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.TRIGGER)
    @DSSource({DSSourceKind.DATE_TIME})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.946 -0500", hash_original_method = "905F61D3BDD6A004D6695A8C4C0A588F", hash_generated_method = "EF947D8DA80AAE9230D7A14A9CE6DA79")
    
@Deprecated
    public int getMinutes() {
        return new GregorianCalendar(milliseconds).get(Calendar.MINUTE);
    }

    /**
     * Returns the gregorian calendar month for this {@code Date} object.
     *
     * @return the month.
     *
     * @deprecated use {@code Calendar.get(Calendar.MONTH)}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.948 -0500", hash_original_method = "62BF86AE189F2A0680B405E29E252A59", hash_generated_method = "2D9B630B310E5C85500AB72FB2439BBC")
    
@Deprecated
    public int getMonth() {
        return new GregorianCalendar(milliseconds).get(Calendar.MONTH);
    }

    /**
     * Returns the gregorian calendar second of the minute for this {@code Date} object.
     *
     * @return the seconds.
     *
     * @deprecated use {@code Calendar.get(Calendar.SECOND)}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.950 -0500", hash_original_method = "21461173A59BCEF943A6FBABC454A724", hash_generated_method = "173D562C297A6F7392DE10703F167650")
    
@Deprecated
    public int getSeconds() {
        return new GregorianCalendar(milliseconds).get(Calendar.SECOND);
    }

    /**
     * Returns this {@code Date} as a millisecond value. The value is the number of
     * milliseconds since Jan. 1, 1970, midnight GMT.
     *
     * @return the number of milliseconds since Jan. 1, 1970, midnight GMT.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.TRIGGER)
    @DSSource({DSSourceKind.DATE_TIME})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.953 -0500", hash_original_method = "6634404A1A66BE1A7302C8A8E427A289", hash_generated_method = "7F40D28ACFD573A56785C7EF4B951249")
    
public long getTime() {
        return milliseconds;
    }

    /**
     * Returns the timezone offset in minutes of the default {@code TimeZone}.
     *
     * @return the timezone offset in minutes of the default {@code TimeZone}.
     *
     * @deprecated use
     *             {@code (Calendar.get(Calendar.ZONE_OFFSET) + Calendar.get(Calendar.DST_OFFSET)) / 60000}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.956 -0500", hash_original_method = "1B1108BADA7A1EB96631D5AF2C5C5E87", hash_generated_method = "F130D9FEDBA95D152E755077CD51E862")
    
@Deprecated
    public int getTimezoneOffset() {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        return -(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000;
    }

    /**
     * Returns the gregorian calendar year since 1900 for this {@code Date} object.
     *
     * @return the year - 1900.
     *
     * @deprecated use {@code Calendar.get(Calendar.YEAR) - 1900}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.959 -0500", hash_original_method = "C799A54F09693A95BB69288113BB6509", hash_generated_method = "601F96662502A243831F5D4144DFCA44")
    
@Deprecated
    public int getYear() {
        return new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900;
    }

    /**
     * Returns an integer hash code for the receiver. Objects which are equal
     * return the same value for this method.
     *
     * @return this {@code Date}'s hash.
     *
     * @see #equals
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.961 -0500", hash_original_method = "B128FED5B5AAAF883404F36E34AD6524", hash_generated_method = "AE36E1D47D9FEEEC990D6DD66BA0B71B")
    
@Override
    public int hashCode() {
        return (int) (milliseconds >>> 32) ^ (int) milliseconds;
    }

    /**
     * Sets the gregorian calendar day of the month for this {@code Date} object.
     *
     * @param day
     *            the day of the month.
     *
     * @deprecated use {@code Calendar.set(Calendar.DATE, day)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.972 -0500", hash_original_method = "CA2D09B2D9B2F9BDCD2321E1B3353343", hash_generated_method = "58E37E4CD8BC78802E2E5556022896DD")
    
@Deprecated
    public void setDate(int day) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.DATE, day);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Sets the gregorian calendar hour of the day for this {@code Date} object.
     *
     * @param hour
     *            the hour of the day.
     *
     * @deprecated use {@code Calendar.set(Calendar.HOUR_OF_DAY, hour)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.975 -0500", hash_original_method = "DAB8B4072C80F91D1F54942852D0B029", hash_generated_method = "A30237EE5E24E594D496E0990A18671D")
    
@Deprecated
    public void setHours(int hour) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Sets the gregorian calendar minute of the hour for this {@code Date} object.
     *
     * @param minute
     *            the minutes.
     *
     * @deprecated use {@code Calendar.set(Calendar.MINUTE, minute)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.978 -0500", hash_original_method = "9DC7826FE54BE20D0703E6C2CC9AB71D", hash_generated_method = "054AC6CBA487676DDBCA8DA2A89B1C62")
    
@Deprecated
    public void setMinutes(int minute) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MINUTE, minute);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Sets the gregorian calendar month for this {@code Date} object.
     *
     * @param month
     *            the month.
     *
     * @deprecated use {@code Calendar.set(Calendar.MONTH, month)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.980 -0500", hash_original_method = "CBC4CDF52C0128D6B57913B17A16C753", hash_generated_method = "066957CB9807A22F9CD08EF1FDF7533B")
    
@Deprecated
    public void setMonth(int month) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MONTH, month);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Sets the gregorian calendar second of the minute for this {@code Date} object.
     *
     * @param second
     *            the seconds.
     *
     * @deprecated use {@code Calendar.set(Calendar.SECOND, second)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.983 -0500", hash_original_method = "2FB8CB70BDB70CDBCF22A1F179F9FAD0", hash_generated_method = "8A30E26DA5FB65CBDE7224776A66E58B")
    
@Deprecated
    public void setSeconds(int second) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.SECOND, second);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Sets this {@code Date} to the specified millisecond value. The value is the
     * number of milliseconds since Jan. 1, 1970 GMT.
     *
     * @param milliseconds
     *            the number of milliseconds since Jan. 1, 1970 GMT.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.985 -0500", hash_original_method = "9E6A699B7F6421DBF4934C3ED6E82161", hash_generated_method = "20C33F5B9B2306A7E151C3A4E9491FC6")
    
public void setTime(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    /**
     * Sets the gregorian calendar year since 1900 for this {@code Date} object.
     *
     * @param year
     *            the year since 1900.
     *
     * @deprecated use {@code Calendar.set(Calendar.YEAR, year + 1900)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.987 -0500", hash_original_method = "6618142CAD2C334ADC07B7799C053111", hash_generated_method = "5E208FC292A30DB77B1DD9A3E4CA2AE1")
    
@Deprecated
    public void setYear(int year) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.YEAR, year + 1900);
        milliseconds = cal.getTimeInMillis();
    }

    /**
     * Returns the string representation of this {@code Date} in GMT in the format
     * {@code "22 Jun 1999 13:02:00 GMT"}.
     *
     * @deprecated use {@link DateFormat}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.990 -0500", hash_original_method = "3D40A4C7B327D97106C4C4EC9B9A341F", hash_generated_method = "5A235153BE1F118BAF7377B03EDB105F")
    
@Deprecated
    public String toGMTString() {
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        TimeZone gmtZone = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(gmtZone);
        GregorianCalendar gc = new GregorianCalendar(gmtZone);
        gc.setTimeInMillis(milliseconds);
        return sdf.format(this);
    }

    /**
     * Returns the string representation of this {@code Date} for the default {@code Locale}.
     *
     * @deprecated use {@link DateFormat}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.993 -0500", hash_original_method = "D0CA357369B8BFBAFFC49AE023576C24", hash_generated_method = "24E015ABA16565E94642407506507F3B")
    
@Deprecated
    public String toLocaleString() {
        return DateFormat.getDateTimeInstance().format(this);
    }

    /**
     * Returns a string representation of this {@code Date}.
     * The formatting is equivalent to using a {@code SimpleDateFormat} with
     * the format string "EEE MMM dd HH:mm:ss zzz yyyy", which looks something
     * like "Tue Jun 22 13:07:00 PDT 1999". The current default time zone and
     * locale are used. If you need control over the time zone or locale,
     * use {@code SimpleDateFormat} instead.
     */
    @DSSource({DSSourceKind.DATE_TIME})
    @DSComment("From safe class list")
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:30.996 -0500", hash_original_method = "6C5F0B4EE91530ACACAA7ACB374F6D90", hash_generated_method = "F709BAEEF90A917275EA136C85EF5182")
    
@Override
    public String toString() {
        // TODO: equivalent to the following one-liner, though that's slower on stingray
        // at 476us versus 69us...
        //   return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(d);
        LocaleData localeData = LocaleData.get(Locale.US);
        Calendar cal = new GregorianCalendar(milliseconds);
        TimeZone tz = cal.getTimeZone();
        StringBuilder result = new StringBuilder();
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
        return result.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.007 -0500", hash_original_method = "A8D1E2059FF037BF4B3478BBC82EA0DD", hash_generated_method = "9B30E80D376D627A7DAFD1F135D31540")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeLong(getTime());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.009 -0500", hash_original_method = "59F27179ED4F1C5D53DD2971937048C1", hash_generated_method = "0DECBD40ABFABEC36D81C02378E64A5F")
    
private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        setTime(stream.readLong());
    }
}

