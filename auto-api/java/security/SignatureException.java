package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SignatureException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.244 -0400", hash_original_method = "1A64E23BD4BC60E25E0621B283BA1364", hash_generated_method = "C71B9CE6B395B0E57D426F180728D6CC")
    public  SignatureException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.245 -0400", hash_original_method = "FC81C3C47A9C38543897BA92BDE9ED63", hash_generated_method = "9B6C915C21DA34F6FA6FCE12975D4CE6")
    public  SignatureException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.245 -0400", hash_original_method = "016680A93C61AAA9E83AF67D8C91F93A", hash_generated_method = "7B2B2FCF730A3EC94A2F3211A556607F")
    public  SignatureException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.245 -0400", hash_original_method = "3352DA5C6676595EED2C0C966A19B61C", hash_generated_method = "895EECBC965475F068EB6F442AE732E8")
    public  SignatureException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.245 -0400", hash_original_field = "A038CA2BE43CB77D44777E4A7BF1B467", hash_generated_field = "072043A767404BD281E6C2C5243BC44F")

    private static long serialVersionUID = 7509989324975124438L;
}

