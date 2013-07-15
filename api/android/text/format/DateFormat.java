package android.text.format;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import com.android.internal.R;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class DateFormat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.861 -0400", hash_original_method = "4FB6BE40E4FA388ABA6A7CE788B3C64B", hash_generated_method = "4FB6BE40E4FA388ABA6A7CE788B3C64B")
    public DateFormat ()
    {
        //Synthesized constructor
    }


        public static boolean is24HourFormat(Context context) {
        String value = Settings.System.getString(context.getContentResolver(),
                Settings.System.TIME_12_24);
        if (value == null) {
            Locale locale = context.getResources().getConfiguration().locale;
            synchronized (sLocaleLock) {
                if (sIs24HourLocale != null && sIs24HourLocale.equals(locale)) {
                    return sIs24Hour;
                }
            }
            java.text.DateFormat natural =
                java.text.DateFormat.getTimeInstance(
                    java.text.DateFormat.LONG, locale);
            if (natural instanceof SimpleDateFormat) {
                SimpleDateFormat sdf = (SimpleDateFormat) natural;
                String pattern = sdf.toPattern();
                if (pattern.indexOf('H') >= 0) {
                    value = "24";
                } else {
                    value = "12";
                }
            } else {
                value = "12";
            }
            synchronized (sLocaleLock) {
                sIs24HourLocale = locale;
                sIs24Hour = !value.equals("12");
            }
        }
        boolean b24 =  !(value == null || value.equals("12"));
        return b24;
    }

    
        public static final java.text.DateFormat getTimeFormat(Context context) {
        boolean b24 = is24HourFormat(context);
        int res;
        if (b24) {
            res = R.string.twenty_four_hour_time_format;
        } else {
            res = R.string.twelve_hour_time_format;
        }
        return new java.text.SimpleDateFormat(context.getString(res));
    }

    
        public static final java.text.DateFormat getDateFormat(Context context) {
        String value = Settings.System.getString(context.getContentResolver(),
                Settings.System.DATE_FORMAT);
        return getDateFormatForSetting(context, value);
    }

    
        public static java.text.DateFormat getDateFormatForSetting(Context context,
                                                               String value) {
        String format = getDateFormatStringForSetting(context, value);
        return new java.text.SimpleDateFormat(format);
    }

    
        private static String getDateFormatStringForSetting(Context context, String value) {
        if (value != null) {
            int month = value.indexOf('M');
            int day = value.indexOf('d');
            int year = value.indexOf('y');
            if (month >= 0 && day >= 0 && year >= 0) {
                String template = context.getString(R.string.numeric_date_template);
                if (year < month && year < day) {
                    if (month < day) {
                        value = String.format(template, "yyyy", "MM", "dd");
                    } else {
                        value = String.format(template, "yyyy", "dd", "MM");
                    }
                } else if (month < day) {
                    if (day < year) {
                        value = String.format(template, "MM", "dd", "yyyy");
                    } else { 
                        value = String.format(template, "MM", "yyyy", "dd");
                    }
                } else { 
                    if (month < year) {
                        value = String.format(template, "dd", "MM", "yyyy");
                    } else { 
                        value = String.format(template, "dd", "yyyy", "MM");
                    }
                }
                return value;
            }
        }
        value = context.getString(R.string.numeric_date_format);
        return value;
    }

    
        public static final java.text.DateFormat getLongDateFormat(Context context) {
        return java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG);
    }

    
        public static final java.text.DateFormat getMediumDateFormat(Context context) {
        return java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM);
    }

    
        public static final char[] getDateFormatOrder(Context context) {
        char[] order = new char[] {DATE, MONTH, YEAR};
        String value = getDateFormatString(context);
        int index = 0;
        boolean foundDate = false;
        boolean foundMonth = false;
        boolean foundYear = false;
        for (char c : value.toCharArray()) {
            if (!foundDate && (c == DATE)) {
                foundDate = true;
                order[index] = DATE;
                index++;
            }
            if (!foundMonth && (c == MONTH)) {
                foundMonth = true;
                order[index] = MONTH;
                index++;
            }
            if (!foundYear && (c == YEAR)) {
                foundYear = true;
                order[index] = YEAR;
                index++;
            }
        }
        return order;
    }

    
        private static String getDateFormatString(Context context) {
        String value = Settings.System.getString(context.getContentResolver(),
                Settings.System.DATE_FORMAT);
        return getDateFormatStringForSetting(context, value);
    }

    
        public static final CharSequence format(CharSequence inFormat, long inTimeInMillis) {
        return format(inFormat, new Date(inTimeInMillis));
    }

    
        public static final CharSequence format(CharSequence inFormat, Date inDate) {
        Calendar    c = new GregorianCalendar();
        c.setTime(inDate);
        return format(inFormat, c);
    }

    
        public static final CharSequence format(CharSequence inFormat, Calendar inDate) {
        SpannableStringBuilder      s = new SpannableStringBuilder(inFormat);
        int             c;
        int             count;
        int len = inFormat.length();
        for (int i = 0; i < len; i += count) {
            int temp;
            count = 1;
            c = s.charAt(i);
            if (c == QUOTE) {
                count = appendQuotedText(s, i, len);
                len = s.length();
                continue;
            }
            while ((i + count < len) && (s.charAt(i + count) == c)) {
                count++;
            }
            String replacement;
            switch (c) {
                case AM_PM:
                    replacement = DateUtils.getAMPMString(inDate.get(Calendar.AM_PM));
                    break;
                case CAPITAL_AM_PM:
                    replacement = DateUtils.getAMPMString(inDate.get(Calendar.AM_PM));
                    break;
                case DATE:
                    replacement = zeroPad(inDate.get(Calendar.DATE), count);
                    break;
                case DAY:
                    temp = inDate.get(Calendar.DAY_OF_WEEK);
                    replacement = DateUtils.getDayOfWeekString(temp,
                                                               count < 4 ? 
                                                               DateUtils.LENGTH_MEDIUM : 
                                                               DateUtils.LENGTH_LONG);
                    break;
                case HOUR:
                    temp = inDate.get(Calendar.HOUR);
                    if (0 == temp)
                        temp = 12;
                    replacement = zeroPad(temp, count);
                    break;
                case HOUR_OF_DAY:
                    replacement = zeroPad(inDate.get(Calendar.HOUR_OF_DAY), count);
                    break;
                case MINUTE:
                    replacement = zeroPad(inDate.get(Calendar.MINUTE), count);
                    break;
                case MONTH:
                    replacement = getMonthString(inDate, count);
                    break;
                case SECONDS:
                    replacement = zeroPad(inDate.get(Calendar.SECOND), count);
                    break;
                case TIME_ZONE:
                    replacement = getTimeZoneString(inDate, count);
                    break;
                case YEAR:
                    replacement = getYearString(inDate, count);
                    break;
                default:
                    replacement = null;
                    break;
            }
            if (replacement != null) {
                s.replace(i, i + count, replacement);
                count = replacement.length(); 
                len = s.length();
            }
        }
        if (inFormat instanceof Spanned)
            return new SpannedString(s);
        else
            return s.toString();
    }

    
        private static final String getMonthString(Calendar inDate, int count) {
        int month = inDate.get(Calendar.MONTH);
        if (count >= 4)
            return DateUtils.getMonthString(month, DateUtils.LENGTH_LONG);
        else if (count == 3)
            return DateUtils.getMonthString(month, DateUtils.LENGTH_MEDIUM);
        else {
            return zeroPad(month+1, count);
        }
    }

    
        private static final String getTimeZoneString(Calendar inDate, int count) {
        TimeZone tz = inDate.getTimeZone();
        if (count < 2) { 
            return formatZoneOffset(inDate.get(Calendar.DST_OFFSET) +
                                    inDate.get(Calendar.ZONE_OFFSET),
                                    count);
        } else {
            boolean dst = inDate.get(Calendar.DST_OFFSET) != 0;
            return tz.getDisplayName(dst, TimeZone.SHORT);
        }
    }

    
        private static final String formatZoneOffset(int offset, int count) {
        offset /= 1000;
        StringBuilder tb = new StringBuilder();
        if (offset < 0) {
            tb.insert(0, "-");
            offset = -offset;
        } else {
            tb.insert(0, "+");
        }
        int hours = offset / 3600;
        int minutes = (offset % 3600) / 60;
        tb.append(zeroPad(hours, 2));
        tb.append(zeroPad(minutes, 2));
        return tb.toString();
    }

    
        private static final String getYearString(Calendar inDate, int count) {
        int year = inDate.get(Calendar.YEAR);
        return (count <= 2) ? zeroPad(year % 100, 2) : String.valueOf(year);
    }

    
        private static final int appendQuotedText(SpannableStringBuilder s, int i, int len) {
        if (i + 1 < len && s.charAt(i + 1) == QUOTE) {
            s.delete(i, i + 1);
            return 1;
        }
        int count = 0;
        s.delete(i, i + 1);
        len--;
        while (i < len) {
            char c = s.charAt(i);
            if (c == QUOTE) {
                if (i + 1 < len && s.charAt(i + 1) == QUOTE) {
                    s.delete(i, i + 1);
                    len--;
                    count++;
                    i++;
                } else {
                    s.delete(i, i + 1);
                    break;
                }
            } else {
                i++;
                count++;
            }
        }
        return count;
    }

    
        private static final String zeroPad(int inValue, int inMinDigits) {
        String val = String.valueOf(inValue);
        if (val.length() < inMinDigits) {
            char[] buf = new char[inMinDigits];
            for (int i = 0; i < inMinDigits; i++)
                buf[i] = '0';
            val.getChars(0, val.length(), buf, inMinDigits - val.length());
            val = new String(buf);
        }
        return val;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "DBC13028CDA4AA8FE6B2F5583DCCC360", hash_generated_field = "250A84389E130C726113284F2D117A00")

    public  static final char    QUOTE                  =    '\'';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "F3E70AA8C5E0344CEE66C4E856D83FBB", hash_generated_field = "16093291ABEFB472FBE1F3FEF4023988")

    public  static final char    AM_PM                  =    'a';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "8FA5FF45D8FEDDEFA32C774836390C6E", hash_generated_field = "9B7136CFCD8022B9C61259E68F2D56A5")

    public  static final char    CAPITAL_AM_PM          =    'A';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "C28932E185C26B878DA498325DB9EAFB", hash_generated_field = "5D54378F1E1E8673FEB1D6D040ACD156")

    public  static final char    DATE                   =    'd';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "02CEA295A3ED4CD7DED9B0EC936F9D95", hash_generated_field = "5A53B128E46D6BA59FBFBB13B828F69D")

    public  static final char    DAY                    =    'E';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "6345F00980E16F356CC9D0351A7F4FC6", hash_generated_field = "613A1CD7DCE462E205EBA8126B697902")

    public  static final char    HOUR                   =    'h';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "4DF1265A6CF2426F63AB5D182484227A", hash_generated_field = "10470B1D7CBA625E2E9CEBCFD571802E")

    public  static final char    HOUR_OF_DAY            =    'k';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "456126919A49C4248E3949C410A2046F", hash_generated_field = "B4992C56769E8673618C8FEA85DC5010")

    public  static final char    MINUTE                 =    'm';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "D90857C2693A6F118D917B4D702654ED", hash_generated_field = "3765CF3C3E8B2767C0D82BAC9274FAE1")

    public  static final char    MONTH                  =    'M';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "2D9367A98397CCB79919394D68E4E635", hash_generated_field = "6F43AB9201DB419BC629D6FFFEC9B8DA")

    public  static final char    SECONDS                =    's';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "5329A427C44652F846BC5F26B62209B4", hash_generated_field = "93F1A65F4251064F2BA64FB11B049AD7")

    public  static final char    TIME_ZONE              =    'z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "CCC53AF6B065086F32549AAD5F6D47E3", hash_generated_field = "670716792657D0E9DD7069832C0E534E")

    public  static final char    YEAR                   =    'y';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "CAEA37DA1A95A3A11078061B01A70F48", hash_generated_field = "AAE447C6BB21DFB2195044EACE33BBDF")

    private static final Object sLocaleLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "81DE3EB1814493ACBA0877DB43FB18D4", hash_generated_field = "872809FA2AF3A2EA3BD5FBFC0313FA4E")

    private static Locale sIs24HourLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:45.865 -0400", hash_original_field = "DC4C8E22D96C40FC0CF11680165A67FD", hash_generated_field = "C14F0D97025D8697B6AE4E5D56399951")

    private static boolean sIs24Hour;
}

