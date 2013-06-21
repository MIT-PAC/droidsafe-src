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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.136 -0400", hash_original_method = "C9ACF49A02C5E86491289146388B2085", hash_generated_method = "C9ACF49A02C5E86491289146388B2085")
        public HttpDate ()
    {
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

    
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.137 -0400", hash_original_method = "884CECE43D2C8988F9978CEA7BD2135F", hash_generated_method = "85E232D75B273FFDF8CD45ADB9013ECF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected DateFormat initialValue() {
            DateFormat rfc1123;
            rfc1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            rfc1123.setTimeZone(TimeZone.getTimeZone("UTC"));
            return (DateFormat)dsTaint.getTaint();
            // ---------- Original Method ----------
            //DateFormat rfc1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            //rfc1123.setTimeZone(TimeZone.getTimeZone("UTC"));
            //return rfc1123;
        }

        
}; //Transformed anonymous class
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

