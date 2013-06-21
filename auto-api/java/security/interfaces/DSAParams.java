package java.security.interfaces;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public interface DSAParams {

    
    public BigInteger getG();

    
    public BigInteger getP();

    
    public BigInteger getQ();

}
