package javax.crypto.interfaces;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.security.PublicKey;

public interface DHPublicKey extends DHKey, PublicKey {

    
    public static final long serialVersionUID = -6628103563352519193L;

    
    public BigInteger getY();
}
