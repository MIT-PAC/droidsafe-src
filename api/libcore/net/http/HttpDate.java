package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class HttpDate {

    /**
     * Returns the date for {@code value}. Returns null if the value couldn't be
     * parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.094 -0500", hash_original_method = "4E4294A231C025C52A332D4C9E438EF3", hash_generated_method = "26D4025E49970D7630B2DC56E7555674")
    
public static Date parse(String value) {
        try {
            return STANDARD_DATE_FORMAT.get().parse(value);
        } catch (ParseException ignore) {
        }
        for (String formatString : BROWSER_COMPATIBLE_DATE_FORMATS) {
            try {
                return new SimpleDateFormat(formatString, Locale.US).parse(value);
            } catch (ParseException ignore) {
            }
        }
        return null;
    }

    /**
     * Returns the string for {@code value}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.096 -0500", hash_original_method = "EA7DEE8E3C730970C4001E63A088D685", hash_generated_method = "E81B2DAF7930C84C4E2B73F1855BB57C")
    
public static String format(Date value) {
        return STANDARD_DATE_FORMAT.get().format(value);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.807 -0400", hash_original_field = "7070321CEDCE8DDA350092605D887EA6", hash_generated_field = "CF56E75DA635218131CA8ED5FD9CB318")

    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.807 -0400", hash_original_method = "884CECE43D2C8988F9978CEA7BD2135F", hash_generated_method = "C825C1CF5D34F144303E23409DAA668A")
        @Override
        protected DateFormat initialValue() {
            DateFormat varB4EAC82CA7396A68D541C85D26508E83_748319768 = null; 
            DateFormat rfc1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            rfc1123.setTimeZone(TimeZone.getTimeZone("UTC"));
            varB4EAC82CA7396A68D541C85D26508E83_748319768 = rfc1123;
            varB4EAC82CA7396A68D541C85D26508E83_748319768.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_748319768;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.091 -0500", hash_original_field = "1C8CEDAF61B9471A928C540FEDF2383A", hash_generated_field = "75790BD0D521D57ABCF72CD45F74CCDF")

    private static final String[] BROWSER_COMPATIBLE_DATE_FORMATS = new String[] {
            /* This list comes from  {@code org.apache.http.impl.cookie.BrowserCompatSpec}. */
            "EEEE, dd-MMM-yy HH:mm:ss zzz", // RFC 1036
            "EEE MMM d HH:mm:ss yyyy", // ANSI C asctime()
            "EEE, dd-MMM-yyyy HH:mm:ss z",
            "EEE, dd-MMM-yyyy HH-mm-ss z",
            "EEE, dd MMM yy HH:mm:ss z",
            "EEE dd-MMM-yyyy HH:mm:ss z",
            "EEE dd MMM yyyy HH:mm:ss z",
            "EEE dd-MMM-yyyy HH-mm-ss z",
            "EEE dd-MMM-yy HH:mm:ss z",
            "EEE dd MMM yy HH:mm:ss z",
            "EEE,dd-MMM-yy HH:mm:ss z",
            "EEE,dd-MMM-yyyy HH:mm:ss z",
            "EEE, dd-MM-yyyy HH:mm:ss z",

            /* RI bug 6641315 claims a cookie of this format was once served by www.yahoo.com */
            "EEE MMM d yyyy HH:mm:ss z",
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.172 -0400", hash_original_method = "0136B205498F115685D55FF9321B6B42", hash_generated_method = "0136B205498F115685D55FF9321B6B42")
    public HttpDate ()
    {
        //Synthesized constructor
    }
}

