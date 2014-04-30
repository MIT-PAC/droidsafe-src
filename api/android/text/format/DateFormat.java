package android.text.format;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import android.content.Context;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;

import com.android.internal.R;

public class DateFormat {

    /**
     * Returns true if user preference is set to 24-hour format.
     * @param context the context to use for the content resolver
     * @return true if 24 hour time format is selected, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.144 -0500", hash_original_method = "E5AB6833BD9B82E228B17845C6EA8653", hash_generated_method = "AB0FFB3AEC8ABA85D7943D4EBCB83DC4")
    
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

    /**
     * Returns a {@link java.text.DateFormat} object that can format the time according
     * to the current locale and the user's 12-/24-hour clock preference.
     * @param context the application context
     * @return the {@link java.text.DateFormat} object that properly formats the time.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.147 -0500", hash_original_method = "71FE993D45AFD9417B89B7CB5C26B27B", hash_generated_method = "CBEC912AD7610BF8D67E68424199304C")
    
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

    /**
     * Returns a {@link java.text.DateFormat} object that can format the date 
     * in short form (such as 12/31/1999) according
     * to the current locale and the user's date-order preference.
     * @param context the application context
     * @return the {@link java.text.DateFormat} object that properly formats the date.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.149 -0500", hash_original_method = "31DB25FCF5E17D5BA39D40A6AB758B79", hash_generated_method = "5AEC6419123B2A4BF329169CFA1989C5")
    
public static final java.text.DateFormat getDateFormat(Context context) {
        String value = Settings.System.getString(context.getContentResolver(),
                Settings.System.DATE_FORMAT);

        return getDateFormatForSetting(context, value);
    }

    /**
     * Returns a {@link java.text.DateFormat} object to format the date
     * as if the date format setting were set to <code>value</code>,
     * including null to use the locale's default format.
     * @param context the application context
     * @param value the date format setting string to interpret for
     *              the current locale
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.152 -0500", hash_original_method = "E08C4A6180FCBAD756891AB6B54F23BC", hash_generated_method = "BCF21067BBFCE97B90A19D2C958E341B")
    
public static java.text.DateFormat getDateFormatForSetting(Context context,
                                                               String value) {
        String format = getDateFormatStringForSetting(context, value);

        return new java.text.SimpleDateFormat(format);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.155 -0500", hash_original_method = "32A5D141E416AE9044FB1BE5A731640E", hash_generated_method = "4E8409AE4FF1E42F9CDEFE7D2F3E60EE")
    
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
                    } else { // unlikely
                        value = String.format(template, "MM", "yyyy", "dd");
                    }
                } else { // day < month
                    if (month < year) {
                        value = String.format(template, "dd", "MM", "yyyy");
                    } else { // unlikely
                        value = String.format(template, "dd", "yyyy", "MM");
                    }
                }

                return value;
            }
        }

        /*
         * The setting is not set; use the default.
         * We use a resource string here instead of just DateFormat.SHORT
         * so that we get a four-digit year instead a two-digit year.
         */
        value = context.getString(R.string.numeric_date_format);
        return value;
    }
    
    /**
     * Returns a {@link java.text.DateFormat} object that can format the date
     * in long form (such as December 31, 1999) for the current locale.
     * @param context the application context
     * @return the {@link java.text.DateFormat} object that formats the date in long form.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.160 -0500", hash_original_method = "2A3978E636FD74D0DA3D3D064C7B50BA", hash_generated_method = "383D75750E7492A1500CF3750B10302E")
    
public static final java.text.DateFormat getLongDateFormat(Context context) {
        return java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG);
    }

    /**
     * Returns a {@link java.text.DateFormat} object that can format the date
     * in medium form (such as Dec. 31, 1999) for the current locale.
     * @param context the application context
     * @return the {@link java.text.DateFormat} object that formats the date in long form.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.162 -0500", hash_original_method = "AA9003CA5933631AE307343983461627", hash_generated_method = "EC5E4BF9F43BDF921F57A24485470A00")
    
public static final java.text.DateFormat getMediumDateFormat(Context context) {
        return java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM);
    }

    /**
     * Gets the current date format stored as a char array. The array will contain
     * 3 elements ({@link #DATE}, {@link #MONTH}, and {@link #YEAR}) in the order    
     * specified by the user's format preference.  Note that this order is
     * only appropriate for all-numeric dates; spelled-out (MEDIUM and LONG)
     * dates will generally contain other punctuation, spaces, or words,
     * not just the day, month, and year, and not necessarily in the same
     * order returned here.
     */    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.166 -0500", hash_original_method = "AFEFE08A10E9D5121F8D0F8F87F0469D", hash_generated_method = "C0D212969C3E423BDD19028625D38031")
    
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.168 -0500", hash_original_method = "566994D4112DFC120EA25833B7A2AD23", hash_generated_method = "6DC8D650167CE81590C08346D1F88C9B")
    
private static String getDateFormatString(Context context) {
        String value = Settings.System.getString(context.getContentResolver(),
                Settings.System.DATE_FORMAT);

        return getDateFormatStringForSetting(context, value);
    }

    /**
     * Given a format string and a time in milliseconds since Jan 1, 1970 GMT, returns a 
     * CharSequence containing the requested date.
     * @param inFormat the format string, as described in {@link android.text.format.DateFormat}
     * @param inTimeInMillis in milliseconds since Jan 1, 1970 GMT
     * @return a {@link CharSequence} containing the requested text
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.172 -0500", hash_original_method = "DB5E1435497B50A83BF83DDB6082161C", hash_generated_method = "FDB2FAFA7D11C2731B9585F51D9312E1")
    
public static final CharSequence format(CharSequence inFormat, long inTimeInMillis) {
        return format(inFormat, new Date(inTimeInMillis));
    }

    /**
     * Given a format string and a {@link java.util.Date} object, returns a CharSequence containing
     * the requested date.
     * @param inFormat the format string, as described in {@link android.text.format.DateFormat}
     * @param inDate the date to format
     * @return a {@link CharSequence} containing the requested text
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.174 -0500", hash_original_method = "E0419C3C471C7E345983AE259311718A", hash_generated_method = "3F9D986BBECCB6EB224C8C601A3AFC67")
    
public static final CharSequence format(CharSequence inFormat, Date inDate) {
        Calendar    c = new GregorianCalendar();
        
        c.setTime(inDate);
        
        return format(inFormat, c);
    }

    /**
     * Given a format string and a {@link java.util.Calendar} object, returns a CharSequence 
     * containing the requested date.
     * @param inFormat the format string, as described in {@link android.text.format.DateFormat}
     * @param inDate the date to format
     * @return a {@link CharSequence} containing the requested text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.179 -0500", hash_original_method = "1E7FCBB9BDAB6241DCC43FD2CDBCAE7C", hash_generated_method = "35A0B093592D9F22C9A064893A06A86F")
    
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
                    //FIXME: this is the same as AM_PM? no capital?
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
                count = replacement.length(); // CARE: count is used in the for loop above
                len = s.length();
            }
        }
        
        if (inFormat instanceof Spanned)
            return new SpannedString(s);
        else
            return s.toString();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.182 -0500", hash_original_method = "B6328CDAAE059376F42670F10E94C3C7", hash_generated_method = "9324B5CE870AACE0BA47C45A3543CFCF")
    
private static final String getMonthString(Calendar inDate, int count) {
        int month = inDate.get(Calendar.MONTH);
        
        if (count >= 4)
            return DateUtils.getMonthString(month, DateUtils.LENGTH_LONG);
        else if (count == 3)
            return DateUtils.getMonthString(month, DateUtils.LENGTH_MEDIUM);
        else {
            // Calendar.JANUARY == 0, so add 1 to month.
            return zeroPad(month+1, count);
        }
    }
        
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.185 -0500", hash_original_method = "717F8011BB33AD60A52972788AFDBE92", hash_generated_method = "89B2030A9561BD57E99AC98ADEE25225")
    
private static final String getTimeZoneString(Calendar inDate, int count) {
        TimeZone tz = inDate.getTimeZone();
        
        if (count < 2) { // FIXME: shouldn't this be <= 2 ?
            return formatZoneOffset(inDate.get(Calendar.DST_OFFSET) +
                                    inDate.get(Calendar.ZONE_OFFSET),
                                    count);
        } else {
            boolean dst = inDate.get(Calendar.DST_OFFSET) != 0;
            return tz.getDisplayName(dst, TimeZone.SHORT);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.188 -0500", hash_original_method = "DCEF93C8648F8A4BADBE0DEB45045CC3", hash_generated_method = "7B7892A12E677D66BCA3E5B7D1B19DAB")
    
private static final String formatZoneOffset(int offset, int count) {
        offset /= 1000; // milliseconds to seconds
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.191 -0500", hash_original_method = "61C8A1A7F87CCD34E1CB408B77469F5C", hash_generated_method = "AD8F947AB2F17726ADEE4FEB87658605")
    
private static final String getYearString(Calendar inDate, int count) {
        int year = inDate.get(Calendar.YEAR);
        return (count <= 2) ? zeroPad(year % 100, 2) : String.valueOf(year);
    }
   
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.195 -0500", hash_original_method = "636A48F51D0980A4E6BB5D7F973D5483", hash_generated_method = "1B17694B1880264A26674589EE8C8527")
    
private static final int appendQuotedText(SpannableStringBuilder s, int i, int len) {
        if (i + 1 < len && s.charAt(i + 1) == QUOTE) {
            s.delete(i, i + 1);
            return 1;
        }

        int count = 0;

        // delete leading quote
        s.delete(i, i + 1);
        len--;

        while (i < len) {
            char c = s.charAt(i);

            if (c == QUOTE) {
                //  QUOTEQUOTE -> QUOTE
                if (i + 1 < len && s.charAt(i + 1) == QUOTE) {

                    s.delete(i, i + 1);
                    len--;
                    count++;
                    i++;
                } else {
                    //  Closing QUOTE ends quoted text copying
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.198 -0500", hash_original_method = "5A00C98C01DB41A2F1A77A0819740F7C", hash_generated_method = "49A2586C850B0856347F2CED3B587F5D")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.100 -0500", hash_original_field = "6B3E51976BB1EC7EE489E9F85EC7B58A", hash_generated_field = "250A84389E130C726113284F2D117A00")

    public  static final char    QUOTE                  =    '\'';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.103 -0500", hash_original_field = "1A4EE042261280E397034EC0E516672B", hash_generated_field = "16093291ABEFB472FBE1F3FEF4023988")

    public  static final char    AM_PM                  =    'a';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.106 -0500", hash_original_field = "6FB7D38D9E6DDEBD95DFD3929F9F05BE", hash_generated_field = "9B7136CFCD8022B9C61259E68F2D56A5")

    public  static final char    CAPITAL_AM_PM          =    'A';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.109 -0500", hash_original_field = "65014EC6E144E18A831B9BCBF62362F7", hash_generated_field = "5D54378F1E1E8673FEB1D6D040ACD156")

    public  static final char    DATE                   =    'd';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.112 -0500", hash_original_field = "B00882DAF304BF3599D65DC438CC9F8D", hash_generated_field = "5A53B128E46D6BA59FBFBB13B828F69D")

    public  static final char    DAY                    =    'E';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.115 -0500", hash_original_field = "B423397E297495E9A2BE24DA3E005E28", hash_generated_field = "613A1CD7DCE462E205EBA8126B697902")

    public  static final char    HOUR                   =    'h';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.118 -0500", hash_original_field = "DB432F36A1C9D5C8626D21EC28E04935", hash_generated_field = "10470B1D7CBA625E2E9CEBCFD571802E")

    public  static final char    HOUR_OF_DAY            =    'k';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.121 -0500", hash_original_field = "1D42B51096A784F674C3669FD0C1E0EB", hash_generated_field = "B4992C56769E8673618C8FEA85DC5010")

    public  static final char    MINUTE                 =    'm';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.124 -0500", hash_original_field = "B779E707DAB0BCFD2C6CF564381F203D", hash_generated_field = "3765CF3C3E8B2767C0D82BAC9274FAE1")

    public  static final char    MONTH                  =    'M';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.127 -0500", hash_original_field = "E3853FE52A3B791FB6C808C2CB9CC186", hash_generated_field = "6F43AB9201DB419BC629D6FFFEC9B8DA")

    public  static final char    SECONDS                =    's';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.129 -0500", hash_original_field = "47DEA5ADCB028D52F18F8E17394E536A", hash_generated_field = "93F1A65F4251064F2BA64FB11B049AD7")

    public  static final char    TIME_ZONE              =    'z';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.132 -0500", hash_original_field = "F72281817953DA925221524BDB52358B", hash_generated_field = "670716792657D0E9DD7069832C0E534E")

    public  static final char    YEAR                   =    'y';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.135 -0500", hash_original_field = "61DC592BCCEB048C6E6CACD1439CA4DE", hash_generated_field = "AAE447C6BB21DFB2195044EACE33BBDF")

    private static final Object sLocaleLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.137 -0500", hash_original_field = "0361EEF44E717D9DAF07EB1CAF9D07BF", hash_generated_field = "872809FA2AF3A2EA3BD5FBFC0313FA4E")

    private static Locale sIs24HourLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.140 -0500", hash_original_field = "4C1DE63FA6BE6A6DDCEC50749B78D69C", hash_generated_field = "C14F0D97025D8697B6AE4E5D56399951")

    private static boolean sIs24Hour;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.413 -0400", hash_original_method = "4FB6BE40E4FA388ABA6A7CE788B3C64B", hash_generated_method = "4FB6BE40E4FA388ABA6A7CE788B3C64B")
    public DateFormat ()
    {
        //Synthesized constructor
    }
}

