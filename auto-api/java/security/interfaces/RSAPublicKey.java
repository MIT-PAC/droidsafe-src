package java.security.interfaces;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.math.BigInteger;
import java.security.PublicKey;

public interface RSAPublicKey extends PublicKey, RSAKey {

    
    public static final long serialVersionUID = -8727434096241101194L;

    
    public BigInteger getPublicExponent();

}

