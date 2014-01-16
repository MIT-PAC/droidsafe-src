package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GregorianCalendar extends Calendar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.292 -0500", hash_original_field = "2AEF9994CA92EDBF78CF161F830ED6AD", hash_generated_field = "B9386A44E9BFA9A5ED8D3E7882B2C9E1")

    private static final long serialVersionUID = -8125100834729963327L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.296 -0500", hash_original_field = "8F18B7E25931F3F020A38D92250DBC58", hash_generated_field = "93BFF7C10A82D9138EF2CEC785C901D2")

    public static final int BC = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.299 -0500", hash_original_field = "14044B627C1BE79FBC4B0CF60A89B14F", hash_generated_field = "BC845EBD4DA20DC255F4737CB21267E2")

    public static final int AD = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.301 -0500", hash_original_field = "6D017D6AC78BE66FCF363B178D70A5E6", hash_generated_field = "23BA66807055EDC52580EFE8B68EA6D9")

    private static final long defaultGregorianCutover = -12219292800000l;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.310 -0500", hash_original_field = "C710FC910AD6EEE7024665E4E1306978", hash_generated_field = "D109403F40DEAA9D96D5485CCE288282")

    static byte[] DaysInMonth = new byte[] { 31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.313 -0500", hash_original_field = "3964D1A3597A89E7D22F1ED4946E1C6E", hash_generated_field = "0A4DD57D0556CD2CAD7A071A46A83584")

    private static int[] DaysInYear = new int[] { 0, 31, 59, 90, 120, 151, 181,
            212, 243, 273, 304, 334 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.315 -0500", hash_original_field = "3D6D2EAD2325BFBC091903FED8C6BDDD", hash_generated_field = "9C039D691AF795C6B392702421AF992F")

    private static int[] maximums = new int[] { 1, 292278994, 11, 53, 6, 31,
            366, 7, 6, 1, 11, 23, 59, 59, 999, 14 * 3600 * 1000, 7200000 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.318 -0500", hash_original_field = "5898DF6E9360F94F2965C8DBDD3A60FE", hash_generated_field = "34197BE97C1359ACB541F3CFF4B6D197")

    private static int[] minimums = new int[] { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0,
            0, 0, 0, 0, 0, -13 * 3600 * 1000, 0 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.320 -0500", hash_original_field = "F896471ADDEB35A649148FC6116CF846", hash_generated_field = "72A42F262CE1CA8E4E3156D2F2A817C5")

    private static int[] leastMaximums = new int[] { 1, 292269054, 11, 50, 3,
            28, 355, 7, 3, 1, 11, 23, 59, 59, 999, 50400000, 1200000 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.303 -0500", hash_original_field = "062786F3914B87EA492F5CD0ADF5D8B8", hash_generated_field = "EA14FB63AF074345B169453863E64EC4")

    private long gregorianCutover = defaultGregorianCutover;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.306 -0500", hash_original_field = "B32171748BA84798392B75BE3D1CAB8A", hash_generated_field = "A0B8CA27149DD74350CDB7EC98C60162")

    private transient int changeYear = 1582;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.308 -0500", hash_original_field = "A2A1BF323C469790B379905EA1AE037F", hash_generated_field = "2808C9DD640CD873EE96A55ECDBB8D85")

    private transient int julianSkew = ((changeYear - 2000) / 400)
            + julianError() - ((changeYear - 2000) / 100);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.323 -0500", hash_original_field = "BD96B1F139C8EA198B3A1B2CA97B93E5", hash_generated_field = "4B7219F27A11B1E89794219BC39393A8")

    private boolean isCached;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.325 -0500", hash_original_field = "29EB5956BF6CB7E2028BB92FA0793412", hash_generated_field = "7AF7C45B7A2B45D012327222457CC902")

    private int[] cachedFields = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.327 -0500", hash_original_field = "09F8159258A9D84329045A944EE71E7B", hash_generated_field = "EAB4464060441E8E83529F625B8AC792")

    private long nextMidnightMillis = 0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.330 -0500", hash_original_field = "F99CA18E41E7D3E217421BBFA1B856C6", hash_generated_field = "A139545ACF978509DA3F6AC55F657D39")

    private long lastMidnightMillis = 0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.332 -0500", hash_original_field = "665D368DAE9B1850F1AA60EADBCFC3A0", hash_generated_field = "657D9B61D3147BAB9300368D7E5B963D")

    private int currentYearSkew = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.334 -0500", hash_original_field = "8CF3BB1297E7C57B5F8A17186009E762", hash_generated_field = "A15FC9D51CCB159121982FD9BA383E19")

    private int lastYearSkew = 0;

    /**
     * Constructs a new {@code GregorianCalendar} initialized to the current date and
     * time with the default {@code Locale} and {@code TimeZone}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.336 -0500", hash_original_method = "7EB3091E87333B7AA987345512812570", hash_generated_method = "8106811364876E1FB5FEFEAB5E247D55")
    
public GregorianCalendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }

    /**
     * Constructs a new {@code GregorianCalendar} initialized to midnight in the default
     * {@code TimeZone} and {@code Locale} on the specified date.
     *
     * @param year
     *            the year.
     * @param month
     *            the month.
     * @param day
     *            the day of the month.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.339 -0500", hash_original_method = "B0762BDDD2B39759F6CE94DB8F25D3E0", hash_generated_method = "C6FBC74FDA42BFD4E322BD6205A6B3F8")
    
public GregorianCalendar(int year, int month, int day) {
        super(TimeZone.getDefault(), Locale.getDefault());
        set(year, month, day);
    }

    /**
     * Constructs a new {@code GregorianCalendar} initialized to the specified date and
     * time in the default {@code TimeZone} and {@code Locale}.
     *
     * @param year
     *            the year.
     * @param month
     *            the month.
     * @param day
     *            the day of the month.
     * @param hour
     *            the hour.
     * @param minute
     *            the minute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.342 -0500", hash_original_method = "D6C72587979F1136CC7CF710B2F32D12", hash_generated_method = "200C889D405CFA31C11B19F22D850B0F")
    
public GregorianCalendar(int year, int month, int day, int hour, int minute) {
        super(TimeZone.getDefault(), Locale.getDefault());
        set(year, month, day, hour, minute);
    }

    /**
     * Constructs a new {@code GregorianCalendar} initialized to the specified date and
     * time in the default {@code TimeZone} and {@code Locale}.
     *
     * @param year
     *            the year.
     * @param month
     *            the month.
     * @param day
     *            the day of the month.
     * @param hour
     *            the hour.
     * @param minute
     *            the minute.
     * @param second
     *            the second.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.345 -0500", hash_original_method = "BC793B84C6DC2AD69827C6FC0D0FCEDD", hash_generated_method = "D808C8A13F245E0033CFCF0DD01629DC")
    
public GregorianCalendar(int year, int month, int day, int hour,
            int minute, int second) {
        super(TimeZone.getDefault(), Locale.getDefault());
        set(year, month, day, hour, minute, second);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.348 -0500", hash_original_method = "63C34121AB8507D7813FBAF0F269A9D2", hash_generated_method = "63C34121AB8507D7813FBAF0F269A9D2")
    
GregorianCalendar(long milliseconds) {
        this(false);
        setTimeInMillis(milliseconds);
    }

    /**
     * Constructs a new {@code GregorianCalendar} initialized to the current date and
     * time and using the specified {@code Locale} and the default {@code TimeZone}.
     *
     * @param locale
     *            the {@code Locale}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.351 -0500", hash_original_method = "56E3B8EB09DD30B0731434891C29D1A4", hash_generated_method = "B220926F77A1F0594A80803E8231CBF7")
    
public GregorianCalendar(Locale locale) {
        this(TimeZone.getDefault(), locale);
    }

    /**
     * Constructs a new {@code GregorianCalendar} initialized to the current date and
     * time and using the specified {@code TimeZone} and the default {@code Locale}.
     *
     * @param timezone
     *            the {@code TimeZone}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.354 -0500", hash_original_method = "7987E4D71BE0DBF5086B038B74101A38", hash_generated_method = "989AD10C10424F4CEEDD7483BF5F80CF")
    
public GregorianCalendar(TimeZone timezone) {
        this(timezone, Locale.getDefault());
    }

    /**
     * Constructs a new {@code GregorianCalendar} initialized to the current date and
     * time and using the specified {@code TimeZone} and {@code Locale}.
     *
     * @param timezone
     *            the {@code TimeZone}.
     * @param locale
     *            the {@code Locale}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.357 -0500", hash_original_method = "98E484CB97D77C9503930A8DB608CAE2", hash_generated_method = "35023E300DC55B5BD1545BFDF63CDBB8")
    
public GregorianCalendar(TimeZone timezone, Locale locale) {
        super(timezone, locale);
        setTimeInMillis(System.currentTimeMillis());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.359 -0500", hash_original_method = "0CE38BA4675BDF22B153CA671467EBE6", hash_generated_method = "0CE38BA4675BDF22B153CA671467EBE6")
    
GregorianCalendar(boolean ignored) {
        super(TimeZone.getDefault());
        setFirstDayOfWeek(SUNDAY);
        setMinimalDaysInFirstWeek(1);
    }

    /**
     * Adds the specified amount to a {@code Calendar} field.
     *
     * @param field
     *            the {@code Calendar} field to modify.
     * @param value
     *            the amount to add to the field.
     *
     * @throws IllegalArgumentException
     *                if the specified field is DST_OFFSET or ZONE_OFFSET.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.363 -0500", hash_original_method = "1FE1308881E1142F9D3B7A007897B586", hash_generated_method = "CD6B180F0015465F27DC84FCF52538BA")
    
@Override
    public void add(int field, int value) {
        if (value == 0) {
            return;
        }
        if (field < 0 || field >= ZONE_OFFSET) {
            throw new IllegalArgumentException();
        }

        isCached = false;

        if (field == ERA) {
            complete();
            if (fields[ERA] == AD) {
                if (value >= 0) {
                    return;
                }
                set(ERA, BC);
            } else {
                if (value <= 0) {
                    return;
                }
                set(ERA, AD);
            }
            complete();
            return;
        }

        if (field == YEAR || field == MONTH) {
            complete();
            if (field == MONTH) {
                int month = fields[MONTH] + value;
                if (month < 0) {
                    value = (month - 11) / 12;
                    month = 12 + (month % 12);
                } else {
                    value = month / 12;
                }
                set(MONTH, month % 12);
            }
            set(YEAR, fields[YEAR] + value);
            int days = daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]);
            if (fields[DATE] > days) {
                set(DATE, days);
            }
            complete();
            return;
        }

        long multiplier = 0;
        getTimeInMillis(); // Update the time
        switch (field) {
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
        }

        if (multiplier == 0) {
            areFieldsSet = false;
            complete();
            return;
        }

        long delta = value * multiplier;

        /*
         * Attempt to keep the hour and minute constant when we've crossed a DST
         * boundary and the user's units are AM_PM or larger. The typical
         * consequence is that calls to add(DATE, 1) will add 23, 24 or 25 hours
         * depending on whether the DST goes forward, constant, or backward.
         *
         * We know we've crossed a DST boundary if the new time will have a
         * different timezone offset. Adjust by adding the difference of the two
         * offsets. We don't adjust when doing so prevents the change from
         * crossing the boundary.
         */
        int zoneOffset = getTimeZone().getRawOffset();
        int offsetBefore = getOffset(time + zoneOffset);
        int offsetAfter = getOffset(time + zoneOffset + delta);
        int dstDelta = offsetBefore - offsetAfter;
        if (getOffset(time + zoneOffset + delta + dstDelta) == offsetAfter) {
            delta += dstDelta;
        }

        time += delta;
        areFieldsSet = false;
        complete();
    }

    /**
     * Creates new instance of {@code GregorianCalendar} with the same properties.
     *
     * @return a shallow copy of this {@code GregorianCalendar}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.366 -0500", hash_original_method = "4451E97BB30CB152B3F7FF3125B7AC95", hash_generated_method = "1D341620BC27492BCFC6A3EA3DD92D1C")
    
@Override
    public Object clone() {
        GregorianCalendar thisClone = (GregorianCalendar) super.clone();
        thisClone.cachedFields = cachedFields.clone();
        return thisClone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.371 -0500", hash_original_method = "005B3A99F85903E106454DD8B0079421", hash_generated_method = "5D5AAECD5714EBB5693CDBC5A5741949")
    
private final void fullFieldsCalc(long timeVal, int millis, int zoneOffset) {
        long days = timeVal / 86400000;

        if (millis < 0) {
            millis += 86400000;
            days--;
        }
        // Cannot add ZONE_OFFSET to time as it might overflow
        millis += zoneOffset;
        while (millis < 0) {
            millis += 86400000;
            days--;
        }
        while (millis >= 86400000) {
            millis -= 86400000;
            days++;
        }

        int dayOfYear = computeYearAndDay(days, timeVal + zoneOffset);
        fields[DAY_OF_YEAR] = dayOfYear;
        if(fields[YEAR] == changeYear && gregorianCutover <= timeVal + zoneOffset){
            dayOfYear += currentYearSkew;
        }
        int month = dayOfYear / 32;
        boolean leapYear = isLeapYear(fields[YEAR]);
        int date = dayOfYear - daysInYear(leapYear, month);
        if (date > daysInMonth(leapYear, month)) {
            date -= daysInMonth(leapYear, month);
            month++;
        }
        fields[DAY_OF_WEEK] = mod7(days - 3) + 1;
        int dstOffset = fields[YEAR] <= 0 ? 0 : getTimeZone().getOffset(AD,
                fields[YEAR], month, date, fields[DAY_OF_WEEK], millis);
        if (fields[YEAR] > 0) {
            dstOffset -= zoneOffset;
        }
        fields[DST_OFFSET] = dstOffset;
        if (dstOffset != 0) {
            long oldDays = days;
            millis += dstOffset;
            if (millis < 0) {
                millis += 86400000;
                days--;
            } else if (millis >= 86400000) {
                millis -= 86400000;
                days++;
            }
            if (oldDays != days) {
                dayOfYear = computeYearAndDay(days, timeVal - zoneOffset
                        + dstOffset);
                fields[DAY_OF_YEAR] = dayOfYear;
                if(fields[YEAR] == changeYear && gregorianCutover <= timeVal - zoneOffset + dstOffset){
                    dayOfYear += currentYearSkew;
                }
                month = dayOfYear / 32;
                leapYear = isLeapYear(fields[YEAR]);
                date = dayOfYear - daysInYear(leapYear, month);
                if (date > daysInMonth(leapYear, month)) {
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

        if (fields[YEAR] <= 0) {
            fields[ERA] = BC;
            fields[YEAR] = -fields[YEAR] + 1;
        } else {
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
        if (week == 0) {
            fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart
                    - (isLeapYear(fields[YEAR] - 1) ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 53
                    : 52;
        } else if (fields[DAY_OF_YEAR] >= (leapYear ? 367 : 366)
                - mod7(daysFromStart + (leapYear ? 2 : 1))) {
            fields[WEEK_OF_YEAR] = 7 - mod7(daysFromStart + (leapYear ? 2 : 1)) >= getMinimalDaysInFirstWeek() ? 1
                    : week;
        } else {
            fields[WEEK_OF_YEAR] = week;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.374 -0500", hash_original_method = "2E866A22E927A34EE822F5C0BBDFB40C", hash_generated_method = "8133CEC61DDB2546B7D27B25AB48C621")
    
private final void cachedFieldsCheckAndGet(long timeVal,
            long newTimeMillis, long newTimeMillisAdjusted, int millis,
            int zoneOffset) {
        int dstOffset = fields[DST_OFFSET];
        if (!isCached
                || newTimeMillis >= nextMidnightMillis
                || newTimeMillis <= lastMidnightMillis
                || cachedFields[4] != zoneOffset
                || (dstOffset == 0 && (newTimeMillisAdjusted >= nextMidnightMillis))
                || (dstOffset != 0 && (newTimeMillisAdjusted <= lastMidnightMillis))) {
            fullFieldsCalc(timeVal, millis, zoneOffset);
            isCached = false;
        } else {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.378 -0500", hash_original_method = "B0DF08CEBB1EE730F98FF9762C9FEBD4", hash_generated_method = "5C58DD3E66D4E1C008C906C62C5D9263")
    
@Override
    protected void computeFields() {
        TimeZone timeZone = getTimeZone();
        int dstOffset = timeZone.inDaylightTime(new Date(time)) ? timeZone.getDSTSavings() : 0;
        int zoneOffset = timeZone.getRawOffset();
        fields[DST_OFFSET] = dstOffset;
        fields[ZONE_OFFSET] = zoneOffset;

        int millis = (int) (time % 86400000);
        int savedMillis = millis;
        // compute without a change in daylight saving time
        int offset = zoneOffset + dstOffset;
        long newTime = time + offset;

        if (time > 0L && newTime < 0L && offset > 0) {
            newTime = 0x7fffffffffffffffL;
        } else if (time < 0L && newTime > 0L && offset < 0) {
            newTime = 0x8000000000000000L;
        }

        // FIXME: I don't think this caching ever really gets used, because it requires that the
        // time zone doesn't use daylight savings (ever). So unless you're somewhere like Taiwan...
        if (isCached) {
            if (millis < 0) {
                millis += 86400000;
            }

            // Cannot add ZONE_OFFSET to time as it might overflow
            millis += zoneOffset;
            millis += dstOffset;

            if (millis < 0) {
                millis += 86400000;
            } else if (millis >= 86400000) {
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

            // FIXME: this has to be wrong; useDaylightTime doesn't mean what they think it means!
            long newTimeAdjusted = newTime;
            if (timeZone.useDaylightTime()) {
                int dstSavings = timeZone.getDSTSavings();
                newTimeAdjusted += (dstOffset == 0) ? dstSavings : -dstSavings;
            }

            if (newTime > 0L && newTimeAdjusted < 0L && dstOffset == 0) {
                newTimeAdjusted = 0x7fffffffffffffffL;
            } else if (newTime < 0L && newTimeAdjusted > 0L && dstOffset != 0) {
                newTimeAdjusted = 0x8000000000000000L;
            }

            cachedFieldsCheckAndGet(time, newTime, newTimeAdjusted,
                    savedMillis, zoneOffset);
        } else {
            fullFieldsCalc(time, savedMillis, zoneOffset);
        }

        for (int i = 0; i < FIELD_COUNT; i++) {
            isSet[i] = true;
        }

        // Caching
        if (!isCached
                && newTime != 0x7fffffffffffffffL
                && newTime != 0x8000000000000000L
                && (!timeZone.useDaylightTime() || timeZone instanceof SimpleTimeZone)) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.384 -0500", hash_original_method = "2C41A89AB92A41E731883E58EB4B865A", hash_generated_method = "022959F13365F46FF73CCF558677F2AC")
    
@Override
    protected void computeTime() {
        if (!isLenient()) {
            if (isSet[HOUR_OF_DAY]) {
                if (fields[HOUR_OF_DAY] < 0 || fields[HOUR_OF_DAY] > 23) {
                    throw new IllegalArgumentException();
                }
            } else if (isSet[HOUR] && (fields[HOUR] < 0 || fields[HOUR] > 11)) {
                throw new IllegalArgumentException();
            }
            if (isSet[MINUTE] && (fields[MINUTE] < 0 || fields[MINUTE] > 59)) {
                throw new IllegalArgumentException();
            }
            if (isSet[SECOND] && (fields[SECOND] < 0 || fields[SECOND] > 59)) {
                throw new IllegalArgumentException();
            }
            if (isSet[MILLISECOND]
                    && (fields[MILLISECOND] < 0 || fields[MILLISECOND] > 999)) {
                throw new IllegalArgumentException();
            }
            if (isSet[WEEK_OF_YEAR]
                    && (fields[WEEK_OF_YEAR] < 1 || fields[WEEK_OF_YEAR] > 53)) {
                throw new IllegalArgumentException();
            }
            if (isSet[DAY_OF_WEEK]
                    && (fields[DAY_OF_WEEK] < 1 || fields[DAY_OF_WEEK] > 7)) {
                throw new IllegalArgumentException();
            }
            if (isSet[DAY_OF_WEEK_IN_MONTH]
                    && (fields[DAY_OF_WEEK_IN_MONTH] < 1 || fields[DAY_OF_WEEK_IN_MONTH] > 6)) {
                throw new IllegalArgumentException();
            }
            if (isSet[WEEK_OF_MONTH]
                    && (fields[WEEK_OF_MONTH] < 1 || fields[WEEK_OF_MONTH] > 6)) {
                throw new IllegalArgumentException();
            }
            if (isSet[AM_PM] && fields[AM_PM] != AM && fields[AM_PM] != PM) {
                throw new IllegalArgumentException();
            }
            if (isSet[HOUR] && (fields[HOUR] < 0 || fields[HOUR] > 11)) {
                throw new IllegalArgumentException();
            }
            if (isSet[YEAR]) {
                if (isSet[ERA] && fields[ERA] == BC
                        && (fields[YEAR] < 1 || fields[YEAR] > 292269054)) {
                    throw new IllegalArgumentException();
                } else if (fields[YEAR] < 1 || fields[YEAR] > 292278994) {
                    throw new IllegalArgumentException();
                }
            }
            if (isSet[MONTH] && (fields[MONTH] < 0 || fields[MONTH] > 11)) {
                throw new IllegalArgumentException();
            }
        }

        long timeVal;
        long hour = 0;
        if (isSet[HOUR_OF_DAY] && lastTimeFieldSet != HOUR) {
            hour = fields[HOUR_OF_DAY];
        } else if (isSet[HOUR]) {
            hour = (fields[AM_PM] * 12) + fields[HOUR];
        }
        timeVal = hour * 3600000;

        if (isSet[MINUTE]) {
            timeVal += ((long) fields[MINUTE]) * 60000;
        }
        if (isSet[SECOND]) {
            timeVal += ((long) fields[SECOND]) * 1000;
        }
        if (isSet[MILLISECOND]) {
            timeVal += fields[MILLISECOND];
        }

        long days;
        int year = isSet[YEAR] ? fields[YEAR] : 1970;
        if (isSet[ERA]) {
            // Always test for valid ERA, even if the Calendar is lenient
            if (fields[ERA] != BC && fields[ERA] != AD) {
                throw new IllegalArgumentException();
            }
            if (fields[ERA] == BC) {
                year = 1 - year;
            }
        }

        boolean weekMonthSet = isSet[WEEK_OF_MONTH]
                || isSet[DAY_OF_WEEK_IN_MONTH];
        boolean useMonth = (isSet[DATE] || isSet[MONTH] || weekMonthSet)
                && lastDateFieldSet != DAY_OF_YEAR;
        if (useMonth
                && (lastDateFieldSet == DAY_OF_WEEK || lastDateFieldSet == WEEK_OF_YEAR)) {
            if (isSet[WEEK_OF_YEAR] && isSet[DAY_OF_WEEK]) {
                useMonth = lastDateFieldSet != WEEK_OF_YEAR && weekMonthSet
                        && isSet[DAY_OF_WEEK];
            } else if (isSet[DAY_OF_YEAR]) {
                useMonth = isSet[DATE] && isSet[MONTH];
            }
        }

        if (useMonth) {
            int month = fields[MONTH];
            year += month / 12;
            month %= 12;
            if (month < 0) {
                year--;
                month += 12;
            }
            boolean leapYear = isLeapYear(year);
            days = daysFromBaseYear(year) + daysInYear(leapYear, month);
            boolean useDate = isSet[DATE];
            if (useDate
                    && (lastDateFieldSet == DAY_OF_WEEK
                            || lastDateFieldSet == WEEK_OF_MONTH || lastDateFieldSet == DAY_OF_WEEK_IN_MONTH)) {
                useDate = !(isSet[DAY_OF_WEEK] && weekMonthSet);
            }
            if (useDate) {
                if (!isLenient()
                        && (fields[DATE] < 1 || fields[DATE] > daysInMonth(
                                leapYear, month))) {
                    throw new IllegalArgumentException();
                }
                days += fields[DATE] - 1;
            } else {
                int dayOfWeek;
                if (isSet[DAY_OF_WEEK]) {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } else {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                }
                if (isSet[WEEK_OF_MONTH]
                        && lastDateFieldSet != DAY_OF_WEEK_IN_MONTH) {
                    int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += (fields[WEEK_OF_MONTH] - 1) * 7
                            + mod7(skew + dayOfWeek - (days - 3)) - skew;
                } else if (isSet[DAY_OF_WEEK_IN_MONTH]) {
                    if (fields[DAY_OF_WEEK_IN_MONTH] >= 0) {
                        days += mod7(dayOfWeek - (days - 3))
                                + (fields[DAY_OF_WEEK_IN_MONTH] - 1) * 7;
                    } else {
                        days += daysInMonth(leapYear, month)
                                + mod7(dayOfWeek
                                        - (days + daysInMonth(leapYear, month) - 3))
                                + fields[DAY_OF_WEEK_IN_MONTH] * 7;
                    }
                } else if (isSet[DAY_OF_WEEK]) {
                    int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                    days += mod7(mod7(skew + dayOfWeek - (days - 3)) - skew);
                }
            }
        } else {
            boolean useWeekYear = isSet[WEEK_OF_YEAR]
                    && lastDateFieldSet != DAY_OF_YEAR;
            if (useWeekYear && isSet[DAY_OF_YEAR]) {
                useWeekYear = isSet[DAY_OF_WEEK];
            }
            days = daysFromBaseYear(year);
            if (useWeekYear) {
                int dayOfWeek;
                if (isSet[DAY_OF_WEEK]) {
                    dayOfWeek = fields[DAY_OF_WEEK] - 1;
                } else {
                    dayOfWeek = getFirstDayOfWeek() - 1;
                }
                int skew = mod7(days - 3 - (getFirstDayOfWeek() - 1));
                days += (fields[WEEK_OF_YEAR] - 1) * 7
                        + mod7(skew + dayOfWeek - (days - 3)) - skew;
                if (7 - skew < getMinimalDaysInFirstWeek()) {
                    days += 7;
                }
            } else if (isSet[DAY_OF_YEAR]) {
                if (!isLenient()
                        && (fields[DAY_OF_YEAR] < 1 || fields[DAY_OF_YEAR] > (365 + (isLeapYear(year) ? 1
                                : 0)))) {
                    throw new IllegalArgumentException();
                }
                days += fields[DAY_OF_YEAR] - 1;
            } else if (isSet[DAY_OF_WEEK]) {
                days += mod7(fields[DAY_OF_WEEK] - 1 - (days - 3));
            }
        }
        lastDateFieldSet = 0;

        timeVal += days * 86400000;
        // Use local time to compare with the gregorian change
        if (year == changeYear
                && timeVal >= gregorianCutover + julianError() * 86400000L) {
            timeVal -= julianError() * 86400000L;
        }

        // It is not possible to simply subtract getOffset(timeVal) from timeVal
        // to get UTC.
        // The trick is needed for the moment when DST transition occurs,
        // say 1:00 is a transition time when DST offset becomes +1 hour,
        // then wall time in the interval 1:00 - 2:00 is invalid and is
        // treated as UTC time.
        long timeValWithoutDST = timeVal - getOffset(timeVal)
                + getTimeZone().getRawOffset();
        timeVal -= getOffset(timeValWithoutDST);
        // Need to update wall time in fields, since it was invalid due to DST
        // transition
        this.time = timeVal;
        if (timeValWithoutDST != timeVal) {
            computeFields();
            areFieldsSet = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.387 -0500", hash_original_method = "2A644CA75A846A9F294F6A7DE0BAB232", hash_generated_method = "8E73AB6637D824B9FAA3816A317AC3E0")
    
private int computeYearAndDay(long dayCount, long localTime) {
        int year = 1970;
        long days = dayCount;
        if (localTime < gregorianCutover) {
            days -= julianSkew;
        }
        int approxYears;

        while ((approxYears = (int) (days / 365)) != 0) {
            year = year + approxYears;
            days = dayCount - daysFromBaseYear(year);
        }
        if (days < 0) {
            year = year - 1;
            days = days + daysInYear(year);
        }
        fields[YEAR] = year;
        return (int) days + 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.390 -0500", hash_original_method = "975CAA178CB1C52E2022FF53CD13129C", hash_generated_method = "C78D61EDBA01C546F088DF888225FF91")
    
private long daysFromBaseYear(int iyear) {
        long year = iyear;

        if (year >= 1970) {
            long days = (year - 1970) * 365 + ((year - 1969) / 4);
            if (year > changeYear) {
                days -= ((year - 1901) / 100) - ((year - 1601) / 400);
            } else {
                if(year == changeYear){
                    days += currentYearSkew;
                }else if(year == changeYear -1){
                    days += lastYearSkew;
                }else{
                    days += julianSkew;
                }
            }
            return days;
        } else if (year <= changeYear) {
            return (year - 1970) * 365 + ((year - 1972) / 4) + julianSkew;
        }
        return (year - 1970) * 365 + ((year - 1972) / 4)
                - ((year - 2000) / 100) + ((year - 2000) / 400);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.392 -0500", hash_original_method = "B393AFA9309B3ECCDD74469F481095BD", hash_generated_method = "3D80089CAC945F7D85B5EBE0BD6A19BE")
    
private int daysInMonth() {
        return daysInMonth(isLeapYear(fields[YEAR]), fields[MONTH]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.395 -0500", hash_original_method = "F030460418FCB84947C9AD9647C8CF35", hash_generated_method = "B76702503A4E8E0C89A90CF13CA4C1F7")
    
private int daysInMonth(boolean leapYear, int month) {
        if (leapYear && month == FEBRUARY) {
            return DaysInMonth[month] + 1;
        }

        return DaysInMonth[month];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.397 -0500", hash_original_method = "643B799339D2A3831DACB9C12752109A", hash_generated_method = "DBDC23FEAAD1342B28D6E8FF18631D90")
    
private int daysInYear(int year) {
        int daysInYear = isLeapYear(year) ? 366 : 365;
        if (year == changeYear) {
            daysInYear -= currentYearSkew;
        }
        if (year == changeYear - 1) {
            daysInYear -= lastYearSkew;
        }
        return daysInYear;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.400 -0500", hash_original_method = "7E255F605E98F52E53144D7126E773F6", hash_generated_method = "0C8FD76949EE8694052989880C69E55A")
    
private int daysInYear(boolean leapYear, int month) {
        if (leapYear && month > FEBRUARY) {
            return DaysInYear[month] + 1;
        }

        return DaysInYear[month];
    }

    /**
     * Compares the specified {@code Object} to this {@code GregorianCalendar} and returns whether
     * they are equal. To be equal, the {@code Object} must be an instance of {@code GregorianCalendar} and
     * have the same properties.
     *
     * @param object
     *            the {@code Object} to compare with this {@code GregorianCalendar}.
     * @return {@code true} if {@code object} is equal to this
     *         {@code GregorianCalendar}, {@code false} otherwise.
     * @throws IllegalArgumentException
     *                if the time is not set and the time cannot be computed
     *                from the current field values.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.403 -0500", hash_original_method = "61C11EDCA3B03978A14421C2440916AB", hash_generated_method = "638BA54CFC73F2DB62C2F1DAB15463EE")
    
@Override
    public boolean equals(Object object) {
        if (!(object instanceof GregorianCalendar)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        return super.equals(object)
                && gregorianCutover == ((GregorianCalendar) object).gregorianCutover;
    }

    /**
     * Gets the maximum value of the specified field for the current date. For
     * example, the maximum number of days in the current month.
     *
     * @param field
     *            the field.
     * @return the maximum value of the specified field.
     */
    @DSSource({DSSourceKind.CALENDAR_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.406 -0500", hash_original_method = "F6A8281F341CD14B238EE5FA427449C3", hash_generated_method = "913FDEF5112DA93F0557A07043E98A89")
    
@Override
    public int getActualMaximum(int field) {
        int value;
        if ((value = maximums[field]) == leastMaximums[field]) {
            return value;
        }

        switch (field) {
            case WEEK_OF_YEAR:
            case WEEK_OF_MONTH:
                isCached = false;
                break;
        }

        complete();
        long orgTime = time;
        int result = 0;
        switch (field) {
            case WEEK_OF_YEAR:
                set(DATE, 31);
                set(MONTH, DECEMBER);
                result = get(WEEK_OF_YEAR);
                if (result == 1) {
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
                return daysInMonth();
            case DAY_OF_YEAR:
                return daysInYear(fields[YEAR]);
            case DAY_OF_WEEK_IN_MONTH:
                result = get(DAY_OF_WEEK_IN_MONTH)
                        + ((daysInMonth() - get(DATE)) / 7);
                break;
            case YEAR:
                GregorianCalendar clone = (GregorianCalendar) clone();
                if (get(ERA) == AD) {
                    clone.setTimeInMillis(Long.MAX_VALUE);
                } else {
                    clone.setTimeInMillis(Long.MIN_VALUE);
                }
                result = clone.get(YEAR);
                clone.set(YEAR, get(YEAR));
                if (clone.before(this)) {
                    result--;
                }
                break;
            case DST_OFFSET:
                result = getMaximum(DST_OFFSET);
                break;
        }
        time = orgTime;
        return result;
    }

    /**
     * Gets the minimum value of the specified field for the current date. For
     * the gregorian calendar, this value is the same as
     * {@code getMinimum()}.
     *
     * @param field
     *            the field.
     * @return the minimum value of the specified field.
     */
    @DSSource({DSSourceKind.CALENDAR_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.409 -0500", hash_original_method = "0094646504037C44C448A8626AEC2CA3", hash_generated_method = "9859DA9E3BF6480B52F971E718B8EF8F")
    
@Override
    public int getActualMinimum(int field) {
        return getMinimum(field);
    }

    /**
     * Gets the greatest minimum value of the specified field. For the gregorian
     * calendar, this value is the same as {@code getMinimum()}.
     *
     * @param field
     *            the field.
     * @return the greatest minimum value of the specified field.
     */
    @DSSource({DSSourceKind.CALENDAR_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.411 -0500", hash_original_method = "F3CD156C4D2759DEA34A15A000EAB551", hash_generated_method = "06503E779DF1AAE63FA9E76A736474C4")
    
@Override
    public int getGreatestMinimum(int field) {
        return minimums[field];
    }

    /**
     * Returns the gregorian change date of this calendar. This is the date on
     * which the gregorian calendar came into effect.
     *
     * @return a {@code Date} which represents the gregorian change date.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.CALENDAR_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.414 -0500", hash_original_method = "BD206861177D272D9EC33433339CB64F", hash_generated_method = "6F349129557415586896680515720B93")
    
public final Date getGregorianChange() {
        return new Date(gregorianCutover);
    }

    /**
     * Gets the smallest maximum value of the specified field. For example, 28
     * for the day of month field.
     *
     * @param field
     *            the field.
     * @return the smallest maximum value of the specified field.
     */
    @DSSource({DSSourceKind.CALENDAR_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.417 -0500", hash_original_method = "3B0100990EBACC07D6E54BAA89A3102A", hash_generated_method = "7B78DAC75A84381CCBABA20E70062944")
    
@Override
    public int getLeastMaximum(int field) {
        // return value for WEEK_OF_YEAR should make corresponding changes when
        // the gregorian change date have been reset.
        if (gregorianCutover != defaultGregorianCutover
                && field == WEEK_OF_YEAR) {
            long currentTimeInMillis = time;
            setTimeInMillis(gregorianCutover);
            int actual = getActualMaximum(field);
            setTimeInMillis(currentTimeInMillis);
            return actual;
        }
        return leastMaximums[field];
    }

    /**
     * Gets the greatest maximum value of the specified field. For example, 31
     * for the day of month field.
     *
     * @param field
     *            the field.
     * @return the greatest maximum value of the specified field.
     */
    @DSSource({DSSourceKind.CALENDAR_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.419 -0500", hash_original_method = "80794FF1ED1E8F2177114BCAA53EED59", hash_generated_method = "FB0DD220BDF24E9F0F24D7EAE89D9387")
    
@Override
    public int getMaximum(int field) {
        return maximums[field];
    }

    /**
     * Gets the smallest minimum value of the specified field.
     *
     * @param field
     *            the field.
     * @return the smallest minimum value of the specified field.
     */
    @DSSource({DSSourceKind.CALENDAR_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.421 -0500", hash_original_method = "1A09A14EE8971B3B0503081305AF18CB", hash_generated_method = "D44877A6918017B79756798A76B891F2")
    
@Override
    public int getMinimum(int field) {
        return minimums[field];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.424 -0500", hash_original_method = "A5F3F970AF018D82525827EF3879E8F1", hash_generated_method = "7CC64E6D1EDC82187803C698D4A4A318")
    
private int getOffset(long localTime) {
        TimeZone timeZone = getTimeZone();

        long dayCount = localTime / 86400000;
        int millis = (int) (localTime % 86400000);
        if (millis < 0) {
            millis += 86400000;
            dayCount--;
        }

        int year = 1970;
        long days = dayCount;
        if (localTime < gregorianCutover) {
            days -= julianSkew;
        }
        int approxYears;

        while ((approxYears = (int) (days / 365)) != 0) {
            year = year + approxYears;
            days = dayCount - daysFromBaseYear(year);
        }
        if (days < 0) {
            year = year - 1;
            days = days + 365 + (isLeapYear(year) ? 1 : 0);
            if (year == changeYear && localTime < gregorianCutover) {
                days -= julianError();
            }
        }
        if (year <= 0) {
            return timeZone.getRawOffset();
        }
        int dayOfYear = (int) days + 1;

        int month = dayOfYear / 32;
        boolean leapYear = isLeapYear(year);
        int date = dayOfYear - daysInYear(leapYear, month);
        if (date > daysInMonth(leapYear, month)) {
            date -= daysInMonth(leapYear, month);
            month++;
        }
        int dayOfWeek = mod7(dayCount - 3) + 1;
        int offset = timeZone.getOffset(AD, year, month, date, dayOfWeek,
                millis);
        return offset;
    }

    /**
     * Returns an integer hash code for the receiver. Objects which are equal
     * return the same value for this method.
     *
     * @return the receiver's hash.
     *
     * @see #equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.427 -0500", hash_original_method = "6907F2ED2DF57E219AB70EADED509565", hash_generated_method = "30C160E12136D4D4A9C2EA4D3CA5489B")
    
@Override
    public int hashCode() {
        return super.hashCode()
                + ((int) (gregorianCutover >>> 32) ^ (int) gregorianCutover);
    }

    /**
     * Returns whether the specified year is a leap year.
     *
     * @param year
     *            the year.
     * @return {@code true} if the specified year is a leap year, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.429 -0500", hash_original_method = "FD1210B9D1DAC87CC2975B1EB57E42AE", hash_generated_method = "35D84B3A7B789FBCDB9B49955EBD6A56")
    
public boolean isLeapYear(int year) {
        if (year > changeYear) {
            return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        }

        return year % 4 == 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.432 -0500", hash_original_method = "6792E5EC134CCE3576D348D7664F192E", hash_generated_method = "63AF018498F6022012D2F2CC4CF10B85")
    
private int julianError() {
        return changeYear / 100 - changeYear / 400 - 2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.434 -0500", hash_original_method = "C7B77E5A8B6CB394A26ACFDB4CA2A34C", hash_generated_method = "2EDCB797D9AC2A54F5D65E61E61FBCC1")
    
private int mod(int value, int mod) {
        int rem = value % mod;
        if (value < 0 && rem < 0) {
            return rem + mod;
        }
        return rem;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.436 -0500", hash_original_method = "B5B6FCF50F48D18673AA227255C5F0A5", hash_generated_method = "F83C9883192187F90C92BB45D63524AE")
    
private int mod7(long num1) {
        int rem = (int) (num1 % 7);
        if (num1 < 0 && rem < 0) {
            return rem + 7;
        }
        return rem;
    }

    /**
     * Adds the specified amount the specified field and wraps the value of the
     * field when it goes beyond the maximum or minimum value for the current
     * date. Other fields will be adjusted as required to maintain a consistent
     * date.
     *
     * @param field
     *            the field to roll.
     * @param value
     *            the amount to add.
     *
     * @throws IllegalArgumentException
     *                if an invalid field is specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.441 -0500", hash_original_method = "B265969ED1D5B160D0AFF42D0A073F4D", hash_generated_method = "6947F0FF708D447C444AC79188FF3E12")
    
@Override
    public void roll(int field, int value) {
        if (value == 0) {
            return;
        }
        if (field < 0 || field >= ZONE_OFFSET) {
            throw new IllegalArgumentException();
        }

        isCached = false;

        complete();
        int days, day, mod, maxWeeks, newWeek;
        int max = -1;
        switch (field) {
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
            if (newWeek == maxWeeks) {
                int addDays = (newWeek - fields[field]) * 7;
                if (fields[day] > addDays && fields[day] + addDays > days) {
                    set(field, 1);
                } else {
                    set(field, newWeek - 1);
                }
            } else if (newWeek == 1) {
                int week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
                if (week > 1) {
                    set(field, 1);
                } else {
                    set(field, newWeek);
                }
            } else {
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
            if (newWeek == maxWeeks) {
                if (fields[day] + (newWeek - fields[field]) * 7 > days) {
                    set(day, days);
                } else {
                    set(field, newWeek);
                }
            } else if (newWeek == 1) {
                int week = (fields[day] - ((fields[day] - 1) / 7 * 7) - 1 + mod) / 7 + 1;
                if (week > 1) {
                    set(day, 1);
                } else {
                    set(field, newWeek);
                }
            } else {
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
            if (field == MONTH && fields[DATE] > daysInMonth()) {
                set(DATE, daysInMonth());
            } else if (field == AM_PM) {
                lastTimeFieldSet = HOUR;
            }
            break;
        }
        if (max != -1) {
            set(field, mod(fields[field] - 1 + value, max) + 1);
        }
        complete();
    }

    /**
     * Increments or decrements the specified field and wraps the value of the
     * field when it goes beyond the maximum or minimum value for the current
     * date. Other fields will be adjusted as required to maintain a consistent
     * date. For example, March 31 will roll to April 30 when rolling the month
     * field.
     *
     * @param field
     *            the field to roll.
     * @param increment
     *            {@code true} to increment the field, {@code false} to
     *            decrement.
     * @throws IllegalArgumentException
     *                if an invalid field is specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.444 -0500", hash_original_method = "011BFEF6AF7823592586BFF14A1F0FAF", hash_generated_method = "FE5BCB66CD01CF31C39790EAE8AB2B56")
    
@Override
    public void roll(int field, boolean increment) {
        roll(field, increment ? 1 : -1);
    }

    /**
     * Sets the gregorian change date of this calendar.
     *
     * @param date
     *            a {@code Date} which represents the gregorian change date.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.447 -0500", hash_original_method = "BBA926F39AADCD3D723F5CC72B7A16F3", hash_generated_method = "4AA7C83623817997BC8747FF5A0196F8")
    
public void setGregorianChange(Date date) {
        gregorianCutover = date.getTime();
        GregorianCalendar cal = new GregorianCalendar(TimeZone.GMT);
        cal.setTime(date);
        changeYear = cal.get(YEAR);
        if (cal.get(ERA) == BC) {
            changeYear = 1 - changeYear;
        }
        julianSkew = ((changeYear - 2000) / 400) + julianError()
                - ((changeYear - 2000) / 100);
        isCached = false;
        int dayOfYear = cal.get(DAY_OF_YEAR);
        if (dayOfYear < julianSkew) {
            currentYearSkew = dayOfYear-1;
            lastYearSkew = julianSkew - dayOfYear + 1;
        } else {
            lastYearSkew = 0;
            currentYearSkew = julianSkew;
        }
        isCached = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.449 -0500", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "0D892AC32B11DE8523EBE22E891255E4")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.451 -0500", hash_original_method = "6812E7459A56AAC638E0A1455D3A3623", hash_generated_method = "0244D1DF1EB7DAAD65F12CB1E37D37C9")
    
private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {

        stream.defaultReadObject();
        setGregorianChange(new Date(gregorianCutover));
        isCached = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.454 -0500", hash_original_method = "803EF27234E46811EE9F1109A1277F23", hash_generated_method = "E0B037C32A61FEE0F752C4B043F555ED")
    
@Override
    public void setFirstDayOfWeek(int value) {
        super.setFirstDayOfWeek(value);
        isCached = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:28.456 -0500", hash_original_method = "77A4B23D11FEBAAF4DA5B074DBE88F4F", hash_generated_method = "3B6A66061E8C274F79CCF8B7B203E082")
    
@Override
    public void setMinimalDaysInFirstWeek(int value) {
        super.setMinimalDaysInFirstWeek(value);
        isCached = false;
    }
}

