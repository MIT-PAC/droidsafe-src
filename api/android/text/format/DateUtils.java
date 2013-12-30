package android.text.format;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.android.internal.R;






public class DateUtils {

    /**
     * Return a string for the day of the week.
     * @param dayOfWeek One of {@link Calendar#SUNDAY Calendar.SUNDAY},
     *               {@link Calendar#MONDAY Calendar.MONDAY}, etc.
     * @param abbrev One of {@link #LENGTH_LONG}, {@link #LENGTH_SHORT},
     *               {@link #LENGTH_MEDIUM}, or {@link #LENGTH_SHORTEST}.
     *               Note that in most languages, {@link #LENGTH_SHORT}
     *               will return the same as {@link #LENGTH_MEDIUM}.
     *               Undefined lengths will return {@link #LENGTH_MEDIUM}
     *               but may return something different in the future.
     * @throws IndexOutOfBoundsException if the dayOfWeek is out of bounds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.052 -0500", hash_original_method = "2B2F84D2FC68A393309EA6006B51C303", hash_generated_method = "09A03706A02E74A4C4BE59D52AC288E7")
    
public static String getDayOfWeekString(int dayOfWeek, int abbrev) {
        int[] list;
        switch (abbrev) {
            case LENGTH_LONG:       list = sDaysLong;       break;
            case LENGTH_MEDIUM:     list = sDaysMedium;     break;
            case LENGTH_SHORT:      list = sDaysShort;      break;
            case LENGTH_SHORTER:    list = sDaysShort;      break;
            case LENGTH_SHORTEST:   list = sDaysShortest;   break;
            default:                list = sDaysMedium;     break;
        }

        Resources r = Resources.getSystem();
        return r.getString(list[dayOfWeek - Calendar.SUNDAY]);
    }

    /**
     * Return a localized string for AM or PM.
     * @param ampm Either {@link Calendar#AM Calendar.AM} or {@link Calendar#PM Calendar.PM}.
     * @throws IndexOutOfBoundsException if the ampm is out of bounds.
     * @return Localized version of "AM" or "PM".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.055 -0500", hash_original_method = "6F85B36BD6291771C5AD197E0780281E", hash_generated_method = "57683F9CB095B5840113EBA0DEE32F21")
    
public static String getAMPMString(int ampm) {
        Resources r = Resources.getSystem();
        return r.getString(sAmPm[ampm - Calendar.AM]);
    }

    /**
     * Return a localized string for the month of the year.
     * @param month One of {@link Calendar#JANUARY Calendar.JANUARY},
     *               {@link Calendar#FEBRUARY Calendar.FEBRUARY}, etc.
     * @param abbrev One of {@link #LENGTH_LONG}, {@link #LENGTH_MEDIUM},
     *               or {@link #LENGTH_SHORTEST}.
     *               Undefined lengths will return {@link #LENGTH_MEDIUM}
     *               but may return something different in the future.
     * @return Localized month of the year.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.058 -0500", hash_original_method = "1AFCB2614025096248397B0D897A2A57", hash_generated_method = "C084D88BDC7E2FE5D770222936EC6397")
    
public static String getMonthString(int month, int abbrev) {
        // Note that here we use sMonthsMedium for MEDIUM, SHORT and SHORTER. 
        // This is a shortcut to not spam the translators with too many variations
        // of the same string.  If we find that in a language the distinction
        // is necessary, we can can add more without changing this API.
        int[] list;
        switch (abbrev) {
            case LENGTH_LONG:       list = sMonthsLong;     break;
            case LENGTH_MEDIUM:     list = sMonthsMedium;   break;
            case LENGTH_SHORT:      list = sMonthsMedium;   break;
            case LENGTH_SHORTER:    list = sMonthsMedium;   break;
            case LENGTH_SHORTEST:   list = sMonthsShortest; break;
            default:                list = sMonthsMedium;   break;
        }

        Resources r = Resources.getSystem();
        return r.getString(list[month - Calendar.JANUARY]);
    }

    /**
     * Return a localized string for the month of the year, for
     * contexts where the month is not formatted together with
     * a day of the month.
     *
     * @param month One of {@link Calendar#JANUARY Calendar.JANUARY},
     *               {@link Calendar#FEBRUARY Calendar.FEBRUARY}, etc.
     * @param abbrev One of {@link #LENGTH_LONG}, {@link #LENGTH_MEDIUM},
     *               or {@link #LENGTH_SHORTEST}.
     *               Undefined lengths will return {@link #LENGTH_MEDIUM}
     *               but may return something different in the future.
     * @return Localized month of the year.
     * @hide Pending API council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.061 -0500", hash_original_method = "C99BC873D7A17CFA79867BFC91539165", hash_generated_method = "8360518FFACE4B67B13818239D69B65B")
    
public static String getStandaloneMonthString(int month, int abbrev) {
        // Note that here we use sMonthsMedium for MEDIUM, SHORT and SHORTER. 
        // This is a shortcut to not spam the translators with too many variations
        // of the same string.  If we find that in a language the distinction
        // is necessary, we can can add more without changing this API.
        int[] list;
        switch (abbrev) {
            case LENGTH_LONG:       list = sMonthsStandaloneLong;
                                                            break;
            case LENGTH_MEDIUM:     list = sMonthsMedium;   break;
            case LENGTH_SHORT:      list = sMonthsMedium;   break;
            case LENGTH_SHORTER:    list = sMonthsMedium;   break;
            case LENGTH_SHORTEST:   list = sMonthsShortest; break;
            default:                list = sMonthsMedium;   break;
        }

        Resources r = Resources.getSystem();
        return r.getString(list[month - Calendar.JANUARY]);
    }

    /**
     * Returns a string describing the elapsed time since startTime.
     * @param startTime some time in the past.
     * @return a String object containing the elapsed time.
     * @see #getRelativeTimeSpanString(long, long, long)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.064 -0500", hash_original_method = "1D17ACCAF111CCE023230DB7131552E6", hash_generated_method = "2204A65B4D68212F67FC36D2B19D485F")
    
public static CharSequence getRelativeTimeSpanString(long startTime) {
        return getRelativeTimeSpanString(startTime, System.currentTimeMillis(), MINUTE_IN_MILLIS);
    }

    /**
     * Returns a string describing 'time' as a time relative to 'now'.
     * <p>
     * Time spans in the past are formatted like "42 minutes ago".
     * Time spans in the future are formatted like "in 42 minutes".
     *
     * @param time the time to describe, in milliseconds
     * @param now the current time in milliseconds
     * @param minResolution the minimum timespan to report. For example, a time 3 seconds in the
     *     past will be reported as "0 minutes ago" if this is set to MINUTE_IN_MILLIS. Pass one of
     *     0, MINUTE_IN_MILLIS, HOUR_IN_MILLIS, DAY_IN_MILLIS, WEEK_IN_MILLIS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.067 -0500", hash_original_method = "810BA8C34FC43DE5C93F9EBCCB482C4D", hash_generated_method = "30A52CBE7651B433FAA8CCFB9E744B38")
    
public static CharSequence getRelativeTimeSpanString(long time, long now, long minResolution) {
        int flags = FORMAT_SHOW_DATE | FORMAT_SHOW_YEAR | FORMAT_ABBREV_MONTH;
        return getRelativeTimeSpanString(time, now, minResolution, flags);
    }

    /**
     * Returns a string describing 'time' as a time relative to 'now'.
     * <p>
     * Time spans in the past are formatted like "42 minutes ago". Time spans in
     * the future are formatted like "in 42 minutes".
     * <p>
     * Can use {@link #FORMAT_ABBREV_RELATIVE} flag to use abbreviated relative
     * times, like "42 mins ago".
     * 
     * @param time the time to describe, in milliseconds
     * @param now the current time in milliseconds
     * @param minResolution the minimum timespan to report. For example, a time
     *            3 seconds in the past will be reported as "0 minutes ago" if
     *            this is set to MINUTE_IN_MILLIS. Pass one of 0,
     *            MINUTE_IN_MILLIS, HOUR_IN_MILLIS, DAY_IN_MILLIS,
     *            WEEK_IN_MILLIS
     * @param flags a bit mask of formatting options, such as
     *            {@link #FORMAT_NUMERIC_DATE} or
     *            {@link #FORMAT_ABBREV_RELATIVE}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.071 -0500", hash_original_method = "02D2E61DA71B792A06715C5A90574A1F", hash_generated_method = "9C9BB65D8B7DBDB873F13DB77E6C20D6")
    
public static CharSequence getRelativeTimeSpanString(long time, long now, long minResolution,
            int flags) {
        Resources r = Resources.getSystem();
        boolean abbrevRelative = (flags & (FORMAT_ABBREV_RELATIVE | FORMAT_ABBREV_ALL)) != 0;
        
        boolean past = (now >= time);
        long duration = Math.abs(now - time);

        int resId;
        long count;
        if (duration < MINUTE_IN_MILLIS && minResolution < MINUTE_IN_MILLIS) {
            count = duration / SECOND_IN_MILLIS;
            if (past) {
                if (abbrevRelative) {
                    resId = com.android.internal.R.plurals.abbrev_num_seconds_ago;
                } else {
                    resId = com.android.internal.R.plurals.num_seconds_ago;
                }
            } else {
                if (abbrevRelative) {
                    resId = com.android.internal.R.plurals.abbrev_in_num_seconds;
                } else {
                    resId = com.android.internal.R.plurals.in_num_seconds;
                }
            }
        } else if (duration < HOUR_IN_MILLIS && minResolution < HOUR_IN_MILLIS) {
            count = duration / MINUTE_IN_MILLIS;
            if (past) {
                if (abbrevRelative) {
                    resId = com.android.internal.R.plurals.abbrev_num_minutes_ago;
                } else {
                    resId = com.android.internal.R.plurals.num_minutes_ago;
                }
            } else {
                if (abbrevRelative) {
                    resId = com.android.internal.R.plurals.abbrev_in_num_minutes;
                } else {
                    resId = com.android.internal.R.plurals.in_num_minutes;
                }
            }
        } else if (duration < DAY_IN_MILLIS && minResolution < DAY_IN_MILLIS) {
            count = duration / HOUR_IN_MILLIS;
            if (past) {
                if (abbrevRelative) {
                    resId = com.android.internal.R.plurals.abbrev_num_hours_ago;
                } else {
                    resId = com.android.internal.R.plurals.num_hours_ago;
                }
            } else {
                if (abbrevRelative) {
                    resId = com.android.internal.R.plurals.abbrev_in_num_hours;
                } else {
                    resId = com.android.internal.R.plurals.in_num_hours;
                }
            }
        } else if (duration < WEEK_IN_MILLIS && minResolution < WEEK_IN_MILLIS) {
            count = getNumberOfDaysPassed(time, now);
            if (past) {
                if (abbrevRelative) {
                    resId = com.android.internal.R.plurals.abbrev_num_days_ago;
                } else {
                    resId = com.android.internal.R.plurals.num_days_ago;
                }
            } else {
                if (abbrevRelative) {
                    resId = com.android.internal.R.plurals.abbrev_in_num_days;
                } else {
                    resId = com.android.internal.R.plurals.in_num_days;
                }
            }
        } else {
            // We know that we won't be showing the time, so it is safe to pass
            // in a null context.
            return formatDateRange(null, time, time, flags);
        }

        String format = r.getQuantityString(resId, (int) count);
        return String.format(format, count);
    }
    
    /**
     * Returns the number of days passed between two dates.
     *
     * @param date1 first date
     * @param date2 second date
     * @return number of days passed between to dates.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.074 -0500", hash_original_method = "0E8B24A91185CEAB3D4A07D94FE93D82", hash_generated_method = "096F9CBB8AAFC32DF354327E687413C0")
    
private synchronized static long getNumberOfDaysPassed(long date1, long date2) {
        if (sThenTime == null) {
            sThenTime = new Time();
        }
        sThenTime.set(date1);
        int day1 = Time.getJulianDay(date1, sThenTime.gmtoff);
        sThenTime.set(date2);
        int day2 = Time.getJulianDay(date2, sThenTime.gmtoff);
        return Math.abs(day2 - day1);
    }

    /**
     * Return string describing the elapsed time since startTime formatted like
     * "[relative time/date], [time]".
     * <p>
     * Example output strings for the US date format.
     * <ul>
     * <li>3 mins ago, 10:15 AM</li>
     * <li>yesterday, 12:20 PM</li>
     * <li>Dec 12, 4:12 AM</li>
     * <li>11/14/2007, 8:20 AM</li>
     * </ul>
     * 
     * @param time some time in the past.
     * @param minResolution the minimum elapsed time (in milliseconds) to report
     *            when showing relative times. For example, a time 3 seconds in
     *            the past will be reported as "0 minutes ago" if this is set to
     *            {@link #MINUTE_IN_MILLIS}.
     * @param transitionResolution the elapsed time (in milliseconds) at which
     *            to stop reporting relative measurements. Elapsed times greater
     *            than this resolution will default to normal date formatting.
     *            For example, will transition from "6 days ago" to "Dec 12"
     *            when using {@link #WEEK_IN_MILLIS}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.077 -0500", hash_original_method = "CBEBBC0C0AA9B5B5A899405D0F8BAC67", hash_generated_method = "8C0B50B9CFF672641830D045EEDD5D18")
    
public static CharSequence getRelativeDateTimeString(Context c, long time, long minResolution,
            long transitionResolution, int flags) {
        Resources r = Resources.getSystem();

        long now = System.currentTimeMillis();
        long duration = Math.abs(now - time);

        // getRelativeTimeSpanString() doesn't correctly format relative dates
        // above a week or exact dates below a day, so clamp
        // transitionResolution as needed.
        if (transitionResolution > WEEK_IN_MILLIS) {
            transitionResolution = WEEK_IN_MILLIS;
        } else if (transitionResolution < DAY_IN_MILLIS) {
            transitionResolution = DAY_IN_MILLIS;
        }

        CharSequence timeClause = formatDateRange(c, time, time, FORMAT_SHOW_TIME);
        
        String result;
        if (duration < transitionResolution) {
            CharSequence relativeClause = getRelativeTimeSpanString(time, now, minResolution, flags);
            result = r.getString(com.android.internal.R.string.relative_time, relativeClause, timeClause);
        } else {
            CharSequence dateClause = getRelativeTimeSpanString(c, time, false);
            result = r.getString(com.android.internal.R.string.date_time, dateClause, timeClause);
        }

        return result;
    }

    /**
     * Returns a string describing a day relative to the current day. For example if the day is
     * today this function returns "Today", if the day was a week ago it returns "7 days ago", and
     * if the day is in 2 weeks it returns "in 14 days".
     * 
     * @param r the resources to get the strings from
     * @param day the relative day to describe in UTC milliseconds
     * @param today the current time in UTC milliseconds
     * @return a formatting string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.080 -0500", hash_original_method = "9AC914C306FDB37385F4136987F182E8", hash_generated_method = "AF01706CA36D83D43AA6F0F932E4890F")
    
private static final String getRelativeDayString(Resources r, long day, long today) {
        Time startTime = new Time();
        startTime.set(day);
        Time currentTime = new Time();
        currentTime.set(today);

        int startDay = Time.getJulianDay(day, startTime.gmtoff);
        int currentDay = Time.getJulianDay(today, currentTime.gmtoff);

        int days = Math.abs(currentDay - startDay);
        boolean past = (today > day);
        
        if (days == 1) {
            if (past) {
                return r.getString(com.android.internal.R.string.yesterday);
            } else {
                return r.getString(com.android.internal.R.string.tomorrow);
            }
        } else if (days == 0) {
            return r.getString(com.android.internal.R.string.today);
        }

        int resId;
        if (past) {
            resId = com.android.internal.R.plurals.num_days_ago;
        } else {
            resId = com.android.internal.R.plurals.in_num_days;
        }
        
        String format = r.getQuantityString(resId, days);
        return String.format(format, days);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.083 -0500", hash_original_method = "7C6415570E17C875444543CA7E0BEB8E", hash_generated_method = "B0E4A3FFAFD407125D4A9F7FF76883F5")
    
private static void initFormatStrings() {
        synchronized (sLock) {
            initFormatStringsLocked();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.085 -0500", hash_original_method = "1A7EB517E51BACF861383DCE36CB844C", hash_generated_method = "2FF27538157087A97E783A2E63507DDC")
    
private static void initFormatStringsLocked() {
        Resources r = Resources.getSystem();
        Configuration cfg = r.getConfiguration();
        if (sLastConfig == null || !sLastConfig.equals(cfg)) {
            sLastConfig = cfg;
            sStatusTimeFormat = java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT);
            sElapsedFormatMMSS = r.getString(com.android.internal.R.string.elapsed_time_short_format_mm_ss);
            sElapsedFormatHMMSS = r.getString(com.android.internal.R.string.elapsed_time_short_format_h_mm_ss);
        }
    }

    /**
     * Format a time so it appears like it would in the status bar clock.
     * @deprecated use {@link #DateFormat.getTimeFormat(Context)} instead.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.088 -0500", hash_original_method = "5C7CD09A9243ABC84BD76D8BB04AA3C5", hash_generated_method = "B69FAA21AD101141AF546C1E595C2553")
    
public static final CharSequence timeString(long millis) {
        synchronized (sLock) {
            initFormatStringsLocked();
            return sStatusTimeFormat.format(millis);
        }
    }

    /**
     * Formats an elapsed time in the form "MM:SS" or "H:MM:SS"
     * for display on the call-in-progress screen.
     * @param elapsedSeconds the elapsed time in seconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.098 -0500", hash_original_method = "D0EA86A6CC28EFB8C6A60B32F1D784F7", hash_generated_method = "6BDAA12EB64D2B1485C3C28942198D4D")
    
public static String formatElapsedTime(long elapsedSeconds) {
        return formatElapsedTime(null, elapsedSeconds);
    }
    
    /**
     * Formats an elapsed time in the form "MM:SS" or "H:MM:SS"
     * for display on the call-in-progress screen.
     * 
     * @param recycle {@link StringBuilder} to recycle, if possible
     * @param elapsedSeconds the elapsed time in seconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.102 -0500", hash_original_method = "E6A664B73F10945CFC9983451CADB566", hash_generated_method = "01DEB5F2A93E2DFAFC048D9A5B76AE9C")
    
public static String formatElapsedTime(StringBuilder recycle, long elapsedSeconds) {
        initFormatStrings();

        long hours = 0;
        long minutes = 0;
        long seconds = 0;

        if (elapsedSeconds >= 3600) {
            hours = elapsedSeconds / 3600;
            elapsedSeconds -= hours * 3600;
        }
        if (elapsedSeconds >= 60) {
            minutes = elapsedSeconds / 60;
            elapsedSeconds -= minutes * 60;
        }
        seconds = elapsedSeconds;

        String result;
        if (hours > 0) {
            return formatElapsedTime(recycle, sElapsedFormatHMMSS, hours, minutes, seconds);
        } else {
            return formatElapsedTime(recycle, sElapsedFormatMMSS, minutes, seconds);
        }
    }

    /**
     * Fast formatting of h:mm:ss
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.105 -0500", hash_original_method = "BE434DFF88CE2417ED5025C2BE62DC96", hash_generated_method = "A714873C97139AD9E9871B8DA38FCAE1")
    
private static String formatElapsedTime(StringBuilder recycle, String format, long hours,
            long minutes, long seconds) {
        if (FAST_FORMAT_HMMSS.equals(format)) {
            StringBuilder sb = recycle;
            if (sb == null) {
                sb = new StringBuilder(8);
            } else {
                sb.setLength(0);
            }
            sb.append(hours);
            sb.append(TIME_SEPARATOR);
            if (minutes < 10) { 
                sb.append(TIME_PADDING);
            } else {
                sb.append(toDigitChar(minutes / 10));
            }
            sb.append(toDigitChar(minutes % 10));
            sb.append(TIME_SEPARATOR);
            if (seconds < 10) {
                sb.append(TIME_PADDING);
            } else {
                sb.append(toDigitChar(seconds / 10));
            }
            sb.append(toDigitChar(seconds % 10));
            return sb.toString();
        } else {
            return String.format(format, hours, minutes, seconds);
        }
    }

    /**
     * Fast formatting of m:ss
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.108 -0500", hash_original_method = "CC8D5ED8CB2C3C80437353ABAD2DF566", hash_generated_method = "1A35D553520A52DA0CAD178CDB8F9B9B")
    
private static String formatElapsedTime(StringBuilder recycle, String format, long minutes,
            long seconds) {
        if (FAST_FORMAT_MMSS.equals(format)) {
            StringBuilder sb = recycle;
            if (sb == null) {
                sb = new StringBuilder(8);
            } else {
                sb.setLength(0);
            }
            if (minutes < 10) { 
                sb.append(TIME_PADDING);
            } else {
                sb.append(toDigitChar(minutes / 10));
            }
            sb.append(toDigitChar(minutes % 10));
            sb.append(TIME_SEPARATOR);
            if (seconds < 10) {
                sb.append(TIME_PADDING);
            } else {
                sb.append(toDigitChar(seconds / 10));
            }
            sb.append(toDigitChar(seconds % 10));
            return sb.toString();
        } else {
            return String.format(format, minutes, seconds);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.111 -0500", hash_original_method = "996FF09FDD15BCAB357CDF7A2EFE4B94", hash_generated_method = "5783DC381F39FE347BD4CAFF36CFB877")
    
private static char toDigitChar(long digit) {
        return (char) (digit + '0');
    }
    
    /**
     * Format a date / time such that if the then is on the same day as now, it shows
     * just the time and if it's a different day, it shows just the date.
     * 
     * <p>The parameters dateFormat and timeFormat should each be one of
     * {@link java.text.DateFormat#DEFAULT},
     * {@link java.text.DateFormat#FULL},
     * {@link java.text.DateFormat#LONG},
     * {@link java.text.DateFormat#MEDIUM}
     * or
     * {@link java.text.DateFormat#SHORT}
     *
     * @param then the date to format
     * @param now the base time
     * @param dateStyle how to format the date portion.
     * @param timeStyle how to format the time portion.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.114 -0500", hash_original_method = "06E384656CBC1C1FB3906DD3D7D2CFEF", hash_generated_method = "858E3A67AB48F51DA3A01A5BE1B701C3")
    
public static final CharSequence formatSameDayTime(long then, long now,
            int dateStyle, int timeStyle) {
        Calendar thenCal = new GregorianCalendar();
        thenCal.setTimeInMillis(then);
        Date thenDate = thenCal.getTime();
        Calendar nowCal = new GregorianCalendar();
        nowCal.setTimeInMillis(now);

        java.text.DateFormat f;

        if (thenCal.get(Calendar.YEAR) == nowCal.get(Calendar.YEAR)
                && thenCal.get(Calendar.MONTH) == nowCal.get(Calendar.MONTH)
                && thenCal.get(Calendar.DAY_OF_MONTH) == nowCal.get(Calendar.DAY_OF_MONTH)) {
            f = java.text.DateFormat.getTimeInstance(timeStyle);
        } else {
            f = java.text.DateFormat.getDateInstance(dateStyle);
        }
        return f.format(thenDate);
    }

    /**
     * @hide
     * @deprecated use {@link android.text.format.Time}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.116 -0500", hash_original_method = "6FC2FF787482B00C1ED28540B9D79D25", hash_generated_method = "B603065CFB6080317A06C068D90FEF02")
    
public static Calendar newCalendar(boolean zulu)
    {
        if (zulu)
            return Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        return Calendar.getInstance();
    }

    /**
     * @return true if the supplied when is today else false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.119 -0500", hash_original_method = "BCBEFB19F695AD30621394F70B29C099", hash_generated_method = "63E341009367C2831E3CBC92EAD5E19D")
    
public static boolean isToday(long when) {
        Time time = new Time();
        time.set(when);
        
        int thenYear = time.year;
        int thenMonth = time.month;
        int thenMonthDay = time.monthDay;

        time.set(System.currentTimeMillis());
        return (thenYear == time.year)
                && (thenMonth == time.month) 
                && (thenMonthDay == time.monthDay);
    }

    /**
     * @hide
     * @deprecated use {@link android.text.format.Time}
     * Return true if this date string is local time
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.122 -0500", hash_original_method = "10084A132F682ED9F3933E48366097FD", hash_generated_method = "E8D02453DE7BCBA4A45C13F324EE1F44")
    
public static boolean isUTC(String s)
    {
        if (s.length() == 16 && s.charAt(15) == 'Z') {
            return true;
        }
        if (s.length() == 9 && s.charAt(8) == 'Z') {
            // XXX not sure if this case possible/valid
            return true;
        }
        return false;
    }

    /**
     * Return a string containing the date and time in RFC2445 format.
     * Ensures that the time is written in UTC.  The Calendar class doesn't
     * really help out with this, so this is slower than it ought to be.
     *
     * @param cal the date and time to write
     * @hide
     * @deprecated use {@link android.text.format.Time}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.125 -0500", hash_original_method = "4C81A08F59ACE9D4E0294DB069346160", hash_generated_method = "AB892100D0FF299C9A57061325B5ABD7")
    
public static String writeDateTime(Calendar cal)
    {
        TimeZone tz = TimeZone.getTimeZone("GMT");
        GregorianCalendar c = new GregorianCalendar(tz);
        c.setTimeInMillis(cal.getTimeInMillis());
        return writeDateTime(c, true);
    }

    /**
     * Return a string containing the date and time in RFC2445 format.
     *
     * @param cal the date and time to write
     * @param zulu If the calendar is in UTC, pass true, and a Z will
     * be written at the end as per RFC2445.  Otherwise, the time is
     * considered in localtime.
     * @hide
     * @deprecated use {@link android.text.format.Time}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.127 -0500", hash_original_method = "F5B26D6CEA03C69B6056609DE60A7792", hash_generated_method = "AE416BA4BB2E6B01C869A36E21DEDEE2")
    
public static String writeDateTime(Calendar cal, boolean zulu)
    {
        StringBuilder sb = new StringBuilder();
        sb.ensureCapacity(16);
        if (zulu) {
            sb.setLength(16);
            sb.setCharAt(15, 'Z');
        } else {
            sb.setLength(15);
        }
        return writeDateTime(cal, sb);
    }

    /**
     * Return a string containing the date and time in RFC2445 format.
     *
     * @param cal the date and time to write
     * @param sb a StringBuilder to use.  It is assumed that setLength
     *           has already been called on sb to the appropriate length
     *           which is sb.setLength(zulu ? 16 : 15)
     * @hide
     * @deprecated use {@link android.text.format.Time}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.130 -0500", hash_original_method = "BD44C4716A0E3FC25053D312996F500E", hash_generated_method = "BDC6CE66737DE329DDD2B2D5AEA45D4E")
    
public static String writeDateTime(Calendar cal, StringBuilder sb)
    {
        int n;
       
        n = cal.get(Calendar.YEAR);
        sb.setCharAt(3, (char)('0'+n%10));
        n /= 10;
        sb.setCharAt(2, (char)('0'+n%10));
        n /= 10;
        sb.setCharAt(1, (char)('0'+n%10));
        n /= 10;
        sb.setCharAt(0, (char)('0'+n%10));

        n = cal.get(Calendar.MONTH) + 1;
        sb.setCharAt(5, (char)('0'+n%10));
        n /= 10;
        sb.setCharAt(4, (char)('0'+n%10));

        n = cal.get(Calendar.DAY_OF_MONTH);
        sb.setCharAt(7, (char)('0'+n%10));
        n /= 10;
        sb.setCharAt(6, (char)('0'+n%10));

        sb.setCharAt(8, 'T');

        n = cal.get(Calendar.HOUR_OF_DAY);
        sb.setCharAt(10, (char)('0'+n%10));
        n /= 10;
        sb.setCharAt(9, (char)('0'+n%10));

        n = cal.get(Calendar.MINUTE);
        sb.setCharAt(12, (char)('0'+n%10));
        n /= 10;
        sb.setCharAt(11, (char)('0'+n%10));

        n = cal.get(Calendar.SECOND);
        sb.setCharAt(14, (char)('0'+n%10));
        n /= 10;
        sb.setCharAt(13, (char)('0'+n%10));

        return sb.toString();
    }

    /**
     * @hide
     * @deprecated use {@link android.text.format.Time}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.133 -0500", hash_original_method = "76C82D1EFB5A0BE18C12D577CE4D9227", hash_generated_method = "67240239E6400BA87389BA492BB7F4B7")
    
public static void assign(Calendar lval, Calendar rval)
    {
        // there should be a faster way.
        lval.clear();
        lval.setTimeInMillis(rval.getTimeInMillis());
    }

    /**
     * Formats a date or a time range according to the local conventions.
     * <p>
     * Note that this is a convenience method. Using it involves creating an
     * internal {@link java.util.Formatter} instance on-the-fly, which is
     * somewhat costly in terms of memory and time. This is probably acceptable
     * if you use the method only rarely, but if you rely on it for formatting a
     * large number of dates, consider creating and reusing your own
     * {@link java.util.Formatter} instance and use the version of
     * {@link #formatDateRange(Context, long, long, int) formatDateRange}
     * that takes a {@link java.util.Formatter}.
     *
     * @param context the context is required only if the time is shown
     * @param startMillis the start time in UTC milliseconds
     * @param endMillis the end time in UTC milliseconds
     * @param flags a bit mask of options See
     * {@link #formatDateRange(Context, Formatter, long, long, int, String) formatDateRange}
     * @return a string containing the formatted date/time range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.136 -0500", hash_original_method = "5BA7A7B1E96B568F9A0E77807F1C78CA", hash_generated_method = "1FD909086414B099B53F7D92BBCA13EA")
    
public static String formatDateRange(Context context, long startMillis,
            long endMillis, int flags) {
        Formatter f = new Formatter(new StringBuilder(50), Locale.getDefault());
        return formatDateRange(context, f, startMillis, endMillis, flags).toString();
    }

    /**
     * Formats a date or a time range according to the local conventions.
     * <p>
     * Note that this is a convenience method for formatting the date or
     * time range in the local time zone. If you want to specify the time
     * zone please use
     * {@link #formatDateRange(Context, Formatter, long, long, int, String) formatDateRange}.
     *
     * @param context the context is required only if the time is shown
     * @param formatter the Formatter used for formatting the date range.
     * Note: be sure to call setLength(0) on StringBuilder passed to
     * the Formatter constructor unless you want the results to accumulate.
     * @param startMillis the start time in UTC milliseconds
     * @param endMillis the end time in UTC milliseconds
     * @param flags a bit mask of options See
     * {@link #formatDateRange(Context, Formatter, long, long, int, String) formatDateRange}
     * @return a string containing the formatted date/time range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.139 -0500", hash_original_method = "E872D5914238ECC5887A5B447D659373", hash_generated_method = "9825CA7DEF874ED0CE56383290D32786")
    
public static Formatter formatDateRange(Context context, Formatter formatter, long startMillis,
            long endMillis, int flags) {
        return formatDateRange(context, formatter, startMillis, endMillis, flags, null);
    }

    /**
     * Formats a date or a time range according to the local conventions.
     * 
     * <p>
     * Example output strings (date formats in these examples are shown using
     * the US date format convention but that may change depending on the
     * local settings):
     * <ul>
     *   <li>10:15am</li>
     *   <li>3:00pm - 4:00pm</li>
     *   <li>3pm - 4pm</li>
     *   <li>3PM - 4PM</li>
     *   <li>08:00 - 17:00</li>
     *   <li>Oct 9</li>
     *   <li>Tue, Oct 9</li>
     *   <li>October 9, 2007</li>
     *   <li>Oct 9 - 10</li>
     *   <li>Oct 9 - 10, 2007</li>
     *   <li>Oct 28 - Nov 3, 2007</li>
     *   <li>Dec 31, 2007 - Jan 1, 2008</li>
     *   <li>Oct 9, 8:00am - Oct 10, 5:00pm</li>
     *   <li>12/31/2007 - 01/01/2008</li>
     * </ul>
     * 
     * <p>
     * The flags argument is a bitmask of options from the following list:
     * 
     * <ul>
     *   <li>FORMAT_SHOW_TIME</li>
     *   <li>FORMAT_SHOW_WEEKDAY</li>
     *   <li>FORMAT_SHOW_YEAR</li>
     *   <li>FORMAT_NO_YEAR</li>
     *   <li>FORMAT_SHOW_DATE</li>
     *   <li>FORMAT_NO_MONTH_DAY</li>
     *   <li>FORMAT_12HOUR</li>
     *   <li>FORMAT_24HOUR</li>
     *   <li>FORMAT_CAP_AMPM</li>
     *   <li>FORMAT_NO_NOON</li>
     *   <li>FORMAT_CAP_NOON</li>
     *   <li>FORMAT_NO_MIDNIGHT</li>
     *   <li>FORMAT_CAP_MIDNIGHT</li>
     *   <li>FORMAT_UTC</li>
     *   <li>FORMAT_ABBREV_TIME</li>
     *   <li>FORMAT_ABBREV_WEEKDAY</li>
     *   <li>FORMAT_ABBREV_MONTH</li>
     *   <li>FORMAT_ABBREV_ALL</li>
     *   <li>FORMAT_NUMERIC_DATE</li>
     * </ul>
     * 
     * <p>
     * If FORMAT_SHOW_TIME is set, the time is shown as part of the date range.
     * If the start and end time are the same, then just the start time is
     * shown.
     * 
     * <p>
     * If FORMAT_SHOW_WEEKDAY is set, then the weekday is shown.
     * 
     * <p>
     * If FORMAT_SHOW_YEAR is set, then the year is always shown.
     * If FORMAT_NO_YEAR is set, then the year is not shown.
     * If neither FORMAT_SHOW_YEAR nor FORMAT_NO_YEAR are set, then the year
     * is shown only if it is different from the current year, or if the start
     * and end dates fall on different years.  If both are set,
     * FORMAT_SHOW_YEAR takes precedence.
     *
     * <p>
     * Normally the date is shown unless the start and end day are the same.
     * If FORMAT_SHOW_DATE is set, then the date is always shown, even for
     * same day ranges.
     * 
     * <p>
     * If FORMAT_NO_MONTH_DAY is set, then if the date is shown, just the
     * month name will be shown, not the day of the month.  For example,
     * "January, 2008" instead of "January 6 - 12, 2008".
     * 
     * <p>
     * If FORMAT_CAP_AMPM is set and 12-hour time is used, then the "AM"
     * and "PM" are capitalized.  You should not use this flag
     * because in some locales these terms cannot be capitalized, and in
     * many others it doesn't make sense to do so even though it is possible.
     * 
     * <p>
     * If FORMAT_NO_NOON is set and 12-hour time is used, then "12pm" is
     * shown instead of "noon".
     * 
     * <p>
     * If FORMAT_CAP_NOON is set and 12-hour time is used, then "Noon" is
     * shown instead of "noon".  You should probably not use this flag
     * because in many locales it will not make sense to capitalize
     * the term.
     * 
     * <p>
     * If FORMAT_NO_MIDNIGHT is set and 12-hour time is used, then "12am" is
     * shown instead of "midnight".
     * 
     * <p>
     * If FORMAT_CAP_MIDNIGHT is set and 12-hour time is used, then "Midnight"
     * is shown instead of "midnight".  You should probably not use this
     * flag because in many locales it will not make sense to capitalize
     * the term.
     * 
     * <p>
     * If FORMAT_12HOUR is set and the time is shown, then the time is
     * shown in the 12-hour time format. You should not normally set this.
     * Instead, let the time format be chosen automatically according to the
     * system settings. If both FORMAT_12HOUR and FORMAT_24HOUR are set, then
     * FORMAT_24HOUR takes precedence.
     * 
     * <p>
     * If FORMAT_24HOUR is set and the time is shown, then the time is
     * shown in the 24-hour time format. You should not normally set this.
     * Instead, let the time format be chosen automatically according to the
     * system settings. If both FORMAT_12HOUR and FORMAT_24HOUR are set, then
     * FORMAT_24HOUR takes precedence.
     * 
     * <p>
     * If FORMAT_UTC is set, then the UTC time zone is used for the start
     * and end milliseconds unless a time zone is specified. If a time zone
     * is specified it will be used regardless of the FORMAT_UTC flag.
     * 
     * <p>
     * If FORMAT_ABBREV_TIME is set and 12-hour time format is used, then the
     * start and end times (if shown) are abbreviated by not showing the minutes
     * if they are zero.  For example, instead of "3:00pm" the time would be
     * abbreviated to "3pm".
     * 
     * <p>
     * If FORMAT_ABBREV_WEEKDAY is set, then the weekday (if shown) is
     * abbreviated to a 3-letter string.
     * 
     * <p>
     * If FORMAT_ABBREV_MONTH is set, then the month (if shown) is abbreviated
     * to a 3-letter string.
     * 
     * <p>
     * If FORMAT_ABBREV_ALL is set, then the weekday and the month (if shown)
     * are abbreviated to 3-letter strings.
     * 
     * <p>
     * If FORMAT_NUMERIC_DATE is set, then the date is shown in numeric format
     * instead of using the name of the month.  For example, "12/31/2008"
     * instead of "December 31, 2008".
     * 
     * @param context the context is required only if the time is shown
     * @param formatter the Formatter used for formatting the date range.
     * Note: be sure to call setLength(0) on StringBuilder passed to
     * the Formatter constructor unless you want the results to accumulate.
     * @param startMillis the start time in UTC milliseconds
     * @param endMillis the end time in UTC milliseconds
     * @param flags a bit mask of options
     * @param timeZone the time zone to compute the string in. Use null for local
     * or if the FORMAT_UTC flag is being used.
     *  
     * @return the formatter with the formatted date/time range appended to the string buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.148 -0500", hash_original_method = "8CB3016823DC727CE96A9F34A7CC13A4", hash_generated_method = "5A20A63F96B1A47B139B807B81054F73")
    
public static Formatter formatDateRange(Context context, Formatter formatter, long startMillis,
            long endMillis, int flags, String timeZone) {
        Resources res = Resources.getSystem();
        boolean showTime = (flags & FORMAT_SHOW_TIME) != 0;
        boolean showWeekDay = (flags & FORMAT_SHOW_WEEKDAY) != 0;
        boolean showYear = (flags & FORMAT_SHOW_YEAR) != 0;
        boolean noYear = (flags & FORMAT_NO_YEAR) != 0;
        boolean useUTC = (flags & FORMAT_UTC) != 0;
        boolean abbrevWeekDay = (flags & (FORMAT_ABBREV_WEEKDAY | FORMAT_ABBREV_ALL)) != 0;
        boolean abbrevMonth = (flags & (FORMAT_ABBREV_MONTH | FORMAT_ABBREV_ALL)) != 0;
        boolean noMonthDay = (flags & FORMAT_NO_MONTH_DAY) != 0;
        boolean numericDate = (flags & FORMAT_NUMERIC_DATE) != 0;

        // If we're getting called with a single instant in time (from
        // e.g. formatDateTime(), below), then we can skip a lot of
        // computation below that'd otherwise be thrown out.
        boolean isInstant = (startMillis == endMillis);

        Time startDate;
        if (timeZone != null) {
            startDate = new Time(timeZone);
        } else if (useUTC) {
            startDate = new Time(Time.TIMEZONE_UTC);
        } else {
            startDate = new Time();
        }
        startDate.set(startMillis);

        Time endDate;
        int dayDistance;
        if (isInstant) {
            endDate = startDate;
            dayDistance = 0;
        } else {
            if (timeZone != null) {
                endDate = new Time(timeZone);
            } else if (useUTC) {
                endDate = new Time(Time.TIMEZONE_UTC);
            } else {
                endDate = new Time();
            }
            endDate.set(endMillis);
            int startJulianDay = Time.getJulianDay(startMillis, startDate.gmtoff);
            int endJulianDay = Time.getJulianDay(endMillis, endDate.gmtoff);
            dayDistance = endJulianDay - startJulianDay;
        }

        // If the end date ends at 12am at the beginning of a day,
        // then modify it to make it look like it ends at midnight on
        // the previous day.  This will allow us to display "8pm - midnight",
        // for example, instead of "Nov 10, 8pm - Nov 11, 12am". But we only do
        // this if it is midnight of the same day as the start date because
        // for multiple-day events, an end time of "midnight on Nov 11" is
        // ambiguous and confusing (is that midnight the start of Nov 11, or
        // the end of Nov 11?).
        // If we are not showing the time then also adjust the end date
        // for multiple-day events.  This is to allow us to display, for
        // example, "Nov 10 -11" for an event with a start date of Nov 10
        // and an end date of Nov 12 at 00:00.
        // If the start and end time are the same, then skip this and don't
        // adjust the date.
        if (!isInstant
            && (endDate.hour | endDate.minute | endDate.second) == 0
            && (!showTime || dayDistance <= 1)) {
            endDate.monthDay -= 1;
            endDate.normalize(true /* ignore isDst */);
        }

        int startDay = startDate.monthDay;
        int startMonthNum = startDate.month;
        int startYear = startDate.year;

        int endDay = endDate.monthDay;
        int endMonthNum = endDate.month;
        int endYear = endDate.year;

        String startWeekDayString = "";
        String endWeekDayString = "";
        if (showWeekDay) {
            String weekDayFormat = "";
            if (abbrevWeekDay) {
                weekDayFormat = ABBREV_WEEKDAY_FORMAT;
            } else {
                weekDayFormat = WEEKDAY_FORMAT;
            }
            startWeekDayString = startDate.format(weekDayFormat);
            endWeekDayString = isInstant ? startWeekDayString : endDate.format(weekDayFormat);
        }

        String startTimeString = "";
        String endTimeString = "";
        if (showTime) {
            String startTimeFormat = "";
            String endTimeFormat = "";
            boolean force24Hour = (flags & FORMAT_24HOUR) != 0;
            boolean force12Hour = (flags & FORMAT_12HOUR) != 0;
            boolean use24Hour;
            if (force24Hour) {
                use24Hour = true;
            } else if (force12Hour) {
                use24Hour = false;
            } else {
                use24Hour = DateFormat.is24HourFormat(context);
            }
            if (use24Hour) {
                startTimeFormat = endTimeFormat =
                    res.getString(com.android.internal.R.string.hour_minute_24);
            } else {
                boolean abbrevTime = (flags & (FORMAT_ABBREV_TIME | FORMAT_ABBREV_ALL)) != 0;
                boolean capAMPM = (flags & FORMAT_CAP_AMPM) != 0;
                boolean noNoon = (flags & FORMAT_NO_NOON) != 0;
                boolean capNoon = (flags & FORMAT_CAP_NOON) != 0;
                boolean noMidnight = (flags & FORMAT_NO_MIDNIGHT) != 0;
                boolean capMidnight = (flags & FORMAT_CAP_MIDNIGHT) != 0;

                boolean startOnTheHour = startDate.minute == 0 && startDate.second == 0;
                boolean endOnTheHour = endDate.minute == 0 && endDate.second == 0;
                if (abbrevTime && startOnTheHour) {
                    if (capAMPM) {
                        startTimeFormat = res.getString(com.android.internal.R.string.hour_cap_ampm);
                    } else {
                        startTimeFormat = res.getString(com.android.internal.R.string.hour_ampm);
                    }
                } else {
                    if (capAMPM) {
                        startTimeFormat = res.getString(com.android.internal.R.string.hour_minute_cap_ampm);
                    } else {
                        startTimeFormat = res.getString(com.android.internal.R.string.hour_minute_ampm);
                    }
                }

                // Don't waste time on setting endTimeFormat when
                // we're dealing with an instant, where we'll never
                // need the end point.  (It's the same as the start
                // point)
                if (!isInstant) {
                    if (abbrevTime && endOnTheHour) {
                        if (capAMPM) {
                            endTimeFormat = res.getString(com.android.internal.R.string.hour_cap_ampm);
                        } else {
                            endTimeFormat = res.getString(com.android.internal.R.string.hour_ampm);
                        }
                    } else {
                        if (capAMPM) {
                            endTimeFormat = res.getString(com.android.internal.R.string.hour_minute_cap_ampm);
                        } else {
                            endTimeFormat = res.getString(com.android.internal.R.string.hour_minute_ampm);
                        }
                    }

                    if (endDate.hour == 12 && endOnTheHour && !noNoon) {
                        if (capNoon) {
                            endTimeFormat = res.getString(com.android.internal.R.string.Noon);
                        } else {
                            endTimeFormat = res.getString(com.android.internal.R.string.noon);
                        }
                    } else if (endDate.hour == 0 && endOnTheHour && !noMidnight) {
                        if (capMidnight) {
                            endTimeFormat = res.getString(com.android.internal.R.string.Midnight);
                        } else {
                            endTimeFormat = res.getString(com.android.internal.R.string.midnight);
                        }
                    }
                }

                if (startDate.hour == 12 && startOnTheHour && !noNoon) {
                    if (capNoon) {
                        startTimeFormat = res.getString(com.android.internal.R.string.Noon);
                    } else {
                        startTimeFormat = res.getString(com.android.internal.R.string.noon);
                    }
                    // Don't show the start time starting at midnight.  Show
                    // 12am instead.
                }
            }

            startTimeString = startDate.format(startTimeFormat);
            endTimeString = isInstant ? startTimeString : endDate.format(endTimeFormat);
        }

        // Show the year if the user specified FORMAT_SHOW_YEAR or if
        // the starting and end years are different from each other
        // or from the current year.  But don't show the year if the
        // user specified FORMAT_NO_YEAR.
        if (showYear) {
            // No code... just a comment for clarity.  Keep showYear
            // on, as they enabled it with FORMAT_SHOW_YEAR.  This
            // takes precedence over them setting FORMAT_NO_YEAR.
        } else if (noYear) {
            // They explicitly didn't want a year.
            showYear = false;
        } else if (startYear != endYear) {
            showYear = true;
        } else {
            // Show the year if it's not equal to the current year.
            Time currentTime = new Time();
            currentTime.setToNow();
            showYear = startYear != currentTime.year;
        }

        String defaultDateFormat, fullFormat, dateRange;
        if (numericDate) {
            defaultDateFormat = res.getString(com.android.internal.R.string.numeric_date);
        } else if (showYear) {
            if (abbrevMonth) {
                if (noMonthDay) {
                    defaultDateFormat = res.getString(com.android.internal.R.string.abbrev_month_year);
                } else {
                    defaultDateFormat = res.getString(com.android.internal.R.string.abbrev_month_day_year);
                }
            } else {
                if (noMonthDay) {
                    defaultDateFormat = res.getString(com.android.internal.R.string.month_year);
                } else {
                    defaultDateFormat = res.getString(com.android.internal.R.string.month_day_year);
                }
            }
        } else {
            if (abbrevMonth) {
                if (noMonthDay) {
                    defaultDateFormat = res.getString(com.android.internal.R.string.abbrev_month);
                } else {
                    defaultDateFormat = res.getString(com.android.internal.R.string.abbrev_month_day);
                }
            } else {
                if (noMonthDay) {
                    defaultDateFormat = res.getString(com.android.internal.R.string.month);
                } else {
                    defaultDateFormat = res.getString(com.android.internal.R.string.month_day);
                }
            }
        }

        if (showWeekDay) {
            if (showTime) {
                fullFormat = res.getString(com.android.internal.R.string.wday1_date1_time1_wday2_date2_time2);
            } else {
                fullFormat = res.getString(com.android.internal.R.string.wday1_date1_wday2_date2);
            }
        } else {
            if (showTime) {
                fullFormat = res.getString(com.android.internal.R.string.date1_time1_date2_time2);
            } else {
                fullFormat = res.getString(com.android.internal.R.string.date1_date2);
            }
        }

        if (noMonthDay && startMonthNum == endMonthNum && startYear == endYear) {
            // Example: "January, 2008"
            return formatter.format("%s", startDate.format(defaultDateFormat));
        }

        if (startYear != endYear || noMonthDay) {
            // Different year or we are not showing the month day number.
            // Example: "December 31, 2007 - January 1, 2008"
            // Or: "January - February, 2008"
            String startDateString = startDate.format(defaultDateFormat);
            String endDateString = endDate.format(defaultDateFormat);

            // The values that are used in a fullFormat string are specified
            // by position.
            return formatter.format(fullFormat,
                    startWeekDayString, startDateString, startTimeString,
                    endWeekDayString, endDateString, endTimeString);
        }

        // Get the month, day, and year strings for the start and end dates
        String monthFormat;
        if (numericDate) {
            monthFormat = NUMERIC_MONTH_FORMAT;
        } else if (abbrevMonth) {
            monthFormat =
                res.getString(com.android.internal.R.string.short_format_month);
        } else {
            monthFormat = MONTH_FORMAT;
        }
        String startMonthString = startDate.format(monthFormat);
        String startMonthDayString = startDate.format(MONTH_DAY_FORMAT);
        String startYearString = startDate.format(YEAR_FORMAT);

        String endMonthString = isInstant ? null : endDate.format(monthFormat);
        String endMonthDayString = isInstant ? null : endDate.format(MONTH_DAY_FORMAT);
        String endYearString = isInstant ? null : endDate.format(YEAR_FORMAT);

        if (startMonthNum != endMonthNum) {
            // Same year, different month.
            // Example: "October 28 - November 3"
            // or: "Wed, Oct 31 - Sat, Nov 3, 2007"
            // or: "Oct 31, 8am - Sat, Nov 3, 2007, 5pm"

            int index = 0;
            if (showWeekDay) index = 1;
            if (showYear) index += 2;
            if (showTime) index += 4;
            if (numericDate) index += 8;
            int resId = sameYearTable[index];
            fullFormat = res.getString(resId);

            // The values that are used in a fullFormat string are specified
            // by position.
            return formatter.format(fullFormat,
                    startWeekDayString, startMonthString, startMonthDayString,
                    startYearString, startTimeString,
                    endWeekDayString, endMonthString, endMonthDayString,
                    endYearString, endTimeString);
        }

        if (startDay != endDay) {
            // Same month, different day.
            int index = 0;
            if (showWeekDay) index = 1;
            if (showYear) index += 2;
            if (showTime) index += 4;
            if (numericDate) index += 8;
            int resId = sameMonthTable[index];
            fullFormat = res.getString(resId);

            // The values that are used in a fullFormat string are specified
            // by position.
            return formatter.format(fullFormat,
                    startWeekDayString, startMonthString, startMonthDayString,
                    startYearString, startTimeString,
                    endWeekDayString, endMonthString, endMonthDayString,
                    endYearString, endTimeString);
        }

        // Same start and end day
        boolean showDate = (flags & FORMAT_SHOW_DATE) != 0;

        // If nothing was specified, then show the date.
        if (!showTime && !showDate && !showWeekDay) showDate = true;

        // Compute the time string (example: "10:00 - 11:00 am")
        String timeString = "";
        if (showTime) {
            // If the start and end time are the same, then just show the
            // start time.
            if (isInstant) {
                // Same start and end time.
                // Example: "10:15 AM"
                timeString = startTimeString;
            } else {
                // Example: "10:00 - 11:00 am"
                String timeFormat = res.getString(com.android.internal.R.string.time1_time2);
                // Don't use the user supplied Formatter because the result will pollute the buffer.
                timeString = String.format(timeFormat, startTimeString, endTimeString);
            }
        }

        // Figure out which full format to use.
        fullFormat = "";
        String dateString = "";
        if (showDate) {
            dateString = startDate.format(defaultDateFormat);
            if (showWeekDay) {
                if (showTime) {
                    // Example: "10:00 - 11:00 am, Tue, Oct 9"
                    fullFormat = res.getString(com.android.internal.R.string.time_wday_date);
                } else {
                    // Example: "Tue, Oct 9"
                    fullFormat = res.getString(com.android.internal.R.string.wday_date);
                }
            } else {
                if (showTime) {
                    // Example: "10:00 - 11:00 am, Oct 9"
                    fullFormat = res.getString(com.android.internal.R.string.time_date);
                } else {
                    // Example: "Oct 9"
                    return formatter.format("%s", dateString);
                }
            }
        } else if (showWeekDay) {
            if (showTime) {
                // Example: "10:00 - 11:00 am, Tue"
                fullFormat = res.getString(com.android.internal.R.string.time_wday);
            } else {
                // Example: "Tue"
                return formatter.format("%s", startWeekDayString);
            }
        } else if (showTime) {
            return formatter.format("%s", timeString);
        }

        // The values that are used in a fullFormat string are specified
        // by position.
        return formatter.format(fullFormat, timeString, startWeekDayString, dateString);
    }

    /**
     * Formats a date or a time according to the local conventions. There are
     * lots of options that allow the caller to control, for example, if the
     * time is shown, if the day of the week is shown, if the month name is
     * abbreviated, if noon is shown instead of 12pm, and so on. For the
     * complete list of options, see the documentation for
     * {@link #formatDateRange}.
     * <p>
     * Example output strings (date formats in these examples are shown using
     * the US date format convention but that may change depending on the
     * local settings):
     * <ul>
     *   <li>10:15am</li>
     *   <li>3:00pm</li>
     *   <li>3pm</li>
     *   <li>3PM</li>
     *   <li>08:00</li>
     *   <li>17:00</li>
     *   <li>noon</li>
     *   <li>Noon</li>
     *   <li>midnight</li>
     *   <li>Midnight</li>
     *   <li>Oct 31</li>
     *   <li>Oct 31, 2007</li>
     *   <li>October 31, 2007</li>
     *   <li>10am, Oct 31</li>
     *   <li>17:00, Oct 31</li>
     *   <li>Wed</li>
     *   <li>Wednesday</li>
     *   <li>10am, Wed, Oct 31</li>
     *   <li>Wed, Oct 31</li>
     *   <li>Wednesday, Oct 31</li>
     *   <li>Wed, Oct 31, 2007</li>
     *   <li>Wed, October 31</li>
     *   <li>10/31/2007</li>
     * </ul>
     * 
     * @param context the context is required only if the time is shown
     * @param millis a point in time in UTC milliseconds
     * @param flags a bit mask of formatting options
     * @return a string containing the formatted date/time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.151 -0500", hash_original_method = "40048A0916DFE1A9CFC219167424AF4B", hash_generated_method = "CABF73F43CFEEE0590001DE2A5285770")
    
public static String formatDateTime(Context context, long millis, int flags) {
        return formatDateRange(context, millis, millis, flags);
    }

    /**
     * @return a relative time string to display the time expressed by millis.  Times
     * are counted starting at midnight, which means that assuming that the current
     * time is March 31st, 0:30:
     * <ul>
     *   <li>"millis=0:10 today" will be displayed as "0:10"</li> 
     *   <li>"millis=11:30pm the day before" will be displayed as "Mar 30"</li>
     * </ul>
     * If the given millis is in a different year, then the full date is
     * returned in numeric format (e.g., "10/12/2008").
     * 
     * @param withPreposition If true, the string returned will include the correct 
     * preposition ("at 9:20am", "on 10/12/2008" or "on May 29").
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.156 -0500", hash_original_method = "B98A7B20DE64F8A0743D9F388930FDE8", hash_generated_method = "5CCF661DE6AB443130309C4C6F8DFBD4")
    
public static CharSequence getRelativeTimeSpanString(Context c, long millis,
            boolean withPreposition) {

        String result;
        long now = System.currentTimeMillis();
        long span = now - millis;

        synchronized (DateUtils.class) {
            if (sNowTime == null) {
                sNowTime = new Time();
            }

            if (sThenTime == null) {
                sThenTime = new Time();
            }

            sNowTime.set(now);
            sThenTime.set(millis);

            int prepositionId;
            if (span < DAY_IN_MILLIS && sNowTime.weekDay == sThenTime.weekDay) {
                // Same day
                int flags = FORMAT_SHOW_TIME;
                result = formatDateRange(c, millis, millis, flags);
                prepositionId = R.string.preposition_for_time;
            } else if (sNowTime.year != sThenTime.year) {
                // Different years
                int flags = FORMAT_SHOW_DATE | FORMAT_SHOW_YEAR | FORMAT_NUMERIC_DATE;
                result = formatDateRange(c, millis, millis, flags);

                // This is a date (like "10/31/2008" so use the date preposition)
                prepositionId = R.string.preposition_for_date;
            } else {
                // Default
                int flags = FORMAT_SHOW_DATE | FORMAT_ABBREV_MONTH;
                result = formatDateRange(c, millis, millis, flags);
                prepositionId = R.string.preposition_for_date;
            }
            if (withPreposition) {
                Resources res = c.getResources();
                result = res.getString(prepositionId, result);
            }
        }
        return result;
    }
    
    /**
     * Convenience function to return relative time string without preposition. 
     * @param c context for resources
     * @param millis time in milliseconds
     * @return {@link CharSequence} containing relative time.
     * @see #getRelativeTimeSpanString(Context, long, boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.158 -0500", hash_original_method = "362BB89AE30E2B1620FB7746D71D6A23", hash_generated_method = "7F279C628C2CE3542A823A9ABCB8A086")
    
public static CharSequence getRelativeTimeSpanString(Context c, long millis) {
        return getRelativeTimeSpanString(c, millis, false /* no preposition */);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.878 -0500", hash_original_field = "3892ABA92B7F95295E8CFDAE8B79791E", hash_generated_field = "BDCA99E42BC506D141E07BE230771AE3")

    private static final Object sLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.882 -0500", hash_original_field = "533DF481F9908FCA1A2CC8479B5D64EE", hash_generated_field = "5AE502B95436A2049A07BE1AB861371A")

    private static final int[] sDaysLong = new int[] {
            com.android.internal.R.string.day_of_week_long_sunday,
            com.android.internal.R.string.day_of_week_long_monday,
            com.android.internal.R.string.day_of_week_long_tuesday,
            com.android.internal.R.string.day_of_week_long_wednesday,
            com.android.internal.R.string.day_of_week_long_thursday,
            com.android.internal.R.string.day_of_week_long_friday,
            com.android.internal.R.string.day_of_week_long_saturday,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.885 -0500", hash_original_field = "11EA286AAC68436E3F8758BC1332DE84", hash_generated_field = "2E8BE399F9A028B0809C9BF09FB8EF23")

    private static final int[] sDaysMedium = new int[] {
            com.android.internal.R.string.day_of_week_medium_sunday,
            com.android.internal.R.string.day_of_week_medium_monday,
            com.android.internal.R.string.day_of_week_medium_tuesday,
            com.android.internal.R.string.day_of_week_medium_wednesday,
            com.android.internal.R.string.day_of_week_medium_thursday,
            com.android.internal.R.string.day_of_week_medium_friday,
            com.android.internal.R.string.day_of_week_medium_saturday,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.888 -0500", hash_original_field = "F26297DAF2744E24E4D94FB0EB2EF1CA", hash_generated_field = "3D14142FC1B5546DB07B6182A3F839A1")

    private static final int[] sDaysShort = new int[] {
            com.android.internal.R.string.day_of_week_short_sunday,
            com.android.internal.R.string.day_of_week_short_monday,
            com.android.internal.R.string.day_of_week_short_tuesday,
            com.android.internal.R.string.day_of_week_short_wednesday,
            com.android.internal.R.string.day_of_week_short_thursday,
            com.android.internal.R.string.day_of_week_short_friday,
            com.android.internal.R.string.day_of_week_short_saturday,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.891 -0500", hash_original_field = "4B9A4C3CCCEEA6FD144E058EE3A2E506", hash_generated_field = "FCBBD21FABEB805B84C3FDFAE4B6D538")

    private static final int[] sDaysShortest = new int[] {
            com.android.internal.R.string.day_of_week_shortest_sunday,
            com.android.internal.R.string.day_of_week_shortest_monday,
            com.android.internal.R.string.day_of_week_shortest_tuesday,
            com.android.internal.R.string.day_of_week_shortest_wednesday,
            com.android.internal.R.string.day_of_week_shortest_thursday,
            com.android.internal.R.string.day_of_week_shortest_friday,
            com.android.internal.R.string.day_of_week_shortest_saturday,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.894 -0500", hash_original_field = "8FE70401AD135FAE094011C6ED6578E0", hash_generated_field = "DA88BB6A3EB42BBE407526E57B3F33C2")

    private static final int[] sMonthsStandaloneLong = new int [] {
            com.android.internal.R.string.month_long_standalone_january,
            com.android.internal.R.string.month_long_standalone_february,
            com.android.internal.R.string.month_long_standalone_march,
            com.android.internal.R.string.month_long_standalone_april,
            com.android.internal.R.string.month_long_standalone_may,
            com.android.internal.R.string.month_long_standalone_june,
            com.android.internal.R.string.month_long_standalone_july,
            com.android.internal.R.string.month_long_standalone_august,
            com.android.internal.R.string.month_long_standalone_september,
            com.android.internal.R.string.month_long_standalone_october,
            com.android.internal.R.string.month_long_standalone_november,
            com.android.internal.R.string.month_long_standalone_december,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.897 -0500", hash_original_field = "CDC64C3FEA6197F69C9F14CFBA0EDBD6", hash_generated_field = "4547DAD07ABD85D2D2D1ACCB17920EF1")

    private static final int[] sMonthsLong = new int [] {
            com.android.internal.R.string.month_long_january,
            com.android.internal.R.string.month_long_february,
            com.android.internal.R.string.month_long_march,
            com.android.internal.R.string.month_long_april,
            com.android.internal.R.string.month_long_may,
            com.android.internal.R.string.month_long_june,
            com.android.internal.R.string.month_long_july,
            com.android.internal.R.string.month_long_august,
            com.android.internal.R.string.month_long_september,
            com.android.internal.R.string.month_long_october,
            com.android.internal.R.string.month_long_november,
            com.android.internal.R.string.month_long_december,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.900 -0500", hash_original_field = "6C02EBAB89A544DA6F71ACBA19BC2C19", hash_generated_field = "82E2F3C350602C01C819078C228E09D7")

    private static final int[] sMonthsMedium = new int [] {
            com.android.internal.R.string.month_medium_january,
            com.android.internal.R.string.month_medium_february,
            com.android.internal.R.string.month_medium_march,
            com.android.internal.R.string.month_medium_april,
            com.android.internal.R.string.month_medium_may,
            com.android.internal.R.string.month_medium_june,
            com.android.internal.R.string.month_medium_july,
            com.android.internal.R.string.month_medium_august,
            com.android.internal.R.string.month_medium_september,
            com.android.internal.R.string.month_medium_october,
            com.android.internal.R.string.month_medium_november,
            com.android.internal.R.string.month_medium_december,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.903 -0500", hash_original_field = "9CEFA1AD7D0362B863407D4D4B042262", hash_generated_field = "63140BA4003E492897CA13FBAFD13C15")

    private static final int[] sMonthsShortest = new int [] {
            com.android.internal.R.string.month_shortest_january,
            com.android.internal.R.string.month_shortest_february,
            com.android.internal.R.string.month_shortest_march,
            com.android.internal.R.string.month_shortest_april,
            com.android.internal.R.string.month_shortest_may,
            com.android.internal.R.string.month_shortest_june,
            com.android.internal.R.string.month_shortest_july,
            com.android.internal.R.string.month_shortest_august,
            com.android.internal.R.string.month_shortest_september,
            com.android.internal.R.string.month_shortest_october,
            com.android.internal.R.string.month_shortest_november,
            com.android.internal.R.string.month_shortest_december,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.906 -0500", hash_original_field = "20E5CA46B6673AA14C784E114E8D478A", hash_generated_field = "AE7954E09EE1C9E367D945340EAD3656")

    private static final int[] sAmPm = new int[] {
            com.android.internal.R.string.am,
            com.android.internal.R.string.pm,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.909 -0500", hash_original_field = "51F0C61B65FDA03AE9E74C86DD9FF6EF", hash_generated_field = "737B30803857B1AC340BE52098FE6E79")

    private static Configuration sLastConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.912 -0500", hash_original_field = "83872E935DA040CDC37F4DD68E433E74", hash_generated_field = "6AC70FBC663CA3A5FB4CAD1078B01011")

    private static java.text.DateFormat sStatusTimeFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.914 -0500", hash_original_field = "86172C6AC8ED4C8B8C44C643673FFFDB", hash_generated_field = "D8DEBE98A79FC3F9DE2D01F24B5E42EF")

    private static String sElapsedFormatMMSS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.917 -0500", hash_original_field = "70F4BFDD3B4DD70885D5BE7F437AC4DC", hash_generated_field = "42AD2C2E59CC524CB9A70C4F177F1F8D")

    private static String sElapsedFormatHMMSS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.919 -0500", hash_original_field = "5886D4FC76C55F77396ED00292E48799", hash_generated_field = "FF305F482E500D435B4D697A0A89A3B1")

    
    private static final String FAST_FORMAT_HMMSS = "%1$d:%2$02d:%3$02d";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.922 -0500", hash_original_field = "121C8096C10396F9CA53B21724378E03", hash_generated_field = "427596CFBDAE0F72F1DCA7731E4535A3")

    private static final String FAST_FORMAT_MMSS = "%1$02d:%2$02d";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.924 -0500", hash_original_field = "096B6E4853DE328FDFCD77AA097093D4", hash_generated_field = "44D2FF046FE0733689E5E16F829C84FD")

    private static final char TIME_PADDING = '0';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.927 -0500", hash_original_field = "D9490667D78FF2853DE02066A0E7C03F", hash_generated_field = "D74541D4DB10DF42733B9013A859242D")

    private static final char TIME_SEPARATOR = ':';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.930 -0500", hash_original_field = "56BE4EFCFEFF0C5DA945B3A6C115D395", hash_generated_field = "79393C5109653A6A95A2D0A9A64DDFB7")

    

    public static final long SECOND_IN_MILLIS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.933 -0500", hash_original_field = "E37B0A9DC8D2A173C46FD7C52EC101E2", hash_generated_field = "BBDDAEF6073B4DDF1ACD1C13CB027102")

    public static final long MINUTE_IN_MILLIS = SECOND_IN_MILLIS * 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.936 -0500", hash_original_field = "563EDC48774CDE5B6AFBED70242D07A7", hash_generated_field = "018572DA120DAD97E3D68174934A7622")

    public static final long HOUR_IN_MILLIS = MINUTE_IN_MILLIS * 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.938 -0500", hash_original_field = "2DE8E0E9A8C77DFBD3D02012512AAF91", hash_generated_field = "E6C45A6B8B8D3C2E6F23ED475AE9E497")

    public static final long DAY_IN_MILLIS = HOUR_IN_MILLIS * 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.941 -0500", hash_original_field = "E3E16858C841EE18C6B4626B4817302F", hash_generated_field = "8FE2D3EB53A7E5BA12FA7431CEC3F1BA")

    public static final long WEEK_IN_MILLIS = DAY_IN_MILLIS * 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.944 -0500", hash_original_field = "B41023FB35F3C64A35DF1098E7917FEE", hash_generated_field = "1BEFCE660A45888FD4B6980D40B5BF94")

    public static final long YEAR_IN_MILLIS = WEEK_IN_MILLIS * 52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.946 -0500", hash_original_field = "083B031724A81C23C045A5166F2EF169", hash_generated_field = "D924A77C41D152AB00F8BF98330549A1")

    // dates and times in the formatDateRange method.
    public static final int FORMAT_SHOW_TIME = 0x00001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.949 -0500", hash_original_field = "EFE92CD7BC21167260BB68316F77DA51", hash_generated_field = "2E22F820F5C7AE635D4B26BBC68A384A")

    public static final int FORMAT_SHOW_WEEKDAY = 0x00002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.951 -0500", hash_original_field = "2C078B2D932EE6687FF3E9E7148380CB", hash_generated_field = "F75AD8500F536F5D64A3ACAB8D7874B5")

    public static final int FORMAT_SHOW_YEAR = 0x00004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.954 -0500", hash_original_field = "53A7628109EF4DDB8844D9E3CB000E15", hash_generated_field = "8333D106B0DC926FBABB190C682E8B4A")

    public static final int FORMAT_NO_YEAR = 0x00008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.958 -0500", hash_original_field = "FFB2943F60A7A4874E45D9E42271813A", hash_generated_field = "FBEE04ADFEB0D3428DCC32844A2D53CB")

    public static final int FORMAT_SHOW_DATE = 0x00010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.960 -0500", hash_original_field = "B9645039FA0788928F5A9CA5AAB45503", hash_generated_field = "1020C1B8CDD83BFC4F639D572EFC383D")

    public static final int FORMAT_NO_MONTH_DAY = 0x00020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.963 -0500", hash_original_field = "92330F8B38F79226A237DF88E1A4E8C8", hash_generated_field = "3EE8E32FE9322277BE9C4F7EF706D5D7")

    public static final int FORMAT_12HOUR = 0x00040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.966 -0500", hash_original_field = "EFF7198F2D9F77EEA296BFF9A559223A", hash_generated_field = "E0821032FB403F62EA92120DC8A74519")

    public static final int FORMAT_24HOUR = 0x00080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.968 -0500", hash_original_field = "969E9C47E46C9309B4CD6733FC8540FB", hash_generated_field = "0A7AE2EF261B06F90815654F11ACFCEC")

    public static final int FORMAT_CAP_AMPM = 0x00100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.971 -0500", hash_original_field = "A927CFC76A94714732B4960CF00F4506", hash_generated_field = "533274CA521ADACA885345CF79F85BAE")

    public static final int FORMAT_NO_NOON = 0x00200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.974 -0500", hash_original_field = "0C1F1903A8FAF5A59CA95454EFEF1EEF", hash_generated_field = "E92705C2913CEF065DB8E82CB22966CF")

    public static final int FORMAT_CAP_NOON = 0x00400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.977 -0500", hash_original_field = "A42860C3135D92E61C0D3DF7376C686C", hash_generated_field = "6DDBCCC3EF5AD8AA3EACD5E8D4D41979")

    public static final int FORMAT_NO_MIDNIGHT = 0x00800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.979 -0500", hash_original_field = "EF6B6B06961A8F38228404151D8683EC", hash_generated_field = "285BC0AA1D33A734B61DA6252141ABD6")

    public static final int FORMAT_CAP_MIDNIGHT = 0x01000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.983 -0500", hash_original_field = "7711D6D94B3B65930070E8E52F8AC49F", hash_generated_field = "B5C8BD6C50C0FA131549BA298805FDD5")

    @Deprecated
    public static final int FORMAT_UTC = 0x02000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.985 -0500", hash_original_field = "1E025C2788C6B110B75FE5FCFB0AC5AE", hash_generated_field = "223A27F0A09AD5C7B11F4C22EC53FAB3")

    public static final int FORMAT_ABBREV_TIME = 0x04000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.989 -0500", hash_original_field = "A58DE2E18CD6293759E5992773163BAF", hash_generated_field = "2E2C29F520661754D3DC8AFACE29C971")

    public static final int FORMAT_ABBREV_WEEKDAY = 0x08000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.991 -0500", hash_original_field = "19FE6966D26F4408B106A7FE3B2B5E4B", hash_generated_field = "5FED42F5CAC032995F50232DA95899E6")

    public static final int FORMAT_ABBREV_MONTH = 0x10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.994 -0500", hash_original_field = "8B0EEB57B8E96DE47A69466FB7595E98", hash_generated_field = "2C8F29926729437E3965E15FACA21A42")

    public static final int FORMAT_NUMERIC_DATE = 0x20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.996 -0500", hash_original_field = "FBAB5781262E960098B622F035C90283", hash_generated_field = "B1BBE918D9FBA6D13EBD99F2BEFAD2CD")

    public static final int FORMAT_ABBREV_RELATIVE = 0x40000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.999 -0500", hash_original_field = "28D5F6CA7C8CAFB81A9574817B34E5DC", hash_generated_field = "088AC6C6C6FA89924A4328CD58584ECE")

    public static final int FORMAT_ABBREV_ALL = 0x80000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.002 -0500", hash_original_field = "71397C2CA3A127005132AF6E40B365C6", hash_generated_field = "A952B3C3C2FF7C7D8CB476E150A7257B")

    public static final int FORMAT_CAP_NOON_MIDNIGHT = (FORMAT_CAP_NOON | FORMAT_CAP_MIDNIGHT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.005 -0500", hash_original_field = "BC6638E24EBB93F2096A5B0DB9C00BB6", hash_generated_field = "7BFBC27E61C2940B6BF6D5E8E93D8E81")

    public static final int FORMAT_NO_NOON_MIDNIGHT = (FORMAT_NO_NOON | FORMAT_NO_MIDNIGHT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.008 -0500", hash_original_field = "CAA5EF7EC51C215C751DC331FBB96C16", hash_generated_field = "983E8345028088EB11E635BBBD97D208")

    // translated.
    /**
     * This is not actually the preferred 24-hour date format in all locales.
     */
    public static final String HOUR_MINUTE_24 = "%H:%M";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.010 -0500", hash_original_field = "6BDFB53377715257361778DC3C1917E2", hash_generated_field = "B6240F652676C39F4BFCE98B4AA9DE53")

    public static final String MONTH_FORMAT = "%B";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.013 -0500", hash_original_field = "8242615F14AEFA51EA7D3B045BABF2D5", hash_generated_field = "EF1BE0079541CDBA2E520EBFB85B09F2")

    public static final String ABBREV_MONTH_FORMAT = "%b";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.016 -0500", hash_original_field = "0992F74298682C5D2E2156D4A9898E91", hash_generated_field = "A2B7255A7EEF395A6AC547961A01921C")

    public static final String NUMERIC_MONTH_FORMAT = "%m";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.018 -0500", hash_original_field = "60AA38667FCC5800C83449A24663BAA3", hash_generated_field = "DD178978999E124B4C49C343AF7BD4F0")

    public static final String MONTH_DAY_FORMAT = "%-d";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.021 -0500", hash_original_field = "BDBC1A3B101B29DF15D3BF55E6636D78", hash_generated_field = "6562E92BF38BDDF46B45DDFC9A26848A")

    public static final String YEAR_FORMAT = "%Y";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.024 -0500", hash_original_field = "543F4E2AFB50DBF3CA3401438610DE02", hash_generated_field = "00BEA3F65CA07642F15C025D41A3639A")

    public static final String YEAR_FORMAT_TWO_DIGITS = "%g";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.027 -0500", hash_original_field = "B44BD9F7C09E11C33D525C34C3B1E847", hash_generated_field = "A65D6D6099BE774F67A73287D784026A")

    public static final String WEEKDAY_FORMAT = "%A";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.029 -0500", hash_original_field = "944E6A6AEA873DD747620ECF89238F2D", hash_generated_field = "C862608C358C499EBB5EE9E15A523C9D")

    public static final String ABBREV_WEEKDAY_FORMAT = "%a";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.033 -0500", hash_original_field = "A0D7B14F6CC91B5B85A92C6D7C0597AE", hash_generated_field = "DA02EADA19B6E3D2D05C4348C983A4DF")

    // used for formatting a start and end date that fall in the same year.
    // The index is constructed from a bit-wise OR of the boolean values:
    // {showTime, showYear, showWeekDay}.  For example, if showYear and
    // showWeekDay are both true, then the index would be 3.
    public static final int sameYearTable[] = {
        com.android.internal.R.string.same_year_md1_md2,
        com.android.internal.R.string.same_year_wday1_md1_wday2_md2,
        com.android.internal.R.string.same_year_mdy1_mdy2,
        com.android.internal.R.string.same_year_wday1_mdy1_wday2_mdy2,
        com.android.internal.R.string.same_year_md1_time1_md2_time2,
        com.android.internal.R.string.same_year_wday1_md1_time1_wday2_md2_time2,
        com.android.internal.R.string.same_year_mdy1_time1_mdy2_time2,
        com.android.internal.R.string.same_year_wday1_mdy1_time1_wday2_mdy2_time2,

        // Numeric date strings
        com.android.internal.R.string.numeric_md1_md2,
        com.android.internal.R.string.numeric_wday1_md1_wday2_md2,
        com.android.internal.R.string.numeric_mdy1_mdy2,
        com.android.internal.R.string.numeric_wday1_mdy1_wday2_mdy2,
        com.android.internal.R.string.numeric_md1_time1_md2_time2,
        com.android.internal.R.string.numeric_wday1_md1_time1_wday2_md2_time2,
        com.android.internal.R.string.numeric_mdy1_time1_mdy2_time2,
        com.android.internal.R.string.numeric_wday1_mdy1_time1_wday2_mdy2_time2,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.036 -0500", hash_original_field = "12D824E56C6F20098CFDD3CEA2FFACA6", hash_generated_field = "3A170BC64110B296D364170A6F3BCD0F")

    // used for formatting a start and end date that fall in the same month.
    // The index is constructed from a bit-wise OR of the boolean values:
    // {showTime, showYear, showWeekDay}.  For example, if showYear and
    // showWeekDay are both true, then the index would be 3.
    public static final int sameMonthTable[] = {
        com.android.internal.R.string.same_month_md1_md2,
        com.android.internal.R.string.same_month_wday1_md1_wday2_md2,
        com.android.internal.R.string.same_month_mdy1_mdy2,
        com.android.internal.R.string.same_month_wday1_mdy1_wday2_mdy2,
        com.android.internal.R.string.same_month_md1_time1_md2_time2,
        com.android.internal.R.string.same_month_wday1_md1_time1_wday2_md2_time2,
        com.android.internal.R.string.same_month_mdy1_time1_mdy2_time2,
        com.android.internal.R.string.same_month_wday1_mdy1_time1_wday2_mdy2_time2,

        com.android.internal.R.string.numeric_md1_md2,
        com.android.internal.R.string.numeric_wday1_md1_wday2_md2,
        com.android.internal.R.string.numeric_mdy1_mdy2,
        com.android.internal.R.string.numeric_wday1_mdy1_wday2_mdy2,
        com.android.internal.R.string.numeric_md1_time1_md2_time2,
        com.android.internal.R.string.numeric_wday1_md1_time1_wday2_md2_time2,
        com.android.internal.R.string.numeric_mdy1_time1_mdy2_time2,
        com.android.internal.R.string.numeric_wday1_mdy1_time1_wday2_mdy2_time2,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.039 -0500", hash_original_field = "661580F33EAB0B70EB1EBB1CEF657ACA", hash_generated_field = "37F92F3C1E0DA48CE7BCF3D224131FD2")

    public static final int LENGTH_LONG = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.041 -0500", hash_original_field = "6AE7502070AF0CF71693A91FD5B53AFC", hash_generated_field = "FC3AA02DFCF8D074DDE080453B145EE5")

    public static final int LENGTH_MEDIUM = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.043 -0500", hash_original_field = "109B084CF00D04FDCF5592B461B0BE81", hash_generated_field = "1C38D436BC8341CD44AB627FE69641E1")

    public static final int LENGTH_SHORT = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.047 -0500", hash_original_field = "31FA28D36FC0364C046B6F7B3E2F434D", hash_generated_field = "193553017D8A7C3E8062B466F200FA02")

    public static final int LENGTH_SHORTER = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.049 -0500", hash_original_field = "BBAE0A3C75AEB138B17E2218D8960203", hash_generated_field = "8C75FD0674414579FCA46D8846153EF2")

    public static final int LENGTH_SHORTEST = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.160 -0500", hash_original_field = "EC651D5336C532B18D3F0FE5F80FAF43", hash_generated_field = "C8423BFDB99E2148E6FA387DE029FB84")

    
    private static Time sNowTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:17.163 -0500", hash_original_field = "32456A67436C9849145D5D40CF2E32F5", hash_generated_field = "210393CA853056B78316AD7FC7D5F3A4")

    private static Time sThenTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.651 -0400", hash_original_method = "15B73761459E939452D7F92AFEA42834", hash_generated_method = "15B73761459E939452D7F92AFEA42834")
    public DateUtils ()
    {
        //Synthesized constructor
    }
}

