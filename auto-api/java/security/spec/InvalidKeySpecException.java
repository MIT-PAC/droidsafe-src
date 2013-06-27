package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class InvalidKeySpecException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.631 -0400", hash_original_method = "DB6EC4555D24FA0B7F53C3D0CF9817D1", hash_generated_method = "AB28894F018080560CCAE565B0A64445")
    public  InvalidKeySpecException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.631 -0400", hash_original_method = "62E7948E21963822758AD86C4EE61479", hash_generated_method = "375CBDDC3236D67BD233F634A596B6E0")
    public  InvalidKeySpecException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.632 -0400", hash_original_method = "164335802BFF46F4D28D2A0D3E3265D8", hash_generated_method = "CAE3251672647854362B9BE2AF788ACB")
    public  InvalidKeySpecException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.632 -0400", hash_original_method = "64F8C7884589B108D58D14C2DB6A45FC", hash_generated_method = "0D59CB40A6BBA4C4E532A44F22B2673E")
    public  InvalidKeySpecException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.632 -0400", hash_original_field = "F17171D54F14DC33B0940EA4A66899BF", hash_generated_field = "E2D0BF9DFB11D673749DD13AD47CBC26")

    private static long serialVersionUID = 3546139293998810778L;
}

