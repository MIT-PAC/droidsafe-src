package java.security.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;

public interface DSAParams {

    
    public BigInteger getG();

    
    public BigInteger getP();

    
    public BigInteger getQ();

}
