package java.security.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.security.PublicKey;

public interface RSAPublicKey extends PublicKey, RSAKey {

    
    public static final long serialVersionUID = -8727434096241101194L;

    
    public BigInteger getPublicExponent();

}
