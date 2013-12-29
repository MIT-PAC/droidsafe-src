package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.SoftReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;




public final class DateUtils {
    
    /**
     * Parses a date value.  The formats used for parsing the date value are retrieved from
     * the default http params.
     *
     * @param dateValue the date value to parse
     * 
     * @return the parsed date
     *
     * @throws DateParseException if the value could not be parsed using any of the 
     * supported date formats
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.396 -0500", hash_original_method = "6166267645AF08CBDE09E0034E28CA3C", hash_generated_method = "A5E6C725D739B892A0631EB910719174")
    public static Date parseDate(String dateValue) throws DateParseException {
        return parseDate(dateValue, null, null);
    }
    
    /**
     * Parses the date value using the given date formats.
     * 
     * @param dateValue the date value to parse
     * @param dateFormats the date formats to use
     * 
     * @return the parsed date
     * 
     * @throws DateParseException if none of the dataFormats could parse the dateValue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.396 -0500", hash_original_method = "5FD28FD097FA7AFD0A367EAC6C59D766", hash_generated_method = "D479575CB2424DCD39BA62A902BB6AA3")
    public static Date parseDate(final String dateValue, String[] dateFormats) 
        throws DateParseException {
        return parseDate(dateValue, dateFormats, null);
    }
    
    /**
     * Parses the date value using the given date formats.
     * 
     * @param dateValue the date value to parse
     * @param dateFormats the date formats to use
     * @param startDate During parsing, two digit years will be placed in the range 
     * <code>startDate</code> to <code>startDate + 100 years</code>. This value may 
     * be <code>null</code>. When <code>null</code> is given as a parameter, year 
     * <code>2000</code> will be used. 
     * 
     * @return the parsed date
     * 
     * @throws DateParseException if none of the dataFormats could parse the dateValue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.397 -0500", hash_original_method = "54F9496B76E22DCCA8FF0A5B8A943002", hash_generated_method = "993738107803E3943239BD943931C67E")
    public static Date parseDate(
        String dateValue, 
        String[] dateFormats,
        Date startDate 
    ) throws DateParseException {
        
        if (dateValue == null) {
            throw new IllegalArgumentException("dateValue is null");
        }
        if (dateFormats == null) {
            dateFormats = DEFAULT_PATTERNS;
        }
        if (startDate == null) {
            startDate = DEFAULT_TWO_DIGIT_YEAR_START;
        }
        // trim single quotes around date if present
        // see issue #5279
        if (dateValue.length() > 1 
            && dateValue.startsWith("'") 
            && dateValue.endsWith("'")
        ) {
            dateValue = dateValue.substring (1, dateValue.length() - 1);
        }

        for (String dateFormat : dateFormats) {
            SimpleDateFormat dateParser = DateFormatHolder.formatFor(dateFormat);
            dateParser.set2DigitYearStart(startDate);

            try {
                return dateParser.parse(dateValue);
            } catch (ParseException pe) {
                // ignore this exception, we will try the next format
            }
        }
        
        // we were unable to parse the date
        throw new DateParseException("Unable to parse the date " + dateValue);        
    }

    /**
     * Formats the given date according to the RFC 1123 pattern.
     * 
     * @param date The date to format.
     * @return An RFC 1123 formatted date string.
     * 
     * @see #PATTERN_RFC1123
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.398 -0500", hash_original_method = "66D645225B00D19BD8F91A153166EE50", hash_generated_method = "FF33893603C1E5E241951E9F37ACAF7E")
    public static String formatDate(Date date) {
        return formatDate(date, PATTERN_RFC1123);
    }
    
    /**
     * Formats the given date according to the specified pattern.  The pattern
     * must conform to that used by the {@link SimpleDateFormat simple date
     * format} class.
     * 
     * @param date The date to format.
     * @param pattern The pattern to use for formatting the date.  
     * @return A formatted date string.
     * 
     * @throws IllegalArgumentException If the given date pattern is invalid.
     * 
     * @see SimpleDateFormat
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.399 -0500", hash_original_method = "6B278988893DFE2E8A5CC8A2996548D4", hash_generated_method = "939A99CAF9ED0BBA6E6FD3AF12D4D529")
    public static String formatDate(Date date, String pattern) {
        if (date == null) throw new IllegalArgumentException("date is null");
        if (pattern == null) throw new IllegalArgumentException("pattern is null");
        
        SimpleDateFormat formatter = DateFormatHolder.formatFor(pattern);
        return formatter.format(date);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.390 -0500", hash_original_field = "C98385C9500782E8D6C619F2F4D4E34D", hash_generated_field = "4C394D5CADCD628D7373F95DB7006036")

    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    
    final static class DateFormatHolder {

        /**
         * creates a {@link SimpleDateFormat} for the requested format string.
         * 
         * @param pattern
         *            a non-<code>null</code> format String according to
         *            {@link SimpleDateFormat}. The format is not checked against
         *            <code>null</code> since all paths go through
         *            {@link DateUtils}.
         * @return the requested format. This simple dateformat should not be used
         *         to {@link SimpleDateFormat#applyPattern(String) apply} to a
         *         different pattern.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.403 -0500", hash_original_method = "5D9163D62347670BAA9E97E0E486304F", hash_generated_method = "7A3EE3BE3184BA33E3F3130D3FFC2663")
        public static SimpleDateFormat formatFor(String pattern) {
            SoftReference<Map<String, SimpleDateFormat>> ref = THREADLOCAL_FORMATS.get();
            Map<String, SimpleDateFormat> formats = ref.get();
            if (formats == null) {
                formats = new HashMap<String, SimpleDateFormat>();
                THREADLOCAL_FORMATS.set(
                        new SoftReference<Map<String, SimpleDateFormat>>(formats));    
            }

            SimpleDateFormat format = formats.get(pattern);
            if (format == null) {
                format = new SimpleDateFormat(pattern, Locale.US);
                format.setTimeZone(TimeZone.getTimeZone("GMT"));
                formats.put(pattern, format);
            }

            return format;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.159 -0400", hash_original_field = "F739AADE8F0088A4E58211C56C35F437", hash_generated_field = "ADAA82333267496F40F5112F0DF68EE8")

        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.159 -0400", hash_original_method = "344E20B97AD97B49F3F39541DF8E3F01", hash_generated_method = "75FC8D79F7241F46085D7AEE2CD6464A")
            @Override
            protected SoftReference<Map<String, SimpleDateFormat>> initialValue() {
                SoftReference<Map<String, SimpleDateFormat>> varB4EAC82CA7396A68D541C85D26508E83_353515551 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_353515551 = new SoftReference<Map<String, SimpleDateFormat>>(
                        new HashMap<String, SimpleDateFormat>());
                varB4EAC82CA7396A68D541C85D26508E83_353515551.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_353515551;
                
                
                        
            }

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.866 -0400", hash_original_method = "6FB3E28AC91977E78E839268C5DC660F", hash_generated_method = "6FB3E28AC91977E78E839268C5DC660F")
        public DateFormatHolder ()
        {
            //Synthesized constructor
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.391 -0500", hash_original_field = "19C53457D79736FAA1EB10935EF7CF36", hash_generated_field = "B80A298901B78AFE77638CA599BCD6A0")

    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.391 -0500", hash_original_field = "42346194518FEC244094D6173086F6AC", hash_generated_field = "2FAAFA8A33A639A51D421B0A22227474")

    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.392 -0500", hash_original_field = "BD911E5E75510CD3E4D8D0D0A8F185FC", hash_generated_field = "4BA37EA834B7C65E3B0C18FFD5AC8C26")


    private static final String[] DEFAULT_PATTERNS = new String[] {
    	PATTERN_RFC1036,
    	PATTERN_RFC1123,
        PATTERN_ASCTIME
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.393 -0500", hash_original_field = "0C3FAA0B9C64436A4C6BA72E28AC89A5", hash_generated_field = "5E940A040DBE4448C9671F88AC75ED62")


    private static  Date DEFAULT_TWO_DIGIT_YEAR_START;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.394 -0500", hash_original_field = "1805E39C3A2BD113B25018C5FFF99805", hash_generated_field = "3A278BEAEB75318EBD87EA7DAAF24AD0")

    
    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    
    /** This class should not be instantiated. */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.400 -0500", hash_original_method = "48D34D966FD8EAADA4B9042FB2D410CB", hash_generated_method = "47C30919D1E228AF190D6E0D3F0530CF")
    private DateUtils() { 
    }
    static {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(GMT);
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = calendar.getTime(); 
    }
    
}

