package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.535 -0400", hash_original_method = "48D34D966FD8EAADA4B9042FB2D410CB", hash_generated_method = "F2D2192E1AB0D80DE38C401BF608C353")
    private  DateUtils() {
        
    }

    
        public static Date parseDate(String dateValue) throws DateParseException {
        return parseDate(dateValue, null, null);
    }

    
        public static Date parseDate(final String dateValue, String[] dateFormats) throws DateParseException {
        return parseDate(dateValue, dateFormats, null);
    }

    
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
            }
        }
        throw new DateParseException("Unable to parse the date " + dateValue);
    }

    
        public static String formatDate(Date date) {
        return formatDate(date, PATTERN_RFC1123);
    }

    
        public static String formatDate(Date date, String pattern) {
        if (date == null) throw new IllegalArgumentException("date is null");
        if (pattern == null) throw new IllegalArgumentException("pattern is null");
        SimpleDateFormat formatter = DateFormatHolder.formatFor(pattern);
        return formatter.format(date);
    }

    
    final static class DateFormatHolder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.536 -0400", hash_original_method = "6FB3E28AC91977E78E839268C5DC660F", hash_generated_method = "6FB3E28AC91977E78E839268C5DC660F")
        public DateFormatHolder ()
        {
            
        }


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
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.537 -0400", hash_original_field = "8385826B3234ECEB289CAA862FF1A4B2", hash_generated_field = "4C394D5CADCD628D7373F95DB7006036")

    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.537 -0400", hash_original_field = "738C731AEFD7A71F84D06C5D256C466E", hash_generated_field = "B80A298901B78AFE77638CA599BCD6A0")

    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.537 -0400", hash_original_field = "B9B9F39F84AC1CC81FFD7BC2D3D1DE39", hash_generated_field = "2FAAFA8A33A639A51D421B0A22227474")

    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.537 -0400", hash_original_field = "444C2DA544FF1A5C0659716DCB5ECF34", hash_generated_field = "4BA37EA834B7C65E3B0C18FFD5AC8C26")

    private static final String[] DEFAULT_PATTERNS = new String[] {
    	PATTERN_RFC1036,
    	PATTERN_RFC1123,
        PATTERN_ASCTIME
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.537 -0400", hash_original_field = "CE304DC78F351ECFD06CD7D303B3C51B", hash_generated_field = "5E940A040DBE4448C9671F88AC75ED62")

    private static Date DEFAULT_TWO_DIGIT_YEAR_START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.537 -0400", hash_original_field = "E12B34FD92B4631CB840A76131270F12", hash_generated_field = "3A278BEAEB75318EBD87EA7DAAF24AD0")

    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    static {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(GMT);
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = calendar.getTime(); 
    }
    
}

