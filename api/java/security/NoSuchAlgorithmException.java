package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class NoSuchAlgorithmException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.131 -0400", hash_original_method = "8378123FC231FFDF9C6899E890D8DBB0", hash_generated_method = "3A8D9EE1098E6C39699D65C685A657C2")
    public  NoSuchAlgorithmException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.131 -0400", hash_original_method = "BDAEA1DD03CDDD29A73CAE9E450C10A2", hash_generated_method = "6779E68168EEB1D0C958B92A65CCA975")
    public  NoSuchAlgorithmException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.132 -0400", hash_original_method = "738326F937D05503D0FB4C9FA84CE359", hash_generated_method = "2F050E61EA34B409AB1699CEB6E3E572")
    public  NoSuchAlgorithmException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.132 -0400", hash_original_method = "24E352B1812045F462874BBBC93C9102", hash_generated_method = "B931096311E6C72CD2BCDE3A2D281271")
    public  NoSuchAlgorithmException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.132 -0400", hash_original_field = "32F3C8473262988C228D1AB948E0F8CE", hash_generated_field = "6FE1C320D9DA70D0E4A8AE85FC938A15")

    private static final long serialVersionUID = -7443947487218346562L;
}

