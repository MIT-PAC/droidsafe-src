package java.security.interfaces;

// Droidsafe Imports
import java.math.BigInteger;

public interface DSAParams {

    
    public BigInteger getG();

    
    public BigInteger getP();

    
    public BigInteger getQ();

}
