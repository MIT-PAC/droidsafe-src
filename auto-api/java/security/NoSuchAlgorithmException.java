package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchAlgorithmException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.309 -0400", hash_original_method = "8378123FC231FFDF9C6899E890D8DBB0", hash_generated_method = "3A8D9EE1098E6C39699D65C685A657C2")
    public  NoSuchAlgorithmException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.309 -0400", hash_original_method = "BDAEA1DD03CDDD29A73CAE9E450C10A2", hash_generated_method = "6779E68168EEB1D0C958B92A65CCA975")
    public  NoSuchAlgorithmException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.309 -0400", hash_original_method = "738326F937D05503D0FB4C9FA84CE359", hash_generated_method = "47F24BCA0A3FC50EF60FD112F6382D84")
    public  NoSuchAlgorithmException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.309 -0400", hash_original_method = "24E352B1812045F462874BBBC93C9102", hash_generated_method = "B931096311E6C72CD2BCDE3A2D281271")
    public  NoSuchAlgorithmException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.309 -0400", hash_original_field = "32F3C8473262988C228D1AB948E0F8CE", hash_generated_field = "171AD030B0C8CBEDB18B2A2EE06BA912")

    private static long serialVersionUID = -7443947487218346562L;
}

