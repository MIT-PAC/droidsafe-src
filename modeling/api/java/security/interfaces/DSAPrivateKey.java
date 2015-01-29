package java.security.interfaces;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.PrivateKey;

public interface DSAPrivateKey extends DSAKey, PrivateKey {
    
    public static final long serialVersionUID = 7776497482533790279L;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public BigInteger getX();

}
