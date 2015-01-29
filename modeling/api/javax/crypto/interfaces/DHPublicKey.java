package javax.crypto.interfaces;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.PublicKey;

public interface DHPublicKey extends DHKey, PublicKey {
    
    public static final long serialVersionUID = -6628103563352519193L;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public BigInteger getY();
}
