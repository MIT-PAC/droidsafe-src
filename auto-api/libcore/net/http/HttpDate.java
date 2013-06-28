package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class HttpDate {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.806 -0400", hash_original_method = "0136B205498F115685D55FF9321B6B42", hash_generated_method = "0136B205498F115685D55FF9321B6B42")
    public HttpDate ()
    {
        //Synthesized constructor
    }


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

    
    public static String format(Date value) {
        return STANDARD_DATE_FORMAT.get().format(value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.807 -0400", hash_original_field = "7070321CEDCE8DDA350092605D887EA6", hash_generated_field = "CF56E75DA635218131CA8ED5FD9CB318")

    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.807 -0400", hash_original_method = "884CECE43D2C8988F9978CEA7BD2135F", hash_generated_method = "C825C1CF5D34F144303E23409DAA668A")
        @Override
        protected DateFormat initialValue() {
            DateFormat varB4EAC82CA7396A68D541C85D26508E83_748319768 = null; //Variable for return #1
            DateFormat rfc1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            rfc1123.setTimeZone(TimeZone.getTimeZone("UTC"));
            varB4EAC82CA7396A68D541C85D26508E83_748319768 = rfc1123;
            varB4EAC82CA7396A68D541C85D26508E83_748319768.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_748319768;
            // ---------- Original Method ----------
            //DateFormat rfc1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            //rfc1123.setTimeZone(TimeZone.getTimeZone("UTC"));
            //return rfc1123;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.807 -0400", hash_original_field = "1A5262111CAC9B43E8DD975F2EB0643F", hash_generated_field = "BEEAED429442B6C53D9D9D627997B72C")

    private static final String[] BROWSER_COMPATIBLE_DATE_FORMATS = new String[] {
            
            "EEEE, dd-MMM-yy HH:mm:ss zzz", 
            "EEE MMM d HH:mm:ss yyyy", 
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

            
            "EEE MMM d yyyy HH:mm:ss z",
    };
}

