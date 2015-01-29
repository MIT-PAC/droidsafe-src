package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class PasswordAuthentication {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.452 -0500", hash_original_field = "603671BF518F3A411771AE6211095177", hash_generated_field = "4011AE72656FEC39CB60833262E361C8")

    private String userName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.454 -0500", hash_original_field = "21BCD293DE862031F898430214E88677", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;

    /**
     * Creates an instance of a password authentication with a specified
     * username and password.
     *
     * @param userName
     *            the username to store.
     * @param password
     *            the associated password to store.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.457 -0500", hash_original_method = "5D7214C35F0B8EFCD4776395D10A0F27", hash_generated_method = "29ACC9DE2D8A4C1B8CFCE6AA59A2D59D")
    
public PasswordAuthentication(String userName, char[] password) {
        this.userName = userName;
        this.password = password.clone();
    }

    /**
     * Gets a clone of the password stored by this instance. The user is
     * responsible to finalize the returned array if the password clone is no
     * longer needed.
     *
     * @return the copied password.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.459 -0500", hash_original_method = "79A6CAB64FA4B390A39CA60FAD9B839D", hash_generated_method = "C814E988AE5D6DF03B812A5ABE48A46E")
    
public char[] getPassword() {
        return password.clone();
    }

    /**
     * Gets the username stored by this instance.
     *
     * @return the stored username.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.461 -0500", hash_original_method = "AE8C8ADC981355D9DAA86F7D72E53644", hash_generated_method = "A531C69D4F950205F39A1FFF6AFE3034")
    
public String getUserName() {
        return userName;
    }
    
}

