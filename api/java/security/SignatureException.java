package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SignatureException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.545 -0400", hash_original_method = "1A64E23BD4BC60E25E0621B283BA1364", hash_generated_method = "C71B9CE6B395B0E57D426F180728D6CC")
    public  SignatureException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.545 -0400", hash_original_method = "FC81C3C47A9C38543897BA92BDE9ED63", hash_generated_method = "9B6C915C21DA34F6FA6FCE12975D4CE6")
    public  SignatureException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.546 -0400", hash_original_method = "016680A93C61AAA9E83AF67D8C91F93A", hash_generated_method = "235295AC12209FD131042B171620EDED")
    public  SignatureException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.546 -0400", hash_original_method = "3352DA5C6676595EED2C0C966A19B61C", hash_generated_method = "895EECBC965475F068EB6F442AE732E8")
    public  SignatureException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.546 -0400", hash_original_field = "A038CA2BE43CB77D44777E4A7BF1B467", hash_generated_field = "8852B99AF1FA24D08606C87FCCB86602")

    private static final long serialVersionUID = 7509989324975124438L;
}

