package java.security.interfaces;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.PrivateKey;

public interface ECPrivateKey extends PrivateKey, ECKey {

    
    public static final long serialVersionUID = -7896394956925609184L;

    
    public BigInteger getS();
}
