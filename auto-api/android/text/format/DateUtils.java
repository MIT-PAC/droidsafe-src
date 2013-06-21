package android.text.format;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.092 -0400", hash_original_method = "4FF56AE1B5128412651F1D6EEA8376BF", hash_generated_method = "4FF56AE1B5128412651F1D6EEA8376BF")
        public DateUtils ()
    {
    }


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

    
        public static String getAMPMString(int ampm) {
        Resources r = Resources.getSystem();
        return r.getString(sAmPm[ampm - Calendar.AM]);
    }

    
        public static String getMonthString(int month, int abbrev) {
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

    
        public static String getStandaloneMonthString(int month, int abbrev) {
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

    
        public static CharSequence getRelativeTimeSpanString(long startTime) {
        return getRelativeTimeSpanString(startTime, System.currentTimeMillis(), MINUTE_IN_MILLIS);
    }

    
        public static CharSequence getRelativeTimeSpanString(long time, long now, long minResolution) {
        int flags = FORMAT_SHOW_DATE | FORMAT_SHOW_YEAR | FORMAT_ABBREV_MONTH;
        return getRelativeTimeSpanString(time, now, minResolution, flags);
    }

    
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
            return formatDateRange(null, time, time, flags);
        }
        String format = r.getQuantityString(resId, (int) count);
        return String.format(format, count);
    }

    
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

    
        public static CharSequence getRelativeDateTimeString(Context c, long time, long minResolution,
            long transitionResolution, int flags) {
        Resources r = Resources.getSystem();
        long now = System.currentTimeMillis();
        long duration = Math.abs(now - time);
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

    
        private static void initFormatStrings() {
        synchronized (sLock) {
            initFormatStringsLocked();
        }
    }

    
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

    
        public static final CharSequence timeString(long millis) {
        synchronized (sLock) {
            initFormatStringsLocked();
            return sStatusTimeFormat.format(millis);
        }
    }

    
        public static String formatElapsedTime(long elapsedSeconds) {
        return formatElapsedTime(null, elapsedSeconds);
    }

    
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

    
        private static char toDigitChar(long digit) {
        return (char) (digit + '0');
    }

    
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

    
        public static Calendar newCalendar(boolean zulu) {
        if (zulu)
            return Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        return Calendar.getInstance();
    }

    
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

    
        public static boolean isUTC(String s) {
        if (s.length() == 16 && s.charAt(15) == 'Z') {
            return true;
        }
        if (s.length() == 9 && s.charAt(8) == 'Z') {
            return true;
        }
        return false;
    }

    
        public static String writeDateTime(Calendar cal) {
        TimeZone tz = TimeZone.getTimeZone("GMT");
        GregorianCalendar c = new GregorianCalendar(tz);
        c.setTimeInMillis(cal.getTimeInMillis());
        return writeDateTime(c, true);
    }

    
        public static String writeDateTime(Calendar cal, boolean zulu) {
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

    
        public static String writeDateTime(Calendar cal, StringBuilder sb) {
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

    
        public static void assign(Calendar lval, Calendar rval) {
        lval.clear();
        lval.setTimeInMillis(rval.getTimeInMillis());
    }

    
        public static String formatDateRange(Context context, long startMillis,
            long endMillis, int flags) {
        Formatter f = new Formatter(new StringBuilder(50), Locale.getDefault());
        return formatDateRange(context, f, startMillis, endMillis, flags).toString();
    }

    
        public static Formatter formatDateRange(Context context, Formatter formatter, long startMillis,
            long endMillis, int flags) {
        return formatDateRange(context, formatter, startMillis, endMillis, flags, null);
    }

    
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
        if (!isInstant
            && (endDate.hour | endDate.minute | endDate.second) == 0
            && (!showTime || dayDistance <= 1)) {
            endDate.monthDay -= 1;
            endDate.normalize(true );
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
                }
            }
            startTimeString = startDate.format(startTimeFormat);
            endTimeString = isInstant ? startTimeString : endDate.format(endTimeFormat);
        }
        if (showYear) {
        } else if (noYear) {
            showYear = false;
        } else if (startYear != endYear) {
            showYear = true;
        } else {
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
            return formatter.format("%s", startDate.format(defaultDateFormat));
        }
        if (startYear != endYear || noMonthDay) {
            String startDateString = startDate.format(defaultDateFormat);
            String endDateString = endDate.format(defaultDateFormat);
            return formatter.format(fullFormat,
                    startWeekDayString, startDateString, startTimeString,
                    endWeekDayString, endDateString, endTimeString);
        }
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
            int index = 0;
            if (showWeekDay) index = 1;
            if (showYear) index += 2;
            if (showTime) index += 4;
            if (numericDate) index += 8;
            int resId = sameYearTable[index];
            fullFormat = res.getString(resId);
            return formatter.format(fullFormat,
                    startWeekDayString, startMonthString, startMonthDayString,
                    startYearString, startTimeString,
                    endWeekDayString, endMonthString, endMonthDayString,
                    endYearString, endTimeString);
        }
        if (startDay != endDay) {
            int index = 0;
            if (showWeekDay) index = 1;
            if (showYear) index += 2;
            if (showTime) index += 4;
            if (numericDate) index += 8;
            int resId = sameMonthTable[index];
            fullFormat = res.getString(resId);
            return formatter.format(fullFormat,
                    startWeekDayString, startMonthString, startMonthDayString,
                    startYearString, startTimeString,
                    endWeekDayString, endMonthString, endMonthDayString,
                    endYearString, endTimeString);
        }
        boolean showDate = (flags & FORMAT_SHOW_DATE) != 0;
        if (!showTime && !showDate && !showWeekDay) showDate = true;
        String timeString = "";
        if (showTime) {
            if (isInstant) {
                timeString = startTimeString;
            } else {
                String timeFormat = res.getString(com.android.internal.R.string.time1_time2);
                timeString = String.format(timeFormat, startTimeString, endTimeString);
            }
        }
        fullFormat = "";
        String dateString = "";
        if (showDate) {
            dateString = startDate.format(defaultDateFormat);
            if (showWeekDay) {
                if (showTime) {
                    fullFormat = res.getString(com.android.internal.R.string.time_wday_date);
                } else {
                    fullFormat = res.getString(com.android.internal.R.string.wday_date);
                }
            } else {
                if (showTime) {
                    fullFormat = res.getString(com.android.internal.R.string.time_date);
                } else {
                    return formatter.format("%s", dateString);
                }
            }
        } else if (showWeekDay) {
            if (showTime) {
                fullFormat = res.getString(com.android.internal.R.string.time_wday);
            } else {
                return formatter.format("%s", startWeekDayString);
            }
        } else if (showTime) {
            return formatter.format("%s", timeString);
        }
        return formatter.format(fullFormat, timeString, startWeekDayString, dateString);
    }

    
        public static String formatDateTime(Context context, long millis, int flags) {
        return formatDateRange(context, millis, millis, flags);
    }

    
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
                int flags = FORMAT_SHOW_TIME;
                result = formatDateRange(c, millis, millis, flags);
                prepositionId = R.string.preposition_for_time;
            } else if (sNowTime.year != sThenTime.year) {
                int flags = FORMAT_SHOW_DATE | FORMAT_SHOW_YEAR | FORMAT_NUMERIC_DATE;
                result = formatDateRange(c, millis, millis, flags);
                prepositionId = R.string.preposition_for_date;
            } else {
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

    
        public static CharSequence getRelativeTimeSpanString(Context c, long millis) {
        return getRelativeTimeSpanString(c, millis, false );
    }

    
    private static final Object sLock = new Object();
    private static final int[] sDaysLong = new int[] {
            com.android.internal.R.string.day_of_week_long_sunday,
            com.android.internal.R.string.day_of_week_long_monday,
            com.android.internal.R.string.day_of_week_long_tuesday,
            com.android.internal.R.string.day_of_week_long_wednesday,
            com.android.internal.R.string.day_of_week_long_thursday,
            com.android.internal.R.string.day_of_week_long_friday,
            com.android.internal.R.string.day_of_week_long_saturday,
        };
    private static final int[] sDaysMedium = new int[] {
            com.android.internal.R.string.day_of_week_medium_sunday,
            com.android.internal.R.string.day_of_week_medium_monday,
            com.android.internal.R.string.day_of_week_medium_tuesday,
            com.android.internal.R.string.day_of_week_medium_wednesday,
            com.android.internal.R.string.day_of_week_medium_thursday,
            com.android.internal.R.string.day_of_week_medium_friday,
            com.android.internal.R.string.day_of_week_medium_saturday,
        };
    private static final int[] sDaysShort = new int[] {
            com.android.internal.R.string.day_of_week_short_sunday,
            com.android.internal.R.string.day_of_week_short_monday,
            com.android.internal.R.string.day_of_week_short_tuesday,
            com.android.internal.R.string.day_of_week_short_wednesday,
            com.android.internal.R.string.day_of_week_short_thursday,
            com.android.internal.R.string.day_of_week_short_friday,
            com.android.internal.R.string.day_of_week_short_saturday,
        };
    private static final int[] sDaysShortest = new int[] {
            com.android.internal.R.string.day_of_week_shortest_sunday,
            com.android.internal.R.string.day_of_week_shortest_monday,
            com.android.internal.R.string.day_of_week_shortest_tuesday,
            com.android.internal.R.string.day_of_week_shortest_wednesday,
            com.android.internal.R.string.day_of_week_shortest_thursday,
            com.android.internal.R.string.day_of_week_shortest_friday,
            com.android.internal.R.string.day_of_week_shortest_saturday,
        };
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
    private static final int[] sAmPm = new int[] {
            com.android.internal.R.string.am,
            com.android.internal.R.string.pm,
        };
    private static Configuration sLastConfig;
    private static java.text.DateFormat sStatusTimeFormat;
    private static String sElapsedFormatMMSS;
    private static String sElapsedFormatHMMSS;
    private static final String FAST_FORMAT_HMMSS = "%1$d:%2$02d:%3$02d";
    private static final String FAST_FORMAT_MMSS = "%1$02d:%2$02d";
    private static final char TIME_PADDING = '0';
    private static final char TIME_SEPARATOR = ':';
    public static final long SECOND_IN_MILLIS = 1000;
    public static final long MINUTE_IN_MILLIS = SECOND_IN_MILLIS * 60;
    public static final long HOUR_IN_MILLIS = MINUTE_IN_MILLIS * 60;
    public static final long DAY_IN_MILLIS = HOUR_IN_MILLIS * 24;
    public static final long WEEK_IN_MILLIS = DAY_IN_MILLIS * 7;
    public static final long YEAR_IN_MILLIS = WEEK_IN_MILLIS * 52;
    public static final int FORMAT_SHOW_TIME = 0x00001;
    public static final int FORMAT_SHOW_WEEKDAY = 0x00002;
    public static final int FORMAT_SHOW_YEAR = 0x00004;
    public static final int FORMAT_NO_YEAR = 0x00008;
    public static final int FORMAT_SHOW_DATE = 0x00010;
    public static final int FORMAT_NO_MONTH_DAY = 0x00020;
    public static final int FORMAT_12HOUR = 0x00040;
    public static final int FORMAT_24HOUR = 0x00080;
    public static final int FORMAT_CAP_AMPM = 0x00100;
    public static final int FORMAT_NO_NOON = 0x00200;
    public static final int FORMAT_CAP_NOON = 0x00400;
    public static final int FORMAT_NO_MIDNIGHT = 0x00800;
    public static final int FORMAT_CAP_MIDNIGHT = 0x01000;
    @Deprecated public static final int FORMAT_UTC = 0x02000;
    public static final int FORMAT_ABBREV_TIME = 0x04000;
    public static final int FORMAT_ABBREV_WEEKDAY = 0x08000;
    public static final int FORMAT_ABBREV_MONTH = 0x10000;
    public static final int FORMAT_NUMERIC_DATE = 0x20000;
    public static final int FORMAT_ABBREV_RELATIVE = 0x40000;
    public static final int FORMAT_ABBREV_ALL = 0x80000;
    public static final int FORMAT_CAP_NOON_MIDNIGHT = (FORMAT_CAP_NOON | FORMAT_CAP_MIDNIGHT);
    public static final int FORMAT_NO_NOON_MIDNIGHT = (FORMAT_NO_NOON | FORMAT_NO_MIDNIGHT);
    public static final String HOUR_MINUTE_24 = "%H:%M";
    public static final String MONTH_FORMAT = "%B";
    public static final String ABBREV_MONTH_FORMAT = "%b";
    public static final String NUMERIC_MONTH_FORMAT = "%m";
    public static final String MONTH_DAY_FORMAT = "%-d";
    public static final String YEAR_FORMAT = "%Y";
    public static final String YEAR_FORMAT_TWO_DIGITS = "%g";
    public static final String WEEKDAY_FORMAT = "%A";
    public static final String ABBREV_WEEKDAY_FORMAT = "%a";
    public static final int sameYearTable[] = {
        com.android.internal.R.string.same_year_md1_md2,
        com.android.internal.R.string.same_year_wday1_md1_wday2_md2,
        com.android.internal.R.string.same_year_mdy1_mdy2,
        com.android.internal.R.string.same_year_wday1_mdy1_wday2_mdy2,
        com.android.internal.R.string.same_year_md1_time1_md2_time2,
        com.android.internal.R.string.same_year_wday1_md1_time1_wday2_md2_time2,
        com.android.internal.R.string.same_year_mdy1_time1_mdy2_time2,
        com.android.internal.R.string.same_year_wday1_mdy1_time1_wday2_mdy2_time2,

        
        com.android.internal.R.string.numeric_md1_md2,
        com.android.internal.R.string.numeric_wday1_md1_wday2_md2,
        com.android.internal.R.string.numeric_mdy1_mdy2,
        com.android.internal.R.string.numeric_wday1_mdy1_wday2_mdy2,
        com.android.internal.R.string.numeric_md1_time1_md2_time2,
        com.android.internal.R.string.numeric_wday1_md1_time1_wday2_md2_time2,
        com.android.internal.R.string.numeric_mdy1_time1_mdy2_time2,
        com.android.internal.R.string.numeric_wday1_mdy1_time1_wday2_mdy2_time2,
    };
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
    public static final int LENGTH_LONG = 10;
    public static final int LENGTH_MEDIUM = 20;
    public static final int LENGTH_SHORT = 30;
    public static final int LENGTH_SHORTER = 40;
    public static final int LENGTH_SHORTEST = 50;
    private static Time sNowTime;
    private static Time sThenTime;
}

