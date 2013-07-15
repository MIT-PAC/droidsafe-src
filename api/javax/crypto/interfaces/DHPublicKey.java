package javax.crypto.interfaces;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.security.PublicKey;

public interface DHPublicKey extends DHKey, PublicKey {

    
    public static final long serialVersionUID = -6628103563352519193L;

    
    public BigInteger getY();
}
