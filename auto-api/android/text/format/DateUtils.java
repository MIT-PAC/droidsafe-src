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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.407 -0400", hash_original_method = "15B73761459E939452D7F92AFEA42834", hash_generated_method = "15B73761459E939452D7F92AFEA42834")
    public DateUtils ()
    {
        //Synthesized constructor
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.457 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.458 -0400", hash_original_field = "7280B9ED005F9C4315F513C11B3049C7", hash_generated_field = "B39E782A388B3FC74361E4CBE905A976")

    private static int[] sDaysLong = new int[] {
            com.android.internal.R.string.day_of_week_long_sunday,
            com.android.internal.R.string.day_of_week_long_monday,
            com.android.internal.R.string.day_of_week_long_tuesday,
            com.android.internal.R.string.day_of_week_long_wednesday,
            com.android.internal.R.string.day_of_week_long_thursday,
            com.android.internal.R.string.day_of_week_long_friday,
            com.android.internal.R.string.day_of_week_long_saturday,
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.458 -0400", hash_original_field = "C29A4D747340C3DFB03A81EC329C3E38", hash_generated_field = "09EA75BDBA5EA1A8F03C1F066C9A4FC4")

    private static int[] sDaysMedium = new int[] {
            com.android.internal.R.string.day_of_week_medium_sunday,
            com.android.internal.R.string.day_of_week_medium_monday,
            com.android.internal.R.string.day_of_week_medium_tuesday,
            com.android.internal.R.string.day_of_week_medium_wednesday,
            com.android.internal.R.string.day_of_week_medium_thursday,
            com.android.internal.R.string.day_of_week_medium_friday,
            com.android.internal.R.string.day_of_week_medium_saturday,
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.458 -0400", hash_original_field = "859FF96FAE028E25DB503F63A91B4FBE", hash_generated_field = "21832626BFB1A99D564E9C5A253C769F")

    private static int[] sDaysShort = new int[] {
            com.android.internal.R.string.day_of_week_short_sunday,
            com.android.internal.R.string.day_of_week_short_monday,
            com.android.internal.R.string.day_of_week_short_tuesday,
            com.android.internal.R.string.day_of_week_short_wednesday,
            com.android.internal.R.string.day_of_week_short_thursday,
            com.android.internal.R.string.day_of_week_short_friday,
            com.android.internal.R.string.day_of_week_short_saturday,
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.458 -0400", hash_original_field = "582E2D9C502FD28D846DDD8B9A0107C8", hash_generated_field = "DC991486AB48F2E55980D0D4356F57D2")

    private static int[] sDaysShortest = new int[] {
            com.android.internal.R.string.day_of_week_shortest_sunday,
            com.android.internal.R.string.day_of_week_shortest_monday,
            com.android.internal.R.string.day_of_week_shortest_tuesday,
            com.android.internal.R.string.day_of_week_shortest_wednesday,
            com.android.internal.R.string.day_of_week_shortest_thursday,
            com.android.internal.R.string.day_of_week_shortest_friday,
            com.android.internal.R.string.day_of_week_shortest_saturday,
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.458 -0400", hash_original_field = "3D59FFAA9B6BE88426D1D9122015C365", hash_generated_field = "02A647B1D48F91B026ABAA21A0DE25F2")

    private static int[] sMonthsStandaloneLong = new int [] {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.458 -0400", hash_original_field = "AA5C8D7253A30F29E1253D9645E27423", hash_generated_field = "0CDDB912286F35D9B3FE094A7B8BA6D0")

    private static int[] sMonthsLong = new int [] {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.458 -0400", hash_original_field = "DD9C363FF013606DEDEB50DD6E74BCEA", hash_generated_field = "648F7DB7B02243110F31D02012281DB6")

    private static int[] sMonthsMedium = new int [] {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.458 -0400", hash_original_field = "18736E841D5B02556CA67BBF81896A76", hash_generated_field = "E940AD1511E17ADFF6A86300F5C2E805")

    private static int[] sMonthsShortest = new int [] {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "E38189295EE5655BAF95345B7620D2DC", hash_generated_field = "CB65F8807BC849FF0EAA59BE84ED5BAC")

    private static int[] sAmPm = new int[] {
            com.android.internal.R.string.am,
            com.android.internal.R.string.pm,
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "6A1A0CD6F12B27F79B1B6890254E089E", hash_generated_field = "737B30803857B1AC340BE52098FE6E79")

    private static Configuration sLastConfig;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "9034373F8D39AB1D4E61F0FA28BE8172", hash_generated_field = "6AC70FBC663CA3A5FB4CAD1078B01011")

    private static java.text.DateFormat sStatusTimeFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "B304B17EDFF43720A826155F142D66E8", hash_generated_field = "D8DEBE98A79FC3F9DE2D01F24B5E42EF")

    private static String sElapsedFormatMMSS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "57108094C9D70FB0F5DC1315E1A0AF88", hash_generated_field = "42AD2C2E59CC524CB9A70C4F177F1F8D")

    private static String sElapsedFormatHMMSS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "E9E83F0EEBF5B40D2951CB0A41B6A1FF", hash_generated_field = "62E69AC829F3992A9AA88D56DC8025EA")

    private static String FAST_FORMAT_HMMSS = "%1$d:%2$02d:%3$02d";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "70292A3AFE3D508FA183724291D3049C", hash_generated_field = "A18B29F0A9EEC1097210EA21A665EB26")

    private static String FAST_FORMAT_MMSS = "%1$02d:%2$02d";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "C92131E48518F97151BA55C2D5CB3AB1", hash_generated_field = "E4A1A6A08C7B510C246F4B64228122D4")

    private static char TIME_PADDING = '0';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "7D37BFF23BB1DEAFCEC8AC89FBF0DBA1", hash_generated_field = "C10FE36F391189CDC674B66A0A14C21F")

    private static char TIME_SEPARATOR = ':';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "7B964E5C20CF4834FFEC459AD3ACF544", hash_generated_field = "79393C5109653A6A95A2D0A9A64DDFB7")

    public static final long SECOND_IN_MILLIS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.459 -0400", hash_original_field = "F61789E093D4C8E67DCB88DC6ECB3679", hash_generated_field = "BBDDAEF6073B4DDF1ACD1C13CB027102")

    public static final long MINUTE_IN_MILLIS = SECOND_IN_MILLIS * 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "92A369E4BEA67225BB626FED008765D2", hash_generated_field = "018572DA120DAD97E3D68174934A7622")

    public static final long HOUR_IN_MILLIS = MINUTE_IN_MILLIS * 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "B1C646DA22F7AADC51BE1EF81436FC53", hash_generated_field = "E6C45A6B8B8D3C2E6F23ED475AE9E497")

    public static final long DAY_IN_MILLIS = HOUR_IN_MILLIS * 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "9DA8AA5CC48DAF8EE1A559A23C1C6906", hash_generated_field = "8FE2D3EB53A7E5BA12FA7431CEC3F1BA")

    public static final long WEEK_IN_MILLIS = DAY_IN_MILLIS * 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "2102005B8628D33F041518307EB66E45", hash_generated_field = "1BEFCE660A45888FD4B6980D40B5BF94")

    public static final long YEAR_IN_MILLIS = WEEK_IN_MILLIS * 52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "FBA5CDA94F50AF55796856F7A2CED4E6", hash_generated_field = "057E17D042B6F4582B16C42C3EB68693")

    public static final int FORMAT_SHOW_TIME = 0x00001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "FAF69A6105E484526AFAD532CDB44C1B", hash_generated_field = "2E22F820F5C7AE635D4B26BBC68A384A")

    public static final int FORMAT_SHOW_WEEKDAY = 0x00002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "28201F02503FFD561658E9F2D8ADC9FD", hash_generated_field = "F75AD8500F536F5D64A3ACAB8D7874B5")

    public static final int FORMAT_SHOW_YEAR = 0x00004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "20A2DD8F68FF9621D252E64BA41AA694", hash_generated_field = "8333D106B0DC926FBABB190C682E8B4A")

    public static final int FORMAT_NO_YEAR = 0x00008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "B9102079621429945E0EFFB82EAEC18C", hash_generated_field = "FBEE04ADFEB0D3428DCC32844A2D53CB")

    public static final int FORMAT_SHOW_DATE = 0x00010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "B7F9D744C3DB72BC1782697725979377", hash_generated_field = "1020C1B8CDD83BFC4F639D572EFC383D")

    public static final int FORMAT_NO_MONTH_DAY = 0x00020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "7FF4CB4A2CD899720D1EE7B9492787E4", hash_generated_field = "3EE8E32FE9322277BE9C4F7EF706D5D7")

    public static final int FORMAT_12HOUR = 0x00040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "8E88DA6832E2EB7B7040971007647D59", hash_generated_field = "E0821032FB403F62EA92120DC8A74519")

    public static final int FORMAT_24HOUR = 0x00080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "80C31BEC8856F17866DF085EA6EF36F0", hash_generated_field = "0A7AE2EF261B06F90815654F11ACFCEC")

    public static final int FORMAT_CAP_AMPM = 0x00100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "F3F2492CF2F43083632AA2474C44C3A6", hash_generated_field = "533274CA521ADACA885345CF79F85BAE")

    public static final int FORMAT_NO_NOON = 0x00200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "546F494447F2C7A329A901FB377E135B", hash_generated_field = "E92705C2913CEF065DB8E82CB22966CF")

    public static final int FORMAT_CAP_NOON = 0x00400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "FCFE965999DF1E96885A688E627C84D9", hash_generated_field = "6DDBCCC3EF5AD8AA3EACD5E8D4D41979")

    public static final int FORMAT_NO_MIDNIGHT = 0x00800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.460 -0400", hash_original_field = "E9A838FE2219E3D2A7A45F3DCC875F7B", hash_generated_field = "285BC0AA1D33A734B61DA6252141ABD6")

    public static final int FORMAT_CAP_MIDNIGHT = 0x01000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.472 -0400", hash_original_field = "0FD23A0531A50FB8999268F50142B5AA", hash_generated_field = "B5C8BD6C50C0FA131549BA298805FDD5")

    @Deprecated
    public static final int FORMAT_UTC = 0x02000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.473 -0400", hash_original_field = "F0EF17AB7F2583FA094B63ECB7BD6F8B", hash_generated_field = "223A27F0A09AD5C7B11F4C22EC53FAB3")

    public static final int FORMAT_ABBREV_TIME = 0x04000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.473 -0400", hash_original_field = "4857EF2681AD30736173D0D296697F61", hash_generated_field = "2E2C29F520661754D3DC8AFACE29C971")

    public static final int FORMAT_ABBREV_WEEKDAY = 0x08000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.485 -0400", hash_original_field = "35BFF54C6A1A9CCC725383B20F7AE3C9", hash_generated_field = "5FED42F5CAC032995F50232DA95899E6")

    public static final int FORMAT_ABBREV_MONTH = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.485 -0400", hash_original_field = "01838959A8D09E3253CF9357E4CC2DFC", hash_generated_field = "2C8F29926729437E3965E15FACA21A42")

    public static final int FORMAT_NUMERIC_DATE = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.485 -0400", hash_original_field = "497BC7447D431095FA226D360E40B1D0", hash_generated_field = "B1BBE918D9FBA6D13EBD99F2BEFAD2CD")

    public static final int FORMAT_ABBREV_RELATIVE = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.485 -0400", hash_original_field = "E1A9568ED9EE8C5353F2D7D1A2A319E8", hash_generated_field = "088AC6C6C6FA89924A4328CD58584ECE")

    public static final int FORMAT_ABBREV_ALL = 0x80000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "4F93DB090A2A7820D6F19D5B905F3B74", hash_generated_field = "A952B3C3C2FF7C7D8CB476E150A7257B")

    public static final int FORMAT_CAP_NOON_MIDNIGHT = (FORMAT_CAP_NOON | FORMAT_CAP_MIDNIGHT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "5025AF36607366E9D419FC5755B9DD7D", hash_generated_field = "7BFBC27E61C2940B6BF6D5E8E93D8E81")

    public static final int FORMAT_NO_NOON_MIDNIGHT = (FORMAT_NO_NOON | FORMAT_NO_MIDNIGHT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "7409A77EB8B20458B596ECC5D6B916B0", hash_generated_field = "72EC29AD42021B91F056AA9FE41C13C6")

    public static final String HOUR_MINUTE_24 = "%H:%M";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "AEB62BD64552943A79F59F0AFE537C43", hash_generated_field = "B6240F652676C39F4BFCE98B4AA9DE53")

    public static final String MONTH_FORMAT = "%B";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "05B0B2555034CFC66B0713C04A5E5AA7", hash_generated_field = "EF1BE0079541CDBA2E520EBFB85B09F2")

    public static final String ABBREV_MONTH_FORMAT = "%b";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "C1C29312FA9402A9B390BA99FD4A7EED", hash_generated_field = "A2B7255A7EEF395A6AC547961A01921C")

    public static final String NUMERIC_MONTH_FORMAT = "%m";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "B85941DAB95D5AF394DC061F7BC6DDDE", hash_generated_field = "DD178978999E124B4C49C343AF7BD4F0")

    public static final String MONTH_DAY_FORMAT = "%-d";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "4A530FC6280E2FDDC65133AC964F88A2", hash_generated_field = "6562E92BF38BDDF46B45DDFC9A26848A")

    public static final String YEAR_FORMAT = "%Y";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "B8125CC54E9840E47A2CED3938637C89", hash_generated_field = "00BEA3F65CA07642F15C025D41A3639A")

    public static final String YEAR_FORMAT_TWO_DIGITS = "%g";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "10D210C604036FFA09FF1C5ECB402B1A", hash_generated_field = "A65D6D6099BE774F67A73287D784026A")

    public static final String WEEKDAY_FORMAT = "%A";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "D7DD9446C3A9D87E12818397EB6DC41A", hash_generated_field = "C862608C358C499EBB5EE9E15A523C9D")

    public static final String ABBREV_WEEKDAY_FORMAT = "%a";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "0B3672291FD896FAD80E083CA9E915B1", hash_generated_field = "64A11B7D3FDAD88C03BB90022D5755A1")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "EC2D80079B673DC4AD8B823B99DEB67A", hash_generated_field = "F5BF6878F0A5DE159309E522328DEF59")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "C6EB7828F5B50D46358669B3E3074FC1", hash_generated_field = "37F92F3C1E0DA48CE7BCF3D224131FD2")

    public static final int LENGTH_LONG = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "6D9410EDAF66BD045BF42BFEEA1104C6", hash_generated_field = "FC3AA02DFCF8D074DDE080453B145EE5")

    public static final int LENGTH_MEDIUM = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "275E058ED28C7ECFE7EED75934796DD0", hash_generated_field = "1C38D436BC8341CD44AB627FE69641E1")

    public static final int LENGTH_SHORT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "2C4B4ECD60365CE25F753682CBFEA619", hash_generated_field = "193553017D8A7C3E8062B466F200FA02")

    public static final int LENGTH_SHORTER = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "FC97AE1E858113DBFD13F86AB330E185", hash_generated_field = "8C75FD0674414579FCA46D8846153EF2")

    public static final int LENGTH_SHORTEST = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "CBC3F1B106A518C3401D150AEA906CA5", hash_generated_field = "C8423BFDB99E2148E6FA387DE029FB84")

    private static Time sNowTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.486 -0400", hash_original_field = "B615816BF61460D2074795F0DC4905FE", hash_generated_field = "210393CA853056B78316AD7FC7D5F3A4")

    private static Time sThenTime;
}

