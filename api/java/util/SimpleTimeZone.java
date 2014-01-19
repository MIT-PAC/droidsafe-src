package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

public class SimpleTimeZone extends TimeZone {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.939 -0500", hash_original_field = "66B1EAC7CE31864A5D82470EA5A5D79E", hash_generated_field = "1CF196C479DD1F282A55928D9D41E39D")

    private static final long serialVersionUID = -403250971215465050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.593 -0400", hash_original_field = "A16CDC7A98B9FE1707BCB38A5FD0B490", hash_generated_field = "3037D344D26C320D59D8AAFE3A431E48")

    private static final int DOM_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.593 -0400", hash_original_field = "B27995F1E6069CEF7A0FF35116D534B6", hash_generated_field = "2C93A32BCFE1ECF0127BDA095E88DC8A")

    private static final int DOW_IN_MONTH_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.593 -0400", hash_original_field = "04A0BC6AA9754653D5751ED4E151C000", hash_generated_field = "F1DC93233ED325B0B7BD9D456CA553CF")

    private static final int DOW_GE_DOM_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.593 -0400", hash_original_field = "31ABAC6414B935DA144D0D6AEB5168DC", hash_generated_field = "E441A9DEBF4A92E218DA7693E0A9869F")

    private static final int DOW_LE_DOM_MODE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.955 -0500", hash_original_field = "0E0A14D3A016165FA5B575D2F7B35C7A", hash_generated_field = "61DB737AECFE59272E81B27E825907AA")

    public static final int UTC_TIME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.958 -0500", hash_original_field = "A97A2F57206B020391BB2C7F6E0FF5AB", hash_generated_field = "DC2E634827EAB82F13E8E712A81C7981")

    public static final int STANDARD_TIME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.961 -0500", hash_original_field = "ACD40ABCCAEAD6B8DD9E4BC3C4D35B61", hash_generated_field = "847DF430EF9ED807826F046224B40B8D")

    public static final int WALL_TIME = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.055 -0500", hash_original_field = "44E97694732CF460E3F6B74D80B9EB36", hash_generated_field = "2894821EF324A43745E14FE4AD86DCFF")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.942 -0500", hash_original_field = "87D5609A01CDCA385278402CB3082C09", hash_generated_field = "02FD65C4AE6246DF84FF429CBB8EEA00")

    private int rawOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "78B902B91A7DB6AE4440D916F8C1C0E1", hash_generated_field = "D96A347FAB9C04C4C794424684EFB084")

    private int startYear;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "E8122CC997AB2C59FCE8C314426F4F68", hash_generated_field = "940B798A01BC8ABB2CE78C90F3BCFFD3")

    private int startMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "F9C17BD1FAD2884297D4CC252E94B554", hash_generated_field = "C94A63CC5ED4704D0C2CA8DCAD9FD876")

    private int startDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "4C26E00B6B24E29E71510CA729F0973C", hash_generated_field = "43E2727F657E2CD398223A6F1FA2BD3F")

    private int startDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "5B2A579F62087D17D79CE59F3DE5F6D1", hash_generated_field = "C0B40C0BA543A9EB6854A39344BC26D4")

    private int startTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "211595262C719DC6A6D21AE48FD0734D", hash_generated_field = "FF7508574F08AAF5CB8B3A9500D95481")

    private int endMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "993848D0DEA30349854C28B46462E893", hash_generated_field = "71D6BC1B0CA52DA20C0737FDC0586303")

    private int endDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "0446C45DF1D67C67D576C73B791C3225", hash_generated_field = "2FB4FAECAEDA119C4460DBD2706193A4")

    private int endDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "C5B5790B8B74A68D0CDE09C8F1080FC5", hash_generated_field = "D0D7BC1269A7BA712BB9A8CDDA9E82F8")

    private int endTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "6A3EC46E8E89018DABF9BC20BD89E0EF", hash_generated_field = "0E9AA7511822CAC3FB3D4A8874DCE60D")

    private int startMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.568 -0400", hash_original_field = "38C063B6C1F84E1D761E186944C0FD3D", hash_generated_field = "5C6BDD12C029B639E093E1584B7C3AD2")

    private int endMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.963 -0500", hash_original_field = "17226682B482887BEDFA35680B73611D", hash_generated_field = "6E9DFCBD335172F280DBFDE8886FC716")

    private boolean useDaylight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.966 -0500", hash_original_field = "2F9AE701EB19A988F08B754E3473BD90", hash_generated_field = "5B4639FCCF517E827D012B95CA754FED")

    private int dstSavings = 3600000;

    /**
     * Constructs a {@code SimpleTimeZone} with the given base time zone offset from GMT
     * and time zone ID. Timezone IDs can be obtained from
     * {@code TimeZone.getAvailableIDs}. Normally you should use {@code TimeZone.getDefault} to
     * construct a {@code TimeZone}.
     *
     * @param offset
     *            the given base time zone offset to GMT.
     * @param name
     *            the time zone ID which is obtained from
     *            {@code TimeZone.getAvailableIDs}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.969 -0500", hash_original_method = "A73AE5A515785364E3BAF8A0CE898B7F", hash_generated_method = "249D8005DA2796BB58F156E53C6ADD37")
    
public SimpleTimeZone(int offset, final String name) {
        setID(name);
        rawOffset = offset;
    }

    /**
     * Constructs a {@code SimpleTimeZone} with the given base time zone offset from GMT,
     * time zone ID, and times to start and end the daylight savings time. Timezone IDs can
     * be obtained from {@code TimeZone.getAvailableIDs}. Normally you should use
     * {@code TimeZone.getDefault} to create a {@code TimeZone}. For a time zone that does not
     * use daylight saving time, do not use this constructor; instead you should
     * use {@code SimpleTimeZone(rawOffset, ID)}.
     * <p>
     * By default, this constructor specifies day-of-week-in-month rules. That
     * is, if the {@code startDay} is 1, and the {@code startDayOfWeek} is {@code SUNDAY}, then this
     * indicates the first Sunday in the {@code startMonth}. A {@code startDay} of -1 likewise
     * indicates the last Sunday. However, by using negative or zero values for
     * certain parameters, other types of rules can be specified.
     * <p>
     * Day of month: To specify an exact day of the month, such as March 1, set
     * {@code startDayOfWeek} to zero.
     * <p>
     * Day of week after day of month: To specify the first day of the week
     * occurring on or after an exact day of the month, make the day of the week
     * negative. For example, if {@code startDay} is 5 and {@code startDayOfWeek} is {@code -MONDAY},
     * this indicates the first Monday on or after the 5th day of the
     * {@code startMonth}.
     * <p>
     * Day of week before day of month: To specify the last day of the week
     * occurring on or before an exact day of the month, make the day of the
     * week and the day of the month negative. For example, if {@code startDay} is {@code -21}
     * and {@code startDayOfWeek} is {@code -WEDNESDAY}, this indicates the last Wednesday on or
     * before the 21st of the {@code startMonth}.
     * <p>
     * The above examples refer to the {@code startMonth}, {@code startDay}, and {@code startDayOfWeek};
     * the same applies for the {@code endMonth}, {@code endDay}, and {@code endDayOfWeek}.
     * <p>
     * The daylight savings time difference is set to the default value: one hour.
     *
     * @param offset
     *            the given base time zone offset to GMT.
     * @param name
     *            the time zone ID which is obtained from
     *            {@code TimeZone.getAvailableIDs}.
     * @param startMonth
     *            the daylight savings starting month. The month indexing is 0-based. eg, 0
     *            for January.
     * @param startDay
     *            the daylight savings starting day-of-week-in-month. Please see
     *            the member description for an example.
     * @param startDayOfWeek
     *            the daylight savings starting day-of-week. Please see the
     *            member description for an example.
     * @param startTime
     *            the daylight savings starting time in local wall time, which
     *            is standard time in this case. Please see the member
     *            description for an example.
     * @param endMonth
     *            the daylight savings ending month. The month indexing is 0-based. eg, 0 for
     *            January.
     * @param endDay
     *            the daylight savings ending day-of-week-in-month. Please see
     *            the member description for an example.
     * @param endDayOfWeek
     *            the daylight savings ending day-of-week. Please see the member
     *            description for an example.
     * @param endTime
     *            the daylight savings ending time in local wall time, which is
     *            daylight time in this case. Please see the member description
     *            for an example.
     * @throws IllegalArgumentException
     *             if the month, day, dayOfWeek, or time parameters are out of
     *             range for the start or end rule.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.971 -0500", hash_original_method = "8CE6DF24772062229638C2D4C95CF5BA", hash_generated_method = "CBB162538BAD51AFD3350BB36C159888")
    
public SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime) {
        this(offset, name, startMonth, startDay, startDayOfWeek, startTime,
                endMonth, endDay, endDayOfWeek, endTime, 3600000);
    }

    /**
     * Constructs a {@code SimpleTimeZone} with the given base time zone offset from GMT,
     * time zone ID, times to start and end the daylight savings time, and
     * the daylight savings time difference in milliseconds.
     *
     * @param offset
     *            the given base time zone offset to GMT.
     * @param name
     *            the time zone ID which is obtained from
     *            {@code TimeZone.getAvailableIDs}.
     * @param startMonth
     *            the daylight savings starting month. Month is 0-based. eg, 0
     *            for January.
     * @param startDay
     *            the daylight savings starting day-of-week-in-month. Please see
     *            the description of {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)} for an example.
     * @param startDayOfWeek
     *            the daylight savings starting day-of-week. Please see the
     *            description of {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)} for an example.
     * @param startTime
     *            The daylight savings starting time in local wall time, which
     *            is standard time in this case. Please see the description of
     *            {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)} for an example.
     * @param endMonth
     *            the daylight savings ending month. Month is 0-based. eg, 0 for
     *            January.
     * @param endDay
     *            the daylight savings ending day-of-week-in-month. Please see
     *            the description of {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)} for an example.
     * @param endDayOfWeek
     *            the daylight savings ending day-of-week. Please see the description of
     *            {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)} for an example.
     * @param endTime
     *            the daylight savings ending time in local wall time, which is
     *            daylight time in this case. Please see the description of {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)}
     *            for an example.
     * @param daylightSavings
     *            the daylight savings time difference in milliseconds.
     * @throws IllegalArgumentException
     *                if the month, day, dayOfWeek, or time parameters are out of
     *                range for the start or end rule.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.975 -0500", hash_original_method = "8623FC95180B9E56345F7D06857248B1", hash_generated_method = "805B155C9B08C01D378B769E8D1A5CD6")
    
public SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int endMonth,
            int endDay, int endDayOfWeek, int endTime, int daylightSavings) {
        this(offset, name);
        if (daylightSavings <= 0) {
            throw new IllegalArgumentException("Invalid daylightSavings: " + daylightSavings);
        }
        dstSavings = daylightSavings;
        // TODO: do we need to set useDaylight is dstSavings != 0?

        setStartRule(startMonth, startDay, startDayOfWeek, startTime);
        setEndRule(endMonth, endDay, endDayOfWeek, endTime);
    }

    /**
     * Construct a {@code SimpleTimeZone} with the given base time zone offset from GMT,
     * time zone ID, times to start and end the daylight savings time including a
     * mode specifier, the daylight savings time difference in milliseconds.
     * The mode specifies either {@link #WALL_TIME}, {@link #STANDARD_TIME}, or
     * {@link #UTC_TIME}.
     *
     * @param offset
     *            the given base time zone offset to GMT.
     * @param name
     *            the time zone ID which is obtained from
     *            {@code TimeZone.getAvailableIDs}.
     * @param startMonth
     *            the daylight savings starting month. The month indexing is 0-based. eg, 0
     *            for January.
     * @param startDay
     *            the daylight savings starting day-of-week-in-month. Please see
     *            the description of {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)} for an example.
     * @param startDayOfWeek
     *            the daylight savings starting day-of-week. Please see the
     *            description of {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)} for an example.
     * @param startTime
     *            the time of day in milliseconds on which daylight savings
     *            time starts, based on the {@code startTimeMode}.
     * @param startTimeMode
     *            the mode (UTC, standard, or wall time) of the start time
     *            value.
     * @param endDay
     *            the day of the week on which daylight savings time ends.
     * @param endMonth
     *            the daylight savings ending month. The month indexing is 0-based. eg, 0 for
     *            January.
     * @param endDayOfWeek
     *            the daylight savings ending day-of-week. Please see the description of
     *            {@link #SimpleTimeZone(int, String, int, int, int, int, int, int, int, int)} for an example.
     * @param endTime
     *            the time of day in milliseconds on which daylight savings
     *            time ends, based on the {@code endTimeMode}.
     * @param endTimeMode
     *            the mode (UTC, standard, or wall time) of the end time value.
     * @param daylightSavings
     *            the daylight savings time difference in milliseconds.
     * @throws IllegalArgumentException
     *             if the month, day, dayOfWeek, or time parameters are out of
     *             range for the start or end rule.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.979 -0500", hash_original_method = "79A83CB077FC893587B86C22BBA871F3", hash_generated_method = "9E3C308C1B1CDDE4184B6C105D3BD3B9")
    
public SimpleTimeZone(int offset, String name, int startMonth,
            int startDay, int startDayOfWeek, int startTime, int startTimeMode,
            int endMonth, int endDay, int endDayOfWeek, int endTime,
            int endTimeMode, int daylightSavings) {

        this(offset, name, startMonth, startDay, startDayOfWeek, startTime,
                endMonth, endDay, endDayOfWeek, endTime, daylightSavings);
        startMode = startTimeMode;
        endMode = endTimeMode;
    }

    /**
     * Returns a new {@code SimpleTimeZone} with the same ID, {@code rawOffset} and daylight
     * savings time rules as this SimpleTimeZone.
     *
     * @return a shallow copy of this {@code SimpleTimeZone}.
     * @see java.lang.Cloneable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.982 -0500", hash_original_method = "826DFB88845863F51C3C619017A5C62F", hash_generated_method = "3891F8CF82A703B740E4B977D8713D1C")
    
@Override
    public Object clone() {
        SimpleTimeZone zone = (SimpleTimeZone) super.clone();
        return zone;
    }

    /**
     * Compares the specified object to this {@code SimpleTimeZone} and returns whether they
     * are equal. The object must be an instance of {@code SimpleTimeZone} and have the
     * same internal data.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this
     *         {@code SimpleTimeZone}, {@code false} otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.985 -0500", hash_original_method = "6B0E934BFCA438C9EF8D8ACC7F42CB32", hash_generated_method = "4B1A52DCD50B84BCD56926B029AFE427")
    
@Override
    public boolean equals(Object object) {
        if (!(object instanceof SimpleTimeZone)) {
            return false;
        }
        SimpleTimeZone tz = (SimpleTimeZone) object;
        return getID().equals(tz.getID())
                && rawOffset == tz.rawOffset
                && useDaylight == tz.useDaylight
                && (!useDaylight || (startYear == tz.startYear
                        && startMonth == tz.startMonth
                        && startDay == tz.startDay && startMode == tz.startMode
                        && startDayOfWeek == tz.startDayOfWeek
                        && startTime == tz.startTime && endMonth == tz.endMonth
                        && endDay == tz.endDay
                        && endDayOfWeek == tz.endDayOfWeek
                        && endTime == tz.endTime && endMode == tz.endMode && dstSavings == tz.dstSavings));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.988 -0500", hash_original_method = "80F5C5F4A535ECB3386672D31D5CF9AA", hash_generated_method = "B689829CB1C604AC52A715A39828C8A4")
    
@Override
    public int getDSTSavings() {
        if (!useDaylight) {
            return 0;
        }
        return dstSavings;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.993 -0500", hash_original_method = "8DB3C09D8D79030897991A8AF2C3603A", hash_generated_method = "C6F92D3B6C143A636AE0517E2D0B92C8")
    
@Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int time) {
        if (era != GregorianCalendar.BC && era != GregorianCalendar.AD) {
            throw new IllegalArgumentException("Invalid era: " + era);
        }
        checkRange(month, dayOfWeek, time);
        if (month != Calendar.FEBRUARY || day != 29 || !isLeapYear(year)) {
            checkDay(month, day);
        }

        if (!useDaylightTime() || era != GregorianCalendar.AD || year < startYear) {
            return rawOffset;
        }
        if (endMonth < startMonth) {
            if (month > endMonth && month < startMonth) {
                return rawOffset;
            }
        } else {
            if (month < startMonth || month > endMonth) {
                return rawOffset;
            }
        }

        int ruleDay = 0, daysInMonth, firstDayOfMonth = mod7(dayOfWeek - day);
        if (month == startMonth) {
            switch (startMode) {
                case DOM_MODE:
                    ruleDay = startDay;
                    break;
                case DOW_IN_MONTH_MODE:
                    if (startDay >= 0) {
                        ruleDay = mod7(startDayOfWeek - firstDayOfMonth) + 1
                                + (startDay - 1) * 7;
                    } else {
                        daysInMonth = GregorianCalendar.DaysInMonth[startMonth];
                        if (startMonth == Calendar.FEBRUARY && isLeapYear(
                                year)) {
                            daysInMonth += 1;
                        }
                        ruleDay = daysInMonth
                                + 1
                                + mod7(startDayOfWeek
                                - (firstDayOfMonth + daysInMonth))
                                + startDay * 7;
                    }
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
                    if (ruleDay != startDay) {
                        ruleDay -= 7;
                    }
                    break;
            }
            if (ruleDay > day || ruleDay == day && time < startTime) {
                return rawOffset;
            }
        }

        int ruleTime = endTime - dstSavings;
        int nextMonth = (month + 1) % 12;
        if (month == endMonth || (ruleTime < 0 && nextMonth == endMonth)) {
            switch (endMode) {
                case DOM_MODE:
                    ruleDay = endDay;
                    break;
                case DOW_IN_MONTH_MODE:
                    if (endDay >= 0) {
                        ruleDay = mod7(endDayOfWeek - firstDayOfMonth) + 1
                                + (endDay - 1) * 7;
                    } else {
                        daysInMonth = GregorianCalendar.DaysInMonth[endMonth];
                        if (endMonth == Calendar.FEBRUARY && isLeapYear(year)) {
                            daysInMonth++;
                        }
                        ruleDay = daysInMonth
                                + 1
                                + mod7(endDayOfWeek
                                - (firstDayOfMonth + daysInMonth)) + endDay
                                * 7;
                    }
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
                    if (ruleDay != endDay) {
                        ruleDay -= 7;
                    }
                    break;
            }

            int ruleMonth = endMonth;
            if (ruleTime < 0) {
                int changeDays = 1 - (ruleTime / 86400000);
                ruleTime = (ruleTime % 86400000) + 86400000;
                ruleDay -= changeDays;
                if (ruleDay <= 0) {
                    if (--ruleMonth < Calendar.JANUARY) {
                        ruleMonth = Calendar.DECEMBER;
                    }
                    ruleDay += GregorianCalendar.DaysInMonth[ruleMonth];
                    if (ruleMonth == Calendar.FEBRUARY && isLeapYear(year)) {
                        ruleDay++;
                    }
                }
            }

            if (month == ruleMonth) {
                if (ruleDay < day || ruleDay == day && time >= ruleTime) {
                    return rawOffset;
                }
            } else if (nextMonth != ruleMonth) {
                return rawOffset;
            }
        }
        return rawOffset + dstSavings;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.996 -0500", hash_original_method = "6DBE603182E450BA9A410285A6D6CE41", hash_generated_method = "70BEBAA8B2BA13FF2EADDA2F08EF85CA")
    
@Override
    public int getOffset(long time) {
        // Simplified variant of the ICU4J code.
        if (!useDaylightTime()) {
            return rawOffset;
        }
        int[] fields = Grego.timeToFields(time + rawOffset, null);
        return getOffset(GregorianCalendar.AD, fields[0], fields[1], fields[2],
                fields[3], fields[5]);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:59.999 -0500", hash_original_method = "D90129E49D21D0E2F7EA4F6539F9D2CB", hash_generated_method = "C17505E26981E9F2733690B104177769")
    
@Override
    public int getRawOffset() {
        return rawOffset;
    }

    /**
     * Returns an integer hash code for the receiver. Objects which are equal
     * return the same value for this method.
     *
     * @return the receiver's hash.
     * @see #equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.002 -0500", hash_original_method = "543AFBFA58DD3885C5C6D68F749BE5FB", hash_generated_method = "F59402BF202611685F635C695FD2D912")
    
@Override
    public synchronized int hashCode() {
        int hashCode = getID().hashCode() + rawOffset;
        if (useDaylight) {
            hashCode += startYear + startMonth + startDay + startDayOfWeek
                    + startTime + startMode + endMonth + endDay + endDayOfWeek
                    + endTime + endMode + dstSavings;
        }
        return hashCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.005 -0500", hash_original_method = "4BB4BBFFC89848EE3A9E98B493F95D5F", hash_generated_method = "151BEB860200488A67FBA27E804360BC")
    
@Override
    public boolean hasSameRules(TimeZone zone) {
        if (!(zone instanceof SimpleTimeZone)) {
            return false;
        }
        SimpleTimeZone tz = (SimpleTimeZone) zone;
        if (useDaylight != tz.useDaylight) {
            return false;
        }
        if (!useDaylight) {
            return rawOffset == tz.rawOffset;
        }
        return rawOffset == tz.rawOffset && dstSavings == tz.dstSavings
                && startYear == tz.startYear && startMonth == tz.startMonth
                && startDay == tz.startDay && startMode == tz.startMode
                && startDayOfWeek == tz.startDayOfWeek
                && startTime == tz.startTime && endMonth == tz.endMonth
                && endDay == tz.endDay && endDayOfWeek == tz.endDayOfWeek
                && endTime == tz.endTime && endMode == tz.endMode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.008 -0500", hash_original_method = "C51A338C9795AC2507162C0CE1A08702", hash_generated_method = "07476B51E1F72A77AF67007C1E161911")
    
@Override public boolean inDaylightTime(Date time) {
        return useDaylightTime() && getOffset(time.getTime()) != getRawOffset();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.010 -0500", hash_original_method = "8AD8F18B8E2CE991A6AB313B3340B306", hash_generated_method = "389E08095E7DA7BB895C13DFEF3FDEA3")
    
private boolean isLeapYear(int year) {
        if (year > 1582) {
            return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        }
        return year % 4 == 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.013 -0500", hash_original_method = "EABB822EA3A4CED689A420DE5F07AD18", hash_generated_method = "6EDF1A67EEB6134BA7E3C295180BA051")
    
private int mod7(int num1) {
        int rem = num1 % 7;
        return (num1 < 0 && rem < 0) ? 7 + rem : rem;
    }

    /**
     * Sets the daylight savings offset in milliseconds for this {@code SimpleTimeZone}.
     *
     * @param milliseconds
     *            the daylight savings offset in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.015 -0500", hash_original_method = "37D938F55D2005A7FF3D5AC31467EF4C", hash_generated_method = "91AD9DB45FD779AEBCD8021ED551D223")
    
public void setDSTSavings(int milliseconds) {
        if (milliseconds > 0) {
            dstSavings = milliseconds;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.018 -0500", hash_original_method = "29EACAF13C91B179EA825409505E4565", hash_generated_method = "FCAFA965D4A4DB96397E8EAD7B49DFA3")
    
private void checkRange(int month, int dayOfWeek, int time) {
        if (month < Calendar.JANUARY || month > Calendar.DECEMBER) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        if (dayOfWeek < Calendar.SUNDAY || dayOfWeek > Calendar.SATURDAY) {
            throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
        }
        if (time < 0 || time >= 24 * 3600000) {
            throw new IllegalArgumentException("Invalid time: " + time);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.021 -0500", hash_original_method = "F04B5CC4561F29CBDFD2A63D85494102", hash_generated_method = "C3383CE28563A567C949C6C2E32EBB75")
    
private void checkDay(int month, int day) {
        if (day <= 0 || day > GregorianCalendar.DaysInMonth[month]) {
            throw new IllegalArgumentException("Invalid day of month: " + day);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.024 -0500", hash_original_method = "E98C141304510A5F08CF5DF5CC63E118", hash_generated_method = "B066AEFAA498DFD7A991B3714D47B498")
    
private void setEndMode() {
        if (endDayOfWeek == 0) {
            endMode = DOM_MODE;
        } else if (endDayOfWeek < 0) {
            endDayOfWeek = -endDayOfWeek;
            if (endDay < 0) {
                endDay = -endDay;
                endMode = DOW_LE_DOM_MODE;
            } else {
                endMode = DOW_GE_DOM_MODE;
            }
        } else {
            endMode = DOW_IN_MONTH_MODE;
        }
        useDaylight = startDay != 0 && endDay != 0;
        if (endDay != 0) {
            checkRange(endMonth, endMode == DOM_MODE ? 1 : endDayOfWeek,
                    endTime);
            if (endMode != DOW_IN_MONTH_MODE) {
                checkDay(endMonth, endDay);
            } else {
                if (endDay < -5 || endDay > 5) {
                    throw new IllegalArgumentException("Day of week in month: " + endDay);
                }
            }
        }
        if (endMode != DOM_MODE) {
            endDayOfWeek--;
        }
    }

    /**
     * Sets the rule which specifies the end of daylight savings time.
     *
     * @param month
     *            the {@code Calendar} month in which daylight savings time ends.
     * @param dayOfMonth
     *            the {@code Calendar} day of the month on which daylight savings time
     *            ends.
     * @param time
     *            the time of day in milliseconds standard time on which
     *            daylight savings time ends.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.026 -0500", hash_original_method = "B4162090EB008A9B00DF0FE1EF92B7AC", hash_generated_method = "9B14F99D36C6E95C9455E4892D58E9C4")
    
public void setEndRule(int month, int dayOfMonth, int time) {
        endMonth = month;
        endDay = dayOfMonth;
        endDayOfWeek = 0; // Initialize this value for hasSameRules()
        endTime = time;
        setEndMode();
    }

    /**
     * Sets the rule which specifies the end of daylight savings time.
     *
     * @param month
     *            the {@code Calendar} month in which daylight savings time ends.
     * @param day
     *            the occurrence of the day of the week on which daylight
     *            savings time ends.
     * @param dayOfWeek
     *            the {@code Calendar} day of the week on which daylight savings time
     *            ends.
     * @param time
     *            the time of day in milliseconds standard time on which
     *            daylight savings time ends.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.029 -0500", hash_original_method = "582DA5383125C3306AD7EBC943F58F20", hash_generated_method = "878706F3ED8B8A49446DA0DD67696B35")
    
public void setEndRule(int month, int day, int dayOfWeek, int time) {
        endMonth = month;
        endDay = day;
        endDayOfWeek = dayOfWeek;
        endTime = time;
        setEndMode();
    }

    /**
     * Sets the rule which specifies the end of daylight savings time.
     *
     * @param month
     *            the {@code Calendar} month in which daylight savings time ends.
     * @param day
     *            the {@code Calendar} day of the month.
     * @param dayOfWeek
     *            the {@code Calendar} day of the week on which daylight savings time
     *            ends.
     * @param time
     *            the time of day in milliseconds on which daylight savings time
     *            ends.
     * @param after
     *            selects the day after or before the day of month.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.031 -0500", hash_original_method = "2E94B36A00113021CB8FDF603EDAA945", hash_generated_method = "226B341ACC4D2E91E74CC230F1E74914")
    
public void setEndRule(int month, int day, int dayOfWeek, int time, boolean after) {
        endMonth = month;
        endDay = after ? day : -day;
        endDayOfWeek = -dayOfWeek;
        endTime = time;
        setEndMode();
    }

    /**
     * Sets the offset for standard time from GMT for this {@code SimpleTimeZone}.
     *
     * @param offset
     *            the offset from GMT of standard time in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.034 -0500", hash_original_method = "C8A257B93E1C51862FD9A30D6A75C66A", hash_generated_method = "6B3DE74FE781DF776659D0672A413299")
    
@Override
    public void setRawOffset(int offset) {
        rawOffset = offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.036 -0500", hash_original_method = "4370DAC820CAB38F82466934EE4F5C8D", hash_generated_method = "2877D3D2CEC7F17C9334895D4D13934C")
    
private void setStartMode() {
        if (startDayOfWeek == 0) {
            startMode = DOM_MODE;
        } else if (startDayOfWeek < 0) {
            startDayOfWeek = -startDayOfWeek;
            if (startDay < 0) {
                startDay = -startDay;
                startMode = DOW_LE_DOM_MODE;
            } else {
                startMode = DOW_GE_DOM_MODE;
            }
        } else {
            startMode = DOW_IN_MONTH_MODE;
        }
        useDaylight = startDay != 0 && endDay != 0;
        if (startDay != 0) {
            checkRange(startMonth, startMode == DOM_MODE ? 1 : startDayOfWeek,
                    startTime);
            if (startMode != DOW_IN_MONTH_MODE) {
                checkDay(startMonth, startDay);
            } else {
                if (startDay < -5 || startDay > 5) {
                    throw new IllegalArgumentException("Day of week in month: " + startDay);
                }
            }
        }
        if (startMode != DOM_MODE) {
            startDayOfWeek--;
        }
    }

    /**
     * Sets the rule which specifies the start of daylight savings time.
     *
     * @param month
     *            the {@code Calendar} month in which daylight savings time starts.
     * @param dayOfMonth
     *            the {@code Calendar} day of the month on which daylight savings time
     *            starts.
     * @param time
     *            the time of day in milliseconds on which daylight savings time
     *            starts.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.039 -0500", hash_original_method = "1B6B9F6DA0D38FD2E6B0C75070F8A774", hash_generated_method = "5EF80926DEF4C2F6107FDDA2F72BAACC")
    
public void setStartRule(int month, int dayOfMonth, int time) {
        startMonth = month;
        startDay = dayOfMonth;
        startDayOfWeek = 0; // Initialize this value for hasSameRules()
        startTime = time;
        setStartMode();
    }

    /**
     * Sets the rule which specifies the start of daylight savings time.
     *
     * @param month
     *            the {@code Calendar} month in which daylight savings time starts.
     * @param day
     *            the occurrence of the day of the week on which daylight
     *            savings time starts.
     * @param dayOfWeek
     *            the {@code Calendar} day of the week on which daylight savings time
     *            starts.
     * @param time
     *            the time of day in milliseconds on which daylight savings time
     *            starts.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.042 -0500", hash_original_method = "05B57A1DF0091079AD9D1D4FB9E42767", hash_generated_method = "96AFAB722150386CBF3702A9FB920AEE")
    
public void setStartRule(int month, int day, int dayOfWeek, int time) {
        startMonth = month;
        startDay = day;
        startDayOfWeek = dayOfWeek;
        startTime = time;
        setStartMode();
    }

    /**
     * Sets the rule which specifies the start of daylight savings time.
     *
     * @param month
     *            the {@code Calendar} month in which daylight savings time starts.
     * @param day
     *            the {@code Calendar} day of the month.
     * @param dayOfWeek
     *            the {@code Calendar} day of the week on which daylight savings time
     *            starts.
     * @param time
     *            the time of day in milliseconds on which daylight savings time
     *            starts.
     * @param after
     *            selects the day after or before the day of month.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.044 -0500", hash_original_method = "D71B6352FE444D82D409CFA5438BDAA8", hash_generated_method = "874383FE574C1B00C2B58F12FEB17FB3")
    
public void setStartRule(int month, int day, int dayOfWeek, int time, boolean after) {
        startMonth = month;
        startDay = after ? day : -day;
        startDayOfWeek = -dayOfWeek;
        startTime = time;
        setStartMode();
    }

    /**
     * Sets the starting year for daylight savings time in this {@code SimpleTimeZone}.
     * Years before this start year will always be in standard time.
     *
     * @param year
     *            the starting year.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.047 -0500", hash_original_method = "7CBF25AFDCF863C97C11F8D0CB7F66E7", hash_generated_method = "7F0487982CAAC50F068E2EF69DD9A86D")
    
public void setStartYear(int year) {
        startYear = year;
        useDaylight = true;
    }

    /**
     * Returns the string representation of this {@code SimpleTimeZone}.
     *
     * @return the string representation of this {@code SimpleTimeZone}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.050 -0500", hash_original_method = "8DB4BEB563F494A2FC46832022F4609E", hash_generated_method = "DD90658939D7EF7DED8494A054570D8F")
    
@Override
    public String toString() {
        return getClass().getName()
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.052 -0500", hash_original_method = "7C1BE50DE9C29B43BADE36CF66AF8A96", hash_generated_method = "7EB8179D7118704192041A83659A57C3")
    
@Override
    public boolean useDaylightTime() {
        return useDaylight;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.059 -0500", hash_original_method = "F4691E6CC75F84FE0527C352A6F6F1B9", hash_generated_method = "2C211A75DB24E2D3EF588C18FBB3CA20")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        int sEndDay = endDay, sEndDayOfWeek = endDayOfWeek + 1, sStartDay = startDay, sStartDayOfWeek = startDayOfWeek + 1;
        if (useDaylight
                && (startMode != DOW_IN_MONTH_MODE || endMode != DOW_IN_MONTH_MODE)) {
            Calendar cal = new GregorianCalendar(this);
            if (endMode != DOW_IN_MONTH_MODE) {
                cal.set(Calendar.MONTH, endMonth);
                cal.set(Calendar.DATE, endDay);
                sEndDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                if (endMode == DOM_MODE) {
                    sEndDayOfWeek = cal.getFirstDayOfWeek();
                }
            }
            if (startMode != DOW_IN_MONTH_MODE) {
                cal.set(Calendar.MONTH, startMonth);
                cal.set(Calendar.DATE, startDay);
                sStartDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                if (startMode == DOM_MODE) {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.062 -0500", hash_original_method = "19765306B3DA0529AD0AFD53EDC0B4B8", hash_generated_method = "B76CEBA51327266D935605469BBD5852")
    
private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        rawOffset = fields.get("rawOffset", 0);
        useDaylight = fields.get("useDaylight", false);
        if (useDaylight) {
            endMonth = fields.get("endMonth", 0);
            endTime = fields.get("endTime", 0);
            startMonth = fields.get("startMonth", 0);
            startTime = fields.get("startTime", 0);
            startYear = fields.get("startYear", 0);
        }
        if (fields.get("serialVersionOnStream", 0) == 0) {
            if (useDaylight) {
                startMode = endMode = DOW_IN_MONTH_MODE;
                endDay = fields.get("endDay", 0);
                endDayOfWeek = fields.get("endDayOfWeek", 0) - 1;
                startDay = fields.get("startDay", 0);
                startDayOfWeek = fields.get("startDayOfWeek", 0) - 1;
            }
        } else {
            dstSavings = fields.get("dstSavings", 0);
            if (useDaylight) {
                endMode = fields.get("endMode", 0);
                startMode = fields.get("startMode", 0);
                int length = stream.readInt();
                byte[] values = new byte[length];
                stream.readFully(values);
                if (length >= 4) {
                    startDay = values[0];
                    startDayOfWeek = values[1];
                    if (startMode != DOM_MODE) {
                        startDayOfWeek--;
                    }
                    endDay = values[2];
                    endDayOfWeek = values[3];
                    if (endMode != DOM_MODE) {
                        endDayOfWeek--;
                    }
                }
            }
        }
    }
}

