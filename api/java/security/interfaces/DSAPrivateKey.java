package java.security.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import java.security.PrivateKey;

public interface DSAPrivateKey extends DSAKey, PrivateKey {

    
    public static final long serialVersionUID = 7776497482533790279L;

    
    public BigInteger getX();

}
