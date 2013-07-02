package javax.crypto.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import java.security.PublicKey;

public interface DHPublicKey extends DHKey, PublicKey {

    
    public static final long serialVersionUID = -6628103563352519193L;

    
    public BigInteger getY();
}
